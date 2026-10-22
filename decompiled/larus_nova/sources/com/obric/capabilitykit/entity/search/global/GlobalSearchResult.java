package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchResult;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class GlobalSearchResult implements Parcelable {
    public static final a CREATOR = null;

    public static final class a implements Parcelable.Creator<GlobalSearchResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchResult createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return (GlobalSearchResult) GsonProtectorUtils.fromJson(EntityExtKt.a(), r100.readString(), GlobalSearchResult.class);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchResult[] newArray(int r100) {
            return new GlobalSearchResult[r100];
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
        if ((r100 instanceof GlobalSearchResult) == true) goto L8;
        return false;
    L8:
        ((GlobalSearchResult) r100).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "GlobalSearchResult(entityType=0, entities=null, sequence=0)";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(GsonProtectorUtils.toJson(EntityExtKt.a(), this));
    }
}
