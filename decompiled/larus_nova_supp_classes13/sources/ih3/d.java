package ih3;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements s83.d {
    public static final d b = null;
    public final /* synthetic */ s83.d a;

    @Override // s83.d
    public final void a(View r2) {
        this.a.a(r2);
    }

    @Override // s83.d
    public final void b() {
        this.a.b();
    }

    @Override // s83.d
    public final void c() {
        this.a.c();
    }

    @Override // s83.d
    public final void d(boolean r10, String r11, FragmentActivity r12, boolean r13, boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r11, "eventType");
        Intrinsics.checkNotNullParameter("VideoProductFeedFragment", "owner");
        this.a.d(r10, r11, r12, r13, r14, r15);
    }

    @Override // s83.d
    public final void e(boolean r2, Context r3) {
        this.a.e(r2, r3);
    }

    @Override // s83.d
    public final void f() {
        this.a.f();
    }

    @Override // s83.d
    public final void g() {
        this.a.g();
    }

    @Override // s83.d
    public final void h() {
        this.a.h();
    }

    @Override // s83.d
    public final boolean isPlaying() {
        return this.a.isPlaying();
    }

    static {
        b = new d();
    }

    public d() {
        this.a = g.b.N();
    }
}
