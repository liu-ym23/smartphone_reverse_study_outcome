package com.ss.android.lark.widget.columns.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/widget/columns/entity/ColumnsScrollProcess;", "Ljava/io/Serializable;", "verticalScrollProcess", "Lcom/ss/android/lark/widget/columns/entity/ColumnsScrollProcess$VerticalScrollProcess;", "<init>", "(Lcom/ss/android/lark/widget/columns/entity/ColumnsScrollProcess$VerticalScrollProcess;)V", "getVerticalScrollProcess", "()Lcom/ss/android/lark/widget/columns/entity/ColumnsScrollProcess$VerticalScrollProcess;", "equals", "", "other", "", "hashCode", "", "toString", "", "component1", "copy", "VerticalScrollProcess", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsScrollProcess implements Serializable {
    private final VerticalScrollProcess verticalScrollProcess;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/widget/columns/entity/ColumnsScrollProcess$VerticalScrollProcess;", "Ljava/io/Serializable;", "verticalX", "", "verticalY", "<init>", "(II)V", "getVerticalX", "()I", "getVerticalY", "equals", "", "other", "", "hashCode", "toString", "", "component1", "component2", "copy", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class VerticalScrollProcess implements Serializable {
        private final int verticalX;
        private final int verticalY;

        public static /* synthetic */ VerticalScrollProcess copy$default(VerticalScrollProcess r100, int r101, int r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.verticalX;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.verticalY;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.verticalX;
        }

        public final int component2() {
            return this.verticalY;
        }

        public final VerticalScrollProcess copy(int r100, int r101) {
            return new VerticalScrollProcess(r100, r101);
        }

        public int hashCode() {
            return (this.verticalX * 31) + this.verticalY;
        }

        public String toString() {
            return "VerticalScrollProcess(verticalX=" + this.verticalX + ", verticalY=" + this.verticalY + ')';
        }

        public final int getVerticalX() {
            return this.verticalX;
        }

        public final int getVerticalY() {
            return this.verticalY;
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(VerticalScrollProcess.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.columns.entity.ColumnsScrollProcess.VerticalScrollProcess");
            VerticalScrollProcess r102 = (VerticalScrollProcess) r100;
            if (this.verticalX == r102.verticalX) goto L16;
            return false;
        L16:
            if (this.verticalY == r102.verticalY) goto L18;
            return false;
        L18:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public VerticalScrollProcess(int r100, int r101) {
            this.verticalX = r100;
            this.verticalY = r101;
        }
    }

    public static /* synthetic */ ColumnsScrollProcess copy$default(ColumnsScrollProcess r100, VerticalScrollProcess r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.verticalScrollProcess;
    L6:
        return r100.copy(r101);
    }

    public final VerticalScrollProcess component1() {
        return this.verticalScrollProcess;
    }

    public final ColumnsScrollProcess copy(VerticalScrollProcess r100) {
        Intrinsics.checkNotNullParameter(r100, "verticalScrollProcess");
        return new ColumnsScrollProcess(r100);
    }

    public int hashCode() {
        return this.verticalScrollProcess.hashCode();
    }

    public String toString() {
        return "ColumnsScrollProcess(verticalScrollProcess=" + this.verticalScrollProcess + ')';
    }

    public final VerticalScrollProcess getVerticalScrollProcess() {
        return this.verticalScrollProcess;
    }

    public ColumnsScrollProcess(VerticalScrollProcess r100) {
        Intrinsics.checkNotNullParameter(r100, "verticalScrollProcess");
        this.verticalScrollProcess = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ColumnsScrollProcess.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.columns.entity.ColumnsScrollProcess");
        if (Intrinsics.areEqual(this.verticalScrollProcess, ((ColumnsScrollProcess) r100).verticalScrollProcess) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }
}
