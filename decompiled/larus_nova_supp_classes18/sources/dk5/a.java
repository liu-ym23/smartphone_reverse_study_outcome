package dk5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.bean.NotificationCloseStatus;
import com.bytedance.ee.bear.notification.o;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Consumer<Result<NotificationCloseStatus>> {
    public final /* synthetic */ Notification a;
    public final /* synthetic */ c b;

    public final void accept(Object r3) throws Exception {
        c.b r0 = this.b.b;
        o.b r1 = (o.b) r0;
        r1.a(this.a, ((NotificationCloseStatus) ((Result) r3).getData()).isClose());
    }

    public a(c r1, Notification r2) {
        this.b = r1;
        this.a = r2;
    }
}
