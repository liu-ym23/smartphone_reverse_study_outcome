package com.ss.android.lark.qrcode.zxing.common;

import com.ss.android.lark.qrcode.zxing.FormatException;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum CharacterSetECI extends Enum<CharacterSetECI> {
    public static final CharacterSetECI ASCII = null;
    public static final CharacterSetECI Big5 = null;
    public static final CharacterSetECI Cp1250 = null;
    public static final CharacterSetECI Cp1251 = null;
    public static final CharacterSetECI Cp1252 = null;
    public static final CharacterSetECI Cp1256 = null;
    public static final CharacterSetECI Cp437 = null;
    public static final CharacterSetECI EUC_KR = null;
    public static final CharacterSetECI GB18030 = null;
    public static final CharacterSetECI ISO8859_1 = null;
    public static final CharacterSetECI ISO8859_10 = null;
    public static final CharacterSetECI ISO8859_11 = null;
    public static final CharacterSetECI ISO8859_13 = null;
    public static final CharacterSetECI ISO8859_14 = null;
    public static final CharacterSetECI ISO8859_15 = null;
    public static final CharacterSetECI ISO8859_16 = null;
    public static final CharacterSetECI ISO8859_2 = null;
    public static final CharacterSetECI ISO8859_3 = null;
    public static final CharacterSetECI ISO8859_4 = null;
    public static final CharacterSetECI ISO8859_5 = null;
    public static final CharacterSetECI ISO8859_6 = null;
    public static final CharacterSetECI ISO8859_7 = null;
    public static final CharacterSetECI ISO8859_8 = null;
    public static final CharacterSetECI ISO8859_9 = null;
    public static final CharacterSetECI SJIS = null;
    public static final CharacterSetECI UTF8 = null;
    public static final CharacterSetECI UnicodeBigUnmarked = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, CharacterSetECI> f439112a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, CharacterSetECI> f439113b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ CharacterSetECI[] f439114c = null;
    private final String[] otherEncodingNames;
    private final int[] values;

    public CharacterSetECI() {
        throw null;
    }

    static {
        CharacterSetECI r100 = new CharacterSetECI("Cp437", 0, new int[]{0, 2}, new String[0]);
        Cp437 = r100;
        CharacterSetECI r101 = new CharacterSetECI("ISO8859_1", 1, new int[]{1, 3}, new String[]{"ISO-8859-1"});
        ISO8859_1 = r101;
        CharacterSetECI r102 = new CharacterSetECI("ISO8859_2", 2, 4, new String[]{"ISO-8859-2"});
        ISO8859_2 = r102;
        CharacterSetECI r103 = new CharacterSetECI("ISO8859_3", 3, 5, new String[]{"ISO-8859-3"});
        ISO8859_3 = r103;
        CharacterSetECI r104 = new CharacterSetECI("ISO8859_4", 4, 6, new String[]{"ISO-8859-4"});
        ISO8859_4 = r104;
        CharacterSetECI r105 = new CharacterSetECI("ISO8859_5", 5, 7, new String[]{"ISO-8859-5"});
        ISO8859_5 = r105;
        CharacterSetECI r110 = new CharacterSetECI("ISO8859_6", 6, 8, new String[]{"ISO-8859-6"});
        ISO8859_6 = r110;
        CharacterSetECI r111 = new CharacterSetECI("ISO8859_7", 7, 9, new String[]{"ISO-8859-7"});
        ISO8859_7 = r111;
        CharacterSetECI r112 = new CharacterSetECI("ISO8859_8", 8, 10, new String[]{"ISO-8859-8"});
        ISO8859_8 = r112;
        CharacterSetECI r113 = new CharacterSetECI("ISO8859_9", 9, 11, new String[]{"ISO-8859-9"});
        ISO8859_9 = r113;
        CharacterSetECI r114 = new CharacterSetECI("ISO8859_10", 10, 12, new String[]{"ISO-8859-10"});
        ISO8859_10 = r114;
        CharacterSetECI r106 = new CharacterSetECI("ISO8859_11", 11, 13, new String[]{"ISO-8859-11"});
        ISO8859_11 = r106;
        CharacterSetECI r107 = new CharacterSetECI("ISO8859_13", 12, 15, new String[]{"ISO-8859-13"});
        ISO8859_13 = r107;
        CharacterSetECI r108 = new CharacterSetECI("ISO8859_14", 13, 16, new String[]{"ISO-8859-14"});
        ISO8859_14 = r108;
        CharacterSetECI r109 = new CharacterSetECI("ISO8859_15", 14, 17, new String[]{"ISO-8859-15"});
        ISO8859_15 = r109;
        CharacterSetECI r115 = new CharacterSetECI("ISO8859_16", 15, 18, new String[]{"ISO-8859-16"});
        ISO8859_16 = r115;
        CharacterSetECI r116 = new CharacterSetECI("SJIS", 16, 20, new String[]{"Shift_JIS"});
        SJIS = r116;
        CharacterSetECI r117 = new CharacterSetECI("Cp1250", 17, 21, new String[]{"windows-1250"});
        Cp1250 = r117;
        CharacterSetECI r118 = new CharacterSetECI("Cp1251", 18, 22, new String[]{"windows-1251"});
        Cp1251 = r118;
        CharacterSetECI r119 = new CharacterSetECI("Cp1252", 19, 23, new String[]{"windows-1252"});
        Cp1252 = r119;
        CharacterSetECI r120 = new CharacterSetECI("Cp1256", 20, 24, new String[]{"windows-1256"});
        Cp1256 = r120;
        CharacterSetECI r121 = new CharacterSetECI("UnicodeBigUnmarked", 21, 25, new String[]{"UTF-16BE", "UnicodeBig"});
        UnicodeBigUnmarked = r121;
        CharacterSetECI r122 = new CharacterSetECI("UTF8", 22, 26, new String[]{"UTF-8"});
        UTF8 = r122;
        CharacterSetECI r123 = new CharacterSetECI("ASCII", 23, new int[]{27, 170}, new String[]{"US-ASCII"});
        ASCII = r123;
        CharacterSetECI r124 = new CharacterSetECI("Big5", 24, new int[]{28}, new String[0]);
        Big5 = r124;
        CharacterSetECI r125 = new CharacterSetECI("GB18030", 25, 29, new String[]{"GB2312", "EUC_CN", "GBK"});
        GB18030 = r125;
        CharacterSetECI r126 = new CharacterSetECI("EUC_KR", 26, 30, new String[]{"EUC-KR"});
        EUC_KR = r126;
        f439114c = new CharacterSetECI[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126};
        f439112a = new HashMap();
        f439113b = new HashMap();
        CharacterSetECI[] r127 = values();
        int r128 = r127.length;
        int r129 = 0;
    L3:
        if (r129 >= r128) goto L11;
        CharacterSetECI r130 = r127[r129];
        int[] r131 = r130.values;
        int r132 = r131.length;
        int r133 = 0;
    L5:
        if (r133 >= r132) goto L7;
        f439112a.put(Integer.valueOf(r131[r133]), r130);
        r133 = r133 + 1;
        goto L5
    L7:
        f439113b.put(r130.name(), r130);
        String[] r134 = r130.otherEncodingNames;
        int r135 = r134.length;
        int r136 = 0;
    L8:
        if (r136 >= r135) goto L10;
        f439113b.put(r134[r136], r130);
        r136 = r136 + 1;
        goto L8
    L10:
        r129 = r129 + 1;
        goto L3
    }

    public static CharacterSetECI[] values() {
        return (CharacterSetECI[]) f439114c.clone();
    }

    public int getValue() {
        return this.values[0];
    }

    public static CharacterSetECI getCharacterSetECIByName(String r100) {
        return (CharacterSetECI) ((HashMap) f439113b).get(r100);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int r100) throws FormatException {
        if (r100 < 0) goto L8;
        if (r100 >= 900) goto L8;
        Map<Integer, CharacterSetECI> r101 = f439112a;
        HashMap r102 = (HashMap) r101;
        return (CharacterSetECI) r102.get(Integer.valueOf(r100));
    L8:
        throw FormatException.getFormatInstance();
    }

    public static CharacterSetECI valueOf(String r100) {
        return (CharacterSetECI) a.a(CharacterSetECI.class, r100);
    }

    public CharacterSetECI(String r100, int r101, int r102, String... r103) {
        super(r100, r101);
        this.values = new int[]{r102};
        this.otherEncodingNames = r103;
    }

    public CharacterSetECI(String r100, int r101, int[] r102, String... r103) {
        super(r100, r101);
        this.values = r102;
        this.otherEncodingNames = r103;
    }
}
