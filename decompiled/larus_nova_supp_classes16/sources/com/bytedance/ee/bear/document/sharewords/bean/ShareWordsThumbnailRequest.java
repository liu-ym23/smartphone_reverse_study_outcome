package com.bytedance.ee.bear.document.sharewords.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J;\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020\u0005HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015¨\u0006("}, d2 = {"Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailRequest;", "Landroid/os/Parcelable;", "objToken", "", "objType", "", "url", "commentEnable", "", "showCommentEntry", "<init>", "(Ljava/lang/String;ILjava/lang/String;ZZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getObjToken", "()Ljava/lang/String;", "getObjType", "()I", "getUrl", "getCommentEnable", "()Z", "getShowCommentEntry", "describeContents", "writeToParcel", "", "dest", "flags", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "CREATOR", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareWordsThumbnailRequest implements Parcelable {
    public static final a CREATOR = null;
    public final String a;
    public final int b;
    public final String c;
    public final boolean d;
    public final boolean e;

    public static final class a implements Parcelable.Creator<ShareWordsThumbnailRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareWordsThumbnailRequest createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            Intrinsics.checkNotNullParameter(r9, "parcel");
            String r0 = r9.readString();
            if (r0 != null) goto L5;
            String r2 = "";
        L6:
            int r3 = r9.readInt();
            String r1 = r9.readString();
            if (r1 != null) goto L9;
            String r4 = "";
        L11:
            if (r9.readInt() != 1) goto L13;
            boolean r5 = true;
        L15:
            if (r9.readInt() != 1) goto L17;
            boolean r6 = true;
        L19:
            return new ShareWordsThumbnailRequest(r2, r3, r4, r5, r6);
        L17:
            r6 = false;
            goto L19
        L13:
            r5 = false;
            goto L15
        L9:
            r4 = r1;
            goto L11
        L5:
            r2 = r0;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final ShareWordsThumbnailRequest[] newArray(int r1) {
            return new ShareWordsThumbnailRequest[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ShareWordsThumbnailRequest) == true) goto L8;
        return false;
    L8:
        ShareWordsThumbnailRequest r6 = (ShareWordsThumbnailRequest) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31;
        int r2 = 1231;
        if (this.d == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.e == true) goto L11;
        r2 = 1237;
    L11:
        return r3 + r2;
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "ShareWordsThumbnailRequest(objToken=" + this.a + ", objType=" + this.b + ", url=" + this.c + ", commentEnable=" + this.d + ", showCommentEntry=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeInt(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d ? 1 : 0);
        r1.writeInt(this.e ? 1 : 0);
    }

    public ShareWordsThumbnailRequest(String r2, int r3, String r4, boolean r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "objToken");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
