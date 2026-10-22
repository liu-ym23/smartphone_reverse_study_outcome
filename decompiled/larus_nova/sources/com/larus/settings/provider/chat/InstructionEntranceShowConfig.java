package com.larus.settings.provider.chat;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/settings/provider/chat/InstructionEntranceShowConfig;", "", "showByClickPlus", "", "showWithClearContext", "showAlways", "<init>", "(ZZZ)V", "getShowByClickPlus", "()Z", "getShowWithClearContext", "getShowAlways", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InstructionEntranceShowConfig {

    @SerializedName("show_always")
    private final boolean showAlways;

    @SerializedName("show_click_plus")
    private final boolean showByClickPlus;

    @SerializedName("show_with_clear_context")
    private final boolean showWithClearContext;

    public InstructionEntranceShowConfig() {
        this(false, false, false, 7, null);
    }

    public static /* synthetic */ InstructionEntranceShowConfig copy$default(InstructionEntranceShowConfig r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.showByClickPlus;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.showWithClearContext;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.showAlways;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.showByClickPlus;
    }

    public final boolean component2() {
        return this.showWithClearContext;
    }

    public final boolean component3() {
        return this.showAlways;
    }

    public final InstructionEntranceShowConfig copy(boolean r100, boolean r101, boolean r102) {
        return new InstructionEntranceShowConfig(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InstructionEntranceShowConfig) == true) goto L8;
        return false;
    L8:
        InstructionEntranceShowConfig r101 = (InstructionEntranceShowConfig) r100;
        if (this.showByClickPlus == r101.showByClickPlus) goto L12;
        return false;
    L12:
        if (this.showWithClearContext == r101.showWithClearContext) goto L15;
        return false;
    L15:
        if (this.showAlways == r101.showAlways) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.showByClickPlus == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.showWithClearContext == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.showAlways == true) goto L15;
        r100 = 1237;
    L15:
        return r104 + r100;
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "InstructionEntranceShowConfig(showByClickPlus=" + this.showByClickPlus + ", showWithClearContext=" + this.showWithClearContext + ", showAlways=" + this.showAlways + ')';
    }

    public final boolean getShowAlways() {
        return this.showAlways;
    }

    public final boolean getShowByClickPlus() {
        return this.showByClickPlus;
    }

    public final boolean getShowWithClearContext() {
        return this.showWithClearContext;
    }

    public InstructionEntranceShowConfig(boolean r100, boolean r101, boolean r102) {
        this.showByClickPlus = r100;
        this.showWithClearContext = r101;
        this.showAlways = r102;
    }

    public /* synthetic */ InstructionEntranceShowConfig(boolean r100, boolean r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = true;
    L11:
        this(r100, r101, r102);
    }
}
