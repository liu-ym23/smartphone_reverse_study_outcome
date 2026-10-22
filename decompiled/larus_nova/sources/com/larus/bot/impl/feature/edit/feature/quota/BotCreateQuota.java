package com.larus.bot.impl.feature.edit.feature.quota;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J?\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0006\u0010\u001a\u001a\u00020\u0005J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\bHÖ\u0001J\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006%"}, d2 = {"Lcom/larus/bot/impl/feature/edit/feature/quota/BotCreateQuota;", "Landroid/os/Parcelable;", "limitEnabled", "", "totalQuota", "", "usedQuota", "limitedMsg", "", "tipsContent", "<init>", "(ZIILjava/lang/String;Ljava/lang/String;)V", "getLimitEnabled", "()Z", "getTotalQuota", "()I", "getUsedQuota", "getLimitedMsg", "()Ljava/lang/String;", "getTipsContent", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotCreateQuota implements Parcelable {
    public static final Parcelable.Creator<BotCreateQuota> CREATOR = null;

    @SerializedName("limited")
    private final boolean limitEnabled;

    @SerializedName("limited_msg")
    private final String limitedMsg;

    @SerializedName("tips_content")
    private final String tipsContent;

    @SerializedName("total_quota")
    private final int totalQuota;

    @SerializedName("used_quota")
    private final int usedQuota;

    public static final class a implements Parcelable.Creator<BotCreateQuota> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreateQuota createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            if (r100.readInt() == 0) goto L5;
            boolean r101 = true;
        L7:
            return new BotCreateQuota(r101, r100.readInt(), r100.readInt(), r100.readString(), r100.readString());
        L5:
            r101 = false;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final BotCreateQuota[] newArray(int r100) {
            return new BotCreateQuota[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotCreateQuota() {
        this(false, 0, 0, null, null, 31, null);
    }

    public static /* synthetic */ BotCreateQuota copy$default(BotCreateQuota r100, boolean r101, int r102, int r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.limitEnabled;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.totalQuota;
    L8:
        int r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.usedQuota;
    L11:
        int r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.limitedMsg;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.tipsContent;
    L17:
        boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final boolean component1() {
        return this.limitEnabled;
    }

    public final int component2() {
        return this.totalQuota;
    }

    public final int component3() {
        return this.usedQuota;
    }

    public final String component4() {
        return this.limitedMsg;
    }

    public final String component5() {
        return this.tipsContent;
    }

    public final BotCreateQuota copy(boolean r100, int r101, int r110, String r111, String r112) {
        return new BotCreateQuota(r100, r101, r110, r111, r112);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotCreateQuota) == true) goto L8;
        return false;
    L8:
        BotCreateQuota r101 = (BotCreateQuota) r100;
        if (this.limitEnabled == r101.limitEnabled) goto L12;
        return false;
    L12:
        if (this.totalQuota == r101.totalQuota) goto L15;
        return false;
    L15:
        if (this.usedQuota == r101.usedQuota) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.limitedMsg, r101.limitedMsg) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.tipsContent, r101.tipsContent) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        if (this.limitEnabled == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((((r100 * 31) + this.totalQuota) * 31) + this.usedQuota) * 31;
        String r102 = this.limitedMsg;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.tipsContent;
        if (r106 == null) goto L15;
        r103 = r106.hashCode();
    L15:
        return r105 + r103;
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "BotCreateQuota(limitEnabled=" + this.limitEnabled + ", totalQuota=" + this.totalQuota + ", usedQuota=" + this.usedQuota + ", limitedMsg=" + this.limitedMsg + ", tipsContent=" + this.tipsContent + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.limitEnabled ? 1 : 0);
        r100.writeInt(this.totalQuota);
        r100.writeInt(this.usedQuota);
        r100.writeString(this.limitedMsg);
        r100.writeString(this.tipsContent);
    }

    public final boolean getLimitEnabled() {
        return this.limitEnabled;
    }

    public final String getLimitedMsg() {
        return this.limitedMsg;
    }

    public final String getTipsContent() {
        return this.tipsContent;
    }

    public final int getTotalQuota() {
        return this.totalQuota;
    }

    public final int getUsedQuota() {
        return this.usedQuota;
    }

    public BotCreateQuota(boolean r100, int r101, int r102, String r103, String r104) {
        this.limitEnabled = r100;
        this.totalQuota = r101;
        this.usedQuota = r102;
        this.limitedMsg = r103;
        this.tipsContent = r104;
    }

    public /* synthetic */ BotCreateQuota(boolean r100, int r101, int r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
        int r106 = 0;
        if ((r105 & 1) == 0) goto L5;
        boolean r111 = false;
    L7:
        if ((r105 & 2) == 0) goto L9;
        int r107 = 0;
    L11:
        if ((r105 & 4) != 0) goto L15;
        r106 = r102;
    L15:
        if ((r105 & 8) == 0) goto L17;
        String r108 = "";
    L19:
        if ((r105 & 16) == 0) goto L21;
        String r109 = "";
    L22:
        this(r111, r107, r106, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
