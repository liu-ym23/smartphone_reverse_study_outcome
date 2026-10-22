package com.bytedance.assem.arch.reused;

import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.comment.write.model.TextExtraStruct;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, TextExtraStruct.TYPE_GROUP_CHAT})
final class ReusedAssemProxy$handleOnDestroy$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ReusedAssemProxy this$0;

    public ReusedAssemProxy$handleOnDestroy$2(ReusedAssemProxy r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1118invoke() {
        this.this$0.d.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1118invoke();
        return Unit.INSTANCE;
    }
}
