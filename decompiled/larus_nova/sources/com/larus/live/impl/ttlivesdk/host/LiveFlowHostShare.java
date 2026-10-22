package com.larus.live.impl.ttlivesdk.host;

import android.app.Activity;
import android.net.Uri;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.live.profit.redpacket.x0;
import com.bytedance.android.livehostapi.business.depend.share.IShareCallback;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.android.livehostapi.wrap.AbsHostShare;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.share.api.IShareService;
import com.larus.btm.api.IBTMService;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.share.service.ShareShortUrlCreateHelper;
import com.larus.share.service.d;
import com.larus.share.service.e;
import com.larus.share.service.f;
import com.larus.share.service.g;
import com.larus.share.service.h;
import com.larus.share.service.j;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import py.k;
import t19.s;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveFlowHostShare extends AbsHostShare {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f355849a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.live.impl.ttlivesdk.host.LiveFlowHostShare$showNativeShareDialog$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.live.impl.ttlivesdk.host.LiveFlowHostShare$showNativeShareDialog$1", f = "LiveFlowHostShare.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ FragmentActivity $availableActivity;
        final /* synthetic */ IShareCallback $callback;
        final /* synthetic */ ShareParams $params;
        int label;
        final /* synthetic */ LiveFlowHostShare this$0;

        public AnonymousClass1(LiveFlowHostShare r100, FragmentActivity r101, ShareParams r102, IShareCallback r103, Continuation<? super AnonymousClass1> r104) {
            this.this$0 = r100;
            this.$availableActivity = r101;
            this.$params = r102;
            this.$callback = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, this.$availableActivity, this.$params, this.$callback, r101);
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
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            LiveFlowHostShare r103 = this.this$0;
            FragmentActivity r104 = this.$availableActivity;
            ShareParams r105 = this.$params;
            IShareCallback r106 = this.$callback;
            this.label = 1;
            if (LiveFlowHostShare.b(r103, r104, r105, r106, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShareForSaas
    public final boolean isSupportLiveShare() {
        FLogger.f375446a.i("LiveFlowHostShare", "[saas_share_panel][live] isSupportLiveShare=true");
        return true;
    }

    public LiveFlowHostShare() {
    }

    public static String c(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L18;
        return r100;
    L18:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L10
        Object r103 = Result.m9449constructorimpl(URLEncoder.encode(r100, Charsets.UTF_8.name()));     // Catch: Throwable -> L10
    L12:
        Object r104 = r100;
        if (Result.m9455isFailureimpl(r103) == true) goto L17;
        r104 = r103;
    L17:
        return (String) r104;
    L10:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    L5:
        r101 = false;
        goto L6
    }

    public static String e(String r100) {
        Object r101 = "invalid";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L27
        if (r100 == null) goto L7;
        String r103 = StringsKt.trim(r100).toString();     // Catch: Throwable -> L27
    L8:
        String r104 = "";
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        URI r105 = new URI(r103);     // Catch: Throwable -> L27
        String r106 = r105.getHost();     // Catch: Throwable -> L27
        if (r106 != null) goto L14;
    L17:
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
        String r108 = "invalid";
    L25:
        Object r109 = Result.m9449constructorimpl(r108);     // Catch: Throwable -> L27
    L30:
        if (Result.m9455isFailureimpl(r109) == true) goto L34;
        r101 = r109;
    L34:
        return (String) r101;
    L20:
        StringBuilder r110 = new StringBuilder();     // Catch: Throwable -> L27
        r110.append(r105.getScheme());     // Catch: Throwable -> L27
        r110.append("://");     // Catch: Throwable -> L27
        r110.append(r105.getHost());     // Catch: Throwable -> L27
        String r111 = r105.getPath();     // Catch: Throwable -> L27
        if (r111 == null) goto L24;
        r104 = r111;
    L24:
        r110.append(r104);     // Catch: Throwable -> L27
        r108 = r110.toString();     // Catch: Throwable -> L27
        goto L25
    L14:
        if (StringsKt.isBlank(r106) == true) goto L17;
        r107 = false;
        goto L18
    L7:
        r103 = null;
    L27:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    public static void d(IShareCallback r100, String r101) {
        FLogger.f375446a.e("LiveFlowHostShare", "[saas_share_panel][live] failed reason=" + r101);
        if (r100 == null) goto L6;
        r100.onFail(new IllegalStateException(r101));
        return;
    }

    public static void i(JSONObject r100, Map r101) {
        if (r101 == null) goto L7;
        Iterator r102 = r101.entrySet().iterator();
    L5:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        r100.put((String) r103.getKey(), (String) r103.getValue());
        goto L5
    L9:
        return;
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShare
    public final boolean isShareAvailable(String r100, Activity r101) {
        if ((r101 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r101;
    L6:
        if (r102 != null) goto L8;
    L16:
        boolean r103 = false;
    L17:
        FLogger.f375446a.i("LiveFlowHostShare", "[saas_share_panel][live] isShareAvailable type=" + r100 + " available=" + r103);
        return r103;
    L8:
        if (r102.isFinishing() == true) goto L16;
        if (r102.isDestroyed() == true) goto L16;
        if (r102.getSupportFragmentManager().isStateSaved() == true) goto L16;
        if (ServiceManager.get().getService(IShareService.class) == null) goto L16;
        r103 = true;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.bytedance.android.livehostapi.hostdefault.HostShareDefault, com.bytedance.android.livehostapi.business.IHostShareForSaas
    public final void showNativeShareDialog(Activity r110, ShareParams r111, IShareCallback r112) {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("[saas_share_panel][live] showNativeShareDialog activity=");
        if (r110 == null) goto L5;
        String r102 = r110.getClass().getName();
    L6:
        r101.append(r102);
        r101.append(" roomId=");
        if (r111 == null) goto L9;
        long r103 = r111.getRoomId();
    L10:
        r101.append(r103);
        r101.append(" url=");
        FragmentActivity r104 = null;
        if (r111 == null) goto L13;
        String r105 = r111.getUrl();
    L14:
        r101.append(e(r105));
        r100.i("LiveFlowHostShare", r101.toString());
        if ((r110 instanceof FragmentActivity) == false) goto L17;
        r104 = (FragmentActivity) r110;
    L17:
        FragmentActivity r106 = r104;
        if (r106 != null) goto L20;
    L26:
        boolean r113 = false;
    L27:
        if (r113 == true) goto L30;
        d(r112, "FragmentActivity is unavailable");
        return;
    L30:
        if (r106 != null) goto L32;
        return;
    L32:
        if (r111 != null) goto L35;
        d(r112, "ShareParams is null");
        return;
    L35:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r106), null, null, new AnonymousClass1(this, r106, r111, r112, null), 3, null);
        return;
    L20:
        if (r106.isFinishing() == true) goto L26;
        if (r106.isDestroyed() == true) goto L26;
        if (r106.getSupportFragmentManager().isStateSaved() == true) goto L26;
        r113 = true;
        goto L27
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = 0;
        goto L10
    L5:
        r102 = "null";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v1, types: [com.larus.live.impl.ttlivesdk.host.a] */
    public static final Object b(final LiveFlowHostShare r210, FragmentActivity r211, ShareParams r212, IShareCallback r310, Continuation r311) {
        r210.getClass();
        if ((r311 instanceof LiveFlowHostShare$showNativeShareDialogAsync$1) == false) goto L7;
        LiveFlowHostShare$showNativeShareDialogAsync$1 r100 = (LiveFlowHostShare$showNativeShareDialogAsync$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        LiveFlowHostShare$showNativeShareDialogAsync$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        String r110 = "";
        String r111 = null;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        int r106 = r102.I$0;
        String r107 = (String) r102.L$4;
        JSONObject r108 = (JSONObject) r102.L$3;
        IShareCallback r109 = (IShareCallback) r102.L$2;
        ShareParams r112 = (ShareParams) r102.L$1;
        FragmentActivity r113 = (FragmentActivity) r102.L$0;
        ResultKt.throwOnFailure(r103);
        String r213 = r107;
        JSONObject r214 = r108;
        FragmentActivity r114 = r113;
        IShareCallback r115 = r109;
    L69:
        j r116 = (j) r103;
        if ((r116 instanceof j.b) == false) goto L107;
        String r117 = ((j.b) r116).f368937a;
        h r118 = h.f368920a;
        if (r106 == 0) goto L74;
        String r119 = "local_life_live_room";
    L75:
        String r120 = r119;
        String r121 = r112.getTitle();
        if (r121 != null) goto L78;
    L82:
        r121 = r112.getRoomTitle();
    L83:
        String r122 = r121;
        String r123 = z2.f365865a.getSaasShareConfig().g();
        if (r123 != null) goto L86;
        String r215 = "";
    L87:
        k r124 = r112.getAvatarThumb();
        if (r124 == null) goto L90;
        r111 = x0.f(r124);
    L90:
        f r125 = new f(r120, r117, r122, r215, r111, null, null, r213, r214, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE);
        r118.getClass();
        g r126 = h.c(r125);
        final e r127 = r126.getContext();
        if (r126.f368917a == false) goto L102;
        if (r127 == null) goto L102;
        final IShareService r128 = (IShareService) ServiceManager.get().getService(IShareService.class);
        if (r128 != null) goto L97;
        d(r115, "IShareService is null");
        return Unit.INSTANCE;
    L97:
        final c r129 = new c(r127, r112, r128, r114);
        final FragmentActivity r130 = r114;
        final IShareCallback r131 = r115;
        final ?? r132 = new com.larus.live.impl.ttlivesdk.host.a(r210, r130, r131, r128, r127, r129);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L100;
        r132.invoke();
    L120:
        return Unit.INSTANCE;
    L100:
        FLogger.f375446a.w("LiveFlowHostShare", "[saas_share_panel][live] post showSharePanel to main thread");
        r114.runOnUiThread(new b(r132));
    L102:
        String r133 = r126.f368919c;
        if (r133 != null) goto L105;
        r133 = "unknown";
    L105:
        d(r115, "resolve failed: ".concat(r133));
        return Unit.INSTANCE;
    L86:
        r215 = r123;
        goto L87
    L78:
        if ((!StringsKt.isBlank(r121)) == true) goto L81;
        r121 = null;
    L81:
        if (r121 != null) goto L83;
    L74:
        r119 = "live_room";
        goto L75
    L107:
        if ((r116 instanceof j.c) == false) goto L110;
        FLogger.f375446a.w("LiveFlowHostShare", "[saas_share_panel][live] create short url timeout=" + ((j.c) r116).f368938a + "ms");
        s.f544207a.getClass();
        s.b(r114, R.string.larus_share_failed, false);
        d(r115, "create short url timeout");
        return Unit.INSTANCE;
    L110:
        if ((r116 instanceof j.a) == false) goto L118;
        FLogger r134 = FLogger.f375446a;
        StringBuilder r135 = new StringBuilder("[saas_share_panel][live] create short url failed code=");
        j.a r136 = (j.a) r116;
        r135.append(r136.f368934a);
        r135.append(", msg=");
        r135.append(r136.f368935b);
        r134.w("LiveFlowHostShare", r135.toString());
        s.f544207a.getClass();
        s.b(r114, R.string.larus_share_failed, false);
        String r137 = r136.f368935b;
        if (r137 == null) goto L115;
        r110 = r137;
    L115:
        d(r115, "create short url failed: ".concat(r110));
        return Unit.INSTANCE;
    L118:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        JSONObject r138 = new JSONObject();
        i(r138, r212.getLogV3Params());
        i(r138, r212.getLogExtraParams());
        i(r138, r212.getExtraParams());
        i(r138, r212.getLiveCommonShareParams());
        i(r138, r212.getActivityInfo());
        String r139 = r212.getShareEnterFrom();
        if (r139 != null) goto L17;
    L22:
        String r140 = r212.getShareEnterMethod();
        if (r140 != null) goto L25;
    L30:
        Long r141 = Boxing.boxLong(r212.getRoomId());
        if (r141.longValue() <= 0) goto L33;
        boolean r142 = true;
    L34:
        if (r142 == true) goto L37;
        r141 = null;
    L37:
        if (r141 == null) goto L39;
        String r143 = r141.toString();
    L40:
        String r144 = d.d(r138, r212.getUrl());
        r138.put(BdpAppEventConstant.SHARE_ID, r144);
        Map<String, String> r145 = r212.getLogV3Params();
        if (r145 == null) goto L45;
        String r146 = r145.get("live_room_type");
        if (r146 == null) goto L45;
        Integer r147 = StringsKt.toIntOrNull(r146);
    L46:
        if (r147 != null) goto L49;
    L50:
        String r148 = r212.getLifeExtraInfo();
        if (r148 != null) goto L53;
    L56:
        boolean r149 = true;
    L57:
        if (r149 == false) goto L60;
        int r150 = 0;
    L61:
        String r151 = r212.getUrl();
        if (r151 != null) goto L64;
        String r152 = "";
    L65:
        String r153 = String.valueOf(r212.getRoomId());
        r114 = r211;
        r102.L$0 = r114;
        r102.L$1 = r212;
        r102.L$2 = r310;
        r102.L$3 = r138;
        r102.L$4 = r143;
        r102.I$0 = r150;
        r102.label = 1;
        Object r154 = r210.g(r152, r153, r144, r150, r102);
        if (r154 == r104) goto L123;
        r112 = r212;
        r115 = r310;
        r214 = r138;
        r103 = r154;
        r213 = r143;
        r106 = r150;
        goto L69
    L123:
        return r104;
    L64:
        r152 = r151;
    L60:
        r150 = 1;
        goto L61
    L53:
        if (r148.length() == 0) goto L56;
        r149 = false;
        goto L57
    L49:
        if (r147.intValue() == 1) goto L60;
    L45:
        r147 = null;
        goto L46
    L39:
        r143 = null;
        goto L40
    L33:
        r142 = false;
        goto L34
    L25:
        if ((!StringsKt.isBlank(r140)) == true) goto L28;
        r140 = null;
    L28:
        if (r140 == null) goto L30;
        r138.put("share_enter_method", r140);
        goto L30
    L17:
        if ((!StringsKt.isBlank(r139)) == true) goto L20;
        r139 = null;
    L20:
        if (r139 == null) goto L22;
        r138.put("share_enter_from", r139);
    L7:
        r100 = new LiveFlowHostShare$showNativeShareDialogAsync$1(r210, r311);
        goto L8
    }

    public final Object g(String r110, String r111, String r112, boolean r210, Continuation<? super j> r211) {
        if ((r211 instanceof LiveFlowHostShare$packUrl$1) == false) goto L7;
        LiveFlowHostShare$packUrl$1 r100 = (LiveFlowHostShare$packUrl$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r105 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L50:
        j r106 = (j) r102;
        e(r105);
        return r106;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (StringsKt.isBlank(r111) == true) goto L17;
        String r107 = "doubao://webcast_room?need_login_strict_mode=1&need_login_to_target_page=1&enter_from_merge=doubao&enter_method=doubao_share&room_id=" + r111 + "&share_id=" + r112;
        JSONObject r108 = new JSONObject();
        JSONObject r109 = new JSONObject();
        r109.put(BdpAppEventConstant.SHARE_ID, r112);
        r109.put("room_id", r111);
        Unit r113 = Unit.INSTANCE;
        r108.put(BdpAppEventConstant.PARAMS_LIFE_EXTRA_INFO, r109.toString());
        FragmentActivity r114 = null;
        if (r210 == false) goto L21;
        String r115 = r107 + "&enter_from_merge=doubao&enter_method=doubao_share&extra_params=" + c(r108.toString());
    L30:
        Pair[] r116 = new Pair[4];
        r116[0] = TuplesKt.to(BdpAppEventConstant.SHARE_ID, r112);
        r116[1] = TuplesKt.to("share_from", "doubao_share");
        JSONObject r117 = new JSONObject();
        r117.put(BdpAppEventConstant.SHARE_ID, r112);
        r117.put("share_from", "doubao_share");
        if (r210 == false) goto L33;
        String r118 = "locallife";
    L34:
        r117.put("share_scene", r118);
        r116[2] = TuplesKt.to("doubao_event_params", r117.toString());
        r116[3] = TuplesKt.to("schema", r115);
        LinkedHashMap r119 = MapsKt.linkedMapOf(r116);
        if (r210 == false) goto L37;
        r119.put("extra_params", c(r108.toString()));
    L37:
        r105 = d.b(r110, r119);
        IBTMService r120 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r120 == null) goto L47;
        JSONObject r121 = new JSONObject();
        r121.put("doubao_share_id", r112);
        Activity r122 = AppHost.f326268a.a().getCurrentActivity();
        if ((r122 instanceof FragmentActivity) == false) goto L42;
        r114 = (FragmentActivity) r122;
    L42:
        Uri r123 = r120.p(r105, "a35794.b116695.c116696.d116698", r121, r114);
        if (r123 == null) goto L47;
        String r124 = r123.toString();
        if (r124 == null) goto L47;
        r105 = r124;
    L47:
        ShareShortUrlCreateHelper r125 = ShareShortUrlCreateHelper.f368890a;
        r100.L$0 = r105;
        r100.label = 1;
        r102 = ShareShortUrlCreateHelper.b(r105, r100);
        if (r102 != r103) goto L50;
        return r103;
    L33:
        r118 = "ecom";
        goto L34
    L21:
        IBTMService r126 = (IBTMService) ServiceManager.get().getService(IBTMService.class);
        if (r126 == null) goto L28;
        JSONObject r127 = new JSONObject();
        r127.put("doubao_share_id", r112);
        Activity r128 = AppHost.f326268a.a().getCurrentActivity();
        if ((r128 instanceof FragmentActivity) == false) goto L26;
        FragmentActivity r129 = (FragmentActivity) r128;
    L27:
        Uri r130 = r126.p(r107, "a35794.b116695.c116696.d116698", r127, r129);
    L29:
        r115 = String.valueOf(r130);
        goto L30
    L26:
        r129 = null;
        goto L27
    L28:
        r130 = null;
        goto L29
    L17:
        return new j.b(d.a(r110, r112));
    L7:
        r100 = new LiveFlowHostShare$packUrl$1(this, r211);
        goto L8
    }
}
