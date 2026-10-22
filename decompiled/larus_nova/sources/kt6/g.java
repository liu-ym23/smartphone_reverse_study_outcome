package kt6;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.locallife.bridge.common.method.XGetCurrentGCJLocationMethod;
import com.bytedance.locallife.bridge.common.method.i0;
import com.bytedance.locallife.bridge.common.method.o;
import com.bytedance.locallife.poi.newdetail.component.PoiDetailLocationBottomBarDitoView;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes21.dex */
public interface g {
    boolean a();

    l b(TokenCert r100);

    void c(Activity r100, TokenCert r101, Function0<Unit> r102, Function0<Unit> r103);

    boolean d();

    void e(String r100);

    void f();

    Map g();

    void h();

    void i(TokenCert r100, j r101);

    boolean isPersonalRecommendOn();

    boolean j();

    l k(TokenCert r100);

    boolean l();

    @Deprecated(message = "请不要使用该方法，如果需要使用该方法请联系@cassie.wang", replaceWith = @ReplaceWith(expression = "com.bytedance.locallife.host.location.ILifeLocationService.requestLocationPermission", imports = {}))
    void m(Activity r100, TokenCert r101, String r102, i0 r103, m r104, String r105);

    void n(Activity r100, String r101, PoiDetailLocationBottomBarDitoView.b r102);

    void o(Activity r100, TokenCert r101, String r102, h r103);

    void p(Activity r100, Function0 r101, o r102);

    void q(FragmentActivity r100, Function0 r101, Function0 r102);

    void r(TokenCert r100, XGetCurrentGCJLocationMethod.b r101);
}
