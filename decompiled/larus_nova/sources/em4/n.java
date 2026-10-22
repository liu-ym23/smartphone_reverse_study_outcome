package em4;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class n {

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f473076a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f473077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f473078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f473079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f473080e;

        public a(View r100, int r101, int r102, boolean r103, ViewGroup r104) {
            this.f473076a = r100;
            this.f473077b = r101;
            this.f473078c = r102;
            this.f473079d = r103;
            this.f473080e = r104;
        }

        public final void a() {
            Rect r100 = new Rect();
            this.f473076a.getHitRect(r100);
            int r101 = (this.f473077b - r100.width()) / 2;
            int r102 = (this.f473078c - r100.height()) / 2;
            if (r101 < 0) goto L5;
        L7:
            if (r102 < 0) goto L9;
        L11:
            r100.left -= r101;
            r100.top -= r102;
            r100.right += r101;
            r100.bottom += r102;
            this.f473080e.setTouchDelegate(new TouchDelegate(r100, this.f473076a));
            return;
        L9:
            if (this.f473079d == true) goto L11;
            r102 = 0;
            goto L11
        L5:
            if (this.f473079d == true) goto L7;
            r101 = 0;
            goto L7
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

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View[] f473081a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f473082b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ l f473083c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f473084d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f473085e;

        public b(View[] r100, View r101, l r102, int r103, int r104) {
            this.f473081a = r100;
            this.f473082b = r101;
            this.f473083c = r102;
            this.f473084d = r103;
            this.f473085e = r104;
        }

        public final void a() {
            View[] r100 = this.f473081a;
            int r101 = this.f473084d;
            int r102 = this.f473085e;
            l r103 = this.f473083c;
            int r104 = r100.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L10;
            View r106 = r100[r105];
            Rect r107 = new Rect();
            r106.getHitRect(r107);
            int r108 = (r101 - r107.width()) / 2;
            int r110 = (r102 - r107.height()) / 2;
            if (r108 >= 0) goto L7;
            r108 = 0;
        L7:
            if (r110 >= 0) goto L9;
            r110 = 0;
        L9:
            r107.left -= r108;
            r107.top -= r110;
            r107.right += r108;
            r107.bottom += r110;
            TouchDelegate r109 = new TouchDelegate(r107, r106);
            r103.getClass();
            Intrinsics.checkNotNullParameter(r109, "delegate");
            ((ArrayList) r103.f473069a).add(r109);
            r105 = r105 + 1;
            goto L3
        L10:
            this.f473082b.setTouchDelegate(this.f473083c);
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

    public static final boolean d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void e(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(8);
    }

    public static final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        r100.setVisibility(0);
    }

    public static final void g(View r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getParent() != null) goto L5;
        return;
    L5:
        if ((r100.getParent() instanceof ViewGroup) == false) goto L9;
        ViewParent r101 = r100.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r101).removeView(r100);
        return;
    }

    public static final void a(View r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        b(r100, r101, r101, false);
    }

    public static final void h(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r101 == false) goto L5;
        f(r100);
        return;
    L5:
        e(r100);
    }

    public static final void b(View r100, int r101, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.getParent() == null) goto L5;
        ViewParent r102 = r100.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r103 = (ViewGroup) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        r103.post(new a(r100, r101, r110, r111, r103));
        return;
    L5:
        r103 = null;
        goto L6
    }

    public static final void c(View r100, int r101, int r102, View... r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r110, "views");
        r100.post(new b(r110, r100, new l(r100), r101, r102));
    }
}
