package com.larus.bmhome.chat.resp;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "old data flow")
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "Landroid/os/Parcelable;", "enableWebSearch", "", "enablePicGen", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnableWebSearch", "()Ljava/lang/Boolean;", "setEnableWebSearch", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnablePicGen", "setEnablePicGen", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/bmhome/chat/resp/BotSwitchConfInfo;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotSwitchConfInfo implements Parcelable {
    public static final Parcelable.Creator<BotSwitchConfInfo> CREATOR = null;

    @SerializedName("enable_pic_gen")
    private Boolean enablePicGen;

    @SerializedName("enable_web_search")
    private Boolean enableWebSearch;

    public static final class a implements Parcelable.Creator<BotSwitchConfInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final BotSwitchConfInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            boolean r101 = false;
            Boolean r102 = null;
            if (r100.readInt() != 0) goto L6;
            Boolean r103 = null;
        L11:
            if (r100.readInt() == 0) goto L18;
            if (r100.readInt() == 0) goto L16;
            r101 = true;
        L16:
            r102 = Boolean.valueOf(r101);
        L18:
            return new BotSwitchConfInfo(r103, r102);
        L6:
            if (r100.readInt() == 0) goto L8;
            boolean r104 = true;
        L9:
            r103 = Boolean.valueOf(r104);
            goto L11
        L8:
            r104 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public final BotSwitchConfInfo[] newArray(int r100) {
            return new BotSwitchConfInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public BotSwitchConfInfo() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BotSwitchConfInfo) == true) goto L8;
        return false;
    L8:
        BotSwitchConfInfo r101 = (BotSwitchConfInfo) r100;
        if (Intrinsics.areEqual(this.enableWebSearch, r101.enableWebSearch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enablePicGen, r101.enablePicGen) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.enableWebSearch;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.enablePicGen;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BotSwitchConfInfo(enableWebSearch=" + this.enableWebSearch + ", enablePicGen=" + this.enablePicGen + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        Boolean r102 = this.enableWebSearch;
        if (r102 != null) goto L5;
        r100.writeInt(0);
    L6:
        Boolean r103 = this.enablePicGen;
        if (r103 != null) goto L9;
        r100.writeInt(0);
        return;
    L9:
        r100.writeInt(1);
        r100.writeInt(r103.booleanValue() ? 1 : 0);
        return;
    L5:
        r100.writeInt(1);
        r100.writeInt(r102.booleanValue() ? 1 : 0);
        goto L6
    }

    public BotSwitchConfInfo(Boolean r100, Boolean r101) {
        this.enableWebSearch = r100;
        this.enablePicGen = r101;
    }
}
