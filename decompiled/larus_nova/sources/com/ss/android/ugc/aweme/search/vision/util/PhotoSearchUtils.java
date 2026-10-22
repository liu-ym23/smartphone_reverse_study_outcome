package com.ss.android.ugc.aweme.search.vision.util;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.search.common.config.PhotoSearchConfigSettings;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.vision.model.PhotoSearchParamModel;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoSearchUIConfig;
import com.ss.android.ugc.aweme.search.vision.model.data.ResultPanelStatus;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/util/PhotoSearchUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PhotoSearchUtils f454046a = null;

    private PhotoSearchUtils() {
    }

    static {
        f454046a = new PhotoSearchUtils();
    }

    public static boolean a(PhotoSearchParamModel r100) {
        if (r100 == null) goto L8;
        PhotoSearchUIConfig r101 = r100.getPhotoSearchUIConfig();
        if (r101 == null) goto L8;
        if (r101.getCanDragPanelFs() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public static Float b(PhotoSearchUIConfig r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Float r101 = r100.getInitPanelHeight();
        if (r101 != null) goto L8;
    L15:
        return null;
    L8:
        if (r100.getResultPanelPattern() != ResultPanelStatus.FULLSCREEN) goto L15;
        if (r101.floatValue() > 0.0f) goto L14;
        return null;
    L14:
        return Float.valueOf(RangesKt.coerceAtMost(r101.floatValue(), 1.0f));
    }

    public static Map c(PhotoSearchParamModel r100) {
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L7;
        ITradeSearchHostAppInfo r102 = r101.getITradeSearchHostAppInfo();
        if (r102 == null) goto L7;
        boolean r103 = r102.isNightMode();
    L8:
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("tab_label_name", "ecom_photo_search");
        String r105 = "";
        if (r100 == null) goto L14;
        PhotoEnterModel r106 = r100.getPhotoEnterModel();
        if (r106 == null) goto L14;
        String r107 = r106.getEnterFrom();
        if (r107 == null) goto L14;
    L15:
        r104.put("search_enter_from", r107);
        if (r100 == null) goto L21;
        PhotoEnterModel r108 = r100.getPhotoEnterModel();
        if (r108 == null) goto L21;
        String r109 = r108.getSearchChannel();
        if (r109 == null) goto L21;
    L22:
        r104.put("channel", r109);
        if (r100 == null) goto L28;
        PhotoEnterModel r110 = r100.getPhotoEnterModel();
        if (r110 == null) goto L28;
        String r111 = r110.getEnterMethod();
        if (r111 == null) goto L28;
    L29:
        r104.put("enter_method", r111);
        if (r103 == false) goto L32;
        String r112 = "1";
    L33:
        r104.put("is_night_mode", r112);
        ResultPanelStatus r113 = null;
        if (r100 == null) goto L38;
        PhotoEnterModel r114 = r100.getPhotoEnterModel();
        if (r114 == null) goto L38;
        String r115 = r114.getLocalFilePath();
    L39:
        r104.put("has_local_path", Integer.valueOf(!TextUtils.isEmpty(r115) ? 1 : 0));
        if (r100 == null) goto L47;
        PhotoEnterModel r116 = r100.getPhotoEnterModel();
        if (r116 == null) goto L47;
        String r117 = r116.getSearchEntrance();
        if (r117 == null) goto L47;
        r105 = r117;
    L47:
        r104.put("photo_search_entrance", r105);
        if (r100 == null) goto L53;
        PhotoSearchUIConfig r118 = r100.getPhotoSearchUIConfig();
        if (r118 == null) goto L53;
        r113 = r118.getResultPanelPattern();
    L53:
        if (r113 != ResultPanelStatus.HALFSCREEN) goto L55;
        int r119 = 7;
    L56:
        r104.put("screen_type", Integer.valueOf(r119));
        f454046a.getClass();
        if (r100 == null) goto L63;
        PhotoEnterModel r120 = r100.getPhotoEnterModel();
        if (r120 == null) goto L63;
        if (r120.getForbidFirstEnterAnim() != true) goto L63;
        String r121 = "forbid_first_enter_anim";
    L64:
        r104.put("srp_display_type", r121);
        return r104;
    L63:
        r121 = "normal";
        goto L64
    L55:
        r119 = 10;
    L38:
        r115 = null;
        goto L39
    L32:
        r112 = "0";
    L28:
        r111 = "";
    L21:
        r109 = "";
    L14:
        r107 = "";
    L7:
        r103 = false;
        goto L8
    }

    public static boolean d(PhotoEnterModel r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getSearchEntrance();
    L7:
        if ((!Intrinsics.areEqual(r102, "find_similar_big_promotion")) == false) goto L28;
        if (r100 == null) goto L10;
        String r103 = r100.getSearchEntrance();
    L12:
        if ((!Intrinsics.areEqual(r103, "video_to_mall_find_same_bubble")) == false) goto L28;
        if (r100 == null) goto L15;
        String r104 = r100.getSearchEntrance();
    L17:
        if ((!Intrinsics.areEqual(r104, "video_to_mall_find_same_single")) == false) goto L28;
        if (r100 == null) goto L20;
        String r105 = r100.getSearchEntrance();
    L22:
        if ((!Intrinsics.areEqual(r105, "video_to_mall_find_same_multi")) == false) goto L28;
        if (r100 == null) goto L26;
        r101 = r100.getSearchEntrance();
    L26:
        if ((!Intrinsics.areEqual(r101, "video_to_mall_find_same_loading")) == false) goto L28;
        return true;
    L20:
        r105 = null;
        goto L22
    L15:
        r104 = null;
        goto L17
    L10:
        r103 = null;
    L28:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public static boolean e(PhotoEnterModel r100) {
        if (r100 == null) goto L7;
        String r101 = r100.getClientParams();
        if (r101 == null) goto L12;
        return new JSONObject(r101).optBoolean("product_detail_auto_show");
    L13:
        return false;
    L12:
        return false;
    L7:
        return false;
    }

    public static boolean f(PhotoEnterModel r100) {
        if (r100 == null) goto L9;
        String r101 = r100.getClientParams();
        if (r101 == null) goto L9;
        if (new JSONObject(r101).optInt("rounded_sticky_style") != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public static boolean g(PhotoSearchParamModel r100) {
        if (r100 == null) goto L12;
        PhotoEnterModel r101 = r100.getPhotoEnterModel();
        if (r101 == null) goto L12;
        if (r101.getForbidFirstEnterAnim() != true) goto L12;
        PhotoEnterModel r102 = r100.getPhotoEnterModel();
        if (r102 == null) goto L12;
        if (r102.getForbidBackgroundAnim() == true) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean h(PhotoEnterModel r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getSearchImageUrl();
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L17;
        PhotoSearchConfigSettings.f451589c.getClass();
        List<String> r103 = PhotoSearchConfigSettings.f451587a.getImageOptForbidEntrance();
        if (r103 != null) goto L11;
        r103 = CollectionsKt.emptyList();
    L11:
        List<String> r104 = r103;
        if (r100 == null) goto L15;
        r101 = r100.getSearchEntrance();
    L15:
        if (CollectionsKt.contains(r104, r101) == true) goto L17;
        return true;
    L17:
        return false;
    L5:
        r102 = null;
        goto L7
    }
}
