package com.bytedance.ee.bear.drive.cache;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.batterymonitor.stragety.AbsBatteryStrategy;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class DriveCacheService implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f224042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.m f224043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f224044c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void onDestroy() {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void j0(List<? extends LocalSaveEntity> r110) {
        List<? extends LocalSaveEntity> r100 = r110;
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        tt5.a.k(this.f224042a, "saveUploadDriveFileCache, saveEntities invalid: " + r110);
        return;
    L12:
        UserSession r103 = new a95.a(new o85.f(this.f224043b.getSession())).f2278b;
        int r104 = com.bytedance.ee.bear.drive.services.v.f224636a;
        Intrinsics.checkNotNullParameter(r103, "userSession");
        StringBuilder r105 = new StringBuilder("start save files, size=");
        if (r110 == null) goto L15;
        Integer r106 = Integer.valueOf(r110.size());
    L16:
        r105.append(r106);
        tt5.a.h("DriveSaveCacheManager", r105.toString());
        if (new a95.a().f2279c.isEnable("ccm.mobile.drive.add_preview_cache_enable") == true) goto L19;
        tt5.a.k("DriveSaveCacheManager", "save files failed, DRIVE_ADD_PREVIEW_CACHE_ENABLE == false");
        return;
    L19:
        if (r110 == null) goto L103;
        Iterator<T> r107 = r110.iterator();
    L22:
        if (r107.hasNext() == false) goto L104;
        LocalSaveEntity r108 = (LocalSaveEntity) r107.next();
        int r109 = com.bytedance.ee.bear.drive.services.v.f224636a;
        tt5.a.h("DriveSaveCacheManager", "start save file to cache...");
        String r111 = r108.getLocalFilePath();
        r108.getBizContentProviderAuthority();
        String r112 = r108.getFileId();
        if (TextUtils.isEmpty(r108.getFileName()) == true) goto L93;
        String r113 = r108.getFileName();
    L33:
        if (TextUtils.isEmpty(r108.getFileType()) == true) goto L35;
        String r114 = r108.getFileType();
    L37:
        if (TextUtils.isEmpty(r111) == false) goto L39;
    L86:
        StringBuilder r115 = new StringBuilder("file info error, path=");
        if ((r111 instanceof Object) == true) goto L90;
        r111 = null;
    L90:
        r115.append(du5.b.f(r111));
        r115.append(", token=");
        r115.append(du5.b.i(r112));
        tt5.a.k("DriveSaveCacheManager", r115.toString());
    L91:
        r101 = true;
        goto L22
    L39:
        if (TextUtils.isEmpty(r112) == true) goto L86;
        boolean r116 = FileUtils.G(r111);
        if (FileUtils.F(r116, r111) == true) goto L48;
        StringBuilder r117 = new StringBuilder("file invalid, path=");
        if ((r111 instanceof Object) == true) goto L47;
        r111 = null;
    L47:
        r117.append(du5.b.f(r111));
        r117.append(", token=");
        r117.append(du5.b.i(r112));
        tt5.a.k("DriveSaveCacheManager", r117.toString());
        goto L91
    L48:
        o75.a r118 = o75.b.a();
        if (r118 == null) goto L55;
        g85.f r119 = r118.getMimeTypeManager();
        if (r119 == null) goto L55;
        if (((g85.b) r119).k(r114) != r101) goto L55;
        boolean r120 = true;
    L56:
        if (r120 == false) goto L58;
        tt5.a.k("DriveSaveCacheManager", "upload file is local not support(" + r114 + "), will not be put to cache");
        goto L91
    L58:
        if (r118 == null) goto L62;
        q75.a r121 = r118.getDriveConfig();
        if (r121 == null) goto L62;
        DrivePreviewConfig r122 = r121.a();
    L63:
        if (r122 == null) goto L65;
        Long r123 = Long.valueOf(r122.getMaxAddCacheSize());
    L66:
        if (r122 == null) goto L68;
        String[] r124 = r122.getBlackListAddCacheFileType();
    L69:
        if (r123 != null) goto L71;
        tt5.a.k("DriveSaveCacheManager", "current preview config is null");
        goto L91
    L71:
        if (r124 != null) goto L73;
    L75:
        boolean r125 = false;
    L76:
        if (r125 == false) goto L78;
        tt5.a.k("DriveSaveCacheManager", "upload file type not match previewConfig");
        goto L91
    L78:
        long r126 = FileUtils.z(r116, r111);
        if ((r123.longValue() * ((long) 1024)) >= r126) goto L81;
        tt5.a.k("DriveSaveCacheManager", "upload file size not match previewConfig, maxAddCacheSize=" + r123 + ", fileSize=" + r126);
        goto L91
    L81:
        Intrinsics.checkNotNull(r111);
        Intrinsics.checkNotNull(r114);
        if (Intrinsics.areEqual(r108.getAppId(), AbsBatteryStrategy.AppBgCombination.APP_BG__CHARGE_IN__NETWORK_WIFI__SCREEN_OFF) == false) goto L84;
        com.bytedance.ee.bear.drive.services.v.b r127 = new com.bytedance.ee.bear.drive.services.v.c(r108, r113, r114);
    L85:
        String r128 = r127.getCacheKey();
        Application r129 = eu5.b.f474075a;
        DriveFilePath r130 = t.f();
        r130.cacheName(r128);
        Intrinsics.checkNotNull(r130);
        Flowable.just("").observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.services.r(r130, r103, r116, r111, z75.b.e(r130, r103))).flatMap(new com.bytedance.ee.bear.drive.services.s(r127, r103)).subscribe(com.bytedance.ee.bear.drive.services.t.f224634a, com.bytedance.ee.bear.drive.services.u.f224635a);
        goto L91
    L84:
        r127 = new com.bytedance.ee.bear.drive.services.v.d(r108, r113, r114);
        goto L85
    L73:
        if (ArraysKt.contains(r124, ("" + r114).toLowerCase(Locale.ROOT)) != r101) goto L75;
        r125 = true;
        goto L76
    L68:
        r124 = null;
        goto L69
    L65:
        r123 = null;
    L62:
        r122 = null;
    L55:
        r120 = false;
        goto L56
    L35:
        r114 = com.bytedance.ee.util.io.a.c(r113);
        goto L37
    L93:
        r113 = FileUtils.x(FileUtils.G(r108.getLocalFilePath()), r108.getLocalFilePath());     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r113);     // Catch: Exception -> L28
    L28:
        StringBuilder r131 = new StringBuilder("tryToFindFileName fail, localFilePath=");
        String r132 = r108.getLocalFilePath();
        if (r132 != null) goto L31;
        r132 = null;
    L31:
        r131.append(du5.b.f(r132));
        tt5.a.d("DriveSaveCacheManager", r131.toString());
        r113 = "";
        goto L33
    L104:
        return;
    L103:
        return;
    L15:
        r106 = null;
        goto L16
    L5:
        if (r100.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public DriveCacheService(String r100, by4.b r101, com.ss.android.lark.passportc.api.m r102) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "kvStorage");
        Intrinsics.checkNotNullParameter(r102, "userService");
        this.f224042a = r100;
        this.f224043b = r102;
        this.f224044c = LazyKt.lazy(DriveCacheService$cacheSP$2.INSTANCE);
    }
}
