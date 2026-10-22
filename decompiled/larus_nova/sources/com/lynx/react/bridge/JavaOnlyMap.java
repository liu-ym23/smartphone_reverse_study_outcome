package com.lynx.react.bridge;

import androidx.camera.video.AudioStats;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.lynx.tasm.TemplateData;
import f6a.c;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class JavaOnlyMap extends HashMap<String, Object> implements ReadableMap, WritableMap {
    private static final String TAG = "JavaOnlyMap";

    public class a implements ReadableMapKeySetIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<String> f381441a;

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final boolean hasNextKey() {
            return this.f381441a.hasNext();
        }

        @Override // com.lynx.react.bridge.ReadableMapKeySetIterator
        public final String nextKey() {
            return this.f381441a.next();
        }

        public a(JavaOnlyMap r100) {
            this.f381441a = r100.keySet().iterator();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f381442a = null;

        static {
            int[] r100 = new int[ReadableType.values().length];
            f381442a = r100;
            r100[ReadableType.Null.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f381442a[ReadableType.Boolean.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f381442a[ReadableType.Int.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f381442a[ReadableType.Long.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f381442a[ReadableType.Number.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f381442a[ReadableType.String.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f381442a[ReadableType.Map.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f381442a[ReadableType.Array.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f381442a[ReadableType.ByteArray.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public HashMap<String, Object> asHashMap() {
        return this;
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

    public JSONObject toJSONObject() {
        JSONObject r100 = new JSONObject();
        if (size() != 0) goto L5;
        return r100;
    L5:
        Iterator r101 = keySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L22;
        String r102 = (String) r101.next();
        Object r103 = get(r102);
        if (getType(r102) == ReadableType.Map) goto L11;
        if (getType(r102) == ReadableType.Array) goto L14;
        if (getType(r102) == ReadableType.Null) goto L17;
        r100.putOpt(r102, r103);     // Catch: Exception -> L20
        goto L7
    L17:
        r100.putOpt(r102, JSONObject.NULL);     // Catch: Exception -> L20
        goto L7
    L14:
        r100.putOpt(r102, ((JavaOnlyArray) r103).toJSONArray());     // Catch: Exception -> L20
        goto L7
    L11:
        r100.putOpt(r102, ((JavaOnlyMap) r103).toJSONObject());     // Catch: Exception -> L20
    L20:
        e = move-exception;
        e.toString();
        goto L7
    L22:
        return r100;
    }

    private JavaOnlyMap shallowCopy() {
        return shallowCopy(this);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map, com.lynx.react.bridge.ReadableMap
    public int size() {
        return super.size();
    }

    public JavaOnlyMap() {
    }

    private JavaOnlyMap(Map r100) {
        super(r100);
    }

    public static JavaOnlyMap deepClone(ReadableMap r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L17;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        switch(b.f381442a[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L4;
        };
    L8:
        r101.putByteArray(r103, (byte[]) r100.getByteArray(r103).clone());
        goto L4
    L9:
        r101.putArray(r103, JavaOnlyArray.deepClone(r100.getArray(r103)));
        goto L4
    L10:
        r101.putMap(r103, deepClone(r100.getMap(r103)));
        goto L4
    L11:
        r101.putString(r103, r100.getString(r103));
        goto L4
    L12:
        r101.putDouble(r103, r100.getDouble(r103));
        goto L4
    L13:
        r101.putLong(r103, r100.getLong(r103));
        goto L4
    L14:
        r101.putInt(r103, r100.getInt(r103));
        goto L4
    L15:
        r101.putBoolean(r103, r100.getBoolean(r103));
        goto L4
    L16:
        r101.putNull(r103);
        goto L4
    L17:
        return r101;
    }

    public static JavaOnlyMap from(Map r100) {
        return new JavaOnlyMap(r100);
    }

    public static JavaOnlyMap shallowCopy(ReadableMap r100) {
        JavaOnlyMap r101 = new JavaOnlyMap();
        ReadableMapKeySetIterator r102 = r100.keySetIterator();
    L4:
        if (r102.hasNextKey() == false) goto L17;
        String r103 = r102.nextKey();
        ReadableType r104 = r100.getType(r103);
        switch(b.f381442a[r104.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L4;
        };
    L8:
        r101.putByteArray(r103, r100.getByteArray(r103));
        goto L4
    L9:
        r101.putArray(r103, (WritableArray) r100.getArray(r103));
        goto L4
    L10:
        r101.putMap(r103, (WritableMap) r100.getMap(r103));
        goto L4
    L11:
        r101.putString(r103, r100.getString(r103));
        goto L4
    L12:
        r101.putDouble(r103, r100.getDouble(r103));
        goto L4
    L13:
        r101.putLong(r103, r100.getLong(r103));
        goto L4
    L14:
        r101.putInt(r103, r100.getInt(r103));
        goto L4
    L15:
        r101.putBoolean(r103, r100.getBoolean(r103));
        goto L4
    L16:
        r101.putNull(r103);
        goto L4
    L17:
        return r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public ReadableArray getArray(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof ReadableArray) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ReadableArray.class.getName() + ", key: " + r100 + ", value: " + r101);
    L5:
        return (ReadableArray) r101;
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
        if ((r101 instanceof ReadableMap) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + ReadableMap.class.getName() + ", key: " + r100 + ", value: " + r101);
    L5:
        return (ReadableMap) r101;
    }

    @Override // com.lynx.react.bridge.ReadableMap
    public PiperData getPiperData(String r100) {
        Object r101 = get(r100);
        if ((r101 instanceof PiperData) == true) goto L5;
        if (r101 != null) goto L10;
        return null;
    L10:
        throw new ClassCastException(r101.getClass().getName() + " cannot be cast to " + PiperData.class.getName() + ", key: " + r100);
    L5:
        return (PiperData) r101;
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
        if ((r101 instanceof Number) == true) goto L54;
        if ((r101 instanceof Character) == true) goto L54;
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
        if ((r101 instanceof PiperData) == false) goto L44;
        return ReadableType.PiperData;
    L44:
        if ((r101 instanceof TemplateData) == false) goto L48;
        return ReadableType.TemplateData;
    L48:
        if ((r101 instanceof f6a.a) == false) goto L52;
        return ((f6a.a) r101).getType();
    L52:
        throw new IllegalArgumentException("Invalid value " + r101.toString() + " for key " + r100 + "contained in JavaOnlyMap");
    L54:
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
        putAll(r100.asHashMap());
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
    public PiperData getPiperData(String r100, PiperData r101) {
        Object r102 = get(r100);
        if ((r102 instanceof PiperData) == true) goto L5;
        return r101;
    L5:
        return (PiperData) r102;
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
    public void putPiperData(String r100, PiperData r101) {
        put(r100, r101);
    }

    @Override // com.lynx.react.bridge.WritableMap
    public void putString(String r100, String r101) {
        put(r100, r101);
    }
}
