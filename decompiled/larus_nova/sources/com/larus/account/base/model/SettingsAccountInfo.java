package com.larus.account.base.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u0010\u001a\u00020\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001e"}, d2 = {"Lcom/larus/account/base/model/SettingsAccountInfo;", "Landroid/os/Parcelable;", "baseAccountInfo", "Lcom/larus/account/base/model/SettingsBaseAccountInfo;", "connectAccountInfo", "", "Lcom/larus/account/base/model/SettingsConnectAccountInfo;", "<init>", "(Lcom/larus/account/base/model/SettingsBaseAccountInfo;Ljava/util/List;)V", "getBaseAccountInfo", "()Lcom/larus/account/base/model/SettingsBaseAccountInfo;", "getConnectAccountInfo", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SettingsAccountInfo implements Parcelable {
    public static final Parcelable.Creator<SettingsAccountInfo> CREATOR = null;

    @SerializedName("base_account_info")
    private final SettingsBaseAccountInfo baseAccountInfo;

    @SerializedName("connect_account_info")
    private final List<SettingsConnectAccountInfo> connectAccountInfo;

    public static final class a implements Parcelable.Creator<SettingsAccountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SettingsAccountInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            ArrayList r101 = null;
            if (r100.readInt() != 0) goto L5;
            SettingsBaseAccountInfo r102 = null;
        L6:
            SettingsBaseAccountInfo r103 = r102;
            if (r100.readInt() == 0) goto L18;
            int r104 = r100.readInt();
            ArrayList r105 = new ArrayList(r104);
            int r106 = 0;
        L10:
            if (r106 == r104) goto L16;
            if (r100.readInt() != 0) goto L14;
            SettingsConnectAccountInfo r107 = null;
        L15:
            r105.add(r107);
            r106 = r106 + 1;
            goto L10
        L14:
            r107 = SettingsConnectAccountInfo.CREATOR.createFromParcel(r100);
            goto L15
        L16:
            r101 = r105;
        L18:
            return new SettingsAccountInfo(r103, r101);
        L5:
            r102 = SettingsBaseAccountInfo.CREATOR.createFromParcel(r100);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final SettingsAccountInfo[] newArray(int r100) {
            return new SettingsAccountInfo[r100];
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
        if ((r100 instanceof SettingsAccountInfo) == true) goto L8;
        return false;
    L8:
        SettingsAccountInfo r101 = (SettingsAccountInfo) r100;
        if (Intrinsics.areEqual(this.baseAccountInfo, r101.baseAccountInfo) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.connectAccountInfo, r101.connectAccountInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        SettingsBaseAccountInfo r100 = this.baseAccountInfo;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<SettingsConnectAccountInfo> r104 = this.connectAccountInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SettingsAccountInfo(baseAccountInfo=" + this.baseAccountInfo + ", connectAccountInfo=" + this.connectAccountInfo + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        SettingsBaseAccountInfo r102 = this.baseAccountInfo;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        List<SettingsConnectAccountInfo> r103 = this.connectAccountInfo;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.size());
        Iterator<SettingsConnectAccountInfo> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L23;
        SettingsConnectAccountInfo r105 = r104.next();
        if (r105 == null) goto L14;
        r100.writeInt(1);
        r105.writeToParcel(r100, r101);
        goto L11
    L14:
        r100.writeInt(0);
        goto L11
    L23:
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
        goto L6
    }

    public SettingsAccountInfo() {
        this(new SettingsBaseAccountInfo(0), CollectionsKt.emptyList());
    }

    public final SettingsBaseAccountInfo a() {
        return this.baseAccountInfo;
    }

    public final List<SettingsConnectAccountInfo> b() {
        return this.connectAccountInfo;
    }

    public SettingsAccountInfo(SettingsBaseAccountInfo r100, List<SettingsConnectAccountInfo> r101) {
        this.baseAccountInfo = r100;
        this.connectAccountInfo = r101;
    }
}
