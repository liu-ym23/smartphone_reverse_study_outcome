package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/UpdateBadgeParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "count", "", "<init>", "(Ljava/lang/Integer;)V", "getCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "toString", "", "component1", "copy", "(Ljava/lang/Integer;)Lcom/ss/android/lark/todo/impl/flutterweb/bridge/UpdateBadgeParam;", "equals", "", "other", "", "hashCode", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateBadgeParam implements NonProguard {
    private final Integer count;

    public static /* synthetic */ UpdateBadgeParam copy$default(UpdateBadgeParam r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.count;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.count;
    }

    public final UpdateBadgeParam copy(Integer r100) {
        return new UpdateBadgeParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateBadgeParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.count, ((UpdateBadgeParam) r100).count) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.count;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "OpenActionSheetParam(count='" + this.count + "')";
    }

    public final Integer getCount() {
        return this.count;
    }

    public UpdateBadgeParam(Integer r100) {
        this.count = r100;
    }
}
