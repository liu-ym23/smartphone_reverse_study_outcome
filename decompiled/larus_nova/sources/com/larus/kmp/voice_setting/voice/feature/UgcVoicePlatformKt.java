package com.larus.kmp.voice_setting.voice.feature;

import com.larus.im.FlowRuntime;
import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes30.dex */
public final class UgcVoicePlatformKt {
    public static final void a(String r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        FlowRuntime.b().e().i("VoiceListDiag", r100);     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final Object c(String r100, Object r101, Continuation<? super com.larus.kmp.voice_setting.voice.network.b<? extends Object>> r102) {
        if ((r102 instanceof UgcVoicePlatformKt$ugcVoicePostForAction$1) == false) goto L7;
        UgcVoicePlatformKt$ugcVoicePostForAction$1 r103 = (UgcVoicePlatformKt$ugcVoicePostForAction$1) r102;
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
        com.larus.kmp.voice_setting.voice.network.b r108 = (com.larus.kmp.voice_setting.voice.network.b) r105;
        if ((r108 instanceof com.larus.kmp.voice_setting.voice.network.b.C4393b) == false) goto L21;
        com.larus.kmp.voice_setting.voice.network.b.C4393b r109 = (com.larus.kmp.voice_setting.voice.network.b.C4393b) r108;
        com.larus.kmp.voice_setting.voice.network.a<T> r110 = r109.f353993a;
        return new com.larus.kmp.voice_setting.voice.network.b.C4393b(new com.larus.kmp.voice_setting.voice.network.a(r110.f353984a, r110.f353985b, r110.f353986c, r110.f353987d), r109.f353994b);
    L21:
        if ((r108 instanceof com.larus.kmp.voice_setting.voice.network.b.a) == false) goto L24;
        return r108;
    L24:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        juc.d<ouc.i> r111 = ouc.i.Companion.serializer();
        r103.label = 1;
        r105 = b(r100, r101, r111, r103);
        if (r105 != r106) goto L17;
        return r106;
    L7:
        r103 = new UgcVoicePlatformKt$ugcVoicePostForAction$1(r102);
        goto L8
    }

    public static final Object d(String r100, Object r101, Continuation<? super com.larus.kmp.voice_setting.voice.network.b<ah9.e>> r102) {
        return b(r100, r101, ah9.e.Companion.serializer(), r102);
    }

    public static final Object e(String r100, Object r101, Continuation<? super com.larus.kmp.voice_setting.voice.network.b<SpeakerVoice>> r102) {
        return b(r100, r101, SpeakerVoice.Companion.serializer(), r102);
    }

    public static final <T> Object b(String r110, Object r111, juc.d<T> r112, Continuation<? super com.larus.kmp.voice_setting.voice.network.b<? extends T>> r113) {
        if ((r113 instanceof UgcVoicePlatformKt$ugcVoicePost$1) == false) goto L7;
        UgcVoicePlatformKt$ugcVoicePost$1 r100 = (UgcVoicePlatformKt$ugcVoicePost$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r114 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        Integer r104 = null;
        boolean r105 = true;
        String r115 = "";
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        r112 = (juc.d) r100.L$1;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r114);     // Catch: Exception -> L56
    L20:
        gd9.e r116 = (gd9.e) r114;     // Catch: Exception -> L56
        StringBuilder r117 = new StringBuilder("[network:raw] path=");     // Catch: Exception -> L56
        r117.append(r110);     // Catch: Exception -> L56
        r117.append(" httpSuccess=");     // Catch: Exception -> L56
        r117.append(r116.c());     // Catch: Exception -> L56
        r117.append(" status=");     // Catch: Exception -> L56
        r117.append(r116.f480966b);     // Catch: Exception -> L56
        r117.append(" message=");     // Catch: Exception -> L56
        String r106 = r116.f480969e;     // Catch: Exception -> L56
        if (r106 != null) goto L23;
        r106 = "";
    L23:
        r117.append(r106);     // Catch: Exception -> L56
        r117.append(" exception=");     // Catch: Exception -> L56
        Throwable r107 = r116.f480971g;     // Catch: Exception -> L56
        if (r107 == null) goto L26;
        String r108 = r107.getMessage();     // Catch: Exception -> L56
    L27:
        if (r108 != null) goto L29;
        r108 = "";
    L29:
        r117.append(r108);     // Catch: Exception -> L56
        a(r117.toString());     // Catch: Exception -> L56
        if (r116.c() == false) goto L42;
        com.larus.kmp.voice_setting.voice.network.a r118 = com.larus.kmp.voice_setting.voice.network.c.a(r116, r112);     // Catch: Exception -> L56
        StringBuilder r119 = new StringBuilder("[network:biz] path=");     // Catch: Exception -> L56
        r119.append(r110);     // Catch: Exception -> L56
        r119.append(" code=");     // Catch: Exception -> L56
        r119.append(r118.f353984a);     // Catch: Exception -> L56
        r119.append(" msg=");     // Catch: Exception -> L56
        String r109 = r118.f353985b;     // Catch: Exception -> L56
        if (r109 != null) goto L34;
        r109 = "";
    L34:
        r119.append(r109);     // Catch: Exception -> L56
        r119.append(" hasData=");     // Catch: Exception -> L56
        if (r118.f353987d != null) goto L38;
        r105 = false;
    L38:
        r119.append(r105);     // Catch: Exception -> L56
        a(r119.toString());     // Catch: Exception -> L56
        com.larus.kmp.voice_setting.voice.network.b.a r120 = com.larus.kmp.voice_setting.voice.network.c.b(r118, r116.f480971g);     // Catch: Exception -> L56
        if (r120 == null) goto L68;
        return r120;
    L68:
        return new com.larus.kmp.voice_setting.voice.network.b.C4393b(r118, r116.f480971g);
    L42:
        Integer r121 = Boxing.boxInt(r116.f480966b);     // Catch: Exception -> L56
        if (r121.intValue() != 0) goto L46;
        r105 = false;
    L46:
        if (r105 == false) goto L48;
        r104 = r121;
    L48:
        if (r104 == null) goto L50;
        int r122 = r104.intValue();     // Catch: Exception -> L56
    L51:
        String r123 = r116.f480969e;     // Catch: Exception -> L56
        if (r123 != null) goto L69;
        r123 = "";
    L69:
        return new com.larus.kmp.voice_setting.voice.network.b.a(r122, r123, r116.f480971g);
    L50:
        r122 = -1000;
        goto L51
    L26:
        r108 = null;
        goto L27
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r114);
        a("[network:start] path=" + r110 + " body=" + StringsKt.take(r111.toString(), 320));     // Catch: Exception -> L56
        CoroutineDispatcher r124 = Dispatchers.getIO();     // Catch: Exception -> L56
        UgcVoicePlatformKt$ugcVoicePost$result$1 r125 = new UgcVoicePlatformKt$ugcVoicePost$result$1(r110, r111, null);     // Catch: Exception -> L56
        r100.L$0 = r110;     // Catch: Exception -> L56
        r100.L$1 = r112;     // Catch: Exception -> L56
        r100.label = 1;     // Catch: Exception -> L56
        r114 = BuildersKt.withContext(r124, r125, r100);     // Catch: Exception -> L56
        if (r114 != r102) goto L20;
        return r102;
    L56:
        e = move-exception;
        StringBuilder r126 = new StringBuilder("[network:catch] path=");
        r126.append(r110);
        r126.append(" exception=");
        String r127 = e.getMessage();
        if (r127 != null) goto L60;
        r127 = "";
    L60:
        r126.append(r127);
        a(r126.toString());
        String r128 = e.getMessage();
        if (r128 == null) goto L65;
        r115 = r128;
    L65:
        return new com.larus.kmp.voice_setting.voice.network.b.a(-1000, r115, e);
    L7:
        r100 = new UgcVoicePlatformKt$ugcVoicePost$1(r113);
        goto L8
    }
}
