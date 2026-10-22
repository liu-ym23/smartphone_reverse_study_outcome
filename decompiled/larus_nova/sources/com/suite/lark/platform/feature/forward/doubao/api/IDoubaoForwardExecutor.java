package com.suite.lark.platform.feature.forward.doubao.api;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import npc.c;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ&\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardExecutor;", "Ljava/io/Serializable;", "onForward", "", "targets", "", "Lcom/suite/lark/platform/feature/forward/doubao/api/entity/ForwardDoubaoInfo;", "extra", "Lcom/suite/lark/platform/feature/forward/doubao/api/ForwardDoubaoExecutorExtra;", "executeCallback", "Lcom/suite/lark/platform/feature/forward/doubao/api/IDoubaoForwardExecutor$OnForwardExecuteCallback;", "OnForwardExecuteCallback", "forward-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IDoubaoForwardExecutor extends Serializable {

    public interface a {
    }

    void onForward(List<c> r100, ForwardDoubaoExecutorExtra r101, a r102);
}
