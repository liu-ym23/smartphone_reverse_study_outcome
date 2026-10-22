package com.obric.assistant.interaction.api;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J.\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH&¨\u0006\u000b"}, d2 = {"Lcom/obric/assistant/interaction/api/IObricApmService;", "", "markReady", "", "monitorEventForSlardar", "event", "", "category", "Lorg/json/JSONObject;", "metric", "extraLog", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricApmService {
    void markReady();

    void monitorEventForSlardar(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
