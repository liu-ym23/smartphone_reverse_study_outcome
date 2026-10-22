package com.bytedance.applog.priority.original;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\"\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0003J9\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/bytedance/applog/priority/original/InsertCacheConfig;", "", "cacheEnable", "", "maxCacheSize", "", "cacheTime", "", "notFlushType", "", "(ZIJLjava/util/Set;)V", "getCacheEnable", "()Z", "getCacheTime", "()J", "getMaxCacheSize", "()I", "getNotFlushType", "()Ljava/util/Set;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InsertCacheConfig {
    private final boolean cacheEnable;
    private final long cacheTime;
    private final int maxCacheSize;
    private final Set<Integer> notFlushType;

    public InsertCacheConfig() {
        this(false, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InsertCacheConfig copy$default(InsertCacheConfig r3, boolean r4, int r5, long r6, Set r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.cacheEnable;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.maxCacheSize;
    L8:
        int r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.cacheTime;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.notFlushType;
    L14:
        boolean r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final boolean component1() {
        return this.cacheEnable;
    }

    public final int component2() {
        return this.maxCacheSize;
    }

    public final long component3() {
        return this.cacheTime;
    }

    public final Set<Integer> component4() {
        return this.notFlushType;
    }

    public final InsertCacheConfig copy(boolean r8, int r9, long r10, Set<Integer> r12) {
        return new InsertCacheConfig(r8, r9, r10, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof InsertCacheConfig) == true) goto L8;
        return false;
    L8:
        InsertCacheConfig r9 = (InsertCacheConfig) r8;
        if (this.cacheEnable == r9.cacheEnable) goto L12;
        return false;
    L12:
        if (this.maxCacheSize == r9.maxCacheSize) goto L15;
        return false;
    L15:
        if (this.cacheTime == r9.cacheTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.notFlushType, r9.notFlushType) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean r0 = this.cacheEnable;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = ((r1 * 31) + this.maxCacheSize) * 31;
        long r3 = this.cacheTime;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        Set<Integer> r5 = this.notFlushType;
        if (r5 != null) goto L8;
        int r6 = 0;
    L10:
        return r4 + r6;
    L8:
        r6 = r5.hashCode();
        goto L10
    }

    public String toString() {
        return "InsertCacheConfig(cacheEnable=" + this.cacheEnable + ", maxCacheSize=" + this.maxCacheSize + ", cacheTime=" + this.cacheTime + ", notFlushType=" + this.notFlushType + ')';
    }

    public final boolean getCacheEnable() {
        return this.cacheEnable;
    }

    public final long getCacheTime() {
        return this.cacheTime;
    }

    public final int getMaxCacheSize() {
        return this.maxCacheSize;
    }

    public final Set<Integer> getNotFlushType() {
        return this.notFlushType;
    }

    public InsertCacheConfig(boolean r1, int r2, long r3, Set<Integer> r5) {
        this.cacheEnable = r1;
        this.maxCacheSize = r2;
        this.cacheTime = r3;
        this.notFlushType = r5;
    }

    public /* synthetic */ InsertCacheConfig(boolean r5, int r6, long r7, Set r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        boolean r12 = false;
    L7:
        if ((r10 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r10 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        long r2 = r7;
        if ((r10 & 8) == 0) goto L16;
        r9 = SetsKt.setOf(new Integer[]{1, 3});
    L16:
        this(r12, r1, r2, r9);
        return;
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
