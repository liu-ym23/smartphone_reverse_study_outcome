package com.bytedance.ee.bear.bitable.itemview.cell;

import com.bytedance.ee.bear.bitable.itemview.record.list.CellPureUIType;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/PureUITypeParser;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/CellPureUIType;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PureUITypeParser implements JsonSerializer<CellPureUIType>, JsonDeserializer<CellPureUIType> {
    public PureUITypeParser() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final CellPureUIType deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r100.isJsonNull() == false) goto L6;
        return CellPureUIType.NotSupport;
    L6:
        if (r100.isJsonPrimitive() == false) goto L16;
        JsonPrimitive r103 = r100.getAsJsonPrimitive();
        if (r103.isNumber() == false) goto L14;
        CellPureUIType.a r104 = CellPureUIType.Companion;
        int r105 = r103.getAsInt();
        r104.getClass();
        CellPureUIType r106 = (CellPureUIType) CellPureUIType.access$getMAP$cp().get(Integer.valueOf(r105));
        if (r106 == null) goto L18;
        return r106;
    L18:
        return CellPureUIType.NotSupport;
    L14:
        return CellPureUIType.NotSupport;
    L16:
        return CellPureUIType.NotSupport;
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(CellPureUIType r100, Type r101, JsonSerializationContext r102) {
        CellPureUIType r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new JsonPrimitive(Integer.valueOf(r103.getValue()));
    }
}
