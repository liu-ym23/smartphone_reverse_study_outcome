package com.larus.slides.impl.actionbar.model;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.ttm.player.MediaPlayer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class PPTGenerationRepo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PPTGenerationRepo f369481a = null;

    static {
        f369481a = new PPTGenerationRepo();
    }

    public PPTGenerationRepo() {
    }

    public final Object a(int r110, int r111, Continuation<? super com.larus.network.http.a<d>> r112) {
        if ((r112 instanceof PPTGenerationRepo$getPPTTemplateListData$1) == false) goto L7;
        PPTGenerationRepo$getPPTTemplateListData$1 r100 = (PPTGenerationRepo$getPPTTemplateListData$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        PPTGenerationRepo$getPPTTemplateListData$1 r113 = r100;
        Object r102 = r113.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r113.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L28:
        com.larus.network.http.a r105 = (com.larus.network.http.a) r102;
        FLogger.f375446a.i("PPTGenerationRepo", "getPPTTemplateListData end");
        return r105;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        FLogger.f375446a.i("PPTGenerationRepo", "getPPTTemplateListData start");
        b.a r106 = b.f369482a;
        if (b.f369483b != null) goto L25;
        monitor-enter(r106);
    L22:
        th = move-exception;
        throw th;
    L18:
        if (b.f369483b != null) goto L20;
        b.f369483b = new b();     // Catch: Throwable -> L22
    L20:
        monitor-exit(r106);
    L25:
        r113.label = 1;
        JSONObject r107 = new JSONObject();
        r107.put(EffectConfiguration.KEY_CURSOR, r110);
        r107.put("page_size", r111);
        Unit r108 = Unit.INSTANCE;
        r102 = HttpExtKt.k(ServiceType.BASIC_SERVICE, d.class, "/alice/aippt/template_list", r107, null, null, true, null, null, null, r113, MediaPlayer.MEDIA_PLAYER_OPTION_HTTP2_PARAMS);
        if (r102 != r103) goto L28;
        return r103;
    L7:
        r100 = new PPTGenerationRepo$getPPTTemplateListData$1(this, r112);
        goto L8
    }
}
