package com.bytedance.applog.priority.original;

import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.applog.priority.PriorityCallback;
import com.bytedance.applog.priority.PriorityHttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class Group implements g {
    public final o a;
    public final l b;
    public final com.bytedance.applog.log.a c;
    public final PriorityCallback d;
    public final AppSession e;
    public final d f;
    public final AtomicBoolean g;
    public long h;
    public final AtomicBoolean i;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[Model$EventType.values().length];
            r0[Model$EventType.V3.ordinal()] = 1;
            r0[Model$EventType.V1.ordinal()] = 2;
            r0[Model$EventType.LogData.ordinal()] = 3;
            r0[Model$EventType.Launch.ordinal()] = 4;
            r0[Model$EventType.Terminate.ordinal()] = 5;
            r0[Model$EventType.Impression.ordinal()] = 6;
            r0[Model$EventType.Unknown.ordinal()] = 7;
            r0[Model$EventType.ForwardV3.ordinal()] = 8;
            a = r0;
            int[] r1 = new int[Model$GroupFrequencyAllow.values().length];
            r1[Model$GroupFrequencyAllow.Allow.ordinal()] = 1;
            r1[Model$GroupFrequencyAllow.BlockByBackoff.ordinal()] = 2;
            r1[Model$GroupFrequencyAllow.BlockByFrequency.ordinal()] = 3;
            b = r1;
        }
    }

    @Override // com.bytedance.applog.priority.original.g
    public final int b() {
        return this.b.c;
    }

    @Override // com.bytedance.applog.priority.original.g
    public final int c() {
        return this.b.a;
    }

    @Override // com.bytedance.applog.priority.original.g
    public final void destroy() {
        this.g.set(false);
    }

    @Override // com.bytedance.applog.priority.original.g
    public final void flush() {
        this.h = 0;
    }

    public final String toString() {
        return "Group-" + this.b.e.c + '-' + this.b.a + '-' + this.b.c + 's';
    }

    @Override // com.bytedance.applog.priority.original.g
    public final boolean a(long r6) {
        if (this.g.get() == true) goto L6;
        return false;
    L6:
        if (this.b.c > 0) goto L9;
        return true;
    L9:
        if (this.h > r6) goto L12;
        return true;
    L12:
        return false;
    }

    public static boolean f(JSONObject r3, HashMap r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L15;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        String r2 = (String) r0.getValue();
        if (Intrinsics.areEqual(r3.optString(r1), r2) == true) goto L4;
        Object r6 = r3.opt(r1);
        if (r6 == null) goto L10;
        String r7 = r6.toString();
    L12:
        if (Intrinsics.areEqual(r7, r2) == true) goto L4;
        return false;
    L10:
        r7 = null;
        goto L12
    L15:
        return true;
    }

    public final boolean e(final PriorityHttpResponse r10, final Map<j, ? extends JSONObject> r11) {
        int r0 = r10.getCode();
        if (200 <= r0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L31;
        m r2 = this.b.d;
        int r3 = r2.f.incrementAndGet();
        if (r2.e.get() > 0) goto L13;
    L17:
        this.c.a("Group:doWork", new Group$handleLogResponse$1(this, r10));
        JSONObject r4 = new JSONObject(r10.getData());
        if (Intrinsics.areEqual(r4.optString("message"), "success") == true) goto L20;
    L22:
        boolean r5 = false;
    L23:
        if (r5 == false) goto L27;
        Set<j> r12 = r11.keySet();
        Intrinsics.checkNotNullParameter(r12, "keys");
        this.f.b(r12);
        PriorityCallback r13 = this.d;
        l r6 = this.b;
        CommonKt.m(r13, "3F", r11, r6.e.c, r6.a);
        CommonKt.j(this.d, this.b.a, r11);
        this.d.monitorIncreaseStats("priority_request_success_cnt", 1);
        this.c.a("Group:doWork", new Group$handleLogResponse$2(this, r11));
        this.b.e.a.i(r4);
        return true;
    L27:
        if (this.d.isMonitorEnabled() == false) goto L29;
        this.d.monitorError("post priority[" + this + "] log biz error", "response: " + r10);
    L29:
        this.c.b("Group:doWork", null, new Group$handleLogResponse$3(this, r10));
    L55:
        PriorityCallback r14 = this.d;
        l r7 = this.b;
        CommonKt.m(r14, "3B", r11, r7.e.c, r7.a);
        this.d.monitorIncreaseStats("priority_request_failed_cnt", 1);
        return false;
    L20:
        if (Intrinsics.areEqual(r4.optString("magic_tag"), "ss_app_log") == false) goto L22;
        r5 = true;
        goto L23
    L13:
        if (r3 < r2.j) goto L15;
    L16:
        r2.e.set(0);
        goto L17
    L15:
        if (r2.a == false) goto L17;
    L31:
        if (500 <= r0) goto L33;
    L35:
        boolean r8 = false;
    L36:
        if (r8 == false) goto L44;
        m r9 = this.b.d;
        r9.f.set(r9.d);
        r9.g = r9.h;
        if (r9.e.incrementAndGet() <= 4) goto L41;
        r9.e.set(4);
    L41:
        if (this.d.isMonitorEnabled() == false) goto L55;
        this.d.monitorError("post priority[" + this + "] log 5xx error", "response: " + r10);
        goto L55
    L44:
        if (400 > r0) goto L47;
        if (r0 >= 500) goto L47;
        boolean r15 = true;
    L48:
        if (r15 == false) goto L52;
        this.b.d.getClass();
        this.c.b("Group:doWork", null, new Group$handleLogResponse$4(this, r10));
        if (this.d.isMonitorEnabled() == false) goto L55;
        this.d.monitorError("post priority[" + this + "] log 4xx error", "response: " + r10);
        goto L55
    L52:
        this.c.b("Group:doWork", null, new Group$handleLogResponse$5(this, r10));
        if (this.d.isMonitorEnabled() == false) goto L55;
        this.d.monitorError("post priority[" + this + "] log unknown error", "response: " + r10);
    L47:
        r15 = false;
        goto L48
    L33:
        if (r0 >= 600) goto L35;
        r8 = true;
        goto L36
    L5:
        if (r0 >= 300) goto L7;
        r1 = true;
        goto L9
    }

    @Override // com.bytedance.applog.priority.original.g
    public final Object d(i r19, long r20, Continuation r22) {
        if ((r22 instanceof Group$doWork$1) == false) goto L7;
        Group$doWork$1 r2 = (Group$doWork$1) r22;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Lazy r6 = (Lazy) r2.L$1;
        final Group r7 = (Group) r2.L$0;
        ResultKt.throwOnFailure(r0);
    L69:
        int r1 = r7.b.d.d;     // Catch: Throwable -> L66
        final int r8 = 0;
    L32:
        if (r8 >= r1) goto L64;
        if (r7.g.get() == false) goto L64;
        if (r7.f.e(r7.b.a) == true) goto L64;
        Model$GroupFrequencyAllow r9 = r7.b.d.a();     // Catch: Throwable -> L66
        int r10 = a.b[r9.ordinal()];     // Catch: Throwable -> L66
        if (r10 != 1) goto L41;
        r7.c.a("Group:doWork", new Group$doWork$4(r7, r8));     // Catch: Throwable -> L66
    L48:
        n r11 = r7.b.e;     // Catch: Throwable -> L66
        long r12 = r11.e;     // Catch: Throwable -> L66
        int r14 = r11.f;     // Catch: Throwable -> L66
        long r15 = r11.g * ((long) ECDraweeView.SQUARE);     // Catch: Throwable -> L66
        Function1<JSONObject, Boolean> r13 = new Group$doWork$7(r7);     // Catch: Throwable -> L66
        Intrinsics.checkNotNullParameter(r13, "filter");     // Catch: Throwable -> L66
        Pair<HashMap<j, JSONObject>, Boolean> r16 = r7.f.c(r7.b.a, r12, r14, r15, r13);     // Catch: Throwable -> L66
        final Map<j, ? extends JSONObject> r17 = (Map) r16.component1();     // Catch: Throwable -> L66
        boolean r18 = ((Boolean) r16.component2()).booleanValue();     // Catch: Throwable -> L66
        if (r17.isEmpty() == true) goto L50;
        if (r6.getValue() == null) goto L53;
        r7.c.a("Group:doWork", new Group$doWork$10(r7, r17));     // Catch: Throwable -> L66
        JSONObject r21 = new JSONObject();     // Catch: Throwable -> L66
        r21.put("header", r6.getValue());     // Catch: Throwable -> L66
        CommonKt.c(r21, r17, r7.a.getContext().c);     // Catch: Throwable -> L66
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L66
        l r111 = r7.b;     // Catch: Throwable -> L66
        r110.put("backoff_priority", r111.d.b.b(Boxing.boxInt(r111.a)));     // Catch: Throwable -> L66
        l r112 = r7.b;     // Catch: Throwable -> L66
        r110.put("group_priority", r112.b.b(Boxing.boxInt(r112.a)));     // Catch: Throwable -> L66
        n r113 = r7.b.e;     // Catch: Throwable -> L66
        r110.put("event_priority_config", r113.b.b(r113.c.name()));     // Catch: Throwable -> L66
        CommonKt.e(r110, r7.d);     // Catch: Throwable -> L66
        r21.put("options", r110);     // Catch: Throwable -> L66
        CommonKt.d(r21);     // Catch: Throwable -> L66
        if (r7.a.getContext().b.d == false) goto L57;
        Pair<String, String> r114 = CommonKt.f(r21, r7.a.getContext().b.e);     // Catch: Throwable -> L66
    L58:
        r7.d.monitorIncreaseStats("REPORT_REQUEST_COUNT", 1);     // Catch: Throwable -> L66
        if (r7.e(r7.d.doHttpPost(r7.b.h, r21.toString().getBytes(Charsets.UTF_8), r114), r17) == false) goto L63;
        if (r18 == true) goto L63;
        r7.c.a("Group:doWork", new Group$doWork$11(r7));     // Catch: Throwable -> L66
    L63:
        r8 = r8 + 1;
        goto L32
    L57:
        r114 = null;
        goto L58
    L53:
        r7.c.a("Group:doWork", new Group$doWork$9(r7));     // Catch: Throwable -> L66
        goto L64
    L50:
        r7.c.a("Group:doWork", new Group$doWork$8(r7));     // Catch: Throwable -> L66
        goto L64
    L41:
        if (r10 == 2) goto L46;
        if (r10 != 3) goto L48;
        r7.c.a("Group:doWork", new Group$doWork$6(r7));     // Catch: Throwable -> L66
        goto L64
    L46:
        r7.c.a("Group:doWork", new Group$doWork$5(r7));     // Catch: Throwable -> L66
    L64:
        r7.i.set(false);
        return Unit.INSTANCE;
    L66:
        th = move-exception;
        r7.i.set(false);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        this.h = r20 + ((long) this.b.c);
        if (this.i.compareAndSet(false, true) == true) goto L18;
        this.c.b("Group:doWork", null, new Group$doWork$2(this));
        return Unit.INSTANCE;
    L18:
        this.c.a("Group:doWork", new Group$doWork$3(this));
        if (this.b.g.contains(Model$EventType.Launch.getAlias()) == false) goto L21;
    L24:
        final AppSession r23 = this.e;
        r2.L$0 = this;
        i r24 = r19;
        r2.L$1 = r24;
        r2.label = 1;
        r23.a.c.a("AppSession:packHistorySessionEvents", new AppSession$syncPackHistorySessionEvents$2(r23));
        Object r25 = r23.c(r23.d, r2);
        if (r25 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
        r25 = Unit.INSTANCE;
    L28:
        if (r25 != r4) goto L30;
        return r4;
    L30:
        r7 = this;
        r6 = r24;
        goto L69
    L21:
        if (this.b.g.contains(Model$EventType.Terminate.getAlias()) == true) goto L24;
        r24 = r19;
    L7:
        r2 = new Group$doWork$1(this, r22);
        goto L8
    }

    public final boolean g(Model$EventType r8, String r9, Lazy r10) {
        Intrinsics.checkNotNullParameter(r8, "eventType");
        Intrinsics.checkNotNullParameter(r9, "event");
        if (this.b.g.contains(r8.getAlias()) == true) goto L6;
        return false;
    L6:
        if (this.b.f != null) goto L9;
        return true;
    L9:
        switch(a.a[r8.ordinal()]) {
            case 2: goto L12;
            case 3: goto L12;
            case 4: goto L12;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L11;
            default: goto L14;
        };
    L11:
        return false;
    L12:
        return true;
    L14:
        if ((!this.b.f.a.isEmpty()) == true) goto L16;
    L18:
        if (r10 != null) goto L21;
        return false;
    L21:
        if ((!this.b.f.b.isEmpty()) == false) goto L73;
        List<List<String>> r11 = this.b.f.b.get(r9);
        if (r11 == null) goto L46;
        JSONObject r4 = ((JSONObject) r10.getValue()).optJSONObject("params");
        if (r4 == null) goto L46;
        List<List<String>> r12 = r11;
        if ((r12 instanceof Collection) == true) goto L29;
    L31:
        Iterator<T> r13 = r12.iterator();
    L33:
        if (r13.hasNext() == false) goto L43;
        Iterator r5 = ((List) r13.next()).iterator();
    L36:
        if (r5.hasNext() == false) goto L40;
        if (r4.has((String) r5.next()) == true) goto L36;
        boolean r6 = false;
    L41:
        if (r6 == false) goto L33;
        boolean r14 = true;
    L44:
        if (r14 == false) goto L46;
        return true;
    L40:
        r6 = true;
    L43:
        r14 = false;
        goto L44
    L29:
        if (r12.isEmpty() == false) goto L31;
    L46:
        List<List<String>> r15 = this.b.f.b.get("*");
        if (r15 == null) goto L73;
        if ((!r15.isEmpty()) == false) goto L73;
        JSONObject r7 = ((JSONObject) r10.getValue()).optJSONObject("params");
        if (r7 == null) goto L73;
        List<List<String>> r16 = r15;
        if ((r16 instanceof Collection) == true) goto L55;
    L57:
        Iterator<T> r17 = r16.iterator();
    L59:
        if (r17.hasNext() == false) goto L69;
        Iterator r18 = ((List) r17.next()).iterator();
    L62:
        if (r18.hasNext() == false) goto L66;
        if (r7.has((String) r18.next()) == true) goto L62;
        boolean r19 = false;
    L67:
        if (r19 == false) goto L59;
        boolean r20 = true;
    L70:
        if (r20 == false) goto L73;
        return true;
    L66:
        r19 = true;
    L69:
        r20 = false;
        goto L70
    L55:
        if (r16.isEmpty() == false) goto L57;
    L73:
        if ((!this.b.f.c.isEmpty()) == false) goto L112;
        List<HashMap<String, String>> r21 = this.b.f.c.get(r9);
        if (r21 == null) goto L92;
        JSONObject r22 = ((JSONObject) r10.getValue()).optJSONObject("params");
        if (r22 == null) goto L92;
        List<HashMap<String, String>> r23 = r21;
        if ((r23 instanceof Collection) == true) goto L81;
    L83:
        Iterator<T> r24 = r23.iterator();
    L85:
        if (r24.hasNext() == false) goto L89;
        if (f(r22, (HashMap) r24.next()) == false) goto L85;
        boolean r25 = true;
    L90:
        if (r25 == false) goto L92;
        return true;
    L89:
        r25 = false;
        goto L90
    L81:
        if (r23.isEmpty() == false) goto L83;
    L92:
        List<HashMap<String, String>> r26 = this.b.f.c.get("*");
        if (r26 == null) goto L112;
        if ((!r26.isEmpty()) == false) goto L112;
        JSONObject r27 = ((JSONObject) r10.getValue()).optJSONObject("params");
        if (r27 == null) goto L112;
        List<HashMap<String, String>> r28 = r26;
        if ((r28 instanceof Collection) == true) goto L101;
    L103:
        Iterator<T> r29 = r28.iterator();
    L105:
        if (r29.hasNext() == false) goto L109;
        if (f(r27, (HashMap) r29.next()) == false) goto L105;
        boolean r30 = true;
    L110:
        if (r30 == false) goto L112;
        return true;
    L109:
        r30 = false;
        goto L110
    L101:
        if (r28.isEmpty() == false) goto L103;
    L112:
        return false;
    L16:
        if (this.b.f.a.contains(r9) == false) goto L18;
        return true;
    }

    public Group(o r2, l r3, com.bytedance.applog.log.a r4, PriorityCallback r5, AppSession r6) {
        Intrinsics.checkNotNullParameter(r2, "priorityContext");
        Intrinsics.checkNotNullParameter(r3, "config");
        Intrinsics.checkNotNullParameter(r4, "logger");
        Intrinsics.checkNotNullParameter(r5, "callback");
        Intrinsics.checkNotNullParameter(r6, "appSession");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r2.a.a(r3.e.c);
        this.g = new AtomicBoolean(true);
        this.i = new AtomicBoolean(false);
    }
}
