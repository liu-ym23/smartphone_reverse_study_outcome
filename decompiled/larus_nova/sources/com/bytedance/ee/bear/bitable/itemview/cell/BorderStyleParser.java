package com.bytedance.ee.bear.bitable.itemview.cell;

import com.bytedance.ee.bear.bitable.itemview.record.list.BorderStyle;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0006\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/BorderStyleParser;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/BorderStyle;", "Lcom/google/gson/JsonSerializer;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderStyleParser implements JsonDeserializer<BorderStyle>, JsonSerializer<BorderStyle> {
    public BorderStyleParser() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final BorderStyle deserialize(JsonElement r100, Type r101, JsonDeserializationContext r102) {
        if (r100 == null) goto L4;
        String r103 = r100.getAsString();
    L5:
        BorderStyle.Companion.getClass();
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L18;
        BorderStyle r105 = (BorderStyle) BorderStyle.access$getMap$cp().get(r103.toLowerCase(Locale.ROOT));
        if (r105 == null) goto L17;
        return r105;
    L17:
        return BorderStyle.Soli;
    L18:
        return BorderStyle.Soli;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L4:
        r103 = null;
        goto L5
    }

    @Override // com.google.gson.JsonSerializer
    public final JsonElement serialize(BorderStyle r100, Type r101, JsonSerializationContext r102) {
        BorderStyle r103 = r100;
        if (r103 == null) goto L6;
        String r104 = r103.getValue();
        if (r104 == null) goto L6;
    L8:
        return new JsonPrimitive(r104);
    L6:
        r104 = BorderStyle.Soli.getValue();
        goto L8
    }
}
