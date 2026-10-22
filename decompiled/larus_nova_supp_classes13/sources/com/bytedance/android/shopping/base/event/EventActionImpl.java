package com.bytedance.android.shopping.base.event;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.event.eventdumper.ECEventDumper;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.injector.Injector$provideIECHostLogService$1;
import com.bytedance.android.shopping.utils.u;
import io.reactivex.Completable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public class EventActionImpl implements com.bytedance.android.shopping.base.event.b {
    public final Lazy a;
    public final xi.a b;

    public static final class a<T> implements Consumer {
        public a(String r1) {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public b(EventActionImpl r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            this.a.b.logV3(this.b, new JSONObject(this.c));
            EventActionImpl.a(this.a, this.b, this.c);
        }
    }

    public static final class c implements Action {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void run() {
        }
    }

    public static final class d<T> implements Consumer {
        public d(String r1) {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class e implements Action {
        public final /* synthetic */ EventActionImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Map c;

        public e(EventActionImpl r1, String r2, Map r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void run() {
            this.a.b.logV3(this.b, new JSONObject(this.c));
            EventActionImpl.a(this.a, this.b, this.c);
        }
    }

    public static final class f implements Action {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void run() {
        }
    }

    public final Map<String, Object> c() {
        return (Map) this.a.getValue();
    }

    public EventActionImpl() {
        int r0 = com.bytedance.android.shopping.injector.a.a;
        xi.a r1 = new Injector$provideIECHostLogService$1();
        Intrinsics.checkNotNullParameter(r1, "hostLogService");
        this.b = r1;
        this.a = LazyKt.lazy(EventActionImpl$contextParams$2.INSTANCE);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void clearEventParams() {
        c().clear();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final Map<String, Object> getEventParams() {
        return c();
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "paramsMap");
        Map<String, Object> r0 = c();
        Set<Map.Entry<String, ? extends Object>> r7 = r6.entrySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Object r2 = r8.next();
        if (((Map.Entry) r2).getValue() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r10 = r5.getKey();
        int r11 = ga3.a.a;
        r9.add(TuplesKt.to(r10, ga3.a.a(r5.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r0, r9);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Map<String, ? extends Object> r6) {
        Intrinsics.checkNotNullParameter(r6, "paramsMap");
        Map<String, Object> r0 = c();
        Set<Map.Entry<String, ? extends Object>> r7 = r6.entrySet();
        ArrayList r1 = new ArrayList();
        Iterator<T> r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L11;
        Object r2 = r8.next();
        if (((Map.Entry) r2).getValue() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r1.add(r2);
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r4 = r1.iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r10 = r5.getKey();
        int r11 = ga3.a.a;
        r9.add(TuplesKt.to(r10, ga3.a.a(r5.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r0, r9);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParams(Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        MapsKt.putAll(c(), SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r3), AnonymousClass1.INSTANCE), AnonymousClass2.INSTANCE));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void initEventContext(Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r3, "params");
        MapsKt.putAll(c(), SequencesKt.map(SequencesKt.filter(ArraysKt.asSequence(r3), AnonymousClass3.INSTANCE), AnonymousClass4.INSTANCE));
    }

    public static void b(PageFinder r5, Map r6) {
        LinkedHashMap r0 = (LinkedHashMap) r6;
        Object r1 = r0.get("btm");
        Object r3 = null;
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r2 = (String) r1;
        if (r2 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L24;
        if (r5 == null) goto L25;
        BtmItemBuilder r7 = new BtmItemBuilder(r2, null, 2, null).withPageFinder(r5);
        Object r8 = r0.get("bcm_description");
        if ((r8 instanceof Map) == false) goto L19;
        r3 = r8;
    L19:
        Map r9 = (Map) r3;
        if (r9 == null) goto L22;
        BcmParams.Companion.getClass();
        r7.internalSetUnitParams("description", BcmParams.a.c(r9));
    L22:
        r6.put("btm_id", r7.obtainEventBtmParams());
        return;
    L25:
        return;
    L24:
        return;
    L8:
        if (StringsKt.isBlank(r2) == true) goto L11;
        r4 = false;
        goto L12
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void appendEventParamToEntranceInfo(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        Object r0 = c().get("entrance_info");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        c().put("entrance_info", u.a((String) r0, r4, r5));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Pair<String, ? extends Object>... r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        doEventAction(r2, null, MapsKt.toMap(r3));
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r2, Map<String, ? extends Object> r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        doEventAction(r2, null, r3);
    }

    public static final void a(EventActionImpl r2, String r3, Map r4) {
        r2.getClass();
        if (ECAppInfoService.e.isDebug() == false) goto L11;
        new StringBuilder("<<<=========" + r3 + " start =========>>>\n");
        Iterator r5 = r4.entrySet().iterator();
    L6:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r6 = (Map.Entry) r5.next();
        String r7 = (String) r6.getKey();
        Objects.toString(r6.getValue());
        goto L6
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r6, PageFinder r7, Map<String, ? extends Object> r8) {
        Intrinsics.checkNotNullParameter(r6, "actionName");
        Intrinsics.checkNotNullParameter(r8, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(c());
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<Map.Entry<String, ? extends Object>> r9 = r8.entrySet().iterator();
    L4:
        if (r9.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r2 = r9.next();
        if (r2.getValue() == null) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L4;
        r1.put(r2.getKey(), r2.getValue());
        goto L4
    L8:
        r3 = false;
        goto L9
    L11:
        ArrayList r10 = new ArrayList(r1.size());
        Iterator r4 = r1.entrySet().iterator();
    L13:
        if (r4.hasNext() == false) goto L15;
        Map.Entry r5 = (Map.Entry) r4.next();
        Object r11 = r5.getKey();
        int r12 = ga3.a.a;
        r10.add(TuplesKt.to(r11, ga3.a.a(r5.getValue())));
        goto L13
    L15:
        MapsKt.putAll(r0, r10);
        b(r7, r0);
        fa3.c.b(bg4.b.a(Completable.fromAction(new e(this, r6, r0))).subscribe(f.a, new a(r6)));
        ECEventDumper.h.getClass();
        ECEventDumper.a.b(r6, r0);
    }

    @Override // com.bytedance.android.shopping.base.event.b
    public final void doEventAction(String r8, PageFinder r9, Pair<String, ? extends Object>... r10) {
        Intrinsics.checkNotNullParameter(r8, "actionName");
        Intrinsics.checkNotNullParameter(r10, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.putAll(c());
        ArrayList r1 = new ArrayList();
        int r2 = r10.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L11;
        Pair<String, ? extends Object> r5 = r10[r4];
        if (r5.getSecond() == null) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L10;
        r1.add(r5);
    L10:
        r4 = r4 + 1;
        goto L3
    L7:
        r6 = false;
        goto L8
    L11:
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator r3 = r1.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        Pair r7 = (Pair) r3.next();
        Object r12 = r7.getFirst();
        int r13 = ga3.a.a;
        r11.add(TuplesKt.to(r12, ga3.a.a(r7.getSecond())));
        goto L13
    L15:
        MapsKt.putAll(r0, r11);
        b(r9, r0);
        fa3.c.b(bg4.b.a(Completable.fromAction(new b(this, r8, r0))).subscribe(c.a, new d(r8)));
        ECEventDumper.h.getClass();
        ECEventDumper.a.b(r8, r0);
    }
}
