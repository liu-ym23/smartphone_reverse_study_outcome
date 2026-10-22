package com.bytedance.ee.bear.bitable.workbench;

import com.bytedance.ee.bear.contract.Result;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/workbench/WorkBenchOnboarding;", "Lcom/bytedance/ee/bear/contract/Result;", "", "isShow", "<init>", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkBenchOnboarding extends Result<Boolean> {
    private final boolean isShow;

    public WorkBenchOnboarding() {
        boolean r100 = false;
        this(r100, 1, null);
    }

    public static /* synthetic */ WorkBenchOnboarding copy$default(WorkBenchOnboarding r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.isShow;
    L6:
        return r100.copy(r101);
    }

    public final boolean component1() {
        return this.isShow;
    }

    public final WorkBenchOnboarding copy(boolean r100) {
        return new WorkBenchOnboarding(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WorkBenchOnboarding) == true) goto L9;
        return false;
    L9:
        if (this.isShow == ((WorkBenchOnboarding) r100).isShow) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this.isShow == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "WorkBenchOnboarding(isShow=" + this.isShow + ')';
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public WorkBenchOnboarding(boolean r100) {
        this.isShow = r100;
    }

    public /* synthetic */ WorkBenchOnboarding(boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = false;
    L5:
        this(r100);
    }
}
