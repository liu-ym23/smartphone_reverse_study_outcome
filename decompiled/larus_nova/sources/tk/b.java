package tk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.live.api.commerce.userinfo.f;
import com.bytedance.android.livesdk.livecommerce.room.service.CommerceServiceDelegate;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;
import vk.d;

/* JADX INFO: loaded from: classes44.dex */
public interface b {
    void callInjection();

    void chooseCategory(String r100, String r101);

    void e(d r100);

    boolean enableFullLiveCommerce();

    void g(JSONObject r100);

    uk.a getBuyNowService();

    xk.b getECLiveReplayService();

    f getECUserInfoService();

    al.a getLiveBizWindowLayoutAbility();

    al.b getLiveBizWindowLogAbility();

    al.c getLiveBizWindowWidgetAbility();

    JSONObject getLiveShoppingData(int r100);

    void h(Activity r100);

    void handleWebcastInRoomSchema(Map<String, Object> r100);

    void hookECOMLiveParams(String r100, Bundle r101);

    boolean i(Object r100);

    boolean isProductDetailPageExpanded();

    void j(String r100, Bundle r101);

    Fragment k(Context r100, CommerceServiceDelegate.i r101);

    void notifyPromotionNum(int r100);

    boolean onBackPressed();

    void roomEnter(String r100, String r101, String r102, Map<String, String> r103);

    void setAddress(String r100, int r101, String r102);

    boolean showEnterRoomTicketExpandDialog(boolean r100);

    boolean showExitRoomTicketExpandDialog(boolean r100, Runnable r101);

    DialogFragment showLiveFlashFragment(Context r100, Bundle r101);

    void switchFlashConfig(boolean r100);

    void tryShowLiveFlashFragment(Context r100, Bundle r101, Function1<DialogFragment, Unit> r102);

    void tryShowSaasCouponDialog(Context r100, Bundle r101, Function1<JSONObject, Unit> r102);

    void updatePromotionList();
}
