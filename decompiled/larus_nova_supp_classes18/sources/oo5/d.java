package oo5;

import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerStyle;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayingState;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public String a;
    public String b;
    public String c;
    public String d;
    public float e;
    public Pair<Float, Float> f;
    public float g;
    public TtsLynxPlayerStyle h;
    public TtsLynxPlayingState i;
    public float j;
    public c k;
    public String l;
    public oo5.a m;

    public static final class a {
    }

    static {
    }

    public final HashMap<String, Serializable> a() {
        HashMap<String, Serializable> r0 = new HashMap();
        String r3 = this.a;     // Catch: Exception -> L30
        String r4 = "";
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r0.put(ResourceData.KEY_TOKEN, r3);     // Catch: Exception -> L30
        String r5 = this.b;     // Catch: Exception -> L30
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.put("title", r5);     // Catch: Exception -> L30
        String r6 = this.c;     // Catch: Exception -> L30
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r0.put("owner", r6);     // Catch: Exception -> L30
        String r7 = this.d;     // Catch: Exception -> L30
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r0.put("iconInfo", r7);     // Catch: Exception -> L30
        r0.put("totalSeconds", Float.valueOf(this.e));     // Catch: Exception -> L30
        Pair[] r8 = new Pair[2];     // Catch: Exception -> L30
        Pair<Float, Float> r9 = this.f;     // Catch: Exception -> L30
        if (r9 == null) goto L19;
        Object r10 = Float.valueOf(((Number) r9.getFirst()).floatValue());     // Catch: Exception -> L30
    L20:
        r8[0] = TuplesKt.to("start", r10);     // Catch: Exception -> L30
        Pair<Float, Float> r11 = this.f;     // Catch: Exception -> L30
        if (r11 == null) goto L23;
        Object r12 = Float.valueOf(((Number) r11.getSecond()).floatValue());     // Catch: Exception -> L30
    L24:
        r8[1] = TuplesKt.to("end", r12);     // Catch: Exception -> L30
        r0.put("loadedRange", MapsKt.hashMapOf(r8));     // Catch: Exception -> L30
        r0.put("currentSeconds", Float.valueOf(this.g));     // Catch: Exception -> L30
        r0.put("style", Integer.valueOf(this.h.getValue()));     // Catch: Exception -> L30
        r0.put("playingState", Integer.valueOf(this.i.getValue()));     // Catch: Exception -> L30
        r0.put("speed", Float.valueOf(this.j));     // Catch: Exception -> L30
        c r13 = this.k;     // Catch: Exception -> L30
        if (r13 == null) goto L32;
        HashMap r14 = new HashMap();     // Catch: Exception -> L30
        r14.put("animationType", Integer.valueOf(r13.a));     // Catch: Exception -> L30
        String r15 = r13.b;     // Catch: Exception -> L30
        if (r15 != null) goto L29;
        r15 = "";
    L29:
        r14.put("titleColor", r15);     // Catch: Exception -> L30
        r14.put("titleFontSize", Integer.valueOf(r13.c));     // Catch: Exception -> L30
    L33:
        r0.put("coverInfo", r14);     // Catch: Exception -> L30
        String r16 = this.l;     // Catch: Exception -> L30
        if (r16 == null) goto L37;
        r4 = r16;
    L37:
        r0.put("speakerId", r4);     // Catch: Exception -> L30
        oo5.a r2 = this.m;     // Catch: Exception -> L30
        if (r2 == null) goto L42;
        r0.put("width", Float.valueOf(r2.a));     // Catch: Exception -> L30
        Serializable r17 = r0.put("height", Float.valueOf(r2.b));     // Catch: Exception -> L30
    L42:
        return r0;
    L32:
        r14 = new HashMap();     // Catch: Exception -> L30
        goto L33
    L23:
        r12 = 0;     // Catch: Exception -> L30
        goto L24
    L19:
        r10 = 0;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        tt5.a.e("TtsLynxPlayerParams", "TtsLynxPlayerParams-toMap, error:", e, false);
        goto L42
    }

    public d() {
        this.h = TtsLynxPlayerStyle.FULLSCREEN;
        this.i = TtsLynxPlayingState.NOT_PLAYING;
        this.j = 1.0f;
    }
}
