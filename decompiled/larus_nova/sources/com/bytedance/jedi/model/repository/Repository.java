package com.bytedance.jedi.model.repository;

import com.bytedance.jedi.model.sync.CompositeReceipt;
import com.bytedance.jedi.model.sync.ISyncReceipt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/jedi/model/repository/Repository;", "", "Lcom/bytedance/jedi/model/sync/ISyncReceipt;", "Lcom/bytedance/jedi/model/repository/SyncExtensions;", "<init>", "()V", "model_release"}, k = 1, mv = {1, 7, 1})
public abstract class Repository extends SyncExtensions implements ISyncReceipt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeReceipt f251188a;

    @Override // com.bytedance.jedi.model.sync.ISyncReceipt
    public final void release() {
        this.f251188a.release();
    }

    public Repository() {
        this.f251188a = new CompositeReceipt();
    }
}
