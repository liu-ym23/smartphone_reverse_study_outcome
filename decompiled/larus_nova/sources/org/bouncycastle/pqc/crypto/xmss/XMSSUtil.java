package org.bouncycastle.pqc.crypto.xmss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;
import kotlin.UByte;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes42.dex */
public class XMSSUtil {

    public static class CheckingStream extends ObjectInputStream {
        private static final Set components = null;
        private boolean found;
        private final Class mainClass;

        static {
            HashSet r100 = new HashSet();
            components = r100;
            r100.add("java.util.TreeMap");
            r100.add("java.lang.Integer");
            r100.add("java.lang.Number");
            r100.add("org.bouncycastle.pqc.crypto.xmss.BDS");
            r100.add("java.util.ArrayList");
            r100.add("org.bouncycastle.pqc.crypto.xmss.XMSSNode");
            r100.add("[B");
            r100.add("java.util.LinkedList");
            r100.add("java.util.Stack");
            r100.add("java.util.Vector");
            r100.add("[Ljava.lang.Object;");
            r100.add("org.bouncycastle.pqc.crypto.xmss.BDSTreeHash");
        }

        public CheckingStream(Class r100, InputStream r101) throws IOException {
            super(r101);
            this.found = false;
            this.mainClass = r100;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass r100) throws IOException, ClassNotFoundException {
            if (this.found == true) goto L10;
            if (r100.getName().equals(this.mainClass.getName()) == false) goto L8;
            this.found = true;
        L12:
            return super.resolveClass(r100);
        L8:
            throw new InvalidClassException("unexpected class: ", r100.getName());
        L10:
            if (components.contains(r100.getName()) == true) goto L12;
            throw new InvalidClassException("unexpected class: ", r100.getName());
        }
    }

    public XMSSUtil() {
    }

    public static boolean areEqual(byte[][] r100, byte[][] r101) {
        if (hasNullPointer(r100) == true) goto L16;
        if (hasNullPointer(r101) == true) goto L16;
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L13;
        if (Arrays.areEqual(r100[r102], r101[r102]) == false) goto L11;
        r102 = r102 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L16:
        throw new NullPointerException("a or b == null");
    }

    public static long bytesToXBigEndian(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L9;
        long r103 = 0;
        int r104 = r101;
    L5:
        if (r104 >= (r101 + r102)) goto L7;
        r103 = (r103 << 8) | ((long) (r100[r104] & UByte.MAX_VALUE));
        r104 = r104 + 1;
        goto L5
    L7:
        return r103;
    L9:
        throw new NullPointerException("in == null");
    }

    public static int calculateTau(int r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        if (((r100 >> r102) & 1) == 0) goto L8;
        r102 = r102 + 1;
        goto L3
    L8:
        return r102;
    L11:
        return 0;
    }

