package jc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.api.model.l;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;

/* JADX INFO: loaded from: classes3.dex */
public interface b {
    void appendPageParams(PageFinder r100, String r101, BcmParams r102);

    void appendUnitParams(PageFinder r100, String r101, BcmParams r102);

    void configBusiness(String r100, kc.b r101);

    kc.a getBcmChainByBtmModel(d r100, List<String> r101, int r102, boolean r103);

    kc.a getBcmChainByFinder(PageFinder r100, List<String> r101, int r102, boolean r103);

    kc.a getBcmChainByToken(String r100, List<String> r101, int r102, boolean r103);

    Map<String, Object> getBcmPassThroughMap(l r100);

    void init();

    @Deprecated(message = "DO NOT USE", replaceWith = @ReplaceWith(expression = "registerBcmParamsChecker", imports = {}))
    void registerExtraChecker(kc.d r100);

    void setBcmPageParams(PageFinder r100, BcmParams r101, boolean r102);

    boolean setBcmParams(PageFinder r100, Map<String, ? extends Object> r101);

    boolean setBcmParamsV2(PageFinder r100, Map<String, ? extends Object> r101);

    void setPageEventParams(PageFinder r100, Map<String, ? extends Object> r101);

    void setPageParams(PageFinder r100, String r101, BcmParams r102);

    void setUnitParams(PageFinder r100, String r101, BcmParams r102);

    void setUnitParamsV2(PageFinder r100, Map<String, ? extends Object> r101);
}
