package com.optimize.statistics;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.common.logging.FLog;
import com.facebook.drawee.controller.BaseFrescoControllerListener;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.SizeDeterminer;
import com.facebook.imagepipeline.cache.DealCacheHelper;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.optimize.statistics.sampling.IFrescoMonitorSamplingDecider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class FrescoControllerListener extends BaseFrescoControllerListener {
    private static final int FROM_BITMAP_MEMORYCACHE = 3;
    private static final int FROM_CACHE = 1;
    private static final int FROM_DISKCACHE = 2;
    private static final int FROM_ENCODE_MEMORYCACHE = 1;
    private static final int FROM_NETWORK = 0;
    private static final int FROM_UNKNOW = -1;
    private static final int HASH_MAP_DEFAULT_MAX_SIZE = 50;
    public static final String IMAGE_MONITOR_USER_SENCE = "image_sensible_monitor";
    public static final String IMAGE_MONITOR_WASTE = "image_waste_show";
    private static final int NOT_FROM_CACHE = 0;
    private static final String TAG = "UserSenceListener";
    private static boolean mForceRunInSubThread = false;
    private static int mHashMapMaxSize = 50;
    private static boolean mHashMapOpt = false;
    private static HashMap<ImageRequest, Long> mImageLoadDurationMap = null;
    private static SparseArray<Long> mImageLoadDurationOptMap = null;
    private static boolean mIsRecordSensible = true;
    private static boolean mIsRecordWaste = true;
    private static boolean mUseOptHashMap;

    private int getHitCache(int r100) {
        if (r100 == 2) goto L10;
        if (r100 == 1) goto L10;
        if (r100 == 3) goto L10;
        return 0;
    L10:
        return 1;
    }

    private int getHitType(int r100) {
        if (r100 != (-1)) goto L6;
        return 0;
    L6:
        return r100;
    }

    static {
        mImageLoadDurationMap = new HashMap();
        mImageLoadDurationOptMap = new SparseArray();
        mUseOptHashMap = false;
    }

    public static void clearHashMap() {
    L7:
        th = move-exception;
        FLog.d(TAG, "clearHashMap mImageLoadDurationMap clear failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == false) goto L5;
        mImageLoadDurationOptMap.clear();     // Catch: Throwable -> L7
    L10:
        return;
    L5:
        mImageLoadDurationMap.clear();     // Catch: Throwable -> L7
        goto L10
    }

    private boolean isReportWaste() {
        if (mIsRecordWaste == true) goto L5;
    L7:
        return false;
    L5:
        if (FrescoMonitor.isReportImageWaste() == false) goto L7;
        return true;
    }

    public FrescoControllerListener() {
    }

    public static int getMapMaxSize() {
        return mHashMapMaxSize;
    }

    public static boolean isHashMapOpt() {
        return mHashMapOpt;
    }

    public static void forceRunInSubThread(boolean r100) {
        mForceRunInSubThread = r100;
    }

    private int getFrom(CloseableImage r100) {
        if (r100.isRequestInternet() == false) goto L7;
        return 0;
    L7:
        if (r100.isHitDiskCache() == false) goto L11;
        return 2;
    L11:
        if (r100.isHitEncodeMemoryCache() == false) goto L15;
        return 1;
    L15:
        if (r100.isHitBitmapMemoryCache() == false) goto L18;
        return 3;
    L18:
        return -1;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x002f -> B:13:0x0030). Please report as a decompilation issue!!! */
    private int getLoadDuration(ImageRequest r100) {
        if (mUseOptHashMap == false) goto L8;
        if (r100 == null) goto L12;
        long r101 = mImageLoadDurationOptMap.get(r100.hashCode()).longValue();     // Catch: Exception -> L11
    L13:
        if (r101 != (-1)) goto L16;
        return -1;
    L16:
        return (int) (System.currentTimeMillis() - r101);
    L8:
        if (mImageLoadDurationMap.containsKey(r100) == false) goto L12;
        r101 = mImageLoadDurationMap.get(r100).longValue();     // Catch: Exception -> L11
    L12:
        r101 = -1;
        goto L13
    }

    public static void setHashMapOpt(boolean r100) {
        mHashMapOpt = r100;
    }

    public static void setMapMaxSize(int r100) {
        mHashMapMaxSize = r100;
    }

    public static void setUseOptHashMap(boolean r100) {
        mUseOptHashMap = r100;
    }

    public void setIsRecordSensible(boolean r100) {
        mIsRecordSensible = r100;
    }

    public void setIsRecordWaste(boolean r100) {
        mIsRecordWaste = r100;
    }

    private void addTagsFromMonitorHook(JSONObject r110, String r111) {
        IMonitorHook r100 = FrescoMonitor.getMonitorHook();
        if (r100 == null) goto L18;
        Pair<Boolean, Map<String, Object>> r101 = r100.onMonitorCompleted(null, null, null, r110, true);     // Catch: Exception -> L7
    L8:
        if (r101 == null) goto L18;
        Map r102 = (Map) r101.second;
        if (r102 == null) goto L18;
        Iterator r103 = r102.keySet().iterator();     // Catch: JSONException -> L16
    L13:
        if (r103.hasNext() == false) goto L18;
        String r104 = (String) r103.next();     // Catch: JSONException -> L16
        r110.put(r104, r102.get(r104));     // Catch: JSONException -> L16
    L7:
        r101 = null;
    L18:
        if (FrescoCacheMonitorUtil.isOptListenerAnr() == false) goto L32;
        Iterator<IMonitorHookV2> r105 = FrescoMonitor.sNewMonitorHookV2s.iterator();
    L21:
        if (r105.hasNext() == false) goto L48;
        Pair<Boolean, Map<String, Object>> r106 = r105.next().onMonitorCompleted(null, null, null, r110, true, false);
        if (r106 == null) goto L21;
        Map r107 = (Map) r106.second;
        if (r107 == null) goto L21;
        Iterator r108 = r107.keySet().iterator();     // Catch: JSONException -> L31
    L28:
        if (r108.hasNext() == false) goto L21;
        String r109 = (String) r108.next();     // Catch: JSONException -> L31
        r110.put(r109, r107.get(r109));     // Catch: JSONException -> L31
    L48:
        if (TextUtils.isEmpty(r110.optString("biz_tag")) == false) goto L99;
        Uri r112 = UriProtector.parse(r111);
        String r113 = UriProtector.getQueryParameter(r112, "biz_tag");
        if (TextUtils.isEmpty(r113) == false) goto L53;
        r113 = UriProtector.getQueryParameter(r112, "from");
    L53:
        if (TextUtils.isEmpty(r113) == false) goto L60;
        String r114 = r112.getPath();
        if (r114 == null) goto L57;
        int r115 = r114.lastIndexOf(47);
    L58:
        if (r115 <= 0) goto L60;
        r113 = r114.substring(0, r115);
        goto L60
    L57:
        r115 = -1;
    L60:
        if (r113 == null) goto L100;
        r110.put("biz_tag", r113);     // Catch: JSONException -> L63
        return;
    L63:
        e = move-exception;
        e.printStackTrace();
        return;
    L100:
        return;
    L99:
        return;
    L32:
        List<IMonitorHookV2> r116 = FrescoMonitor.sMonitorHookV2s;
        monitor-enter(r116);
        Iterator<IMonitorHookV2> r117 = r116.iterator();     // Catch: Throwable -> L66
    L36:
        if (r117.hasNext() == false) goto L46;
        Pair<Boolean, Map<String, Object>> r118 = r117.next().onMonitorCompleted(null, null, null, r110, true, false);     // Catch: Throwable -> L66
        if (r118 == null) goto L36;
        Map r119 = (Map) r118.second;     // Catch: Throwable -> L66
        if (r119 == null) goto L36;
        Iterator r120 = r119.keySet().iterator();     // Catch: JSONException -> L69 Throwable -> L66
    L43:
        if (r120.hasNext() == false) goto L36;
        String r121 = (String) r120.next();     // Catch: JSONException -> L69 Throwable -> L66
        r110.put(r121, r119.get(r121));     // Catch: JSONException -> L69 Throwable -> L66
    L46:
        monitor-exit(r116);     // Catch: Throwable -> L66
    L66:
        th = move-exception;
        throw th;
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public void onControllerStart(ImageRequest r100, long r101) {
    L18:
        th = move-exception;
        FLog.d(TAG, "onControllerStart mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == false) goto L12;
        if (mHashMapOpt == true) goto L7;
    L9:
        if (r100 == null) goto L22;
        mImageLoadDurationOptMap.put(r100.hashCode(), Long.valueOf(r101));     // Catch: Throwable -> L18
        return;
    L22:
        return;
    L7:
        if (mImageLoadDurationOptMap.size() <= mHashMapMaxSize) goto L9;
        mImageLoadDurationOptMap.clear();     // Catch: Throwable -> L18
        goto L9
    L12:
        if (mHashMapOpt == true) goto L14;
    L16:
        mImageLoadDurationMap.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L18
        return;
    L14:
        if (mImageLoadDurationMap.size() <= mHashMapMaxSize) goto L16;
        mImageLoadDurationMap.clear();     // Catch: Throwable -> L18
        goto L16
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public void onRelease(String r100, ImageRequest r101) {
    L8:
        th = move-exception;
        FLog.d(TAG, "onRelease mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == true) goto L5;
        mImageLoadDurationMap.remove(r101);     // Catch: Throwable -> L8
    L11:
        return;
    L5:
        if (r101 == null) goto L11;
        mImageLoadDurationOptMap.remove(r101.hashCode());     // Catch: Throwable -> L8
        goto L11
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public void onFailure(String r100, ImageRequest r101, Throwable r102) {
    L8:
        th = move-exception;
        FLog.d(TAG, "onFailure mImageLoadDurationMap put element failed! t = " + th);
        return;
    L3:
        if (mUseOptHashMap == true) goto L5;
        mImageLoadDurationMap.remove(r101);     // Catch: Throwable -> L8
    L11:
        return;
    L5:
        if (r101 == null) goto L11;
        mImageLoadDurationOptMap.remove(r101.hashCode());     // Catch: Throwable -> L8
        goto L11
    }

    @Override // com.facebook.drawee.controller.BaseFrescoControllerListener, com.facebook.drawee.controller.BaseControllerListener
    public void onFinalImageSet(String r110, Object r210, Animatable r211, ImageRequest r212, final Map r213) {
        if (r212 != null) goto L6;
        FLog.e(TAG, "imageRequest is null");
        return;
    L6:
        IFrescoMonitorSamplingDecider r100 = FrescoMonitor.getSamplingDecider();
        if (r100 != null) goto L145;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == false) goto L143;
        boolean r102 = FrescoMonitor.getLogTypeSwitch(IMAGE_MONITOR_USER_SENCE);
        boolean r103 = isReportWaste();
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L35;
        if (r102 == true) goto L35;
        if (r103 == true) goto L35;
    L31:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet fast-path remove failed! t = " + th);
        return;
    L27:
        if (mUseOptHashMap == false) goto L29;
        mImageLoadDurationOptMap.remove(r212.hashCode());     // Catch: Throwable -> L31
    L139:
        return;
    L29:
        mImageLoadDurationMap.remove(r212);     // Catch: Throwable -> L31
    L35:
        if (r212.getSourceUri() == null) goto L37;
        String r104 = r212.getSourceUri().toString();
    L38:
        final String r105 = r104;
        int r106 = -1;
        if ((r210 instanceof CloseableImage) == false) goto L41;
        CloseableImage r107 = (CloseableImage) r210;
        int r108 = r107.getImageCount();
        ImageFormat r109 = r107.getImageFormat();
        int r111 = getFrom(r107);
        int r112 = r108;
    L42:
        final SizeDeterminer r113 = r212.getSizeDeterminer();
        if (r113 != null) goto L45;
    L64:
        boolean r114 = false;
        final int r115 = -1;
        String r116 = null;
        boolean r117 = false;
    L65:
        Object r118 = r213.get(FrescoMonitorConst.SCENE_TAG);
        if (r118 != null) goto L68;
    L71:
        int r119 = r111;
        String r120 = FrescoMonitor.getCurrentScene();
        if (r120 == null) goto L75;
        r213.put(FrescoMonitorConst.SCENE_TAG, r120);
    L75:
        if (TextUtils.isEmpty(r116) == false) goto L80;
        String r121 = FrescoMonitor.getCurrentActivity();
        if (r121 == null) goto L80;
        r116 = r121;
    L80:
        if (TextUtils.isEmpty(r116) == true) goto L82;
        r213.put(FrescoMonitorConst.PAGE_TAG, r116);
    L82:
        if (r103 == false) goto L100;
        JSONObject r122 = new JSONObject();
        StringBuilder r123 = new StringBuilder();     // Catch: JSONException -> L97
        int r214 = r112;
        r123.append(r213.get("drawableWidth"));     // Catch: JSONException -> L133
        r123.append("x");     // Catch: JSONException -> L133
        r123.append(r213.get("drawableHeight"));     // Catch: JSONException -> L133
        r122.put(FrescoMonitorConst.APPLIED_IMAGE_SIZE, r123.toString());     // Catch: JSONException -> L133
        if (r109 != null) goto L89;
        String r124 = "undefined";
    L90:
        r122.put("image_type", r124);     // Catch: JSONException -> L133
        r122.put(FrescoMonitorConst.LOG_TYPE, IMAGE_MONITOR_WASTE);     // Catch: JSONException -> L133
        r122.put("uri", r105);     // Catch: JSONException -> L133
        r122.put(FrescoMonitorConst.SCENE_TAG, r213.get(FrescoMonitorConst.SCENE_TAG));     // Catch: JSONException -> L133
        addTagsFromMonitorHook(r122, r105);     // Catch: RuntimeException -> L93 JSONException -> L133
    L99:
        FrescoMonitor.onImageShowCallback(r114, r122);
    L101:
        if (r102 == false) goto L106;
        if (r113 == null) goto L106;
        if (r113.getView() == null) goto L106;
    L111:
        final int r125 = getLoadDuration(r212);
        if (mForceRunInSubThread == true) goto L114;
    L116:
        upload(r106, r115, r213, r125, r109, r105, r117, r214, r119, r113);
    L134:
    L122:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet2 mImageLoadDurationMap put element failed! t = " + th);
        return;
    L118:
        if (mUseOptHashMap == false) goto L120;
        mImageLoadDurationOptMap.remove(r212.hashCode());     // Catch: Throwable -> L122
        return;
    L120:
        mImageLoadDurationMap.remove(r212);     // Catch: Throwable -> L122
        return;
    L114:
        if (Looper.myLooper() != Looper.getMainLooper()) goto L116;
        final int r126 = r106;
        final ImageFormat r127 = r109;
        final boolean r128 = r117;
        final int r129 = r214;
        final int r130 = r119;
        DealCacheHelper.getIOExecutor().execute(new AnonymousClass1(this, r126, r115, r213, r125, r127, r105, r128, r129, r130, r113));
    L106:
        if (FrescoCacheMonitorUtil.isOptSensibleMonitor() == true) goto L108;
    L138:
    L130:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet mImageLoadDurationMap put element failed! t = " + th);
        return;
    L126:
        if (mUseOptHashMap == false) goto L128;
        mImageLoadDurationOptMap.remove(r212.hashCode());     // Catch: Throwable -> L130
        return;
    L128:
        mImageLoadDurationMap.remove(r212);     // Catch: Throwable -> L130
        return;
    L108:
        if (FrescoCacheMonitorUtil.isOptMonitorSample() == false) goto L111;
        if (r102 == true) goto L111;
    L93:
        e = move-exception;
        FLog.e(TAG, "RuntimeException error is: ", e);     // Catch: JSONException -> L133
        goto L99
    L89:
        r124 = r109.getName();     // Catch: JSONException -> L133
    L98:
        FLog.w(TAG, "JSONException in FrescoControllerListener");
    L97:
        r214 = r112;
        goto L98
    L100:
        r214 = r112;
        goto L101
    L68:
        if (TextUtils.isEmpty(r118.toString()) == true) goto L71;
        r119 = r111;
        goto L75
    L45:
        if (r113.getView() == null) goto L64;
        r115 = r113.getView().getHeight();
        r106 = r113.getView().getWidth();
        Rect r131 = new Rect();
        if (r113.getView().getGlobalVisibleRect(r131) == false) goto L49;
    L52:
        boolean r132 = true;
    L54:
        if (r113.getView().getGlobalVisibleRect(r131) == true) goto L56;
    L58:
        boolean r133 = false;
    L59:
        Context r134 = r113.getView().getContext();
        boolean r135 = r133;
        if ((r134 instanceof Activity) == false) goto L62;
        r116 = ((Activity) r134).getClass().getSimpleName();
    L63:
        r114 = r135;
        r117 = r132;
        goto L65
    L62:
        r116 = null;
        goto L63
    L56:
        if (r113.getView().isShown() == false) goto L58;
        r133 = true;
        goto L59
    L49:
        if (r113.getView().isShown() == true) goto L52;
        r132 = false;
        goto L54
    L41:
        r109 = null;
        r112 = -1;
        r111 = -1;
        goto L42
    L37:
        r104 = "";
        goto L38
    L143:
    L19:
        th = move-exception;
        FLog.d(TAG, "onFinalImageSet mImageLoadDurationMap remove element failed! t = " + th);
        return;
    L15:
        if (mUseOptHashMap == false) goto L17;
        mImageLoadDurationOptMap.remove(r212.hashCode());     // Catch: Throwable -> L19
    L142:
        return;
    L17:
        mImageLoadDurationMap.remove(r212);     // Catch: Throwable -> L19
        goto L142
    L145:
        r101 = r100.shouldSampleFinalImageSet(r212, r213);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        FLog.w(TAG, "sampling decider error in onFinalImageSet, fallback to sample", th);
        goto L12
    }

    private void upload(int r100, int r101, Map r102, int r103, ImageFormat r110, String r111, boolean r112, int r113, int r114, SizeDeterminer r115) {
        JSONObject r104 = new JSONObject();
        if (mIsRecordSensible == true) goto L31;
        return;
    L31:
        r104.put("view_width", r100);     // Catch: JSONException -> L23
        r104.put("view_height", r101);     // Catch: JSONException -> L23
        r104.put("image_width", r102.get("drawableWidth"));     // Catch: JSONException -> L23
        r104.put("image_height", r102.get("drawableHeight"));     // Catch: JSONException -> L23
        r104.put("duration", r103);     // Catch: JSONException -> L23
        r104.put("from", r114);     // Catch: JSONException -> L23
        if (r110 != null) goto L8;
        String r105 = "undefined";
    L9:
        r104.put("image_type", r105);     // Catch: JSONException -> L23
        r104.put(FrescoMonitorConst.IMAGE_SDK_VERSION, "1.41.6");     // Catch: JSONException -> L23
        r104.put(FrescoMonitorConst.LOG_TYPE, IMAGE_MONITOR_USER_SENCE);     // Catch: JSONException -> L23
        r104.put(FrescoMonitorConst.IMAGE_COUNT, r113);     // Catch: JSONException -> L23
        r104.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L23
        r104.put("uri", r111);     // Catch: JSONException -> L23
        r104.put(FrescoMonitorConst.SCENE_TAG, r102.get(FrescoMonitorConst.SCENE_TAG));     // Catch: JSONException -> L23
        addTagsFromMonitorHook(r104, r111);     // Catch: RuntimeException -> L12 JSONException -> L23
    L14:
        if (r115 == null) goto L16;
        View r106 = r115.getView();     // Catch: JSONException -> L23
    L17:
        if (r106 == null) goto L21;
        Context r107 = r106.getContext();     // Catch: JSONException -> L23
        if ((r107 instanceof Activity) == false) goto L21;
        r104.put(FrescoMonitorConst.PAGE_TAG, ((Activity) r107).getClass().getSimpleName());     // Catch: JSONException -> L23
    L21:
        r104.put("exception_tag", 1);     // Catch: JSONException -> L23
        r104.put(a.KEY_HIT_CACHE, getHitCache(r114));     // Catch: JSONException -> L23
        r104.put("hit_type", getHitType(r114));     // Catch: JSONException -> L23
    L25:
        if (FrescoCacheMonitorUtil.isOptSensibleMonitor() == true) goto L27;
        if (r112 == true) goto L27;
        return;
    L27:
        FrescoMonitor.onSensibleCallback(r104);
        MonitorUtils.monitorCommonLog(IMAGE_MONITOR_USER_SENCE, r104);
        FLog.d(TAG, "User sence tracking upload successful, content: " + r104);
        return;
    L16:
        r106 = null;
        goto L17
    L12:
        e = move-exception;
        FLog.e(TAG, "RuntimeException error is: ", e);     // Catch: JSONException -> L23
        goto L14
    L8:
        r105 = r110.getName();     // Catch: JSONException -> L23
    L23:
        FLog.w(TAG, "JSONException in FrescoControllerListener");
        goto L25
    }

    public static /* synthetic */ void access$000(FrescoControllerListener r100, int r101, int r102, Map r103, int r104, ImageFormat r105, String r106, boolean r107, int r108, int r109, SizeDeterminer r110) {
        r100.upload(r101, r102, r103, r104, r105, r106, r107, r108, r109, r110);
    }
}
