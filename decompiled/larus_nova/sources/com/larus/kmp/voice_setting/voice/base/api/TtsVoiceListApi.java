package com.larus.kmp.voice_setting.voice.base.api;

import com.larus.kmp.voice_setting.voice.network.FlowHttpConnection;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes30.dex */
public final class TtsVoiceListApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f351763a = 0;

    static {
    }

    public TtsVoiceListApi() {
    }

    public static Object b(int r100, int r101, String r110, Continuation r111) {
        return FlowHttpConnection.f353982a.a(new TtsVoiceListApi$requestRecommendVoiceList$2(r100, r101, 1, r110, null), r111);
    }

    public static Object a(int r100, int r101, String r110, String r111, Continuation r112) {
        return FlowHttpConnection.f353982a.a(new TtsVoiceListApi$requestOtherVoiceList$2(r100, r101, r110, r111, null), r112);
    }
}
