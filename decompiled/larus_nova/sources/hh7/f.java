package hh7;

import androidx.exifinterface.media.ExifInterface;
import com.amap.api.col.s.ce;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.timon_monitor_api.pipeline.JSBInfoData;
import com.bytedance.timon_monitor_api.pipeline.UIActionData;
import com.bytedance.timonbase.scene.PageDataManager;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\u0013R.\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001f\u001a\u0004\b$\u0010 \"\u0004\b\u000b\u0010\"R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\u0013R,\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010)\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R0\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0016\u001a\u0004\b2\u0010\u0018\"\u0004\b3\u0010\u001aR$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R0\u0010;\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u0018\"\u0004\b=\u0010\u001aR*\u0010?\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010+\u001a\u0004\b@\u0010-\"\u0004\bA\u0010/R$\u0010B\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010\u0004\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\u0013R$\u0010E\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0004\u001a\u0004\bF\u0010\u0006\"\u0004\bG\u0010\u0013R\"\u0010H\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bH\u0010\u0004\u001a\u0004\bI\u0010\u0006\"\u0004\bJ\u0010\u0013R\"\u0010K\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010\u0004\u001a\u0004\bL\u0010\u0006\"\u0004\bM\u0010\u0013R\"\u0010N\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bN\u0010\u001f\u001a\u0004\bO\u0010 \"\u0004\bP\u0010\"R*\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010+\u001a\u0004\bS\u0010-\"\u0004\bT\u0010/R$\u0010U\u001a\u0004\u0018\u00010Q8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR$\u0010[\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R.\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001008\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u0016\u001a\u0004\bb\u0010\u0018\"\u0004\bc\u0010\u001aR\"\u0010d\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u001f\u001a\u0004\be\u0010 \"\u0004\bf\u0010\"R\"\u0010g\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bg\u0010\u001f\u001a\u0004\bh\u0010 \"\u0004\bi\u0010\"R\"\u0010j\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bj\u0010\u001f\u001a\u0004\bk\u0010 \"\u0004\bl\u0010\"R$\u0010m\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bm\u0010\\\u001a\u0004\bn\u0010^\"\u0004\bo\u0010`R$\u0010p\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bp\u0010\\\u001a\u0004\bq\u0010^\"\u0004\br\u0010`R$\u0010t\u001a\u0004\u0018\u00010s8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bt\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR$\u0010z\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bz\u0010{\u001a\u0004\bz\u0010|\"\u0004\b}\u0010~¨\u0006\u007f"}, d2 = {"Lhh7/f;", "", "", "class_name", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "method_name", "f", "", LocationMonitorConst.PERMISSION_STATUS, "I", "getPermission_status", "()I", "x", "(I)V", "permission_type", "getPermission_type", "y", "(Ljava/lang/String;)V", "", "privacy_api_params", "Ljava/util/Map;", ce.f26391f, "()Ljava/util/Map;", MapBundleKey.MapObjKey.OBJ_SS_ARROW_Z, "(Ljava/util/Map;)V", "api_id", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", LocationMonitorConst.IS_VALID, "Z", "()Z", "J", "(Z)V", "is_downgrade", ce.f26396k, "strategy_md5", "getStrategy_md5", FaceService.girlLabel, "", "Lhh7/c;", "strategies", "Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "()Ljava/util/List;", ExifInterface.LONGITUDE_EAST, "(Ljava/util/List;)V", "", "bpea_info", "b", "setBpea_info", "Lcom/bytedance/timon_monitor_api/pipeline/JSBInfoData;", "jsb_info", "Lcom/bytedance/timon_monitor_api/pipeline/JSBInfoData;", "getJsb_info", "()Lcom/bytedance/timon_monitor_api/pipeline/JSBInfoData;", BaseSwitches.V, "(Lcom/bytedance/timon_monitor_api/pipeline/JSBInfoData;)V", "custom_info", "getCustom_info", "setCustom_info", "Lcom/bytedance/timonbase/scene/PageDataManager$b;", "page_info", "getPage_info", "w", "event_thread", "d", "q", "event_process", "getEvent_process", "p", "stack", "h", "D", "full_stack", "e", "s", "isReflection", ce.f26395j, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/bytedance/timon_monitor_api/pipeline/UIActionData;", "ui_actions", "getUi_actions", "G", "related_ui_action", "Lcom/bytedance/timon_monitor_api/pipeline/UIActionData;", "getRelated_ui_action", "()Lcom/bytedance/timon_monitor_api/pipeline/UIActionData;", "B", "(Lcom/bytedance/timon_monitor_api/pipeline/UIActionData;)V", "scene_id", "Ljava/lang/Integer;", "getScene_id", "()Ljava/lang/Integer;", "C", "(Ljava/lang/Integer;)V", "extra_params", "getExtra_params", "r", "async_config_enable", "getAsync_config_enable", "l", "async_stack_enable", "getAsync_stack_enable", "m", "async_stack_strategy_v2", "getAsync_stack_strategy_v2", OfficeSDKRequestTag.KEY_NEW_USER, "hash_token", "getHash_token", "t", "hash_token_type", "getHash_token_type", "u", "", "background_time_v2", "Ljava/lang/Long;", "getBackground_time_v2", "()Ljava/lang/Long;", "o", "(Ljava/lang/Long;)V", LocationMonitorConst.IS_BACKGROUND, "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", FaceService.neutralLabel, "(Ljava/lang/Boolean;)V", "timon-monitor-impl_release"}, k = 1, mv = {1, 4, 0})
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Throwable f485229a;

    @SerializedName("api_id")
    private final int api_id;

    @SerializedName("async_config_enable")
    private boolean async_config_enable;

    @SerializedName("async_stack_enable")
    private boolean async_stack_enable;

    @SerializedName("async_stack_strategy_v2")
    private boolean async_stack_strategy_v2;

    @SerializedName("legacy_background_time")
    private Long background_time_v2;

    @SerializedName("bpea_info")
    private Map<String, String> bpea_info;

    @SerializedName("class_name")
    private final String class_name;

    @SerializedName("custom_info")
    private Map<String, String> custom_info;

    @SerializedName("event_process")
    private String event_process;

    @SerializedName("event_thread")
    private String event_thread;

    @SerializedName("extra_params")
    private Map<String, Object> extra_params;

    @SerializedName("full_stack")
    private String full_stack;

    @SerializedName("hash_token")
    private Integer hash_token;

    @SerializedName("hash_token_type")
    private Integer hash_token_type;

    @SerializedName("is_reflection")
    private boolean isReflection;

    @SerializedName("legacy_is_background")
    private Boolean is_background;

    @SerializedName("is_downgrade")
    private boolean is_downgrade;

    @SerializedName(LocationMonitorConst.IS_VALID)
    private boolean is_valid;

    @SerializedName("jsb_info")
    private JSBInfoData jsb_info;

    @SerializedName("method_name")
    private final String method_name;

    @SerializedName("page_info")
    private List<PageDataManager.b> page_info;

    @SerializedName(LocationMonitorConst.PERMISSION_STATUS)
    private int permission_status;

    @SerializedName("permission_type")
    private String permission_type;

    @SerializedName("privacy_api_params")
    private Map<String, ? extends Object> privacy_api_params;

    @SerializedName("related_ui_action")
    private UIActionData related_ui_action;

    @SerializedName("scene_id")
    private Integer scene_id;

    @SerializedName("stack")
    private String stack;

    @SerializedName("strategies")
    private List<c> strategies;

    @SerializedName("strategy_md5")
    private String strategy_md5;

    @SerializedName("ui_actions")
    private List<UIActionData> ui_actions;

    public f() {
        throw null;
    }

    public final void B() {
        this.related_ui_action = null;
    }

    public final void G() {
        this.ui_actions = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == false) goto L68;
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.class_name, r101.class_name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.method_name, r101.method_name) == true) goto L10;
        return false;
    L10:
        if (this.permission_status == r101.permission_status) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.permission_type, r101.permission_type) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.privacy_api_params, r101.privacy_api_params) == true) goto L16;
        return false;
    L16:
        if (this.api_id == r101.api_id) goto L18;
        return false;
    L18:
        if (this.is_valid == r101.is_valid) goto L20;
        return false;
    L20:
        if (this.is_downgrade == r101.is_downgrade) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.strategy_md5, r101.strategy_md5) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.strategies, r101.strategies) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.bpea_info, r101.bpea_info) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.jsb_info, r101.jsb_info) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.custom_info, r101.custom_info) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.page_info, r101.page_info) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.event_thread, r101.event_thread) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.event_process, r101.event_process) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.stack, r101.stack) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.full_stack, r101.full_stack) == true) goto L42;
        return false;
    L42:
        if (this.isReflection == r101.isReflection) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.ui_actions, r101.ui_actions) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.related_ui_action, r101.related_ui_action) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.scene_id, r101.scene_id) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.extra_params, r101.extra_params) == true) goto L52;
        return false;
    L52:
        if (this.async_config_enable == r101.async_config_enable) goto L54;
        return false;
    L54:
        if (this.async_stack_enable == r101.async_stack_enable) goto L56;
        return false;
    L56:
        if (this.async_stack_strategy_v2 == r101.async_stack_strategy_v2) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.hash_token, r101.hash_token) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.hash_token_type, r101.hash_token_type) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.background_time_v2, r101.background_time_v2) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.is_background, r101.is_background) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.f485229a, r101.f485229a) == true) goto L103;
        return false;
    L103:
        return true;
    L68:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v103 */
    /* JADX WARN: Type inference failed for: r2v104 */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v106 */
    /* JADX WARN: Type inference failed for: r2v107 */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v60, types: [int] */
    /* JADX WARN: Type inference failed for: r2v62, types: [int] */
    /* JADX WARN: Type inference failed for: r2v81 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v98 */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.class_name;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.method_name;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (((r103 + r105) * 31) + this.permission_status) * 31;
        String r107 = this.permission_type;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, ? extends Object> r110 = this.privacy_api_params;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.api_id) * 31;
        boolean r113 = this.is_valid;
        ?? r114 = 1;
        ?? r115 = r113;
        if (r113 == false) goto L21;
        r115 = 1;
    L21:
        int r116 = (r112 + r115) * 31;
        boolean r117 = this.is_downgrade;
        ?? r118 = r117;
        if (r117 == false) goto L24;
        r118 = 1;
    L24:
        int r119 = (r116 + r118) * 31;
        String r120 = this.strategy_md5;
        if (r120 == null) goto L27;
        int r121 = r120.hashCode();
    L28:
        int r122 = (r119 + r121) * 31;
        List<c> r123 = this.strategies;
        if (r123 == null) goto L31;
        int r124 = r123.hashCode();
    L32:
        int r125 = (r122 + r124) * 31;
        Map<String, String> r126 = this.bpea_info;
        if (r126 == null) goto L35;
        int r127 = r126.hashCode();
    L36:
        int r128 = (r125 + r127) * 31;
        JSBInfoData r129 = this.jsb_info;
        if (r129 == null) goto L39;
        int r130 = r129.hashCode();
    L40:
        int r131 = (r128 + r130) * 31;
        Map<String, String> r132 = this.custom_info;
        if (r132 == null) goto L43;
        int r133 = r132.hashCode();
    L44:
        int r134 = (r131 + r133) * 31;
        List<PageDataManager.b> r135 = this.page_info;
        if (r135 == null) goto L47;
        int r136 = r135.hashCode();
    L48:
        int r137 = (r134 + r136) * 31;
        String r138 = this.event_thread;
        if (r138 == null) goto L51;
        int r139 = r138.hashCode();
    L52:
        int r140 = (r137 + r139) * 31;
        String r141 = this.event_process;
        if (r141 == null) goto L55;
        int r142 = r141.hashCode();
    L56:
        int r143 = (r140 + r142) * 31;
        String r144 = this.stack;
        if (r144 == null) goto L59;
        int r145 = r144.hashCode();
    L60:
        int r146 = (r143 + r145) * 31;
        String r147 = this.full_stack;
        if (r147 == null) goto L63;
        int r148 = r147.hashCode();
    L64:
        int r149 = (r146 + r148) * 31;
        boolean r150 = this.isReflection;
        ?? r151 = r150;
        if (r150 == false) goto L67;
        r151 = 1;
    L67:
        int r152 = (r149 + r151) * 31;
        List<UIActionData> r153 = this.ui_actions;
        if (r153 == null) goto L70;
        int r154 = r153.hashCode();
    L71:
        int r155 = (r152 + r154) * 31;
        UIActionData r156 = this.related_ui_action;
        if (r156 == null) goto L74;
        int r157 = r156.hashCode();
    L75:
        int r158 = (r155 + r157) * 31;
        Integer r159 = this.scene_id;
        if (r159 == null) goto L78;
        int r160 = r159.hashCode();
    L79:
        int r161 = (r158 + r160) * 31;
        Map<String, Object> r162 = this.extra_params;
        if (r162 == null) goto L82;
        int r163 = r162.hashCode();
    L83:
        int r164 = (r161 + r163) * 31;
        boolean r165 = this.async_config_enable;
        ?? r166 = r165;
        if (r165 == false) goto L86;
        r166 = 1;
    L86:
        int r167 = (r164 + r166) * 31;
        boolean r168 = this.async_stack_enable;
        ?? r169 = r168;
        if (r168 == false) goto L89;
        r169 = 1;
    L89:
        int r170 = (r167 + r169) * 31;
        boolean r171 = this.async_stack_strategy_v2;
        if (r171 == true) goto L93;
        r114 = r171;
    L93:
        int r172 = (r170 + r114) * 31;
        Integer r173 = this.hash_token;
        if (r173 == null) goto L96;
        int r174 = r173.hashCode();
    L97:
        int r175 = (r172 + r174) * 31;
        Integer r176 = this.hash_token_type;
        if (r176 == null) goto L100;
        int r177 = r176.hashCode();
    L101:
        int r178 = (r175 + r177) * 31;
        Long r179 = this.background_time_v2;
        if (r179 == null) goto L104;
        int r180 = r179.hashCode();
    L105:
        int r181 = (r178 + r180) * 31;
        Boolean r182 = this.is_background;
        if (r182 == null) goto L108;
        int r183 = r182.hashCode();
    L109:
        int r184 = (r181 + r183) * 31;
        Throwable r185 = this.f485229a;
        if (r185 == null) goto L113;
        r101 = r185.hashCode();
    L113:
        return r184 + r101;
    L108:
        r183 = 0;
        goto L109
    L104:
        r180 = 0;
        goto L105
    L100:
        r177 = 0;
        goto L101
    L96:
        r174 = 0;
        goto L97
    L82:
        r163 = 0;
        goto L83
    L78:
        r160 = 0;
        goto L79
    L74:
        r157 = 0;
        goto L75
    L70:
        r154 = 0;
        goto L71
    L63:
        r148 = 0;
        goto L64
    L59:
        r145 = 0;
        goto L60
    L55:
        r142 = 0;
        goto L56
    L51:
        r139 = 0;
        goto L52
    L47:
        r136 = 0;
        goto L48
    L43:
        r133 = 0;
        goto L44
    L39:
        r130 = 0;
        goto L40
    L35:
        r127 = 0;
        goto L36
    L31:
        r124 = 0;
        goto L32
    L27:
        r121 = 0;
        goto L28
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final void l() {
        this.async_config_enable = false;
    }

    public final void m() {
        this.async_stack_enable = false;
    }

    public final void n() {
        this.async_stack_strategy_v2 = false;
    }

    public final String toString() {
        return "PrivacyApiData(class_name=" + this.class_name + ", method_name=" + this.method_name + ", permission_status=" + this.permission_status + ", permission_type=" + this.permission_type + ", privacy_api_params=" + this.privacy_api_params + ", api_id=" + this.api_id + ", is_valid=" + this.is_valid + ", is_downgrade=" + this.is_downgrade + ", strategy_md5=" + this.strategy_md5 + ", strategies=" + this.strategies + ", bpea_info=" + this.bpea_info + ", jsb_info=" + this.jsb_info + ", custom_info=" + this.custom_info + ", page_info=" + this.page_info + ", event_thread=" + this.event_thread + ", event_process=" + this.event_process + ", stack=" + this.stack + ", full_stack=" + this.full_stack + ", isReflection=" + this.isReflection + ", ui_actions=" + this.ui_actions + ", related_ui_action=" + this.related_ui_action + ", scene_id=" + this.scene_id + ", extra_params=" + this.extra_params + ", async_config_enable=" + this.async_config_enable + ", async_stack_enable=" + this.async_stack_enable + ", async_stack_strategy_v2=" + this.async_stack_strategy_v2 + ", hash_token=" + this.hash_token + ", hash_token_type=" + this.hash_token_type + ", background_time_v2=" + this.background_time_v2 + ", is_background=" + this.is_background + ", throwable=" + this.f485229a + ")";
    }

    public final void v() {
        this.jsb_info = null;
    }

    public final void s() {
        this.full_stack = "";
    }

    public final int a() {
        return this.api_id;
    }

    public final Map<String, String> b() {
        return this.bpea_info;
    }

    public final String c() {
        return this.class_name;
    }

    public final String d() {
        return this.event_thread;
    }

    public final String e() {
        return this.full_stack;
    }

    public final String f() {
        return this.method_name;
    }

    public final Map<String, Object> g() {
        return this.privacy_api_params;
    }

    public final String h() {
        return this.stack;
    }

    public final List<c> i() {
        return this.strategies;
    }

    public final boolean j() {
        return this.isReflection;
    }

    public final boolean k() {
        return this.is_downgrade;
    }

    public final void A(boolean r100) {
        this.isReflection = r100;
    }

    public final void C(Integer r100) {
        this.scene_id = r100;
    }

    public final void D(String r100) {
        this.stack = r100;
    }

    public final void E(List<c> r100) {
        this.strategies = r100;
    }

    public final void F(String r100) {
        this.strategy_md5 = r100;
    }

    public final void H(Boolean r100) {
        this.is_background = r100;
    }

    public final void I(boolean r100) {
        this.is_downgrade = r100;
    }

    public final void J(boolean r100) {
        this.is_valid = r100;
    }

    public final void o(Long r100) {
        this.background_time_v2 = r100;
    }

    public final void p(String r100) {
        this.event_process = r100;
    }

    public final void q(String r100) {
        this.event_thread = r100;
    }

    public final void r(Map<String, Object> r100) {
        this.extra_params = r100;
    }

    public final void t(Integer r100) {
        this.hash_token = r100;
    }

    public final void u(Integer r100) {
        this.hash_token_type = r100;
    }

    public final void w(List<PageDataManager.b> r100) {
        this.page_info = r100;
    }

    public final void x(int r100) {
        this.permission_status = r100;
    }

    public final void y(String r100) {
        this.permission_type = r100;
    }

    public final void z(Map<String, ? extends Object> r100) {
        this.privacy_api_params = r100;
    }

    public f(String r100, String r101, int r102) {
        Map<String, ? extends Object> r103 = MapsKt.emptyMap();
        LinkedHashMap r104 = new LinkedHashMap();
        LinkedHashMap r105 = new LinkedHashMap();
        this.class_name = r100;
        this.method_name = r101;
        this.permission_status = 0;
        this.permission_type = "";
        this.privacy_api_params = r103;
        this.api_id = r102;
        this.is_valid = true;
        this.is_downgrade = false;
        this.strategy_md5 = "";
        this.strategies = null;
        this.bpea_info = r104;
        this.jsb_info = null;
        this.custom_info = null;
        this.page_info = null;
        this.event_thread = null;
        this.event_process = null;
        this.stack = "";
        this.full_stack = "";
        this.isReflection = false;
        this.ui_actions = null;
        this.related_ui_action = null;
        this.scene_id = -1;
        this.extra_params = r105;
        this.async_config_enable = false;
        this.async_stack_enable = false;
        this.async_stack_strategy_v2 = false;
        this.hash_token = null;
        this.hash_token_type = null;
        this.background_time_v2 = null;
        this.is_background = null;
        this.f485229a = null;
    }
}
