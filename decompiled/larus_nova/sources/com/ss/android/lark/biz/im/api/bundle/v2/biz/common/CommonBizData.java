package com.ss.android.lark.biz.im.api.bundle.v2.biz.common;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_common_key")
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/common/CommonBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "extraBundle", "Landroid/os/Bundle;", "<init>", "(Landroid/os/Bundle;)V", "getExtraBundle", "()Landroid/os/Bundle;", "putInBundle", "", "bundle", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonBizData implements Parcelable {
    public static final Parcelable.Creator<CommonBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f410048a;

    public static final class a implements Parcelable.Creator<CommonBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CommonBizData(r100.readBundle(CommonBizData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final CommonBizData[] newArray(int r100) {
            return new CommonBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public CommonBizData() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CommonBizData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f410048a, ((CommonBizData) r100).f410048a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f410048a.hashCode();
    }

    public final String toString() {
        return "CommonBizData(extraBundle=" + this.f410048a + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeBundle(this.f410048a);
    }

    public CommonBizData(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "extraBundle");
        this.f410048a = r100;
    }

    public /* synthetic */ CommonBizData(int r100) {
        this(new Bundle());
    }
}
