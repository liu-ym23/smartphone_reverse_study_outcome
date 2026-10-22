package com.obric.capabilitykit.sync;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/sync/EntityHashData;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityHashData implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f396299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f396300b;

    public static final class a implements Parcelable.Creator<EntityHashData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final EntityHashData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r101 != null) goto L6;
            r101 = "";
        L6:
            return new EntityHashData(r101, r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final EntityHashData[] newArray(int r100) {
            return new EntityHashData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public EntityHashData(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f396299a = r100;
        this.f396300b = r101;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f396299a);
        r100.writeInt(this.f396300b);
    }
}
