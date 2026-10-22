package ipa;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f495326a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f495327b = null;

    public static final class a extends ByteArrayOutputStream {
        public a() {
        }

        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L5;
        boolean r100 = true;
    L6:
        f495326a = r100;
        f495327b = Charset.forName("UTF8");
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static Object a(ByteBuffer r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        r100.order(ByteOrder.nativeOrder());
        Object r101 = e(r100);
        if (r100.hasRemaining() == true) goto L9;
        return r101;
    L9:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static ByteBuffer b(Object r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r101 = new a();
        k(r101, r100);
        ByteBuffer r102 = ByteBuffer.allocateDirect(r101.size());
        r102.put(r101.a(), 0, r101.size());
        return r102;
    }

    public static final int d(ByteBuffer r100) {
        if (r100.hasRemaining() == false) goto L13;
        int r101 = r100.get() & UByte.MAX_VALUE;
        if (r101 >= 254) goto L7;
        return r101;
    L7:
        if (r101 != 254) goto L11;
        return r100.getChar();
    L11:
        return r100.getInt();
    L13:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static Object e(ByteBuffer r100) {
        if (r100.hasRemaining() == false) goto L33;
        int r101 = 0;
        switch(r100.get()) {
            case 0: goto L30;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L49;
            case 4: goto L48;
            case 5: goto L25;
            case 6: goto L24;
            case 7: goto L23;
            case 8: goto L22;
            case 9: goto L21;
            case 10: goto L20;
            case 11: goto L19;
            case 12: goto L16;
            case 13: goto L13;
            case 14: goto L40;
            case 15: goto L39;
            case 16: goto L38;
            case 17: goto L9;
            case 18: goto L8;
            default: goto L7;
        };
    L8:
        int r102 = d(r100);
        float[] r103 = new float[r102];
        c(r100, 4);
        r100.asFloatBuffer().get(r103);
        r100.position(r100.position() + (r102 * 4));
        return r103;
    L9:
        int r104 = d(r100);
        short[] r105 = new short[r104];
        c(r100, 2);
        r100.asShortBuffer().get(r105);
        r100.position(r100.position() + (r104 * 2));
        return r105;
    L13:
        int r106 = d(r100);
        HashMap r107 = new HashMap();
    L14:
        if (r101 >= r106) goto L52;
        r107.put(e(r100), e(r100));
        r101 = r101 + 1;
        goto L14
    L52:
        return r107;
    L16:
        int r108 = d(r100);
        ArrayList r109 = new ArrayList(r108);
    L17:
        if (r101 >= r108) goto L53;
        r109.add(e(r100));
        r101 = r101 + 1;
        goto L17
    L53:
        return r109;
    L19:
        int r110 = d(r100);
        double[] r111 = new double[r110];
        c(r100, 8);
        r100.asDoubleBuffer().get(r111);
        r100.position(r100.position() + (r110 * 8));
        return r111;
    L20:
        int r112 = d(r100);
        long[] r113 = new long[r112];
        c(r100, 8);
        r100.asLongBuffer().get(r113);
        r100.position(r100.position() + (r112 * 8));
        return r113;
    L21:
        int r114 = d(r100);
        int[] r115 = new int[r114];
        c(r100, 4);
        r100.asIntBuffer().get(r115);
        r100.position(r100.position() + (r114 * 4));
        return r115;
    L22:
        byte[] r116 = new byte[d(r100)];
        r100.get(r116);
        return r116;
    L23:
        byte[] r117 = new byte[d(r100)];
        r100.get(r117);
        return new String(r117, f495327b);
    L24:
        c(r100, 8);
        return Double.valueOf(r100.getDouble());
    L25:
        byte[] r118 = new byte[d(r100)];
        r100.get(r118);
        return new BigInteger(new String(r118, f495327b), 16);
    L30:
        return null;
    L7:
        throw new IllegalArgumentException("Message corrupted");
    L38:
        return Float.valueOf(r100.getFloat());
    L39:
        return Short.valueOf(r100.getShort());
    L40:
        return Byte.valueOf(r100.get());
    L48:
        return Long.valueOf(r100.getLong());
    L49:
        return Integer.valueOf(r100.getInt());
    L50:
        return Boolean.FALSE;
    L51:
        return Boolean.TRUE;
    L33:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static final void c(ByteBuffer r100, int r101) {
        int r102 = r100.position() % r101;
        if (r102 == 0) goto L6;
        r100.position((r100.position() + r101) - r102);
        return;
    }

    public static final void f(a r100, int r101) {
        int r102 = r100.size() % r101;
        if (r102 == 0) goto L8;
        int r103 = 0;
    L6:
        if (r103 >= (r101 - r102)) goto L10;
        r100.write(0);
        r103 = r103 + 1;
        goto L6
    L10:
        return;
    }

    public static final void g(a r100, int r101) {
        if (f495326a == false) goto L5;
        r100.write(r101);
        r100.write(r101 >>> 8);
        return;
    L5:
        r100.write(r101 >>> 8);
        r100.write(r101);
    }

    public static final void h(a r100, int r101) {
        if (f495326a == false) goto L5;
        r100.write(r101);
        r100.write(r101 >>> 8);
        r100.write(r101 >>> 16);
        r100.write(r101 >>> 24);
        return;
    L5:
        r100.write(r101 >>> 24);
        r100.write(r101 >>> 16);
        r100.write(r101 >>> 8);
        r100.write(r101);
    }

    public static final void i(a r100, long r110) {
        if (f495326a == false) goto L5;
        r100.write((byte) r110);
        r100.write((byte) (r110 >>> 8));
        r100.write((byte) (r110 >>> 16));
        r100.write((byte) (r110 >>> 24));
        r100.write((byte) (r110 >>> 32));
        r100.write((byte) (r110 >>> 40));
        r100.write((byte) (r110 >>> 48));
        r100.write((byte) (r110 >>> 56));
        return;
    L5:
        r100.write((byte) (r110 >>> 56));
        r100.write((byte) (r110 >>> 48));
        r100.write((byte) (r110 >>> 40));
        r100.write((byte) (r110 >>> 32));
        r100.write((byte) (r110 >>> 24));
        r100.write((byte) (r110 >>> 16));
        r100.write((byte) (r110 >>> 8));
        r100.write((byte) r110);
    }

    public static final void j(a r100, int r101) {
        if (r101 >= 254) goto L6;
        r100.write(r101);
        return;
    L6:
        if (r101 > 65535) goto L8;
        r100.write(254);
        g(r100, r101);
        return;
    L8:
        r100.write(255);
        h(r100, r101);
    }

    public static void k(a r100, Object r101) {
        int r102 = 0;
        if (r101 != null) goto L5;
    L102:
        r100.write(0);
        return;
    L5:
        if (r101.equals(null) == true) goto L102;
        int r103 = 2;
        if ((r101 instanceof Boolean) == false) goto L14;
        if (((Boolean) r101).booleanValue() == false) goto L12;
        r103 = 1;
    L12:
        r100.write(r103);
        return;
    L14:
        if ((r101 instanceof Number) == false) goto L42;
        if ((r101 instanceof Integer) == false) goto L19;
        r100.write(3);
        h(r100, ((Number) r101).intValue());
        return;
    L19:
        if ((r101 instanceof Short) == false) goto L22;
        r100.write(15);
        g(r100, ((Number) r101).intValue());
        return;
    L22:
        if ((r101 instanceof Byte) == false) goto L28;
        r100.write(14);
        int r104 = ((Number) r101).intValue();
        if (f495326a == false) goto L26;
        r100.write(r104);
        return;
    L26:
        r100.write(r104 >>> 24);
        return;
    L28:
        if ((r101 instanceof Long) == false) goto L31;
        r100.write(4);
        i(r100, ((Long) r101).longValue());
        return;
    L31:
        if ((r101 instanceof Float) == false) goto L34;
        r100.write(16);
        h(r100, Float.floatToIntBits(((Number) r101).floatValue()));
        return;
    L34:
        if ((r101 instanceof Double) == false) goto L37;
        r100.write(6);
        f(r100, 8);
        i(r100, Double.doubleToLongBits(((Number) r101).doubleValue()));
        return;
    L37:
        if ((r101 instanceof BigInteger) == false) goto L40;
        r100.write(5);
        byte[] r105 = ((BigInteger) r101).toString(16).getBytes(f495327b);
        j(r100, r105.length);
        r100.write(r105, 0, r105.length);
        return;
    L40:
        throw new IllegalArgumentException("Unsupported Number type: " + r101.getClass());
    L42:
        if ((r101 instanceof String) == false) goto L45;
        r100.write(7);
        byte[] r106 = ((String) r101).getBytes(f495327b);
        j(r100, r106.length);
        r100.write(r106, 0, r106.length);
        return;
    L45:
        if ((r101 instanceof byte[]) == false) goto L48;
        r100.write(8);
        byte[] r107 = (byte[]) r101;
        j(r100, r107.length);
        r100.write(r107, 0, r107.length);
        return;
    L48:
        if ((r101 instanceof int[]) == false) goto L53;
        r100.write(9);
        int[] r108 = (int[]) r101;
        j(r100, r108.length);
        f(r100, 4);
        int r109 = r108.length;
    L50:
        if (r102 >= r109) goto L126;
        h(r100, r108[r102]);
        r102 = r102 + 1;
        goto L50
    L126:
        return;
    L53:
        if ((r101 instanceof long[]) == false) goto L58;
        r100.write(10);
        long[] r110 = (long[]) r101;
        j(r100, r110.length);
        f(r100, 8);
        int r111 = r110.length;
    L55:
        if (r102 >= r111) goto L127;
        i(r100, r110[r102]);
        r102 = r102 + 1;
        goto L55
    L127:
        return;
    L58:
        if ((r101 instanceof double[]) == false) goto L63;
        r100.write(11);
        double[] r112 = (double[]) r101;
        j(r100, r112.length);
        f(r100, 8);
        int r113 = r112.length;
    L60:
        if (r102 >= r113) goto L128;
        i(r100, Double.doubleToLongBits(r112[r102]));
        r102 = r102 + 1;
        goto L60
    L128:
        return;
    L63:
        if ((r101 instanceof short[]) == false) goto L68;
        r100.write(17);
        short[] r114 = (short[]) r101;
        j(r100, r114.length);
        f(r100, 2);
        int r115 = r114.length;
    L65:
        if (r102 >= r115) goto L129;
        g(r100, r114[r102]);
        r102 = r102 + 1;
        goto L65
    L129:
        return;
    L68:
        if ((r101 instanceof float[]) == false) goto L73;
        r100.write(18);
        float[] r116 = (float[]) r101;
        j(r100, r116.length);
        f(r100, 4);
        int r117 = r116.length;
    L70:
        if (r102 >= r117) goto L130;
        h(r100, Float.floatToIntBits(r116[r102]));
        r102 = r102 + 1;
        goto L70
    L130:
        return;
    L73:
        if ((r101 instanceof List) == false) goto L79;
        r100.write(12);
        List r118 = (List) r101;
        j(r100, r118.size());
        Iterator r119 = r118.iterator();
    L76:
        if (r119.hasNext() == false) goto L131;
        k(r100, r119.next());
        goto L76
    L131:
        return;
    L79:
        if ((r101 instanceof Map) == false) goto L85;
        r100.write(13);
        Map r120 = (Map) r101;
        j(r100, r120.size());
        Iterator r121 = r120.entrySet().iterator();
    L82:
        if (r121.hasNext() == false) goto L132;
        Map.Entry r122 = (Map.Entry) r121.next();
        k(r100, r122.getKey());
        k(r100, r122.getValue());
        goto L82
    L132:
        return;
    L85:
        if ((r101 instanceof JSONObject) == false) goto L91;
        JSONObject r123 = (JSONObject) r101;
        r100.write(13);
        j(r100, r123.length());
        Iterator<String> r124 = r123.keys();
    L88:
        if (r124.hasNext() == false) goto L133;
        String r125 = r124.next();
        k(r100, r125);
        k(r100, r123.opt(r125));
        goto L88
    L133:
        return;
    L91:
        if ((r101 instanceof JSONArray) == false) goto L101;
        r100.write(12);
        JSONArray r126 = (JSONArray) r101;
        j(r100, r126.length());
    L94:
        if (r102 >= r126.length()) goto L134;
        k(r100, r126.opt(r102));     // Catch: Throwable -> L98
        r102 = r102 + 1;
    L98:
        th = move-exception;
        throw th;
    L134:
        return;
    L101:
        throw new IllegalArgumentException("Unsupported value: " + r101);
    }
}
