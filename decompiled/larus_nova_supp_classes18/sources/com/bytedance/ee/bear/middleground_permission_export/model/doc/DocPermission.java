package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006!"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/DocPermission;", "Landroid/os/Parcelable;", "userPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "publicPermission", "Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "<init>", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;)V", "getUserPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;", "setUserPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocUserPermission;)V", "getPublicPermission", "()Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;", "setPublicPermission", "(Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/IDocPublicPermission;)V", "toString", "", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-export-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocPermission implements Parcelable {
    public static final Parcelable.Creator<DocPermission> CREATOR = null;
    public IDocUserPermission a;
    public IDocPublicPermission b;

    public static final class a implements Parcelable.Creator<DocPermission> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermission createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new DocPermission((IDocUserPermission) r3.readSerializable(), (IDocPublicPermission) r3.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final DocPermission[] newArray(int r1) {
            return new DocPermission[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public DocPermission() {
        this(null, 3);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DocPermission) == true) goto L8;
        return false;
    L8:
        DocPermission r6 = (DocPermission) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeSerializable(this.a);
        r1.writeSerializable(this.b);
    }

    public final String toString() {
        return "DocPermission(docUserPermission=" + this.a + ", docPublicPermission=" + this.b + ')';
    }

    public /* synthetic */ DocPermission(IDocUserPermission r2, int r3) {
        if ((r3 & 1) == 0) goto L6;
        r2 = new DefaultDocUserPermission();
    L6:
        if ((r3 & 2) == 0) goto L8;
        DefaultDocPublicPermission r4 = new DefaultDocPublicPermission();
    L9:
        this(r2, r4);
        return;
    L8:
        r4 = null;
        goto L9
    }

    public DocPermission(IDocUserPermission r2, IDocPublicPermission r3) {
        Intrinsics.checkNotNullParameter(r2, "userPermission");
        Intrinsics.checkNotNullParameter(r3, "publicPermission");
        this.a = r2;
        this.b = r3;
    }
}
