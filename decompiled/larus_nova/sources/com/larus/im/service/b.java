package com.larus.im.service;

import com.larus.bmhome.chat.model.n1;
import com.larus.media.MediaResourceManager;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends c {
    public b() {
        super(50200);
    }

    @Override // com.larus.im.service.c
    public final Object b(ouc.d0 r100, Continuation<? super Unit> r101) {
        com.larus.im.internal.delegate.a.f348188b.i("CmdProcessor", "biz cmd processor");
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L5
        Object r103 = Result.m9449constructorimpl(com.flow.kmp.common.util.g.b(r100.toString()));     // Catch: Throwable -> L5
    L8:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L11;
        r103 = new JSONObject();
    L11:
        JSONObject r104 = ((JSONObject) r103).optJSONObject("bot_reply_loading_update_notify");
        if (r104 == null) goto L14;
        Integer r105 = Boxing.boxInt(r104.optInt("loading_type"));
    L16:
        if (r105 != null) goto L19;
    L20:
        FLogger.f375446a.e("StopLoadingCmdProcessor", "Stop loading failed, because of indicate loading type is " + r105 + '.');
        Unit r106 = Unit.INSTANCE;
    L41:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L44;
        return r106;
    L44:
        return Unit.INSTANCE;
    L19:
        if (r105.intValue() != 4) goto L20;
        String r107 = r104.optString("reply_msg_id");
        if (r107 != null) goto L24;
    L27:
        boolean r108 = true;
    L28:
        if (r108 == false) goto L30;
        FLogger.f375446a.e("StopLoadingCmdProcessor", "Stop loading failed, because of indicate reply id is " + r107 + '.');
        r106 = Unit.INSTANCE;
        goto L41
    L30:
        JSONObject r109 = r104.optJSONObject("ext");
        if (r109 == null) goto L33;
        String r110 = r109.optString("stop_loading_without_msg");
    L35:
        if (Intrinsics.areEqual(r110, "1") == true) goto L37;
    L39:
        com.larus.im.d.e().x(r107, new n1(), null);
        r106 = Unit.INSTANCE;
        goto L41
    L37:
        if (com.larus.media.o.a() == false) goto L39;
        MediaResourceManager.a r111 = new MediaResourceManager.a();
        r111.f358957a = 4;
        r111.f358958b = r107;
        r111.f358959c = MediaResourceManager.FlowAudioBroadcastEvent.asrWaitReplyEnd;
        Lazy r112 = MediaResourceManager.f358950a;
        MediaResourceManager.d(r111);
        goto L39
    L33:
        r110 = null;
        goto L35
    L24:
        if (StringsKt.isBlank(r107) == true) goto L27;
        r108 = false;
        goto L28
    L14:
        r105 = null;
    L5:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }
}
