package com.larus.voicecall.impl.continue_talk;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J1\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/larus/voicecall/impl/continue_talk/ChatContinuousTalkComponentViewState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "talkState", "", "closeTalk", "isQueryBegin", "isQueryEnd", "<init>", "(IIII)V", "getTalkState", "()I", "getCloseTalk", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatContinuousTalkComponentViewState implements w1a.b {
    private final int closeTalk;
    private final int isQueryBegin;
    private final int isQueryEnd;
    private final int talkState;

    public ChatContinuousTalkComponentViewState() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ChatContinuousTalkComponentViewState copy$default(ChatContinuousTalkComponentViewState r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.talkState;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.closeTalk;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.isQueryBegin;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.isQueryEnd;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.talkState;
    }

    public final int component2() {
        return this.closeTalk;
    }

    public final int component3() {
        return this.isQueryBegin;
    }

    public final int component4() {
        return this.isQueryEnd;
    }

    public final ChatContinuousTalkComponentViewState copy(int r100, int r101, int r102, int r103) {
        return new ChatContinuousTalkComponentViewState(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatContinuousTalkComponentViewState) == true) goto L8;
        return false;
    L8:
        ChatContinuousTalkComponentViewState r101 = (ChatContinuousTalkComponentViewState) r100;
        if (this.talkState == r101.talkState) goto L12;
        return false;
    L12:
        if (this.closeTalk == r101.closeTalk) goto L15;
        return false;
    L15:
        if (this.isQueryBegin == r101.isQueryBegin) goto L18;
        return false;
    L18:
        if (this.isQueryEnd == r101.isQueryEnd) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.talkState * 31) + this.closeTalk) * 31) + this.isQueryBegin) * 31) + this.isQueryEnd;
    }

    public String toString() {
        return "ChatContinuousTalkComponentViewState(talkState=" + this.talkState + ", closeTalk=" + this.closeTalk + ", isQueryBegin=" + this.isQueryBegin + ", isQueryEnd=" + this.isQueryEnd + ')';
    }

    public final int getCloseTalk() {
        return this.closeTalk;
    }

    public final int getTalkState() {
        return this.talkState;
    }

    public final int isQueryBegin() {
        return this.isQueryBegin;
    }

    public final int isQueryEnd() {
        return this.isQueryEnd;
    }

    public ChatContinuousTalkComponentViewState(int r100, int r101, int r102, int r103) {
        this.talkState = r100;
        this.closeTalk = r101;
        this.isQueryBegin = r102;
        this.isQueryEnd = r103;
    }

    public /* synthetic */ ChatContinuousTalkComponentViewState(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = -1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = -1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = -1;
    L14:
        this(r100, r101, r102, r103);
    }
}
