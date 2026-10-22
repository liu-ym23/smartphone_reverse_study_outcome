package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applog/priority/original/SqliteOptConfig;", "", "pragmaConfig", "Lcom/bytedance/applog/priority/original/PragmaConfig;", "insertCache", "Lcom/bytedance/applog/priority/original/InsertCacheConfig;", "switchToWal", "", "(Lcom/bytedance/applog/priority/original/PragmaConfig;Lcom/bytedance/applog/priority/original/InsertCacheConfig;Z)V", "getInsertCache", "()Lcom/bytedance/applog/priority/original/InsertCacheConfig;", "getPragmaConfig", "()Lcom/bytedance/applog/priority/original/PragmaConfig;", "getSwitchToWal", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SqliteOptConfig {
    private final InsertCacheConfig insertCache;
    private final PragmaConfig pragmaConfig;
    private final boolean switchToWal;

    public SqliteOptConfig() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ SqliteOptConfig copy$default(SqliteOptConfig r0, PragmaConfig r1, InsertCacheConfig r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.pragmaConfig;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.insertCache;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.switchToWal;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PragmaConfig component1() {
        return this.pragmaConfig;
    }

    public final InsertCacheConfig component2() {
        return this.insertCache;
    }

    public final boolean component3() {
        return this.switchToWal;
    }

    public final SqliteOptConfig copy(PragmaConfig r2, InsertCacheConfig r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "pragmaConfig");
        Intrinsics.checkNotNullParameter(r3, "insertCache");
        return new SqliteOptConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SqliteOptConfig) == true) goto L8;
        return false;
    L8:
        SqliteOptConfig r6 = (SqliteOptConfig) r5;
        if (Intrinsics.areEqual(this.pragmaConfig, r6.pragmaConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.insertCache, r6.insertCache) == true) goto L15;
        return false;
    L15:
        if (this.switchToWal == r6.switchToWal) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = ((this.pragmaConfig.hashCode() * 31) + this.insertCache.hashCode()) * 31;
        boolean r1 = this.switchToWal;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public String toString() {
        return "SqliteOptConfig(pragmaConfig=" + this.pragmaConfig + ", insertCache=" + this.insertCache + ", switchToWal=" + this.switchToWal + ')';
    }

    public final InsertCacheConfig getInsertCache() {
        return this.insertCache;
    }

    public final PragmaConfig getPragmaConfig() {
        return this.pragmaConfig;
    }

    public final boolean getSwitchToWal() {
        return this.switchToWal;
    }

    public SqliteOptConfig(PragmaConfig r2, InsertCacheConfig r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "pragmaConfig");
        Intrinsics.checkNotNullParameter(r3, "insertCache");
        this.pragmaConfig = r2;
        this.insertCache = r3;
        this.switchToWal = r4;
    }

    public /* synthetic */ SqliteOptConfig(PragmaConfig r10, InsertCacheConfig r11, boolean r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = new PragmaConfig(false, false, false, 0, 0, 31, null);
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = new InsertCacheConfig(false, 0, 0, null, 15, null);
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = false;
    L11:
        this(r10, r11, r12);
    }
}
