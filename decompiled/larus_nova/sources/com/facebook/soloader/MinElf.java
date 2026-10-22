package com.facebook.soloader;

import com.obric.miniapp.alarm.AccountType;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes23.dex */
public final class MinElf {
    public static final int DT_NEEDED = 1;
    public static final int DT_NULL = 0;
    public static final int DT_STRTAB = 5;
    public static final int ELF_MAGIC = 1179403647;
    public static final int PN_XNUM = 65535;
    public static final int PT_DYNAMIC = 2;
    public static final int PT_LOAD = 1;
    private static final String TAG = "MinElf";

    public static class ElfError extends RuntimeException {
        public ElfError(String r100) {
            super(r100);
        }
    }

    public static final enum ISA extends Enum<ISA> {
        private static final /* synthetic */ ISA[] $VALUES = null;
        public static final ISA AARCH64 = null;
        public static final ISA ARM = null;
        public static final ISA NOT_SO = null;
        public static final ISA OTHERS = null;
        public static final ISA X86 = null;
        public static final ISA X86_64 = null;
        private final String value;

        static {
            ISA r100 = new ISA("NOT_SO", 0, "not_so");
            NOT_SO = r100;
            ISA r101 = new ISA("X86", 1, "x86");
            X86 = r101;
            ISA r102 = new ISA("ARM", 2, "armeabi-v7a");
            ARM = r102;
            ISA r103 = new ISA("X86_64", 3, "x86_64");
            X86_64 = r103;
            ISA r104 = new ISA("AARCH64", 4, "arm64-v8a");
            AARCH64 = r104;
            ISA r105 = new ISA(AccountType.OTHERS, 5, "others");
            OTHERS = r105;
            $VALUES = new ISA[]{r100, r101, r102, r103, r104, r105};
        }

        public static ISA[] values() {
            return (ISA[]) $VALUES.clone();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }

        public static ISA valueOf(String r100) {
            return (ISA) Enum.valueOf(ISA.class, r100);
        }

