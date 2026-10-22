package zq5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationMove$TreeNodeMoveToWikiParams;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j<T, R> implements Function {
    public final /* synthetic */ IOperationMove$TreeNodeMoveToWikiParams a;
    public final /* synthetic */ ce5.a b;

    public j(IOperationMove$TreeNodeMoveToWikiParams r1, ce5.a r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r9) {
        Intrinsics.checkNotNullParameter((String) r9, "it");
        IOperationMove$TreeNodeMoveToWikiParams r0 = this.a;
        MoveNodePuller.Params r10 = new MoveNodePuller.Params(r0.srcSpaceId, r0.srcParentToken, r0.destSpaceId, r0.destParentToken, r0.srcToken, r0.chainPushUUid);
        return new MoveNodePuller(this.b.c).d(r10);
    }
}
