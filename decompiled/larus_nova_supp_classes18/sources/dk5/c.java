package dk5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.bean.NotificationCloseStatus;
import com.bytedance.ee.bear.notification.bean.NotificationPushData;
import com.bytedance.ee.bear.notification.o;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements bu5.a {
    public final NetService a;
    public final b b;
    public final b0 c;

    public class a extends TypeReference<Result<NotificationCloseStatus>> {
        public a() {
        }
    }

    public interface b {
    }

    public final void didReceivePush(String r11) {
        if (r11 == null) goto L11;
        NotificationPushData r12 = (NotificationPushData) JSON.parseObject(r11, NotificationPushData.class);
        if (r12 == null) goto L11;
        if (r12.getData() == null) goto L11;
        if (r12.getData().getBody() == null) goto L11;
        Notification r13 = (Notification) JSON.parseObject(r12.getData().getBody().getData(), Notification.class);
    L12:
        if (r13 == null) goto L46;
        List<Notification.VersionBean> r0 = r13.getVersion();
        boolean r1 = false;
        if (r0 != null) goto L17;
        tt5.a.d("NotificationPushObserve", "checkVersion, version is null!");
    L26:
        boolean r2 = true;
    L28:
        if (r2 == true) goto L30;
        return;
    L30:
        if (System.currentTimeMillis() > (r13.getEnd_time() * 1000)) goto L32;
        r1 = true;
    L32:
        if (r1 == true) goto L34;
        tt5.a.h("NotificationPushObserve", "notification invalid");
    L34:
        if (r1 == true) goto L36;
        return;
    L36:
        if (r13.getStatus() == 0) goto L38;
        ((o.b) this.b).a(r13, true);
        return;
    L38:
        NetService.d r3 = this.a.Rb(new a().getType());
        NetService.f r4 = new NetService.f("/api/bulletin/close_status/");
        r4.b(ResourceData.KEY_ID, r13.getId());
        r3.a(r4).subscribe(new dk5.a(this, r13), new dk5.b());
        return;
    L17:
        if (r0.isEmpty() == true) goto L26;
        String r5 = this.c.getVersionName();
        Iterator<Notification.VersionBean> r6 = r0.iterator();
    L21:
        if (r6.hasNext() == false) goto L27;
        Notification.VersionBean r7 = r6.next();
        if (yu5.d.a(r5, r7.getStart()) < 0) goto L21;
        if (yu5.d.a(r5, r7.getEnd()) > 0) goto L21;
    L27:
        tt5.a.h("NotificationPushObserve", "no version-matched notification");
        r2 = false;
        goto L28
    L46:
        return;
    L11:
        r13 = null;
        goto L12
    }

    public c(NetService r2, o.b r3) {
        this.c = (b0) org.koin.java.a.a(b0.class);
        this.a = r2;
        this.b = r3;
    }
}
