package com.google.zxing.common;

import com.google.zxing.FormatException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
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
    public static final CharacterSetECI ISO8859_13 = null;
    public static final CharacterSetECI ISO8859_15 = null;
    public static final CharacterSetECI ISO8859_16 = null;
    public static final CharacterSetECI ISO8859_2 = null;
    public static final CharacterSetECI ISO8859_3 = null;
    public static final CharacterSetECI ISO8859_4 = null;
    public static final CharacterSetECI ISO8859_5 = null;
    public static final CharacterSetECI ISO8859_7 = null;
    public static final CharacterSetECI ISO8859_9 = null;
    public static final CharacterSetECI SJIS = null;
    public static final CharacterSetECI UTF8 = null;
    public static final CharacterSetECI UnicodeBigUnmarked = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, CharacterSetECI> f275942a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, CharacterSetECI> f275943b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ CharacterSetECI[] f275944c = null;
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
        CharacterSetECI r110 = new CharacterSetECI("ISO8859_7", 6, 9, new String[]{"ISO-8859-7"});
        ISO8859_7 = r110;
        CharacterSetECI r111 = new CharacterSetECI("ISO8859_9", 7, 11, new String[]{"ISO-8859-9"});
        ISO8859_9 = r111;
        CharacterSetECI r112 = new CharacterSetECI("ISO8859_13", 8, 15, new String[]{"ISO-8859-13"});
        ISO8859_13 = r112;
        CharacterSetECI r113 = new CharacterSetECI("ISO8859_15", 9, 17, new String[]{"ISO-8859-15"});
        ISO8859_15 = r113;
        CharacterSetECI r106 = new CharacterSetECI("ISO8859_16", 10, 18, new String[]{"ISO-8859-16"});
        ISO8859_16 = r106;
        CharacterSetECI r107 = new CharacterSetECI("SJIS", 11, 20, new String[]{"Shift_JIS"});
        SJIS = r107;
        CharacterSetECI r108 = new CharacterSetECI("Cp1250", 12, 21, new String[]{"windows-1250"});
        Cp1250 = r108;
        CharacterSetECI r114 = new CharacterSetECI("Cp1251", 13, 22, new String[]{"windows-1251"});
        Cp1251 = r114;
        CharacterSetECI r109 = new CharacterSetECI("Cp1252", 14, 23, new String[]{"windows-1252"});
        Cp1252 = r109;
        CharacterSetECI r115 = new CharacterSetECI("Cp1256", 15, 24, new String[]{"windows-1256"});
        Cp1256 = r115;
        CharacterSetECI r116 = new CharacterSetECI("UnicodeBigUnmarked", 16, 25, new String[]{"UTF-16BE", "UnicodeBig"});
        UnicodeBigUnmarked = r116;
        CharacterSetECI r117 = new CharacterSetECI("UTF8", 17, 26, new String[]{"UTF-8"});
        UTF8 = r117;
        CharacterSetECI r118 = new CharacterSetECI("ASCII", 18, new int[]{27, 170}, new String[]{"US-ASCII"});
        ASCII = r118;
        CharacterSetECI r119 = new CharacterSetECI("Big5", 19, new int[]{28}, new String[0]);
        Big5 = r119;
        CharacterSetECI r120 = new CharacterSetECI("GB18030", 20, 29, new String[]{"GB2312", "EUC_CN", "GBK"});
        GB18030 = r120;
        CharacterSetECI r121 = new CharacterSetECI("EUC_KR", 21, 30, new String[]{"EUC-KR"});
        EUC_KR = r121;
        f275944c = new CharacterSetECI[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r114, r109, r115, r116, r117, r118, r119, r120, r121};
        f275942a = new HashMap();
        f275943b = new HashMap();
        CharacterSetECI[] r122 = values();
        int r123 = r122.length;
        int r124 = 0;
    L3:
        if (r124 >= r123) goto L11;
        CharacterSetECI r125 = r122[r124];
        int[] r126 = r125.values;
        int r127 = r126.length;
        int r128 = 0;
    L5:
        if (r128 >= r127) goto L7;
        f275942a.put(Integer.valueOf(r126[r128]), r125);
        r128 = r128 + 1;
        goto L5
    L7:
        f275943b.put(r125.name(), r125);
        String[] r129 = r125.otherEncodingNames;
        int r130 = r129.length;
        int r131 = 0;
    L8:
        if (r131 >= r130) goto L10;
        f275943b.put(r129[r131], r125);
        r131 = r131 + 1;
        goto L8
    L10:
        r124 = r124 + 1;
        goto L3
    }

    public static CharacterSetECI[] values() {
        return (CharacterSetECI[]) f275944c.clone();
    }

    public int getValue() {
        return this.values[0];
    }

    public Charset getCharset() {
        return Charset.forName(name());
    }

    public static CharacterSetECI getCharacterSetECI(Charset r100) {
        Map<String, CharacterSetECI> r101 = f275943b;
        HashMap r102 = (HashMap) r101;
        return (CharacterSetECI) r102.get(r100.name());
    }

    public static CharacterSetECI getCharacterSetECIByName(String r100) {
        return (CharacterSetECI) ((HashMap) f275943b).get(r100);
    }

    public static CharacterSetECI getCharacterSetECIByValue(int r100) throws FormatException {
        if (r100 < 0) goto L8;
        if (r100 >= 900) goto L8;
        Map<Integer, CharacterSetECI> r101 = f275942a;
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
