package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/StartMergeMessagePageHandlerParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "messageResource", "", "", "<init>", "(Ljava/util/List;)V", "getMessageResource", "()Ljava/util/List;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StartMergeMessagePageHandlerParam implements NonProguard {
    private final List<Integer> messageResource;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StartMergeMessagePageHandlerParam copy$default(StartMergeMessagePageHandlerParam r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.messageResource;
    L6:
        return r100.copy(r101);
    }

    public final List<Integer> component1() {
        return this.messageResource;
    }

    public final StartMergeMessagePageHandlerParam copy(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageResource");
        return new StartMergeMessagePageHandlerParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof StartMergeMessagePageHandlerParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.messageResource, ((StartMergeMessagePageHandlerParam) r100).messageResource) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.messageResource.hashCode();
    }

    public String toString() {
        return "StartMergeMessagePageHandlerParam(messageResource=" + this.messageResource + ')';
    }

    public final List<Integer> getMessageResource() {
        return this.messageResource;
    }

    public StartMergeMessagePageHandlerParam(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "messageResource");
        this.messageResource = r100;
    }
}
