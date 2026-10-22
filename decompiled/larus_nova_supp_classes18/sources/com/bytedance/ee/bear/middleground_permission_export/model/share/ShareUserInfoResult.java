package com.bytedance.ee.bear.middleground_permission_export.model.share;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.share.export.UserInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        public final ShareUserInfoResult createFromParcel(Parcel r2) {
            return new ShareUserInfoResult(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final ShareUserInfoResult[] newArray(int r1) {
            return new ShareUserInfoResult[r1];
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
        String r0 = this.lastLabel;
        if (r0 != null) goto L7;
        return "";
    L7:
        return r0;
    }

    public ArrayList<UserInfo> getUserInfoList() {
        ArrayList<UserInfo> r0 = this.userInfoList;
        if (r0 == null) goto L6;
        return r0;
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

    public ShareUserInfoResult(Parcel r4) {
        boolean r1 = true;
        if (r4.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.isExternal = r0;
        this.userInfoList = r4.createTypedArrayList(UserInfo.CREATOR);
        this.totalNum = r4.readInt();
        if (r4.readByte() != 0) goto L10;
        r1 = false;
    L10:
        this.hasMore = r1;
        this.lastLabel = r4.readString();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void setExternal(boolean r1) {
        this.isExternal = r1;
    }

    public void setHasMore(boolean r1) {
        this.hasMore = r1;
    }

    public void setLastLabel(String r1) {
        this.lastLabel = r1;
    }

    public void setTotalNum(int r1) {
        this.totalNum = r1;
    }

    public void setUserInfoList(ArrayList<UserInfo> r1) {
        this.userInfoList = r1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeByte(this.isExternal ? 1 : 0);
        r1.writeTypedList(this.userInfoList);
        r1.writeInt(this.totalNum);
        r1.writeByte(this.hasMore ? 1 : 0);
        r1.writeString(this.lastLabel);
    }
}
