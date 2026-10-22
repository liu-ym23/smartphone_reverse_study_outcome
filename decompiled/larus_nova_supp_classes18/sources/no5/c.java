package no5;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.ee.util.ui.n;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public final String a;
    public final Context b;
    public final mo5.a c;
    public oo5.a d;
    public oo5.c e;
    public Runnable f;
    public final C0276c g;
    public final b h;
    public final d i;
    public final e j;
    public final j k;
    public final g l;
    public final h m;
    public final i n;
    public final f o;
    public CCMLynxCardView p;
    public int q;
    public int r;
    public int s;
    public int t;
    public float u;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ c a;

        public b(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            List r4 = (List) r3;
            Intrinsics.checkNotNullParameter(r4, "itemList");
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] albumItemListObserver, itemList: " + r4);
            c.b(this.a);
            c.c(this.a);
        }
    }

    /* JADX INFO: renamed from: no5.c$c, reason: collision with other inner class name */
    public static final class C0276c<T> implements Observer {
        public final /* synthetic */ c a;

        public C0276c(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            mo5.i r6 = (mo5.i) r5;
            Intrinsics.checkNotNullParameter(r6, "change");
            c r0 = this.a;
            if (r0.p != null) goto L5;
            tt5.a.k("TtsLynxViewModel", "[" + this.a.a + "] albumItemSelectionObserver, lynxView is null.");
            return;
        L5:
            r0.f((mo5.g) r6.a);
            c r1 = this.a;
            mo5.g r7 = (mo5.g) r6.b;
            r1.getClass();
            if (r7 != null) goto L8;
            tt5.a.d("TtsLynxViewModel", "[" + r1.a + "] startItemObserver, itemVM is null.");
        L9:
            c.a(this.a);
            return;
        L8:
            r7.i().observeForever(r1.j);
            r7.u().observeForever(r1.k);
            r7.o().observeForever(r1.l);
            r7.r().observeForever(r1.m);
            r7.g().observeForever(r1.n);
            r7.j().observeForever(r1.o);
            goto L9
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            mo5.g r4 = (mo5.g) r3;
            Intrinsics.checkNotNullParameter(r4, "itemVM");
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] albumItemUpdateObserver, itemVM: " + r4);
            c.b(this.a);
            c.c(this.a);
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            mo5.j r4 = (mo5.j) r3;
            Intrinsics.checkNotNullParameter(r4, "itemInfo");
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] itemInfoObserver, itemInfo: " + r4);
            c.b(this.a);
            c.c(this.a);
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ c a;

        public f(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            Intrinsics.checkNotNullParameter(r4, "timeRangeMs");
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] playableRangeObserver, timeRangeMs: " + r4);
            c.b(this.a);
            c.c(this.a);
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ c a;

        public g(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r8) {
            ((Number) r8).longValue();
            c r9 = this.a;
            CCMLynxCardView r0 = r9.p;
            if (r0 != null) goto L5;
            tt5.a.k("TtsLynxViewModel", "[" + r9.a + "] updateLynxProgress, lynxView is null.");
            return;
        L5:
            no5.a r1 = no5.a.a;
            mo5.a r10 = r9.c;
            r1.getClass();
            if (r10 == null) goto L22;
            mo5.g r2 = mo5.h.e(r10);
            if (r2 == null) goto L22;
            oo5.f r11 = new oo5.f();
            mo5.j r3 = (mo5.j) r2.i().getValue();
            String r4 = null;
            if (r3 == null) goto L13;
            String r5 = r3.a;
        L14:
            r11.a = r5;
            Long r6 = (Long) r2.o().getValue();
            if (r6 == null) goto L17;
            float r7 = r6.longValue() / 1000.0f;
        L18:
            r11.b = r7;
            StringBuilder r12 = new StringBuilder("generateProgressParams, title: ");
            mo5.j r13 = (mo5.j) r2.i().getValue();
            if (r13 == null) goto L21;
            r4 = r13.c;
        L21:
            r12.append(r4);
            r12.append(", state: ");
            r12.append(r2.u().getValue());
            r12.append(", progress: ");
            r12.append(r11.b);
            tt5.a.b("TtsLynxModel", r12.toString());
        L23:
            JSONObject r14 = new JSONObject();
            r14.putOpt(ResourceData.KEY_TOKEN, r11.a);
            r14.putOpt("currentSeconds", Float.valueOf(r11.b));
            r0.sendEvent("update_progress", CollectionsKt.listOf(r14.toString()));
            return;
        L17:
            r7 = 0.0f;
            goto L18
        L13:
            r5 = null;
        L22:
            tt5.a.h("TtsLynxModel", "generateProgressParams, selectedVM is null, albumVM: " + r10);
            r11 = new oo5.f();
            goto L23
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ c a;

        public h(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] playerSpeedObserver, speed: " + ((Number) r3).floatValue());
            c.b(this.a);
            c.c(this.a);
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ c a;

        public i(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] totalDurationObserver, totalDurationMs: " + ((Number) r4).longValue());
            c.b(this.a);
            c.c(this.a);
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ c a;

        public j(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            IPlayer.State r4 = (IPlayer.State) r3;
            Intrinsics.checkNotNullParameter(r4, "state");
            tt5.a.h("TtsLynxViewModel", "[" + this.a.a + "] ttsStateObserver, state: " + r4);
            c.b(this.a);
            c.c(this.a);
        }
    }

    static {
    }

    public final void d() {
        this.p = null;
        tt5.a.h("TtsLynxViewModel", "[" + this.a + "] stopItemChangeObserver.");
        this.c.e().removeObserver(this.g);
        this.c.b().removeObserver(this.h);
        this.c.m().removeObserver(this.i);
        f(mo5.h.e(this.c));
        List r0 = (List) this.c.b().getValue();
        if (r0 == null) goto L8;
        Iterator r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        f((mo5.g) r1.next());
        goto L6
    L10:
        return;
    }

    public static final void a(c r25) {
        r25.getClass();
        no5.a r1 = no5.a.a;
        mo5.a r2 = r25.c;
        int r3 = r25.q;
        int r4 = r25.r;
        int r5 = r25.s;
        int r6 = r25.t;
        float r15 = r25.u;
        r1.getClass();
        if (r2 == null) goto L31;
        mo5.g r14 = mo5.h.e(r2);
        if (r14 == null) goto L31;
        mo5.j r7 = (mo5.j) r14.i().getValue();
        if (r7 == null) goto L30;
        String r8 = r7.c;
        if (r8 == null) goto L30;
        int r13 = n.d(r3);
        int r12 = n.d(r4);
        int r11 = n.G(r5);
        int r10 = n.G(r6);
        TextPaint r9 = new TextPaint();
        r9.setAntiAlias(true);
        r9.setTextSize(r10);
        Layout.Alignment r16 = Layout.Alignment.ALIGN_NORMAL;
    L13:
        if (r11 <= 0) goto L23;
        if (r9.getTextSize() < r11) goto L23;
        TextPaint r20 = r9;
        int r21 = r10;
        int r22 = r11;
        int r23 = r12;
        String r24 = r8;
        int r17 = r13;
        mo5.g r0 = r14;
        StaticLayout r18 = new StaticLayout(r8, r9, r13, r16, r15, 0.0f, false);
        if (r18.getWidth() > r17) goto L21;
        int r19 = r23;
        if (r18.getHeight() > r19) goto L22;
        r9 = r20;
    L24:
        int r26 = (int) r9.getTextSize();
        int r27 = RangesKt.coerceIn(n.F(r26), r5, r6);
        tt5.a.h("TtsLynxModel", "generateCoverParams, selectedVM: " + r0 + ", maxWidthDp: " + r3 + ", maxHeightDp: " + r4 + ", minFontSizeSp: " + r5 + ", maxFontSizeSp: " + r6 + ", maxWidthPx: " + r17 + ", maxHeightPx: " + r19 + ", minFontSizePx: " + r22 + ", maxFontSizePx: " + r21 + ", lineHeightRate: " + r15 + ", resultFontSizePx: " + r26 + ", resultFontSizeSp: " + r27);
        oo5.c r28 = new oo5.c();
        mo5.j r29 = (mo5.j) r0.i().getValue();
        if (r29 == null) goto L28;
        CCMLottieRes r30 = r29.f;
        if (r30 == null) goto L28;
    L29:
        r28.a = r30.getType();
        r28.b = no5.a.c.get(r30);
        r28.c = r27;
    L32:
        r25.e = r28;
        return;
    L28:
        r30 = CCMLottieRes.SEA_WAVE;
    L22:
        r9 = r20;
        r9.setTextSize(r20.getTextSize() - 1.0f);
        r14 = r0;
        r13 = r17;
        r12 = r19;
        r10 = r21;
        r11 = r22;
        r8 = r24;
        goto L13
    L21:
        r19 = r23;
    L23:
        r21 = r10;
        r22 = r11;
        r19 = r12;
        r17 = r13;
        r0 = r14;
    L30:
        tt5.a.k("TtsLynxModel", "generateCoverParams, titleText is null or empty.");
        r28 = new oo5.c();
    L31:
        tt5.a.h("TtsLynxModel", "generateCoverParams, selectedVM is null, albumVM: " + r2);
        r28 = new oo5.c();
        goto L32
    }

    public static final void b(c r8) {
        CCMLynxCardView r0 = r8.p;
        if (r0 != null) goto L5;
        tt5.a.k("TtsLynxViewModel", "[" + r8.a + "] updateLynxView, lynxView is null.");
        return;
    L5:
        no5.a r1 = no5.a.a;
        mo5.a r2 = r8.c;
        oo5.a r3 = r8.d;
        oo5.c r9 = r8.e;
        r1.getClass();
        oo5.d r10 = no5.a.b(r2, r3, r9);
        JSONObject r4 = new JSONObject();
        String r5 = r10.a;     // Catch: Exception -> L36
        String r6 = "";
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r4.putOpt(ResourceData.KEY_TOKEN, r5);     // Catch: Exception -> L36
        String r7 = r10.b;     // Catch: Exception -> L36
        if (r7 != null) goto L13;
        r7 = "";
    L13:
        r4.putOpt("title", r7);     // Catch: Exception -> L36
        String r11 = r10.c;     // Catch: Exception -> L36
        if (r11 != null) goto L16;
        r11 = "";
    L16:
        r4.putOpt("owner", r11);     // Catch: Exception -> L36
        String r12 = r10.d;     // Catch: Exception -> L36
        if (r12 == null) goto L20;
        r6 = r12;
    L20:
        r4.putOpt("iconInfo", r6);     // Catch: Exception -> L36
        r4.putOpt("totalSeconds", Float.valueOf(r10.e));     // Catch: Exception -> L36
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L36
        Pair<Float, Float> r14 = r10.f;     // Catch: Exception -> L36
        if (r14 == null) goto L23;
        Object r15 = Float.valueOf(((Number) r14.getFirst()).floatValue());     // Catch: Exception -> L36
    L24:
        r13.putOpt("start", r15);     // Catch: Exception -> L36
        Pair<Float, Float> r16 = r10.f;     // Catch: Exception -> L36
        if (r16 == null) goto L27;
        Object r17 = Float.valueOf(((Number) r16.getSecond()).floatValue());     // Catch: Exception -> L36
    L28:
        r13.putOpt("end", r17);     // Catch: Exception -> L36
        Unit r18 = Unit.INSTANCE;     // Catch: Exception -> L36
        r4.putOpt("loadedRange", r13);     // Catch: Exception -> L36
        r4.putOpt("currentSeconds", Float.valueOf(r10.g));     // Catch: Exception -> L36
        r4.putOpt("style", Integer.valueOf(r10.h.getValue()));     // Catch: Exception -> L36
        r4.putOpt("playingState", Integer.valueOf(r10.i.getValue()));     // Catch: Exception -> L36
        r4.putOpt("speed", Float.valueOf(r10.j));     // Catch: Exception -> L36
        oo5.c r19 = r10.k;     // Catch: Exception -> L36
        if (r19 == null) goto L31;
        JSONObject r20 = new JSONObject();     // Catch: Exception -> L36
        r20.putOpt("animationType", Integer.valueOf(r19.a));     // Catch: Exception -> L36
        r20.putOpt("titleColor", r19.b);     // Catch: Exception -> L36
        r20.putOpt("titleFontSize", Integer.valueOf(r19.c));     // Catch: Exception -> L36
    L32:
        r4.putOpt("coverInfo", r20);     // Catch: Exception -> L36
        r4.putOpt("speakerId", r10.l);     // Catch: Exception -> L36
        oo5.a r21 = r10.m;     // Catch: Exception -> L36
        if (r21 == null) goto L38;
        r4.putOpt("width", Float.valueOf(r21.a));     // Catch: Exception -> L36
        r4.putOpt("height", Float.valueOf(r21.b));     // Catch: Exception -> L36
    L38:
        r0.sendEvent("update_player_status", CollectionsKt.listOf(r4.toString()));
        return;
    L31:
        r20 = null;
        goto L32
    L27:
        r17 = 0;     // Catch: Exception -> L36
        goto L28
    L23:
        r15 = 0;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        tt5.a.e("TtsLynxPlayerParams", "TtsLynxPlayerParams-toJson, error:", e, false);
        goto L38
    }

    public static final void c(c r11) {
        CCMLynxCardView r0 = r11.p;
        if (r0 != null) goto L5;
        tt5.a.k("TtsLynxViewModel", "[" + r11.a + "] updateLynxView, lynxView is null.");
        return;
    L5:
        no5.a r1 = no5.a.a;
        mo5.a r12 = r11.c;
        r1.getClass();
        oo5.e r13 = no5.a.c(r12);
        JSONObject r2 = new JSONObject();
        r2.putOpt(ResourceData.KEY_TOKEN, r13.a);
        JSONArray r3 = new JSONArray();
        Iterator<oo5.b> r14 = r13.b.iterator();
    L7:
        if (r14.hasNext() == false) goto L28;
        oo5.b r4 = r14.next();
        r4.getClass();
        JSONObject r7 = new JSONObject();
        String r8 = r4.a;     // Catch: Exception -> L25
        String r9 = "";
        if (r8 != null) goto L13;
        r8 = "";
    L13:
        r7.putOpt(ResourceData.KEY_TOKEN, r8);     // Catch: Exception -> L25
        String r10 = r4.b;     // Catch: Exception -> L25
        if (r10 != null) goto L16;
        r10 = "";
    L16:
        r7.putOpt("title", r10);     // Catch: Exception -> L25
        String r15 = r4.c;     // Catch: Exception -> L25
        if (r15 != null) goto L19;
        r15 = "";
    L19:
        r7.putOpt("owner", r15);     // Catch: Exception -> L25
        String r16 = r4.d;     // Catch: Exception -> L25
        if (r16 == null) goto L23;
        r9 = r16;
    L23:
        r7.putOpt("iconInfo", r9);     // Catch: Exception -> L25
        r7.putOpt("totalSeconds", Float.valueOf(r4.e));     // Catch: Exception -> L25
        r7.putOpt("currentSeconds", Float.valueOf(r4.f));     // Catch: Exception -> L25
        r7.putOpt("enable", Boolean.valueOf(r4.g));     // Catch: Exception -> L25
        r7.putOpt("highlight", Boolean.valueOf(r4.h));     // Catch: Exception -> L25
        r7.putOpt("playing", Boolean.valueOf(r4.i));     // Catch: Exception -> L25
    L27:
        r3.put(r7);
    L25:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlayListItemParams-toJson, error:", e, false);
        goto L27
    L28:
        JSONObject r17 = new JSONObject();
        r17.putOpt("playingItem", r2);     // Catch: Exception -> L31
        r17.putOpt("items", r3);     // Catch: Exception -> L31
    L33:
        r0.sendEvent("update_play_list", CollectionsKt.listOf(r17.toString()));
        return;
    L31:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlaylistParams-toJson, error:", e, false);
        goto L33
    }

    public final void e(CCMLynxCardView r3) {
        Intrinsics.checkNotNullParameter(r3, "lynxView");
        this.p = r3;
        r3.h("ccm.closePage", new no5.d(this));
        r3.h("ccm.doc.fetchPlayList", new no5.e(this));
        r3.h("ccm.doc.playerAction", new no5.f(this));
        r3.h("ccm.doc.seekDidFinish", new no5.g(this));
        r3.h("ccm.doc.getFontSize", new no5.h(this));
        r3.h("ccm.impactFeedback", new no5.i());
        tt5.a.h("TtsLynxViewModel", "[" + this.a + "] startItemChangeObserver.");
        this.c.e().observeForever(this.g);
        this.c.b().observeForever(this.h);
        this.c.m().observeForever(this.i);
    }

    public final void f(mo5.g r3) {
        if (r3 != null) goto L5;
        tt5.a.d("TtsLynxViewModel", "[" + this.a + "] stopItemObserver, itemVM is null.");
        return;
    L5:
        r3.i().removeObserver(this.j);
        r3.u().removeObserver(this.k);
        r3.o().removeObserver(this.l);
        r3.r().removeObserver(this.m);
        r3.g().removeObserver(this.n);
        r3.j().removeObserver(this.o);
    }

    public c(String r2, Context r3, mo5.a r4) {
        Intrinsics.checkNotNullParameter(r2, "hostName");
        Intrinsics.checkNotNullParameter(r4, "albumVM");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.g = new C0276c(this);
        this.h = new b(this);
        this.i = new d(this);
        this.j = new e(this);
        this.k = new j(this);
        this.l = new g(this);
        this.m = new h(this);
        this.n = new i(this);
        this.o = new f(this);
    }
}
