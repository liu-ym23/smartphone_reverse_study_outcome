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

/* JADX INFO: loaded from: classes13.dex */
public final class g implements s83.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g f489807b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s83.g f489808a;

    @Override // s83.g
    public final ECAdInfo A(String r100) {
        return this.f489808a.A(r100);
    }

    @Override // s83.g
    public final boolean B() {
        return this.f489808a.B();
    }

    @Override // s83.g
    public final void C(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f489808a.C(r100, r101);
    }

    @Override // s83.g
    public final void H(String r100, double r101, Map r102) {
        Intrinsics.checkNotNullParameter(r100, "stageName");
        Intrinsics.checkNotNullParameter("", "scheme");
        Intrinsics.checkNotNullParameter("mall_deliveryRecord_bridge", "triggerSource");
        this.f489808a.H(r100, r101, r102);
    }

    @Override // s83.g
    public final void J() {
        this.f489808a.J();
    }

    @Override // s83.g
    public final void M(Activity r100, String r101, com.bytedance.android.shopping.anchorv3.widget.b r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "riskInfo");
        this.f489808a.M(r100, r101, r102);
    }

    @Override // s83.g
    public final boolean P() {
        return this.f489808a.P();
    }

    @Override // s83.g
    public final String S(String r100) {
        return this.f489808a.S(r100);
    }

    @Override // s83.g
    public final s83.h T() {
        return this.f489808a.T();
    }

    @Override // s83.g
    public final int U() {
        return this.f489808a.U();
    }

    @Override // s83.g
    public final List<IECBridgeMethod> Y() {
        return this.f489808a.Y();
    }

    @Override // s83.g
    public final void b(Map r100) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.f489808a.b(r100);
    }

    @Override // s83.g
    public final void b0() {
        this.f489808a.b0();
    }

    @Override // s83.g
    public final void d0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f489808a.d0(r100);
    }

    @Override // s83.g
    public final String e(String r100, String r101, JSONObject r102) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        Intrinsics.checkNotNullParameter(r101, "pageName");
        return this.f489808a.e(r100, r101, r102);
    }

    @Override // s83.g
    public final void e0(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f489808a.e0(r100, r101);
    }

    @Override // s83.g
    public final void f0(Context r100, String r101, Function1<? super Integer, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        this.f489808a.f0(r100, r101, r102);
    }

    @Override // s83.g
    public final void g() {
        this.f489808a.g();
    }

    @Override // s83.g
    public final void g0(Context r100, boolean r101) {
        this.f489808a.g0(r100, r101);
    }

    @Override // s83.g
    public final Integer getLocationPermissionParam() {
        return this.f489808a.getLocationPermissionParam();
    }

    @Override // s83.g
    public final Map<String, Object> getSettings(List<String> r100) {
        return this.f489808a.getSettings(r100);
    }

    @Override // s83.g
    public final void h0() {
        this.f489808a.h0();
    }

    @Override // s83.g
    public final void i() {
        this.f489808a.i();
    }

    @Override // s83.g
    public final void i0(v83.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f489808a.i0(r100);
    }

    @Override // s83.g
    public final boolean isPad() {
        return this.f489808a.isPad();
    }

    @Override // s83.g
    public final void j0(String r100) {
        Intrinsics.checkNotNullParameter("ECStore", "tag");
        this.f489808a.j0(r100);
    }

    @Override // s83.g
    public final void k(Map r100) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.f489808a.k(r100);
    }

    @Override // s83.g
    public final void l() {
        this.f489808a.l();
    }

    @Override // s83.g
    public final void m() {
        this.f489808a.m();
    }

    @Override // s83.g
    public final void o(v83.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f489808a.o(r100);
    }

    @Override // s83.g
    public final JsonObject r() {
        return this.f489808a.r();
    }

    @Override // s83.g
    public final void t(Map r100) {
        Intrinsics.checkNotNullParameter("", "schema");
        this.f489808a.t(r100);
    }

    @Override // s83.g
    public final boolean u() {
        return this.f489808a.u();
    }

    @Override // s83.g
    public final void v(Runnable r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f489808a.v(r100);
    }

    @Override // s83.g
    public final void w(List r100, l.c r101) {
        Intrinsics.checkNotNullParameter(r100, "paths");
        Intrinsics.checkNotNullParameter(r101, "listener");
        this.f489808a.w(r100, r101);
    }

    @Override // s83.g
    public final void y() {
        this.f489808a.y();
    }

    @Override // s83.g
    public final void z() {
        this.f489808a.z();
    }

    static {
        f489807b = new g();
    }

    @Override // s83.g
    public final s83.c D() {
        s83.c r100 = h.f489809a.D();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.e();
    }

    @Override // s83.g
    public final Boolean E() {
        return h.f489809a.E();
    }

    @Override // s83.g
    public final p83.f G() {
        p83.f r100 = h.f489809a.G();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.h();
    }

    @Override // s83.g
    public final s83.d N() {
        s83.d r100 = h.f489809a.N();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.f();
    }

    @Override // s83.g
    public final t83.a Q() {
        t83.a r100 = h.f489809a.Q();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.b();
    }

    @Override // s83.g
    public final Boolean R() {
        return h.f489809a.R();
    }

    @Override // s83.g
    public final s83.e W() {
        s83.e r100 = h.f489809a.W();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.g();
    }

    @Override // s83.g
    public final boolean Z() {
        return h.f489809a.Z();
    }

    @Override // s83.g
    public final String a() {
        return h.f489809a.a();
    }

    @Override // s83.g
    public final boolean a0() {
        return h.f489809a.a0();
    }

    @Override // s83.g
    public final boolean c0() {
        return h.f489809a.c0();
    }

    @Override // s83.g
    public final String getCurrentBcmChain() {
        return h.f489809a.getCurrentBcmChain();
    }

    @Override // s83.g
    public final float getFontScale() {
        return h.f489809a.getFontScale();
    }

    @Override // s83.g
    public final int getHomePageMallSource() {
        return h.f489809a.getHomePageMallSource();
    }

    @Override // s83.g
    public final Boolean hasLivePlayingMute() {
        return h.f489809a.hasLivePlayingMute();
    }

    @Override // s83.g
    public final boolean isSearchScreenshotBubbleMobOpen() {
        return h.f489809a.isSearchScreenshotBubbleMobOpen();
    }

    @Override // s83.g
    public final u83.a j() {
        u83.a r100 = h.f489809a.j();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.c();
    }

    @Override // s83.g
    public final IVideoPlaybackService n() {
        return h.f489809a.n();
    }

    @Override // s83.g
    public final s83.f p() {
        s83.f r100 = h.f489809a.p();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new i();
    }

    @Override // s83.g
    public final s83.a q() {
        s83.a r100 = h.f489809a.q();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.a();
    }

    @Override // s83.g
    public final void s() {
        h.f489809a.s();
    }

    @Override // s83.g
    public final s83.b x() {
        s83.b r100 = h.f489809a.x();
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new jh3.d();
    }

    public g() {
        this.f489808a = h.f489809a;
    }

    @Override // s83.g
    public final String F(String r100) {
        return h.f489809a.F(r100);
    }

    @Override // s83.g
    public final void I(int r100) {
        h.f489809a.I(r100);
    }

    @Override // s83.g
    public final JSONObject K(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return h.f489809a.K(r100);
    }

    @Override // s83.g
    public final void O(int r100) {
        h.f489809a.O(r100);
    }

    @Override // s83.g
    public final void X(int r100) {
        h.f489809a.X(r100);
    }

    @Override // s83.g
    public final void c(int r100) {
        h.f489809a.c(r100);
    }

    @Override // s83.g
    public final JSONObject f(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        return h.f489809a.f(r100);
    }

    @Override // s83.g
    public final void k0(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        h.f489809a.k0(r100);
    }

    @Override // s83.g
    public final void V(String r100, int r101, Object r102, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        h.f489809a.V(r100, r101, r102, r103);
    }

    @Override // s83.g
    public final void h(FragmentActivity r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r101, "filePath");
        Intrinsics.checkNotNullParameter(r102, "extra");
        Intrinsics.checkNotNullParameter(r103, "screenShotWithQr");
        h.f489809a.h(r100, r101, r102, r103);
    }

    @Override // s83.g
    public final void L(String r100, String r101, String r110, Function1<? super Integer, Unit> r111, Function0<Unit> r112) {
        Intrinsics.checkNotNullParameter(r100, "itemId");
        h.f489809a.L(r100, r101, r110, r111, r112);
    }

    @Override // s83.g
    public final void d(String r110, String r111, String r112, String r113, String r114, Map<String, ? extends Object> r115, String r116, String r117) {
        Intrinsics.checkNotNullParameter(r110, "tag");
        Intrinsics.checkNotNullParameter(r111, "label");
        Intrinsics.checkNotNullParameter(r113, "creative_id");
        h.f489809a.d(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
