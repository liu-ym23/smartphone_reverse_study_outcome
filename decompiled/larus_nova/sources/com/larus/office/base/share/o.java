package com.larus.office.base.share;

import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi$Result;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: classes29.dex */
public final class o implements ut5.a<GetPublicPermissionApi$Result> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f361166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f361167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f361168c;

    @Override // ut5.a
    public final void onResult(GetPublicPermissionApi$Result r110) {
        GetPublicPermissionApi$Result r111 = r110;
        n r100 = this.f361166a;
        String r101 = this.f361167b;
        int r102 = this.f361168c;
        monitor-enter(r100);
    L53:
        th = move-exception;
        throw th;
    L5:
        if (r100.e(r101, r102) == true) goto L8;
        monitor-exit(r100);
        return;
    L8:
        if (r111 == null) goto L10;
        GetPublicPermissionApi$Result.PermPublic r103 = r111.getPublicPerm();     // Catch: Throwable -> L53
    L11:
        boolean r104 = false;
        if (r103 != null) goto L14;
    L16:
        boolean r112 = false;
    L17:
        r100.f361157a = Boolean.valueOf(r112);     // Catch: Throwable -> L53
        if (r111 != null) goto L20;
    L22:
        boolean r113 = false;
    L23:
        if (r113 == true) goto L27;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "handlePublicPermissionResult skipped: not owner, type=" + r102);     // Catch: Throwable -> L53
        r100.b();     // Catch: Throwable -> L53
        monitor-exit(r100);
        return;
    L27:
        if (r103 != null) goto L31;
        FLogger.f375446a.w("OfficeSharePermissionHandler", "handlePublicPermissionResult skipped: public permission null, type=" + r102);     // Catch: Throwable -> L53
        r100.b();     // Catch: Throwable -> L53
        monitor-exit(r100);
        return;
    L31:
        if (r112 == false) goto L36;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "handlePublicPermissionResult skipped: link share modified, type=" + r102);     // Catch: Throwable -> L53
        r100.b();     // Catch: Throwable -> L53
        monitor-exit(r100);
        return;
    L36:
        if (r103.getLinkShareEntityV2() != TypeLinkShare.LINK_SHARE_ANYONE_READ.m8351getTypeValue().intValue()) goto L38;
    L41:
        boolean r114 = true;
    L43:
        if (r103.getExternalAccessEntity() != TypeExternalAccess.EXTERNAL_ACCESS_OPEN.m8350getTypeValue().intValue()) goto L46;
        if (r114 == false) goto L46;
        r104 = true;
    L46:
        if (r104 == false) goto L50;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "handlePublicPermissionResult skipped: already internet visible, type=" + r102);     // Catch: Throwable -> L53
        r100.b();     // Catch: Throwable -> L53
        monitor-exit(r100);
        return;
    L50:
        r100.f(r101, r102);     // Catch: Throwable -> L53
        monitor-exit(r100);
        return;
    L38:
        if (r103.getLinkShareEntityV2() == TypeLinkShare.LINK_SHARE_ANYONE_EDIT.m8351getTypeValue().intValue()) goto L41;
        r114 = false;
        goto L43
    L20:
        if (r111.isOwner() != true) goto L22;
        r113 = true;
        goto L23
    L14:
        if (r103.getHasModifiedLinkShare() != true) goto L16;
        r112 = true;
        goto L17
    L10:
        r103 = null;
        goto L11
    }

    @Override // ut5.a
    public final void onError(int r100, Throwable r101) {
        FLogger.f375446a.w("OfficeSharePermissionHandler", "getPublicPermission failed: type=" + this.f361168c + ", code=" + r100, r101);
        this.f361166a.c(this.f361167b, this.f361168c);
    }

    public o(n r100, String r101, int r102) {
        this.f361166a = r100;
        this.f361167b = r101;
        this.f361168c = r102;
    }
}
