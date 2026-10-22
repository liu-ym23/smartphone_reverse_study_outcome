package com.bytedance.ee.bear.middleground_permission_export.model.doc;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u0014\u001a\u00020\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/middleground_permission_export/model/doc/SimpleDocInfo;", "Landroid/os/Parcelable;", ResourceData.KEY_TYPE, "", ResourceData.KEY_TOKEN, "", "<init>", "(ILjava/lang/String;)V", "getType", "()I", "getToken", "()Ljava/lang/String;", "equals", "", "other", "", "hashCode", "component1", "component2", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "middleground-permission-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimpleDocInfo implements Parcelable {
    public static final Parcelable.Creator<SimpleDocInfo> CREATOR = null;
    public final int a;
    public final String b;

    public static final class a implements Parcelable.Creator<SimpleDocInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleDocInfo createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new SimpleDocInfo(r3.readInt(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final SimpleDocInfo[] newArray(int r1) {
            return new SimpleDocInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "SimpleDocInfo(type=" + this.a + ", token=" + this.b + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a);
        r1.writeString(this.b);
    }

    public SimpleDocInfo() {
        this(e.g.b, "");
    }

    public final int hashCode() {
        return (this.a * 31) + this.b.hashCode();
    }

    public final int getType() {
        return this.a;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(SimpleDocInfo.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.bytedance.ee.bear.middleground_permission_export.model.doc.SimpleDocInfo");
        SimpleDocInfo r6 = (SimpleDocInfo) r5;
        if (this.a == r6.a) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public SimpleDocInfo(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        this.a = r2;
        this.b = r3;
    }
}
