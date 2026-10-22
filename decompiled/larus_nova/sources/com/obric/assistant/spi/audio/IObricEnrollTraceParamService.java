package com.obric.assistant.spi.audio;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J,\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\f"}, d2 = {"Lcom/obric/assistant/spi/audio/IObricEnrollTraceParamService;", "", "putEnterPageEventPara", "", "jsonObject", "Lorg/json/JSONObject;", "currentPage", "", "previousPage", "enterFrom", "putClickPageEventPara", ReportConstant.COMMON_ACTION_TYPE, "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricEnrollTraceParamService {
    void a(JSONObject r100, String r101, String r102, String r103);

    void b(JSONObject r100, String r101, String r102, String r103);
}
