package nk9;

import android.graphics.Rect;
import android.view.View;
import com.larus.media.focus.CardContextState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class c implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f519492a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f519493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Rect f519494c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f519495d;

    @Override // nk9.e
    public final View c() {
        return this.f519492a.c();
    }

    @Override // nk9.e
    public final float e() {
        return this.f519492a.e();
    }

    @Override // nk9.e
    public final float f() {
        return this.f519492a.f();
    }

    @Override // nk9.e
    public final boolean g() {
        return this.f519492a.g();
    }

    @Override // nk9.e
    public final float h() {
        return this.f519492a.h();
    }

    @Override // nk9.e
    public final float i() {
        return this.f519492a.i();
    }

    @Override // nk9.e
    public final String b() {
        if (Intrinsics.areEqual(this.f519493b, this.f519492a.b()) == true) goto L6;
        this.f519493b = this.f519492a.b();
        this.f519495d = false;
    L6:
        return this.f519493b;
    }

    public final Rect j() {
        int[] r100 = n.f519505a;
        n.b(c(), this.f519494c);
        Rect r101 = this.f519494c;
        n.a(r101, h(), f(), e(), i());
        return r101;
    }

    public final boolean k() {
        if (Intrinsics.areEqual(this.f519493b, this.f519492a.b()) == true) goto L6;
        this.f519493b = this.f519492a.b();
        this.f519495d = false;
    L6:
        return this.f519495d;
    }

    @Override // nk9.e
    public final void d(CardContextState r100) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        this.f519495d = false;
        this.f519492a.d(r100);
    }

    public c(e r100, com.larus.media.focus.a r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "cardStateKeeper");
        this.f519492a = r100;
        this.f519493b = "";
        this.f519494c = new Rect();
        boolean r102 = r100 instanceof c;
    }

    @Override // nk9.e
    public final void a(CardContextState r100, go2.g r101) {
        Intrinsics.checkNotNullParameter(r100, "contextState");
        Intrinsics.checkNotNullParameter(r101, "actionCallback");
        this.f519495d = true;
        this.f519492a.a(r100, r101);
    }
}
