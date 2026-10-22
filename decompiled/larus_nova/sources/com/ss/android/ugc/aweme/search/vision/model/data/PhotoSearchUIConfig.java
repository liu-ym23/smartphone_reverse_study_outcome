package com.ss.android.ugc.aweme.search.vision.model.data;

import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0012\"\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u0010\u0014R\u001e\u00100\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u0010\u0014R\u001e\u00103\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0012\"\u0004\b5\u0010\u0014R\"\u00106\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010;\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001e\u0010<\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0012\"\u0004\b>\u0010\u0014R \u0010?\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\f\"\u0004\bA\u0010\u000eR\u001a\u0010B\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001b\"\u0004\bD\u0010\u001dR\u001a\u0010E\u001a\u00020FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001e\u0010K\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0012\"\u0004\bM\u0010\u0014R\u001e\u0010N\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u0012\"\u0004\bP\u0010\u0014R \u0010Q\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\f\"\u0004\bS\u0010\u000eR\u001a\u0010T\u001a\u00020UX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010Y¨\u0006["}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/PhotoSearchUIConfig;", "Ljava/io/Serializable;", "()V", "backIconStyle", "Lcom/ss/android/ugc/aweme/search/vision/model/data/BackIconStyle;", "getBackIconStyle", "()Lcom/ss/android/ugc/aweme/search/vision/model/data/BackIconStyle;", "setBackIconStyle", "(Lcom/ss/android/ugc/aweme/search/vision/model/data/BackIconStyle;)V", "bgColor", "", "getBgColor", "()Ljava/lang/String;", "setBgColor", "(Ljava/lang/String;)V", "canDragPanelFs", "", "getCanDragPanelFs", "()Z", "setCanDragPanelFs", "(Z)V", "canDragResultPanel", "getCanDragResultPanel", "setCanDragResultPanel", "closeBgBlur", "", "getCloseBgBlur", "()I", "setCloseBgBlur", "(I)V", "enablePullDownClose", "getEnablePullDownClose", "setEnablePullDownClose", "enablePullUpExpand", "getEnablePullUpExpand", "setEnablePullUpExpand", "enableSkipCollapsed", "getEnableSkipCollapsed", "setEnableSkipCollapsed", "floatScreen", "", "getFloatScreen", "()F", "setFloatScreen", "(F)V", "hasCropAreaFs", "getHasCropAreaFs", "setHasCropAreaFs", "hasOriginCard", "getHasOriginCard", "setHasOriginCard", "hasRecognitionAnim", "getHasRecognitionAnim", "setHasRecognitionAnim", "initPanelHeight", "getInitPanelHeight", "()Ljava/lang/Float;", "setInitPanelHeight", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "noCropImage", "getNoCropImage", "setNoCropImage", "resultBgColor", "getResultBgColor", "setResultBgColor", "resultPanelFadeAnim", "getResultPanelFadeAnim", "setResultPanelFadeAnim", "resultPanelPattern", "Lcom/ss/android/ugc/aweme/search/vision/model/data/ResultPanelStatus;", "getResultPanelPattern", "()Lcom/ss/android/ugc/aweme/search/vision/model/data/ResultPanelStatus;", "setResultPanelPattern", "(Lcom/ss/android/ugc/aweme/search/vision/model/data/ResultPanelStatus;)V", "resultPanelRightAnim", "getResultPanelRightAnim", "setResultPanelRightAnim", "showSearchButton", "getShowSearchButton", "setShowSearchButton", "titleName", "getTitleName", "setTitleName", "toolBarStyle", "Lcom/ss/android/ugc/aweme/search/vision/model/data/ToolBarStyle;", "getToolBarStyle", "()Lcom/ss/android/ugc/aweme/search/vision/model/data/ToolBarStyle;", "setToolBarStyle", "(Lcom/ss/android/ugc/aweme/search/vision/model/data/ToolBarStyle;)V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PhotoSearchUIConfig implements Serializable {
    public static final Companion Companion = null;
    private BackIconStyle backIconStyle;

    @SerializedName("bg_color")
    private String bgColor;
    private boolean canDragPanelFs;

    @SerializedName("can_drag_panel")
    private boolean canDragResultPanel;

    @SerializedName("close_bg_blur")
    private int closeBgBlur;

    @SerializedName("enable_pull_down_close")
    private boolean enablePullDownClose;

    @SerializedName("ue_can_swipe_up")
    private boolean enablePullUpExpand;

    @SerializedName("enable_skip_collapsed")
    private boolean enableSkipCollapsed;

    @SerializedName(ECFindSimilarConfig.FLOAT_SCREEN_HEIGHT)
    private float floatScreen;
    private boolean hasCropAreaFs;

    @SerializedName("has_origin_card")
    private boolean hasOriginCard;

    @SerializedName("has_recognition_anim")
    private boolean hasRecognitionAnim;

    @SerializedName("init_panel_height")
    private Float initPanelHeight;

    @SerializedName("no_crop_images_card")
    private boolean noCropImage;

    @SerializedName("result_bg_color")
    private String resultBgColor;
    private int resultPanelFadeAnim;
    private ResultPanelStatus resultPanelPattern;

    @SerializedName("result_panel_anim")
    private boolean resultPanelRightAnim;

    @SerializedName("has_search_button")
    private boolean showSearchButton;

    @SerializedName("title_name")
    private String titleName;
    private ToolBarStyle toolBarStyle;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/data/PhotoSearchUIConfig$Companion;", "", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public PhotoSearchUIConfig() {
        this.canDragResultPanel = true;
        this.hasRecognitionAnim = true;
        this.titleName = "";
        this.floatScreen = 0.73f;
        this.enablePullUpExpand = true;
        this.hasCropAreaFs = true;
        this.canDragPanelFs = true;
        this.toolBarStyle = ToolBarStyle.TRANSPARENT;
        this.resultPanelPattern = ResultPanelStatus.FULLSCREEN;
        this.backIconStyle = BackIconStyle.CLOSE;
    }

    public final BackIconStyle getBackIconStyle() {
        return this.backIconStyle;
    }

    public final String getBgColor() {
        return this.bgColor;
    }

    public final boolean getCanDragPanelFs() {
        return this.canDragPanelFs;
    }

    public final boolean getCanDragResultPanel() {
        return this.canDragResultPanel;
    }

    public final int getCloseBgBlur() {
        return this.closeBgBlur;
    }

    public final boolean getEnablePullDownClose() {
        return this.enablePullDownClose;
    }

    public final boolean getEnablePullUpExpand() {
        return this.enablePullUpExpand;
    }

    public final boolean getEnableSkipCollapsed() {
        return this.enableSkipCollapsed;
    }

    public final float getFloatScreen() {
        return this.floatScreen;
    }

    public final boolean getHasCropAreaFs() {
        return this.hasCropAreaFs;
    }

    public final boolean getHasOriginCard() {
        return this.hasOriginCard;
    }

    public final boolean getHasRecognitionAnim() {
        return this.hasRecognitionAnim;
    }

    public final Float getInitPanelHeight() {
        return this.initPanelHeight;
    }

    public final boolean getNoCropImage() {
        return this.noCropImage;
    }

    public final String getResultBgColor() {
        return this.resultBgColor;
    }

    public final int getResultPanelFadeAnim() {
        return this.resultPanelFadeAnim;
    }

    public final ResultPanelStatus getResultPanelPattern() {
        return this.resultPanelPattern;
    }

    public final boolean getResultPanelRightAnim() {
        return this.resultPanelRightAnim;
    }

    public final boolean getShowSearchButton() {
        return this.showSearchButton;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final ToolBarStyle getToolBarStyle() {
        return this.toolBarStyle;
    }

    public final void setBackIconStyle(BackIconStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.backIconStyle = r100;
    }

    public final void setBgColor(String r100) {
        this.bgColor = r100;
    }

    public final void setCanDragPanelFs(boolean r100) {
        this.canDragPanelFs = r100;
    }

    public final void setCanDragResultPanel(boolean r100) {
        this.canDragResultPanel = r100;
    }

    public final void setCloseBgBlur(int r100) {
        this.closeBgBlur = r100;
    }

    public final void setEnablePullDownClose(boolean r100) {
        this.enablePullDownClose = r100;
    }

    public final void setEnablePullUpExpand(boolean r100) {
        this.enablePullUpExpand = r100;
    }

    public final void setEnableSkipCollapsed(boolean r100) {
        this.enableSkipCollapsed = r100;
    }

    public final void setFloatScreen(float r100) {
        this.floatScreen = r100;
    }

    public final void setHasCropAreaFs(boolean r100) {
        this.hasCropAreaFs = r100;
    }

    public final void setHasOriginCard(boolean r100) {
        this.hasOriginCard = r100;
    }

    public final void setHasRecognitionAnim(boolean r100) {
        this.hasRecognitionAnim = r100;
    }

    public final void setInitPanelHeight(Float r100) {
        this.initPanelHeight = r100;
    }

    public final void setNoCropImage(boolean r100) {
        this.noCropImage = r100;
    }

    public final void setResultBgColor(String r100) {
        this.resultBgColor = r100;
    }

    public final void setResultPanelFadeAnim(int r100) {
        this.resultPanelFadeAnim = r100;
    }

    public final void setResultPanelPattern(ResultPanelStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resultPanelPattern = r100;
    }

    public final void setResultPanelRightAnim(boolean r100) {
        this.resultPanelRightAnim = r100;
    }

    public final void setShowSearchButton(boolean r100) {
        this.showSearchButton = r100;
    }

    public final void setTitleName(String r100) {
        this.titleName = r100;
    }

    public final void setToolBarStyle(ToolBarStyle r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.toolBarStyle = r100;
    }
}
