package com.bytedance.forest.model;

import java.io.InputStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes19.dex */
public final class m extends k {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // com.bytedance.forest.model.k
    public final boolean isCacheClear$forest_release() {
        return false;
    }

    @Override // com.bytedance.forest.model.k
    public final boolean isCacheProvided$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public final boolean isCacheReady$forest_release() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public final boolean supportReuse() {
        return true;
    }

    @Override // com.bytedance.forest.model.k
    public final void tryLoadToMemory$forest_release(Response r100) {
    }

    public final String toString() {
        return "OutSideDirectBuffer@" + hashCode() + "(data=null)";
    }

    @Override // com.bytedance.forest.model.k
    public final byte[] provideBytes() {
        throw null;
    }

    @Override // com.bytedance.forest.model.k
    public final int size() {
        throw null;
    }

    @Override // com.bytedance.forest.model.k
    public final void fulfillListener$forest_release(Function0<Unit> r100) {
        r100.invoke();
    }

    @Override // com.bytedance.forest.model.k
    public final InputStream provideInputStream(Response r100) {
        throw null;
    }
}
