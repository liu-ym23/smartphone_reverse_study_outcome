package xa7;

import com.ss.ttvideoengine.TTVideoEngineInterface;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class k extends ua7.g {
    public k(String r100, String r101) {
        super(false, TTVideoEngineInterface.GLOBAL_ENGINE_OPTION_VIDEOINFOFETCHER_HANDLER_THREAD, r100, r101);
    }

    @Override // ua7.g
    public final void a(JSONObject r100, JSONObject r101) {
        super.a(r100, r101);
        r101.optString("extra");
    }

    public k(boolean r100, String r101, int r102) {
        super(r100, TTVideoEngineInterface.GLOBAL_ENGINE_OPTION_VIDEOINFOFETCHER_HANDLER_THREAD, r101, r102);
    }
}
