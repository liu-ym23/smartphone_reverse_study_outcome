package com.larus.voice_setting.voice;

import android.os.SystemClock;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.buynow.data.model.CheckStatus;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.hihonor.honorid.core.data.UserInfo;
import com.larus.audio.bean.GetMatchVoiceRequest;
import com.larus.audio.bean.RecommendScene;
import com.larus.im.bean.bot.IconItem;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.larus.utils.livedata.NonStickyLiveData;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.bean.CacheStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class UgcVoiceLoader {
    public static final NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> A = null;
    public static final NonStickyLiveData B = null;
    public static final MutableLiveData<Integer> C = null;
    public static final MutableLiveData D = null;
    public static final List<SpeakerVoice> E = null;
    public static final CopyOnWriteArrayList<p2a.e> F = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UgcVoiceLoader f376282a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f376283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f376284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Gson f376285d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final List<SpeakerVoice> f376286e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<SpeakerVoice> f376287f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final List<SpeakerVoice> f376288g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final List<SpeakerVoice> f376289h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.i> f376290i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final NonStickyLiveData f376291j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.e> f376292k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.e> f376293l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile CacheStatus f376294m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static volatile RecommendScene f376295n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.c> f376296o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final NonStickyLiveData f376297p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final NonStickyLiveData<com.larus.network.http.a<r2a.d>> f376298q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final NonStickyLiveData f376299r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> f376300s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final NonStickyLiveData f376301t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.b> f376302u = null;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final NonStickyLiveData f376303v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.a> f376304w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final NonStickyLiveData f376305x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final NonStickyLiveData<r2a.c> f376306y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final NonStickyLiveData f376307z = null;

    public UgcVoiceLoader() {
    }

    static {
        f376282a = new UgcVoiceLoader();
        f376283b = 1;
        f376284c = 1;
        f376285d = new Gson();
        f376286e = new ArrayList();
        f376287f = new ArrayList();
        f376288g = new CopyOnWriteArrayList();
        f376289h = new CopyOnWriteArrayList();
        NonStickyLiveData<r2a.i> r100 = new NonStickyLiveData();
        f376290i = r100;
        f376291j = r100;
        NonStickyLiveData<r2a.e> r101 = new NonStickyLiveData();
        f376292k = r101;
        f376293l = r101;
        f376294m = CacheStatus.EMPTY;
        f376295n = RecommendScene.NULL;
        NonStickyLiveData<r2a.c> r102 = new NonStickyLiveData();
        f376296o = r102;
        f376297p = r102;
        NonStickyLiveData<com.larus.network.http.a<r2a.d>> r103 = new NonStickyLiveData();
        f376298q = r103;
        f376299r = r103;
        NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> r104 = new NonStickyLiveData();
        f376300s = r104;
        f376301t = r104;
        NonStickyLiveData<r2a.b> r105 = new NonStickyLiveData();
        f376302u = r105;
        f376303v = r105;
        NonStickyLiveData<r2a.a> r106 = new NonStickyLiveData();
        f376304w = r106;
        f376305x = r106;
        NonStickyLiveData<r2a.c> r107 = new NonStickyLiveData();
        f376306y = r107;
        f376307z = r107;
        NonStickyLiveData<com.larus.network.http.a<SpeakerVoice>> r108 = new NonStickyLiveData();
        A = r108;
        B = r108;
        MutableLiveData<Integer> r109 = new MutableLiveData();
        C = r109;
        D = r109;
        E = new CopyOnWriteArrayList();
        F = new CopyOnWriteArrayList();
    }

    public static void p() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUgcVoiceAuthorized$1(null), 3, null);
    }

    public static void u() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$updateFailedVoiceKeva$1(null), 2, null);
    }

    public static final void a(String r100) {
        Iterator r101 = ((ArrayList) f376286e).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        SpeakerVoice r102 = (SpeakerVoice) r101.next();
        if (r102 == null) goto L4;
        if (Intrinsics.areEqual(r102.getId(), r100) == false) goto L4;
        r101.remove();
        goto L4
    L10:
        Iterator r103 = ((ArrayList) f376287f).iterator();
        boolean r104 = false;
    L12:
        if (r103.hasNext() == false) goto L18;
        SpeakerVoice r105 = (SpeakerVoice) r103.next();
        if (r105 == null) goto L12;
        if (Intrinsics.areEqual(r105.getId(), r100) == false) goto L12;
        r103.remove();
        r104 = true;
        goto L12
    L18:
        if (r104 == false) goto L35;
        u();
        return;
    }

    public static void f(SpeakerVoice r100) {
        Intrinsics.checkNotNullParameter(r100, "voice");
        Iterator r101 = ((ArrayList) f376287f).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r102).getId(), r100.getId()) == false) goto L4;
    L10:
        if (((SpeakerVoice) r102) != null) goto L16;
        ((ArrayList) f376287f).add(r100);
        u();
        return;
    L16:
        return;
    L8:
        r102 = null;
        goto L10
    }

    public static boolean h(String r100) {
        r2a.e r101 = f376293l.getValue();
        if (r101 == null) goto L5;
        List<SpeakerVoice> r102 = r101.f535834a;
    L6:
        List<SpeakerVoice> r103 = r102;
        if (r103 != null) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return false;
    L15:
        Iterator<T> r105 = r102.iterator();
        int r106 = 0;
    L17:
        if (r105.hasNext() == false) goto L29;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        SpeakerVoice r109 = (SpeakerVoice) r107;
        if (Intrinsics.areEqual(r100, r109.getId()) == true) goto L24;
        if (r106 == 9) goto L27;
        r106 = r108;
        goto L17
    L27:
        return false;
    L24:
        return r109.getBestMatch();
    L29:
        return false;
    L9:
        if (r103.isEmpty() == true) goto L12;
        r104 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }

    public static void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$queryMoreVoice$1(r100, null), 2, null);
    }

    public static void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$requestMyUgcVoiceList$1(r100, null), 2, null);
    }

    public static void t(SpeakerVoice r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator r101 = ((CopyOnWriteArrayList) E).iterator();
        int r102 = 0;
    L6:
        if (r101.hasNext() == false) goto L11;
        SpeakerVoice r103 = (SpeakerVoice) r101.next();
        if (Intrinsics.areEqual(r100.getId(), r103.getId()) == true) goto L12;
        r102 = r102 + 1;
    L12:
        if (r102 == (-1)) goto L17;
        ListProtector.set(E, r102, r100);
        return;
    L17:
        return;
    L11:
        r102 = -1;
        goto L12
    }

    public static final void b(String r100, String r101) {
        Iterator r102 = ((ArrayList) f376286e).iterator();
    L3:
        SpeakerVoice r103 = null;
        if (r102.hasNext() == false) goto L8;
        Object r104 = r102.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r104).getId(), r100) == false) goto L3;
    L9:
        SpeakerVoice r105 = (SpeakerVoice) r104;
        if (r105 == null) goto L12;
        r105.setName(r101);
    L12:
        Iterator r106 = ((ArrayList) f376287f).iterator();
    L14:
        if (r106.hasNext() == false) goto L18;
        Object r107 = r106.next();
        if (Intrinsics.areEqual(((SpeakerVoice) r107).getId(), r100) == false) goto L14;
    L19:
        SpeakerVoice r108 = (SpeakerVoice) r107;
        if (r108 == null) goto L22;
        r108.setName(r101);
        r103 = r108;
    L22:
        if (r103 == null) goto L31;
        u();
        return;
    L31:
        return;
    L18:
        r107 = null;
        goto L19
    L8:
        r104 = null;
        goto L9
    }

    public static void g(String r100, SpeakerVoice r101) {
        boolean r102 = false;
        ListProtector.add(f376286e, 0, r101);
        Iterator r103 = ((ArrayList) f376287f).iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        if (Intrinsics.areEqual(((SpeakerVoice) r103.next()).getId(), r100) == false) goto L4;
        r103.remove();
        r102 = true;
        goto L4
    L8:
        if (r102 == false) goto L16;
        u();
        return;
    }

    public static void i(GetMatchVoiceRequest r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "param");
        Ref.LongRef r100 = new Ref.LongRef();
        r100.element = SystemClock.uptimeMillis();
        f376294m = CacheStatus.EMPTY;
        f376295n = RecommendScene.NULL;
        f376284c = 1;
        f376292k.setValue(null);
        f376294m = CacheStatus.LOADING;
        f376295n = r110.f288723g;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$preLoadRecommendVoiceListV2$1(r110, r100, false, r111, null), 2, null);
    }

    public static void j(GetMatchVoiceRequest r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "param");
        Ref.LongRef r101 = new Ref.LongRef();
        r101.element = SystemClock.uptimeMillis();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new UgcVoiceLoader$queryMoreRecommendVoiceV2$1(r100, r101, r110, null), 2, null);
    }

    public static final Object d(int r110, String r111, Continuation r112) {
        JSONObject r100 = new JSONObject();
        if (z2.f365865a.I2() == false) goto L5;
        r100.put("page_index", r110);
        r100.put("page_size", 20);
        r100.put("language_code", r111);
    L5:
        Unit r113 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.UGC, r2a.g.class, "/alice/user_voice/list", r100, null, null, false, null, null, null, r112, 1008);
    }

    public static final Object c(UgcVoiceLoader r110, GetMatchVoiceRequest r111, int r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof UgcVoiceLoader$queryBestMatchVoiceList$1) == false) goto L7;
        UgcVoiceLoader$queryBestMatchVoiceList$1 r100 = (UgcVoiceLoader$queryBestMatchVoiceList$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$queryBestMatchVoiceList$1 r114 = r100;
        Object r102 = r114.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r114.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L18:
        return (com.larus.network.http.a) r102;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        JSONObject r105 = new JSONObject();
        r105.put("page_index", r112);
        r105.put("page_size", 20);
        r105.put(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_TYPE, 2);
        r105.put("language_code", r111.f288722f);
        r105.put("bot_name", r111.f288717a);
        r105.put("bot_desc", r111.f288718b);
        r105.put("bot_id", r111.f288720d);
        r105.put("bot_model_type", r111.f288721e);
        Unit r106 = Unit.INSTANCE;
        r114.label = 1;
        r102 = HttpExtKt.k(ServiceType.UGC, r2a.g.class, "/alice/user_voice/recommend", r105, null, null, false, null, null, null, r114, 1008);
        if (r102 != r103) goto L18;
        return r103;
    L7:
        r100 = new UgcVoiceLoader$queryBestMatchVoiceList$1(r110, r113);
        goto L8
    }

    public static void n(String r110, String r111, String r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r110, "voiceName");
        Intrinsics.checkNotNullParameter(r112, "localVoiceId");
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestCreateUgcVoiceV2$1(r112, r110, r111, r113, null), 3, null);
    }

    public static void q(String r110, String r111, String r112, boolean r113) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUpdateVoiceV2$1(r110, r111, r112, r113, null), 3, null);
    }

    public final Object l(String r110, String r111, String r112, Continuation<? super Unit> r210) {
        String r100 = r112;
        if ((r210 instanceof UgcVoiceLoader$requestCloneUgcVoiceV2$1) == false) goto L7;
        UgcVoiceLoader$requestCloneUgcVoiceV2$1 r101 = (UgcVoiceLoader$requestCloneUgcVoiceV2$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCloneUgcVoiceV2$1 r113 = r101;
        Object r103 = r113.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r113.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        r100 = (String) r113.L$0;
        ResultKt.throwOnFailure(r103);
    L17:
        f376304w.postValue(new r2a.a((com.larus.network.http.a) r103, r100));
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        JSONObject r106 = new JSONObject();
        r106.put("tos_key", r111);
        r106.put("lang_code", r110);
        r106.put("local_voice_id", r100);
        Unit r107 = Unit.INSTANCE;
        r113.L$0 = r100;
        r113.label = 1;
        r103 = HttpExtKt.k(ServiceType.UGC, SpeakerVoice.class, "/alice/user_voice/clone", r106, null, null, false, null, null, null, r113, 1008);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new UgcVoiceLoader$requestCloneUgcVoiceV2$1(this, r210);
        goto L8
    }

    public static /* synthetic */ void s(String r110, String r111, String r112, String r113, String r114, IconItem r115, String r116, String r117, boolean r118) {
        r(r110, r111, r112, r113, r114, r115, false, r116, r117, r118);
    }

    public static Job r(String r110, String r111, String r112, String r113, String r210, IconItem r211, boolean r212, String r213, String r214, boolean r215) {
        Intrinsics.checkNotNullParameter(r110, UserInfo.LANGUAGECODE);
        Intrinsics.checkNotNullParameter(r111, "filePath");
        Intrinsics.checkNotNullParameter(r112, "freeTalkContent");
        Intrinsics.checkNotNullParameter(r214, "enterMethod");
        return BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new UgcVoiceLoader$requestUploadVoice$1(r111, r113, r112, r110, r210, r211, r212, r213, r214, r215, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object m(final String r210, final String r211, final String r212, final String r213, final IconItem r310, boolean r311, final String r312, final String r313, boolean r314, Continuation<? super Unit> r315) {
        final String r100 = r212;
        final String r101 = r312;
        if ((r315 instanceof UgcVoiceLoader$requestCreateUgcVoice$1) == false) goto L7;
        UgcVoiceLoader$requestCreateUgcVoice$1 r102 = (UgcVoiceLoader$requestCreateUgcVoice$1) r315;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCreateUgcVoice$1 r110 = r102;
        Object r104 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r110.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        boolean r106 = r110.Z$0;
        String r107 = (String) r110.L$1;
        String r108 = (String) r110.L$0;
        ResultKt.throwOnFailure(r104);
        boolean r109 = r106;
        r101 = r107;
        r100 = r108;
        String r112 = "enter_method";
        boolean r113 = true;
        int r114 = 15;
        Object r115 = r104;
        String r116 = null;
    L25:
        final com.larus.network.http.a r117 = (com.larus.network.http.a) r115;
        if ((r117 instanceof com.larus.network.http.y) == false) goto L32;
        SpeakerVoice r118 = (SpeakerVoice) ((com.larus.network.http.y) r117).f360135b;
        if (r118 == null) goto L30;
        g(r100, r118);
    L30:
        f2a.c r119 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice create success");
        r119.e(new x1(r101, r100));
        r119.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r119, r116, r114);
    L34:
        f376296o.postValue(new r2a.c(r117, r100, r113));
        return Unit.INSTANCE;
    L32:
        if ((r117 instanceof com.larus.network.http.f) == false) goto L34;
        FLogger r120 = FLogger.f375446a;
        StringBuilder r121 = new StringBuilder("[requestCreateUgcVoice] fail, error=");
        com.larus.network.http.f r122 = (com.larus.network.http.f) r117;
        r121.append(r122.f360157d);
        r121.append(", localVoiceId=");
        r121.append(r100);
        r120.e("UgcVoiceLoader", r121.toString(), r122.f360157d);
        int r123 = y2a.a.f565724a;
        JSONObject r124 = new JSONObject();
        r124.put("is_scheme", y2a.b.b(r109));
        r124.put(r112, y2a.b.a(r101));
        r124.put("result", CheckStatus.FAIL);
        r124.put("reason", "CreateUGCVoiceRequestFailed");
        JSONObject r125 = new JSONObject();
        r125.put("code", r122.f360157d.getCode());
        r125.put("message", r122.f360157d.getMessage());
        Unit r126 = Unit.INSTANCE;
        r124.put("reason_detail", r125.toString());
        y2a.a.a(r124);
        f2a.c r127 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice create failed");
        r127.e(new y1(r117, r101, r100));
        r127.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r127, r116, r114);
        goto L34
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        f2a.c r128 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice create");
        r128.e(new w1(r213, r211, r210, r313, r310, r312, r212));
        r128.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        r116 = null;
        f2a.c.c(r128, null, 15);
        JSONObject r129 = new JSONObject();
        r129.put("name", r213);
        r129.put("tos_key", r211);
        r129.put("bot_lang", r210);
        if (r310 == null) goto L18;
        String r130 = r310.getUri();
        if (r130 == null) goto L18;
    L19:
        r129.put("icon", r130);
        if (r311 == false) goto L22;
        r129.put("need_delete_id", r100);
    L22:
        r112 = "enter_method";
        r129.put(r112, r101);
        r129.put("preview_text", r313);
        Unit r131 = Unit.INSTANCE;
        r110.L$0 = r100;
        r110.L$1 = r101;
        r109 = r314;
        r110.Z$0 = r109;
        r113 = true;
        r110.label = 1;
        r114 = 15;
        r115 = HttpExtKt.k(ServiceType.UGC, SpeakerVoice.class, "/alice/user_voice/create", r129, null, null, false, null, null, null, r110, 1008);
        if (r115 != r111) goto L25;
        return r111;
    L18:
        r130 = "";
    L7:
        r102 = new UgcVoiceLoader$requestCreateUgcVoice$1(this, r315);
        goto L8
    }

    public static final Object e(UgcVoiceLoader r210, final String r310, final String r311, final String r312, final String r313, String r314, IconItem r315, boolean r316, String r317, final String r318, boolean r319, Continuation r410) {
        String r100 = r310;
        String r101 = r311;
        String r102 = r312;
        final String r103 = r318;
        r210.getClass();
        if ((r410 instanceof UgcVoiceLoader$requestCheckUgcVoice$1) == false) goto L7;
        UgcVoiceLoader$requestCheckUgcVoice$1 r104 = (UgcVoiceLoader$requestCheckUgcVoice$1) r410;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        UgcVoiceLoader$requestCheckUgcVoice$1 r110 = r104;
        Object r106 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r110.label;
        if (r107 == 0) goto L18;
        if (r107 == 1) goto L17;
        if (r107 == 2) goto L16;
        if (r107 == 3) goto L16;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        String r108 = (String) r110.L$0;
        ResultKt.throwOnFailure(r106);
    L39:
        tx9.e0.a(r108, Boxing.boxLong(1));
    L44:
        return Unit.INSTANCE;
    L17:
        boolean r109 = r110.Z$1;
        boolean r112 = r110.Z$0;
        String r113 = (String) r110.L$7;
        String r114 = (String) r110.L$6;
        IconItem r115 = (IconItem) r110.L$5;
        String r116 = (String) r110.L$4;
        String r117 = (String) r110.L$3;
        String r118 = (String) r110.L$2;
        String r119 = (String) r110.L$1;
        String r120 = (String) r110.L$0;
        ResultKt.throwOnFailure(r106);
        boolean r121 = r109;
        String r122 = r114;
        IconItem r123 = r115;
        r100 = r120;
        Object r124 = r111;
        UgcVoiceLoader$requestCheckUgcVoice$1 r211 = r110;
        Object r125 = r106;
        String r126 = "enter_method";
        String r127 = r116;
        r101 = r119;
        r103 = r113;
        final String r128 = r117;
        r102 = r118;
    L22:
        final com.larus.network.http.a r129 = (com.larus.network.http.a) r125;
        String r320 = r101;
        Object r130 = r124;
        String r131 = r100;
        String r132 = r102;
        boolean r321 = r112;
        if ((r129 instanceof com.larus.network.http.y) == false) goto L41;
        final com.larus.network.http.y r133 = (com.larus.network.http.y) r129;
        Long r134 = r133.f360205g;
        if (r134 != null) goto L28;
    L29:
        int r135 = y2a.a.f565724a;
        JSONObject r136 = new JSONObject();
        r136.put("is_scheme", y2a.b.b(r121));
        r136.put(r126, y2a.b.a(r103));
        r136.put("result", CheckStatus.FAIL);
        r136.put("reason", "CheckUGCVoiceRequestFailed");
        JSONObject r137 = new JSONObject();
        r137.put("code", r133.f360205g);
        Unit r138 = Unit.INSTANCE;
        r136.put("reason_detail", r137.toString());
        y2a.a.a(r136);
        f2a.c r139 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice check success, but code is not 0");
        r139.e(new a2(r133, r103, r128));
        r139.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r139, null, 15);
        f376302u.postValue(new r2a.b(0));
        tx9.e0.a(r122, Boxing.boxLong(0));
        goto L44
    L28:
        if (r134.longValue() != 0) goto L29;
        f2a.c r140 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice check success");
        r140.e(new b2(r103, r128));
        r140.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r140, null, 15);
        f376302u.postValue(new r2a.b(0, r128, r127, r123, r321));
        boolean r141 = z2.f365865a.I2();
        UgcVoiceLoader r142 = f376282a;
        if (r141 == false) goto L35;
        UgcVoiceLoader$requestCheckUgcVoice$1 r143 = r211;
        r143.L$0 = r122;
        r143.L$1 = null;
        r143.L$2 = null;
        r143.L$3 = null;
        r143.L$4 = null;
        r143.L$5 = null;
        r143.L$6 = null;
        r143.L$7 = null;
        r143.label = 2;
        Object r144 = r130;
        if (r142.l(r132, r131, r128, r143) == r144) goto L45;
    L38:
        r108 = r122;
    L45:
        return r144;
    L35:
        r144 = r130;
        UgcVoiceLoader$requestCheckUgcVoice$1 r145 = r211;
        r145.L$0 = r122;
        r145.L$1 = null;
        r145.L$2 = null;
        r145.L$3 = null;
        r145.L$4 = null;
        r145.L$5 = null;
        r145.L$6 = null;
        r145.L$7 = null;
        r145.label = 3;
        if (r142.m(r132, r131, r128, r127, r123, r321, r103, r320, r121, r145) != r144) goto L38;
    L41:
        if ((r129 instanceof com.larus.network.http.f) == false) goto L44;
        int r146 = y2a.a.f565724a;
        JSONObject r147 = new JSONObject();
        r147.put("is_scheme", y2a.b.b(r121));
        r147.put(r126, y2a.b.a(r103));
        r147.put("result", CheckStatus.FAIL);
        r147.put("reason", "CheckUGCVoiceRequestFailed");
        JSONObject r148 = new JSONObject();
        com.larus.network.http.f r149 = (com.larus.network.http.f) r129;
        r148.put("code", r149.f360157d.getCode());
        r148.put("message", r149.f360157d.getMessage());
        Unit r150 = Unit.INSTANCE;
        r147.put("reason_detail", r148.toString());
        y2a.a.a(r147);
        FLogger.f375446a.e("UgcVoiceLoader", "[requestCheckUgcVoice] fail, error=" + r149.f360157d + ", localVoiceId=" + r128, r149.f360157d);
        f2a.c r151 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice check failed");
        r151.e(new c2(r129, r103, r128));
        r151.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r151, null, 15);
        f376302u.postValue(new r2a.b(0));
        tx9.e0.a(r122, Boxing.boxLong(0));
        goto L44
    L18:
        ResultKt.throwOnFailure(r106);
        f2a.c r152 = com.larus.voice_setting.voice.utils.k.f377041a.b("request voice check");
        r152.e(new z1(r310, r311, r312, r318, r313));
        r152.f475230c.f475254b = CollectionsKt.listOf("VoiceCreate");
        f2a.c.c(r152, null, 15);
        JSONObject r153 = new JSONObject();
        r153.put("tos_key", r100);
        r153.put("preview_text", r101);
        r153.put("voice_lang", r102);
        r153.put("enter_method", r103);
        Unit r154 = Unit.INSTANCE;
        r110.L$0 = r100;
        r110.L$1 = r101;
        r110.L$2 = r102;
        r128 = r313;
        r110.L$3 = r128;
        r127 = r314;
        r110.L$4 = r127;
        r123 = r315;
        r110.L$5 = r123;
        r110.L$6 = r317;
        r110.L$7 = r103;
        r110.Z$0 = r316;
        r110.Z$1 = r319;
        r110.label = 1;
        r124 = r111;
        r126 = "enter_method";
        r211 = r110;
        Object r155 = HttpExtKt.k(ServiceType.UGC, Object.class, "/alice/user_voice/voice_check", r153, null, null, false, null, null, null, r211, 1008);
        if (r155 != r124) goto L21;
        r144 = r124;
        goto L45
    L21:
        r121 = r319;
        r125 = r155;
        r122 = r317;
        r112 = r316;
    L7:
        r104 = new UgcVoiceLoader$requestCheckUgcVoice$1(r210, r410);
        goto L8
    }
}
