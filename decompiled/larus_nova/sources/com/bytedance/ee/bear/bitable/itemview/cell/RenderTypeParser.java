package com.bytedance.ee.bear.bitable.itemview.cell;

import com.bytedance.ee.bear.bitable.itemview.record.list.RenderType;
import com.bytedance.ee.bear.bitable.itemview.util.l;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/RenderTypeParser;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/RenderType;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RenderTypeParser implements JsonSerializer<RenderType>, JsonDeserializer<RenderType> {
    public RenderTypeParser() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final RenderType deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = r100.getAsInt();
        RenderType.Companion.getClass();
        RenderType[] r104 = RenderType.values();
        int r105 = r104.length;
        int r106 = 0;
    L4:
        if (r106 >= r105) goto L12;
        RenderType r107 = r104[r106];
        if (r107.getValue() != r103) goto L8;
        boolean r108 = true;
    L9:
        if (r108 == true) goto L13;
        r106 = r106 + 1;
    L13:
        if (r107 != null) goto L18;
        l.a("RenderTypeParser.Unknown RenderType value: " + r103, null, null, null, 14);
        return RenderType.Placeholder;
    L18:
        return r107;
    L8:
        r108 = false;
        goto L9
    L12:
        r107 = null;
        goto L13
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(RenderType r100, Type r101, JsonSerializationContext r102) {
        RenderType r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new JsonPrimitive(Integer.valueOf(r103.getValue()));
    }
}
