package com.larus.audio.trace;

import com.larus.audio.u0;
import com.obric.trace.ObricActionBarTrackType;
import hq9.v;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import m58.h;
import m58.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f289814a = null;

    static {
        f289814a = new b();
    }

    public b() {
    }

    @Override // com.larus.audio.u0
    public final void a(v r100) {
        c r101 = c.f289815a;
        String r102 = r100.f486788d;
        String r103 = "";
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.e(r102);
        if (Intrinsics.areEqual(r100.f486791g, ObricActionBarTrackType.SPEAK) == true) goto L36;
        String r104 = r100.f486788d;
        if (r104 != null) goto L10;
        r104 = "";
    L10:
        JSONObject r105 = new JSONObject();
        String r106 = r100.f486785a;
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r105.put("bot_id", r106);
        String r107 = r100.f486786b;
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        r105.put("chat_type", r107);
        String r108 = r100.f486787c;
        if (r108 != null) goto L19;
        r108 = "";
    L19:
        r105.put("conversation_id", r108);
        String r109 = r100.f486788d;
        if (r109 != null) goto L22;
        r109 = "";
    L22:
        r105.put("local_msg_id", r109);
        String r110 = r100.f486788d;
        if (r110 != null) goto L25;
        r110 = "";
    L25:
        r105.put("asr_task_id", r110);
        String r111 = r100.f486791g;
        if (r111 != null) goto L28;
        r111 = "";
    L28:
        r105.put("scene", r111);
        Unit r112 = Unit.INSTANCE;
        r101.a(r104, r105);
        u r113 = h.f512141l;
        if (r113 == null) goto L37;
        String r114 = r100.f486788d;
        if (r114 == null) goto L34;
        r103 = r114;
    L34:
        r113.f(r103, "tts_touch_up_to_chat_first_pkg", null);
        return;
    L37:
        return;
    }
}
