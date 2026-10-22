package cr;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ecom.bcm.track.api.p003const.AppendScene;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface c {
    String appendEntranceInfo(l r100, String r101, AppendScene r102);

    JSONObject appendEntranceInfo(l r100, JSONObject r101, AppendScene r102);

    Map<String, Object> appendEventParams(PageFinder r100, Map<String, ? extends Object> r101);

    String getBcmChainForGlobalProps(Map<String, Object> r100);

    String getBcmChainWithStandardContent(PageFinder r100);

    String getBcmChainWithStandardContent(l r100);

    JSONObject getBcmInfoForGlobalProps(Map<String, Object> r100);

    String getCompressedBcmChain(String r100, Boolean r101, String r102, String r103);

    void init();

    void setUnitParams(PageFinder r100, BcmParams r101);
}
