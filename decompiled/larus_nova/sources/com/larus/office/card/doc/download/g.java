package com.larus.office.card.doc.download;

import android.app.Application;
import android.net.Uri;
import com.larus.common.apphost.AppHost;
import com.larus.home.impl.sdk.b1;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import t19.s;

/* JADX INFO: loaded from: classes29.dex */
public final /* synthetic */ class g implements Function4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DocExportChooseDialog f361407a;

    public /* synthetic */ g(DocExportChooseDialog r100) {
        this.f361407a = r100;
    }

    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object r100, Object r101, Object r102, Object r103) {
        DocExportChooseDialog r104 = this.f361407a;
        Uri r105 = (Uri) r101;
        Integer r106 = (Integer) r102;
        String r107 = (String) r103;
        if (((Boolean) r100).booleanValue() == false) goto L14;
        if (r105 == null) goto L11;
        String r108 = r105.getPath();
        if (r108 == null) goto L11;
        IFlowSdkDepend r109 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r109 == null) goto L11;
        r109.D0();
        b1.f346144a.a(r108, new h());
    L11:
        if (r104.f361386i == true) goto L13;
        r104.V90(true, null);
        r104.W90(true, null);
    L13:
        int r110 = DocExportChooseDialog.f361380s;
        DocExportChooseDialog.a.a(r104);
    L40:
        return Unit.INSTANCE;
    L14:
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        if (r104.f361386i == false) goto L19;
        String r111 = "cancel";
    L20:
        r104.V90(false, r111);
        r104.W90(false, r107);
        if (r104.f361386i == true) goto L39;
        if (r104.isDetached() == true) goto L39;
        if (r106 != null) goto L28;
    L30:
        if (r106 != null) goto L33;
    L35:
        s r112 = s.f544207a;
        Application r113 = AppHost.f326268a.getApplication();
        r112.getClass();
        s.s(r113, R.string.larus_aiDoc_downloadFailed_errorMsg);
    L36:
        int r114 = DocExportChooseDialog.f361380s;
        DocExportChooseDialog.a.a(r104);
        goto L40
    L33:
        if (r106.intValue() != 900099003) goto L35;
        s r115 = s.f544207a;
        Application r116 = AppHost.f326268a.getApplication();
        r115.getClass();
        s.s(r116, R.string.larus_enterprise_dlpCheck_deny_errToast);
        goto L36
    L28:
        if (r106.intValue() != 900099001) goto L30;
        s r117 = s.f544207a;
        Application r118 = AppHost.f326268a.getApplication();
        r117.getClass();
        s.s(r118, R.string.larus_enterprise_dlpCheck_errToast);
    L39:
        return Unit.INSTANCE;
    L19:
        r111 = r107;
        goto L20
    }
}
