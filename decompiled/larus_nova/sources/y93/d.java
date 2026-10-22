package y93;

import com.amap.api.col.s.ce;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.lynx.service.monitor.LynxMonitorService;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.log.IVideoEventLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010#\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u001c\u0010'\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016R\u001c\u0010)\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016R\u001c\u0010+\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010\u0016R\u001c\u0010/\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u0016R\u001c\u00103\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016R\u001c\u00105\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010\u000bR\u001a\u00107\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109¨\u0006:"}, d2 = {"Ly93/d;", "", "", "schema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "itemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "status", "getStatus", "errCode", "getErrCode", "errMsg", "b", "", "renderStart", "Ljava/lang/Long;", "getRenderStart", "()Ljava/lang/Long;", "renderEnd", "getRenderEnd", "isPreload", "scene", "getScene", "", "prefDict", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setupTiming", ce.f26391f, IVideoEventLogger.FEATURE_KEY_PREPARE_DECODE_ONLY, "d", "createKitViewEnd", "getCreateKitViewEnd", "transDataStart", "getTransDataStart", "transDataEnd", "getTransDataEnd", "lynxRenderLoadStart", "getLynxRenderLoadStart", "lynxCardLoadStart", "getLynxCardLoadStart", "updateStart", "getUpdateStart", "loadResource", "getLoadResource", "readTemplate", "getReadTemplate", "bindType", "getBindType", "isFirstScreenReady", "I", "()I", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566970a;

    @SerializedName("bind_type")
    private final Integer bindType;

    @SerializedName("create_kit_view_end")
    private final Long createKitViewEnd;

    @SerializedName("error_code")
    private final Integer errCode;

    @SerializedName("error_msg")
    private final String errMsg;

    @SerializedName("is_first_screen_ready")
    private final int isFirstScreenReady;

    @SerializedName("is_preload")
    private final Integer isPreload;

    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ITEM_TYPE)
    private final Integer itemType;

    @SerializedName("t_load_resource")
    private final Long loadResource;

    @SerializedName("lynx_card_load_start")
    private final Long lynxCardLoadStart;

    @SerializedName("lynx_render_load_start")
    private final Long lynxRenderLoadStart;

    @SerializedName(IVideoEventLogger.FEATURE_KEY_PREPARE_DECODE_ONLY)
    private final Integer pre_decode;

    @SerializedName("perf_dict")
    private final Map<String, Object> prefDict;

    @SerializedName("t_read_template")
    private final Long readTemplate;

    @SerializedName("lynx_t_render_end")
    private final Long renderEnd;

    @SerializedName("lynx_t_render_start")
    private final Long renderStart;

    @SerializedName("scene")
    private final String scene;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private final String schema;

    @SerializedName(LynxMonitorService.KEY_SETUP_TIMING)
    private final Map<String, Object> setupTiming;

    @SerializedName("status")
    private final Integer status;

    @SerializedName("trans_data_end")
    private final Long transDataEnd;

    @SerializedName("trans_data_start")
    private final Long transDataStart;

    @SerializedName("t_update_start")
    private final Long updateStart;

    /* JADX WARN: Multi-variable type inference failed */
    public d() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 8388607);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L52;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemType, r101.itemType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errCode, r101.errCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.errMsg, r101.errMsg) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.renderStart, r101.renderStart) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.renderEnd, r101.renderEnd) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.isPreload, r101.isPreload) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prefDict, r101.prefDict) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.setupTiming, r101.setupTiming) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.pre_decode, r101.pre_decode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createKitViewEnd, r101.createKitViewEnd) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.transDataStart, r101.transDataStart) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.transDataEnd, r101.transDataEnd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lynxRenderLoadStart, r101.lynxRenderLoadStart) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.lynxCardLoadStart, r101.lynxCardLoadStart) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.updateStart, r101.updateStart) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadResource, r101.loadResource) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.readTemplate, r101.readTemplate) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.bindType, r101.bindType) == true) goto L48;
        return false;
    L48:
        if (this.isFirstScreenReady == r101.isFirstScreenReady) goto L50;
        return false;
    L50:
        if (this.f566970a == r101.f566970a) goto L79;
        return false;
    L79:
        return true;
    L52:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v46, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final int hashCode() {
        String r100 = this.schema;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.itemType;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.status;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.errCode;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.errMsg;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Long r116 = this.renderStart;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Long r119 = this.renderEnd;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.isPreload;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.scene;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Map<String, Object> r128 = this.prefDict;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        Map<String, Object> r131 = this.setupTiming;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        Integer r134 = this.pre_decode;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.createKitViewEnd;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        Long r140 = this.transDataStart;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        Long r143 = this.transDataEnd;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        Long r146 = this.lynxRenderLoadStart;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        Long r149 = this.lynxCardLoadStart;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        Long r152 = this.updateStart;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        Long r155 = this.loadResource;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        Long r158 = this.readTemplate;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        Integer r161 = this.bindType;
        if (r161 == null) goto L85;
        r101 = r161.hashCode();
    L85:
        int r162 = (((r160 + r101) * 31) + this.isFirstScreenReady) * 31;
        boolean r163 = this.f566970a;
        ?? r164 = r163;
        if (r163 == false) goto L89;
        r164 = 1;
    L89:
        return r162 + r164;
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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

    public final String toString() {
        return "LynxCardMonitorBean(schema=" + this.schema + ", itemType=" + this.itemType + ", status=" + this.status + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", renderStart=" + this.renderStart + ", renderEnd=" + this.renderEnd + ", isPreload=" + this.isPreload + ", scene=" + this.scene + ", prefDict=" + this.prefDict + ", setupTiming=" + this.setupTiming + ", pre_decode=" + this.pre_decode + ", createKitViewEnd=" + this.createKitViewEnd + ", transDataStart=" + this.transDataStart + ", transDataEnd=" + this.transDataEnd + ", lynxRenderLoadStart=" + this.lynxRenderLoadStart + ", lynxCardLoadStart=" + this.lynxCardLoadStart + ", updateStart=" + this.updateStart + ", loadResource=" + this.loadResource + ", readTemplate=" + this.readTemplate + ", bindType=" + this.bindType + ", isFirstScreenReady=" + this.isFirstScreenReady + ", _reported=" + this.f566970a + ")";
    }

    public final String b() {
        return this.errMsg;
    }

    public final Integer c() {
        return this.itemType;
    }

    public final Integer d() {
        return this.pre_decode;
    }

    public final Map<String, Object> e() {
        return this.prefDict;
    }

    public final String f() {
        return this.schema;
    }

    public final Map<String, Object> g() {
        return this.setupTiming;
    }

    public /* synthetic */ d(Integer r210, String r211, int r212) {
        if ((r212 & 2) == 0) goto L5;
        Integer r100 = null;
    L7:
        if ((r212 & 256) == 0) goto L9;
        String r110 = null;
    L11:
        if ((r212 & 2097152) == 0) goto L13;
        int r213 = -1;
    L14:
        this(null, r100, null, null, null, null, null, null, r110, null, null, null, null, null, null, null, null, null, null, null, null, r213, false);
        return;
    L13:
        r213 = 0;
        goto L14
    L9:
        r110 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }

    public static d a(d r210, String r211, Integer r212, Integer r310, Integer r311, String r312, Long r313, Long r314, Integer r315, Map r316, Map r317, Integer r318, Long r319, Long r410, Long r411, Long r412, Long r413, Integer r414, int r415, boolean r416, int r417) {
        if ((r417 & 1) == 0) goto L5;
        String r100 = r210.schema;
    L7:
        if ((r417 & 2) == 0) goto L9;
        Integer r101 = r210.itemType;
    L11:
        if ((r417 & 4) == 0) goto L13;
        Integer r102 = r210.status;
    L15:
        if ((r417 & 8) == 0) goto L17;
        Integer r103 = r210.errCode;
    L19:
        if ((r417 & 16) == 0) goto L21;
        String r104 = r210.errMsg;
    L23:
        if ((r417 & 32) == 0) goto L25;
        Long r105 = r210.renderStart;
    L27:
        if ((r417 & 64) == 0) goto L29;
        Long r110 = r210.renderEnd;
    L31:
        if ((r417 & 128) == 0) goto L33;
        Integer r111 = r210.isPreload;
    L35:
        if ((r417 & 256) == 0) goto L37;
        String r112 = r210.scene;
    L39:
        if ((r417 & 512) == 0) goto L41;
        Map r113 = r210.prefDict;
    L43:
        if ((r417 & 1024) == 0) goto L45;
        Map r114 = r210.setupTiming;
    L47:
        if ((r417 & 2048) == 0) goto L49;
        Integer r115 = r210.pre_decode;
    L51:
        if ((r417 & 4096) == 0) goto L53;
        Long r116 = r210.createKitViewEnd;
    L55:
        if ((r417 & 8192) == 0) goto L57;
        Long r117 = r210.transDataStart;
    L59:
        if ((r417 & 16384) == 0) goto L61;
        Long r118 = r210.transDataEnd;
    L63:
        if ((32768 & r417) == 0) goto L65;
        Long r119 = r210.lynxRenderLoadStart;
    L67:
        if ((65536 & r417) == 0) goto L69;
        Long r213 = r210.lynxCardLoadStart;
    L71:
        if ((131072 & r417) == 0) goto L73;
        Long r214 = r210.updateStart;
    L75:
        if ((262144 & r417) == 0) goto L77;
        Long r215 = r210.loadResource;
    L79:
        if ((524288 & r417) == 0) goto L81;
        Long r216 = r210.readTemplate;
    L83:
        if ((1048576 & r417) == 0) goto L85;
        Integer r217 = r210.bindType;
    L87:
        if ((2097152 & r417) == 0) goto L89;
        int r218 = r210.isFirstScreenReady;
    L91:
        if ((r417 & 4194304) == 0) goto L93;
        boolean r219 = r210.f566970a;
    L94:
        r210.getClass();
        return new d(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r213, r214, r215, r216, r217, r218, r219);
    L93:
        r219 = r416;
        goto L94
    L89:
        r218 = r415;
        goto L91
    L85:
        r217 = r414;
        goto L87
    L81:
        r216 = null;
        goto L83
    L77:
        r215 = null;
        goto L79
    L73:
        r214 = r413;
        goto L75
    L69:
        r213 = r412;
        goto L71
    L65:
        r119 = null;
        goto L67
    L61:
        r118 = r411;
        goto L63
    L57:
        r117 = r410;
        goto L59
    L53:
        r116 = r319;
        goto L55
    L49:
        r115 = r318;
        goto L51
    L45:
        r114 = r317;
        goto L47
    L41:
        r113 = r316;
        goto L43
    L37:
        r112 = null;
        goto L39
    L33:
        r111 = r315;
        goto L35
    L29:
        r110 = r314;
        goto L31
    L25:
        r105 = r313;
        goto L27
    L21:
        r104 = r312;
        goto L23
    L17:
        r103 = r311;
        goto L19
    L13:
        r102 = r310;
        goto L15
    L9:
        r101 = r212;
        goto L11
    L5:
        r100 = r211;
        goto L7
    }

    public d(String r100, Integer r101, Integer r102, Integer r103, String r104, Long r105, Long r106, Integer r110, String r111, Map<String, ? extends Object> r112, Map<String, ? extends Object> r113, Integer r114, Long r115, Long r116, Long r117, Long r118, Long r119, Long r210, Long r211, Long r212, Integer r213, int r214, boolean r215) {
        this.schema = r100;
        this.itemType = r101;
        this.status = r102;
        this.errCode = r103;
        this.errMsg = r104;
        this.renderStart = r105;
        this.renderEnd = r106;
        this.isPreload = r110;
        this.scene = r111;
        this.prefDict = r112;
        this.setupTiming = r113;
        this.pre_decode = r114;
        this.createKitViewEnd = r115;
        this.transDataStart = r116;
        this.transDataEnd = r117;
        this.lynxRenderLoadStart = r118;
        this.lynxCardLoadStart = r119;
        this.updateStart = r210;
        this.loadResource = r211;
        this.readTemplate = r212;
        this.bindType = r213;
        this.isFirstScreenReady = r214;
        this.f566970a = r215;
    }
}
