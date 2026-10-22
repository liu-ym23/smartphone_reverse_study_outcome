package com.bytedance.locallife.cube.api.model;

import com.bytedance.locallife.cube.api.config.CubeCreateThreadStrategy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Deprecated(message = "use CubeConfig instead")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/locallife/cube/api/model/CubeCreateThreadConfig;", "", "createThreadStrategy", "Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;", "loadThreadStrategy", "(Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;)V", "getCreateThreadStrategy", "()Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;", "setCreateThreadStrategy", "(Lcom/bytedance/locallife/cube/api/config/CubeCreateThreadStrategy;)V", "getLoadThreadStrategy", "setLoadThreadStrategy", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "cube-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class CubeCreateThreadConfig {
    private CubeCreateThreadStrategy createThreadStrategy;
    private CubeCreateThreadStrategy loadThreadStrategy;

    /* JADX WARN: Multi-variable type inference failed */
    public CubeCreateThreadConfig() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CubeCreateThreadConfig copy$default(CubeCreateThreadConfig r100, CubeCreateThreadStrategy r101, CubeCreateThreadStrategy r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.createThreadStrategy;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.loadThreadStrategy;
    L9:
        return r100.copy(r101, r102);
    }

    public final CubeCreateThreadStrategy component1() {
        return this.createThreadStrategy;
    }

    public final CubeCreateThreadStrategy component2() {
        return this.loadThreadStrategy;
    }

    public final CubeCreateThreadConfig copy(CubeCreateThreadStrategy r100, CubeCreateThreadStrategy r101) {
        Intrinsics.checkNotNullParameter(r100, "createThreadStrategy");
        Intrinsics.checkNotNullParameter(r101, "loadThreadStrategy");
        return new CubeCreateThreadConfig(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CubeCreateThreadConfig) == true) goto L8;
        return false;
    L8:
        CubeCreateThreadConfig r101 = (CubeCreateThreadConfig) r100;
        if (this.createThreadStrategy == r101.createThreadStrategy) goto L12;
        return false;
    L12:
        if (this.loadThreadStrategy == r101.loadThreadStrategy) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.createThreadStrategy.hashCode() * 31) + this.loadThreadStrategy.hashCode();
    }

    public String toString() {
        return "CubeCreateThreadConfig(createThreadStrategy=" + this.createThreadStrategy + ", loadThreadStrategy=" + this.loadThreadStrategy + ')';
    }

    public final CubeCreateThreadStrategy getCreateThreadStrategy() {
        return this.createThreadStrategy;
    }

    public final CubeCreateThreadStrategy getLoadThreadStrategy() {
        return this.loadThreadStrategy;
    }

    public final void setCreateThreadStrategy(CubeCreateThreadStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.createThreadStrategy = r100;
    }

    public final void setLoadThreadStrategy(CubeCreateThreadStrategy r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.loadThreadStrategy = r100;
    }

    public CubeCreateThreadConfig(CubeCreateThreadStrategy r100, CubeCreateThreadStrategy r101) {
        Intrinsics.checkNotNullParameter(r100, "createThreadStrategy");
        Intrinsics.checkNotNullParameter(r101, "loadThreadStrategy");
        this.createThreadStrategy = r100;
        this.loadThreadStrategy = r101;
    }

    public /* synthetic */ CubeCreateThreadConfig(CubeCreateThreadStrategy r100, CubeCreateThreadStrategy r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = CubeCreateThreadStrategy.ON_CALLER_THREAD;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = CubeCreateThreadStrategy.ON_CALLER_THREAD;
    L8:
        this(r100, r101);
    }
}
