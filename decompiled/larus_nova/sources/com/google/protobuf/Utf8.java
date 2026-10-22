package com.google.protobuf;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes23.dex */
final class Utf8 {
    private static final long ASCII_MASK_LONG = -9187201950435737472L;
    public static final int COMPLETE = 0;
    public static final int MALFORMED = -1;
    static final int MAX_BYTES_PER_CHAR = 3;
    private static final int UNSAFE_COUNT_ASCII_THRESHOLD = 16;
    private static final Processor processor = null;

    public static abstract class Processor {
        public Processor() {
        }

        public abstract int encodeUtf8(CharSequence r100, byte[] r101, int r102, int r103);

        public abstract void encodeUtf8Direct(CharSequence r100, ByteBuffer r101);

        public abstract int partialIsValidUtf8(int r100, byte[] r101, int r102, int r103);

        public abstract int partialIsValidUtf8Direct(int r100, ByteBuffer r101, int r102, int r103);

        public final void encodeUtf8(CharSequence r100, ByteBuffer r101) {
            if (r101.hasArray() == false) goto L6;
            int r102 = r101.arrayOffset();
            r101.position(Utf8.encode(r100, r101.array(), r101.position() + r102, r101.remaining()) - r102);
            return;
        L6:
            if (r101.isDirect() == false) goto L8;
            encodeUtf8Direct(r100, r101);
            return;
        L8:
            encodeUtf8Default(r100, r101);
        }

