package com.ss.android.ugc.aweme.lazydata;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/ugc/aweme/lazydata/LazyDataBase;", "", "()V", "lazyDataInitializedMarkMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getLazyDataInitializedMarkMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "setLazyDataInitializedMarkMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "lazyDataKey", "", "getLazyDataKey", "()Ljava/lang/String;", "setLazyDataKey", "(Ljava/lang/String;)V", "lazyDataRootKey", "getLazyDataRootKey", "setLazyDataRootKey", "lazydata_release"}, k = 1, mv = {1, 4, 1})
public class LazyDataBase {
    private ConcurrentHashMap<Object, Boolean> lazyDataInitializedMarkMap;
    private volatile String lazyDataKey;
    private volatile String lazyDataRootKey;

    public LazyDataBase() {
        this.lazyDataKey = "";
        this.lazyDataRootKey = "";
        this.lazyDataInitializedMarkMap = new ConcurrentHashMap();
    }

    public final ConcurrentHashMap<Object, Boolean> getLazyDataInitializedMarkMap() {
        return this.lazyDataInitializedMarkMap;
    }

    public final String getLazyDataKey() {
        return this.lazyDataKey;
    }

    public final String getLazyDataRootKey() {
        return this.lazyDataRootKey;
    }

    public final void setLazyDataInitializedMarkMap(ConcurrentHashMap<Object, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lazyDataInitializedMarkMap = r100;
    }

    public final void setLazyDataKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lazyDataKey = r100;
    }

    public final void setLazyDataRootKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.lazyDataRootKey = r100;
    }
}
