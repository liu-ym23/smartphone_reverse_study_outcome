package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes18.dex */
public class WikiDetailInfo implements NonProguard, Parcelable, Cloneable {
    public static final Parcelable.Creator<WikiDetailInfo> CREATOR = null;
    private static final String TAG = "WikiDetailInfoV2";
    public String owner_id;
    public String thumbnail;

    public class a implements Parcelable.Creator<WikiDetailInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDetailInfo createFromParcel(Parcel r100) {
            return new WikiDetailInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final WikiDetailInfo[] newArray(int r100) {
            return new WikiDetailInfo[r100];
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
        WikiDetailInfo r100 = new WikiDetailInfo();
        return (WikiDetailInfo) super.clone();
    L5:
        e = move-exception;
        tt5.a.d(TAG, "clone WikiDetailInfo fail. " + e);
        return r100;
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
    public /* bridge */ /* synthetic */ Object m8345clone() throws CloneNotSupportedException {
        return clone();
    }

    public WikiDetailInfo(Parcel r100) {
        readFromParcel(r100);
    }

    public static WikiDetailInfo fromJson(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L10;
        return null;
    L10:
        return (WikiDetailInfo) new Gson().fromJson(r100, WikiDetailInfo.class);
    L7:
        e = move-exception;
        tt5.a.d(TAG, "fromJson fail: " + e);
        return null;
    }

    private void readFromParcel(Parcel r100) {
        this.owner_id = r100.readString();
        this.thumbnail = r100.readString();
    }

    public static String toJson(WikiDetailInfo r100) {
        return GsonProtectorUtils.toJson(new Gson(), r100);
    }

    public void setOwner_id(String r100) {
        this.owner_id = r100;
    }

    public void setThumbnail(String r100) {
        this.thumbnail = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.owner_id);
        r100.writeString(this.thumbnail);
    }
}
