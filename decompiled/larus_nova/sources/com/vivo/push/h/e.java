package com.vivo.push.h;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public final class e extends ab {
    public e(com.vivo.push.v r100) {
        super(r100);
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        com.vivo.push.b.p r101 = (com.vivo.push.b.p) r100;
        InsideNotificationItem r102 = r101.g();
        if (r102 != null) goto L6;
        com.vivo.push.util.t.d("NotifyOpenClientTask", "current notification item is null");
        return;
    L6:
        UPSNotificationMessage r103 = com.vivo.push.util.u.a(r102);
        boolean r104 = this.f462510a.getPackageName().equals(r101.e());
        if (r104 == false) goto L9;
        NotifyAdapterUtil.cancelNotify(this.f462510a);
    L9:
        if (r104 == false) goto L71;
        com.vivo.push.b.y r105 = new com.vivo.push.b.y(1030);
        HashMap<String, String> r106 = new HashMap();
        r106.put("type", "2");
        r106.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r101.f()));
        r106.put("platform", this.f462510a.getPackageName());
        String r107 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r107) == true) goto L13;
        r106.put("remoteAppId", r107);
    L13:
        r105.a(r106);
        com.vivo.push.m.a().a(r105);
        com.vivo.push.util.t.d("NotifyOpenClientTask", "notification is clicked by skip type[" + r103.getSkipType() + "]");
        int r108 = r103.getSkipType();
        boolean r109 = true;
        if (r108 != 1) goto L16;
        ThreadMethodProxy.start(new PthreadThreadV2(new f(this, this.f462510a, r103.getParams()), "vivo/push/h/e"));
        a(r103);
        return;
    L16:
        if (r108 != 2) goto L18;
        String r110 = r103.getSkipContent();
        if (r110.startsWith("http://") == false) goto L58;
    L61:
        if (r109 == false) goto L66;
        Uri r111 = UriProtector.parse(r110);
        Intent r112 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, r111);
        r112.setFlags(268435456);
        b(r112, r103.getParams());
        this.f462510a.startActivity(r112);     // Catch: Exception -> L65
    L67:
        a(r103);
        return;
    L65:
        com.vivo.push.util.t.a("NotifyOpenClientTask", "startActivity error : ".concat(String.valueOf(r111)));
        goto L67
    L66:
        com.vivo.push.util.t.a("NotifyOpenClientTask", "url not legal");
        goto L67
    L58:
        if (r110.startsWith("https://") == true) goto L61;
        r109 = false;
        goto L61
    L18:
        if (r108 != 3) goto L20;
        a(r103);
        return;
    L20:
        if (r108 == 4) goto L23;
        com.vivo.push.util.t.a("NotifyOpenClientTask", "illegitmacy skip type error : " + r103.getSkipType());
        return;
    L23:
        String r113 = r103.getSkipContent();
        Intent r114 = Intent.parseUri(r113, 1);     // Catch: Exception -> L49
        String r115 = r114.getPackage();     // Catch: Exception -> L49
        if (TextUtils.isEmpty(r115) == true) goto L32;
        if (this.f462510a.getPackageName().equals(r115) == true) goto L32;
        com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : local pkgName is " + this.f462510a.getPackageName() + "; but remote pkgName is " + r114.getPackage());     // Catch: Exception -> L49
        return;
    L32:
        if (r114.getComponent() != null) goto L34;
        String r116 = null;
    L36:
        if (TextUtils.isEmpty(r116) == false) goto L38;
    L41:
        r114.setSelector(null);     // Catch: Exception -> L49
        r114.setPackage(this.f462510a.getPackageName());     // Catch: Exception -> L49
        r114.addFlags(335544320);     // Catch: Exception -> L49
        b(r114, r103.getParams());     // Catch: Exception -> L49
        ActivityInfo r117 = r114.resolveActivityInfo(this.f462510a.getPackageManager(), 65536);     // Catch: Exception -> L49
        if (r117 != null) goto L44;
    L47:
        this.f462510a.startActivity(r114);     // Catch: Exception -> L49
    L51:
        a(r103);
        return;
    L44:
        if (r117.exported == true) goto L47;
        com.vivo.push.util.t.a("NotifyOpenClientTask", "activity is not exported : " + r117.toString());     // Catch: Exception -> L49
        return;
    L38:
        if (this.f462510a.getPackageName().equals(r116) == true) goto L41;
        com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity component error : local pkgName is " + this.f462510a.getPackageName() + "; but remote pkgName is " + r114.getPackage());     // Catch: Exception -> L49
        return;
    L34:
        r116 = r114.getComponent().getPackageName();     // Catch: Exception -> L49
    L49:
        e = move-exception;
        com.vivo.push.util.t.a("NotifyOpenClientTask", "open activity error : ".concat(String.valueOf(r113)), e);
        goto L51
    L71:
        com.vivo.push.util.t.a("NotifyOpenClientTask", "notify is " + r103 + " ; isMatch is " + r104);
    }

    private void a(UPSNotificationMessage r100) {
        com.vivo.push.t.b(new g(this, r100));
    }

    public static /* synthetic */ Context a(e r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Intent a(Intent r100, Map r101) {
        return b(r100, r101);
    }

    private static Intent b(Intent r100, Map<String, String> r101) {
        if (r101 != null) goto L4;
    L14:
        return r100;
    L4:
        if (r101.entrySet() == null) goto L14;
        Iterator<Map.Entry<String, String>> r102 = r101.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, String> r103 = r102.next();
        if (r103 == null) goto L8;
        if (r103.getKey() == null) goto L8;
        r100.putExtra(r103.getKey(), r103.getValue());
        goto L8
    }
}
