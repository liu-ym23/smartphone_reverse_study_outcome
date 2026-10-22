package com.bytedance.ee.space.sync;

import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.dwarf.UserScope;
import f75.e;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@UserScope
public final class SyncPushService implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f243093a;

    public static final class a {
    }

    static {
    }

    public final com.bytedance.ee.space.sync.a a() {
        return (com.bytedance.ee.space.sync.a) this.f243093a.getValue();
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void onDestroy() {
        tt5.a.h("SyncPushService", "onDestroy, pushImpl: " + a());
        a().onDestroy();
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void De(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeFileDeleteObserver, pushImpl: " + a() + ", observer: " + r100);
        a().De(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Lc(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removePermissionChangeObserver, pushImpl: " + a() + ", observer: " + r100);
        a().Lc(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void P1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeDeleteFileVersionObserver, pushImpl: " + a() + ", observer: " + r100);
        a().P1(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Ye(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeSecUpdateObserver, pushImpl: " + a() + ", observer: " + r100);
        a().Ye(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void lb(cr5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeWikiTreeObserver, pushImpl: " + a() + ", observer: " + r100);
        a().lb(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n5(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeUploadFileVersionObserver, pushImpl: " + a() + ", observer: " + r100);
        a().n5(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n8(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeGroupChangeObserver, pushImpl: " + a() + ", observer: " + r100);
        a().n8(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void q1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeUpdateFileMetaObserver, pushImpl: " + a() + ", observer: " + r100);
        a().q1(r100);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void w7(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.h("SyncPushService", "removeDrivePreviewEventObserver, pushImpl: " + a() + ", observer: " + r100);
        a().w7(r100);
    }

    @Inject
    public SyncPushService(by4.b r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
        Intrinsics.checkNotNullParameter(r101, "userService");
        this.f243093a = LazyKt.lazy(SyncPushService$pushImpl$2.INSTANCE);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Cd(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        tt5.a.h("SyncPushService", "addWikiTreeObserver, pushImpl: " + a() + ", observer: " + r101);
        return a().Cd(r100, r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Lb(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "routeKey");
        Intrinsics.checkNotNullParameter(r101, "observer");
        tt5.a.h("SyncPushService", "addDrivePreviewEventObserver, pushImpl: " + a() + ", observer: " + r101);
        return a().Lb(r100, r101);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean M6(String r100, int r101, i65.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addUpdateFileMetaObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().M6(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean P8(String r100, int r101, f75.c r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addDeleteFileVersionObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().P8(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean S2(String r100, int r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addUploadFileVersionObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().S2(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean d7(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addSecUpdateObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().d7(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean i4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addPermissionChangeObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().i4(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean r6(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addFileDeleteObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().r6(r100, r101, r102);
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean u4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.h("SyncPushService", "addGroupChangeObserver, pushImpl: " + a() + ", docType: " + r101 + ", observer: " + r102);
        return a().u4(r100, r101, r102);
    }
}
