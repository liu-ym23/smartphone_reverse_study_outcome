package com.ss.android.lark.photoeditor.impl.editaction;

import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/photoeditor/impl/editaction/CropAndRotationAction;", "Lcom/ss/android/lark/photoeditor/impl/editaction/ParcelableEditAction;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "angle", "", "getAngle", "()I", "setAngle", "(I)V", "total", "Landroid/graphics/RectF;", "getTotal", "()Landroid/graphics/RectF;", "setTotal", "(Landroid/graphics/RectF;)V", "show", "getShow", "setShow", "writeToParcel", "", "flags", "describeContents", "CREATOR", "lark-photo-editor_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CropAndRotationAction implements ParcelableEditAction {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f438552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f438553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RectF f438554c;

    public static final class a implements Parcelable.Creator<CropAndRotationAction> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CropAndRotationAction createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            CropAndRotationAction r101 = new CropAndRotationAction();
            r101.f438552a = r100.readInt();
            r101.f438553b = (RectF) r100.readParcelable(RectF.class.getClassLoader());
            r101.f438554c = (RectF) r100.readParcelable(RectF.class.getClassLoader());
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final CropAndRotationAction[] newArray(int r100) {
            return new CropAndRotationAction[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CropAndRotationAction() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeInt(this.f438552a);
        r100.writeParcelable(this.f438553b, r101);
        r100.writeParcelable(this.f438554c, r101);
    }
}
