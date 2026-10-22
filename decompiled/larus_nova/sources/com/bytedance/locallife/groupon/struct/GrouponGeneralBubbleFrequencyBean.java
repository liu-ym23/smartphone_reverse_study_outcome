package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J3\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001bJ\u0006\u0010\u001f\u001a\u00020\u001bJ\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006!"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/GrouponGeneralBubbleFrequencyBean;", "", "freqKey", "", "freqCountX", "", "freqTimeY", "freqOption", "(Ljava/lang/String;III)V", "getFreqCountX", "()I", "setFreqCountX", "(I)V", "getFreqKey", "()Ljava/lang/String;", "setFreqKey", "(Ljava/lang/String;)V", "getFreqOption", "setFreqOption", "getFreqTimeY", "setFreqTimeY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "needAddFreq", "needReadFreq", "toString", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class GrouponGeneralBubbleFrequencyBean {

    @SerializedName("freq_count_x")
    private int freqCountX;

    @SerializedName("freq_key")
    private String freqKey;

    @SerializedName("freq_option")
    private int freqOption;

    @SerializedName("freq_time_y")
    private int freqTimeY;

    public GrouponGeneralBubbleFrequencyBean() {
        this(null, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ GrouponGeneralBubbleFrequencyBean copy$default(GrouponGeneralBubbleFrequencyBean r100, String r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.freqKey;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.freqCountX;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.freqTimeY;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.freqOption;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.freqKey;
    }

    public final int component2() {
        return this.freqCountX;
    }

    public final int component3() {
        return this.freqTimeY;
    }

    public final int component4() {
        return this.freqOption;
    }

    public final GrouponGeneralBubbleFrequencyBean copy(String r100, int r101, int r102, int r103) {
        return new GrouponGeneralBubbleFrequencyBean(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GrouponGeneralBubbleFrequencyBean) == true) goto L8;
        return false;
    L8:
        GrouponGeneralBubbleFrequencyBean r101 = (GrouponGeneralBubbleFrequencyBean) r100;
        if (Intrinsics.areEqual(this.freqKey, r101.freqKey) == true) goto L12;
        return false;
    L12:
        if (this.freqCountX == r101.freqCountX) goto L15;
        return false;
    L15:
        if (this.freqTimeY == r101.freqTimeY) goto L18;
        return false;
    L18:
        if (this.freqOption == r101.freqOption) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r100 = this.freqKey;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((r101 * 31) + this.freqCountX) * 31) + this.freqTimeY) * 31) + this.freqOption;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "GrouponGeneralBubbleFrequencyBean(freqKey=" + this.freqKey + ", freqCountX=" + this.freqCountX + ", freqTimeY=" + this.freqTimeY + ", freqOption=" + this.freqOption + ')';
    }

    public final boolean needAddFreq() {
        if (this.freqOption == 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean needReadFreq() {
        if (this.freqOption != 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getFreqCountX() {
        return this.freqCountX;
    }

    public final String getFreqKey() {
        return this.freqKey;
    }

    public final int getFreqOption() {
        return this.freqOption;
    }

    public final int getFreqTimeY() {
        return this.freqTimeY;
    }

    public final void setFreqCountX(int r100) {
        this.freqCountX = r100;
    }

    public final void setFreqKey(String r100) {
        this.freqKey = r100;
    }

    public final void setFreqOption(int r100) {
        this.freqOption = r100;
    }

    public final void setFreqTimeY(int r100) {
        this.freqTimeY = r100;
    }

    public GrouponGeneralBubbleFrequencyBean(String r100, int r101, int r102, int r103) {
        this.freqKey = r100;
        this.freqCountX = r101;
        this.freqTimeY = r102;
        this.freqOption = r103;
    }

    public /* synthetic */ GrouponGeneralBubbleFrequencyBean(String r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 1;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 1;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 0;
    L14:
        this(r100, r101, r102, r103);
    }
}
