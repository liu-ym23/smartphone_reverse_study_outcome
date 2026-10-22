package p31;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.revlink.impl.multianchor.service.f;
import com.bytedance.android.live.revlink.impl.pk.ui.CrossRoomContainerLayout;
import com.bytedance.ies.sdk.widgets.inflater.AsyncLayoutInflater;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<? extends View>, View> f527549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<View> f527550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AsyncLayoutInflater f527551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C7145a f527552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f527553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f527554g;

    /* JADX INFO: renamed from: p31.a$a, reason: collision with other inner class name */
    public static final class C7145a implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527555a;

        public C7145a(a r100) {
            this.f527555a = r100;
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final /* synthetic */ void onCancel(int r100) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Iterator<T> r103 = p31.b.f527557a.iterator();
        L4:
            if (r103.hasNext() == false) goto L11;
            Object r104 = r103.next();
            ((c) r104).getClass();
            if (r101 != 0) goto L8;
            boolean r105 = true;
        L9:
            if (r105 == false) goto L4;
        L12:
            c r106 = (c) r104;
            if (Intrinsics.areEqual(null, CrossRoomContainerLayout.class) == false) goto L15;
            r106.getClass();
            jy0.b.f("MultiLinkPreloadWidget", "async inflate done for null", null, 4);
        L15:
            if (r106 == null) goto L23;
            this.f527555a.f527549b.put(null, r100);
            return;
        L23:
            return;
        L8:
            r105 = false;
            goto L9
        L11:
            r104 = null;
            goto L12
        }
    }

    public static final class b implements androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f527556a;

        public b(a r100) {
            this.f527556a = r100;
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final /* synthetic */ void onCancel(int r100) {
            androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener.CC.$default$onCancel(this, r100);
        }

        @Override // androidx.asynclayoutinflater.view.AsyncLayoutInflater.OnInflateFinishedListener
        public final void onInflateFinished(View r100, int r101, ViewGroup r102) {
            Intrinsics.checkNotNullParameter(r100, "view");
            ((LinkedList) this.f527556a.f527550c).add(r100);
            jy0.b.f("link_preload", "async done for " + ((LinkedList) this.f527556a.f527550c).size(), null, 4);
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final int a() {
        return ((LinkedList) this.f527550c).size();
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void c() {
        jy0.b.f("link_preload", "start asyncInflatePkLayouts", null, 4);
        FrameLayout r100 = new FrameLayout(this.f527554g);
        Iterator<T> r101 = p31.b.f527557a.iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        c r102 = (c) r101.next();
        HashMap<Class<? extends View>, View> r103 = this.f527549b;
        r102.getClass();
        if (r103.get(null) != null) goto L7;
        this.f527551d.inflate(0, r100, this.f527552e);
        goto L4
    L7:
        jy0.b.c("link_preload", "already loaded layout " + r102, null, 4);
        goto L4
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f527554g = r100;
        this.f527549b = new HashMap();
        this.f527550c = new LinkedList();
        this.f527551d = new AsyncLayoutInflater(r100);
        this.f527552e = new C7145a(this);
        this.f527553f = new b(this);
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void b(int r100) {
        jy0.b.f("link_preload", "start asyncInflateMultiAnchorLayout windowCnt=" + r100, null, 4);
        if (r100 <= 0) goto L8;
        AsyncLayoutInflater r101 = new AsyncLayoutInflater(this.f527554g);
        int r102 = 0;
        int r103 = RangesKt.coerceAtLeast(r100 - ((LinkedList) this.f527550c).size(), 0);
    L6:
        if (r102 >= r103) goto L10;
        r101.inflate(R.layout.ttlive_interact_multi_anchor_window_v2, null, this.f527553f);
        r102 = r102 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.multianchor.service.f
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        jy0.b.c("link_preload", "clear by " + r100 + " , layoutMap:" + this.f527549b.size() + " asyncViews:" + ((LinkedList) this.f527550c).size(), null, 4);
        this.f527549b.clear();
        ((LinkedList) this.f527550c).clear();
    }
}
