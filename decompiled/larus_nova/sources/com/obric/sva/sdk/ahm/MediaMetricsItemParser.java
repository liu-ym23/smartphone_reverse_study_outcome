package com.obric.sva.sdk.ahm;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MediaMetricsItemParser {
    private static final String TAG = "MediaMetricsItemParser";
    private static final byte TYPE_CSTRING = 4;
    private static final byte TYPE_DOUBLE = 3;
    private static final byte TYPE_INT32 = 1;
    private static final byte TYPE_INT64 = 2;
    private static final byte TYPE_NONE = 0;
    private static final byte TYPE_RATE = 5;

    public static class MediaMetricsItem {
        public String key;
        public int pid;
        public Map<String, Object> properties;
        public long timestamp;
        public int uid;

        public String toString() {
            return "MediaMetricsItem{key='" + this.key + "', pid=" + this.pid + ", uid=" + this.uid + ", timestamp=" + this.timestamp + ", properties=" + this.properties + '}';
        }

        public MediaMetricsItem() {
            this.properties = new HashMap();
        }
    }

    public MediaMetricsItemParser() {
    }

    public static String extractJsonData(byte[] r100) {
        MediaMetricsItem r101 = parse(r100);
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.properties.containsKey("jsonData") == false) goto L12;
        Object r102 = r101.properties.get("jsonData");
        if ((r102 instanceof String) == true) goto L9;
        return null;
    L9:
        return (String) r102;
    L12:
        return null;
    }

    public static JSONObject extractJsonObject(byte[] r100) {
        String r101 = extractJsonData(r100);
        if (r101 != null) goto L9;
        return null;
    L9:
        return new JSONObject(r101);
    L11:
        return null;
    }

    public static MediaMetricsItem parse(byte[] r100) {
        if (r100 != null) goto L5;
    L18:
        return null;
    L5:
        if (r100.length == 0) goto L18;
        MediaMetricsItem r101 = new MediaMetricsItem();
        ByteBuffer r102 = ByteBuffer.wrap(r100);
        r102.order(ByteOrder.LITTLE_ENDIAN);
        r102.getInt();     // Catch: Exception -> L19
        int r103 = r102.getInt();     // Catch: Exception -> L19
        r102.getShort();     // Catch: Exception -> L19
        byte[] r104 = new byte[r102.getShort() - 1];     // Catch: Exception -> L19
        r102.get(r104);     // Catch: Exception -> L19
        r102.get();     // Catch: Exception -> L19
        r101.key = new String(r104);     // Catch: Exception -> L19
        r101.pid = r102.getInt();     // Catch: Exception -> L19
        r101.uid = r102.getInt();     // Catch: Exception -> L19
        r101.timestamp = r102.getLong();     // Catch: Exception -> L19
        if (r102.position() >= r103) goto L11;
        r102.position(r103);     // Catch: Exception -> L19
    L11:
        int r105 = r102.getInt();     // Catch: Exception -> L19
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L17;
        Object[] r107 = readProperty(r102);     // Catch: Exception -> L19
        if (r107 == null) goto L16;
        String r108 = (String) r107[0];     // Catch: Exception -> L19
        Object r109 = r107[1];     // Catch: Exception -> L19
        r101.properties.put(r108, r109);     // Catch: Exception -> L19
        Objects.toString(r109);     // Catch: Exception -> L19
    L16:
        r106 = r106 + 1;
        goto L12
    L17:
        return r101;
    }

    private static Object[] readProperty(ByteBuffer r110) {
        int r100 = r110.position() + (r110.getShort() & 65535);     // Catch: Exception -> L31
        byte r101 = r110.get();     // Catch: Exception -> L31
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L31
    L4:
        byte r103 = r110.get();     // Catch: Exception -> L31
        if (r103 == 0) goto L7;
        r102.append((char) r103);     // Catch: Exception -> L31
        goto L4
    L7:
        String r104 = r102.toString();     // Catch: Exception -> L31
        if (r101 == 1) goto L25;
        if (r101 != 2) goto L11;
        Object r105 = Long.valueOf(r110.getLong());     // Catch: Exception -> L31
    L27:
        if (r110.position() >= r100) goto L29;
        r110.position(r100);     // Catch: Exception -> L31
    L29:
        Objects.toString(r105);     // Catch: Exception -> L31
        return new Object[]{r104, r105};
    L11:
        if (r101 != 3) goto L13;
        r105 = Double.valueOf(r110.getDouble());     // Catch: Exception -> L31
        goto L27
    L13:
        if (r101 != 4) goto L15;
        StringBuilder r106 = new StringBuilder();     // Catch: Exception -> L31
    L19:
        byte r107 = r110.get();     // Catch: Exception -> L31
        if (r107 == 0) goto L22;
        r106.append((char) r107);     // Catch: Exception -> L31
        goto L19
    L22:
        r105 = r106.toString();     // Catch: Exception -> L31
        goto L27
    L15:
        if (r101 == 5) goto L17;
        r105 = null;
        goto L27
    L17:
        r105 = new long[]{r110.getLong(), r110.getLong()};     // Catch: Exception -> L31
        goto L27
    L25:
        r105 = Integer.valueOf(r110.getInt());     // Catch: Exception -> L31
    L31:
        return null;
    }
}
