package com.ss.android.lark.profile_office.shareprofile;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.ss.android.lark.forwardv3.configuration.IForwardContent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/profile_office/shareprofile/ProfileForwardContent;", "Lcom/ss/android/lark/forwardv3/configuration/IForwardContent;", "<init>", "()V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "chatterId", "", "getChatterId", "()Ljava/lang/String;", "setChatterId", "(Ljava/lang/String;)V", CommonConstant.KEY_DISPLAY_NAME, "getDisplayName", "setDisplayName", "avatarKey", "getAvatarKey", "setAvatarKey", "writeToParcel", "", "flags", "", "describeContents", "Builder", "CREATOR", "profile-office_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileForwardContent implements IForwardContent {
    public static final b CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f438863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f438864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f438865c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f438866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f438867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f438868c;

        public a() {
            this.f438866a = "";
            this.f438867b = "";
            this.f438868c = "";
        }
    }

    public static final class b implements Parcelable.Creator<ProfileForwardContent> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileForwardContent createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ProfileForwardContent r101 = new ProfileForwardContent();
            String r102 = r100.readString();
            String r103 = "";
            if (r102 != null) goto L5;
            r102 = "";
        L5:
            r101.f438863a = r102;
            String r104 = r100.readString();
            if (r104 != null) goto L8;
            r104 = "";
        L8:
            r101.f438864b = r104;
            String r105 = r100.readString();
            if (r105 == null) goto L12;
            r103 = r105;
        L12:
            r101.f438865c = r103;
            return r101;
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileForwardContent[] newArray(int r100) {
            return new ProfileForwardContent[r100];
        }
    }

    static {
        CREATOR = new b();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public ProfileForwardContent() {
        this.f438863a = "";
        this.f438864b = "";
        this.f438865c = "";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f438863a);
        r100.writeString(this.f438864b);
        r100.writeString(this.f438865c);
    }
}
