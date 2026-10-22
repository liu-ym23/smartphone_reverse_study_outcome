package com.ss.android.lark.widget.columns.entity;

import android.text.Layout;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/widget/columns/entity/ColumnsCellData;", "Ljava/io/Serializable;", "contentLayout", "Landroid/text/Layout;", "cellWidth", "", "<init>", "(Landroid/text/Layout;I)V", "getContentLayout", "()Landroid/text/Layout;", "setContentLayout", "(Landroid/text/Layout;)V", "getCellWidth", "()I", "setCellWidth", "(I)V", "equals", "", "other", "", "hashCode", "toString", "", "component1", "component2", "copy", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ColumnsCellData implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Layout f445730a;
    private int cellWidth;

    public static /* synthetic */ ColumnsCellData copy$default(ColumnsCellData r100, Layout r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f445730a;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.cellWidth;
    L9:
        return r100.copy(r101, r102);
    }

    public final Layout component1() {
        return this.f445730a;
    }

    public final int component2() {
        return this.cellWidth;
    }

    public final ColumnsCellData copy(Layout r100, int r101) {
        return new ColumnsCellData(r100, r101);
    }

    public int hashCode() {
        Layout r100 = this.f445730a;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.cellWidth;
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "ColumnsCellData(contentLayout=" + this.f445730a + ", cellWidth=" + this.cellWidth + ')';
    }

    public final int getCellWidth() {
        return this.cellWidth;
    }

    public final Layout getContentLayout() {
        return this.f445730a;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(ColumnsCellData.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.widget.columns.entity.ColumnsCellData");
        ColumnsCellData r102 = (ColumnsCellData) r100;
        if (Intrinsics.areEqual(this.f445730a, r102.f445730a) == true) goto L16;
        return false;
    L16:
        if (this.cellWidth == r102.cellWidth) goto L18;
        return false;
    L18:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    public final void setCellWidth(int r100) {
        this.cellWidth = r100;
    }

    public final void setContentLayout(Layout r100) {
        this.f445730a = r100;
    }

    public ColumnsCellData(Layout r100, int r101) {
        this.f445730a = r100;
        this.cellWidth = r101;
    }
}
