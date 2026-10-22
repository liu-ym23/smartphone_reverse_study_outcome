package s83;

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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public interface g {
    ECAdInfo A(String r100);

    boolean B();

    void C(String r100, JSONObject r101);

    c D();

    Boolean E();

    String F(String r100);

    p83.f G();

    void H(String r100, double r101, Map r102);

    void I(int r100);

    void J();

    JSONObject K(JSONObject r100);

    void L(String r100, String r101, String r102, Function1<? super Integer, Unit> r103, Function0<Unit> r104);

    void M(Activity r100, String r101, com.bytedance.android.shopping.anchorv3.widget.b r102);

    d N();

    void O(int r100);

    boolean P();

    t83.a Q();

    Boolean R();

    String S(String r100);

    h T();

    int U();

    void V(String r100, int r101, Object r102, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r103);

    e W();

    void X(int r100);

    List<IECBridgeMethod> Y();

    boolean Z();

    String a();

    boolean a0();

    void b(Map r100);

    void b0();

    void c(int r100);

    boolean c0();

    void d(String r100, String r101, String r102, String r103, String r104, Map<String, ? extends Object> r105, String r106, String r107);

    void d0(View r100);

    String e(String r100, String r101, JSONObject r102);

    void e0(FragmentActivity r100, boolean r101);

    JSONObject f(JSONObject r100);

    void f0(Context r100, String r101, Function1<? super Integer, Unit> r102);

    void g();

    void g0(Context r100, boolean r101);

    String getCurrentBcmChain();

    float getFontScale();

    int getHomePageMallSource();

    Integer getLocationPermissionParam();

    Map<String, Object> getSettings(List<String> r100);

    void h(FragmentActivity r100, String r101, String r102, String r103);

    void h0();

    Boolean hasLivePlayingMute();

    void i();

    void i0(v83.a r100);

    boolean isPad();

    boolean isSearchScreenshotBubbleMobOpen();

    u83.a j();

    void j0(String r100);

    void k(Map r100);

    void k0(ViewGroup r100);

    void l();

    void m();

    IVideoPlaybackService n();

    void o(v83.a r100);

    f p();

    a q();

    JsonObject r();

    void s();

    void t(Map r100);

    boolean u();

    void v(Runnable r100);

    void w(List r100, l.c r101);

    b x();

    void y();

    void z();
}
