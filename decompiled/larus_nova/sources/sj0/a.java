package sj0;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.m;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import pn0.f;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f542264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f542265b;

    /* JADX INFO: renamed from: sj0.a$a, reason: collision with other inner class name */
    public static final class C7620a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f542266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f542267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f542268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f542269d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof C7620a) == false) goto L14;
            C7620a r101 = (C7620a) r100;
            if (this.f542266a == r101.f542266a) goto L8;
            return false;
        L8:
            if (this.f542267b == r101.f542267b) goto L10;
            return false;
        L10:
            if (this.f542268c == r101.f542268c) goto L12;
            return false;
        L12:
            if (this.f542269d == r101.f542269d) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.f542266a * 31) + this.f542267b) * 31) + this.f542268c) * 31) + this.f542269d;
        }

        public final String toString() {
            return "LayoutAlignConfig(width = " + this.f542266a + ", height = " + this.f542267b + ", marginLeft = " + this.f542268c + ", marginTop = " + this.f542269d + ')';
        }

        public C7620a(int r100, int r101, int r102, int r103) {
            this.f542266a = r100;
            this.f542267b = r101;
            this.f542268c = r102;
            this.f542269d = r103;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f542270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f.a f542271b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f542272c;

        public b(a r100, f.a r101, ViewGroup r102) {
            this.f542270a = r100;
            this.f542271b = r101;
            this.f542272c = r102;
        }

        public final void a() {
            a r100 = this.f542270a;
            f.a r101 = this.f542271b;
            if (r101 == null) goto L5;
            int r102 = r101.f529927c;
        L6:
            f.a r103 = this.f542271b;
            if (r103 == null) goto L9;
            int r104 = r103.f529928d;
        L10:
            f.a r105 = this.f542271b;
            int r106 = 0;
            if (r105 == null) goto L13;
            int r107 = r105.f529925a;
        L14:
            if (r105 == null) goto L16;
            r106 = r105.f529926b;
        L16:
            r100.a(true, new C7620a(r102, r104, r107, r106));
            return;
        L13:
            r107 = 0;
            goto L14
        L9:
            r104 = this.f542272c.getHeight();
            goto L10
        L5:
            r102 = this.f542272c.getWidth();
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final void update() {
        b("update");
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "from");
        ALogger.i("MicseatMixer#AnchorPreviewUpdater", "init from ".concat(r100));
        DataCenter r101 = this.f542265b;
        f.a r102 = null;
        if (r101 == null) goto L5;
        m r103 = (m) r101.get("cmd_link_window_layout_config_changed");
    L6:
        if (r103 == null) goto L10;
        f r104 = r103.f75842d;
        if (r104 == null) goto L10;
        r102 = r104.f529922b;
    L10:
        this.f542264a.post(new b(this, r102, (ViewGroup) this.f542264a.findViewById(R.id.surface_view_container)));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public a(ViewGroup r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        this.f542264a = r100;
        this.f542265b = r101;
    }

    public final void a(boolean r100, C7620a r101) {
        ViewGroup r102 = this.f542264a;
        if ((r102 instanceof ConstraintLayout) == true) goto L5;
        r102 = null;
    L5:
        ConstraintLayout r103 = (ConstraintLayout) r102;
        if (r103 != null) goto L8;
        return;
    L8:
        View r104 = r103.findViewById(R.id.surface_view_container);
        if (r104 != null) goto L12;
        return;
    L12:
        if ((r104 instanceof ConstraintLayout) == true) goto L14;
        return;
    L14:
        View r105 = r103.findViewById(R.id.link_seat_recyclerview);
        if (r105 != null) goto L17;
        return;
    L17:
        ALogger.i("MicseatMixer#AnchorPreviewUpdater", "changeSurfaceViewAlignMode, isSingleMode = " + r100 + ", layoutAlignConfig = " + r101);
        if (r100 == false) goto L28;
        if (r101 == null) goto L29;
        int r106 = r101.f542266a;
        int r107 = -2;
        if (r106 > 0) goto L24;
        r106 = -2;
    L24:
        int r108 = r101.f542267b;
        if (r108 <= 0) goto L27;
        r107 = r108;
    L27:
        ConstraintLayout.LayoutParams r109 = new ConstraintLayout.LayoutParams(r106, r107);
        r109.leftToLeft = -1;
        r109.topToTop = -1;
        r109.rightToRight = -1;
        r109.bottomToBottom = -1;
        ConstraintLayout r110 = (ConstraintLayout) r104;
        r110.setLayoutParams(r109);
        r110.setTranslationX(r101.f542268c);
        r110.setTranslationY(r101.f542269d);
    L29:
        r103.requestLayout();
        return;
    L28:
        ConstraintLayout.LayoutParams r111 = new ConstraintLayout.LayoutParams(0, 0);
        r111.leftToLeft = r105.getId();
        r111.rightToRight = r105.getId();
        r111.topToTop = r105.getId();
        r111.bottomToBottom = r105.getId();
        ConstraintLayout r112 = (ConstraintLayout) r104;
        r112.setLayoutParams(r111);
        r112.setTranslationX(0.0f);
        r112.setTranslationY(0.0f);
        goto L29
    }
}
