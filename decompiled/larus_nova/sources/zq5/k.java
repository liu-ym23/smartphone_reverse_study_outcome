package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class k<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams f573345a;

    public k(IOperationMove$TreeNodeMoveToWikiParams r100) {
        this.f573345a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        MoveNodePuller.Result r101 = (MoveNodePuller.Result) r100;
        Intrinsics.checkNotNullParameter(r101, "pullerResult");
        IOperationMove$TreeNodeMoveToWikiParams r102 = this.f573345a;
        r102.sortId = r101.sort_id;
        Lazy<WikiTreeNotificationServiceImpl> r103 = WikiTreeNotificationServiceImpl.f241625b;
        WikiTreeNotificationServiceImpl.a.a().f(this.f573345a);
    }
}
