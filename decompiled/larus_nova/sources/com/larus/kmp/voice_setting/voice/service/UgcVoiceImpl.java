package com.larus.kmp.voice_setting.voice.service;

import com.hihonor.honorid.core.data.UserInfo;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.kmp.voice_setting.voice.feature.UgcVoiceRepository;
import com.larus.kmp.voice_setting.voice.feature.w0;
import com.larus.kmp.voice_setting.voice.network.b;
import com.larus.tts.impl.ChatTitleTtsComponent;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import p2a.f;
import p2a.j;
import p2a.k;
import p2a.m;
import p2a.o;

/* JADX INFO: loaded from: classes4.dex */
public final class UgcVoiceImpl implements f {
    public UgcVoiceImpl() {
    }

    @Override // p2a.f
    public final List<SpeakerVoice> D1() {
        UgcVoiceRepository.f353283a.getClass();
        return UgcVoiceRepository.o();
    }

    @Override // p2a.f
    public final void Z() {
        UgcVoiceRepository.f353283a.g();
    }

    @Override // p2a.f
    public final void N(ChatTitleTtsComponent.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        UgcVoiceRepository.f353283a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        w0 r101 = UgcVoiceRepository.f353286d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        ((ArrayList) r101.f353369b).remove(r100);
    }

    @Override // p2a.f
    public final void O(ChatTitleTtsComponent.f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        UgcVoiceRepository.f353283a.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        w0 r101 = UgcVoiceRepository.f353286d;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (((ArrayList) r101.f353369b).contains(r100) == true) goto L6;
        ((ArrayList) r101.f353369b).add(r100);
        return;
    }

    @Override // p2a.f
    public final void b2(String r100) {
        Intrinsics.checkNotNullParameter(r100, UserInfo.LANGUAGECODE);
        UgcVoiceRepository.f353283a.getClass();
        UgcVoiceRepository.r(r100);
    }

    @Override // p2a.f
    public final void R(String r100, String r101) {
        UgcVoiceRepository.f353283a.getClass();
        UgcVoiceRepository.w(r100, r101);
    }

    @Override // p2a.f
    public final void d1(k r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "param");
        UgcVoiceRepository.f353283a.s(a.a(r100), true, r101);
    }

    @Override // p2a.f
    public final Object F1(w2a.f r100, String r101, Continuation<? super SpeakerVoice> r102) {
        return UgcVoiceRepository.f353283a.j(r100, r101, r102);
    }

    @Override // p2a.f
    public final Object y2(w2a.f r100, String r101, String r110, String r111, Continuation<? super m<SpeakerVoice>> r112) {
        if ((r112 instanceof UgcVoiceImpl$saveUserVoice$1) == false) goto L7;
        UgcVoiceImpl$saveUserVoice$1 r102 = (UgcVoiceImpl$saveUserVoice$1) r112;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        UgcVoiceImpl$saveUserVoice$1 r104 = r102;
        Object r113 = r104.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r104.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        b r114 = (b) r113;
        if ((r114 instanceof b.C4393b) == false) goto L21;
        com.larus.kmp.voice_setting.voice.network.a<T> r107 = ((b.C4393b) r114).f353993a;
        return new o(r107.f353987d, r107.f353986c, r107.f353985b, Long.valueOf(r107.f353984a));
    L21:
        if ((r114 instanceof b.a) == false) goto L29;
        b.a r115 = (b.a) r114;
        long r108 = r115.f353990a;
        String r109 = r115.f353991b;
        Throwable r116 = r115.f353992c;
        if (r116 == null) goto L25;
        String r117 = r116.getMessage();
    L27:
        return new j(r108, r109, r117, null);
    L25:
        r117 = null;
        goto L27
    L29:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        UgcVoiceRepository r118 = UgcVoiceRepository.f353283a;
        r104.label = 1;
        r113 = r118.A(r100, r101, r110, r111, r104);
        if (r113 != r105) goto L17;
        return r105;
    L7:
        r102 = new UgcVoiceImpl$saveUserVoice$1(this, r112);
        goto L8
    }
}
