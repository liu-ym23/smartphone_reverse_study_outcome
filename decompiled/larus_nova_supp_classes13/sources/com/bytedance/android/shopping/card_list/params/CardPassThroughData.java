package com.bytedance.android.shopping.card_list.params;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001f\b\u0086\b\u0018\u0000 92\u00020\u0001:\u0001:By\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b7\u00108J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000b\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J{\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032(\b\u0002\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010\u0010\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010*RB\u0010\u0012\u001a\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010(\u001a\u0004\b0\u0010*\"\u0004\b1\u00102R$\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010(\u001a\u0004\b3\u0010*\"\u0004\b4\u00102R$\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010(\u001a\u0004\b5\u0010*\"\u0004\b6\u00102¨\u0006;"}, d2 = {"Lcom/bytedance/android/shopping/card_list/params/CardPassThroughData;", "Ljava/io/Serializable;", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getSchemaParamsOrCreate", "Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "component1", "Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "component2", "component3", "component4", "component5", "component6", "component7", "cartSchemaData", "collectSchemaData", "sessionId", "schemaParams", "monitorId", "ecomSceneId", "splitActivityScene", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "getCartSchemaData", "()Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;", "setCartSchemaData", "(Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;)V", "Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "getCollectSchemaData", "()Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;", "setCollectSchemaData", "(Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;)V", "Ljava/lang/String;", "getSessionId", "()Ljava/lang/String;", "Ljava/util/HashMap;", "getSchemaParams", "()Ljava/util/HashMap;", "setSchemaParams", "(Ljava/util/HashMap;)V", "getMonitorId", "setMonitorId", "(Ljava/lang/String;)V", "getEcomSceneId", "setEcomSceneId", "getSplitActivityScene", "setSplitActivityScene", "<init>", "(Lcom/bytedance/android/shopping/card_list/params/CartPassThroughData;Lcom/bytedance/android/shopping/card_list/params/CollectPassThroughData;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardPassThroughData implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;

    @SerializedName("cart_schema_data")
    private CartPassThroughData cartSchemaData;

    @SerializedName("collect_schema_data")
    private CollectPassThroughData collectSchemaData;

    @SerializedName("ecom_scene_id")
    private String ecomSceneId;

    @SerializedName("ec_monitor_key")
    private String monitorId;

    @SerializedName("schema_params")
    private HashMap<String, String> schemaParams;

    @SerializedName("session_id")
    private final String sessionId;

    @SerializedName("split_activity_scene")
    private String splitActivityScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public CardPassThroughData() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CardPassThroughData copy$default(CardPassThroughData r5, CartPassThroughData r6, CollectPassThroughData r7, String r8, HashMap r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.cartSchemaData;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.collectSchemaData;
    L8:
        CollectPassThroughData r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.sessionId;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.schemaParams;
    L14:
        HashMap r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.monitorId;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.ecomSceneId;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.splitActivityScene;
    L23:
        CartPassThroughData r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final CartPassThroughData component1() {
        return this.cartSchemaData;
    }

    public final CollectPassThroughData component2() {
        return this.collectSchemaData;
    }

    public final String component3() {
        return this.sessionId;
    }

    public final HashMap<String, String> component4() {
        return this.schemaParams;
    }

    public final String component5() {
        return this.monitorId;
    }

    public final String component6() {
        return this.ecomSceneId;
    }

    public final String component7() {
        return this.splitActivityScene;
    }

    public final CardPassThroughData copy(CartPassThroughData r10, CollectPassThroughData r11, String r12, HashMap<String, String> r13, String r14, String r15, String r16) {
        return new CardPassThroughData(r10, r11, r12, r13, r14, r15, r16);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CardPassThroughData) == false) goto L20;
        CardPassThroughData r4 = (CardPassThroughData) r3;
        if (Intrinsics.areEqual(this.cartSchemaData, r4.cartSchemaData) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.collectSchemaData, r4.collectSchemaData) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.sessionId, r4.sessionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.schemaParams, r4.schemaParams) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.monitorId, r4.monitorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.ecomSceneId, r4.ecomSceneId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.splitActivityScene, r4.splitActivityScene) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        CartPassThroughData r0 = this.cartSchemaData;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        CollectPassThroughData r4 = this.collectSchemaData;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.sessionId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        HashMap<String, String> r10 = this.schemaParams;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.monitorId;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.ecomSceneId;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.splitActivityScene;
        if (r19 == null) goto L30;
        r1 = r19.hashCode();
    L30:
        return r18 + r1;
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
        return "CardPassThroughData(cartSchemaData=" + this.cartSchemaData + ", collectSchemaData=" + this.collectSchemaData + ", sessionId=" + this.sessionId + ", schemaParams=" + this.schemaParams + ", monitorId=" + this.monitorId + ", ecomSceneId=" + this.ecomSceneId + ", splitActivityScene=" + this.splitActivityScene + ")";
    }

    public final HashMap<String, String> getSchemaParamsOrCreate() {
        HashMap<String, String> r0 = this.schemaParams;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new HashMap();
    }

    public final CartPassThroughData getCartSchemaData() {
        return this.cartSchemaData;
    }

    public final CollectPassThroughData getCollectSchemaData() {
        return this.collectSchemaData;
    }

    public final String getEcomSceneId() {
        return this.ecomSceneId;
    }

    public final String getMonitorId() {
        return this.monitorId;
    }

    public final HashMap<String, String> getSchemaParams() {
        return this.schemaParams;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final String getSplitActivityScene() {
        return this.splitActivityScene;
    }

    public final void setCartSchemaData(CartPassThroughData r1) {
        this.cartSchemaData = r1;
    }

    public final void setCollectSchemaData(CollectPassThroughData r1) {
        this.collectSchemaData = r1;
    }

    public final void setEcomSceneId(String r1) {
        this.ecomSceneId = r1;
    }

    public final void setMonitorId(String r1) {
        this.monitorId = r1;
    }

    public final void setSchemaParams(HashMap<String, String> r1) {
        this.schemaParams = r1;
    }

    public final void setSplitActivityScene(String r1) {
        this.splitActivityScene = r1;
    }

    public CardPassThroughData(CartPassThroughData r1, CollectPassThroughData r2, String r3, HashMap<String, String> r4, String r5, String r6, String r7) {
        this.cartSchemaData = r1;
        this.collectSchemaData = r2;
        this.sessionId = r3;
        this.schemaParams = r4;
        this.monitorId = r5;
        this.ecomSceneId = r6;
        this.splitActivityScene = r7;
    }

    public /* synthetic */ CardPassThroughData(CartPassThroughData r7, CollectPassThroughData r8, String r9, HashMap r10, String r11, String r12, String r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L5;
        CartPassThroughData r16 = null;
    L7:
        if ((r14 & 2) == 0) goto L9;
        CollectPassThroughData r1 = null;
    L11:
        if ((r14 & 4) == 0) goto L13;
        String r2 = null;
    L15:
        if ((r14 & 8) == 0) goto L17;
        r10 = new HashMap();
    L17:
        HashMap r3 = r10;
        if ((r14 & 16) == 0) goto L20;
        String r4 = null;
    L22:
        if ((r14 & 32) == 0) goto L24;
        String r5 = null;
    L26:
        if ((r14 & 64) == 0) goto L28;
        String r17 = null;
    L29:
        this(r16, r1, r2, r3, r4, r5, r17);
        return;
    L28:
        r17 = r13;
        goto L29
    L24:
        r5 = r12;
        goto L26
    L20:
        r4 = r11;
        goto L22
    L13:
        r2 = r9;
        goto L15
    L9:
        r1 = r8;
        goto L11
    L5:
        r16 = r7;
        goto L7
    }
}
