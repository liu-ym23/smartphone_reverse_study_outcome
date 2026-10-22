package com.bytedance.ee.bear.bitable.itemview.cell;

import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
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
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/EFieldUITypeParser;", "Lcom/google/gson/JsonSerializer;", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "serialize", "Lcom/google/gson/JsonElement;", "src", "typeOfSrc", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonSerializationContext;", "deserialize", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EFieldUITypeParser implements JsonSerializer<EFieldUIType>, JsonDeserializer<EFieldUIType> {
    public EFieldUITypeParser() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final EFieldUIType deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Intrinsics.checkNotNullParameter(r101, "typeOfT");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        EFieldUIType.a r103 = EFieldUIType.Companion;
        String r104 = r100.getAsString();
        r103.getClass();
        return EFieldUIType.a.a(r104);
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(EFieldUIType r100, Type r101, JsonSerializationContext r102) {
        EFieldUIType r103 = r100;
        Intrinsics.checkNotNullParameter(r103, "src");
        Intrinsics.checkNotNullParameter(r101, "typeOfSrc");
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        return new JsonPrimitive(r103.getValue());
    }
}
