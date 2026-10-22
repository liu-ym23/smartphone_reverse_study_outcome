package g50;

import android.os.Bundle;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.livesdk.gift.model.h2;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface c extends IService {
    h2 findLiteGiftById(long r100);

    void openGiftDialog(int r100, long r101, Bundle r102, List<String> r103, boolean r104, String r105);

    void openGiftDialog(int r100, long r101, String r102, Bundle r103, int r104, JSONObject r105, String r106);

    void openGiftDialog(IBaseUser r100);

    void openGiftDialog(IBaseUser r100, Bundle r101);

    void registerRecommendReceiver(String r100, String r101, Map<String, String> r102, Map<String, String> r103);
}
