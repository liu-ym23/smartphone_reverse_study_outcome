package com.obric.assistant.live.gr.island.island.impl;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.live.gr.island.business.utils.GRIslandType;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate;
import com.obric.assistant.live.gr.island.island.template.GRComplexTaskOperatingExpandedTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedDialogueTemplate;
import com.obric.assistant.live.gr.island.island.template.GRExpandedNormalTemplate;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.sync.MutexImpl;
import org.json.JSONObject;
import pea.f;
import pea.j;
import pea.k;
import pea.l;

/* JADX INFO: loaded from: classes33.dex */
public final class GRIslandImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<j, Long> f390079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutexImpl f390080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableSharedFlow<c> f390081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f390082d;

    /* JADX INFO: renamed from: com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1", f = "GRIslandImpl.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GRIslandImpl this$0;

        /* JADX INFO: renamed from: com.obric.assistant.live.gr.island.island.impl.GRIslandImpl$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C46131<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GRIslandImpl f390083a;

            public C46131(GRIslandImpl r100) {
                this.f390083a = r100;
            }

            public final Object a(c r100, Continuation<? super Unit> r101) {
                if ((r101 instanceof GRIslandImpl$1$1$emit$1) == false) goto L7;
                GRIslandImpl$1$1$emit$1 r102 = (GRIslandImpl$1$1$emit$1) r101;
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
                kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$0;
                ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
            L30:
                Unit r108 = Unit.INSTANCE;     // Catch: Throwable -> L33
                r107.unlock(null);
                return Unit.INSTANCE;
            L33:
                th = move-exception;
                r107.unlock(null);
                throw th;
            L15:
                Throwable th10 = th;
            L38:
                FLogger.f375446a.e("GRIslandImpl", "createSession() error", th10);     // Catch: Throwable -> L33
                goto L30
            L18:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L19:
                kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r102.L$1;
                c r110 = (c) r102.L$0;
                ResultKt.throwOnFailure(r104);
                kotlinx.coroutines.sync.a r111 = r109;
                r100 = r110;
            L40:
                Function1<Continuation<? super Unit>, Object> r112 = r100.f390087b;     // Catch: Throwable -> L27
                r102.L$0 = r111;     // Catch: Throwable -> L27
                r102.L$1 = null;     // Catch: Throwable -> L27
                r102.label = 2;     // Catch: Throwable -> L27
                if (r112.invoke(r102) != r105) goto L26;
                return r105;
            L26:
                r107 = r111;
            L27:
                th = move-exception;
                kotlinx.coroutines.sync.a r113 = r111;
                th10 = th;
                r107 = r113;
                goto L38
            L20:
                ResultKt.throwOnFailure(r104);
                r111 = this.f390083a.f390080b;
                r102.L$0 = r100;
                r102.L$1 = r111;
                r102.label = 1;
                if (r111.a(null, r102) != r105) goto L40;
                return r105;
            L7:
                r102 = new GRIslandImpl$1$1$emit$1(this, r101);
                goto L8
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
                return a((c) r100, r101);
            }
        }

        public AnonymousClass1(GRIslandImpl r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            GRIslandImpl r103 = this.this$0;
            MutableSharedFlow<c> r104 = r103.f390081c;
            C46131 r105 = new C46131(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    public static final class a {
    }

    static {
    }

    public GRIslandImpl() {
        this.f390079a = new ConcurrentHashMap();
        this.f390080b = kotlinx.coroutines.sync.b.a();
        int r100 = 0;
        this.f390081c = SharedFlowKt.MutableSharedFlow$default(0, 64, null, 5, null);
        this.f390082d = new AtomicLong(System.currentTimeMillis());
        if (Build.VERSION.SDK_INT >= 26) goto L25;
    L23:
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L25:
        Context r101 = AppHost.f326268a.getApplication().getApplicationContext();     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L21
        Object r102 = r101.getSystemService("notification");     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.app.NotificationManager");     // Catch: Throwable -> L21
        NotificationManager r103 = (NotificationManager) r102;     // Catch: Throwable -> L21
        StatusBarNotification[] r104 = r103.getActiveNotifications();     // Catch: Throwable -> L21
        if (r104 == null) goto L23;
        int r105 = r104.length;     // Catch: Throwable -> L21
    L9:
        if (r100 >= r105) goto L23;
        StatusBarNotification r106 = r104[r100];     // Catch: Throwable -> L21
        Notification r107 = r106.getNotification();     // Catch: Throwable -> L21
        if (r107 == null) goto L13;
        String r108 = r107.getChannelId();     // Catch: Throwable -> L21
    L15:
        if (Intrinsics.areEqual(r108, "obric_gr_island_channel") == false) goto L20;
        FLogger.f375446a.i("GRIslandImpl", "cancelLeftoverIslandNotifications() cancel id=" + r106.getId() + ", tag=" + r106.getTag() + ", channelId=" + r108);     // Catch: Throwable -> L21
        String r109 = r106.getTag();     // Catch: Throwable -> L21
        if (r109 == null) goto L19;
        r103.cancel(r109, r106.getId());     // Catch: Throwable -> L21
        goto L20
    L19:
        r103.cancel(r106.getId());     // Catch: Throwable -> L21
    L20:
        r100 = r100 + 1;
        goto L9
    L13:
        r108 = null;
    L21:
        th = move-exception;
        FLogger.f375446a.e("GRIslandImpl", "cancelLeftoverIslandNotifications() error", th);
        goto L23
    }

    public final void c(j r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f390081c.tryEmit(new c(new GRIslandImpl$destroySession$1(r100, this, null)));
    }

    public final void e(j r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        this.f390081c.tryEmit(new c(new GRIslandImpl$updateSessionFlags$1(this, r100, null)));
    }

    public final void b(j r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f390081c.tryEmit(new c(new GRIslandImpl$createSession$1(r100, this, r101, null)));
    }

    public final void f(j r100, k r101) {
        Intrinsics.checkNotNullParameter(r100, "targetSession");
        Intrinsics.checkNotNullParameter(r101, "targetWidget");
        this.f390081c.tryEmit(new c(new GRIslandImpl$updateWidget$1(r100, this, null)));
    }

    public static final void a(GRIslandImpl r210, j r211, Context r212) {
        r210.getClass();
        boolean r100 = !r211.a();
        k r101 = r211.f528802b;
        if (r101 == null) goto L5;
        l r102 = r101.f528828b;
    L6:
        boolean r103 = r102 instanceof GRComplexTaskExpandedTemplate;
        if (r103 == false) goto L17;
        if (r100 == false) goto L13;
        if (r101 == null) goto L11;
        l r104 = r101.f528828b;
    L12:
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        l r105 = ((GRComplexTaskExpandedTemplate) r104).getNormal();
    L20:
        if (r105 == null) goto L22;
        Bundle r106 = r105.getPics();
    L23:
        if (r105 == null) goto L25;
        Bundle r107 = r105.getActions();
    L27:
        if ((r105 instanceof GRExpandedNormalTemplate) == false) goto L30;
        f r108 = ((GRExpandedNormalTemplate) r105).getIconTextInfo();
    L36:
        if (r108 == null) goto L38;
        String r110 = r108.f528771b;
    L40:
        if (o0.d(r110) == false) goto L44;
        if (r108 == null) goto L43;
        String r111 = r108.f528771b;
    L45:
        if (r108 == null) goto L47;
        String r112 = r108.f528770a;
    L49:
        if (o0.d(r112) == false) goto L53;
        if (r108 == null) goto L52;
        String r109 = r108.f528770a;
    L54:
        Bundle r113 = r211.f528801a.f528828b.getPics();
        Bundle r114 = r211.f528803c.f528828b.getPics();
        Object r115 = r212.getSystemService("notification");
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r116 = (NotificationManager) r115;
        if (r116.getNotificationChannel("obric_gr_island_channel") != null) goto L58;
        FLogger.f375446a.d("GRIslandImpl", "ensureChannel() create channel: obric_gr_island_channel");
        r116.createNotificationChannel(new NotificationChannel("obric_gr_island_channel", "助手消息", 4));
    L58:
        JsonObject r117 = r211.f528811k;
        if (r117 == null) goto L63;
        JsonElement r118 = r117.get("obric_island_type");
        if (r118 == null) goto L63;
        String r119 = r118.getAsString();
    L64:
        boolean r120 = Intrinsics.areEqual(r119, GRIslandType.REALTIME_CALL.getValue());
        if ((r211.f528812l & 256) == 0) goto L67;
        boolean r121 = true;
    L68:
        if (r121 == false) goto L75;
        if (r120 == false) goto L75;
        IObricRealtimeCallExtService r122 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r122 == null) goto L74;
        PendingIntent r123 = r122.getNotificationPendingIntent(r212, true, r212);
        if (r123 == null) goto L74;
    L76:
        Notification.Builder r124 = new Notification.Builder(r212, "obric_gr_island_channel").setSmallIcon(R.drawable.obric_live_island_doubao_icon_new).setContentTitle(r111).setContentText(r109).setContentIntent(r123);
        Bundle r125 = new Bundle();
        r125.putAll(r113);
        if (r106 == null) goto L79;
        r125.putAll(r106);
    L79:
        r125.putAll(r114);
        Integer r126 = r211.f528822v;
        if (o0.d(r211.f528820t) == true) goto L82;
    L85:
        Integer r127 = r211.f528825y;
        if (o0.d(r211.f528823w) == true) goto L88;
    L91:
        Bundle r128 = new Bundle();
        r128.putBundle("miui.focus.actions", r107);
        r128.putBundle("miui.focus.pics", r125);
        r124.addExtras(r128);
        JSONObject r129 = new JSONObject();
        if (r211.a() == false) goto L94;
        int r130 = 1;
        r129.put("enableFloat", true);
        r129.put("islandFirstFloat", true);
    L95:
        r129.put("protocol", r130);
        r129.put("business", r211.f528814n);
        r129.put("updatable", r211.f528817q);
        Integer r131 = r211.f528818r;
        if (r131 == null) goto L98;
        r131.intValue();
        r129.put("timeout", r211.f528818r);
    L98:
        String r132 = r211.f528819s;
        if (r132 == null) goto L101;
        r129.put(JSEventListener.ACTION_REOPEN, r132);
    L101:
        String r133 = r211.f528820t;
        if (r133 == null) goto L104;
        r129.put(RemoteMessageConst.Notification.TICKER, r133);
    L104:
        String r134 = r211.f528821u;
        if (r134 == null) goto L107;
        r129.put("tickerPic", r134);
    L107:
        String r135 = r211.f528823w;
        if (r135 == null) goto L110;
        r129.put("aodTitle", r135);
    L110:
        String r136 = r211.f528824x;
        if (r136 == null) goto L113;
        r129.put("aodPic", r136);
    L113:
        JSONObject r137 = new JSONObject();
        Integer r138 = r211.f528826z;
        if (r138 == null) goto L116;
        r138.intValue();
        r137.put("islandProperty", r211.f528826z);
    L116:
        Boolean r139 = r211.A;
        if (r139 == null) goto L119;
        r139.booleanValue();
        r137.put("islandOrder", r211.A);
    L119:
        Integer r140 = r211.B;
        if (r140 == null) goto L122;
        r140.intValue();
        r137.put("islandTimeout", r211.B);
    L122:
        Boolean r141 = r211.C;
        if (r141 == null) goto L125;
        r141.booleanValue();
        r137.put("dismissIsland", r211.C);
    L125:
        r137.put("bigIslandArea", r211.f528801a.f528828b.toJSONObject());
        r137.put("smallIslandArea", r211.f528803c.f528828b.toJSONObject());
        Integer r142 = r211.D;
        if (r142 == null) goto L128;
        r142.intValue();
        r137.put("expandedTime", r211.D);
    L128:
        r129.put("param_island", r137);
        boolean r143 = !r211.a();
        k r144 = r211.f528802b;
        if (r144 == null) goto L131;
        l r145 = r144.f528828b;
    L133:
        if ((r145 instanceof GRComplexTaskExpandedTemplate) == false) goto L143;
        if (r143 == false) goto L139;
        if (r144 == null) goto L137;
        l r146 = r144.f528828b;
    L138:
        Intrinsics.checkNotNull(r146, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        JSONObject r147 = ((GRComplexTaskExpandedTemplate) r146).getNormal().toJSONObject();
    L148:
        if (r147 == null) goto L156;
        Iterator<String> r148 = r147.keys();
        if (r148 == null) goto L156;
    L152:
        if (r148.hasNext() == false) goto L156;
        String r149 = r148.next();
        Object r150 = r147.opt(r149);
        if (r150 == null) goto L152;
        r129.put(r149, r150);
    L156:
        JSONObject r151 = new JSONObject();
        r151.put("param_v2", r129);
        String r152 = r151.toString();
        Notification r153 = r124.build();
        r153.extras.putString("miui.focus.param", r152);
        Object r154 = r212.getSystemService("notification");
        Intrinsics.checkNotNull(r154, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r154).notify((int) r211.f528807g, r153);
        FLogger r155 = FLogger.f375446a;
        StringBuilder r156 = new StringBuilder("sendNotify() taskId:");
        r156.append(r211.f528807g);
        r156.append(",isNormal:");
        r156.append(r100);
        r156.append(", isComplexTaskTemplate:");
        r156.append(r103);
        r156.append(", expandTemplate:");
        k r157 = r211.f528802b;
        if (r157 == null) goto L161;
        l r158 = r157.f528828b;
        if (r158 == null) goto L161;
        String r159 = r158.getClass().getSimpleName();
    L162:
        r156.append(r159);
        r156.append(" param:");
        r156.append(r152);
        r155.i("GRIslandImpl", r156.toString());
        return;
    L161:
        r159 = null;
        goto L162
    L137:
        r146 = null;
        goto L138
    L139:
        if (r144 == null) goto L141;
        l r160 = r144.f528828b;
    L142:
        Intrinsics.checkNotNull(r160, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        r147 = ((GRComplexTaskExpandedTemplate) r160).getDialogue().toJSONObject();
        goto L148
    L141:
        r160 = null;
        goto L142
    L143:
        if (r144 == null) goto L147;
        l r161 = r144.f528828b;
        if (r161 == null) goto L147;
        r147 = r161.toJSONObject();
    L147:
        r147 = null;
        goto L148
    L131:
        r145 = null;
        goto L133
    L94:
        r130 = 1;
        r129.put("enableFloat", r211.f528815o);
        r129.put("islandFirstFloat", r211.f528816p);
        goto L95
    L88:
        if (o0.d(r211.f528824x) == false) goto L91;
        if (r127 == null) goto L91;
        r125.putParcelable(r211.f528824x, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), r127.intValue()));
        goto L91
    L82:
        if (o0.d(r211.f528821u) == false) goto L85;
        if (r126 == null) goto L85;
        r125.putParcelable(r211.f528821u, Icon.createWithResource(AppHost.f326268a.getApplication().getApplicationContext(), r126.intValue()));
    L74:
        r123 = r211.f528804d;
    L75:
        r123 = r211.f528804d;
        goto L76
    L67:
        r121 = false;
    L63:
        r119 = null;
        goto L64
    L52:
        r109 = null;
        goto L54
    L53:
        r109 = " ";
        goto L54
    L47:
        r112 = null;
        goto L49
    L43:
        r111 = null;
        goto L45
    L44:
        r111 = "豆包手机助手";
        goto L45
    L38:
        r110 = null;
        goto L40
    L30:
        if ((r105 instanceof GRComplexTaskOperatingExpandedTemplate) == false) goto L33;
        r108 = ((GRComplexTaskOperatingExpandedTemplate) r105).getIconTextInfo();
        goto L36
    L33:
        if ((r105 instanceof GRExpandedDialogueTemplate) == false) goto L35;
        r108 = ((GRExpandedDialogueTemplate) r105).getIconTextInfo();
        goto L36
    L35:
        r108 = null;
        goto L36
    L25:
        r107 = null;
        goto L27
    L22:
        r106 = null;
        goto L23
    L11:
        r104 = null;
        goto L12
    L13:
        if (r101 == null) goto L15;
        l r162 = r101.f528828b;
    L16:
        Intrinsics.checkNotNull(r162, "null cannot be cast to non-null type com.obric.assistant.live.gr.island.island.template.GRComplexTaskExpandedTemplate");
        r105 = ((GRComplexTaskExpandedTemplate) r162).getDialogue();
        goto L20
    L15:
        r162 = null;
        goto L16
    L17:
        if (r101 == null) goto L19;
        r105 = r101.f528828b;
        goto L20
    L19:
        r105 = null;
        goto L20
    L5:
        r102 = null;
        goto L6
    }

    public final void d(j r110, k r111, oea.a r112) {
        Intrinsics.checkNotNullParameter(r110, "targetSession");
        Intrinsics.checkNotNullParameter(r111, "targetWidget");
        Intrinsics.checkNotNullParameter("update_button", com.heytap.mcssdk.constant.b.f276361k);
        Intrinsics.checkNotNullParameter(r112, "event");
        this.f390081c.tryEmit(new c(new GRIslandImpl$sendEvent$1("update_button", r112, r111, this, r110, null)));
    }
}
