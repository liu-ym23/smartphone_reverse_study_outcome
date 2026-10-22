package org.apache.commons.compress.archivers.sevenz;

import java.util.Arrays;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum SevenZMethod extends Enum<SevenZMethod> {
    private static final /* synthetic */ SevenZMethod[] $VALUES = null;
    public static final SevenZMethod AES256SHA256 = null;
    public static final SevenZMethod BCJ_ARM_FILTER = null;
    public static final SevenZMethod BCJ_ARM_THUMB_FILTER = null;
    public static final SevenZMethod BCJ_IA64_FILTER = null;
    public static final SevenZMethod BCJ_PPC_FILTER = null;
    public static final SevenZMethod BCJ_SPARC_FILTER = null;
    public static final SevenZMethod BCJ_X86_FILTER = null;
    public static final SevenZMethod BZIP2 = null;
    public static final SevenZMethod COPY = null;
    public static final SevenZMethod DEFLATE = null;
    public static final SevenZMethod DEFLATE64 = null;
    public static final SevenZMethod DELTA_FILTER = null;
    public static final SevenZMethod LZMA = null;
    public static final SevenZMethod LZMA2 = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final byte[] f525007id;

    static {
        SevenZMethod r100 = new SevenZMethod("COPY", 0, new byte[]{0});
        COPY = r100;
        SevenZMethod r101 = new SevenZMethod("LZMA", 1, new byte[]{3, 1, 1});
        LZMA = r101;
        SevenZMethod r102 = new SevenZMethod("LZMA2", 2, new byte[]{33});
        LZMA2 = r102;
        SevenZMethod r103 = new SevenZMethod("DEFLATE", 3, new byte[]{4, 1, 8});
        DEFLATE = r103;
        SevenZMethod r104 = new SevenZMethod("DEFLATE64", 4, new byte[]{4, 1, 9});
        DEFLATE64 = r104;
        SevenZMethod r105 = new SevenZMethod("BZIP2", 5, new byte[]{4, 2, 2});
        BZIP2 = r105;
        SevenZMethod r110 = new SevenZMethod("AES256SHA256", 6, new byte[]{6, -15, 7, 1});
        AES256SHA256 = r110;
        SevenZMethod r111 = new SevenZMethod("BCJ_X86_FILTER", 7, new byte[]{3, 3, 1, 3});
        BCJ_X86_FILTER = r111;
        SevenZMethod r112 = new SevenZMethod("BCJ_PPC_FILTER", 8, new byte[]{3, 3, 2, 5});
        BCJ_PPC_FILTER = r112;
        SevenZMethod r113 = new SevenZMethod("BCJ_IA64_FILTER", 9, new byte[]{3, 3, 4, 1});
        BCJ_IA64_FILTER = r113;
        SevenZMethod r106 = new SevenZMethod("BCJ_ARM_FILTER", 10, new byte[]{3, 3, 5, 1});
        BCJ_ARM_FILTER = r106;
        SevenZMethod r107 = new SevenZMethod("BCJ_ARM_THUMB_FILTER", 11, new byte[]{3, 3, 7, 1});
        BCJ_ARM_THUMB_FILTER = r107;
        SevenZMethod r108 = new SevenZMethod("BCJ_SPARC_FILTER", 12, new byte[]{3, 3, 8, 5});
        BCJ_SPARC_FILTER = r108;
        SevenZMethod r109 = new SevenZMethod("DELTA_FILTER", 13, new byte[]{3});
        DELTA_FILTER = r109;
        $VALUES = new SevenZMethod[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109};
    }

    public static SevenZMethod[] values() {
        return (SevenZMethod[]) $VALUES.clone();
    }

    public byte[] getId() {
        byte[] r100 = this.f525007id;
        byte[] r101 = new byte[r100.length];
        System.arraycopy(r100, 0, r101, 0, r100.length);
        return r101;
    }

    public static SevenZMethod byId(byte[] r100) {
        SevenZMethod[] r101 = (SevenZMethod[]) SevenZMethod.class.getEnumConstants();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        SevenZMethod r104 = r101[r103];
        if (Arrays.equals(r104.f525007id, r100) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static SevenZMethod valueOf(String r100) {
        return (SevenZMethod) a.a(SevenZMethod.class, r100);
    }

    private SevenZMethod(String r100, int r101, byte[] r102) {
        super(r100, r101);
        this.f525007id = r102;
    }
}
