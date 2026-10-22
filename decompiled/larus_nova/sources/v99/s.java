package v99;

import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.keyboard.biz.plus.inject.PlusInnerEndPlugin;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class s implements eya.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f553861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f553862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w99.a f553863c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w99.a f553864a;

        public a(w99.a r100) {
            this.f553864a = r100;
        }

        public final void a(boolean r100, int r101, int r102, boolean r103) {
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelHeightAnimationListener onEnd = " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
            w99.a r104 = this.f553864a;
            if (r104 == null) goto L6;
            r104.kf(r100, r101, r102, r103);
            return;
        }

        public final void b(boolean r100, int r101, int r102, long r103, Interpolator r110) {
            Intrinsics.checkNotNullParameter(r110, "interpolator");
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelHeightAnimationListener onStart = " + r100 + ", " + r101 + ", " + r102 + ", " + r103 + ", " + r110);
            w99.a r104 = this.f553864a;
            if (r104 == null) goto L5;
            r104.C20(r100, r101, r102);
        L5:
            Intrinsics.checkNotNullParameter(r110, "interpolator");
        }

        public final void c(boolean r110, int r111, int r112, int r113, float r114) {
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelHeightAnimationListener onUpdate = " + r110 + ", " + r111 + ", " + r112 + ", " + r113 + ", " + r114);
            w99.a r100 = this.f553864a;
            if (r100 == null) goto L6;
            r100.Fm(r110, r111, r112, r113, r114);
            return;
        }
    }

    public static final class b {
        public b() {
        }

        public final void a(boolean r100, int r101, int r102, boolean r103) {
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelTranslationYAnimationListener onEnd = " + r100 + ", " + r101 + ", " + r102 + ", " + r103);
        }

        public final void b(boolean r100, int r101, int r102, long r103, Interpolator r110) {
            Intrinsics.checkNotNullParameter(r110, "interpolator");
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelTranslationYAnimationListener onStart = " + r100 + ", " + r101 + ", " + r102 + ", " + r103 + ", " + r110);
            Intrinsics.checkNotNullParameter(r110, "interpolator");
        }

        public final void c(boolean r100, int r101, int r102, float r103, float r104) {
            FLogger.f375446a.i("FlowPlusExtensionFactory", "panelTranslationYAnimationListener onUpdate = " + r100 + ", " + r101 + ", " + r102 + ", " + r103 + ", " + r104);
        }
    }

    @Override // eya.b
    public final b a7() {
        return this.f553862b;
    }

    @Override // eya.b
    public final a b7() {
        return this.f553861a;
    }

    public s(w99.a r100) {
        this.f553863c = r100;
        this.f553861a = new a(r100);
        this.f553862b = new b();
    }

    @Override // eya.b
    public final void J4(eya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "panelItemConfig");
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.J4(r100);
        return;
    }

    @Override // eya.b
    public final void K3(PlusInnerEndPlugin.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.K3(r100);
        return;
    }

    @Override // eya.b
    public final void S2(int r100) {
        FLogger.f375446a.i("FlowPlusExtensionFactory", "onImeWrapperHeightChange = " + r100);
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.S2(r100);
        return;
    }

    @Override // eya.b
    public final void Z6(PlusInnerEndPlugin.d r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.Z6(r100);
        return;
    }

    @Override // eya.b
    public final void d7(boolean r100) {
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.wj(r100);
        return;
    }

    @Override // eya.b
    public final void e7(Interpolator r100) {
        Intrinsics.checkNotNullParameter(r100, "interpolator");
    }

    @Override // eya.b
    public final void f7(Function2<? super Integer, ? super Integer, Unit> r100) {
        w99.a r101 = this.f553863c;
        if (r101 == null) goto L6;
        r101.Lq();
        return;
    }

    @Override // eya.b
    public final void c7(ViewGroup r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "panelViewGroup");
        Intrinsics.checkNotNullParameter(r101, "chatParams");
        w99.a r102 = this.f553863c;
        if (r102 == null) goto L5;
        r102.dQ(r101);
    L5:
        w99.a r103 = this.f553863c;
        if (r103 == null) goto L10;
        ViewGroup r104 = r103.vh();
        if (r104 == null) goto L10;
        r104.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    L11:
        r100.addView(r104);
        return;
    L10:
        r104 = null;
        goto L11
    }
}
