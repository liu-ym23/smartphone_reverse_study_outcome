package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationUpdate$TreeNodeUpdateTokenParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes18.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationUpdate$TreeNodeUpdateTokenParams f573349a;

    public o(IOperationUpdate$TreeNodeUpdateTokenParams r100) {
        this.f573349a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = (String) r100;
        Lazy<WikiTreeNotificationServiceImpl> r102 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().i(this.f573349a);
    }
}
