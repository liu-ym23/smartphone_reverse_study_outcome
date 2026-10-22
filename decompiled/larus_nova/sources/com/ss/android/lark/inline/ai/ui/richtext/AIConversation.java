package com.ss.android.lark.inline.ai.ui.richtext;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/inline/ai/ui/richtext/AIConversation;", "Ljava/io/Serializable;", "conversationId", "", DBDefinition.TASK_ID, "contentHeight", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getConversationId", "()Ljava/lang/String;", "setConversationId", "(Ljava/lang/String;)V", "getTaskId", "setTaskId", "getContentHeight", "()Ljava/lang/Integer;", "setContentHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "toString", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/inline/ai/ui/richtext/AIConversation;", "equals", "", "other", "", "hashCode", "inline-ai-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIConversation implements Serializable {
    private Integer contentHeight;
    private String conversationId;
    private String taskId;

    public AIConversation() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AIConversation copy$default(AIConversation r100, String r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.conversationId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.taskId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.contentHeight;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.taskId;
    }

    public final Integer component3() {
        return this.contentHeight;
    }

    public final AIConversation copy(String r100, String r101, Integer r102) {
        return new AIConversation(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AIConversation) == true) goto L8;
        return false;
    L8:
        AIConversation r101 = (AIConversation) r100;
        if (Intrinsics.areEqual(this.conversationId, r101.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.taskId, r101.taskId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contentHeight, r101.contentHeight) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.conversationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.taskId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.contentHeight;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "AIConversation(conversationId='" + this.conversationId + "', taskId='" + this.taskId + "', contentHeight = " + this.contentHeight + ')';
    }

    public final Integer getContentHeight() {
        return this.contentHeight;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final void setContentHeight(Integer r100) {
        this.contentHeight = r100;
    }

    public final void setConversationId(String r100) {
        this.conversationId = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public AIConversation(String r100, String r101, Integer r102) {
        this.conversationId = r100;
        this.taskId = r101;
        this.contentHeight = r102;
    }

    public /* synthetic */ AIConversation(String r100, String r101, Integer r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
