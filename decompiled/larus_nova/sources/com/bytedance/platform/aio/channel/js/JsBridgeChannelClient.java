package com.bytedance.platform.aio.channel.js;

import com.bytedance.platform.aio.Severity;
import com.bytedance.platform.aio.channel.AbstractChannelClient;
import com.bytedance.platform.aio.channel.e;
import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import com.bytedance.platform.aio.channel.js.model.g;
import com.bytedance.platform.aio.channel.js.model.i;
import com.bytedance.platform.aio.channel.js.model.j;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.WritableArray;
import com.lynx.react.bridge.WritableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class JsBridgeChannelClient extends AbstractChannelClient<Object, Object> {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f266592l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f266593g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f266594h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f266595i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<String> f266596j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.platform.aio.channel.js.a f266597k;

    public static final class a {
    }

    static {
    }

    public JsBridgeChannelClient(com.bytedance.platform.aio.channel.js.a r100) {
        Intrinsics.checkNotNullParameter(r100, "jsBridge");
        this.f266597k = r100;
        JsBridgeChannelClient$jsbMethod$1 r101 = new JsBridgeChannelClient$jsbMethod$1(this);
        Intrinsics.checkNotNullParameter(r101, "onMessage");
        c r102 = new c(r101);
        this.f266593g = r102;
        JsBridgeChannelClient$jsbV2Method$1 r103 = new JsBridgeChannelClient$jsbV2Method$1(this);
        Intrinsics.checkNotNullParameter(r103, "onMessage");
        c r104 = new c(r103);
        this.f266594h = r104;
        this.f266595i = new LinkedHashSet();
        this.f266596j = new LinkedHashSet();
        jy0.b.d("JsBridgeChannelClient", "init JsBridgeChannelClient: eventName: rpcChannelMessage, rpcChannelMessageV2");
        r100.c("rpcChannelMessage", r102);
        r100.c("rpcChannelMessageV2", r104);
    }

    @Override // com.bytedance.platform.aio.channel.AbstractChannelClient
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
        this.f266596j.remove(r100);
    }

    @Override // com.bytedance.platform.aio.channel.AbstractChannelClient
    public final void c(List<? extends e<? extends Object>> r100) {
        Intrinsics.checkNotNullParameter(r100, "operations");
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L10;
        e r104 = (e) r103.next();
        if (this.f266596j.contains(r104.a()) == true) goto L7;
        r102.add(d.a(r104));
        goto L4
    L7:
        r101.add(d.a(r104));
        goto L4
    L10:
        if (r101.size() <= 0) goto L13;
        com.bytedance.platform.aio.channel.js.a r105 = this.f266597k;
        com.bytedance.platform.aio.channel.js.model.e r106 = new com.bytedance.platform.aio.channel.js.model.e();
        r106.b(r101);
        Unit r107 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r105, "$this$sendV1Event");
        Intrinsics.checkNotNullParameter("rpcChannelMessage", "jsBridgeEventName");
        Intrinsics.checkNotNullParameter(r106, "message");
        r105.b(r106);
    L13:
        if (r102.size() <= 0) goto L45;
        com.bytedance.platform.aio.channel.js.a r108 = this.f266597k;
        com.bytedance.platform.aio.channel.js.model.e r109 = new com.bytedance.platform.aio.channel.js.model.e();
        r109.b(r102);
        Unit r110 = Unit.INSTANCE;
        Intrinsics.checkNotNullParameter(r108, "$this$sendV2Event");
        Intrinsics.checkNotNullParameter("rpcChannelMessageV2", "jsBridgeV2EventName");
        Intrinsics.checkNotNullParameter(r109, "message");
        JavaOnlyMap r111 = new JavaOnlyMap();
        JavaOnlyArray r112 = new JavaOnlyArray();
        Iterator<T> r113 = r109.a().iterator();
    L16:
        if (r113.hasNext() == false) goto L26;
        Object r114 = ((g) r113.next()).a();
        if ((r114 instanceof byte[]) == true) goto L19;
        if ((r114 instanceof JavaOnlyArray) == true) goto L22;
        if ((r114 instanceof JavaOnlyMap) == false) goto L16;
        r112.pushMap((WritableMap) r114);
        goto L16
    L22:
        r112.pushArray((WritableArray) r114);
        goto L16
    L19:
        r112.pushByteArray((byte[]) r114);
        goto L16
    L26:
        Unit r115 = Unit.INSTANCE;
        r111.put("aio_operations", r112);
        JavaOnlyMap r116 = new JavaOnlyMap();
        r116.put("data", r111);
        r108.d(r116);
        return;
    }

    public final void f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        this.f266595i.add(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void g(com.bytedance.platform.aio.channel.js.model.e r110, boolean r111) {
        List<g> r112 = r110.a();
        ArrayList r100 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator<T> r113 = r112.iterator();
    L3:
        boolean r101 = false;
        if (r113.hasNext() == false) goto L52;
        g r102 = (g) r113.next();
        Intrinsics.checkNotNullParameter(r102, "$this$toNativeModel");
        if ((r102 instanceof com.bytedance.platform.aio.channel.js.model.b) == false) goto L15;
        com.bytedance.platform.aio.channel.js.model.b r103 = (com.bytedance.platform.aio.channel.js.model.b) r102;
        String r104 = r103.b();
        String r105 = r103.c();
        String r106 = r103.d();
        int r107 = r103.e();
        if (r107 == 0) goto L12;
        if (r107 == 1) goto L11;
        BytesContentType r108 = BytesContentType.JSON;
    L13:
        e r109 = new e.b(r104, r105, r106, r108);
    L51:
        r100.add(r109);
        goto L3
    L11:
        r108 = BytesContentType.PROTOBUF;
        goto L13
    L12:
        r108 = BytesContentType.JSON;
        goto L13
    L15:
        if ((r102 instanceof j) == false) goto L38;
        j r114 = (j) r102;
        if (r114.f() != null) goto L30;
        String r115 = r114.c();
        Object r116 = r114.e();
        if (r116 == null) goto L22;
        uh7.c.f550106d.getClass();
        JsonObject r117 = uh7.c.e(r116);
        if (r117 == null) goto L22;
    L23:
        int r118 = r114.d();
        if (r118 == 0) goto L28;
        if (r118 == 1) goto L27;
        BytesContentType r119 = BytesContentType.JSON;
    L29:
        r109 = new e.d.a(r115, r117, r119);
        goto L51
    L27:
        r119 = BytesContentType.PROTOBUF;
        goto L29
    L28:
        r119 = BytesContentType.JSON;
    L22:
        r117 = new JsonObject();
        goto L23
    L30:
        String r120 = r114.c();
        com.bytedance.platform.aio.channel.js.model.c r121 = r114.f();
        Intrinsics.checkNotNull(r121);
        Intrinsics.checkNotNullParameter(r121, "$this$toNativeModel");
        com.bytedance.platform.aio.channel.a r122 = new com.bytedance.platform.aio.channel.a(r121.b(), r121.d(), r121.c());
        int r123 = r114.d();
        if (r123 == 0) goto L35;
        if (r123 == 1) goto L34;
        BytesContentType r124 = BytesContentType.JSON;
    L36:
        r109 = new e.d.b(r120, r122, r124);
        goto L51
    L34:
        r124 = BytesContentType.PROTOBUF;
        goto L36
    L35:
        r124 = BytesContentType.JSON;
        goto L36
    L38:
        if ((r102 instanceof com.bytedance.platform.aio.channel.js.model.a) == false) goto L48;
        com.bytedance.platform.aio.channel.js.model.a r125 = (com.bytedance.platform.aio.channel.js.model.a) r102;
        String r126 = r125.b();
        Intrinsics.checkNotNullParameter(r125, "$this$closeRead");
        if ((r125.c() & 2) == 0) goto L42;
        boolean r127 = true;
    L43:
        Intrinsics.checkNotNullParameter(r125, "$this$closeWrite");
        if ((r125.c() & 1) == 0) goto L46;
        r101 = true;
    L46:
        r109 = new e.a(r126, r127, r101);
        goto L51
    L42:
        r127 = false;
        goto L43
    L48:
        if ((r102 instanceof i) == false) goto L50;
        r109 = new e.c(((i) r102).b());
        goto L51
    L50:
        r109 = new e.d.b("", new com.bytedance.platform.aio.channel.a("", "", MapsKt.emptyMap()), BytesContentType.JSON);
        goto L51
    L52:
        List r128 = CollectionsKt.toList(r100);
        Intrinsics.checkNotNullParameter(r128, "operations");
        Iterator r129 = r128.iterator();
    L54:
        if (r129.hasNext() == false) goto L122;
        e r130 = (e) r129.next();
        if ((r130 instanceof e.b) == true) goto L57;
        if ((r130 instanceof e.d.a) == true) goto L72;
        if ((r130 instanceof e.d.b) == true) goto L87;
        if ((r130 instanceof e.a) == true) goto L102;
        if ((r130 instanceof e.c) == false) goto L54;
        e.c r131 = (e.c) r130;
        f(r131.f266584a);
        com.bytedance.platform.aio.channel.d r132 = this.f266559e;
        if (r132 == null) goto L54;
        r132.onRegister(r131.f266584a);
        goto L54
    L102:
        e.a r133 = (e.a) r130;
        AbstractChannelClient.a r134 = (AbstractChannelClient.a) ((LinkedHashMap) this.f266556b).get(r133.f266577a);
        if (r134 == null) goto L54;
        if (r133.f266578b == false) goto L112;
        String r135 = this.f266555a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r136 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r137 = Severity.DEBUG;
        if (r136.b(r137, r135) == false) goto L110;
        r136.a(r137, r135, "remote read closed, channel = " + r134);
    L110:
        r134.h(false);
    L112:
        if (r133.f266579c == false) goto L54;
        String r138 = this.f266555a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r139 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r140 = Severity.DEBUG;
        if (r139.b(r140, r138) == false) goto L116;
        r139.a(r140, r138, "remote write closed, channel = " + r134);
    L116:
        r134.g(false);
        goto L54
    L87:
        e.d.b r141 = (e.d.b) r130;
        Intrinsics.checkNotNullParameter(r141, "op");
        AbstractChannelClient.a r142 = (AbstractChannelClient.a) ((LinkedHashMap) this.f266556b).get(r141.f266588a);
        if (r142 == null) goto L54;
        com.bytedance.platform.aio.channel.a r143 = r141.f266589b;
        String r144 = r143.f266574a;
        String r145 = r143.f266575b;
        Map<String, String> r146 = r143.f266576c;
        Intrinsics.checkNotNullParameter(r144, "category");
        Intrinsics.checkNotNullParameter(r145, "message");
        Intrinsics.checkNotNullParameter(r146, "extra");
        if (r142.f266562b == true) goto L54;
        com.bytedance.platform.aio.channel.b.InterfaceC3727b<R> r147 = r142.f266564d;
        if (r147 == 0) goto L95;
        r147.a(r144, r145, r146);
        goto L54
    L95:
        String r148 = r142.f266561a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r149 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r150 = Severity.ERROR;
        if (r149.b(r150, r148) == false) goto L98;
        r149.a(r150, r148, "reader missed an error, channel = " + r142);
    L98:
        r142.f266565e = true;
        r142.d("internal_error", "reader is not set", null, BytesContentType.JSON);
        r142.close();
        goto L54
    L72:
        e.d.a r151 = (e.d.a) r130;
        Intrinsics.checkNotNullParameter(r151, "op");
        AbstractChannelClient.a r152 = (AbstractChannelClient.a) ((LinkedHashMap) this.f266556b).get(r151.f266585a);
        if (r152 == null) goto L54;
        T r153 = r151.f266586b;
        if (r152.f266562b == true) goto L54;
        com.bytedance.platform.aio.channel.b.InterfaceC3727b<R> r154 = r152.f266564d;
        if (r154 == 0) goto L80;
        r154.U0(r153);
        goto L54
    L80:
        String r155 = r152.f266561a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r156 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r157 = Severity.ERROR;
        if (r156.b(r157, r155) == false) goto L83;
        r156.a(r157, r155, "reader missed data, channel = " + r152);
    L83:
        r152.f266565e = true;
        r152.d("internal_error", "reader is not set", null, BytesContentType.JSON);
        r152.close();
        goto L54
    L57:
        e.b r158 = (e.b) r130;
        Intrinsics.checkNotNullParameter(r158, "op");
        if (r158.f266580a.length() != 0) goto L60;
        boolean r159 = true;
    L61:
        if (r159 == true) goto L54;
        if (this.f266556b.containsKey(r158.f266580a) == true) goto L54;
        AbstractChannelClient<Object, Object>.a r160 = b(r158.f266580a);
        this.f266556b.put(r158.f266580a, r160);
        String r161 = this.f266555a;
        com.bytedance.platform.aio.b.f266552a.getClass();
        com.bytedance.platform.aio.b r162 = com.bytedance.platform.aio.b.a.f266553a;
        Severity r163 = Severity.DEBUG;
        if (r162.b(r163, r161) == false) goto L69;
        r162.a(r163, r161, "remote connected, channel = " + r160);
    L69:
        d(r158.f266581b, r158.f266582c, r158.f266580a, r111);
        this.f266558d.a(r158.f266581b, r158.f266582c, r160, r158.f266583d);
        goto L54
    L60:
        r159 = false;
        goto L61
    }

    public final void e(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        Intrinsics.checkNotNullParameter(r101, "methodId");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.Notification.CHANNEL_ID);
        if (this.f266595i.contains(r100) == false) goto L6;
        this.f266596j.add(r102);
        return;
    }

    public final void d(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "interfaceId");
        Intrinsics.checkNotNullParameter(r101, "methodId");
        Intrinsics.checkNotNullParameter(r102, RemoteMessageConst.Notification.CHANNEL_ID);
        if (r103 == true) goto L6;
        this.f266596j.add(r102);
        return;
    }
}
