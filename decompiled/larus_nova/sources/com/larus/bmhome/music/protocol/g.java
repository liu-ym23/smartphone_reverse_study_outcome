package com.larus.bmhome.music.protocol;

import com.larus.network.http.HttpExtKt;
import com.larus.network.http.ServiceType;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class g {
    public static final Object a(String r110, String r111, Continuation<? super com.larus.network.http.a<BigMusicLyrics>> r112) {
        JSONObject r100 = new JSONObject();
        if (r110 == null) goto L5;
        r100.put(EventConstant.Key.RETAIN_PROMPT, r110);
    L5:
        if (r111 == null) goto L7;
        r100.put("instruction_options", r111);
    L7:
        Unit r113 = Unit.INSTANCE;
        return HttpExtKt.k(ServiceType.UGC, BigMusicLyrics.class, "/alice/media/bigmusic/lyrics", r100, null, null, false, null, null, null, r112, 1008);
    }
}
