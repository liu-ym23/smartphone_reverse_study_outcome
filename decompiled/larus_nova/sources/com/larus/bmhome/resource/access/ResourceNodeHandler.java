package com.larus.bmhome.resource.access;

import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH¦@¢\u0006\u0002\u0010\u0012R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "priority", "", "getPriority", "()I", "supports", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ResourceNodeHandler {
    String a();

    boolean b(h0 r100);

    Object c(h0 r100, Continuation<? super g> r101);

    String getKey();

    void getPriority();
}
