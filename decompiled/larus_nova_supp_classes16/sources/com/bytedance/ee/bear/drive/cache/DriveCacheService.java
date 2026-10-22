package com.bytedance.ee.bear.drive.cache;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.contract.drive.DriveFilePath;
import com.bytedance.ee.bear.contract.drive.sdk.entity.save.LocalSaveEntity;
import com.bytedance.ee.bear.drive.config.fg.DrivePreviewConfig;
import com.bytedance.ee.util.io.FileUtils;
import com.ss.android.lark.passportc.entity.UserSession;
import io.reactivex.Flowable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class DriveCacheService implements w {
    public final String a;
    public final com.ss.android.lark.passportc.api.m b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void onDestroy() {
    }

    @Override // com.bytedance.ee.bear.drive.cache.w
    public final void j0(List<? extends LocalSaveEntity> r19) {
        List<? extends LocalSaveEntity> r2 = r19;
        boolean r4 = true;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        tt5.a.k(this.a, "saveUploadDriveFileCache, saveEntities invalid: " + r19);
        return;
    L12:
        UserSession r5 = new a95.a(new o85.f(this.b.getSession())).b;
        int r6 = com.bytedance.ee.bear.drive.services.v.a;
        Intrinsics.checkNotNullParameter(r5, "userSession");
        StringBuilder r7 = new StringBuilder("start save files, size=");
        if (r19 == null) goto L15;
        Integer r8 = Integer.valueOf(r19.size());
    L16:
        r7.append(r8);
        tt5.a.h("DriveSaveCacheManager", r7.toString());
        if (new a95.a().c.isEnable("ccm.mobile.drive.add_preview_cache_enable") == true) goto L19;
        tt5.a.k("DriveSaveCacheManager", "save files failed, DRIVE_ADD_PREVIEW_CACHE_ENABLE == false");
        return;
    L19:
        if (r19 == null) goto L103;
        Iterator<T> r1 = r19.iterator();
    L22:
        if (r1.hasNext() == false) goto L104;
        LocalSaveEntity r9 = (LocalSaveEntity) r1.next();
        int r10 = com.bytedance.ee.bear.drive.services.v.a;
        tt5.a.h("DriveSaveCacheManager", "start save file to cache...");
        String r11 = r9.getLocalFilePath();
        r9.getBizContentProviderAuthority();
        String r12 = r9.getFileId();
        if (TextUtils.isEmpty(r9.getFileName()) == true) goto L93;
        String r13 = r9.getFileName();
    L33:
        if (TextUtils.isEmpty(r9.getFileType()) == true) goto L35;
        String r14 = r9.getFileType();
    L37:
        if (TextUtils.isEmpty(r11) == false) goto L39;
    L86:
        StringBuilder r16 = new StringBuilder("file info error, path=");
        if ((r11 instanceof Object) == true) goto L90;
        r11 = null;
    L90:
        r16.append(du5.b.f(r11));
        r16.append(", token=");
        r16.append(du5.b.i(r12));
        tt5.a.k("DriveSaveCacheManager", r16.toString());
    L91:
        r4 = true;
        goto L22
    L39:
        if (TextUtils.isEmpty(r12) == true) goto L86;
        boolean r17 = FileUtils.G(r11);
        if (FileUtils.F(r17, r11) == true) goto L48;
        StringBuilder r18 = new StringBuilder("file invalid, path=");
        if ((r11 instanceof Object) == true) goto L47;
        r11 = null;
    L47:
        r18.append(du5.b.f(r11));
        r18.append(", token=");
        r18.append(du5.b.i(r12));
        tt5.a.k("DriveSaveCacheManager", r18.toString());
        goto L91
    L48:
        o75.a r20 = o75.b.a();
        if (r20 == null) goto L55;
        g85.f r110 = r20.getMimeTypeManager();
        if (r110 == null) goto L55;
        if (((g85.b) r110).k(r14) != r4) goto L55;
        boolean r111 = true;
    L56:
        if (r111 == false) goto L58;
        tt5.a.k("DriveSaveCacheManager", "upload file is local not support(" + r14 + "), will not be put to cache");
        goto L91
    L58:
        if (r20 == null) goto L62;
        q75.a r21 = r20.getDriveConfig();
        if (r21 == null) goto L62;
        DrivePreviewConfig r22 = r21.a();
    L63:
        if (r22 == null) goto L65;
        Long r112 = Long.valueOf(r22.getMaxAddCacheSize());
    L66:
        if (r22 == null) goto L68;
        String[] r23 = r22.getBlackListAddCacheFileType();
    L69:
        if (r112 != null) goto L71;
        tt5.a.k("DriveSaveCacheManager", "current preview config is null");
        goto L91
    L71:
        if (r23 != null) goto L73;
    L75:
        boolean r24 = false;
    L76:
        if (r24 == false) goto L78;
        tt5.a.k("DriveSaveCacheManager", "upload file type not match previewConfig");
        goto L91
    L78:
        long r26 = FileUtils.z(r17, r11);
        if ((r112.longValue() * ((long) 1024)) >= r26) goto L81;
        tt5.a.k("DriveSaveCacheManager", "upload file size not match previewConfig, maxAddCacheSize=" + r112 + ", fileSize=" + r26);
        goto L91
    L81:
        Intrinsics.checkNotNull(r11);
        Intrinsics.checkNotNull(r14);
        if (Intrinsics.areEqual(r9.getAppId(), "1001") == false) goto L84;
        com.bytedance.ee.bear.drive.services.v.b r27 = new com.bytedance.ee.bear.drive.services.v.c(r9, r13, r14);
    L85:
        String r28 = r27.getCacheKey();
        Application r29 = eu5.b.a;
        DriveFilePath r30 = t.f();
        r30.cacheName(r28);
        Intrinsics.checkNotNull(r30);
        Flowable.just("").observeOn(fo5.d.b()).map(new com.bytedance.ee.bear.drive.services.r(r30, r5, r17, r11, z75.b.e(r30, r5))).flatMap(new com.bytedance.ee.bear.drive.services.s(r27, r5)).subscribe(com.bytedance.ee.bear.drive.services.t.a, com.bytedance.ee.bear.drive.services.u.a);
        goto L91
    L84:
        r27 = new com.bytedance.ee.bear.drive.services.v.d(r9, r13, r14);
        goto L85
    L73:
        if (ArraysKt.contains(r23, ("" + r14).toLowerCase(Locale.ROOT)) != r4) goto L75;
        r24 = true;
        goto L76
    L68:
        r23 = null;
        goto L69
    L65:
        r112 = null;
    L62:
        r22 = null;
    L55:
        r111 = false;
        goto L56
    L35:
        r14 = com.bytedance.ee.util.io.a.c(r13);
        goto L37
    L93:
        r13 = FileUtils.x(FileUtils.G(r9.getLocalFilePath()), r9.getLocalFilePath());     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L28
    L28:
        StringBuilder r31 = new StringBuilder("tryToFindFileName fail, localFilePath=");
        String r113 = r9.getLocalFilePath();
        if (r113 != null) goto L31;
        r113 = null;
    L31:
        r31.append(du5.b.f(r113));
        tt5.a.d("DriveSaveCacheManager", r31.toString());
        r13 = "";
        goto L33
    L104:
        return;
    L103:
        return;
    L15:
        r8 = null;
        goto L16
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    public DriveCacheService(String r2, by4.b r3, com.ss.android.lark.passportc.api.m r4) {
        Intrinsics.checkNotNullParameter(r2, "logTag");
        Intrinsics.checkNotNullParameter(r3, "kvStorage");
        Intrinsics.checkNotNullParameter(r4, "userService");
        this.a = r2;
        this.b = r4;
        this.c = LazyKt.lazy(DriveCacheService$cacheSP$2.INSTANCE);
    }
}
