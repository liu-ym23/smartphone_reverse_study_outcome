package com.relax.relaxui.value;

import androidx.camera.video.AudioStats;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.react.bridge.PiperData;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import com.lynx.tasm.TemplateData;
import f6a.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {

    public class a implements ReadableMapKeySetIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<String> f405688a;

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final boolean hasNextKey() {
            return this.f405688a.hasNext();
        }

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final String nextKey() {
            return this.f405688a.next();
        }

        public a(JavaOnlyMap r100) {
            this.f405688a = r100.keySet().iterator();
        }
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String r100) {
        return null;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String r100, PiperData r101) {
        return null;
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putPiperData(String r100, PiperData r101) {
    }

    private static JavaOnlyMap create() {
        return new JavaOnlyMap();
    }

    public ArrayList<String> getKeys() {
        return new ArrayList(keySet());
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMapKeySetIterator keySetIterator() {
        return new a(this);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> toHashMap() {
        return new HashMap(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.lynx.react.bridge.ReadableMap
    public int size() {
        return super.size();
    }

    public JavaOnlyMap() {
    }

    public JavaOnlyMap(Map r100) {
        super(r100);
    }

    public static JavaOnlyMap from(Map r100) {
        return new JavaOnlyMap(r100);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyArray) == false) goto L7;
        return (JavaOnlyArray) r101;
    L7:
        if ((r101 instanceof com.lynx.react.bridge.JavaOnlyArray) == true) goto L9;
        if (r101 != null) goto L14;
        return null;
    L14:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ReadableArray.class.getName() + ", key: " + r100 + ", value: " + r101);
    L9:
        return new JavaOnlyArray((com.lynx.react.bridge.JavaOnlyArray) r101);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Boolean) == false) goto L7;
        return ((Boolean) r101).booleanValue();
    L7:
        if ((r101 instanceof String) == false) goto L15;
        String r102 = (String) r101;
        if (r102.equalsIgnoreCase("true") == false) goto L11;
    L12:
        return true;
    L11:
        if (r102.equalsIgnoreCase(BdpAppEventConstant.YES) == true) goto L12;
        return false;
    L15:
        if ((r101 instanceof Number) == true) goto L17;
        if (r101 != null) goto L24;
        throw new NullPointerException("key: " + r100);
    L24:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Boolean, key: " + r100 + ", value: " + r101);
    L17:
        if (((Number) r101).intValue() == 0) goto L26;
        return true;
    L26:
        return false;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof byte[]) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + byte[].class.getName() + ", key: " + r100 + ", value: " + r101);
    L5:
        return (byte[]) r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof ByteBuffer) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ByteBuffer.class.getName() + ", key: " + r100);
    L5:
        return (ByteBuffer) r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public double getDouble(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == false) goto L7;
        return ((Number) r101).doubleValue();
    L7:
        if ((r101 instanceof Boolean) == false) goto L14;
        if (((Boolean) r101).booleanValue() == false) goto L11;
        return 1.0d;
    L11:
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    L14:
        if ((r101 instanceof String) == true) goto L24;
        if (r101 != null) goto L23;
        throw new NullPointerException("key: " + r100);
    L23:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r100 + ", value: " + r101);
    L24:
        return CastDoubleProtector.parseDouble((String) r101);
    L18:
        throw new IllegalArgumentException("String cannot be cast to double, key: " + r100 + ", value: " + r101);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public f6a.a getDynamic(String r100) {
        return new c(this, r100);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public int getInt(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == false) goto L7;
        return ((Number) r101).intValue();
    L7:
        if ((r101 instanceof Boolean) == false) goto L11;
        return ((Boolean) r101).booleanValue() ? 1 : 0;
    L11:
        if ((r101 instanceof String) == true) goto L21;
        if (r101 != null) goto L20;
        throw new NullPointerException("key: " + r100);
    L20:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Number, key: " + r100 + ", value: " + r101);
    L21:
        return CastIntegerProtector.parseInt((String) r101);
    L15:
        throw new IllegalArgumentException("String cannot be cast to int, key: " + r100 + ", value: " + r101);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public long getLong(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof Number) == false) goto L7;
        return ((Number) r101).longValue();
    L7:
        if ((r101 instanceof Boolean) == false) goto L14;
        if (((Boolean) r101).booleanValue() == false) goto L11;
        return 1;
    L11:
        return 0;
    L14:
        if ((r101 instanceof String) == true) goto L24;
        if (r101 != null) goto L23;
        throw new NullPointerException("key: " + r100);
    L23:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to java.lang.Long, key: " + r100 + ", value: " + r101);
    L24:
        return CastLongProtector.parseLong((String) r101);
    L18:
        throw new IllegalArgumentException("String cannot be cast to long int, key: " + r100 + ", value: " + r101);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof JavaOnlyMap) == false) goto L7;
        return (JavaOnlyMap) r101;
    L7:
        if ((r101 instanceof com.lynx.react.bridge.JavaOnlyMap) == true) goto L9;
        if (r101 != null) goto L14;
        return null;
    L14:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r100 + ", value: " + r101);
    L9:
        return new JavaOnlyMap((com.lynx.react.bridge.JavaOnlyMap) r101);
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
    public TemplateData getTemplateData(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof TemplateData) == true) goto L5;
        return null;
    L5:
        return (TemplateData) r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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
        if ((r101 instanceof Number) == true) goto L46;
        if ((r101 instanceof Character) == true) goto L46;
        if ((r101 instanceof String) == false) goto L24;
        return ReadableType.String;
    L24:
        if ((r101 instanceof Boolean) == false) goto L28;
        return ReadableType.Boolean;
    L28:
        if ((r101 instanceof ReadableMap) == false) goto L32;
        return ReadableType.Map;
    L32:
        if ((r101 instanceof ReadableArray) == false) goto L36;
        return ReadableType.Array;
    L36:
        if ((r101 instanceof byte[]) == false) goto L40;
        return ReadableType.ByteArray;
    L40:
        if ((r101 instanceof f6a.a) == false) goto L44;
        return ((f6a.a) r101).getType();
    L44:
        throw new IllegalArgumentException("Invalid value " + r101.toString() + " for key " + r100 + "contained in JavaOnlyMap");
    L46:
        return ReadableType.Number;
    }

    public int getTypeIndex(String r100) {
        return getType(r100).ordinal();
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean hasKey(String r100) {
        return containsKey(r100);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean isNull(String r100) {
        if (get(r100) != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void merge(ReadableMap r100) {
        putAll((JavaOnlyMap) r100);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putNull(String r100) {
        put(r100, null);
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String r100, ReadableArray r101) {
        Object r102 = get(r100);
        if ((r102 instanceof ReadableArray) == true) goto L5;
        return r101;
    L5:
        return (ReadableArray) r102;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public boolean getBoolean(String r100, boolean r101) {
        Object r102 = get(r100);
        if ((r102 instanceof Boolean) == false) goto L7;
        return ((Boolean) r102).booleanValue();
    L7:
        if ((r102 instanceof Number) == false) goto L14;
        if (((Number) r102).intValue() != 0) goto L27;
        return false;
    L27:
        return true;
    L14:
        if ((r102 instanceof String) == false) goto L26;
        String r103 = (String) r102;
        if (r103.equalsIgnoreCase("true") == false) goto L18;
    L25:
        return true;
    L18:
        if (r103.equalsIgnoreCase(BdpAppEventConstant.YES) == true) goto L25;
        if (r103.equalsIgnoreCase("false") == false) goto L23;
    L24:
        return false;
    L23:
        if (r103.equalsIgnoreCase(BdpAppEventConstant.NO) == true) goto L24;
    L26:
        return r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public byte[] getByteArray(String r100, byte[] r101) {
        Object r102 = get(r100);
        if ((r102 instanceof byte[]) == true) goto L5;
        return r101;
    L5:
        return (byte[]) r102;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ByteBuffer getByteBuffer(String r100, ByteBuffer r101) {
        Object r102 = get(r100);
        if ((r102 instanceof ByteBuffer) == true) goto L5;
        return r101;
    L5:
        return (ByteBuffer) r102;
    }

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
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

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableMap getMap(String r100, ReadableMap r101) {
        Object r102 = get(r100);
        if ((r102 instanceof ReadableMap) == true) goto L5;
        return r101;
    L5:
        return (ReadableMap) r102;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public String getString(String r100, String r101) {
        Object r102 = get(r100);
        if ((r102 instanceof String) == false) goto L7;
        return (String) r102;
    L7:
        if ((r102 instanceof Boolean) == false) goto L14;
        if (((Boolean) r102).booleanValue() == false) goto L11;
        return "true";
    L11:
        return "false";
    L14:
        if ((r102 instanceof Number) == true) goto L16;
        return r101;
    L16:
        return ((Number) r102).toString();
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putArray(String r100, WritableArray r101) {
        put(r100, r101);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putBoolean(String r100, boolean r101) {
        put(r100, Boolean.valueOf(r101));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArray(String r100, byte[] r101) {
        put(r100, r101);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteArrayAsString(byte[] r100, byte[] r101) {
        put(new String(r100), new String(r101));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putByteBuffer(String r100, ByteBuffer r101) {
        put(r100, r101);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putDouble(String r100, double r101) {
        put(r100, Double.valueOf(r101));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putInt(String r100, int r101) {
        put(r100, Integer.valueOf(r101));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putLong(String r100, long r101) {
        put(r100, Long.valueOf(r101));
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putMap(String r100, WritableMap r101) {
        put(r100, r101);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putString(String r100, String r101) {
        put(r100, r101);
    }
}
