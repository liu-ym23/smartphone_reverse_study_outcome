package com.bytedance.ee.bear.document.sharewords.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;", "Landroid/os/Parcelable;", "objToken", "", "objType", "", "url", "commentEnable", "", "showCommentEntry", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getObjToken", "()Ljava/lang/String;", "getObjType", "()I", "getUrl", "getCommentEnable", "()Z", "getShowCommentEntry", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsThumbnailRequest implements Parcelable {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f221787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f221788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f221789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f221790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f221791e;

    public static final class a implements Parcelable.Creator<ShareWordsThumbnailRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareWordsThumbnailRequest createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            if (r101 != null) goto L5;
            String r102 = "";
        L6:
            int r103 = r100.readInt();
            String r104 = r100.readString();
            if (r104 != null) goto L9;
            String r105 = "";
        L11:
            if (r100.readInt() != 1) goto L13;
            boolean r106 = true;
        L15:
            if (r100.readInt() != 1) goto L17;
            boolean r107 = true;
        L19:
            return new ShareWordsThumbnailRequest(r102, r103, r105, r106, r107);
        L17:
            r107 = false;
            goto L19
        L13:
            r106 = false;
            goto L15
        L9:
            r105 = r104;
            goto L11
        L5:
            r102 = r101;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ShareWordsThumbnailRequest[] newArray(int r100) {
            return new ShareWordsThumbnailRequest[r100];
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
        if ((r100 instanceof ShareWordsThumbnailRequest) == true) goto L8;
        return false;
    L8:
        ShareWordsThumbnailRequest r101 = (ShareWordsThumbnailRequest) r100;
        if (Intrinsics.areEqual(this.f221787a, r101.f221787a) == true) goto L12;
        return false;
    L12:
        if (this.f221788b == r101.f221788b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f221789c, r101.f221789c) == true) goto L18;
        return false;
    L18:
        if (this.f221790d == r101.f221790d) goto L21;
        return false;
    L21:
        if (this.f221791e == r101.f221791e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f221787a.hashCode() * 31) + this.f221788b) * 31) + this.f221789c.hashCode()) * 31;
        int r101 = 1231;
        if (this.f221790d == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.f221791e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareWordsThumbnailRequest(objToken=" + this.f221787a + ", objType=" + this.f221788b + ", url=" + this.f221789c + ", commentEnable=" + this.f221790d + ", showCommentEntry=" + this.f221791e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f221787a);
        r100.writeInt(this.f221788b);
        r100.writeString(this.f221789c);
        r100.writeInt(this.f221790d ? 1 : 0);
        r100.writeInt(this.f221791e ? 1 : 0);
    }

    public ShareWordsThumbnailRequest(String r100, int r101, String r102, boolean r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r102, "url");
        this.f221787a = r100;
        this.f221788b = r101;
        this.f221789c = r102;
        this.f221790d = r103;
        this.f221791e = r104;
    }
}
