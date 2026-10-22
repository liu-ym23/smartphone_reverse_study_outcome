package com.bytedance.interaction.game.ext.goldenFinger.predefine.security;

import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.agilelogger.ALog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.UByte;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
public final class GoldenFingerFileValidate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GoldenFingerFileValidate f250923a = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/interaction/game/ext/goldenFinger/predefine/security/GoldenFingerFileValidate$TypeEnum;", "", "MD5", "SHA256", "SIZE_SHA256", "interaction-ext_release"}, k = 1, mv = {1, 4, 0})
    public static final enum TypeEnum extends Enum<TypeEnum> {
        public static final TypeEnum MD5 = null;
        public static final TypeEnum SHA256 = null;
        public static final TypeEnum SIZE_SHA256 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TypeEnum[] f250924a = null;

        static {
            TypeEnum r100 = new TypeEnum("MD5", 0);
            MD5 = r100;
            TypeEnum r101 = new TypeEnum("SHA256", 1);
            SHA256 = r101;
            TypeEnum r102 = new TypeEnum("SIZE_SHA256", 2);
            SIZE_SHA256 = r102;
            f250924a = new TypeEnum[]{r100, r101, r102};
        }

        public static TypeEnum valueOf(String r100) {
            return (TypeEnum) a.a(TypeEnum.class, r100);
        }

        public static TypeEnum[] values() {
            return (TypeEnum[]) f250924a.clone();
        }

        public TypeEnum(String r100, int r101) {
            super(r100, r101);
        }
    }

    public GoldenFingerFileValidate() {
    }

    static {
        f250923a = new GoldenFingerFileValidate();
    }

    public static TypeEnum a(String r100) {
        if (Intrinsics.areEqual(r100, "sha256") == false) goto L7;
        return TypeEnum.SHA256;
    L7:
        if (Intrinsics.areEqual(r100, "mdf5") == false) goto L11;
        return TypeEnum.MD5;
    L11:
        if (Intrinsics.areEqual(r100, "size_sha256") == true) goto L13;
        return null;
    L13:
        return TypeEnum.SIZE_SHA256;
    }

    public static String b(PolarisFileWrapper r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r101);     // Catch: NoSuchAlgorithmException -> L33
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: FileNotFoundException -> L31
        byte[] r104 = new byte[8192];     // Catch: IOException -> L21 Throwable -> L26
        int r105 = r103.read(r104);     // Catch: IOException -> L21 Throwable -> L26
    L7:
        int r106 = 0;
        if (r105 <= 0) goto L10;
        r102.update(r104, 0, r105);     // Catch: IOException -> L21 Throwable -> L26
        r105 = r103.read(r104);     // Catch: IOException -> L21 Throwable -> L26
        goto L7
    L10:
        byte[] r107 = r102.digest();     // Catch: IOException -> L21 Throwable -> L26
        StringBuilder r108 = new StringBuilder();     // Catch: IOException -> L21 Throwable -> L26
        int r109 = r107.length;     // Catch: IOException -> L21 Throwable -> L26
    L11:
        if (r106 >= r109) goto L16;
        int r110 = r107[r106] & UByte.MAX_VALUE;     // Catch: IOException -> L21 Throwable -> L26
        if (r110 >= 16) goto L15;
        r108.append("0");     // Catch: IOException -> L21 Throwable -> L26
    L15:
        r108.append(Integer.toHexString(r110));     // Catch: IOException -> L21 Throwable -> L26
        r106 = r106 + 1;     // Catch: IOException -> L21 Throwable -> L26
        goto L11
    L16:
        String r111 = r108.toString();     // Catch: IOException -> L21 Throwable -> L26
    L44:
        r103.close();     // Catch: IOException -> L19
    L20:
        return r111;
    L19:
        int r112 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
    L26:
        th = move-exception;
        r103.close();     // Catch: IOException -> L29
    L30:
        throw th;
    L29:
        int r113 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
    L21:
        int r114 = f96.a.f475971a;     // Catch: Throwable -> L26
        f96.a.a("interactive_predefine", "Unable to process file ", null);     // Catch: Throwable -> L26
        r103.close();     // Catch: IOException -> L24
    L25:
        return null;
    L24:
        int r115 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
    L31:
        int r116 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception while getting FileInputStream", null);
    L32:
        return null;
    }

    public static boolean c(TypeEnum r110, String r111, PolarisFileWrapper r112) {
        long r100 = System.currentTimeMillis();
        if (TextUtils.isEmpty(r111) == true) goto L48;
        int r101 = k96.a.f502160a[r110.ordinal()];
        if (r101 != 1) goto L7;
        String r102 = b(r112, "MD5");
    L42:
        int r103 = f96.a.f475971a;
        f96.a.d("interactive_predefine", "fileSignature call", MapsKt.mapOf(new Pair[]{TuplesKt.to("res", r102), TuplesKt.to("type", r110.name())}));
        if (TextUtils.isEmpty(r102) == false) goto L46;
        ALog.d(f96.a.c("interactive_predefine"), f96.a.b("calculatedDigest null", null));
        return false;
    L46:
        boolean r104 = StringsKt.equals(r102, r111, true);
        f96.a.a("interactive_predefine", "validateFile result " + r104, MapsKt.mapOf(new Pair[]{TuplesKt.to("standardStr", r111), TuplesKt.to("result", Boolean.valueOf(r104)), TuplesKt.to("duration", Long.valueOf(System.currentTimeMillis() - r100))}));
        return r104;
    L7:
        if (r101 == 2) goto L40;
        if (r101 != 3) goto L39;
        MessageDigest r113 = MessageDigest.getInstance("SHA-256");     // Catch: NoSuchAlgorithmException -> L36
        PolarisFileInputStreamWrapper r114 = new PolarisFileInputStreamWrapper(r112);     // Catch: FileNotFoundException -> L35
        String r105 = String.valueOf(r114.getChannel().size());     // Catch: IOException -> L26 Throwable -> L30
        Charset r115 = Charsets.UTF_8;     // Catch: IOException -> L26 Throwable -> L30
        if (r105 == null) goto L25;
        r113.update(r105.getBytes(r115));     // Catch: IOException -> L26 Throwable -> L30
        byte[] r106 = r113.digest();     // Catch: IOException -> L26 Throwable -> L30
        StringBuilder r116 = new StringBuilder();     // Catch: IOException -> L26 Throwable -> L30
        int r117 = r106.length;     // Catch: IOException -> L26 Throwable -> L30
        int r118 = 0;
    L15:
        if (r118 >= r117) goto L20;
        int r119 = r106[r118] & UByte.MAX_VALUE;     // Catch: IOException -> L26 Throwable -> L30
        if (r119 >= 16) goto L19;
        r116.append("0");     // Catch: IOException -> L26 Throwable -> L30
    L19:
        r116.append(Integer.toHexString(r119));     // Catch: IOException -> L26 Throwable -> L30
        r118 = r118 + 1;     // Catch: IOException -> L26 Throwable -> L30
        goto L15
    L20:
        r102 = r116.toString();     // Catch: IOException -> L26 Throwable -> L30
        r114.close();     // Catch: IOException -> L23
    L23:
        int r107 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
        goto L42
    L25:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");     // Catch: IOException -> L26 Throwable -> L30
    L26:
        int r108 = f96.a.f475971a;     // Catch: Throwable -> L30
        f96.a.a("interactive_predefine", "Unable to process file ", null);     // Catch: Throwable -> L30
        r114.close();     // Catch: IOException -> L29
    L29:
        int r109 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
    L35:
        int r120 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception while getting FileInputStream", null);
    L30:
        th = move-exception;
        r114.close();     // Catch: IOException -> L33
    L34:
        throw th;
    L33:
        int r121 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "Exception on closing input stream", null);
    L37:
        r102 = null;
        goto L42
    L39:
        throw new NoWhenBranchMatchedException();
    L40:
        r102 = b(r112, "SHA-256");
        goto L42
    L48:
        int r122 = f96.a.f475971a;
        f96.a.a("interactive_predefine", "MD5 string empty or updateFile null", null);
        return false;
    }
}
