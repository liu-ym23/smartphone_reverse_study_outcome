package com.relax.relaxframework;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/relax/relaxframework/PipelineOptions;", "", "listId", "", "listCompId", "operationId", "", "(IIJ)V", "getListCompId", "()I", "setListCompId", "(I)V", "getListId", "setListId", "getOperationId", "()J", "setOperationId", "(J)V", "relax-framework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PipelineOptions {
    private int listCompId;
    private int listId;
    private long operationId;

    public final int getListCompId() {
        return this.listCompId;
    }

    public final int getListId() {
        return this.listId;
    }

    public final long getOperationId() {
        return this.operationId;
    }

    public final void setListCompId(int r100) {
        this.listCompId = r100;
    }

    public final void setListId(int r100) {
        this.listId = r100;
    }

    public final void setOperationId(long r100) {
        this.operationId = r100;
    }

    public PipelineOptions(int r100, int r101, long r102) {
        this.listId = r100;
        this.listCompId = r101;
        this.operationId = r102;
    }
}
