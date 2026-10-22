package com.sun.jna;

import androidx.camera.video.AudioStats;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes40.dex */
public class Pointer {
    public static final Pointer NULL = null;
    protected long peer;

    /* JADX INFO: renamed from: com.sun.jna.Pointer$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Opaque extends Pointer {
        private final String MSG;

        @Override // com.sun.jna.Pointer
        public String toString() {
            return "const@0x" + Long.toHexString(this.peer);
        }

        private Opaque(long r100) {
            super(r100);
            this.MSG = "This pointer is opaque: " + this;
        }

        @Override // com.sun.jna.Pointer
        public void clear(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public byte getByte(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public char getChar(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public double getDouble(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public float getFloat(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public int getInt(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long getLong(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer getPointer(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public short getShort(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getWideString(long r100) {
            throw new UnsupportedOperationException(this.MSG);
        }

        public /* synthetic */ Opaque(long r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // com.sun.jna.Pointer
        public String dump(long r100, int r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public ByteBuffer getByteBuffer(long r100, long r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getString(long r100, String r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long indexOf(long r100, byte r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setByte(long r100, byte r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setChar(long r100, char r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setDouble(long r100, double r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setFloat(long r100, float r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setInt(long r100, int r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setLong(long r100, long r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setPointer(long r100, Pointer r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setShort(long r100, short r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setWideString(long r100, String r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer share(long r100, long r101) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setMemory(long r100, long r101, byte r102) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setString(long r100, String r101, String r102) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, byte[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, byte[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, char[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, char[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, double[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, double[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, float[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, float[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, int[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, int[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, long[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, long[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, Pointer[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, Pointer[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long r100, short[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long r100, short[] r101, int r102, int r103) {
            throw new UnsupportedOperationException(this.MSG);
        }
    }

    public int hashCode() {
        long r100 = this.peer;
        return (int) ((r100 >>> 32) + (r100 & BodyPartID.bodyIdMax));
    }

    public String toString() {
        return "native@0x" + Long.toHexString(this.peer);
    }

    public Pointer() {
    }

    public Pointer(long r100) {
        this.peer = r100;
    }

    public static final Pointer createConstant(int r100) {
        return new Opaque(((long) r100) & BodyPartID.bodyIdMax, null);
    }

    public static long nativeValue(Pointer r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.peer;
    }

    public void clear(long r100) {
        setMemory(0, r100, (byte) 0);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof Pointer) == true) goto L11;
    L13:
        return false;
    L11:
        if (((Pointer) r100).peer != this.peer) goto L13;
        return true;
    }

    public byte getByte(long r100) {
        return Native.getByte(this, this.peer, r100);
    }

    public char getChar(long r100) {
        return Native.getChar(this, this.peer, r100);
    }

    public double getDouble(long r100) {
        return Native.getDouble(this, this.peer, r100);
    }

    public float getFloat(long r100) {
        return Native.getFloat(this, this.peer, r100);
    }

    public int getInt(long r100) {
        return Native.getInt(this, this.peer, r100);
    }

    public long getLong(long r100) {
        return Native.getLong(this, this.peer, r100);
    }

    public NativeLong getNativeLong(long r100) {
        if (NativeLong.SIZE != 8) goto L5;
        long r101 = getLong(r100);
    L7:
        return new NativeLong(r101);
    L5:
        r101 = getInt(r100);
        goto L7
    }

    public Pointer getPointer(long r100) {
        return Native.getPointer(this.peer + r100);
    }

    public Pointer[] getPointerArray(long r100) {
        ArrayList r101 = new ArrayList();
        Pointer r102 = getPointer(r100);
        int r103 = 0;
    L3:
        if (r102 == null) goto L6;
        r101.add(r102);
        r103 = r103 + Native.POINTER_SIZE;
        r102 = getPointer(((long) r103) + r100);
        goto L3
    L6:
        return (Pointer[]) r101.toArray(new Pointer[0]);
    }

    public short getShort(long r100) {
        return Native.getShort(this, this.peer, r100);
    }

    public String getString(long r100) {
        return getString(r100, Native.getDefaultStringEncoding());
    }

    public String[] getStringArray(long r100) {
        return getStringArray(r100, -1, Native.getDefaultStringEncoding());
    }

    public String getWideString(long r100) {
        return Native.getWideString(this, this.peer, r100);
    }

    public String[] getWideStringArray(long r100) {
        return getWideStringArray(r100, -1);
    }

    public Pointer share(long r100) {
        return share(r100, 0);
    }

    public static final Pointer createConstant(long r100) {
        return new Opaque(r100, null);
    }

    public static void nativeValue(Pointer r100, long r101) {
        r100.peer = r101;
    }

    public String dump(long r100, int r110) {
        StringWriter r101 = new StringWriter((13 + (r110 * 2)) + ((r110 / 4) * 4));
        PrintWriter r102 = new PrintWriter(r101);
        r102.println("memory dump");
        int r103 = 0;
    L4:
        if (r103 >= r110) goto L19;
        byte r104 = getByte(((long) r103) + r100);
        int r105 = r103 % 4;
        if (r105 != 0) goto L8;
        r102.print("[");
    L8:
        if (r104 >= 0) goto L10;
    L12:
        r102.print(Integer.toHexString(r104 & UByte.MAX_VALUE));
        if (r105 != 3) goto L17;
        if (r103 >= (r110 - 1)) goto L17;
        r102.println("]");
    L17:
        r103 = r103 + 1;
        goto L4
    L10:
        if (r104 >= 16) goto L12;
        r102.print("0");
        goto L12
    L19:
        if (r101.getBuffer().charAt(r101.getBuffer().length() - 2) == ']') goto L22;
        r102.println("]");
    L22:
        return r101.toString();
    }

    public byte[] getByteArray(long r100, int r110) {
        byte[] r101 = new byte[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public ByteBuffer getByteBuffer(long r100, long r110) {
        return Native.getDirectByteBuffer(this, this.peer, r100, r110).order(ByteOrder.nativeOrder());
    }

    public char[] getCharArray(long r100, int r110) {
        char[] r101 = new char[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public double[] getDoubleArray(long r100, int r110) {
        double[] r101 = new double[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public float[] getFloatArray(long r100, int r110) {
        float[] r101 = new float[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public int[] getIntArray(long r100, int r110) {
        int[] r101 = new int[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public long[] getLongArray(long r100, int r110) {
        long[] r101 = new long[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public Pointer[] getPointerArray(long r100, int r110) {
        Pointer[] r101 = new Pointer[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public short[] getShortArray(long r100, int r110) {
        short[] r101 = new short[r110];
        read(r100, r101, 0, r110);
        return r101;
    }

    public String getString(long r100, String r101) {
        return Native.getString(this, r100, r101);
    }

    public String[] getStringArray(long r100, int r101) {
        return getStringArray(r100, r101, Native.getDefaultStringEncoding());
    }

    public String[] getWideStringArray(long r100, int r101) {
        return getStringArray(r100, r101, "--WIDE-STRING--");
    }

    public long indexOf(long r100, byte r101) {
        return Native.indexOf(this, this.peer, r100, r101);
    }

    public void setByte(long r100, byte r101) {
        Native.setByte(this, this.peer, r100, r101);
    }

    public void setChar(long r100, char r101) {
        Native.setChar(this, this.peer, r100, r101);
    }

    public void setDouble(long r100, double r110) {
        Native.setDouble(this, this.peer, r100, r110);
    }

    public void setFloat(long r100, float r101) {
        Native.setFloat(this, this.peer, r100, r101);
    }

    public void setInt(long r100, int r101) {
        Native.setInt(this, this.peer, r100, r101);
    }

    public void setLong(long r100, long r110) {
        Native.setLong(this, this.peer, r100, r110);
    }

    public void setNativeLong(long r100, NativeLong r101) {
        if (NativeLong.SIZE != 8) goto L5;
        setLong(r100, r101.longValue());
        return;
    L5:
        setInt(r100, r101.intValue());
    }

    public void setPointer(long r100, Pointer r110) {
        long r101 = this.peer;
        if (r110 == null) goto L5;
        long r102 = r110.peer;
    L6:
        Native.setPointer(this, r101, r100, r102);
        return;
    L5:
        r102 = 0;
        goto L6
    }

    public void setShort(long r100, short r101) {
        Native.setShort(this, this.peer, r100, r101);
    }

    public void setString(long r100, WString r101) {
        if (r101 != null) goto L4;
        String r102 = null;
    L5:
        setWideString(r100, r102);
        return;
    L4:
        r102 = r101.toString();
        goto L5
    }

    public void setWideString(long r100, String r101) {
        Native.setWideString(this, this.peer, r100, r101);
    }

    public Pointer share(long r100, long r101) {
        if (r100 != 0) goto L6;
        return this;
    L6:
        return new Pointer(this.peer + r100);
    }

    public String[] getStringArray(long r100, String r101) {
        return getStringArray(r100, -1, r101);
    }

    public void setString(long r100, String r101) {
        setString(r100, r101, Native.getDefaultStringEncoding());
    }

    private void readArray(long r100, Object r110, Class<?> r111) {
        int r101 = Array.getLength(r110);
        if (r111 != Byte.TYPE) goto L6;
        read(r100, (byte[]) r110, 0, r101);
        return;
    L6:
        if (r111 != Short.TYPE) goto L9;
        read(r100, (short[]) r110, 0, r101);
        return;
    L9:
        if (r111 != Character.TYPE) goto L12;
        read(r100, (char[]) r110, 0, r101);
        return;
    L12:
        if (r111 != Integer.TYPE) goto L15;
        read(r100, (int[]) r110, 0, r101);
        return;
    L15:
        if (r111 != Long.TYPE) goto L18;
        read(r100, (long[]) r110, 0, r101);
        return;
    L18:
        if (r111 != Float.TYPE) goto L21;
        read(r100, (float[]) r110, 0, r101);
        return;
    L21:
        if (r111 != Double.TYPE) goto L24;
        read(r100, (double[]) r110, 0, r101);
        return;
    L24:
        if (Pointer.class.isAssignableFrom(r111) == false) goto L26;
        read(r100, (Pointer[]) r110, 0, r101);
        return;
    L26:
        int r102 = 0;
        if (Structure.class.isAssignableFrom(r111) == false) goto L47;
        Structure[] r112 = (Structure[]) r110;
        if (Structure.ByReference.class.isAssignableFrom(r111) == false) goto L34;
        Pointer[] r103 = getPointerArray(r100, r112.length);
    L32:
        if (r102 >= r112.length) goto L67;
        r112[r102] = Structure.updateStructureByReference(r111, r112[r102], r103[r102]);
        r102 = r102 + 1;
        goto L32
    L67:
        return;
    L34:
        Structure r104 = r112[0];
        if (r104 != null) goto L37;
        r104 = Structure.newInstance(r111, share(r100));
        r104.conditionalAutoRead();
        r112[0] = r104;
    L38:
        Structure[] r113 = r104.toArray(r112.length);
        int r105 = 1;
    L40:
        if (r105 >= r112.length) goto L68;
        Structure r106 = r112[r105];
        if (r106 != null) goto L44;
        r112[r105] = r113[r105];
    L45:
        r105 = r105 + 1;
        goto L40
    L44:
        r106.useMemory(this, (int) (((long) (r106.size() * r105)) + r100), true);
        r112[r105].read();
        goto L45
    L68:
        return;
    L37:
        r104.useMemory(this, (int) r100, true);
        r104.read();
        goto L38
    L47:
        if (NativeMapped.class.isAssignableFrom(r111) == false) goto L54;
        NativeMapped[] r107 = (NativeMapped[]) r110;
        NativeMappedConverter r108 = NativeMappedConverter.getInstance(r111);
        int r114 = Native.getNativeSize(r110.getClass(), r110) / r107.length;
    L50:
        if (r102 >= r107.length) goto L69;
        r107[r102] = (NativeMapped) r108.fromNative(getValue(((long) (r114 * r102)) + r100, r108.nativeType(), r107[r102]), new FromNativeContext(r111));
        r102 = r102 + 1;
        goto L50
    L69:
        return;
    L54:
        throw new IllegalArgumentException("Reading array of " + r111 + " from memory not supported");
    }

    private void writeArray(long r100, Object r110, Class<?> r111) {
        if (r111 != Byte.TYPE) goto L6;
        byte[] r101 = (byte[]) r110;
        write(r100, r101, 0, r101.length);
        return;
    L6:
        if (r111 != Short.TYPE) goto L9;
        short[] r102 = (short[]) r110;
        write(r100, r102, 0, r102.length);
        return;
    L9:
        if (r111 != Character.TYPE) goto L12;
        char[] r103 = (char[]) r110;
        write(r100, r103, 0, r103.length);
        return;
    L12:
        if (r111 != Integer.TYPE) goto L15;
        int[] r104 = (int[]) r110;
        write(r100, r104, 0, r104.length);
        return;
    L15:
        if (r111 != Long.TYPE) goto L18;
        long[] r105 = (long[]) r110;
        write(r100, r105, 0, r105.length);
        return;
    L18:
        if (r111 != Float.TYPE) goto L21;
        float[] r106 = (float[]) r110;
        write(r100, r106, 0, r106.length);
        return;
    L21:
        if (r111 != Double.TYPE) goto L24;
        double[] r107 = (double[]) r110;
        write(r100, r107, 0, r107.length);
        return;
    L24:
        if (Pointer.class.isAssignableFrom(r111) == false) goto L26;
        Pointer[] r108 = (Pointer[]) r110;
        write(r100, r108, 0, r108.length);
        return;
    L26:
        int r109 = 0;
        if (Structure.class.isAssignableFrom(r111) == false) goto L52;
        Structure[] r112 = (Structure[]) r110;
        if (Structure.ByReference.class.isAssignableFrom(r111) == false) goto L39;
        int r113 = r112.length;
        Pointer[] r114 = new Pointer[r113];
    L32:
        if (r109 >= r112.length) goto L38;
        Structure r115 = r112[r109];
        if (r115 != null) goto L36;
        r114[r109] = null;
    L37:
        r109 = r109 + 1;
        goto L32
    L36:
        r114[r109] = r115.getPointer();
        r112[r109].write();
        goto L37
    L38:
        write(r100, r114, 0, r113);
        return;
    L39:
        Structure r116 = r112[0];
        if (r116 != null) goto L42;
        r116 = Structure.newInstance(r111, share(r100));
        r112[0] = r116;
    L43:
        r116.write();
        Structure[] r117 = r116.toArray(r112.length);
        int r118 = 1;
    L45:
        if (r118 >= r112.length) goto L75;
        Structure r119 = r112[r118];
        if (r119 != null) goto L49;
        r112[r118] = r117[r118];
    L50:
        r112[r118].write();
        r118 = r118 + 1;
        goto L45
    L49:
        r119.useMemory(this, (int) (((long) (r119.size() * r118)) + r100), true);
        goto L50
    L75:
        return;
    L42:
        r116.useMemory(this, (int) r100, true);
        goto L43
    L52:
        if (NativeMapped.class.isAssignableFrom(r111) == false) goto L59;
        NativeMapped[] r120 = (NativeMapped[]) r110;
        NativeMappedConverter r121 = NativeMappedConverter.getInstance(r111);
        Class<?> r122 = r121.nativeType();
        int r123 = Native.getNativeSize(r110.getClass(), r110) / r120.length;
    L55:
        if (r109 >= r120.length) goto L76;
        setValue(((long) (r109 * r123)) + r100, r121.toNative(r120[r109], new ToNativeContext()), r122);
        r109 = r109 + 1;
        goto L55
    L76:
        return;
    L59:
        throw new IllegalArgumentException("Writing array of " + r111 + " to memory not supported");
    }

    public String[] getStringArray(long r110, int r111, String r112) {
        ArrayList r100 = new ArrayList();
        if (r111 == (-1)) goto L17;
        Pointer r101 = getPointer(((long) 0) + r110);
        int r102 = 0;
        int r103 = 0;
    L5:
        int r104 = r102 + 1;
        if (r102 >= r111) goto L26;
        if (r101 != null) goto L10;
        String r105 = null;
    L13:
        r100.add(r105);
        if (r104 >= r111) goto L16;
        r103 = r103 + Native.POINTER_SIZE;
        r101 = getPointer(((long) r103) + r110);
    L16:
        r102 = r104;
        goto L5
    L10:
        if ("--WIDE-STRING--".equals(r112) == false) goto L12;
        r105 = r101.getWideString(0);
        goto L13
    L12:
        r105 = r101.getString(0, r112);
    L26:
        return (String[]) r100.toArray(new String[0]);
    L17:
        int r113 = 0;
    L18:
        Pointer r106 = getPointer(((long) r113) + r110);
        if (r106 == null) goto L26;
        if ("--WIDE-STRING--".equals(r112) == false) goto L23;
        String r107 = r106.getWideString(0);
    L24:
        r100.add(r107);
        r113 = r113 + Native.POINTER_SIZE;
        goto L18
    L23:
        r107 = r106.getString(0, r112);
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v23, types: [com.sun.jna.Pointer] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v26, types: [com.sun.jna.Structure] */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.sun.jna.NativeMapped, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v17, types: [java.lang.Object] */
    public Object getValue(long r100, Class<?> r101, Object r102) {
        boolean r103 = true;
        if (Structure.class.isAssignableFrom(r101) == false) goto L10;
        Structure r104 = (Structure) r102;
        if (Structure.ByReference.class.isAssignableFrom(r101) == false) goto L8;
        ?? r105 = Structure.updateStructureByReference(r101, r104, getPointer(r100));
    L124:
        return r105;
    L8:
        r104.useMemory(this, (int) r100, true);
        r104.read();
        return r104;
    L10:
        if (r101 == Boolean.TYPE) goto L119;
        if (r101 == Boolean.class) goto L119;
        if (r101 == Byte.TYPE) goto L137;
        if (r101 == Byte.class) goto L137;
        if (r101 == Short.TYPE) goto L136;
        if (r101 == Short.class) goto L136;
        if (r101 == Character.TYPE) goto L135;
        if (r101 == Character.class) goto L135;
        if (r101 == Integer.TYPE) goto L134;
        if (r101 == Integer.class) goto L134;
        if (r101 == Long.TYPE) goto L133;
        if (r101 == Long.class) goto L133;
        if (r101 == Float.TYPE) goto L132;
        if (r101 == Float.class) goto L132;
        if (r101 == Double.TYPE) goto L131;
        if (r101 == Double.class) goto L131;
        Pointer r106 = null;
        if (Pointer.class.isAssignableFrom(r101) == false) goto L62;
        r105 = getPointer(r100);
        if (r105 == 0) goto L126;
        if ((r102 instanceof Pointer) == false) goto L56;
        r106 = (Pointer) r102;
    L56:
        if (r106 == null) goto L124;
        if (r105.peer != r106.peer) goto L124;
    L126:
        return r106;
    L62:
        if (r101 != String.class) goto L67;
        Pointer r107 = getPointer(r100);
        if (r107 == null) goto L126;
        r105 = r107.getString(0);
        goto L124
    L67:
        if (r101 != WString.class) goto L72;
        Pointer r108 = getPointer(r100);
        if (r108 == null) goto L126;
        return new WString(r108.getWideString(0));
    L72:
        if (Callback.class.isAssignableFrom(r101) == false) goto L80;
        Pointer r109 = getPointer(r100);
        if (r109 == null) goto L126;
        Callback r110 = (Callback) r102;
        if (r109.equals(CallbackReference.getFunctionPointer(r110)) == false) goto L129;
        return r110;
    L129:
        return CallbackReference.getCallback(r101, r109);
    L80:
        if (Platform.HAS_BUFFERS == false) goto L96;
        if (Buffer.class.isAssignableFrom(r101) == false) goto L96;
        Pointer r111 = getPointer(r100);
        if (r111 == null) goto L126;
        if (r102 == null) goto L89;
        r106 = Native.getDirectBufferPointer((Buffer) r102);
    L89:
        if (r106 == null) goto L94;
        if (r106.equals(r111) == false) goto L94;
        return r102;
    L94:
        throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
    L96:
        if (NativeMapped.class.isAssignableFrom(r101) == false) goto L104;
        ?? r112 = (NativeMapped) r102;
        if (r112 == 0) goto L102;
        r105 = r112.fromNative(getValue(r100, r112.nativeType(), null), new FromNativeContext(r101));
        if (r112.equals(r105) == false) goto L124;
        return r112;
    L102:
        NativeMappedConverter r113 = NativeMappedConverter.getInstance(r101);
        r105 = r113.fromNative(getValue(r100, r113.nativeType(), null), new FromNativeContext(r101));
        goto L124
    L104:
        if (r101.isArray() == false) goto L110;
        if (r102 == null) goto L108;
        readArray(r100, r102, r101.getComponentType());
        return r102;
    L108:
        throw new IllegalStateException("Need an initialized array");
    L110:
        throw new IllegalArgumentException("Reading \"" + r101 + "\" from memory is not supported");
    L131:
        return Double.valueOf(getDouble(r100));
    L132:
        return Float.valueOf(getFloat(r100));
    L133:
        return Long.valueOf(getLong(r100));
    L134:
        return Integer.valueOf(getInt(r100));
    L135:
        return Character.valueOf(getChar(r100));
    L136:
        return Short.valueOf(getShort(r100));
    L137:
        return Byte.valueOf(getByte(r100));
    L119:
        if (getInt(r100) != 0) goto L123;
        r103 = false;
    L123:
        return Function.valueOf(r103);
    }

    public void setMemory(long r100, long r110, byte r111) {
        Native.setMemory(this, this.peer, r100, r110, r111);
    }

    public void setString(long r100, String r101, String r110) {
        byte[] r102 = Native.getBytes(r101, r110);
        write(r100, r102, 0, r102.length);
        setByte(r100 + ((long) r102.length), (byte) 0);
    }

    public void setValue(long r100, Object r101, Class<?> r102) {
        int r103 = 0;
        int r104 = 0;
        char r105 = 0;
        short r106 = 0;
        byte r107 = 0;
        if (r102 == Boolean.TYPE) goto L110;
        if (r102 == Boolean.class) goto L110;
        if (r102 != Byte.TYPE) goto L10;
    L105:
        if (r101 == null) goto L108;
        r107 = ((Byte) r101).byteValue();
    L108:
        setByte(r100, r107);
        return;
    L10:
        if (r102 == Byte.class) goto L105;
        if (r102 != Short.TYPE) goto L15;
    L101:
        if (r101 == null) goto L104;
        r106 = ((Short) r101).shortValue();
    L104:
        setShort(r100, r106);
        return;
    L15:
        if (r102 == Short.class) goto L101;
        if (r102 != Character.TYPE) goto L20;
    L97:
        if (r101 == null) goto L100;
        r105 = ((Character) r101).charValue();
    L100:
        setChar(r100, r105);
        return;
    L20:
        if (r102 == Character.class) goto L97;
        if (r102 != Integer.TYPE) goto L25;
    L93:
        if (r101 == null) goto L96;
        r104 = ((Integer) r101).intValue();
    L96:
        setInt(r100, r104);
        return;
    L25:
        if (r102 == Integer.class) goto L93;
        if (r102 != Long.TYPE) goto L30;
    L89:
        if (r101 != null) goto L91;
        long r108 = 0;
    L92:
        setLong(r100, r108);
        return;
    L91:
        r108 = ((Long) r101).longValue();
        goto L92
    L30:
        if (r102 == Long.class) goto L89;
        if (r102 != Float.TYPE) goto L35;
    L85:
        if (r101 != null) goto L87;
        float r109 = 0.0f;
    L88:
        setFloat(r100, r109);
        return;
    L87:
        r109 = ((Float) r101).floatValue();
        goto L88
    L35:
        if (r102 == Float.class) goto L85;
        if (r102 != Double.TYPE) goto L40;
    L81:
        if (r101 != null) goto L83;
        double r110 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L84:
        setDouble(r100, r110);
        return;
    L83:
        r110 = ((Double) r101).doubleValue();
        goto L84
    L40:
        if (r102 == Double.class) goto L81;
        if (r102 != Pointer.class) goto L46;
        setPointer(r100, (Pointer) r101);
        return;
    L46:
        if (r102 != String.class) goto L49;
        setPointer(r100, (Pointer) r101);
        return;
    L49:
        if (r102 != WString.class) goto L51;
        setPointer(r100, (Pointer) r101);
        return;
    L51:
        Pointer r111 = null;
        if (Structure.class.isAssignableFrom(r102) == false) goto L63;
        Structure r112 = (Structure) r101;
        if (Structure.ByReference.class.isAssignableFrom(r102) == false) goto L61;
        if (r112 == null) goto L58;
        r111 = r112.getPointer();
    L58:
        setPointer(r100, r111);
        if (r112 == null) goto L117;
        r112.autoWrite();
        return;
    L117:
        return;
    L61:
        r112.useMemory(this, (int) r100, true);
        r112.write();
        return;
    L63:
        if (Callback.class.isAssignableFrom(r102) == false) goto L66;
        setPointer(r100, CallbackReference.getFunctionPointer((Callback) r101));
        return;
    L66:
        if (Platform.HAS_BUFFERS == false) goto L74;
        if (Buffer.class.isAssignableFrom(r102) == false) goto L74;
        if (r101 == null) goto L72;
        r111 = Native.getDirectBufferPointer((Buffer) r101);
    L72:
        setPointer(r100, r111);
        return;
    L74:
        if (NativeMapped.class.isAssignableFrom(r102) == false) goto L77;
        NativeMappedConverter r113 = NativeMappedConverter.getInstance(r102);
        setValue(r100, r113.toNative(r101, new ToNativeContext()), r113.nativeType());
        return;
    L77:
        if (r102.isArray() == false) goto L80;
        writeArray(r100, r101, r102.getComponentType());
        return;
    L80:
        throw new IllegalArgumentException("Writing " + r102 + " to memory is not supported");
    L110:
        if (Boolean.TRUE.equals(r101) == false) goto L112;
        r103 = -1;
    L112:
        setInt(r100, r103);
    }

    public void read(long r100, Pointer[] r110, int r111, int r112) {
        int r101 = 0;
    L3:
        if (r101 >= r112) goto L11;
        Pointer r102 = getPointer(((long) (Native.POINTER_SIZE * r101)) + r100);
        int r103 = r101 + r111;
        Pointer r104 = r110[r103];
        if (r104 == null) goto L9;
        if (r102 == null) goto L9;
        if (r102.peer != r104.peer) goto L9;
    L10:
        r101 = r101 + 1;
    L9:
        r110[r103] = r102;
        goto L10
    }

    public void write(long r100, Pointer[] r101, int r102, int r103) {
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        setPointer(((long) (Native.POINTER_SIZE * r104)) + r100, r101[r102 + r104]);
        r104 = r104 + 1;
        goto L3
    }

    public void read(long r100, byte[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, byte[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, char[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, char[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, double[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, double[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, float[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, float[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, int[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, int[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, long[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, long[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }

    public void read(long r100, short[] r110, int r111, int r112) {
        Native.read(this, this.peer, r100, r110, r111, r112);
    }

    public void write(long r100, short[] r110, int r111, int r112) {
        Native.write(this, this.peer, r100, r110, r111, r112);
    }
}
