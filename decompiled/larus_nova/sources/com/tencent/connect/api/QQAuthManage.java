package com.tencent.connect.api;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.auth.c;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.apireq.BaseResp;
import com.tencent.open.apireq.IApiCallback;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;

/* JADX INFO: loaded from: classes40.dex */
public class QQAuthManage extends BaseApi {

    public static class Resp extends BaseResp {
        public Resp() {
        }
    }

    private int a(Activity r100) {
        if (k.c(r100) == true) goto L7;
        SLog.i("QQAuthManage", "gotoManagePage: not installed all qq");
        return -1000;
    L7:
        if (k.b(r100) == true) goto L11;
        SLog.i("QQAuthManage", "gotoManagePage: only support mobile qq");
        return -1002;
    L11:
        if (k.c(r100, "8.6.0") >= 0) goto L14;
        SLog.i("QQAuthManage", "gotoManagePage: low version");
        return -1001;
    L14:
        return 0;
    }

    public QQAuthManage(c r100, QQToken r101) {
        super(r100, r101);
    }

    private void a(Activity r100, IApiCallback r101) {
        SLog.i("QQAuthManage", "doGotoMangePage");
        StringBuilder r102 = new StringBuilder("mqqapi://opensdk/open_auth_manage");
        a(r102, r100);
        Intent r103 = new Intent();
        r103.setData(UriProtector.parse(r102.toString()));
        r103.putExtra("pkg_name", r100.getPackageName());
        r103.setPackage("com.tencent.mobileqq");
        r103.setFlags(335544320);
        r100.startActivity(r103);
        r101.onResp(new Resp());
    }

    public void gotoManagePage(final Activity r100, final IApiCallback r101) {
        SLog.i("QQAuthManage", "gotoManagePage");
        final Resp r102 = new Resp();
        if (a.a("QQAuthManage", null) == false) goto L6;
        r102.setCode(-1003);
        r101.onResp(r102);
        return;
    L6:
        int r103 = a(r100);
        if (r103 == 0) goto L11;
        r102.setCode(r103);
        r101.onResp(r102);
        return;
    L11:
        if (this.f461558c.isSessionValid() == true) goto L13;
    L17:
        SLog.i("QQAuthManage", "gotoManagePage: not login");
        r102.setCode(-2001);
        r101.onResp(r102);
        return;
    L13:
        if (this.f461558c.getOpenId() == null) goto L17;
        this.f461557b.a(new AnonymousClass1(this, r100, r101, r102));
    }

    public static /* synthetic */ void a(QQAuthManage r100, Activity r101, IApiCallback r102) {
        r100.a(r101, r102);
    }
}
