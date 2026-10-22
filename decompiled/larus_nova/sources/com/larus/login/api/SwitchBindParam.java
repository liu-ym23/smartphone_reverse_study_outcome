package com.larus.login.api;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J[\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\u0016\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006+"}, d2 = {"Lcom/larus/login/api/SwitchBindParam;", "Landroid/os/Parcelable;", "profileKey", "", "platformAppId", "platform", "enterMethod", "previousPage", "scene", "extraParams", "Landroid/os/Bundle;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "getProfileKey", "()Ljava/lang/String;", "getPlatformAppId", "getPlatform", "getEnterMethod", "getPreviousPage", "getScene", "getExtraParams", "()Landroid/os/Bundle;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SwitchBindParam implements Parcelable {
    public static final Parcelable.Creator<SwitchBindParam> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f356994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f356995b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f356996c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f356997d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f356998e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f356999f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Bundle f357000g;

    public static final class a implements Parcelable.Creator<SwitchBindParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SwitchBindParam createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            return new SwitchBindParam(r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readString(), r110.readBundle(SwitchBindParam.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public final SwitchBindParam[] newArray(int r100) {
            return new SwitchBindParam[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SwitchBindParam() {
        this(null, null, null, null, null, 127);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SwitchBindParam) == true) goto L8;
        return false;
    L8:
        SwitchBindParam r101 = (SwitchBindParam) r100;
        if (Intrinsics.areEqual(this.f356994a, r101.f356994a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f356995b, r101.f356995b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f356996c, r101.f356996c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f356997d, r101.f356997d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f356998e, r101.f356998e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f356999f, r101.f356999f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f357000g, r101.f357000g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f356994a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f356995b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f356996c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f356997d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f356998e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f356999f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return ((r115 + r101) * 31) + this.f357000g.hashCode();
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SwitchBindParam(profileKey=" + this.f356994a + ", platformAppId=" + this.f356995b + ", platform=" + this.f356996c + ", enterMethod=" + this.f356997d + ", previousPage=" + this.f356998e + ", scene=" + this.f356999f + ", extraParams=" + this.f357000g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f356994a);
        r100.writeString(this.f356995b);
        r100.writeString(this.f356996c);
        r100.writeString(this.f356997d);
        r100.writeString(this.f356998e);
        r100.writeString(this.f356999f);
        r100.writeBundle(this.f357000g);
    }

    public /* synthetic */ SwitchBindParam(String r110, String r111, String r112, String r113, String r114, int r115) {
        Bundle r100 = null;
        if ((r115 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r115 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r115 & 4) == 0) goto L13;
        String r103 = null;
    L15:
        if ((r115 & 8) == 0) goto L17;
        String r104 = null;
    L19:
        if ((r115 & 16) == 0) goto L21;
        String r105 = null;
    L23:
        if ((r115 & 64) == 0) goto L25;
        r100 = new Bundle();
    L25:
        this(r101, r102, r103, r104, r105, null, r100);
        return;
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public SwitchBindParam(String r100, String r101, String r102, String r103, String r104, String r105, Bundle r106) {
        Intrinsics.checkNotNullParameter(r106, "extraParams");
        this.f356994a = r100;
        this.f356995b = r101;
        this.f356996c = r102;
        this.f356997d = r103;
        this.f356998e = r104;
        this.f356999f = r105;
        this.f357000g = r106;
    }
}
