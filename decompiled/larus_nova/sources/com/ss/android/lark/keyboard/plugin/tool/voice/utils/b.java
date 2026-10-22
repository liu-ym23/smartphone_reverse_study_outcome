package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.larus.nova.R;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.storage.LarkKVStorage;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Integer> f430827a = null;

    public static boolean b() {
        if (KeyboardVoiceFGUtils.a("im.messenger.voice_input_polish", null) == true) goto L6;
        return true;
    L6:
        return LarkKVStorage.q(com.ss.android.lark.im.base.a.f425879a, true).getBoolean("user_voice_input_polish_enabled_local_key", true);
    }

    static {
        HashMap r100 = new HashMap();
        f430827a = r100;
        r100.put("zh_ch", Integer.valueOf(R.string.Lark_Chat_AudioToChinese));
        r100.put("en_us", Integer.valueOf(R.string.Lark_Chat_AudioToEnglish));
    }

    public static String a() {
        if (KeyboardVoiceModule.a().isEn() == false) goto L5;
        String r100 = "en_us";
    L6:
        String r101 = LarkKVStorage.q(com.ss.android.lark.im.base.a.f425879a, true).getString("user_audio_2_text_locale_server_key", r100);
        Log.i("ConfigHelper", "getAudioRecognizeLocale defaultLocale=" + r100 + ", result" + r101);
        return r101;
    L5:
        r100 = "zh_ch";
        goto L6
    }

    public static void c(String r100) {
        LarkKVStorage.q(com.ss.android.lark.im.base.a.f425879a, true).putString("user_audio_2_text_locale_local_key", r100);
    }
}
