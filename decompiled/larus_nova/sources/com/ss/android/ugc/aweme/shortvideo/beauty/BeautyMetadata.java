package com.ss.android.ugc.aweme.shortvideo.beauty;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001aH\u0016R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001e\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001e\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001e\u0010\u0016\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006!"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautyMetadata;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "beautyId", "", "getBeautyId", "()Ljava/lang/String;", "setBeautyId", "(Ljava/lang/String;)V", "beautyName", "getBeautyName", "setBeautyName", "beautyRes", "getBeautyRes", "setBeautyRes", "beautyStrength", "getBeautyStrength", "setBeautyStrength", "beautyValid", "getBeautyValid", "setBeautyValid", "describeContents", "", "toString", "writeToParcel", "", "dest", "flags", "CREATOR", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class BeautyMetadata implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("te_record_beauty_id")
    private String beautyId;

    @SerializedName("te_record_beauty_name")
    private String beautyName;

    @SerializedName("te_record_beauty_res")
    private String beautyRes;

    @SerializedName("te_record_beauty_strength")
    private String beautyStrength;

    @SerializedName("te_record_beauty_res_valid")
    private String beautyValid;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautyMetadata$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/shortvideo/beauty/BeautyMetadata;", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class CREATOR implements Parcelable.Creator<BeautyMetadata> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final BeautyMetadata createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new BeautyMetadata(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final BeautyMetadata[] newArray(int r100) {
            return new BeautyMetadata[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BeautyMetadata:id=" + this.beautyId + ",name=" + this.beautyName + ",strength=" + this.beautyStrength + ",res=" + this.beautyRes + ",valid=" + this.beautyValid;
    }

    public BeautyMetadata() {
        this.beautyName = "";
        this.beautyStrength = "";
        this.beautyId = "";
        this.beautyRes = "";
        this.beautyValid = "";
    }

    public final String getBeautyId() {
        return this.beautyId;
    }

    public final String getBeautyName() {
        return this.beautyName;
    }

    public final String getBeautyRes() {
        return this.beautyRes;
    }

    public final String getBeautyStrength() {
        return this.beautyStrength;
    }

    public final String getBeautyValid() {
        return this.beautyValid;
    }

    public BeautyMetadata(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        String r101 = r100.readString();
        String r102 = "";
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        this.beautyName = r101;
        String r103 = r100.readString();
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        this.beautyStrength = r103;
        String r104 = r100.readString();
        if (r104 != null) goto L14;
        r104 = "";
    L14:
        this.beautyId = r104;
        String r105 = r100.readString();
        if (r105 != null) goto L18;
        r105 = "";
    L18:
        this.beautyRes = r105;
        String r106 = r100.readString();
        if (r106 == null) goto L21;
        r102 = r106;
    L21:
        this.beautyValid = r102;
    }

    public final void setBeautyId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beautyId = r100;
    }

    public final void setBeautyName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beautyName = r100;
    }

    public final void setBeautyRes(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beautyRes = r100;
    }

    public final void setBeautyStrength(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beautyStrength = r100;
    }

    public final void setBeautyValid(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.beautyValid = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeString(this.beautyName);
        r100.writeString(this.beautyStrength);
        r100.writeString(this.beautyId);
        r100.writeString(this.beautyRes);
        r100.writeString(this.beautyValid);
    }
}
