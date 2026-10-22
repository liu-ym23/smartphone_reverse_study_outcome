package du4;

import android.view.View;
import com.ttnet.org.chromium.base.BaseSwitches;
import io.supercharge.shimmerlayout.ShimmerLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShimmerLayout f470040a;

        public a(ShimmerLayout r100) {
            this.f470040a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f470040a.c();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
            this.f470040a.d();
        }
    }

    public static final <T extends com.bytedance.ee.bear.bitable.loading.a> ShimmerLayout a(T r100, View r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "view");
        ShimmerLayout r103 = new ShimmerLayout(r101.getContext());
        r103.addView(r101);
        r103.setShimmerAngle(0);
        if (r102 == null) goto L5;
        r103.setShimmerColor(r102.intValue());
    L5:
        r103.addOnAttachStateChangeListener(new a(r103));
        return r103;
    }
}
