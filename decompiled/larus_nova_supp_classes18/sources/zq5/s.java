package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationShortcut$TreeNodeShortcutParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s<T> implements Consumer {
    public final /* synthetic */ IOperationShortcut$TreeNodeShortcutParams a;

    public s(IOperationShortcut$TreeNodeShortcutParams r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        Lazy<WikiTreeNotificationServiceImpl> r4 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().g(this.a);
    }
}
