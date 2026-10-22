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

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u001eJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\nHÂ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JE\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0006\u0010&\u001a\u00020\u0005J\u0013\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0005HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\u0016\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00060"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/BitableSharePermSetInfo;", "Landroid/os/Parcelable;", "url", "", "type", "", "token", "shareMeta", "Lcom/bytedance/ee/bear/share/IShareMeta;", "bitableSharePermission", "Lcom/bytedance/ee/bear/bitable/share/permission/BitableSharePermission;", "shareRecordInfo", "Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/ee/bear/share/IShareMeta;Lcom/bytedance/ee/bear/bitable/share/permission/BitableSharePermission;Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;)V", "getUrl", "()Ljava/lang/String;", "getType", "()I", "getToken", "getShareMeta", "()Lcom/bytedance/ee/bear/share/IShareMeta;", "getShareRecordInfo", "()Lcom/bytedance/ee/bear/bitable/card/viewmodel/share/ShareRecordInfo;", "getPublicPermission", "Lcom/bytedance/ee/bear/bitable/share/permission/IBitableSharePublicPermission;", "setPublicPermission", "", "newPublicPermission", "canShare", "", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "dest", "Landroid/os/Parcel;", "flags", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSharePermSetInfo implements Parcelable {
    public static final Parcelable.Creator<BitableSharePermSetInfo> CREATOR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f215305a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f215306b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f215307c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final IShareMeta f215308d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BitableSharePermission f215309e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ShareRecordInfo f215310f;

    public static final class a implements Parcelable.Creator<BitableSharePermSetInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BitableSharePermSetInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new BitableSharePermSetInfo(r100.readString(), r100.readInt(), r100.readString(), (IShareMeta) r100.readSerializable(), BitableSharePermission.CREATOR.createFromParcel(r100), (ShareRecordInfo) r100.readSerializable());
        }

        @Override // android.os.Parcelable.Creator
        public final BitableSharePermSetInfo[] newArray(int r100) {
            return new BitableSharePermSetInfo[r100];
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableSharePermSetInfo) == true) goto L8;
        return false;
    L8:
        BitableSharePermSetInfo r101 = (BitableSharePermSetInfo) r100;
        if (Intrinsics.areEqual(this.f215305a, r101.f215305a) == true) goto L12;
        return false;
    L12:
        if (this.f215306b == r101.f215306b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f215307c, r101.f215307c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f215308d, r101.f215308d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f215309e, r101.f215309e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f215310f, r101.f215310f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        return (((((((((this.f215305a.hashCode() * 31) + this.f215306b) * 31) + this.f215307c.hashCode()) * 31) + this.f215308d.hashCode()) * 31) + this.f215309e.hashCode()) * 31) + this.f215310f.hashCode();
    }

    public final String toString() {
        return "BitableSharePermSetInfo(url=" + this.f215305a + ", type=" + this.f215306b + ", token=" + this.f215307c + ", shareMeta=" + this.f215308d + ", bitableSharePermission=" + this.f215309e + ", shareRecordInfo=" + this.f215310f + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.f215305a);
        r100.writeInt(this.f215306b);
        r100.writeString(this.f215307c);
        r100.writeSerializable(this.f215308d);
        this.f215309e.writeToParcel(r100, r101);
        r100.writeSerializable(this.f215310f);
    }

    public final int getType() {
        return this.f215306b;
    }

    public BitableSharePermSetInfo(int r110, String r111, int r210) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r210 & 2) == 0) goto L9;
        int r101 = e.f541296g.f541317b;
    L11:
        if ((r210 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r210 & 8) == 0) goto L17;
        DefaultShareMeta r103 = new DefaultShareMeta();
    L19:
        if ((r210 & 16) == 0) goto L21;
        BitableSharePermission r104 = new BitableSharePermission(0);
    L23:
        if ((r210 & 32) == 0) goto L25;
        ShareRecordInfo r105 = new ShareRecordInfo(false, false, false, false, false, 31, null);
    L26:
        this(r100, r101, r102, r103, r104, r105);
        return;
    L25:
        r105 = null;
        goto L26
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r111;
        goto L15
    L9:
        r101 = r110;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public BitableSharePermSetInfo(String r100, int r101, String r102, IShareMeta r103, BitableSharePermission r104, ShareRecordInfo r105) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r102, "token");
        Intrinsics.checkNotNullParameter(r103, "shareMeta");
        Intrinsics.checkNotNullParameter(r104, "bitableSharePermission");
        Intrinsics.checkNotNullParameter(r105, "shareRecordInfo");
        this.f215305a = r100;
        this.f215306b = r101;
        this.f215307c = r102;
        this.f215308d = r103;
        this.f215309e = r104;
        this.f215310f = r105;
    }
}
