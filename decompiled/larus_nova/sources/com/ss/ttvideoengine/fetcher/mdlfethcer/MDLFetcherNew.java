package com.ss.ttvideoengine.fetcher.mdlfethcer;

import android.content.Context;
import android.text.TextUtils;
import com.ss.mediakit.fetcher.AVMDLURLFetcherInterface;
import com.ss.mediakit.fetcher.AVMDLURLFetcherListener;
import com.ss.ttvideoengine.VideoModelCache;
import com.ss.ttvideoengine.fetcher.VideoInfoFetcher;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes34.dex */
public class MDLFetcherNew implements AVMDLURLFetcherInterface {
    private static final int CALLBACK_URLS_TO_MDL = 0;
    private static final int MDL_GET_URLS = 1;
    private static final String TAG = "MDLFetcherNew";
    private VideoInfoFetcher mFetcher;
    private String mFileHash;
    private AVMDLURLFetcherListener mListener;
    private WeakReference<MDLFetcherListener> mMDLFetcherListener;
    private String[] mNewUrls;
    private String mOldUrl;
    private String mVideoID;
    private VideoModel mVideoModel;

    public static class MyFetcherListener implements VideoInfoFetcher.FetcherListener {
        private final WeakReference<MDLFetcherNew> mFetcherRef;

