package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k<T> implements Consumer {
    public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams a;

    public k(IOperationMove$TreeNodeMoveToWikiParams r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        MoveNodePuller.Result r5 = (MoveNodePuller.Result) r4;
        Intrinsics.checkNotNullParameter(r5, "pullerResult");
        IOperationMove$TreeNodeMoveToWikiParams r0 = this.a;
        r0.sortId = r5.sort_id;
        Lazy<WikiTreeNotificationServiceImpl> r6 = WikiTreeNotificationServiceImpl.b;
        WikiTreeNotificationServiceImpl.a.a().f(this.a);
    }
}
