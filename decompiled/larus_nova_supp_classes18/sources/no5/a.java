package no5;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final a a = null;
    public static final Map<TtsLynxPlayerAction, po5.a> b = null;
    public static final Map<CCMLottieRes, String> c = null;

    /* JADX INFO: renamed from: no5.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0275a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[IPlayer.State.values().length];
            r0[IPlayer.State.PLAYING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[IPlayer.State.PREPARING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[IPlayer.State.BUFFERING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public a() {
    }

    static {
        a = new a();
        b = MapsKt.mapOf(new Pair[]{TuplesKt.to(TtsLynxPlayerAction.START_PLAYING, t.b), TuplesKt.to(TtsLynxPlayerAction.RESUME, r.b), TuplesKt.to(TtsLynxPlayerAction.PAUSE, po5.i.b), TuplesKt.to(TtsLynxPlayerAction.CHANGE_SPEED, po5.e.b), TuplesKt.to(TtsLynxPlayerAction.CHANGE_SPEAKER, po5.c.b), TuplesKt.to(TtsLynxPlayerAction.REMOVE_ITEM, p.b), TuplesKt.to(TtsLynxPlayerAction.ON_CLICK_FLOAT_VIEW, po5.g.b), TuplesKt.to(TtsLynxPlayerAction.TERMINATE, u.b), TuplesKt.to(TtsLynxPlayerAction.PLAY_PREVIOUS, m.b), TuplesKt.to(TtsLynxPlayerAction.PLAY_NEXT, k.b), TuplesKt.to(TtsLynxPlayerAction.OPEN_CONTENT, po5.f.b), TuplesKt.to(TtsLynxPlayerAction.OPEN_PLAYLIST, po5.h.b)});
        c = MapsKt.mapOf(new Pair[]{TuplesKt.to(CCMLottieRes.SEA_WAVE, "#FFFFFF"), TuplesKt.to(CCMLottieRes.SINE_WAVE, "#1F2329"), TuplesKt.to(CCMLottieRes.FIREWORK, "#1F2329")});
    }

    public static FragmentActivity a() {
        FragmentActivity r0 = AppLifecycle.a.a.f();
        if ((r0 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r1 = r0;
    L7:
        if (r1 == null) goto L9;
        tt5.a.h("TtsLynxModel", "findActivity, found topActivity: " + r1 + ", lifecycle: " + r1.getLifecycle().getCurrentState());
        return r1;
    L9:
        tt5.a.d("TtsLynxModel", "findActivity, no available FragmentActivity.");
        return null;
    L5:
        r1 = null;
        goto L7
    }

    public static oo5.e c(mo5.a r15) {
        if (r15 == null) goto L5;
        mo5.g r1 = mo5.h.e(r15);
    L6:
        oo5.e r2 = new oo5.e();
        if (r1 == null) goto L13;
        MutableLiveData r3 = r1.i();
        if (r3 == null) goto L13;
        j r4 = (j) r3.getValue();
        if (r4 == null) goto L13;
        String r5 = r4.a;
    L14:
        r2.a = r5;
        if (r15 == null) goto L67;
        List<mo5.g> r16 = mo5.h.d(r15);
        if (r16 == null) goto L67;
        Iterator<T> r17 = r16.iterator();
    L20:
        if (r17.hasNext() == false) goto L67;
        mo5.g r6 = (mo5.g) r17.next();
        j r7 = (j) r6.i().getValue();
        IPlayer.State r8 = (IPlayer.State) r6.u().getValue();
        if (r8 != null) goto L24;
        r8 = IPlayer.State.IDLE;
    L24:
        Long r9 = (Long) r6.o().getValue();
        long r10 = 0;
        if (r9 == null) goto L27;
        long r11 = r9.longValue();
    L28:
        Long r12 = (Long) r6.g().getValue();
        if (r12 == null) goto L31;
        r10 = r12.longValue();
    L31:
        oo5.b r13 = new oo5.b();
        if (r7 == null) goto L34;
        String r14 = r7.a;
    L35:
        r13.a = r14;
        if (r7 == null) goto L38;
        String r18 = r7.c;
    L39:
        r13.b = r18;
        if (r7 == null) goto L42;
        String r19 = r7.d;
    L43:
        r13.c = r19;
        if (r7 == null) goto L46;
        String r20 = r7.e;
    L47:
        r13.d = r20;
        r13.e = r10 / 1000.0f;
        IPlayer.State r21 = IPlayer.State.PLAYING;
        if (r8 != r21) goto L50;
    L53:
        float r22 = r11 / 1000.0f;
    L54:
        r13.f = r22;
        r13.g = r6.l("TtsLynxModel-generatePlaylistParams").a();
        String r23 = r6.a();
        if (r1 == null) goto L57;
        String r24 = r1.a();
    L58:
        r13.h = Intrinsics.areEqual(r23, r24);
        if (r6.u().getValue() != r21) goto L61;
        boolean r25 = true;
    L62:
        r13.i = r25;
        StringBuilder r26 = new StringBuilder("generatePlaylistParams, title: ");
        r26.append(r13.b);
        r26.append(", state: ");
        r26.append(r8);
        r26.append(", iconInfo(length): ");
        String r27 = r13.d;
        if (r27 == null) goto L65;
        Integer r28 = Integer.valueOf(r27.length());
    L66:
        r26.append(r28);
        r26.append(", totalSeconds: ");
        r26.append(r13.e);
        r26.append(", currentSeconds: ");
        r26.append(r13.f);
        r26.append(", isEnabled: ");
        r26.append(r13.g);
        r26.append(", isHighlighting: ");
        r26.append(r13.h);
        r26.append(", isPlaying: ");
        r26.append(r13.i);
        tt5.a.h("TtsLynxModel", r26.toString());
        r2.b.add(r13);
        goto L20
    L65:
        r28 = null;
        goto L66
    L61:
        r25 = false;
        goto L62
    L57:
        r24 = null;
        goto L58
    L50:
        if ((r10 - r11) >= 500) goto L53;
        r22 = 0.0f;
        goto L54
    L46:
        r20 = null;
        goto L47
    L42:
        r19 = null;
        goto L43
    L38:
        r18 = null;
        goto L39
    L34:
        r14 = null;
        goto L35
    L27:
        r11 = 0;
    L67:
        return r2;
    L13:
        r5 = null;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public static oo5.d b(mo5.a r8, oo5.a r9, oo5.c r10) {
        if (r8 == null) goto L59;
        mo5.g r1 = mo5.h.e(r8);
        if (r1 == null) goto L59;
        j r11 = (j) r1.i().getValue();
        oo5.d r2 = new oo5.d();
        Integer r3 = null;
        if (r11 == null) goto L10;
        String r4 = r11.a;
    L11:
        r2.a = r4;
        if (r11 == null) goto L14;
        String r5 = r11.c;
    L15:
        r2.b = r5;
        if (r11 == null) goto L18;
        String r6 = r11.d;
    L19:
        r2.c = r6;
        if (r11 == null) goto L22;
        String r12 = r11.e;
    L23:
        r2.d = r12;
        Long r13 = (Long) r1.g().getValue();
        float r7 = 0.0f;
        if (r13 == null) goto L26;
        float r14 = r13.longValue() / 1000.0f;
    L27:
        r2.e = r14;
        Pair r15 = (Pair) r1.j().getValue();
        if (r15 == null) goto L30;
        Pair<Float, Float> r16 = new Pair(Float.valueOf(((Number) r15.getFirst()).floatValue() / 1000.0f), Float.valueOf(((Number) r15.getSecond()).floatValue() / 1000.0f));
    L31:
        r2.f = r16;
        Long r17 = (Long) r1.o().getValue();
        if (r17 == null) goto L34;
        r7 = r17.longValue() / 1000.0f;
    L34:
        r2.g = r7;
        a r18 = a;
        IPlayer.State r19 = (IPlayer.State) r1.u().getValue();
        if (r19 != null) goto L37;
        r19 = IPlayer.State.IDLE;
    L37:
        r18.getClass();
        Intrinsics.checkNotNullParameter(r19, "ttsState");
        int r20 = C0275a.a[r19.ordinal()];
        if (r20 != 1) goto L40;
        TtsLynxPlayingState r21 = TtsLynxPlayingState.PLAYING;
    L46:
        Intrinsics.checkNotNullParameter(r21, "<set-?>");
        r2.i = r21;
        Float r22 = (Float) r1.r().getValue();
        if (r22 == null) goto L49;
        float r23 = r22.floatValue();
    L50:
        r2.j = r23;
        r2.k = r10;
        TtsToneBean r24 = (TtsToneBean) r1.v().getValue();
        if (r24 == null) goto L53;
        String r25 = r24.getToneId();
    L54:
        r2.l = r25;
        r2.m = r9;
        StringBuilder r26 = new StringBuilder("generatePlayerParams, title: ");
        r26.append(r2.b);
        r26.append(", iconInfo(length): ");
        String r27 = r2.d;
        if (r27 == null) goto L57;
        r3 = Integer.valueOf(r27.length());
    L57:
        r26.append(r3);
        r26.append(", totalSeconds: ");
        r26.append(r2.e);
        r26.append(", loadedRangeSeconds: ");
        r26.append(r2.f);
        r26.append(", currentSeconds: ");
        r26.append(r2.g);
        r26.append(", lynxPlayingState: ");
        r26.append(r2.i);
        r26.append(", speed: ");
        r26.append(r2.j);
        r26.append(", coverInfo: ");
        r26.append(r2.k);
        r26.append(", speakerId: ");
        r26.append(r2.l);
        tt5.a.h("TtsLynxModel", r26.toString());
        return r2;
    L53:
        r25 = null;
        goto L54
    L49:
        r23 = 1.0f;
        goto L50
    L40:
        if (r20 != 2) goto L42;
    L44:
        r21 = TtsLynxPlayingState.LOADING;
        goto L46
    L42:
        if (r20 == 3) goto L44;
        r21 = TtsLynxPlayingState.NOT_PLAYING;
        goto L46
    L30:
        r16 = new Pair(Float.valueOf(0.0f), Float.valueOf(0.0f));
        goto L31
    L26:
        r14 = 0.0f;
        goto L27
    L22:
        r12 = null;
        goto L23
    L18:
        r6 = null;
        goto L19
    L14:
        r5 = null;
        goto L15
    L10:
        r4 = null;
    L59:
        tt5.a.h("TtsLynxModel", "getPlayerInitParams, selectedVM is null, albumVM: " + r8);
        return new oo5.d();
    }
}
