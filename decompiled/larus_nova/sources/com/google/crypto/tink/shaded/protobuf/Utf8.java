package com.google.crypto.tink.shaded.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes23.dex */
public final class Utf8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f275849a = null;

    public static class UnpairedSurrogateException extends IllegalArgumentException {
        public UnpairedSurrogateException(int r100, int r101) {
            super("Unpaired surrogate at index " + r100 + " of " + r101);
        }
    }

    public static class a {
        public static boolean d(byte r100) {
            if (r100 <= (-65)) goto L5;
            return true;
        L5:
            return false;
        }

        public static void b(byte r100, byte r101, char[] r102, int r103) throws InvalidProtocolBufferException {
            if (r100 < (-62)) goto L9;
            if (d(r101) == true) goto L9;
            r102[r103] = (char) (((r100 & 31) << 6) | (r101 & 63));
            return;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        public static void c(byte r100, byte r101, byte r102, char[] r103, int r104) throws InvalidProtocolBufferException {
            if (d(r101) == true) goto L15;
            if (r100 != (-32)) goto L8;
            if (r101 < (-96)) goto L15;
        L8:
            if (r100 != (-19)) goto L11;
            if (r101 >= (-96)) goto L15;
        L11:
            if (d(r102) == true) goto L15;
            r103[r104] = (char) ((((r100 & 15) << 12) | ((r101 & 63) << 6)) | (r102 & 63));
            return;
        L15:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        public static void a(byte r100, byte r101, byte r102, byte r103, char[] r104, int r105) throws InvalidProtocolBufferException {
            if (d(r101) == true) goto L13;
            if ((((r100 << 28) + (r101 + 112)) >> 30) != 0) goto L13;
            if (d(r102) == true) goto L13;
            if (d(r103) == true) goto L13;
            int r106 = ((((r100 & 7) << 18) | ((r101 & 63) << 12)) | ((r102 & 63) << 6)) | (r103 & 63);
            r104[r105] = (char) ((r106 >>> 10) + 55232);
            r104[r105 + 1] = (char) ((r106 & 1023) + 56320);
            return;
        L13:
            throw InvalidProtocolBufferException.invalidUtf8();
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract String a(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException;

        public abstract String c(ByteBuffer r100, int r101, int r102) throws InvalidProtocolBufferException;

        public abstract int e(int r100, byte[] r101, int r102, int r103);

        public abstract int g(int r100, ByteBuffer r101, int r102, int r103);

        public static String b(ByteBuffer r110, int r111, int r112) throws InvalidProtocolBufferException {
            if (((r111 | r112) | ((r110.limit() - r111) - r112)) < 0) goto L57;
            int r100 = r111 + r112;
            char[] r113 = new char[r112];
            int r101 = 0;
        L5:
            if (r111 >= r100) goto L13;
            byte r102 = r110.get(r111);
            if (r102 < 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L13;
            r111 = r111 + 1;
            r113[r101] = (char) r102;
            r101 = r101 + 1;
            goto L5
        L9:
            r103 = false;
        L13:
            int r104 = r101;
        L14:
            if (r111 >= r100) goto L55;
            int r105 = r111 + 1;
            byte r114 = r110.get(r111);
            if (r114 < 0) goto L18;
            boolean r106 = true;
        L19:
            if (r106 == true) goto L20;
            if (r114 >= (-32)) goto L33;
            boolean r107 = true;
        L34:
            if (r107 == true) goto L35;
            if (r114 >= (-16)) goto L42;
            boolean r108 = true;
        L43:
            if (r108 == true) goto L45;
            if (r105 >= (r100 - 2)) goto L53;
            int r109 = r105 + 1;
            byte r115 = r110.get(r105);
            int r116 = r109 + 1;
            a.a(r114, r115, r110.get(r109), r110.get(r116), r113, r104);
            r104 = (r104 + 1) + 1;
            r111 = r116 + 1;
            goto L14
        L53:
            throw InvalidProtocolBufferException.invalidUtf8();
        L45:
            if (r105 >= (r100 - 1)) goto L48;
            int r117 = r105 + 1;
            a.c(r114, r110.get(r105), r110.get(r117), r113, r104);
            r111 = r117 + 1;
            r104 = r104 + 1;
            goto L14
        L48:
            throw InvalidProtocolBufferException.invalidUtf8();
        L42:
            r108 = false;
            goto L43
        L35:
            if (r105 >= r100) goto L38;
            a.b(r114, r110.get(r105), r113, r104);
            r111 = r105 + 1;
            r104 = r104 + 1;
            goto L14
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L33:
            r107 = false;
            goto L34
        L20:
            int r118 = r104 + 1;
            r113[r104] = (char) r114;
            r111 = r105;
        L21:
            r104 = r118;
            if (r111 >= r100) goto L14;
            byte r119 = r110.get(r111);
            if (r119 < 0) goto L26;
            boolean r120 = true;
        L27:
            if (r120 == false) goto L14;
            r111 = r111 + 1;
            r118 = r104 + 1;
            r113[r104] = (char) r119;
            goto L21
        L26:
            r120 = false;
            goto L27
        L18:
            r106 = false;
            goto L19
        L55:
            return new String(r113, 0, r104);
        L57:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r110.limit()), Integer.valueOf(r111), Integer.valueOf(r112)}));
        }

        public static int f(int r110, ByteBuffer r210, int r211, int r212) {
            int r100 = r211;
            if (r110 == 0) goto L51;
            if (r100 < r212) goto L6;
            return r110;
        L6:
            byte r111 = (byte) r110;
            if (r111 >= (-32)) goto L14;
            if (r111 < (-62)) goto L13;
            int r101 = r100 + 1;
            if (r210.get(r211) > (-65)) goto L13;
            r100 = r101;
        L13:
            return -1;
        L14:
            if (r111 >= (-16)) goto L30;
            byte r102 = (byte) (~(r110 >> 8));
            if (r102 != 0) goto L21;
            int r103 = r100 + 1;
            byte r104 = r210.get(r211);
            if (r103 >= r212) goto L20;
        L22:
            if (r104 > (-65)) goto L29;
            if (r111 != (-32)) goto L25;
            if (r104 < (-96)) goto L29;
        L25:
            if (r111 != (-19)) goto L27;
            if (r104 >= (-96)) goto L29;
        L27:
            r100 = r103 + 1;
            if (r210.get(r103) <= (-65)) goto L51;
        L29:
            return -1;
        L20:
            return Utf8.d(r111, r104);
        L21:
            r104 = r102;
            r103 = r100;
            goto L22
        L30:
            byte r112 = (byte) (~(r110 >> 8));
            if (r112 != 0) goto L37;
            int r105 = r100 + 1;
            r112 = r210.get(r211);
            if (r105 >= r212) goto L35;
            byte r106 = 0;
        L38:
            if (r106 != 0) goto L44;
            int r107 = r105 + 1;
            byte r108 = r210.get(r105);
            if (r107 >= r212) goto L42;
            r106 = r108;
            r105 = r107;
            goto L44
        L42:
            return Utf8.e(r111, r112, r108);
        L44:
            if (r112 <= (-65)) goto L46;
        L50:
            return -1;
        L46:
            if ((((r111 << 28) + (r112 + 112)) >> 30) != 0) goto L50;
            if (r106 > (-65)) goto L50;
            r100 = r105 + 1;
            if (r210.get(r105) <= (-65)) goto L51;
        L35:
            return Utf8.d(r111, r112);
        L37:
            r106 = (byte) (r110 >> 16);
            r105 = r100;
        L51:
            b r109 = Utf8.f275849a;
            int r113 = r212 - 7;
            int r114 = r100;
        L52:
            if (r114 >= r113) goto L56;
            if ((r210.getLong(r114) & (-9187201950435737472L)) != 0) goto L56;
            r114 = r114 + 8;
        L56:
            int r115 = r100 + (r114 - r100);
        L57:
            if (r115 >= r212) goto L125;
            int r116 = r115 + 1;
            byte r117 = r210.get(r115);
            if (r117 >= 0) goto L96;
            if (r117 >= (-32)) goto L69;
            if (r116 >= r212) goto L122;
            if (r117 < (-62)) goto L94;
            if (r210.get(r116) > (-65)) goto L94;
            r116 = r116 + 1;
        L94:
            return -1;
        L122:
            return r117;
        L69:
            if (r117 < (-16)) goto L71;
            if (r116 >= (r212 - 2)) goto L124;
            int r118 = r116 + 1;
            byte r119 = r210.get(r116);
            if (r119 > (-65)) goto L94;
            if ((((r117 << 28) + (r119 + 112)) >> 30) != 0) goto L94;
            int r120 = r118 + 1;
            if (r210.get(r118) > (-65)) goto L94;
            r115 = r120 + 1;
            if (r210.get(r120) <= (-65)) goto L57;
        L124:
            return Utf8.b(r210, r117, r116, r212 - r116);
        L71:
            if (r116 >= (r212 - 1)) goto L123;
            int r121 = r116 + 1;
            byte r122 = r210.get(r116);
            if (r122 > (-65)) goto L94;
            if (r117 != (-32)) goto L77;
            if (r122 < (-96)) goto L94;
        L77:
            if (r117 != (-19)) goto L80;
            if (r122 >= (-96)) goto L94;
        L80:
            if (r210.get(r121) > (-65)) goto L94;
            r115 = r121 + 1;
            goto L57
        L123:
            return Utf8.b(r210, r117, r116, r212 - r116);
        L96:
            r115 = r116;
            goto L57
        L125:
            return 0;
        }

        public final int d(int r100, ByteBuffer r101, int r102, int r103) {
            if (r101.hasArray() == false) goto L7;
            int r104 = r101.arrayOffset();
            return e(r100, r101.array(), r102 + r104, r104 + r103);
        L7:
            if (r101.isDirect() == false) goto L11;
            return g(r100, r101, r102, r103);
        L11:
            return f(r100, r101, r102, r103);
        }
    }

    public static final class c extends b {
        public c() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final String a(byte[] r110, int r111, int r112) throws InvalidProtocolBufferException {
            if (((r111 | r112) | ((r110.length - r111) - r112)) < 0) goto L57;
            int r100 = r111 + r112;
            char[] r113 = new char[r112];
            int r101 = 0;
        L5:
            if (r111 >= r100) goto L13;
            byte r102 = r110[r111];
            if (r102 < 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L13;
            r111 = r111 + 1;
            r113[r101] = (char) r102;
            r101 = r101 + 1;
            goto L5
        L9:
            r103 = false;
        L13:
            int r104 = r101;
        L14:
            if (r111 >= r100) goto L55;
            int r105 = r111 + 1;
            byte r114 = r110[r111];
            if (r114 < 0) goto L18;
            boolean r106 = true;
        L19:
            if (r106 == true) goto L20;
            if (r114 >= (-32)) goto L33;
            boolean r107 = true;
        L34:
            if (r107 == true) goto L35;
            if (r114 >= (-16)) goto L42;
            boolean r108 = true;
        L43:
            if (r108 == true) goto L45;
            if (r105 >= (r100 - 2)) goto L53;
            int r109 = r105 + 1;
            byte r115 = r110[r105];
            int r116 = r109 + 1;
            a.a(r114, r115, r110[r109], r110[r116], r113, r104);
            r104 = (r104 + 1) + 1;
            r111 = r116 + 1;
            goto L14
        L53:
            throw InvalidProtocolBufferException.invalidUtf8();
        L45:
            if (r105 >= (r100 - 1)) goto L48;
            int r117 = r105 + 1;
            a.c(r114, r110[r105], r110[r117], r113, r104);
            r111 = r117 + 1;
            r104 = r104 + 1;
            goto L14
        L48:
            throw InvalidProtocolBufferException.invalidUtf8();
        L42:
            r108 = false;
            goto L43
        L35:
            if (r105 >= r100) goto L38;
            a.b(r114, r110[r105], r113, r104);
            r111 = r105 + 1;
            r104 = r104 + 1;
            goto L14
        L38:
            throw InvalidProtocolBufferException.invalidUtf8();
        L33:
            r107 = false;
            goto L34
        L20:
            int r118 = r104 + 1;
            r113[r104] = (char) r114;
            r111 = r105;
        L21:
            r104 = r118;
            if (r111 >= r100) goto L14;
            byte r119 = r110[r111];
            if (r119 < 0) goto L26;
            boolean r120 = true;
        L27:
            if (r120 == false) goto L14;
            r111 = r111 + 1;
            r118 = r104 + 1;
            r113[r104] = (char) r119;
            goto L21
        L26:
            r120 = false;
            goto L27
        L18:
            r106 = false;
            goto L19
        L55:
            return new String(r113, 0, r104);
        L57:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(r110.length), Integer.valueOf(r111), Integer.valueOf(r112)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final String c(ByteBuffer r100, int r101, int r102) throws InvalidProtocolBufferException {
            return b.b(r100, r101, r102);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final int e(int r110, byte[] r111, int r112, int r113) {
            if (r110 == 0) goto L51;
            if (r112 < r113) goto L6;
            return r110;
        L6:
            byte r100 = (byte) r110;
            if (r100 >= (-32)) goto L14;
            if (r100 < (-62)) goto L13;
            int r114 = r112 + 1;
            if (r111[r112] > (-65)) goto L13;
        L12:
            r112 = r114;
        L13:
            return -1;
        L14:
            if (r100 >= (-16)) goto L30;
            byte r115 = (byte) (~(r110 >> 8));
            if (r115 != 0) goto L22;
            int r116 = r112 + 1;
            byte r117 = r111[r112];
            if (r116 >= r113) goto L20;
            r112 = r116;
            r115 = r117;
            goto L22
        L20:
            return Utf8.d(r100, r117);
        L22:
            if (r115 > (-65)) goto L29;
            if (r100 != (-32)) goto L25;
            if (r115 < (-96)) goto L29;
        L25:
            if (r100 != (-19)) goto L27;
            if (r115 >= (-96)) goto L29;
        L27:
            r114 = r112 + 1;
            if (r111[r112] <= (-65)) goto L12;
        L29:
            return -1;
        L30:
            byte r101 = (byte) (~(r110 >> 8));
            if (r101 != 0) goto L37;
            int r118 = r112 + 1;
            r101 = r111[r112];
            if (r118 >= r113) goto L35;
            r112 = r118;
            byte r119 = 0;
        L38:
            if (r119 != 0) goto L44;
            int r120 = r112 + 1;
            byte r121 = r111[r112];
            if (r120 >= r113) goto L42;
            r112 = r120;
            r119 = r121;
            goto L44
        L42:
            return Utf8.e(r100, r101, r121);
        L44:
            if (r101 <= (-65)) goto L46;
        L50:
            return -1;
        L46:
            if ((((r100 << 28) + (r101 + 112)) >> 30) != 0) goto L50;
            if (r119 > (-65)) goto L50;
            r114 = r112 + 1;
            if (r111[r112] <= (-65)) goto L12;
        L35:
            return Utf8.d(r100, r101);
        L37:
            r119 = (byte) (r110 >> 16);
        L51:
            if (r112 >= r113) goto L55;
            if (r111[r112] < 0) goto L55;
            r112 = r112 + 1;
        L55:
            if (r112 >= r113) goto L126;
        L57:
            if (r112 >= r113) goto L127;
            int r122 = r112 + 1;
            byte r123 = r111[r112];
            if (r123 < 0) goto L61;
            r112 = r122;
            goto L57
        L61:
            if (r123 < (-32)) goto L62;
            if (r123 < (-16)) goto L70;
            if (r122 >= (r113 - 2)) goto L125;
            int r102 = r122 + 1;
            byte r124 = r111[r122];
            if (r124 > (-65)) goto L92;
            if ((((r123 << 28) + (r124 + 112)) >> 30) != 0) goto L92;
            int r125 = r102 + 1;
            if (r111[r102] > (-65)) goto L92;
            r112 = r125 + 1;
            if (r111[r125] <= (-65)) goto L57;
        L92:
            return -1;
        L125:
            return Utf8.a(r111, r122, r113);
        L70:
            if (r122 >= (r113 - 1)) goto L124;
            int r103 = r122 + 1;
            byte r126 = r111[r122];
            if (r126 > (-65)) goto L92;
            if (r123 != (-32)) goto L76;
            if (r126 < (-96)) goto L92;
        L76:
            if (r123 != (-19)) goto L78;
            if (r126 >= (-96)) goto L92;
        L78:
            r112 = r103 + 1;
            if (r111[r103] <= (-65)) goto L57;
        L124:
            return Utf8.a(r111, r122, r113);
        L62:
            if (r122 >= r113) goto L123;
            if (r123 < (-62)) goto L92;
            r112 = r122 + 1;
            if (r111[r122] <= (-65)) goto L57;
        L123:
            return r123;
        L127:
            return 0;
        L126:
            return 0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final int g(int r100, ByteBuffer r101, int r102, int r103) {
            return b.f(r100, r101, r102, r103);
        }
    }

    public static final class d extends b {
        public d() {
        }

        public static int h(long r100, int r101, int r102) {
            if (r102 != 0) goto L4;
            b r103 = Utf8.f275849a;
            if (r101 <= (-12)) goto L17;
            return -1;
        L17:
            return r101;
        L4:
            if (r102 == 1) goto L12;
            if (r102 != 2) goto L10;
            return Utf8.e(r101, i.f(r100), i.f(r100 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.d(r101, i.f(r100));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final String a(byte[] r100, int r101, int r102) throws InvalidProtocolBufferException {
            Charset r103 = e.f275885a;
            String r104 = new String(r100, r101, r102, r103);
            if (r104.contains("�") == true) goto L6;
            return r104;
        L6:
            if (Arrays.equals(r104.getBytes(r103), Arrays.copyOfRange(r100, r101, r102 + r101)) == false) goto L9;
            return r104;
        L9:
            throw InvalidProtocolBufferException.invalidUtf8();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final String c(ByteBuffer r110, int r111, int r210) throws InvalidProtocolBufferException {
            if (((r111 | r210) | ((r110.limit() - r111) - r210)) < 0) goto L60;
            long r100 = i.f275898b.h(r110, i.f275902f) + ((long) r111);
            long r101 = ((long) r210) + r100;
            char[] r102 = new char[r210];
            int r103 = 0;
        L6:
            if (r100 >= r101) goto L14;
            byte r104 = i.f(r100);
            if (r104 < 0) goto L10;
            boolean r105 = true;
        L11:
            if (r105 == false) goto L14;
            r100 = r100 + 1;
            r102[r103] = (char) r104;
            r103 = r103 + 1;
            goto L6
        L10:
            r105 = false;
        L14:
            int r112 = r103;
        L16:
            if (r100 >= r101) goto L58;
            long r106 = r100 + 1;
            byte r107 = i.f(r100);
            if (r107 < 0) goto L20;
            boolean r108 = true;
        L21:
            if (r108 == true) goto L22;
            if (r107 >= (-32)) goto L35;
            boolean r109 = true;
        L36:
            if (r109 == true) goto L38;
            if (r107 >= (-16)) goto L45;
            boolean r113 = true;
        L46:
            if (r113 == false) goto L53;
            if (r106 >= (r101 - 1)) goto L51;
            long r114 = r106 + 1;
            a.c(r107, i.f(r106), i.f(r114), r102, r112);
            r112 = r112 + 1;
            r100 = r114 + 1;
            goto L16
        L51:
            throw InvalidProtocolBufferException.invalidUtf8();
        L53:
            if (r106 >= (r101 - 2)) goto L56;
            long r115 = r106 + 1;
            byte r116 = i.f(r106);
            long r117 = r115 + 1;
            byte r118 = i.f(r115);
            r100 = r117 + 1;
            a.a(r107, r116, r118, i.f(r117), r102, r112);
            r103 = (r112 + 1) + 1;
            goto L14
        L56:
            throw InvalidProtocolBufferException.invalidUtf8();
        L45:
            r113 = false;
            goto L46
        L38:
            if (r106 >= r101) goto L41;
            r100 = r106 + 1;
            a.b(r107, i.f(r106), r102, r112);
            r112 = r112 + 1;
            goto L16
        L41:
            throw InvalidProtocolBufferException.invalidUtf8();
        L35:
            r109 = false;
            goto L36
        L22:
            r102[r112] = (char) r107;
            r112 = r112 + 1;
            r100 = r106;
        L24:
            if (r100 >= r101) goto L16;
            byte r119 = i.f(r100);
            if (r119 < 0) goto L28;
            boolean r120 = true;
        L29:
            if (r120 == false) goto L16;
            r100 = r100 + 1;
            r102[r112] = (char) r119;
            r112 = r112 + 1;
            goto L24
        L28:
            r120 = false;
            goto L29
        L20:
            r108 = false;
            goto L21
        L58:
            return new String(r102, 0, r112);
        L60:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r110.limit()), Integer.valueOf(r111), Integer.valueOf(r210)}));
        }

        public static int i(byte[] r100, int r101, long r102, int r103) {
            if (r103 != 0) goto L4;
            b r104 = Utf8.f275849a;
            if (r101 <= (-12)) goto L17;
            return -1;
        L17:
            return r101;
        L4:
            if (r103 == 1) goto L12;
            if (r103 != 2) goto L10;
            return Utf8.e(r101, i.g(r100, r102), i.g(r100, r102 + 1));
        L10:
            throw new AssertionError();
        L12:
            return Utf8.d(r101, i.g(r100, r102));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final int e(int r210, byte[] r211, int r212, int r213) {
            if (((r212 | r213) | (r211.length - r213)) < 0) goto L126;
            long r100 = r212;
            long r101 = r213;
            if (r210 != 0) goto L7;
        L56:
            int r102 = (int) (r101 - r100);
            if (r102 >= 16) goto L59;
            int r103 = 0;
        L77:
            int r104 = r102 - r103;
            long r105 = r100 + ((long) r103);
        L78:
            byte r106 = 0;
        L79:
            if (r104 <= 0) goto L84;
            long r107 = r105 + 1;
            byte r108 = i.g(r211, r105);
            if (r108 < 0) goto L83;
            r104 = r104 - 1;
            r105 = r107;
            r106 = r108;
            goto L79
        L83:
            r105 = r107;
            r106 = r108;
        L84:
            if (r104 == 0) goto L85;
            int r109 = r104 - 1;
            if (r106 < (-32)) goto L88;
            if (r106 < (-16)) goto L99;
            if (r109 < 3) goto L161;
            r104 = r109 - 3;
            long r110 = r105 + 1;
            byte r111 = i.g(r211, r105);
            if (r111 > (-65)) goto L96;
            if ((((r106 << 28) + (r111 + 112)) >> 30) != 0) goto L96;
            long r112 = r110 + 1;
            if (i.g(r211, r110) > (-65)) goto L96;
            long r113 = r112 + 1;
            if (i.g(r211, r112) > (-65)) goto L96;
            r105 = r113;
        L96:
            return -1;
        L161:
            return i(r211, r106, r105, r109);
        L99:
            if (r109 < 2) goto L160;
            r104 = r109 - 2;
            long r114 = r105 + 1;
            byte r115 = i.g(r211, r105);
            if (r115 > (-65)) goto L96;
            if (r106 != (-32)) goto L106;
            if (r115 < (-96)) goto L96;
        L106:
            if (r106 != (-19)) goto L108;
            if (r115 >= (-96)) goto L96;
        L108:
            r105 = r114 + 1;
            if (i.g(r211, r114) <= (-65)) goto L78;
        L160:
            return i(r211, r106, r105, r109);
        L88:
            if (r109 == 0) goto L158;
            r104 = r109 - 1;
            if (r106 < (-62)) goto L96;
            long r116 = r105 + 1;
            if (i.g(r211, r105) > (-65)) goto L96;
            r105 = r116;
            goto L78
        L158:
            return r106;
        L85:
            return 0;
        L59:
            int r117 = 8 - (((int) r100) & 7);
            long r118 = r100;
            r103 = 0;
        L60:
            if (r103 >= r117) goto L65;
            long r214 = r118 + 1;
            if (i.g(r211, r118) < 0) goto L77;
            r103 = r103 + 1;
            r118 = r214;
        L65:
            int r119 = r103 + 8;
            if (r119 > r102) goto L71;
            if ((i.f275898b.h(r211, i.f275901e + r118) & (-9187201950435737472L)) != 0) goto L71;
            r118 = r118 + 8;
            r103 = r119;
        L71:
            if (r103 >= r102) goto L76;
            long r120 = r118 + 1;
            if (i.g(r211, r118) < 0) goto L77;
            r103 = r103 + 1;
            r118 = r120;
            goto L71
        L76:
            r103 = r102;
            goto L77
        L7:
            if (r100 < r101) goto L9;
            return r210;
        L9:
            byte r121 = (byte) r210;
            if (r121 >= (-32)) goto L17;
            if (r121 < (-62)) goto L16;
            long r215 = r100 + 1;
            if (i.g(r211, r100) > (-65)) goto L16;
        L15:
            r100 = r215;
        L16:
            return -1;
        L17:
            if (r121 >= (-16)) goto L33;
            byte r122 = (byte) (~(r210 >> 8));
            if (r122 != 0) goto L25;
            long r216 = r100 + 1;
            r122 = i.g(r211, r100);
            if (r216 >= r101) goto L23;
            r100 = r216;
            goto L25
        L23:
            return Utf8.d(r121, r122);
        L25:
            if (r122 > (-65)) goto L32;
            if (r121 != (-32)) goto L28;
            if (r122 < (-96)) goto L32;
        L28:
            if (r121 != (-19)) goto L30;
            if (r122 >= (-96)) goto L32;
        L30:
            r215 = r100 + 1;
            if (i.g(r211, r100) <= (-65)) goto L15;
        L32:
            return -1;
        L33:
            byte r123 = (byte) (~(r210 >> 8));
            if (r123 != 0) goto L40;
            long r217 = r100 + 1;
            r123 = i.g(r211, r100);
            if (r217 >= r101) goto L38;
            r100 = r217;
            byte r124 = 0;
        L41:
            if (r124 != 0) goto L47;
            long r218 = r100 + 1;
            r124 = i.g(r211, r100);
            if (r218 >= r101) goto L45;
            r100 = r218;
            goto L47
        L45:
            return Utf8.e(r121, r123, r124);
        L47:
            if (r123 <= (-65)) goto L49;
        L55:
            return -1;
        L49:
            if ((((r121 << 28) + (r123 + 112)) >> 30) != 0) goto L55;
            if (r124 > (-65)) goto L55;
            long r125 = r100 + 1;
            if (i.g(r211, r100) > (-65)) goto L55;
            r100 = r125;
            goto L56
        L38:
            return Utf8.d(r121, r123);
        L40:
            r124 = (byte) (r210 >> 16);
            goto L41
        L126:
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r211.length), Integer.valueOf(r212), Integer.valueOf(r213)}));
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Utf8.b
        public final int g(int r210, ByteBuffer r211, int r212, int r213) {
            if (((r212 | r213) | (r211.limit() - r213)) < 0) goto L115;
            long r100 = i.f275898b.h(r211, i.f275902f) + ((long) r212);
            long r101 = ((long) (r213 - r212)) + r100;
            if (r210 != 0) goto L7;
        L54:
            int r102 = (int) (r101 - r100);
            if (r102 >= 16) goto L57;
            int r103 = 0;
        L69:
            long r104 = r100 + ((long) r103);
            int r105 = r102 - r103;
        L70:
            byte r106 = 0;
        L71:
            if (r105 <= 0) goto L76;
            long r107 = r104 + 1;
            byte r108 = i.f(r104);
            if (r108 < 0) goto L75;
            r105 = r105 - 1;
            r104 = r107;
            r106 = r108;
            goto L71
        L75:
            r104 = r107;
            r106 = r108;
        L76:
            if (r105 == 0) goto L77;
            int r109 = r105 - 1;
            if (r106 < (-32)) goto L80;
            if (r106 >= (-16)) goto L102;
            if (r109 < 2) goto L144;
            r105 = r109 - 2;
            long r110 = r104 + 1;
            byte r111 = i.f(r104);
            if (r111 > (-65)) goto L112;
            if (r106 != (-32)) goto L96;
            if (r111 < (-96)) goto L112;
        L96:
            if (r106 != (-19)) goto L98;
            if (r111 >= (-96)) goto L112;
        L98:
            r104 = r110 + 1;
            if (i.f(r110) <= (-65)) goto L70;
        L112:
            return -1;
        L144:
            return h(r104, r106, r109);
        L102:
            if (r109 < 3) goto L145;
            r105 = r109 - 3;
            long r112 = r104 + 1;
            byte r113 = i.f(r104);
            if (r113 > (-65)) goto L112;
            if ((((r106 << 28) + (r113 + 112)) >> 30) != 0) goto L112;
            long r114 = r112 + 1;
            if (i.f(r112) > (-65)) goto L112;
            long r115 = r114 + 1;
            if (i.f(r114) > (-65)) goto L112;
        L87:
            r104 = r115;
            goto L70
        L145:
            return h(r104, r106, r109);
        L80:
            if (r109 == 0) goto L143;
            r105 = r109 - 1;
            if (r106 < (-62)) goto L112;
            r115 = r104 + 1;
            if (i.f(r104) <= (-65)) goto L87;
        L143:
            return r106;
        L77:
            return 0;
        L57:
            int r116 = (int) ((-r100) & 7);
            int r117 = r116;
            long r118 = r100;
        L58:
            if (r117 <= 0) goto L63;
            long r214 = r118 + 1;
            if (i.f(r118) < 0) goto L61;
            r117 = r117 - 1;
            r118 = r214;
            goto L58
        L61:
            r103 = r116 - r117;
            goto L69
        L63:
            int r119 = r102 - r116;
            long r120 = r118;
        L64:
            if (r119 < 8) goto L68;
            if ((i.f275898b.g(r120) & (-9187201950435737472L)) != 0) goto L68;
            r120 = r120 + 8;
            r119 = r119 - 8;
        L68:
            r103 = r102 - r119;
            goto L69
        L7:
            if (r100 < r101) goto L9;
            return r210;
        L9:
            byte r121 = (byte) r210;
            if (r121 >= (-32)) goto L15;
            if (r121 < (-62)) goto L14;
            long r122 = r100 + 1;
            if (i.f(r100) > (-65)) goto L14;
        L52:
            r100 = r122;
        L14:
            return -1;
        L15:
            if (r121 >= (-16)) goto L31;
            byte r123 = (byte) (~(r210 >> 8));
            if (r123 != 0) goto L23;
            long r124 = r100 + 1;
            r123 = i.f(r100);
            if (r124 >= r101) goto L21;
            r100 = r124;
            goto L23
        L21:
            return Utf8.d(r121, r123);
        L23:
            if (r123 > (-65)) goto L30;
            if (r121 != (-32)) goto L26;
            if (r123 < (-96)) goto L30;
        L26:
            if (r121 != (-19)) goto L28;
            if (r123 >= (-96)) goto L30;
        L28:
            r122 = r100 + 1;
            if (i.f(r100) <= (-65)) goto L52;
        L30:
            return -1;
        L31:
            byte r125 = (byte) (~(r210 >> 8));
            if (r125 != 0) goto L38;
            long r126 = r100 + 1;
            r125 = i.f(r100);
            if (r126 >= r101) goto L36;
            r100 = r126;
            byte r127 = 0;
        L39:
            if (r127 != 0) goto L45;
            long r128 = r100 + 1;
            r127 = i.f(r100);
            if (r128 >= r101) goto L43;
            r100 = r128;
            goto L45
        L43:
            return Utf8.e(r121, r125, r127);
        L45:
            if (r125 <= (-65)) goto L47;
        L53:
            return -1;
        L47:
            if ((((r121 << 28) + (r125 + 112)) >> 30) != 0) goto L53;
            if (r127 > (-65)) goto L53;
            r122 = r100 + 1;
            if (i.f(r100) <= (-65)) goto L52;
        L36:
            return Utf8.d(r121, r125);
        L38:
            r127 = (byte) (r210 >> 16);
            goto L39
        L115:
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", new Object[]{Integer.valueOf(r211.limit()), Integer.valueOf(r212), Integer.valueOf(r213)}));
        }
    }

    public static int d(int r100, int r101) {
        if (r100 <= (-12)) goto L5;
    L8:
        return -1;
    L5:
        if (r101 > (-65)) goto L8;
        return r100 ^ (r101 << 8);
    }

    public static int e(int r100, int r101, int r102) {
        if (r100 <= (-12)) goto L5;
    L9:
        return -1;
    L5:
        if (r101 > (-65)) goto L9;
        if (r102 > (-65)) goto L9;
        return (r100 ^ (r101 << 8)) ^ (r102 << 16);
    }

    static {
        if (i.f275900d == true) goto L5;
    L7:
        boolean r100 = false;
    L8:
        if (r100 == true) goto L10;
    L12:
        b r101 = new c();
    L13:
        f275849a = r101;
        return;
    L10:
        if (com.google.crypto.tink.shaded.protobuf.a.b() == true) goto L12;
        r101 = new d();
        goto L13
    L5:
        if (i.f275899c == false) goto L7;
        r100 = true;
        goto L8
    }

    public static int a(byte[] r100, int r101, int r102) {
        byte r103 = r100[r101 - 1];
        int r104 = r102 - r101;
        if (r104 == 0) goto L13;
        if (r104 == 1) goto L18;
        if (r104 != 2) goto L10;
        return e(r103, r100[r101], r100[r101 + 1]);
    L10:
        throw new AssertionError();
    L18:
        return d(r103, r100[r101]);
    L13:
        if (r103 <= (-12)) goto L16;
        r103 = -1;
    L16:
        return r103;
    }

    public static String c(ByteBuffer r100, int r101, int r102) throws InvalidProtocolBufferException {
        b r103 = f275849a;
        r103.getClass();
        if (r100.hasArray() == false) goto L6;
        int r104 = r100.arrayOffset();
        return r103.a(r100.array(), r104 + r101, r102);
    L6:
        if (r100.isDirect() == false) goto L9;
        return r103.c(r100, r101, r102);
    L9:
        return b.b(r100, r101, r102);
    }

    public static int b(ByteBuffer r100, int r101, int r102, int r103) {
        if (r103 == 0) goto L12;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L9;
        return e(r101, r100.get(r102), r100.get(r102 + 1));
    L9:
        throw new AssertionError();
    L17:
        return d(r101, r100.get(r102));
    L12:
        if (r101 <= (-12)) goto L15;
        r101 = -1;
    L15:
        return r101;
    }
}
