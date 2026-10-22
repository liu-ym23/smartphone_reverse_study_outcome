package com.ss.ttvideoengine.fetcher;

import android.content.Context;
import android.text.TextUtils;
import com.ss.mediakit.fetcher.AVMDLFetcherMakerInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes34.dex */
public class FetcherMaker implements AVMDLFetcherMakerInterface {
    private static final String TAG = "FetcherMaker";
    private static Hashtable<String, FetcherBase> sFallbackCenter;
    private final Context mContext;

    static {
        sFallbackCenter = new Hashtable();
    }

    public FetcherMaker() {
        this.mContext = null;
    }

    public FetcherMaker(Context r100) {
        this.mContext = r100;
    }

    public static void remove(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        sFallbackCenter.remove(r100);
    }

    @Override // com.ss.mediakit.fetcher.AVMDLFetcherMakerInterface
    public AVMDLURLFetcherInterface getFetcher(String r100, String r101, String r102) {
        TTVideoEngineLog.i(TAG, "getFetcher rawKey " + r100 + ", fileKey " + r101 + ", oldURL " + r102);
        FetcherBase r103 = sFallbackCenter.get(r100);
        if (r103 != null) goto L6;
        TTVideoEngineLog.i(TAG, "getFetcher FetcherBase is null");
        return null;
    L6:
        String r104 = r103.getKeyseed();
        String r105 = r103.getFallbackAPI();
        int r106 = r103.getVideoModelVersion();
        if (TextUtils.isEmpty(r105) == false) goto L9;
    L15:
        TTVideoEngineLog.i(TAG, "getFetcher FetcherBase is error " + r103);
        return null;
    L9:
        if (r106 != 3) goto L11;
    L13:
        MDLFetcher r107 = new MDLFetcher(this.mContext, r105, r104);
        TTVideoEngineLog.i(TAG, "return fetcher to mdl " + r107);
        return r107;
    L11:
        if (TextUtils.isEmpty(r104) == false) goto L13;
        goto L13
    }

    public static void store(String r100, String r101, String r102, int r103) {
        TTVideoEngineLog.i(TAG, "store videoId " + r100 + ", keyseed " + r101 + ", fallbackAPI " + r102 + ", version " + r103);
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L13:
        TTVideoEngineLog.i(TAG, "mdlFetch store fail");
        return;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L13;
        if (r103 != 3) goto L9;
    L11:
        sFallbackCenter.put(r100, new FetcherBase(r101, r102, r103));
        return;
    L9:
        if (TextUtils.isEmpty(r101) == false) goto L11;
        goto L11
    }
}
