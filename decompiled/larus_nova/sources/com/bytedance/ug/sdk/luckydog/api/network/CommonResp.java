package com.bytedance.ug.sdk.luckydog.api.network;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class CommonResp implements Parcelable {
    public static final Parcelable.Creator<CommonResp> CREATOR = null;

    @SerializedName("act_base")
    public String actBase;

    @SerializedName("act_data")
    public String actData;

    @SerializedName("act_token")
    public String actToken;

    @SerializedName("activity_infos")
    public List<ActivityInfo> activityInfos;

    @SerializedName("dynamic_settings_version")
    public long dynamicSettingsVersion;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_IS_APP_LOGIN)
    public boolean isAppLogin;

    @SerializedName("sdk_version")
    public String sdkVersion;

    @SerializedName("settings_version")
    public int settingsVersion;

    @SerializedName("static_settings_version")
    public long staticSettingsVersion;

    public static class ActivityInfo implements Parcelable {
        public static final Parcelable.Creator<ActivityInfo> CREATOR = null;

        @SerializedName("act_hash")
        public String actHash;

        @SerializedName("activity_id")
        public String activityId;

        @SerializedName("is_union_login")
        public boolean isUnionLogin;

        public static class a implements Parcelable.Creator<ActivityInfo> {
            public a() {
            }

            @Override // android.os.Parcelable.Creator
            public final ActivityInfo createFromParcel(Parcel r100) {
                return new ActivityInfo(r100);
            }

            @Override // android.os.Parcelable.Creator
            public final ActivityInfo[] newArray(int r100) {
                return new ActivityInfo[r100];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        static {
            CREATOR = new a();
        }

        public ActivityInfo(Parcel r100) {
            this.activityId = r100.readString();
            this.actHash = r100.readString();
            if (r100.readByte() == 0) goto L5;
            boolean r101 = true;
        L6:
            this.isUnionLogin = r101;
            return;
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r100, int r101) {
            r100.writeString(this.activityId);
            r100.writeString(this.actHash);
            r100.writeByte(this.isUnionLogin ? 1 : 0);
        }
    }

    public static class a implements Parcelable.Creator<CommonResp> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final CommonResp createFromParcel(Parcel r100) {
            return new CommonResp(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final CommonResp[] newArray(int r100) {
            return new CommonResp[r100];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public CommonResp(Parcel r100) {
        this.sdkVersion = r100.readString();
        this.settingsVersion = r100.readInt();
        this.actBase = r100.readString();
        this.actData = r100.readString();
        this.actToken = r100.readString();
        this.activityInfos = r100.createTypedArrayList(ActivityInfo.CREATOR);
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.isAppLogin = r101;
        this.staticSettingsVersion = r100.readLong();
        this.dynamicSettingsVersion = r100.readLong();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.sdkVersion);
        r100.writeInt(this.settingsVersion);
        r100.writeString(this.actBase);
        r100.writeString(this.actData);
        r100.writeString(this.actToken);
        r100.writeTypedList(this.activityInfos);
        r100.writeByte(this.isAppLogin ? 1 : 0);
        r100.writeLong(this.staticSettingsVersion);
        r100.writeLong(this.dynamicSettingsVersion);
    }
}
