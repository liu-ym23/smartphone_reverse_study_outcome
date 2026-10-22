package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMakeCopy$TreeNodeMakeCopyParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ IOperationMakeCopy$TreeNodeMakeCopyParams a;

    public g(IOperationMakeCopy$TreeNodeMakeCopyParams r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        Lazy<WikiTreeNotificationServiceImpl> r4 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().e(this.a);
    }
}
