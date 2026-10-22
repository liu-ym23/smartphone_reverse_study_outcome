package com.larksuite.component.card.component.text;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larksuite/component/card/component/text/EmojProps;", "", "key", "", "textSize", "", "<init>", "(Ljava/lang/String;I)V", "getKey", "()Ljava/lang/String;", "getTextSize", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EmojProps {
    private final String key;
    private final int textSize;

    /* JADX WARN: Multi-variable type inference failed */
    public EmojProps() {
        String r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ EmojProps copy$default(EmojProps r100, String r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.key;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.textSize;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.key;
    }

    public final int component2() {
        return this.textSize;
    }

    public final EmojProps copy(String r100, int r101) {
        return new EmojProps(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EmojProps) == true) goto L8;
        return false;
    L8:
        EmojProps r101 = (EmojProps) r100;
        if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
        return false;
    L12:
        if (this.textSize == r101.textSize) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.key;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (r101 * 31) + this.textSize;
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public String toString() {
        return "EmojProps(key=" + this.key + ", textSize=" + this.textSize + ')';
    }

    public final String getKey() {
        return this.key;
    }

    public final int getTextSize() {
        return this.textSize;
    }

    public EmojProps(String r100, int r101) {
        this.key = r100;
        this.textSize = r101;
    }

    public /* synthetic */ EmojProps(String r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 14;
    L8:
        this(r100, r101);
    }
}
