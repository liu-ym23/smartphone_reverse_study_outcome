package com.bytedance.ies.bullet.interaction.predefine.security;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
public final class PredefineFileValidate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PredefineFileValidate f246778a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/ies/bullet/interaction/predefine/security/PredefineFileValidate$TypeEnum;", "", "MD5", "SHA256", "SIZE_SHA256", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final enum TypeEnum extends Enum<TypeEnum> {
        public static final TypeEnum MD5 = null;
        public static final TypeEnum SHA256 = null;
        public static final TypeEnum SIZE_SHA256 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TypeEnum[] f246779a = null;

        public static TypeEnum valueOf(String r100) {
            return (TypeEnum) r27.a.a(TypeEnum.class, r100);
        }

        public static TypeEnum[] values() {
            return (TypeEnum[]) f246779a.clone();
        }

        static {
            TypeEnum r100 = new TypeEnum("MD5", 0);
            MD5 = r100;
            TypeEnum r101 = new TypeEnum("SHA256", 1);
            SHA256 = r101;
            TypeEnum r102 = new TypeEnum("SIZE_SHA256", 2);
            SIZE_SHA256 = r102;
            f246779a = new TypeEnum[]{r100, r101, r102};
        }

        public TypeEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f246780a = null;

        static {
            int[] r100 = new int[TypeEnum.values().length];
            r100[TypeEnum.MD5.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[TypeEnum.SHA256.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[TypeEnum.SIZE_SHA256.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f246780a = r100;
        }
    }

    static {
        f246778a = new PredefineFileValidate();
    }

    public PredefineFileValidate() {
    }

    public static String a(PolarisFileWrapper r100, String r110) {
        MessageDigest r111 = MessageDigest.getInstance(r110);     // Catch: NoSuchAlgorithmException -> L35
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper(r100);     // Catch: FileNotFoundException -> L33
        byte[] r102 = new byte[8192];     // Catch: Throwable -> L22 IOException -> L24
        int r103 = r101.read(r102);     // Catch: Throwable -> L22 IOException -> L24
    L8:
        int r104 = 0;
        if (r103 <= 0) goto L11;
        r111.update(r102, 0, r103);     // Catch: Throwable -> L22 IOException -> L24
        r103 = r101.read(r102);     // Catch: Throwable -> L22 IOException -> L24
        goto L8
    L11:
        byte[] r105 = r111.digest();     // Catch: Throwable -> L22 IOException -> L24
        StringBuilder r112 = new StringBuilder();     // Catch: Throwable -> L22 IOException -> L24
        int r106 = r105.length;     // Catch: Throwable -> L22 IOException -> L24
    L12:
        if (r104 >= r106) goto L17;
        int r107 = r105[r104] & UByte.MAX_VALUE;     // Catch: Throwable -> L22 IOException -> L24
        if (r107 >= 16) goto L16;
        r112.append("0");     // Catch: Throwable -> L22 IOException -> L24
    L16:
        r112.append(Integer.toHexString(r107));     // Catch: Throwable -> L22 IOException -> L24
        r104 = r104 + 1;     // Catch: Throwable -> L22 IOException -> L24
        goto L12
    L17:
        String r108 = r112.toString();     // Catch: Throwable -> L22 IOException -> L24
    L46:
        r101.close();     // Catch: IOException -> L20
    L21:
        return r108;
    L20:
        HybridLogger r113 = HybridLogger.f246343a;
        HybridLogger.i("XPredefine", "Exception on closing input stream", null, 12);
    L22:
        th = move-exception;
        r101.close();     // Catch: IOException -> L31
    L32:
        throw th;
    L31:
        HybridLogger r114 = HybridLogger.f246343a;
        HybridLogger.i("XPredefine", "Exception on closing input stream", null, 12);
    L24:
        HybridLogger.i("XPredefine", "Unable to process file ", null, 12);     // Catch: Throwable -> L22
        r101.close();     // Catch: IOException -> L27
    L28:
        return null;
    L27:
        HybridLogger r109 = HybridLogger.f246343a;
        HybridLogger.i("XPredefine", "Exception on closing input stream", null, 12);
    L33:
        HybridLogger.i("XPredefine", "Exception while getting FileInputStream", null, 12);
    L34:
        return null;
    }
}
