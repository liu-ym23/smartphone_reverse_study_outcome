package com.ss.android.lark.todo.impl.features.common.share.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareEntity;", "Ljava/io/Serializable;", "status", "Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareStatus;", "errorStr", "", "<init>", "(Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareStatus;Ljava/lang/String;)V", "getStatus", "()Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareStatus;", "setStatus", "(Lcom/ss/android/lark/todo/impl/features/common/share/entity/ShareStatus;)V", "getErrorStr", "()Ljava/lang/String;", "setErrorStr", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareEntity implements Serializable {
    private String errorStr;
    private ShareStatus status;

    public static /* synthetic */ ShareEntity copy$default(ShareEntity r100, ShareStatus r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.errorStr;
    L9:
        return r100.copy(r101, r102);
    }

    public final ShareStatus component1() {
        return this.status;
    }

    public final String component2() {
        return this.errorStr;
    }

    public final ShareEntity copy(ShareStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "errorStr");
        return new ShareEntity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareEntity) == true) goto L8;
        return false;
    L8:
        ShareEntity r101 = (ShareEntity) r100;
        if (this.status == r101.status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errorStr, r101.errorStr) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.status.hashCode() * 31) + this.errorStr.hashCode();
    }

    public String toString() {
        return "ShareEntity(status=" + this.status + ", errorStr=" + this.errorStr + ')';
    }

    public final String getErrorStr() {
        return this.errorStr;
    }

    public final ShareStatus getStatus() {
        return this.status;
    }

    public final void setErrorStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorStr = r100;
    }

    public final void setStatus(ShareStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.status = r100;
    }

    public ShareEntity(ShareStatus r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r101, "errorStr");
        this.status = r100;
        this.errorStr = r101;
    }

    public /* synthetic */ ShareEntity(ShareStatus r100, String r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = "";
    L5:
        this(r100, r101);
    }
}
