package mh9;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f514018a = 0;

    static {
    }

    public static void a(final com.larus.kmp.voice_setting.voice.editvoice.b r100, final Object r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        com.larus.kmp.voice_setting.voice.utils.k r103 = com.larus.kmp.voice_setting.voice.utils.m.f355113a.a("request conf_preview_create failed");
        r103.b(new l(r100, r101, r102));
        r103.f355107d = CollectionsKt.listOf("VoicePlay");
        com.larus.kmp.voice_setting.voice.utils.k.a(r103);
    }
}
