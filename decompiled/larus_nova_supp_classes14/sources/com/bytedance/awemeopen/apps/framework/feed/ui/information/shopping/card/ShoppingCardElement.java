package com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.utils.UserLoginUtil;
import com.bytedance.awemeopen.bizmodels.feed.AwemeStatus;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.DetailPromotion;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.ShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShoppingCardElement extends BaseElement<a0, b0, tz3.a, jz3.a> {
    public static final /* synthetic */ int L = 0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public final e E;
    public final b F;
    public final c G;
    public final j H;
    public final d I;
    public boolean J;
    public boolean K;
    public final Activity g;
    public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o h;
    public final Lazy i;
    public final Lazy j;
    public ShoppingCardInfo k;
    public com.bytedance.awemeopen.bizmodels.feed.shopping.card.a l;
    public r14.c m;
    public jz3.a n;
    public boolean o;
    public int p;
    public List<DetailPromotion> q;
    public boolean r;
    public boolean s;
    public boolean t;
    public final Handler u;
    public com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.e v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public static final class a {
    }

    public static final class b implements FeedSeekBarHelper.c {
        public final /* synthetic */ ShoppingCardElement a;

        public b(ShoppingCardElement r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.c
        public final void a(float r6) {
            float r7 = r6 * 0.01f;
            if (r7 < ((Number) AoShoppingCardSettingsConfig.f.getValue()).doubleValue()) goto L5;
            ShoppingCardElement.q(this.a);
            return;
        L5:
            r14.c r0 = this.a.m;
            if (r0 == null) goto L10;
            Video r1 = r0.P();
            if (r1 == null) goto L10;
            int r2 = r1.getDuration();
        L12:
            if (MathKt.roundToInt(r2 * r7) < (((Number) AoShoppingCardSettingsConfig.g.getValue()).intValue() * ECDraweeView.SQUARE)) goto L16;
            ShoppingCardElement.q(this.a);
            return;
        L16:
            return;
        L10:
            r2 = 0;
            goto L12
        }
    }

    public static final class c implements com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a {
        public final /* synthetic */ ShoppingCardElement a;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void a() {
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void onProgressChanged(int r1) {
        }

        public c(ShoppingCardElement r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d.a
        public final void b(SeekBar r3, boolean r4) {
            if (r4 == false) goto L5;
            return;
        L5:
            if (r3 == null) goto L7;
            int r5 = r3.getProgress();
        L8:
            r14.c r0 = this.a.m;
            if (r0 == null) goto L13;
            Video r1 = r0.P();
            if (r1 == null) goto L13;
            int r2 = r1.getDuration();
        L14:
            int r6 = r2 * (r5 / 100);
            ShoppingCardElement r7 = this.a;
            int r8 = r7.p;
            if (r6 >= r8) goto L19;
            r14.c r9 = r7.m;
            if (r9 == null) goto L23;
            r7.s(r9, (r8 * ECDraweeView.SQUARE) - r6);
            return;
        L23:
            return;
        L19:
            r14.c r10 = r7.m;
            if (r10 == null) goto L25;
            r7.s(r10, 0);
            return;
        L25:
            return;
        L13:
            r2 = 0;
            goto L14
        L7:
            r5 = 0;
            goto L8
        }
    }

    public static final class d implements com.bytedance.awemeopen.infra.base.player.k {
        public final /* synthetic */ ShoppingCardElement a;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void e(String r1, int r2, String r3) {
        }

        public final void f(String r1, boolean r2, int r3, int r4) {
        }

        public final void g(String r1, boolean r2, String r3) {
        }

        public final void h(String r1) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public final void onPlaying(String r1) {
        }

        public d(ShoppingCardElement r1) {
            this.a = r1;
        }

        public final void l(String r1, com.bytedance.awemeopen.infra.base.player.l r2) {
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
            Intrinsics.checkNotNullParameter(r2, "playerStatusInfo");
            ShoppingCardElement.q(this.a);
            ShoppingCardElement r3 = this.a;
            r3.getClass();
            int r4 = com.bytedance.awemeopen.bizmodels.user.d.a;
            if (com.bytedance.awemeopen.bizmodels.user.d.b(r3.m) == false) goto L5;
            return;
        L5:
            if (this.a.D() == false) goto L9;
            this.a.y(true);
            return;
        }
    }

    public static final class e implements FeedSeekBarHelper.c {
        public final /* synthetic */ ShoppingCardElement a;

        public e(ShoppingCardElement r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper.c
        public final void a(float r4) {
            if (AoShoppingCardSettingsConfig.a() == false) goto L21;
            Map<String, String> r0 = this.a.h.getHostExtraInfo();
            if (r0 == null) goto L9;
            String r1 = r0.get("enable_two_line_style");
            if (r1 == null) goto L9;
            boolean r2 = r1.equals(CommentScene.COMMENTSCENE_NO_AWEME);
        L10:
            if (r2 == false) goto L22;
            r14.c r3 = this.a.m;
            if (r3 == null) goto L16;
            Video r5 = r3.P();
            if (r5 == null) goto L16;
            int r6 = r5.getDuration();
        L18:
            if (MathKt.roundToInt(r6 * (r4 * 0.01f)) < (((Number) AoShoppingCardSettingsConfig.c.getValue()).intValue() * ECDraweeView.SQUARE)) goto L23;
            this.a.y(true);
            return;
        L23:
            return;
        L16:
            r6 = 0;
            goto L18
        L22:
            return;
        L9:
            r2 = true;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void k() {
        this.w = true;
        d14.a r0 = b14.a.a;
        this.J = b14.a.a(k34.b.class).isLogin();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.a b() {
        return new a0();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.b c() {
        return new b0();
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c d() {
        return new y(getContext(), g(), h());
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void m() {
        tz3.b<Boolean> r0 = this.f;
        if (w() == false) goto L42;
        if (r0 == null) goto L42;
        if (Intrinsics.areEqual(r0.c, Boolean.TRUE) == false) goto L42;
        tz3.b<Boolean> r1 = h().j;
        Boolean r2 = Boolean.FALSE;
        r1.b(r2);
        y(false);
        h().i.b(Unit.INSTANCE);
        h().h.b(r2);
        com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.e r3 = this.v;
        if (r3 == null) goto L11;
        this.u.removeCallbacks(r3);
        this.v = null;
    L11:
        if (this.z == false) goto L16;
        if (AoShoppingCardSettingsConfig.a() == false) goto L16;
        this.h.removePlayDurationChangeListener(this.E);
    L16:
        if (this.C == false) goto L27;
        if (AoShoppingCardSettingsConfig.a() == false) goto L27;
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r4 = this.h.getSlidesProgressInfo();
        if (r4 == null) goto L22;
        r4.removeObserver(this.H);
    L22:
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r5 = this.h.getSlidesProgressInfo();
        if (r5 == null) goto L27;
        r5.setValue(null);
    L27:
        if (this.A == false) goto L34;
        if (AoShoppingCardSettingsConfig.c() == false) goto L31;
    L32:
        this.h.removePlayDurationChangeListener(this.F);
        this.h.removeSeekBarChangeListener(this.G);
        goto L34
    L31:
        if (AoShoppingCardSettingsConfig.b() == true) goto L32;
    L34:
        if (this.B == false) goto L42;
        if (AoShoppingCardSettingsConfig.a() == false) goto L38;
    L41:
        this.h.removePlayStateListener(this.I);
        goto L42
    L38:
        if (AoShoppingCardSettingsConfig.c() == true) goto L41;
        if (AoShoppingCardSettingsConfig.b() == true) goto L41;
    L42:
        this.w = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void n() {
        ShoppingCardInfo r1 = this.k;
        r14.c r2 = this.m;
        String r20 = u();
        boolean r21 = false;
        if (r1 == null) goto L63;
        if (r2 == null) goto L63;
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        r14.a0 r5 = r2.d;
        if (r5 == null) goto L10;
        String r6 = r5.a();
    L12:
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        User r7 = r2.f();
        if (r7 == null) goto L18;
        String r8 = r7.u();
        if (r8 == null) goto L18;
    L19:
        String r9 = r2.c();
        String r10 = r2.r().c;
        if (r10 != null) goto L22;
        r10 = "";
    L22:
        User r11 = r2.f();
        if (r11 == null) goto L25;
        int r12 = r11.m();
    L26:
        String r13 = r1.getProductId();
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r14.a0 r14 = r2.d;
        if (r14 == null) goto L33;
        String r15 = r14.a();
        if (r15 == null) goto L33;
    L34:
        String r16 = r1.getPromotionId();
        int r17 = r1.getPromotionSource();
        String r18 = this.h.getPageConfig().getHostEnterFrom();
        int r19 = r2.i();
        String r110 = r2.r().d;
        if (r110 != null) goto L37;
        String r23 = "";
    L38:
        r4.W1(r6, r8, r9, r10, r12, r13, r15, r16, r17, r20, r18, r19, r23, this.h.getPageConfig().isCardMode(), null, this.h.getPageConfig().getEcEntranceInfo());
        t24.a r22 = b14.a.a(t24.a.class);
        r14.a0 r24 = r2.d;
        if (r24 == null) goto L41;
        String r111 = r24.a();
    L42:
        if (r111 != null) goto L44;
        String r25 = "";
    L45:
        User r26 = r2.f();
        if (r26 == null) goto L49;
        String r27 = r26.u();
        if (r27 == null) goto L49;
    L50:
        String r28 = r2.c();
        String r29 = r2.r().c;
        if (r29 != null) goto L53;
        r29 = "";
    L53:
        User r30 = r2.f();
        if (r30 == null) goto L56;
        int r31 = r30.m();
    L57:
        String r32 = r1.getProductId();
        if (r32 != null) goto L60;
        String r33 = "";
    L61:
        r22.f1(r25, r27, r28, r29, r31, r33, r1.getPromotionId(), r1.getPromotionSource(), r20, this.h.getPageConfig().isCardMode(), this.h.getPageConfig().getEcEntranceInfo());
        goto L63
    L60:
        r33 = r32;
        goto L61
    L56:
        r31 = 0;
    L49:
        r27 = "";
        goto L50
    L44:
        r25 = r111;
        goto L45
    L41:
        r111 = null;
        goto L42
    L37:
        r23 = r110;
    L33:
        r15 = "";
        goto L34
    L25:
        r12 = 0;
    L18:
        r8 = "";
        goto L19
    L10:
        r6 = null;
    L63:
        if (w() == false) goto L140;
        r14.c r34 = this.m;
        if (r34 != null) goto L67;
        return;
    L67:
        if (AoShoppingCardSettingsConfig.a() == false) goto L94;
        ShoppingCardInfo r35 = this.k;
        if (r35 == null) goto L71;
        List r112 = r35.getTags();
    L72:
        List r113 = r112;
        if (r113 != null) goto L75;
    L78:
        boolean r36 = true;
    L79:
        if (r36 == true) goto L94;
        int r37 = com.bytedance.awemeopen.bizmodels.user.d.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.m) == true) goto L83;
        List r38 = null;
        this.h.addPlayDurationChangeListener(this.E);
        this.z = true;
    L96:
        if (x() == false) goto L124;
        this.h.addPlayDurationChangeListener(this.F);
        this.h.addSeekBarChangeListener(this.G);
        Video r39 = r34.P();
        if (r39 == null) goto L100;
        int r40 = r39.getDuration();
    L101:
        int r41 = Math.min(MathKt.roundToInt(((double) r40) * ((Number) AoShoppingCardSettingsConfig.f.getValue()).doubleValue()), ((Number) AoShoppingCardSettingsConfig.g.getValue()).intValue() * ECDraweeView.SQUARE);
        if (AoShoppingCardSettingsConfig.c() == true) goto L107;
        if (AoShoppingCardSettingsConfig.b() == true) goto L107;
    L122:
        this.A = true;
    L107:
        if (r34.f() == null) goto L122;
        if (r34.Q() == false) goto L122;
        int r42 = ((Number) AoShoppingCardSettingsConfig.a.getValue()).intValue();
        this.p = r42;
        if (r42 >= 0) goto L115;
        this.p = r41;
    L121:
        h().g.b(Unit.INSTANCE);
        s(r34, this.p);
        goto L122
    L115:
        if (r42 <= 0) goto L121;
        int r43 = r42 * ECDraweeView.SQUARE;
        this.p = r43;
        if (r41 <= r43) goto L119;
        int r44 = r41 - r43;
    L120:
        this.p = r44;
        goto L121
    L119:
        r44 = 0;
        goto L120
    L100:
        r40 = 0;
    L124:
        if (x() == false) goto L126;
    L137:
        this.h.addPlayStateListener(this.I);
        this.B = true;
    L138:
        h().j.b(Boolean.valueOf(x()));
        return;
    L126:
        if (AoShoppingCardSettingsConfig.a() == false) goto L138;
        ShoppingCardInfo r45 = this.k;
        if (r45 == null) goto L130;
        List r114 = r45.getTags();
    L131:
        List r115 = r114;
        if (r115 != null) goto L134;
    L135:
        r21 = true;
    L136:
        if (r21 == true) goto L138;
    L134:
        if (r115.isEmpty() == false) goto L136;
    L130:
        r114 = r38;
        goto L131
    L83:
        if (com.bytedance.awemeopen.bizmodels.user.d.d(this.m) == false) goto L85;
        y(true);
        goto L94
    L85:
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r46 = this.h.getSlidesProgressInfo();
        r38 = null;
        if (r46 == null) goto L89;
        r46.setValue(null);
    L89:
        MutableLiveData<com.bytedance.awemeopen.apps.framework.framework.viewpager.p> r47 = this.h.getSlidesProgressInfo();
        if (r47 == null) goto L92;
        r47.observeForever(this.H);
    L92:
        this.C = true;
        goto L96
    L75:
        if (r113.isEmpty() == true) goto L78;
        r36 = false;
        goto L79
    L71:
        r112 = null;
    L94:
        r38 = null;
        goto L96
    }

    public final String t() {
        d14.a r0 = b14.a.a;
        t24.a r1 = b14.a.a(t24.a.class);
        String r2 = this.h.sceneId();
        r14.c r3 = this.m;
        String r10 = null;
        if (r3 == null) goto L7;
        User r4 = r3.f();
        if (r4 == null) goto L7;
        String r5 = r4.u();
    L9:
        if (r5 != null) goto L11;
        String r6 = "";
    L12:
        r14.c r7 = this.m;
        if (r7 == null) goto L15;
        String r8 = r7.c();
    L16:
        if (r8 != null) goto L18;
        String r9 = "";
    L19:
        r14.c r11 = this.m;
        if (r11 == null) goto L22;
        String r12 = r11.r().c;
    L23:
        if (r12 != null) goto L25;
        String r13 = "";
    L26:
        r14.c r14 = this.m;
        if (r14 == null) goto L31;
        r14.a0 r15 = r14.d;
        if (r15 == null) goto L31;
        String r16 = r15.a();
    L32:
        if (r16 != null) goto L34;
        String r17 = "";
    L35:
        Gson r18 = GsonHolder.a();
        r14.c r19 = this.m;
        if (r19 == null) goto L38;
        r14.a0 r20 = r19.d;
    L39:
        String r21 = GsonProtectorUtils.toJson(r18, r20);
        r14.c r22 = this.m;
        if (r22 == null) goto L44;
        User r23 = r22.f();
        if (r23 == null) goto L44;
        boolean r24 = r23.O();
    L45:
        AosEventReporter r25 = AosEventReporter.a;
        String r26 = this.h.sceneId();
        jz3.a r110 = this.n;
        r25.getClass();
        JSONObject r27 = t24.a.a.a(r1, r2, r6, r9, r13, r17, r21, r24, AosEventReporter.a(r26, r110));
        if (r27 == null) goto L48;
        r10 = r27.optString("group_source");
    L48:
        if (r10 != null) goto L51;
        return "";
    L51:
        return r10;
    L44:
        r24 = false;
        goto L45
    L38:
        r20 = null;
        goto L39
    L34:
        r17 = r16;
    L31:
        r16 = null;
        goto L32
    L25:
        r13 = r12;
        goto L26
    L22:
        r12 = null;
        goto L23
    L18:
        r9 = r8;
        goto L19
    L15:
        r8 = null;
        goto L16
    L11:
        r6 = r5;
    L7:
        r5 = null;
        goto L9
    }

    public final String u() {
        return this.h.sceneId();
    }

    public final pz3.d v() {
        return (pz3.d) this.j.getValue();
    }

    public final boolean w() {
        return ((Boolean) this.i.getValue()).booleanValue();
    }

    public final boolean x() {
        r14.c r0 = this.m;
        if (r0 == null) goto L5;
        boolean r1 = r0.Q();
    L6:
        if (r1 == true) goto L8;
        return false;
    L8:
        if (AoShoppingCardSettingsConfig.c() == false) goto L10;
    L11:
        return true;
    L10:
        if (AoShoppingCardSettingsConfig.b() == true) goto L11;
        return false;
    L5:
        r1 = false;
        goto L6
    }

    public final boolean D() {
        if (AoShoppingCardSettingsConfig.a() == false) goto L12;
        Map<String, String> r0 = this.h.getHostExtraInfo();
        if (r0 == null) goto L9;
        String r1 = r0.get("enable_two_line_style");
        if (r1 == null) goto L9;
        boolean r2 = r1.equals(CommentScene.COMMENTSCENE_NO_AWEME);
    L10:
        if (r2 == false) goto L12;
        return true;
    L9:
        r2 = true;
    L12:
        return false;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void o() {
        h().a();
        this.l = null;
        this.k = null;
        this.m = null;
        this.o = false;
        this.D = false;
        this.p = 0;
        this.x = false;
        this.q = null;
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void onCreate() {
        a0 r0 = g();
        Observer<Unit> r1 = new f(this);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "observer");
        r0.a.a(r1);
        a0 r2 = g();
        Observer<Pair<DetailPromotion, Integer>> r3 = new g(this);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "observer");
        r2.b.a(r3);
        a0 r4 = g();
        Observer<DetailPromotion> r5 = new h(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r5, "observer");
        r4.c.a(r5);
        a0 r6 = g();
        Observer<Pair<DetailPromotion, Integer>> r7 = new i(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.d.a(r7);
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.d e() {
        return com.bytedance.awemeopen.apps.framework.feed.ui.information.b.d;
    }

    public final Activity getActivity() {
        return this.g;
    }

    public static final void q(ShoppingCardElement r19) {
        if (r19.w == true) goto L5;
        return;
    L5:
        if (r19.x == true) goto L7;
        return;
    L7:
        if (r19.w() == true) goto L10;
        return;
    L10:
        if (r19.y == true) goto L93;
        r19.s = true;
        if (r19.r == true) goto L94;
        List<DetailPromotion> r2 = r19.q;
        if (r2 == null) goto L18;
        int r3 = r2.size();
    L20:
        if (AoShoppingCardSettingsConfig.c() == false) goto L23;
        if (r3 != 1) goto L23;
    L26:
        List<DetailPromotion> r4 = r19.q;
        if (r4 != null) goto L29;
    L32:
        boolean r5 = true;
    L33:
        if (r5 == true) goto L90;
        r14.c r6 = r19.m;
        List<DetailPromotion> r7 = r19.q;
        if (r19.r == true) goto L91;
        List<DetailPromotion> r8 = r7;
        if (r8 != null) goto L39;
    L42:
        boolean r9 = true;
    L43:
        if (r9 == true) goto L46;
        if (r6 == null) goto L46;
        r19.h().h.b(Boolean.TRUE);
        r19.h().f.b(r7);
    L46:
        r19.r = true;
        ShoppingCardInfo r1 = r19.k;
        String r10 = r19.u();
        if (r1 == null) goto L96;
        if (r6 == null) goto L97;
        d14.a r11 = b14.a.a;
        t24.a r12 = b14.a.a(t24.a.class);
        r14.a0 r13 = r6.d;
        if (r13 == null) goto L54;
        String r14 = r13.a();
    L56:
        if (r14 != null) goto L58;
        r14 = "";
    L58:
        User r15 = r6.f();
        if (r15 == null) goto L62;
        String r16 = r15.u();
        if (r16 == null) goto L62;
    L63:
        String r17 = r6.c();
        if (r17 != null) goto L66;
        r17 = "";
    L66:
        String r18 = r6.r().c;
        if (r18 != null) goto L69;
        r18 = "";
    L69:
        User r20 = r6.f();
        if (r20 == null) goto L72;
        int r110 = r20.m();
    L73:
        String r21 = r1.getProductId();
        if (r21 != null) goto L76;
        String r111 = "";
    L77:
        String r22 = r1.getPromotionId();
        if (r22 != null) goto L80;
        String r112 = "";
    L81:
        int r113 = r1.getPromotionSource();
        if (r10 != null) goto L84;
        String r114 = "";
    L85:
        String r23 = r14;
        r12.U1(r23, r16, r17, r18, r110, r111, r112, r113, r114, r19.h.getPageConfig().isCardMode(), null, r19.h.getPageConfig().getEcEntranceInfo());
        return;
    L84:
        r114 = r10;
        goto L85
    L80:
        r112 = r22;
        goto L81
    L76:
        r111 = r21;
        goto L77
    L72:
        r110 = 0;
    L62:
        r16 = "";
        goto L63
    L54:
        r14 = null;
        goto L56
    L97:
        return;
    L96:
        return;
    L39:
        if (r8.isEmpty() == true) goto L42;
        r9 = false;
        goto L43
    L91:
        return;
    L90:
        return;
    L29:
        if (r4.isEmpty() == true) goto L32;
        r5 = false;
    L23:
        if (AoShoppingCardSettingsConfig.b() == false) goto L89;
        if (r3 > 1) goto L26;
        return;
    L89:
        return;
    L18:
        r3 = 0;
        goto L20
    L94:
        return;
    }

    public final void C(boolean r12) {
        String r0 = this.h.sceneId();
        String r2 = null;
        String r3 = "";
        if (Intrinsics.areEqual(r0, "others_homepage") == false) goto L10;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r1 = this.h;
        if ((r1 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L7;
        AosUserProfileFeedFragmentViewModel r4 = (AosUserProfileFeedFragmentViewModel) r1;
    L8:
        if (r4 == null) goto L10;
        String r5 = r4.getFromGroupId();
    L11:
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("enter_from", r0);
        r14.c r7 = this.m;
        if (r7 == null) goto L17;
        User r8 = r7.f();
        if (r8 == null) goto L17;
        String r9 = r8.u();
        if (r9 == null) goto L17;
    L18:
        r6.put("author_id", r9);
        r14.c r10 = this.m;
        if (r10 == null) goto L22;
        String r11 = r10.c();
        if (r11 == null) goto L22;
    L23:
        r6.put("group_id", r11);
        r6.put("duration", "");
        r14.c r13 = this.m;
        if (r13 == null) goto L28;
        r14.a0 r14 = r13.d;
        if (r14 == null) goto L28;
        r2 = r14.a();
    L28:
        if (r2 == null) goto L31;
        r3 = r2;
    L31:
        r6.put("impr_id", r3);
        r6.put("from_group_id", r5);
        if (r12 == false) goto L34;
        String r15 = "auto";
    L35:
        r6.put("transfer_mode", r15);
        r6.put("type", "ec");
        AosEventReporter.s(AosEventReporter.a, "video_outer_play_click", r6, null, null, null, 28);
        return;
    L34:
        r15 = "manual";
    L22:
        r11 = "";
    L17:
        r9 = "";
        goto L18
    L7:
        r4 = null;
    L10:
        r5 = "";
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.BaseElement
    public final void l(jz3.a r8) {
        jz3.a r9 = r8;
        Intrinsics.checkNotNullParameter(r9, "data");
        this.n = r9;
        this.x = true;
        h().a();
        if (w() == true) goto L5;
        j();
        return;
    L5:
        d14.a r1 = b14.a.a;
        if (b14.a.a(s24.a.class).e() == true) goto L8;
    L10:
        r14.c r10 = r9.a;
        this.m = r10;
        String r2 = null;
        if (r10 == null) goto L13;
        ShoppingCardInfo r11 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r10.K());
    L14:
        this.k = r11;
        if (((Boolean) AoShoppingCardSettingsConfig.k.getValue()).booleanValue() == false) goto L21;
        ShoppingCardInfo r12 = this.k;
        if (r12 == null) goto L19;
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.a r13 = r12.getAnchorContentObj();
    L20:
        this.l = r13;
        goto L21
    L19:
        r13 = null;
    L21:
        r14.c r14 = this.m;
        if (r14 == null) goto L28;
        AwemeStatus r15 = r14.M();
        if (r15 == null) goto L28;
        if (r15.d() != true) goto L28;
        boolean r16 = true;
    L29:
        if (r16 == true) goto L31;
    L134:
        j();
        return;
    L31:
        if (this.k == null) goto L134;
        b0 r17 = h();
        r17.c.b(this.h.getHostExtraInfo());
        b0 r18 = h();
        r14.c r4 = this.m;
        if (r4 == null) goto L41;
        s14.d r5 = r4.d();
        if (r5 == null) goto L41;
        t14.a r6 = r5.b();
        if (r6 == null) goto L41;
        List r7 = r6.g();
        if (r7 == null) goto L41;
    L42:
        com.bytedance.awemeopen.infra.base.image.b r3 = new com.bytedance.awemeopen.infra.base.image.b(r7);
        r3.b(2131231608);
        r3.m = ImageView.ScaleType.CENTER_CROP;
        Resources r19 = Resources.getSystem();
        r3.s = MathKt.roundToInt(TypedValue.applyDimension(1, 2, WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics())));
        r18.getClass();
        Intrinsics.checkNotNullParameter(r3, "imageOptions");
        r18.a.b(r3);
        b0 r20 = h();
        r14.c r21 = this.m;
        if (r21 == null) goto L47;
        s14.d r22 = r21.d();
        if (r22 == null) goto L47;
        String r23 = r22.g();
    L48:
        r14.c r24 = this.m;
        if (r24 == null) goto L53;
        s14.d r25 = r24.d();
        if (r25 == null) goto L53;
        String r26 = r25.f();
    L54:
        if (r26 != null) goto L56;
    L59:
        boolean r27 = true;
    L60:
        if (r27 == true) goto L66;
        r14.c r28 = this.m;
        if (r28 == null) goto L94;
        s14.d r29 = r28.d();
        if (r29 == null) goto L94;
        String r30 = r29.f();
    L95:
        ShoppingCardInfo r31 = this.k;
        if (r31 != null) goto L98;
    L100:
        boolean r32 = false;
    L101:
        if (r32 == true) goto L109;
        ShoppingCardInfo r33 = this.k;
        if (r33 != null) goto L105;
    L107:
        boolean r34 = false;
    L108:
        if (r34 == true) goto L109;
    L112:
        r20.b.b(new Triple(r23, r30, r2));
        ShoppingCardInfo r35 = this.k;
        if (r35 == null) goto L117;
        List<String> r36 = r35.getTags();
        if (r36 == null) goto L117;
        b0 r37 = h();
        r37.getClass();
        Intrinsics.checkNotNullParameter(r36, "tags");
        r37.d.b(r36);
    L117:
        p();
        if (b14.a.a(t24.a.class).k() == false) goto L142;
        r14.c r38 = this.m;
        if (r38 == null) goto L138;
        String r39 = r38.c();
        if (r39 != null) goto L126;
        return;
    L126:
        if (Intrinsics.areEqual(r39, this.h.getPageConfig().getEnterAid()) == true) goto L129;
        return;
    L129:
        if (Intrinsics.areEqual(this.h.getCommerceClickType(), "ec_anchor") == false) goto L132;
        z(this.k, true);
        A(this.k, this.m, true);
        C(true);
        this.h.setCommerceClickType("");
        return;
    L132:
        if (Intrinsics.areEqual(this.h.getCommerceClickType(), "ec_normal") == false) goto L140;
        C(false);
        this.h.setCommerceClickType("");
        return;
    L140:
        return;
    L138:
        return;
    L142:
        return;
    L105:
        if (r33.getStyleType() != 14) goto L107;
        r34 = true;
    L109:
        com.bytedance.awemeopen.bizmodels.feed.shopping.card.a r40 = this.l;
        if (r40 == null) goto L112;
        r2 = r40.a();
        goto L112
    L98:
        if (r31.getStyleType() != 6) goto L100;
        r32 = true;
    L94:
        r30 = null;
        goto L95
    L66:
        ShoppingCardInfo r41 = this.k;
        if (r41 == null) goto L69;
        String r42 = r41.getElasticTitle();
    L70:
        if (r42 != null) goto L72;
    L75:
        boolean r43 = true;
    L76:
        if (r43 == true) goto L80;
        ShoppingCardInfo r44 = this.k;
        if (r44 == null) goto L94;
        r30 = r44.getElasticTitle();
        goto L95
    L80:
        ShoppingCardInfo r45 = this.k;
        if (r45 == null) goto L83;
        String r46 = r45.getTitle();
    L84:
        if (r46 != null) goto L86;
    L89:
        boolean r47 = true;
    L90:
        if (r47 == true) goto L94;
        ShoppingCardInfo r48 = this.k;
        if (r48 == null) goto L94;
        r30 = r48.getTitle();
        goto L95
    L86:
        if (r46.length() == 0) goto L89;
        r47 = false;
        goto L90
    L83:
        r46 = null;
        goto L84
    L72:
        if (r42.length() == 0) goto L75;
        r43 = false;
        goto L76
    L69:
        r42 = null;
        goto L70
    L56:
        if (r26.length() == 0) goto L59;
        r27 = false;
    L53:
        r26 = null;
    L47:
        r23 = null;
    L41:
        r7 = CollectionsKt.emptyList();
    L28:
        r16 = false;
        goto L29
    L13:
        r11 = null;
        goto L14
    L8:
        if (b14.a.a(s24.a.class).isAvailable() == true) goto L10;
        j();
        int r49 = j64.b.a;
        j64.b.a(AoHostService.class).J1();
    }

    public final void y(boolean r3) {
        if (r3 == true) goto L4;
    L10:
        h().e.b(Boolean.valueOf(r3));
        this.t = r3;
        return;
    L4:
        if (this.w == true) goto L6;
        return;
    L6:
        if (this.x == true) goto L8;
        return;
    L8:
        if (this.t == false) goto L10;
    }

    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.j] */
    public ShoppingCardElement(Activity r2, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r3) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "vm");
        super(r2);
        this.g = r2;
        this.h = r3;
        this.i = LazyKt.lazy(ShoppingCardElement$isShow$2.INSTANCE);
        this.j = LazyKt.lazy(ShoppingCardElement$videoScalingParams$2.INSTANCE);
        this.u = new Handler(Looper.getMainLooper());
        this.E = new e(this);
        this.F = new b(this);
        this.G = new c(this);
        this.H = new j(this);
        this.I = new d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.e, java.lang.Runnable] */
    public final void s(final r14.c r4, int r5) {
        if (AoShoppingCardSettingsConfig.c() == true) goto L8;
        if (AoShoppingCardSettingsConfig.b() == true) goto L8;
        return;
    L8:
        if (r4.f() != null) goto L11;
        return;
    L11:
        if (r4.Q() == true) goto L14;
        return;
    L14:
        if (this.o == false) goto L17;
        return;
    L17:
        if (this.D == false) goto L19;
        return;
    L19:
        com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.e r0 = this.v;
        if (r0 == null) goto L22;
        this.u.removeCallbacks(r0);
        this.v = null;
    L22:
        ?? r1 = new com.bytedance.awemeopen.apps.framework.feed.ui.information.shopping.card.e(this, r4);
        this.v = r1;
        this.u.postDelayed(r1, r5);
    }

    public final void z(final ShoppingCardInfo r5, final boolean r6) {
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
        Lazy r0 = UserLoginUtil.a;
        Activity r1 = this.g;
        int r2 = com.bytedance.awemeopen.bizmodels.user.a.a;
        if (this.h.getPageConfig().isCardMode() == false) goto L5;
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("is_card_mode", CommentScene.COMMENTSCENE_NO_AWEME)});
    L6:
        UserLoginUtil.a(r1, "ecom_anchor", r3, new ShoppingCardElement$onShoppingCardClick$1(r5, this, r6));
        return;
    L5:
        r3 = new LinkedHashMap();
        goto L6
    }

    public static final void r(ShoppingCardElement r1, float r2, float r3) {
        r1.v().a = r2;
        r1.v().b = r3;
        r1.v().getClass();
        r1.v().f = false;
        r1.v().g = true;
        r1.h.getVideoScaling().setValue(r1.v());
    }

    public final void A(ShoppingCardInfo r24, r14.c r25, boolean r26) {
        if (r24 != null) goto L5;
        return;
    L5:
        if (r25 != null) goto L7;
        return;
    L7:
        String r19 = u();
        d14.a r2 = b14.a.a;
        t24.a r3 = b14.a.a(t24.a.class);
        r14.a0 r4 = r25.d;
        String r20 = null;
        if (r4 == null) goto L10;
        String r5 = r4.a();
    L12:
        if (r5 != null) goto L14;
        r5 = "";
    L14:
        User r6 = r25.f();
        if (r6 == null) goto L18;
        String r7 = r6.u();
        if (r7 == null) goto L18;
    L19:
        String r8 = r25.r().c;
        if (r8 != null) goto L22;
        String r9 = "";
    L23:
        String r10 = r25.c();
        User r11 = r25.f();
        if (r11 == null) goto L26;
        int r12 = r11.m();
    L27:
        String r13 = r24.getProductId();
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r14.a0 r14 = r25.d;
        if (r14 == null) goto L34;
        String r15 = r14.a();
        if (r15 == null) goto L34;
    L35:
        String r16 = r24.getPromotionId();
        int r17 = r24.getPromotionSource();
        String r18 = this.h.getPageConfig().getHostEnterFrom();
        int r110 = r25.i();
        String r111 = r25.r().d;
        if (r111 != null) goto L38;
        String r112 = "";
    L39:
        r3.R1(r5, r7, r10, r9, r12, r13, r15, r16, r17, r19, r18, r110, r112, this.h.getPageConfig().isCardMode(), r26, this.h.getPageConfig().getEcEntranceInfo());
        t24.a r21 = b14.a.a(t24.a.class);
        r14.a0 r22 = r25.d;
        if (r22 == null) goto L42;
        r20 = r22.a();
    L42:
        if (r20 != null) goto L44;
        r20 = "";
    L44:
        User r23 = r25.f();
        if (r23 == null) goto L48;
        String r27 = r23.u();
        if (r27 == null) goto L48;
    L49:
        String r28 = r25.c();
        String r29 = r25.r().c;
        if (r29 != null) goto L52;
        r29 = "";
    L52:
        User r1 = r25.f();
        if (r1 == null) goto L55;
        int r30 = r1.m();
    L56:
        String r31 = r24.getProductId();
        if (r31 != null) goto L59;
        String r32 = "";
    L60:
        r21.A1(r20, r27, r28, r29, r30, r32, r24.getPromotionId(), r24.getPromotionSource(), r19, this.h.getPageConfig().isCardMode(), r26, null, this.h.getPageConfig().getEcEntranceInfo());
        return;
    L59:
        r32 = r31;
        goto L60
    L55:
        r30 = 0;
    L48:
        r27 = "";
        goto L49
    L38:
        r112 = r111;
    L34:
        r15 = "";
        goto L35
    L26:
        r12 = 0;
        goto L27
    L22:
        r9 = r8;
    L18:
        r7 = "";
        goto L19
    L10:
        r5 = null;
        goto L12
    }

    public final void B(ShoppingCardInfo r19, r14.c r20, boolean r21, boolean r22) {
        if (r19 != null) goto L5;
        return;
    L5:
        if (r20 != null) goto L7;
        return;
    L7:
        String r2 = u();
        d14.a r3 = b14.a.a;
        t24.a r4 = b14.a.a(t24.a.class);
        r14.a0 r5 = r20.d;
        if (r5 == null) goto L10;
        String r6 = r5.a();
    L12:
        if (r6 != null) goto L14;
        r6 = "";
    L14:
        User r7 = r20.f();
        if (r7 == null) goto L18;
        String r8 = r7.u();
        if (r8 == null) goto L18;
    L19:
        String r9 = r20.r().c;
        if (r9 != null) goto L22;
        String r10 = "";
    L23:
        String r11 = r20.c();
        if (r11 != null) goto L26;
        r11 = "";
    L26:
        User r1 = r20.f();
        if (r1 == null) goto L29;
        int r12 = r1.m();
    L30:
        String r13 = r19.getProductId();
        if (r13 != null) goto L33;
        String r14 = "";
    L34:
        String r15 = r19.getPromotionId();
        if (r15 != null) goto L37;
        String r16 = "";
    L38:
        int r17 = r19.getPromotionSource();
        if (r2 != null) goto L41;
        String r18 = "";
    L42:
        String r23 = r6;
        r4.T1(r23, r8, r11, r10, r12, r14, r16, r17, r18, this.h.getPageConfig().isCardMode(), r21, r22, this.h.getPageConfig().getEcEntranceInfo());
        return;
    L41:
        r18 = r2;
        goto L42
    L37:
        r16 = r15;
        goto L38
    L33:
        r14 = r13;
        goto L34
    L29:
        r12 = 0;
        goto L30
    L22:
        r10 = r9;
    L18:
        r8 = "";
        goto L19
    L10:
        r6 = null;
        goto L12
    }
}
