package com.ss.android.lark.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.supervisor.token.Token;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f444723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f444724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f444725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f444726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f444727e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Token f444728f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h.e f444729g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f444730h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Boolean f444731i;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r210, int r211) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
    L30:
        com.larksuite.framework.utils.u.a(this.f444724b.getApplicationContext());
        h.e r100 = this.f444729g;
        if (r100 == null) goto L41;
        r100.a(this.f444731i.booleanValue());
        return;
    L41:
        return;
    L5:
        if (this.f444723a == false) goto L30;
        Activity r101 = this.f444724b;
        String r110 = this.f444725c;
        ArrayList r111 = new ArrayList();
        Object[] r112 = {r110};
        f06.b r113 = new f06.b("auto_cert_com_ss_android_lark_utils_AppPermission$8_android_app_Activity_shouldShowRequestPermissionRationale");
        g06.a r102 = ApiHookConfig.f245611b.get(102609);
        if (r102 == null) goto L9;
        f06.a[] r103 = r102.f479473i;
    L10:
        f06.a[] r104 = r103;
        int r105 = r104.length;
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L19;
        f06.a r107 = r104[r106];
        int r114 = r106;
        int r212 = r105;
        f06.a[] r213 = r104;
        f06.d r108 = r107.preInvoke(102609, "android/app/Activity", "shouldShowRequestPermissionRationale", r101, r112, "boolean", r113);     // Catch: Exception -> L34
        if (r108.f474982a == true) goto L21;
        r111.add(r107);     // Catch: Exception -> L34
    L21:
        if (r108.f474982a == false) goto L23;
        boolean r109 = ((Boolean) r108.f474983b).booleanValue();
    L24:
        if (r109 == false) goto L30;
        int r115 = this.f444726d;
        if (r115 >= 6) goto L30;
        int r116 = this.f444727e;
        if (r116 >= 3) goto L30;
        h.c(this.f444724b, this.f444728f, this.f444729g, this.f444725c, this.f444730h, true, r115, 1 + r116);
        return;
    L23:
        r109 = r101.shouldShowRequestPermissionRationale(r110);
    L18:
        r106 = r114 + 1;
        r105 = r212;
        r104 = r213;
        goto L12
    L19:
        r108 = new f06.d(false, null);
        goto L21
    L9:
        r103 = ApiHookConfig.f245613d;
        goto L10
    }

    public j(boolean r100, Activity r101, String r102, int r103, int r104, Token r105, h.e r106, k r107, Boolean r108) {
        this.f444723a = r100;
        this.f444724b = r101;
        this.f444725c = r102;
        this.f444726d = r103;
        this.f444727e = r104;
        this.f444728f = r105;
        this.f444729g = r106;
        this.f444730h = r107;
        this.f444731i = r108;
    }
}
