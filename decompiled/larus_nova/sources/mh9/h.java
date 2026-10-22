package mh9;

import com.larus.im.bean.bot.SpeakerVoice;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514002a = 0;

    static {
    }

    public static void a(String r100, final String r101, final String r102, final SpeakerVoice r103) {
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "enterMethod");
        Intrinsics.checkNotNullParameter(r102, "botId");
        com.larus.kmp.voice_setting.voice.utils.k r104 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.b(r100);
        r104.b(new c(r101, r102, r103));
        r104.f355107d = CollectionsKt.listOf("VoiceChange");
        com.larus.kmp.voice_setting.voice.utils.k.a(r104);
    }
}
