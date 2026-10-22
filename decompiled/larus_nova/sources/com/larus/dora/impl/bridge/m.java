package com.larus.dora.impl.bridge;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeMethodName;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamField;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes27.dex */
@XBridgeMethod(name = "dora.device.getCurrent")
public final class m extends XCoreIDLBridgeMethod<b, c> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final IntRange f332102b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @XBridgeMethodName(name = "dora.device.getCurrent")
    public final String f332103a;

    public static final class a {
    }

    @XBridgeParamModel
    public interface b extends XBaseParamModel {
        @XBridgeParamField(isGetter = true, keyPath = "deviceExtraInfo", required = false)
        List<String> getDeviceExtraInfo();
    }

    @XBridgeResultModel
    public interface c extends XBaseResultModel {
        @XBridgeParamField(isGetter = true, keyPath = Scraps.BATTERY, required = false)
        List<Number> getBattery();

        @XBridgeParamField(isGetter = true, keyPath = "btstate", required = false)
        Number getBtstate();

        @XBridgeParamField(isGetter = true, keyPath = "charge", required = false)
        List<Number> getCharge();

        @XBridgeParamField(isGetter = true, keyPath = "mac", required = false)
        String getMac();

        @XBridgeParamField(isGetter = true, keyPath = "name", required = false)
        String getName();

        @XBridgeParamField(isGetter = true, keyPath = "productId", required = false)
        Number getProductId();

        @XBridgeParamField(isGetter = true, keyPath = "settings", required = false)
        Object getSettings();

        @XBridgeParamField(isGetter = true, keyPath = ECPromotion.SKU, required = false)
        Number getSku();

        @XBridgeParamField(isGetter = true, keyPath = "sn", required = false)
        String getSn();

        @XBridgeParamField(isGetter = true, keyPath = "state", required = false)
        List<Number> getState();

        @XBridgeParamField(isGetter = true, keyPath = "supportAbilities", required = false)
        List<String> getSupportAbilities();

        @XBridgeParamField(isGetter = true, keyPath = "vendorId", required = false)
        Number getVendorId();

        @XBridgeParamField(isGetter = true, keyPath = "version", required = false)
        String getVersion();

        @XBridgeParamField(isGetter = false, keyPath = Scraps.BATTERY, required = false)
        void setBattery(List<? extends Number> r100);

        @XBridgeParamField(isGetter = false, keyPath = "btstate", required = false)
        void setBtstate(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "charge", required = false)
        void setCharge(List<? extends Number> r100);

        @XBridgeParamField(isGetter = false, keyPath = "mac", required = false)
        void setMac(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "name", required = false)
        void setName(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "productId", required = false)
        void setProductId(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "settings", required = false)
        void setSettings(Object r100);

        @XBridgeParamField(isGetter = false, keyPath = ECPromotion.SKU, required = false)
        void setSku(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "sn", required = false)
        void setSn(String r100);

        @XBridgeParamField(isGetter = false, keyPath = "state", required = false)
        void setState(List<? extends Number> r100);

        @XBridgeParamField(isGetter = false, keyPath = "supportAbilities", required = false)
        void setSupportAbilities(List<String> r100);

        @XBridgeParamField(isGetter = false, keyPath = "vendorId", required = false)
        void setVendorId(Number r100);

        @XBridgeParamField(isGetter = false, keyPath = "version", required = false)
        void setVersion(String r100);
    }

    static {
        f332102b = new IntRange(0, 1);
    }

    public m() {
        this.f332103a = "dora.device.getCurrent";
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public final String getName() {
        return this.f332103a;
    }

    public static boolean c(String r100) {
        if (Intrinsics.areEqual(r100, "AdaptationEnable") == false) goto L5;
    L10:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "CueToneVolume") == true) goto L10;
        if (Intrinsics.areEqual(r100, "GestureSettings") == true) goto L10;
        return false;
    }

    public static final List b(m r100, int[] r101) {
        r100.getClass();
        if (r101 == null) goto L13;
        int r102 = 0;
        if (r101.length != 0) goto L7;
        boolean r103 = true;
    L8:
        if (r103 == true) goto L13;
        ArrayList r104 = new ArrayList(r101.length);
        int r105 = r101.length;
    L11:
        if (r102 >= r105) goto L16;
        int r106 = r101[r102];
        Intrinsics.checkNotNull(Integer.valueOf(r106), "null cannot be cast to non-null type kotlin.Number");
        r104.add(Integer.valueOf(r106));
        r102 = r102 + 1;
        goto L11
    L16:
        return r104;
    L7:
        r103 = false;
    L13:
        return null;
    }

    public static Map e(n r100, Set r101) {
        LinkedHashMap r102 = new LinkedHashMap(2);
        if (r101.contains("AdaptationEnable") == false) goto L8;
        Boolean r103 = r100.f332104a;
        if (r103 == null) goto L8;
        r102.put("isAdaptationEnable", Boolean.valueOf(r103.booleanValue()));
    L8:
        if (r101.contains("CueToneVolume") == false) goto L12;
        Integer r104 = r100.f332105b;
        if (r104 == null) goto L12;
        r102.put("cueToneVolume", Integer.valueOf(r104.intValue()));
    L12:
        return r102;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        b r100 = (b) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        kj4.a r101 = kj4.a.g();
        Intrinsics.checkNotNull(r101);
        DoraDevice r102 = DoraAdapterExtKt.h(r101);
        if (r102 != null) goto L5;
        FLogger.f375446a.w("DoraDeviceGetCurrentMethod", "dora.device.getCurrent current device is null");
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "current dora device not found", null, 4, null);
        return;
    L5:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO())), null, null, new DoraDeviceGetCurrentMethod$handle$1(r100, this, r102, r101, r112, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v43, types: [T, java.lang.Integer] */
    public static final Object a(m r210, kj4.a r211, String r212, Set r213, Continuation r214) {
        r210.getClass();
        String r100 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        String r101 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
        if ((r214 instanceof DoraDeviceGetCurrentMethod$loadDeviceSettings$1) == false) goto L7;
        DoraDeviceGetCurrentMethod$loadDeviceSettings$1 r102 = (DoraDeviceGetCurrentMethod$loadDeviceSettings$1) r214;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        Set r107 = (Set) r102.L$6;
        Ref.BooleanRef r108 = (Ref.BooleanRef) r102.L$5;
        Ref.ObjectRef r109 = (Ref.ObjectRef) r102.L$4;
        Ref.ObjectRef r110 = (Ref.ObjectRef) r102.L$3;
        Set r111 = (Set) r102.L$2;
        String r112 = (String) r102.L$1;
        kj4.a r113 = (kj4.a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
        r100 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        final Ref.ObjectRef r114 = r110;
        Set r115 = r111;
        r101 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
        String r116 = r112;
    L145:
        int r117 = ((Number) r104).intValue();     // Catch: Throwable -> L76
        Integer r118 = Boxing.boxInt(r117);     // Catch: Throwable -> L76
        int r119 = r118.intValue();     // Catch: Throwable -> L76
        IntRange r215 = f332102b;     // Catch: Throwable -> L76
        int r120 = r215.getFirst();     // Catch: Throwable -> L76
        kj4.a r216 = r113;
    L74:
        th = th;
    L78:
        r113 = r216;
    L82:
        Result.Companion r121 = Result.Companion;
        Object r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Set r123 = r107;
        Ref.BooleanRef r124 = r108;
        String r125 = r116;
        final Ref.ObjectRef r126 = r109;
        kj4.a r127 = r113;
    L83:
        Throwable r128 = Result.m9452exceptionOrNullimpl(r122);
        if (r128 == null) goto L90;
        FLogger.f375446a.e("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load failed deviceKey=" + r125, r128);
    L90:
        if (r123.contains("CueToneVolume") == true) goto L92;
    L109:
        boolean r129 = true;
        if (r123.contains("CueToneVolume") == false) goto L113;
        FLogger.f375446a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent cueToneVolume use cache deviceKey=" + r125 + " value=" + r126.element);
    L113:
        if (r124.element == false) goto L116;
        DoraDeviceSettingsCache.f332061a.update(r125, new l(r114, r126));
        FLogger.f375446a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent settings cache updated deviceKey=" + r125 + " requestedExtraInfo=" + r115);
    L116:
        if (r123.isEmpty() == false) goto L118;
        return null;
    L118:
        Object r130 = r114.element;
        Boolean r131 = (Boolean) r130;
        if (r123.contains("AdaptationEnable") == true) goto L122;
        r130 = null;
    L122:
        Boolean r132 = (Boolean) r130;
        Object r133 = r126.element;
        Integer r134 = (Integer) r133;
        if (r123.contains("CueToneVolume") == true) goto L126;
        r133 = null;
    L126:
        Integer r135 = (Integer) r133;
        n r136 = new n(r132, r135);
        if (r132 != null) goto L130;
        if (r135 != null) goto L130;
    L131:
        if (r129 == true) goto L133;
        n r137 = r136;
    L134:
        FLogger r138 = FLogger.f375446a;
        StringBuilder r139 = new StringBuilder("dora.device.getCurrent settings result deviceKey=");
        r139.append(r125);
        r139.append(" value=");
        if (r137 == null) goto L137;
        Map r140 = e(r137, r115);
    L138:
        r139.append(r140);
        r138.i("DoraDeviceGetCurrentMethod", r139.toString());
        return r137;
    L137:
        r140 = null;
        goto L138
    L133:
        r137 = null;
    L130:
        r129 = false;
        goto L131
    L92:
        if (r126.element != 0) goto L109;
        Result.Companion r141 = Result.Companion;     // Catch: Throwable -> L103
        ?? r142 = Boxing.boxInt(r127.z() & UByte.MAX_VALUE);     // Catch: Throwable -> L103
        r126.element = r142;     // Catch: Throwable -> L103
        if (r142 != 0) goto L97;
        FLogger.f375446a.w("DoraDeviceGetCurrentMethod", r100 + r125);     // Catch: Throwable -> L103
    L96:
        r129 = true;
        r124.element = true;     // Catch: Throwable -> L101
        Object r143 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L106:
        Throwable r144 = Result.m9452exceptionOrNullimpl(r143);
        if (r144 == null) goto L113;
        FLogger.f375446a.e("DoraDeviceGetCurrentMethod", "dora.device.getCurrent cueToneVolume load failed deviceKey=" + r125, r144);
    L101:
        th = th;
    L105:
        Result.Companion r145 = Result.Companion;
        r143 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L106
    L97:
        FLogger.f375446a.i("DoraDeviceGetCurrentMethod", r101 + r125 + " value=" + r126.element);     // Catch: Throwable -> L103
    L103:
        th = th;
        r129 = true;
        goto L105
    L53:
        if (r119 > r215.getLast()) goto L56;
        if (r120 > r119) goto L56;
        boolean r146 = true;
    L58:
        if (Boxing.boxBoolean(r146).booleanValue() == false) goto L60;
        Integer r147 = r118;
    L61:
        if (r147 != null) goto L63;
        T r148 = 0;
    L68:
        r114.element = r148;     // Catch: Throwable -> L74
        if (r148 != 0) goto L71;
        FLogger.f375446a.w("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load ignored unexpected state=" + r117 + " deviceKey=" + r116);     // Catch: Throwable -> L74
    L72:
        r108.element = true;     // Catch: Throwable -> L74
        r122 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L74
        r123 = r107;
        r124 = r108;
        r125 = r116;
        r126 = r109;
        r127 = r216;
        goto L83
    L71:
        FLogger.f375446a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable load ok deviceKey=" + r116 + " value=" + r114.element);     // Catch: Throwable -> L74
        goto L72
    L63:
        if (r147.intValue() != 1) goto L65;
        boolean r149 = true;
    L66:
        r148 = Boxing.boxBoolean(r149);     // Catch: Throwable -> L74
        goto L68
    L65:
        r149 = false;
        goto L66
    L60:
        r147 = null;
    L56:
        r146 = false;
    L76:
        th = th;
        r216 = r113;
    L15:
        th = th;
        r100 = "dora.device.getCurrent cueToneVolume load returned null deviceKey=";
        r114 = r110;
        r115 = r111;
        String r150 = r112;
        r101 = "dora.device.getCurrent cueToneVolume load ok deviceKey=";
    L81:
        r116 = r150;
        goto L82
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        Set r151 = (Set) r102.L$2;
        r125 = (String) r102.L$1;
        r127 = (kj4.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
        r115 = r151;
    L24:
        n r152 = (n) r104;
        if (r152 == null) goto L34;
        FLogger r153 = FLogger.f375446a;
        StringBuilder r154 = new StringBuilder("dora.device.getCurrent settings cache hit deviceKey=");
        r154.append(r125);
        r154.append(" cachedKeys=");
        ArrayList r155 = new ArrayList();
        if (r152.f332104a == null) goto L30;
        r155.add("AdaptationEnable");
    L30:
        if (r152.f332105b == null) goto L32;
        r155.add("CueToneVolume");
    L32:
        r154.append(r155);
        r153.i("DoraDeviceGetCurrentMethod", r154.toString());
    L34:
        r114 = new Ref.ObjectRef();
        if (r152 == null) goto L37;
        T r156 = r152.f332104a;
    L38:
        r114.element = r156;
        r126 = new Ref.ObjectRef();
        if (r152 == null) goto L41;
        T r157 = r152.f332105b;
    L42:
        r126.element = r157;
        r124 = new Ref.BooleanRef();
        r123 = SetsKt.minus(r115, "GestureSettings");
        if (r123.contains("AdaptationEnable") == false) goto L87;
        if (r114.element != 0) goto L87;
        Result.Companion r158 = Result.Companion;     // Catch: Throwable -> L79
        r102.L$0 = r127;     // Catch: Throwable -> L79
        r102.L$1 = r125;     // Catch: Throwable -> L79
        r102.L$2 = r115;     // Catch: Throwable -> L79
        r102.L$3 = r114;     // Catch: Throwable -> L79
        r102.L$4 = r126;     // Catch: Throwable -> L79
        r102.L$5 = r124;     // Catch: Throwable -> L79
        r102.L$6 = r123;     // Catch: Throwable -> L79
        r102.label = 2;     // Catch: Throwable -> L79
        Object r159 = DoraAdapterExtKt.l(r127);     // Catch: Throwable -> L79
        if (r159 == r105) goto L153;
        r113 = r127;
        r107 = r123;
        r109 = r126;
        r116 = r125;
        r108 = r124;
        r104 = r159;
        goto L145
    L153:
        return r105;
    L79:
        th = th;
        r113 = r127;
        r107 = r123;
        r109 = r126;
        String r217 = r125;
        r108 = r124;
        r150 = r217;
    L87:
        if (r123.contains("AdaptationEnable") == false) goto L90;
        FLogger.f375446a.i("DoraDeviceGetCurrentMethod", "dora.device.getCurrent adaptationEnable use cache deviceKey=" + r125 + " value=" + r114.element);
        goto L90
    L41:
        r157 = 0;
        goto L42
    L37:
        r156 = 0;
        goto L38
    L20:
        ResultKt.throwOnFailure(r104);
        DoraDeviceSettingsCache r160 = DoraDeviceSettingsCache.f332061a;
        DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1 r161 = new DoraDeviceGetCurrentMethod$loadDeviceSettings$cachedSnapshot$1(null);
        r127 = r211;
        r102.L$0 = r127;
        r102.L$1 = r212;
        r115 = r213;
        r102.L$2 = r115;
        r102.label = 1;
        r104 = r160.a(r212, r161, r102);
        if (r104 == r105) goto L152;
        r125 = r212;
        goto L24
    L152:
        return r105;
    L7:
        r102 = new DoraDeviceGetCurrentMethod$loadDeviceSettings$1(r210, r214);
        goto L8
    }
}
