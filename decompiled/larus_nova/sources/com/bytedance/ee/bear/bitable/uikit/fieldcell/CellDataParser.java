package com.bytedance.ee.bear.bitable.uikit.fieldcell;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u001f*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001\u001fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004J\u001f\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0002\u0010\u000fJ\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0004J+\u0010\u0014\u001a\u00028\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u001dH&¨\u0006 "}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/CellDataParser;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/google/gson/JsonDeserializer;", "<init>", "()V", "safeGetJsonElementString", "", "jsonObject", "Lcom/google/gson/JsonObject;", "key", "safeGetJsonElementBoolean", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Boolean;", "safeGetJsonElementInt", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Integer;", "safeGetHighLightModel", "Lcom/bytedance/ee/bear/bitable/common/widgets/HighlightModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Ljava/lang/Object;", "bizDeserialize", "", "cellData", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", "buildCellData", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class CellDataParser<T> implements JsonDeserializer<T> {

    public static final class a {
    }

    static {
    }

    public CellDataParser() {
    }

    public void a(JsonObject r100, BaseCellData r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "cellData");
    }

    public abstract BaseCellData b();

    public static Boolean c(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r102 = r100.get(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isJsonNull() != true) goto L7;
    L9:
        if (r103 == false) goto L11;
        return null;
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        return Boolean.valueOf(r102.getAsBoolean());
    L7:
        r103 = false;
        goto L9
    }

    public static String d(JsonObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "key");
        JsonElement r102 = r100.get(r101);
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.isJsonNull() != true) goto L7;
    L9:
        if (r103 == false) goto L11;
        return null;
    L11:
        if (r102 != null) goto L13;
        return null;
    L13:
        return r102.getAsString();
    L7:
        r103 = false;
        goto L9
    }

    /* JADX WARN: Type inference failed for: r15v1, types: [T, com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData] */
    @Override // com.google.gson.JsonDeserializer
    public final T deserialize(JsonElement r110, Type r111, JsonDeserializationContext r210) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L70;
        JsonObject r102 = r110.getAsJsonObject();
        Intrinsics.checkNotNull(r102);     // Catch: Exception -> L65
        String r103 = d(r102, "fieldUIType");     // Catch: Exception -> L65
        if (TextUtils.isEmpty(r103) == true) goto L13;
        EFieldUIType.Companion.getClass();     // Catch: Exception -> L65
        EFieldUIType r104 = EFieldUIType.a.a(r103);     // Catch: Exception -> L65
        BaseCellData.Companion.getClass();     // Catch: Exception -> L65
        Type r105 = BaseCellData.a.a(r104);     // Catch: Exception -> L65
        String r106 = d(r102, "fieldId");     // Catch: Exception -> L65
        String r107 = "";
        if (r106 != null) goto L18;
        r106 = "";
    L18:
        String r112 = d(r102, "fieldName");     // Catch: Exception -> L65
        if (r112 == null) goto L22;
        r107 = r112;
    L22:
        String r113 = d(r102, "highlightColor");     // Catch: Exception -> L65
        String r114 = d(r102, "borderHighlightColor");     // Catch: Exception -> L65
        Boolean r115 = c(r102, "isClipped");     // Catch: Exception -> L65
        Boolean r116 = c(r102, "isBold");     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter(r102, "jsonObject");     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter("totalChildCount", "key");     // Catch: Exception -> L65
        JsonElement r117 = r102.get("totalChildCount");     // Catch: Exception -> L65
        if (r117 != null) goto L25;
    L27:
        r100 = false;
    L28:
        if (r100 == true) goto L32;
        if (r117 == null) goto L32;
        Integer r108 = Integer.valueOf(r117.getAsInt());     // Catch: Exception -> L65
    L33:
        JsonElement r118 = r102.get("data");     // Catch: Exception -> L65
        if (r118 == null) goto L62;
        if (r118.isJsonArray() == false) goto L62;
        ?? r119 = (T) b();
        r119.setFieldId(r106);     // Catch: Exception -> L65
        r119.setFieldUIType(r104);     // Catch: Exception -> L65
        r119.setFieldName(r107);     // Catch: Exception -> L65
        r119.setHighlightColor(r113);     // Catch: Exception -> L65
        r119.setBorderHighlightColor(r114);     // Catch: Exception -> L65
        r119.setClipped(r115);     // Catch: Exception -> L65
        r119.setTotalChildCount(r108);     // Catch: Exception -> L65
        r119.setBold(r116);     // Catch: Exception -> L65
        Intrinsics.checkNotNullParameter(r102, "jsonObject");     // Catch: Exception -> L65
        JsonElement r109 = r102.get("highlightColorV2");     // Catch: Exception -> L65
        if (r109 == null) goto L44;
        if (r210 == null) goto L44;
        HighlightModel r120 = (HighlightModel) r210.deserialize(r109, HighlightModel.class);     // Catch: Exception -> L43
    L45:
        r119.setHighlightColorV2(r120);     // Catch: Exception -> L65
        if (r104 == EFieldUIType.NOT_SUPPORT) goto L59;
        if (r105 == null) goto L59;
        JsonArray r121 = r118.getAsJsonArray();     // Catch: Exception -> L65
        ArrayList r122 = new ArrayList();     // Catch: Exception -> L65
        Iterator<JsonElement> r123 = r121.iterator();     // Catch: Exception -> L65
    L50:
        if (r123.hasNext() == false) goto L57;
        JsonElement r124 = r123.next();     // Catch: Exception -> L65
        if (r210 == null) goto L54;
        h0 r125 = (h0) r210.deserialize(r124, r105);     // Catch: Exception -> L65
    L55:
        if (r125 == null) goto L50;
        r122.add(r125);     // Catch: Exception -> L65
        goto L50
    L54:
        r125 = null;
        goto L55
    L57:
        r119.setData(r122);     // Catch: Exception -> L65
    L59:
        a(r102, r119);     // Catch: Exception -> L63
        return r119;
    L43:
        tt5.a.d("CardCellDataParser", "safeGetHighLightModel parser exception");     // Catch: Exception -> L65
    L44:
        r120 = null;
    L62:
        return (T) b();
    L63:
        e = e;
    L67:
        tt5.a.e("CardCellDataParser", "PanelDataParser : deserialize fails: ", e, false);
    L32:
        r108 = null;
        goto L33
    L25:
        if (r117.isJsonNull() != true) goto L27;
    L13:
        return (T) b();
    L65:
        e = e;
    L70:
        return (T) b();
    L5:
        if (r110.isJsonObject() != true) goto L7;
        r101 = true;
        goto L8
    }
}
