package com.bytedance.android.window.shop.eventcard;

import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.hostapi.IHybridHostService;
import com.bytedance.android.ec.hybrid.monitor.ECHybridLogUtil;
import com.bytedance.android.ec.hybrid.monitor.c;
import com.bytedance.android.window.shop.eventcard.handler.LynxABReadHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxCallEventHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxNativeDBHandler;
import com.bytedance.android.window.shop.eventcard.handler.LynxPreferenceHandler;
import com.bytedance.android.window.shop.home.viewmodel.ECWindowViewModel;
import com.bytedance.sdk.xbridge.cn.protocol.h;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import yj.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class WindowPageCardBridge {
    public final com.bytedance.android.window.shop.eventcard.handler.b a;
    public final LynxCallEventHandler b;
    public final Map<Integer, com.bytedance.android.window.shop.eventcard.handler.a> c;
    public final ECWindowViewModel d;

    public final class a implements IDLXBridgeMethod, h {
        public final IDLXBridgeMethod.Access a;
        public final IDLXBridgeMethod.Compatibility b;
        public final Function1<Map<String, ? extends Object>, Map<String, Object>> c;
        public final String d;
        public final boolean e;
        public final /* synthetic */ WindowPageCardBridge f;

        /* JADX INFO: renamed from: com.bytedance.android.window.shop.eventcard.WindowPageCardBridge$a$a, reason: collision with other inner class name */
        public static final class RunnableC0028a implements Runnable {
            public final /* synthetic */ a a;
            public final /* synthetic */ Map b;
            public final /* synthetic */ IDLXBridgeMethod.a c;

            public RunnableC0028a(a r1, Map r2, IDLXBridgeMethod.a r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(this.b, this.c);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public final boolean canRunInBackground() {
            return false;
        }

        public final void release() {
        }

        public final IDLXBridgeMethod.Access getAccess() {
            return this.a;
        }

        public final IDLXBridgeMethod.Compatibility getCompatibility() {
            return this.b;
        }

        public final String getName() {
            return this.d;
        }

        public final void a(Map<String, ? extends Object> r5, IDLXBridgeMethod.a r6) {
            Map r0 = (Map) this.c.invoke(r5);
            Lazy r1 = ECHybridLogUtil.a;
            String r2 = this.d;
            Intrinsics.checkNotNullParameter(r5, "callMsg");
            Intrinsics.checkNotNullParameter(r0, "backMsg");
            Intrinsics.checkNotNullParameter(r2, "eventName");
            IHybridHostService r3 = com.bytedance.android.ec.hybrid.a.h();
            if (r3 == null) goto L9;
            g r4 = r3.getHostAB();
            if (r4 == null) goto L9;
            Map r7 = r4.s();
            if (r7 == null) goto L9;
            List r8 = (List) r7.get("jsb");
        L10:
            if (r8 != null) goto L12;
        L14:
            com.bytedance.android.ec.hybrid.a.i(new c(r5, r0, r2));
        L15:
            r6.invoke(r0);
            return;
        L12:
            if (r8.contains(r2) == false) goto L14;
        L9:
            r8 = null;
            goto L10
        }

        public final void realHandle(IBDXBridgeContext r3, Map<String, ? extends Object> r4, IDLXBridgeMethod.a r5) {
            Intrinsics.checkNotNullParameter(r3, "bridgeContext");
            Intrinsics.checkNotNullParameter(r4, "params");
            Intrinsics.checkNotNullParameter(r5, "callback");
            if (this.e == false) goto L5;
            this.f.d.add(Schedulers.computation().scheduleDirect(new RunnableC0028a(this, r4, r5)));
            return;
        L5:
            a(r4, r5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(WindowPageCardBridge r2, Function1<? super Map<String, ? extends Object>, ? extends Map<String, ? extends Object>> r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r3, "realHandler");
            Intrinsics.checkNotNullParameter(r4, "name");
            this.f = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.a = IDLXBridgeMethod.Access.PUBLIC;
            this.b = IDLXBridgeMethod.Compatibility.Compatible;
        }
    }

    public static final class b {
    }

    /* JADX INFO: renamed from: com.bytedance.android.window.shop.eventcard.WindowPageCardBridge$call$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "p1", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 4, 3})
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<String, Boolean> {
        public AnonymousClass1(com.bytedance.android.window.shop.eventcard.handler.b r8) {
            super(1, r8, com.bytedance.android.window.shop.eventcard.handler.b.class, "checkBlocked", "checkBlocked(Ljava/lang/String;)Ljava/lang/Boolean;", 0);
        }

        public final Boolean invoke(String r4) {
            Intrinsics.checkNotNullParameter(r4, "p1");
            com.bytedance.android.window.shop.eventcard.handler.b r0 = (com.bytedance.android.window.shop.eventcard.handler.b) ((CallableReference) this).receiver;
            r0.getClass();
            Intrinsics.checkNotNullParameter(r4, "key");
            Boolean r1 = r0.a.get(r4);
            if (r1 == null) goto L5;
            r0.a.put(r4, Boolean.FALSE);
        L5:
            return r1;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke((String) r1);
        }
    }

    static {
    }

    public WindowPageCardBridge(ECWindowViewModel r6) {
        Intrinsics.checkNotNullParameter(r6, "shopViewModel");
        this.d = r6;
        com.bytedance.android.window.shop.eventcard.handler.b r0 = new com.bytedance.android.window.shop.eventcard.handler.b();
        this.a = r0;
        LynxCallEventHandler r1 = new LynxCallEventHandler(r6);
        this.b = r1;
        this.c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, r1), TuplesKt.to(3, r0), TuplesKt.to(5, LynxPreferenceHandler.a), TuplesKt.to(6, LynxABReadHandler.a), TuplesKt.to(7, LynxNativeDBHandler.c)});
    }

    public static final Map a(WindowPageCardBridge r2, Map r3) {
        r2.getClass();
        Object r0 = r3.get("event_type");
        if ((r0 instanceof Integer) == true) goto L5;
        r0 = null;
    L5:
        Integer r1 = (Integer) r0;
        if (r1 == null) goto L8;
        int r4 = r1.intValue();
    L9:
        com.bytedance.android.window.shop.eventcard.handler.a r5 = r2.c.get(Integer.valueOf(r4));
        if (r5 != null) goto L13;
        return MapsKt.emptyMap();
    L13:
        return r5.a(r4, r3);
    L8:
        r4 = 0;
        goto L9
    }

    public final boolean call(ECLynxCard r4, cp3.a r5) {
        Intrinsics.checkNotNullParameter(r4, "card");
        Intrinsics.checkNotNullParameter(r5, "params");
        return this.b.b(r4, r5, new AnonymousClass1(this.a));
    }
}
