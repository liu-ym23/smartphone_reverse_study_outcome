package com.bytedance.locallife.model.album;

import android.net.Uri;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\bR\b\u0086\b\u0018\u0000 \u0096\u00012\u00020\u0001:\u0002\u0097\u0001B»\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u0002\u0012\b\b\u0002\u0010'\u001a\u00020\u0002\u0012\b\b\u0002\u0010(\u001a\u00020\u0002\u0012\b\b\u0002\u0010)\u001a\u00020\u0002\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\b\b\u0002\u0010+\u001a\u00020\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u0002\u0012\b\b\u0002\u0010-\u001a\u00020\n\u0012\b\b\u0002\u0010.\u001a\u00020\u0002\u0012\b\b\u0002\u0010/\u001a\u00020\r\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u00101\u001a\u00020\u0002\u0012\b\b\u0002\u00102\u001a\u00020\r\u0012\b\b\u0002\u00103\u001a\u00020\n\u0012\b\b\u0002\u00104\u001a\u00020\u0002\u0012\b\b\u0002\u00105\u001a\u00020\u0002\u0012\b\b\u0002\u00106\u001a\u00020\u0002\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u00108\u001a\u00020\r\u0012\b\b\u0002\u00109\u001a\u00020\r\u0012\b\b\u0002\u0010:\u001a\u00020\u0002\u0012\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b\u0012\b\b\u0002\u0010<\u001a\u00020\r\u0012\b\b\u0002\u0010=\u001a\u00020\r\u0012\b\b\u0002\u0010>\u001a\u00020\r\u0012\b\b\u0002\u0010?\u001a\u00020\n\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010B\u001a\u00020\r¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0002HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000b\u001a\u00020\nHÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003J\t\u0010\u000e\u001a\u00020\rHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010\u0011\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0012\u001a\u00020\rHÆ\u0003J\t\u0010\u0013\u001a\u00020\nHÆ\u0003J\t\u0010\u0014\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0018\u001a\u00020\rHÆ\u0003J\t\u0010\u0019\u001a\u00020\rHÆ\u0003J\t\u0010\u001a\u001a\u00020\u0002HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bHÆ\u0003J\t\u0010\u001e\u001a\u00020\rHÆ\u0003J\t\u0010\u001f\u001a\u00020\rHÆ\u0003J\t\u0010 \u001a\u00020\rHÆ\u0003J\t\u0010!\u001a\u00020\nHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010#HÆ\u0003J\t\u0010%\u001a\u00020\rHÆ\u0003J»\u0002\u0010C\u001a\u00020\u00002\b\b\u0002\u0010&\u001a\u00020\u00022\b\b\u0002\u0010'\u001a\u00020\u00022\b\b\u0002\u0010(\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020\u00022\b\b\u0002\u0010*\u001a\u00020\u00022\b\b\u0002\u0010+\u001a\u00020\u00022\b\b\u0002\u0010,\u001a\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\n2\b\b\u0002\u0010.\u001a\u00020\u00022\b\b\u0002\u0010/\u001a\u00020\r2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u00101\u001a\u00020\u00022\b\b\u0002\u00102\u001a\u00020\r2\b\b\u0002\u00103\u001a\u00020\n2\b\b\u0002\u00104\u001a\u00020\u00022\b\b\u0002\u00105\u001a\u00020\u00022\b\b\u0002\u00106\u001a\u00020\u00022\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u00108\u001a\u00020\r2\b\b\u0002\u00109\u001a\u00020\r2\b\b\u0002\u0010:\u001a\u00020\u00022\u0010\b\u0002\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b2\b\b\u0002\u0010<\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\r2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010?\u001a\u00020\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010A\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010B\u001a\u00020\rHÆ\u0001J\t\u0010D\u001a\u00020\u0002HÖ\u0001J\t\u0010E\u001a\u00020\nHÖ\u0001J\u0013\u0010H\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010FHÖ\u0003R\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010'\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010I\u001a\u0004\bN\u0010K\"\u0004\bO\u0010MR\"\u0010(\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010I\u001a\u0004\bP\u0010K\"\u0004\bQ\u0010MR\"\u0010)\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010I\u001a\u0004\bR\u0010K\"\u0004\bS\u0010MR\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010I\u001a\u0004\bT\u0010K\"\u0004\bU\u0010MR\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010I\u001a\u0004\bV\u0010K\"\u0004\bW\u0010MR\"\u0010,\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010I\u001a\u0004\bX\u0010K\"\u0004\bY\u0010MR\"\u0010-\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010.\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010I\u001a\u0004\b_\u0010K\"\u0004\b`\u0010MR\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u00100\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u00101\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010I\u001a\u0004\bk\u0010K\"\u0004\bl\u0010MR\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010a\u001a\u0004\bm\u0010c\"\u0004\bn\u0010eR\"\u00103\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010Z\u001a\u0004\bo\u0010\\\"\u0004\bp\u0010^R\"\u00104\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010I\u001a\u0004\bq\u0010K\"\u0004\br\u0010MR\"\u00105\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010I\u001a\u0004\bs\u0010K\"\u0004\bt\u0010MR\"\u00106\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u0010I\u001a\u0004\bu\u0010K\"\u0004\bv\u0010MR$\u00107\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010I\u001a\u0004\bw\u0010K\"\u0004\bx\u0010MR\"\u00108\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010a\u001a\u0004\by\u0010c\"\u0004\bz\u0010eR\"\u00109\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010a\u001a\u0004\b{\u0010c\"\u0004\b|\u0010eR\"\u0010:\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010I\u001a\u0004\b}\u0010K\"\u0004\b~\u0010MR.\u0010;\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0004\b;\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0006\b\u0082\u0001\u0010\u0083\u0001R$\u0010<\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b<\u0010a\u001a\u0005\b\u0084\u0001\u0010c\"\u0005\b\u0085\u0001\u0010eR$\u0010=\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b=\u0010a\u001a\u0005\b\u0086\u0001\u0010c\"\u0005\b\u0087\u0001\u0010eR#\u0010>\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0013\n\u0004\b>\u0010a\u001a\u0004\b>\u0010c\"\u0005\b\u0088\u0001\u0010eR$\u0010?\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b?\u0010Z\u001a\u0005\b\u0089\u0001\u0010\\\"\u0005\b\u008a\u0001\u0010^R&\u0010@\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b@\u0010I\u001a\u0005\b\u008b\u0001\u0010K\"\u0005\b\u008c\u0001\u0010MR)\u0010A\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\bA\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R$\u0010B\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\bB\u0010a\u001a\u0005\b\u0092\u0001\u0010c\"\u0005\b\u0093\u0001\u0010e¨\u0006\u0098\u0001"}, d2 = {"Lcom/bytedance/locallife/model/album/PoiAlbumParams;", "Ljava/io/Serializable;", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "component9", "", "component10", "Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "", "Lcom/ss/android/ugc/aweme/poi/model/AlbumTabListModel;", "component22", "component23", "component24", "component25", "component26", "component27", "Lcom/bytedance/locallife/model/album/PoiCoinLabel;", "component28", "component29", "poiId", "poiName", "enterFrom", "enterMethod", "poiBackendType", "productId", "traceSessionId", "poiPicMode", "screenMode", "showUploadButton", "poiBundle", "anchorTab", "needAnchor", "anchorIndex", "extraParams", "extraMobParams", "albumBottomBarParamsString", "anchorTabId", "showShareIcon", "showMoreIconOnly", "anchorPagerType", "photoPageTabList", "useNewStyle", "videoDarkMode", "isHomePoiStyle", "checkInVideoCnt", "albumEnterMethod", "poiCoinLabel", "showSingleLineFilterOnly", "copy", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getPoiId", "()Ljava/lang/String;", "setPoiId", "(Ljava/lang/String;)V", "getPoiName", "setPoiName", "getEnterFrom", "setEnterFrom", "getEnterMethod", "setEnterMethod", "getPoiBackendType", "setPoiBackendType", "getProductId", "setProductId", "getTraceSessionId", "setTraceSessionId", "I", "getPoiPicMode", "()I", "setPoiPicMode", "(I)V", "getScreenMode", "setScreenMode", "Z", "getShowUploadButton", "()Z", "setShowUploadButton", "(Z)V", "Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", "getPoiBundle", "()Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;", "setPoiBundle", "(Lcom/ss/android/ugc/aweme/poi/model/PoiBundle;)V", "getAnchorTab", "setAnchorTab", "getNeedAnchor", "setNeedAnchor", "getAnchorIndex", "setAnchorIndex", "getExtraParams", "setExtraParams", "getExtraMobParams", "setExtraMobParams", "getAlbumBottomBarParamsString", "setAlbumBottomBarParamsString", "getAnchorTabId", "setAnchorTabId", "getShowShareIcon", "setShowShareIcon", "getShowMoreIconOnly", "setShowMoreIconOnly", "getAnchorPagerType", "setAnchorPagerType", "Ljava/util/List;", "getPhotoPageTabList", "()Ljava/util/List;", "setPhotoPageTabList", "(Ljava/util/List;)V", "getUseNewStyle", "setUseNewStyle", "getVideoDarkMode", "setVideoDarkMode", "setHomePoiStyle", "getCheckInVideoCnt", "setCheckInVideoCnt", "getAlbumEnterMethod", "setAlbumEnterMethod", "Lcom/bytedance/locallife/model/album/PoiCoinLabel;", "getPoiCoinLabel", "()Lcom/bytedance/locallife/model/album/PoiCoinLabel;", "setPoiCoinLabel", "(Lcom/bytedance/locallife/model/album/PoiCoinLabel;)V", "getShowSingleLineFilterOnly", "setShowSingleLineFilterOnly", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZLcom/ss/android/ugc/aweme/poi/model/PoiBundle;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/util/List;ZZZILjava/lang/String;Lcom/bytedance/locallife/model/album/PoiCoinLabel;Z)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumParams implements Serializable {
    public static final a Companion = null;
    private String albumBottomBarParamsString;
    private String albumEnterMethod;
    private int anchorIndex;
    private String anchorPagerType;
    private String anchorTab;
    private String anchorTabId;
    private int checkInVideoCnt;
    private String enterFrom;
    private String enterMethod;
    private String extraMobParams;
    private String extraParams;
    private boolean isHomePoiStyle;
    private boolean needAnchor;
    private List<AlbumTabListModel> photoPageTabList;
    private String poiBackendType;
    private PoiBundle poiBundle;
    private PoiCoinLabel poiCoinLabel;
    private String poiId;
    private String poiName;
    private int poiPicMode;
    private String productId;
    private String screenMode;
    private boolean showMoreIconOnly;
    private boolean showShareIcon;
    private boolean showSingleLineFilterOnly;
    private boolean showUploadButton;
    private String traceSessionId;
    private boolean useNewStyle;
    private boolean videoDarkMode;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static PoiAlbumParams a(Uri r310) {
            Intrinsics.checkNotNullParameter(r310, "uri");
            PoiAlbumParams r100 = new PoiAlbumParams(null, null, null, null, null, null, null, 0, null, false, null, null, false, 0, null, null, null, null, false, false, null, null, false, false, false, 0, null, null, false, 536870911, null);
            String r101 = b(r310, "poi_id");
            if (r101 == null) goto L5;
            r100.setPoiId(r101);
        L5:
            String r102 = b(r310, "poi_name");
            if (r102 == null) goto L8;
            r100.setPoiName(r102);
        L8:
            String r103 = b(r310, "poi_backend_type");
            if (r103 == null) goto L11;
            r100.setPoiBackendType(r103);
        L11:
            String r104 = b(r310, "enter_from");
            if (r104 == null) goto L14;
            r100.setEnterFrom(r104);
        L14:
            String r105 = b(r310, "enter_method");
            if (r105 == null) goto L17;
            r100.setEnterMethod(r105);
        L17:
            String r106 = b(r310, LiveLocalLifeRoomInfo.TRACE_SESSION_ID);
            if (r106 == null) goto L20;
            r100.setTraceSessionId(r106);
        L20:
            String r107 = b(r310, "tab_id");
            if (r107 == null) goto L23;
            r100.setAnchorTabId(r107);
        L23:
            String r108 = b(r310, "screen_mode");
            if (r108 == null) goto L26;
            r100.setScreenMode(r108);
        L26:
            String r109 = b(r310, "product_id");
            if (r109 == null) goto L29;
            r100.setProductId(r109);
        L29:
            String r110 = b(r310, "anchor_tab");
            if (r110 == null) goto L32;
            r100.setAnchorTab(r110);
        L32:
            String r111 = b(r310, "anchor_pager_type");
            if (r111 == null) goto L35;
            r100.setAnchorPagerType(r111);
        L35:
            String r112 = b(r310, "extra_params");
            if (r112 == null) goto L38;
            r100.setExtraParams(r112);
        L38:
            String r113 = b(r310, "extra_mob_params");
            if (r113 == null) goto L41;
            r100.setExtraMobParams(r113);
        L41:
            String r114 = b(r310, "anchor_index");
            if (r114 == null) goto L46;
            Integer r115 = StringsKt.toIntOrNull(r114);
            if (r115 == null) goto L46;
            r100.setAnchorIndex(r115.intValue());
        L46:
            String r116 = b(r310, "poi_pic_mode");
            if (r116 == null) goto L51;
            Integer r117 = StringsKt.toIntOrNull(r116);
            if (r117 == null) goto L51;
            r100.setPoiPicMode(r117.intValue());
        L51:
            String r118 = b(r310, "need_anchor");
            boolean r119 = true;
            if (r118 != null) goto L54;
        L61:
            String r120 = b(r310, "show_upload_button");
            if (r120 != null) goto L64;
        L71:
            String r121 = b(r310, "show_share_icon");
            if (r121 != null) goto L74;
        L81:
            String r122 = b(r310, "show_more_icon_only");
            if (r122 != null) goto L84;
        L90:
            return r100;
        L84:
            if (Intrinsics.areEqual(r122, "true") == false) goto L86;
        L89:
            r100.setShowMoreIconOnly(r119);
            goto L90
        L86:
            if (Intrinsics.areEqual(r122, "1") == true) goto L89;
            r119 = false;
            goto L89
        L74:
            if (Intrinsics.areEqual(r121, "true") == false) goto L76;
        L79:
            boolean r123 = true;
        L80:
            r100.setShowShareIcon(r123);
            goto L81
        L76:
            if (Intrinsics.areEqual(r121, "1") == true) goto L79;
            r123 = false;
            goto L80
        L64:
            if (Intrinsics.areEqual(r120, "true") == false) goto L66;
        L69:
            boolean r124 = true;
        L70:
            r100.setShowUploadButton(r124);
            goto L71
        L66:
            if (Intrinsics.areEqual(r120, "1") == true) goto L69;
            r124 = false;
            goto L70
        L54:
            if (Intrinsics.areEqual(r118, "true") == false) goto L56;
        L59:
            boolean r125 = true;
        L60:
            r100.setNeedAnchor(r125);
            goto L61
        L56:
            if (Intrinsics.areEqual(r118, "1") == true) goto L59;
            r125 = false;
            goto L60
        }

        public static final String b(Uri r100, String r101) {
            return UriProtector.getQueryParameter(r100, r101);
        L4:
            return null;
        }
    }

    static {
        Companion = new a();
    }

    public PoiAlbumParams() {
        this(null, null, null, null, null, null, null, 0, null, false, null, null, false, 0, null, null, null, null, false, false, null, null, false, false, false, 0, null, null, false, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PoiAlbumParams copy$default(PoiAlbumParams r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, int r215, String r216, boolean r217, PoiBundle r218, String r219, boolean r310, int r311, String r312, String r313, String r314, String r315, boolean r316, boolean r317, String r318, List r319, boolean r410, boolean r411, boolean r412, int r413, String r414, PoiCoinLabel r415, boolean r416, int r417, Object r418) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = r110.poiId;
    L7:
        if ((r417 & 2) == 0) goto L9;
        String r101 = r110.poiName;
    L11:
        if ((r417 & 4) == 0) goto L13;
        String r102 = r110.enterFrom;
    L15:
        if ((r417 & 8) == 0) goto L17;
        String r103 = r110.enterMethod;
    L19:
        if ((r417 & 16) == 0) goto L21;
        String r104 = r110.poiBackendType;
    L23:
        if ((r417 & 32) == 0) goto L25;
        String r105 = r110.productId;
    L27:
        if ((r417 & 64) == 0) goto L29;
        String r106 = r110.traceSessionId;
    L31:
        if ((r417 & 128) == 0) goto L33;
        int r107 = r110.poiPicMode;
    L35:
        if ((r417 & 256) == 0) goto L37;
        String r113 = r110.screenMode;
    L39:
        if ((r417 & 512) == 0) goto L41;
        boolean r114 = r110.showUploadButton;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        PoiBundle r115 = r110.poiBundle;
    L47:
        if ((r417 & 2048) == 0) goto L49;
        String r116 = r110.anchorTab;
    L51:
        if ((r417 & 4096) == 0) goto L53;
        boolean r117 = r110.needAnchor;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        int r118 = r110.anchorIndex;
    L58:
        int r320 = r118;
        if ((r417 & 16384) == 0) goto L61;
        String r119 = r110.extraParams;
    L62:
        String r321 = r119;
        if ((r417 & 32768) == 0) goto L65;
        String r120 = r110.extraMobParams;
    L66:
        String r322 = r120;
        if ((r417 & 65536) == 0) goto L69;
        String r121 = r110.albumBottomBarParamsString;
    L70:
        String r323 = r121;
        if ((r417 & 131072) == 0) goto L73;
        String r122 = r110.anchorTabId;
    L74:
        String r324 = r122;
        if ((r417 & 262144) == 0) goto L77;
        boolean r123 = r110.showShareIcon;
    L78:
        boolean r325 = r123;
        if ((r417 & 524288) == 0) goto L81;
        boolean r124 = r110.showMoreIconOnly;
    L82:
        boolean r326 = r124;
        if ((r417 & 1048576) == 0) goto L85;
        String r125 = r110.anchorPagerType;
    L86:
        String r327 = r125;
        if ((r417 & 2097152) == 0) goto L89;
        List r126 = r110.photoPageTabList;
    L90:
        List r328 = r126;
        if ((r417 & 4194304) == 0) goto L93;
        boolean r127 = r110.useNewStyle;
    L94:
        boolean r419 = r127;
        if ((r417 & 8388608) == 0) goto L97;
        boolean r128 = r110.videoDarkMode;
    L98:
        boolean r420 = r128;
        if ((r417 & 16777216) == 0) goto L101;
        boolean r129 = r110.isHomePoiStyle;
    L102:
        boolean r421 = r129;
        if ((r417 & 33554432) == 0) goto L105;
        int r130 = r110.checkInVideoCnt;
    L106:
        int r422 = r130;
        if ((r417 & 67108864) == 0) goto L109;
        String r131 = r110.albumEnterMethod;
    L110:
        String r423 = r131;
        if ((r417 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        PoiCoinLabel r132 = r110.poiCoinLabel;
    L115:
        if ((r417 & 268435456) == 0) goto L117;
        boolean r108 = r110.showSingleLineFilterOnly;
    L119:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r419, r420, r421, r422, r423, r132, r108);
    L117:
        r108 = r416;
        goto L119
    L113:
        r132 = r415;
        goto L115
    L109:
        r131 = r414;
        goto L110
    L105:
        r130 = r413;
        goto L106
    L101:
        r129 = r412;
        goto L102
    L97:
        r128 = r411;
        goto L98
    L93:
        r127 = r410;
        goto L94
    L89:
        r126 = r319;
        goto L90
    L85:
        r125 = r318;
        goto L86
    L81:
        r124 = r317;
        goto L82
    L77:
        r123 = r316;
        goto L78
    L73:
        r122 = r315;
        goto L74
    L69:
        r121 = r314;
        goto L70
    L65:
        r120 = r313;
        goto L66
    L61:
        r119 = r312;
        goto L62
    L57:
        r118 = r311;
        goto L58
    L53:
        r117 = r310;
        goto L55
    L49:
        r116 = r219;
        goto L51
    L45:
        r115 = r218;
        goto L47
    L41:
        r114 = r217;
        goto L43
    L37:
        r113 = r216;
        goto L39
    L33:
        r107 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    @JvmStatic
    public static final PoiAlbumParams parseFromSchema(Uri r100) {
        Companion.getClass();
        return a.a(r100);
    }

    public final String component1() {
        return this.poiId;
    }

    public final boolean component10() {
        return this.showUploadButton;
    }

    public final PoiBundle component11() {
        return this.poiBundle;
    }

    public final String component12() {
        return this.anchorTab;
    }

    public final boolean component13() {
        return this.needAnchor;
    }

    public final int component14() {
        return this.anchorIndex;
    }

    public final String component15() {
        return this.extraParams;
    }

    public final String component16() {
        return this.extraMobParams;
    }

    public final String component17() {
        return this.albumBottomBarParamsString;
    }

    public final String component18() {
        return this.anchorTabId;
    }

    public final boolean component19() {
        return this.showShareIcon;
    }

    public final String component2() {
        return this.poiName;
    }

    public final boolean component20() {
        return this.showMoreIconOnly;
    }

    public final String component21() {
        return this.anchorPagerType;
    }

    public final List<AlbumTabListModel> component22() {
        return this.photoPageTabList;
    }

    public final boolean component23() {
        return this.useNewStyle;
    }

    public final boolean component24() {
        return this.videoDarkMode;
    }

    public final boolean component25() {
        return this.isHomePoiStyle;
    }

    public final int component26() {
        return this.checkInVideoCnt;
    }

    public final String component27() {
        return this.albumEnterMethod;
    }

    public final PoiCoinLabel component28() {
        return this.poiCoinLabel;
    }

    public final boolean component29() {
        return this.showSingleLineFilterOnly;
    }

    public final String component3() {
        return this.enterFrom;
    }

    public final String component4() {
        return this.enterMethod;
    }

    public final String component5() {
        return this.poiBackendType;
    }

    public final String component6() {
        return this.productId;
    }

    public final String component7() {
        return this.traceSessionId;
    }

    public final int component8() {
        return this.poiPicMode;
    }

    public final String component9() {
        return this.screenMode;
    }

    public final PoiAlbumParams copy(String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r410, String r411, boolean r412, PoiBundle r413, String r414, boolean r415, int r416, String r417, String r418, String r419, String r510, boolean r511, boolean r512, String r513, List<AlbumTabListModel> r514, boolean r515, boolean r516, boolean r517, int r518, String r519, PoiCoinLabel r610, boolean r611) {
        Intrinsics.checkNotNullParameter(r310, "poiId");
        Intrinsics.checkNotNullParameter(r311, "poiName");
        Intrinsics.checkNotNullParameter(r312, "enterFrom");
        Intrinsics.checkNotNullParameter(r313, "enterMethod");
        Intrinsics.checkNotNullParameter(r314, "poiBackendType");
        Intrinsics.checkNotNullParameter(r315, "productId");
        Intrinsics.checkNotNullParameter(r316, "traceSessionId");
        Intrinsics.checkNotNullParameter(r411, "screenMode");
        Intrinsics.checkNotNullParameter(r414, "anchorTab");
        Intrinsics.checkNotNullParameter(r417, "extraParams");
        Intrinsics.checkNotNullParameter(r418, "extraMobParams");
        Intrinsics.checkNotNullParameter(r419, "albumBottomBarParamsString");
        Intrinsics.checkNotNullParameter(r513, "anchorPagerType");
        return new PoiAlbumParams(r310, r311, r312, r313, r314, r315, r316, r410, r411, r412, r413, r414, r415, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r519, r610, r611);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiAlbumParams) == true) goto L8;
        return false;
    L8:
        PoiAlbumParams r101 = (PoiAlbumParams) r100;
        if (Intrinsics.areEqual(this.poiId, r101.poiId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.poiName, r101.poiName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enterFrom, r101.enterFrom) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.poiBackendType, r101.poiBackendType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.traceSessionId, r101.traceSessionId) == true) goto L30;
        return false;
    L30:
        if (this.poiPicMode == r101.poiPicMode) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.screenMode, r101.screenMode) == true) goto L36;
        return false;
    L36:
        if (this.showUploadButton == r101.showUploadButton) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.poiBundle, r101.poiBundle) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.anchorTab, r101.anchorTab) == true) goto L45;
        return false;
    L45:
        if (this.needAnchor == r101.needAnchor) goto L48;
        return false;
    L48:
        if (this.anchorIndex == r101.anchorIndex) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.extraParams, r101.extraParams) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.extraMobParams, r101.extraMobParams) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.albumBottomBarParamsString, r101.albumBottomBarParamsString) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.anchorTabId, r101.anchorTabId) == true) goto L63;
        return false;
    L63:
        if (this.showShareIcon == r101.showShareIcon) goto L66;
        return false;
    L66:
        if (this.showMoreIconOnly == r101.showMoreIconOnly) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.anchorPagerType, r101.anchorPagerType) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.photoPageTabList, r101.photoPageTabList) == true) goto L75;
        return false;
    L75:
        if (this.useNewStyle == r101.useNewStyle) goto L78;
        return false;
    L78:
        if (this.videoDarkMode == r101.videoDarkMode) goto L81;
        return false;
    L81:
        if (this.isHomePoiStyle == r101.isHomePoiStyle) goto L84;
        return false;
    L84:
        if (this.checkInVideoCnt == r101.checkInVideoCnt) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.albumEnterMethod, r101.albumEnterMethod) == true) goto L90;
        return false;
    L90:
        if (Intrinsics.areEqual(this.poiCoinLabel, r101.poiCoinLabel) == true) goto L93;
        return false;
    L93:
        if (this.showSingleLineFilterOnly == r101.showSingleLineFilterOnly) goto L95;
        return false;
    L95:
        return true;
    }

    public int hashCode() {
        int r100 = ((((((((((((((((this.poiId.hashCode() * 31) + this.poiName.hashCode()) * 31) + this.enterFrom.hashCode()) * 31) + this.enterMethod.hashCode()) * 31) + this.poiBackendType.hashCode()) * 31) + this.productId.hashCode()) * 31) + this.traceSessionId.hashCode()) * 31) + this.poiPicMode) * 31) + this.screenMode.hashCode()) * 31;
        int r101 = 1231;
        if (this.showUploadButton == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        PoiBundle r104 = this.poiBundle;
        int r105 = 0;
        if (r104 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r103 + r106) * 31) + this.anchorTab.hashCode()) * 31;
        if (this.needAnchor == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (((((((((r107 + r108) * 31) + this.anchorIndex) * 31) + this.extraParams.hashCode()) * 31) + this.extraMobParams.hashCode()) * 31) + this.albumBottomBarParamsString.hashCode()) * 31;
        String r110 = this.anchorTabId;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.showShareIcon == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.showMoreIconOnly == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (((r114 + r115) * 31) + this.anchorPagerType.hashCode()) * 31;
        List<AlbumTabListModel> r117 = this.photoPageTabList;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        if (this.useNewStyle == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        if (this.videoDarkMode == false) goto L37;
        int r122 = 1231;
    L38:
        int r123 = (r121 + r122) * 31;
        if (this.isHomePoiStyle == false) goto L41;
        int r124 = 1231;
    L42:
        int r125 = (((r123 + r124) * 31) + this.checkInVideoCnt) * 31;
        String r126 = this.albumEnterMethod;
        if (r126 != null) goto L45;
        int r127 = 0;
    L46:
        int r128 = (r125 + r127) * 31;
        PoiCoinLabel r129 = this.poiCoinLabel;
        if (r129 == null) goto L50;
        r105 = r129.hashCode();
    L50:
        int r130 = (r128 + r105) * 31;
        if (this.showSingleLineFilterOnly == true) goto L55;
        r101 = 1237;
    L55:
        return r130 + r101;
    L45:
        r127 = r126.hashCode();
        goto L46
    L41:
        r124 = 1237;
        goto L42
    L37:
        r122 = 1237;
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "PoiAlbumParams(poiId=" + this.poiId + ", poiName=" + this.poiName + ", enterFrom=" + this.enterFrom + ", enterMethod=" + this.enterMethod + ", poiBackendType=" + this.poiBackendType + ", productId=" + this.productId + ", traceSessionId=" + this.traceSessionId + ", poiPicMode=" + this.poiPicMode + ", screenMode=" + this.screenMode + ", showUploadButton=" + this.showUploadButton + ", poiBundle=" + this.poiBundle + ", anchorTab=" + this.anchorTab + ", needAnchor=" + this.needAnchor + ", anchorIndex=" + this.anchorIndex + ", extraParams=" + this.extraParams + ", extraMobParams=" + this.extraMobParams + ", albumBottomBarParamsString=" + this.albumBottomBarParamsString + ", anchorTabId=" + this.anchorTabId + ", showShareIcon=" + this.showShareIcon + ", showMoreIconOnly=" + this.showMoreIconOnly + ", anchorPagerType=" + this.anchorPagerType + ", photoPageTabList=" + this.photoPageTabList + ", useNewStyle=" + this.useNewStyle + ", videoDarkMode=" + this.videoDarkMode + ", isHomePoiStyle=" + this.isHomePoiStyle + ", checkInVideoCnt=" + this.checkInVideoCnt + ", albumEnterMethod=" + this.albumEnterMethod + ", poiCoinLabel=" + this.poiCoinLabel + ", showSingleLineFilterOnly=" + this.showSingleLineFilterOnly + ')';
    }

    public final String getAlbumBottomBarParamsString() {
        return this.albumBottomBarParamsString;
    }

    public final String getAlbumEnterMethod() {
        return this.albumEnterMethod;
    }

    public final int getAnchorIndex() {
        return this.anchorIndex;
    }

    public final String getAnchorPagerType() {
        return this.anchorPagerType;
    }

    public final String getAnchorTab() {
        return this.anchorTab;
    }

    public final String getAnchorTabId() {
        return this.anchorTabId;
    }

    public final int getCheckInVideoCnt() {
        return this.checkInVideoCnt;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getExtraMobParams() {
        return this.extraMobParams;
    }

    public final String getExtraParams() {
        return this.extraParams;
    }

    public final boolean getNeedAnchor() {
        return this.needAnchor;
    }

    public final List<AlbumTabListModel> getPhotoPageTabList() {
        return this.photoPageTabList;
    }

    public final String getPoiBackendType() {
        return this.poiBackendType;
    }

    public final PoiBundle getPoiBundle() {
        return this.poiBundle;
    }

    public final PoiCoinLabel getPoiCoinLabel() {
        return this.poiCoinLabel;
    }

    public final String getPoiId() {
        return this.poiId;
    }

    public final String getPoiName() {
        return this.poiName;
    }

    public final int getPoiPicMode() {
        return this.poiPicMode;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getScreenMode() {
        return this.screenMode;
    }

    public final boolean getShowMoreIconOnly() {
        return this.showMoreIconOnly;
    }

    public final boolean getShowShareIcon() {
        return this.showShareIcon;
    }

    public final boolean getShowSingleLineFilterOnly() {
        return this.showSingleLineFilterOnly;
    }

    public final boolean getShowUploadButton() {
        return this.showUploadButton;
    }

    public final String getTraceSessionId() {
        return this.traceSessionId;
    }

    public final boolean getUseNewStyle() {
        return this.useNewStyle;
    }

    public final boolean getVideoDarkMode() {
        return this.videoDarkMode;
    }

    public final boolean isHomePoiStyle() {
        return this.isHomePoiStyle;
    }

    @JvmStatic
    public static final PoiAlbumParams parseFromSchema(String r310) {
        Companion.getClass();
        if (r310 != null) goto L5;
    L8:
        boolean r100 = true;
    L9:
        if (r100 == true) goto L17;
        return a.a(UriProtector.parse(r310));
    L14:
        return new PoiAlbumParams(null, null, null, null, null, null, null, 0, null, false, null, null, false, 0, null, null, null, null, false, false, null, null, false, false, false, 0, null, null, false, 536870911, null);
    L17:
        return new PoiAlbumParams(null, null, null, null, null, null, null, 0, null, false, null, null, false, 0, null, null, null, null, false, false, null, null, false, false, false, 0, null, null, false, 536870911, null);
    L5:
        if (r310.length() == 0) goto L8;
        r100 = false;
        goto L9
    }

    public final void setAlbumBottomBarParamsString(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.albumBottomBarParamsString = r100;
    }

    public final void setAlbumEnterMethod(String r100) {
        this.albumEnterMethod = r100;
    }

    public final void setAnchorIndex(int r100) {
        this.anchorIndex = r100;
    }

    public final void setAnchorPagerType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorPagerType = r100;
    }

    public final void setAnchorTab(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.anchorTab = r100;
    }

    public final void setAnchorTabId(String r100) {
        this.anchorTabId = r100;
    }

    public final void setCheckInVideoCnt(int r100) {
        this.checkInVideoCnt = r100;
    }

    public final void setEnterFrom(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterFrom = r100;
    }

    public final void setEnterMethod(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enterMethod = r100;
    }

    public final void setExtraMobParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraMobParams = r100;
    }

    public final void setExtraParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.extraParams = r100;
    }

    public final void setHomePoiStyle(boolean r100) {
        this.isHomePoiStyle = r100;
    }

    public final void setNeedAnchor(boolean r100) {
        this.needAnchor = r100;
    }

    public final void setPhotoPageTabList(List<AlbumTabListModel> r100) {
        this.photoPageTabList = r100;
    }

    public final void setPoiBackendType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiBackendType = r100;
    }

    public final void setPoiBundle(PoiBundle r100) {
        this.poiBundle = r100;
    }

    public final void setPoiCoinLabel(PoiCoinLabel r100) {
        this.poiCoinLabel = r100;
    }

    public final void setPoiId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiId = r100;
    }

    public final void setPoiName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.poiName = r100;
    }

    public final void setPoiPicMode(int r100) {
        this.poiPicMode = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public final void setScreenMode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.screenMode = r100;
    }

    public final void setShowMoreIconOnly(boolean r100) {
        this.showMoreIconOnly = r100;
    }

    public final void setShowShareIcon(boolean r100) {
        this.showShareIcon = r100;
    }

    public final void setShowSingleLineFilterOnly(boolean r100) {
        this.showSingleLineFilterOnly = r100;
    }

    public final void setShowUploadButton(boolean r100) {
        this.showUploadButton = r100;
    }

    public final void setTraceSessionId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.traceSessionId = r100;
    }

    public final void setUseNewStyle(boolean r100) {
        this.useNewStyle = r100;
    }

    public final void setVideoDarkMode(boolean r100) {
        this.videoDarkMode = r100;
    }

    public PoiAlbumParams(String r110, String r111, String r112, String r113, String r210, String r211, String r212, int r213, String r214, boolean r215, PoiBundle r216, String r217, boolean r218, int r219, String r310, String r311, String r312, String r313, boolean r314, boolean r315, String r316, List<AlbumTabListModel> r317, boolean r318, boolean r319, boolean r410, int r411, String r412, PoiCoinLabel r413, boolean r414) {
        Intrinsics.checkNotNullParameter(r110, "poiId");
        Intrinsics.checkNotNullParameter(r111, "poiName");
        Intrinsics.checkNotNullParameter(r112, "enterFrom");
        Intrinsics.checkNotNullParameter(r113, "enterMethod");
        Intrinsics.checkNotNullParameter(r210, "poiBackendType");
        Intrinsics.checkNotNullParameter(r211, "productId");
        Intrinsics.checkNotNullParameter(r212, "traceSessionId");
        Intrinsics.checkNotNullParameter(r214, "screenMode");
        Intrinsics.checkNotNullParameter(r217, "anchorTab");
        Intrinsics.checkNotNullParameter(r310, "extraParams");
        Intrinsics.checkNotNullParameter(r311, "extraMobParams");
        Intrinsics.checkNotNullParameter(r312, "albumBottomBarParamsString");
        Intrinsics.checkNotNullParameter(r316, "anchorPagerType");
        this.poiId = r110;
        this.poiName = r111;
        this.enterFrom = r112;
        this.enterMethod = r113;
        this.poiBackendType = r210;
        this.productId = r211;
        this.traceSessionId = r212;
        this.poiPicMode = r213;
        this.screenMode = r214;
        this.showUploadButton = r215;
        this.poiBundle = r216;
        this.anchorTab = r217;
        this.needAnchor = r218;
        this.anchorIndex = r219;
        this.extraParams = r310;
        this.extraMobParams = r311;
        this.albumBottomBarParamsString = r312;
        this.anchorTabId = r313;
        this.showShareIcon = r314;
        this.showMoreIconOnly = r315;
        this.anchorPagerType = r316;
        this.photoPageTabList = r317;
        this.useNewStyle = r318;
        this.videoDarkMode = r319;
        this.isHomePoiStyle = r410;
        this.checkInVideoCnt = r411;
        this.albumEnterMethod = r412;
        this.poiCoinLabel = r413;
        this.showSingleLineFilterOnly = r414;
    }

    public /* synthetic */ PoiAlbumParams(String r310, String r311, String r312, String r313, String r314, String r315, String r316, int r317, String r318, boolean r410, PoiBundle r411, String r412, boolean r413, int r414, String r415, String r416, String r417, String r418, boolean r419, boolean r510, String r511, List r512, boolean r513, boolean r514, boolean r515, int r516, String r517, PoiCoinLabel r518, boolean r519, int r610, DefaultConstructorMarker r611) {
        if ((r610 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r610 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r610 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r610 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r610 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r610 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r610 & 64) == 0) goto L29;
        String r106 = "";
    L31:
        if ((r610 & 128) == 0) goto L33;
        int r107 = 0;
    L35:
        if ((r610 & 256) == 0) goto L37;
        String r110 = "";
    L39:
        if ((r610 & 512) == 0) goto L41;
        boolean r111 = false;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        PoiBundle r112 = null;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        String r113 = "";
    L51:
        if ((r610 & 4096) == 0) goto L53;
        boolean r114 = false;
    L55:
        if ((r610 & 8192) == 0) goto L57;
        int r115 = 0;
    L59:
        if ((r610 & 16384) == 0) goto L61;
        String r108 = "";
    L63:
        if ((r610 & 32768) == 0) goto L65;
        String r116 = "";
    L67:
        if ((r610 & 65536) == 0) goto L69;
        String r117 = "";
    L71:
        if ((r610 & 131072) == 0) goto L73;
        String r118 = null;
    L75:
        if ((r610 & 262144) == 0) goto L77;
        boolean r119 = false;
    L79:
        if ((r610 & 524288) == 0) goto L81;
        boolean r210 = false;
    L83:
        if ((r610 & 1048576) == 0) goto L85;
        String r211 = "photo";
    L87:
        if ((r610 & 2097152) == 0) goto L89;
        List r212 = null;
    L91:
        if ((r610 & 4194304) == 0) goto L93;
        boolean r213 = false;
    L95:
        if ((r610 & 8388608) == 0) goto L97;
        boolean r214 = true;
    L99:
        if ((r610 & 16777216) == 0) goto L101;
        boolean r215 = false;
    L103:
        if ((r610 & 33554432) == 0) goto L105;
        int r216 = 0;
    L107:
        if ((r610 & 67108864) == 0) goto L109;
        String r217 = "";
    L111:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        PoiCoinLabel r218 = null;
    L115:
        if ((r610 & 268435456) == 0) goto L117;
        boolean r109 = false;
    L118:
        this(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r115, r108, r116, r117, r118, r119, r210, r211, r212, r213, r214, r215, r216, r217, r218, r109);
        return;
    L117:
        r109 = r519;
        goto L118
    L113:
        r218 = r518;
        goto L115
    L109:
        r217 = r517;
        goto L111
    L105:
        r216 = r516;
        goto L107
    L101:
        r215 = r515;
        goto L103
    L97:
        r214 = r514;
        goto L99
    L93:
        r213 = r513;
        goto L95
    L89:
        r212 = r512;
        goto L91
    L85:
        r211 = r511;
        goto L87
    L81:
        r210 = r510;
        goto L83
    L77:
        r119 = r419;
        goto L79
    L73:
        r118 = r418;
        goto L75
    L69:
        r117 = r417;
        goto L71
    L65:
        r116 = r416;
        goto L67
    L61:
        r108 = r415;
        goto L63
    L57:
        r115 = r414;
        goto L59
    L53:
        r114 = r413;
        goto L55
    L49:
        r113 = r412;
        goto L51
    L45:
        r112 = r411;
        goto L47
    L41:
        r111 = r410;
        goto L43
    L37:
        r110 = r318;
        goto L39
    L33:
        r107 = r317;
        goto L35
    L29:
        r106 = r316;
        goto L31
    L25:
        r105 = r315;
        goto L27
    L21:
        r104 = r314;
        goto L23
    L17:
        r103 = r313;
        goto L19
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }
}
