package ir1;

import kotlin.jvm.internal.Intrinsics;
import mq1.d0;
import mq1.f0;

/* JADX INFO: loaded from: classes8.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f495438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f495439b;

    public static final class a implements f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f495440a;

        @Override // mq1.f0
        public final void wg() {
            this.f495440a.n();
        }

        public a(c r100) {
            this.f495440a = r100;
        }
    }

    public void n() {
    }

    public final boolean a() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r100.j(16, this);
    }

    public final boolean b() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r100.j(4, this);
    }

    public final boolean c() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r100.j(4, this);
    }

    public final boolean d() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r100.j(8, this);
    }

    public final boolean f() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r100.j(1, this);
    }

    public final boolean g() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r100.j(2, this);
    }

    public final boolean h() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r100.j(2, this);
    }

    public final boolean i() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r100.j(8, this);
    }

    public final boolean l() {
        d0 r100 = this.f495438a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return !r100.j(1, this);
    }

    public c() {
        this.f495439b = new a(this);
    }

    public final boolean e() {
        if (d() == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }

    public final boolean j() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (b() == false) goto L7;
        return true;
    }

    public final boolean k() {
        if (i() == true) goto L5;
    L7:
        return false;
    L5:
        if (c() == false) goto L7;
        return true;
    }

    public final boolean m(int r100) {
        d0 r101 = this.f495438a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("uiStateService");
    L6:
        return r101.j(r100, this);
    }
}