        private ISA(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public MinElf() {
    }

    public static String[] extract_DT_NEEDED(File r100) throws IOException {
        ElfFileChannel r101 = new ElfFileChannel(r100);
        String[] r102 = extract_DT_NEEDED(r101);     // Catch: Throwable -> L6
        r101.close();
        return r102;
    L6:
        th = move-exception;
        r101.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    private static String[] extract_DT_NEEDED_no_retries(ElfByteChannel r310) throws IOException {
        ByteBuffer r100 = ByteBuffer.allocate(8);
        r100.order(ByteOrder.LITTLE_ENDIAN);
        long r101 = getu32(r310, r100, 0);
        if (r101 != 1179403647) goto L134;
        boolean r102 = true;
        if (getu8(r310, r100, 4) == 1) goto L9;
        r102 = false;
    L9:
        if (getu8(r310, r100, 5) != 2) goto L12;
        r100.order(ByteOrder.BIG_ENDIAN);
    L12:
        if (r102 == false) goto L14;
        long r110 = getu32(r310, r100, 28);
    L16:
        if (r102 == false) goto L18;
        long r103 = getu16(r310, r100, 44);
    L19:
        if (r102 == false) goto L21;
        long r104 = 42;
    L22:
        int r105 = getu16(r310, r100, r104);
        if (r103 != 65535) goto L31;
        if (r102 == false) goto L26;
        long r106 = getu32(r310, r100, 32);
    L27:
        if (r102 == false) goto L29;
        long r107 = getu32(r310, r100, r106 + 28);
    L30:
        r103 = r107;
        goto L31
    L29:
        r107 = getu32(r310, r100, r106 + 44);
        goto L30
    L26:
        r106 = get64(r310, r100, 40);
    L31:
        long r111 = r110;
        long r112 = 0;
    L33:
        if (r112 >= r103) goto L43;
        if (r102 == false) goto L36;
        long r108 = getu32(r310, r100, r111 + 0);
    L38:
        if (r108 == 2) goto L39;
        r111 = r111 + ((long) r105);
        r112 = r112 + 1;
        goto L33
    L39:
        if (r102 == false) goto L41;
        long r109 = getu32(r310, r100, r111 + 4);
    L44:
        long r210 = 0;
        if (r109 == 0) goto L132;
        long r113 = r109;
        long r114 = 0;
        int r115 = 0;
    L47:
        boolean r211 = r102;
        if (r102 == false) goto L50;
        long r116 = getu32(r310, r100, r113 + r210);
    L52:
        if (r116 != 1) goto L58;
        long r311 = r109;
        if (r115 == Integer.MAX_VALUE) goto L57;
        r115 = r115 + 1;
    L64:
        long r117 = 16;
        if (r211 == false) goto L67;
        long r312 = 8;
    L68:
        r113 = r113 + r312;
        r210 = 0;
        if (r116 == 0) goto L71;
        r102 = r211;
        r109 = r311;
        goto L47
    L71:
        if (r114 == 0) goto L129;
        int r118 = 0;
    L74:
        if (r118 >= r103) goto L96;
        if (r211 == false) goto L77;
        long r119 = getu32(r310, r100, r110 + r210);
    L79:
        if (r119 != 1) goto L94;
        if (r211 == false) goto L82;
        long r120 = getu32(r310, r100, r110 + 8);
    L83:
        if (r211 == false) goto L85;
        long r121 = getu32(r310, r100, r110 + 20);
    L87:
        if (r120 > r114) goto L95;
        if (r114 >= (r121 + r120)) goto L95;
        if (r211 == false) goto L92;
        long r122 = getu32(r310, r100, r110 + 4);
    L93:
        long r123 = r122 + (r114 - r120);
    L97:
        long r124 = 0;
        if (r123 == 0) goto L127;
        String[] r125 = new String[r115];
        int r126 = 0;
    L100:
        long r127 = r311 + r124;
        if (r211 == false) goto L103;
        long r128 = getu32(r310, r100, r127);
    L105:
        if (r128 != 1) goto L116;
        if (r211 == false) goto L109;
        long r129 = getu32(r310, r100, r311 + 4);
    L110:
        r125[r126] = getSz(r310, r100, r129 + r123);
        if (r126 == Integer.MAX_VALUE) goto L114;
        r126 = r126 + 1;
        goto L116
    L114:
        throw new ElfError("malformed DT_NEEDED section");
    L109:
        r129 = get64(r310, r100, r311 + 8);
    L116:
        if (r211 == false) goto L118;
        long r130 = 8;
    L119:
        r311 = r311 + r130;
        if (r128 == 0) goto L121;
        r124 = 0;
        goto L100
    L121:
        if (r126 != r115) goto L124;
        return r125;
    L124:
        throw new ElfError("malformed DT_NEEDED section");
    L118:
        r130 = 16;
        goto L119
    L103:
        r128 = get64(r310, r100, r127);
        goto L105
    L127:
        throw new ElfError("did not find file offset of DT_STRTAB table");
    L92:
        r122 = get64(r310, r100, r110 + 8);
    L95:
        r110 = r110 + ((long) r105);
        r118 = r118 + 1;
        r103 = r103;
        r117 = 16;
        r210 = 0;
        goto L74
    L85:
        r121 = get64(r310, r100, r110 + 40);
        goto L87
    L82:
        r120 = get64(r310, r100, r110 + r117);
        goto L83
    L94:
        r103 = r103;
        goto L95
    L77:
        r119 = getu32(r310, r100, r110 + r210);
        goto L79
    L96:
        r123 = 0;
        goto L97
    L129:
        throw new ElfError("Dynamic section string-table not found");
    L67:
        r312 = 16;
        goto L68
    L57:
        throw new ElfError("malformed DT_NEEDED section");
    L58:
        r311 = r109;
        if (r116 != 5) goto L64;
        if (r211 == false) goto L62;
        long r131 = getu32(r310, r100, r113 + 4);
    L63:
        r114 = r131;
        goto L64
    L62:
        r131 = get64(r310, r100, r113 + 8);
        goto L63
    L50:
        r116 = get64(r310, r100, r113 + r210);
        goto L52
    L132:
        throw new ElfError("ELF file does not contain dynamic linking information");
    L41:
        r109 = get64(r310, r100, r111 + 8);
        goto L44
    L36:
        r108 = getu32(r310, r100, r111 + 0);
        goto L38
    L43:
        r109 = 0;
        goto L44
    L21:
        r104 = 54;
        goto L22
    L18:
        r103 = getu16(r310, r100, 56);
        goto L19
    L14:
        r110 = get64(r310, r100, 32);
        goto L16
    L134:
        throw new ElfError("file is not ELF: 0x" + Long.toHexString(r101));
    }

    private static String[] extract_DT_NEEDED_with_retries(ElfFileChannel r100) throws IOException {
        int r101 = 0;
    L10:
        return extract_DT_NEEDED_no_retries(r100);
    L5:
        e = move-exception;
        r101 = r101 + 1;
        if (r101 > 4) goto L9;
        Thread.interrupted();
        r100.openChannel();
        goto L10
    L9:
        throw e;
    }

    public static String[] extract_DT_NEEDED(ElfByteChannel r100) throws IOException {
        if ((r100 instanceof ElfFileChannel) == false) goto L7;
        return extract_DT_NEEDED_with_retries((ElfFileChannel) r100);
    L7:
        return extract_DT_NEEDED_no_retries(r100);
    }

    private static long get64(ElfByteChannel r100, ByteBuffer r101, long r102) throws IOException {
        read(r100, r101, 8, r102);
        return r101.getLong();
    }

    private static String getSz(ElfByteChannel r100, ByteBuffer r101, long r102) throws IOException {
        StringBuilder r103 = new StringBuilder();
    L3:
        long r104 = 1 + r102;
        short r105 = getu8(r100, r101, r102);
        if (r105 == 0) goto L7;
        r103.append((char) r105);
        r102 = r104;
        goto L3
    L7:
        return r103.toString();
    }

    private static int getu16(ElfByteChannel r100, ByteBuffer r101, long r102) throws IOException {
        read(r100, r101, 2, r102);
        return r101.getShort() & 65535;
    }

    private static long getu32(ElfByteChannel r100, ByteBuffer r101, long r102) throws IOException {
        read(r100, r101, 4, r102);
        return ((long) r101.getInt()) & BodyPartID.bodyIdMax;
    }

    private static short getu8(ElfByteChannel r100, ByteBuffer r101, long r102) throws IOException {
        read(r100, r101, 1, r102);
        return (short) (r101.get() & UByte.MAX_VALUE);
    }

    private static void read(ElfByteChannel r100, ByteBuffer r101, int r102, long r103) throws IOException {
        r101.position(0);
        r101.limit(r102);
    L4:
        if (r101.remaining() <= 0) goto L10;
        int r104 = r100.read(r101, r103);
        if (r104 == (-1)) goto L10;
        r103 = r103 + ((long) r104);
    L10:
        if (r101.remaining() > 0) goto L14;
        r101.position(0);
        return;
    L14:
        throw new ElfError("ELF file truncated");
    }
}
