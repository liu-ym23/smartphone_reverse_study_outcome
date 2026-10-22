package wh6;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.base.abtest.ClientABTestKey;
import com.bytedance.android.scope.o;
import com.bytedance.live.kmp.core.c;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends c, o {
    boolean A9();

    boolean Wb();

    int Xe();

    void broadcastPerfDowngrade(boolean r100);

    void centerIconToast(Context r100, Map<String, ? extends Object> r101);

    void checkAndShowGuide(FragmentActivity r100, String r101, String r102);

    boolean d9();

    boolean ec();

    int getAppId();

    String getAppName();

    String getChannel();

    <T> T getClientABValue(ClientABTestKey<T> r100);

    Activity getCurrentActivity();

    b getCurrentLocation();

    Context getHostContext();

    Activity getTopActivity();

    int getUpdateVersionCode();

    String getVersionCode();

    boolean isAppInGuestMode();

    boolean isBoe();

    boolean isDeepCleanDowngrade();

    boolean isNeedProtectUnderage();

    boolean isPersonalRecommendOn();

    boolean n2();

    String o8();

    void openWallet(Activity r100);

    boolean wn();
}