    public static byte[] cloneArray(byte[] r100) {
        if (r100 == null) goto L6;
        byte[] r101 = new byte[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    L6:
        throw new NullPointerException("in == null");
    }

    public static byte[][] cloneArray(byte[][] r100) {
        if (hasNullPointer(r100) == true) goto L10;
        byte[][] r101 = new byte[r100.length][];
        int r102 = 0;
    L6:
        if (r102 >= r100.length) goto L8;
        byte[] r103 = new byte[r100[r102].length];
        r101[r102] = r103;
        byte[] r104 = r100[r102];
        System.arraycopy(r104, 0, r103, 0, r104.length);
        r102 = r102 + 1;
        goto L6
    L8:
        return r101;
    L10:
        throw new NullPointerException("in has null pointers");
    }

    public static void copyBytesAtOffset(byte[] r100, byte[] r101, int r102) {
        if (r100 == null) goto L19;
        if (r101 == null) goto L17;
        if (r102 < 0) goto L15;
        if ((r101.length + r102) > r100.length) goto L13;
        int r103 = 0;
    L9:
        if (r103 >= r101.length) goto L11;
        r100[r102 + r103] = r101[r103];
        r103 = r103 + 1;
        goto L9
    L11:
        return;
    L13:
        throw new IllegalArgumentException("src length + offset must not be greater than size of destination");
    L15:
        throw new IllegalArgumentException("offset hast to be >= 0");
    L17:
        throw new NullPointerException("src == null");
    L19:
        throw new NullPointerException("dst == null");
    }

    public static Object deserialize(byte[] r100, Class r101) throws IOException, ClassNotFoundException {
        CheckingStream r102 = new CheckingStream(r101, new ByteArrayInputStream(r100));
        Object r103 = r102.readObject();
        if (r102.available() != 0) goto L10;
        if (r101.isInstance(r103) == false) goto L8;
        return r103;
    L8:
        throw new IOException("unexpected class found in ObjectInputStream");
    L10:
        throw new IOException("unexpected data found at end of ObjectInputStream");
    }

    public static void dumpByteArray(byte[][] r100) {
        if (hasNullPointer(r100) == true) goto L10;
        int r101 = 0;
    L6:
        if (r101 >= r100.length) goto L8;
        System.out.println(Hex.toHexString(r100[r101]));
        r101 = r101 + 1;
        goto L6
    L8:
        return;
    L10:
        throw new NullPointerException("x has null pointers");
    }

    public static byte[] extractBytesAtOffset(byte[] r100, int r101, int r102) {
        if (r100 == null) goto L18;
        if (r101 < 0) goto L16;
        if (r102 < 0) goto L14;
        if ((r101 + r102) > r100.length) goto L12;
        byte[] r103 = new byte[r102];
        int r104 = 0;
    L8:
        if (r104 >= r102) goto L10;
        r103[r104] = r100[r101 + r104];
        r104 = r104 + 1;
        goto L8
    L10:
        return r103;
    L12:
        throw new IllegalArgumentException("offset + length must not be greater then size of source array");
    L14:
        throw new IllegalArgumentException("length hast to be >= 0");
    L16:
        throw new IllegalArgumentException("offset hast to be >= 0");
    L18:
        throw new NullPointerException("src == null");
    }

    public static int getDigestSize(Digest r100) {
        if (r100 == null) goto L14;
        String r101 = r100.getAlgorithmName();
        if (r101.equals("SHAKE128") == false) goto L8;
        return 32;
    L8:
        if (r101.equals("SHAKE256") == false) goto L12;
        return 64;
    L12:
        return r100.getDigestSize();
    L14:
        throw new NullPointerException("digest == null");
    }

    public static int getLeafIndex(long r100, int r101) {
        return (int) (r100 & ((1 << r101) - 1));
    }

    public static long getTreeIndex(long r100, int r101) {
        return r100 >> r101;
    }

    public static boolean hasNullPointer(byte[][] r100) {
        if (r100 != null) goto L5;
        return true;
    L5:
        int r101 = 0;
    L7:
        if (r101 >= r100.length) goto L12;
        if (r100[r101] == null) goto L10;
        r101 = r101 + 1;
        goto L7
    L10:
        return true;
    L12:
        return false;
    }

    public static boolean isIndexValid(int r100, long r101) {
        if (r101 < 0) goto L10;
        if (r101 >= (1 << r100)) goto L7;
        return true;
    L7:
        return false;
    L10:
        throw new IllegalStateException("index must not be negative");
    }

    public static boolean isNewAuthenticationPathNeeded(long r100, int r101, int r102) {
        if (r100 != 0) goto L6;
        return false;
    L6:
        if (((r100 + 1) % ((long) Math.pow(1 << r101, r102))) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean isNewBDSInitNeeded(long r100, int r101, int r102) {
        if (r100 != 0) goto L6;
        return false;
    L6:
        if ((r100 % ((long) Math.pow(1 << r101, r102 + 1))) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public static int log2(int r100) {
        int r101 = 0;
    L3:
        r100 = r100 >> 1;
        if (r100 == 0) goto L6;
        r101 = r101 + 1;
        goto L3
    L6:
        return r101;
    }

    public static void longToBigEndian(long r100, byte[] r101, int r102) {
        if (r101 == null) goto L10;
        if ((r101.length - r102) < 8) goto L8;
        r101[r102] = (byte) ((r100 >> 56) & 255);
        r101[r102 + 1] = (byte) ((r100 >> 48) & 255);
        r101[r102 + 2] = (byte) ((r100 >> 40) & 255);
        r101[r102 + 3] = (byte) ((r100 >> 32) & 255);
        r101[r102 + 4] = (byte) ((r100 >> 24) & 255);
        r101[r102 + 5] = (byte) ((r100 >> 16) & 255);
        r101[r102 + 6] = (byte) ((r100 >> 8) & 255);
        r101[r102 + 7] = (byte) (r100 & 255);
        return;
    L8:
        throw new IllegalArgumentException("not enough space in array");
    L10:
        throw new NullPointerException("in == null");
    }

    public static byte[] serialize(Object r100) throws IOException {
        ByteArrayOutputStream r101 = new ByteArrayOutputStream();
        ObjectOutputStream r102 = new ObjectOutputStream(r101);
        r102.writeObject(r100);
        r102.flush();
        return r101.toByteArray();
    }

    public static byte[] toBytesBigEndian(long r100, int r101) {
        byte[] r102 = new byte[r101];
        int r103 = r101 - 1;
    L3:
        if (r103 < 0) goto L5;
        r102[r103] = (byte) r100;
        r100 = r100 >>> 8;
        r103 = r103 - 1;
        goto L3
    L5:
        return r102;
    }
}
