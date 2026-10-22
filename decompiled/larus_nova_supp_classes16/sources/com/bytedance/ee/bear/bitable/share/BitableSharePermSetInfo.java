package com.bytedance.ee.bear.bitable.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.DefaultShareMeta;
import com.bytedance.ee.bear.bitable.card.viewmodel.share.ShareRecordInfo;
import com.bytedance.ee.bear.bitable.share.permission.BitableSharePermission;
import com.bytedance.ee.bear.share.IShareMeta;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÂ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0006\u0010&\u001a\u00020\u0005J\u0013\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "Landroid/os/Parcelable;", "url", "", "type", "", "token", "shareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "bitableSharePermission", "Lcom/bytedance/ee/bear/bitable/share/permission/BitableSharePermission;", "shareRecordInfo", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/share/IShareMeta;Lcom/bytedance/ee/bear/bitable/share/permission/BitableSharePermission;Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;)V", "getUrl", "()Ljava/lang/String;", "getType", "()I", "getToken", "getShareMeta", "()Lcom/bytedance/ee/bear/share/IShareMeta;", "getShareRecordInfo", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "getPublicPermission", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "setPublicPermission", "", "newPublicPermission", "canShare", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSharePermSetInfo implements Parcelable {
    public static final Parcelable.Creator<BitableSharePermSetInfo> CREATOR = null;
    public final String a;
    public final int b;
    public final String c;
    public final IShareMeta d;
    public final BitableSharePermission e;
    public final ShareRecordInfo f;

    public static final class a implements Parcelable.Creator<BitableSharePermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BitableSharePermSetInfo createFromParcel(Parcel r9) {
            Intrinsics.checkNotNullParameter(r9, "parcel");
            return new BitableSharePermSetInfo(r9.readString(), r9.readInt(), r9.readString(), r9.readSerializable(), BitableSharePermission.CREATOR.createFromParcel(r9), r9.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final BitableSharePermSetInfo[] newArray(int r1) {
            return new BitableSharePermSetInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public BitableSharePermSetInfo() {
        this(0, null, 63);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BitableSharePermSetInfo) == true) goto L8;
        return false;
    L8:
        BitableSharePermSetInfo r6 = (BitableSharePermSetInfo) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public final String toString() {
        return "BitableSharePermSetInfo(url=" + this.a + ", type=" + this.b + ", token=" + this.c + ", shareMeta=" + this.d + ", bitableSharePermission=" + this.e + ", shareRecordInfo=" + this.f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        r2.writeString(this.a);
        r2.writeInt(this.b);
        r2.writeString(this.c);
        r2.writeSerializable(this.d);
        this.e.writeToParcel(r2, r3);
        r2.writeSerializable(this.f);
    }

    public final int getType() {
        return this.b;
    }

    public BitableSharePermSetInfo(int r18, String r19, int r20) {
        if ((r20 & 1) == 0) goto L5;
        String r4 = "";
    L7:
        if ((r20 & 2) == 0) goto L9;
        int r5 = e.g.b;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r6 = "";
    L15:
        if ((r20 & 8) == 0) goto L17;
        IShareMeta r7 = new DefaultShareMeta();
    L19:
        if ((r20 & 16) == 0) goto L21;
        BitableSharePermission r8 = new BitableSharePermission(0);
    L23:
        if ((r20 & 32) == 0) goto L25;
        ShareRecordInfo r9 = new ShareRecordInfo(false, false, false, false, false, 31, null);
    L26:
        this(r4, r5, r6, r7, r8, r9);
        return;
    L25:
        r9 = null;
        goto L26
    L21:
        r8 = null;
        goto L23
    L17:
        r7 = null;
        goto L19
    L13:
        r6 = r19;
        goto L15
    L9:
        r5 = r18;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public BitableSharePermSetInfo(String r2, int r3, String r4, IShareMeta r5, BitableSharePermission r6, ShareRecordInfo r7) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r4, "token");
        Intrinsics.checkNotNullParameter(r5, "shareMeta");
        Intrinsics.checkNotNullParameter(r6, "bitableSharePermission");
        Intrinsics.checkNotNullParameter(r7, "shareRecordInfo");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
