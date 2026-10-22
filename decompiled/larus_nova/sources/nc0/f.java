package nc0;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f implements lc0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kc0.e f518610a;

    @Override // lc0.a
    public final boolean V() {
        return this.f518610a.V();
    }

    @Override // lc0.a
    public final boolean a() {
        return this.f518610a.a();
    }

    @Override // lc0.a
    public final boolean c() {
        return this.f518610a.c();
    }

    @Override // lc0.a
    public final Map<String, String> e() {
        return this.f518610a.e();
    }

    @Override // lc0.a
    public final String g() {
        return this.f518610a.g();
    }

    @Override // lc0.a
    public final String getConnectionType() {
        return this.f518610a.getConnectionType();
    }

    @Override // lc0.a
    public final int getCurrentMode() {
        return this.f518610a.getCurrentMode();
    }

    @Override // lc0.a
    public final int getMixStreamType() {
        return this.f518610a.getMixStreamType();
    }

    @Override // lc0.a
    public final Map<String, String> h() {
        return this.f518610a.h();
    }

    @Override // lc0.a
    public final boolean i() {
        return this.f518610a.i();
    }

    @Override // lc0.a
    public final void m() {
        this.f518610a.m();
    }

    @Override // lc0.a
    public final boolean p() {
        return this.f518610a.p();
    }

    public f(kc0.e r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f518610a = r100;
    }

    @Override // lc0.a
    public final void b(int r100) {
        this.f518610a.b(r100);
    }

    @Override // lc0.a
    public final void f(boolean r100) {
        this.f518610a.f(r100);
    }

    @Override // lc0.a
    public final void unLoadOtherWidget(int r100) {
        this.f518610a.unLoadOtherWidget(r100);
    }

    @Override // lc0.a
    public final void d(String r100, HashMap<String, String> r101) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f518610a.d(r100, r101);
    }

    @Override // lc0.a
    public final boolean j(String r100, int r101, String r102, String r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "guideType");
        Intrinsics.checkNotNullParameter(r102, "toUserGroup");
        Intrinsics.checkNotNullParameter(r103, "page");
        return this.f518610a.r5(r100, r102, r103, r104);
    }
}
