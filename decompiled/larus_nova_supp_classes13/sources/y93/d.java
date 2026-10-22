package y93;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u001e\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0019\u0010\u000bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R(\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R*\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\u001e\u001a\u0004\b\"\u0010 R\u001c\u0010#\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR\u001c\u0010%\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016R\u001c\u0010'\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0014\u001a\u0004\b(\u0010\u0016R\u001c\u0010)\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010\u0014\u001a\u0004\b*\u0010\u0016R\u001c\u0010+\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010\u0014\u001a\u0004\b,\u0010\u0016R\u001c\u0010-\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0014\u001a\u0004\b.\u0010\u0016R\u001c\u0010/\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b/\u0010\u0014\u001a\u0004\b0\u0010\u0016R\u001c\u00101\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u0016R\u001c\u00103\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016R\u001c\u00105\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b6\u0010\u000bR\u001a\u00107\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b7\u00109¨\u0006:"}, d2 = {"Ly93/d;", "", "", "schema", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "", "itemType", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "status", "getStatus", "errCode", "getErrCode", "errMsg", "b", "", "renderStart", "Ljava/lang/Long;", "getRenderStart", "()Ljava/lang/Long;", "renderEnd", "getRenderEnd", "isPreload", "scene", "getScene", "", "prefDict", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "setupTiming", "g", "pre_decode", "d", "createKitViewEnd", "getCreateKitViewEnd", "transDataStart", "getTransDataStart", "transDataEnd", "getTransDataEnd", "lynxRenderLoadStart", "getLynxRenderLoadStart", "lynxCardLoadStart", "getLynxCardLoadStart", "updateStart", "getUpdateStart", "loadResource", "getLoadResource", "readTemplate", "getReadTemplate", "bindType", "getBindType", "isFirstScreenReady", "I", "()I", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {
    public final boolean a;

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

    @SerializedName("item_type")
    private final Integer itemType;

    @SerializedName("t_load_resource")
    private final Long loadResource;

    @SerializedName("lynx_card_load_start")
    private final Long lynxCardLoadStart;

    @SerializedName("lynx_render_load_start")
    private final Long lynxRenderLoadStart;

    @SerializedName("pre_decode")
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

    @SerializedName("lynx_schema")
    private final String schema;

    @SerializedName("setup_timing")
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
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 8388607);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof d) == false) goto L52;
        d r4 = (d) r3;
        if (Intrinsics.areEqual(this.schema, r4.schema) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.itemType, r4.itemType) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.errCode, r4.errCode) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.errMsg, r4.errMsg) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.renderStart, r4.renderStart) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.renderEnd, r4.renderEnd) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.isPreload, r4.isPreload) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.scene, r4.scene) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.prefDict, r4.prefDict) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.setupTiming, r4.setupTiming) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.pre_decode, r4.pre_decode) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.createKitViewEnd, r4.createKitViewEnd) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.transDataStart, r4.transDataStart) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.transDataEnd, r4.transDataEnd) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.lynxRenderLoadStart, r4.lynxRenderLoadStart) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.lynxCardLoadStart, r4.lynxCardLoadStart) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.updateStart, r4.updateStart) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.loadResource, r4.loadResource) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.readTemplate, r4.readTemplate) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.bindType, r4.bindType) == true) goto L48;
        return false;
    L48:
        if (this.isFirstScreenReady == r4.isFirstScreenReady) goto L50;
        return false;
    L50:
        if (this.a == r4.a) goto L79;
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
        String r0 = this.schema;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.itemType;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.status;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.errCode;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.errMsg;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.renderStart;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        Long r19 = this.renderEnd;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.isPreload;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.scene;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        Map<String, Object> r28 = this.prefDict;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        Map<String, Object> r31 = this.setupTiming;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.pre_decode;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        Long r37 = this.createKitViewEnd;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        Long r40 = this.transDataStart;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Long r43 = this.transDataEnd;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        Long r46 = this.lynxRenderLoadStart;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        Long r49 = this.lynxCardLoadStart;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        Long r52 = this.updateStart;
        if (r52 == null) goto L73;
        int r53 = r52.hashCode();
    L74:
        int r54 = (r51 + r53) * 31;
        Long r55 = this.loadResource;
        if (r55 == null) goto L77;
        int r56 = r55.hashCode();
    L78:
        int r57 = (r54 + r56) * 31;
        Long r58 = this.readTemplate;
        if (r58 == null) goto L81;
        int r59 = r58.hashCode();
    L82:
        int r60 = (r57 + r59) * 31;
        Integer r61 = this.bindType;
        if (r61 == null) goto L85;
        r1 = r61.hashCode();
    L85:
        int r62 = (((r60 + r1) * 31) + this.isFirstScreenReady) * 31;
        boolean r63 = this.a;
        ?? r64 = r63;
        if (r63 == false) goto L89;
        r64 = 1;
    L89:
        return r62 + r64;
    L81:
        r59 = 0;
        goto L82
    L77:
        r56 = 0;
        goto L78
    L73:
        r53 = 0;
        goto L74
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "LynxCardMonitorBean(schema=" + this.schema + ", itemType=" + this.itemType + ", status=" + this.status + ", errCode=" + this.errCode + ", errMsg=" + this.errMsg + ", renderStart=" + this.renderStart + ", renderEnd=" + this.renderEnd + ", isPreload=" + this.isPreload + ", scene=" + this.scene + ", prefDict=" + this.prefDict + ", setupTiming=" + this.setupTiming + ", pre_decode=" + this.pre_decode + ", createKitViewEnd=" + this.createKitViewEnd + ", transDataStart=" + this.transDataStart + ", transDataEnd=" + this.transDataEnd + ", lynxRenderLoadStart=" + this.lynxRenderLoadStart + ", lynxCardLoadStart=" + this.lynxCardLoadStart + ", updateStart=" + this.updateStart + ", loadResource=" + this.loadResource + ", readTemplate=" + this.readTemplate + ", bindType=" + this.bindType + ", isFirstScreenReady=" + this.isFirstScreenReady + ", _reported=" + this.a + ")";
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

    public /* synthetic */ d(Integer r26, String r27, int r28) {
        if ((r28 & 2) == 0) goto L5;
        Integer r2 = null;
    L7:
        if ((r28 & 256) == 0) goto L9;
        String r10 = null;
    L11:
        if ((r28 & 2097152) == 0) goto L13;
        int r24 = -1;
    L14:
        this(null, r2, null, null, null, null, null, null, r10, null, null, null, null, null, null, null, null, null, null, null, null, r24, false);
        return;
    L13:
        r24 = 0;
        goto L14
    L9:
        r10 = r27;
        goto L11
    L5:
        r2 = r26;
        goto L7
    }

    public static d a(d r27, String r28, Integer r29, Integer r30, Integer r31, String r32, Long r33, Long r34, Integer r35, Map r36, Map r37, Integer r38, Long r39, Long r40, Long r41, Long r42, Long r43, Integer r44, int r45, boolean r46, int r47) {
        if ((r47 & 1) == 0) goto L5;
        String r4 = r27.schema;
    L7:
        if ((r47 & 2) == 0) goto L9;
        Integer r5 = r27.itemType;
    L11:
        if ((r47 & 4) == 0) goto L13;
        Integer r6 = r27.status;
    L15:
        if ((r47 & 8) == 0) goto L17;
        Integer r7 = r27.errCode;
    L19:
        if ((r47 & 16) == 0) goto L21;
        String r8 = r27.errMsg;
    L23:
        if ((r47 & 32) == 0) goto L25;
        Long r9 = r27.renderStart;
    L27:
        if ((r47 & 64) == 0) goto L29;
        Long r10 = r27.renderEnd;
    L31:
        if ((r47 & 128) == 0) goto L33;
        Integer r11 = r27.isPreload;
    L35:
        if ((r47 & 256) == 0) goto L37;
        String r12 = r27.scene;
    L39:
        if ((r47 & 512) == 0) goto L41;
        Map r13 = r27.prefDict;
    L43:
        if ((r47 & 1024) == 0) goto L45;
        Map r14 = r27.setupTiming;
    L47:
        if ((r47 & 2048) == 0) goto L49;
        Integer r15 = r27.pre_decode;
    L51:
        if ((r47 & 4096) == 0) goto L53;
        Long r16 = r27.createKitViewEnd;
    L55:
        if ((r47 & 8192) == 0) goto L57;
        Long r17 = r27.transDataStart;
    L59:
        if ((r47 & 16384) == 0) goto L61;
        Long r18 = r27.transDataEnd;
    L63:
        if ((32768 & r47) == 0) goto L65;
        Long r19 = r27.lynxRenderLoadStart;
    L67:
        if ((65536 & r47) == 0) goto L69;
        Long r20 = r27.lynxCardLoadStart;
    L71:
        if ((131072 & r47) == 0) goto L73;
        Long r21 = r27.updateStart;
    L75:
        if ((262144 & r47) == 0) goto L77;
        Long r22 = r27.loadResource;
    L79:
        if ((524288 & r47) == 0) goto L81;
        Long r23 = r27.readTemplate;
    L83:
        if ((1048576 & r47) == 0) goto L85;
        Integer r24 = r27.bindType;
    L87:
        if ((2097152 & r47) == 0) goto L89;
        int r25 = r27.isFirstScreenReady;
    L91:
        if ((r47 & 4194304) == 0) goto L93;
        boolean r26 = r27.a;
    L94:
        r27.getClass();
        return new d(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L93:
        r26 = r46;
        goto L94
    L89:
        r25 = r45;
        goto L91
    L85:
        r24 = r44;
        goto L87
    L81:
        r23 = null;
        goto L83
    L77:
        r22 = null;
        goto L79
    L73:
        r21 = r43;
        goto L75
    L69:
        r20 = r42;
        goto L71
    L65:
        r19 = null;
        goto L67
    L61:
        r18 = r41;
        goto L63
    L57:
        r17 = r40;
        goto L59
    L53:
        r16 = r39;
        goto L55
    L49:
        r15 = r38;
        goto L51
    L45:
        r14 = r37;
        goto L47
    L41:
        r13 = r36;
        goto L43
    L37:
        r12 = null;
        goto L39
    L33:
        r11 = r35;
        goto L35
    L29:
        r10 = r34;
        goto L31
    L25:
        r9 = r33;
        goto L27
    L21:
        r8 = r32;
        goto L23
    L17:
        r7 = r31;
        goto L19
    L13:
        r6 = r30;
        goto L15
    L9:
        r5 = r29;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }

    public d(String r3, Integer r4, Integer r5, Integer r6, String r7, Long r8, Long r9, Integer r10, String r11, Map<String, ? extends Object> r12, Map<String, ? extends Object> r13, Integer r14, Long r15, Long r16, Long r17, Long r18, Long r19, Long r20, Long r21, Long r22, Integer r23, int r24, boolean r25) {
        this.schema = r3;
        this.itemType = r4;
        this.status = r5;
        this.errCode = r6;
        this.errMsg = r7;
        this.renderStart = r8;
        this.renderEnd = r9;
        this.isPreload = r10;
        this.scene = r11;
        this.prefDict = r12;
        this.setupTiming = r13;
        this.pre_decode = r14;
        this.createKitViewEnd = r15;
        this.transDataStart = r16;
        this.transDataEnd = r17;
        this.lynxRenderLoadStart = r18;
        this.lynxCardLoadStart = r19;
        this.updateStart = r20;
        this.loadResource = r21;
        this.readTemplate = r22;
        this.bindType = r23;
        this.isFirstScreenReady = r24;
        this.a = r25;
    }
}
