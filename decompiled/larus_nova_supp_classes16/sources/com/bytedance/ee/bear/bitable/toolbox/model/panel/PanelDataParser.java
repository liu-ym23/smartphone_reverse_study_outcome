package com.bytedance.ee.bear.bitable.toolbox.model.panel;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelDataParser;", "Lcom/google/gson/JsonDeserializer;", "Lcom/bytedance/ee/bear/bitable/toolbox/model/panel/PanelData;", "<init>", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "typeOfT", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PanelDataParser implements JsonDeserializer<PanelData> {

    public static final class a {
    }

    static {
    }

    public PanelDataParser() {
    }

    public final Object deserialize(JsonElement r12, Type r13, JsonDeserializationContext r14) {
        if (r12 == null) goto L7;
        boolean r1 = true;
        if (r12.isJsonObject() != true) goto L7;
    L8:
        if (r1 == false) goto L71;
        JsonObject r16 = r12.getAsJsonObject();
        JsonElement r0 = r16.get(JSEventListener.ACTION);     // Catch: Exception -> L68
        PanelData.TopBarButton r2 = null;
        if (r0 == null) goto L13;
        String r3 = r0.getAsString();     // Catch: Exception -> L68
    L14:
        JsonElement r4 = r16.get("baseId");     // Catch: Exception -> L68
        if (r4 == null) goto L17;
        String r5 = r4.getAsString();     // Catch: Exception -> L68
    L18:
        JsonElement r6 = r16.get("tableId");     // Catch: Exception -> L68
        if (r6 == null) goto L21;
        String r7 = r6.getAsString();     // Catch: Exception -> L68
    L22:
        JsonElement r8 = r16.get("viewId");     // Catch: Exception -> L68
        if (r8 == null) goto L25;
        String r9 = r8.getAsString();     // Catch: Exception -> L68
    L26:
        JsonElement r10 = r16.get("viewEditable");     // Catch: Exception -> L68
        if (r10 == null) goto L29;
        boolean r11 = r10.getAsBoolean();     // Catch: Exception -> L68
    L30:
        JsonElement r17 = r16.get("srcObjToken");     // Catch: Exception -> L68
        if (r17 == null) goto L33;
        String r18 = r17.getAsString();     // Catch: Exception -> L68
    L34:
        JsonElement r19 = r16.get("srcObjType");     // Catch: Exception -> L68
        if (r19 == null) goto L37;
        Integer r20 = Integer.valueOf(r19.getAsInt());     // Catch: Exception -> L68
    L38:
        JsonElement r21 = r16.get("tabs");     // Catch: Exception -> L68
        if (r21 == null) goto L41;
        JsonArray r22 = r21.getAsJsonArray();     // Catch: Exception -> L68
    L42:
        JsonElement r23 = r16.get("currTab");     // Catch: Exception -> L68
        if (r23 == null) goto L45;
        String r24 = r23.getAsString();     // Catch: Exception -> L68
    L46:
        PanelData r110 = new PanelData();     // Catch: Exception -> L68
        r110.setAction(r3);     // Catch: Exception -> L68
        r110.setBaseId(r5);     // Catch: Exception -> L68
        r110.setTableId(r7);     // Catch: Exception -> L68
        r110.setViewId(r9);     // Catch: Exception -> L68
        r110.setViewEditable(r11);     // Catch: Exception -> L68
        r110.setSrcObjToken(r18);     // Catch: Exception -> L68
        r110.setSrcObjType(r20);     // Catch: Exception -> L68
        r110.setCurrTab(r24);     // Catch: Exception -> L68
        if (r22 == null) goto L53;
        ArrayList<String> r26 = new ArrayList();     // Catch: Exception -> L68
        int r27 = r22.size();     // Catch: Exception -> L68
        int r28 = 0;
    L49:
        if (r28 >= r27) goto L51;
        r26.add(r22.get(r28).getAsString());     // Catch: Exception -> L68
        r28 = r28 + 1;     // Catch: Exception -> L68
        goto L49
    L51:
        r110.setTabs(r26);     // Catch: Exception -> L68
    L53:
        if (TextUtils.equals(EPanelAction.SHOW_LAYOUT_PANEL.getValue(), r3) == false) goto L55;
    L58:
        if (r14 == null) goto L60;
        Object r29 = r14.deserialize(r16.get("payload"), PanelData.ViewSettingParams.class);     // Catch: Exception -> L68
    L61:
        r110.setPayload(r29);     // Catch: Exception -> L68
    L62:
        JsonElement r111 = r16.get("button");     // Catch: Exception -> L68
        if (r111 == null) goto L75;
        if (r14 == null) goto L66;
        r2 = (PanelData.TopBarButton) r14.deserialize(r111, PanelData.TopBarButton.class);     // Catch: Exception -> L68
    L66:
        r110.setButton(r2);     // Catch: Exception -> L68
        return r110;
    L75:
        return r110;
    L60:
        r29 = null;
        goto L61
    L55:
        if (TextUtils.equals(EPanelAction.LAYOUT_INFO_CHANGE.getValue(), r3) == true) goto L58;
        if (TextUtils.equals(EPanelAction.SHOW_COMPOSITE.getValue(), r3) == false) goto L62;
    L45:
        r24 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L37:
        r20 = null;
        goto L38
    L33:
        r18 = null;
        goto L34
    L29:
        r11 = false;
        goto L30
    L25:
        r9 = null;
        goto L26
    L21:
        r7 = null;
        goto L22
    L17:
        r5 = null;
        goto L18
    L13:
        r3 = null;
    L68:
        e = move-exception;
        tt5.a.e("PanelDataParser", "PanelDataParser : deserialize fails: ", e, false);
        return new PanelData();
    L71:
        return new PanelData();
    L7:
        r1 = false;
        goto L8
    }
}
