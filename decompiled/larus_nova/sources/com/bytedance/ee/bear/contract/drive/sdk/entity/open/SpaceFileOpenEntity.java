package com.bytedance.ee.bear.contract.drive.sdk.entity.open;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.bear.drive.loader.download.platform.api.FileInfoPuller;
import com.bytedance.lark.pb.space.drive.v1.DriveBizScene;
import com.bytedance.lark.pb.space.drive.v1.DriveWatermarkScene;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public class SpaceFileOpenEntity extends BaseSpaceOpenEntity {
    public static final Parcelable.Creator<SpaceFileOpenEntity> CREATOR = null;
    private Map<String, String> extra;
    private String feedId;
    private boolean hasSpaceCache;
    private String hostWikiUrl;
    private String originUrl;

    @JSONField(serialize = false)
    private Bundle reminderBinder;
    private String url;

    public class a implements Parcelable.Creator<SpaceFileOpenEntity> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceFileOpenEntity createFromParcel(Parcel r100) {
            return new SpaceFileOpenEntity(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceFileOpenEntity[] newArray(int r100) {
            return new SpaceFileOpenEntity[r100];
        }
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getWikiUrl() {
        String r100 = this.hostWikiUrl;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public Map<String, String> getExtra() {
        return this.extra;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public Bundle getReminderBinder() {
        return this.reminderBinder;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isHasSpaceCache() {
        return this.hasSpaceCache;
    }

    public SpaceFileOpenEntity(Parcel r100) {
        super(r100);
        this.extra = new HashMap();
        this.url = r100.readString();
        this.originUrl = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.hasSpaceCache = r101;
        this.reminderBinder = r100.readBundle();
        this.extra = r100.readHashMap(getClass().getClassLoader());
        this.feedId = r100.readString();
        this.hostWikiUrl = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r100) {
        super.readFromParcel(r100);
        this.url = r100.readString();
        this.originUrl = r100.readString();
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.hasSpaceCache = r101;
        this.reminderBinder = r100.readBundle();
        this.extra = r100.readHashMap(getClass().getClassLoader());
        this.feedId = r100.readString();
        this.hostWikiUrl = r100.readString();
        return;
    L5:
        r101 = false;
        goto L6
    }

    public void setExtra(Map<String, String> r100) {
        this.extra = r100;
    }

    public void setFeedId(String r100) {
        this.feedId = r100;
    }

    public void setHasSpaceCache(boolean r100) {
        this.hasSpaceCache = r100;
    }

    public void setOriginUrl(String r100) {
        this.originUrl = r100;
    }

    public void setReminderBinder(Bundle r100) {
        this.reminderBinder = r100;
    }

    public void setUrl(String r100) {
        this.url = r100;
    }

    public void setWikiUrl(String r100) {
        this.hostWikiUrl = r100;
    }

    public SpaceFileOpenEntity(String r100, String r101) {
        super("2", r100, r101);
        this.extra = new HashMap();
        setBizType(2);
        setMountPoint(FileInfoPuller.CALLER_EXPLORER);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeString(this.url);
        r100.writeString(this.originUrl);
        r100.writeByte(this.hasSpaceCache ? 1 : 0);
        r100.writeBundle(this.reminderBinder);
        r100.writeMap(this.extra);
        r100.writeString(this.feedId);
        r100.writeString(this.hostWikiUrl);
    }

    public SpaceFileOpenEntity(String r100, String r101, DriveBizScene r102, DriveWatermarkScene r103) {
        super("2", r100, r101);
        this.extra = new HashMap();
        setBizType(2);
        setMountPoint(FileInfoPuller.CALLER_EXPLORER);
        setBizScene(r102);
        setWatermarkScene(r103);
    }
}
