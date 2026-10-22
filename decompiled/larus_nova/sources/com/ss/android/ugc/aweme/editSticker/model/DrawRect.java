package com.ss.android.ugc.aweme.editSticker.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0014HÖ\u0001R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR\u001a\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/DrawRect;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "left", "", "bottom", "right", "top", "(FFFF)V", "getBottom", "()F", "setBottom", "(F)V", "getLeft", "setLeft", "getRight", "setRight", "getTop", "setTop", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class DrawRect implements Parcelable, Serializable {
    public static final Parcelable.Creator<DrawRect> CREATOR = null;
    public static final Companion Companion = null;
    private float bottom;
    private float left;
    private float right;
    private float top;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/editSticker/model/DrawRect$Companion;", "", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    public static class Creator implements Parcelable.Creator<DrawRect> {
        public Creator() {
        }

        @Override // android.os.Parcelable.Creator
        public final DrawRect createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "in");
            return new DrawRect(r100.readFloat(), r100.readFloat(), r100.readFloat(), r100.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final DrawRect[] newArray(int r100) {
            return new DrawRect[r100];
        }
    }

    static {
        Companion = new Companion(0);
        CREATOR = new Creator();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeFloat(this.left);
        r100.writeFloat(this.bottom);
        r100.writeFloat(this.right);
        r100.writeFloat(this.top);
    }

    public final float getBottom() {
        return this.bottom;
    }

    public final float getLeft() {
        return this.left;
    }

    public final float getRight() {
        return this.right;
    }

    public final float getTop() {
        return this.top;
    }

    public final void setBottom(float r100) {
        this.bottom = r100;
    }

    public final void setLeft(float r100) {
        this.left = r100;
    }

    public final void setRight(float r100) {
        this.right = r100;
    }

    public final void setTop(float r100) {
        this.top = r100;
    }

    public DrawRect(float r100, float r101, float r102, float r103) {
        this.left = r100;
        this.bottom = r101;
        this.right = r102;
        this.top = r103;
    }
}
