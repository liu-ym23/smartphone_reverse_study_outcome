package com.lynx.animax.base.bridge;

import androidx.camera.video.AudioStats;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import r4a.a;

/* JADX INFO: loaded from: classes32.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap {
    @Override // com.lynx.animax.base.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    public JavaOnlyMap() {
    }

    public JavaOnlyMap(Map r100) {
        super(r100);
    }

    public static JavaOnlyMap from(Map r100) {
        return new JavaOnlyMap(r100);
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public a getArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyArray) == false) goto L7;
        return (JavaOnlyArray) r101;
    L7:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + a.class.getName() + ", key: " + r100 + ", value: " + r101);
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public String getString(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof String) == false) goto L7;
        return (String) r101;
    L7:
        if ((r101 instanceof Boolean) == false) goto L14;
        if (((Boolean) r101).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    L14:
        if ((r101 instanceof Number) == true) goto L16;
        if (r101 != null) goto L21;
        return null;
    L21:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.String, key: " + r100 + ", value: " + r101);
    L16:
        return ((Number) r101).toString();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public ReadableType getType(String r100) {
        Object r101 = get(r100);
        if (r101 != null) goto L7;
        return ReadableType.Null;
    L7:
        if ((r101 instanceof Integer) == false) goto L11;
        return ReadableType.Int;
    L11:
        if ((r101 instanceof Long) == false) goto L15;
        return ReadableType.Long;
    L15:
        if ((r101 instanceof Number) == true) goto L38;
        if ((r101 instanceof Character) == true) goto L38;
        if ((r101 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r101 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r101 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r101 instanceof a) == false) goto L36;
        return ReadableType.Array;
    L36:
        throw new IllegalArgumentException("Invalid value " + r101.toString() + " for key " + r100 + "contained in JavaOnlyMap");
    L38:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r100) {
        return getType(r100).ordinal();
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public double getDouble(String r100, double r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == false) goto L7;
        return ((Number) r102).doubleValue();
    L7:
        if ((r102 instanceof Boolean) == false) goto L14;
        if (((Boolean) r102).booleanValue() == false) goto L11;
        return 1.0d;
    L11:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L14:
        if ((r102 instanceof String) == true) goto L20;
    L19:
        return r101;
    L20:
        return CastDoubleProtector.parseDouble((String) r102);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public int getInt(String r100, int r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == false) goto L7;
        return ((Number) r102).intValue();
    L7:
        if ((r102 instanceof Boolean) == false) goto L11;
        return ((Boolean) r102).booleanValue() ? 1 : 0;
    L11:
        if ((r102 instanceof String) == true) goto L17;
    L16:
        return r101;
    L17:
        return CastIntegerProtector.parseInt((String) r102);
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // com.lynx.animax.base.bridge.ReadableMap
    public long getLong(String r100, long r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Number) == false) goto L7;
        return ((Number) r102).longValue();
    L7:
        if ((r102 instanceof Boolean) == false) goto L14;
        if (((Boolean) r102).booleanValue() == false) goto L11;
        return 1;
    L11:
        return 0;
    L14:
        if ((r102 instanceof String) == true) goto L20;
    L19:
        return r101;
    L20:
        return CastLongProtector.parseLong((String) r102);
    L17:
        e = move-exception;
        e.printStackTrace();
        goto L19
    }

    public void putArray(String r100, JavaOnlyArray r101) {
        put(r100, r101);
    }

    public void putByteArrayAsString(byte[] r100, byte[] r101) {
        put(new String(r100), new String(r101));
    }

    public void putDouble(String r100, double r101) {
        put(r100, Double.valueOf(r101));
    }

    public void putInt(String r100, int r101) {
        put(r100, Integer.valueOf(r101));
    }

    public void putString(String r100, String r101) {
        put(r100, r101);
    }
}
