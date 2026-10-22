package com.bytedance.android.shopping.buynow.eventcenter.handle;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.buynow.viewmodel.BuyNowViewModel;
import com.gyf.barlibrary.ImmersionBar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfJsBridgeFunction extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Context a;
    public final BuyNowViewModel b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/eventcenter/handle/SelfJsBridgeFunction$SelfJsBridgeType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "EC_GALLERY", "SEND_AD_LOG", "SET_CONTAINER", "GET_BCM_CHAIN_V2", "APPEND_ENTRANCE_INFO", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum SelfJsBridgeType extends Enum<SelfJsBridgeType> {
        public static final SelfJsBridgeType APPEND_ENTRANCE_INFO = null;
        public static final SelfJsBridgeType EC_GALLERY = null;
        public static final SelfJsBridgeType GET_BCM_CHAIN_V2 = null;
        public static final SelfJsBridgeType SEND_AD_LOG = null;
        public static final SelfJsBridgeType SET_CONTAINER = null;
        public static final /* synthetic */ SelfJsBridgeType[] a = null;
        private final String type;

        static {
            SelfJsBridgeType r1 = new SelfJsBridgeType("EC_GALLERY", 0, "ecGallery");
            EC_GALLERY = r1;
            SelfJsBridgeType r2 = new SelfJsBridgeType("SEND_AD_LOG", 1, "sendAdLog");
            SEND_AD_LOG = r2;
            SelfJsBridgeType r3 = new SelfJsBridgeType("SET_CONTAINER", 2, "setContainer");
            SET_CONTAINER = r3;
            SelfJsBridgeType r4 = new SelfJsBridgeType("GET_BCM_CHAIN_V2", 3, "getBcmChainV2");
            GET_BCM_CHAIN_V2 = r4;
            SelfJsBridgeType r5 = new SelfJsBridgeType("APPEND_ENTRANCE_INFO", 4, "appendEntranceInfo");
            APPEND_ENTRANCE_INFO = r5;
            a = new SelfJsBridgeType[]{r1, r2, r3, r4, r5};
        }

        public static SelfJsBridgeType valueOf(String r1) {
            return (SelfJsBridgeType) r27.a.a(SelfJsBridgeType.class, r1);
        }

        public static SelfJsBridgeType[] values() {
            return (SelfJsBridgeType[]) a.clone();
        }

        public final String getType() {
            return this.type;
        }

        public SelfJsBridgeType(String r1, int r2, String r3) {
            super(r1, r2);
            this.type = r3;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/buynow/eventcenter/handle/SelfJsBridgeFunction$StatusBarMode;", "", "", "mode", "Ljava/lang/String;", "getMode", "()Ljava/lang/String;", "DARK", "LIGHT", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum StatusBarMode extends Enum<StatusBarMode> {
        public static final StatusBarMode DARK = null;
        public static final StatusBarMode LIGHT = null;
        public static final /* synthetic */ StatusBarMode[] a = null;
        private final String mode;

        static {
            StatusBarMode r1 = new StatusBarMode("DARK", 0, "dark");
            DARK = r1;
            StatusBarMode r2 = new StatusBarMode("LIGHT", 1, "light");
            LIGHT = r2;
            a = new StatusBarMode[]{r1, r2};
        }

        public static StatusBarMode valueOf(String r1) {
            return (StatusBarMode) r27.a.a(StatusBarMode.class, r1);
        }

        public static StatusBarMode[] values() {
            return (StatusBarMode[]) a.clone();
        }

        public final String getMode() {
            return this.mode;
        }

        public StatusBarMode(String r1, int r2, String r3) {
            super(r1, r2);
            this.mode = r3;
        }
    }

    public static final class a {
    }

    static {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r19) {
        Intrinsics.checkNotNullParameter(r19, "input");
        BuyNowLog.d("selfJSBridge", "selfJSBridge start");
        Object r3 = r19.p(Reflection.getOrCreateKotlinClass(String.class), "type");
        if ((r3 instanceof String) == true) goto L5;
        r3 = null;
    L5:
        String r4 = com.bytedance.android.shopping.extensions.k.j((String) r3);
        Object r5 = r19.p(Reflection.getOrCreateKotlinClass(Map.class), "params");
        if ((r5 instanceof Map) == true) goto L8;
        r5 = null;
    L8:
        Map r6 = (Map) r5;
        if (r6 != null) goto L12;
        r6 = MapsKt.emptyMap();
    L12:
        if (r4.length() != 0) goto L14;
        boolean r7 = true;
    L15:
        if (r7 == false) goto L19;
        BuyNowLog.d("selfJSBridge", "selfJSBridge type is empty");
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfJSBridge", "type is empty", r19);
        int r0 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "type is empty", null, null, 57);
    L19:
        if (Intrinsics.areEqual(r4, SelfJsBridgeType.EC_GALLERY.getType()) == false) goto L43;
        BuyNowLog.d("selfJSBridge", "selfJSBridge: ecGallery start");
        Object r1 = r6.get("images");
        if ((r1 instanceof List) == true) goto L23;
        r1 = null;
    L23:
        List r2 = (List) r1;
        if (r2 != null) goto L26;
        r2 = CollectionsKt.emptyList();
    L26:
        List r11 = r2;
        Object r8 = r6.get("index");
        if ((r8 instanceof Integer) == true) goto L29;
        r8 = null;
    L29:
        int r13 = com.bytedance.android.shopping.extensions.k.f((Integer) r8);
        Object r9 = r6.get("titles");
        if ((r9 instanceof List) == true) goto L32;
        r9 = null;
    L32:
        List r10 = (List) r9;
        if (r10 != null) goto L35;
        r10 = CollectionsKt.emptyList();
    L35:
        List r12 = r10;
        Object r14 = r6.get("drag");
        if ((r14 instanceof Boolean) == true) goto L38;
        r14 = null;
    L38:
        boolean r15 = com.bytedance.android.shopping.extensions.k.i((Boolean) r14);
        Object r16 = r6.get("download");
        if ((r16 instanceof Boolean) == true) goto L41;
        r16 = null;
    L41:
        boolean r17 = com.bytedance.android.shopping.extensions.k.i((Boolean) r16);
        int r18 = com.bytedance.android.shopping.buynow.utils.o.a;
        com.bytedance.android.shopping.buynow.utils.o.a(this.a, CollectionsKt.emptyList(), r11, r12, r13, r15, r17);
    L140:
        BuyNowLog.d("selfJSBridge", "selfJSBridge finishes");
        int r20 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L43:
        if (Intrinsics.areEqual(r4, SelfJsBridgeType.SEND_AD_LOG.getType()) == false) goto L77;
        BuyNowLog.d("selfJSBridge", "selfJSBridge: sendAdLog start");
        Object r21 = r6.get("tag");
        if ((r21 instanceof String) == true) goto L47;
        r21 = null;
    L47:
        String r110 = com.bytedance.android.shopping.extensions.k.j((String) r21);
        Object r22 = r6.get("label");
        if ((r22 instanceof String) == true) goto L50;
        r22 = null;
    L50:
        String r111 = com.bytedance.android.shopping.extensions.k.j((String) r22);
        Object r23 = r6.get("creative_id");
        if ((r23 instanceof String) == true) goto L53;
        r23 = null;
    L53:
        String r112 = com.bytedance.android.shopping.extensions.k.j((String) r23);
        Object r24 = r6.get("extParam");
        if ((r24 instanceof Map) == true) goto L56;
        r24 = null;
    L56:
        Map<String, ? extends Object> r113 = (Map) r24;
        if (r113 == null) goto L59;
        Object r25 = r113.get("category");
    L61:
        if ((r25 instanceof String) == true) goto L63;
        r25 = null;
    L63:
        String r114 = (String) r25;
        Object r26 = r6.get("refer");
        if ((r26 instanceof String) == true) goto L66;
        r26 = null;
    L66:
        String r115 = (String) r26;
        Object r27 = r6.get("group_id");
        if ((r27 instanceof String) == true) goto L69;
        r27 = null;
    L69:
        String r116 = com.bytedance.android.shopping.extensions.k.j((String) r27);
        Object r28 = r6.get("log_extra");
        if ((r28 instanceof String) == true) goto L72;
        r28 = null;
    L72:
        String r117 = (String) r28;
        int r29 = ECSdk.a;
        s83.g r30 = (s83.g) ECSdk.a(s83.g.class);
        if (r30 == null) goto L75;
        r30.d(r110, r111, r115, r112, r117, r113, r116, r114);
        goto L140
    L75:
        com.bytedance.android.shopping.buynow.monitor.error.a.e(this.b.getTracker(), "selfJSBridge", "IEShoppingHostService is null", r19);
        goto L140
    L59:
        r25 = null;
        goto L61
    L77:
        if (Intrinsics.areEqual(r4, SelfJsBridgeType.SET_CONTAINER.getType()) == false) goto L110;
        BuyNowLog.d("selfJSBridge", "selfJsBridge: setContainer start");
        Object r31 = r6.get("pageUI");
        if ((r31 instanceof Map) == true) goto L81;
        r31 = null;
    L81:
        Map r32 = (Map) r31;
        if (r32 == null) goto L84;
        Object r33 = r32.get("statusFontMode");
    L86:
        if ((r33 instanceof String) == true) goto L88;
        r33 = null;
    L88:
        String r34 = (String) r33;
        if (r34 != null) goto L92;
        r34 = "";
    L92:
        if (Intrinsics.areEqual(r34, StatusBarMode.DARK.getMode()) == false) goto L101;
        Activity r35 = l0.b(this.a);
        if (r35 == null) goto L140;
        ImmersionBar r36 = ImmersionBar.with(r35);
        if (r36 == null) goto L140;
        ImmersionBar r37 = r36.statusBarDarkFont(true);
        if (r37 == null) goto L140;
        r37.init();
        goto L140
    L101:
        if (Intrinsics.areEqual(r34, StatusBarMode.LIGHT.getMode()) == false) goto L140;
        Activity r38 = l0.b(this.a);
        if (r38 == null) goto L140;
        ImmersionBar r39 = ImmersionBar.with(r38);
        if (r39 == null) goto L140;
        ImmersionBar r40 = r39.statusBarDarkFont(false);
        if (r40 == null) goto L140;
        r40.init();
        goto L140
    L84:
        r33 = null;
        goto L86
    L110:
        if (Intrinsics.areEqual(r4, SelfJsBridgeType.GET_BCM_CHAIN_V2.getType()) == false) goto L129;
        Object r41 = r6.get("btm");
        if ((r41 instanceof String) == true) goto L114;
        r41 = null;
    L114:
        String r42 = com.bytedance.android.shopping.extensions.k.j((String) r41);
        Object r43 = r6.get("bcm");
        if ((r43 instanceof Map) == true) goto L117;
        r43 = null;
    L117:
        Map r44 = (Map) r43;
        Object r45 = r6.get("chain_length");
        if ((r45 instanceof Number) == true) goto L120;
        r45 = null;
    L120:
        Number r46 = (Number) r45;
        if (r46 == null) goto L123;
        r46.intValue();
    L123:
        Object r47 = r6.get("is_domain_standard");
        if ((r47 instanceof Boolean) == true) goto L126;
        r47 = null;
    L126:
        com.bytedance.android.shopping.extensions.k.i((Boolean) r47);
        int r48 = o43.b.a;
        PageFinder r49 = this.b.getStaticState().d;
        Intrinsics.checkNotNullParameter(r42, "btm");
        LinkedHashMap r50 = new LinkedHashMap();
        r50.put("bcm_chain", null);
        int r51 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, r50, null, 5);
    L129:
        if (Intrinsics.areEqual(r4, SelfJsBridgeType.APPEND_ENTRANCE_INFO.getType()) == false) goto L140;
        Object r52 = r6.get("btm");
        if ((r52 instanceof String) == true) goto L133;
        r52 = null;
    L133:
        String r53 = (String) r52;
        Result.Companion r54 = Result.Companion;     // Catch: Throwable -> L136
        int r55 = o43.b.a;     // Catch: Throwable -> L136
        PageFinder r56 = this.b.getStaticState().d;     // Catch: Throwable -> L136
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L136
    L138:
        int r57 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("entrance_info", r53)), null, 5);
    L136:
        th = move-exception;
        Result.Companion r58 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L138
    L14:
        r7 = false;
        goto L15
    }

    public SelfJsBridgeFunction(Context r2, BuyNowViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        this.a = r2;
        this.b = r3;
    }
}
