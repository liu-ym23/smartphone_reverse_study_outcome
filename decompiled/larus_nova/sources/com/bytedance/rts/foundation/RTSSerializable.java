package com.bytedance.rts.foundation;

import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B!\b\u0016\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010!¢\u0006\u0004\b1\u00102B\u001d\b\u0016\u0012\b\u00100\u001a\u0004\u0018\u00010!\u0012\b\u0010/\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b1\u00103J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0014\u0010\u000f\u001a\u00020\u00042\n\u0010\u000e\u001a\u00060\fj\u0002`\rH\u0016J\b\u0010\u0010\u001a\u00020\u0004H\u0016JE\u0010\u001a\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\b2#\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0015J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0004H\u0016J\u0016\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0004H\u0016J\b\u0010 \u001a\u00020\u0004H\u0016R$\u0010#\u001a\u00020!2\u0006\u0010\"\u001a\u00020!8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R&\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0004X\u0084\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0011\u0010.\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b-\u0010&¨\u00064"}, d2 = {"Lcom/bytedance/rts/foundation/RTSSerializable;", "Ljava/io/Serializable;", "", "andParse", "", "doInit", "", "", "", "toJSON", "rts_afterToJSON", "rts_toJSONString", "Lorg/json/JSONObject;", "Lcom/bytedance/rts/foundation/RTSJSONMap;", "map", "mapping", "unmapping", ExifInterface.GPS_DIRECTION_TRUE, "", "maxLevel", "value", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "el", "elConv", "optMapList", "rts_afterInit", "rts_afterParse", "afterToJSON", "toJSONString", "afterInit", "afterParse", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "<set-?>", "rts_rawData", "Lcom/bytedance/rts/foundation/RTSJSONObject;", "getRts_rawData", "()Lcom/bytedance/rts/foundation/RTSJSONObject;", "removeRawData", "Z", "encodeData", "Ljava/util/Map;", "getEncodeData", "()Ljava/util/Map;", "getRawData", "rawData", "JSONString", "JSONObject", "<init>", "(Ljava/lang/String;Lcom/bytedance/rts/foundation/RTSJSONObject;)V", "(Lcom/bytedance/rts/foundation/RTSJSONObject;Ljava/lang/String;)V", "lib_release"}, k = 1, mv = {1, 7, 1})
public class RTSSerializable implements Serializable {
    private final Map<String, Object> encodeData;
    private boolean removeRawData;
    private RTSJSONObject rts_rawData;

    public void mapping(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
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
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L18
        Map<String, Object> r101 = toJSON();     // Catch: Throwable -> L18
        r101.putAll(afterToJSON());     // Catch: Throwable -> L18
        Iterator<Map.Entry<String, Object>> r102 = r101.entrySet().iterator();     // Catch: Throwable -> L18
    L4:
        if (r102.hasNext() == false) goto L8;
        Map.Entry<String, Object> r103 = r102.next();     // Catch: Throwable -> L18
        String r104 = r103.getKey();     // Catch: Throwable -> L18
        r100.put(r104, a(r103.getValue()));     // Catch: Throwable -> L20
        goto L4
    L8:
        Iterator<String> r105 = this.rts_rawData.getRawMap$lib_release().keys();     // Catch: Throwable -> L18
    L10:
        if (r105.hasNext() == false) goto L16;
        String r106 = r105.next();     // Catch: Throwable -> L18
        if (r101.containsKey(r106) == true) goto L10;
        r100.put(r106, a(this.rts_rawData.getRawMap$lib_release().opt(r106)));     // Catch: Throwable -> L21
        goto L10
    L16:
        return r100.toString(0);
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

    public static Object a(Object r100) {
        if ((r100 instanceof RTSSerializable) == false) goto L21;
        JSONObject r101 = new JSONObject();
        RTSSerializable r102 = (RTSSerializable) r100;
        Map<String, Object> r103 = r102.toJSON();
        r103.putAll(r102.afterToJSON());
        Iterator<Map.Entry<String, Object>> r104 = r103.entrySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Map.Entry<String, Object> r105 = r104.next();
        String r106 = r105.getKey();
        r101.put(r106, a(r105.getValue()));     // Catch: Throwable -> L10
        goto L6
    L11:
        Iterator<String> r107 = r102.rts_rawData.getRawMap$lib_release().keys();
    L13:
        if (r107.hasNext() == false) goto L19;
        String r108 = r107.next();
        if (r103.containsKey(r108) == true) goto L13;
        r101.put(r108, a(((RTSSerializable) r100).rts_rawData.getRawMap$lib_release().opt(r108)));     // Catch: Throwable -> L18
        goto L13
    L19:
        return r101;
    L21:
        if (TypeIntrinsics.isMutableList(r100) == false) goto L31;
        JSONArray r109 = new JSONArray();
        Iterator r110 = ((Iterable) r100).iterator();
    L24:
        if (r110.hasNext() == false) goto L29;
        r109.put(a(r110.next()));     // Catch: Throwable -> L28
        goto L24
    L29:
        return r109;
    L31:
        if (TypeIntrinsics.isMutableMap(r100) == false) goto L42;
        JSONObject r111 = new JSONObject();
        Iterator r112 = ((Map) r100).entrySet().iterator();
    L34:
        if (r112.hasNext() == false) goto L41;
        Map.Entry r113 = (Map.Entry) r112.next();
        Object r114 = r113.getKey();
        Object r115 = r113.getValue();
        if ((r114 instanceof String) == false) goto L34;
        if (r115 == null) goto L34;
        r111.put((String) r114, a(r115));     // Catch: Throwable -> L40
        goto L34
    L41:
        return r111;
    L42:
        return r100;
    }

    public final void doInit(boolean r100) {
        if (r100 == false) goto L4;
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

    public RTSSerializable(String r100, RTSJSONObject r101) {
        this.rts_rawData = new RTSJSONObject(new JSONObject());
        this.encodeData = new LinkedHashMap();
        if (r100 != null) goto L11;
        if (r101 == null) goto L14;
        this.rts_rawData = r101;
        return;
    L14:
        return;
    L11:
        this.rts_rawData = new RTSJSONObject(new JSONObject(r100));     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    public RTSSerializable(RTSJSONObject r100, String r101) {
        this(r101, r100);
    }

    public final <T> Object optMapList(int r100, Object r101, Function1<Object, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r102, "elConv");
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r100 > 0) goto L9;
        return r102.invoke(r101);
    L9:
        if ((r101 instanceof JSONArray) == false) goto L18;
        int r103 = 0;
        ArrayList r104 = j.k(new Object[0]);
        JSONArray r105 = (JSONArray) r101;
        int r106 = r105.length();
    L11:
        if (r103 >= r106) goto L16;
        Object r107 = optMapList(r100 - 1, r105.opt(r103), r102);
        if (r107 == null) goto L15;
        r104.add(r107);
    L15:
        r103 = r103 + 1;
        goto L11
    L16:
        return r104;
    L18:
        if ((r101 instanceof JSONObject) == false) goto L29;
        LinkedHashMap r108 = new LinkedHashMap();
        JSONObject r109 = (JSONObject) r101;
        Iterator r110 = SequencesKt.toList(SequencesKt.asSequence(r109.keys())).iterator();
    L21:
        if (r110.hasNext() == false) goto L28;
        String r111 = (String) r110.next();
        Object r112 = r109.opt(r111);
        if (r112 == null) goto L25;
        Object r113 = optMapList(r100 - 1, r112, r102);
    L26:
        if (r113 == null) goto L21;
        r108.put(r111, r113);
        goto L21
    L25:
        r113 = null;
        goto L26
    L28:
        return r108;
    L29:
        return null;
    }

    public /* synthetic */ RTSSerializable(String r100, RTSJSONObject r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
