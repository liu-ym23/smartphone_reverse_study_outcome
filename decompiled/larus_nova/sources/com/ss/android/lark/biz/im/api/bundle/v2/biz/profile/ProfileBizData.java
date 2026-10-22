package com.ss.android.lark.biz.im.api.bundle.v2.biz.profile;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.biz.im.api.bundle.v2.annotation.BundleKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@BundleKey("data_profile_key")
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0013\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001J\u0016\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0019R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006#"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/v2/biz/profile/ProfileBizData;", "Landroid/os/Parcelable;", "Lcom/ss/android/lark/biz/im/api/bundle/v2/base/IBundle;", "isShowGroupProfile", "", "isCloudApply", "showApplyChat", "optionLinkUrl", "", "<init>", "(ZZZLjava/lang/String;)V", "()Z", "getShowApplyChat", "getOptionLinkUrl", "()Ljava/lang/String;", "putInBundle", "", "bundle", "Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileBizData implements Parcelable {
    public static final Parcelable.Creator<ProfileBizData> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f410052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f410053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f410054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f410055d;

    public static final class a implements Parcelable.Creator<ProfileBizData> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileBizData createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            if (r100.readInt() == 0) goto L5;
            boolean r102 = true;
        L7:
            if (r100.readInt() == 0) goto L9;
            boolean r103 = true;
        L11:
            if (r100.readInt() == 0) goto L14;
            r101 = true;
        L14:
            return new ProfileBizData(r102, r103, r101, r100.readString());
        L9:
            r103 = false;
            goto L11
        L5:
            r102 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileBizData[] newArray(int r100) {
            return new ProfileBizData[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProfileBizData() {
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
        if ((r100 instanceof ProfileBizData) == true) goto L8;
        return false;
    L8:
        ProfileBizData r101 = (ProfileBizData) r100;
        if (this.f410052a == r101.f410052a) goto L12;
        return false;
    L12:
        if (this.f410053b == r101.f410053b) goto L15;
        return false;
    L15:
        if (this.f410054c == r101.f410054c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f410055d, r101.f410055d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.f410052a == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.f410053b == false) goto L9;
        int r103 = 1231;
    L10:
        int r104 = (r102 + r103) * 31;
        if (this.f410054c == true) goto L14;
        r100 = 1237;
    L14:
        int r105 = (r104 + r100) * 31;
        String r106 = this.f410055d;
        if (r106 != null) goto L17;
        int r107 = 0;
    L19:
        return r105 + r107;
    L17:
        r107 = r106.hashCode();
        goto L19
    L9:
        r103 = 1237;
        goto L10
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ProfileBizData(isShowGroupProfile=" + this.f410052a + ", isCloudApply=" + this.f410053b + ", showApplyChat=" + this.f410054c + ", optionLinkUrl=" + this.f410055d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f410052a ? 1 : 0);
        r100.writeInt(this.f410053b ? 1 : 0);
        r100.writeInt(this.f410054c ? 1 : 0);
        r100.writeString(this.f410055d);
    }

    public /* synthetic */ ProfileBizData(int r100) {
        this(false, false, false, null);
    }

    public ProfileBizData(boolean r100, boolean r101, boolean r102, String r103) {
        this.f410052a = r100;
        this.f410053b = r101;
        this.f410054c = r102;
        this.f410055d = r103;
    }
}
