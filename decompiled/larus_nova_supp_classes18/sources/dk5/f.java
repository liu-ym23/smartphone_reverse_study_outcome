package dk5;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.notification.bean.Notification;
import com.bytedance.ee.bear.notification.bean.NotificationResult;
import io.reactivex.functions.Function;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements Function<Result<NotificationResult>, List<Notification>> {
    public f() {
    }

    public final Object apply(Object r1) throws Exception {
        return ((NotificationResult) ((Result) r1).getData()).getNotificationResults();
    }
}
