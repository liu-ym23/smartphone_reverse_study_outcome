package com.bytedance.android.shopping.new_cart.params;

import com.bytedance.kmp.ec.yata.common.biz.YataPageInfo;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b-\b\u0086\b\u0018\u0000 Y2\u00020\u0001:\u0001ZBã\u0001\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u0013\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\bW\u0010XJ\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000eHÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0013HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jå\u0001\u0010)\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010%\u001a\u00020\u00132\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001J\t\u0010+\u001a\u00020\u0013HÖ\u0001J\u0013\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010,HÖ\u0003R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00100\u001a\u0004\b1\u00102R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u00100\u001a\u0004\b3\u00102R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00100\u001a\u0004\b4\u00102R$\u0010\u001c\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u00100\u001a\u0004\b5\u00102\"\u0004\b6\u00107R$\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u00100\u001a\u0004\b8\u00102\"\u0004\b9\u00107R$\u0010\u001e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u00100\u001a\u0004\b:\u00102\"\u0004\b;\u00107R$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u00100\u001a\u0004\b<\u00102\"\u0004\b=\u00107R$\u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u00100\u001a\u0004\b>\u00102\"\u0004\b?\u00107RB\u0010!\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\rj\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\bE\u00102\"\u0004\bF\u00107R$\u0010#\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u00100\u001a\u0004\bG\u00102\"\u0004\bH\u00107R$\u0010$\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u00100\u001a\u0004\bI\u00102\"\u0004\bJ\u00107R\"\u0010%\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR$\u0010&\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u00100\u001a\u0004\bP\u00102\"\u0004\bQ\u00107R\u001c\u0010'\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010R\u001a\u0004\bS\u0010TR$\u0010(\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u00100\u001a\u0004\bU\u00102\"\u0004\bV\u00107¨\u0006["}, d2 = {"Lcom/bytedance/android/shopping/new_cart/params/CartParams;", "Ljava/io/Serializable;", "", "", "getSchemaParamsOrCreate", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "component9", "component10", "component11", "component12", "", "component13", "component14", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "component15", "component16", "newSourceType", "historyPath", "enterFromLiveSaas", "ecomSceneId", "cartIds", "shopIds", "showShopIds", "anchorCartId", "schemaParams", "durationMonitorKey", "yataPerfMonitorKey", "transparentParams", "heightPercent", "deliverySessionId", "pageInfo", "splitActivityScene", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getNewSourceType", "()Ljava/lang/String;", "getHistoryPath", "getEnterFromLiveSaas", "getEcomSceneId", "setEcomSceneId", "(Ljava/lang/String;)V", "getCartIds", "setCartIds", "getShopIds", "setShopIds", "getShowShopIds", "setShowShopIds", "getAnchorCartId", "setAnchorCartId", "Ljava/util/HashMap;", "getSchemaParams", "()Ljava/util/HashMap;", "setSchemaParams", "(Ljava/util/HashMap;)V", "getDurationMonitorKey", "setDurationMonitorKey", "getYataPerfMonitorKey", "setYataPerfMonitorKey", "getTransparentParams", "setTransparentParams", "I", "getHeightPercent", "()I", "setHeightPercent", "(I)V", "getDeliverySessionId", "setDeliverySessionId", "Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getPageInfo", "()Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;", "getSplitActivityScene", "setSplitActivityScene", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/kmp/ec/yata/common/biz/YataPageInfo;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartParams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("anchor_cart_id")
    private String anchorCartId;

    @SerializedName("cart_ids")
    private String cartIds;

    @SerializedName("delivery_session_id")
    private String deliverySessionId;

    @SerializedName("ec_monitor_key")
    private String durationMonitorKey;

    @SerializedName("ecom_scene_id")
    private String ecomSceneId;

    @SerializedName("enter_from_live_saas")
    private final String enterFromLiveSaas;

    @SerializedName("height_percent")
    private int heightPercent;

    @SerializedName("history_path")
    private final String historyPath;

    @SerializedName("new_source_type")
    private final String newSourceType;

    @SerializedName("page_info")
    private final YataPageInfo pageInfo;

    @SerializedName("schema_params")
    private HashMap<String, String> schemaParams;

    @SerializedName("shop_ids")
    private String shopIds;

    @SerializedName("show_shop_ids")
    private String showShopIds;

    @SerializedName("split_activity_scene")
    private String splitActivityScene;

    @SerializedName("transparent_params")
    private String transparentParams;

    @SerializedName("yata_monitor_key")
    private String yataPerfMonitorKey;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CartParams() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CartParams copy$default(CartParams r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, HashMap r26, String r27, String r28, String r29, int r30, String r31, YataPageInfo r32, String r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        String r2 = r17.newSourceType;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = r17.historyPath;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = r17.enterFromLiveSaas;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = r17.ecomSceneId;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = r17.cartIds;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r7 = r17.shopIds;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r8 = r17.showShopIds;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r9 = r17.anchorCartId;
    L35:
        if ((r34 & 256) == 0) goto L37;
        HashMap r10 = r17.schemaParams;
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r11 = r17.durationMonitorKey;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = r17.yataPerfMonitorKey;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = r17.transparentParams;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        int r14 = r17.heightPercent;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = r17.deliverySessionId;
    L58:
        String r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        YataPageInfo r16 = r17.pageInfo;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r1 = r17.splitActivityScene;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.newSourceType;
    }

    public final String component10() {
        return this.durationMonitorKey;
    }

    public final String component11() {
        return this.yataPerfMonitorKey;
    }

    public final String component12() {
        return this.transparentParams;
    }

    public final int component13() {
        return this.heightPercent;
    }

    public final String component14() {
        return this.deliverySessionId;
    }

    public final YataPageInfo component15() {
        return this.pageInfo;
    }

    public final String component16() {
        return this.splitActivityScene;
    }

    public final String component2() {
        return this.historyPath;
    }

    public final String component3() {
        return this.enterFromLiveSaas;
    }

    public final String component4() {
        return this.ecomSceneId;
    }

    public final String component5() {
        return this.cartIds;
    }

    public final String component6() {
        return this.shopIds;
    }

    public final String component7() {
        return this.showShopIds;
    }

    public final String component8() {
        return this.anchorCartId;
    }

    public final HashMap<String, String> component9() {
        return this.schemaParams;
    }

    public final CartParams copy(String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, HashMap<String, String> r27, String r28, String r29, String r30, int r31, String r32, YataPageInfo r33, String r34) {
        return new CartParams(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CartParams) == false) goto L38;
        CartParams r4 = (CartParams) r3;
        if (Intrinsics.areEqual(this.newSourceType, r4.newSourceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.historyPath, r4.historyPath) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.enterFromLiveSaas, r4.enterFromLiveSaas) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.ecomSceneId, r4.ecomSceneId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cartIds, r4.cartIds) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.shopIds, r4.shopIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.showShopIds, r4.showShopIds) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.anchorCartId, r4.anchorCartId) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.schemaParams, r4.schemaParams) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.durationMonitorKey, r4.durationMonitorKey) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.yataPerfMonitorKey, r4.yataPerfMonitorKey) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.transparentParams, r4.transparentParams) == true) goto L30;
        return false;
    L30:
        if (this.heightPercent == r4.heightPercent) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.deliverySessionId, r4.deliverySessionId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pageInfo, r4.pageInfo) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.splitActivityScene, r4.splitActivityScene) == true) goto L58;
        return false;
    L58:
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        String r0 = this.newSourceType;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.historyPath;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.enterFromLiveSaas;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.ecomSceneId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.cartIds;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.shopIds;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.showShopIds;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.anchorCartId;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        HashMap<String, String> r25 = this.schemaParams;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.durationMonitorKey;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.yataPerfMonitorKey;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.transparentParams;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (((r33 + r35) * 31) + this.heightPercent) * 31;
        String r37 = this.deliverySessionId;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        YataPageInfo r40 = this.pageInfo;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        String r43 = this.splitActivityScene;
        if (r43 == null) goto L62;
        r1 = r43.hashCode();
    L62:
        return r42 + r1;
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

    public String toString() {
        return "CartParams(newSourceType=" + this.newSourceType + ", historyPath=" + this.historyPath + ", enterFromLiveSaas=" + this.enterFromLiveSaas + ", ecomSceneId=" + this.ecomSceneId + ", cartIds=" + this.cartIds + ", shopIds=" + this.shopIds + ", showShopIds=" + this.showShopIds + ", anchorCartId=" + this.anchorCartId + ", schemaParams=" + this.schemaParams + ", durationMonitorKey=" + this.durationMonitorKey + ", yataPerfMonitorKey=" + this.yataPerfMonitorKey + ", transparentParams=" + this.transparentParams + ", heightPercent=" + this.heightPercent + ", deliverySessionId=" + this.deliverySessionId + ", pageInfo=" + this.pageInfo + ", splitActivityScene=" + this.splitActivityScene + ")";
    }

    public final Map<String, String> getSchemaParamsOrCreate() {
        HashMap<String, String> r0 = this.schemaParams;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return new HashMap();
    }

    public final String getAnchorCartId() {
        return this.anchorCartId;
    }

    public final String getCartIds() {
        return this.cartIds;
    }

    public final String getDeliverySessionId() {
        return this.deliverySessionId;
    }

    public final String getDurationMonitorKey() {
        return this.durationMonitorKey;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getEnterFromLiveSaas() {
        return this.enterFromLiveSaas;
    }

    public final int getHeightPercent() {
        return this.heightPercent;
    }

    public final String getHistoryPath() {
        return this.historyPath;
    }

    public final String getNewSourceType() {
        return this.newSourceType;
    }

    public final YataPageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final HashMap<String, String> getSchemaParams() {
        return this.schemaParams;
    }

    public final String getShopIds() {
        return this.shopIds;
    }

    public final String getShowShopIds() {
        return this.showShopIds;
    }

    public final String getSplitActivityScene() {
        return this.splitActivityScene;
    }

    public final String getTransparentParams() {
        return this.transparentParams;
    }

    public final String getYataPerfMonitorKey() {
        return this.yataPerfMonitorKey;
    }

    public final void setAnchorCartId(String r1) {
        this.anchorCartId = r1;
    }

    public final void setCartIds(String r1) {
        this.cartIds = r1;
    }

    public final void setDeliverySessionId(String r1) {
        this.deliverySessionId = r1;
    }

    public final void setDurationMonitorKey(String r1) {
        this.durationMonitorKey = r1;
    }

    public final void setEcomSceneId(String r1) {
        this.ecomSceneId = r1;
    }

    public final void setHeightPercent(int r1) {
        this.heightPercent = r1;
    }

    public final void setSchemaParams(HashMap<String, String> r1) {
        this.schemaParams = r1;
    }

    public final void setShopIds(String r1) {
        this.shopIds = r1;
    }

    public final void setShowShopIds(String r1) {
        this.showShopIds = r1;
    }

    public final void setSplitActivityScene(String r1) {
        this.splitActivityScene = r1;
    }

    public final void setTransparentParams(String r1) {
        this.transparentParams = r1;
    }

    public final void setYataPerfMonitorKey(String r1) {
        this.yataPerfMonitorKey = r1;
    }

    public CartParams(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, HashMap<String, String> r11, String r12, String r13, String r14, int r15, String r16, YataPageInfo r17, String r18) {
        this.newSourceType = r3;
        this.historyPath = r4;
        this.enterFromLiveSaas = r5;
        this.ecomSceneId = r6;
        this.cartIds = r7;
        this.shopIds = r8;
        this.showShopIds = r9;
        this.anchorCartId = r10;
        this.schemaParams = r11;
        this.durationMonitorKey = r12;
        this.yataPerfMonitorKey = r13;
        this.transparentParams = r14;
        this.heightPercent = r15;
        this.deliverySessionId = r16;
        this.pageInfo = r17;
        this.splitActivityScene = r18;
    }

    public /* synthetic */ CartParams(String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, HashMap r26, String r27, String r28, String r29, int r30, String r31, YataPageInfo r32, String r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        HashMap r10 = new HashMap();
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        String r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        int r14 = 0;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        YataPageInfo r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        String r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
