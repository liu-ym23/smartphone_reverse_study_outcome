package com.bytedance.android.shopping.api.anchorv3;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b9\u0018\u00002\u00020\u0001Bÿ\u0002\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010&\u001a\u00020'\u0012\b\b\u0002\u0010(\u001a\u00020\u0010\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010*R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010#\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u00102\u001a\u0004\b3\u00101R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010,R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010.R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010,R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010,R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010(\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010,R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010,R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010,R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010,R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010.R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010,R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010G\u001a\u0004\bM\u0010DR\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010G\u001a\u0004\bN\u0010DR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010,R\"\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\bP\u00101\"\u0004\bQ\u0010RR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010,R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010,R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u0010\n\u0002\u0010G\u001a\u0004\bW\u0010D\"\u0004\bX\u0010FR\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bY\u0010,R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010G\u001a\u0004\bZ\u0010DR\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b[\u0010.R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006`"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECUIParam;", "Ljava/io/Serializable;", "requestPage", "", "disableLiveWindow", "", "isFromFeedAnchor", "actionType", "clickArea", "iconType", "liveWindowRoomId", "clickAnchorTimeStamp", "", "clickAnchorSystemCurrentTimeMills", "sellPoint", "inflowFeedCardLayoutPos", "", "panelHeight", "showInternalListStyle", "muteSmallWindow", "videoPriority", "splitPercent", "sceneTransitionData", "Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;", "pdpHalf2026HeightType", "fractionListenerId", "pageStateListenerId", "pageStateListenerExtra", "wireFrameSchemaInfo", "Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "panelHeightPercent", "firstCid", "liveHotSaleComponent", "headerConfig", "clientCacheDisable", "autoBuyNow", "autoAddToCart", "skuId", "halfHeadScale", "", "halfHeadSpace", "prePageClickTime", "(Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ZZLjava/lang/Integer;Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;FILjava/lang/Long;)V", "getActionType", "()Ljava/lang/String;", "getAutoAddToCart", "()Z", "getAutoBuyNow", "getClickAnchorSystemCurrentTimeMills", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getClickAnchorTimeStamp", "getClickArea", "getClientCacheDisable", "getDisableLiveWindow", "getFirstCid", "getFractionListenerId", "getHalfHeadScale", "()F", "setHalfHeadScale", "(F)V", "getHalfHeadSpace", "()I", "setHalfHeadSpace", "(I)V", "getHeaderConfig", "getIconType", "getInflowFeedCardLayoutPos", "()Ljava/lang/Integer;", "setInflowFeedCardLayoutPos", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getLiveHotSaleComponent", "getLiveWindowRoomId", "getMuteSmallWindow", "getPageStateListenerExtra", "getPageStateListenerId", "getPanelHeight", "getPanelHeightPercent", "getPdpHalf2026HeightType", "getPrePageClickTime", "setPrePageClickTime", "(Ljava/lang/Long;)V", "getRequestPage", "getSceneTransitionData", "()Lcom/bytedance/android/shopping/api/anchorv3/ECSceneTransitionData;", "getSellPoint", "getShowInternalListStyle", "setShowInternalListStyle", "getSkuId", "getSplitPercent", "getVideoPriority", "getWireFrameSchemaInfo", "()Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;", "setWireFrameSchemaInfo", "(Lcom/bytedance/android/shopping/api/anchorv3/WireFrameSchemaInfo;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECUIParam implements Serializable {
    private final String actionType;
    private final boolean autoAddToCart;
    private final boolean autoBuyNow;
    private final Long clickAnchorSystemCurrentTimeMills;
    private final Long clickAnchorTimeStamp;
    private final String clickArea;
    private final boolean clientCacheDisable;
    private final boolean disableLiveWindow;
    private final String firstCid;
    private final String fractionListenerId;
    private float halfHeadScale;
    private int halfHeadSpace;
    private final String headerConfig;
    private final String iconType;
    private Integer inflowFeedCardLayoutPos;
    private final boolean isFromFeedAnchor;
    private final String liveHotSaleComponent;
    private final String liveWindowRoomId;
    private final boolean muteSmallWindow;
    private final String pageStateListenerExtra;
    private final String pageStateListenerId;
    private final Integer panelHeight;
    private final Integer panelHeightPercent;
    private final String pdpHalf2026HeightType;

    @SerializedName("pre_page_click_time")
    private Long prePageClickTime;
    private final String requestPage;
    private final ECSceneTransitionData sceneTransitionData;
    private final String sellPoint;
    private Integer showInternalListStyle;
    private final String skuId;
    private final Integer splitPercent;
    private final boolean videoPriority;
    private WireFrameSchemaInfo wireFrameSchemaInfo;

    public ECUIParam() {
        this(null, false, false, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, null, null, null, null, null, false, false, false, null, 0.0f, 0, null, -1, 1, null);
    }

    public final String getActionType() {
        return this.actionType;
    }

    public final boolean getAutoAddToCart() {
        return this.autoAddToCart;
    }

    public final boolean getAutoBuyNow() {
        return this.autoBuyNow;
    }

    public final Long getClickAnchorSystemCurrentTimeMills() {
        return this.clickAnchorSystemCurrentTimeMills;
    }

    public final Long getClickAnchorTimeStamp() {
        return this.clickAnchorTimeStamp;
    }

    public final String getClickArea() {
        return this.clickArea;
    }

    public final boolean getClientCacheDisable() {
        return this.clientCacheDisable;
    }

    public final boolean getDisableLiveWindow() {
        return this.disableLiveWindow;
    }

    public final String getFirstCid() {
        return this.firstCid;
    }

    public final String getFractionListenerId() {
        return this.fractionListenerId;
    }

    public final float getHalfHeadScale() {
        return this.halfHeadScale;
    }

    public final int getHalfHeadSpace() {
        return this.halfHeadSpace;
    }

    public final String getHeaderConfig() {
        return this.headerConfig;
    }

    public final String getIconType() {
        return this.iconType;
    }

    public final Integer getInflowFeedCardLayoutPos() {
        return this.inflowFeedCardLayoutPos;
    }

    public final String getLiveHotSaleComponent() {
        return this.liveHotSaleComponent;
    }

    public final String getLiveWindowRoomId() {
        return this.liveWindowRoomId;
    }

    public final boolean getMuteSmallWindow() {
        return this.muteSmallWindow;
    }

    public final String getPageStateListenerExtra() {
        return this.pageStateListenerExtra;
    }

    public final String getPageStateListenerId() {
        return this.pageStateListenerId;
    }

    public final Integer getPanelHeight() {
        return this.panelHeight;
    }

    public final Integer getPanelHeightPercent() {
        return this.panelHeightPercent;
    }

    public final String getPdpHalf2026HeightType() {
        return this.pdpHalf2026HeightType;
    }

    public final Long getPrePageClickTime() {
        return this.prePageClickTime;
    }

    public final String getRequestPage() {
        return this.requestPage;
    }

    public final ECSceneTransitionData getSceneTransitionData() {
        return this.sceneTransitionData;
    }

    public final String getSellPoint() {
        return this.sellPoint;
    }

    public final Integer getShowInternalListStyle() {
        return this.showInternalListStyle;
    }

    public final String getSkuId() {
        return this.skuId;
    }

    public final Integer getSplitPercent() {
        return this.splitPercent;
    }

    public final boolean getVideoPriority() {
        return this.videoPriority;
    }

    public final WireFrameSchemaInfo getWireFrameSchemaInfo() {
        return this.wireFrameSchemaInfo;
    }

    public final boolean isFromFeedAnchor() {
        return this.isFromFeedAnchor;
    }

    public final void setHalfHeadScale(float r1) {
        this.halfHeadScale = r1;
    }

    public final void setHalfHeadSpace(int r1) {
        this.halfHeadSpace = r1;
    }

    public final void setInflowFeedCardLayoutPos(Integer r1) {
        this.inflowFeedCardLayoutPos = r1;
    }

    public final void setPrePageClickTime(Long r1) {
        this.prePageClickTime = r1;
    }

    public final void setShowInternalListStyle(Integer r1) {
        this.showInternalListStyle = r1;
    }

    public final void setWireFrameSchemaInfo(WireFrameSchemaInfo r1) {
        this.wireFrameSchemaInfo = r1;
    }

    public ECUIParam(String r3, boolean r4, boolean r5, String r6, String r7, String r8, String r9, Long r10, Long r11, String r12, Integer r13, Integer r14, Integer r15, boolean r16, boolean r17, Integer r18, ECSceneTransitionData r19, String r20, String r21, String r22, String r23, WireFrameSchemaInfo r24, Integer r25, String r26, String r27, String r28, boolean r29, boolean r30, boolean r31, String r32, float r33, int r34, Long r35) {
        this.requestPage = r3;
        this.disableLiveWindow = r4;
        this.isFromFeedAnchor = r5;
        this.actionType = r6;
        this.clickArea = r7;
        this.iconType = r8;
        this.liveWindowRoomId = r9;
        this.clickAnchorTimeStamp = r10;
        this.clickAnchorSystemCurrentTimeMills = r11;
        this.sellPoint = r12;
        this.inflowFeedCardLayoutPos = r13;
        this.panelHeight = r14;
        this.showInternalListStyle = r15;
        this.muteSmallWindow = r16;
        this.videoPriority = r17;
        this.splitPercent = r18;
        this.sceneTransitionData = r19;
        this.pdpHalf2026HeightType = r20;
        this.fractionListenerId = r21;
        this.pageStateListenerId = r22;
        this.pageStateListenerExtra = r23;
        this.wireFrameSchemaInfo = r24;
        this.panelHeightPercent = r25;
        this.firstCid = r26;
        this.liveHotSaleComponent = r27;
        this.headerConfig = r28;
        this.clientCacheDisable = r29;
        this.autoBuyNow = r30;
        this.autoAddToCart = r31;
        this.skuId = r32;
        this.halfHeadScale = r33;
        this.halfHeadSpace = r34;
        this.prePageClickTime = r35;
    }

    public /* synthetic */ ECUIParam(String r35, boolean r36, boolean r37, String r38, String r39, String r40, String r41, Long r42, Long r43, String r44, Integer r45, Integer r46, Integer r47, boolean r48, boolean r49, Integer r50, ECSceneTransitionData r51, String r52, String r53, String r54, String r55, WireFrameSchemaInfo r56, Integer r57, String r58, String r59, String r60, boolean r61, boolean r62, boolean r63, String r64, float r65, int r66, Long r67, int r68, int r69, DefaultConstructorMarker r70) {
        if ((r68 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r68 & 2) == 0) goto L9;
        boolean r3 = false;
    L11:
        if ((r68 & 4) == 0) goto L13;
        boolean r5 = false;
    L15:
        if ((r68 & 8) == 0) goto L17;
        String r6 = null;
    L19:
        if ((r68 & 16) == 0) goto L21;
        String r7 = null;
    L23:
        if ((r68 & 32) == 0) goto L25;
        String r8 = "";
    L27:
        if ((r68 & 64) == 0) goto L29;
        String r9 = null;
    L31:
        if ((r68 & 128) == 0) goto L33;
        Long r10 = null;
    L35:
        if ((r68 & 256) == 0) goto L37;
        Long r11 = null;
    L39:
        if ((r68 & 512) == 0) goto L41;
        String r12 = null;
    L43:
        if ((r68 & 1024) == 0) goto L45;
        Integer r13 = null;
    L47:
        if ((r68 & 2048) == 0) goto L49;
        Integer r14 = null;
    L51:
        if ((r68 & 4096) == 0) goto L53;
        Integer r15 = null;
    L55:
        if ((r68 & 8192) == 0) goto L57;
        boolean r2 = false;
    L59:
        if ((r68 & 16384) == 0) goto L61;
        boolean r4 = true;
    L63:
        if ((r68 & 32768) == 0) goto L65;
        Integer r17 = null;
    L67:
        if ((r68 & 65536) == 0) goto L69;
        ECSceneTransitionData r18 = null;
    L71:
        if ((r68 & 131072) == 0) goto L73;
        String r19 = null;
    L75:
        if ((r68 & 262144) == 0) goto L77;
        String r20 = null;
    L79:
        if ((r68 & 524288) == 0) goto L81;
        String r21 = null;
    L83:
        if ((r68 & 1048576) == 0) goto L85;
        String r22 = null;
    L87:
        if ((r68 & 2097152) == 0) goto L89;
        WireFrameSchemaInfo r23 = null;
    L91:
        if ((r68 & 4194304) == 0) goto L93;
        Integer r24 = null;
    L95:
        if ((r68 & 8388608) == 0) goto L97;
        String r25 = null;
    L99:
        if ((r68 & 16777216) == 0) goto L101;
        String r26 = null;
    L103:
        if ((r68 & 33554432) == 0) goto L105;
        String r27 = null;
    L107:
        if ((r68 & 67108864) == 0) goto L109;
        boolean r28 = false;
    L111:
        if ((r68 & 134217728) == 0) goto L113;
        boolean r29 = false;
    L115:
        if ((r68 & 268435456) == 0) goto L117;
        boolean r30 = false;
    L119:
        if ((r68 & 536870912) == 0) goto L121;
        String r31 = null;
    L123:
        if ((r68 & 1073741824) == 0) goto L125;
        float r32 = 0.0f;
    L127:
        if ((r68 & Integer.MIN_VALUE) == 0) goto L129;
        int r0 = 0;
    L131:
        if ((r69 & 1) == 0) goto L133;
        Long r16 = null;
    L134:
        this(r1, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r4, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r0, r16);
        return;
    L133:
        r16 = r67;
        goto L134
    L129:
        r0 = r66;
        goto L131
    L125:
        r32 = r65;
        goto L127
    L121:
        r31 = r64;
        goto L123
    L117:
        r30 = r63;
        goto L119
    L113:
        r29 = r62;
        goto L115
    L109:
        r28 = r61;
        goto L111
    L105:
        r27 = r60;
        goto L107
    L101:
        r26 = r59;
        goto L103
    L97:
        r25 = r58;
        goto L99
    L93:
        r24 = r57;
        goto L95
    L89:
        r23 = r56;
        goto L91
    L85:
        r22 = r55;
        goto L87
    L81:
        r21 = r54;
        goto L83
    L77:
        r20 = r53;
        goto L79
    L73:
        r19 = r52;
        goto L75
    L69:
        r18 = r51;
        goto L71
    L65:
        r17 = r50;
        goto L67
    L61:
        r4 = r49;
        goto L63
    L57:
        r2 = r48;
        goto L59
    L53:
        r15 = r47;
        goto L55
    L49:
        r14 = r46;
        goto L51
    L45:
        r13 = r45;
        goto L47
    L41:
        r12 = r44;
        goto L43
    L37:
        r11 = r43;
        goto L39
    L33:
        r10 = r42;
        goto L35
    L29:
        r9 = r41;
        goto L31
    L25:
        r8 = r40;
        goto L27
    L21:
        r7 = r39;
        goto L23
    L17:
        r6 = r38;
        goto L19
    L13:
        r5 = r37;
        goto L15
    L9:
        r3 = r36;
        goto L11
    L5:
        r1 = r35;
        goto L7
    }
}
