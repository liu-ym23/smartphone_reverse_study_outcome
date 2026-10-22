package com.obric.memorydata.sdk.screencapture.rule;

import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRuleDeserializerTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenEventRuleDeserializerTypeAdapter implements JsonDeserializer<ScreenEventRule> {
    public ScreenEventRuleDeserializerTypeAdapter() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final ScreenEventRule deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Map<ScreenEvent.EventType, Class<? extends ScreenEventRule>> r103 = ScreenEventRule.f397277a;
        String r104 = r100.toString();
        Intrinsics.checkNotNullParameter(r104, "json");
        String r105 = new JSONObject(r104).optString("eventType");
        Intrinsics.checkNotNull(r105);
        if (r105.length() != 0) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == true) goto L10;
        ScreenEvent.EventType r107 = ScreenEvent.EventType.valueOf(r105);
        Class<? extends ScreenEventRule> r108 = ScreenEventRule.f397277a.get(r107);
        if (r108 == null) goto L10;
        ScreenEventRule r109 = (ScreenEventRule) GsonProtectorUtils.fromJson(new Gson(), r104, r108);
    L12:
        if (r109 == null) goto L15;
        return r109;
    L15:
        throw new IllegalArgumentException("invalid json for ScreenEventRule");
    L10:
        r109 = null;
        goto L12
    L5:
        r106 = false;
        goto L6
    }
}
