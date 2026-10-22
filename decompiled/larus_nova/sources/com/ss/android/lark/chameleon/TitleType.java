package com.ss.android.lark.chameleon;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u0000J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/chameleon/TitleType;", "Ljava/io/Serializable;", "size", "", "position", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getSize", "()Ljava/lang/Integer;", "setSize", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getPosition", "setPosition", "copy", "toString", "", "component1", "component2", "(Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/ss/android/lark/chameleon/TitleType;", "equals", "", "other", "", "hashCode", "chameleon-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleType implements Serializable {
    private Integer position;
    private Integer size;

    /* JADX WARN: Multi-variable type inference failed */
    public TitleType() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ TitleType copy$default(TitleType r100, Integer r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.size;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.position;
    L9:
        return r100.copy(r101, r102);
    }

    public final Integer component1() {
        return this.size;
    }

    public final Integer component2() {
        return this.position;
    }

    public final TitleType copy(Integer r100, Integer r101) {
        return new TitleType(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TitleType) == true) goto L8;
        return false;
    L8:
        TitleType r101 = (TitleType) r100;
        if (Intrinsics.areEqual(this.size, r101.size) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.position, r101.position) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.size;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.position;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final TitleType copy() {
        return new TitleType(this.size, this.position);
    }

    public String toString() {
        return "TitleType(size=" + this.size + ", position=" + this.position + ')';
    }

    public final Integer getPosition() {
        return this.position;
    }

    public final Integer getSize() {
        return this.size;
    }

    public final void setPosition(Integer r100) {
        this.position = r100;
    }

    public final void setSize(Integer r100) {
        this.size = r100;
    }

    public TitleType(Integer r100, Integer r101) {
        this.size = r100;
        this.position = r101;
    }

    public /* synthetic */ TitleType(Integer r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 1;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 1;
    L8:
        this(r100, r101);
    }
}
