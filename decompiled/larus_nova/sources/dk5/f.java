package dk5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.bean.NotificationResult;
import io.reactivex.functions.Function;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Function<Result<NotificationResult>, List<Notification>> {
    public f() {
    }

    @Override // io.reactivex.functions.Function
    public final List<Notification> apply(Result<NotificationResult> r100) throws Exception {
        return ((NotificationResult) r100.getData()).getNotificationResults();
    }
}
