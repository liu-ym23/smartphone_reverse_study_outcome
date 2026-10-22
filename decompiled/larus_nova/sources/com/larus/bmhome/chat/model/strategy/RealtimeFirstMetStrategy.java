package com.larus.bmhome.chat.model.strategy;

import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.BotOnBoarding;
import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class RealtimeFirstMetStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f307943a;

    public static final class a {
    }

    static {
    }

    public RealtimeFirstMetStrategy() {
        this.f307943a = new LinkedHashSet();
    }

    public final void b(String r110, BotModel r111) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (r111 != null) goto L8;
        return;
    L8:
        if (r111.getOnBoarding() != null) goto L10;
        c(r111, r110, null, null);
    L10:
        BotOnBoarding r100 = r111.getOnBoarding();
        if (r100 != null) goto L13;
        return;
    L13:
        Ref.ObjectRef r101 = new Ref.ObjectRef();
        boolean r102 = true;
        if (r100.getCallMode() != 1) goto L16;
    L19:
        if (r102 == true) goto L23;
        FLogger.f375446a.d("RealtimeFirstMetStrategy", "updateLocalOnboarding called, only should fetch first met allow");
        c(r111, r110, r100, null);
        return;
    L23:
        if (this.f307943a.contains(r110) == false) goto L25;
        return;
    L25:
        this.f307943a.add(r110);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new RealtimeFirstMetStrategy$asyncUpdateLocalOnBoardingByRealtime$1(r110, this, r111, r100, r101, null), 3, null);
        return;
    L16:
        if (r100.getCallMode() == 2) goto L19;
        r102 = false;
        goto L19
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object a(RealtimeFirstMetStrategy r100, String r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1) == false) goto L7;
        RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1 r103 = (RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L17:
        com.larus.network.http.a r108 = (com.larus.network.http.a) r105;
        if ((r108 instanceof com.larus.network.http.f) == false) goto L20;
        FLogger.f375446a.d("RealtimeFirstMetStrategy", "requireLocalOnBoardingMsg called, fetch first met fail, reason: " + ((com.larus.network.http.f) r108).f360157d);
        return null;
    L20:
        com.larus.bmhome.chat.bean.BotOnBoarding r109 = (com.larus.bmhome.chat.bean.BotOnBoarding) r108.f360135b;
        if (r109 != null) goto L24;
        return r109;
    L24:
        return new BotOnBoarding(r109.d(), r109.e(), r109.b(), r109.a(), r109.c());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        RepoDispatcher.f307729a.getClass();
        BotRepo r110 = RepoDispatcher.f307735g;
        r103.label = 1;
        r110.getClass();
        BotRepo.a().getClass();
        r105 = BotApi.d(r101, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new RealtimeFirstMetStrategy$requireLocalOnBoardingMsg$1(r100, r102);
        goto L8
    }

    public static void c(BotModel r100, String r101, BotOnBoarding r102, BotOnBoarding r103) {
        Intrinsics.checkNotNullParameter(r100, "bot");
        int r104 = 0;
        if (r102 != null) goto L5;
        boolean r105 = true;
    L6:
        if (r102 != null) goto L8;
        boolean r106 = true;
    L9:
        if (r102 == null) goto L16;
        if (r103 != null) goto L12;
    L13:
        r105 = r102.isMessageListContentEmpty();
        r106 = com.larus.bmhome.chat.bean.d.u0(r102);
    L14:
        if (r103 == null) goto L16;
        r105 = r103.isMessageListContentEmpty();
        r106 = com.larus.bmhome.chat.bean.d.u0(r103);
        goto L16
    L12:
        if (r102.getCanUseBackUp() == false) goto L14;
    L16:
        String r107 = r100.getBotId();
        if (r102 == null) goto L19;
        Integer r108 = Integer.valueOf(r102.getCallMode());
    L20:
        Boolean r109 = Boolean.valueOf(r106);
        Boolean r110 = Boolean.valueOf(r105);
        JSONObject r111 = new JSONObject();
        Intrinsics.checkNotNullParameter(r111, "params");
        if (r107 != null) goto L40;
    L25:
        if (r101 == null) goto L27;
        r111.put("conversation_id", r101);     // Catch: JSONException -> L23
    L27:
        if (r108 == null) goto L29;
        r111.put("call_mode", r108.intValue());     // Catch: JSONException -> L23
    L29:
        if (r109 != null) goto L31;
    L34:
        if (r110 == null) goto L38;
        r111.put("content_empty", r110.booleanValue() ? 1 : 0);     // Catch: JSONException -> L23
    L23:
        e = move-exception;
        FLogger.f375446a.e("FirstMeetEventHelper", "error in FirstMeetEventHelper showDevOnBoardingCard " + e.getLocalizedMessage());
    L38:
        TrackParams r112 = new TrackParams().merge(r111);
        by7.a r113 = new by7.a("dev_create_local_cvs_onboarding");
        r113.f21463a.merge(r112);
        r113.b();
        return;
    L31:
        if (r109.booleanValue() == false) goto L33;
        r104 = 1;
    L33:
        r111.put("suggest_empty", r104);     // Catch: JSONException -> L23
        goto L34
    L40:
        r111.put("bot_id", r107);     // Catch: JSONException -> L23
        goto L25
    L19:
        r108 = null;
        goto L20
    L8:
        r106 = false;
        goto L9
    L5:
        r105 = false;
        goto L6
    }
}
