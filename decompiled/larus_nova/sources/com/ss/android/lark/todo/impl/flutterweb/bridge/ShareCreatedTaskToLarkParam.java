package com.ss.android.lark.todo.impl.flutterweb.bridge;

import com.ss.android.lark.diskmanage.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u000f\u001a\u00020\u0003H\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/todo/impl/flutterweb/bridge/ShareCreatedTaskToLarkParam;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "taskGuid", "", "chatId", "threadId", "isFromThread", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getTaskGuid", "()Ljava/lang/String;", "getChatId", "getThreadId", "()Z", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareCreatedTaskToLarkParam implements NonProguard {
    private final String chatId;
    private final boolean isFromThread;
    private final String taskGuid;
    private final String threadId;

    public static /* synthetic */ ShareCreatedTaskToLarkParam copy$default(ShareCreatedTaskToLarkParam r100, String r101, String r102, String r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.taskGuid;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.chatId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.threadId;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isFromThread;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.taskGuid;
    }

    public final String component2() {
        return this.chatId;
    }

    public final String component3() {
        return this.threadId;
    }

    public final boolean component4() {
        return this.isFromThread;
    }

    public final ShareCreatedTaskToLarkParam copy(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        return new ShareCreatedTaskToLarkParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ShareCreatedTaskToLarkParam) == true) goto L8;
        return false;
    L8:
        ShareCreatedTaskToLarkParam r101 = (ShareCreatedTaskToLarkParam) r100;
        if (Intrinsics.areEqual(this.taskGuid, r101.taskGuid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatId, r101.chatId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.threadId, r101.threadId) == true) goto L18;
        return false;
    L18:
        if (this.isFromThread == r101.isFromThread) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.taskGuid.hashCode() * 31) + this.chatId.hashCode()) * 31;
        String r101 = this.threadId;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.isFromThread == false) goto L9;
        int r104 = 1231;
    L11:
        return r103 + r104;
    L9:
        r104 = 1237;
        goto L11
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "ShareCreatedTaskToLarkParam(taskGuid='" + this.taskGuid + "', chatId='" + this.chatId + "', threadId='" + this.threadId + "', isFromThread='" + this.isFromThread + "')";
    }

    public final String getChatId() {
        return this.chatId;
    }

    public final String getTaskGuid() {
        return this.taskGuid;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final boolean isFromThread() {
        return this.isFromThread;
    }

    public ShareCreatedTaskToLarkParam(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "taskGuid");
        Intrinsics.checkNotNullParameter(r101, "chatId");
        this.taskGuid = r100;
        this.chatId = r101;
        this.threadId = r102;
        this.isFromThread = r103;
    }
}
