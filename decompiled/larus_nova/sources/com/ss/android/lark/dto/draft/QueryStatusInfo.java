package com.ss.android.lark.dto.draft;

import com.ss.android.lark.chat.entity.message.content.AtAIKnowledgeSourceClient;
import com.ss.android.lark.keyboard.base.n;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/ss/android/lark/dto/draft/QueryStatusInfo;", "Ljava/io/Serializable;", "isQueryStatus", "", "startPos", "", "endPos", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "<init>", "(ZIILcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;)V", "()Z", "setQueryStatus", "(Z)V", "getStartPos", "()I", "setStartPos", "(I)V", "getEndPos", "setEndPos", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "Companion", "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QueryStatusInfo implements Serializable {
    public static final a Companion = null;
    private int endPos;
    private boolean isQueryStatus;
    private final AtAIKnowledgeSourceClient source;
    private int startPos;

    public static final class a implements n.a<QueryStatusInfo> {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public QueryStatusInfo() {
        this(false, 0, 0, null, 15, null);
    }

    public static /* synthetic */ QueryStatusInfo copy$default(QueryStatusInfo r100, boolean r101, int r102, int r103, AtAIKnowledgeSourceClient r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.isQueryStatus;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.startPos;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.endPos;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.source;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final boolean component1() {
        return this.isQueryStatus;
    }

    public final int component2() {
        return this.startPos;
    }

    public final int component3() {
        return this.endPos;
    }

    public final AtAIKnowledgeSourceClient component4() {
        return this.source;
    }

    public final QueryStatusInfo copy(boolean r100, int r101, int r102, AtAIKnowledgeSourceClient r103) {
        return new QueryStatusInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof QueryStatusInfo) == true) goto L8;
        return false;
    L8:
        QueryStatusInfo r101 = (QueryStatusInfo) r100;
        if (this.isQueryStatus == r101.isQueryStatus) goto L12;
        return false;
    L12:
        if (this.startPos == r101.startPos) goto L15;
        return false;
    L15:
        if (this.endPos == r101.endPos) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.source, r101.source) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        if (this.isQueryStatus == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.startPos) * 31) + this.endPos) * 31;
        AtAIKnowledgeSourceClient r102 = this.source;
        if (r102 != null) goto L9;
        int r103 = 0;
    L11:
        return r101 + r103;
    L9:
        r103 = r102.hashCode();
        goto L11
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "isQueryStatus = " + this.isQueryStatus + ", startPos = " + this.startPos + ", endPos = " + this.endPos;
    }

    public final int getEndPos() {
        return this.endPos;
    }

    public final AtAIKnowledgeSourceClient getSource() {
        return this.source;
    }

    public final int getStartPos() {
        return this.startPos;
    }

    public final boolean isQueryStatus() {
        return this.isQueryStatus;
    }

    public final void setEndPos(int r100) {
        this.endPos = r100;
    }

    public final void setQueryStatus(boolean r100) {
        this.isQueryStatus = r100;
    }

    public final void setStartPos(int r100) {
        this.startPos = r100;
    }

    public QueryStatusInfo(boolean r100, int r101, int r102, AtAIKnowledgeSourceClient r103) {
        this.isQueryStatus = r100;
        this.startPos = r101;
        this.endPos = r102;
        this.source = r103;
    }

    public /* synthetic */ QueryStatusInfo(boolean r100, int r101, int r102, AtAIKnowledgeSourceClient r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
