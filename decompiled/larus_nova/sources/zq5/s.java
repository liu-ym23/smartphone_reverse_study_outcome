package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationShortcut$TreeNodeShortcutParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class s<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationShortcut$TreeNodeShortcutParams f573352a;

    public s(IOperationShortcut$TreeNodeShortcutParams r100) {
        this.f573352a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Lazy<WikiTreeNotificationServiceImpl> r102 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().g(this.f573352a);
    }
}
