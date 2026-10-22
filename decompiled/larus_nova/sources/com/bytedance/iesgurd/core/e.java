package com.bytedance.iesgurd.core;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bytedance.ee.bear.operation.api.event.OperationName;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.common.util.UriUtil;
import com.ss.android.ttve.model.VETrackParams;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f250656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicBoolean f250657b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, com.bytedance.iesgurd.a> f250658c = null;

    public static final class a implements FileFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f250659a = null;

        static {
            f250659a = new a();
        }

        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            return r100.isDirectory();
        }
    }

    static {
        f250656a = new LinkedHashMap();
        f250657b = new AtomicBoolean(false);
        f250658c = new ConcurrentHashMap();
    }

    public static String a(String r100) {
        return "gecko_build_in" + File.separator + r100;
    }

    public static Long h(PolarisFileWrapper r110) {
        File[] r100 = r110.listFiles();
        Long r101 = null;
        boolean r102 = false;
        if (r100 == null) goto L22;
        boolean r103 = true;
        if (r100.length > 1) goto L8;
        r103 = false;
    L8:
        int r104 = r100.length;
        Long r105 = null;
        Long r106 = null;
        int r107 = 0;
    L9:
        if (r107 >= r104) goto L21;
        File r108 = r100[r107];
        if (r108.isDirectory() == false) goto L20;
        if (StringsKt.endsWith$default(r108.getName(), "--pending-delete", false, 2, null) == true) goto L20;
        if (StringsKt.endsWith$default(r108.getName(), "--updating", false, 2, null) == true) goto L20;
        if (r106 != null) goto L18;
    L19:
        r106 = Long.valueOf(r108.lastModified());
        r105 = Long.valueOf(CastLongProtector.parseLong(r108.getName()));
        goto L20
    L18:
        if (r106.longValue() < r108.lastModified()) goto L19;
    L20:
        r107 = r107 + 1;
        goto L9
    L21:
        r102 = r103;
        r101 = r105;
    L22:
        if (r102 == false) goto L24;
        c(r110.getAbsolutePath(), r101);
    L24:
        return r101;
    }

    public static String k(String r100) {
        return new Uri.Builder().scheme(UriUtil.LOCAL_ASSET_SCHEME).authority("").path(r100).build().toString();
    }

    public static String l(String r100) {
        if (StringsKt.contains$default(r100, "@", false, 2, null) == true) goto L7;
        return Uri.fromFile(new PolarisFileWrapper(r100)).toString();
    L7:
        return "file:///" + r100;
    }

    public static void c(String r100, Long r101) {
        String r102 = String.valueOf(r101);
        File[] r103 = new PolarisFileWrapper(r100).listFiles(a.f250659a);
        int r104 = 0;
        if (r103 == null) goto L11;
        int r105 = r103.length;
        int r106 = 0;
    L5:
        if (r104 >= r105) goto L10;
        File r107 = r103[r104];
        if ((!Intrinsics.areEqual(r107.getName(), r102)) == false) goto L9;
        GeckoLogger.d("delete buildin file: " + r107.getAbsolutePath());
        com.bytedance.iesgurd.core.a.c(r107);
        r106 = 1;
    L9:
        r104 = r104 + 1;
        goto L5
    L10:
        r104 = r106;
    L11:
        if (r104 == 0) goto L17;
        com.bytedance.iesgurd.core.a.b();
        return;
    }

    public static boolean f(Context r100, String r101) {
        if (StringsKt.startsWith$default(r101, File.separator, false, 2, null) == false) goto L12;
        if (r101 == null) goto L7;
        r101 = r101.substring(1);
        goto L12
    L7:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L12:
        CloseableKt.closeFinally(r100.getAssets().open(r101), null);     // Catch: IOException -> L11
        return true;
    L14:
        return false;
    }

    public static Object i(String r100, String r101) {
        Map<String, Object> r102 = f250656a;
        monitor-enter(r102);
        Object r103 = ((LinkedHashMap) r102).get(r100 + r101);     // Catch: Throwable -> L9
        if (r103 != null) goto L7;
        r103 = new Object();     // Catch: Throwable -> L9
        r102.put(r100 + r101, r103);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r102);
        return r103;
    L9:
        th = move-exception;
        throw th;
    }

    public static String b(Context r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder();
        r103.append(r100.getFilesDir());
        String r104 = File.separator;
        r103.append(r104);
        r103.append("gecko_build_in");
        r103.append(r104);
        r103.append(r101);
        r103.append(r104);
        r103.append(r102);
        return r103.toString();
    }

    public static Pair d(Context r100, String r110, String r111) {
        GeckoLogger.d("build-in decompress channel,accessKey:" + r110 + ",channel:" + r111);     // Catch: Throwable -> L45
        if (e(r100, a(r110), r111) == true) goto L7;
        String r101 = "build-in channel does not exist in assets dir,accessKey:" + r110 + ",channel:" + r111;     // Catch: Throwable -> L45
        GeckoLogger.d(r101);     // Catch: Throwable -> L45
        return new Pair(null, r101);
    L7:
        String r102 = a(r110) + File.separator + r111;     // Catch: Throwable -> L45
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
        String[] r104 = r100.getAssets().list(r102);     // Catch: Throwable -> L20
        if (r104 == null) goto L15;
        int r105 = r104.length;     // Catch: Throwable -> L20
        int r106 = 0;
        Long r107 = null;
    L12:
        if (r106 >= r105) goto L14;
        r107 = Long.valueOf(CastLongProtector.parseLong(r104[r106]));     // Catch: Throwable -> L18
        r106 = r106 + 1;     // Catch: Throwable -> L18
    L18:
        th = th;
    L22:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L45
        Object r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L45
    L23:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r109);     // Catch: Throwable -> L45
        if (r112 == null) goto L27;
        String r113 = "build-in get channel version failed,accessKey:" + r110 + ",channel:" + r111 + ",path:" + r102 + ",error:" + r112.getMessage();     // Catch: Throwable -> L45
        GeckoLogger.d(r113);     // Catch: Throwable -> L45
        return new Pair(null, r113);
    L27:
        PolarisFileWrapper r114 = new PolarisFileWrapper(b(r100, r110, r111));     // Catch: Throwable -> L45
        if (r114.exists() == false) goto L30;
        Long r115 = h(r114);     // Catch: Throwable -> L45
    L31:
        if (r107 == null) goto L44;
        if (Intrinsics.areEqual(r115, r107) == true) goto L44;
        AssetManager r116 = r100.getAssets();     // Catch: Throwable -> L45
        StringBuilder r117 = new StringBuilder();     // Catch: Throwable -> L45
        r117.append(r102);     // Catch: Throwable -> L45
        String r118 = File.separator;     // Catch: Throwable -> L45
        r117.append(r118);     // Catch: Throwable -> L45
        r117.append(r107);     // Catch: Throwable -> L45
        r117.append(r118);     // Catch: Throwable -> L45
        r117.append("res.zst");     // Catch: Throwable -> L45
        InputStream r119 = r116.open(r117.toString());     // Catch: Throwable -> L45
        PolarisFileWrapper r120 = new PolarisFileWrapper(r114, r107 + "--updating");     // Catch: Throwable -> L45
        ez5.c.delete(r120);     // Catch: Throwable -> L45
        if (r120.exists() == true) goto L38;
        r120.mkdirs();     // Catch: Throwable -> L45
    L38:
        PolarisFileWrapper r121 = new PolarisFileWrapper(r120, "res_temp");     // Catch: Throwable -> L45
        r121.createNewFile();     // Catch: Throwable -> L45
        ez5.j.a(r119, r121);     // Catch: Throwable -> L45
        ez5.j.c(new PolarisFileInputStreamWrapper(r121), r120.getAbsolutePath(), r111);     // Catch: Throwable -> L45
        new PolarisFileWrapper(r120, r111).renameTo(new PolarisFileWrapper(r120, "res"));     // Catch: Throwable -> L45
        r120.renameTo(new PolarisFileWrapper(r114, String.valueOf(r107)));     // Catch: Throwable -> L45
        r121.delete();     // Catch: Throwable -> L45
        if (r115 == null) goto L42;
        GeckoLogger.d("build-in remove old version in storage,accessKey:" + r110 + ",channel:" + r111 + ",old version:" + r115);     // Catch: Throwable -> L45
        c(r114.getAbsolutePath(), r107);     // Catch: Throwable -> L45
    L42:
        return new Pair(r107, null);
    L44:
        return new Pair(r115, null);
    L30:
        r115 = null;
        goto L31
    L14:
        Unit r122 = Unit.INSTANCE;     // Catch: Throwable -> L18
    L16:
        r109 = Result.m9449constructorimpl(r122);     // Catch: Throwable -> L18
        goto L23
    L15:
        r122 = null;
        r107 = null;
    L20:
        th = th;
        r107 = null;
    L45:
        th = move-exception;
        String r123 = "decompress build-in resource failed:" + th.getMessage() + ",accessKey:" + r110 + ",channel:" + r111;
        GeckoLogger.w(r123);
        return new Pair(null, r123);
    }

    public static boolean e(Context r100, String r101, String r102) {
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L4
        Object r104 = Result.m9449constructorimpl(r100.getAssets().list(r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r104) == false) goto L9;
        r104 = null;
    L9:
        String[] r105 = (String[]) r104;
        if (r105 != null) goto L12;
    L14:
        return false;
    L12:
        if (ArraysKt.contains(r105, r102) != true) goto L14;
        return true;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static com.bytedance.iesgurd.a g(Context r110, String r111, String r112, String r113) {
        String r100 = File.separator;
        Long r101 = null;
        if (StringsKt.startsWith$default(r113, r100, false, 2, null) == false) goto L5;
        String r102 = r113;
    L6:
        Map<String, com.bytedance.iesgurd.a> r103 = f250658c;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        if (r104.containsKey(r111 + r112) == false) goto L54;
        com.bytedance.iesgurd.a r105 = (com.bytedance.iesgurd.a) r104.get(r111 + r112);
        if (r105 == null) goto L11;
        String r106 = r105.f250627a;
    L13:
        if (Intrinsics.areEqual(r106, "deleted_path") == true) goto L48;
        if (r105 == null) goto L16;
        String r107 = r105.f250627a;
    L18:
        if (Intrinsics.areEqual(r107, VETrackParams.EMPTY_PATH) == true) goto L48;
        StringBuilder r108 = new StringBuilder();
        if (r105 != null) goto L23;
        Intrinsics.throwNpe();
    L23:
        r108.append(r105.f250627a);
        r108.append(r102);
        Uri r109 = UriProtector.parse(r108.toString());
        String r114 = r109.getPath();
        if (r114 == null) goto L54;
        String r115 = r109.getScheme();
        if (r115 == null) goto L47;
        int r116 = r115.hashCode();
        if (r116 == 3143036) goto L41;
        if (r116 != 93121264) goto L47;
        if (r115.equals(UriUtil.LOCAL_ASSET_SCHEME) == false) goto L47;
        if (f(r110, r114) == false) goto L39;
        return new com.bytedance.iesgurd.a(r109.toString(), r105.f250628b, null);
    L39:
        return new com.bytedance.iesgurd.a(null, null, "build-in bundle does not exist in assets path:" + r105.f250627a + ",accessKey:" + r111 + ",channel:" + r112 + ",bundle:" + r113);
    L41:
        if (r115.equals("file") == false) goto L47;
        if (new PolarisFileWrapper(r109.getPath()).exists() == false) goto L46;
        return new com.bytedance.iesgurd.a(r109.toString(), r105.f250628b, null);
    L46:
        return new com.bytedance.iesgurd.a(null, null, "build-in bundle does not exist in file path:" + r105.f250627a + ",accessKey:" + r111 + ",channel:" + r112 + ",bundle:" + r113);
    L47:
        GeckoLogger.d("build-in cached channel path:" + r105.f250627a + " is incorrect,accessKey:" + r111 + ",channel:" + r112 + ",bundle:" + r113);
        goto L54
    L16:
        r107 = null;
    L48:
        String r117 = r105.f250629c;
        if (r117 != null) goto L52;
        r117 = "";
    L52:
        GeckoLogger.d(r117);
        return new com.bytedance.iesgurd.a(null, null, r105.f250629c);
    L11:
        r106 = null;
    L54:
        String r118 = OperationName.OPERATION_OFFLINE_AVAILABLE + r100 + r112;
        if (e(r110, OperationName.OPERATION_OFFLINE_AVAILABLE, r112) == true) goto L57;
        String r119 = a(r111) + r100 + r112;
        String r120 = r119 + r100 + "res";
        if (e(r110, r119, "res") == false) goto L68;
        r118 = k(r120);
        if (f(r110, r120 + r102) == false) goto L66;
        String r121 = k(r120 + r102);
    L65:
        String r122 = null;
    L121:
        String r123 = r111 + r112;
        if (r118 != null) goto L124;
        r118 = VETrackParams.EMPTY_PATH;
    L124:
        r104.put(r123, new com.bytedance.iesgurd.a(r118, r101, r122));
        return new com.bytedance.iesgurd.a(r121, r101, r122);
    L66:
        String r124 = "build-in bundle does not exist in assets path:" + r120 + ",accessKey:" + r111 + ",channel:" + r112;
    L70:
        r122 = r124;
        r121 = null;
        goto L121
    L68:
        if (j(false, r110, r111, r112) == false) goto L72;
        r118 = "deleted_path";
        r124 = "build-in channel is offline in current App version,accessKey:" + r111 + ",channel:" + r112;
        goto L70
    L72:
        if (r104.get(r111 + r112) != null) goto L94;
        Object r125 = i(r111, r112);
        monitor-enter(r125);
    L91:
        th = move-exception;
        throw th;
    L76:
        if (((ConcurrentHashMap) r103).get(r111 + r112) != null) goto L88;
        Pair r126 = d(r110, r111, r112);     // Catch: Throwable -> L91
        Long r127 = (Long) r126.getFirst();     // Catch: Throwable -> L91
        if (r127 == null) goto L85;
        String r128 = b(r110, r111, r112) + r100 + r127.longValue() + r100 + "res";     // Catch: Throwable -> L91
        ((ConcurrentHashMap) r103).put(r111 + r112, new com.bytedance.iesgurd.a(l(r128), (Long) r126.getFirst(), (String) r126.getSecond()));     // Catch: Throwable -> L91
        Object r129 = ((ConcurrentHashMap) r103).get(r111 + r112);     // Catch: Throwable -> L91
        if (r129 != null) goto L82;
        Intrinsics.throwNpe();     // Catch: Throwable -> L91
    L82:
        com.bytedance.iesgurd.a r130 = (com.bytedance.iesgurd.a) r129;     // Catch: Throwable -> L91
        monitor-exit(r125);
    L113:
        String r131 = r130.f250629c;
        String r132 = r130.f250627a;
        if (r132 == null) goto L120;
        Long r133 = r130.f250628b;
        PolarisFileWrapper r134 = new PolarisFileWrapper(UriProtector.parse(r132).getPath(), r102);
        if (r134.exists() == false) goto L118;
        String r135 = l(r134.getAbsolutePath());
    L119:
        String r136 = r131;
        r118 = r132;
        r122 = r136;
        r101 = r133;
        r121 = r135;
        goto L121
    L118:
        r131 = "build-in bundle does not exist in file path:" + r132 + ",accessKey:" + r111 + ",channel:" + r112 + ",bundle:" + r102;
        r135 = null;
        goto L119
    L120:
        r124 = r131;
        r118 = null;
        goto L70
    L85:
        r130 = new com.bytedance.iesgurd.a(null, null, (String) r126.getSecond());     // Catch: Throwable -> L91
        monitor-exit(r125);
        goto L113
    L88:
        Unit r137 = Unit.INSTANCE;     // Catch: Throwable -> L91
        monitor-exit(r125);
    L94:
        Object r138 = r104.get(r111 + r112);
        if (r138 != null) goto L98;
        Intrinsics.throwNpe();
    L98:
        if (Intrinsics.areEqual(((com.bytedance.iesgurd.a) r138).f250627a, VETrackParams.EMPTY_PATH) == true) goto L109;
        Object r139 = r104.get(r111 + r112);
        if (r139 != null) goto L103;
        Intrinsics.throwNpe();
    L103:
        if (Intrinsics.areEqual(((com.bytedance.iesgurd.a) r139).f250627a, "deleted_path") == true) goto L109;
        Object r140 = r104.get(r111 + r112);
        if (r140 != null) goto L108;
        Intrinsics.throwNpe();
    L108:
        r130 = (com.bytedance.iesgurd.a) r140;
    L109:
        Object r141 = r104.get(r111 + r112);
        if (r141 != null) goto L112;
        Intrinsics.throwNpe();
    L112:
        r130 = new com.bytedance.iesgurd.a(null, null, ((com.bytedance.iesgurd.a) r141).f250629c);
        goto L113
    L57:
        if (f(r110, r118 + r102) == false) goto L59;
        r121 = k(r118 + r102);
        goto L65
    L59:
        r124 = "build-in bundle does not exist in assets path:" + r118 + ",accessKey:" + r111 + ",channel:" + r112;
        goto L70
    L5:
        r102 = r100 + r113;
        goto L6
    }

    public static boolean j(boolean r110, Context r111, String r112, String r113) {
        if (f250657b.get() == false) goto L5;
        return false;
    L5:
        PolarisFileWrapper r100 = new PolarisFileWrapper(b(r111, r112, r113));
        if (r100.exists() == true) goto L8;
        return false;
    L8:
        ConcurrentHashMap r101 = (ConcurrentHashMap) f250658c;
        com.bytedance.iesgurd.a r102 = (com.bytedance.iesgurd.a) r101.get(r112 + r113);
        if (r102 == null) goto L11;
        String r103 = r102.f250627a;
    L13:
        if (Intrinsics.areEqual(r103, "deleted_path") == false) goto L18;
        GeckoLogger.d("build-in channel is offline return,accessKey:" + r112 + ",channel:" + r113);
        if (r110 == false) goto L17;
        ez5.c.delete(r100);
        GeckoLogger.d("build-in offline channel is deleted,accessKey:" + r112 + ",channel:" + r113);
    L17:
        return true;
    L18:
        Long r104 = h(r100);
        if (r104 == null) goto L26;
        r104.longValue();
        if (e(r111, a(r112), r113) == true) goto L26;
        GeckoLogger.d("build-in channel is offline check,accessKey:" + r112 + ",channel:" + r113);
        StringBuilder r114 = new StringBuilder();
        r114.append(r112);
        r114.append(r113);
        r101.put(r114.toString(), new com.bytedance.iesgurd.a("deleted_path", null, "build-in channel is offline in current App version,accessKey:" + r112 + ",channel:" + r113));
        if (r110 == false) goto L25;
        ez5.c.delete(r100);
        GeckoLogger.d("build-in offline channel is deleted,accessKey:" + r112 + ",channel:" + r113 + ",storage dir:" + r100);
    L25:
        return true;
    L26:
        return false;
    L11:
        r103 = null;
        goto L13
    }
}
