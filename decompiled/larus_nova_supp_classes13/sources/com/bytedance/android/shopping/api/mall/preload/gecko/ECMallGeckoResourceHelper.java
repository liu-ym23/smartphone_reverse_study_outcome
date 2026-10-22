package com.bytedance.android.shopping.api.mall.preload.gecko;

import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.m;
import com.bytedance.android.shopping.api.mall.common.tools.NativeMallGeckoHelper;
import com.bytedance.android.shopping.api.mall.common.tools.o;
import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallGeckoResourceHelper implements JsEventSubscriber {
    public static final Lazy a = null;
    public static final Lazy b = null;

    public static final class a extends o {
        public final /* synthetic */ String c;
        public final /* synthetic */ boolean d;
        public final /* synthetic */ OptionCheckUpdateParams e;
        public final /* synthetic */ String f;
        public final /* synthetic */ GeckoClient g;
        public final /* synthetic */ Map h;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper$a$a, reason: collision with other inner class name */
        public static final class RunnableC0024a implements Runnable {
            public final /* synthetic */ a a;

            /* JADX INFO: renamed from: com.bytedance.android.shopping.api.mall.preload.gecko.ECMallGeckoResourceHelper$a$a$a, reason: collision with other inner class name */
            public static final class RunnableC0025a implements Runnable {
                public final /* synthetic */ RunnableC0024a a;

                public RunnableC0025a(RunnableC0024a r1) {
                    this.a = r1;
                }

                public final void a() {
                    com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_mall_gecko_fail_retry_preload");
                    Lazy r0 = ECMallLogUtil.a;
                    ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper, retry after failed, channel = " + this.a.a.c);
                    OptionCheckUpdateParams r1 = this.a.a.e;
                    if (r1 == null) goto L9;
                    Map r2 = r1.getCustomParam();
                    if (r2 == null) goto L9;
                    Map r3 = (Map) r2.get(this.a.a.f);
                    if (r3 == null) goto L9;
                    r3.put("load_tag", "repeat");
                L9:
                    a r4 = this.a.a;
                    GeckoClient r5 = r4.g;
                    if (r5 == null) goto L13;
                    r5.checkUpdateMulti(null, r4.h, r4.e);
                    return;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a();     // Catch: Throwable -> L4
                    return;
                L4:
                    th = move-exception;
                    if (RunnableProtector.intercept(th) == false) goto L8;
                    return;
                L8:
                    throw th;
                }
            }

            public RunnableC0024a(a r1) {
                this.a = r1;
            }

            public final void a() {
                Lazy r0 = ECMallLogUtil.a;
                ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper, gecko update failed, channel = " + this.a.c + ", retryEnable = " + this.a.d);
                if (this.a.d == true) goto L5;
                return;
            L5:
                com.bytedance.android.ec.hybrid.card.service.a.a("ec_anr_degrade_mall_gecko_fail_retry_preload");
                t93.a.b().postDelayed(new RunnableC0025a(this), 60000);
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public static final class b implements Runnable {
            public final /* synthetic */ a a;

            public b(a r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Lazy r0 = ECMallLogUtil.a;     // Catch: Throwable -> L4
                ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper, gecko update success, channel = " + this.a.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void a() {
            t93.a.b().post(new RunnableC0024a(this));
        }

        @Override // com.bytedance.android.shopping.api.mall.common.tools.o
        public final void b() {
            t93.a.b().post(new b(this));
        }

        public a(String r1, boolean r2, OptionCheckUpdateParams r3, String r4, GeckoClient r5, Map r6, String r7, String r8) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            this.g = r5;
            this.h = r6;
            super(r7, r8);
        }
    }

    public static boolean c() {
        return ((Boolean) b.getValue()).booleanValue();
    }

    static {
        a = LazyKt.lazy(ECMallGeckoResourceHelper$config$2.INSTANCE);
        b = LazyKt.lazy(ECMallGeckoResourceHelper$isOnlineEnv$2.INSTANCE);
    }

    public static String a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "schema");
        com.bytedance.android.ec.hybrid.tools.a r0 = com.bytedance.android.ec.hybrid.tools.a.a;
        String r1 = NativeMallGeckoHelper.a();
        String r2 = NativeMallGeckoHelper.b();
        r0.getClass();
        return com.bytedance.android.ec.hybrid.tools.a.a(r1, r2, r3);
    }

    public static boolean b(ECMallGeckoPreloadConfig.ItemConfig r8) {
        int r0 = r8.getExecuteCountLimit();
        if (r0 > 0) goto L5;
    L8:
        int r1 = r8.getExecuteGapDuration();
        long r3 = System.currentTimeMillis() - r8.getLastExecuteTimestamp();
        if (r1 > 0) goto L11;
        return true;
    L11:
        if (r3 > r1) goto L16;
        Lazy r5 = ECMallLogUtil.a;
        ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper#checkPreloadCondition, failed, channel = " + r8.getChannelName() + ", gapDuration = " + r1 + ", gap = " + r3);
        return false;
    L16:
        return true;
    L5:
        if (r8.getExecuteCount() < r0) goto L8;
        Lazy r4 = ECMallLogUtil.a;
        ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper#checkPreloadCondition, failed, channel = " + r8.getChannelName() + ", countLimit = " + r0 + ", count = " + r8.getExecuteCount());
        return false;
    }

    public static boolean e(Function1 r5) {
        Intrinsics.checkNotNullParameter(r5, "condition");
        Lazy r0 = a;
        if (((ECMallGeckoPreloadConfig) r0.getValue()).getExposureExecuteEnable() == true) goto L5;
        return false;
    L5:
        Map<String, ECMallGeckoPreloadConfig.ItemConfig> r1 = ((ECMallGeckoPreloadConfig) r0.getValue()).getItemConfigMap();
        if (r1 == null) goto L33;
        Collection<ECMallGeckoPreloadConfig.ItemConfig> r2 = r1.values();
        if (r2 == null) goto L33;
        Iterator<T> r3 = r2.iterator();
    L11:
        if (r3.hasNext() == false) goto L15;
        Object r4 = r3.next();
        if (((Boolean) r5.invoke((ECMallGeckoPreloadConfig.ItemConfig) r4)).booleanValue() == false) goto L11;
    L16:
        ECMallGeckoPreloadConfig.ItemConfig r6 = (ECMallGeckoPreloadConfig.ItemConfig) r4;
        if (r6 == null) goto L33;
        if (b(r6) == true) goto L23;
        return false;
    L23:
        if (c() == false) goto L25;
        String r7 = r6.getAccessKeyOnline();
    L26:
        if (r7 != null) goto L28;
        return false;
    L28:
        String r8 = r6.getChannelName();
        if (r8 != null) goto L31;
        return false;
    L31:
        Lazy r9 = ECMallLogUtil.a;
        ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper#preloadGeckoResource, by condition, channel = " + r8 + ", isOnline = " + c());
        d(r7, r8, r6.getRetryEnable());
        f(r6);
        return true;
    L25:
        r7 = r6.getAccessKeyDebug();
        goto L26
    L15:
        r4 = null;
    L33:
        return false;
    }

    public static void f(ECMallGeckoPreloadConfig.ItemConfig r4) {
        r4.setExecuteCount(r4.getExecuteCount() + 1);
        r4.setLastExecuteTimestamp(System.currentTimeMillis());
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper#recordPreloadExecuted, channel = " + r4.getChannelName() + ", executeCount = " + r4.getExecuteCount() + ", executeTimestamp = " + r4.getLastExecuteTimestamp());
    }

    public final void onReceiveJsEvent(Js2NativeEvent r6) {
        Intrinsics.checkNotNullParameter(r6, "jsEvent");
        if ((!Intrinsics.areEqual(r6.getEventName(), "ec.event.mallPreloadGecko")) == false) goto L5;
        return;
    L5:
        XReadableMap r7 = r6.getParams();
        if (r7 == null) goto L46;
        Map r8 = r7.toMap();
        if (r8 == null) goto L48;
        Object r0 = r8.get("key");
        Object r2 = null;
        if ((r0 instanceof String) == true) goto L13;
        r0 = null;
    L13:
        String r1 = (String) r0;
        if (r1 != null) goto L16;
        return;
    L16:
        Map<String, ECMallGeckoPreloadConfig.ItemConfig> r3 = ((ECMallGeckoPreloadConfig) a.getValue()).getItemConfigMap();
        if (r3 == null) goto L47;
        ECMallGeckoPreloadConfig.ItemConfig r4 = r3.get(r1);
        if (r4 != null) goto L22;
        return;
    L22:
        if (b(r4) == true) goto L24;
        return;
    L24:
        Object r5 = r8.get("accessKey");
        if ((r5 instanceof String) == true) goto L27;
        r5 = null;
    L27:
        String r9 = (String) r5;
        if (r9 == null) goto L30;
    L33:
        if (r9 != null) goto L35;
        return;
    L35:
        Object r10 = r8.get("channelName");
        if ((r10 instanceof String) == false) goto L39;
        r2 = r10;
    L39:
        String r11 = (String) r2;
        if (r11 != null) goto L42;
        r11 = r4.getChannelName();
    L42:
        if (r11 != null) goto L44;
        return;
    L44:
        Lazy r12 = ECMallLogUtil.a;
        ECMallLogUtil.c(m.b.b, "ECMallGeckoResourceHelper#preloadGeckoResource, by event, channel = " + r11 + ", isOnline = " + c());
        d(r9, r11, r4.getRetryEnable());
        f(r4);
        return;
    L30:
        if (c() == false) goto L32;
        r9 = r4.getAccessKeyOnline();
        goto L33
    L32:
        r9 = r4.getAccessKeyDebug();
        goto L33
    L47:
        return;
    L48:
        return;
    }

    public static void d(String r13, String r14, boolean r15) {
        GeckoClient r9 = com.bytedance.geckox.a.a(r13);
        Map r10 = MapsKt.mapOf(TuplesKt.to(r13, CollectionsKt.listOf(new CheckRequestBodyModel.TargetChannel(r14))));
        OptionCheckUpdateParams r11 = new OptionCheckUpdateParams().setLazyUpdate(false).setEnableDownloadAutoRetry(true).setChannelUpdatePriority(3);
        r11.setCustomParam(MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(r13, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("load_tag", "first")}))}));
        r11.setListener(new a(r14, r15, r11, r13, r9, r10, r13, r14));
        if (r9 == null) goto L6;
        r9.checkUpdateMulti(null, r10, r11);
        return;
    }
}
