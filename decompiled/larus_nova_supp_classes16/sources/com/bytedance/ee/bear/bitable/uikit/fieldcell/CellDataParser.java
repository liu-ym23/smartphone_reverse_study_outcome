package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004J\u001f\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0004J+\u0010\u0014\u001a\u00028\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH&¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/CellDataParser;", "T", "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "safeGetJsonElementString", "", "jsonObject", "Lcom/google/gson/JsonObject;", "key", "safeGetJsonElementBoolean", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "safeGetJsonElementInt", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "safeGetHighLightModel", "Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", "context", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "bizDeserialize", "", "cellData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "buildCellData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CellDataParser<T> implements JsonDeserializer<T> {

    public static final class a {
    }

    static {
    }

    public CellDataParser() {
    }

    public void a(JsonObject r2, BaseCellData r3) {
        Intrinsics.checkNotNullParameter(r2, "jsonObject");
        Intrinsics.checkNotNullParameter(r3, "cellData");
    }

    public abstract BaseCellData b();

    public static Boolean c(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "jsonObject");
        Intrinsics.checkNotNullParameter(r2, "key");
        JsonElement r3 = r1.get(r2);
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.isJsonNull() != true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        if (r3 != null) goto L13;
        return null;
    L13:
        return Boolean.valueOf(r3.getAsBoolean());
    L7:
        r0 = false;
        goto L9
    }

    public static String d(JsonObject r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "jsonObject");
        Intrinsics.checkNotNullParameter(r2, "key");
        JsonElement r3 = r1.get(r2);
        if (r3 == null) goto L7;
        boolean r0 = true;
        if (r3.isJsonNull() != true) goto L7;
    L9:
        if (r0 == false) goto L11;
        return null;
    L11:
        if (r3 != null) goto L13;
        return null;
    L13:
        return r3.getAsString();
    L7:
        r0 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r15v1, types: [T, com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData] */
    public final T deserialize(JsonElement r18, Type r19, JsonDeserializationContext r20) {
        boolean r4 = true;
        if (r18 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        if (r5 == false) goto L70;
        JsonObject r6 = r18.getAsJsonObject();
        Intrinsics.checkNotNull(r6);     // Catch: Exception -> L65
        String r7 = d(r6, "fieldUIType");     // Catch: Exception -> L65
        if (TextUtils.isEmpty(r7) == true) goto L13;
        EFieldUIType.Companion.getClass();     // Catch: Exception -> L65
        EFieldUIType r8 = EFieldUIType.a.a(r7);     // Catch: Exception -> L65
        BaseCellData.Companion.getClass();     // Catch: Exception -> L65
        Type r9 = BaseCellData.a.a(r8);     // Catch: Exception -> L65
        String r10 = d(r6, "fieldId");     // Catch: Exception -> L65
        String r11 = "";
        if (r10 != null) goto L18;
        r10 = "";
    L18:
        String r12 = d(r6, "fieldName");     // Catch: Exception -> L65
        if (r12 == null) goto L22;
        r11 = r12;
    L22:
        String r13 = d(r6, "highlightColor");     // Catch: Exception -> L65
        String r14 = d(r6, "borderHighlightColor");     // Catch: Exception -> L65
        Boolean r16 = c(r6, "isClipped");     // Catch: Exception -> L65
        Boolean r17 = c(r6, "isBold");     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter(r6, "jsonObject");     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter("totalChildCount", "key");     // Catch: Exception -> L65
        JsonElement r110 = r6.get("totalChildCount");     // Catch: Exception -> L65
        if (r110 != null) goto L25;
    L27:
        r4 = false;
    L28:
        if (r4 == true) goto L32;
        if (r110 == null) goto L32;
        Integer r21 = Integer.valueOf(r110.getAsInt());     // Catch: Exception -> L65
    L33:
        JsonElement r111 = r6.get("data");     // Catch: Exception -> L65
        if (r111 == null) goto L62;
        if (r111.isJsonArray() == false) goto L62;
        ?? r112 = (T) b();
        r112.setFieldId(r10);     // Catch: Exception -> L65
        r112.setFieldUIType(r8);     // Catch: Exception -> L65
        r112.setFieldName(r11);     // Catch: Exception -> L65
        r112.setHighlightColor(r13);     // Catch: Exception -> L65
        r112.setBorderHighlightColor(r14);     // Catch: Exception -> L65
        r112.setClipped(r16);     // Catch: Exception -> L65
        r112.setTotalChildCount(r21);     // Catch: Exception -> L65
        r112.setBold(r17);     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter(r6, "jsonObject");     // Catch: Exception -> L65
        JsonElement r1 = r6.get("highlightColorV2");     // Catch: Exception -> L65
        if (r1 == null) goto L44;
        if (r20 == null) goto L44;
        HighlightModel r2 = (HighlightModel) r20.deserialize(r1, HighlightModel.class);     // Catch: Exception -> L43
    L45:
        r112.setHighlightColorV2(r2);     // Catch: Exception -> L65
        if (r8 == EFieldUIType.NOT_SUPPORT) goto L59;
        if (r9 == null) goto L59;
        JsonArray r3 = r111.getAsJsonArray();     // Catch: Exception -> L65
        ArrayList r22 = new ArrayList();     // Catch: Exception -> L65
        Iterator r23 = r3.iterator();     // Catch: Exception -> L65
    L50:
        if (r23.hasNext() == false) goto L57;
        JsonElement r24 = (JsonElement) r23.next();     // Catch: Exception -> L65
        if (r20 == null) goto L54;
        h0 r26 = (h0) r20.deserialize(r24, r9);     // Catch: Exception -> L65
    L55:
        if (r26 == null) goto L50;
        r22.add(r26);     // Catch: Exception -> L65
        goto L50
    L54:
        r26 = null;
        goto L55
    L57:
        r112.setData(r22);     // Catch: Exception -> L65
    L59:
        a(r6, r112);     // Catch: Exception -> L63
        return r112;
    L43:
        tt5.a.d("CardCellDataParser", "safeGetHighLightModel parser exception");     // Catch: Exception -> L65
    L44:
        r2 = null;
    L62:
        return (T) b();
    L63:
        e = e;
    L67:
        tt5.a.e("CardCellDataParser", "PanelDataParser : deserialize fails: ", e, false);
    L32:
        r21 = null;
        goto L33
    L25:
        if (r110.isJsonNull() != true) goto L27;
    L13:
        return (T) b();
    L65:
        e = e;
    L70:
        return (T) b();
    L5:
        if (r18.isJsonObject() != true) goto L7;
        r5 = true;
        goto L8
    }
}
