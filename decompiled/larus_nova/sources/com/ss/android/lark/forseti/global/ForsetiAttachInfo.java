package com.ss.android.lark.forseti.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.api.bean.ForsetiMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/forseti/global/ForsetiAttachInfo;", "Landroid/os/Parcelable;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "placeMode", "Lcom/ss/android/lark/api/bean/ForsetiMode;", "getPlaceMode", "()Lcom/ss/android/lark/api/bean/ForsetiMode;", "setPlaceMode", "(Lcom/ss/android/lark/api/bean/ForsetiMode;)V", "writeToParcel", "", "flags", "", "describeContents", "CREATOR", "forseti_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ForsetiAttachInfo implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ForsetiMode f424459a;

    public static final class a implements Parcelable.Creator<ForsetiAttachInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiAttachInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ForsetiAttachInfo r101 = new ForsetiAttachInfo();
            ForsetiMode r102 = (ForsetiMode) r100.readParcelable(ForsetiMode.class.getClassLoader());
            if (r102 != null) goto L5;
            r102 = r101.f424459a;
        L5:
            r101.f424459a = r102;
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ForsetiAttachInfo[] newArray(int r100) {
            return new ForsetiAttachInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ForsetiAttachInfo() {
        this.f424459a = ForsetiMode.Unknown;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.f424459a, r101);
    }
}
