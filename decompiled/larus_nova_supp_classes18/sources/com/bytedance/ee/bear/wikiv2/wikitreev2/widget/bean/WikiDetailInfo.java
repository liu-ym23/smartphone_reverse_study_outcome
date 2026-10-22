package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class WikiDetailInfo implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<WikiDetailInfo> CREATOR = null;
    private static final String TAG = "WikiDetailInfoV2";
    public String owner_id;
    public String thumbnail;

    public class a implements Parcelable.Creator<WikiDetailInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDetailInfo createFromParcel(Parcel r2) {
            return new WikiDetailInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDetailInfo[] newArray(int r1) {
            return new WikiDetailInfo[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public WikiDetailInfo clone() {
        WikiDetailInfo r0 = new WikiDetailInfo();
        return (WikiDetailInfo) super.clone();
    L5:
        e = move-exception;
        tt5.a.d(TAG, "clone WikiDetailInfo fail. " + e);
        return r0;
    }

    public WikiDetailInfo() {
    }

    public String getOwner_id() {
        return this.owner_id;
    }

    public String getThumbnail() {
        return this.thumbnail;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m712clone() throws CloneNotSupportedException {
        return clone();
    }

    public WikiDetailInfo(Parcel r1) {
        readFromParcel(r1);
    }

    public static WikiDetailInfo fromJson(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return null;
    L10:
        return (WikiDetailInfo) new Gson().fromJson(r3, WikiDetailInfo.class);
    L7:
        e = move-exception;
        tt5.a.d(TAG, "fromJson fail: " + e);
        return null;
    }

    private void readFromParcel(Parcel r2) {
        this.owner_id = r2.readString();
        this.thumbnail = r2.readString();
    }

    public static String toJson(WikiDetailInfo r1) {
        return GsonProtectorUtils.toJson(new Gson(), r1);
    }

    public void setOwner_id(String r1) {
        this.owner_id = r1;
    }

    public void setThumbnail(String r1) {
        this.thumbnail = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeString(this.owner_id);
        r1.writeString(this.thumbnail);
    }
}
