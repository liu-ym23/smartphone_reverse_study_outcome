package ih3;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d implements s83.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f489803b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s83.d f489804a;

    @Override // s83.d
    public final void a(View r100) {
        this.f489804a.a(r100);
    }

    @Override // s83.d
    public final void b() {
        this.f489804a.b();
    }

    @Override // s83.d
    public final void c() {
        this.f489804a.c();
    }

    @Override // s83.d
    public final void d(boolean r110, String r111, FragmentActivity r112, boolean r113, boolean r114, String r115) {
        Intrinsics.checkNotNullParameter(r111, "eventType");
        Intrinsics.checkNotNullParameter("VideoProductFeedFragment", "owner");
        this.f489804a.d(r110, r111, r112, r113, r114, r115);
    }

    @Override // s83.d
    public final void e(boolean r100, Context r101) {
        this.f489804a.e(r100, r101);
    }

    @Override // s83.d
    public final void f() {
        this.f489804a.f();
    }

    @Override // s83.d
    public final void g() {
        this.f489804a.g();
    }

    @Override // s83.d
    public final void h() {
        this.f489804a.h();
    }

    @Override // s83.d
    public final boolean isPlaying() {
        return this.f489804a.isPlaying();
    }

    static {
        f489803b = new d();
    }

    public d() {
        this.f489804a = g.f489807b.N();
    }
}
