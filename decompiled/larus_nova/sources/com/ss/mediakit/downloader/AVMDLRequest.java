package com.ss.mediakit.downloader;

import java.util.HashMap;
import okhttp3.Response;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLRequest {
    public static final int UrlStateIsForbidden = 1;
    public static final int UrlStateIsNormal = 0;
    public HashMap<String, String> headers;
    public int mCurlUrlIndex;
    public int mMaxTryCout;
    public int mOpenTimeOut;
    public int mRWTimeOut;
    public int[] mUrlErrCount;
    public int[] mUrlState;
    public long reqOff;
    public Response response;
    public long size;
    public String[] urls;

    public AVMDLRequest() {
        this.urls = null;
        this.headers = new HashMap();
        this.reqOff = -1;
        this.size = 0;
        this.response = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
    }

    public AVMDLRequest(long r100, long r101, String[] r102, HashMap<String, String> r103) {
        this.urls = r102;
        this.headers = r103;
        this.reqOff = r100;
        this.size = r101;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = 0;
        this.mOpenTimeOut = 10;
        this.mRWTimeOut = 10;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L12;
        this.mUrlState = new int[r102.length];
        int r104 = 0;
    L7:
        int[] r105 = this.mUrlState;
        if (r104 >= r105.length) goto L13;
        r105[r104] = 0;
        r104 = r104 + 1;
        goto L7
    L13:
        return;
    }

    public AVMDLRequest(long r100, long r101, String[] r102, Object r103, int r104, int r105, int r106) {
        this.urls = r102;
        this.headers = (HashMap) r103;
        this.reqOff = r100;
        this.size = r101;
        this.response = null;
        this.mUrlState = null;
        this.mCurlUrlIndex = 0;
        this.mMaxTryCout = r104;
        this.mOpenTimeOut = r105;
        this.mRWTimeOut = r106;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.length <= 0) goto L17;
        this.mUrlState = new int[r102.length];
        int r107 = 0;
    L7:
        int[] r108 = this.mUrlState;
        if (r107 >= r108.length) goto L10;
        r108[r107] = 0;
        r107 = r107 + 1;
        goto L7
    L10:
        this.mUrlErrCount = new int[this.urls.length];
        int r109 = 0;
    L11:
        int[] r110 = this.mUrlErrCount;
        if (r109 >= r110.length) goto L18;
        r110[r109] = 0;
        r109 = r109 + 1;
        goto L11
    L18:
        return;
    }
}
