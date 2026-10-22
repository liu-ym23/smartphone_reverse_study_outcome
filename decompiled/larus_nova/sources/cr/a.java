package cr;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.l;
import com.bytedance.android.ecom.bcm.track.api.p003const.AppendScene;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f465029a = null;

    public a() {
    }

    @Override // cr.c
    public final String appendEntranceInfo(l r100, String r101, AppendScene r102) {
        return r101;
    }

    @Override // cr.c
    public final JSONObject appendEntranceInfo(l r100, JSONObject r101, AppendScene r102) {
        return r101;
    }

    @Override // cr.c
    public final Map<String, Object> appendEventParams(PageFinder r100, Map<String, ? extends Object> r101) {
        return r101;
    }

    @Override // cr.c
    public final String getBcmChainForGlobalProps(Map<String, Object> r100) {
        return null;
    }

    @Override // cr.c
    public final String getBcmChainWithStandardContent(PageFinder r100) {
        return null;
    }

    @Override // cr.c
    public final String getBcmChainWithStandardContent(l r100) {
        return null;
    }

    @Override // cr.c
    public final JSONObject getBcmInfoForGlobalProps(Map<String, Object> r100) {
        return null;
    }

    @Override // cr.c
    public final String getCompressedBcmChain(String r100, Boolean r101, String r102, String r103) {
        return null;
    }

    @Override // cr.c
    public final void init() {
    }

    @Override // cr.c
    public final void setUnitParams(PageFinder r100, BcmParams r101) {
    }

    static {
        f465029a = new a();
    }
}