        public MyFetcherListener(MDLFetcherNew r100) {
            this.mFetcherRef = new WeakReference(r100);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onLog(String r100) {
            MDLFetcherNew r101 = this.mFetcherRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (MDLFetcherNew.access$000(r101) == null) goto L10;
            MDLFetcherNew.access$000(r101).onLog(r100);
            return;
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onRetry(Error r100) {
            MDLFetcherNew r101 = this.mFetcherRef.get();
            if (r101 != null) goto L5;
            return;
        L5:
            if (MDLFetcherNew.access$000(r101) == null) goto L10;
            MDLFetcherNew.access$000(r101).onRetry(r100);
            return;
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onCompletion(VideoModel r100, Error r101) {
            TTVideoEngineLog.i(MDLFetcherNew.TAG, "onCompletion model " + r100 + ", error " + r101);
            MDLFetcherNew r102 = this.mFetcherRef.get();
            if (r102 != null) goto L7;
            TTVideoEngineLog.i(MDLFetcherNew.TAG, "onCompletion but fetcher is null");
            return;
        L7:
            if (r101 == null) goto L11;
            MDLFetcherNew.access$100(r102, r101, true);
            return;
        L11:
            if (r100 != null) goto L14;
            MDLFetcherNew.access$100(r102, new Error(Error.MDLRetry, Error.ResultEmpty, "fetch empty"), true);
            return;
        L14:
            MDLFetcherNew.access$202(r102, MDLFetcherNew.access$400(r102, r100, MDLFetcherNew.access$300(r102)));
            TTVideoEngineLog.i(MDLFetcherNew.TAG, "onCompletion newUrls " + Arrays.toString(MDLFetcherNew.access$200(r102)));
            if (MDLFetcherNew.access$200(r102) != null) goto L17;
        L24:
            MDLFetcherNew.access$100(r102, new Error(Error.MDLRetry, -10003, "file hash invalid"), true);
            JSONObject r103 = r100.getMediaInfo();
            if (r103 == null) goto L29;
            TTVideoEngineLog.i(MDLFetcherNew.TAG, String.format("new video model: %s", new Object[]{r103.toString()}));
            return;
        L29:
            return;
        L17:
            if (MDLFetcherNew.access$200(r102).length == 0) goto L24;
            if (MDLFetcherNew.access$600(MDLFetcherNew.access$200(r102), MDLFetcherNew.access$500(r102)) == false) goto L22;
            MDLFetcherNew.access$800(r102).onCompletion(0, MDLFetcherNew.access$700(r102), MDLFetcherNew.access$300(r102), MDLFetcherNew.access$200(r102));
            MDLFetcherNew.access$900(r102, r100, true);
            return;
        L22:
            MDLFetcherNew.access$100(r102, new Error(Error.MDLRetry, -10004, "fetch videoModel is expired"), true);
        }

        @Override // com.ss.ttvideoengine.fetcher.VideoInfoFetcher.FetcherListener
        public void onStatusException(int r100, String r101) {
            MDLFetcherNew r102 = this.mFetcherRef.get();
            if (r102 != null) goto L6;
            TTVideoEngineLog.i(MDLFetcherNew.TAG, "onStatusException but fetcher is null");
            return;
        L6:
            MDLFetcherNew.access$100(r102, new Error(Error.MDLRetry, -10005, r100, r101), true);
        }
    }

    private MDLFetcherListener getMDLFetcherListener() {
        WeakReference<MDLFetcherListener> r100 = this.mMDLFetcherListener;
        if (r100 != null) goto L7;
        TTVideoEngineLog.d(TAG, "getMDLFetcherListener is null");
        return null;
    L7:
        return r100.get();
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public void close() {
        VideoInfoFetcher r100 = this.mFetcher;
        if (r100 == null) goto L5;
        r100.cancel();
        this.mFetcher = null;
    L5:
        this.mMDLFetcherListener = null;
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public String[] getURLs() {
        TTVideoEngineLog.i(TAG, "mdl getURLs " + Arrays.toString(this.mNewUrls));
        return this.mNewUrls;
    }

    public MDLFetcherNew(MDLFetcherListener r100) {
        this.mNewUrls = null;
        this.mMDLFetcherListener = new WeakReference(r100);
    }

    public static /* synthetic */ MDLFetcherListener access$000(MDLFetcherNew r100) {
        return r100.getMDLFetcherListener();
    }

    public static /* synthetic */ String[] access$200(MDLFetcherNew r100) {
        return r100.mNewUrls;
    }

    public static /* synthetic */ String access$300(MDLFetcherNew r100) {
        return r100.mFileHash;
    }

    public static /* synthetic */ String access$500(MDLFetcherNew r100) {
        return r100.mOldUrl;
    }

    public static /* synthetic */ String access$700(MDLFetcherNew r100) {
        return r100.mVideoID;
    }

    public static /* synthetic */ AVMDLURLFetcherListener access$800(MDLFetcherNew r100) {
        return r100.mListener;
    }

    public static /* synthetic */ String[] access$202(MDLFetcherNew r100, String[] r101) {
        r100.mNewUrls = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$600(String[] r100, String r101) {
        return isNewUrlsValid(r100, r101);
    }

    private String[] getURLsFromCache(String r100, String r101) {
        VideoModelCache.VideoModelCacheInfo r102 = VideoModelCache.getInstance().get(this.mVideoID, r100);
        if (r102 != null) goto L5;
    L20:
        TTVideoEngineLog.i(TAG, "getURLsFromCache cacheInfo is null or isExpired");
        return null;
    L5:
        if (r102.isExpired == true) goto L20;
        VideoModel r103 = r102.model;
        this.mVideoModel = r103;
        String[] r104 = getUrlsFromVideoModelByFileHash(r103, this.mFileHash);
        if (r104 != null) goto L10;
    L18:
        TTVideoEngineLog.i(TAG, "getURLsFromCache temUrls is null");
        return null;
    L10:
        if (r104.length <= 0) goto L18;
        if (isNewUrlsValid(r104, r101) == true) goto L16;
        VideoModelCache.getInstance().remove(this.mVideoID, r100);
        TTVideoEngineLog.i(TAG, "getURLsFromCache urls is invalid");
        return null;
    L16:
        TTVideoEngineLog.i(TAG, "getURLsFromCache " + Arrays.toString(r104));
        return r104;
    }

    private String[] getUrlsFromVideoModelByFileHash(VideoModel r100, String r101) {
        if (r100 != null) goto L5;
    L19:
        TTVideoEngineLog.i(TAG, "getUrlsFromVideoModelByFileHash videoModel is null or fileHash is empty " + r101);
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L19;
        HashMap r102 = new HashMap();
        r102.put(15, r101);
        if (r101.startsWith("fileid") == true) goto L21;
    L13:
        VideoInfo r103 = r100.getVideoInfo(r102);
        if (r103 != null) goto L17;
        TTVideoEngineLog.i(TAG, "getUrlsFromVideoModelByFileHash videoInfo is null");
        return null;
    L17:
        String[] r104 = r103.getValueStrArr(16);
        TTVideoEngineLog.i(TAG, "getUrlsFromVideoModelByFileHash " + Arrays.toString(r104));
        return r104;
    L21:
        r102.put(28, r101.substring(6));     // Catch: IndexOutOfBoundsException -> L12
    L12:
        TTVideoEngineLog.e(TAG, "fileid index out of bounds");
        goto L13
    }

    private static boolean isNewUrlsValid(String[] r100, String r101) {
        if (r100 != null) goto L5;
    L18:
        return false;
    L5:
        if (r100.length <= 0) goto L18;
        if (TextUtils.isEmpty(r101) == false) goto L10;
        return true;
    L10:
        int r102 = r100.length;
        int r103 = 0;
    L11:
        if (r103 >= r102) goto L17;
        if (TextUtils.equals(r100[r103], r101) == true) goto L14;
        r103 = r103 + 1;
        goto L11
    L14:
        TTVideoEngineLog.d(TAG, "new urls is invalid");
        return false;
    L17:
        return true;
    }

    private void onCompletion(VideoModel r100, boolean r101) {
        MDLFetcherListener r102 = getMDLFetcherListener();
        if (r102 == null) goto L5;
        r102.onCompletion(r100, r101, this.mFileHash);
    L5:
        close();
    }

    private void onError(Error r100, boolean r101) {
        if (r101 == false) goto L4;
        this.mListener.onCompletion(r100.code, this.mVideoID, this.mFileHash, null);
    L4:
        MDLFetcherListener r102 = getMDLFetcherListener();
        if (r102 == null) goto L13;
        r102.onError(r100, this.mFileHash);
        if (r100.code != (-10003)) goto L13;
        VideoModel r103 = r102.getOldVideoModel();
        if (r103 == null) goto L13;
        JSONObject r104 = r103.getMediaInfo();
        if (r104 == null) goto L13;
        TTVideoEngineLog.i(TAG, String.format("old video model: %s", new Object[]{r104.toString()}));
    L13:
        close();
    }

    public static /* synthetic */ void access$100(MDLFetcherNew r100, Error r101, boolean r102) {
        r100.onError(r101, r102);
    }

    public static /* synthetic */ String[] access$400(MDLFetcherNew r100, VideoModel r101, String r102) {
        return r100.getUrlsFromVideoModelByFileHash(r101, r102);
    }

    public static /* synthetic */ void access$900(MDLFetcherNew r100, VideoModel r101, boolean r102) {
        r100.onCompletion(r101, r102);
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherInterface
    public int start(String r100, String r101, String r102, AVMDLURLFetcherListener r103) {
        TTVideoEngineLog.i(TAG, "start rawKey " + r100 + ", fileKey " + r101 + ", olderUrl " + r102 + ", listener " + r103);
        this.mVideoID = r100;
        this.mFileHash = r101;
        this.mListener = r103;
        this.mOldUrl = r102;
        MDLFetcherListener r104 = getMDLFetcherListener();
        boolean r105 = true;
        if (r104 != null) goto L6;
        TTVideoEngineLog.i(TAG, "start MDLFetcherListener is null return MDL_GET_URLS");
        onError(new Error(Error.MDLRetry, -10001, "MDLFetcherListener is empty"), false);
        return 1;
    L6:
        String r106 = r104.getFallbackApi();
        if (TextUtils.isEmpty(r106) == false) goto L10;
        TTVideoEngineLog.i(TAG, "start fallbackApi is empty return MDL_GET_URLS");
        onError(new Error(Error.MDLRetry, -10002, "fallbackApi is empty"), false);
        return 1;
    L10:
        String[] r107 = getURLsFromCache(r106, r102);
        if (r107 != null) goto L13;
    L16:
        Context r108 = r104.getContext();
        VideoInfoFetcher r109 = new VideoInfoFetcher(r108, null);
        this.mFetcher = r109;
        if (r108 != null) goto L20;
        r105 = false;
    L20:
        r109.setUseVideoModelCache(r105);
        this.mFetcher.setVideoID(r100);
        this.mFetcher.setListener(new MyFetcherListener(this));
        this.mFetcher.setUseFallbakApi(Boolean.TRUE);
        this.mFetcher.fetchInfo(r106, null, 0, null);
        TTVideoEngineLog.i(TAG, "start return CALLBACK_URLS_TO_MDL");
        return 0;
    L13:
        if (r107.length <= 0) goto L16;
        this.mNewUrls = r107;
        TTVideoEngineLog.i(TAG, "start return MDL_GET_URLS");
        onCompletion(this.mVideoModel, false);
        return 1;
    }
}
