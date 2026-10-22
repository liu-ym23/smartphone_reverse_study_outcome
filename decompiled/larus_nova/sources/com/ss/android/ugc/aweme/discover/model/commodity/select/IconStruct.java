package com.ss.android.ugc.aweme.discover.model.commodity.select;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u00012\u00020\u0002:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0018H\u0016R\"\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u0015\u0010\n\"\u0004\b\u0016\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "Ljava/io/Serializable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "height", "", "getHeight", "()Ljava/lang/Float;", "setHeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "icon", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "width", "getWidth", "setWidth", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IconStruct implements Serializable, Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("height")
    private Float height;

    @SerializedName("icon")
    private String icon;

    @SerializedName("width")
    private Float width;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<IconStruct> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final IconStruct createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new IconStruct(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final IconStruct[] newArray(int r100) {
            return new IconStruct[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public IconStruct() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final Float getHeight() {
        return this.height;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Float getWidth() {
        return this.width;
    }

    public IconStruct(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.icon = r100.readString();
        Class r101 = Float.TYPE;
        Object r102 = r100.readValue(r101.getClassLoader());
        Object r103 = null;
        if ((r102 instanceof Float) == true) goto L5;
        r102 = null;
    L5:
        this.width = (Float) r102;
        Object r104 = r100.readValue(r101.getClassLoader());
        if ((r104 instanceof Float) == false) goto L9;
        r103 = r104;
    L9:
        this.height = (Float) r103;
    }

    public final void setHeight(Float r100) {
        this.height = r100;
    }

    public final void setIcon(String r100) {
        this.icon = r100;
    }

    public final void setWidth(Float r100) {
        this.width = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.icon);
        r100.writeValue(this.width);
        r100.writeValue(this.height);
    }
}
