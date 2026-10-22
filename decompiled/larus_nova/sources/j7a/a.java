package j7a;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f497652a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f497653b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f497654c = null;

    /* JADX INFO: renamed from: j7a.a$a, reason: collision with other inner class name */
    public static final class C6401a extends ByteArrayOutputStream {
        public C6401a() {
        }

        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public a() {
    }

    static {
        f497652a = new a();
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) goto L5;
        boolean r100 = true;
    L6:
        f497653b = r100;
        f497654c = Charset.forName("UTF8");
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static Object a(ByteBuffer r100) {
        TraceEvent.beginSection("LepusBuffer::DecodeMessage");
        if (r100 != null) goto L18;
        TraceEvent.endSection("LepusBuffer::DecodeMessage");
        return null;
    L18:
        r100.order(ByteOrder.nativeOrder());     // Catch: IllegalArgumentException -> L12
        Object r101 = e(r100);     // Catch: IllegalArgumentException -> L12
        if (r100.hasRemaining() == true) goto L11;
        TraceEvent.endSection("LepusBuffer::DecodeMessage");     // Catch: IllegalArgumentException -> L12
        return r101;
    L11:
        throw new IllegalArgumentException("Message corrupted");     // Catch: IllegalArgumentException -> L12
    L12:
        e = move-exception;
        LynxError r102 = new LynxError(e.toString(), -3);
        if (LynxEnv.inst().getLynxViewClient() == null) goto L16;
        LynxEnv.inst().getLynxViewClient().onReceivedError(r102);
    L16:
        TraceEvent.endSection("LepusBuffer::DecodeMessage");
        return null;
    }

    public static ByteBuffer b(Object r100) {
        TraceEvent.beginSection("LepusBuffer::EncodeMessage");
        if (r100 != null) goto L6;
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return null;
    L6:
        C6401a r101 = new C6401a();
        f(r101, r100, new LinkedList());     // Catch: IllegalArgumentException -> L10
        ByteBuffer r102 = ByteBuffer.allocateDirect(r101.size());
        r102.put(r101.a(), 0, r101.size());
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return r102;
    L10:
        e = move-exception;
        LynxError r103 = new LynxError(e.toString(), -3);
        LynxEnv.inst().getLynxViewClient().onReceivedError(r103);
        LLog.e("LepusBuffer", r103.toString());
        TraceEvent.endSection("LepusBuffer::EncodeMessage");
        return null;
    }

    public static void c(ByteBuffer r100) {
        int r101 = r100.position() % 8;
        if (r101 == 0) goto L6;
        r100.position((r100.position() + 8) - r101);
        return;
    }

    public static int d(ByteBuffer r100) {
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.HashMap] */
    public static Object e(ByteBuffer r100) {
        if (r100.hasRemaining() == false) goto L27;
        byte r101 = r100.get();
        if (r101 == 100) goto L24;
        int r102 = 0;
        switch(r101) {
            case 0: goto L24;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L14;
            case 8: goto L11;
            case 9: goto L10;
            default: goto L9;
        };
    L10:
        byte[] r103 = new byte[d(r100)];
        r100.get(r103);
        return r103;
    L11:
        int r104 = d(r100);
        ?? r105 = new HashMap();
    L12:
        if (r102 >= r104) goto L31;
        r105.put(e(r100), e(r100));
        r102 = r102 + 1;
    L31:
        return r105;
    L14:
        int r106 = d(r100);
        r105 = new ArrayList(r106);
    L15:
        if (r102 >= r106) goto L31;
        r105.add(e(r100));
        r102 = r102 + 1;
        goto L15
    L18:
        byte[] r107 = new byte[d(r100)];
        r100.get(r107);
        return new String(r107, f497654c);
    L19:
        c(r100);
        return Double.valueOf(r100.getDouble());
    L20:
        c(r100);
        return Long.valueOf(r100.getLong());
    L21:
        c(r100);
        return Integer.valueOf(r100.getInt());
    L9:
        throw new IllegalArgumentException("Message corrupted");
    L36:
        return Boolean.FALSE;
    L37:
        return Boolean.TRUE;
    L24:
        return null;
    L27:
        throw new IllegalArgumentException("Message corrupted");
    }

    public static boolean g(Collection<Object> r100, Object r101) {
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator<Object> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        if (r101 != r102.next()) goto L7;
        return true;
    L12:
        return false;
    }

    public static void h(C6401a r100, int r101) {
        if (f497653b == false) goto L5;
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

    public static void i(C6401a r100, long r110) {
        if (f497653b == false) goto L5;
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

    public static void j(C6401a r100, int r101) {
        if (r101 >= 254) goto L6;
        r100.write(r101);
        return;
    L6:
        if (r101 > 65535) goto L11;
        r100.write(254);
        if (f497653b == false) goto L10;
        r100.write(r101);
        r100.write(r101 >>> 8);
        return;
    L10:
        r100.write(r101 >>> 8);
        r100.write(r101);
        return;
    L11:
        r100.write(255);
        h(r100, r101);
    }

    public static void f(C6401a r100, Object r101, LinkedList r102) {
        int r103 = 0;
        if (r101 != null) goto L5;
    L106:
        r100.write(0);
        return;
    L5:
        if (r101.equals(null) == true) goto L106;
        if ((r101 instanceof Boolean) == false) goto L15;
        if (((Boolean) r101).booleanValue() == false) goto L12;
        int r104 = 1;
    L13:
        r100.write(r104);
        return;
    L12:
        r104 = 2;
        goto L13
    L15:
        if ((r101 instanceof Number) == false) goto L41;
        if ((r101 instanceof Integer) == false) goto L19;
    L39:
        r100.write(3);
        h(r100, ((Number) r101).intValue());
        return;
    L19:
        if ((r101 instanceof Short) == true) goto L39;
        if ((r101 instanceof Byte) == true) goto L39;
        if ((r101 instanceof Long) == false) goto L27;
        r100.write(4);
        i(r100, ((Long) r101).longValue());
        return;
    L27:
        if ((r101 instanceof Float) == false) goto L29;
    L32:
        r100.write(5);
        int r105 = r100.size() % 8;
        if (r105 == 0) goto L38;
        int r106 = 0;
    L36:
        if (r106 >= (8 - r105)) goto L38;
        r100.write(0);
        r106 = r106 + 1;
    L38:
        i(r100, Double.doubleToLongBits(((Number) r101).doubleValue()));
        return;
    L29:
        if ((r101 instanceof Double) == true) goto L32;
        r100.write(0);
        LLog.e("LepusBuffer", "Unsupported Number type: " + r101.getClass() + " value: " + r101);
        return;
    L41:
        if ((r101 instanceof String) == false) goto L44;
        r100.write(6);
        byte[] r107 = ((String) r101).getBytes(f497654c);
        j(r100, r107.length);
        r100.write(r107, 0, r107.length);
        return;
    L44:
        if ((r101 instanceof List) == false) goto L57;
        List r108 = (List) r101;
        if (r108.isEmpty() == false) goto L48;
    L51:
        r102.addLast(r101);
        r100.write(7);
        j(r100, r108.size());
        Iterator r109 = r108.iterator();
    L53:
        if (r109.hasNext() == false) goto L55;
        f(r100, r109.next(), r102);
        goto L53
    L55:
        r102.removeLast();
        return;
    L48:
        if (g(r102, r101) == false) goto L51;
        r100.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle array!"));
        return;
    L57:
        if ((r101 instanceof Map) == false) goto L70;
        Map r110 = (Map) r101;
        if (r110.isEmpty() == false) goto L61;
    L64:
        r102.addLast(r101);
        r100.write(8);
        j(r100, r110.size());
        Iterator r111 = r110.entrySet().iterator();
    L66:
        if (r111.hasNext() == false) goto L68;
        Map.Entry r112 = (Map.Entry) r111.next();
        f(r100, r112.getKey(), r102);
        f(r100, r112.getValue(), r102);
        goto L66
    L68:
        r102.removeLast();
        return;
    L61:
        if (g(r102, r101) == false) goto L64;
        r100.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle dict!"));
        return;
    L70:
        if ((r101 instanceof JSONObject) == false) goto L83;
        JSONObject r113 = (JSONObject) r101;
        if (r113.length() > 0) goto L74;
    L77:
        r102.addLast(r101);
        r100.write(8);
        j(r100, r113.length());
        Iterator<String> r114 = r113.keys();
    L79:
        if (r114.hasNext() == false) goto L81;
        String r115 = r114.next();
        f(r100, r115, r102);
        f(r100, r113.opt(r115), r102);
        goto L79
    L81:
        r102.removeLast();
        return;
    L74:
        if (g(r102, r101) == false) goto L77;
        r100.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONObject!"));
        return;
    L83:
        if ((r101 instanceof JSONArray) == false) goto L100;
        JSONArray r116 = (JSONArray) r101;
        if (r116.length() > 0) goto L87;
    L90:
        r102.addLast(r101);
        r100.write(7);
        j(r100, r116.length());
    L92:
        if (r103 >= r116.length()) goto L98;
        f(r100, r116.opt(r103), r102);     // Catch: Throwable -> L96
        r103 = r103 + 1;
    L96:
        th = move-exception;
        throw th;
    L98:
        r102.removeLast();
        return;
    L87:
        if (g(r102, r101) == false) goto L90;
        r100.write(0);
        LLog.DTHROW(new IllegalArgumentException("writeValue has cycle JSONArray!"));
        return;
    L100:
        if ((r101 instanceof byte[]) == false) goto L103;
        r100.write(9);
        byte[] r117 = (byte[]) r101;
        j(r100, r117.length);
        r100.write(r117, 0, r117.length);
        return;
    L103:
        if ((r101 instanceof TemplateData) == false) goto L105;
        TemplateData r118 = (TemplateData) r101;
        r118.flush();
        r100.write(10);
        i(r100, r118.getNativePtr());
        return;
    L105:
        r100.write(0);
        LLog.e("LepusBuffer", "Unsupported type: " + r101.getClass() + " value: " + r101);
    }
}
