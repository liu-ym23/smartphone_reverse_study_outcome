package com.larus.avlink.gallery.storage;

import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaLifecycleState;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.dora.impl.ota.g2.j0;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.MutexImpl;
import w88.o;
import w88.p;

/* JADX INFO: loaded from: classes25.dex */
public final class GalleryStoragePolicyManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GalleryStoragePolicyManager f292721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f292722b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f292723c = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f292724a = null;

        static {
            int[] r100 = new int[MediaLifecycleState.values().length];
            r100[MediaLifecycleState.FAILED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f292724a = r100;
        }
    }

    public GalleryStoragePolicyManager() {
    }

    static {
        f292721a = new GalleryStoragePolicyManager();
        f292722b = kotlinx.coroutines.sync.b.a();
        f292723c = LazyKt.lazy(new e());
    }

    public static boolean m() {
        String r100 = AccountService.f365697a.getUserId();
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        r100 = "default";
    L9:
        return ((Keva) f292723c.getValue()).getBoolean("dora_gallery_storage_database_migrated_".concat(r100), false);
    L5:
        r101 = false;
        goto L6
    }

    public static List f(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L22
        if (r100.exists() == true) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (r100.isFile() == true) goto L9;
        File[] r102 = r100.listFiles();     // Catch: Throwable -> L22
        if (r102 == null) goto L19;
        Collection r103 = new ArrayList();     // Catch: Throwable -> L22
        int r104 = r102.length;     // Catch: Throwable -> L22
        int r105 = 0;
    L13:
        if (r105 >= r104) goto L20;
        File r106 = r102[r105];     // Catch: Throwable -> L22
        if (r106.isDirectory() == false) goto L17;
        List r107 = CollectionsKt.listOf(r106);     // Catch: Throwable -> L22
        GalleryStoragePolicyManager r108 = f292721a;     // Catch: Throwable -> L22
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L22
        r108.getClass();     // Catch: Throwable -> L22
        List r109 = CollectionsKt.plus(r107, f(r106));     // Catch: Throwable -> L22
    L18:
        CollectionsKt.addAll(r103, r109);     // Catch: Throwable -> L22
        r105 = r105 + 1;     // Catch: Throwable -> L22
        goto L13
    L17:
        r109 = CollectionsKt.listOf(r106);     // Catch: Throwable -> L22
    L20:
        Object r110 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L22
    L24:
        Throwable r111 = Result.m9452exceptionOrNullimpl(r110);
        if (r111 == null) goto L29;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "childrenRecursively failed, path=" + r100.getAbsolutePath(), r111);
        r110 = CollectionsKt.emptyList();
    L29:
        return (List) r110;
    L19:
        r103 = CollectionsKt.emptyList();     // Catch: Throwable -> L22
        goto L20
    L9:
        return CollectionsKt.listOf(r100);
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    }

    public static void i(File r110) {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L31
        if (r110.exists() == true) goto L6;
        return;
    L6:
        if (r110.isFile() == true) goto L43;
        File[] r101 = r110.listFiles();     // Catch: Throwable -> L31
        if (r101 == null) goto L27;
        int r102 = r101.length;     // Catch: Throwable -> L31
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L26;
        File r104 = r101[r103];     // Catch: Throwable -> L31
        if (r104.isDirectory() == false) goto L25;
        Intrinsics.checkNotNull(r104);     // Catch: Throwable -> L31
        i(r104);     // Catch: Throwable -> L31
        File[] r105 = r104.listFiles();     // Catch: Throwable -> L31
        if (r105 == null) goto L22;
        boolean r106 = true;
        if (r105.length != 0) goto L19;
        boolean r107 = true;
    L20:
        if (r107 != true) goto L22;
    L23:
        if (r106 == false) goto L25;
        boolean r108 = r104.delete();     // Catch: Throwable -> L31
        FLogger.f375446a.i("GalleryStoragePolicyManager", "delete empty dir result=" + r108 + ", path=" + r104.getAbsolutePath());     // Catch: Throwable -> L31
        goto L25
    L19:
        r107 = false;
    L22:
        r106 = false;
    L25:
        r103 = r103 + 1;     // Catch: Throwable -> L31
        goto L11
    L26:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L31
    L28:
        Object r111 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L31
    L33:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L44;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "cleanupEmptyDirs failed, path=" + r110.getAbsolutePath(), r112);
        return;
    L44:
        return;
    L27:
        r109 = null;
        goto L28
    L43:
        return;
    L31:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    }

    public static Object j(Continuation r100) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupFallback$2(null), r100);
    }

    public static boolean n(File r100) {
        String r101 = r100.getAbsolutePath();
        com.larus.avlink.gallery.e.f292493a.getClass();
        List r102 = CollectionsKt.listOf(new File[]{com.larus.avlink.gallery.e.c(), com.larus.avlink.gallery.e.g(), com.larus.avlink.gallery.e.f(), com.larus.avlink.gallery.e.e(), com.larus.avlink.gallery.e.d(), new PolarisFileWrapper(com.larus.avlink.gallery.e.b(), "failed")});
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L26;
        String r104 = ((File) r103.next()).getAbsolutePath();
        if (Intrinsics.areEqual(r101, r104) == true) goto L16;
        Intrinsics.checkNotNull(r101);
        if (StringsKt.startsWith$default(r101, r104 + File.separator, false, 2, null) == true) goto L16;
        boolean r105 = false;
    L17:
        if (r105 == false) goto L9;
        return true;
    L16:
        r105 = true;
        goto L17
    L26:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        return false;
    }

    public static Long r(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Long.valueOf(r100.lastModified()));     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L11;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "safeLastModified failed, path=" + r100.getAbsolutePath(), r103);
        r102 = null;
    L11:
        return (Long) r102;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static long s(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        if (r100.isFile() == false) goto L6;
        long r102 = r100.length();     // Catch: Throwable -> L9
    L7:
        Object r103 = Result.m9449constructorimpl(Long.valueOf(r102));     // Catch: Throwable -> L9
    L11:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "safeLength failed, path=" + r100.getAbsolutePath(), r104);
        r103 = 0L;
    L16:
        return ((Number) r103).longValue();
    L6:
        r102 = 0;
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public static n t(List r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        LinkedHashSet r102 = new LinkedHashSet();
        Iterator r103 = CollectionsKt.distinct(r100).iterator();
    L4:
        if (r103.hasNext() == false) goto L19;
        String r104 = (String) r103.next();
        if (StringsKt.isBlank(r104) == true) goto L4;
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104);
        r101.add(r105.getAbsolutePath());
        if (r105.isDirectory() == true) goto L12;
        if (StringsKt.endsWith$default(r104, File.separator, false, 2, null) == false) goto L4;
    L12:
        GalleryStoragePolicyManager r106 = f292721a;
        String r107 = r105.getAbsolutePath();
        char r108 = File.separatorChar;
        r106.getClass();
        int r109 = r107.length();
    L13:
        if (r109 <= 0) goto L17;
        int r110 = r109 - 1;
        if (r107.charAt(r110) != r108) goto L17;
        r109 = r110;
    L17:
        r102.add(r107.substring(0, r109));
        goto L4
    L19:
        return new n(r101, r102);
    }

    public static long u(File r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L16
        if (r100.exists() == true) goto L7;
        return 0;
    L7:
        if (r100.isFile() == false) goto L10;
        f292721a.getClass();     // Catch: Throwable -> L16
        return s(r100);
    L10:
        f292721a.getClass();     // Catch: Throwable -> L16
        Iterator r102 = f(r100).iterator();     // Catch: Throwable -> L16
        long r103 = 0;
    L12:
        if (r102.hasNext() == false) goto L14;
        File r104 = (File) r102.next();     // Catch: Throwable -> L16
        f292721a.getClass();     // Catch: Throwable -> L16
        r103 = r103 + s(r104);     // Catch: Throwable -> L16
        goto L12
    L14:
        Object r105 = Result.m9449constructorimpl(Long.valueOf(r103));     // Catch: Throwable -> L16
    L18:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L23;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "totalSize failed, path=" + r100.getAbsolutePath(), r106);
        r105 = 0L;
    L23:
        return ((Number) r105).longValue();
    L16:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    public final Object l(Continuation<? super Set<String>> r100) {
        if ((r100 instanceof GalleryStoragePolicyManager$getInProgressSourcePaths$1) == false) goto L7;
        GalleryStoragePolicyManager$getInProgressSourcePaths$1 r101 = (GalleryStoragePolicyManager$getInProgressSourcePaths$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        GalleryStoragePolicyManager r106 = (GalleryStoragePolicyManager) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L55
    L21:
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r108 = ((Iterable) r103).iterator();     // Catch: Throwable -> L55
    L23:
        if (r108.hasNext() == false) goto L27;
        Object r109 = r108.next();     // Catch: Throwable -> L55
        if (((MediaMetadata) r109).isInProgress() == false) goto L23;
        r107.add(r109);     // Catch: Throwable -> L55
        goto L23
    L27:
        ArrayList r110 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r111 = r107.iterator();     // Catch: Throwable -> L55
    L29:
        if (r111.hasNext() == false) goto L33;
        String r112 = ((MediaMetadata) r111.next()).getDownloadFilePath();     // Catch: Throwable -> L55
        if (r112 == null) goto L29;
        r110.add(r112);     // Catch: Throwable -> L55
        goto L29
    L33:
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r114 = r110.iterator();     // Catch: Throwable -> L55
    L35:
        if (r114.hasNext() == false) goto L39;
        Object r115 = r114.next();     // Catch: Throwable -> L55
        if ((!StringsKt.isBlank((String) r115)) == false) goto L35;
        r113.add(r115);     // Catch: Throwable -> L55
        goto L35
    L39:
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r113, 10));     // Catch: Throwable -> L55
        Iterator r117 = r113.iterator();     // Catch: Throwable -> L55
    L41:
        if (r117.hasNext() == false) goto L43;
        r116.add(new PolarisFileWrapper((String) r117.next()));     // Catch: Throwable -> L55
        goto L41
    L43:
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L55
        Iterator r119 = r116.iterator();     // Catch: Throwable -> L55
    L45:
        if (r119.hasNext() == false) goto L49;
        Object r120 = r119.next();     // Catch: Throwable -> L55
        r106.getClass();     // Catch: Throwable -> L55
        if (p((File) r120, null) == false) goto L45;
        r118.add(r120);     // Catch: Throwable -> L55
        goto L45
    L49:
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r118, 10));     // Catch: Throwable -> L55
        Iterator r122 = r118.iterator();     // Catch: Throwable -> L55
    L51:
        if (r122.hasNext() == false) goto L53;
        r121.add(((File) r122.next()).getAbsolutePath());     // Catch: Throwable -> L55
        goto L51
    L53:
        Object r123 = Result.m9449constructorimpl(CollectionsKt.toSet(r121));     // Catch: Throwable -> L55
    L57:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L86;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "getInProgressSourcePaths: load metadata failed", r124);
        return SetsKt.emptySet();
    L86:
        return r123;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r125 = Result.Companion;     // Catch: Throwable -> L55
        AlbumDataBaseHelper r126 = AlbumDataBaseHelper.f292393a;     // Catch: Throwable -> L55
        r101.L$0 = this;     // Catch: Throwable -> L55
        r101.label = 1;     // Catch: Throwable -> L55
        r103 = r126.m(r101);     // Catch: Throwable -> L55
        if (r103 != r104) goto L20;
        return r104;
    L20:
        r106 = this;
    L55:
        th = move-exception;
        Result.Companion r127 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new GalleryStoragePolicyManager$getInProgressSourcePaths$1(this, r100);
        goto L8
    }

    public static final Object a(GalleryStoragePolicyManager r110, Continuation r111) {
        GalleryStoragePolicyManager r100 = r110;
        r110.getClass();
        if ((r111 instanceof GalleryStoragePolicyManager$cleanupOrphanTempFiles$1) == false) goto L7;
        GalleryStoragePolicyManager$cleanupOrphanTempFiles$1 r101 = (GalleryStoragePolicyManager$cleanupOrphanTempFiles$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        r100 = (GalleryStoragePolicyManager) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L26
    L20:
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L26
        Iterator r107 = ((Iterable) r103).iterator();     // Catch: Throwable -> L26
    L22:
        if (r107.hasNext() == false) goto L24;
        CollectionsKt.addAll(r106, ((MediaMetadata) r107.next()).getAllFilePaths());     // Catch: Throwable -> L26
        goto L22
    L24:
        r100.getClass();     // Catch: Throwable -> L26
        Object r108 = Result.m9449constructorimpl(t(r106));     // Catch: Throwable -> L26
    L28:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 != null) goto L64;
        n r112 = (n) r108;
        long r113 = System.currentTimeMillis();
        com.larus.avlink.gallery.e.f292493a.getClass();
        List r114 = CollectionsKt.listOf(new Pair[]{TuplesKt.to(com.larus.avlink.gallery.e.c(), new com.larus.avlink.gallery.storage.a()), TuplesKt.to(com.larus.avlink.gallery.e.g(), new b()), TuplesKt.to(com.larus.avlink.gallery.e.f(), new c()), TuplesKt.to(com.larus.avlink.gallery.e.e(), new d())});
        ArrayList r115 = new ArrayList();
        Iterator r116 = r114.iterator();
    L32:
        if (r116.hasNext() == false) goto L63;
        Pair r117 = (Pair) r116.next();
        File r118 = (File) r117.component1();
        Function1 r119 = (Function1) r117.component2();
        GalleryStoragePolicyManager r120 = f292721a;
        Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L56
        r120.getClass();     // Catch: Throwable -> L56
        List r122 = f(r118);     // Catch: Throwable -> L56
        ArrayList r123 = new ArrayList();     // Catch: Throwable -> L56
        Iterator r124 = r122.iterator();     // Catch: Throwable -> L56
    L36:
        if (r124.hasNext() == false) goto L54;
        Object r125 = r124.next();     // Catch: Throwable -> L56
        File r126 = (File) r125;     // Catch: Throwable -> L56
        if (((Boolean) r119.invoke(r126)).booleanValue() == true) goto L40;
    L51:
        boolean r127 = false;
    L52:
        if (r127 == false) goto L36;
        r123.add(r125);     // Catch: Throwable -> L56
        goto L36
    L40:
        if (r126.isFile() == false) goto L51;
        if (o(r126, r112) == true) goto L51;
        Long r128 = r(r126);     // Catch: Throwable -> L56
        if (r128 != null) goto L46;
    L48:
        boolean r129 = false;
    L49:
        if (r129 == false) goto L51;
        r127 = true;
        goto L52
    L46:
        if ((r113 - r128.longValue()) <= 86400000) goto L48;
        r129 = true;
        goto L49
    L54:
        Object r130 = Result.m9449constructorimpl(r123);     // Catch: Throwable -> L56
    L58:
        Throwable r131 = Result.m9452exceptionOrNullimpl(r130);
        if (r131 == null) goto L62;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "cleanupOrphanTempFiles: scan dir failed, path=" + r118.getAbsolutePath(), r131);
        r130 = CollectionsKt.emptyList();
    L62:
        CollectionsKt.addAll(r115, (Iterable) r130);
    L56:
        th = move-exception;
        Result.Companion r132 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L58
    L63:
        o r133 = k(CollectionsKt.take(CollectionsKt.sortedWith(r115, new g()), 200), "orphan_temp", false, null);
        com.larus.avlink.gallery.e.f292493a.getClass();
        i(com.larus.avlink.gallery.e.f());
        i(com.larus.avlink.gallery.e.g());
        return r133;
    L64:
        FLogger.f375446a.e("GalleryStoragePolicyManager", "cleanupOrphanTempFiles: load metadata failed", r109);
        return new o(0, 0, "orphan_temp_skip_metadata_failed");
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        Result.Companion r134 = Result.Companion;     // Catch: Throwable -> L26
        AlbumDataBaseHelper r135 = AlbumDataBaseHelper.f292393a;     // Catch: Throwable -> L26
        r101.L$0 = r100;     // Catch: Throwable -> L26
        r101.label = 1;     // Catch: Throwable -> L26
        r103 = r135.m(r101);     // Catch: Throwable -> L26
        if (r103 != r104) goto L20;
        return r104;
    L26:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r101 = new GalleryStoragePolicyManager$cleanupOrphanTempFiles$1(r100, r111);
        goto L8
    }

    public static final Object b(GalleryStoragePolicyManager r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof GalleryStoragePolicyManager$cleanupSourceFilesLocked$1) == false) goto L7;
        GalleryStoragePolicyManager$cleanupSourceFilesLocked$1 r100 = (GalleryStoragePolicyManager$cleanupSourceFilesLocked$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        long r104 = r100.J$1;
        long r105 = r100.J$0;
        p r113 = (p) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L18:
        Set r114 = (Set) r112;
        com.larus.avlink.gallery.e.f292493a.getClass();
        List r106 = f(com.larus.avlink.gallery.e.c());
        ArrayList r107 = new ArrayList();
        Iterator r108 = r106.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        Object r109 = r108.next();
        f292721a.getClass();
        if (p((File) r109, null) == false) goto L20;
        r107.add(r109);
        goto L20
    L24:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r107.iterator();
    L26:
        if (r116.hasNext() == false) goto L30;
        Object r117 = r116.next();
        if (r114.contains(((File) r117).getAbsolutePath()) == true) goto L26;
        r115.add(r117);
        goto L26
    L30:
        List r118 = CollectionsKt.sortedWith(r115, new h());
        ArrayList r119 = new ArrayList();
        Iterator r120 = r118.iterator();
    L32:
        if (r120.hasNext() == false) goto L41;
        Object r121 = r120.next();
        f292721a.getClass();
        Long r122 = r((File) r121);
        if (r122 != null) goto L36;
    L38:
        boolean r123 = false;
    L39:
        if (r123 == false) goto L32;
        r119.add(r121);
        goto L32
    L36:
        if ((r105 - r122.longValue()) <= r104) goto L38;
        r123 = true;
        goto L39
    L41:
        Set r124 = CollectionsKt.toSet(r119);
        ArrayList r125 = new ArrayList();
        Iterator r126 = r118.iterator();
    L43:
        if (r126.hasNext() == false) goto L47;
        Object r127 = r126.next();
        if (r124.contains((File) r127) == true) goto L43;
        r125.add(r127);
        goto L43
    L47:
        ArrayList r128 = new ArrayList();
        Ref.LongRef r129 = new Ref.LongRef();
        Iterator r130 = r125.iterator();
        long r131 = 0;
    L49:
        if (r130.hasNext() == false) goto L51;
        File r132 = (File) r130.next();
        f292721a.getClass();
        r131 = r131 + s(r132);
        goto L49
    L51:
        r129.element = r131;
        Iterator r133 = r125.iterator();
    L53:
        if (r133.hasNext() == false) goto L57;
        File r134 = (File) r133.next();
        if (r129.element <= r113.f558700b) goto L53;
        r128.add(r134);
        long r135 = r129.element;
        f292721a.getClass();
        r129.element = r135 - s(r134);
        goto L53
    L57:
        Set r136 = SetsKt.plus(r124, r128);
        HashSet r137 = new HashSet();
        ArrayList r138 = new ArrayList();
        Iterator r139 = r136.iterator();
    L59:
        if (r139.hasNext() == false) goto L64;
        Object r140 = r139.next();
        if (r137.add(((File) r140).getAbsolutePath()) == false) goto L59;
        r138.add(r140);
        goto L59
    L64:
        return k(r138, "source_policy(expired=" + r124.size() + ", over_limit=" + r128.size() + ", retention_days=" + r113.f558699a + ", max_bytes=" + r113.f558700b + ", protected=" + r114.size() + ')', true, null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        Lazy r141 = f292723c;
        int r142 = ((Keva) r141.getValue()).getInt("dora_gallery_storage_pack_retention_days", 3);
        long r143 = ((Keva) r141.getValue()).getLong("dora_gallery_storage_pack_max_bytes", 3221225472L);
        int r144 = RangesKt.coerceIn(r142, 1, 30);
        p r145 = new p(r144, RangesKt.coerceIn(r143, j0.G2_OTA_SPACE_CHECK_BYTES, 21474836480L));
        r105 = System.currentTimeMillis();
        long r146 = (((((long) r144) * 24) * 60) * 60) * 1000;
        r100.L$0 = r145;
        r100.J$0 = r105;
        r100.J$1 = r146;
        r100.label = 1;
        r112 = r110.l(r100);
        if (r112 == r102) goto L96;
        r113 = r145;
        r104 = r146;
        goto L18
    L96:
        return r102;
    L7:
        r100 = new GalleryStoragePolicyManager$cleanupSourceFilesLocked$1(r110, r111);
        goto L8
    }

    public static Object g(MediaMetadata r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupAfterSync$2(r100, null), r101);
    }

    public static boolean o(File r100, n r101) {
        String r102 = r100.getAbsolutePath();
        if (r101.f292727a.contains(r102) == true) goto L23;
        Set<String> r103 = r101.f292728b;
        if ((r103 instanceof Collection) == true) goto L7;
    L9:
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        String r105 = (String) r104.next();
        Intrinsics.checkNotNull(r102);
        if (StringsKt.startsWith$default(r102, r105 + File.separator, false, 2, null) == false) goto L11;
        boolean r106 = true;
    L16:
        if (r106 == true) goto L24;
        return false;
    L24:
        return true;
    L15:
        r106 = false;
        goto L16
    L7:
        if (r103.isEmpty() == false) goto L9;
    L23:
        return true;
    }

    public static boolean p(File r100, MediaMetadata r101) {
        com.larus.avlink.gallery.e.f292493a.getClass();
        String r102 = com.larus.avlink.gallery.e.c().getAbsolutePath();
        String r103 = r100.getAbsolutePath();
        if (Intrinsics.areEqual(r103, r102) == true) goto L8;
        Intrinsics.checkNotNull(r103);
        if (StringsKt.startsWith$default(r103, r102 + File.separator, false, 2, null) == true) goto L8;
        boolean r104 = false;
    L9:
        if (r104 == true) goto L12;
        return false;
    L12:
        if (StringsKt.equals(FilesKt.getExtension(r100), "pack", true) == false) goto L15;
        return true;
    L15:
        if (StringsKt.equals(FilesKt.getExtension(r100), "mp4", true) == false) goto L29;
        if (r101 == null) goto L31;
        String r105 = r101.getDownloadFilePath();
        if (r105 != null) goto L22;
    L24:
        boolean r106 = false;
    L25:
        if (r106 == false) goto L29;
        int r107 = com.larus.avlink.gallery.j.f292609a;
        if (com.larus.avlink.gallery.j.c(r101.getMediaType()) == false) goto L29;
        return true;
    L22:
        if (Intrinsics.areEqual(new PolarisFileWrapper(r105).getAbsolutePath(), r100.getAbsolutePath()) != true) goto L24;
        r106 = true;
        goto L25
    L31:
        return true;
    L29:
        return false;
    L8:
        r104 = true;
        goto L9
    }

    public static w88.n d(String r100, List r101, Function1 r102) {
        ArrayList r103 = new ArrayList();
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        File r105 = (File) r104.next();
        f292721a.getClass();
        CollectionsKt.addAll(r103, f(r105));
        goto L4
    L6:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r103.iterator();
    L8:
        if (r107.hasNext() == false) goto L12;
        Object r108 = r107.next();
        if (((Boolean) r102.invoke(r108)).booleanValue() == false) goto L8;
        r106.add(r108);
        goto L8
    L12:
        Iterator r109 = r106.iterator();
        long r110 = 0;
    L14:
        if (r109.hasNext() == false) goto L16;
        File r111 = (File) r109.next();
        f292721a.getClass();
        r110 = r110 + s(r111);
        goto L14
    L16:
        int r112 = 0;
        if (r106.isEmpty() == true) goto L28;
        Iterator r113 = r106.iterator();
    L21:
        if (r113.hasNext() == false) goto L28;
        if (((File) r113.next()).isFile() == false) goto L21;
        r112 = r112 + 1;
        if (r112 >= 0) goto L21;
        CollectionsKt.throwCountOverflow();
    L28:
        return new w88.n(r100, r110, r112);
    }

    public static /* synthetic */ w88.n e(GalleryStoragePolicyManager r100, String r101, List r102) {
        Function1 r103 = new f();
        r100.getClass();
        return d(r101, r102, r103);
    }

    public static Object h(MediaMetadata r100, String r101, ContinuationImpl r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new GalleryStoragePolicyManager$cleanupDeletedMedia$2(r100, r101, null), r102);
    }

    public static o k(List r110, String r111, boolean r112, String r113) {
        HashSet r100 = new HashSet();
        ArrayList r101 = new ArrayList();
        Iterator r114 = r110.iterator();
    L4:
        if (r114.hasNext() == false) goto L8;
        Object r102 = r114.next();
        if (r100.add(((File) r102).getAbsolutePath()) == false) goto L4;
        r101.add(r102);
        goto L4
    L8:
        Iterator r115 = r101.iterator();
        int r103 = 0;
        long r104 = 0;
    L10:
        if (r115.hasNext() == false) goto L37;
        File r105 = (File) r115.next();
        GalleryStoragePolicyManager r106 = f292721a;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L31
        r106.getClass();     // Catch: Throwable -> L31
        if (n(r105) == false) goto L14;
        if (r112 == true) goto L20;
        if (p(r105, null) == false) goto L20;
        q(r105, r111, "skip_source", 0, r113);     // Catch: Throwable -> L31
    L20:
        if (r105.exists() == false) goto L10;
        long r108 = u(r105);     // Catch: Throwable -> L31
        if (r105.isDirectory() == false) goto L25;
        boolean r109 = FilesKt.deleteRecursively(r105);     // Catch: Throwable -> L31
    L26:
        if (r109 == false) goto L28;
        r103 = r103 + 1;     // Catch: Throwable -> L31
        r104 = r104 + r108;     // Catch: Throwable -> L31
        q(r105, r111, "success", r108, r113);     // Catch: Throwable -> L31
    L29:
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L10;
        FLogger.f375446a.e("GalleryStoragePolicyManager", "delete file failed, path=" + r105.getAbsolutePath() + ", reason=" + r111, r117);
        f292721a.getClass();
        q(r105, r111, com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, 0, r113);
        goto L10
    L28:
        q(r105, r111, "failed", r108, r113);     // Catch: Throwable -> L31
        goto L29
    L25:
        r109 = r105.delete();     // Catch: Throwable -> L31
        goto L26
    L14:
        q(r105, r111, "reject_invalid_path", 0, r113);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        Result.Companion r118 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L37:
        return new o(r103, r104, r111);
    }

    public static final o c(GalleryStoragePolicyManager r100, List r101, String r102, boolean r103, String r104) {
        r100.getClass();
        ArrayList r105 = new ArrayList();
        Iterator r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L8;
        Object r107 = r106.next();
        if ((!StringsKt.isBlank((String) r107)) == false) goto L4;
        r105.add(r107);
        goto L4
    L8:
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r109 = r105.iterator();
    L10:
        if (r109.hasNext() == false) goto L13;
        r108.add(new PolarisFileWrapper((String) r109.next()));
        goto L10
    L13:
        return k(r108, r102, r103, r104);
    }

    public static void q(File r100, String r101, String r110, long r111, String r112) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("file_action=delete, media_id=");
        if (r112 != null) goto L5;
        r112 = "";
    L5:
        r103.append(r112);
        r103.append(", stage=");
        String r113 = r100.getAbsolutePath();
        Intrinsics.checkNotNull(r113);
        com.larus.avlink.gallery.e.f292493a.getClass();
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L11;
        String r104 = "pack";
        if (StringsKt.equals(FilesKt.getExtension(r100), "pack", true) == false) goto L11;
    L34:
        r103.append(r104);
        r103.append(", path=");
        r103.append(r100.getAbsolutePath());
        r103.append(", size=");
        r103.append(r111);
        r103.append(", result=");
        r103.append(r110);
        r103.append(", reason=");
        r103.append(r101);
        r102.i("GalleryStoragePolicyManager", r103.toString());
        return;
    L11:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L16;
        if (p(r100, null) == false) goto L16;
        r104 = "source";
    L16:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.c().getAbsolutePath(), false, 2, null) == false) goto L19;
        r104 = "downloads";
        goto L34
    L19:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.g().getAbsolutePath(), false, 2, null) == false) goto L22;
        r104 = "temp";
        goto L34
    L22:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.f().getAbsolutePath(), false, 2, null) == false) goto L25;
        r104 = "processing";
        goto L34
    L25:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.e().getAbsolutePath(), false, 2, null) == false) goto L28;
        r104 = "processed";
        goto L34
    L28:
        if (StringsKt.startsWith$default(r113, com.larus.avlink.gallery.e.d().getAbsolutePath(), false, 2, null) == false) goto L30;
        r104 = "final";
        goto L34
    L30:
        r104 = "failed";
        if (StringsKt.startsWith$default(r113, new PolarisFileWrapper(com.larus.avlink.gallery.e.b(), "failed").getAbsolutePath(), false, 2, null) == true) goto L34;
        r104 = "unknown";
        goto L34
    }
}
