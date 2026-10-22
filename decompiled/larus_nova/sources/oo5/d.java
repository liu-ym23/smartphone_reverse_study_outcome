package oo5;

import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerStyle;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayingState;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f524598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f524599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f524600c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f524601d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f524602e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Pair<Float, Float> f524603f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f524604g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TtsLynxPlayerStyle f524605h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TtsLynxPlayingState f524606i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f524607j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c f524608k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f524609l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public oo5.a f524610m;

    public static final class a {
    }

    static {
    }

    public final HashMap<String, Serializable> a() {
        HashMap<String, Serializable> r100 = new HashMap();
        String r101 = this.f524598a;     // Catch: Exception -> L30
        String r102 = "";
        if (r101 != null) goto L7;
        r101 = "";
    L7:
        r100.put("token", r101);     // Catch: Exception -> L30
        String r103 = this.f524599b;     // Catch: Exception -> L30
        if (r103 != null) goto L10;
        r103 = "";
    L10:
        r100.put("title", r103);     // Catch: Exception -> L30
        String r104 = this.f524600c;     // Catch: Exception -> L30
        if (r104 != null) goto L13;
        r104 = "";
    L13:
        r100.put("owner", r104);     // Catch: Exception -> L30
        String r105 = this.f524601d;     // Catch: Exception -> L30
        if (r105 != null) goto L16;
        r105 = "";
    L16:
        r100.put("iconInfo", r105);     // Catch: Exception -> L30
        r100.put("totalSeconds", Float.valueOf(this.f524602e));     // Catch: Exception -> L30
        Pair[] r106 = new Pair[2];     // Catch: Exception -> L30
        Pair<Float, Float> r107 = this.f524603f;     // Catch: Exception -> L30
        if (r107 == null) goto L19;
        Object r108 = Float.valueOf(r107.getFirst().floatValue());     // Catch: Exception -> L30
    L20:
        r106[0] = TuplesKt.to("start", r108);     // Catch: Exception -> L30
        Pair<Float, Float> r109 = this.f524603f;     // Catch: Exception -> L30
        if (r109 == null) goto L23;
        Object r110 = Float.valueOf(r109.getSecond().floatValue());     // Catch: Exception -> L30
    L24:
        r106[1] = TuplesKt.to("end", r110);     // Catch: Exception -> L30
        r100.put("loadedRange", MapsKt.hashMapOf(r106));     // Catch: Exception -> L30
        r100.put("currentSeconds", Float.valueOf(this.f524604g));     // Catch: Exception -> L30
        r100.put("style", Integer.valueOf(this.f524605h.getValue()));     // Catch: Exception -> L30
        r100.put("playingState", Integer.valueOf(this.f524606i.getValue()));     // Catch: Exception -> L30
        r100.put("speed", Float.valueOf(this.f524607j));     // Catch: Exception -> L30
        c r111 = this.f524608k;     // Catch: Exception -> L30
        if (r111 == null) goto L32;
        HashMap r112 = new HashMap();     // Catch: Exception -> L30
        r112.put("animationType", Integer.valueOf(r111.f524595a));     // Catch: Exception -> L30
        String r113 = r111.f524596b;     // Catch: Exception -> L30
        if (r113 != null) goto L29;
        r113 = "";
    L29:
        r112.put("titleColor", r113);     // Catch: Exception -> L30
        r112.put("titleFontSize", Integer.valueOf(r111.f524597c));     // Catch: Exception -> L30
    L33:
        r100.put("coverInfo", r112);     // Catch: Exception -> L30
        String r114 = this.f524609l;     // Catch: Exception -> L30
        if (r114 == null) goto L37;
        r102 = r114;
    L37:
        r100.put("speakerId", r102);     // Catch: Exception -> L30
        oo5.a r115 = this.f524610m;     // Catch: Exception -> L30
        if (r115 == null) goto L42;
        r100.put("width", Float.valueOf(r115.f524584a));     // Catch: Exception -> L30
        Serializable r116 = r100.put("height", Float.valueOf(r115.f524585b));     // Catch: Exception -> L30
    L42:
        return r100;
    L32:
        r112 = new HashMap();     // Catch: Exception -> L30
        goto L33
    L23:
        r110 = 0;     // Catch: Exception -> L30
        goto L24
    L19:
        r108 = 0;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        tt5.a.e("TtsLynxPlayerParams", "TtsLynxPlayerParams-toMap, error:", e, false);
        goto L42
    }

    public d() {
        this.f524605h = TtsLynxPlayerStyle.FULLSCREEN;
        this.f524606i = TtsLynxPlayingState.NOT_PLAYING;
        this.f524607j = 1.0f;
    }
}
