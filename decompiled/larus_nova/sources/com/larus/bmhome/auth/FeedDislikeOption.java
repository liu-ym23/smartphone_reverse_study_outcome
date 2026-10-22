package com.larus.bmhome.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0006\u0010\u0012\u001a\u00020\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/larus/bmhome/auth/FeedDislikeOption;", "Landroid/os/Parcelable;", "starlingKey", "", "text", "alertConfig", "Lcom/larus/bmhome/auth/AlertConfig;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/bmhome/auth/AlertConfig;)V", "getStarlingKey", "()Ljava/lang/String;", "getText", "getAlertConfig", "()Lcom/larus/bmhome/auth/AlertConfig;", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedDislikeOption implements Parcelable {
    public static final Parcelable.Creator<FeedDislikeOption> CREATOR = null;

    @SerializedName("alert_config")
    private final AlertConfig alertConfig;

    @SerializedName("starling_key")
    private final String starlingKey;

    @SerializedName("text")
    private final String text;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Parcelable.Creator<FeedDislikeOption> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDislikeOption createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            String r101 = r100.readString();
            String r102 = r100.readString();
            if (r100.readInt() != 0) goto L5;
            AlertConfig r103 = null;
        L7:
            return new FeedDislikeOption(r101, r102, r103);
        L5:
            r103 = AlertConfig.CREATOR.createFromParcel(r100);
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final FeedDislikeOption[] newArray(int r100) {
            return new FeedDislikeOption[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public FeedDislikeOption() {
        this(null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FeedDislikeOption) == true) goto L8;
        return false;
    L8:
        FeedDislikeOption r101 = (FeedDislikeOption) r100;
        if (Intrinsics.areEqual(this.starlingKey, r101.starlingKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.alertConfig, r101.alertConfig) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.starlingKey;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.text;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        AlertConfig r107 = this.alertConfig;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FeedDislikeOption(starlingKey=" + this.starlingKey + ", text=" + this.text + ", alertConfig=" + this.alertConfig + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.starlingKey);
        r100.writeString(this.text);
        AlertConfig r102 = this.alertConfig;
        if (r102 != null) goto L5;
        r100.writeInt(0);
        return;
    L5:
        r100.writeInt(1);
        r102.writeToParcel(r100, r101);
    }

    public final AlertConfig a() {
        return this.alertConfig;
    }

    public final String b() {
        return this.starlingKey;
    }

    public final String c() {
        return this.text;
    }

    public FeedDislikeOption(String r100, String r101, AlertConfig r102) {
        this.starlingKey = r100;
        this.text = r101;
        this.alertConfig = r102;
    }
}
