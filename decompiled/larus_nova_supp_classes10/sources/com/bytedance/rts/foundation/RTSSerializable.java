package com.bytedance.rts.foundation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.SequencesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!¢\u0006\u0004\b1\u00102B\u001d\b\u0016\u0012\b\u00100\u001a\u0004\u0018\u00010!\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b1\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016JE\u0010\u001a\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\b2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0015J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R$\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b-\u0010&¨\u00064"}, d2 = {"Lcom/bytedance/rts/foundation/RTSSerializable;", "Ljava/io/Serializable;", "", "andParse", "", "doInit", "", "", "", "toJSON", "rts_afterToJSON", "rts_toJSONString", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "map", "mapping", "unmapping", "T", "", "maxLevel", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "el", "elConv", "optMapList", "rts_afterInit", "rts_afterParse", "afterToJSON", "toJSONString", "afterInit", "afterParse", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "<set-?>", "rts_rawData", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "getRts_rawData", "()Lcom/bytedance/rts/foundation/RTSJSONObject;", "removeRawData", "Z", "encodeData", "Ljava/util/Map;", "getEncodeData", "()Ljava/util/Map;", "getRawData", "rawData", "JSONString", "JSONObject", "<init>", "(Ljava/lang/String;Lcom/bytedance/rts/foundation/RTSJSONObject;)V", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "lib_release"}, k = 1, mv = {1, 7, 1})
public class RTSSerializable implements Serializable {
    private final Map<String, Object> encodeData;
    private boolean removeRawData;
    private RTSJSONObject rts_rawData;

    public void mapping(JSONObject r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
    }

    public void rts_afterInit() {
    }

    public void rts_afterParse() {
    }

    public void unmapping() {
    }

    public Map<String, Object> rts_afterToJSON() {
        return new LinkedHashMap();
    }

