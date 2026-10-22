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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final SpaceFileOpenEntity createFromParcel(Parcel r2) {
            return new SpaceFileOpenEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SpaceFileOpenEntity[] newArray(int r1) {
            return new SpaceFileOpenEntity[r1];
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
        String r0 = this.hostWikiUrl;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
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

    public SpaceFileOpenEntity(Parcel r2) {
        super(r2);
        this.extra = new HashMap();
        this.url = r2.readString();
        this.originUrl = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.hasSpaceCache = r0;
        this.reminderBinder = r2.readBundle();
        this.extra = r2.readHashMap(getClass().getClassLoader());
        this.feedId = r2.readString();
        this.hostWikiUrl = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity
    public void readFromParcel(Parcel r2) {
        super.readFromParcel(r2);
        this.url = r2.readString();
        this.originUrl = r2.readString();
        if (r2.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.hasSpaceCache = r0;
        this.reminderBinder = r2.readBundle();
        this.extra = r2.readHashMap(getClass().getClassLoader());
        this.feedId = r2.readString();
        this.hostWikiUrl = r2.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setExtra(Map<String, String> r1) {
        this.extra = r1;
    }

    public void setFeedId(String r1) {
        this.feedId = r1;
    }

    public void setHasSpaceCache(boolean r1) {
        this.hasSpaceCache = r1;
    }

    public void setOriginUrl(String r1) {
        this.originUrl = r1;
    }

    public void setReminderBinder(Bundle r1) {
        this.reminderBinder = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }

    public void setWikiUrl(String r1) {
        this.hostWikiUrl = r1;
    }

    public SpaceFileOpenEntity(String r2, String r3) {
        super("2", r2, r3);
        this.extra = new HashMap();
        setBizType(2);
        setMountPoint(FileInfoPuller.CALLER_EXPLORER);
    }

    @Override // com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseSpaceOpenEntity, com.bytedance.ee.bear.contract.drive.sdk.entity.open.BaseOpenEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeString(this.url);
        r1.writeString(this.originUrl);
        r1.writeByte(this.hasSpaceCache ? 1 : 0);
        r1.writeBundle(this.reminderBinder);
        r1.writeMap(this.extra);
        r1.writeString(this.feedId);
        r1.writeString(this.hostWikiUrl);
    }

    public SpaceFileOpenEntity(String r2, String r3, DriveBizScene r4, DriveWatermarkScene r5) {
        super("2", r2, r3);
        this.extra = new HashMap();
        setBizType(2);
        setMountPoint(FileInfoPuller.CALLER_EXPLORER);
        setBizScene(r4);
        setWatermarkScene(r5);
    }
}
