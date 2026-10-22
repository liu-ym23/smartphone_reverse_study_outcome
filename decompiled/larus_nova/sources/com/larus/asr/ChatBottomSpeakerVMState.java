package com.larus.asr;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/asr/ChatBottomSpeakerVMState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "state", "", "<init>", "(I)V", "getState", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatBottomSpeakerVMState implements w1a.b {
    private final int state;

    public ChatBottomSpeakerVMState() {
        int r100 = 0;
        this(r100, 1, null);
    }

    public static /* synthetic */ ChatBottomSpeakerVMState copy$default(ChatBottomSpeakerVMState r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.state;
    }

    public final ChatBottomSpeakerVMState copy(int r100) {
        return new ChatBottomSpeakerVMState(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatBottomSpeakerVMState) == true) goto L9;
        return false;
    L9:
        if (this.state == ((ChatBottomSpeakerVMState) r100).state) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.state;
    }

    public String toString() {
        return "ChatBottomSpeakerVMState(state=" + this.state + ')';
    }

    public final int getState() {
        return this.state;
    }

    public ChatBottomSpeakerVMState(int r100) {
        this.state = r100;
    }

    public /* synthetic */ ChatBottomSpeakerVMState(int r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = 0;
    L5:
        this(r100);
    }
}
