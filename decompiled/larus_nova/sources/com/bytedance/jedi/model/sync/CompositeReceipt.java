package com.bytedance.jedi.model.sync;

import io.reactivex.internal.util.OpenHashSet;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/jedi/model/sync/CompositeReceipt;", "Lcom/bytedance/jedi/model/sync/ISyncReceipt;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public final class CompositeReceipt implements ISyncReceipt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenHashSet<ISyncReceipt> f251189a;

    @Override // com.bytedance.jedi.model.sync.ISyncReceipt
    public final void release() {
        Object[] r100 = this.f251189a.keys();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        Object r103 = r100[r102];
        if ((r103 instanceof ISyncReceipt) == false) goto L7;
        ((ISyncReceipt) r103).release();
        this.f251189a.remove((ISyncReceipt) r103);
    L7:
        r102 = r102 + 1;
        goto L3
    }

    public CompositeReceipt() {
        this.f251189a = new OpenHashSet(32);
    }
}
