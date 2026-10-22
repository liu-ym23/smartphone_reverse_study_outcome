package com.facebook.net;

import android.net.Uri;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.ttnet.config.ImageStrategyController;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class ImageStrategy {
    private static final String DEFAULT_COUNT_KEY = "p.pstap.com";
    private static final int DEFAULT_ERROR_TIMES = 5;
    private static final int DEFAULT_LIMIT_IMAGES = 50;
    private static final long DEFAULT_LIMIT_INTERVAL = 600000;
    private static final long DEFAULT_UPLOAD_COUNT_INTERVAL = 300000;
    private static final String IMAGE_COUNT_SERVICE = "image_opt_monitor";
    private static final Object mLock = null;
    private static volatile ImageStrategy sIns;
    private final ConcurrentHashMap<String, Long> mBlockHost;
    private final ConcurrentHashMap<String, ImageRequestInfo> mImageRequestInfo;
    private boolean mLocalSwitch;
    private final ConcurrentHashMap<String, RequestCountInfo> mRequestCountInfo;

    public class ImageRequestInfo {
        long mEnterBlackListTime;
        int mErrorRequest;
        boolean mHasInBlackList;
        int mLimitTotalRequest;
        int mTotalRequest;
        final /* synthetic */ ImageStrategy this$0;

        public ImageRequestInfo(ImageStrategy r100, int r101, int r102, boolean r103, long r104, int r105) {
            this.this$0 = r100;
            this.mErrorRequest = r101;
            this.mTotalRequest = r102;
            this.mHasInBlackList = r103;
            this.mEnterBlackListTime = r104;
            this.mLimitTotalRequest = r105;
        }
    }

    public class RequestCountInfo {
        int mErrorTimes;
        long mStartCountTime;
        int mSuccessTimes;
        long mTotalDuration;
        final /* synthetic */ ImageStrategy this$0;

        public RequestCountInfo(ImageStrategy r100, int r101, int r102, long r103) {
            this.this$0 = r100;
            this.mSuccessTimes = r101;
            this.mErrorTimes = r102;
            this.mTotalDuration = r103;
            this.mStartCountTime = System.currentTimeMillis();
        }
    }

    static {
        mLock = new Object();
    }

    public static ImageStrategy getInstance() {
        if (sIns != null) goto L15;
        Object r100 = mLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sIns != null) goto L9;
        sIns = new ImageStrategy();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return sIns;
    }

    private ImageStrategy() {
        this.mBlockHost = new ConcurrentHashMap();
        this.mImageRequestInfo = new ConcurrentHashMap();
        this.mRequestCountInfo = new ConcurrentHashMap();
        this.mLocalSwitch = true;
    }

    private long getBlackInterval() {
        if (ImageStrategyController.getInstance() != null) goto L5;
        return 600000;
    L5:
        if (ImageStrategyController.getInstance().getHostInBlackInterval() > 0) goto L7;
        return 600000;
    L7:
        return ImageStrategyController.getInstance().getHostInBlackInterval() * 1000;
    }

    private int getErrorTimes() {
        if (ImageStrategyController.getInstance() != null) goto L5;
        return 5;
    L5:
        if (ImageStrategyController.getInstance().getFailedTimes() > 0) goto L7;
        return 5;
    L7:
        return ImageStrategyController.getInstance().getFailedTimes();
    }

    private int getImageLimitNumber() {
        if (ImageStrategyController.getInstance() != null) goto L5;
        return 50;
    L5:
        if (ImageStrategyController.getInstance().getLimitImageNumbers() > 0) goto L7;
        return 50;
    L7:
        return ImageStrategyController.getInstance().getLimitImageNumbers();
    }

    private boolean isMatchNetState() {
        if (ImageStrategyController.getInstance() == null) goto L5;
        int r100 = ImageStrategyController.getInstance().getNetWorkType().getValue();
    L7:
        if (r100 != NetworkUtils.NetworkType.WIFI.getValue()) goto L9;
        return true;
    L9:
        if (r100 != NetworkUtils.NetworkType.MOBILE_4G.getValue()) goto L11;
        return true;
    L11:
        if (r100 != NetworkUtils.NetworkType.MOBILE_3G.getValue()) goto L13;
        return true;
    L13:
        if (r100 != NetworkUtils.NetworkType.MOBILE_3G_H.getValue()) goto L15;
        return true;
    L15:
        if (r100 != NetworkUtils.NetworkType.MOBILE_3G_HP.getValue()) goto L17;
        return true;
    L17:
        if (r100 == NetworkUtils.NetworkType.MOBILE_5G.getValue()) goto L26;
        return false;
    L26:
        return true;
    L5:
        r100 = 0;
        goto L7
    }

    public boolean getImageStrategySwitch() {
        if (ImageStrategyController.getInstance() != null) goto L5;
    L7:
        return false;
    L5:
        if (ImageStrategyController.getInstance().getSwitch() != 1) goto L7;
        return true;
    }

    private boolean getHostInBlack(Uri r100) {
        if (r100 != null) goto L27;
    L26:
        return false;
    L27:
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L26
    L5:
        if (getImageStrategySwitch() == false) goto L26;
        String r101 = r100.getHost();     // Catch: Throwable -> L24
        if (StringUtils.isEmpty(r101) == false) goto L11;
        return false;
    L11:
        if (this.mBlockHost.containsKey(r101) == true) goto L13;
        return false;
    L13:
        if ((System.currentTimeMillis() - this.mBlockHost.get(r101).longValue()) > getBlackInterval()) goto L15;
        return true;
    L15:
        if (this.mImageRequestInfo.containsKey(r101) == false) goto L19;
        ImageRequestInfo r102 = this.mImageRequestInfo.get(r101);     // Catch: Throwable -> L24
        if (r102 == null) goto L19;
        r102.mHasInBlackList = false;     // Catch: Throwable -> L24
    L19:
        this.mBlockHost.remove(r101);     // Catch: Throwable -> L24
        return false;
    }

    public List<String> getUrlList(String r100) {
        if (ImageStrategyController.getInstance() != null) goto L5;
        return null;
    L5:
        return ImageStrategyController.getInstance().getUrlListForUrl(r100);
    }

    public void setLocalSwitch(boolean r100) {
        this.mLocalSwitch = r100;
    }

    public void sortImageRequests(ImageRequest[] r100) {
        if (this.mLocalSwitch == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.length > 1) goto L9;
        return;
    L9:
        if (getImageStrategySwitch() == true) goto L11;
        return;
    L11:
        if (this.mBlockHost.isEmpty() == true) goto L38;
        int r101 = r100.length - 1;
        int r102 = 0;
    L14:
        if (r102 >= r101) goto L39;
    L15:
        if (r102 >= r101) goto L19;
        if (getHostInBlack(r100[r102].getSourceUri()) == true) goto L19;
        r102 = r102 + 1;
    L19:
        if (r102 >= r101) goto L23;
        if (getHostInBlack(r100[r101].getSourceUri()) == false) goto L23;
        r101 = r101 - 1;
    L23:
        if (r102 >= r101) goto L14;
        ImageRequest r103 = r100[r102];
        r100[r102] = r100[r101];
        r100[r101] = r103;
        r102 = r102 + 1;
        r101 = r101 - 1;
        goto L14
    L39:
        return;
    }

    private void handleCount(String r110, boolean r111, long r112, boolean r113) {
        if (ImageStrategyController.getInstance() != null) goto L6;
    L8:
        if (r113 == true) goto L11;
        return;
    L11:
        if (this.mRequestCountInfo.containsKey(DEFAULT_COUNT_KEY) == false) goto L30;
        RequestCountInfo r114 = this.mRequestCountInfo.get(DEFAULT_COUNT_KEY);     // Catch: Throwable -> L35
        if (r111 == true) goto L15;
    L17:
        r114.mErrorTimes++;     // Catch: Throwable -> L35
    L18:
        long r115 = System.currentTimeMillis();     // Catch: Throwable -> L35
        if ((r115 - r114.mStartCountTime) <= 300000) goto L37;
        int r116 = r114.mSuccessTimes;     // Catch: Throwable -> L35
        if (r116 <= 0) goto L23;
        long r100 = r114.mTotalDuration / ((long) r116);     // Catch: Throwable -> L35
    L24:
        JSONObject r117 = new JSONObject();     // Catch: Throwable -> L35
        r117.put("error", r114.mErrorTimes);     // Catch: Throwable -> L35
        r117.put("success", r114.mSuccessTimes);     // Catch: Throwable -> L35
        r117.put("average_duration", r100);     // Catch: Throwable -> L35
        if (getImageStrategySwitch() == false) goto L27;
        r117.put("has_opt", 1);     // Catch: Throwable -> L35
    L27:
        r114.mErrorTimes = 0;     // Catch: Throwable -> L35
        r114.mSuccessTimes = 0;     // Catch: Throwable -> L35
        r114.mTotalDuration = 0;     // Catch: Throwable -> L35
        r114.mStartCountTime = r115;     // Catch: Throwable -> L35
        return;
    L23:
        r100 = 0;
        goto L24
    L37:
        return;
    L15:
        if (r112 <= 0) goto L17;
        r114.mSuccessTimes++;     // Catch: Throwable -> L35
        r114.mTotalDuration += r112;     // Catch: Throwable -> L35
        goto L18
    L30:
        if (r111 == false) goto L32;
        int r101 = 0;
    L33:
        this.mRequestCountInfo.put(DEFAULT_COUNT_KEY, new RequestCountInfo(this, r111 ? 1 : 0, r101, r112));     // Catch: Throwable -> L35
        return;
    L32:
        r101 = 1;
        goto L33
    L6:
        if (ImageStrategyController.getInstance().getSwitch() != 2) goto L8;
        return;
    }

    public void handleImageRequest(String r100, boolean r110, long r111, boolean r112) {
        if (this.mLocalSwitch == true) goto L6;
        return;
    L6:
        if (StringUtils.isEmpty(r100) == false) goto L8;
        return;
    L8:
        if (isMatchNetState() == false) goto L45;
        handleCount(r100, r110, r111, r112);
        if (getImageStrategySwitch() == true) goto L41;
        return;
    L41:
        String r101 = Uri.parse(r100).getHost();     // Catch: Throwable -> L38
        if (this.mImageRequestInfo.containsKey(r101) == false) goto L33;
        ImageRequestInfo r113 = this.mImageRequestInfo.get(r101);     // Catch: Throwable -> L38
        if (r113 != null) goto L18;
        return;
    L18:
        if (r113.mHasInBlackList == false) goto L20;
        return;
    L20:
        if (r110 == true) goto L22;
        r113.mErrorRequest++;     // Catch: Throwable -> L38
    L22:
        r113.mTotalRequest++;     // Catch: Throwable -> L38
        if (r113.mErrorRequest < getErrorTimes()) goto L29;
        if (((r113.mErrorRequest * 100) / r113.mTotalRequest) < 10) goto L29;
        r113.mHasInBlackList = true;     // Catch: Throwable -> L38
        r113.mTotalRequest = 0;     // Catch: Throwable -> L38
        r113.mErrorRequest = 0;     // Catch: Throwable -> L38
        this.mBlockHost.put(r101, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L38
        return;
    L29:
        if (r113.mTotalRequest <= r113.mLimitTotalRequest) goto L43;
        r113.mTotalRequest = 0;     // Catch: Throwable -> L38
        r113.mErrorRequest = 0;     // Catch: Throwable -> L38
        r113.mHasInBlackList = false;     // Catch: Throwable -> L38
        return;
    L43:
        return;
    L33:
        if (r110 == false) goto L35;
        int r102 = 0;
    L36:
        this.mImageRequestInfo.put(r101, new ImageRequestInfo(this, r102, 1, false, 0, getImageLimitNumber()));     // Catch: Throwable -> L38
        return;
    L35:
        r102 = 1;
    L38:
        th = move-exception;
        th.printStackTrace();
        return;
    }
}
