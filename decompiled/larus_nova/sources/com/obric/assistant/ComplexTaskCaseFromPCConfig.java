package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/obric/assistant/ComplexTaskCaseFromPCConfig;", "", "limitCount", "", "shortcutLimitCount", "localLimitCount", "maxTextLength", "<init>", "(IIII)V", "getLimitCount", "()I", "getShortcutLimitCount", "getLocalLimitCount", "getMaxTextLength", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComplexTaskCaseFromPCConfig {

    @SerializedName("obric_complex_task_pc_case_count")
    private final int limitCount;

    @SerializedName("obric_complex_task_local_case_count")
    private final int localLimitCount;

    @SerializedName("obric_complex_task_max_text_length")
    private final int maxTextLength;

    @SerializedName("obric_complex_task_shortcut_case_count")
    private final int shortcutLimitCount;

    public ComplexTaskCaseFromPCConfig() {
        this(0, 0, 0, 0, 15, null);
    }

    public static /* synthetic */ ComplexTaskCaseFromPCConfig copy$default(ComplexTaskCaseFromPCConfig r100, int r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.limitCount;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.shortcutLimitCount;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.localLimitCount;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.maxTextLength;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final int component1() {
        return this.limitCount;
    }

    public final int component2() {
        return this.shortcutLimitCount;
    }

    public final int component3() {
        return this.localLimitCount;
    }

    public final int component4() {
        return this.maxTextLength;
    }

    public final ComplexTaskCaseFromPCConfig copy(int r100, int r101, int r102, int r103) {
        return new ComplexTaskCaseFromPCConfig(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ComplexTaskCaseFromPCConfig) == true) goto L8;
        return false;
    L8:
        ComplexTaskCaseFromPCConfig r101 = (ComplexTaskCaseFromPCConfig) r100;
        if (this.limitCount == r101.limitCount) goto L12;
        return false;
    L12:
        if (this.shortcutLimitCount == r101.shortcutLimitCount) goto L15;
        return false;
    L15:
        if (this.localLimitCount == r101.localLimitCount) goto L18;
        return false;
    L18:
        if (this.maxTextLength == r101.maxTextLength) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.limitCount * 31) + this.shortcutLimitCount) * 31) + this.localLimitCount) * 31) + this.maxTextLength;
    }

    public String toString() {
        return "ComplexTaskCaseFromPCConfig(limitCount=" + this.limitCount + ", shortcutLimitCount=" + this.shortcutLimitCount + ", localLimitCount=" + this.localLimitCount + ", maxTextLength=" + this.maxTextLength + ')';
    }

    public final int getLimitCount() {
        return this.limitCount;
    }

    public final int getLocalLimitCount() {
        return this.localLimitCount;
    }

    public final int getMaxTextLength() {
        return this.maxTextLength;
    }

    public final int getShortcutLimitCount() {
        return this.shortcutLimitCount;
    }

    public ComplexTaskCaseFromPCConfig(int r100, int r101, int r102, int r103) {
        this.limitCount = r100;
        this.shortcutLimitCount = r101;
        this.localLimitCount = r102;
        this.maxTextLength = r103;
    }

    public /* synthetic */ ComplexTaskCaseFromPCConfig(int r100, int r101, int r102, int r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = 10;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = 10;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = 10;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = 20;
    L14:
        this(r100, r101, r102, r103);
    }
}
