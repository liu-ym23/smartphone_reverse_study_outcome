package com.ss.android.lark.todo.impl.features.common.entity;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/common/entity/EndTimeTextAttribute;", "Ljava/io/Serializable;", "endTimeStr", "", "endTimeColor", "", "<init>", "(Ljava/lang/String;I)V", "getEndTimeStr", "()Ljava/lang/String;", "setEndTimeStr", "(Ljava/lang/String;)V", "getEndTimeColor", "()I", "setEndTimeColor", "(I)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EndTimeTextAttribute implements Serializable {
    private int endTimeColor;
    private String endTimeStr;

    public static /* synthetic */ EndTimeTextAttribute copy$default(EndTimeTextAttribute r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.endTimeStr;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.endTimeColor;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.endTimeStr;
    }

    public final int component2() {
        return this.endTimeColor;
    }

    public final EndTimeTextAttribute copy(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "endTimeStr");
        return new EndTimeTextAttribute(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EndTimeTextAttribute) == true) goto L8;
        return false;
    L8:
        EndTimeTextAttribute r101 = (EndTimeTextAttribute) r100;
        if (Intrinsics.areEqual(this.endTimeStr, r101.endTimeStr) == true) goto L12;
        return false;
    L12:
        if (this.endTimeColor == r101.endTimeColor) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.endTimeStr.hashCode() * 31) + this.endTimeColor;
    }

    public String toString() {
        return "EndTimeTextAttribute(endTimeStr=" + this.endTimeStr + ", endTimeColor=" + this.endTimeColor + ')';
    }

    public final int getEndTimeColor() {
        return this.endTimeColor;
    }

    public final String getEndTimeStr() {
        return this.endTimeStr;
    }

    public final void setEndTimeColor(int r100) {
        this.endTimeColor = r100;
    }

    public final void setEndTimeStr(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.endTimeStr = r100;
    }

    public EndTimeTextAttribute(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "endTimeStr");
        this.endTimeStr = r100;
        this.endTimeColor = r101;
    }

    public /* synthetic */ EndTimeTextAttribute(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = "";
    L5:
        this(r100, r101);
    }
}
