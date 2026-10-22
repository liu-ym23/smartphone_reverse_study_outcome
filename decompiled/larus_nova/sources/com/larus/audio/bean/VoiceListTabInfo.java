package com.larus.audio.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J+\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0006J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/larus/audio/bean/VoiceListTabInfo;", "Landroid/os/Parcelable;", "tabName", "", "tabKey", "recommendType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getTabName", "()Ljava/lang/String;", "getTabKey", "getRecommendType", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceListTabInfo implements Parcelable {
    public static final Parcelable.Creator<VoiceListTabInfo> CREATOR = null;

    @SerializedName("voice_recommend_type")
    private final int recommendType;

    @SerializedName("tab_key")
    private final String tabKey;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    private final String tabName;

    public static final class a implements Parcelable.Creator<VoiceListTabInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VoiceListTabInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new VoiceListTabInfo(r100.readString(), r100.readString(), r100.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final VoiceListTabInfo[] newArray(int r100) {
            return new VoiceListTabInfo[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public VoiceListTabInfo() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof VoiceListTabInfo) == true) goto L8;
        return false;
    L8:
        VoiceListTabInfo r101 = (VoiceListTabInfo) r100;
        if (Intrinsics.areEqual(this.tabName, r101.tabName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tabKey, r101.tabKey) == true) goto L15;
        return false;
    L15:
        if (this.recommendType == r101.recommendType) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.tabName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.tabKey;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return ((r103 + r101) * 31) + this.recommendType;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "VoiceListTabInfo(tabName=" + this.tabName + ", tabKey=" + this.tabKey + ", recommendType=" + this.recommendType + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.tabName);
        r100.writeString(this.tabKey);
        r100.writeInt(this.recommendType);
    }

    public final int a() {
        return this.recommendType;
    }

    public final String b() {
        return this.tabKey;
    }

    public final String c() {
        return this.tabName;
    }

    public /* synthetic */ VoiceListTabInfo(int r100) {
        this(null, null, 0);
    }

    public VoiceListTabInfo(String r100, String r101, int r102) {
        this.tabName = r100;
        this.tabKey = r101;
        this.recommendType = r102;
    }
}
