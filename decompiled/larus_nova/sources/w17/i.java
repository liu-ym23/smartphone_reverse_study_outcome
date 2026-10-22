package w17;

import com.bytedance.memory.shrink.BaseType;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.UByte;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f557940a = null;

        static {
            int[] r100 = new int[BaseType.values().length];
            f557940a = r100;
            r100[BaseType.OBJECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            f557940a[BaseType.BOOLEAN.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            f557940a[BaseType.CHAR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            f557940a[BaseType.FLOAT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            f557940a[BaseType.DOUBLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            f557940a[BaseType.BYTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            f557940a[BaseType.SHORT.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            f557940a[BaseType.INT.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            f557940a[BaseType.LONG.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    public static int a(InputStream r100) throws IOException {
        int r101 = r100.read();
        int r102 = r100.read();
        int r103 = r100.read();
        int r104 = r100.read();
        if ((((r101 | r102) | r103) | r104) < 0) goto L7;
        return (((r101 << 24) + (r102 << 16)) + (r103 << 8)) + r104;
    L7:
        throw new EOFException();
    }

    public static long b(InputStream r100) throws IOException {
        byte[] r101 = new byte[8];
        d(r100, r101, 8);
        return (((((((((long) r101[0]) << 56) + (((long) (r101[1] & UByte.MAX_VALUE)) << 48)) + (((long) (r101[2] & UByte.MAX_VALUE)) << 40)) + (((long) (r101[3] & UByte.MAX_VALUE)) << 32)) + (((long) (r101[4] & UByte.MAX_VALUE)) << 24)) + ((long) ((r101[5] & UByte.MAX_VALUE) << 16))) + ((long) ((r101[6] & UByte.MAX_VALUE) << 8))) + ((long) (r101[7] & UByte.MAX_VALUE));
    }

    public static short c(InputStream r100) throws IOException {
        int r101 = r100.read();
        int r102 = r100.read();
        if ((r101 | r102) < 0) goto L7;
        return (short) (r102 | (r101 << 8));
    L7:
        throw new EOFException();
    }

    public static e e(InputStream r100, int r101) throws IOException {
        byte[] r102 = new byte[r101];
        d(r100, r102, r101);
        return new e(r102);
    }

    public static void g(InputStream r100, long r101) throws IOException {
        long r102 = 0;
    L4:
        if (r102 >= r101) goto L10;
        long r103 = r100.skip(r101 - r102);
        if (r103 < 0) goto L9;
        r102 = r102 + r103;
        goto L4
    L9:
        throw new EOFException();
    }

    public static void h(OutputStream r100, long r101) throws IOException {
        byte[] r102 = new byte[4096];
        int r103 = 0;
    L4:
        if (r103 >= (r101 >> 12)) goto L6;
        r100.write(r102);
        r103 = r103 + 1;
        goto L4
    L6:
        r100.write(r102, 0, (int) (r101 & 4095));
    }

    public static void i(OutputStream r100, int r101) throws IOException {
        r100.write((r101 >>> 24) & 255);
        r100.write((r101 >>> 16) & 255);
        r100.write((r101 >>> 8) & 255);
        r100.write(r101 & 255);
    }

    public static void j(OutputStream r100, long r101) throws IOException {
        r100.write(new byte[]{(byte) (r101 >>> 56), (byte) (r101 >>> 48), (byte) (r101 >>> 40), (byte) (r101 >>> 32), (byte) (r101 >>> 24), (byte) (r101 >>> 16), (byte) (r101 >>> 8), (byte) r101}, 0, 8);
    }

    public static void k(OutputStream r100, int r101) throws IOException {
        r100.write((r101 >>> 8) & 255);
        r100.write(r101 & 255);
    }

    public static void l(OutputStream r100, Object r101) throws IOException {
        if (r101 == null) goto L58;
        if ((r101 instanceof e) == false) goto L7;
        r100.write(((e) r101).f557929a);
        return;
    L7:
        if ((r101 instanceof Boolean) == false) goto L9;
    L55:
        r100.write(0);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r101.getClass()) == true) goto L55;
        if ((r101 instanceof Character) == false) goto L14;
    L54:
        k(r100, 0);
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r101.getClass()) == true) goto L54;
        if ((r101 instanceof Float) == false) goto L19;
    L53:
        i(r100, 0);
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r101.getClass()) == true) goto L53;
        if ((r101 instanceof Double) == false) goto L24;
    L52:
        j(r100, 0);
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r101.getClass()) == true) goto L52;
        if ((r101 instanceof Byte) == false) goto L29;
    L51:
        r100.write(0);
        return;
    L29:
        if (Byte.TYPE.isAssignableFrom(r101.getClass()) == true) goto L51;
        if ((r101 instanceof Short) == false) goto L34;
    L50:
        k(r100, 0);
        return;
    L34:
        if (Short.TYPE.isAssignableFrom(r101.getClass()) == true) goto L50;
        if ((r101 instanceof Integer) == false) goto L39;
    L49:
        i(r100, 0);
        return;
    L39:
        if (Integer.TYPE.isAssignableFrom(r101.getClass()) == true) goto L49;
        if ((r101 instanceof Long) == false) goto L44;
    L48:
        j(r100, 0);
        return;
    L44:
        if (Long.TYPE.isAssignableFrom(r101.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: ".concat(r101.getClass().getName()));
    L58:
        throw new IllegalArgumentException("value is null.");
    }

    public static void m(OutputStream r100, Object r101) throws IOException {
        if (r101 == null) goto L58;
        if ((r101 instanceof e) == false) goto L7;
        r100.write(((e) r101).f557929a);
        return;
    L7:
        if ((r101 instanceof Boolean) == false) goto L9;
    L55:
        r100.write(((Boolean) r101).booleanValue() ? 1 : 0);
        return;
    L9:
        if (Boolean.TYPE.isAssignableFrom(r101.getClass()) == true) goto L55;
        if ((r101 instanceof Character) == false) goto L14;
    L54:
        k(r100, ((Character) r101).charValue());
        return;
    L14:
        if (Character.TYPE.isAssignableFrom(r101.getClass()) == true) goto L54;
        if ((r101 instanceof Float) == false) goto L19;
    L53:
        i(r100, Float.floatToRawIntBits(((Float) r101).floatValue()));
        return;
    L19:
        if (Float.TYPE.isAssignableFrom(r101.getClass()) == true) goto L53;
        if ((r101 instanceof Double) == false) goto L24;
    L52:
        j(r100, Double.doubleToRawLongBits(((Double) r101).doubleValue()));
        return;
    L24:
        if (Double.TYPE.isAssignableFrom(r101.getClass()) == true) goto L52;
        if ((r101 instanceof Byte) == false) goto L29;
    L51:
        r100.write(((Byte) r101).byteValue());
        return;
    L29:
        if (Byte.TYPE.isAssignableFrom(r101.getClass()) == true) goto L51;
        if ((r101 instanceof Short) == false) goto L34;
    L50:
        k(r100, ((Short) r101).shortValue());
        return;
    L34:
        if (Short.TYPE.isAssignableFrom(r101.getClass()) == true) goto L50;
        if ((r101 instanceof Integer) == false) goto L39;
    L49:
        i(r100, ((Integer) r101).intValue());
        return;
    L39:
        if (Integer.TYPE.isAssignableFrom(r101.getClass()) == true) goto L49;
        if ((r101 instanceof Long) == false) goto L44;
    L48:
        j(r100, ((Long) r101).longValue());
        return;
    L44:
        if (Long.TYPE.isAssignableFrom(r101.getClass()) == true) goto L48;
        throw new IllegalArgumentException("bad value type: ".concat(r101.getClass().getName()));
    L58:
        throw new IllegalArgumentException("value is null.");
    }

    public static void d(InputStream r100, byte[] r101, long r102) throws IOException {
        int r103 = 0;
    L3:
        long r104 = r103;
        if (r104 >= r102) goto L10;
        int r105 = r100.read(r101, r103, (int) (r102 - r104));
        if (r105 < 0) goto L9;
        r103 = r103 + r105;
        goto L3
    L9:
        throw new EOFException();
    }

    public static Object f(InputStream r100, BaseType r101, int r102) throws IOException {
        switch(a.f557940a[r101.ordinal()]) {
            case 1: goto L27;
            case 2: goto L21;
            case 3: goto L19;
            case 4: goto L17;
            case 5: goto L15;
            case 6: goto L13;
            case 7: goto L11;
            case 8: goto L9;
            case 9: goto L7;
            default: goto L4;
        };
    L4:
        return null;
    L7:
        return Long.valueOf(b(r100));
    L9:
        return Integer.valueOf(a(r100));
    L11:
        return Short.valueOf(c(r100));
    L13:
        return Byte.valueOf((byte) r100.read());
    L15:
        return Double.valueOf(Double.longBitsToDouble(b(r100)));
    L17:
        return Float.valueOf(Float.intBitsToFloat(a(r100)));
    L19:
        return Character.valueOf((char) c(r100));
    L21:
        if (r100.read() == 0) goto L23;
        boolean r103 = true;
    L25:
        return Boolean.valueOf(r103);
    L23:
        r103 = false;
        goto L25
    L27:
        return e(r100, r102);
    }
}
