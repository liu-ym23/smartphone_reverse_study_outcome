package com.bytedance.android.shopping.api.mall.preload.resource;

import android.os.Handler;
import com.bytedance.android.shopping.api.mall.IECMallHostService;
import com.bytedance.android.shopping.api.mall.common.tools.a0;
import com.bytedance.forest.model.PreloadType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallResourcePreloader implements JsEventSubscriber {
    public static final Lazy a = null;

    public static final class a implements Runnable {
        public final /* synthetic */ IECMallHostService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ECMallResourcePreloadConfig.ItemConfig c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Integer e;
        public final /* synthetic */ Integer f;
        public final /* synthetic */ Boolean g;
        public final /* synthetic */ Boolean h;

        public a(IECMallHostService r1, String r2, ECMallResourcePreloadConfig.ItemConfig r3, String r4, Integer r5, Integer r6, Boolean r7, Boolean r8) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
        }

        public final void a() {
            IECMallHostService r0 = this.a;
            String r1 = this.b;
            if (r1 != null) goto L7;
            r1 = this.c.getUrl();
            if (r1 != null) goto L7;
            return;
        L7:
            String r2 = this.d;
            if (r2 != null) goto L10;
            r2 = this.c.getScene();
        L10:
            Integer r3 = this.e;
            if (r3 != null) goto L13;
            r3 = this.c.getType();
        L13:
            if (r3 != null) goto L16;
        L18:
            if (r3 != null) goto L21;
            return;
        L21:
            if (r3.intValue() != 2) goto L41;
            PreloadType r4 = PreloadType.WEB;
        L23:
            Integer r5 = this.f;
            if (r5 != null) goto L28;
            r5 = this.c.getMaxAge();
            if (r5 != null) goto L28;
            r5 = ECMallResourcePreloader.a().getDefaultMaxAge();
        L28:
            if (r5 == null) goto L30;
            int r6 = r5.intValue();
        L31:
            Boolean r7 = this.g;
            if (r7 != null) goto L36;
            r7 = this.c.getAsyncEnable();
            if (r7 != null) goto L36;
            r7 = ECMallResourcePreloader.a().getDefaultAsyncEnable();
        L36:
            Boolean r8 = Boolean.TRUE;
            boolean r9 = Intrinsics.areEqual(r7, r8);
            Boolean r10 = this.h;
            if (r10 != null) goto L39;
            r10 = this.c.getPredecodeEnable();
        L39:
            r0.preloadResourceWithForest(r1, r2, r4, r6, r9, Intrinsics.areEqual(r10, r8));
            return;
        L30:
            r6 = 0;
            goto L31
        L41:
            return;
        L16:
            if (r3.intValue() != 1) goto L18;
            r4 = PreloadType.LYNX;
            goto L23
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

    public static ECMallResourcePreloadConfig a() {
        return (ECMallResourcePreloadConfig) a.getValue();
    }

    static {
        a = LazyKt.lazy(ECMallResourcePreloader$config$2.INSTANCE);
    }

    public final void onReceiveJsEvent(Js2NativeEvent r13) {
        Intrinsics.checkNotNullParameter(r13, "jsEvent");
        boolean r1 = true;
        if ((!Intrinsics.areEqual(r13.getEventName(), "ec.event.mallPreloadResource")) == false) goto L5;
        return;
    L5:
        XReadableMap r14 = r13.getParams();
        if (r14 == null) goto L48;
        Map r15 = r14.toMap();
        if (r15 == null) goto L49;
        Map<String, ECMallResourcePreloadConfig.ItemConfig> r0 = a().getItemConfigMap();
        if (r0 != null) goto L13;
    L16:
        if (r1 == true) goto L50;
        Object r2 = r15.get("key");
        Object r3 = null;
        if ((r2 instanceof String) == true) goto L21;
        r2 = null;
    L21:
        String r4 = (String) r2;
        if (r4 == null) goto L51;
        ECMallResourcePreloadConfig.ItemConfig r5 = r0.get(r4);
        if (r5 == null) goto L52;
        Object r6 = r15.get("url");
        if ((r6 instanceof String) == true) goto L30;
        r6 = null;
    L30:
        String r7 = (String) r6;
        Object r8 = r15.get("scene");
        if ((r8 instanceof String) == true) goto L33;
        r8 = null;
    L33:
        String r9 = (String) r8;
        Object r10 = r15.get("type");
        if ((r10 instanceof Integer) == true) goto L36;
        r10 = null;
    L36:
        Integer r11 = (Integer) r10;
        Object r12 = r15.get("max_age");
        if ((r12 instanceof Integer) == true) goto L39;
        r12 = null;
    L39:
        Integer r16 = (Integer) r12;
        Object r17 = r15.get("async_enable");
        if ((r17 instanceof Boolean) == true) goto L42;
        r17 = null;
    L42:
        Boolean r18 = (Boolean) r17;
        Object r19 = r15.get("predecode_enable");
        if ((r19 instanceof Boolean) == false) goto L46;
        r3 = r19;
    L46:
        b(r5, r7, r9, r11, r16, r18, (Boolean) r3, true);
        return;
    L52:
        return;
    L51:
        return;
    L50:
        return;
    L13:
        if (r0.isEmpty() == true) goto L16;
        r1 = false;
        goto L16
    L49:
        return;
    }

    public static void c(int r9, String r10) {
        if (a().getOnceExecuteEnable() == true) goto L5;
        return;
    L5:
        Map<String, ECMallResourcePreloadConfig.ItemConfig> r0 = a().getItemConfigMap();
        if (r0 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == false) goto L14;
        return;
    L14:
        Collection<ECMallResourcePreloadConfig.ItemConfig> r1 = r0.values();
        ArrayList r4 = new ArrayList();
        Iterator<T> r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L27;
        Object r5 = r2.next();
        ECMallResourcePreloadConfig.ItemConfig r6 = (ECMallResourcePreloadConfig.ItemConfig) r5;
        if (r6.getOnceExecuteTiming() == r9) goto L20;
    L24:
        boolean r7 = false;
    L25:
        if (r7 == false) goto L16;
        r4.add(r5);
        goto L16
    L20:
        if (r6.getUrl() == null) goto L24;
        if (r6.getType() == null) goto L24;
        r7 = true;
        goto L25
    L27:
        Iterator r11 = r4.iterator();
    L29:
        if (r11.hasNext() == false) goto L45;
        ECMallResourcePreloadConfig.ItemConfig r8 = (ECMallResourcePreloadConfig.ItemConfig) r11.next();
        List<String> r12 = r8.getAccessiblePages();
        if (r12 == null) goto L35;
        if (r12.contains(r10) == false) goto L29;
    L35:
        long r13 = System.currentTimeMillis();
        if (r8.getStartTimestamp() == null) goto L44;
        if (r8.getEndTimestamp() == null) goto L44;
        Long r14 = r8.getStartTimestamp();
        Intrinsics.checkNotNull(r14);
        long r15 = r14.longValue();
        Long r16 = r8.getEndTimestamp();
        Intrinsics.checkNotNull(r16);
        long r17 = r16.longValue();
        if (r15 > r13) goto L29;
        if (r17 < r13) goto L29;
    L44:
        b(r8, null, null, null, null, null, null, false);
        goto L29
    L45:
        return;
    L8:
        if (r0.isEmpty() == true) goto L11;
        r3 = false;
        goto L12
    }

    public static void b(ECMallResourcePreloadConfig.ItemConfig r10, String r11, String r12, Integer r13, Integer r14, Boolean r15, Boolean r16, boolean r17) {
        IECMallHostService r2 = (IECMallHostService) ServiceManager.get().getService(IECMallHostService.class);
        if (r2 != null) goto L5;
        return;
    L5:
        a r0 = new a(r2, r11, r10, r12, r13, r14, r15, r16);
        if (r17 == true) goto L23;
        Long r1 = r10.getDelay();
        if (r1 != null) goto L10;
        r1 = a().getDefaultDelay();
    L10:
        long r3 = 0;
        if (r1 == null) goto L13;
        long r4 = r1.longValue();
    L15:
        if (r4 <= 0) goto L23;
        Handler r5 = a0.a;
        Long r6 = r10.getDelay();
        if (r6 != null) goto L20;
        r6 = a().getDefaultDelay();
    L20:
        if (r6 == null) goto L22;
        r3 = r6.longValue();
    L22:
        Intrinsics.checkNotNullParameter(r0, "runnable");
        a0.a.postDelayed(r0, r3);
        return;
    L13:
        r4 = 0;
    L23:
        r0.run();
    }
}