    public String rts_toJSONString() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L18
        Map<String, Object> r1 = toJSON();     // Catch: Throwable -> L18
        r1.putAll(afterToJSON());     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, Object>> r2 = r1.entrySet().iterator();     // Catch: Throwable -> L18
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Object> r3 = r2.next();     // Catch: Throwable -> L18
        String r4 = r3.getKey();     // Catch: Throwable -> L18
        r0.put(r4, a(r3.getValue()));     // Catch: Throwable -> L20
        goto L4
    L8:
        Iterator<String> r5 = this.rts_rawData.getRawMap$lib_release().keys();     // Catch: Throwable -> L18
    L10:
        if (r5.hasNext() == false) goto L16;
        String r6 = r5.next();     // Catch: Throwable -> L18
        if (r1.containsKey(r6) == true) goto L10;
        r0.put(r6, a(this.rts_rawData.getRawMap$lib_release().opt(r6)));     // Catch: Throwable -> L21
        goto L10
    L16:
        return r0.toString(0);
    L18:
        return null;
    }

    public Map<String, Object> toJSON() {
        this.encodeData.clear();
        unmapping();
        return MapsKt.toMutableMap(this.encodeData);
    }

    public Map<String, Object> afterToJSON() {
        return rts_afterToJSON();
    }

    public String toJSONString() {
        return rts_toJSONString();
    }

    public void afterInit() {
        rts_afterInit();
    }

    public void afterParse() {
        rts_afterParse();
    }

    public final Map<String, Object> getEncodeData() {
        return this.encodeData;
    }

    public final RTSJSONObject getRawData() {
        return this.rts_rawData;
    }

    public final RTSJSONObject getRts_rawData() {
        return this.rts_rawData;
    }

    public static Object a(Object r6) {
        if ((r6 instanceof RTSSerializable) == false) goto L21;
        JSONObject r0 = new JSONObject();
        RTSSerializable r1 = (RTSSerializable) r6;
        Map<String, Object> r2 = r1.toJSON();
        r2.putAll(r1.afterToJSON());
        Iterator<Map.Entry<String, Object>> r3 = r2.entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L11;
        Map.Entry<String, Object> r4 = r3.next();
        String r5 = r4.getKey();
        r0.put(r5, a(r4.getValue()));     // Catch: Throwable -> L10
        goto L6
    L11:
        Iterator<String> r7 = r1.rts_rawData.getRawMap$lib_release().keys();
    L13:
        if (r7.hasNext() == false) goto L19;
        String r8 = r7.next();
        if (r2.containsKey(r8) == true) goto L13;
        r0.put(r8, a(((RTSSerializable) r6).rts_rawData.getRawMap$lib_release().opt(r8)));     // Catch: Throwable -> L18
        goto L13
    L19:
        return r0;
    L21:
        if (TypeIntrinsics.isMutableList(r6) == false) goto L31;
        JSONArray r9 = new JSONArray();
        Iterator r10 = ((Iterable) r6).iterator();
    L24:
        if (r10.hasNext() == false) goto L29;
        r9.put(a(r10.next()));     // Catch: Throwable -> L28
        goto L24
    L29:
        return r9;
    L31:
        if (TypeIntrinsics.isMutableMap(r6) == false) goto L42;
        JSONObject r11 = new JSONObject();
        Iterator r12 = ((Map) r6).entrySet().iterator();
    L34:
        if (r12.hasNext() == false) goto L41;
        Map.Entry r13 = (Map.Entry) r12.next();
        Object r14 = r13.getKey();
        Object r15 = r13.getValue();
        if ((r14 instanceof String) == false) goto L34;
        if (r15 == null) goto L34;
        r11.put((String) r14, a(r15));     // Catch: Throwable -> L40
        goto L34
    L41:
        return r11;
    L42:
        return r6;
    }

    public final void doInit(boolean r2) {
        if (r2 == false) goto L4;
        mapping(getRawData().getRawMap$lib_release());
        afterParse();
    L6:
        if (this.removeRawData == false) goto L9;
        this.rts_rawData = new RTSJSONObject(new JSONObject());
        return;
    L9:
        return;
    L4:
        afterInit();
        goto L6
    }

    public RTSSerializable(String r3, RTSJSONObject r4) {
        this.rts_rawData = new RTSJSONObject(new JSONObject());
        this.encodeData = new LinkedHashMap();
        if (r3 != null) goto L11;
        if (r4 == null) goto L14;
        this.rts_rawData = r4;
        return;
    L14:
        return;
    L11:
        this.rts_rawData = new RTSJSONObject(new JSONObject(r3));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public RTSSerializable(RTSJSONObject r1, String r2) {
        this(r2, r1);
    }

    public final <T> Object optMapList(int r7, Object r8, Function1<Object, ? extends T> r9) {
        Intrinsics.checkNotNullParameter(r9, "elConv");
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r7 > 0) goto L9;
        return r9.invoke(r8);
    L9:
        if ((r8 instanceof JSONArray) == false) goto L18;
        int r0 = 0;
        ArrayList r1 = j.k(new Object[0]);
        JSONArray r10 = (JSONArray) r8;
        int r2 = r10.length();
    L11:
        if (r0 >= r2) goto L16;
        Object r3 = optMapList(r7 - 1, r10.opt(r0), r9);
        if (r3 == null) goto L15;
        r1.add(r3);
    L15:
        r0 = r0 + 1;
        goto L11
    L16:
        return r1;
    L18:
        if ((r8 instanceof JSONObject) == false) goto L29;
        LinkedHashMap r4 = new LinkedHashMap();
        JSONObject r11 = (JSONObject) r8;
        Iterator r5 = SequencesKt.toList(SequencesKt.asSequence(r11.keys())).iterator();
    L21:
        if (r5.hasNext() == false) goto L28;
        String r6 = (String) r5.next();
        Object r12 = r11.opt(r6);
        if (r12 == null) goto L25;
        Object r13 = optMapList(r7 - 1, r12, r9);
    L26:
        if (r13 == null) goto L21;
        r4.put(r6, r13);
        goto L21
    L25:
        r13 = null;
        goto L26
    L28:
        return r4;
    L29:
        return null;
    }

    public /* synthetic */ RTSSerializable(String r2, RTSJSONObject r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
