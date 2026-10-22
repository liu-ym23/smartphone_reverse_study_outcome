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
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements bu5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f468999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f469000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b0 f469001c;

    public class a extends TypeReference<Result<NotificationCloseStatus>> {
        public a() {
        }
    }

    public interface b {
    }

    @Override // bu5.a
    public final void didReceivePush(String r110) {
        if (r110 == null) goto L11;
        NotificationPushData r111 = (NotificationPushData) JSON.parseObject(r110, NotificationPushData.class);
        if (r111 == null) goto L11;
        if (r111.getData() == null) goto L11;
        if (r111.getData().getBody() == null) goto L11;
        Notification r112 = (Notification) JSON.parseObject(r111.getData().getBody().getData(), Notification.class);
    L12:
        if (r112 == null) goto L46;
        List<Notification.VersionBean> r100 = r112.getVersion();
        boolean r101 = false;
        if (r100 != null) goto L17;
        tt5.a.d("NotificationPushObserve", "checkVersion, version is null!");
    L26:
        boolean r102 = true;
    L28:
        if (r102 == true) goto L30;
        return;
    L30:
        if (System.currentTimeMillis() > (r112.getEnd_time() * 1000)) goto L32;
        r101 = true;
    L32:
        if (r101 == true) goto L34;
        tt5.a.h("NotificationPushObserve", "notification invalid");
    L34:
        if (r101 == true) goto L36;
        return;
    L36:
        if (r112.getStatus() == 0) goto L38;
        ((o.b) this.f469000b).a(r112, true);
        return;
    L38:
        NetService.d r103 = this.f468999a.Rb(new a().getType());
        NetService.f r104 = new NetService.f("/api/bulletin/close_status/");
        r104.b("id", r112.getId());
        r103.a(r104).subscribe(new dk5.a(this, r112), new dk5.b());
        return;
    L17:
        if (r100.isEmpty() == true) goto L26;
        String r105 = this.f469001c.getVersionName();
        Iterator<Notification.VersionBean> r106 = r100.iterator();
    L21:
        if (r106.hasNext() == false) goto L27;
        Notification.VersionBean r107 = r106.next();
        if (yu5.d.a(r105, r107.getStart()) < 0) goto L21;
        if (yu5.d.a(r105, r107.getEnd()) > 0) goto L21;
    L27:
        tt5.a.h("NotificationPushObserve", "no version-matched notification");
        r102 = false;
        goto L28
    L46:
        return;
    L11:
        r112 = null;
        goto L12
    }

    public c(NetService r100, o.b r101) {
        this.f469001c = (b0) org.koin.java.a.a(b0.class);
        this.f468999a = r100;
        this.f469000b = r101;
    }
}
