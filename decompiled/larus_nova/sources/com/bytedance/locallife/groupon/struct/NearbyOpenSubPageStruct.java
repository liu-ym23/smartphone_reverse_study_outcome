package com.bytedance.locallife.groupon.struct;

import android.os.Bundle;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.locallife.live.model.LiveLocalLifeRoomInfo;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.feed.model.nearby.NearbyPageType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0087\b\u0018\u0000 n2\u00020\u0001:\u0001oBÅ\u0001\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010$\u001a\u00020\u0002\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u0012\b\b\u0002\u0010&\u001a\u00020\u000b\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010*\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u0012\b\b\u0002\u0010-\u001a\u00020\u0006¢\u0006\u0004\bl\u0010mJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\bJ\t\u0010\n\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0014\u001a\u00020\u000bHÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0002HÆ\u0003J\u0017\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001aHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003JÇ\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u001e\u001a\u00020\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010$\u001a\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00022\b\b\u0002\u0010&\u001a\u00020\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010*\u001a\u00020\u00022\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a2\b\b\u0002\u0010,\u001a\u00020\u00062\b\b\u0002\u0010-\u001a\u00020\u0006HÆ\u0001J\t\u0010/\u001a\u00020\u000bHÖ\u0001J\t\u00100\u001a\u00020\u0002HÖ\u0001J\u0013\u00102\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001a\u0010\u001e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00103\u001a\u0004\b4\u00105R$\u0010\u001f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010 \u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b;\u00108R\u001c\u0010!\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010<\u001a\u0004\b=\u0010>R\u001c\u0010\"\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\b?\u00108R\u001c\u0010#\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\b@\u00108R\u001a\u0010$\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u00103\u001a\u0004\bA\u00105R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u00103\u001a\u0004\bB\u00105R\"\u0010&\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00106\u001a\u0004\bC\u00108\"\u0004\bD\u0010:R\u001c\u0010'\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u00106\u001a\u0004\bE\u00108R\u001c\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\bF\u00108R\u001c\u0010)\u001a\u0004\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010*\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u00103\u001a\u0004\bJ\u00105R(\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010K\u001a\u0004\bL\u0010MR\u001a\u0010,\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010N\u001a\u0004\bO\u0010PR\u001a\u0010-\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010N\u001a\u0004\bQ\u0010PR$\u0010S\u001a\u0004\u0018\u00010R8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010Z\u001a\u00020Y8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R$\u0010`\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\"\u0010f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bf\u0010N\u001a\u0004\bg\u0010P\"\u0004\bh\u0010iR$\u0010\u0003\u001a\u00020\u00022\u0006\u0010j\u001a\u00020\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0003\u00103\u001a\u0004\bk\u00105¨\u0006p"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyOpenSubPageStruct;", "", "", "pageState", "", "updatePageState", "", "isPageClose", "Lcom/bytedance/locallife/groupon/struct/SizeStyle;", "getSizeStyle", "component1", "", "component2", "component3", "Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "Lcom/bytedance/locallife/groupon/struct/HalfCloseAction;", "component12", "component13", "", "component14", "component15", "component16", "scene", "subPageURL", "traceSessionId", "arrowStyleConfig", "highlightId", "subPageType", "uiStyle", "style", "arrowColor", "targetViewId", "groupId", "halfClosedAction", "disableSlideClose", "trackParams", "preOpenEnable", "preRouteToMain", "copy", "toString", "hashCode", "other", "equals", "I", "getScene", "()I", "Ljava/lang/String;", "getSubPageURL", "()Ljava/lang/String;", "setSubPageURL", "(Ljava/lang/String;)V", "getTraceSessionId", "Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "getArrowStyleConfig", "()Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;", "getHighlightId", "getSubPageType", "getUiStyle", "getStyle", "getArrowColor", "setArrowColor", "getTargetViewId", "getGroupId", "Lcom/bytedance/locallife/groupon/struct/HalfCloseAction;", "getHalfClosedAction", "()Lcom/bytedance/locallife/groupon/struct/HalfCloseAction;", "getDisableSlideClose", "Ljava/util/Map;", "getTrackParams", "()Ljava/util/Map;", "Z", "getPreOpenEnable", "()Z", "getPreRouteToMain", "Landroid/os/Bundle;", "extraParam", "Landroid/os/Bundle;", "getExtraParam", "()Landroid/os/Bundle;", "setExtraParam", "(Landroid/os/Bundle;)V", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "nearbyPageType", "Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "getNearbyPageType", "()Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;", "setNearbyPageType", "(Lcom/ss/android/ugc/aweme/feed/model/nearby/NearbyPageType;)V", "height", "Ljava/lang/Integer;", "getHeight", "()Ljava/lang/Integer;", "setHeight", "(Ljava/lang/Integer;)V", "needPreOpen", "getNeedPreOpen", "setNeedPreOpen", "(Z)V", "<set-?>", "getPageState", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/ArrowStyleConfigStruct;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/locallife/groupon/struct/HalfCloseAction;ILjava/util/Map;ZZ)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyOpenSubPageStruct {
    public static final int ARROW_STYLE_ = 0;
    public static final int ARROW_STYLE_NORMAL = 0;
    public static final a Companion = null;
    public static final int SCENE_OPEN_AFTER_FMP = 2;
    public static final int SCENE_OPEN_IMMEDIATELY = 1;
    public static final int STYLE_ARROW = 1;
    public static final int STYLE_NORMAL = 0;
    public static final int TOP_SLOGAN_TYPE_CONFIGURABLE = 1;
    public static final int TOP_SLOGAN_TYPE_LEGACY = 0;

    @SerializedName("arrow_color")
    private String arrowColor;

    @SerializedName("style_config")
    private final ArrowStyleConfigStruct arrowStyleConfig;

    @SerializedName("disable_slide_close")
    private final int disableSlideClose;
    private Bundle extraParam;

    @SerializedName("group_id")
    private final String groupId;

    @SerializedName("half_closed_action")
    private final HalfCloseAction halfClosedAction;
    private Integer height;

    @SerializedName("highlight_id")
    private final String highlightId;
    private NearbyPageType nearbyPageType;
    private boolean needPreOpen;
    private int pageState;

    @SerializedName("pre_open_enable")
    private final boolean preOpenEnable;

    @SerializedName("pre_route_to_main")
    private final boolean preRouteToMain;

    @SerializedName("scene")
    private final int scene;

    @SerializedName("style")
    private final int style;

    @SerializedName("sub_page_type")
    private final String subPageType;

    @SerializedName("subpage_url")
    private String subPageURL;

    @SerializedName("target_view_id")
    private final String targetViewId;

    @SerializedName(LiveLocalLifeRoomInfo.TRACE_SESSION_ID)
    private final String traceSessionId;

    @SerializedName("track_params")
    private final Map<String, String> trackParams;

    @SerializedName("ui_style")
    private final int uiStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NearbyOpenSubPageStruct() {
        this(0, null, null, null, null, null, 0, 0, null, null, null, null, 0, null, false, false, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NearbyOpenSubPageStruct copy$default(NearbyOpenSubPageStruct r110, int r111, String r112, String r210, ArrowStyleConfigStruct r211, String r212, String r213, int r214, int r215, String r216, String r217, String r218, HalfCloseAction r219, int r310, Map r311, boolean r312, boolean r313, int r314, Object r315) {
        if ((r314 & 1) == 0) goto L5;
        int r100 = r110.scene;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = r110.subPageURL;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = r110.traceSessionId;
    L15:
        if ((r314 & 8) == 0) goto L17;
        ArrowStyleConfigStruct r103 = r110.arrowStyleConfig;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = r110.highlightId;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = r110.subPageType;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r106 = r110.uiStyle;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r107 = r110.style;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = r110.arrowColor;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = r110.targetViewId;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = r110.groupId;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        HalfCloseAction r116 = r110.halfClosedAction;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r117 = r110.disableSlideClose;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Map r118 = r110.trackParams;
    L58:
        Map r316 = r118;
        if ((r314 & 16384) == 0) goto L61;
        boolean r119 = r110.preOpenEnable;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        boolean r108 = r110.preRouteToMain;
    L67:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r113, r114, r115, r116, r117, r316, r119, r108);
    L65:
        r108 = r313;
        goto L67
    L61:
        r119 = r312;
        goto L63
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

    public final int component1() {
        return this.scene;
    }

    public final String component10() {
        return this.targetViewId;
    }

    public final String component11() {
        return this.groupId;
    }

    public final HalfCloseAction component12() {
        return this.halfClosedAction;
    }

    public final int component13() {
        return this.disableSlideClose;
    }

    public final Map<String, String> component14() {
        return this.trackParams;
    }

    public final boolean component15() {
        return this.preOpenEnable;
    }

    public final boolean component16() {
        return this.preRouteToMain;
    }

    public final String component2() {
        return this.subPageURL;
    }

    public final String component3() {
        return this.traceSessionId;
    }

    public final ArrowStyleConfigStruct component4() {
        return this.arrowStyleConfig;
    }

    public final String component5() {
        return this.highlightId;
    }

    public final String component6() {
        return this.subPageType;
    }

    public final int component7() {
        return this.uiStyle;
    }

    public final int component8() {
        return this.style;
    }

    public final String component9() {
        return this.arrowColor;
    }

    public final NearbyOpenSubPageStruct copy(int r110, String r210, String r211, ArrowStyleConfigStruct r212, String r213, String r214, int r215, int r216, String r217, String r218, String r219, HalfCloseAction r310, int r311, Map<String, String> r312, boolean r313, boolean r314) {
        Intrinsics.checkNotNullParameter(r217, "arrowColor");
        return new NearbyOpenSubPageStruct(r110, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyOpenSubPageStruct) == true) goto L8;
        return false;
    L8:
        NearbyOpenSubPageStruct r101 = (NearbyOpenSubPageStruct) r100;
        if (this.scene == r101.scene) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subPageURL, r101.subPageURL) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.traceSessionId, r101.traceSessionId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.arrowStyleConfig, r101.arrowStyleConfig) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.highlightId, r101.highlightId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.subPageType, r101.subPageType) == true) goto L27;
        return false;
    L27:
        if (this.uiStyle == r101.uiStyle) goto L30;
        return false;
    L30:
        if (this.style == r101.style) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.arrowColor, r101.arrowColor) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.targetViewId, r101.targetViewId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.groupId, r101.groupId) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.halfClosedAction, r101.halfClosedAction) == true) goto L45;
        return false;
    L45:
        if (this.disableSlideClose == r101.disableSlideClose) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.trackParams, r101.trackParams) == true) goto L51;
        return false;
    L51:
        if (this.preOpenEnable == r101.preOpenEnable) goto L54;
        return false;
    L54:
        if (this.preRouteToMain == r101.preRouteToMain) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        int r100 = this.scene * 31;
        String r101 = this.subPageURL;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.traceSessionId;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        ArrowStyleConfigStruct r108 = this.arrowStyleConfig;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.highlightId;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.subPageType;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (((((((r113 + r115) * 31) + this.uiStyle) * 31) + this.style) * 31) + this.arrowColor.hashCode()) * 31;
        String r117 = this.targetViewId;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.groupId;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        HalfCloseAction r123 = this.halfClosedAction;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (((r122 + r124) * 31) + this.disableSlideClose) * 31;
        Map<String, String> r126 = this.trackParams;
        if (r126 == null) goto L38;
        r102 = r126.hashCode();
    L38:
        int r127 = (r125 + r102) * 31;
        int r128 = 1231;
        if (this.preOpenEnable == false) goto L41;
        int r129 = 1231;
    L42:
        int r130 = (r127 + r129) * 31;
        if (this.preRouteToMain == true) goto L47;
        r128 = 1237;
    L47:
        return r130 + r128;
    L41:
        r129 = 1237;
        goto L42
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "NearbyOpenSubPageStruct(scene=" + this.scene + ", subPageURL=" + this.subPageURL + ", traceSessionId=" + this.traceSessionId + ", arrowStyleConfig=" + this.arrowStyleConfig + ", highlightId=" + this.highlightId + ", subPageType=" + this.subPageType + ", uiStyle=" + this.uiStyle + ", style=" + this.style + ", arrowColor=" + this.arrowColor + ", targetViewId=" + this.targetViewId + ", groupId=" + this.groupId + ", halfClosedAction=" + this.halfClosedAction + ", disableSlideClose=" + this.disableSlideClose + ", trackParams=" + this.trackParams + ", preOpenEnable=" + this.preOpenEnable + ", preRouteToMain=" + this.preRouteToMain + ')';
    }

    public final SizeStyle getSizeStyle() {
        String r100 = this.highlightId;
        int r101 = this.uiStyle;
        if (Intrinsics.areEqual(r100, "groupon_tab") == false) goto L8;
        if (r101 != 1) goto L8;
        return SizeStyle.SIZE_9;
    L8:
        return SizeStyle.SIZE_7;
    }

    public final boolean isPageClose() {
        if (this.pageState < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getArrowColor() {
        return this.arrowColor;
    }

    public final ArrowStyleConfigStruct getArrowStyleConfig() {
        return this.arrowStyleConfig;
    }

    public final int getDisableSlideClose() {
        return this.disableSlideClose;
    }

    public final Bundle getExtraParam() {
        return this.extraParam;
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final HalfCloseAction getHalfClosedAction() {
        return this.halfClosedAction;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final String getHighlightId() {
        return this.highlightId;
    }

    public final NearbyPageType getNearbyPageType() {
        return this.nearbyPageType;
    }

    public final boolean getNeedPreOpen() {
        return this.needPreOpen;
    }

    public final int getPageState() {
        return this.pageState;
    }

    public final boolean getPreOpenEnable() {
        return this.preOpenEnable;
    }

    public final boolean getPreRouteToMain() {
        return this.preRouteToMain;
    }

    public final int getScene() {
        return this.scene;
    }

    public final int getStyle() {
        return this.style;
    }

    public final String getSubPageType() {
        return this.subPageType;
    }

    public final String getSubPageURL() {
        return this.subPageURL;
    }

    public final String getTargetViewId() {
        return this.targetViewId;
    }

    public final String getTraceSessionId() {
        return this.traceSessionId;
    }

    public final Map<String, String> getTrackParams() {
        return this.trackParams;
    }

    public final int getUiStyle() {
        return this.uiStyle;
    }

    public final void setArrowColor(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.arrowColor = r100;
    }

    public final void setExtraParam(Bundle r100) {
        this.extraParam = r100;
    }

    public final void setHeight(Integer r100) {
        this.height = r100;
    }

    public final void setNearbyPageType(NearbyPageType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.nearbyPageType = r100;
    }

    public final void setNeedPreOpen(boolean r100) {
        this.needPreOpen = r100;
    }

    public final void setSubPageURL(String r100) {
        this.subPageURL = r100;
    }

    public final void updatePageState(int r100) {
        this.pageState = r100;
    }

    public NearbyOpenSubPageStruct(int r100, String r101, String r102, ArrowStyleConfigStruct r103, String r104, String r105, int r110, int r111, String r112, String r113, String r114, HalfCloseAction r115, int r116, Map<String, String> r117, boolean r118, boolean r119) {
        Intrinsics.checkNotNullParameter(r112, "arrowColor");
        this.scene = r100;
        this.subPageURL = r101;
        this.traceSessionId = r102;
        this.arrowStyleConfig = r103;
        this.highlightId = r104;
        this.subPageType = r105;
        this.uiStyle = r110;
        this.style = r111;
        this.arrowColor = r112;
        this.targetViewId = r113;
        this.groupId = r114;
        this.halfClosedAction = r115;
        this.disableSlideClose = r116;
        this.trackParams = r117;
        this.preOpenEnable = r118;
        this.preRouteToMain = r119;
        this.nearbyPageType = NearbyPageType.TAB_GROUP_BUY;
        this.pageState = -1;
    }

    public /* synthetic */ NearbyOpenSubPageStruct(int r110, String r111, String r210, ArrowStyleConfigStruct r211, String r212, String r213, int r214, int r215, String r216, String r217, String r218, HalfCloseAction r219, int r310, Map r311, boolean r312, boolean r313, int r314, DefaultConstructorMarker r315) {
        if ((r314 & 1) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r314 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r314 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r314 & 8) == 0) goto L17;
        ArrowStyleConfigStruct r103 = null;
    L19:
        if ((r314 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r314 & 32) == 0) goto L25;
        String r105 = null;
    L27:
        if ((r314 & 64) == 0) goto L29;
        int r106 = 0;
    L31:
        if ((r314 & 128) == 0) goto L33;
        int r112 = 0;
    L35:
        if ((r314 & 256) == 0) goto L37;
        String r113 = CustomHeaderConfig.COLOR_LIGHT;
    L39:
        if ((r314 & 512) == 0) goto L41;
        String r114 = null;
    L43:
        if ((r314 & 1024) == 0) goto L45;
        String r115 = null;
    L47:
        if ((r314 & 2048) == 0) goto L49;
        HalfCloseAction r116 = null;
    L51:
        if ((r314 & 4096) == 0) goto L53;
        int r117 = 0;
    L55:
        if ((r314 & 8192) == 0) goto L57;
        Map r107 = null;
    L59:
        if ((r314 & 16384) == 0) goto L61;
        boolean r108 = false;
    L63:
        if ((r314 & 32768) == 0) goto L65;
        boolean r109 = false;
    L66:
        this(r100, r101, r102, r103, r104, r105, r106, r112, r113, r114, r115, r116, r117, r107, r108, r109);
        return;
    L65:
        r109 = r313;
        goto L66
    L61:
        r108 = r312;
        goto L63
    L57:
        r107 = r311;
        goto L59
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
        r112 = r215;
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
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
