package com.bytedance.ee.bear.office.space;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.drive.biz.preview.more.save2space.DriveSpaceFileAttachmentExecutor;
import com.bytedance.ee.bear.list.office.preload.OfficeSpaceDbPreloadWorker;
import com.bytedance.ee.bear.office.export.space.OfficeFolderPageRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceConfig;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceEnterContext;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadCancelReason;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadHandle;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadRequest;
import com.bytedance.ee.bear.office.export.space.OfficeSpacePreloadState;
import com.bytedance.ee.bear.office.list.OfficeFolderDetailHostFragment;
import com.bytedance.ee.bear.office.space.preload.OfficeSpacePreloadManager;
import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class l implements com.bytedance.ee.bear.office.export.space.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f236119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.init.a f236120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NetService f236121c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void f() {
        com.bytedance.ee.bear.widgets.menuconfig.c r100 = com.bytedance.ee.bear.widgets.menuconfig.c.f240244a;
        monitor-enter(r100);
        com.bytedance.ee.bear.widgets.menuconfig.c.f240245b = null;     // Catch: Throwable -> L9
        monitor-exit(r100);
        tt5.a.h("OfficeSpaceSdkImpl", "clear shared menu config");
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpacePreloadHandle a(OfficeSpacePreloadRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        ConcurrentHashMap<String, OfficeSpacePreloadState> r101 = OfficeSpacePreloadManager.f236128a;
        return OfficeSpacePreloadManager.a(this.f236119a, r100, System.identityHashCode(this), Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE));
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void b(String r100) {
        com.bytedance.ee.bear.widgets.menuconfig.c r101 = com.bytedance.ee.bear.widgets.menuconfig.c.f240244a;
        monitor-enter(r101);
        com.bytedance.ee.bear.widgets.menuconfig.a.f240242a.getClass();     // Catch: Throwable -> L12
        com.bytedance.ee.bear.widgets.menuconfig.c.f240245b = com.bytedance.ee.bear.widgets.menuconfig.a.a(r100);     // Catch: Throwable -> L12
        monitor-exit(r101);
        StringBuilder r102 = new StringBuilder("install shared menu config, empty=");
        if (StringsKt.isBlank(r100) == false) goto L9;
        boolean r103 = true;
    L10:
        r102.append(r103);
        tt5.a.h("OfficeSpaceSdkImpl", r102.toString());
        return;
    L9:
        r103 = false;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void g(OfficeSpacePreloadCancelReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        ConcurrentHashMap<String, OfficeSpacePreloadState> r101 = OfficeSpacePreloadManager.f236128a;
        Intrinsics.checkNotNullParameter(r100, "reason");
        Iterator<T> r102 = OfficeSpacePreloadManager.f236129b.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.office.list.preload.a.InterfaceC3382a) r102.next()).cancel();
        goto L4
    L6:
        OfficeSpacePreloadManager.f236129b.clear();
        OfficeSpacePreloadManager.f236128a.clear();
        int r103 = com.bytedance.ee.bear.office.list.preload.a.f235950a;
        Handler r104 = OfficeSpaceDbPreloadWorker.f229096a;
        com.bytedance.ee.bear.list.office.preload.d.f229150a.clear();
        com.bytedance.ee.bear.list.office.preload.d.f229151b.clear();
        tt5.a.h("OfficeSpacePreloadCache", "office_space_preload_cache_clear");
        tt5.a.h("OfficeSpacePreloadManager", "office_space_preload_cancel reason=" + r100);
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeFolderDetailHostFragment e(OfficeFolderPageRequest r100, com.bytedance.ee.bear.office.export.space.h r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r101 == null) goto L5;
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r102 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        String r103 = UUID.randomUUID().toString();
        com.bytedance.ee.bear.office.export.space.m.f235477a.put(r103, new com.bytedance.ee.bear.office.export.space.m.a(new WeakReference(r101)));
    L6:
        int r104 = com.bytedance.ee.bear.office.space.a.f236100a;
        if (r103 == null) goto L9;
        boolean r105 = true;
    L10:
        Intrinsics.checkNotNullParameter(r100, "request");
        int r106 = OfficeFolderDetailHostFragment.f235493t;
        Bundle r107 = com.bytedance.ee.bear.office.list.a.a(r100, r103, r105);
        Intrinsics.checkNotNullParameter(r107, "args");
        OfficeFolderDetailHostFragment r108 = new OfficeFolderDetailHostFragment();
        r108.setArguments(new Bundle(r107));
        return r108;
    L9:
        r105 = false;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpaceFragment h(OfficeSpaceConfig r110, com.bytedance.ee.bear.office.export.space.h r111) {
        Intrinsics.checkNotNullParameter(r110, "config");
        return c(r110, r111, new OfficeSpaceEnterContext(null, 0, null, null, 15, null));
    }

    @Inject
    public l(Application r100, com.bytedance.ee.bear.init.a r101, NetService r102) {
        Intrinsics.checkNotNullParameter(r100, "application");
        Intrinsics.checkNotNullParameter(r101, "officeCCMGlobalInit");
        Intrinsics.checkNotNullParameter(r102, "netService");
        this.f236119a = r100;
        this.f236120b = r101;
        this.f236121c = r102;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpaceFragment c(OfficeSpaceConfig r100, com.bytedance.ee.bear.office.export.space.h r101, OfficeSpaceEnterContext r102) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "enterContext");
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r103 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        String r104 = UUID.randomUUID().toString();
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r105 = com.bytedance.ee.bear.office.export.space.m.f235477a;
        if (r101 == null) goto L5;
        WeakReference r106 = new WeakReference(r101);
    L6:
        r105.put(r104, new com.bytedance.ee.bear.office.export.space.m.a(r106));
        int r107 = OfficeSpaceFragment.f236036v;
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r102, "enterContext");
        OfficeSpaceFragment r108 = new OfficeSpaceFragment();
        Bundle r109 = new Bundle();
        r109.putSerializable("office_space_config", r100);
        r109.putString("office_space_runtime_id", r104);
        r109.putSerializable("office_space_enter_context", r102);
        r108.setArguments(r109);
        return r108;
    L5:
        r106 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void d(final String r100, String r101, com.larus.drive.sdk.impl.view.preview.b r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter("doubao_tmp_file", "mountPoint");
        Intrinsics.checkNotNullParameter(r101, "fileName");
        Intrinsics.checkNotNullParameter(r102, "callback");
        NetService.d r103 = this.f236121c.Vc(new DriveSpaceFileAttachmentExecutor.a());
        tt5.a.h("AttachmentExecutor", "saveFileToSpace, token: " + du5.b.i(r100));
        HashMap r104 = new HashMap();
        r104.put("file_token", r100);
        r104.put("name", r101);
        if (TextUtils.isEmpty("doubao_tmp_file") == true) goto L6;
        r104.put(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, "doubao_tmp_file");
    L6:
        if (TextUtils.isEmpty(null) == true) goto L8;
        r104.put("extra", null);
    L8:
        r104.put("size_checker", Boolean.valueOf(((t) org.koin.java.a.a(t.class)).e()));
        final NetService.f r105 = new NetService.f("/api/box/file/save/");
        r105.f216913j = JSON.toJSONString(r104);
        r105.f216906c = 1;
        r103.a(r105).map(new com.bytedance.ee.bear.drive.biz.preview.more.save2space.d(r105)).onErrorResumeNext(new com.bytedance.ee.bear.drive.biz.preview.more.save2space.e(r100)).firstOrError().observeOn(fo5.d.d()).subscribe(new m(r102), new n(r102));
    }
}
