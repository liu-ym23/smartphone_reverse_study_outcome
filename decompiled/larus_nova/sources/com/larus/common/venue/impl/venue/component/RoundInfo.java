package com.larus.common.venue.impl.venue.component;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/common/venue/impl/venue/component/RoundInfo;", "", "roundNum", "", "hasSendMessage", "", "<init>", "(IZ)V", "getRoundNum", "()I", "getHasSendMessage", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RoundInfo {
    private final boolean hasSendMessage;
    private final int roundNum;

    /* JADX WARN: Multi-variable type inference failed */
    public RoundInfo() {
        int r100 = 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(r100, r101, 3, null);
    }

    public static /* synthetic */ RoundInfo copy$default(RoundInfo r100, int r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.roundNum;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.hasSendMessage;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.roundNum;
    }

    public final boolean component2() {
        return this.hasSendMessage;
    }

    public final RoundInfo copy(int r100, boolean r101) {
        return new RoundInfo(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RoundInfo) == true) goto L8;
        return false;
    L8:
        RoundInfo r101 = (RoundInfo) r100;
        if (this.roundNum == r101.roundNum) goto L12;
        return false;
    L12:
        if (this.hasSendMessage == r101.hasSendMessage) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.roundNum * 31;
        if (this.hasSendMessage == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "RoundInfo(roundNum=" + this.roundNum + ", hasSendMessage=" + this.hasSendMessage + ')';
    }

    public final boolean getHasSendMessage() {
        return this.hasSendMessage;
    }

    public final int getRoundNum() {
        return this.roundNum;
    }

    public RoundInfo(int r100, boolean r101) {
        this.roundNum = r100;
        this.hasSendMessage = r101;
    }

    public /* synthetic */ RoundInfo(int r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = -1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
