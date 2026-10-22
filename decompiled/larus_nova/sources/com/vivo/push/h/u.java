package com.vivo.push.h;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class u extends ab {

    public interface a {
        void a();

        void b();
    }

    public u(com.vivo.push.v r100) {
        super(r100);
    }

    public static /* synthetic */ Context b(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context c(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context d(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context e(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context f(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context g(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context h(u r100) {
        return r100.f462510a;
    }

    public static /* synthetic */ Context i(u r100) {
        return r100.f462510a;
    }

    @Override // com.vivo.push.s
    public final void a(com.vivo.push.v r100) {
        if (r100 != null) goto L6;
        com.vivo.push.util.t.a("OnNotificationArrivedTask", "command is null");
        return;
    L6:
        com.vivo.push.b.q r101 = (com.vivo.push.b.q) r100;
        Context r102 = this.f462510a;
        boolean r103 = com.vivo.push.util.aa.d(r102, r102.getPackageName());
        if (r103 == false) goto L9;
    L15:
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(r101.h())));
        if (com.vivo.push.m.a().g() == true) goto L18;
    L24:
        InsideNotificationItem r104 = r101.e();
        if (r104 == null) goto L28;
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "targetType is " + r104.getTargetType() + " ; target is " + r104.getTargetContent());
        com.vivo.push.t.b(new v(this, r104, r101, r103));
        return;
    L28:
        com.vivo.push.util.t.a("OnNotificationArrivedTask", "notify is null");
        com.vivo.push.util.t.c(this.f462510a, "通知内容为空，" + r101.h());
        com.vivo.push.util.f.a(r101.h(), 1027);
        return;
    L18:
        if (a(com.vivo.push.util.ah.c(this.f462510a), r101.f(), r101.k()) == true) goto L24;
        com.vivo.push.b.y r105 = new com.vivo.push.b.y(1021);
        HashMap<String, String> r106 = new HashMap();
        r106.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r101.h()));
        String r107 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r107) == true) goto L22;
        r106.put("remoteAppId", r107);
    L22:
        r105.a(r106);
        com.vivo.push.m.a().a(r105);
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "vertifyMsg not match =" + r101.h());
        return;
    L9:
        if (r101.g() == true) goto L15;
        com.vivo.push.b.y r108 = new com.vivo.push.b.y(2101);
        HashMap<String, String> r109 = new HashMap();
        r109.put(com.heytap.mcssdk.constant.b.f276353c, String.valueOf(r101.h()));
        String r110 = com.vivo.push.restructure.a.a().e().a();
        if (TextUtils.isEmpty(r110) == true) goto L13;
        r109.put("remoteAppId", r110);
    L13:
        r108.a(r109);
        com.vivo.push.m.a().a(r108);
        com.vivo.push.util.t.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f462510a.getPackageName() + " isMsgNoShowOnForeground :" + r101.h());
    }

    public static /* synthetic */ Context a(u r100) {
        return r100.f462510a;
    }
}
