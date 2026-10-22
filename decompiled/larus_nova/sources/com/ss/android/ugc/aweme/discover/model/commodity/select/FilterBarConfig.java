package com.ss.android.ugc.aweme.discover.model.commodity.select;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/FilterBarConfig;", "Landroid/os/Parcelable;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "barLeftIcon", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "getBarLeftIcon", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;", "setBarLeftIcon", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/IconStruct;)V", "", "barText", "Ljava/lang/String;", "getBarText", "()Ljava/lang/String;", "setBarText", "(Ljava/lang/String;)V", "barBtnText", "getBarBtnText", "setBarBtnText", "dataId", "getDataId", "setDataId", "<init>", "()V", "CREATOR", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FilterBarConfig implements Parcelable {
    public static final CREATOR CREATOR = null;

    @SerializedName("bar_btn_text")
    private String barBtnText;

    @SerializedName("bar_left_icon")
    private IconStruct barLeftIcon;

    @SerializedName(a.KEY_BAR_TEXT)
    private String barText;

    @SerializedName("data_id")
    private String dataId;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/FilterBarConfig$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/FilterBarConfig;", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class CREATOR implements Parcelable.Creator<FilterBarConfig> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(int r100) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public final FilterBarConfig createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return new FilterBarConfig(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final FilterBarConfig[] newArray(int r100) {
            return new FilterBarConfig[r100];
        }
    }

    static {
        CREATOR = new CREATOR(0);
    }

    public FilterBarConfig() {
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public FilterBarConfig(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        this();
        this.barLeftIcon = (IconStruct) r100.readParcelable(IconStruct.class.getClassLoader());
        this.barText = r100.readString();
        this.barBtnText = r100.readString();
        this.dataId = r100.readString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeParcelable(this.barLeftIcon, r101);
        r100.writeString(this.barText);
        r100.writeString(this.barBtnText);
        r100.writeString(this.dataId);
    }
}
