package com.bytedance.locallife.groupon.struct.popup.pandent;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.bytedance.locallife.dito.common.data.UrlModel;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0007\u0018\u0000 E2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\bC\u0010DR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001a\u0010%\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R$\u0010'\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR$\u0010-\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR$\u00100\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR$\u00103\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0004\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\"\u00107\u001a\u0002068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006G"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/popup/pandent/NearbyPendantStruct;", "", "", "widgetId", "Ljava/lang/String;", "getWidgetId", "()Ljava/lang/String;", "setWidgetId", "(Ljava/lang/String;)V", "", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "Ljava/lang/Integer;", "getSceneType", "()Ljava/lang/Integer;", "setSceneType", "(Ljava/lang/Integer;)V", "Lis6/a;", "uiConfig", "Lis6/a;", "getUiConfig", "()Lis6/a;", "showStatusType", "I", "getShowStatusType", "()I", "defaultStatus", "getDefaultStatus", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "imgExpand", "Lcom/bytedance/locallife/dito/common/data/UrlModel;", "getImgExpand", "()Lcom/bytedance/locallife/dito/common/data/UrlModel;", "setImgExpand", "(Lcom/bytedance/locallife/dito/common/data/UrlModel;)V", "imgFold", "getImgFold", "setImgFold", ReportConstant.COMMON_ACTION_TYPE, "getActionType", "jumpUrl", "getJumpUrl", "setJumpUrl", "activityId", "getActivityId", "setActivityId", "reportParams", "getReportParams", "setReportParams", "trackParams", "getTrackParams", "setTrackParams", "widgetType", "getWidgetType", "setWidgetType", "", "enableHideOnSticky", "Z", "getEnableHideOnSticky", "()Z", "setEnableHideOnSticky", "(Z)V", "avoidPinchMode", "Ljava/lang/Boolean;", "getAvoidPinchMode", "()Ljava/lang/Boolean;", "setAvoidPinchMode", "(Ljava/lang/Boolean;)V", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyPendantStruct {
    public static final int ATOMIC_TASK_ACTION = 1;
    public static final int CHECK_IN_ENTRANCE_TYPE = 1;
    public static final a Companion = null;
    public static final int RESOURCE_ENTRANCE_TYPE = 0;
    public static final int SCHEMA_ACTION = 0;

    @SerializedName("action_type")
    private final int actionType;

    @SerializedName("activity_id")
    private String activityId;

    @SerializedName("avoid_pinch_mode")
    private Boolean avoidPinchMode;

    @SerializedName("default_status")
    private final int defaultStatus;

    @SerializedName("enable_hide_on_sticky")
    private boolean enableHideOnSticky;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private UrlModel imgExpand;

    @SerializedName("img_url_small")
    private UrlModel imgFold;

    @SerializedName("jump_schema")
    private String jumpUrl;

    @SerializedName("report_params")
    private String reportParams;

    @SerializedName("scene_type")
    private Integer sceneType;

    @SerializedName("show_status_type")
    private final int showStatusType;

    @SerializedName("track_params")
    private String trackParams;

    @SerializedName("ui_config")
    private final is6.a uiConfig;

    @SerializedName("widget_id")
    private String widgetId;

    @SerializedName("widget_type")
    private String widgetType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NearbyPendantStruct() {
        this.sceneType = 0;
        this.uiConfig = new is6.a();
    }

    public final int getActionType() {
        return this.actionType;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final Boolean getAvoidPinchMode() {
        return this.avoidPinchMode;
    }

    public final int getDefaultStatus() {
        return this.defaultStatus;
    }

    public final boolean getEnableHideOnSticky() {
        return this.enableHideOnSticky;
    }

    public final UrlModel getImgExpand() {
        return this.imgExpand;
    }

    public final UrlModel getImgFold() {
        return this.imgFold;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getReportParams() {
        return this.reportParams;
    }

    public final Integer getSceneType() {
        return this.sceneType;
    }

    public final int getShowStatusType() {
        return this.showStatusType;
    }

    public final String getTrackParams() {
        return this.trackParams;
    }

    public final is6.a getUiConfig() {
        return this.uiConfig;
    }

    public final String getWidgetId() {
        return this.widgetId;
    }

    public final String getWidgetType() {
        return this.widgetType;
    }

    public final void setActivityId(String r100) {
        this.activityId = r100;
    }

    public final void setAvoidPinchMode(Boolean r100) {
        this.avoidPinchMode = r100;
    }

    public final void setEnableHideOnSticky(boolean r100) {
        this.enableHideOnSticky = r100;
    }

    public final void setImgExpand(UrlModel r100) {
        this.imgExpand = r100;
    }

    public final void setImgFold(UrlModel r100) {
        this.imgFold = r100;
    }

    public final void setJumpUrl(String r100) {
        this.jumpUrl = r100;
    }

    public final void setReportParams(String r100) {
        this.reportParams = r100;
    }

    public final void setSceneType(Integer r100) {
        this.sceneType = r100;
    }

    public final void setTrackParams(String r100) {
        this.trackParams = r100;
    }

    public final void setWidgetId(String r100) {
        this.widgetId = r100;
    }

    public final void setWidgetType(String r100) {
        this.widgetType = r100;
    }
}
