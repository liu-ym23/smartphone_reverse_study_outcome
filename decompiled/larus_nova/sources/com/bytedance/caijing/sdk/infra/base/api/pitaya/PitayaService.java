package com.bytedance.caijing.sdk.infra.base.api.pitaya;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.caijing.sdk.infra.base.core.di.ICJService;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.VideoTools;
import de4.a;
import de4.b;
import de4.c;
import de4.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J.\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J,\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\rH&J2\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\rH&J,\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\rH&J6\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0014\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH&J\u0018\u0010#\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!H&J&\u0010'\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00062\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u001d0%H&J\u0010\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u0006H&J,\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00060\u00172\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010+\u001a\u00020*H&¨\u0006-"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/api/pitaya/PitayaService;", "Lcom/bytedance/caijing/sdk/infra/base/core/di/ICJService;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lorg/json/JSONObject;", "setupInfo", "", "aid", "Lde4/c;", "callBack", "", "init", "business", "Lde4/d;", "registerApplogRunEventCallback", "", "type", "Landroid/graphics/Bitmap;", SimplayerImageStrategy.RESULT_BITMAP, "runTask", "params", "", "timeout", "Lkotlin/Pair;", "", "isReady", "Lde4/b;", "listener", "registerHostSetupListener", "", "cardNoImg", "", VideoTools.ERROR_TYPE_COMPRESS, "Lde4/a;", "callback", "starRunVmJSWorker", "eventName", "", "evtParams", "onSubmitEvent", "code", "evaluateJavaScript", "Lcom/bytedance/caijing/sdk/infra/base/api/pitaya/RetainDecisionModuleExecFunction;", "functionName", "decideWndTypeViaJs", "cj-host-service-api_release"}, k = 1, mv = {1, 6, 0})
public interface PitayaService extends ICJService {
    byte[] compress(Object r100);

    Pair<Boolean, String> decideWndTypeViaJs(String r100, long r101, RetainDecisionModuleExecFunction r102);

    void evaluateJavaScript(String r100);

    void init(Context r100, JSONObject r101, String r102, c r103);

    boolean isReady(String r100);

    void onSubmitEvent(String r100, Map<String, ? extends Object> r101);

    void registerApplogRunEventCallback(Context r100, String r101, String r102, d r103);

    void registerHostSetupListener(b r100);

    Pair<Boolean, JSONObject> runTask(String r100, String r101, JSONObject r102, long r103);

    void runTask(String r100, int r101, String r102, Bitmap r103, d r104);

    void runTask(String r100, String r101, JSONObject r102, d r103);

    void starRunVmJSWorker(Context r100, a r101);
}
