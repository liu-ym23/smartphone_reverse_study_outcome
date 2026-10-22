package com.ss.android.ugc.aweme.sticker;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\t\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\bJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001dH\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\f¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/CustomizedPropInfo;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "businessExtra", "", "getBusinessExtra", "()Ljava/lang/String;", "setBusinessExtra", "(Ljava/lang/String;)V", "customizedPropIconPath", "getCustomizedPropIconPath", "setCustomizedPropIconPath", "customizedPropId", "getCustomizedPropId", "setCustomizedPropId", "customizedPropPath", "getCustomizedPropPath", "setCustomizedPropPath", "diyType", "getDiyType", "setDiyType", "templatePropId", "getTemplatePropId", "setTemplatePropId", "describeContents", "", "", "key", "writeToParcel", "", "flags", "CREATOR", "lib-api_release"}, k = 1, mv = {1, 4, 1})
public final class CustomizedPropInfo implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;
    private String businessExtra;
    private String customizedPropIconPath;
    private String customizedPropId;
    private String customizedPropPath;
    private String diyType;
    private String templatePropId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/sticker/CustomizedPropInfo$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/sticker/CustomizedPropInfo;", "<init>", "()V", "lib-api_release"}, k = 1, mv = {1, 4, 1})
    public static final class CREATOR implements Parcelable.Creator<CustomizedPropInfo> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final CustomizedPropInfo createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new CustomizedPropInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CustomizedPropInfo[] newArray(int r100) {
            return new CustomizedPropInfo[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public CustomizedPropInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getBusinessExtra() {
        return this.businessExtra;
    }

    public final String getCustomizedPropIconPath() {
        return this.customizedPropIconPath;
    }

    public final String getCustomizedPropId() {
        return this.customizedPropId;
    }

    public final String getCustomizedPropPath() {
        return this.customizedPropPath;
    }

    public final String getDiyType() {
        return this.diyType;
    }

    public final String getTemplatePropId() {
        return this.templatePropId;
    }

    public CustomizedPropInfo(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.templatePropId = r100.readString();
        this.customizedPropId = r100.readString();
        this.customizedPropIconPath = r100.readString();
        this.customizedPropPath = r100.readString();
        this.diyType = r100.readString();
        this.businessExtra = r100.readString();
    }

    public final Object getBusinessExtra(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        String r101 = this.businessExtra;
        if (r101 == null) goto L9;
        return new JSONObject(r101).opt(r100);
    L10:
        return null;
    L9:
        return null;
    }

    public final void setBusinessExtra(String r100) {
        this.businessExtra = r100;
    }

    public final void setCustomizedPropIconPath(String r100) {
        this.customizedPropIconPath = r100;
    }

    public final void setCustomizedPropId(String r100) {
        this.customizedPropId = r100;
    }

    public final void setCustomizedPropPath(String r100) {
        this.customizedPropPath = r100;
    }

    public final void setDiyType(String r100) {
        this.diyType = r100;
    }

    public final void setTemplatePropId(String r100) {
        this.templatePropId = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.templatePropId);
        r100.writeString(this.customizedPropId);
        r100.writeString(this.customizedPropIconPath);
        r100.writeString(this.customizedPropPath);
        r100.writeString(this.diyType);
        r100.writeString(this.businessExtra);
    }
}
