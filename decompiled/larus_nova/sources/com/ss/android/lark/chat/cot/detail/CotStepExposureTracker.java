package com.ss.android.lark.chat.cot.detail;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.lark.chat.cot.detail.blueprint.CotDetailBlueprintAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes35.dex */
public final class CotStepExposureTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RecyclerView f414835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CotDetailBlueprintAdapter f414836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<k, Unit> f414837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<String> f414838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f414839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f414840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewTreeObserver f414841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f414842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CotStepExposureTracker$scrollListener$1 f414843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CotStepExposureTracker$childAttachListener$1 f414844j;

    public static final class a implements ViewTreeObserver.OnPreDrawListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CotStepExposureTracker f414845a;

        public a(CotStepExposureTracker r100) {
            this.f414845a = r100;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            CotStepExposureTracker r100 = this.f414845a;
            r100.b();
            if (r100.f414839e == true) goto L6;
        L47:
            return true;
        L6:
            if (r100.f414835a.isComputingLayout() == false) goto L8;
        L11:
            boolean r101 = true;
        L12:
            if (r101 == false) goto L15;
            r100.a();
            goto L47
        L15:
            if (r100.f414839e == false) goto L47;
            RecyclerView.LayoutManager r102 = r100.f414835a.getLayoutManager();
            if ((r102 instanceof LinearLayoutManager) == false) goto L20;
            LinearLayoutManager r103 = (LinearLayoutManager) r102;
        L21:
            if (r103 == null) goto L47;
            int r104 = r103.findFirstVisibleItemPosition();
            int r105 = r103.findLastVisibleItemPosition();
            if (r104 == (-1)) goto L47;
            if (r105 == (-1)) goto L47;
            IntRange r106 = new IntRange(r104, r105);
            List<k> r107 = r100.f414836b.f414852c.getCurrentList();
            ArrayList r108 = new ArrayList();
            Iterator<Integer> r109 = r106.iterator();
        L29:
            if (r109.hasNext() == false) goto L33;
            k r110 = (k) CollectionsKt.getOrNull(r107, ((IntIterator) r109).nextInt());
            if (r110 == null) goto L29;
            r108.add(r110);
            goto L29
        L33:
            Iterator r111 = r108.iterator();
        L35:
            if (r111.hasNext() == false) goto L47;
            k r112 = (k) r111.next();
            CotDetailBlockType r113 = r112.f414983b;
            if (r113 != CotDetailBlockType.GROUP) goto L39;
        L42:
            boolean r114 = true;
        L43:
            if (r114 == false) goto L35;
            if (r100.f414838d.add(r112.f414982a) == false) goto L35;
            r100.f414837c.invoke(r112);
            goto L35
        L39:
            if (r113 == CotDetailBlockType.TOOLCALL) goto L42;
            r114 = false;
            goto L43
        L20:
            r103 = null;
            goto L21
        L8:
            if (r100.f414835a.hasPendingAdapterUpdates() == true) goto L11;
            r101 = false;
            goto L12
        }
    }

    public final void a() {
        if (this.f414839e == true) goto L6;
        return;
    L6:
        if (this.f414840f == false) goto L8;
        return;
    L8:
        ViewTreeObserver r100 = this.f414835a.getViewTreeObserver();
        if (r100.isAlive() == true) goto L11;
        return;
    L11:
        this.f414841g = r100;
        this.f414840f = true;
        r100.addOnPreDrawListener(this.f414842h);
        this.f414835a.postInvalidateOnAnimation();
    }

    public final void b() {
        if (this.f414840f == true) goto L5;
        return;
    L5:
        ViewTreeObserver r100 = this.f414841g;
        if (r100 != null) goto L8;
    L13:
        this.f414841g = null;
        this.f414840f = false;
        return;
    L8:
        if (r100.isAlive() == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        r100.removeOnPreDrawListener(this.f414842h);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.chat.cot.detail.CotStepExposureTracker$scrollListener$1] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.ss.android.lark.chat.cot.detail.CotStepExposureTracker$childAttachListener$1] */
    public CotStepExposureTracker(RecyclerView r100, CotDetailBlueprintAdapter r101, Function1<? super k, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "onStepView");
        this.f414835a = r100;
        this.f414836b = r101;
        this.f414837c = r102;
        this.f414838d = new LinkedHashSet();
        this.f414842h = new a(this);
        this.f414843i = new CotStepExposureTracker$scrollListener$1(this);
        this.f414844j = new CotStepExposureTracker$childAttachListener$1(this);
    }
}
