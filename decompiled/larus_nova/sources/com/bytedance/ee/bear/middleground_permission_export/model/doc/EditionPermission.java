package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/EditionPermission;", "Landroid/os/Parcelable;", "editionUserPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "<init>", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;)V", "getEditionUserPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IEditionUserPermission;", "setEditionUserPermission", "toString", "", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditionPermission implements Parcelable {
    public static final Parcelable.Creator<EditionPermission> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IEditionUserPermission f234421a;

    public static final class a implements Parcelable.Creator<EditionPermission> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EditionPermission createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new EditionPermission((IEditionUserPermission) r100.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final EditionPermission[] newArray(int r100) {
            return new EditionPermission[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EditionPermission) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f234421a, ((EditionPermission) r100).f234421a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f234421a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeSerializable(this.f234421a);
    }

    public EditionPermission() {
        this(new DefaultEditionUserPermission());
    }

    public final String toString() {
        return "EditionPermission(editionUserPermission = " + this.f234421a + ')';
    }

    public EditionPermission(IEditionUserPermission r100) {
        Intrinsics.checkNotNullParameter(r100, "editionUserPermission");
        this.f234421a = r100;
    }
}
