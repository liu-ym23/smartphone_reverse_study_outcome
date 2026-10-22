package no5;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayerAction;
import com.bytedance.ee.bear.tts.lynx.bean.TtsLynxPlayingState;
import com.bytedance.ee.bear.tts.tone.TtsToneBean;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mo5.j;
import po5.k;
import po5.m;
import po5.p;
import po5.r;
import po5.t;
import po5.u;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f519907a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<TtsLynxPlayerAction, po5.a> f519908b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<CCMLottieRes, String> f519909c = null;

    /* JADX INFO: renamed from: no5.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C6951a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f519910a = null;

        static {
            int[] r100 = new int[IPlayer.State.values().length];
            r100[IPlayer.State.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[IPlayer.State.BUFFERING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f519910a = r100;
        }
    }

    public a() {
    }

    static {
        f519907a = new a();
        f519908b = MapsKt.mapOf(new Pair[]{TuplesKt.to(TtsLynxPlayerAction.START_PLAYING, t.f530084b), TuplesKt.to(TtsLynxPlayerAction.RESUME, r.f530082b), TuplesKt.to(TtsLynxPlayerAction.PAUSE, po5.i.f530073b), TuplesKt.to(TtsLynxPlayerAction.CHANGE_SPEED, po5.e.f530069b), TuplesKt.to(TtsLynxPlayerAction.CHANGE_SPEAKER, po5.c.f530063b), TuplesKt.to(TtsLynxPlayerAction.REMOVE_ITEM, p.f530080b), TuplesKt.to(TtsLynxPlayerAction.ON_CLICK_FLOAT_VIEW, po5.g.f530071b), TuplesKt.to(TtsLynxPlayerAction.TERMINATE, u.f530085b), TuplesKt.to(TtsLynxPlayerAction.PLAY_PREVIOUS, m.f530077b), TuplesKt.to(TtsLynxPlayerAction.PLAY_NEXT, k.f530075b), TuplesKt.to(TtsLynxPlayerAction.OPEN_CONTENT, po5.f.f530070b), TuplesKt.to(TtsLynxPlayerAction.OPEN_PLAYLIST, po5.h.f530072b)});
        f519909c = MapsKt.mapOf(new Pair[]{TuplesKt.to(CCMLottieRes.SEA_WAVE, CustomHeaderConfig.COLOR_LIGHT), TuplesKt.to(CCMLottieRes.SINE_WAVE, "#1F2329"), TuplesKt.to(CCMLottieRes.FIREWORK, "#1F2329")});
    }

    public static FragmentActivity a() {
        Activity r100 = AppLifecycle.a.f408803a.f();
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L7:
        if (r101 == null) goto L9;
        tt5.a.h("TtsLynxModel", "findActivity, found topActivity: " + r101 + ", lifecycle: " + r101.getLifecycle().getCurrentState());
        return r101;
    L9:
        tt5.a.d("TtsLynxModel", "findActivity, no available FragmentActivity.");
        return null;
    L5:
        r101 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static oo5.e c(mo5.a r110) {
        if (r110 == null) goto L5;
        mo5.g r100 = mo5.h.e(r110);
    L6:
        oo5.e r101 = new oo5.e();
        if (r100 == null) goto L13;
        MutableLiveData r102 = r100.i();
        if (r102 == null) goto L13;
        j r103 = (j) r102.getValue();
        if (r103 == null) goto L13;
        String r104 = r103.f514586a;
    L14:
        r101.f524611a = r104;
        if (r110 == null) goto L67;
        List<mo5.g> r111 = mo5.h.d(r110);
        if (r111 == null) goto L67;
        Iterator<T> r112 = r111.iterator();
    L20:
        if (r112.hasNext() == false) goto L67;
        mo5.g r105 = (mo5.g) r112.next();
        j r106 = (j) r105.i().getValue();
        IPlayer.State r107 = (IPlayer.State) r105.u().getValue();
        if (r107 != null) goto L24;
        r107 = IPlayer.State.IDLE;
    L24:
        Long r108 = (Long) r105.o().getValue();
        long r109 = 0;
        if (r108 == null) goto L27;
        long r113 = r108.longValue();
    L28:
        Long r114 = (Long) r105.g().getValue();
        if (r114 == null) goto L31;
        r109 = r114.longValue();
    L31:
        oo5.b r115 = new oo5.b();
        if (r106 == null) goto L34;
        String r116 = r106.f514586a;
    L35:
        r115.f524586a = r116;
        if (r106 == null) goto L38;
        String r117 = r106.f514588c;
    L39:
        r115.f524587b = r117;
        if (r106 == null) goto L42;
        String r118 = r106.f514589d;
    L43:
        r115.f524588c = r118;
        if (r106 == null) goto L46;
        String r119 = r106.f514590e;
    L47:
        r115.f524589d = r119;
        r115.f524590e = r109 / 1000.0f;
        IPlayer.State r120 = IPlayer.State.PLAYING;
        if (r107 != r120) goto L50;
    L53:
        float r121 = r113 / 1000.0f;
    L54:
        r115.f524591f = r121;
        r115.f524592g = r105.l("TtsLynxModel-generatePlaylistParams").a();
        String r122 = r105.a();
        if (r100 == null) goto L57;
        String r123 = r100.a();
    L58:
        r115.f524593h = Intrinsics.areEqual(r122, r123);
        if (r105.u().getValue() != r120) goto L61;
        boolean r124 = true;
    L62:
        r115.f524594i = r124;
        StringBuilder r125 = new StringBuilder("generatePlaylistParams, title: ");
        r125.append(r115.f524587b);
        r125.append(", state: ");
        r125.append(r107);
        r125.append(", iconInfo(length): ");
        String r126 = r115.f524589d;
        if (r126 == null) goto L65;
        Integer r127 = Integer.valueOf(r126.length());
    L66:
        r125.append(r127);
        r125.append(", totalSeconds: ");
        r125.append(r115.f524590e);
        r125.append(", currentSeconds: ");
        r125.append(r115.f524591f);
        r125.append(", isEnabled: ");
        r125.append(r115.f524592g);
        r125.append(", isHighlighting: ");
        r125.append(r115.f524593h);
        r125.append(", isPlaying: ");
        r125.append(r115.f524594i);
        tt5.a.h("TtsLynxModel", r125.toString());
        r101.f524612b.add(r115);
        goto L20
    L65:
        r127 = null;
        goto L66
    L61:
        r124 = false;
        goto L62
    L57:
        r123 = null;
        goto L58
    L50:
        if ((r109 - r113) >= 500) goto L53;
        r121 = 0.0f;
        goto L54
    L46:
        r119 = null;
        goto L47
    L42:
        r118 = null;
        goto L43
    L38:
        r117 = null;
        goto L39
    L34:
        r116 = null;
        goto L35
    L27:
        r113 = 0;
    L67:
        return r101;
    L13:
        r104 = null;
        goto L14
    L5:
        r100 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static oo5.d b(mo5.a r100, oo5.a r101, oo5.c r110) {
        if (r100 == null) goto L59;
        mo5.g r102 = mo5.h.e(r100);
        if (r102 == null) goto L59;
        j r103 = (j) r102.i().getValue();
        oo5.d r104 = new oo5.d();
        Integer r105 = null;
        if (r103 == null) goto L10;
        String r106 = r103.f514586a;
    L11:
        r104.f524598a = r106;
        if (r103 == null) goto L14;
        String r107 = r103.f514588c;
    L15:
        r104.f524599b = r107;
        if (r103 == null) goto L18;
        String r108 = r103.f514589d;
    L19:
        r104.f524600c = r108;
        if (r103 == null) goto L22;
        String r109 = r103.f514590e;
    L23:
        r104.f524601d = r109;
        Long r111 = (Long) r102.g().getValue();
        float r112 = 0.0f;
        if (r111 == null) goto L26;
        float r113 = r111.longValue() / 1000.0f;
    L27:
        r104.f524602e = r113;
        Pair r114 = (Pair) r102.j().getValue();
        if (r114 == null) goto L30;
        Pair<Float, Float> r115 = new Pair(Float.valueOf(((Number) r114.getFirst()).floatValue() / 1000.0f), Float.valueOf(((Number) r114.getSecond()).floatValue() / 1000.0f));
    L31:
        r104.f524603f = r115;
        Long r116 = (Long) r102.o().getValue();
        if (r116 == null) goto L34;
        r112 = r116.longValue() / 1000.0f;
    L34:
        r104.f524604g = r112;
        a r117 = f519907a;
        IPlayer.State r118 = (IPlayer.State) r102.u().getValue();
        if (r118 != null) goto L37;
        r118 = IPlayer.State.IDLE;
    L37:
        r117.getClass();
        Intrinsics.checkNotNullParameter(r118, "ttsState");
        int r119 = C6951a.f519910a[r118.ordinal()];
        if (r119 != 1) goto L40;
        TtsLynxPlayingState r120 = TtsLynxPlayingState.PLAYING;
    L46:
        Intrinsics.checkNotNullParameter(r120, "<set-?>");
        r104.f524606i = r120;
        Float r121 = (Float) r102.r().getValue();
        if (r121 == null) goto L49;
        float r122 = r121.floatValue();
    L50:
        r104.f524607j = r122;
        r104.f524608k = r110;
        TtsToneBean r123 = (TtsToneBean) r102.v().getValue();
        if (r123 == null) goto L53;
        String r124 = r123.getToneId();
    L54:
        r104.f524609l = r124;
        r104.f524610m = r101;
        StringBuilder r125 = new StringBuilder("generatePlayerParams, title: ");
        r125.append(r104.f524599b);
        r125.append(", iconInfo(length): ");
        String r126 = r104.f524601d;
        if (r126 == null) goto L57;
        r105 = Integer.valueOf(r126.length());
    L57:
        r125.append(r105);
        r125.append(", totalSeconds: ");
        r125.append(r104.f524602e);
        r125.append(", loadedRangeSeconds: ");
        r125.append(r104.f524603f);
        r125.append(", currentSeconds: ");
        r125.append(r104.f524604g);
        r125.append(", lynxPlayingState: ");
        r125.append(r104.f524606i);
        r125.append(", speed: ");
        r125.append(r104.f524607j);
        r125.append(", coverInfo: ");
        r125.append(r104.f524608k);
        r125.append(", speakerId: ");
        r125.append(r104.f524609l);
        tt5.a.h("TtsLynxModel", r125.toString());
        return r104;
    L53:
        r124 = null;
        goto L54
    L49:
        r122 = 1.0f;
        goto L50
    L40:
        if (r119 != 2) goto L42;
    L44:
        r120 = TtsLynxPlayingState.LOADING;
        goto L46
    L42:
        if (r119 == 3) goto L44;
        r120 = TtsLynxPlayingState.NOT_PLAYING;
        goto L46
    L30:
        r115 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L31
    L26:
        r113 = 0.0f;
        goto L27
    L22:
        r109 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r107 = null;
        goto L15
    L10:
        r106 = null;
    L59:
        tt5.a.h("TtsLynxModel", "getPlayerInitParams, selectedVM is null, albumVM: " + r100);
        return new oo5.d();
    }
}
