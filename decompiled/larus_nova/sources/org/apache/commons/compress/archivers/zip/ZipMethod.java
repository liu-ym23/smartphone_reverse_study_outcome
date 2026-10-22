package org.apache.commons.compress.archivers.zip;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum ZipMethod extends Enum<ZipMethod> {
    private static final /* synthetic */ ZipMethod[] $VALUES = null;
    public static final ZipMethod AES_ENCRYPTED = null;
    public static final ZipMethod BZIP2 = null;
    public static final ZipMethod DEFLATED = null;
    public static final ZipMethod ENHANCED_DEFLATED = null;
    public static final ZipMethod EXPANDING_LEVEL_1 = null;
    public static final ZipMethod EXPANDING_LEVEL_2 = null;
    public static final ZipMethod EXPANDING_LEVEL_3 = null;
    public static final ZipMethod EXPANDING_LEVEL_4 = null;
    public static final ZipMethod IMPLODING = null;
    public static final ZipMethod JPEG = null;
    public static final ZipMethod LZMA = null;
    public static final ZipMethod PKWARE_IMPLODING = null;
    public static final ZipMethod PPMD = null;
    public static final ZipMethod STORED = null;
    public static final ZipMethod TOKENIZATION = null;
    public static final ZipMethod UNKNOWN = null;
    static final int UNKNOWN_CODE = -1;
    public static final ZipMethod UNSHRINKING = null;
    public static final ZipMethod WAVPACK = null;
    public static final ZipMethod XZ = null;
    private static final Map<Integer, ZipMethod> codeToEnum = null;
    private final int code;

    static {
        ZipMethod r100 = new ZipMethod("STORED", 0, 0);
        STORED = r100;
        ZipMethod r101 = new ZipMethod("UNSHRINKING", 1, 1);
        UNSHRINKING = r101;
        ZipMethod r102 = new ZipMethod("EXPANDING_LEVEL_1", 2, 2);
        EXPANDING_LEVEL_1 = r102;
        ZipMethod r103 = new ZipMethod("EXPANDING_LEVEL_2", 3, 3);
        EXPANDING_LEVEL_2 = r103;
        ZipMethod r104 = new ZipMethod("EXPANDING_LEVEL_3", 4, 4);
        EXPANDING_LEVEL_3 = r104;
        ZipMethod r105 = new ZipMethod("EXPANDING_LEVEL_4", 5, 5);
        EXPANDING_LEVEL_4 = r105;
        ZipMethod r110 = new ZipMethod("IMPLODING", 6, 6);
        IMPLODING = r110;
        ZipMethod r111 = new ZipMethod("TOKENIZATION", 7, 7);
        TOKENIZATION = r111;
        ZipMethod r112 = new ZipMethod("DEFLATED", 8, 8);
        DEFLATED = r112;
        ZipMethod r113 = new ZipMethod("ENHANCED_DEFLATED", 9, 9);
        ENHANCED_DEFLATED = r113;
        ZipMethod r114 = new ZipMethod("PKWARE_IMPLODING", 10, 10);
        PKWARE_IMPLODING = r114;
        ZipMethod r115 = new ZipMethod("BZIP2", 11, 12);
        BZIP2 = r115;
        ZipMethod r106 = new ZipMethod("LZMA", 12, 14);
        LZMA = r106;
        ZipMethod r107 = new ZipMethod("XZ", 13, 95);
        XZ = r107;
        ZipMethod r108 = new ZipMethod("JPEG", 14, 96);
        JPEG = r108;
        ZipMethod r109 = new ZipMethod("WAVPACK", 15, 97);
        WAVPACK = r109;
        ZipMethod r116 = new ZipMethod("PPMD", 16, 98);
        PPMD = r116;
        ZipMethod r117 = new ZipMethod("AES_ENCRYPTED", 17, 99);
        AES_ENCRYPTED = r117;
        ZipMethod r118 = new ZipMethod("UNKNOWN", 18);
        UNKNOWN = r118;
        $VALUES = new ZipMethod[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118};
        HashMap r119 = new HashMap();
        ZipMethod[] r120 = values();
        int r121 = r120.length;
        int r122 = 0;
    L3:
        if (r122 >= r121) goto L5;
        ZipMethod r123 = r120[r122];
        r119.put(Integer.valueOf(r123.getCode()), r123);
        r122 = r122 + 1;
        goto L3
    L5:
        codeToEnum = Collections.unmodifiableMap(r119);
    }

    public static ZipMethod[] values() {
        return (ZipMethod[]) $VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public static ZipMethod getMethodByCode(int r100) {
        return codeToEnum.get(Integer.valueOf(r100));
    }

    public static ZipMethod valueOf(String r100) {
        return (ZipMethod) a.a(ZipMethod.class, r100);
    }

    private ZipMethod(String r100, int r101) {
        this(r100, r101, -1);
    }

    private ZipMethod(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
