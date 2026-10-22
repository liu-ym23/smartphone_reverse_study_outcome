package com.ss.mediakit.net;

import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDNSInfo {
    public String mErrorStr;
    public long mExpiredTime;
    public String mExtraInfo;
    public JSONObject mExtraInfoJson;
    public String mHost;
    public String[] mHosts;
    public String mId;
    public String mIpList;
    public int mTaskType;
    public int mType;

    public void setDnsExtInfo(String r100, int r101) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mExtraInfoJson != null) goto L5;
        this.mExtraInfoJson = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.mExtraInfoJson.put(r100, r101);     // Catch: JSONException -> L7
        this.mExtraInfo = this.mExtraInfoJson.toString();     // Catch: JSONException -> L7
    }

    public void setDnsExtInfo(String r100, String r101) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mExtraInfoJson != null) goto L5;
        this.mExtraInfoJson = new JSONObject();     // Catch: JSONException -> L7
    L5:
        this.mExtraInfoJson.put(r100, r101);     // Catch: JSONException -> L7
        this.mExtraInfo = this.mExtraInfoJson.toString();     // Catch: JSONException -> L7
    }

    public AVMDLDNSInfo(int r100, String r101, String r102, long r103, String r104, int r105) {
        this.mType = r100;
        this.mHost = r101;
        this.mIpList = r102;
        this.mExpiredTime = r103;
        this.mId = r104;
        this.mExtraInfoJson = new JSONObject();
        this.mExtraInfo = "";
        this.mTaskType = r105;
        setDnsExtInfo(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r105);
    }

    public AVMDLDNSInfo(int r100, String[] r101, String r102, long r103, String r104, int r105) {
        this.mType = r100;
        this.mHosts = r101;
        this.mIpList = r102;
        this.mExpiredTime = r103;
        this.mId = r104;
        this.mExtraInfoJson = new JSONObject();
        this.mExtraInfo = "";
        this.mTaskType = r105;
        setDnsExtInfo(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r105);
    }

    public AVMDLDNSInfo(int r100, String r101, String r102, long r103, String r104, String r105, int r106) {
        this.mType = r100;
        this.mHost = r101;
        this.mIpList = r102;
        this.mExpiredTime = r103;
        this.mId = r104;
        this.mErrorStr = r105;
        this.mExtraInfoJson = new JSONObject();
        this.mExtraInfo = "";
        this.mTaskType = r106;
        setDnsExtInfo(AiProactiveTaskViewModel.PARAM_TASK_TYPE, r106);
    }
}
