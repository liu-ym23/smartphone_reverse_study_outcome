package e68;

import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.larus.audio.settings.audio.data.AudioRetransmitStrategy;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import m58.b;
import m58.h;
import m58.w;

/* JADX INFO: loaded from: classes24.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f471149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f471150b;

    /* JADX INFO: renamed from: e68.a$a, reason: collision with other inner class name */
    public static final class C5747a {
    }

    static {
    }

    public final Map<String, Object> a() {
        Pair[] r100 = new Pair[7];
        Pair r101 = TuplesKt.to("bot_id", this.f471150b);
        boolean r102 = false;
        r100[0] = r101;
        x58.a r103 = h.f512130a;
        w r104 = h.f512135f;
        String r105 = "";
        if (r104 == null) goto L6;
        String r106 = r104.getNetworkAccessType();
        if (r106 == null) goto L6;
    L7:
        r100[1] = TuplesKt.to("network", r106);
        r100[2] = TuplesKt.to(SpeechEngineDefines.PARAMS_KEY_ASR_LANGUAGE_STRING, this.f471149a);
        w r107 = h.f512135f;
        if (r107 == null) goto L13;
        String r108 = r107.getCurrentNetworkStatus();
        if (r108 == null) goto L13;
        r105 = r108;
    L13:
        r100[3] = TuplesKt.to("network_status", r105);
        r100[4] = TuplesKt.to("new_arch", "arch-v3");
        x58.a r109 = h.f512130a;
        if (r109 == null) goto L20;
        AudioRetransmitStrategy r110 = r109.f562538l;
        if (r110 == null) goto L20;
        t78.a r111 = r110.getData();
        if (r111 == null) goto L20;
        Boolean r112 = Boolean.valueOf(r111.a());
    L21:
        r100[5] = TuplesKt.to("enable_retransmit", String.valueOf(r112));
        b r113 = h.f512140k;
        if (r113 != null) goto L24;
    L26:
        if (r102 == false) goto L28;
        String r114 = "background";
    L29:
        r100[6] = TuplesKt.to("app_status", r114);
        return MapsKt.mapOf(r100);
    L28:
        r114 = "foreground";
        goto L29
    L24:
        if (r113.isAppBackground() != true) goto L26;
        r102 = true;
    L20:
        r112 = null;
    L6:
        r106 = "";
        goto L7
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "mAsrLanguage");
        Intrinsics.checkNotNullParameter(r101, "botId");
        this.f471149a = r100;
        this.f471150b = r101;
    }
}
