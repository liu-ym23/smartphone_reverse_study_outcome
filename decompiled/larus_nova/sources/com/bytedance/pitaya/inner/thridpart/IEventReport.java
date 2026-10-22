package com.bytedance.pitaya.inner.thridpart;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/inner/thridpart/IEventReport;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "reportEvent", "", "eventName", "", "category", "Lorg/json/JSONObject;", "metric", "extra", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IEventReport extends ReflectionCall {
    void reportEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
