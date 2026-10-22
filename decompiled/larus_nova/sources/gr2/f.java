package gr2;

import android.content.Context;
import com.bytedance.android.livesdk.revenue.service.livecore.IConfig;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.live.livelink.kmp.api.base.config.Character;
import com.bytedance.live.livelink.kmp.api.base.config.InteractMode;
import com.bytedance.live.livelink.kmp.api.base.config.StreamType;
import com.bytedance.live.livelink.kmp.api.base.rtc.Env;
import com.bytedance.live.livelink.kmp.api.core.mixer.MixStreamType;
import com.ss.android.lark.utils.statistics.PerfLog;
import fr2.b0;
import fr2.p0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class f extends c implements fr2.n, hr2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fi6.a f482304a;

    @Override // fr2.n
    public final void N3() {
        this.f482304a.S = 5;
    }

    @Override // fr2.n
    public final void R2() {
        this.f482304a.f477373a0 = false;
    }

    @Override // fr2.n
    public final void S2() {
        this.f482304a.f477390j = 1;
    }

    @Override // fr2.n
    public final void e1() {
        this.f482304a.W = false;
    }

    @Override // fr2.n
    public final boolean F() {
        return this.f482304a.b();
    }

    @Override // fr2.n
    public final void U3() {
        this.f482304a.N = 1000;
    }

    @Override // fr2.n
    public final void Z2() {
        this.f482304a.Q = 1000;
    }

    @Override // fr2.n
    public Context getContext() {
        Object r100 = this.f482304a.getContext();
        if (r100 == null) goto L7;
        return (Context) r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.android.AndroidContext /* = android.content.Context */");
    }

    @Override // fr2.n
    public final String getLinkerSessionId() {
        return this.f482304a.f477393k0;
    }

    @Override // fr2.n
    public final j getMixStreamType() {
        MixStreamType r100 = this.f482304a.U;
        j.f482316e.getClass();
        return j.a.b(r100);
    }

    @Override // fr2.n
    public IConfig.d getType() {
        return new r(this.f482304a.C);
    }

    @Override // fr2.n
    public final g k3() {
        InteractMode r100 = this.f482304a.G;
        g.f482309f.getClass();
        return g.a.b(r100);
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482304a;
    }

    public f(fi6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        super(r100);
        this.f482304a = r100;
    }

    @Override // fr2.n
    public final void E1(String r100) {
        fi6.a r101 = this.f482304a;
        String r102 = String.valueOf(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "channel");
        r101.f477409y = r102;
    }

    @Override // fr2.n
    public final void G4(IConfig.c r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof MixStreamType) == false) goto L10;
        r101 = r102;
    L10:
        MixStreamType r103 = (MixStreamType) r101;
        if (r103 == null) goto L14;
        fi6.a r104 = this.f482304a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        r104.U = r103;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.n
    public final void P2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "version");
        r101.B = r100;
    }

    @Override // fr2.n
    public final void R4(boolean r100) {
        this.f482304a.f477397m0 = r100;
    }

    @Override // fr2.n
    public final void S0(IConfig.e r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof qi6.g) == false) goto L10;
        r101 = r102;
    L10:
        qi6.g r103 = (qi6.g) r101;
        if (r103 == null) goto L14;
        this.f482304a.o(r103);
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.n
    public final void S4(IConfig.b r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof InteractMode) == false) goto L10;
        r101 = r102;
    L10:
        InteractMode r103 = (InteractMode) r101;
        if (r103 == null) goto L14;
        fi6.a r104 = this.f482304a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "mode");
        r104.G = r103;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.n
    public final void V1(b0 r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof Env) == false) goto L10;
        r101 = r102;
    L10:
        Env r103 = (Env) r101;
        if (r103 == null) goto L14;
        fi6.a r104 = this.f482304a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "env");
        r104.Y = r103;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.n
    public final void V3(p0 r100) {
        fi6.a r101 = this.f482304a;
        Object r102 = null;
        if (r100 == null) goto L5;
        Object r103 = r100.getReal();
    L7:
        if ((r103 instanceof ti6.j) == false) goto L10;
        r102 = r103;
    L10:
        r101.f477382f = (ti6.j) r102;
        return;
    L5:
        r103 = null;
        goto L7
    }

    @Override // fr2.n
    public final void W3(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "rtcABTestConfig");
        r101.f477386h = r100;
    }

    @Override // fr2.n
    public final void X0(int r100) {
        this.f482304a.f477378d = r100;
    }

    @Override // fr2.n
    public final void e3(IConfig.d r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof StreamType) == false) goto L10;
        r101 = r102;
    L10:
        StreamType r103 = (StreamType) r101;
        if (r103 == null) goto L14;
        fi6.a r104 = this.f482304a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "type");
        r104.C = r103;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // fr2.n
    public final void e4(boolean r100) {
        this.f482304a.f477403s = r100;
    }

    @Override // fr2.n
    public final void f2(String r100) {
        this.f482304a.f477380e = r100;
    }

    @Override // fr2.n
    public final void l4(IConfig.a r100) {
        Object r101 = null;
        if (r100 == null) goto L5;
        Object r102 = r100.getReal();
    L7:
        if ((r102 instanceof Character) == false) goto L10;
        r101 = r102;
    L10:
        Character r103 = (Character) r101;
        if (r103 == null) goto L14;
        fi6.a r104 = this.f482304a;
        r104.getClass();
        Intrinsics.checkNotNullParameter(r103, "character");
        r104.D = r103;
        return;
    L14:
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Override // hr2.b
    public final void m1(String r100) {
        fi6.a r101 = this.f482304a;
        String r102 = String.valueOf(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "bizChannelId");
        r101.f477399o = r102;
    }

    @Override // fr2.n
    public final void setAppId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "id");
        r101.f477410z = r100;
    }

    @Override // fr2.n
    public final void setAppVersion(String r100) {
        fi6.a r101 = this.f482304a;
        String r102 = String.valueOf(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "version");
        r101.A = r102;
    }

    @Override // fr2.n
    public final void setBackgroundColor(String r100) {
        Intrinsics.checkNotNullParameter(CustomHeaderConfig.COLOR_DARK, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(CustomHeaderConfig.COLOR_DARK, "color");
        r101.f477384g = CustomHeaderConfig.COLOR_DARK;
    }

    @Override // fr2.n
    public final void setContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r101.f477405u = r100;
    }

    @Override // fr2.n
    public final void setLinkerSessionId(String r100) {
        fi6.a r101 = this.f482304a;
        r101.f477393k0 = String.valueOf(r100);
    }

    @Override // fr2.n
    public final void setProjectKey(String r100) {
        fi6.a r101 = this.f482304a;
        String r102 = String.valueOf(r100);
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "key");
        r101.f477407w = r102;
    }

    @Override // fr2.n
    public final void setRtcExtInfo(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        fi6.a r101 = this.f482304a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "info");
        r101.f477406v = r100;
    }
}
