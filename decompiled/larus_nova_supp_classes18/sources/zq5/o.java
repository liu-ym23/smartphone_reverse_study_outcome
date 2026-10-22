package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTokenParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o<T> implements Consumer {
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTokenParams a;

    public o(IOperationUpdate$TreeNodeUpdateTokenParams r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        Lazy<WikiTreeNotificationServiceImpl> r4 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().i(this.a);
    }
}
