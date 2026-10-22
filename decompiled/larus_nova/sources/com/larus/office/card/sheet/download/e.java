package com.larus.office.card.sheet.download;

import android.app.Application;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import t19.s;
import tx9.u0;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class e implements Function4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetDownloadDirectDialog f361633a;

    public /* synthetic */ e(SheetDownloadDirectDialog r100) {
        this.f361633a = r100;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r110, Object r111, Object r112, Object r113) {
        SheetDownloadDirectDialog r100 = this.f361633a;
        boolean r114 = ((Boolean) r110).booleanValue();
        Uri r115 = (Uri) r111;
        Integer r116 = (Integer) r112;
        String r117 = (String) r113;
        if (r100.f361626h == true) goto L34;
        if (r100.isDetached() == true) goto L34;
        if (r100.f361627i <= 0) goto L14;
        if (r114 == false) goto L12;
        String r118 = "1";
    L13:
        u0.c(r118, r100.f361623e, "xlsx", Long.valueOf(System.currentTimeMillis() - r100.f361627i), r117, 12, r100.t9(), 128);
        r100.f361627i = 0;
        goto L14
    L12:
        r118 = "0";
    L14:
        if (r114 == false) goto L17;
        int r119 = SheetDownloadDirectDialog.f361621k;
        SheetDownloadDirectDialog.a.a(r100);
        return Unit.INSTANCE;
    L17:
        if (r116 != null) goto L20;
        s r120 = s.f544207a;
        Application r121 = AppHost.f326268a.getApplication();
        r120.getClass();
        s.s(r121, R.string.larus_slides_download_toast_fail);
        int r122 = SheetDownloadDirectDialog.f361621k;
        SheetDownloadDirectDialog.a.a(r100);
        return Unit.INSTANCE;
    L20:
        if (r116.intValue() != 900099001) goto L23;
        s r123 = s.f544207a;
        Application r124 = AppHost.f326268a.getApplication();
        r123.getClass();
        s.s(r124, R.string.larus_enterprise_dlpCheck_errToast);
    L32:
        int r125 = SheetDownloadDirectDialog.f361621k;
        SheetDownloadDirectDialog.a.a(r100);
        return Unit.INSTANCE;
    L23:
        if (r116.intValue() != 900099003) goto L26;
        s r126 = s.f544207a;
        Application r127 = AppHost.f326268a.getApplication();
        r126.getClass();
        s.s(r127, R.string.larus_enterprise_dlpCheck_deny_errToast);
        goto L32
    L26:
        if (r116.intValue() != 1006) goto L28;
    L31:
        s r128 = s.f544207a;
        Application r129 = AppHost.f326268a.getApplication();
        r128.getClass();
        s.s(r129, R.string.larus_LarkCCM_DoubaoSheets_Deleted_Empty);
        goto L32
    L28:
        if (Intrinsics.areEqual(r117, "sheet_deleted") == true) goto L31;
        s r130 = s.f544207a;
        Application r131 = AppHost.f326268a.getApplication();
        r130.getClass();
        s.s(r131, R.string.larus_slides_download_toast_fail);
    L34:
        return Unit.INSTANCE;
    }
}
