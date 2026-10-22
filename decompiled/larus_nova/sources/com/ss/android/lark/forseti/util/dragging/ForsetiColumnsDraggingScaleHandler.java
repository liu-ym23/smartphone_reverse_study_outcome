package com.ss.android.lark.forseti.util.dragging;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class ForsetiColumnsDraggingScaleHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f424612a = 0;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/forseti/util/dragging/ForsetiColumnsDraggingScaleHandler$ScaleXFactor;", "Ljava/io/Serializable;", "firstFactor", "", "secondFactor", "<init>", "(FF)V", "getFirstFactor", "()F", "getSecondFactor", "equals", "", "other", "", "hashCode", "", "toString", "", "component1", "component2", "copy", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ScaleXFactor implements Serializable {
        private final float firstFactor;
        private final float secondFactor;

        public static /* synthetic */ ScaleXFactor copy$default(ScaleXFactor r100, float r101, float r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.firstFactor;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.secondFactor;
        L9:
            return r100.copy(r101, r102);
        }

        public final float component1() {
            return this.firstFactor;
        }

        public final float component2() {
            return this.secondFactor;
        }

        public final ScaleXFactor copy(float r100, float r101) {
            return new ScaleXFactor(r100, r101);
        }

        public int hashCode() {
            return (Float.floatToIntBits(this.firstFactor) * 31) + Float.floatToIntBits(this.secondFactor);
        }

        public String toString() {
            return "ScaleXFactor(firstFactor=" + this.firstFactor + ", secondFactor=" + this.secondFactor + ')';
        }

        public final float getFirstFactor() {
            return this.firstFactor;
        }

        public final float getSecondFactor() {
            return this.secondFactor;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(ScaleXFactor.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.forseti.util.dragging.ForsetiColumnsDraggingScaleHandler.ScaleXFactor");
            ScaleXFactor r102 = (ScaleXFactor) r100;
            if (this.firstFactor != r102.firstFactor) goto L15;
            boolean r103 = true;
        L16:
            if (r103 == true) goto L19;
            return false;
        L19:
            if (this.secondFactor != r102.secondFactor) goto L21;
            boolean r104 = true;
        L22:
            if (r104 == true) goto L24;
            return false;
        L24:
            return true;
        L21:
            r104 = false;
            goto L22
        L15:
            r103 = false;
            goto L16
        L8:
            r101 = null;
            goto L10
        }

        public ScaleXFactor(float r100, float r101) {
            this.firstFactor = r100;
            this.secondFactor = r101;
        }
    }

    static {
    }
}
