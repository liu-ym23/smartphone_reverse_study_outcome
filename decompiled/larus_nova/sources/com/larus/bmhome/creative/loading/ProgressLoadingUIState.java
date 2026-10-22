package com.larus.bmhome.creative.loading;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import w1a.b;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0015JJ\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/bmhome/creative/loading/ProgressLoadingUIState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "loadingLocalMessageId", "", "loadingReplyId", DBDefinition.TASK_ID, "progress", "", "updateId", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)V", "getLoadingLocalMessageId", "()Ljava/lang/String;", "getLoadingReplyId", "getTaskId", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUpdateId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/larus/bmhome/creative/loading/ProgressLoadingUIState;", "equals", "", "other", "", "hashCode", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProgressLoadingUIState implements b, Serializable {
    private final String loadingLocalMessageId;
    private final String loadingReplyId;
    private final Integer progress;
    private final String taskId;
    private final Long updateId;

    public ProgressLoadingUIState() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ ProgressLoadingUIState copy$default(ProgressLoadingUIState r100, String r101, String r102, String r103, Integer r104, Long r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.loadingLocalMessageId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.loadingReplyId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.taskId;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.progress;
    L14:
        Integer r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.updateId;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.loadingLocalMessageId;
    }

    public final String component2() {
        return this.loadingReplyId;
    }

    public final String component3() {
        return this.taskId;
    }

    public final Integer component4() {
        return this.progress;
    }

    public final Long component5() {
        return this.updateId;
    }

    public final ProgressLoadingUIState copy(String r100, String r101, String r110, Integer r111, Long r112) {
        return new ProgressLoadingUIState(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProgressLoadingUIState) == true) goto L8;
        return false;
    L8:
        ProgressLoadingUIState r101 = (ProgressLoadingUIState) r100;
        if (Intrinsics.areEqual(this.loadingLocalMessageId, r101.loadingLocalMessageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadingReplyId, r101.loadingReplyId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.progress, r101.progress) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.updateId, r101.updateId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.loadingLocalMessageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.loadingReplyId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.taskId;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.progress;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Long r113 = this.updateId;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ProgressLoadingUIState(loadingLocalMessageId=" + this.loadingLocalMessageId + ", loadingReplyId=" + this.loadingReplyId + ", taskId=" + this.taskId + ", progress=" + this.progress + ", updateId=" + this.updateId + ')';
    }

    public final String getLoadingLocalMessageId() {
        return this.loadingLocalMessageId;
    }

    public final String getLoadingReplyId() {
        return this.loadingReplyId;
    }

    public final Integer getProgress() {
        return this.progress;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final Long getUpdateId() {
        return this.updateId;
    }

    public ProgressLoadingUIState(String r100, String r101, String r102, Integer r103, Long r104) {
        this.loadingLocalMessageId = r100;
        this.loadingReplyId = r101;
        this.taskId = r102;
        this.progress = r103;
        this.updateId = r104;
    }

    public /* synthetic */ ProgressLoadingUIState(String r100, String r101, String r102, Integer r103, Long r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Integer r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Long r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
