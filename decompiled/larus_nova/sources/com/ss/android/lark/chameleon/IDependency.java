package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/chameleon/IDependency;", "Ljava/io/Serializable;", "monitorDependency", "Lcom/ss/android/lark/chameleon/IMonitorDependency;", "<init>", "(Lcom/ss/android/lark/chameleon/IMonitorDependency;)V", "getMonitorDependency", "()Lcom/ss/android/lark/chameleon/IMonitorDependency;", "setMonitorDependency", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IDependency implements Serializable {
    private transient IMonitorDependency monitorDependency;

    /* JADX WARN: Multi-variable type inference failed */
    public IDependency() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ IDependency copy$default(IDependency r100, IMonitorDependency r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.monitorDependency;
    L6:
        return r100.copy(r101);
    }

    public final IMonitorDependency component1() {
        return this.monitorDependency;
    }

    public final IDependency copy(IMonitorDependency r100) {
        return new IDependency(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof IDependency) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.monitorDependency, ((IDependency) r100).monitorDependency) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        IMonitorDependency r100 = this.monitorDependency;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "IDependency(monitorDependency=" + this.monitorDependency + ')';
    }

    public final IMonitorDependency getMonitorDependency() {
        return this.monitorDependency;
    }

    public IDependency(IMonitorDependency r100) {
        this.monitorDependency = r100;
    }

    public final void setMonitorDependency(IMonitorDependency r100) {
        this.monitorDependency = r100;
    }

    public /* synthetic */ IDependency(IMonitorDependency r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
