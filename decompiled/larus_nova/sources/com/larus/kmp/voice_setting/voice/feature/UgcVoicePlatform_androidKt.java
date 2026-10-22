package com.larus.kmp.voice_setting.voice.feature;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class UgcVoicePlatform_androidKt {
    public static final Object a(String r110, String r111, String r112, Map<String, String> r113, Continuation<? super com.larus.kmp.voice_setting.voice.network.b<ah9.f>> r114) {
        if ((r114 instanceof UgcVoicePlatform_androidKt$ugcVoiceUploadFile$1) == false) goto L7;
        UgcVoicePlatform_androidKt$ugcVoiceUploadFile$1 r100 = (UgcVoicePlatform_androidKt$ugcVoiceUploadFile$1) r114;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        UgcVoicePlatform_androidKt$ugcVoiceUploadFile$1 r102 = r100;
        Object r115 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r115);
    L17:
        com.larus.network.http.a r116 = (com.larus.network.http.a) r115;
        if ((r116 instanceof com.larus.network.http.y) == false) goto L25;
        com.larus.network.http.y r117 = (com.larus.network.http.y) r116;
        Long r118 = r117.f360205g;
        if (r118 == null) goto L22;
        long r105 = r118.longValue();
    L32:
        return new com.larus.kmp.voice_setting.voice.network.b.C4393b(new com.larus.kmp.voice_setting.voice.network.a(r105, r117.f360204f, r117.f360136c, r117.f360135b), null);
    L22:
        r105 = 0;
        goto L32
    L25:
        if ((r116 instanceof com.larus.network.http.f) == false) goto L31;
        com.larus.network.http.f r119 = (com.larus.network.http.f) r116;
        int r120 = (int) r119.f360157d.getCode();
        String r121 = r119.f360157d.getMessage();
        if (r121 != null) goto L33;
        r121 = "";
    L33:
        return new com.larus.kmp.voice_setting.voice.network.b.a(r120, r121, r119.f360157d);
    L31:
        return new com.larus.kmp.voice_setting.voice.network.b.a(-1000, "unexpected async state", null);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r115);
        r102.label = 1;
        r115 = HttpExtKt.f(ServiceType.UGC, ah9.f.class, r110, r111, r112, r113, null, r102, 64);
        if (r115 != r103) goto L17;
        return r103;
    L7:
        r100 = new UgcVoicePlatform_androidKt$ugcVoiceUploadFile$1(r114);
        goto L8
    }
}
