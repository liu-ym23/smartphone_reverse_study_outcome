package eo;

import ao.b;
import com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode;
import com.bytedance.android.ec.window.base.common.taskgraph.context.NodeType;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public class a<IN, OUT> extends PipelineNode<IN, OUT> {
    @Override // com.bytedance.android.ec.window.base.common.taskgraph.PipelineNode
    public final NodeType c() {
        return NodeType.SINK;
    }

    public a(b r100, Function1 r101, CoroutineContext r102) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        Intrinsics.checkNotNullParameter(r101, "taskAction");
        super(r100, r101, r102);
    }
}
