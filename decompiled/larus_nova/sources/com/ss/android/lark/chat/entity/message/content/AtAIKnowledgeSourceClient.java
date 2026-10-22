package com.ss.android.lark.chat.entity.message.content;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "Ljava/io/Serializable;", "actionId", "", "type", "", "unreadMessageStartPos", "unreadMessageEndPos", "<init>", "(Ljava/lang/String;III)V", "getActionId", "()Ljava/lang/String;", "getType", "()I", "getUnreadMessageStartPos", "getUnreadMessageEndPos", "toString", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtAIKnowledgeSourceClient implements Serializable {
    private final String actionId;
    private final int type;
    private final int unreadMessageEndPos;
    private final int unreadMessageStartPos;

    public AtAIKnowledgeSourceClient() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ AtAIKnowledgeSourceClient copy$default(AtAIKnowledgeSourceClient r100, String r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actionId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.type;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.unreadMessageStartPos;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.unreadMessageEndPos;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.actionId;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.unreadMessageStartPos;
    }

    public final int component4() {
        return this.unreadMessageEndPos;
    }

    public final AtAIKnowledgeSourceClient copy(String r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        return new AtAIKnowledgeSourceClient(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AtAIKnowledgeSourceClient) == true) goto L8;
        return false;
    L8:
        AtAIKnowledgeSourceClient r101 = (AtAIKnowledgeSourceClient) r100;
        if (Intrinsics.areEqual(this.actionId, r101.actionId) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (this.unreadMessageStartPos == r101.unreadMessageStartPos) goto L18;
        return false;
    L18:
        if (this.unreadMessageEndPos == r101.unreadMessageEndPos) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.actionId.hashCode() * 31) + this.type) * 31) + this.unreadMessageStartPos) * 31) + this.unreadMessageEndPos;
    }

    public String toString() {
        return "actionId = " + this.actionId + ", type = " + this.type + ", unreadMessageStartPos = " + this.unreadMessageStartPos + ", unreadMessageEndPos = " + this.unreadMessageEndPos;
    }

    public final String getActionId() {
        return this.actionId;
    }

    public final int getType() {
        return this.type;
    }

    public final int getUnreadMessageEndPos() {
        return this.unreadMessageEndPos;
    }

    public final int getUnreadMessageStartPos() {
        return this.unreadMessageStartPos;
    }

    public AtAIKnowledgeSourceClient(String r100, int r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "actionId");
        this.actionId = r100;
        this.type = r101;
        this.unreadMessageStartPos = r102;
        this.unreadMessageEndPos = r103;
    }

    public /* synthetic */ AtAIKnowledgeSourceClient(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
