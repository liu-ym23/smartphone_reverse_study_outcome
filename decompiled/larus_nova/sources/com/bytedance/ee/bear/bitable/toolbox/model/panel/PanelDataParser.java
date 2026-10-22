package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelDataParser;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/google/gson/JsonDeserializationContext;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelDataParser implements JsonDeserializer<PanelData> {

    public static final class a {
    }

    static {
    }

    public PanelDataParser() {
    }

    @Override // com.google.gson.JsonDeserializer
    public final PanelData deserialize(JsonElement r110, Type r111, JsonDeserializationContext r112) {
        if (r110 == null) goto L7;
        boolean r100 = true;
        if (r110.isJsonObject() != true) goto L7;
    L8:
        if (r100 == false) goto L71;
        JsonObject r113 = r110.getAsJsonObject();
        JsonElement r101 = r113.get("action");     // Catch: Exception -> L68
        PanelData.TopBarButton r102 = null;
        if (r101 == null) goto L13;
        String r103 = r101.getAsString();     // Catch: Exception -> L68
    L14:
        JsonElement r104 = r113.get("baseId");     // Catch: Exception -> L68
        if (r104 == null) goto L17;
        String r105 = r104.getAsString();     // Catch: Exception -> L68
    L18:
        JsonElement r106 = r113.get("tableId");     // Catch: Exception -> L68
        if (r106 == null) goto L21;
        String r107 = r106.getAsString();     // Catch: Exception -> L68
    L22:
        JsonElement r108 = r113.get("viewId");     // Catch: Exception -> L68
        if (r108 == null) goto L25;
        String r109 = r108.getAsString();     // Catch: Exception -> L68
    L26:
        JsonElement r114 = r113.get("viewEditable");     // Catch: Exception -> L68
        if (r114 == null) goto L29;
        boolean r115 = r114.getAsBoolean();     // Catch: Exception -> L68
    L30:
        JsonElement r116 = r113.get("srcObjToken");     // Catch: Exception -> L68
        if (r116 == null) goto L33;
        String r117 = r116.getAsString();     // Catch: Exception -> L68
    L34:
        JsonElement r118 = r113.get("srcObjType");     // Catch: Exception -> L68
        if (r118 == null) goto L37;
        Integer r119 = Integer.valueOf(r118.getAsInt());     // Catch: Exception -> L68
    L38:
        JsonElement r120 = r113.get("tabs");     // Catch: Exception -> L68
        if (r120 == null) goto L41;
        JsonArray r121 = r120.getAsJsonArray();     // Catch: Exception -> L68
    L42:
        JsonElement r122 = r113.get("currTab");     // Catch: Exception -> L68
        if (r122 == null) goto L45;
        String r123 = r122.getAsString();     // Catch: Exception -> L68
    L46:
        PanelData r124 = new PanelData();     // Catch: Exception -> L68
        r124.setAction(r103);     // Catch: Exception -> L68
        r124.setBaseId(r105);     // Catch: Exception -> L68
        r124.setTableId(r107);     // Catch: Exception -> L68
        r124.setViewId(r109);     // Catch: Exception -> L68
        r124.setViewEditable(r115);     // Catch: Exception -> L68
        r124.setSrcObjToken(r117);     // Catch: Exception -> L68
        r124.setSrcObjType(r119);     // Catch: Exception -> L68
        r124.setCurrTab(r123);     // Catch: Exception -> L68
        if (r121 == null) goto L53;
        ArrayList<String> r125 = new ArrayList();     // Catch: Exception -> L68
        int r126 = r121.size();     // Catch: Exception -> L68
        int r127 = 0;
    L49:
        if (r127 >= r126) goto L51;
        r125.add(r121.get(r127).getAsString());     // Catch: Exception -> L68
        r127 = r127 + 1;     // Catch: Exception -> L68
        goto L49
    L51:
        r124.setTabs(r125);     // Catch: Exception -> L68
    L53:
        if (TextUtils.equals(EPanelAction.SHOW_LAYOUT_PANEL.getValue(), r103) == false) goto L55;
    L58:
        if (r112 == null) goto L60;
        Object r128 = r112.deserialize(r113.get(WsConstants.KEY_PAYLOAD), PanelData.ViewSettingParams.class);     // Catch: Exception -> L68
    L61:
        r124.setPayload(r128);     // Catch: Exception -> L68
    L62:
        JsonElement r129 = r113.get("button");     // Catch: Exception -> L68
        if (r129 == null) goto L75;
        if (r112 == null) goto L66;
        r102 = (PanelData.TopBarButton) r112.deserialize(r129, PanelData.TopBarButton.class);     // Catch: Exception -> L68
    L66:
        r124.setButton(r102);     // Catch: Exception -> L68
        return r124;
    L75:
        return r124;
    L60:
        r128 = null;
        goto L61
    L55:
        if (TextUtils.equals(EPanelAction.LAYOUT_INFO_CHANGE.getValue(), r103) == true) goto L58;
        if (TextUtils.equals(EPanelAction.SHOW_COMPOSITE.getValue(), r103) == false) goto L62;
    L45:
        r123 = null;
        goto L46
    L41:
        r121 = null;
        goto L42
    L37:
        r119 = null;
        goto L38
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = false;
        goto L30
    L25:
        r109 = null;
        goto L26
    L21:
        r107 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r103 = null;
    L68:
        e = move-exception;
        tt5.a.e("PanelDataParser", "PanelDataParser : deserialize fails: ", e, false);
        return new PanelData();
    L71:
        return new PanelData();
    L7:
        r100 = false;
        goto L8
    }
}
