package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\u0003H\u0016J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/ShareTaskParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "content", "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "toString", "component1", "copy", "equals", "", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareTaskParam implements NonProguard {
    private final String content;

    public static /* synthetic */ ShareTaskParam copy$default(ShareTaskParam r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.content;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.content;
    }

    public final ShareTaskParam copy(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        return new ShareTaskParam(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareTaskParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.content, ((ShareTaskParam) r100).content) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.content.hashCode();
    }

    public String toString() {
        return "ShareTaskParam(content='" + this.content + "')";
    }

    public final String getContent() {
        return this.content;
    }

    public ShareTaskParam(String r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        this.content = r100;
    }
}
