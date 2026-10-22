package com.ss.android.lark.passport.signinsdk_api.account;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.fastjson.annotation.JSONField;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import java.io.Serializable;

/* JADX INFO: loaded from: classes37.dex */
public class SessionInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<SessionInfo> CREATOR = null;
    private String hostUrl;

    @JSONField(alternateNames = {"value", AppbrandHostConstants.SCHEMA_INSPECT.SESSION})
    private String session;

    @JSONField(alternateNames = {"name", InteractConst.WAKEUP_SESSION_NAME})
    private String sessionName;

    public class a implements Parcelable.Creator<SessionInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SessionInfo createFromParcel(Parcel r100) {
            return new SessionInfo(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SessionInfo[] newArray(int r100) {
            return new SessionInfo[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SessionInfo() {
    }

    public String getHostUrl() {
        return this.hostUrl;
    }

    public String getSession() {
        return this.session;
    }

    public String getSessionName() {
        return this.sessionName;
    }

    public SessionInfo(Parcel r100) {
        this.hostUrl = r100.readString();
        this.sessionName = r100.readString();
        this.session = r100.readString();
    }

    public void setHostUrl(String r100) {
        this.hostUrl = r100;
    }

    public void setSession(String r100) {
        this.session = r100;
    }

    public void setSessionName(String r100) {
        this.sessionName = r100;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.hostUrl);
        r100.writeString(this.sessionName);
        r100.writeString(this.session);
    }

    public SessionInfo(String r100, String r101, String r102) {
        this.hostUrl = r100;
        this.sessionName = r101;
        this.session = r102;
    }
}
