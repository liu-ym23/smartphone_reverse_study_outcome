package sk0;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import fr2.m0;
import kotlin.jvm.internal.Intrinsics;
import uf2.b1;
import uf2.d0;
import uf2.h0;
import uf2.y0;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f542312a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f542313b;

    /* JADX INFO: renamed from: sk0.a$a, reason: collision with other inner class name */
    public static final class C7623a implements h0.d {
        public C7623a(kb6.a r100) {
        }
    }

    public final String b() {
        return this.f542312a.j1();
    }

    public final m0 c() {
        d0.a r100 = this.f542312a.y0();
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.f0());
    L6:
        d0.a r102 = this.f542312a.y0();
        int r103 = 0;
        if (r102 == null) goto L9;
        int r104 = r102.getVideoWidth();
    L10:
        d0.a r105 = this.f542312a.y0();
        if (r105 == null) goto L13;
        int r106 = r105.getVideoHeight();
    L14:
        d0.a r107 = this.f542312a.y0();
        if (r107 == null) goto L18;
        r103 = r107.g();
    L18:
        return new m0(r101, r104, r106, r103);
    L13:
        r106 = 0;
        goto L14
    L9:
        r104 = 0;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    public final void d() {
        this.f542312a.I();
    }

    public final void g() {
        this.f542312a.s();
    }

    public final void a(boolean r100) {
        this.f542313b.R();
    }

    public final void e(kb6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        d r101 = this.f542312a;
        y0.a r102 = y0.f549886a;
        int r103 = r100.f502218a;
        String r104 = String.valueOf(r100.f502219b);
        String r105 = String.valueOf(r100.f502220c);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r104, "businessType");
        Intrinsics.checkNotNullParameter(r105, SignCounterLaunchArgs.EXTRA_SCENE_TYPE);
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r106 = ILiveWrappedLivePusher.a.b();
        if (r106 == null) goto L5;
        r106.newLiveStreamBusinessTag(r103, r104, r105);
    L5:
        r101.L();
    }

    public final void f(boolean r100) {
        this.f542312a.O(r100);
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f542312a.y(r100);
    }

    public final void j(b1 r100) {
        this.f542312a.l1(r100);
    }

    public a(d r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "liveStream");
        Intrinsics.checkNotNullParameter(r101, "liveCore");
        this.f542312a = r100;
        this.f542313b = r101;
    }

    public final void i(String r100, kb6.a r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        d r102 = this.f542312a;
        if (r101 != null) goto L5;
        C7623a r103 = null;
    L6:
        r102.H0(r100, r103);
        return;
    L5:
        r103 = new C7623a(r101);
        goto L6
    }
}
