package no5;

import android.content.Context;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.drive.export.player.IPlayer;
import com.bytedance.ee.bear.widgets.lottie.CCMLottieRes;
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

/* JADX INFO: loaded from: classes18.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f519913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f519914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final mo5.a f519915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public oo5.a f519916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public oo5.c f519917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f519918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C6952c f519919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f519920h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final d f519921i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f519922j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final j f519923k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final g f519924l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final h f519925m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i f519926n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final f f519927o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public CCMLynxCardView f519928p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f519929q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f519930r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f519931s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f519932t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f519933u;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519934a;

        public b(c r100) {
            this.f519934a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            List r101 = (List) r100;
            Intrinsics.checkNotNullParameter(r101, "itemList");
            tt5.a.h("TtsLynxViewModel", "[" + this.f519934a.f519913a + "] albumItemListObserver, itemList: " + r101);
            c.b(this.f519934a);
            c.c(this.f519934a);
        }
    }

    /* JADX INFO: renamed from: no5.c$c, reason: collision with other inner class name */
    public static final class C6952c<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519935a;

        public C6952c(c r100) {
            this.f519935a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            mo5.i r101 = (mo5.i) r100;
            Intrinsics.checkNotNullParameter(r101, "change");
            c r102 = this.f519935a;
            if (r102.f519928p != null) goto L5;
            tt5.a.k("TtsLynxViewModel", "[" + this.f519935a.f519913a + "] albumItemSelectionObserver, lynxView is null.");
            return;
        L5:
            r102.f((mo5.g) r101.f514584a);
            c r103 = this.f519935a;
            mo5.g r104 = (mo5.g) r101.f514585b;
            r103.getClass();
            if (r104 != null) goto L8;
            tt5.a.d("TtsLynxViewModel", "[" + r103.f519913a + "] startItemObserver, itemVM is null.");
        L9:
            c.a(this.f519935a);
            return;
        L8:
            r104.i().observeForever(r103.f519922j);
            r104.u().observeForever(r103.f519923k);
            r104.o().observeForever(r103.f519924l);
            r104.r().observeForever(r103.f519925m);
            r104.g().observeForever(r103.f519926n);
            r104.j().observeForever(r103.f519927o);
            goto L9
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519936a;

        public d(c r100) {
            this.f519936a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            mo5.g r101 = (mo5.g) r100;
            Intrinsics.checkNotNullParameter(r101, "itemVM");
            tt5.a.h("TtsLynxViewModel", "[" + this.f519936a.f519913a + "] albumItemUpdateObserver, itemVM: " + r101);
            c.b(this.f519936a);
            c.c(this.f519936a);
        }
    }

    public static final class e<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519937a;

        public e(c r100) {
            this.f519937a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            mo5.j r101 = (mo5.j) r100;
            Intrinsics.checkNotNullParameter(r101, "itemInfo");
            tt5.a.h("TtsLynxViewModel", "[" + this.f519937a.f519913a + "] itemInfoObserver, itemInfo: " + r101);
            c.b(this.f519937a);
            c.c(this.f519937a);
        }
    }

    public static final class f<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519938a;

        public f(c r100) {
            this.f519938a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "timeRangeMs");
            tt5.a.h("TtsLynxViewModel", "[" + this.f519938a.f519913a + "] playableRangeObserver, timeRangeMs: " + r101);
            c.b(this.f519938a);
            c.c(this.f519938a);
        }
    }

    public static final class g<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519939a;

        public g(c r100) {
            this.f519939a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            ((Number) r100).longValue();
            c r101 = this.f519939a;
            CCMLynxCardView r102 = r101.f519928p;
            if (r102 != null) goto L5;
            tt5.a.k("TtsLynxViewModel", "[" + r101.f519913a + "] updateLynxProgress, lynxView is null.");
            return;
        L5:
            no5.a r103 = no5.a.f519907a;
            mo5.a r104 = r101.f519915c;
            r103.getClass();
            if (r104 == null) goto L22;
            mo5.g r105 = mo5.h.e(r104);
            if (r105 == null) goto L22;
            oo5.f r106 = new oo5.f();
            mo5.j r107 = (mo5.j) r105.i().getValue();
            String r108 = null;
            if (r107 == null) goto L13;
            String r109 = r107.f514586a;
        L14:
            r106.f524613a = r109;
            Long r110 = (Long) r105.o().getValue();
            if (r110 == null) goto L17;
            float r111 = r110.longValue() / 1000.0f;
        L18:
            r106.f524614b = r111;
            StringBuilder r112 = new StringBuilder("generateProgressParams, title: ");
            mo5.j r113 = (mo5.j) r105.i().getValue();
            if (r113 == null) goto L21;
            r108 = r113.f514588c;
        L21:
            r112.append(r108);
            r112.append(", state: ");
            r112.append(r105.u().getValue());
            r112.append(", progress: ");
            r112.append(r106.f524614b);
            tt5.a.b("TtsLynxModel", r112.toString());
        L23:
            JSONObject r114 = new JSONObject();
            r114.putOpt("token", r106.f524613a);
            r114.putOpt("currentSeconds", Float.valueOf(r106.f524614b));
            r102.sendEvent("update_progress", CollectionsKt.listOf(r114.toString()));
            return;
        L17:
            r111 = 0.0f;
            goto L18
        L13:
            r109 = null;
        L22:
            tt5.a.h("TtsLynxModel", "generateProgressParams, selectedVM is null, albumVM: " + r104);
            r106 = new oo5.f();
            goto L23
        }
    }

    public static final class h<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519940a;

        public h(c r100) {
            this.f519940a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            tt5.a.h("TtsLynxViewModel", "[" + this.f519940a.f519913a + "] playerSpeedObserver, speed: " + ((Number) r100).floatValue());
            c.b(this.f519940a);
            c.c(this.f519940a);
        }
    }

    public static final class i<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519941a;

        public i(c r100) {
            this.f519941a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            tt5.a.h("TtsLynxViewModel", "[" + this.f519941a.f519913a + "] totalDurationObserver, totalDurationMs: " + ((Number) r100).longValue());
            c.b(this.f519941a);
            c.c(this.f519941a);
        }
    }

    public static final class j<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f519942a;

        public j(c r100) {
            this.f519942a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            IPlayer.State r101 = (IPlayer.State) r100;
            Intrinsics.checkNotNullParameter(r101, "state");
            tt5.a.h("TtsLynxViewModel", "[" + this.f519942a.f519913a + "] ttsStateObserver, state: " + r101);
            c.b(this.f519942a);
            c.c(this.f519942a);
        }
    }

    static {
    }

    public final void d() {
        this.f519928p = null;
        tt5.a.h("TtsLynxViewModel", "[" + this.f519913a + "] stopItemChangeObserver.");
        this.f519915c.e().removeObserver(this.f519919g);
        this.f519915c.b().removeObserver(this.f519920h);
        this.f519915c.m().removeObserver(this.f519921i);
        f(mo5.h.e(this.f519915c));
        List r100 = (List) this.f519915c.b().getValue();
        if (r100 == null) goto L8;
        Iterator r101 = r100.iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        f((mo5.g) r101.next());
        goto L6
    L10:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(c r210) {
        r210.getClass();
        no5.a r100 = no5.a.f519907a;
        mo5.a r101 = r210.f519915c;
        int r102 = r210.f519929q;
        int r103 = r210.f519930r;
        int r104 = r210.f519931s;
        int r105 = r210.f519932t;
        float r110 = r210.f519933u;
        r100.getClass();
        if (r101 == null) goto L31;
        mo5.g r111 = mo5.h.e(r101);
        if (r111 == null) goto L31;
        mo5.j r106 = (mo5.j) r111.i().getValue();
        if (r106 == null) goto L30;
        String r107 = r106.f514588c;
        if (r107 == null) goto L30;
        int r112 = n.d(r102);
        int r113 = n.d(r103);
        int r114 = n.G(r104);
        int r115 = n.G(r105);
        TextPaint r108 = new TextPaint();
        r108.setAntiAlias(true);
        r108.setTextSize(r115);
        Layout.Alignment r116 = Layout.Alignment.ALIGN_NORMAL;
    L13:
        if (r114 <= 0) goto L23;
        if (r108.getTextSize() < r114) goto L23;
        TextPaint r211 = r108;
        int r212 = r115;
        int r213 = r114;
        int r214 = r113;
        String r215 = r107;
        int r109 = r112;
        mo5.g r117 = r111;
        StaticLayout r118 = new StaticLayout(r107, r108, r112, r116, r110, 0.0f, false);
        if (r118.getWidth() > r109) goto L21;
        int r119 = r214;
        if (r118.getHeight() > r119) goto L22;
        r108 = r211;
    L24:
        int r120 = (int) r108.getTextSize();
        int r121 = RangesKt.coerceIn(n.F(r120), r104, r105);
        tt5.a.h("TtsLynxModel", "generateCoverParams, selectedVM: " + r117 + ", maxWidthDp: " + r102 + ", maxHeightDp: " + r103 + ", minFontSizeSp: " + r104 + ", maxFontSizeSp: " + r105 + ", maxWidthPx: " + r109 + ", maxHeightPx: " + r119 + ", minFontSizePx: " + r213 + ", maxFontSizePx: " + r212 + ", lineHeightRate: " + r110 + ", resultFontSizePx: " + r120 + ", resultFontSizeSp: " + r121);
        oo5.c r122 = new oo5.c();
        mo5.j r123 = (mo5.j) r117.i().getValue();
        if (r123 == null) goto L28;
        CCMLottieRes r124 = r123.f514591f;
        if (r124 == null) goto L28;
    L29:
        r122.f524595a = r124.getType();
        r122.f524596b = no5.a.f519909c.get(r124);
        r122.f524597c = r121;
    L32:
        r210.f519917e = r122;
        return;
    L28:
        r124 = CCMLottieRes.SEA_WAVE;
    L22:
        r108 = r211;
        r108.setTextSize(r211.getTextSize() - 1.0f);
        r111 = r117;
        r112 = r109;
        r113 = r119;
        r115 = r212;
        r114 = r213;
        r107 = r215;
        goto L13
    L21:
        r119 = r214;
    L23:
        r212 = r115;
        r213 = r114;
        r119 = r113;
        r109 = r112;
        r117 = r111;
    L30:
        tt5.a.k("TtsLynxModel", "generateCoverParams, titleText is null or empty.");
        r122 = new oo5.c();
    L31:
        tt5.a.h("TtsLynxModel", "generateCoverParams, selectedVM is null, albumVM: " + r101);
        r122 = new oo5.c();
        goto L32
    }

    public static final void b(c r100) {
        CCMLynxCardView r101 = r100.f519928p;
        if (r101 != null) goto L5;
        tt5.a.k("TtsLynxViewModel", "[" + r100.f519913a + "] updateLynxView, lynxView is null.");
        return;
    L5:
        no5.a r102 = no5.a.f519907a;
        mo5.a r103 = r100.f519915c;
        oo5.a r104 = r100.f519916d;
        oo5.c r105 = r100.f519917e;
        r102.getClass();
        oo5.d r106 = no5.a.b(r103, r104, r105);
        JSONObject r107 = new JSONObject();
        String r108 = r106.f524598a;     // Catch: Exception -> L36
        String r109 = "";
        if (r108 != null) goto L10;
        r108 = "";
    L10:
        r107.putOpt("token", r108);     // Catch: Exception -> L36
        String r110 = r106.f524599b;     // Catch: Exception -> L36
        if (r110 != null) goto L13;
        r110 = "";
    L13:
        r107.putOpt("title", r110);     // Catch: Exception -> L36
        String r111 = r106.f524600c;     // Catch: Exception -> L36
        if (r111 != null) goto L16;
        r111 = "";
    L16:
        r107.putOpt("owner", r111);     // Catch: Exception -> L36
        String r112 = r106.f524601d;     // Catch: Exception -> L36
        if (r112 == null) goto L20;
        r109 = r112;
    L20:
        r107.putOpt("iconInfo", r109);     // Catch: Exception -> L36
        r107.putOpt("totalSeconds", Float.valueOf(r106.f524602e));     // Catch: Exception -> L36
        JSONObject r113 = new JSONObject();     // Catch: Exception -> L36
        Pair<Float, Float> r114 = r106.f524603f;     // Catch: Exception -> L36
        if (r114 == null) goto L23;
        Object r115 = Float.valueOf(r114.getFirst().floatValue());     // Catch: Exception -> L36
    L24:
        r113.putOpt("start", r115);     // Catch: Exception -> L36
        Pair<Float, Float> r116 = r106.f524603f;     // Catch: Exception -> L36
        if (r116 == null) goto L27;
        Object r117 = Float.valueOf(r116.getSecond().floatValue());     // Catch: Exception -> L36
    L28:
        r113.putOpt("end", r117);     // Catch: Exception -> L36
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L36
        r107.putOpt("loadedRange", r113);     // Catch: Exception -> L36
        r107.putOpt("currentSeconds", Float.valueOf(r106.f524604g));     // Catch: Exception -> L36
        r107.putOpt("style", Integer.valueOf(r106.f524605h.getValue()));     // Catch: Exception -> L36
        r107.putOpt("playingState", Integer.valueOf(r106.f524606i.getValue()));     // Catch: Exception -> L36
        r107.putOpt("speed", Float.valueOf(r106.f524607j));     // Catch: Exception -> L36
        oo5.c r119 = r106.f524608k;     // Catch: Exception -> L36
        if (r119 == null) goto L31;
        JSONObject r120 = new JSONObject();     // Catch: Exception -> L36
        r120.putOpt("animationType", Integer.valueOf(r119.f524595a));     // Catch: Exception -> L36
        r120.putOpt("titleColor", r119.f524596b);     // Catch: Exception -> L36
        r120.putOpt("titleFontSize", Integer.valueOf(r119.f524597c));     // Catch: Exception -> L36
    L32:
        r107.putOpt("coverInfo", r120);     // Catch: Exception -> L36
        r107.putOpt("speakerId", r106.f524609l);     // Catch: Exception -> L36
        oo5.a r121 = r106.f524610m;     // Catch: Exception -> L36
        if (r121 == null) goto L38;
        r107.putOpt("width", Float.valueOf(r121.f524584a));     // Catch: Exception -> L36
        r107.putOpt("height", Float.valueOf(r121.f524585b));     // Catch: Exception -> L36
    L38:
        r101.sendEvent("update_player_status", CollectionsKt.listOf(r107.toString()));
        return;
    L31:
        r120 = null;
        goto L32
    L27:
        r117 = 0;     // Catch: Exception -> L36
        goto L28
    L23:
        r115 = 0;     // Catch: Exception -> L36
    L36:
        e = move-exception;
        tt5.a.e("TtsLynxPlayerParams", "TtsLynxPlayerParams-toJson, error:", e, false);
        goto L38
    }

    public static final void c(c r110) {
        CCMLynxCardView r100 = r110.f519928p;
        if (r100 != null) goto L5;
        tt5.a.k("TtsLynxViewModel", "[" + r110.f519913a + "] updateLynxView, lynxView is null.");
        return;
    L5:
        no5.a r101 = no5.a.f519907a;
        mo5.a r111 = r110.f519915c;
        r101.getClass();
        oo5.e r112 = no5.a.c(r111);
        JSONObject r102 = new JSONObject();
        r102.putOpt("token", r112.f524611a);
        JSONArray r103 = new JSONArray();
        Iterator<oo5.b> r113 = r112.f524612b.iterator();
    L7:
        if (r113.hasNext() == false) goto L28;
        oo5.b r104 = r113.next();
        r104.getClass();
        JSONObject r105 = new JSONObject();
        String r106 = r104.f524586a;     // Catch: Exception -> L25
        String r107 = "";
        if (r106 != null) goto L13;
        r106 = "";
    L13:
        r105.putOpt("token", r106);     // Catch: Exception -> L25
        String r114 = r104.f524587b;     // Catch: Exception -> L25
        if (r114 != null) goto L16;
        r114 = "";
    L16:
        r105.putOpt("title", r114);     // Catch: Exception -> L25
        String r115 = r104.f524588c;     // Catch: Exception -> L25
        if (r115 != null) goto L19;
        r115 = "";
    L19:
        r105.putOpt("owner", r115);     // Catch: Exception -> L25
        String r116 = r104.f524589d;     // Catch: Exception -> L25
        if (r116 == null) goto L23;
        r107 = r116;
    L23:
        r105.putOpt("iconInfo", r107);     // Catch: Exception -> L25
        r105.putOpt("totalSeconds", Float.valueOf(r104.f524590e));     // Catch: Exception -> L25
        r105.putOpt("currentSeconds", Float.valueOf(r104.f524591f));     // Catch: Exception -> L25
        r105.putOpt("enable", Boolean.valueOf(r104.f524592g));     // Catch: Exception -> L25
        r105.putOpt("highlight", Boolean.valueOf(r104.f524593h));     // Catch: Exception -> L25
        r105.putOpt("playing", Boolean.valueOf(r104.f524594i));     // Catch: Exception -> L25
    L27:
        r103.put(r105);
    L25:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlayListItemParams-toJson, error:", e, false);
        goto L27
    L28:
        JSONObject r117 = new JSONObject();
        r117.putOpt("playingItem", r102);     // Catch: Exception -> L31
        r117.putOpt("items", r103);     // Catch: Exception -> L31
    L33:
        r100.sendEvent("update_play_list", CollectionsKt.listOf(r117.toString()));
        return;
    L31:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlaylistParams-toJson, error:", e, false);
        goto L33
    }

    public final void e(CCMLynxCardView r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxView");
        this.f519928p = r100;
        r100.h("ccm.closePage", new no5.d(this));
        r100.h("ccm.doc.fetchPlayList", new no5.e(this));
        r100.h("ccm.doc.playerAction", new no5.f(this));
        r100.h("ccm.doc.seekDidFinish", new no5.g(this));
        r100.h("ccm.doc.getFontSize", new no5.h(this));
        r100.h("ccm.impactFeedback", new no5.i());
        tt5.a.h("TtsLynxViewModel", "[" + this.f519913a + "] startItemChangeObserver.");
        this.f519915c.e().observeForever(this.f519919g);
        this.f519915c.b().observeForever(this.f519920h);
        this.f519915c.m().observeForever(this.f519921i);
    }

    public final void f(mo5.g r100) {
        if (r100 != null) goto L5;
        tt5.a.d("TtsLynxViewModel", "[" + this.f519913a + "] stopItemObserver, itemVM is null.");
        return;
    L5:
        r100.i().removeObserver(this.f519922j);
        r100.u().removeObserver(this.f519923k);
        r100.o().removeObserver(this.f519924l);
        r100.r().removeObserver(this.f519925m);
        r100.g().removeObserver(this.f519926n);
        r100.j().removeObserver(this.f519927o);
    }

    public c(String r100, Context r101, mo5.a r102) {
        Intrinsics.checkNotNullParameter(r100, "hostName");
        Intrinsics.checkNotNullParameter(r102, "albumVM");
        this.f519913a = r100;
        this.f519914b = r101;
        this.f519915c = r102;
        this.f519919g = new C6952c(this);
        this.f519920h = new b(this);
        this.f519921i = new d(this);
        this.f519922j = new e(this);
        this.f519923k = new j(this);
        this.f519924l = new g(this);
        this.f519925m = new h(this);
        this.f519926n = new i(this);
        this.f519927o = new f(this);
    }
}
