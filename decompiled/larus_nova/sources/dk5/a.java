package dk5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.bean.NotificationCloseStatus;
import com.bytedance.ee.bear.notification.o;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements Consumer<Result<NotificationCloseStatus>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Notification f468997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f468998b;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Result<NotificationCloseStatus> r100) throws Exception {
        c.b r101 = this.f468998b.f469000b;
        o.b r102 = (o.b) r101;
        r102.a(this.f468997a, ((NotificationCloseStatus) r100.getData()).isClose());
    }

    public a(c r100, Notification r101) {
        this.f468998b = r100;
        this.f468997a = r101;
    }
}
