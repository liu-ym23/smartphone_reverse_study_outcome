package com.obric.eventkit.eventstaskmanager;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/SmsCondition;", "Lcom/obric/eventkit/eventstaskmanager/Condition;", "Landroid/os/Parcelable;", "categoryType", "", "categoryName", "content", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "getCategoryType", "getContent", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SmsCondition implements Condition, Parcelable {
    public static final Parcelable.Creator<SmsCondition> CREATOR = null;
    private final String categoryName;
    private final String categoryType;
    private final String content;

    public static final class a implements Parcelable.Creator<SmsCondition> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SmsCondition createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            SmsCondition r102 = new SmsCondition(r100.readString(), r100.readString(), r100.readString());
            int r103 = Math.min(r101, 0);
            ClassLoader r104 = a.class.getClassLoader();
            int r105 = 1;
        L3:
            if (r105 > r103) goto L5;
            r105 = r105 + 1;
        L5:
            if (r105 > r101) goto L7;
            joa.a.d(r100, r104);
            r105 = r105 + 1;
            goto L5
        L7:
            return r102;
        }

        @Override // android.os.Parcelable.Creator
        public final SmsCondition[] newArray(int r100) {
            return new SmsCondition[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public SmsCondition(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        Intrinsics.checkNotNullParameter(r101, "categoryName");
        this.categoryType = r100;
        this.categoryName = r101;
        this.content = r102;
    }

    public /* synthetic */ SmsCondition(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        this(r100, r101, r102);
    }

    public static /* synthetic */ SmsCondition copy$default(SmsCondition r100, String r101, String r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.categoryType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.categoryName;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.content;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.categoryType;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final String component3() {
        return this.content;
    }

    public final SmsCondition copy(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "categoryType");
        Intrinsics.checkNotNullParameter(r101, "categoryName");
        return new SmsCondition(r100, r101, r102);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SmsCondition) == true) goto L8;
        return false;
    L8:
        SmsCondition r101 = (SmsCondition) r100;
        if (Intrinsics.areEqual(this.categoryType, r101.categoryType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.categoryName, r101.categoryName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getCategoryType() {
        return this.categoryType;
    }

    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        int r100 = ((this.categoryType.hashCode() * 31) + this.categoryName.hashCode()) * 31;
        String r101 = this.content;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "SmsCondition(categoryType=" + this.categoryType + ", categoryName=" + this.categoryName + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.categoryType);
        r100.writeString(this.categoryName);
        r100.writeString(this.content);
    }
}
