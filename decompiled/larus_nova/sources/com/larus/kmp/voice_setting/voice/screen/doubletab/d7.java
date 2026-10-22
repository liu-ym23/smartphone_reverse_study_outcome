package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class d7 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e7 f354249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpeakerVoice f354250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f354251c;

    public /* synthetic */ d7(e7 r100, SpeakerVoice r101, long r102) {
        this.f354249a = r100;
        this.f354250b = r101;
        this.f354251c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        e7 r100 = this.f354249a;
        SpeakerVoice r101 = this.f354250b;
        long r102 = this.f354251c;
        r100.f354285h.invoke(r101.getId(), Long.valueOf(r102));
        return Unit.INSTANCE;
    }
}
