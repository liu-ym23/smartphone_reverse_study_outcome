package com.bytedance.locallife.cube.api.model;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/DecodeRecord;", "", "version", "", "codeCached", "", "(JZ)V", "getCodeCached", "()Z", "getVersion", "()J", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public class DecodeRecord {
    private final boolean codeCached;
    private final long version;

    public final boolean getCodeCached() {
        return this.codeCached;
    }

    public final long getVersion() {
        return this.version;
    }

    public DecodeRecord(long r100, boolean r101) {
        this.version = r100;
        this.codeCached = r101;
    }
}
