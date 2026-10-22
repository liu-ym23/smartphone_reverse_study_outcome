package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.utils;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/utils/AsrAdoptionRate;", "Ljava/io/Serializable;", "asrCount", "", "searchCount", "acceptCount", "<init>", "(III)V", "getAsrCount", "()I", "getSearchCount", "getAcceptCount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AsrAdoptionRate implements Serializable {
    private final int acceptCount;
    private final int asrCount;
    private final int searchCount;

    public static /* synthetic */ AsrAdoptionRate copy$default(AsrAdoptionRate r100, int r101, int r102, int r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.asrCount;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.searchCount;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.acceptCount;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final int component1() {
        return this.asrCount;
    }

    public final int component2() {
        return this.searchCount;
    }

    public final int component3() {
        return this.acceptCount;
    }

    public final AsrAdoptionRate copy(int r100, int r101, int r102) {
        return new AsrAdoptionRate(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AsrAdoptionRate) == true) goto L8;
        return false;
    L8:
        AsrAdoptionRate r101 = (AsrAdoptionRate) r100;
        if (this.asrCount == r101.asrCount) goto L12;
        return false;
    L12:
        if (this.searchCount == r101.searchCount) goto L15;
        return false;
    L15:
        if (this.acceptCount == r101.acceptCount) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.asrCount * 31) + this.searchCount) * 31) + this.acceptCount;
    }

    public String toString() {
        return "AsrAdoptionRate(asrCount=" + this.asrCount + ", searchCount=" + this.searchCount + ", acceptCount=" + this.acceptCount + ')';
    }

    public final int getAcceptCount() {
        return this.acceptCount;
    }

    public final int getAsrCount() {
        return this.asrCount;
    }

    public final int getSearchCount() {
        return this.searchCount;
    }

    public AsrAdoptionRate(int r100, int r101, int r102) {
        this.asrCount = r100;
        this.searchCount = r101;
        this.acceptCount = r102;
    }
}
