package com.larus.office.base.share;

import com.bytedance.ee.permission.PermissionSdk;
import com.bytedance.ee.permission.define.value.TypeExternalAccess;
import com.bytedance.ee.permission.define.value.TypeLinkShare;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi$Result;
import com.larus.office.base.service.IOfficeSdkServiceV2;
import com.larus.platform.api.IFlowOfficeThemeConfigProvider;
import com.larus.platform.model.apptheme.AdaptThemeFeatureKey;
import com.larus.platform.service.n0;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f361157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f361158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f361159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f361160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f361161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Integer f361162f;

    public static final class a {
    }

    public static final class b implements ut5.a<UpdatePublicPermissionApi$Result> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f361163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f361164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f361165c;

        @Override // ut5.a
        public final void onResult(UpdatePublicPermissionApi$Result r100) {
            n r101 = this.f361163a;
            String r102 = this.f361164b;
            int r103 = this.f361165c;
            monitor-enter(r101);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (r101.e(r102, r103) == true) goto L9;
            monitor-exit(r101);
            return;
        L9:
            r101.f361159c = true;     // Catch: Throwable -> L12
            FLogger.f375446a.i("OfficeSharePermissionHandler", "updatePublicPermission success: type=" + r103);     // Catch: Throwable -> L12
            r101.b();     // Catch: Throwable -> L12
            monitor-exit(r101);
        }

        @Override // ut5.a
        public final void onError(int r100, Throwable r101) {
            FLogger.f375446a.w("OfficeSharePermissionHandler", "updatePublicPermission failed: type=" + this.f361165c + ", code=" + r100, r101);
            this.f361163a.c(this.f361164b, this.f361165c);
        }

        public b(n r100, String r101, int r102) {
            this.f361163a = r100;
            this.f361164b = r101;
            this.f361165c = r102;
        }
    }

    static {
    }

    public n() {
    }

    public final void b() {
        this.f361158b = false;
        this.f361161e = null;
        this.f361162f = null;
    }

    public static com.bytedance.ee.permission.a d() {
        IOfficeSdkServiceV2 r100 = (IOfficeSdkServiceV2) ServiceManager.get().getService(IOfficeSdkServiceV2.class);
        if (r100 == null) goto L7;
        gk5.e r101 = r100.q0();
        if (r101 == null) goto L7;
        return r101.i0();
    L7:
        return null;
    }

    public final synchronized void a(String r110, int r111) {
        monitor-enter(this);
        boolean r100 = false;
        if (r110 != null) goto L84;
    L14:
        String r112 = null;
    L16:
        if (this.f361160d == false) goto L21;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: detached, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L21:
        if (z2.f365865a.f4() == true) goto L26;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: mini app disabled, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L26:
        if (n0.f365775a.b() == true) goto L32;
        IFlowOfficeThemeConfigProvider r101 = (IFlowOfficeThemeConfigProvider) ServiceManager.get().getService(IFlowOfficeThemeConfigProvider.class);     // Catch: Throwable -> L81
        if (r101 != null) goto L31;
    L33:
        boolean r102 = false;
    L34:
        if (r102 == false) goto L38;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: enterprise mode, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L38:
        if (r112 != null) goto L43;
        FLogger.f375446a.w("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: empty token, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L43:
        if (r111 != 2) goto L45;
    L53:
        r100 = true;
    L54:
        if (r100 == true) goto L59;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: unsupported type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L59:
        if (this.f361159c == false) goto L64;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: already auto enabled, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L64:
        if (this.f361158b == false) goto L69;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: in flight, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L69:
        if (Intrinsics.areEqual(this.f361157a, Boolean.TRUE) == false) goto L73;
        FLogger.f375446a.i("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: link share modified, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L73:
        com.bytedance.ee.permission.a r103 = d();     // Catch: Throwable -> L81
        if (r103 != null) goto L78;
        FLogger.f375446a.w("OfficeSharePermissionHandler", "autoEnableExternalShare skipped: permission sdk null, type=" + r111);     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L78:
        this.f361158b = true;     // Catch: Throwable -> L81
        this.f361161e = r112;     // Catch: Throwable -> L81
        this.f361162f = Integer.valueOf(r111);     // Catch: Throwable -> L81
        ((PermissionSdk) r103).a().d(new vt5.a(r112, r111), new o(this, r112, r111));     // Catch: Throwable -> L81
        monitor-exit(this);
        return;
    L45:
        if (r111 == 3) goto L53;
        if (r111 == 12) goto L53;
        if (r111 == 22) goto L53;
        if (r111 == 30) goto L53;
    L31:
        if (r101.a(new m(), AdaptThemeFeatureKey.OFFICE_COPY_LINK_DIRECTLY) != true) goto L33;
    L32:
        r102 = true;
        goto L34
    L84:
        r112 = StringsKt.trim(r110).toString();     // Catch: Throwable -> L81
        if (r112 == null) goto L14;
        if (r112.length() <= 0) goto L11;
        boolean r113 = true;
    L12:
        if (r113 == false) goto L14;
    L11:
        r113 = false;
    L81:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(String r100, int r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (e(r100, r101) == true) goto L7;
        monitor-exit(this);
        return;
    L7:
        b();     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    public final boolean e(String r100, int r101) {
        if (this.f361160d == false) goto L5;
    L12:
        return false;
    L5:
        if (Intrinsics.areEqual(this.f361161e, r100) == false) goto L12;
        Integer r102 = this.f361162f;
        if (r102 == null) goto L12;
        if (r102.intValue() != r101) goto L12;
        return true;
    }

    public final void f(String r100, int r101) {
        com.bytedance.ee.permission.a r102 = d();
        if (r102 != null) goto L6;
        FLogger.f375446a.w("OfficeSharePermissionHandler", "updatePublicPermission skipped: permission sdk null, type=" + r101);
        c(r100, r101);
        return;
    L6:
        vt5.c r103 = new vt5.c(r100, r101);
        TypeExternalAccess r104 = TypeExternalAccess.EXTERNAL_ACCESS_OPEN;
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r103.f557226d = r104;
        TypeLinkShare r105 = TypeLinkShare.LINK_SHARE_ANYONE_READ;
        Intrinsics.checkNotNullParameter(r105, "<set-?>");
        r103.f557227e = r105;
        ((PermissionSdk) r102).a().f(r103, new b(this, r100, r101));
    }
}
