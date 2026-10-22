package com.bytedance.kmp.ec.yata.chain.event;

import com.amap.api.services.core.AMapException;
import com.bytedance.kmp.ec.yata.chain.ability.ChainExprHelper;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import com.bytedance.kmp.ec.yata.chain.trigger.e;
import com.bytedance.kmp.ec.yata.chain.trigger.i;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.error.c;
import com.bytedance.kmp.ec.yata.common.error.d;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.common.utils.YataConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class EventContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventChain f251268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f251269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.chain.trigger.b f251270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f251271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.chain.trigger.a f251272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i f251273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f251275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f251276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f251277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, ? extends Object> f251278k;

    public final YataConcurrentHashMap<Object, Object> d() {
        return this.f251270c.f251309a.f251326a.f251318e;
    }

    public final void b(final Function1<? super b, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "resultCallback");
        Function1<b, Unit> r101 = new EventContext$execute$finalResultCallback$1(this, r100);
        this.f251268a.f251262h.onEventStart(this);     // Catch: Exception -> L5
        c(r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        YataErrorManager r102 = this.f251268a.d();
        if (r102 == null) goto L9;
        d r103 = c.e();
        r103.c(this.f251275h + "_crash");
        s96.c.a(r103, this);
        r103.i(e);
        r103.d(this.f251275h + "原子事件执行Crash");
        r102.c(r103);
    L9:
        int r104 = b.f251281h;
        r101.invoke(b.a.b(false, false, "crash=" + e.getMessage(), e, 51));
    }

    public final void c(Function1<? super b, Unit> r110) {
        String r100 = this.f251269b.getEventName();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L16;
        YataErrorManager r102 = this.f251268a.d();
        if (r102 == null) goto L14;
        int r103 = c.f251397a;
        d r104 = new d(AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT, "EVENT_TYPE_EMPTY_ERROR");
        r104.e();
        r104.c("event_type_empty");
        s96.c.a(r104, this);
        r104.d("事件的type为空");
        r102.c(r104);
    L14:
        int r105 = b.f251281h;
        r110.invoke(b.a.b(true, false, "event_type_empty", null, 58));
        return;
    L16:
        t96.a r106 = this.f251268a.c(r100);
        if (r106 != null) goto L23;
        YataErrorManager r107 = this.f251268a.d();
        if (r107 == null) goto L21;
        int r108 = c.f251397a;
        d r109 = new d(2001, "EVENT_SUBSCRIBE_NOT_FOUND");
        r109.c("cannot_find_event-".concat(r100));
        s96.c.a(r109, this);
        r109.d("事件找不到:".concat(r100));
        r107.c(r109);
    L21:
        int r111 = b.f251281h;
        r110.invoke(b.a.b(true, false, "cannot_find_event-".concat(r100), null, 58));
        return;
    L23:
        Map<String, Object> r112 = this.f251272e.b();
        String r113 = this.f251269b.e();
        if (r113 != null) goto L26;
    L29:
        boolean r114 = true;
    L31:
        if (r114 == false) goto L33;
        final String r115 = "empty";
    L42:
        e r116 = this.f251271d;
        if (r116 == null) goto L45;
        Function0<Object> r117 = new EventContext$calcEventControlFlowResult$1(r115);
        Intrinsics.checkNotNullParameter("event_control_flow", "key");
        Intrinsics.checkNotNullParameter(r117, "valueInvoker");
        r116.f251324a.put("event_control_flow", r117.invoke());
    L45:
        if (r115 != null) goto L47;
        r115 = "empty";
    L47:
        this.f251277j = r115;
        switch(r115.hashCode()) {
            case -1504838850: goto L65;
            case 93832333: goto L60;
            case 96634189: goto L56;
            case 1085015458: goto L51;
            default: goto L69;
        };
    L69:
        YataErrorManager r118 = this.f251268a.d();
        if (r118 == null) goto L72;
        d r119 = c.h();
        r119.c("event_control_flow_not_in_enum");
        s96.c.a(r119, this);
        r119.h("event_control_flow:" + this.f251269b.e() + "  result:" + this.f251277j);
        r119.d("表达式执行结果类型不匹配");
        r118.c(r119);
    L72:
        a(r106, r112, r110);
        return;
    L51:
        if (r115.equals(EventControlFlowType.CANCEL_FAILED) == false) goto L69;
        int r120 = b.f251281h;
        r110.invoke(b.a.b(false, true, "event_control_flow=cancel_failed", null, 56));
        return;
    L56:
        if (r115.equals("empty") == false) goto L69;
        a(r106, r112, r110);
        return;
    L60:
        if (r115.equals("block") == false) goto L69;
        int r121 = b.f251281h;
        r110.invoke(b.a.b(true, true, "event_control_flow=block", null, 56));
        return;
    L65:
        if (r115.equals(EventControlFlowType.CANCEL_SUCCESS) == false) goto L69;
        int r122 = b.f251281h;
        r110.invoke(b.a.c(false, null, null, 7));
        return;
    L33:
        y96.c r123 = this.f251268a.e().a(r113, r112);
        if (r123.f566979a == false) goto L38;
        YataErrorManager r124 = this.f251268a.d();
        if (r124 == null) goto L38;
        d r125 = c.g();
        r125.c("event_control_flow_expr_throwable");
        s96.c.a(r125, this);
        r125.j(r123);
        r125.d("表达式执行异常");
        r124.c(r125);
    L38:
        Object r126 = r123.f566981c;
        if ((r126 instanceof String) == false) goto L41;
        r115 = (String) r126;
        goto L42
    L41:
        r115 = null;
        goto L42
    L26:
        if (StringsKt.isBlank(r113) == true) goto L29;
        r114 = false;
        goto L31
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }

    public final void a(t96.a r100, Map<String, ? extends Object> r101, final Function1<? super b, Unit> r102) {
        t96.b r103 = r100.a();
        Map<String, ? extends Object> r104 = this.f251269b.a();
        if (r104 != null) goto L6;
        this.f251278k = null;
    L18:
        r100.b(this, new EventContext$doEmpty$1(r102));
        return;
    L6:
        if (r104.isEmpty() == false) goto L9;
        this.f251278k = MapsKt.emptyMap();
        goto L18
    L9:
        if (r103.f545100a == false) goto L17;
        int r105 = ChainExprHelper.f251251a;
        List<String> r106 = r103.f545101b;
        if (this.f251268a.f251256b.f251433i == true) goto L13;
    L15:
        boolean r107 = false;
    L16:
        this.f251278k = ChainExprHelper.b(this, r104, r101, r106, r107);
        goto L18
    L13:
        if (r103.f545102c == false) goto L15;
        r107 = true;
        goto L16
    L17:
        this.f251278k = r104;
        goto L18
    }

    public EventContext(EventChain r100, a r101, com.bytedance.kmp.ec.yata.chain.trigger.b r102, e r103, com.bytedance.kmp.ec.yata.chain.trigger.a r104, i r105) {
        Intrinsics.checkNotNullParameter(r100, "eventChain");
        Intrinsics.checkNotNullParameter(r101, "event");
        Intrinsics.checkNotNullParameter(r102, "chainContext");
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r105, "pipDataNode");
        this.f251268a = r100;
        this.f251269b = r101;
        this.f251270c = r102;
        this.f251271d = r103;
        this.f251272e = r104;
        this.f251273f = r105;
        this.f251274g = r102.a();
        this.f251275h = r101.getEventName();
        int r106 = h.f251540a;
        this.f251276i = UUID.randomUUID().toString();
    }
}
