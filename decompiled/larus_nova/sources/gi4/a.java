package gi4;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a<DATA, IMAGE_VIEW extends View> extends BasePreviewPageView<DATA> {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final C6027a f481353u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public IMAGE_VIEW f481354v;

    /* JADX INFO: renamed from: gi4.a$a, reason: collision with other inner class name */
    public static class C6027a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f481355a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f481356b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final cj4.a f481357c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final bj4.d f481358d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f481359e;

        public C6027a() {
            this(0);
        }

        public C6027a(int r100) {
            bj4.b r101 = new bj4.b();
            Intrinsics.checkNotNullParameter(r101, "animationScaleType");
            this.f481355a = true;
            this.f481356b = false;
            this.f481357c = null;
            this.f481358d = r101;
            this.f481359e = false;
        }
    }

    public abstract void v(DATA r100);

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final cj4.a n() {
        cj4.a r100 = this.f481353u.f481357c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return super.n();
    }

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final boolean p() {
        return this.f481353u.f481355a;
    }

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final bj4.d r() {
        return this.f481353u.f481358d;
    }

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final void j() {
        super.j();
        ViewGroup r100 = f();
        Intrinsics.checkNotNullParameter(r100, "content");
        IMAGE_VIEW r101 = (IMAGE_VIEW) r100.findViewById(R.id.image_view);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f481354v = r101;
    }

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final void m(DATA r100) {
        super.m(r100);
        IMAGE_VIEW r101 = this.f481354v;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r101 = null;
    L6:
        ci4.a.a(r101, false);
    }

    @Override // com.bytedance.creativex.mediaimport.preview.internal.base.BasePreviewPageView
    public final void l(DATA r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r101, "uri");
        super.l(r100, r101);
        IMAGE_VIEW r102 = this.f481354v;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("imageView");
        r102 = null;
    L6:
        ci4.a.a(r102, true);
        u(r100);
        v(r100);
    }

    public a(Context r110, LifecycleOwner r111, fi4.c<DATA> r112, ViewGroup r113, boolean r114, List<? extends ei4.b<DATA>> r115, Function2<? super Boolean, ? super DATA, ? extends Pair<? extends View, Boolean>> r116, Function1<? super C6027a, Unit> r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, NewBroadcastMonitor.STAGE.LIFECYCLE);
        Intrinsics.checkNotNullParameter(r115, "validators");
        super(r110, r111, r112, r113, r114, r116, r115);
        C6027a r100 = new C6027a(0);
        this.f481353u = r100;
        if (r117 == null) goto L6;
        r117.invoke(r100);
        return;
    }
}
