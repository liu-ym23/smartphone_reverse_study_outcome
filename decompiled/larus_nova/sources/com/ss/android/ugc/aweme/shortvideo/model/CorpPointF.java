package com.ss.android.ugc.aweme.shortvideo.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/model/CorpPointF;", "Ljava/io/Serializable;", "x", "", "y", "(FF)V", "getX", "()F", "setX", "(F)V", "getY", "setY", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CorpPointF implements Serializable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @SerializedName("x")
    private float f454187x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @SerializedName("y")
    private float f454188y;

    public CorpPointF() {
        float r100 = 0.0f;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ CorpPointF copy$default(CorpPointF r100, float r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.f454187x;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.f454188y;
    L9:
        return r100.copy(r101, r102);
    }

    public final float component1() {
        return this.f454187x;
    }

    public final float component2() {
        return this.f454188y;
    }

    public final CorpPointF copy(float r100, float r101) {
        return new CorpPointF(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof CorpPointF) == false) goto L10;
        CorpPointF r101 = (CorpPointF) r100;
        if (Float.compare(this.f454187x, r101.f454187x) == 0) goto L8;
        return false;
    L8:
        if (Float.compare(this.f454188y, r101.f454188y) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.f454187x) * 31) + Float.floatToIntBits(this.f454188y);
    }

    public String toString() {
        return "CorpPointF(x=" + this.f454187x + ", y=" + this.f454188y + ")";
    }

    public final float getX() {
        return this.f454187x;
    }

    public final float getY() {
        return this.f454188y;
    }

    public final void setX(float r100) {
        this.f454187x = r100;
    }

    public final void setY(float r100) {
        this.f454188y = r100;
    }

    public CorpPointF(float r100, float r101) {
        this.f454187x = r100;
        this.f454188y = r101;
    }

    public /* synthetic */ CorpPointF(float r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0.0f;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.0f;
    L8:
        this(r100, r101);
    }
}