        public final void encodeUtf8Default(CharSequence r100, ByteBuffer r101) {
            int r102 = r100.length();
            int r103 = r101.position();
            int r104 = 0;
        L4:
            if (r104 >= r102) goto L8;
            char r105 = r100.charAt(r104);     // Catch: IndexOutOfBoundsException -> L55
            if (r105 >= 128) goto L8;
            r101.put(r103 + r104, (byte) r105);     // Catch: IndexOutOfBoundsException -> L55
            r104 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L55
        L53:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r100.charAt(r104) + " at index " + (r101.position() + Math.max(r104, (r103 - r101.position()) + 1)));
        L8:
            if (r104 != r102) goto L11;
            r101.position(r103 + r104);     // Catch: IndexOutOfBoundsException -> L55
            return;
        L11:
            r103 = r103 + r104;     // Catch: IndexOutOfBoundsException -> L55
        L12:
            if (r104 >= r102) goto L50;
            char r106 = r100.charAt(r104);     // Catch: IndexOutOfBoundsException -> L55
            if (r106 >= 128) goto L18;
            r101.put(r103, (byte) r106);     // Catch: IndexOutOfBoundsException -> L55
        L49:
            r104 = r104 + 1;     // Catch: IndexOutOfBoundsException -> L55
            r103 = r103 + 1;     // Catch: IndexOutOfBoundsException -> L55
            goto L12
        L18:
            if (r106 >= 2048) goto L24;
            int r107 = r103 + 1;
            r101.put(r103, (byte) ((r106 >>> 6) | 192));     // Catch: IndexOutOfBoundsException -> L22
            r101.put(r107, (byte) ((r106 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L22
            r103 = r107;
        L22:
            r103 = r107;
            goto L53
        L24:
            if (r106 >= 55296) goto L26;
        L45:
            int r108 = r103 + 1;
            r101.put(r103, (byte) ((r106 >>> '\f') | 224));     // Catch: IndexOutOfBoundsException -> L22
            r103 = r108 + 1;
            r101.put(r108, (byte) (((r106 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L55
            r101.put(r103, (byte) ((r106 & '?') | 128));     // Catch: IndexOutOfBoundsException -> L55
            goto L49
        L26:
            if (57343 < r106) goto L45;
            int r109 = r104 + 1;
            if (r109 == r102) goto L44;
            char r110 = r100.charAt(r109);     // Catch: IndexOutOfBoundsException -> L54
            if (Character.isSurrogatePair(r106, r110) == false) goto L41;
            int r111 = Character.toCodePoint(r106, r110);     // Catch: IndexOutOfBoundsException -> L54
            int r112 = r103 + 1;
            r101.put(r103, (byte) ((r111 >>> 18) | 240));     // Catch: IndexOutOfBoundsException -> L40
            r103 = r112 + 1;
            r101.put(r112, (byte) (((r111 >>> 12) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L54
            r112 = r103 + 1;
            r101.put(r103, (byte) (((r111 >>> 6) & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            r101.put(r112, (byte) ((r111 & 63) | 128));     // Catch: IndexOutOfBoundsException -> L40
            r103 = r112;
            r104 = r109;
        L40:
            r103 = r112;
            goto L42
        L41:
            r104 = r109;
        L42:
            r104 = r109;
        L44:
            throw new UnpairedSurrogateException(r104, r102);     // Catch: IndexOutOfBoundsException -> L55
        L50:
            r101.position(r103);     // Catch: IndexOutOfBoundsException -> L55
        }

        private static int partialIsValidUtf8(ByteBuffer r100, int r101, int r102) {
            int r103 = r101 + Utf8.access$200(r100, r101, r102);
        L3:
            if (r103 >= r102) goto L4;
            int r104 = r103 + 1;
            byte r105 = r100.get(r103);
            if (r105 >= 0) goto L51;
            if (r105 < (-32)) goto L10;
            if (r105 < (-16)) goto L22;
            if (r104 >= (r102 - 2)) goto L41;
            int r106 = r104 + 1;
            byte r107 = r100.get(r104);
            if (r107 > (-65)) goto L50;
            if ((((r105 << 28) + (r107 + 112)) >> 30) != 0) goto L50;
            int r108 = r106 + 1;
            if (r100.get(r106) > (-65)) goto L50;
            r104 = r108 + 1;
            if (r100.get(r108) <= (-65)) goto L51;
        L50:
            return -1;
        L41:
            return Utf8.access$300(r100, r105, r104, r102 - r104);
        L22:
            if (r104 >= (r102 - 1)) goto L24;
            int r109 = r104 + 1;
            byte r110 = r100.get(r104);
            if (r110 > (-65)) goto L37;
            if (r105 != (-32)) goto L31;
            if (r110 < (-96)) goto L37;
        L31:
            if (r105 != (-19)) goto L34;
            if (r110 >= (-96)) goto L37;
        L34:
            if (r100.get(r109) > (-65)) goto L37;
            r103 = r109 + 1;
        L37:
            return -1;
        L24:
            return Utf8.access$300(r100, r105, r104, r102 - r104);
        L10:
            if (r104 >= r102) goto L11;
            if (r105 < (-62)) goto L18;
            if (r100.get(r104) > (-65)) goto L18;
            r104 = r104 + 1;
        L18:
            return -1;
        L11:
            return r105;
        L51:
            r103 = r104;
            goto L3
        L4:
            return 0;
        }

        public final boolean isValidUtf8(ByteBuffer r100, int r101, int r102) {
            if (partialIsValidUtf8(0, r100, r101, r102) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        public final boolean isValidUtf8(byte[] r100, int r101, int r102) {
            if (partialIsValidUtf8(0, r100, r101, r102) != 0) goto L6;
            return true;
        L6:
            return false;
        }

        public final int partialIsValidUtf8(int r100, ByteBuffer r101, int r102, int r103) {
            if (r101.hasArray() == false) goto L7;
            int r104 = r101.arrayOffset();
            return partialIsValidUtf8(r100, r101.array(), r102 + r104, r104 + r103);
        L7:
            if (r101.isDirect() == false) goto L11;
            return partialIsValidUtf8Direct(r100, r101, r102, r103);
        L11:
            return partialIsValidUtf8Default(r100, r101, r102, r103);
        }

        public final int partialIsValidUtf8Default(int r100, ByteBuffer r101, int r102, int r110) {
            if (r100 == 0) goto L55;
            if (r102 < r110) goto L5;
            return r100;
        L5:
            byte r103 = (byte) r100;
            if (r103 >= (-32)) goto L15;
            if (r103 < (-62)) goto L13;
            int r104 = r102 + 1;
            if (r101.get(r102) > (-65)) goto L13;
        L12:
            r102 = r104;
        L13:
            return -1;
        L15:
            if (r103 >= (-16)) goto L33;
            byte r105 = (byte) (~(r100 >> 8));
            if (r105 != 0) goto L23;
            int r106 = r102 + 1;
            byte r107 = r101.get(r102);
            if (r106 >= r110) goto L21;
            r102 = r106;
            r105 = r107;
            goto L23
        L21:
            return Utf8.access$000(r103, r107);
        L23:
            if (r105 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r103 != (-32)) goto L28;
            if (r105 < (-96)) goto L32;
        L28:
            if (r103 != (-19)) goto L30;
            if (r105 >= (-96)) goto L32;
        L30:
            r104 = r102 + 1;
            if (r101.get(r102) <= (-65)) goto L12;
        L33:
            byte r108 = (byte) (~(r100 >> 8));
            if (r108 != 0) goto L40;
            int r109 = r102 + 1;
            r108 = r101.get(r102);
            if (r109 >= r110) goto L38;
            byte r111 = 0;
        L41:
            if (r111 != 0) goto L47;
            int r112 = r109 + 1;
            byte r113 = r101.get(r109);
            if (r112 >= r110) goto L45;
            r111 = r113;
            r109 = r112;
            goto L47
        L45:
            return Utf8.access$100(r103, r108, r113);
        L47:
            if (r108 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r103 << 28) + (r108 + 112)) >> 30) != 0) goto L53;
            if (r111 > (-65)) goto L53;
            r102 = r109 + 1;
            if (r101.get(r109) <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r103, r108);
        L40:
            r111 = (byte) (r100 >> 16);
            r109 = r102;
        L55:
            return partialIsValidUtf8(r101, r102, r110);
        }
    }

    public static final class SafeProcessor extends Processor {
        public SafeProcessor() {
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence r100, ByteBuffer r101) {
            encodeUtf8Default(r100, r101);
        }

        private static int partialIsValidUtf8(byte[] r100, int r101, int r102) {
        L2:
            if (r101 >= r102) goto L6;
            if (r100[r101] < 0) goto L6;
            r101 = r101 + 1;
        L6:
            if (r101 < r102) goto L9;
            return 0;
        L9:
            return partialIsValidUtf8NonAscii(r100, r101, r102);
        }

        private static int partialIsValidUtf8NonAscii(byte[] r100, int r101, int r102) {
        L2:
            if (r101 >= r102) goto L3;
            int r103 = r101 + 1;
            byte r104 = r100[r101];
            if (r104 >= 0) goto L46;
            if (r104 < (-32)) goto L9;
            if (r104 < (-16)) goto L19;
            if (r103 >= (r102 - 2)) goto L36;
            int r105 = r103 + 1;
            byte r106 = r100[r103];
            if (r106 > (-65)) goto L45;
            if ((((r104 << 28) + (r106 + 112)) >> 30) != 0) goto L45;
            int r107 = r105 + 1;
            if (r100[r105] > (-65)) goto L45;
            r103 = r107 + 1;
            if (r100[r107] <= (-65)) goto L46;
        L45:
            return -1;
        L36:
            return Utf8.access$400(r100, r103, r102);
        L19:
            if (r103 >= (r102 - 1)) goto L21;
            int r108 = r103 + 1;
            byte r109 = r100[r103];
            if (r109 > (-65)) goto L32;
            if (r104 != (-32)) goto L28;
            if (r109 < (-96)) goto L32;
        L28:
            if (r104 != (-19)) goto L30;
            if (r109 >= (-96)) goto L32;
        L30:
            r101 = r108 + 1;
            if (r100[r108] <= (-65)) goto L2;
        L32:
            return -1;
        L21:
            return Utf8.access$400(r100, r103, r102);
        L9:
            if (r103 >= r102) goto L10;
            if (r104 < (-62)) goto L15;
            r101 = r103 + 1;
            if (r100[r103] <= (-65)) goto L2;
        L15:
            return -1;
        L10:
            return r104;
        L46:
            r101 = r103;
            goto L2
        L3:
            return 0;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence r100, byte[] r101, int r110, int r111) {
            int r102 = r100.length();
            int r112 = r111 + r110;
            int r103 = 0;
        L4:
            if (r103 >= r102) goto L10;
            int r104 = r103 + r110;
            if (r104 >= r112) goto L10;
            char r105 = r100.charAt(r103);
            if (r105 >= 128) goto L10;
            r101[r104] = (byte) r105;
            r103 = r103 + 1;
        L10:
            if (r103 == r102) goto L12;
            int r113 = r110 + r103;
        L14:
            if (r103 >= r102) goto L52;
            char r106 = r100.charAt(r103);
            if (r106 >= 128) goto L21;
            if (r113 >= r112) goto L21;
            int r107 = r113 + 1;
            r101[r113] = (byte) r106;
        L19:
            r113 = r107;
        L38:
            r103 = r103 + 1;
        L21:
            if (r106 >= 2048) goto L26;
            if (r113 > (r112 - 2)) goto L26;
            int r108 = r113 + 1;
            r101[r113] = (byte) ((r106 >>> 6) | 960);
            r113 = r108 + 1;
            r101[r108] = (byte) ((r106 & '?') | 128);
        L26:
            if (r106 < 55296) goto L29;
            if (57343 < r106) goto L29;
        L32:
            if (r113 > (r112 - 4)) goto L42;
            int r109 = r103 + 1;
            if (r109 == r100.length()) goto L41;
            char r114 = r100.charAt(r109);
            if (Character.isSurrogatePair(r106, r114) == false) goto L39;
            int r115 = Character.toCodePoint(r106, r114);
            int r116 = r113 + 1;
            r101[r113] = (byte) ((r115 >>> 18) | 240);
            int r117 = r116 + 1;
            r101[r116] = (byte) (((r115 >>> 12) & 63) | 128);
            int r118 = r117 + 1;
            r101[r117] = (byte) (((r115 >>> 6) & 63) | 128);
            r113 = r118 + 1;
            r101[r118] = (byte) ((r115 & 63) | 128);
            r103 = r109;
            goto L38
        L39:
            r103 = r109;
        L41:
            throw new UnpairedSurrogateException(r103 - 1, r102);
        L42:
            if (55296 > r106) goto L51;
            if (r106 > 57343) goto L51;
            int r119 = r103 + 1;
            if (r119 == r100.length()) goto L49;
            if (Character.isSurrogatePair(r106, r100.charAt(r119)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r103, r102);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r106 + " at index " + r113);
        L29:
            if (r113 > (r112 - 3)) goto L32;
            int r120 = r113 + 1;
            r101[r113] = (byte) ((r106 >>> '\f') | 480);
            int r121 = r120 + 1;
            r101[r120] = (byte) (((r106 >>> 6) & 63) | 128);
            r107 = r121 + 1;
            r101[r121] = (byte) ((r106 & '?') | 128);
            goto L19
        L52:
            return r113;
        L12:
            return r110 + r102;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r100, byte[] r101, int r102, int r110) {
            if (r100 == 0) goto L55;
            if (r102 < r110) goto L5;
            return r100;
        L5:
            byte r103 = (byte) r100;
            if (r103 >= (-32)) goto L15;
            if (r103 < (-62)) goto L13;
            int r104 = r102 + 1;
            if (r101[r102] > (-65)) goto L13;
        L12:
            r102 = r104;
        L13:
            return -1;
        L15:
            if (r103 >= (-16)) goto L33;
            byte r105 = (byte) (~(r100 >> 8));
            if (r105 != 0) goto L23;
            int r106 = r102 + 1;
            byte r107 = r101[r102];
            if (r106 >= r110) goto L21;
            r102 = r106;
            r105 = r107;
            goto L23
        L21:
            return Utf8.access$000(r103, r107);
        L23:
            if (r105 <= (-65)) goto L25;
        L32:
            return -1;
        L25:
            if (r103 != (-32)) goto L28;
            if (r105 < (-96)) goto L32;
        L28:
            if (r103 != (-19)) goto L30;
            if (r105 >= (-96)) goto L32;
        L30:
            r104 = r102 + 1;
            if (r101[r102] <= (-65)) goto L12;
        L33:
            byte r108 = (byte) (~(r100 >> 8));
            if (r108 != 0) goto L40;
            int r109 = r102 + 1;
            r108 = r101[r102];
            if (r109 >= r110) goto L38;
            byte r111 = 0;
        L41:
            if (r111 != 0) goto L47;
            int r112 = r109 + 1;
            byte r113 = r101[r109];
            if (r112 >= r110) goto L45;
            r111 = r113;
            r109 = r112;
            goto L47
        L45:
            return Utf8.access$100(r103, r108, r113);
        L47:
            if (r108 <= (-65)) goto L49;
        L53:
            return -1;
        L49:
            if ((((r103 << 28) + (r108 + 112)) >> 30) != 0) goto L53;
            if (r111 > (-65)) goto L53;
            r102 = r109 + 1;
            if (r101[r109] <= (-65)) goto L55;
        L38:
            return Utf8.access$000(r103, r108);
        L40:
            r111 = (byte) (r100 >> 16);
            r109 = r102;
        L55:
            return partialIsValidUtf8(r101, r102, r110);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r100, ByteBuffer r101, int r102, int r103) {
            return partialIsValidUtf8Default(r100, r101, r102, r103);
        }
    }

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r100, int r101) {
            super("Unpaired surrogate at index " + r100 + " of " + r101);
        }
    }

    public static final class UnsafeProcessor extends Processor {
        public static boolean isAvailable() {
            if (UnsafeUtil.hasUnsafeArrayOperations() == true) goto L5;
        L7:
            return false;
        L5:
            if (UnsafeUtil.hasUnsafeByteBufferOperations() == false) goto L7;
            return true;
        }

        public UnsafeProcessor() {
        }

        private static int partialIsValidUtf8(long r100, int r110) {
            int r101 = unsafeEstimateConsecutiveAscii(r100, r110);
            long r102 = r100 + ((long) r101);
            int r111 = r110 - r101;
        L3:
            byte r103 = 0;
        L5:
            if (r111 <= 0) goto L10;
            long r104 = r102 + 1;
            r103 = UnsafeUtil.getByte(r102);
            if (r103 < 0) goto L9;
            r111 = r111 - 1;
            r102 = r104;
            goto L5
        L9:
            r102 = r104;
        L10:
            if (r111 == 0) goto L11;
            int r112 = r111 - 1;
            if (r103 >= (-32)) goto L24;
            if (r112 == 0) goto L15;
            r111 = r112 - 1;
            if (r103 < (-62)) goto L22;
            long r105 = 1 + r102;
            if (UnsafeUtil.getByte(r102) > (-65)) goto L22;
        L21:
            r102 = r105;
        L22:
            return -1;
        L15:
            return r103;
        L24:
            if (r103 >= (-16)) goto L41;
            if (r112 < 2) goto L28;
            r111 = r112 - 2;
            long r106 = r102 + 1;
            byte r107 = UnsafeUtil.getByte(r102);
            if (r107 > (-65)) goto L39;
            if (r103 != (-32)) goto L35;
            if (r107 < (-96)) goto L39;
        L35:
            if (r103 != (-19)) goto L37;
            if (r107 >= (-96)) goto L39;
        L37:
            r105 = 1 + r106;
            if (UnsafeUtil.getByte(r106) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r102, r103, r112);
        L41:
            if (r112 < 3) goto L43;
            r111 = r112 - 3;
            long r108 = r102 + 1;
            byte r109 = UnsafeUtil.getByte(r102);
            if (r109 > (-65)) goto L52;
            if ((((r103 << 28) + (r109 + 112)) >> 30) != 0) goto L52;
            long r113 = r108 + 1;
            if (UnsafeUtil.getByte(r108) > (-65)) goto L52;
            r105 = 1 + r113;
            if (UnsafeUtil.getByte(r113) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r102, r103, r112);
        L11:
            return 0;
        }

        private static int unsafeEstimateConsecutiveAscii(long r100, int r101) {
            if (r101 >= 16) goto L6;
            return 0;
        L6:
            int r102 = 8 - (((int) r100) & 7);
            int r103 = r102;
        L7:
            if (r103 <= 0) goto L13;
            long r104 = 1 + r100;
            if (UnsafeUtil.getByte(r100) < 0) goto L11;
            r103 = r103 - 1;
            r100 = r104;
            goto L7
        L11:
            return r102 - r103;
        L13:
            int r105 = r101 - r102;
        L14:
            if (r105 < 8) goto L19;
            if ((UnsafeUtil.getLong(r100) & (-9187201950435737472L)) != 0) goto L19;
            r100 = r100 + 8;
            r105 = r105 - 8;
        L19:
            return r101 - r105;
        }

        @Override // com.google.protobuf.Utf8.Processor
        public void encodeUtf8Direct(CharSequence r210, ByteBuffer r211) {
            long r100 = UnsafeUtil.addressOffset(r211);
            long r101 = ((long) r211.position()) + r100;
            long r102 = ((long) r211.limit()) + r100;
            int r103 = r210.length();
            if (r103 > (r102 - r101)) goto L55;
            int r104 = 0;
        L5:
            char r110 = 128;
            if (r104 >= r103) goto L10;
            char r111 = r210.charAt(r104);
            if (r111 >= 128) goto L10;
            UnsafeUtil.putByte(r101, (byte) r111);
            r104 = r104 + 1;
            r101 = r101 + 1;
        L10:
            if (r104 != r103) goto L13;
            r211.position((int) (r101 - r100));
            return;
        L13:
            if (r104 >= r103) goto L52;
            char r112 = r210.charAt(r104);
            if (r112 >= r110) goto L20;
            if (r101 >= r102) goto L20;
            UnsafeUtil.putByte(r101, (byte) r112);
            r101 = r101 + 1;
            long r113 = r100;
        L38:
            r104 = r104 + 1;
            r100 = r113;
            r110 = 128;
        L20:
            if (r112 < 2048) goto L22;
        L25:
            r113 = r100;
            if (r112 < 55296) goto L29;
            if (57343 < r112) goto L29;
        L32:
            if (r101 > (r102 - 4)) goto L42;
            int r105 = r104 + 1;
            if (r105 == r103) goto L41;
            char r106 = r210.charAt(r105);
            if (Character.isSurrogatePair(r112, r106) == false) goto L39;
            int r107 = Character.toCodePoint(r112, r106);
            long r108 = r101 + 1;
            UnsafeUtil.putByte(r101, (byte) ((r107 >>> 18) | 240));
            long r109 = r108 + 1;
            UnsafeUtil.putByte(r108, (byte) (((r107 >>> 12) & 63) | 128));
            long r114 = r109 + 1;
            UnsafeUtil.putByte(r109, (byte) (((r107 >>> 6) & 63) | 128));
            long r115 = r114 + 1;
            UnsafeUtil.putByte(r114, (byte) ((r107 & 63) | 128));
            r104 = r105;
            r101 = r115;
            goto L38
        L39:
            r104 = r105;
        L41:
            throw new UnpairedSurrogateException(r104 - 1, r103);
        L42:
            if (55296 > r112) goto L51;
            if (r112 > 57343) goto L51;
            int r116 = r104 + 1;
            if (r116 == r103) goto L49;
            if (Character.isSurrogatePair(r112, r210.charAt(r116)) == true) goto L51;
        L49:
            throw new UnpairedSurrogateException(r104, r103);
        L51:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r112 + " at index " + r101);
        L29:
            if (r101 > (r102 - 3)) goto L32;
            long r117 = r101 + 1;
            UnsafeUtil.putByte(r101, (byte) ((r112 >>> '\f') | 480));
            long r118 = r117 + 1;
            UnsafeUtil.putByte(r117, (byte) (((r112 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r118, (byte) ((r112 & '?') | 128));
            r101 = r118 + 1;
            goto L38
        L22:
            if (r101 > (r102 - 2)) goto L25;
            r113 = r100;
            long r119 = r101 + 1;
            UnsafeUtil.putByte(r101, (byte) ((r112 >>> 6) | 960));
            UnsafeUtil.putByte(r119, (byte) ((r112 & '?') | 128));
            r101 = r119 + 1;
            goto L38
        L52:
            r211.position((int) (r101 - r100));
            return;
        L55:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r210.charAt(r103 - 1) + " at index " + r211.limit());
        }

        private static int partialIsValidUtf8(byte[] r100, long r101, int r110) {
            int r102 = unsafeEstimateConsecutiveAscii(r100, r101, r110);
            int r111 = r110 - r102;
            long r103 = r101 + ((long) r102);
        L3:
            byte r104 = 0;
        L5:
            if (r111 <= 0) goto L10;
            long r105 = r103 + 1;
            r104 = UnsafeUtil.getByte(r100, r103);
            if (r104 < 0) goto L9;
            r111 = r111 - 1;
            r103 = r105;
            goto L5
        L9:
            r103 = r105;
        L10:
            if (r111 == 0) goto L11;
            int r112 = r111 - 1;
            if (r104 >= (-32)) goto L24;
            if (r112 == 0) goto L15;
            r111 = r112 - 1;
            if (r104 < (-62)) goto L22;
            long r106 = 1 + r103;
            if (UnsafeUtil.getByte(r100, r103) > (-65)) goto L22;
        L21:
            r103 = r106;
        L22:
            return -1;
        L15:
            return r104;
        L24:
            if (r104 >= (-16)) goto L41;
            if (r112 < 2) goto L28;
            r111 = r112 - 2;
            long r107 = r103 + 1;
            byte r108 = UnsafeUtil.getByte(r100, r103);
            if (r108 > (-65)) goto L39;
            if (r104 != (-32)) goto L35;
            if (r108 < (-96)) goto L39;
        L35:
            if (r104 != (-19)) goto L37;
            if (r108 >= (-96)) goto L39;
        L37:
            r106 = 1 + r107;
            if (UnsafeUtil.getByte(r100, r107) <= (-65)) goto L21;
        L39:
            return -1;
        L28:
            return unsafeIncompleteStateFor(r100, r104, r103, r112);
        L41:
            if (r112 < 3) goto L43;
            r111 = r112 - 3;
            long r109 = r103 + 1;
            byte r113 = UnsafeUtil.getByte(r100, r103);
            if (r113 > (-65)) goto L52;
            if ((((r104 << 28) + (r113 + 112)) >> 30) != 0) goto L52;
            long r114 = r109 + 1;
            if (UnsafeUtil.getByte(r100, r109) > (-65)) goto L52;
            r106 = 1 + r114;
            if (UnsafeUtil.getByte(r100, r114) <= (-65)) goto L21;
        L52:
            return -1;
        L43:
            return unsafeIncompleteStateFor(r100, r104, r103, r112);
        L11:
            return 0;
        }

        private static int unsafeEstimateConsecutiveAscii(byte[] r100, long r101, int r102) {
            int r103 = 0;
            if (r102 >= 16) goto L5;
            return 0;
        L5:
            if (r103 >= r102) goto L10;
            long r104 = 1 + r101;
            if (UnsafeUtil.getByte(r100, r101) < 0) goto L8;
            r103 = r103 + 1;
            r101 = r104;
            goto L5
        L8:
            return r103;
        L10:
            return r102;
        }

        private static int unsafeIncompleteStateFor(long r100, int r101, int r102) {
            if (r102 == 0) goto L14;
            if (r102 == 1) goto L12;
            if (r102 != 2) goto L10;
            return Utf8.access$100(r101, UnsafeUtil.getByte(r100), UnsafeUtil.getByte(r100 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r101, UnsafeUtil.getByte(r100));
        L14:
            return Utf8.access$500(r101);
        }

        private static int unsafeIncompleteStateFor(byte[] r100, int r101, long r102, int r103) {
            if (r103 == 0) goto L14;
            if (r103 == 1) goto L12;
            if (r103 != 2) goto L10;
            return Utf8.access$100(r101, UnsafeUtil.getByte(r100, r102), UnsafeUtil.getByte(r100, r102 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.access$000(r101, UnsafeUtil.getByte(r100, r102));
        L14:
            return Utf8.access$500(r101);
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int encodeUtf8(CharSequence r210, byte[] r211, int r212, int r213) {
            long r100 = r212;
            long r101 = ((long) r213) + r100;
            int r102 = r210.length();
            if (r102 > r213) goto L57;
            if ((r211.length - r213) < r212) goto L57;
            int r103 = 0;
        L7:
            char r104 = 128;
            long r110 = 1;
            if (r103 >= r102) goto L12;
            char r111 = r210.charAt(r103);
            if (r111 >= 128) goto L12;
            UnsafeUtil.putByte(r211, r100, (byte) r111);
            r103 = r103 + 1;
            r100 = 1 + r100;
        L12:
            if (r103 == r102) goto L14;
        L15:
            if (r103 >= r102) goto L55;
            char r112 = r210.charAt(r103);
            if (r112 >= r104) goto L23;
            if (r100 >= r101) goto L23;
            long r113 = r100 + r110;
            UnsafeUtil.putByte(r211, r100, (byte) r112);
            long r105 = r110;
            long r114 = r113;
        L40:
            r103 = r103 + 1;
            r104 = 128;
            long r214 = r105;
            r100 = r114;
            r110 = r214;
        L23:
            if (r112 >= 2048) goto L28;
            if (r100 > (r101 - 2)) goto L28;
            long r115 = r100 + r110;
            UnsafeUtil.putByte(r211, r100, (byte) ((r112 >>> 6) | 960));
            UnsafeUtil.putByte(r211, r115, (byte) ((r112 & '?') | 128));
            r114 = r115 + r110;
            r105 = r110;
        L28:
            if (r112 < 55296) goto L31;
            if (57343 < r112) goto L31;
        L34:
            if (r100 > (r101 - 4)) goto L44;
            int r106 = r103 + 1;
            if (r106 == r102) goto L43;
            char r107 = r210.charAt(r106);
            if (Character.isSurrogatePair(r112, r107) == false) goto L41;
            int r108 = Character.toCodePoint(r112, r107);
            long r116 = r100 + 1;
            UnsafeUtil.putByte(r211, r100, (byte) ((r108 >>> 18) | 240));
            long r109 = r116 + 1;
            UnsafeUtil.putByte(r211, r116, (byte) (((r108 >>> 12) & 63) | 128));
            long r117 = r109 + 1;
            UnsafeUtil.putByte(r211, r109, (byte) (((r108 >>> 6) & 63) | 128));
            r105 = 1;
            r114 = r117 + 1;
            UnsafeUtil.putByte(r211, r117, (byte) ((r108 & 63) | 128));
            r103 = r106;
            goto L40
        L41:
            r103 = r106;
        L43:
            throw new UnpairedSurrogateException(r103 - 1, r102);
        L44:
            if (55296 > r112) goto L53;
            if (r112 > 57343) goto L53;
            int r118 = r103 + 1;
            if (r118 == r102) goto L51;
            if (Character.isSurrogatePair(r112, r210.charAt(r118)) == true) goto L53;
        L51:
            throw new UnpairedSurrogateException(r103, r102);
        L53:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r112 + " at index " + r100);
        L31:
            if (r100 > (r101 - 3)) goto L34;
            long r119 = r100 + r110;
            UnsafeUtil.putByte(r211, r100, (byte) ((r112 >>> '\f') | 480));
            long r120 = r119 + r110;
            UnsafeUtil.putByte(r211, r119, (byte) (((r112 >>> 6) & 63) | 128));
            UnsafeUtil.putByte(r211, r120, (byte) ((r112 & '?') | 128));
            r114 = r120 + 1;
            r105 = 1;
            goto L40
        L55:
            return (int) r100;
        L14:
            return (int) r100;
        L57:
            throw new ArrayIndexOutOfBoundsException("Failed writing " + r210.charAt(r102 - 1) + " at index " + (r212 + r213));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8(int r110, byte[] r111, int r112, int r113) {
            byte r100 = 0;
            if (((r112 | r113) | (r111.length - r113)) < 0) goto L63;
            long r101 = r112;
            long r114 = r113;
            if (r110 == 0) goto L61;
            if (r101 < r114) goto L9;
            return r110;
        L9:
            byte r102 = (byte) r110;
            if (r102 >= (-32)) goto L19;
            if (r102 < (-62)) goto L17;
            long r103 = 1 + r101;
            if (UnsafeUtil.getByte(r111, r101) > (-65)) goto L17;
            r101 = r103;
        L17:
            return -1;
        L19:
            if (r102 >= (-16)) goto L39;
            byte r115 = (byte) (~(r110 >> 8));
            if (r115 != 0) goto L27;
            long r104 = r101 + 1;
            r115 = UnsafeUtil.getByte(r111, r101);
            if (r104 >= r114) goto L25;
            r101 = r104;
            goto L27
        L25:
            return Utf8.access$000(r102, r115);
        L27:
            if (r115 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r102 != (-32)) goto L32;
            if (r115 < (-96)) goto L38;
        L32:
            if (r102 != (-19)) goto L34;
            if (r115 >= (-96)) goto L38;
        L34:
            long r105 = r101 + 1;
            if (UnsafeUtil.getByte(r111, r101) > (-65)) goto L38;
        L37:
            r101 = r105;
            goto L61
        L39:
            byte r106 = (byte) (~(r110 >> 8));
            if (r106 != 0) goto L46;
            long r107 = r101 + 1;
            r106 = UnsafeUtil.getByte(r111, r101);
            if (r107 >= r114) goto L44;
            r101 = r107;
        L47:
            if (r100 != 0) goto L53;
            long r108 = r101 + 1;
            r100 = UnsafeUtil.getByte(r111, r101);
            if (r108 >= r114) goto L51;
            r101 = r108;
            goto L53
        L51:
            return Utf8.access$100(r102, r106, r100);
        L53:
            if (r106 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r102 << 28) + (r106 + 112)) >> 30) != 0) goto L59;
            if (r100 > (-65)) goto L59;
            r105 = r101 + 1;
            if (UnsafeUtil.getByte(r111, r101) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r102, r106);
        L46:
            r100 = (byte) (r110 >> 16);
        L61:
            return partialIsValidUtf8(r111, r101, (int) (r114 - r101));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r111.length), Integer.valueOf(r112), Integer.valueOf(r113)}));
        }

        @Override // com.google.protobuf.Utf8.Processor
        public int partialIsValidUtf8Direct(int r110, ByteBuffer r111, int r112, int r113) {
            byte r100 = 0;
            if (((r112 | r113) | (r111.limit() - r113)) < 0) goto L63;
            long r101 = UnsafeUtil.addressOffset(r111) + ((long) r112);
            long r114 = ((long) (r113 - r112)) + r101;
            if (r110 == 0) goto L61;
            if (r101 < r114) goto L9;
            return r110;
        L9:
            byte r115 = (byte) r110;
            if (r115 >= (-32)) goto L19;
            if (r115 < (-62)) goto L17;
            long r102 = 1 + r101;
            if (UnsafeUtil.getByte(r101) > (-65)) goto L17;
            r101 = r102;
        L17:
            return -1;
        L19:
            if (r115 >= (-16)) goto L39;
            byte r116 = (byte) (~(r110 >> 8));
            if (r116 != 0) goto L27;
            long r103 = r101 + 1;
            r116 = UnsafeUtil.getByte(r101);
            if (r103 >= r114) goto L25;
            r101 = r103;
            goto L27
        L25:
            return Utf8.access$000(r115, r116);
        L27:
            if (r116 <= (-65)) goto L29;
        L38:
            return -1;
        L29:
            if (r115 != (-32)) goto L32;
            if (r116 < (-96)) goto L38;
        L32:
            if (r115 != (-19)) goto L34;
            if (r116 >= (-96)) goto L38;
        L34:
            long r104 = r101 + 1;
            if (UnsafeUtil.getByte(r101) > (-65)) goto L38;
        L37:
            r101 = r104;
            goto L61
        L39:
            byte r105 = (byte) (~(r110 >> 8));
            if (r105 != 0) goto L46;
            long r106 = r101 + 1;
            r105 = UnsafeUtil.getByte(r101);
            if (r106 >= r114) goto L44;
            r101 = r106;
        L47:
            if (r100 != 0) goto L53;
            long r107 = r101 + 1;
            r100 = UnsafeUtil.getByte(r101);
            if (r107 >= r114) goto L51;
            r101 = r107;
            goto L53
        L51:
            return Utf8.access$100(r115, r105, r100);
        L53:
            if (r105 <= (-65)) goto L55;
        L59:
            return -1;
        L55:
            if ((((r115 << 28) + (r105 + 112)) >> 30) != 0) goto L59;
            if (r100 > (-65)) goto L59;
            r104 = r101 + 1;
            if (UnsafeUtil.getByte(r101) <= (-65)) goto L37;
        L44:
            return Utf8.access$000(r115, r105);
        L46:
            r100 = (byte) (r110 >> 16);
        L61:
            return partialIsValidUtf8(r101, (int) (r114 - r101));
        L63:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r111.limit()), Integer.valueOf(r112), Integer.valueOf(r113)}));
        }
    }

    private Utf8() {
    }

    private static int incompleteStateFor(int r100) {
        if (r100 <= (-12)) goto L6;
        return -1;
    L6:
        return r100;
    }

    private static int incompleteStateFor(int r100, int r101) {
        if (r100 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r101 > (-65)) goto L8;
        return r100 ^ (r101 << 8);
    }

    private static int incompleteStateFor(int r100, int r101, int r102) {
        if (r100 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r101 > (-65)) goto L9;
        if (r102 > (-65)) goto L9;
        return (r100 ^ (r101 << 8)) ^ (r102 << 16);
    }

    static {
        if (UnsafeProcessor.isAvailable() == false) goto L5;
        Processor r100 = new UnsafeProcessor();
    L6:
        processor = r100;
        return;
    L5:
        r100 = new SafeProcessor();
        goto L6
    }

    public static /* synthetic */ int access$500(int r100) {
        return incompleteStateFor(r100);
    }

    public static int encodedLength(CharSequence r100) {
        int r101 = r100.length();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L7;
        if (r100.charAt(r102) >= 128) goto L7;
        r102 = r102 + 1;
    L7:
        int r103 = r101;
    L8:
        if (r102 >= r101) goto L13;
        char r104 = r100.charAt(r102);
        if (r104 >= 2048) goto L12;
        r103 = r103 + ((127 - r104) >>> 31);
        r102 = r102 + 1;
        goto L8
    L12:
        r103 = r103 + encodedLengthGeneral(r100, r102);
    L13:
        if (r103 < r101) goto L16;
        return r103;
    L16:
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) r103) + 4294967296L));
    }

    public static boolean isValidUtf8(ByteBuffer r100) {
        return processor.isValidUtf8(r100, r100.position(), r100.remaining());
    }

    public static boolean isValidUtf8(byte[] r100) {
        return processor.isValidUtf8(r100, 0, r100.length);
    }

    public static /* synthetic */ int access$000(int r100, int r101) {
        return incompleteStateFor(r100, r101);
    }

    public static void encodeUtf8(CharSequence r100, ByteBuffer r101) {
        processor.encodeUtf8(r100, r101);
    }

    private static int encodedLengthGeneral(CharSequence r100, int r101) {
        int r102 = r100.length();
        int r103 = 0;
    L3:
        if (r101 >= r102) goto L17;
        char r104 = r100.charAt(r101);
        if (r104 >= 2048) goto L7;
        r103 = r103 + ((127 - r104) >>> 31);
    L16:
        r101 = r101 + 1;
        goto L3
    L7:
        r103 = r103 + 2;
        if (55296 > r104) goto L16;
        if (r104 > 57343) goto L16;
        if (Character.codePointAt(r100, r101) < 65536) goto L15;
        r101 = r101 + 1;
        goto L16
    L15:
        throw new UnpairedSurrogateException(r101, r102);
    L17:
        return r103;
    }

    public static /* synthetic */ int access$100(int r100, int r101, int r102) {
        return incompleteStateFor(r100, r101, r102);
    }

    public static /* synthetic */ int access$200(ByteBuffer r100, int r101, int r102) {
        return estimateConsecutiveAscii(r100, r101, r102);
    }

    public static /* synthetic */ int access$400(byte[] r100, int r101, int r102) {
        return incompleteStateFor(r100, r101, r102);
    }

    private static int estimateConsecutiveAscii(ByteBuffer r100, int r101, int r102) {
        int r103 = r102 - 7;
        int r104 = r101;
    L3:
        if (r104 >= r103) goto L8;
        if ((r100.getLong(r104) & (-9187201950435737472L)) != 0) goto L8;
        r104 = r104 + 8;
    L8:
        return r104 - r101;
    }

    private static int incompleteStateFor(byte[] r100, int r101, int r102) {
        byte r103 = r100[r101 - 1];
        int r104 = r102 - r101;
        if (r104 == 0) goto L15;
        if (r104 == 1) goto L13;
        if (r104 != 2) goto L11;
        return incompleteStateFor(r103, r100[r101], r100[r101 + 1]);
    L11:
        throw new AssertionError();
    L13:
        return incompleteStateFor(r103, r100[r101]);
    L15:
        return incompleteStateFor(r103);
    }

    public static boolean isValidUtf8(byte[] r100, int r101, int r102) {
        return processor.isValidUtf8(r100, r101, r102);
    }

    public static /* synthetic */ int access$300(ByteBuffer r100, int r101, int r102, int r103) {
        return incompleteStateFor(r100, r101, r102, r103);
    }

    public static int encode(CharSequence r100, byte[] r101, int r102, int r103) {
        return processor.encodeUtf8(r100, r101, r102, r103);
    }

    private static int incompleteStateFor(ByteBuffer r100, int r101, int r102, int r103) {
        if (r103 == 0) goto L14;
        if (r103 == 1) goto L12;
        if (r103 != 2) goto L10;
        return incompleteStateFor(r101, r100.get(r102), r100.get(r102 + 1));
    L10:
        throw new AssertionError();
    L12:
        return incompleteStateFor(r101, r100.get(r102));
    L14:
        return incompleteStateFor(r101);
    }

    public static int partialIsValidUtf8(int r100, ByteBuffer r101, int r102, int r103) {
        return processor.partialIsValidUtf8(r100, r101, r102, r103);
    }

    public static int partialIsValidUtf8(int r100, byte[] r101, int r102, int r103) {
        return processor.partialIsValidUtf8(r100, r101, r102, r103);
    }
}
