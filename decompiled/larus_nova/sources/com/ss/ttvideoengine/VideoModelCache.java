package com.ss.ttvideoengine;

import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.ttvideoengine.model.VideoModel;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes34.dex */
public class VideoModelCache {
    public static final int CACHE_NB = 100;
    private static final int TIME_OUT = 3600;
    private static final List<String> TOB_VIDEO_MODEL_KEYS = null;
    private static int mCacheNB = 100;
    private static VideoModelCache mInstance = null;
    private static int mTimeOutSetByUser = -1;
    private ConcurrentHashMap<String, VideoModelCacheInfo> mVideoModelCache;

    public static class VideoModelCacheInfo {
        public boolean isExpired;
        public VideoModel model;
        public long modelGotTime;

        public VideoModelCacheInfo() {
            this.model = null;
            this.modelGotTime = 0;
            this.isExpired = false;
        }
    }

    public synchronized void clear() {
        monitor-enter(this);
        mTimeOutSetByUser = -1;     // Catch: Throwable -> L9
        mCacheNB = 100;     // Catch: Throwable -> L9
        ConcurrentHashMap<String, VideoModelCacheInfo> r100 = this.mVideoModelCache;     // Catch: Throwable -> L9
        if (r100 == null) goto L7;
        r100.clear();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    static {
        TOB_VIDEO_MODEL_KEYS = Arrays.asList(new String[]{TTVideoEngineInterface.PLAY_API_KEY_ACTION, "Version", "Vid", "Format", "Codec", "Definition", "Quality", "FileType", "Ssl", "NeedThumbs", "NeedBarrageMask", "HDRDefinition", "UnionInfo", "DrmExpireTimestamp", "PlayScene"});
    }

    public static VideoModelCache getInstance() {
        if (mInstance != null) goto L15;
        monitor-enter(VideoModelCache.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new VideoModelCache();     // Catch: Throwable -> L11
    L9:
        monitor-exit(VideoModelCache.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    public VideoModelCache() {
        this.mVideoModelCache = new ConcurrentHashMap();
    }

    public void setCacheNb(int r100) {
        mCacheNB = r100;
    }

    public void setTimeOutInSec(int r100) {
        mTimeOutSetByUser = r100;
    }

    private String getVideoModelCacheKey(String r100, String r101) {
        return getVideoModelCacheKeyForInner(r100, r101);
    }

    private String getVideoModelCacheKeyForInner(String r110, String r111) {
        if (TextUtils.isEmpty(r111) == false) goto L5;
        return r110;
    L5:
        String r100 = null;
        if (TextUtils.isEmpty(r110) == false) goto L8;
        return null;
    L8:
        StringBuilder r101 = new StringBuilder();
        String[] r102 = r111.split("[?]");
        if (r102.length < 2) goto L55;
        String[] r103 = r102[1].split("&");
        int r104 = r103.length;
        String r105 = null;
        String r106 = null;
        String r107 = null;
        String r112 = null;
        String r113 = null;
        String r114 = null;
        String r115 = null;
        int r116 = 0;
    L11:
        if (r116 >= r104) goto L56;
        String r117 = r103[r116];
        int r108 = r117.indexOf(TTVideoEngineInterface.PLAY_API_KEY_CODEC);
        if (r108 != 0) goto L15;
        r100 = r117.substring(r108 + 11);
    L54:
        r116 = r116 + 1;
        goto L11
    L15:
        int r109 = r117.indexOf("CodecType");
        if (r109 != 0) goto L18;
        r100 = r117.substring(r109 + 10);
        goto L54
    L18:
        int r118 = r117.indexOf("Codec");
        if (r118 != 0) goto L21;
        r100 = r117.substring(r118 + 6);
        goto L54
    L21:
        int r119 = r117.indexOf("format_type");
        if (r119 != 0) goto L24;
        r105 = r117.substring(r119 + 12);
        goto L54
    L24:
        int r120 = r117.indexOf("FormatType");
        if (r120 != 0) goto L27;
        r105 = r117.substring(r120 + 11);
        goto L54
    L27:
        int r121 = r117.indexOf("Format");
        if (r121 != 0) goto L30;
        r105 = r117.substring(r121 + 7);
        goto L54
    L30:
        int r122 = r117.indexOf(TTVideoEngineInterface.PLAY_API_KEY_PTOKEN);
        if (r122 != 0) goto L33;
        r106 = r117.substring(r122 + 7);
        goto L54
    L33:
        int r123 = r117.indexOf("PToken");
        if (r123 != 0) goto L36;
        r106 = r117.substring(r123 + 7);
        goto L54
    L36:
        int r124 = r117.indexOf(TTVideoEngineInterface.PLAY_API_KEY_SSL);
        if (r124 != 0) goto L39;
        r107 = r117.substring(r124 + 4);
        goto L54
    L39:
        int r125 = r117.indexOf("Ssl");
        if (r125 != 0) goto L42;
        r107 = r117.substring(r125 + 4);
        goto L54
    L42:
        int r126 = r117.indexOf("HDRDefinition");
        if (r126 != 0) goto L45;
        r112 = r117.substring(r126 + 14);
        goto L54
    L45:
        int r127 = r117.indexOf("FileType");
        if (r127 != 0) goto L49;
        r113 = r117.substring(r127 + 9);
        goto L54
    L49:
        if (r117.indexOf("UnionInfo") != 0) goto L52;
        r114 = r117.substring(10);
        goto L54
    L52:
        if (r117.indexOf("DrmExpireTimestamp") != 0) goto L54;
        r115 = r117.substring(19);
    L56:
        r101.append(r110);
        if (TextUtils.isEmpty(r100) == true) goto L59;
        char r128 = 0;
        r101.append(String.format("/%s", new Object[]{r100}));
    L61:
        if (TextUtils.isEmpty(r105) == true) goto L64;
        Object[] r129 = new Object[1];
        r129[r128] = r105;
        r101.append(String.format("/%s", r129));
    L64:
        if (TextUtils.isEmpty(r106) == true) goto L67;
        Object[] r130 = new Object[1];
        r130[r128] = r106;
        r101.append(String.format("/%s", r130));
    L67:
        if (TextUtils.isEmpty(r107) == true) goto L70;
        Object[] r131 = new Object[1];
        r131[r128] = r107;
        r101.append(String.format("/%s", r131));
    L70:
        if (TextUtils.isEmpty(r112) == true) goto L72;
        char r132 = 0;
        r101.append(String.format("/%s", new Object[]{"hdr_" + r112}));
    L74:
        if (TextUtils.isEmpty(r113) == true) goto L77;
        Object[] r133 = new Object[1];
        r133[r132] = r113;
        r101.append(String.format("/%s", r133));
    L77:
        if (TextUtils.isEmpty(r114) == true) goto L80;
        Object[] r134 = new Object[1];
        r134[r132] = r114;
        r101.append(String.format("/%s", r134));
    L80:
        if (TextUtils.isEmpty(r115) == true) goto L83;
        Object[] r135 = new Object[1];
        r135[r132] = r115;
        r101.append(String.format("/%s", r135));
    L83:
        return r101.toString();
    L72:
        r132 = 0;
        goto L74
    L59:
        r128 = 0;
        goto L61
    L55:
        r105 = null;
        r106 = null;
        r107 = null;
        r112 = null;
        r113 = null;
        r114 = null;
        r115 = null;
        goto L56
    }

    private String getVideoModelCacheKeyForTob(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return r100;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        HttpUrl r102 = HttpUrl.parse(r101);
        if (r102 != null) goto L11;
        return null;
    L11:
        StringBuilder r103 = new StringBuilder();
        Iterator<String> r104 = TOB_VIDEO_MODEL_KEYS.iterator();
    L13:
        if (r104.hasNext() == false) goto L18;
        String r105 = r104.next();
        String r106 = r102.queryParameter(r105);
        if (TextUtils.isEmpty(r106) == true) goto L13;
        r103.append(r105);
        r103.append(ContainerUtils.KEY_VALUE_DELIMITER);
        r103.append(r106);
        r103.append("&");
        goto L13
    L18:
        return r103.toString();
    }

    public synchronized VideoModelCacheInfo get(String r100, String r101) {
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoModelCache == null) goto L24;
        String r102 = getVideoModelCacheKey(r100, r101);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r102) == false) goto L9;
        monitor-exit(this);
        return null;
    L9:
        VideoModelCacheInfo r103 = this.mVideoModelCache.get(r102);     // Catch: Throwable -> L26
        if (r103 == null) goto L24;
        int r104 = mTimeOutSetByUser;     // Catch: Throwable -> L26
        if (r104 > 0) goto L19;
        VideoModel r105 = r103.model;     // Catch: Throwable -> L26
        if (r105 == null) goto L17;
        r104 = (r105.getVideoRefInt(3) + 3600) - 300;     // Catch: Throwable -> L26
        goto L19
    L17:
        r104 = 3600;
    L19:
        if ((SystemClock.elapsedRealtime() - r103.modelGotTime) <= (r104 * 1000)) goto L21;
        r103.isExpired = true;     // Catch: Throwable -> L26
    L22:
        monitor-exit(this);
        return r103;
    L21:
        r103.isExpired = false;     // Catch: Throwable -> L26
    L24:
        monitor-exit(this);
        return null;
    }

    public synchronized void remove(String r100, String r101) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoModelCache == null) goto L10;
        String r102 = getVideoModelCacheKey(r100, r101);     // Catch: Throwable -> L12
        if (TextUtils.isEmpty(r102) == false) goto L9;
        monitor-exit(this);
        return;
    L9:
        this.mVideoModelCache.remove(r102);     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
    }

    public synchronized void put(String r100, String r101, VideoModelCacheInfo r102) {
        monitor-enter(this);
        String r103 = getVideoModelCacheKey(r100, r101);     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r103) == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mVideoModelCache.put(r103, r102);     // Catch: Throwable -> L19
        if (this.mVideoModelCache.size() <= mCacheNB) goto L17;
        Iterator<Map.Entry<String, VideoModelCacheInfo>> r104 = this.mVideoModelCache.entrySet().iterator();     // Catch: Throwable -> L19
        long r105 = Long.MAX_VALUE;
        String r106 = null;
    L11:
        if (r104.hasNext() == false) goto L15;
        Map.Entry<String, VideoModelCacheInfo> r107 = r104.next();     // Catch: Throwable -> L19
        long r108 = r107.getValue().modelGotTime;     // Catch: Throwable -> L19
        if (r108 >= r105) goto L11;
        r106 = r107.getKey();     // Catch: Throwable -> L19
        r105 = r108;
        goto L11
    L15:
        if (r106 == null) goto L17;
        this.mVideoModelCache.remove(r106);     // Catch: Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized void put(String r100, String r101, VideoModel r102) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mVideoModelCache == null) goto L11;
        if (r100 == null) goto L11;
        if (r101 == null) goto L11;
        VideoModelCacheInfo r103 = new VideoModelCacheInfo();     // Catch: Throwable -> L13
        r103.model = r102;     // Catch: Throwable -> L13
        r103.modelGotTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L13
        put(r100, r101, r103);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L11:
        monitor-exit(this);
    }
}
