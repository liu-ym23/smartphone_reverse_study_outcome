package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMakeCopy$TreeNodeMakeCopyParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class g<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationMakeCopy$TreeNodeMakeCopyParams f573341a;

    public g(IOperationMakeCopy$TreeNodeMakeCopyParams r100) {
        this.f573341a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Lazy<WikiTreeNotificationServiceImpl> r102 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().e(this.f573341a);
    }
}
