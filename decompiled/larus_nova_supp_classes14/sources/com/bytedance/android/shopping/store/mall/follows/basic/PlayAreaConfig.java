package com.bytedance.android.shopping.store.mall.follows.basic;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/basic/PlayAreaConfig;", "", "startPlay", "", "endPlay", "playableHeight", "(III)V", "getEndPlay", "()I", "getPlayableHeight", "getStartPlay", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayAreaConfig {
    private final int endPlay;
    private final int playableHeight;
    private final int startPlay;

    public static /* synthetic */ PlayAreaConfig copy$default(PlayAreaConfig r0, int r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.startPlay;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.endPlay;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.playableHeight;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final int component1() {
        return this.startPlay;
    }

    public final int component2() {
        return this.endPlay;
    }

    public final int component3() {
        return this.playableHeight;
    }

    public final PlayAreaConfig copy(int r2, int r3, int r4) {
        return new PlayAreaConfig(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof PlayAreaConfig) == false) goto L12;
        PlayAreaConfig r4 = (PlayAreaConfig) r3;
        if (this.startPlay == r4.startPlay) goto L8;
        return false;
    L8:
        if (this.endPlay == r4.endPlay) goto L10;
        return false;
    L10:
        if (this.playableHeight == r4.playableHeight) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return (((this.startPlay * 31) + this.endPlay) * 31) + this.playableHeight;
    }

    public String toString() {
        return "PlayAreaConfig(startPlay=" + this.startPlay + ", endPlay=" + this.endPlay + ", playableHeight=" + this.playableHeight + ")";
    }

    public final int getEndPlay() {
        return this.endPlay;
    }

    public final int getPlayableHeight() {
        return this.playableHeight;
    }

    public final int getStartPlay() {
        return this.startPlay;
    }

    public PlayAreaConfig(int r1, int r2, int r3) {
        this.startPlay = r1;
        this.endPlay = r2;
        this.playableHeight = r3;
    }
}
