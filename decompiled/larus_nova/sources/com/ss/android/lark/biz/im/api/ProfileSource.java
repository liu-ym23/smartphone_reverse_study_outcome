package com.ss.android.lark.biz.im.api;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u001b\u001a\u00020\u0003J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006'"}, d2 = {"Lcom/ss/android/lark/biz/im/api/ProfileSource;", "Landroid/os/Parcelable;", "sourceType", "", "senderId", "", "sourceId", "sourceName", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSourceType", "()I", "setSourceType", "(I)V", "getSenderId", "()Ljava/lang/String;", "setSenderId", "(Ljava/lang/String;)V", "getSourceId", "setSourceId", "getSourceName", "setSourceName", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProfileSource implements Parcelable {
    public static final Parcelable.Creator<ProfileSource> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f409891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f409892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f409893c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f409894d;

    public static final class a implements Parcelable.Creator<ProfileSource> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileSource createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new ProfileSource(r100.readInt(), r100.readString(), r100.readString(), r100.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final ProfileSource[] newArray(int r100) {
            return new ProfileSource[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public ProfileSource() {
        this(0, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ProfileSource) == true) goto L8;
        return false;
    L8:
        ProfileSource r101 = (ProfileSource) r100;
        if (this.f409891a == r101.f409891a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f409892b, r101.f409892b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f409893c, r101.f409893c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f409894d, r101.f409894d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f409891a * 31;
        String r101 = this.f409892b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f409893c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f409894d;
        if (r108 == null) goto L15;
        r102 = r108.hashCode();
    L15:
        return r107 + r102;
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ProfileSource(sourceType=" + this.f409891a + ", senderId=" + this.f409892b + ", sourceId=" + this.f409893c + ", sourceName=" + this.f409894d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.f409891a);
        r100.writeString(this.f409892b);
        r100.writeString(this.f409893c);
        r100.writeString(this.f409894d);
    }

    public ProfileSource(int r100, String r101, String r102, String r103) {
        this.f409891a = r100;
        this.f409892b = r101;
        this.f409893c = r102;
        this.f409894d = r103;
    }
}
