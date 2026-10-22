package com.bytedance.android.shopping.sku.params.schema;

import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.android.ec.core.hybrid.utils.k;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ul.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\u00020!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010'\u001a\u00020&8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001a\u0010,\u001a\u00020+8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00105\u001a\b\u0012\u0004\u0012\u000204038\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/sku/params/schema/SkuSchemaParams;", "Lul/i;", "Ljava/io/Serializable;", "Landroid/net/Uri;", "uri", "initData", "Lorg/json/JSONObject;", "getJSONSchema", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "productInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "getProductInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuProductInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "bizContext", "Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "getBizContext", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuBizContext;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "userInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "getUserInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuUserInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "clientParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "getClientParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuClientParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "chainInfo", "Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "getChainInfo", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuChainInfo;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "customParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "getCustomParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuCustomParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "passThrough", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "getPassThrough", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuPassThrough;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "platformParams", "Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "getPlatformParams", "()Lcom/bytedance/android/shopping/sku/params/schema/SkuPlatformParams;", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductContext;", "productContext", "Lcom/bytedance/android/shopping/sku/params/schema/SkuProductContext;", "", "", "passThroughToKeys", "Ljava/util/List;", "getPassThroughToKeys", "()Ljava/util/List;", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkuSchemaParams extends i implements Serializable {

    @SerializedName("biz_context")
    private final SkuBizContext bizContext;

    @SerializedName("chain_info")
    private final SkuChainInfo chainInfo;

    @SerializedName("client_params")
    private final SkuClientParams clientParams;

    @SerializedName("custom_params")
    private final SkuCustomParams customParams;

    @SerializedName("pass_through")
    private final SkuPassThrough passThrough;
    private final List<String> passThroughToKeys;

    @SerializedName("platform_params")
    private final SkuPlatformParams platformParams;
    private final SkuProductContext productContext;

    @SerializedName("product_info")
    private final SkuProductInfo productInfo;

    @SerializedName("user_info")
    private final SkuUserInfo userInfo;

    public final JSONObject getJSONSchema() {
        JSONObject r0 = new JSONObject();
        String r1 = this.productInfo.getParamKey();
        int r2 = k.a;
        r0.put(r1, k.b(this.productInfo.getMap()));
        r0.put(this.bizContext.getParamKey(), k.b(this.bizContext.getMap()));
        r0.put(this.userInfo.getParamKey(), k.b(this.userInfo.getMap()));
        r0.put(this.clientParams.getParamKey(), k.b(this.clientParams.getMap()));
        r0.put(this.chainInfo.getParamKey(), k.b(this.chainInfo.getMap()));
        r0.put(this.customParams.getParamKey(), k.b(this.customParams.getMap()));
        r0.put(this.platformParams.getParamKey(), k.b(this.platformParams.getMap()));
        r0.put(this.productContext.getParamKey(), k.b(this.productContext.getMap()));
        r0.put(this.passThrough.getParamKey(), k.a(this.passThrough.getList()));
        return r0;
    }

    public SkuSchemaParams() {
        this.productInfo = new SkuProductInfo();
        this.bizContext = new SkuBizContext();
        this.userInfo = new SkuUserInfo();
        this.clientParams = new SkuClientParams();
        this.chainInfo = new SkuChainInfo();
        this.customParams = new SkuCustomParams();
        this.passThrough = new SkuPassThrough();
        this.platformParams = new SkuPlatformParams();
        this.productContext = new SkuProductContext();
        this.passThroughToKeys = new ArrayList();
    }

    public final SkuBizContext getBizContext() {
        return this.bizContext;
    }

    public final SkuChainInfo getChainInfo() {
        return this.chainInfo;
    }

    public final SkuClientParams getClientParams() {
        return this.clientParams;
    }

    public final SkuCustomParams getCustomParams() {
        return this.customParams;
    }

    public final SkuPassThrough getPassThrough() {
        return this.passThrough;
    }

    public final List<String> getPassThroughToKeys() {
        return this.passThroughToKeys;
    }

    public final SkuPlatformParams getPlatformParams() {
        return this.platformParams;
    }

    public final SkuProductInfo getProductInfo() {
        return this.productInfo;
    }

    public final SkuUserInfo getUserInfo() {
        return this.userInfo;
    }

    public final SkuSchemaParams initData(Uri r8) {
        Intrinsics.checkNotNullParameter(r8, "uri");
        final long r0 = SystemClock.elapsedRealtime();
        this.productInfo.initData(r8);
        this.bizContext.initData(r8);
        this.userInfo.initData(r8);
        this.clientParams.initData(r8);
        this.chainInfo.initData(r8);
        this.customParams.initData(r8);
        this.passThrough.initData(r8);
        this.platformParams.initData(r8);
        this.productContext.initData(r8);
        String r9 = this.bizContext.getAuthorId();
        boolean r2 = false;
        if (r9 != null) goto L5;
    L8:
        boolean r10 = true;
    L9:
        String r4 = null;
        if (r10 == false) goto L22;
        String r11 = this.productContext.getAuthorId();
        if (r11 == null) goto L22;
        if (r11.length() <= 0) goto L16;
        boolean r5 = true;
    L17:
        if (r5 == true) goto L20;
        r11 = null;
    L20:
        if (r11 == null) goto L22;
        this.bizContext.appendOrReplaceParams("author_id", r11);
        goto L22
    L16:
        r5 = false;
    L22:
        String r12 = this.bizContext.getSecAuthorId();
        if (r12 != null) goto L25;
    L28:
        boolean r13 = true;
    L29:
        if (r13 == false) goto L41;
        String r14 = this.productContext.getSecAuthorId();
        if (r14 == null) goto L41;
        if (r14.length() <= 0) goto L35;
        boolean r6 = true;
    L36:
        if (r6 == true) goto L39;
        r14 = null;
    L39:
        if (r14 == null) goto L41;
        this.bizContext.appendOrReplaceParams(PdpOpenThirdParam.KEY_SEC_AUTHOR_ID, r14);
        goto L41
    L35:
        r6 = false;
    L41:
        String r15 = this.chainInfo.getMarketingChannel();
        if (r15 != null) goto L44;
    L47:
        boolean r16 = true;
    L48:
        if (r16 == false) goto L60;
        String r17 = this.productContext.getMarketingChannel();
        if (r17 == null) goto L60;
        if (r17.length() <= 0) goto L54;
        boolean r7 = true;
    L55:
        if (r7 == true) goto L58;
        r17 = null;
    L58:
        if (r17 == null) goto L60;
        this.chainInfo.appendOrReplaceParams("marketing_channel", r17);
        goto L60
    L54:
        r7 = false;
    L60:
        String r18 = this.bizContext.getRoomId();
        if (r18 != null) goto L63;
    L66:
        boolean r19 = true;
    L67:
        if (r19 == false) goto L79;
        String r20 = this.productContext.getRoomId();
        if (r20 == null) goto L79;
        if (r20.length() <= 0) goto L73;
        boolean r21 = true;
    L74:
        if (r21 == true) goto L77;
        r20 = null;
    L77:
        if (r20 == null) goto L79;
        this.bizContext.appendOrReplaceParams("room_id", r20);
        goto L79
    L73:
        r21 = false;
    L79:
        Boolean r22 = this.bizContext.isGroupBuy();
        Boolean r23 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r22, r23)) == true) goto L82;
    L84:
        String r24 = this.bizContext.getOrderUrl();
        if (r24 != null) goto L87;
    L90:
        boolean r25 = true;
    L91:
        if (r25 == false) goto L103;
        String r26 = this.productContext.getOrderUrl();
        if (r26 == null) goto L103;
        if (r26.length() <= 0) goto L97;
        boolean r27 = true;
    L98:
        if (r27 == true) goto L101;
        r26 = null;
    L101:
        if (r26 == null) goto L103;
        this.bizContext.appendOrReplaceParams(PdpOpenThirdParam.KEY_ORDER_URL, r26);
        goto L103
    L97:
        r27 = false;
    L103:
        String r28 = this.bizContext.getItemId();
        if (r28 != null) goto L106;
    L109:
        boolean r29 = true;
    L110:
        if (r29 == false) goto L122;
        String r30 = this.productContext.getItemId();
        if (r30 == null) goto L122;
        if (r30.length() <= 0) goto L116;
        boolean r31 = true;
    L117:
        if (r31 == true) goto L120;
        r30 = null;
    L120:
        if (r30 == null) goto L122;
        this.bizContext.appendOrReplaceParams(PdpOpenThirdParam.KEY_ITEM_ID, r30);
        goto L122
    L116:
        r31 = false;
    L122:
        String r32 = this.bizContext.getActionType();
        if (r32 != null) goto L125;
    L128:
        boolean r33 = true;
    L129:
        if (r33 == false) goto L144;
        Object r34 = this.chainInfo.getMap().get("action_type");
        if ((r34 instanceof String) == true) goto L133;
        r34 = null;
    L133:
        String r35 = (String) r34;
        if (r35 == null) goto L144;
        if (r35.length() <= 0) goto L138;
        boolean r36 = true;
    L139:
        if (r36 == true) goto L142;
        r35 = null;
    L142:
        if (r35 == null) goto L144;
        this.bizContext.appendOrReplaceParams("action_type", r35);
        goto L144
    L138:
        r36 = false;
    L144:
        String r37 = this.bizContext.getSceneType();
        if (r37 != null) goto L147;
    L150:
        boolean r38 = true;
    L151:
        if (r38 == false) goto L166;
        Object r39 = this.chainInfo.getMap().get("scene_type");
        if ((r39 instanceof String) == true) goto L155;
        r39 = null;
    L155:
        String r40 = (String) r39;
        if (r40 == null) goto L166;
        if (r40.length() <= 0) goto L160;
        boolean r41 = true;
    L161:
        if (r41 == true) goto L164;
        r40 = null;
    L164:
        if (r40 == null) goto L166;
        this.bizContext.appendOrReplaceParams("scene_type", r40);
        goto L166
    L160:
        r41 = false;
    L166:
        String r42 = this.bizContext.getSkuId();
        if (r42 != null) goto L169;
    L172:
        boolean r43 = true;
    L173:
        if (r43 == false) goto L189;
        Object r44 = this.clientParams.getMap().get("default_sku_id");
        if ((r44 instanceof String) == true) goto L177;
        r44 = null;
    L177:
        String r45 = (String) r44;
        if (r45 == null) goto L189;
        if (r45.length() <= 0) goto L182;
        boolean r46 = true;
    L183:
        if (r46 == true) goto L186;
        r45 = null;
    L186:
        if (r45 == null) goto L189;
        this.bizContext.appendOrReplaceParams("default_sku_id", r45);
        goto L189
    L182:
        r46 = false;
    L189:
        if (this.bizContext.getHotSaleType() != null) goto L196;
        Object r47 = this.clientParams.getMap().get("hot_sale_type");
        if ((r47 instanceof Integer) == true) goto L193;
        r47 = null;
    L193:
        Integer r48 = (Integer) r47;
        if (r48 == null) goto L196;
        this.bizContext.appendOrReplaceParams("hot_sale_type", Integer.valueOf(r48.intValue()));
    L196:
        String r49 = this.bizContext.getDetailUrl();
        if (r49 != null) goto L199;
    L202:
        boolean r50 = true;
    L203:
        if (r50 == false) goto L216;
        Object r51 = this.clientParams.getMap().get("detail_url");
        if ((r51 instanceof String) == true) goto L207;
        r51 = null;
    L207:
        String r52 = (String) r51;
        if (r52 == null) goto L216;
        if (r52.length() <= 0) goto L212;
        r2 = true;
    L212:
        if (r2 == false) goto L214;
        r4 = r52;
    L214:
        if (r4 == null) goto L216;
        this.bizContext.appendOrReplaceParams("detail_url", r4);
    L216:
        Lazy r53 = SkuCommonLog.a;
        SkuCommonLog.a("SkuSchemaParams", new AnonymousClass1(r0));
        return this;
    L199:
        if (r49.length() == 0) goto L202;
        r50 = false;
        goto L203
    L169:
        if (r42.length() == 0) goto L172;
        r43 = false;
        goto L173
    L147:
        if (r37.length() == 0) goto L150;
        r38 = false;
        goto L151
    L125:
        if (r32.length() == 0) goto L128;
        r33 = false;
        goto L129
    L106:
        if (r28.length() == 0) goto L109;
        r29 = false;
        goto L110
    L87:
        if (r24.length() == 0) goto L90;
        r25 = false;
        goto L91
    L82:
        if (Intrinsics.areEqual(this.productContext.isGroupBuy(), r23) == false) goto L84;
        this.bizContext.appendOrReplaceParams("is_group_buy", r23);
        goto L84
    L63:
        if (r18.length() == 0) goto L66;
        r19 = false;
        goto L67
    L44:
        if (r15.length() == 0) goto L47;
        r16 = false;
        goto L48
    L25:
        if (r12.length() == 0) goto L28;
        r13 = false;
        goto L29
    L5:
        if (r9.length() == 0) goto L8;
        r10 = false;
        goto L9
    }
}
