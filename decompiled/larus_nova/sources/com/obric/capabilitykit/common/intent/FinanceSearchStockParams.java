package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.huawei.hms.push.constant.RemoteMessageConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/FinanceSearchStockParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "date", "", "keywords", RemoteMessageConst.Notification.TICKER, "market", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getKeywords", "setKeywords", "getMarket", "setMarket", "getTicker", "setTicker", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FinanceSearchStockParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<FinanceSearchStockParams> CREATOR = null;
    private String date;
    private String keywords;
    private String market;
    private String ticker;
    private String type;

    /* JADX INFO: loaded from: classes33.dex */
    public static final class a implements Parcelable.Creator<FinanceSearchStockParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FinanceSearchStockParams createFromParcel(Parcel r100) {
            int r101 = r100.readInt();
            Intrinsics.checkNotNullParameter(r100, "parcel");
            FinanceSearchStockParams r102 = new FinanceSearchStockParams(r100.readString(), r100.readString(), r100.readString(), r100.readString(), r100.readString());
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
        public final FinanceSearchStockParams[] newArray(int r100) {
            return new FinanceSearchStockParams[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FinanceSearchStockParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FinanceSearchStockParams copy$default(FinanceSearchStockParams r100, String r101, String r102, String r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.date;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.keywords;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.ticker;
    L11:
        String r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.market;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.type;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.date;
    }

    public final String component2() {
        return this.keywords;
    }

    public final String component3() {
        return this.ticker;
    }

    public final String component4() {
        return this.market;
    }

    public final String component5() {
        return this.type;
    }

    public final FinanceSearchStockParams copy(String r100, String r101, String r110, String r111, String r112) {
        return new FinanceSearchStockParams(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FinanceSearchStockParams) == true) goto L8;
        return false;
    L8:
        FinanceSearchStockParams r101 = (FinanceSearchStockParams) r100;
        if (Intrinsics.areEqual(this.date, r101.date) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keywords, r101.keywords) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ticker, r101.ticker) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.market, r101.market) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r100 = this.date;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.keywords;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.ticker;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.market;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.type;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "FinanceSearchStockParams(date=" + this.date + ", keywords=" + this.keywords + ", ticker=" + this.ticker + ", market=" + this.market + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeInt(0);
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        r100.writeString(this.date);
        r100.writeString(this.keywords);
        r100.writeString(this.ticker);
        r100.writeString(this.market);
        r100.writeString(this.type);
    }

    public final String getDate() {
        return this.date;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final String getMarket() {
        return this.market;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final String getType() {
        return this.type;
    }

    public IntentParams mergeParams(Object r100) {
        if ((r100 instanceof FinanceSearchStockParams) == true) goto L5;
        return this;
    L5:
        String r101 = this.date;
        if (r101 != null) goto L8;
        r101 = ((FinanceSearchStockParams) r100).date;
    L8:
        String r102 = r101;
        String r103 = this.keywords;
        if (r103 != null) goto L11;
        r103 = ((FinanceSearchStockParams) r100).keywords;
    L11:
        String r104 = r103;
        String r105 = this.ticker;
        if (r105 != null) goto L14;
        r105 = ((FinanceSearchStockParams) r100).ticker;
    L14:
        String r106 = r105;
        String r107 = this.market;
        if (r107 != null) goto L17;
        r107 = ((FinanceSearchStockParams) r100).market;
    L17:
        String r108 = r107;
        String r109 = this.type;
        if (r109 != null) goto L20;
        String r110 = ((FinanceSearchStockParams) r100).type;
    L22:
        return new FinanceSearchStockParams(r102, r104, r106, r108, r110);
    L20:
        r110 = r109;
        goto L22
    }

    public final void setDate(String r100) {
        this.date = r100;
    }

    public final void setKeywords(String r100) {
        this.keywords = r100;
    }

    public final void setMarket(String r100) {
        this.market = r100;
    }

    public final void setTicker(String r100) {
        this.ticker = r100;
    }

    public final void setType(String r100) {
        this.type = r100;
    }

    public FinanceSearchStockParams(String r100, String r101, String r102, String r103, String r104) {
        this.date = r100;
        this.keywords = r101;
        this.ticker = r102;
        this.market = r103;
        this.type = r104;
    }

    public /* synthetic */ FinanceSearchStockParams(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        String r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        String r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        String r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
