package com.ss.android.lark.passport.signinsdk_api.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.passport.signinsdk_api.account.SessionInfo;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes37.dex */
public class SessionResult implements Serializable, Parcelable {
    public static final int CMD_SUCCESS_CODE = 0;
    public static final Parcelable.Creator<SessionResult> CREATOR = null;
    public boolean isOnboarding;
    public int responseCode;
    public String responseMessage;
    public Map<String, SessionInfo> sessionInfoMap;
    public String token;

    public class a implements Parcelable.Creator<SessionResult> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SessionResult createFromParcel(Parcel r100) {
            return new SessionResult(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final SessionResult[] newArray(int r100) {
            return new SessionResult[r100];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    static {
        CREATOR = new a();
    }

    public SessionResult() {
        this.sessionInfoMap = new HashMap();
    }

    public SessionResult(Parcel r100) {
        this.sessionInfoMap = new HashMap();
        this.token = r100.readString();
        r100.readMap(this.sessionInfoMap, SessionInfo.class.getClassLoader());
        boolean r101 = true;
        if (r100.readInt() == 1) goto L6;
        r101 = false;
    L6:
        this.isOnboarding = r101;
        this.responseCode = r100.readInt();
        this.responseMessage = r100.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        r100.writeString(this.token);
        r100.writeMap(this.sessionInfoMap);
        r100.writeInt(this.isOnboarding ? 1 : 0);
        r100.writeInt(this.responseCode);
        r100.writeString(this.responseMessage);
    }

    public SessionResult(String r100, Map<String, SessionInfo> r101, int r102, String r103) {
        new HashMap();
        this.token = r100;
        this.sessionInfoMap = r101;
        this.responseCode = r102;
        this.responseMessage = r103;
        this.isOnboarding = false;
    }
}
