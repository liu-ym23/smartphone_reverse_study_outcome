package com.bytedance.ee.bear.middleground_permission_export.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class ShareUserInfoResult extends Result implements Parcelable {
    public static final Parcelable.Creator<ShareUserInfoResult> CREATOR = null;
    private boolean hasMore;
    private boolean isExternal;
    private String lastLabel;
    private int totalNum;
    private ArrayList<UserInfo> userInfoList;

    public class a implements Parcelable.Creator<ShareUserInfoResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final ShareUserInfoResult createFromParcel(Parcel r100) {
            return new ShareUserInfoResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final ShareUserInfoResult[] newArray(int r100) {
            return new ShareUserInfoResult[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public String getLastLabel() {
        String r100 = this.lastLabel;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100;
    }

    public ArrayList<UserInfo> getUserInfoList() {
        ArrayList<UserInfo> r100 = this.userInfoList;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return new ArrayList();
    }

    public ShareUserInfoResult() {
        this.userInfoList = new ArrayList();
    }

    public int getTotalNum() {
        return this.totalNum;
    }

    public boolean isExternal() {
        return this.isExternal;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public ShareUserInfoResult(Parcel r100) {
        boolean r101 = true;
        if (r100.readByte() == 0) goto L5;
        boolean r102 = true;
    L6:
        this.isExternal = r102;
        this.userInfoList = r100.createTypedArrayList(UserInfo.CREATOR);
        this.totalNum = r100.readInt();
        if (r100.readByte() != 0) goto L10;
        r101 = false;
    L10:
        this.hasMore = r101;
        this.lastLabel = r100.readString();
        return;
    L5:
        r102 = false;
        goto L6
    }

    public void setExternal(boolean r100) {
        this.isExternal = r100;
    }

    public void setHasMore(boolean r100) {
        this.hasMore = r100;
    }

    public void setLastLabel(String r100) {
        this.lastLabel = r100;
    }

    public void setTotalNum(int r100) {
        this.totalNum = r100;
    }

    public void setUserInfoList(ArrayList<UserInfo> r100) {
        this.userInfoList = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeByte(this.isExternal ? 1 : 0);
        r100.writeTypedList(this.userInfoList);
        r100.writeInt(this.totalNum);
        r100.writeByte(this.hasMore ? 1 : 0);
        r100.writeString(this.lastLabel);
    }
}
