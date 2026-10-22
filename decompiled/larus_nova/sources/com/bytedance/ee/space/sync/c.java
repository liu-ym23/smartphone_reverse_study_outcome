package com.bytedance.ee.space.sync;

import f75.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements com.bytedance.ee.space.sync.a {

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void onDestroy() {
        tt5.a.k("StubSyncPushManager", "onDestroy, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void De(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeFileDeleteObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Lc(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removePermissionChangeObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void P1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeDeleteFileVersionObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void Ye(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeSecUpdateObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void lb(cr5.b r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeWikiTreeObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n5(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeUploadFileVersionObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void n8(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeGroupChangeObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void q1(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeUpdateFileMetaObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final void w7(bu5.a r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        tt5.a.k("StubSyncPushManager", "removeDrivePreviewEventObserver, not implemented");
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Cd(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceId");
        Intrinsics.checkNotNullParameter(r101, "observer");
        tt5.a.k("StubSyncPushManager", "addWikiTreeObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean Lb(String r100, bu5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "routeKey");
        Intrinsics.checkNotNullParameter(r101, "observer");
        tt5.a.k("StubSyncPushManager", "addDrivePreviewEventObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean M6(String r100, int r101, i65.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addUpdateFileMetaObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean P8(String r100, int r101, f75.c r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addDeleteFileVersionObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean S2(String r100, int r101, e r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addUploadFileVersionObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean d7(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addSecUpdateObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean i4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addPermissionChangeObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean r6(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addFileDeleteObserver, not implemented");
        return false;
    }

    @Override // com.bytedance.ee.space.sync.a
    public final boolean u4(String r100, int r101, bu5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "docToken");
        Intrinsics.checkNotNullParameter(r102, "observer");
        tt5.a.k("StubSyncPushManager", "addGroupChangeObserver, not implemented");
        return false;
    }
}
