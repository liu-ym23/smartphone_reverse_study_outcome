package com.larus.avlink.platform;

import com.larus.avlink.plugins.b5;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.internal.audio.u;
import com.larus.im.internal.d;
import com.larus.im.internal.utils.x;
import com.larus.voicecall.api.bean.SessionConfResponse;
import com.larus.voicecall.api.bean.TtsParams;
import gd9.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.v;
import wc9.e;

/* JADX INFO: loaded from: classes25.dex */
public final class AndroidPlatformKt {
    public static final void a() {
        int r100 = com.larus.im.a.f346406a;
        o r101 = d.f347913a;
        u.f347501c.getClass();
        x r102 = x.f350563a;
    }

    public static final b5 c(String r100) {
        String r101 = "";
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        v r103 = xt7.d.f565073b;     // Catch: Throwable -> L8
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        Object r104 = Result.m9449constructorimpl(r103.c(juc.v.a(r103.f526800b, Reflection.getOrCreateKotlinClass(SessionConfResponse.class)), r100));     // Catch: Throwable -> L8
    L10:
        b5 r105 = null;
        if (Result.m9455isFailureimpl(r104) == false) goto L13;
        r104 = null;
    L13:
        SessionConfResponse r106 = (SessionConfResponse) r104;
        if (r106 == null) goto L33;
        r105 = new b5();
        String r107 = r106.getConversationId();
        if (r107 != null) goto L18;
        r107 = "";
    L18:
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r105.f293841b = r107;
        String r108 = r106.getBotId();
        if (r108 != null) goto L21;
        r108 = "";
    L21:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r105.f293840a = r108;
        TtsParams r109 = r106.getTtsParams();
        if (r109 == null) goto L25;
        String r110 = r109.getStyleId();
        if (r110 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        r105.f293842c = r110;
        TtsParams r111 = r106.getTtsParams();
        if (r111 == null) goto L32;
        String r112 = r111.getAudioMetrics();
        if (r112 == null) goto L32;
        r101 = r112;
    L32:
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r105.f293843d = r101;
    L25:
        r110 = "";
    L33:
        return r105;
    L8:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Object b(String r100, Continuation<? super e> r110) {
        if ((r110 instanceof AndroidPlatformKt$getConversation$1) == false) goto L7;
        AndroidPlatformKt$getConversation$1 r101 = (AndroidPlatformKt$getConversation$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        AndroidPlatformKt$getConversation$1 r103 = r101;
        Object r111 = r103.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r103.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r111);
    L36:
        return r111;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        IConversationRepoService r107 = (IConversationRepoService) r103.L$1;
        String r108 = (String) r103.L$0;
        ResultKt.throwOnFailure(r111);
        IConversationRepoService r109 = r107;
        r100 = r108;
    L20:
        e r112 = (e) r111;
        if (r112 == null) goto L28;
        Integer r113 = r112.f559203f;
        if (r113 == null) goto L28;
        if (r113.intValue() != 1) goto L28;
    L30:
        if (r106 == false) goto L32;
        String r114 = r112.f559198a;
    L33:
        r103.L$0 = null;
        r103.L$1 = null;
        r103.label = 2;
        r111 = IConversationRepoService.a.c(r109, r100, false, r114, r103, 2);
        if (r111 != r104) goto L36;
        return r104;
    L32:
        r114 = null;
    L28:
        r106 = false;
        goto L30
    L16:
        ResultKt.throwOnFailure(r111);
        IConversationRepoService r115 = zh8.a.f572197b;
        r103.L$0 = r100;
        r103.L$1 = r115;
        r103.label = 1;
        Object r116 = r115.a(r100, r103);
        if (r116 != r104) goto L19;
        return r104;
    L19:
        r109 = r115;
        r111 = r116;
    L7:
        r101 = new AndroidPlatformKt$getConversation$1(r110);
        goto L8
    }
}
