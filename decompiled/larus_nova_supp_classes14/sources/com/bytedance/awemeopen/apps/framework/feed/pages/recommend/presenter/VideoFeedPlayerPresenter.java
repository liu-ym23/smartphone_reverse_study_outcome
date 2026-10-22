package com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.awemeopen.apps.framework.base.view.verticalviewPager.VerticalViewPager;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.profile.AosUserProfileFeedFragmentViewModel;
import com.bytedance.awemeopen.apps.framework.framework.eventbus.LiveDataBus;
import com.bytedance.awemeopen.apps.framework.landscape.VideoLandscapeActivity;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.apps.framework.player.FullVideoView;
import com.bytedance.awemeopen.apps.framework.utils.reporter.HostCommonParamProvider;
import com.bytedance.awemeopen.bizmodels.feed.Video;
import com.bytedance.awemeopen.bizmodels.feed.shopping.card.ShoppingCardInfo;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.bytedance.awemeopen.bizmodels.utils.AwemeCheckUtilsKt;
import com.bytedance.awemeopen.domain.base.repo.GsonHolder;
import com.bytedance.awemeopen.export.api.pageconfig.recfeed.FeedPageConfig;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.base.player.AoVideoView;
import com.bytedance.awemeopen.infra.base.player.resize.VideoScaleModel;
import com.bytedance.awemeopen.infra.base.settings.AoSettings;
import com.bytedance.awemeopen.servicesapi.image.AoImageService;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class VideoFeedPlayerPresenter extends g04.a<jz3.a> {
    public static final /* synthetic */ int M = 0;
    public final Lazy A;
    public final Lazy B;
    public long C;
    public float D;
    public float E;
    public final f F;
    public final v G;
    public jz3.a H;
    public final q I;
    public final t J;
    public long K;
    public boolean L;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a e;
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p f;
    public final com.bytedance.awemeopen.apps.framework.player.e g;
    public final Function1<String, Long> h;
    public final boolean i;
    public final FullVideoView j;
    public final AoVideoView k;
    public final b l;
    public final View m;
    public final w n;
    public final x o;
    public final y p;
    public final z q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public final a v;
    public String w;
    public boolean x;
    public boolean y;
    public final g z;

    public static final class a implements com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a {
        public final /* synthetic */ VideoFeedPlayerPresenter a;

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void a() {
            this.a.k.setIsMute(true);
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void b() {
            this.a.k.setIsMute(false);
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void d() {
            this.a.n();
        }

        public a(VideoFeedPlayerPresenter r1) {
            this.a = r1;
        }

        @Override // com.bytedance.awemeopen.apps.framework.utils.audio.a.InterfaceC0106a
        public final void c(boolean r2) {
            this.a.m(r2);
        }
    }

    public static final class b {
        public final ImageView a;
        public final boolean b;
        public final com.bytedance.awemeopen.apps.framework.framework.viewpager.o c;
        public int d;

        public final boolean a() {
            if (this.d != 2131231484) goto L5;
        L7:
            return false;
        L5:
            if (this.a.getVisibility() != 0) goto L7;
            return true;
        }

        public final void b() {
            if (Intrinsics.areEqual(this.c.getEnterPinchMode().getValue(), Boolean.TRUE) == true) goto L5;
            this.a.setVisibility(0);
        L5:
            boolean r0 = this.b;
            if (r0 == false) goto L12;
            if (r0 == false) goto L9;
            int r1 = 2131231485;
        L10:
            this.d = r1;
            this.a.setImageResource(r1);
            return;
        L9:
            r1 = 2131231541;
            goto L10
        }

        public b(ImageView r2, boolean r3, com.bytedance.awemeopen.apps.framework.framework.viewpager.o r4) {
            Intrinsics.checkNotNullParameter(r2, "btn");
            Intrinsics.checkNotNullParameter(r4, "vm");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            if (r3 == false) goto L5;
            int r5 = 2131231485;
        L6:
            this.d = r5;
            return;
        L5:
            r5 = 2131231541;
            goto L6
        }
    }

    public static final class c {
    }

    public static final class d {
        public final int a;
        public final long b;
        public final int c;

        public d() {
            this(0, 0, 7);
        }

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof d) == true) goto L8;
            return false;
        L8:
            d r9 = (d) r8;
            if (this.a == r9.a) goto L12;
            return false;
        L12:
            if (this.b == r9.b) goto L15;
            return false;
        L15:
            if (this.c == r9.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            long r1 = this.b;
            return ((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.c;
        }

        public final String toString() {
            return "VideoBlockInfo(blockActionType=" + this.a + ", blockStartTime=" + this.b + ", blockEndCode=" + this.c + ')';
        }

        public d(int r3, long r4, int r6) {
            int r1 = -1;
            if ((r6 & 1) == 0) goto L6;
            r3 = -1;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = -1;
        L9:
            if ((r6 & 4) != 0) goto L12;
            r1 = 0;
        L12:
            this.a = r3;
            this.b = r4;
            this.c = r1;
        }
    }

    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Lifecycle.Event.values().length];
            r0[Lifecycle.Event.ON_START.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[Lifecycle.Event.ON_RESUME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[Lifecycle.Event.ON_PAUSE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[Lifecycle.Event.ON_STOP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    public static final class f implements com.bytedance.awemeopen.infra.base.player.k {
        public final HashMap<String, d> a;
        public final /* synthetic */ VideoFeedPlayerPresenter b;

        public final void c(String r1) {
        }

        public final void d(String r1, long r2, int r4) {
        }

        public final void h(String r1) {
        }

        public final void onPlayPrepare(String r1) {
        }

        public final void onPlaying(String r1) {
        }

        public f(VideoFeedPlayerPresenter r1) {
            this.b = r1;
            this.a = new HashMap();
        }

        public final void l(String r6, com.bytedance.awemeopen.infra.base.player.l r7) {
            Intrinsics.checkNotNullParameter(r7, "playerStatusInfo");
            VideoFeedPlayerPresenter r8 = this.b;
            jz3.a r0 = r8.H;
            jz3.a r2 = null;
            if (r0 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r0 = null;
        L6:
            if (Intrinsics.areEqual(r6, r0.a.c()) == false) goto L25;
            d14.a r9 = b14.a.a;
            x24.a r10 = b14.a.a(x24.a.class);
            jz3.a r1 = r8.H;
            if (r1 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r1 = null;
        L11:
            if (r10.v3(r1.a) == true) goto L25;
            if (r8.r == true) goto L18;
            r8.r = true;
            AosEventReporter r11 = AosEventReporter.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = r8.e;
            jz3.a r4 = r8.H;
            if (r4 != null) goto L17;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r4 = null;
        L17:
            r11.getClass();
            AosEventReporter.S(r3, r4);
        L18:
            r8.f.c++;
            r8.e.c.setOverType("finish");
            AosEventReporter r12 = AosEventReporter.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r5 = r8.e;
            jz3.a r13 = r8.H;
            if (r13 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r13 = null;
        L21:
            AosEventReporter.M(r12, r5, r13);
            r8.e.c.setStartType("loop");
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r14 = r8.e;
            jz3.a r15 = r8.H;
            if (r15 != null) goto L24;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r15 = null;
        L24:
            AosEventReporter.N(r14, r15, r8.f);
        L25:
            k54.c r16 = iz3.a.c(this.b.e);
            if (r16 == null) goto L32;
            jz3.a r17 = this.b.H;
            if (r17 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r17 = null;
        L30:
            r16.j(new k54.b.b(r17.a.c()));
        L32:
            if (Intrinsics.areEqual(this.b.e.c.canAutoPlay(), Boolean.TRUE) == true) goto L41;
            k54.c r18 = iz3.a.c(this.b.e);
            if (r18 == null) goto L42;
            jz3.a r19 = this.b.H;
            if (r19 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L39:
            r18.j(new k54.b.f(r2.a.c()));
            return;
        L38:
            r2 = r19;
            goto L39
        L42:
            return;
        }

        public final void e(String r40, int r41, String r42) {
            VideoFeedPlayerPresenter r1 = this.b;
            r1.getClass();
            AosEventReporter r2 = AosEventReporter.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = r1.e;
            jz3.a r4 = r1.H;
            if (r4 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r4 = null;
        L5:
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r7 = r1.f;
            r2.getClass();
            Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
            Intrinsics.checkNotNullParameter(r4, "data");
            Intrinsics.checkNotNullParameter(r7, "eventRecorder");
            String r9 = r3.c.sceneId();
            String r30 = r3.c.getPageConfig().getHostEnterFrom();
            JSONObject r38 = r3.c.getPageConfig().getHostExtraParams();
            if (Intrinsics.areEqual(r9, "others_homepage") == false) goto L13;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.o r5 = r3.c;
            if ((r5 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L10;
            AosUserProfileFeedFragmentViewModel r6 = (AosUserProfileFeedFragmentViewModel) r5;
        L11:
            if (r6 == null) goto L13;
            String r13 = r6.getFromGroupId();
        L14:
            FeedPageConfig r8 = r3.c.getPageConfig();
            if (r8.isTeenagerModel() == true) goto L58;
            d14.a r10 = b14.a.a;
            t24.a r11 = b14.a.a(t24.a.class);
            String r12 = r4.a.c();
            String r14 = AosEventReporter.b(r4.a, r8);
            if (r14 != null) goto L19;
            r14 = "";
        L19:
            r14.a0 r15 = r4.a.d;
            if (r15 == null) goto L23;
            String r16 = r15.a();
            if (r16 == null) goto L23;
        L24:
            String r17 = GsonProtectorUtils.toJson(GsonHolder.a(), r4.a.d);
            boolean r18 = AosEventReporter.e(r4.a);
            boolean r19 = r7.b;
            boolean r20 = r4.g;
            boolean r21 = r4.a.t;
            String r110 = r8.getPreviousPage();
            if (r110 != null) goto L27;
            String r27 = "";
        L29:
            if (r4.a.W() == false) goto L31;
            String r22 = "origin";
        L32:
            String r28 = r22;
            User r23 = r4.a.f();
            if (r23 == null) goto L38;
            String r24 = r23.u();
            if (r24 == null) goto L38;
            String r29 = r24;
        L39:
            boolean r25 = r8.isCardMode();
            String r31 = r4.a.e();
            Map r32 = r4.a.b0();
            r14.a0 r26 = r4.a.d;
            if (r26 == null) goto L42;
            String r33 = r26.a();
        L43:
            if (r33 != null) goto L45;
            String r34 = "";
        L46:
            String r35 = r4.a.r().d;
            if (r35 != null) goto L49;
            String r36 = "";
        L50:
            ShoppingCardInfo r37 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r4.a.K());
            if (r37 == null) goto L56;
            String r39 = r37.getProductId();
            if (r39 == null) goto L56;
            String r310 = r39;
        L57:
            r11.u3(r9, r12, r14, r16, r13, r17, r18, "detail", r19, r20, r21, "", false, r25, false, "", "", null, r27, r28, r29, r30, r31, r32, r34, r36, r310, r41, r42, r38);
        L56:
            r310 = "";
            goto L57
        L49:
            r36 = r35;
            goto L50
        L45:
            r34 = r33;
            goto L46
        L42:
            r33 = null;
        L38:
            r29 = "";
            goto L39
        L31:
            r22 = "sdk";
            goto L32
        L27:
            r27 = r110;
        L23:
            r16 = "";
        L58:
            zx3.a.c(r1.getContext(), 2131894254).d();
            k54.c r43 = iz3.a.c(this.b.e);
            if (r43 == null) goto L66;
            jz3.a r44 = this.b.H;
            if (r44 != null) goto L63;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            jz3.a r45 = null;
        L64:
            r43.j(new k54.b.e(r45.a.c()));
            return;
        L63:
            r45 = r44;
            goto L64
        L66:
            return;
        L10:
            r6 = null;
        L13:
            r13 = "";
            goto L14
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v23, types: [java.lang.Long, java.lang.Number] */
        /* JADX WARN: Type inference failed for: r2v24, types: [java.lang.Number] */
        /* JADX WARN: Type inference failed for: r2v26 */
        /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View] */
        /* JADX WARN: Type inference failed for: r9v0, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.a0, java.lang.Runnable] */
        public final void g(String r49, boolean r50, String r51) {
            this.b.y();
            final VideoFeedPlayerPresenter r1 = this.b;
            jz3.a r2 = r1.H;
            if (r2 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r2 = null;
        L5:
            boolean r5 = true;
            if (com.bytedance.awemeopen.apps.framework.landscape.f.b(r2.a.P()) == true) goto L10;
            View r3 = r1.m;
            if (r3 == null) goto L35;
            x54.b.a(r3);
        L35:
            jz3.a r4 = r1.H;
            if (r4 != null) goto L39;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r4 = null;
        L39:
            if (Intrinsics.areEqual(r49, r4.a.c()) == false) goto L191;
            r1.j.getForegroundImageView().setVisibility(4);
            if (r1.s == false) goto L143;
            r1.s = false;
            AosEventReporter.a.getClass();
            Intrinsics.checkNotNullParameter("action_type", "key");
            d14.a r6 = b14.a.a;
            String r7 = b14.a.a(t24.a.class).getEventValue();
            if (r7 != null) goto L45;
        L50:
            r7 = null;
        L51:
            r1.w = r7;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r8 = r1.e;
            jz3.a r11 = r1.H;
            if (r11 != null) goto L54;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r11 = null;
        L54:
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r12 = r1.f;
            Intrinsics.checkNotNullParameter(r8, "feedGroupParameters");
            Intrinsics.checkNotNullParameter(r11, "data");
            Intrinsics.checkNotNullParameter(r12, "eventRecorder");
            String r15 = r8.c.sceneId();
            String r37 = r8.c.getPageConfig().getHostEnterFrom();
            JSONObject r46 = r8.c.getPageConfig().getHostExtraParams();
            if (Intrinsics.areEqual(r15, "others_homepage") == false) goto L62;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.o r13 = r8.c;
            if ((r13 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L59;
            AosUserProfileFeedFragmentViewModel r14 = (AosUserProfileFeedFragmentViewModel) r13;
        L60:
            if (r14 == null) goto L62;
            String r16 = r14.getFromGroupId();
        L63:
            FeedPageConfig r17 = r8.c.getPageConfig();
            com.bytedance.awemeopen.apps.framework.feed.ui.information.bottomcomponent.b.a(r8.c.getHostExtensionInfo());
            if (r17.isTeenagerModel() == false) goto L84;
            t24.a r9 = b14.a.a(t24.a.class);
            User r18 = r11.a.f();
            if (r18 == null) goto L71;
            String r19 = r18.u();
            if (r19 == null) goto L71;
            String r110 = r19;
        L72:
            String r111 = r11.a.c();
            String r112 = AosEventReporter.b(r11.a, r17);
            if (r112 != null) goto L75;
            String r113 = "";
        L76:
            r14.a0 r114 = r11.a.d;
            if (r114 == null) goto L82;
            String r115 = r114.a();
            if (r115 == null) goto L82;
            String r116 = r115;
        L83:
            r9.n3(r15, r110, r111, r113, r116, r16, r11.a.t);
        L139:
            r1.e.c.setPlayTimeDurationRecord(System.currentTimeMillis());
            r1.e.c.setPostPlayTimeDurationRecord(System.currentTimeMillis());
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r10 = r1.e;
            jz3.a r20 = r1.H;
            if (r20 != null) goto L142;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r20 = null;
        L142:
            AosEventReporter.N(r10, r20, r1.f);
        L82:
            r116 = "";
            goto L83
        L75:
            r113 = r112;
        L71:
            r110 = "";
            goto L72
        L84:
            t24.a r21 = b14.a.a(t24.a.class);
            String r117 = r11.a.c();
            String r22 = AosEventReporter.b(r11.a, r17);
            if (r22 != null) goto L87;
            String r118 = "";
        L88:
            r14.a0 r23 = r11.a.d;
            if (r23 == null) goto L94;
            String r24 = r23.a();
            if (r24 == null) goto L94;
            String r119 = r24;
        L95:
            float r25 = r11.a.q() / 1000.0f;
            String r26 = GsonProtectorUtils.toJson(GsonHolder.a(), r11.a.d);
            boolean r27 = AosEventReporter.e(r11.a);
            boolean r28 = r12.b;
            boolean r29 = r11.g;
            boolean r120 = r11.a.t;
            String r121 = r17.getPreviousPage();
            if (r121 != null) goto L98;
            String r34 = "";
        L100:
            if (r11.a.W() == false) goto L102;
            String r30 = "origin";
        L103:
            String r35 = r30;
            User r31 = r11.a.f();
            if (r31 == null) goto L109;
            String r32 = r31.u();
            if (r32 == null) goto L109;
            String r36 = r32;
        L110:
            boolean r210 = r17.isCardMode();
            String r38 = r11.a.e();
            s14.d r33 = r11.a.d();
            if (r33 == null) goto L113;
            Integer r39 = r33.getType();
        L114:
            Map r40 = r11.a.b0();
            r14.a0 r41 = r11.a.d;
            if (r41 == null) goto L117;
            String r42 = r41.a();
        L118:
            if (r42 != null) goto L120;
            String r43 = "";
        L121:
            String r44 = r11.a.r().d;
            if (r44 != null) goto L124;
            String r45 = "";
        L125:
            ShoppingCardInfo r47 = (ShoppingCardInfo) CollectionsKt.firstOrNull(r11.a.K());
            if (r47 == null) goto L131;
            String r48 = r47.getProductId();
            if (r48 == null) goto L131;
            String r410 = r48;
        L132:
            User r52 = r11.a.f();
            if (r52 != null) goto L135;
        L137:
            boolean r411 = false;
        L138:
            r21.U0(r15, r117, r118, r119, r16, r25, r26, r27, "detail", r28, r29, r120, "", false, r210, false, "", "", new com.bytedance.awemeopen.apps.framework.utils.e(r11.a), r34, r35, r36, r37, r38, r39, r40, r43, r45, r410, r50, r411, r46, "");
            goto L139
        L135:
            if (r52.R() != true) goto L137;
            r411 = true;
        L131:
            r410 = "";
            goto L132
        L124:
            r45 = r44;
            goto L125
        L120:
            r43 = r42;
            goto L121
        L117:
            r42 = null;
            goto L118
        L113:
            r39 = null;
        L109:
            r36 = "";
            goto L110
        L102:
            r30 = "sdk";
            goto L103
        L98:
            r34 = r121;
        L94:
            r119 = "";
            goto L95
        L87:
            r118 = r22;
            goto L88
        L59:
            r14 = null;
        L62:
            r16 = "";
            goto L63
        L45:
            if (r7.length() <= 0) goto L47;
            boolean r122 = true;
        L48:
            if (r122 == false) goto L50;
        L47:
            r122 = false;
        L143:
            j04.a r53 = j04.b.a;
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r54 = r1.e;
            jz3.a r55 = r1.H;
            if (r55 != null) goto L146;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r55 = null;
        L146:
            Intrinsics.checkNotNullParameter(r54, "feedGroupParameters");
            Intrinsics.checkNotNullParameter(r55, "data");
            j04.a r56 = j04.b.a;
            if (r56 != null) goto L149;
            jz3.a r0 = null;
        L190:
            com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r57 = r1.f;
            AoLogger.b(r57.a, new Object[]{"onPlayStart"});
            r57.h = System.currentTimeMillis();
        L192:
            long r58 = this.b.e.c.getPageConfig().getStartPlayPosition();
            if (r58 <= 0) goto L195;
            this.b.k.g(r58);
            this.b.e.c.getPageConfig().setStartPlayPosition(0);
        L211:
            FeedLongPressFastSpeedPresenter r59 = (FeedLongPressFastSpeedPresenter) this.b.A.getValue();
            if (r59 == null) goto L214;
            r59.q();
        L214:
            k54.c r60 = iz3.a.c(this.b.e);
            if (r60 == null) goto L222;
            jz3.a r61 = this.b.H;
            if (r61 != null) goto L219;
            Intrinsics.throwUninitializedPropertyAccessException("data");
        L220:
            r60.j(new k54.b.c(r0.a.c()));
            return;
        L219:
            r0 = r61;
            goto L220
        L222:
            return;
        L195:
            VideoFeedPlayerPresenter r62 = this.b;
            Function1<String, Long> r63 = r62.h;
            if (r63 == null) goto L211;
            jz3.a r64 = r62.H;
            if (r64 != null) goto L200;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r64 = r0;
        L200:
            ?? r65 = (Long) r63.invoke(r64.a.c());
            if (r65 == 0) goto L211;
            if (r65.longValue() > 0) goto L206;
            r5 = false;
        L206:
            if (r5 == true) goto L209;
            r65 = r0;
        L209:
            if (r65 == 0) goto L211;
            this.b.k.g(r65.longValue());
            goto L211
        L149:
            if (Intrinsics.areEqual(r56.g, "enter_play") == false) goto L151;
            long r123 = System.currentTimeMillis();
            r56.f = r123;
            long r124 = r56.b;
            r56.h = r124 - r56.a;
            r56.i = r123 - r124;
            long r125 = r56.d;
            long r66 = r56.c;
            r56.j = r125 - r66;
            long r67 = r56.e;
            r56.k = r123 - r67;
            r56.l = r66 - r124;
            r56.m = r67 - r125;
        L152:
            String r68 = r54.c.sceneId();
            if (Intrinsics.areEqual(r68, "others_homepage") == false) goto L167;
            com.bytedance.awemeopen.apps.framework.framework.viewpager.o r69 = r54.c;
            if ((r69 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L157;
            AosUserProfileFeedFragmentViewModel r70 = (AosUserProfileFeedFragmentViewModel) r69;
        L158:
            if (r70 == null) goto L167;
            jz3.a r71 = r70.getFromAweme();
            if (r71 == null) goto L165;
            r14.c r72 = r71.a;
            if (r72 == null) goto L165;
            String r73 = r72.c();
            if (r73 == null) goto L165;
        L166:
            String r211 = r73;
        L169:
            if (r55.d == 0) goto L171;
        L173:
            int r212 = 0;
        L174:
            d14.a r74 = b14.a.a;
            d34.a r126 = b14.a.a(d34.a.class);
            String r75 = r56.g;
            long r76 = r56.i;
            int r77 = r56.o;
            User r78 = r55.a.f();
            if (r78 == null) goto L180;
            String r79 = r78.u();
            if (r79 == null) goto L180;
            String r213 = r79;
        L181:
            String r214 = r55.a.c();
            r14.a0 r80 = r55.a.d;
            if (r80 == null) goto L187;
            String r81 = r80.a();
            if (r81 == null) goto L187;
            String r215 = r81;
        L188:
            r126.i1(r68, r75, r76, r212, r77, r213, r214, r215, r211, String.valueOf(r55.a.i()), MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("hit_video_cache", Integer.valueOf(r50 ? 1 : 0)), TuplesKt.to("hit_aweme_cache", Integer.valueOf(r55.a.o ? 1 : 0)), TuplesKt.to("open_feed_cost", Long.valueOf(r56.h)), TuplesKt.to("network_api_cost", Long.valueOf(r56.j)), TuplesKt.to("video_load_cost", Long.valueOf(r56.k)), TuplesKt.to("user_interface_cost", Long.valueOf(r56.l)), TuplesKt.to("item_ui_cost", Long.valueOf(r56.m)), TuplesKt.to("click_feed_timestamp", Long.valueOf(r56.a)), TuplesKt.to("open_feed_timestamp", Long.valueOf(r56.b)), TuplesKt.to("start_network_timestamp", Long.valueOf(r56.c)), TuplesKt.to("finish_network_timestamp", Long.valueOf(r56.d)), TuplesKt.to("video_request_timestamp", Long.valueOf(r56.e)), TuplesKt.to("first_frame_timestamp", Long.valueOf(r56.f))}), null);
            r0 = null;
            j04.b.a = null;
            r1 = r1;
        L187:
            r215 = r8;
        L180:
            r213 = r8;
            goto L181
        L171:
            if (r55.e == true) goto L173;
            r212 = 1;
        L165:
            r73 = "";
            goto L166
        L157:
            r70 = null;
        L167:
            r211 = r8;
            goto L169
        L151:
            long r82 = System.currentTimeMillis();
            r56.f = r82;
            r56.i = r82 - r56.n;
            goto L152
        L191:
            r0 = null;
            goto L192
        L10:
            final com.bytedance.awemeopen.apps.framework.framework.viewpager.o r83 = r1.e.c;
            jz3.a r84 = r1.H;
            if (r84 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r84 = null;
        L13:
            final String r85 = r84.a.r().c;
            final Ref.BooleanRef r86 = new Ref.BooleanRef();
            final ?? r87 = new a0(r86, r1, r83, r85);
            ViewGroup r127 = r1.e.b;
            if ((r127 instanceof VerticalViewPager) == false) goto L16;
            VerticalViewPager r128 = (VerticalViewPager) r127;
        L17:
            if (r128 != null) goto L19;
        L21:
            boolean r129 = false;
        L22:
            if (r129 == false) goto L29;
            final c0 r130 = new c0(r1, r86, r87);
            Runnable r131 = new b0(r86, r87, r1, r130);
            View r88 = r1.m;
            if (r88 == null) goto L26;
            r88.postDelayed(r131, 200);
        L26:
            ViewTreeObserver r89 = r1.j.getVideoViewWrapper().getViewTreeObserver();
            if (r89 == null) goto L32;
            r89.addOnGlobalLayoutListener(r130);
        L32:
            final Ref.LongRef r90 = new Ref.LongRef();
            View r91 = r1.m;
            if (r91 == null) goto L35;
            r91.setOnClickListener(new r(r90, r1, r83, r85));
            goto L35
        L29:
            ?? r92 = r1.m;
            if (r92 == 0) goto L32;
            r92.post(r87);
            goto L32
        L19:
            if (r128.getCurrentItem() != 0) goto L21;
            r129 = true;
            goto L22
        L16:
            r128 = null;
            goto L17
        }

        public final void f(String r5, boolean r6, int r7, int r8) {
            if (r6 == false) goto L5;
            if (r5 == null) goto L18;
            d r9 = this.a.put(r5, new d(r7, SystemClock.elapsedRealtime(), 4));
            return;
        L18:
            return;
        L5:
            if (r5 == null) goto L20;
            VideoFeedPlayerPresenter r10 = this.b;
            d r11 = this.a.get(r5);
            if (r11 != null) goto L9;
            return;
        L9:
            if (r11.b <= 0) goto L22;
            long r0 = SystemClock.elapsedRealtime() - r11.b;
            LinkedHashMap r12 = new LinkedHashMap();
            r12.put("enter_from", r10.e.c.sceneId());
            r12.put("duration", Long.valueOf(r0));
            r12.put("block_type", String.valueOf(r11.a));
            jz3.a r13 = r10.H;
            if (r13 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r13 = null;
        L13:
            r12.put("vduration", Integer.valueOf(r13.a.q()));
            jz3.a r14 = r10.H;
            if (r14 != null) goto L16;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r14 = null;
        L16:
            r12.put("group_id", r14.a.c());
            d14.a r15 = b14.a.a;
            b14.a.a(d34.a.class).F2("video_block", r12, null);
            this.a.remove(r5);
            return;
        L22:
            return;
        }
    }

    public static final class g implements FeedPlayerHelper.c {
        public final /* synthetic */ VideoFeedPlayerPresenter a;

        @Override // com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper.c
        public final void a() {
            if (this.a.e.e.d.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L5;
            return;
        L5:
            d14.a r0 = b14.a.a;
            x24.a r1 = b14.a.a(x24.a.class);
            jz3.a r2 = this.a.H;
            if (r2 != null) goto L9;
            Intrinsics.throwUninitializedPropertyAccessException("data");
            r2 = null;
        L9:
            if (r1.v3(r2.a) == true) goto L12;
            this.a.e.c.doAutoPlay();
            return;
        }

        public g(VideoFeedPlayerPresenter r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final float p() {
        Object[] r0 = new Object[1];
        StringBuilder r1 = new StringBuilder("get speed: ");
        com.bytedance.awemeopen.infra.base.player.g r2 = this.k.getCustomPlayer();
        if (r2 == null) goto L5;
        Float r3 = Float.valueOf(r2.getPlaySpeed());
    L6:
        r1.append(r3);
        r0[0] = r1.toString();
        AoLogger.b("VideoFeedPlayerPresenter", r0);
        com.bytedance.awemeopen.infra.base.player.g r4 = this.k.getCustomPlayer();
        if (r4 != null) goto L11;
        return 1.0f;
    L11:
        return r4.getPlaySpeed();
    L5:
        r3 = null;
        goto L6
    }

    @Override // g04.a
    public final void g() {
        jz3.a r1 = null;
        if (this.i == true) goto L5;
        com.bytedance.awemeopen.apps.framework.landscape.g.b(null);
    L5:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r0 = this.f;
        r0.c = 0;
        r0.d = 0;
        r0.e = 0;
        r0.f = 0;
        r0.g = 0;
        r0.h = 0;
        this.e.c.addPlayStateListener(this.F);
        this.e.c.setVideoAutoPlayListener(this.z);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = this.e;
        r2.c.addPauseOrPlayObserver(r2.e.d, this.n);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = this.e;
        r3.c.observeCommentShowState(r3.e.d, this.o);
        if (this.y == true) goto L9;
        v();
    L9:
        if (Intrinsics.areEqual(this.e.c.getFeedHomeContainerDeliverHiddenState().getValue(), Boolean.TRUE) == false) goto L11;
    L12:
        t(false);
    L13:
        int r4 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r5 = this.e;
        jz3.a r6 = this.H;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r6 = null;
    L16:
        Intrinsics.checkNotNullParameter(r5, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r6, "data");
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a(r6, r5) == false) goto L24;
        r5.f.e();
        Object[] r7 = new Object[1];
        StringBuilder r8 = new StringBuilder();
        User r9 = r6.a.f();
        if (r9 == null) goto L22;
        String r10 = r9.t();
    L23:
        r8.append(r10);
        r8.append(" resumeImpression");
        r7[0] = r8.toString();
        AoLogger.l("ImpressionHelper", r7);
        goto L24
    L22:
        r10 = null;
    L24:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r11 = this.f;
        AosEventReporter r12 = AosEventReporter.a;
        String r13 = this.e.c.sceneId();
        jz3.a r14 = this.H;
        if (r14 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r14 = null;
    L27:
        r12.getClass();
        r11.b = AosEventReporter.a(r13, r14);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r15 = this.f;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r16 = this.e;
        jz3.a r17 = this.H;
        if (r17 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r17 = null;
    L30:
        r15.c(r16, r17);
        d14.a r18 = b14.a.a;
        t24.a r19 = b14.a.a(t24.a.class);
        String r20 = this.e.c.sceneId();
        jz3.a r21 = this.H;
        if (r21 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r21 = null;
    L33:
        r19.M2(r20, r21.a, this.f.b);
        k54.c r22 = iz3.a.c(this.e);
        if (r22 == null) goto L40;
        jz3.a r23 = this.H;
        if (r23 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L39:
        r22.j(new k54.b.h(r1.a.c(), 1));
        goto L40
    L38:
        r1 = r23;
    L40:
        com.bytedance.awemeopen.apps.framework.utils.audio.a r24 = iz3.a.a(this.e);
        if (r24 == null) goto L47;
        a r25 = this.v;
        if (r25 == null) goto L47;
        if (((ArrayList) r24.c).contains(r25) == true) goto L47;
        ((ArrayList) r24.c).add(r25);
    L47:
        this.e.c.getEnterPinchMode().observe(this.e.e.d, this.J);
        return;
    L11:
        if (this.e.c.isFeedVisible() == true) goto L13;
        goto L12
    }

    @Override // g04.a
    public final void h() {
        this.e.c.getFeedHomeContainerSelectedIndex().removeObserver(this.p);
        this.e.c.getFeedHomeContainerDeliverHiddenState().removeObserver(this.q);
        LiveDataBus r0 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.c.class).removeObserver(this.I);
        w();
    }

    @Override // g04.a
    public final void i() {
        if (this.i == true) goto L5;
        com.bytedance.awemeopen.apps.framework.landscape.g.b(null);
    L5:
        this.e.c.getEnterPinchMode().removeObserver(this.J);
        this.l.a.setVisibility(8);
        jz3.a r1 = this.H;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r1 = null;
    L8:
        r1.e = true;
        this.e.c.removePlayStateListener(this.F);
        this.e.c.removeVideoAutoPlayListener();
        int r2 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r3 = this.e;
        jz3.a r5 = this.H;
        if (r5 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r5 = null;
    L11:
        Intrinsics.checkNotNullParameter(r3, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r5, "data");
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a(r5, r3) == false) goto L24;
        d14.a r7 = b14.a.a;
        w24.d r8 = b14.a.a(w24.d.class);
        String r10 = r5.a.c();
        r14.a0 r11 = r5.a.d;
        if (r11 == null) goto L18;
        String r12 = r11.a();
        if (r12 == null) goto L18;
    L19:
        r8.J0(r10, r12);
        g54.b r4 = r3.f;
        r4.b();
        r4.d();
        Object[] r6 = new Object[1];
        StringBuilder r9 = new StringBuilder();
        User r13 = r5.a.f();
        if (r13 == null) goto L22;
        String r14 = r13.t();
    L23:
        r9.append(r14);
        r9.append(" pauseAndSaveImpression");
        r6[0] = r9.toString();
        AoLogger.l("ImpressionHelper", r6);
        goto L24
    L22:
        r14 = null;
    L18:
        r12 = "";
    L24:
        AosEventReporter r15 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r16 = this.e;
        jz3.a r17 = this.H;
        if (r17 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r17 = null;
    L27:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r18 = this.f;
        r15.getClass();
        AosEventReporter.R(r16, r17, r18);
        if (this.y == false) goto L30;
    L38:
        d14.a r19 = b14.a.a;
        x24.a r20 = b14.a.a(x24.a.class);
        jz3.a r21 = this.H;
        if (r21 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r21 = null;
    L42:
        if (r20.v3(r21.a) == true) goto L76;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r22 = this.e;
        jz3.a r23 = this.H;
        if (r23 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r23 = null;
    L46:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r24 = this.f;
        Intrinsics.checkNotNullParameter(r22, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r23, "data");
        Intrinsics.checkNotNullParameter(r24, "eventRecorder");
        String r110 = r22.c.sceneId();
        long r111 = r24.a();
        Video r25 = r23.a.P();
        if (r25 == null) goto L49;
        int r26 = r25.getVideoLength();
    L50:
        if (r26 != 0) goto L52;
        AoLogger.c(AosEventReporter.b, new Object[]{"video length 0!"});
        goto L76
    L52:
        float r27 = new BigDecimal(r111).divide(new BigDecimal(r26), 2, 4).floatValue();
        if (r24.c <= 0) goto L55;
        float r28 = 1.0f;
    L56:
        double r112 = Math.min(Math.round(100 * r27), 100.0f);
        int r29 = r24.c;
        if (Intrinsics.areEqual(r110, "others_homepage") == false) goto L64;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r113 = r22.c;
        if ((r113 instanceof AosUserProfileFeedFragmentViewModel) == false) goto L61;
        AosUserProfileFeedFragmentViewModel r114 = (AosUserProfileFeedFragmentViewModel) r113;
    L62:
        if (r114 == null) goto L64;
        String r115 = r114.getFromGroupId();
    L65:
        FeedPageConfig r30 = r22.c.getPageConfig();
        t24.a r116 = b14.a.a(t24.a.class);
        String r31 = r30.getHostEnterFrom();
        String r32 = r23.a.c();
        String r33 = AosEventReporter.b(r23.a, r30);
        if (r33 != null) goto L68;
        r33 = "";
    L68:
        r14.a0 r117 = r23.a.d;
        if (r117 == null) goto L74;
        String r118 = r117.a();
        if (r118 == null) goto L74;
        String r210 = r118;
    L75:
        String r119 = GsonProtectorUtils.toJson(GsonHolder.a(), r23.a.d);
        boolean r120 = AosEventReporter.e(r23.a);
        boolean r211 = r30.isCardMode();
        int r121 = r23.a.i();
        boolean r34 = r24.b;
        r14.c r35 = r23.a;
        r116.i2(r110, r31, r32, r33, r210, r115, r119, r120, r121, r211, r112, r28, r111, Float.valueOf(r27), r29, r34, r35.t, null, null, r35.r().a, r30.getHostExtraParams(), new HostCommonParamProvider(r30.getHostCommonParams()));
    L74:
        r210 = "";
        goto L75
    L61:
        r114 = null;
    L64:
        r115 = "";
        goto L65
    L55:
        r28 = r22.c.getCurrentPosition() / r26;
        goto L56
    L49:
        Integer r36 = 0;
        AwemeCheckUtilsKt.a(r36, null, 3);
        r26 = r36.intValue();
    L76:
        this.f.b = false;
        this.r = false;
        this.e.c.removePauseOrPlayObserver(this.n);
        this.e.c.removeObserveCommentShowState(this.o);
        k54.c r37 = iz3.a.c(this.e);
        if (r37 == null) goto L82;
        jz3.a r38 = this.H;
        if (r38 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r38 = null;
    L81:
        r37.j(new k54.b.i(r38.a.c(), 1));
    L82:
        com.bytedance.awemeopen.apps.framework.utils.audio.a r39 = iz3.a.a(this.e);
        if (r39 == null) goto L85;
        TypeIntrinsics.asMutableCollection(r39.c).remove(this.v);
    L85:
        w();
        return;
    L30:
        if (q() == false) goto L38;
        m(false);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r40 = this.e;
        jz3.a r41 = this.H;
        if (r41 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r41 = null;
    L34:
        AosEventReporter.L(r40, r41, o(), null);
        this.e.c.setOverType("next_video");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r42 = this.e;
        jz3.a r43 = this.H;
        if (r43 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r43 = null;
    L37:
        AosEventReporter.M(r15, r42, r43);
        goto L38
    }

    public final void n() {
        Lifecycle.State r0 = this.e.e.d.getLifecycle().getCurrentState();
        AoLogger.b("VideoFeedPlayerPresenter", new Object[]{hashCode() + " controlPlayVideo, " + r0});
        if (r0 == Lifecycle.State.RESUMED) goto L5;
        return;
    L5:
        this.e.c.setPlayTimeDurationRecord(System.currentTimeMillis());
        this.e.c.setPostPlayTimeDurationRecord(System.currentTimeMillis());
        com.bytedance.awemeopen.apps.framework.utils.audio.a r1 = iz3.a.a(this.e);
        if (r1 == null) goto L9;
        r1.e(new VideoFeedPlayerPresenter$controlPlayVideo$1(this));
        return;
    }

    public final long o() {
        if (this.K != 0) goto L5;
        return 0;
    L5:
        long r0 = System.currentTimeMillis() - this.K;
        this.K = 0;
        return r0;
    }

    public final boolean q() {
        if (this.e.c.getPlayerController().playerIsPlaying() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.e.c.getPlayerController().b() == true) goto L8;
        return false;
    }

    public final void s() {
        if (this.t == false) goto L5;
        return;
    L5:
        jz3.a r1 = null;
        if (q() == false) goto L21;
        m(true);
        AosEventReporter r0 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r5 = this.e;
        jz3.a r6 = this.H;
        if (r6 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r6 = null;
    L10:
        long r7 = o();
        r0.getClass();
        AosEventReporter.L(r5, r6, r7, null);
        this.e.c.setOverType("pause");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = this.e;
        jz3.a r8 = this.H;
        if (r8 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r8 = null;
    L13:
        AosEventReporter.M(r0, r2, r8);
        k54.c r3 = iz3.a.c(this.e);
        if (r3 == null) goto L33;
        jz3.a r9 = this.H;
        if (r9 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L19:
        r3.j(new k54.b.d(r1.a.c(), 1, 1));
        return;
    L18:
        r1 = r9;
        goto L19
    L33:
        return;
    L21:
        if (this.e.c.getPlayerController().a() == false) goto L35;
        this.e.c.setStartType("pause");
        AosEventReporter r4 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r10 = this.e;
        jz3.a r11 = this.H;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r11 = null;
    L25:
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r12 = this.f;
        r4.getClass();
        AosEventReporter.N(r10, r11, r12);
        y();
        n();
        k54.c r13 = iz3.a.c(this.e);
        if (r13 == null) goto L36;
        jz3.a r14 = this.H;
        if (r14 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L31:
        r13.j(new k54.b.g(r1.a.c(), 1, 1));
        return;
    L30:
        r1 = r14;
        goto L31
    L36:
        return;
    }

    public final void v() {
        if (((Boolean) this.B.getValue()).booleanValue() == true) goto L6;
    L8:
        boolean r0 = false;
    L9:
        if (r0 == false) goto L12;
        this.x = true;
        return;
    L12:
        this.l.a.setVisibility(8);
        AoVideoView r1 = this.k;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r2 = this.e.c;
        jz3.a r3 = this.H;
        if (r3 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L15:
        r1.e(r2.toPlayRequest(r3.a));
        com.bytedance.awemeopen.apps.framework.utils.audio.a r4 = iz3.a.a(this.e);
        if (r4 == null) goto L18;
        r4.e(new VideoFeedPlayerPresenter$prepare$1(this));
    L18:
        LinkedHashMap r5 = new LinkedHashMap();
        r5.put("enter_from", this.e.c.sceneId());
        jz3.a r6 = this.H;
        if (r6 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r6 = null;
    L21:
        r5.put("group_id", r6.a.c());
        jz3.a r7 = this.H;
        if (r7 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r7 = null;
    L24:
        User r8 = r7.a.f();
        String r9 = "";
        if (r8 == null) goto L28;
        String r10 = r8.u();
        if (r10 == null) goto L28;
    L29:
        r5.put("author_openid", r10);
        jz3.a r11 = this.H;
        if (r11 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r11 = null;
    L32:
        r14.a0 r12 = r11.a.d;
        if (r12 == null) goto L38;
        String r13 = r12.a();
        if (r13 == null) goto L38;
        r9 = r13;
    L38:
        r5.put("impr_id", r9);
        Gson r14 = GsonHolder.a();
        jz3.a r15 = this.H;
        if (r15 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r15 = null;
    L41:
        r5.put("log_pb", GsonProtectorUtils.toJson(r14, r15.a.d));
        jz3.a r16 = this.H;
        if (r16 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r16 = null;
    L44:
        r5.put("aweme_type", Integer.valueOf(r16.a.i()));
        d14.a r17 = b14.a.a;
        b14.a.a(d34.a.class).F2("video_request", r5, null);
        j04.a r18 = j04.b.a;
        long r19 = System.currentTimeMillis();
        j04.a r20 = j04.b.a;
        if (r20 == null) goto L48;
        r20.e = r19;
        return;
    L48:
        return;
    L28:
        r10 = "";
        goto L29
    L6:
        if (this.e.e.d.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L8;
        r0 = true;
        goto L9
    }

    public final void w() {
        this.D = -1.0f;
        this.E = 1.0f;
        this.C = 0;
        this.r = false;
        this.s = true;
        View r0 = this.m;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
    L6:
        com.bytedance.awemeopen.infra.base.player.g r1 = this.k.getCustomPlayer();
        if (r1 == null) goto L14;
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r2 = com.bytedance.awemeopen.apps.framework.landscape.g.a;
        com.bytedance.awemeopen.infra.base.player.g r3 = this.k.getCustomPlayer();
        if (Intrinsics.areEqual(com.bytedance.awemeopen.apps.framework.landscape.g.a.get(), r3) == false) goto L11;
        return;
    L11:
        if (this.y == true) goto L16;
        r1.d(this.E);
        return;
    L16:
        return;
    }

    public final void y() {
        if (this.K != 0) goto L6;
        this.K = System.currentTimeMillis();
        return;
    }

    public final void r() {
        if (q() == false) goto L7;
        s();
        return;
    L7:
        if (this.e.c.getPlayerController().a() == false) goto L10;
        this.l.b();
        return;
    }

    @Override // g04.a
    public final void f(jz3.a r18) {
        jz3.a r2 = r18;
        Intrinsics.checkNotNullParameter(r2, "data");
        this.H = r2;
        boolean r3 = false;
        this.t = false;
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r0 = com.bytedance.awemeopen.apps.framework.landscape.g.a;
        com.bytedance.awemeopen.infra.base.player.g r1 = this.k.getCustomPlayer();
        this.y = Intrinsics.areEqual(com.bytedance.awemeopen.apps.framework.landscape.g.a.get(), r1);
        if (this.i == false) goto L5;
        this.l.a.setOnClickListener(new d0(this));
    L5:
        this.e.c.getFeedHomeContainerSelectedIndex().observe(this.e.e.d, this.p);
        this.e.c.getFeedHomeContainerDeliverHiddenState().observe(this.e.e.d, this.q);
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4 = this.e;
        g54.b r5 = r4.f;
        View r6 = r4.a;
        g54.c r7 = new g54.c();
        if (TextUtils.isEmpty(r2.a.r().c) == false) goto L9;
        r2.a.getClass();
    L9:
        JSONObject r8 = r7.a;
        r14.a0 r9 = r2.a.d;
        if (r9 == null) goto L13;
        String r10 = r9.a();
        if (r10 == null) goto L13;
    L14:
        r8.put("impr_id", r10);
        r7.a.put("group_source", r2.a.r().a);
        if (Intrinsics.areEqual(this.e.c.sceneId(), "compilation_play") == false) goto L17;
        r7.a.put("channel_id", "94349597794");
    L18:
        Unit r11 = Unit.INSTANCE;
        r5.c(r6, r7, this.e.c.sceneId());
        if (Intrinsics.areEqual(com.bytedance.awemeopen.apps.framework.landscape.g.d, Boolean.FALSE) == true) goto L21;
    L25:
        this.l.a.setVisibility(8);
    L27:
        if (r2.a.P() == null) goto L86;
        String r12 = r2.a.u();
        if (r12 != null) goto L32;
    L47:
        boolean r13 = false;
    L48:
        Video r14 = r2.a.P();
        if (r14 == null) goto L76;
        FullVideoView r15 = this.j;
        int r16 = r14.getWidth();
        int r17 = r14.getHeight();
        boolean r19 = this.e.c.getPageConfig().getFullScreen();
        Context r20 = getContext();
        r14.d0 r110 = r2.a.B();
        boolean r111 = this.i;
        r15.getClass();
        Intrinsics.checkNotNullParameter(r20, "context");
        if (r13 == false) goto L53;
        c64.a r21 = new c64.a();
    L54:
        r15.a.setSizeCalculator(r21);
        AoVideoView r22 = r15.a;
        Size r23 = r22.c.getSize();
        c64.b r24 = r22.d.a(r16, r17, r23.getWidth(), r23.getHeight());
        Size r25 = r24.a;
        FrameLayout.LayoutParams r112 = new FrameLayout.LayoutParams(r25.getWidth(), r25.getHeight());
        r112.gravity = 17;
        r22.setLayoutParams(r112);
        Size r26 = r24.a;
        VideoScaleModel r113 = r24.c;
        double r114 = (((double) r16) * 1.0d) / ((double) r17);
        int r115 = l04.a.a;
        JSONObject r116 = AoSettings.a("ao_full_screen_adapt");
        double r27 = 0.75d;
        if (r116 == null) goto L58;
        r27 = r116.optDouble("adaptation_ratio_of_width_to_height", 0.75d);
    L58:
        if (r114 <= r27) goto L60;
    L67:
        x54.b.a(r15.f);
        x54.b.a(r15.g);
        x54.b.a(r15.c);
    L68:
        if (r16 <= r17) goto L71;
        if (r111 == true) goto L71;
        r3 = true;
    L71:
        if (r3 == true) goto L73;
    L75:
        FrameLayout.LayoutParams r28 = new FrameLayout.LayoutParams(r15.a.getLayoutParams().width, r15.a.getLayoutParams().height);
        r28.gravity = 17;
        r15.b.setLayoutParams(r28);
        r15.b.setScaleType(r24.b);
        RelativeLayout.LayoutParams r29 = new RelativeLayout.LayoutParams(-2, -2);
        r29.addRule(13, -1);
        r15.e.setLayoutParams(r29);
    L77:
        this.e.e.d.getLifecycle().addObserver(this.G);
        com.bytedance.awemeopen.apps.framework.player.e r30 = this.g;
        if (r30 == null) goto L80;
        r30.a(new com.bytedance.awemeopen.apps.framework.player.f(this.k, this.e.c.toPlayRequest(r2.a), r2.d));
    L80:
        LiveDataBus r31 = LiveDataBus.c;
        LiveDataBus.a.a(gz3.c.class).observeForever(this.I);
        return;
    L73:
        if (com.bytedance.awemeopen.apps.framework.landscape.f.d == false) goto L75;
        r15.i = new com.bytedance.awemeopen.apps.framework.player.b(r15, r24);
        r15.e.getViewTreeObserver().addOnPreDrawListener(r15.i);
        goto L77
    L60:
        if (r113 != VideoScaleModel.FIT) goto L67;
        JSONObject r32 = AoSettings.a("ao_full_screen_adapt");
        if (r32 == null) goto L64;
        boolean r33 = r32.optBoolean("adaptation_use_static_gaussian", false);
    L65:
        if (r33 == false) goto L67;
        int r34 = (int) (((double) r26.getHeight()) * 0.02d);
        r15.f.getLayoutParams().height = r34;
        r15.g.getLayoutParams().height = r34;
        int r35 = j64.b.a;
        AoImageService r36 = j64.a.a(AoImageService.class);
        Intrinsics.checkNotNull(r36);
        Context r37 = r15.getContext();
        com.bytedance.awemeopen.infra.base.image.b r117 = new com.bytedance.awemeopen.infra.base.image.b(r15.h);
        r117.q = 20;
        r117.d = r15.c;
        r117.k = new com.bytedance.awemeopen.apps.framework.player.c(r15, r26, r34);
        r36.e1(r37, r117.a());
        x54.b.d(r15.f);
        x54.b.d(r15.g);
        x54.b.d(r15.c);
        goto L68
    L64:
        r33 = false;
        goto L65
    L53:
        r21 = new k04.a(r19, r20, r110);
        goto L54
    L76:
        AwemeCheckUtilsKt.a(this, r2.a, 2);
        goto L77
    L32:
        if (r12.length() <= 0) goto L34;
        boolean r38 = true;
    L35:
        if (r38 == false) goto L47;
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L44
        if (new JSONObject(r12).optInt("video_type", 0) != 1) goto L39;
        r13 = true;
    L82:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L42
    L42:
        th = th;
    L46:
        Result.Companion r40 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L48
    L39:
        r13 = false;
    L44:
        th = th;
        r13 = false;
        goto L46
    L34:
        r38 = false;
        goto L35
    L86:
        return;
    L21:
        if (this.y == false) goto L25;
        if (this.i == false) goto L25;
        this.l.b();
        goto L27
    L17:
        r7.a.put("channel_id", "94349593515");
    L13:
        r10 = "";
        goto L14
    }

    public final void m(boolean r4) {
        AoLogger.b("VideoFeedPlayerPresenter", new Object[]{hashCode() + " controlPauseVideo, withUI: " + r4});
        if (r4 == false) goto L5;
        this.l.b();
    L5:
        this.k.d();
        this.f.b();
        if (this.y == true) goto L8;
        return;
    L8:
        if (this.i == false) goto L13;
        if (r4 == false) goto L14;
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r5 = com.bytedance.awemeopen.apps.framework.landscape.g.a;
        com.bytedance.awemeopen.apps.framework.landscape.g.b(Boolean.FALSE);
        return;
    L14:
        return;
    }

    public final void t(boolean r10) {
        AoLogger.b("VideoFeedPlayerPresenter", new Object[]{hashCode() + " performOnPause, isSelected: " + this.d + ", readyPause: " + q()});
        if (this.d == false) goto L42;
        int r1 = com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r2 = this.e;
        jz3.a r3 = this.H;
        jz3.a r4 = null;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L7:
        Intrinsics.checkNotNullParameter(r2, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r3, "data");
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.j.a(r3, r2) == false) goto L16;
        r2.f.b();
        Object[] r5 = new Object[1];
        StringBuilder r6 = new StringBuilder();
        User r7 = r3.a.f();
        if (r7 == null) goto L13;
        String r8 = r7.t();
    L14:
        r6.append(r8);
        r6.append(" pauseImpression");
        r5[0] = r6.toString();
        AoLogger.l("ImpressionHelper", r5);
        goto L16
    L13:
        r8 = null;
    L16:
        if (q() == true) goto L18;
        return;
    L18:
        if (this.e.c.ignorePageStatusControl() == false) goto L20;
        return;
    L20:
        if (this.e.c.getPageConfig().getIgnoreUserPauseOrPlay() == false) goto L22;
    L24:
        m(false);
        AosEventReporter r9 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r11 = this.e;
        jz3.a r12 = this.H;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r12 = null;
    L27:
        long r13 = o();
        String r14 = this.w;
        r9.getClass();
        AosEventReporter.L(r11, r12, r13, r14);
        this.e.c.setOverType("pause");
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r15 = this.e;
        jz3.a r16 = this.H;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r16 = null;
    L30:
        AosEventReporter.M(r9, r15, r16);
        if (r10 == false) goto L33;
        int r17 = 3;
    L34:
        k54.c r18 = iz3.a.c(this.e);
        if (r18 == null) goto L45;
        jz3.a r19 = this.H;
        if (r19 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L40:
        r18.j(new k54.b.d(r4.a.c(), 1, r17));
        return;
    L39:
        r4 = r19;
        goto L40
    L45:
        return;
    L33:
        r17 = 4;
        goto L34
    L22:
        if (this.l.a() == false) goto L24;
        return;
    }

    public final void u(boolean r5) {
        AoLogger.b("VideoFeedPlayerPresenter", new Object[]{hashCode() + " performOnResume, isSelected: " + this.d + ", readyPause: " + q()});
        if (this.d == true) goto L5;
        return;
    L5:
        if (this.e.c.isInFeedPage() == true) goto L7;
        return;
    L7:
        if (this.e.c.ignorePageStatusControl() == false) goto L9;
        return;
    L9:
        if (this.e.c.getPageConfig().getIgnoreUserPauseOrPlay() == false) goto L11;
    L13:
        y();
        n();
        if (r5 == false) goto L16;
        int r6 = 3;
    L17:
        k54.c r1 = iz3.a.c(this.e);
        if (r1 == null) goto L27;
        jz3.a r3 = this.H;
        if (r3 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L22:
        r1.j(new k54.b.g(r3.a.c(), 1, r6));
        return;
    L27:
        return;
    L16:
        r6 = 4;
        goto L17
    L11:
        if (this.l.a() == false) goto L13;
    }

    public final void x(float r11, boolean r12) {
        boolean r0 = true;
        AoLogger.b("VideoFeedPlayerPresenter", new Object[]{"set speed: " + r11});
        com.bytedance.awemeopen.infra.base.player.g r1 = this.k.getCustomPlayer();
        if (r1 == null) goto L19;
        r1.d(r11);
        this.E = r11;
        if (r12 == true) goto L8;
    L17:
        this.D = r11;
        return;
    L8:
        if (this.D == (-1.0f)) goto L11;
        r0 = false;
    L11:
        if (r0 == false) goto L13;
        this.C = r1.getWatchDuration();
        goto L17
    L13:
        long r2 = r1.getWatchDuration();
        long r8 = r2 - this.C;
        AosEventReporter r13 = AosEventReporter.a;
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4 = this.e;
        jz3.a r3 = this.H;
        if (r3 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("data");
        r3 = null;
    L16:
        float r7 = this.D;
        r13.getClass();
        AosEventReporter.Q(r4, r3, "long_press", r7, r8);
        this.C = r2;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.q] */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.t] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.v] */
    /* JADX WARN: Type inference failed for: r4v3, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.w] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.x] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.y] */
    /* JADX WARN: Type inference failed for: r4v6, types: [com.bytedance.awemeopen.apps.framework.feed.pages.recommend.presenter.z] */
    public VideoFeedPlayerPresenter(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.a r4, com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.p r5, com.bytedance.awemeopen.apps.framework.player.e r6, Function1<? super String, Long> r7) {
        Intrinsics.checkNotNullParameter(r4, "feedGroupParameters");
        Intrinsics.checkNotNullParameter(r5, "eventRecorder");
        super(r4.a);
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        boolean r8 = r4.getActivity() instanceof VideoLandscapeActivity;
        this.i = r8;
        FullVideoView r9 = (FullVideoView) e(2131375746);
        this.j = r9;
        final AoVideoView r10 = r9.getVideoView();
        this.k = r10;
        this.l = new b((ImageView) e(2131381974), r8, r4.c);
        this.m = this.a.findViewById(2131373353);
        this.s = true;
        this.z = new g(this);
        this.A = LazyKt.lazy(new VideoFeedPlayerPresenter$feedLongPressFastSpeedPresenter$2(this));
        this.B = LazyKt.lazy(VideoFeedPlayerPresenter$isEnablePrepareFix$2.INSTANCE);
        this.D = -1.0f;
        this.E = 1.0f;
        this.F = new f(this);
        this.I = new q(this);
        this.J = new t(this);
        r10.setCustomPlayer(r4.c.getPlayer());
        WeakReference<com.bytedance.awemeopen.infra.base.player.g> r0 = com.bytedance.awemeopen.apps.framework.landscape.g.a;
        AoLogger.b("land_player_holder", new Object[]{"enable, " + com.bytedance.awemeopen.apps.framework.landscape.g.e + ", peek is " + com.bytedance.awemeopen.apps.framework.landscape.g.b.get()});
        final SurfaceTexture r11 = com.bytedance.awemeopen.apps.framework.landscape.g.b.get();
        final com.bytedance.awemeopen.infra.base.player.surface.j r1 = new com.bytedance.awemeopen.infra.base.player.surface.j(r11, null, 5);
        r10.setSurfaceSource(r1);
        r10.setScaleContainer(r4.b);
        if (r11 == null) goto L6;
        if (r8 == false) goto L6;
        r10.postDelayed(new u(r10, r11, r1), com.bytedance.awemeopen.apps.framework.landscape.f.c);
    L6:
        this.G = new v(this);
        this.n = new w(this);
        this.o = new x(this);
        this.p = new y(this);
        this.q = new z(this);
        this.v = new a(this);
    }
}
