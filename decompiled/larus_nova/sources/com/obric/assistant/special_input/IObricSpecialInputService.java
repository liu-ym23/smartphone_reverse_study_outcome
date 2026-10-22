package com.obric.assistant.special_input;

import android.content.Context;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.obric.aiagent.assistant.idl.bean.DMTaskState;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&J\u001e\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0006H&¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/special_input/IObricSpecialInputService;", "", "getObricVariantInputWidget", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getBuryPointState", "", "mapActionBarKey", PlayerResolution.SDKKEY.ORIGIN, "getComplexClarifyMessageExtra", "", "relatedTask", "Lcom/obric/aiagent/assistant/idl/bean/DMTaskState;", "replayCallForMe", "", "closeSpecialInputBeforeMicOn", "isAssistantRequestFromAIKey", "", "isFeatureEnable", "featureKey", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricSpecialInputService {
    void a();

    Object b(Context r100);

    boolean c();

    void d();

    String e(String r100);

    String f();

    Map<String, String> g(DMTaskState r100);

    boolean isAssistantRequestFromAIKey();
}
