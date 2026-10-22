package com.bytedance.ug.sdk.luckycat.impl.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.texturerender.TextureRenderKeys;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes22.dex */
public class SchemaUIConfig implements Serializable {

    @SchemaUIConfigAnnotation(defaultString = "1.0", keys = {TextureRenderKeys.KEY_IS_ASPECT_RATIO})
    private double aspectRatio;

    @SchemaUIConfigAnnotation(keys = {"back_button_color"})
    private String backBtnColor;

    @SchemaUIConfigAnnotation(keys = {"back_button_icon"})
    private String backBtnIcon;

    @SchemaUIConfigAnnotation(keys = {"back_button_position"})
    private String backBtnPosition;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"bg_transparent"})
    private boolean bgTransparent;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"cancel_animation"})
    private boolean cancelAnimation;

    @SchemaUIConfigAnnotation(defaultInt = 0, keys = {"close_by_mask"})
    private boolean closeByMask;

    @SchemaUIConfigAnnotation(defaultString = CustomHeaderConfig.COLOR_LIGHT, keys = {"container_bgcolor"})
    private String containerBgColor;

    @SchemaUIConfigAnnotation(keys = {"disableHistory"})
    private boolean disableHistory;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"disable_swipe"})
    private boolean disableSwipe;

    @SchemaUIConfigAnnotation(defaultInt = 0, keys = {"height"})
    private int height;

    @SchemaUIConfigAnnotation(defaultString = "100", keys = {ECFindSimilarConfig.HEIGHT_PERCENT})
    private int heightPercent;

    @SchemaUIConfigAnnotation(keys = {"hide_back_button", "hide_back_btn"})
    private boolean hideBackBtn;

    @SchemaUIConfigAnnotation(keys = {"hide_bar", "hide_nav_bar"})
    private boolean hideBar;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"hide_nav_bar"})
    private boolean hideNavBar;

    @SchemaUIConfigAnnotation(keys = {"hide_status_bar"})
    private boolean hideStatusBar;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"block_back_press"})
    private boolean isBlockBackPress;

    @SchemaUIConfigAnnotation(keys = {"hide_more"})
    private boolean isHideRightBtn;

    @SchemaUIConfigAnnotation(keys = {"page_keep_alive"})
    private boolean isKeepPageAlive;

    @SchemaUIConfigAnnotation(defaultBoolean = true, keys = {"show_loading"})
    private boolean isShowLoading;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"use_dialog_fullscreen_style"})
    private boolean isUseDialogFullScreenStyle;

    @SchemaUIConfigAnnotation(defaultString = "", keys = {"mask_color"})
    private String maskColor;

    @SchemaUIConfigAnnotation(defaultString = "", keys = {"origin_container_id"})
    private String originContainerID;

    @SchemaUIConfigAnnotation(defaultString = "center", keys = {"popup_enter_type"})
    private String popupEnterType;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {"preload_popup"})
    private boolean preloadPopup;

    @SchemaUIConfigAnnotation(defaultInt = 0, keys = {"radius"})
    private int radius;

    @SchemaUIConfigAnnotation(defaultString = "", keys = {"soft_input_mode"})
    private String softInputMode;

    @SchemaUIConfigAnnotation(keys = {"status_bar_background", AppConstants.BUNDLE_STATUS_BAR_BG_COLOR})
    private String statusBarBgColor;

    @SchemaUIConfigAnnotation(keys = {AppConstants.BUNDLE_STATUS_BAR_TEXT_COLOR, "status_bar_text_color"})
    private String statusBarTextColor;

    @SchemaUIConfigAnnotation(keys = {"title"})
    private String titleText;

    @SchemaUIConfigAnnotation(defaultBoolean = false, keys = {AppConstants.TRANS_STATUS_BAR})
    private boolean transStatusBar;

    @SchemaUIConfigAnnotation(keys = {AppConstants.BUNDLE_USE_WEBVIEW_TITLE})
    private boolean useWebViewTitle;

    @SchemaUIConfigAnnotation(keys = {"webview_bg_color"})
    private String webViewBgColor;

    @SchemaUIConfigAnnotation(keys = {"webview_text_zoom"})
    private String webViewTextZoom;

    @SchemaUIConfigAnnotation(defaultInt = 0, keys = {"width"})
    private int width;

    @SchemaUIConfigAnnotation(defaultString = "100", keys = {"width_percent"})
    private int widthPercent;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SchemaUIConfigAnnotation {
        boolean defaultBoolean() default false;

        double defaultDouble() default 0.0d;

        int defaultInt() default 0;

        String defaultString() default "";

        String[] keys() default {""};
    }

    public String toString() {
        return "SchemaUIConfig{hideBar=" + this.hideBar + ", hideStatusBar=" + this.hideStatusBar + ", statusBarTextColor='" + this.statusBarTextColor + "', statusBarBgColor='" + this.statusBarBgColor + "', hideBackBtn=" + this.hideBackBtn + ", backBtnColor='" + this.backBtnColor + "', backBtnIcon='" + this.backBtnIcon + "', backBtnPosition='" + this.backBtnPosition + "', disableHistory=" + this.disableHistory + ", webViewBgColor='" + this.webViewBgColor + "', isKeepPageAlive=" + this.isKeepPageAlive + ", webViewTextZoom='" + this.webViewTextZoom + "', titleText='" + this.titleText + "', useWebViewTitle=" + this.useWebViewTitle + ", isHideRightBtn=" + this.isHideRightBtn + ", hideNavBar=" + this.hideNavBar + ", transStatusBar=" + this.transStatusBar + ", containerBgColor='" + this.containerBgColor + "', disableSwipe=" + this.disableSwipe + ", cancelAnimation=" + this.cancelAnimation + ", bgTransparent=" + this.bgTransparent + ", isShowLoading=" + this.isShowLoading + ", width=" + this.width + ", height=" + this.height + ", widthPercent=" + this.widthPercent + ", heightPercent=" + this.heightPercent + ", aspectRatio=" + this.aspectRatio + ", popupEnterType='" + this.popupEnterType + "', radius=" + this.radius + ", maskColor='" + this.maskColor + "', closeByMask=" + this.closeByMask + ", originContainerID='" + this.originContainerID + "', preloadPopup=" + this.preloadPopup + ", softInputMode" + this.softInputMode + ", isBlockBackPress" + this.isBlockBackPress + ", isUseDialogFullScreenStyle" + this.isUseDialogFullScreenStyle + '}';
    }

    public SchemaUIConfig() {
        this.preloadPopup = false;
        this.softInputMode = "";
        this.isBlockBackPress = false;
        this.isUseDialogFullScreenStyle = false;
    }

    public double getAspectRatio() {
        return this.aspectRatio;
    }

    public String getBackBtnColor() {
        return this.backBtnColor;
    }

    public String getBackBtnIcon() {
        return this.backBtnIcon;
    }

    public String getBackBtnPosition() {
        return this.backBtnPosition;
    }

    public String getContainerBgColor() {
        return this.containerBgColor;
    }

    public int getHeight() {
        return this.height;
    }

    public int getHeightPercent() {
        return this.heightPercent;
    }

    public String getMaskColor() {
        return this.maskColor;
    }

    public String getOriginContainerID() {
        return this.originContainerID;
    }

    public String getPopupEnterType() {
        return this.popupEnterType;
    }

    public int getRadius() {
        return this.radius;
    }

    public String getSoftInputMode() {
        return this.softInputMode;
    }

    public String getStatusBarBgColor() {
        return this.statusBarBgColor;
    }

    public String getStatusBarTextColor() {
        return this.statusBarTextColor;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public String getWebViewBgColor() {
        return this.webViewBgColor;
    }

    public String getWebViewTextZoom() {
        return this.webViewTextZoom;
    }

    public int getWidth() {
        return this.width;
    }

    public int getWidthPercent() {
        return this.widthPercent;
    }

    public boolean isBgTransparent() {
        return this.bgTransparent;
    }

    public boolean isBlockBackPress() {
        return this.isBlockBackPress;
    }

    public boolean isCancelAnimation() {
        return this.cancelAnimation;
    }

    public boolean isCloseByMask() {
        return this.closeByMask;
    }

    public boolean isDisableHistory() {
        return this.disableHistory;
    }

    public boolean isDisableSwipe() {
        return this.disableSwipe;
    }

    public boolean isHideBackBtn() {
        return this.hideBackBtn;
    }

    public boolean isHideBar() {
        return this.hideBar;
    }

    public boolean isHideNavBar() {
        return this.hideNavBar;
    }

    public boolean isHideRightBtn() {
        return this.isHideRightBtn;
    }

    public boolean isHideStatusBar() {
        return this.hideStatusBar;
    }

    public boolean isKeepPageAlive() {
        return this.isKeepPageAlive;
    }

    public boolean isPreloadPopup() {
        return this.preloadPopup;
    }

    public boolean isShowLoading() {
        return this.isShowLoading;
    }

    public boolean isTransStatusBar() {
        return this.transStatusBar;
    }

    public boolean isUseDialogFullScreenStyle() {
        return this.isUseDialogFullScreenStyle;
    }

    public boolean isUseWebViewTitle() {
        return this.useWebViewTitle;
    }

    public static SchemaUIConfig createConfig(String r110) {
        SchemaUIConfig r100 = new SchemaUIConfig();
        if (TextUtils.isEmpty(r110) == false) goto L5;
        return r100;
    L5:
        Uri r101 = UriProtector.parse(r110);
        String r102 = UriProtector.getQueryParameter(r101, "url");
        if (TextUtils.isEmpty(r102) == false) goto L9;
        r102 = UriProtector.getQueryParameter(r101, "surl");
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        return r100;
    L11:
        Uri r103 = UriProtector.parse(r102);
        Field[] r104 = SchemaUIConfig.class.getDeclaredFields();
        int r105 = 0;
    L13:
        if (r105 >= r104.length) goto L68;
        Field r106 = r104[r105];
        if (r106 == null) goto L67;
        Annotation[] r107 = r106.getAnnotations();
        if (r107 == null) goto L67;
        if (r107.length == 0) goto L67;
        int r108 = r107.length;
        int r111 = 0;
    L23:
        if (r111 >= r108) goto L67;
        Annotation r109 = r107[r111];
        if ((r109 instanceof SchemaUIConfigAnnotation) == false) goto L66;
        SchemaUIConfigAnnotation r112 = (SchemaUIConfigAnnotation) r109;
        String[] r113 = r112.keys();
        int r114 = r113.length;
        String r115 = "";
        int r116 = 0;
    L27:
        if (r116 >= r114) goto L39;
        String r117 = r113[r116];
        if (TextUtils.isEmpty(r117) == true) goto L37;
        r115 = UriProtector.getQueryParameter(r103, r117);
        if (TextUtils.isEmpty(r115) == false) goto L35;
        r115 = UriProtector.getQueryParameter(r101, r117);
    L35:
        if (TextUtils.isEmpty(r115) == false) goto L39;
    L37:
        r116 = r116 + 1;
    L39:
        if (TextUtils.isEmpty(r115) == false) goto L41;
        r115 = r112.defaultString();
    L41:
        boolean r118 = true;
        r106.setAccessible(true);     // Catch: Throwable -> L64
        if (r106.getGenericType() != Boolean.TYPE) goto L55;
        boolean r119 = r112.defaultBoolean();     // Catch: Throwable -> L64
        if (TextUtils.isEmpty(r115) == false) goto L71;
    L53:
        r106.set(r100, Boolean.valueOf(r119));     // Catch: Throwable -> L64
        goto L66
    L71:
        if (CastIntegerProtector.parseInt(r115) > 0) goto L51;
        r118 = false;
    L51:
        r119 = r118;
        goto L53
    L52:
        r119 = Boolean.valueOf(r115).booleanValue();     // Catch: Throwable -> L64
        goto L53
    L55:
        if (r106.getGenericType() != String.class) goto L58;
        r106.set(r100, r115);     // Catch: Throwable -> L64
        goto L66
    L58:
        if (r106.getGenericType() != Integer.TYPE) goto L61;
        r106.set(r100, CastIntegerProtector.valueOf(r115));     // Catch: Throwable -> L64
        goto L66
    L61:
        if (r106.getGenericType() != Double.TYPE) goto L66;
        r106.set(r100, CastDoubleProtector.valueOf(r115));     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        th.getMessage();
    L66:
        r111 = r111 + 1;
    L67:
        r105 = r105 + 1;
        goto L13
    L68:
        return r100;
    }

    public void setAspectRatio(double r100) {
        this.aspectRatio = r100;
    }

    public void setBackBtnColor(String r100) {
        this.backBtnColor = r100;
    }

    public void setBackBtnIcon(String r100) {
        this.backBtnIcon = r100;
    }

    public void setBackBtnPosition(String r100) {
        this.backBtnPosition = r100;
    }

    public void setBgTransparent(boolean r100) {
        this.bgTransparent = r100;
    }

    public void setBlockBackPress(boolean r100) {
        this.isBlockBackPress = r100;
    }

    public void setCancelAnimation(boolean r100) {
        this.cancelAnimation = r100;
    }

    public void setCloseByMask(boolean r100) {
        this.closeByMask = r100;
    }

    public void setContainerBgColor(String r100) {
        this.containerBgColor = r100;
    }

    public void setDisableHistory(boolean r100) {
        this.disableHistory = r100;
    }

    public void setDisableSwipe(boolean r100) {
        this.disableSwipe = r100;
    }

    public void setHeight(int r100) {
        this.height = r100;
    }

    public void setHeightPercent(int r100) {
        this.heightPercent = r100;
    }

    public void setHideBackBtn(boolean r100) {
        this.hideBackBtn = r100;
    }

    public void setHideBar(boolean r100) {
        this.hideBar = r100;
    }

    public void setHideNavBar(boolean r100) {
        this.hideNavBar = r100;
    }

    public void setHideRightBtn(boolean r100) {
        this.isHideRightBtn = r100;
    }

    public void setHideStatusBar(boolean r100) {
        this.hideStatusBar = r100;
    }

    public void setKeepPageAlive(boolean r100) {
        this.isKeepPageAlive = r100;
    }

    public void setMaskColor(String r100) {
        this.maskColor = r100;
    }

    public void setOriginContainerID(String r100) {
        this.originContainerID = r100;
    }

    public void setPopupEnterType(String r100) {
        this.popupEnterType = r100;
    }

    public void setPreloadPopup(boolean r100) {
        this.preloadPopup = r100;
    }

    public void setRadius(int r100) {
        this.radius = r100;
    }

    public void setShowLoading(boolean r100) {
        this.isShowLoading = r100;
    }

    public void setSoftInputMode(String r100) {
        this.softInputMode = r100;
    }

    public void setStatusBarBgColor(String r100) {
        this.statusBarBgColor = r100;
    }

    public void setStatusBarTextColor(String r100) {
        this.statusBarTextColor = r100;
    }

    public void setTitleText(String r100) {
        this.titleText = r100;
    }

    public void setTransStatusBar(boolean r100) {
        this.transStatusBar = r100;
    }

    public void setUseDialogFullScreenStyle(boolean r100) {
        this.isUseDialogFullScreenStyle = r100;
    }

    public void setUseWebViewTitle(boolean r100) {
        this.useWebViewTitle = r100;
    }

    public void setWebViewBgColor(String r100) {
        this.webViewBgColor = r100;
    }

    public void setWebViewTextZoom(String r100) {
        this.webViewTextZoom = r100;
    }

    public void setWidth(int r100) {
        this.width = r100;
    }

    public void setWidthPercent(int r100) {
        this.widthPercent = r100;
    }
}
