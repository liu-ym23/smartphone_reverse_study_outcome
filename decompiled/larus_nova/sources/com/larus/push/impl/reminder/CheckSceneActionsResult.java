package com.larus.push.impl.reminder;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/push/impl/reminder/CheckSceneActionsResult;", "", "needShow", "", "<init>", "(Ljava/lang/Boolean;)V", "getNeedShow", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/push/impl/reminder/CheckSceneActionsResult;", "equals", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CheckSceneActionsResult {

    @SerializedName("need_show")
    private final Boolean needShow;

    /* JADX WARN: Multi-variable type inference failed */
    public CheckSceneActionsResult() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ CheckSceneActionsResult copy$default(CheckSceneActionsResult r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.needShow;
    L6:
        return r100.copy(r101);
    }

    public final Boolean component1() {
        return this.needShow;
    }

    public final CheckSceneActionsResult copy(Boolean r100) {
        return new CheckSceneActionsResult(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CheckSceneActionsResult) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.needShow, ((CheckSceneActionsResult) r100).needShow) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.needShow;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "CheckSceneActionsResult(needShow=" + this.needShow + ')';
    }

    public final Boolean getNeedShow() {
        return this.needShow;
    }

    public CheckSceneActionsResult(Boolean r100) {
        this.needShow = r100;
    }

    public /* synthetic */ CheckSceneActionsResult(Boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = Boolean.FALSE;
    L5:
        this(r100);
    }
}
