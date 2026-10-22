package com.larus.voice_setting.voice;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class v0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleTtsSpeakerSettingFragment f377044a;

    public /* synthetic */ v0(SingleTtsSpeakerSettingFragment r100) {
        this.f377044a = r100;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        SingleTtsSpeakerSettingFragment r100 = this.f377044a;
        int r101 = SingleTtsSpeakerSettingFragment.f376249y;
        p2a.q.a().stopAudio();
        SingleTtsSpeakerSettingFragment.Z90(r100, false, null, null, 15);
        com.larus.voice_setting.voice.base.g1 r102 = com.larus.voice_setting.voice.base.g1.f376420a;
        String r103 = r100.f376260o;
        com.larus.voice_setting.voice.base.g1.c(r103, r100, r103, new JSONObject(), null);
        return Unit.INSTANCE;
    }
}
