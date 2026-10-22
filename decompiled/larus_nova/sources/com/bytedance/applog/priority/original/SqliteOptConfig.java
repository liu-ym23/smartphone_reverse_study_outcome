package com.bytedance.applog.priority.original;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/applog/priority/original/SqliteOptConfig;", "", "pragmaConfig", "Lcom/bytedance/applog/priority/original/PragmaConfig;", "insertCache", "Lcom/bytedance/applog/priority/original/InsertCacheConfig;", "switchToWal", "", "(Lcom/bytedance/applog/priority/original/PragmaConfig;Lcom/bytedance/applog/priority/original/InsertCacheConfig;Z)V", "getInsertCache", "()Lcom/bytedance/applog/priority/original/InsertCacheConfig;", "getPragmaConfig", "()Lcom/bytedance/applog/priority/original/PragmaConfig;", "getSwitchToWal", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "priority_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SqliteOptConfig {
    private final InsertCacheConfig insertCache;
    private final PragmaConfig pragmaConfig;
    private final boolean switchToWal;

    public SqliteOptConfig() {
        this(null, null, false, 7, null);
    }

    public static /* synthetic */ SqliteOptConfig copy$default(SqliteOptConfig r100, PragmaConfig r101, InsertCacheConfig r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.pragmaConfig;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.insertCache;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.switchToWal;
    L12:
        return r100.copy(r101, r102, r103);
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

    public final SqliteOptConfig copy(PragmaConfig r100, InsertCacheConfig r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "pragmaConfig");
        Intrinsics.checkNotNullParameter(r101, "insertCache");
        return new SqliteOptConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SqliteOptConfig) == true) goto L8;
        return false;
    L8:
        SqliteOptConfig r101 = (SqliteOptConfig) r100;
        if (Intrinsics.areEqual(this.pragmaConfig, r101.pragmaConfig) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.insertCache, r101.insertCache) == true) goto L15;
        return false;
    L15:
        if (this.switchToWal == r101.switchToWal) goto L17;
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
        int r100 = ((this.pragmaConfig.hashCode() * 31) + this.insertCache.hashCode()) * 31;
        boolean r101 = this.switchToWal;
        ?? r102 = r101;
        if (r101 == false) goto L6;
        r102 = 1;
    L6:
        return r100 + r102;
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

    public SqliteOptConfig(PragmaConfig r100, InsertCacheConfig r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "pragmaConfig");
        Intrinsics.checkNotNullParameter(r101, "insertCache");
        this.pragmaConfig = r100;
        this.insertCache = r101;
        this.switchToWal = r102;
    }

    public /* synthetic */ SqliteOptConfig(PragmaConfig r110, InsertCacheConfig r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L6;
        r110 = new PragmaConfig(false, false, false, 0, 0, 31, null);
    L6:
        if ((r113 & 2) == 0) goto L9;
        r111 = new InsertCacheConfig(false, 0, 0, null, 15, null);
    L9:
        if ((r113 & 4) == 0) goto L11;
        r112 = false;
    L11:
        this(r110, r111, r112);
    }
}
