package com.relax.runtime.gen;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\u0002\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0018\b\u0002\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R*\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/relax/runtime/gen/MeasuredResult;", "", "width", "", "height", "contents", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(DDLjava/util/ArrayList;)V", "getContents", "()Ljava/util/ArrayList;", "setContents", "(Ljava/util/ArrayList;)V", "getHeight", "()D", "setHeight", "(D)V", "getWidth", "setWidth", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Relax_noasanRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MeasuredResult {
    private ArrayList<String> contents;
    private double height;
    private double width;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MeasuredResult copy$default(MeasuredResult r100, double r101, double r102, ArrayList r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.width;
    L5:
        double r103 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.height;
    L8:
        double r104 = r102;
        if ((r111 & 4) == 0) goto L12;
        r110 = r100.contents;
    L12:
        return r100.copy(r103, r104, r110);
    }

    public final double component1() {
        return this.width;
    }

    public final double component2() {
        return this.height;
    }

    public final ArrayList<String> component3() {
        return this.contents;
    }

    public final MeasuredResult copy(double r100, double r110, ArrayList<String> r111) {
        Intrinsics.checkNotNullParameter(r111, "contents");
        return new MeasuredResult(r100, r110, r111);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MeasuredResult) == true) goto L8;
        return false;
    L8:
        MeasuredResult r101 = (MeasuredResult) r100;
        if (Intrinsics.areEqual(Double.valueOf(this.width), Double.valueOf(r101.width)) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(Double.valueOf(this.height), Double.valueOf(r101.height)) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.contents, r101.contents) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        long r100 = Double.doubleToLongBits(this.width);
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        long r102 = Double.doubleToLongBits(this.height);
        return ((r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31) + this.contents.hashCode();
    }

    public String toString() {
        return "MeasuredResult(width=" + this.width + ", height=" + this.height + ", contents=" + this.contents + ')';
    }

    public final ArrayList<String> getContents() {
        return this.contents;
    }

    public final double getHeight() {
        return this.height;
    }

    public final double getWidth() {
        return this.width;
    }

    public final void setContents(ArrayList<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contents = r100;
    }

    public final void setHeight(double r100) {
        this.height = r100;
    }

    public final void setWidth(double r100) {
        this.width = r100;
    }

    public MeasuredResult(double r100, double r101, ArrayList<String> r102) {
        Intrinsics.checkNotNullParameter(r102, "contents");
        this.width = r100;
        this.height = r101;
        this.contents = r102;
    }
}
