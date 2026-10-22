package com.ss.android.ugc.aweme.ktv;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/ktv/AudioInterval;", "Ljava/io/Serializable;", "start", "", "end", "(JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getStart", "setStart", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class AudioInterval implements Serializable {
    private long end;
    private long start;

    public static /* synthetic */ AudioInterval copy$default(AudioInterval r100, long r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.start;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.end;
    L9:
        return r100.copy(r101, r102);
    }

    public final long component1() {
        return this.start;
    }

    public final long component2() {
        return this.end;
    }

    public final AudioInterval copy(long r100, long r101) {
        return new AudioInterval(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AudioInterval) == false) goto L10;
        AudioInterval r101 = (AudioInterval) r100;
        if (this.start == r101.start) goto L8;
        return false;
    L8:
        if (this.end == r101.end) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        long r100 = this.start;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = this.end;
        return r101 + ((int) (r102 ^ (r102 >>> 32)));
    }

    public String toString() {
        return "AudioInterval(start=" + this.start + ", end=" + this.end + ")";
    }

    public final long getEnd() {
        return this.end;
    }

    public final long getStart() {
        return this.start;
    }

    public final void setEnd(long r100) {
        this.end = r100;
    }

    public final void setStart(long r100) {
        this.start = r100;
    }

    public AudioInterval(long r100, long r101) {
        this.start = r100;
        this.end = r101;
    }
}
