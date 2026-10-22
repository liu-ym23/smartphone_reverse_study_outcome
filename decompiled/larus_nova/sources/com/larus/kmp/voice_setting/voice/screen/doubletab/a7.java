package com.larus.kmp.voice_setting.voice.screen.doubletab;

import com.larus.kmp.voice_setting.platform.VoiceStringKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class a7 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e7 f354198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f354199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Long f354200c;

    public /* synthetic */ a7(e7 r100, String r101, Long r102) {
        this.f354198a = r100;
        this.f354199b = r101;
        this.f354200c = r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        e7 r100 = this.f354198a;
        String r101 = this.f354199b;
        Long r102 = this.f354200c;
        r100.f354285h.invoke(r101, r102);
        r100.f354286i.invoke(VoiceStringKey.LARUS_MODIFY_BOT_VOICE_FAILED_TOAST);
        return Unit.INSTANCE;
    }
}
