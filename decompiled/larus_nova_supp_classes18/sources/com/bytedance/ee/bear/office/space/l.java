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
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class l implements com.bytedance.ee.bear.office.export.space.a {
    public final Application a;
    public final com.bytedance.ee.bear.init.a b;
    public final NetService c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void f() {
        com.bytedance.ee.bear.widgets.menuconfig.c r0 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        monitor-enter(r0);
        com.bytedance.ee.bear.widgets.menuconfig.c.b = null;     // Catch: Throwable -> L9
        monitor-exit(r0);
        tt5.a.h("OfficeSpaceSdkImpl", "clear shared menu config");
        return;
    L9:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpacePreloadHandle a(OfficeSpacePreloadRequest r5) {
        Intrinsics.checkNotNullParameter(r5, "request");
        ConcurrentHashMap<String, OfficeSpacePreloadState> r0 = OfficeSpacePreloadManager.a;
        return OfficeSpacePreloadManager.a(this.a, r5, System.identityHashCode(this), Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE));
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void b(String r3) {
        com.bytedance.ee.bear.widgets.menuconfig.c r0 = com.bytedance.ee.bear.widgets.menuconfig.c.a;
        monitor-enter(r0);
        com.bytedance.ee.bear.widgets.menuconfig.a.a.getClass();     // Catch: Throwable -> L12
        com.bytedance.ee.bear.widgets.menuconfig.c.b = com.bytedance.ee.bear.widgets.menuconfig.a.a(r3);     // Catch: Throwable -> L12
        monitor-exit(r0);
        StringBuilder r1 = new StringBuilder("install shared menu config, empty=");
        if (StringsKt.isBlank(r3) == false) goto L9;
        boolean r4 = true;
    L10:
        r1.append(r4);
        tt5.a.h("OfficeSpaceSdkImpl", r1.toString());
        return;
    L9:
        r4 = false;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void g(OfficeSpacePreloadCancelReason r3) {
        Intrinsics.checkNotNullParameter(r3, "reason");
        ConcurrentHashMap<String, OfficeSpacePreloadState> r1 = OfficeSpacePreloadManager.a;
        Intrinsics.checkNotNullParameter(r3, "reason");
        Iterator<T> r0 = OfficeSpacePreloadManager.b.values().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.bytedance.ee.bear.office.list.preload.a.InterfaceC0135a) r0.next()).cancel();
        goto L4
    L6:
        OfficeSpacePreloadManager.b.clear();
        OfficeSpacePreloadManager.a.clear();
        int r2 = com.bytedance.ee.bear.office.list.preload.a.a;
        Handler r4 = OfficeSpaceDbPreloadWorker.a;
        com.bytedance.ee.bear.list.office.preload.d.a.clear();
        com.bytedance.ee.bear.list.office.preload.d.b.clear();
        tt5.a.h("OfficeSpacePreloadCache", "office_space_preload_cache_clear");
        tt5.a.h("OfficeSpacePreloadManager", "office_space_preload_cancel reason=" + r3);
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeFolderDetailHostFragment e(OfficeFolderPageRequest r5, com.bytedance.ee.bear.office.export.space.h r6) {
        Intrinsics.checkNotNullParameter(r5, "request");
        if (r6 == null) goto L5;
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r1 = com.bytedance.ee.bear.office.export.space.m.a;
        String r2 = UUID.randomUUID().toString();
        com.bytedance.ee.bear.office.export.space.m.a.put(r2, new com.bytedance.ee.bear.office.export.space.m.a(new WeakReference(r6)));
    L6:
        int r7 = com.bytedance.ee.bear.office.space.a.a;
        if (r2 == null) goto L9;
        boolean r8 = true;
    L10:
        Intrinsics.checkNotNullParameter(r5, "request");
        int r0 = OfficeFolderDetailHostFragment.t;
        Bundle r9 = com.bytedance.ee.bear.office.list.a.a(r5, r2, r8);
        Intrinsics.checkNotNullParameter(r9, "args");
        OfficeFolderDetailHostFragment r10 = new OfficeFolderDetailHostFragment();
        r10.setArguments(new Bundle(r9));
        return r10;
    L9:
        r8 = false;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpaceFragment h(OfficeSpaceConfig r10, com.bytedance.ee.bear.office.export.space.h r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        return c(r10, r11, new OfficeSpaceEnterContext(null, 0, null, null, 15, null));
    }

    @Inject
    public l(Application r2, com.bytedance.ee.bear.init.a r3, NetService r4) {
        Intrinsics.checkNotNullParameter(r2, "application");
        Intrinsics.checkNotNullParameter(r3, "officeCCMGlobalInit");
        Intrinsics.checkNotNullParameter(r4, "netService");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final OfficeSpaceFragment c(OfficeSpaceConfig r6, com.bytedance.ee.bear.office.export.space.h r7, OfficeSpaceEnterContext r8) {
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r8, "enterContext");
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r2 = com.bytedance.ee.bear.office.export.space.m.a;
        String r3 = UUID.randomUUID().toString();
        ConcurrentHashMap<String, com.bytedance.ee.bear.office.export.space.m.a> r4 = com.bytedance.ee.bear.office.export.space.m.a;
        if (r7 == null) goto L5;
        WeakReference r5 = new WeakReference(r7);
    L6:
        r4.put(r3, new com.bytedance.ee.bear.office.export.space.m.a(r5));
        int r9 = OfficeSpaceFragment.v;
        Intrinsics.checkNotNullParameter(r6, "config");
        Intrinsics.checkNotNullParameter(r8, "enterContext");
        OfficeSpaceFragment r10 = new OfficeSpaceFragment();
        Bundle r0 = new Bundle();
        r0.putSerializable("office_space_config", r6);
        r0.putString("office_space_runtime_id", r3);
        r0.putSerializable("office_space_enter_context", r8);
        r10.setArguments(r0);
        return r10;
    L5:
        r5 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.office.export.space.a
    public final void d(String r5, String r6, com.larus.drive.sdk.impl.view.preview.b r7) {
        Intrinsics.checkNotNullParameter(r5, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter("doubao_tmp_file", "mountPoint");
        Intrinsics.checkNotNullParameter(r6, "fileName");
        Intrinsics.checkNotNullParameter(r7, "callback");
        NetService.d r0 = this.c.Vc(new DriveSpaceFileAttachmentExecutor.a());
        tt5.a.h("AttachmentExecutor", "saveFileToSpace, token: " + du5.b.i(r5));
        HashMap r2 = new HashMap();
        r2.put("file_token", r5);
        r2.put("name", r6);
        if (TextUtils.isEmpty("doubao_tmp_file") == true) goto L6;
        r2.put("mount_point", "doubao_tmp_file");
    L6:
        if (TextUtils.isEmpty(null) == true) goto L8;
        r2.put("extra", null);
    L8:
        r2.put("size_checker", Boolean.valueOf(((t) org.koin.java.a.a(t.class)).e()));
        NetService.f r8 = new NetService.f("/api/box/file/save/");
        ((NetService.e) r8).j = JSON.toJSONString(r2);
        ((NetService.e) r8).c = 1;
        r0.a(r8).map(new com.bytedance.ee.bear.drive.biz.preview.more.save2space.d(r8)).onErrorResumeNext(new com.bytedance.ee.bear.drive.biz.preview.more.save2space.e(r5)).firstOrError().observeOn(fo5.d.d()).subscribe(new m(r7), new n(r7));
    }
}
