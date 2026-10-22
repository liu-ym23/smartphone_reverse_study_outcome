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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface g {
    ECAdInfo A(String r1);

    boolean B();

    void C(String r1, JSONObject r2);

    c D();

    Boolean E();

    String F(String r1);

    p83.f G();

    void H(String r1, double r2, Map r4);

    void I(int r1);

    void J();

    JSONObject K(JSONObject r1);

    void L(String r1, String r2, String r3, Function1<? super Integer, Unit> r4, Function0<Unit> r5);

    void M(Activity r1, String r2, com.bytedance.android.shopping.anchorv3.widget.b r3);

    d N();

    void O(int r1);

    boolean P();

    t83.a Q();

    Boolean R();

    String S(String r1);

    h T();

    int U();

    void V(String r1, int r2, Object r3, Function3<? super Integer, ? super String, ? super JSONObject, Unit> r4);

    e W();

    void X(int r1);

    List<IECBridgeMethod> Y();

    boolean Z();

    String a();

    boolean a0();

    void b(Map r1);

    void b0();

    void c(int r1);

    boolean c0();

    void d(String r1, String r2, String r3, String r4, String r5, Map<String, ? extends Object> r6, String r7, String r8);

    void d0(View r1);

    String e(String r1, String r2, JSONObject r3);

    void e0(FragmentActivity r1, boolean r2);

    JSONObject f(JSONObject r1);

    void f0(Context r1, String r2, Function1<? super Integer, Unit> r3);

    void g();

    void g0(Context r1, boolean r2);

    String getCurrentBcmChain();

    float getFontScale();

    int getHomePageMallSource();

    Integer getLocationPermissionParam();

    Map<String, Object> getSettings(List<String> r1);

    void h(FragmentActivity r1, String r2, String r3, String r4);

    void h0();

    Boolean hasLivePlayingMute();

    void i();

    void i0(v83.a r1);

    boolean isPad();

    boolean isSearchScreenshotBubbleMobOpen();

    u83.a j();

    void j0(String r1);

    void k(Map r1);

    void k0(ViewGroup r1);

    void l();

    void m();

    IVideoPlaybackService n();

    void o(v83.a r1);

    f p();

    a q();

    JsonObject r();

    void s();

    void t(Map r1);

    boolean u();

    void v(Runnable r1);

    void w(List r1, l.c r2);

    b x();

    void y();

    void z();
}
