package com.obric.capabilitykit.common;

import com.google.gson.JsonObject;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes33.dex */
@Deprecated(message = "migration to intent api")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J!\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0010H\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/common/BaseFunction;", "", "name", "", "getName", "()Ljava/lang/String;", "doAction", "Lcom/obric/capabilitykit/common/BaseResult;", "params", "Lcom/google/gson/JsonObject;", "dispatchContext", "Lcom/obric/capabilitykit/common/DispatchContext;", "(Lcom/google/gson/JsonObject;Lcom/obric/capabilitykit/common/DispatchContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isBlock", "", "translateTimeIntoUTC", "", "input", "translateUTCIntoTime", "time", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface BaseFunction {
    Object doAction(JsonObject r100, DispatchContext r101, Continuation<? super BaseResult> r102);

    String getName();

    boolean isBlock();

    long translateTimeIntoUTC(String r100);

    String translateUTCIntoTime(long r100);
}
