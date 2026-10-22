package com.obric.assistant.interaction.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/interaction/api/WeakUpState;", "", "isAudioWeakUp", "", "isUiRenderedByChildProcess", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WeakUpState {
    private final boolean isAudioWeakUp;
    private final boolean isUiRenderedByChildProcess;

    public WeakUpState() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ WeakUpState copy$default(WeakUpState r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.isAudioWeakUp;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isUiRenderedByChildProcess;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.isAudioWeakUp;
    }

    public final boolean component2() {
        return this.isUiRenderedByChildProcess;
    }

    public final WeakUpState copy(boolean r100, boolean r101) {
        return new WeakUpState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WeakUpState) == true) goto L8;
        return false;
    L8:
        WeakUpState r101 = (WeakUpState) r100;
        if (this.isAudioWeakUp == r101.isAudioWeakUp) goto L12;
        return false;
    L12:
        if (this.isUiRenderedByChildProcess == r101.isUiRenderedByChildProcess) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.isAudioWeakUp == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isUiRenderedByChildProcess == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "WeakUpState(isAudioWeakUp=" + this.isAudioWeakUp + ", isUiRenderedByChildProcess=" + this.isUiRenderedByChildProcess + ')';
    }

    public final boolean isAudioWeakUp() {
        return this.isAudioWeakUp;
    }

    public final boolean isUiRenderedByChildProcess() {
        return this.isUiRenderedByChildProcess;
    }

    public WeakUpState(boolean r100, boolean r101) {
        this.isAudioWeakUp = r100;
        this.isUiRenderedByChildProcess = r101;
    }

    public /* synthetic */ WeakUpState(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
