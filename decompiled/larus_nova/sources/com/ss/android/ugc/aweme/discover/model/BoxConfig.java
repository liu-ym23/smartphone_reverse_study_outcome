package com.ss.android.ugc.aweme.discover.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/BoxConfig;", "Ljava/io/Serializable;", "widths", "", "([I)V", "getWidths", "()[I", "setWidths", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-search-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BoxConfig implements Serializable {

    @SerializedName("widths")
    private int[] widths;

    /* JADX WARN: Multi-variable type inference failed */
    public BoxConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ BoxConfig copy$default(BoxConfig r100, int[] r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.widths;
    L6:
        return r100.copy(r101);
    }

    public final int[] component1() {
        return this.widths;
    }

    public final BoxConfig copy(int[] r100) {
        return new BoxConfig(r100);
    }

    public String toString() {
        return "BoxConfig(widths=" + Arrays.toString(this.widths) + ")";
    }

    public int hashCode() {
        int[] r100 = this.widths;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return Arrays.hashCode(r100);
    }

    public final int[] getWidths() {
        return this.widths;
    }

    public BoxConfig(int[] r100) {
        this.widths = r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(BoxConfig.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L26;
        BoxConfig r102 = (BoxConfig) r100;
        int[] r103 = this.widths;
        if (r103 == null) goto L22;
        int[] r104 = r102.widths;
        if (r104 != null) goto L19;
        return false;
    L19:
        if (Arrays.equals(r103, r104) == true) goto L24;
        return false;
    L24:
        return true;
    L22:
        if (r102.widths == null) goto L24;
        return false;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type com.ss.android.ugc.aweme.discover.model.BoxConfig");
    L8:
        r101 = null;
        goto L10
    }

    public final void setWidths(int[] r100) {
        this.widths = r100;
    }

    public /* synthetic */ BoxConfig(int[] r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = new int[]{70, 88};
    L5:
        this(r100);
    }
}
