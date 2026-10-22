package ih3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.ECAdInfo;
import com.bytedance.android.ec.model.hybrid.IECBridgeMethod;
import com.bytedance.android.shopping.api.playback.IVideoPlaybackService;
import com.bytedance.android.shopping.deepfeed.data.repo.l;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map;
import jh3.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class g implements s83.g {
    public static final g b = null;
    public final /* synthetic */ s83.g a;

    @Override // s83.g
    public final ECAdInfo A(String r2) {
        return this.a.A(r2);
    }

    @Override // s83.g
    public final boolean B() {
        return this.a.B();
    }

    @Override // s83.g
    public final void C(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        this.a.C(r2, r3);
    }

    @Override // s83.g
    public final void H(String r3, double r4, Map r6) {
        Intrinsics.checkNotNullParameter(r3, "stageName");
        Intrinsics.checkNotNullParameter("", "scheme");
        Intrinsics.checkNotNullParameter("mall_deliveryRecord_bridge", "triggerSource");
        this.a.H(r3, r4, r6);
    }

    @Override // s83.g
    public final void J() {
        this.a.J();
    }

    @Override // s83.g
    public final void M(Activity r2, String r3, com.bytedance.android.shopping.anchorv3.widget.b r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "riskInfo");
        this.a.M(r2, r3, r4);
    }

    @Override // s83.g
    public final boolean P() {
        return this.a.P();
    }

    @Override // s83.g
    public final String S(String r2) {
        return this.a.S(r2);
    }

    @Override // s83.g
    public final s83.h T() {
        return this.a.T();
    }

    @Override // s83.g
    public final int U() {
        return this.a.U();
    }

    @Override // s83.g
    public final List<IECBridgeMethod> Y() {
        return this.a.Y();
    }

    @Override // s83.g
    public final void b(Map r3) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.a.b(r3);
    }

    @Override // s83.g
    public final void b0() {
        this.a.b0();
    }

    @Override // s83.g
    public final void d0(View r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        this.a.d0(r2);
    }

    @Override // s83.g
    public final String e(String r2, String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "schema");
        Intrinsics.checkNotNullParameter(r3, "pageName");
        return this.a.e(r2, r3, r4);
    }

    @Override // s83.g
    public final void e0(FragmentActivity r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        this.a.e0(r2, r3);
    }

    @Override // s83.g
    public final void f0(Context r2, String r3, Function1<? super Integer, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.f0(r2, r3, r4);
    }

    @Override // s83.g
    public final void g() {
        this.a.g();
    }

    @Override // s83.g
    public final void g0(Context r2, boolean r3) {
        this.a.g0(r2, r3);
    }

    @Override // s83.g
    public final Integer getLocationPermissionParam() {
        return this.a.getLocationPermissionParam();
    }

    @Override // s83.g
    public final Map<String, Object> getSettings(List<String> r2) {
        return this.a.getSettings(r2);
    }

    @Override // s83.g
    public final void h0() {
        this.a.h0();
    }

    @Override // s83.g
    public final void i() {
        this.a.i();
    }

    @Override // s83.g
    public final void i0(v83.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.i0(r2);
    }

    @Override // s83.g
    public final boolean isPad() {
        return this.a.isPad();
    }

    @Override // s83.g
    public final void j0(String r3) {
        Intrinsics.checkNotNullParameter("ECStore", "tag");
        this.a.j0(r3);
    }

    @Override // s83.g
    public final void k(Map r3) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.a.k(r3);
    }

    @Override // s83.g
    public final void l() {
        this.a.l();
    }

    @Override // s83.g
    public final void m() {
        this.a.m();
    }

    @Override // s83.g
    public final void o(v83.a r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.a.o(r2);
    }

    @Override // s83.g
    public final JsonObject r() {
        return this.a.r();
    }

    @Override // s83.g
    public final void t(Map r3) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.a.t(r3);
    }

    @Override // s83.g
    public final boolean u() {
        return this.a.u();
    }

    @Override // s83.g
    public final void v(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        this.a.v(r2);
    }

    @Override // s83.g
    public final void w(List r2, l.c r3) {
        Intrinsics.checkNotNullParameter(r2, "paths");
        Intrinsics.checkNotNullParameter(r3, "listener");
        this.a.w(r2, r3);
    }

    @Override // s83.g
    public final void y() {
        this.a.y();
    }

    @Override // s83.g
    public final void z() {
        this.a.z();
    }

    static {
        b = new g();
    }

    @Override // s83.g
    public final s83.c D() {
        s83.c r0 = h.a.D();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.e();
    }

    @Override // s83.g
    public final Boolean E() {
        return h.a.E();
    }

    @Override // s83.g
    public final p83.f G() {
        p83.f r0 = h.a.G();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.h();
    }

    @Override // s83.g
    public final s83.d N() {
        s83.d r0 = h.a.N();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.f();
    }

    @Override // s83.g
    public final t83.a Q() {
        t83.a r0 = h.a.Q();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.b();
    }

    @Override // s83.g
    public final Boolean R() {
        return h.a.R();
    }

    @Override // s83.g
    public final s83.e W() {
        s83.e r0 = h.a.W();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.g();
    }

    @Override // s83.g
    public final boolean Z() {
        return h.a.Z();
    }

    @Override // s83.g
    public final String a() {
        return h.a.a();
    }

    @Override // s83.g
    public final boolean a0() {
        return h.a.a0();
    }

    @Override // s83.g
    public final boolean c0() {
        return h.a.c0();
    }

    @Override // s83.g
    public final String getCurrentBcmChain() {
        return h.a.getCurrentBcmChain();
    }

    @Override // s83.g
    public final float getFontScale() {
        return h.a.getFontScale();
    }

    @Override // s83.g
    public final int getHomePageMallSource() {
        return h.a.getHomePageMallSource();
    }

    @Override // s83.g
    public final Boolean hasLivePlayingMute() {
        return h.a.hasLivePlayingMute();
    }

    @Override // s83.g
    public final boolean isSearchScreenshotBubbleMobOpen() {
        return h.a.isSearchScreenshotBubbleMobOpen();
    }

    @Override // s83.g
    public final u83.a j() {
        u83.a r0 = h.a.j();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.c();
    }

    @Override // s83.g
    public final IVideoPlaybackService n() {
        return h.a.n();
    }

    @Override // s83.g
    public final s83.f p() {
        s83.f r0 = h.a.p();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new i();
    }

    @Override // s83.g
    public final s83.a q() {
        s83.a r0 = h.a.q();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.a();
    }

    @Override // s83.g
    public final void s() {
        h.a.s();
    }

    @Override // s83.g
    public final s83.b x() {
        s83.b r0 = h.a.x();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new jh3.d();
    }

    public g() {
        this.a = h.a;
    }

    @Override // s83.g
    public final String F(String r2) {
        return h.a.F(r2);
    }

    @Override // s83.g
    public final void I(int r2) {
        h.a.I(r2);
    }

    @Override // s83.g
    public final JSONObject K(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return h.a.K(r2);
    }

    @Override // s83.g
    public final void O(int r2) {
        h.a.O(r2);
    }

    @Override // s83.g
    public final void X(int r2) {
        h.a.X(r2);
    }

    @Override // s83.g
    public final void c(int r2) {
        h.a.c(r2);
    }

    @Override // s83.g
    public final JSONObject f(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        return h.a.f(r2);
    }

    @Override // s83.g
    public final void k0(ViewGroup r2) {
        Intrinsics.checkNotNullParameter(r2, FreqActions.ACTION_VIEW);
        h.a.k0(r2);
    }

    @Override // s83.g
    public final void V(String r2, int r3, Object r4, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        h.a.V(r2, r3, r4, r5);
    }

    @Override // s83.g
    public final void h(FragmentActivity r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "filePath");
        Intrinsics.checkNotNullParameter(r4, "extra");
        Intrinsics.checkNotNullParameter(r5, "screenShotWithQr");
        h.a.h(r2, r3, r4, r5);
    }

    @Override // s83.g
    public final void L(String r8, String r9, String r10, Function1<? super Integer, Unit> r11, Function0<Unit> r12) {
        Intrinsics.checkNotNullParameter(r8, "itemId");
        h.a.L(r8, r9, r10, r11, r12);
    }

    @Override // s83.g
    public final void d(String r11, String r12, String r13, String r14, String r15, Map<String, ? extends Object> r16, String r17, String r18) {
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r12, "label");
        Intrinsics.checkNotNullParameter(r14, "creative_id");
        h.a.d(r11, r12, r13, r14, r15, r16, r17, r18);
    }
}
