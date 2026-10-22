package org.apache.commons.compress.archivers.zip;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PKWareExtraHeader$HashAlgorithm extends Enum<PKWareExtraHeader$HashAlgorithm> {
    private static final /* synthetic */ PKWareExtraHeader$HashAlgorithm[] $VALUES = null;
    public static final PKWareExtraHeader$HashAlgorithm CRC32 = null;
    public static final PKWareExtraHeader$HashAlgorithm MD5 = null;
    public static final PKWareExtraHeader$HashAlgorithm NONE = null;
    public static final PKWareExtraHeader$HashAlgorithm RIPEND160 = null;
    public static final PKWareExtraHeader$HashAlgorithm SHA1 = null;
    public static final PKWareExtraHeader$HashAlgorithm SHA256 = null;
    public static final PKWareExtraHeader$HashAlgorithm SHA384 = null;
    public static final PKWareExtraHeader$HashAlgorithm SHA512 = null;
    private static final Map<Integer, PKWareExtraHeader$HashAlgorithm> codeToEnum = null;
    private final int code;

    static {
        int r100 = 0;
        PKWareExtraHeader$HashAlgorithm r101 = new PKWareExtraHeader$HashAlgorithm(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r101;
        PKWareExtraHeader$HashAlgorithm r102 = new PKWareExtraHeader$HashAlgorithm("CRC32", 1, 1);
        CRC32 = r102;
        PKWareExtraHeader$HashAlgorithm r103 = new PKWareExtraHeader$HashAlgorithm("MD5", 2, 32771);
        MD5 = r103;
        PKWareExtraHeader$HashAlgorithm r104 = new PKWareExtraHeader$HashAlgorithm("SHA1", 3, 32772);
        SHA1 = r104;
        PKWareExtraHeader$HashAlgorithm r105 = new PKWareExtraHeader$HashAlgorithm("RIPEND160", 4, 32775);
        RIPEND160 = r105;
        PKWareExtraHeader$HashAlgorithm r106 = new PKWareExtraHeader$HashAlgorithm("SHA256", 5, 32780);
        SHA256 = r106;
        PKWareExtraHeader$HashAlgorithm r110 = new PKWareExtraHeader$HashAlgorithm("SHA384", 6, 32781);
        SHA384 = r110;
        PKWareExtraHeader$HashAlgorithm r111 = new PKWareExtraHeader$HashAlgorithm("SHA512", 7, 32782);
        SHA512 = r111;
        $VALUES = new PKWareExtraHeader$HashAlgorithm[]{r101, r102, r103, r104, r105, r106, r110, r111};
        HashMap r107 = new HashMap();
        PKWareExtraHeader$HashAlgorithm[] r108 = values();
        int r109 = r108.length;
    L3:
        if (r100 >= r109) goto L5;
        PKWareExtraHeader$HashAlgorithm r112 = r108[r100];
        r107.put(Integer.valueOf(r112.getCode()), r112);
        r100 = r100 + 1;
        goto L3
    L5:
        codeToEnum = Collections.unmodifiableMap(r107);
    }

    public static PKWareExtraHeader$HashAlgorithm[] values() {
        return (PKWareExtraHeader$HashAlgorithm[]) $VALUES.clone();
    }

    public int getCode() {
        return this.code;
    }

    public static PKWareExtraHeader$HashAlgorithm getAlgorithmByCode(int r100) {
        return codeToEnum.get(Integer.valueOf(r100));
    }

    public static PKWareExtraHeader$HashAlgorithm valueOf(String r100) {
        return (PKWareExtraHeader$HashAlgorithm) a.a(PKWareExtraHeader$HashAlgorithm.class, r100);
    }

    private PKWareExtraHeader$HashAlgorithm(String r100, int r101, int r102) {
        super(r100, r101);
        this.code = r102;
    }
}
