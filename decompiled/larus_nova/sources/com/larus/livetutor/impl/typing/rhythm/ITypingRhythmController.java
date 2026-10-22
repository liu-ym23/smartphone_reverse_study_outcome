package com.larus.livetutor.impl.typing.rhythm;

import com.larus.livetutor.impl.typing.enumeration.TypingStreamStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
public interface ITypingRhythmController {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/livetutor/impl/typing/rhythm/ITypingRhythmController$Beat;", "", "step", "", "time", "", "<init>", "(IJ)V", "getStep", "()I", "getTime", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Beat {
        private final int step;
        private final long time;

        public Beat() {
            this(0, 0, 3, null);
        }

        public static /* synthetic */ Beat copy$default(Beat r100, int r101, long r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.step;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.time;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.step;
        }

        public final long component2() {
            return this.time;
        }

        public final Beat copy(int r100, long r101) {
            return new Beat(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Beat) == true) goto L8;
            return false;
        L8:
            Beat r101 = (Beat) r100;
            if (this.step == r101.step) goto L12;
            return false;
        L12:
            if (this.time == r101.time) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r100 = this.step * 31;
            long r101 = this.time;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public String toString() {
            return "Beat(step=" + this.step + ", time=" + this.time + ')';
        }

        public final int getStep() {
            return this.step;
        }

        public final long getTime() {
            return this.time;
        }

        public Beat(int r100, long r101) {
            this.step = r100;
            this.time = r101;
        }

        public /* synthetic */ Beat(int r100, long r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 1;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = 20;
        L8:
            this(r100, r101);
        }
    }

    Beat a(Beat r100, TypingStreamStatus r101);
}
