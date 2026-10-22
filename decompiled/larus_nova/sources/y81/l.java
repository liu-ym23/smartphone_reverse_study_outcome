package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewmodel.AbsOpenFeaturePanelViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.ILiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.slf4j.Marker;
import zg1.w1;

/* JADX INFO: loaded from: classes47.dex */
public final class l extends y81.b {
    public static final /* synthetic */ int U = 0;
    public TextSwitcher A;
    public TextSwitcher B;
    public TextSwitcher C;
    public TextSwitcher D;
    public TextSwitcher E;
    public TextSwitcher F;
    public TextView G;
    public TextSwitcher H;
    public String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public List<TextSwitcher> f566774J;
    public Disposable K;
    public final CompositeDisposable L;
    public Dialog M;
    public int N;
    public IRoom O;
    public Integer P;
    public int Q;
    public int R;
    public boolean S;
    public boolean T;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f566775j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f566776k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f566777l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f566778m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f566779n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public HSImageView f566780o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextSwitcher f566781p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f566782q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f566783r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final List<String> f566784s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public RelativeLayout f566785t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public StrokeTextView f566786u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public LottieAnimationView f566787v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ValueAnimator f566788w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ValueAnimator f566789x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ValueAnimator f566790y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f566791z;

    public static final class a {
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566792a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            int r101 = r100.what;
            if (r101 == 1) goto L26;
            if (r101 != 2) goto L6;
            l r102 = this.f566792a;
            ValueAnimator r103 = r102.f566788w;
            if (r103 == null) goto L14;
            r103.cancel();
        L14:
            r102.f566788w = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            Ref.IntRef r104 = new Ref.IntRef();
            r104.element = 0;
            ValueAnimator r105 = r102.f566788w;
            if (r105 == null) goto L17;
            r105.addListener(new x(r102, r104));
            r105.addUpdateListener(new y(r105, r102, r104));
            r105.setDuration(200);
            r105.start();
        L17:
            ValueAnimator r106 = r102.f566790y;
            if (r106 == null) goto L20;
            r106.cancel();
        L20:
            ValueAnimator r107 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
            r102.f566790y = r107;
            if (r107 == null) goto L23;
            r107.addListener(new z(r102));
            r107.addUpdateListener(new a0(r107, r102));
            r107.setDuration(200);
        L23:
            ValueAnimator r108 = r102.f566790y;
            if (r108 == null) goto L48;
            r108.start();
            return;
        L48:
            return;
        L6:
            if (r101 != 3) goto L54;
            l r109 = this.f566792a;
            if (r109.S == true) goto L46;
            r109.o();
            return;
        L46:
            return;
        L54:
            return;
        L26:
            List<String> r110 = this.f566792a.f566784s;
            if (r110 != null) goto L29;
        L33:
            b r111 = this.f566792a.f566783r;
            if (r111 == null) goto L36;
            r111.sendEmptyMessageDelayed(1, 2000);
        L36:
            l r112 = this.f566792a;
            TextSwitcher r113 = r112.f566781p;
            if (r113 == null) goto L52;
            List<String> r114 = r112.f566784s;
            if (r114 == null) goto L41;
            String r115 = (String) CollectionsKt.firstOrNull(r114);
        L42:
            r113.setText(r115);
            List<String> r116 = this.f566792a.f566784s;
            if (r116 == null) goto L53;
            String r117 = (String) ListProtector.remove(r116, 0);
            return;
        L53:
            return;
        L41:
            r115 = null;
            goto L42
        L52:
            return;
        L29:
            if (((ArrayList) r110).isEmpty() != true) goto L33;
            b r118 = this.f566792a.f566783r;
            if (r118 == null) goto L50;
            r118.sendEmptyMessage(2);
            return;
        }

        public b(l r100, Looper r101) {
            this.f566792a = r100;
            super(r101);
        }
    }

    public static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566793a;

        public c(l r100) {
            this.f566793a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r210) {
            l r100 = this.f566793a;
            String r101 = LiveInfraSettingKeys.DOU_PLUS_INDICATOR_DATA_URL.getValue();
            IRoom r102 = this.f566793a.O;
            if (r102 == null) goto L5;
            Long r103 = Long.valueOf(r102.getId());
        L6:
            IRoom r104 = this.f566793a.O;
            if (r104 == null) goto L12;
            IBaseUser r105 = r104.getOwner();
            if (r105 == null) goto L12;
            Intrinsics.checkNotNullParameter(r105, "$this$secUidExt");
            String r106 = r105.getCastSecUid();
            if (r106 == null) goto L12;
        L13:
            r100.getClass();
            if (com.bytedance.android.live.core.utils.a.d() != null) goto L16;
        L36:
            Object r110 = "dou_plus_order_type";
        L37:
            ILiveDouPlusService r107 = (ILiveDouPlusService) jc1.k.n(ILiveDouPlusService.class);
            HashMap r108 = new HashMap();
            r108.put("target_step", "0");
            if (((Boolean) this.f566793a.f566668f.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L40;
            Object r109 = "my_group";
        L41:
            r108.put("dou_plus_serving_type", r109);
            r108.put("dou_plus_medium", "live_indicator");
            r108.put("dou_plus_entrance_type", "0");
            r108.put("dou_plus_entrance_level", "1");
            r108.put("dou_plus_referer", "live");
            r108.put(r110, "live");
            r107.logEvent(false, "click_dou_plus", "", r108);
            return;
        L40:
            r109 = "other_group";
            goto L41
        L16:
            if (TextUtils.isEmpty(r101) == true) goto L36;
            Uri.Builder r111 = UriProtector.parse(r101).buildUpon().appendQueryParameter(ILiveRoomPlayFragmentConstant.MALL_ENTRANCE_TYPE, "live_play").appendQueryParameter("enter_from", "live_play");
            if (r103 == null) goto L21;
            String r112 = String.valueOf(r103.longValue());
        L22:
            Uri.Builder r113 = r111.appendQueryParameter("room_id", r112).appendQueryParameter("sec_anchor_id", r106).appendQueryParameter(AbsOpenFeaturePanelViewModel.IS_IN_LIVE, "1");
            if (((Boolean) r100.f566668f.get("data_is_anchor", Boolean.FALSE)).booleanValue() == false) goto L25;
            String r114 = "my_group";
        L26:
            Uri.Builder r115 = r113.appendQueryParameter("dou_plus_serving_type", r114).appendQueryParameter("dou_plus_medium", "live_indicator").appendQueryParameter("dou_plus_entrance_type", "0").appendQueryParameter("dou_plus_entrance_level", "1").appendQueryParameter("dou_plus_referer", "live").appendQueryParameter("dou_plus_order_type", "live");
            if (PadConfigUtils.c() == false) goto L29;
        L30:
            r115.appendQueryParameter("is_pad", "1");
        L31:
            q r116 = new q(r100);
            r110 = "dou_plus_order_type";
            HashMap r117 = new HashMap();
            r117.put("is_live", "1");
            r117.put("scene", IPerformanceManager.SCENE_CLICK_DOU_PLUS);
            r117.put("sec_anchor_id", r106);
            ILiveMode r118 = (ILiveMode) r100.f566668f.get("data_live_mode", LiveMode.VIDEO);
            int r119 = h1.f66189a;
            r117.put("live_type", i1.a(r118));
            ILiveDouPlusService r120 = (ILiveDouPlusService) jc1.k.f(ILiveDouPlusService.class);
            if (r120 == null) goto L34;
            Dialog r121 = r120.showDouPlusDialog(ContextUtil.contextToFragmentActivity(com.bytedance.android.live.core.utils.a.d()), r117, r115.build().toString(), r116);
        L35:
            r100.M = r121;
            goto L37
        L34:
            r121 = null;
            goto L35
        L29:
            if (FoldScreenUtils.e() == false) goto L31;
        L25:
            r114 = "other_group";
            goto L26
        L21:
            r112 = null;
        L12:
            r106 = "";
            goto L13
        L5:
            r103 = null;
            goto L6
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566794a;

        public d(l r100) {
            this.f566794a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            w1 r101 = (w1) r100;
            Dialog r102 = this.f566794a.M;
            if (r102 == null) goto L12;
            IRoomContextService r103 = (IRoomContextService) jc1.k.n(IRoomContextService.class);
            l r104 = this.f566794a;
            DataCenter r105 = r104.f566668f;
            IRoom r106 = r104.O;
            if (r106 == null) goto L7;
            long r107 = r106.getId();
        L8:
            com.bytedance.android.livesdk.chatroom.r r108 = r103.getRoomExpService(r105, r107);
            if (r108 == null) goto L13;
            r108.o(r102, r101.f571972b);
            return;
        L13:
            return;
        L7:
            r107 = 0;
            goto L8
        }
    }

    public static final class e extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f566796b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            StrokeTextView r101 = this.f566795a.f566786u;
            if (r101 == null) goto L6;
            r101.setGravity(1);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r101 = this.f566795a;
            LottieAnimationView r102 = r101.f566787v;
            if (r102 != null) goto L5;
            l.l(r101);
        L6:
            b r103 = this.f566795a.f566783r;
            if (r103 == null) goto L9;
            r103.sendEmptyMessageDelayed(1, 4000);
        L9:
            StrokeTextView r104 = this.f566795a.f566786u;
            if (r104 == null) goto L13;
            r104.setGravity(1);
            return;
        L13:
            return;
        L5:
            r102.playAnimation();
            goto L6
        }

        public e(l r100, Ref.IntRef r101) {
            this.f566795a = r100;
            this.f566796b = r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r102 = this.f566795a.f566779n;
            if (r102 == null) goto L5;
            r102.setVisibility(8);
        L5:
            TextSwitcher r103 = this.f566795a.H;
            if (r103 == null) goto L8;
            r103.setVisibility(8);
        L8:
            View r104 = this.f566795a.f566791z;
            if (r104 == null) goto L11;
            r104.setVisibility(8);
        L11:
            HSImageView r105 = this.f566795a.f566780o;
            if (r105 == null) goto L14;
            r105.setVisibility(8);
        L14:
            TextSwitcher r106 = this.f566795a.f566781p;
            if (r106 == null) goto L17;
            r106.setVisibility(0);
        L17:
            TextView r107 = this.f566795a.f566782q;
            if (r107 == null) goto L20;
            r107.setVisibility(0);
        L20:
            Ref.IntRef r108 = this.f566796b;
            ViewGroup r109 = this.f566795a.f566776k;
            if (r109 == null) goto L23;
            int r110 = r109.getWidth();
        L24:
            r108.element = r110;
            l r111 = this.f566795a;
            TextSwitcher r112 = r111.f566781p;
            if (r112 == null) goto L33;
            List<String> r113 = r111.f566784s;
            if (r113 == null) goto L29;
            String r114 = (String) CollectionsKt.firstOrNull(r113);
        L30:
            r112.setCurrentText(r114);
            List<String> r115 = this.f566795a.f566784s;
            if (r115 == null) goto L33;
            String r116 = (String) ListProtector.remove(r115, 0);
            goto L33
        L29:
            r114 = null;
        L33:
            StrokeTextView r117 = this.f566795a.f566786u;
            if (r117 == null) goto L37;
            r117.setGravity(GravityCompat.START);
            return;
        L37:
            return;
        L23:
            r110 = 0;
            goto L24
        }
    }

    public static final class f implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f566798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f566799c;

        public f(ValueAnimator r100, l r101, Ref.IntRef r102) {
            this.f566797a = r100;
            this.f566798b = r101;
            this.f566799c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
            Object r101 = this.f566797a.getAnimatedValue();
            if (r101 == null) goto L19;
            float r102 = ((Float) r101).floatValue();
            ViewGroup r103 = this.f566798b.f566777l;
            if (r103 == null) goto L9;
            float r104 = 52;
            if (this.f566799c.element <= UtilityKotlinExtentionsKt.h(r104)) goto L9;
            ViewGroup.LayoutParams r105 = r103.getLayoutParams();
            r105.width = ((int) ((this.f566799c.element - UtilityKotlinExtentionsKt.h(r104)) * r102)) + ((int) UtilityKotlinExtentionsKt.h(r104));
            r103.setLayoutParams(r105);
        L9:
            RelativeLayout r106 = this.f566798b.f566785t;
            if (r106 == null) goto L14;
            float r107 = 52;
            if (this.f566799c.element <= UtilityKotlinExtentionsKt.h(r107)) goto L14;
            ViewGroup.LayoutParams r108 = r106.getLayoutParams();
            r108.width = (int) ((this.f566799c.element - UtilityKotlinExtentionsKt.h(r107)) * (1 - r102));
            r106.setLayoutParams(r108);
        L14:
            l r109 = this.f566798b;
            r109.r(r109.f566785t, 1 - r102);
            l r110 = this.f566798b;
            float r111 = 3 * r102;
            r110.r(r110.f566782q, r111);
            TextSwitcher r112 = this.f566798b.f566781p;
            if (r112 == null) goto L20;
            r112.setAlpha(r111);
            return;
        L20:
            return;
        L19:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class g extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566800a;

        public g(l r100) {
            this.f566800a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r101 = this.f566800a;
            l.k(r101, r101.f566777l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#80FF356F"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r102 = this.f566800a;
            l.k(r102, r102.f566777l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#29FF356F"));
        }
    }

    public static final class h implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f566802b;

        public h(ValueAnimator r100, l r101) {
            this.f566801a = r100;
            this.f566802b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566801a.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            l r103 = this.f566802b;
            l.k(r103, r103.f566777l, ColorProtector.parseColor("#29FF356F"), r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class i extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566803a;

        public i(l r100) {
            this.f566803a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r101 = this.f566803a;
            l.k(r101, r101.f566777l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r102 = this.f566803a;
            l.k(r102, r102.f566777l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class j implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f566805b;

        public j(ValueAnimator r100, l r101) {
            this.f566804a = r100;
            this.f566805b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566804a.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            l r103 = this.f566805b;
            l.k(r103, r103.f566777l, ColorProtector.parseColor("#26000000"), r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class k extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f566806a;

        public k(l r100) {
            this.f566806a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r101 = this.f566806a;
            r101.r(r101.f566778m, 1.0f);
            l r102 = this.f566806a;
            r102.T = false;
            r102.R = 10;
            List<String> r103 = r102.f566784s;
            if (r103 != null) goto L5;
            return;
        L5:
            if (((ArrayList) r103).isEmpty() == true) goto L11;
            b r104 = this.f566806a.f566783r;
            if (r104 == null) goto L12;
            r104.sendEmptyMessageDelayed(3, 1000);
            return;
        L12:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            l r101 = this.f566806a;
            r101.T = false;
            r101.R = 10;
            l.l(r101);
            Integer r102 = this.f566806a.P;
            if (r102 != null) goto L6;
        L13:
            Integer r103 = this.f566806a.P;
            if (r103 != null) goto L17;
        L21:
            List<String> r104 = this.f566806a.f566784s;
            if (r104 != null) goto L24;
            return;
        L24:
            if (((ArrayList) r104).isEmpty() == true) goto L30;
            b r105 = this.f566806a.f566783r;
            if (r105 == null) goto L31;
            r105.sendEmptyMessageDelayed(3, 1000);
            return;
        L31:
            return;
        L30:
            return;
        L17:
            if (r103.intValue() != 4) goto L21;
            TextSwitcher r106 = this.f566806a.H;
            if (r106 == null) goto L21;
            r106.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_audit));
            goto L21
        L6:
            if (r102.intValue() != 1) goto L13;
            TextSwitcher r107 = this.f566806a.H;
            if (r107 == null) goto L10;
            r107.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_on));
        L10:
            l r108 = this.f566806a;
            int r109 = r108.N;
            if (r109 <= 0) goto L21;
            r108.m(r109);
            goto L21
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r102 = this.f566806a.f566778m;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            l r103 = this.f566806a;
            r103.r(r103.f566778m, 0.0f);
        }
    }

    /* JADX INFO: renamed from: y81.l$l, reason: collision with other inner class name */
    public static final class C8312l implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f566808b;

        public C8312l(ValueAnimator r100, l r101) {
            this.f566807a = r100;
            this.f566808b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566807a.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            l r103 = this.f566808b;
            r103.r(r103.f566778m, r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    static {
    }

    public final void o() {
        i(1);
        this.L.clear();
        if (this.T == false) goto L6;
        this.S = false;
        return;
    L6:
        List<TextSwitcher> r100 = this.f566774J;
        if (r100 == null) goto L22;
        Iterator<T> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L22;
        TextSwitcher r102 = (TextSwitcher) r101.next();
        if (r102 == null) goto L14;
        View r103 = r102.getCurrentView();
    L16:
        if ((r103 instanceof TextView) == false) goto L10;
        View r104 = r102.getCurrentView();
        if (r104 == null) goto L21;
        ((TextView) r104).setTextColor(s1.h(R.color.commonui_white));
        goto L10
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L14:
        r103 = null;
    L22:
        TextView r105 = this.G;
        if (r105 == null) goto L25;
        r105.setTextColor(s1.h(R.color.commonui_white));
    L25:
        this.S = true;
        ValueAnimator r106 = this.f566788w;
        if (r106 == null) goto L28;
        r106.cancel();
    L28:
        this.f566788w = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Ref.IntRef r107 = new Ref.IntRef();
        r107.element = 0;
        ValueAnimator r108 = this.f566788w;
        if (r108 == null) goto L31;
        r108.addListener(new e(this, r107));
        r108.addUpdateListener(new f(r108, this, r107));
        r108.setStartDelay(500);
        r108.setDuration(500);
        r108.start();
    L31:
        ValueAnimator r109 = this.f566790y;
        if (r109 == null) goto L34;
        r109.cancel();
    L34:
        ValueAnimator r110 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#29FF356F")), Integer.valueOf(ColorProtector.parseColor("#80FF356F"))});
        this.f566790y = r110;
        if (r110 == null) goto L37;
        r110.addListener(new g(this));
        r110.addUpdateListener(new h(r110, this));
        r110.setStartDelay(500);
        r110.setDuration(500);
    L37:
        ValueAnimator r111 = this.f566790y;
        if (r111 == null) goto L47;
        r111.start();
        return;
    }

    public final void q() {
        this.Q = -1;
        this.N = 0;
        this.I = null;
        ValueAnimator r100 = this.f566790y;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.f566788w;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.P = -1;
        this.R = 11;
        this.S = false;
        TextSwitcher r102 = this.H;
        if (r102 == null) goto L11;
        r102.setCurrentText("");
    L11:
        TextSwitcher r103 = this.f566781p;
        if (r103 == null) goto L14;
        r103.setCurrentText("");
    L14:
        ViewGroup r104 = this.f566777l;
        if (r104 == null) goto L17;
        r104.setVisibility(8);
    L17:
        j();
        this.L.clear();
        Disposable r105 = this.K;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        LottieAnimationView r106 = this.f566787v;
        if (r106 == null) goto L23;
        r106.setVisibility(8);
    L23:
        List<TextSwitcher> r107 = this.f566774J;
        if (r107 == null) goto L41;
        Iterator<T> r108 = r107.iterator();
    L27:
        if (r108.hasNext() == false) goto L41;
        TextSwitcher r109 = (TextSwitcher) r108.next();
        if (r109 == null) goto L31;
        View r110 = r109.getCurrentView();
    L33:
        if ((r110 instanceof TextView) == false) goto L39;
        View r111 = r109.getCurrentView();
        if (r111 == null) goto L38;
        ((TextView) r111).setTextColor(s1.h(R.color.commonui_white));
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L39:
        if (r109 == null) goto L27;
        r109.setCurrentText("");
        goto L27
    L31:
        r110 = null;
    L41:
        TextView r112 = this.G;
        if (r112 == null) goto L44;
        r112.setTextColor(s1.h(R.color.commonui_white));
    L44:
        TextSwitcher r113 = this.f566781p;
        if (r113 == null) goto L57;
        int r114 = r113.getChildCount();
        if (r114 < 0) goto L57;
        int r115 = 0;
    L49:
        View r116 = r113.getChildAt(r115);
        if ((r116 instanceof TextView) == true) goto L52;
        r116 = null;
    L52:
        TextView r117 = (TextView) r116;
        if (r117 == null) goto L55;
        r117.setTextColor(s1.h(R.color.commonui_white));
        r117.setMaxEms(6);
        r117.setEllipsize(TextUtils.TruncateAt.END);
        r117.setMaxLines(1);
        r117.setText("");
    L55:
        if (r115 == r114) goto L57;
        r115 = r115 + 1;
    L57:
        ViewGroup r118 = this.f566779n;
        if (r118 != null) goto L60;
    L64:
        TextSwitcher r119 = this.H;
        if (r119 != null) goto L67;
        return;
    L67:
        if (r119.getVisibility() != 8) goto L80;
        TextSwitcher r120 = this.H;
        if (r120 == null) goto L81;
        r120.setVisibility(0);
        return;
    L81:
        return;
    L80:
        return;
    L60:
        if (r118.getVisibility() != 0) goto L64;
        ViewGroup r121 = this.f566779n;
        if (r121 == null) goto L64;
        r121.setVisibility(8);
        goto L64
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    @Override // u81.d
    public final void onInit() {
        View r100 = this.f566670h;
        TextView r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.online_info_root_view);
    L6:
        this.f566776k = r102;
        View r103 = this.f566670h;
        if (r103 == null) goto L9;
        ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.dou_plus_root_view);
    L10:
        this.f566777l = r104;
        View r105 = this.f566669g;
        if (r105 == null) goto L13;
        ViewGroup r106 = (ViewGroup) r105.findViewById(R.id.alpha_change_area);
    L14:
        this.f566778m = r106;
        View r107 = this.f566669g;
        if (r107 == null) goto L17;
        ViewGroup r108 = (ViewGroup) r107.findViewById(R.id.data_info_area);
    L18:
        this.f566779n = r108;
        View r109 = this.f566670h;
        if (r109 == null) goto L21;
        LottieAnimationView r110 = (LottieAnimationView) r109.findViewById(R.id.sweep_anim);
    L22:
        this.f566787v = r110;
        View r111 = this.f566669g;
        if (r111 == null) goto L25;
        HSImageView r112 = (HSImageView) r111.findViewById(R.id.indicator_dou);
    L26:
        this.f566780o = r112;
        View r113 = this.f566669g;
        if (r113 == null) goto L29;
        View r114 = r113.findViewById(R.id.indicator_boundary);
    L30:
        this.f566791z = r114;
        View r115 = this.f566670h;
        if (r115 == null) goto L33;
        RelativeLayout r116 = (RelativeLayout) r115.findViewById(R.id.online_info_area);
    L34:
        this.f566785t = r116;
        View r117 = this.f566670h;
        if (r117 == null) goto L37;
        StrokeTextView r118 = (StrokeTextView) r117.findViewById(R.id.online_info);
    L38:
        this.f566786u = r118;
        View r119 = this.f566669g;
        if (r119 == null) goto L41;
        TextSwitcher r120 = (TextSwitcher) r119.findViewById(R.id.indicator_new_order_user_name);
    L42:
        this.f566781p = r120;
        View r121 = this.f566669g;
        if (r121 == null) goto L45;
        TextView r122 = (TextView) r121.findViewById(R.id.indicator_new_order_copy_writer);
    L46:
        this.f566782q = r122;
        SpannableString r123 = new SpannableString("dou+");
        Drawable r124 = s1.m(R.drawable.ttlive_bg_watch_user_info_new_indicator_dou);
        r124.setBounds(0, 0, (int) UtilityKotlinExtentionsKt.h(21), (int) UtilityKotlinExtentionsKt.h(9));
        r123.setSpan(new ImageSpan(r124, 1), 0, r123.length(), 17);
        TextView r125 = this.f566782q;
        if (r125 == null) goto L49;
        r125.append(s1.B(R.string.ttlive_dou_plus_indicator_new_order_hint_one));
        r125.append(r123);
        r125.append(s1.B(R.string.ttlive_dou_plus_indicator_new_order_hint_two));
    L49:
        this.f566783r = new b(this, Looper.getMainLooper());
        DataCenter r126 = this.f566668f;
        if (r126 == null) goto L52;
        IRoom r127 = com.bytedance.android.live.core.utils.a0.m(r126).f66427a;
    L53:
        this.O = r127;
        View r128 = this.f566669g;
        if (r128 == null) goto L56;
        TextSwitcher r129 = (TextSwitcher) r128.findViewById(R.id.plus);
    L57:
        this.F = r129;
        View r130 = this.f566669g;
        if (r130 == null) goto L60;
        TextSwitcher r131 = (TextSwitcher) r130.findViewById(R.id.bits);
    L61:
        this.B = r131;
        View r132 = this.f566669g;
        if (r132 == null) goto L64;
        TextSwitcher r133 = (TextSwitcher) r132.findViewById(R.id.decade);
    L65:
        this.C = r133;
        View r134 = this.f566669g;
        if (r134 == null) goto L68;
        TextSwitcher r135 = (TextSwitcher) r134.findViewById(R.id.hundreds);
    L69:
        this.D = r135;
        View r136 = this.f566669g;
        if (r136 == null) goto L72;
        TextSwitcher r137 = (TextSwitcher) r136.findViewById(R.id.thousand);
    L73:
        this.E = r137;
        View r138 = this.f566669g;
        if (r138 == null) goto L76;
        TextSwitcher r139 = (TextSwitcher) r138.findViewById(R.id.unit);
    L77:
        this.A = r139;
        View r140 = this.f566669g;
        if (r140 == null) goto L80;
        TextSwitcher r141 = (TextSwitcher) r140.findViewById(R.id.info_label);
    L81:
        this.H = r141;
        View r142 = this.f566669g;
        if (r142 == null) goto L84;
        r101 = (TextView) r142.findViewById(R.id.point);
    L84:
        this.G = r101;
        this.f566774J = CollectionsKt.mutableListOf(new TextSwitcher[]{this.A, this.B, this.C, this.D, this.E, this.F});
        ViewGroup r143 = this.f566778m;
        if (r143 == null) goto L87;
        r143.setOnClickListener(new c(this));
    L87:
        Disposable r144 = xs2.b.a().b(w1.class).subscribe(new d(this));
        if (r144 == null) goto L90;
        Intrinsics.checkNotNullParameter(r144, "$this$autoBind");
        this.f566664b.add(r144);
    L90:
        q();
        return;
    L80:
        r141 = null;
        goto L81
    L76:
        r139 = null;
        goto L77
    L72:
        r137 = null;
        goto L73
    L68:
        r135 = null;
        goto L69
    L64:
        r133 = null;
        goto L65
    L60:
        r131 = null;
        goto L61
    L56:
        r129 = null;
        goto L57
    L52:
        r127 = null;
        goto L53
    L45:
        r122 = null;
        goto L46
    L41:
        r120 = null;
        goto L42
    L37:
        r118 = null;
        goto L38
    L33:
        r116 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r112 = null;
        goto L26
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = null;
        goto L18
    L13:
        r106 = null;
        goto L14
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void p() {
        ValueAnimator r100 = this.f566790y;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.L.clear();
        ValueAnimator r101 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.f566790y = r101;
        if (r101 == null) goto L11;
        r101.addListener(new i(this));
        r101.addUpdateListener(new j(r101, this));
        if (this.f566665c == true) goto L10;
        r101.setStartDelay(0);
        r101.setDuration(0);
        goto L11
    L10:
        r101.setStartDelay(200);
        r101.setDuration(300);
    L11:
        ValueAnimator r102 = this.f566790y;
        if (r102 == null) goto L14;
        r102.start();
    L14:
        List<TextSwitcher> r103 = this.f566774J;
        if (r103 == null) goto L30;
        Iterator<T> r104 = r103.iterator();
    L18:
        if (r104.hasNext() == false) goto L30;
        TextSwitcher r105 = (TextSwitcher) r104.next();
        if (r105 == null) goto L22;
        View r106 = r105.getCurrentView();
    L24:
        if ((r106 instanceof TextView) == false) goto L18;
        View r107 = r105.getCurrentView();
        if (r107 == null) goto L29;
        ((TextView) r107).setTextColor(s1.h(R.color.commonui_white));
        goto L18
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L22:
        r106 = null;
    L30:
        TextView r108 = this.G;
        if (r108 == null) goto L33;
        r108.setTextColor(s1.h(R.color.commonui_white));
    L33:
        ValueAnimator r109 = this.f566789x;
        if (r109 == null) goto L36;
        r109.cancel();
    L36:
        ValueAnimator r110 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f566789x = r110;
        if (r110 == null) goto L39;
        r110.addListener(new k(this));
        r110.addUpdateListener(new C8312l(r110, this));
        r110.setStartDelay(500);
        r110.setDuration(200);
    L39:
        ValueAnimator r111 = this.f566789x;
        if (r111 == null) goto L49;
        r111.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.L.clear();
        Disposable r100 = this.K;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        LottieAnimationView r101 = this.f566787v;
        if (r101 == null) goto L8;
        r101.cancelAnimation();
    L8:
        ValueAnimator r102 = this.f566788w;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ValueAnimator r103 = this.f566789x;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        ValueAnimator r104 = this.f566790y;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        q();
    }

    @Override // u81.d
    public final int getItemType() {
        return this.f566775j;
    }

    public static final void l(l r100) {
        LottieAnimationView r101 = r100.f566787v;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        LottieAnimationView r102 = r100.f566787v;
        if (r102 == null) goto L8;
        r102.addAnimatorListener(new b0(r102, r100));
        r102.setAnimation("rank_indicator_sweep.json");
        r102.setImageAssetsFolder("rank_indicator/");
        r102.loop(false);
    L8:
        r100.K = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r100.f566669g))).subscribe(new c0(r100), RxUtil.getNoOpThrowable());
    }

    @Override // u81.d
    public final void f(String r100) {
        this.f566666d = "";
        HSImageView r101 = this.f566780o;
        if (r101 == null) goto L6;
        r101.setImageResource(R.drawable.ttlive_bg_watch_user_info_new_indicator_dou);
        return;
    }

    @Override // u81.d
    public final void g(w81.a r110) {
        if (r110 == null) goto L5;
        tlc.d r100 = r110.f558609a;
    L7:
        if ((r100 instanceof com.bytedance.android.live.base.model.message.s0) == true) goto L9;
        r100 = null;
    L9:
        com.bytedance.android.live.base.model.message.s0 r101 = (com.bytedance.android.live.base.model.message.s0) r100;
        StringBuilder r102 = new StringBuilder("process holder binding, status: ");
        if (r101 == null) goto L12;
        Long r103 = r101.getStatus();
    L13:
        r102.append(r103);
        r102.append(", curStatus: ");
        r102.append(this.P);
        r102.append(", showStatus: ");
        r102.append(this.R);
        ALogger.d("DouPlusHolder", r102.toString());
        if (r101 != null) goto L17;
        return;
    L17:
        if (r110 == null) goto L21;
        Boolean r111 = r110.f558610b;
        if (r111 == null) goto L21;
        boolean r112 = r111.booleanValue();
    L22:
        this.f566665c = r112;
        Long r113 = r101.getStatus();
        if (r113 == null) goto L25;
        long r104 = r113.longValue();
    L26:
        int r114 = (int) r104;
        Long r105 = r101.getNumber();
        if (r105 == null) goto L29;
        long r106 = r105.longValue();
    L30:
        int r107 = (int) r106;
        if (r114 == 1) goto L34;
        if (r114 == 4) goto L34;
    L56:
        if (r114 != 2) goto L93;
        Integer r108 = this.P;
        if (r108 == null) goto L63;
        if (r108.intValue() == 2) goto L93;
    L63:
        if (this.R != 10) goto L93;
        this.P = Integer.valueOf(r114);
        this.N = 0;
        this.S = false;
        i(1);
        Disposable r115 = this.K;
        if (r115 == null) goto L67;
        r115.dispose();
    L67:
        this.L.clear();
        LottieAnimationView r116 = this.f566787v;
        if (r116 == null) goto L70;
        r116.cancelAnimation();
    L70:
        LottieAnimationView r117 = this.f566787v;
        if (r117 == null) goto L73;
        r117.setVisibility(8);
    L73:
        List<TextSwitcher> r118 = this.f566774J;
        if (r118 == null) goto L89;
        Iterator<T> r119 = r118.iterator();
    L77:
        if (r119.hasNext() == false) goto L89;
        TextSwitcher r109 = (TextSwitcher) r119.next();
        if (r109 == null) goto L81;
        View r120 = r109.getCurrentView();
    L83:
        if ((r120 instanceof TextView) == false) goto L77;
        View r121 = r109.getCurrentView();
        if (r121 == null) goto L88;
        ((TextView) r121).setTextColor(s1.h(R.color.ttlive_dou_plus_end_data_color));
        goto L77
    L88:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L81:
        r120 = null;
    L89:
        TextView r122 = this.G;
        if (r122 == null) goto L92;
        r122.setTextColor(s1.h(R.color.ttlive_start_live_select_yellow));
    L92:
        CompositeDisposable r123 = this.L;
        Observable r124 = Observable.just(this);
        TimeUnit r125 = TimeUnit.MILLISECONDS;
        r123.add(r124.delay(5000, r125).compose(RxUtil.rxSchedulerHelper()).subscribe(new m(this), RxUtil.getNoOpThrowable()));
        this.L.add(Observable.just(this).delay(9000, r125).compose(RxUtil.rxSchedulerHelper()).subscribe(new n(this), RxUtil.getNoOpThrowable()));
        return;
    L93:
        if (r114 == 1) goto L95;
    L108:
        if (r114 != 4) goto L124;
        if (this.R != 10) goto L124;
        Integer r126 = this.P;
        if (r126 != null) goto L115;
    L117:
        this.P = Integer.valueOf(r114);
        if (this.S == false) goto L122;
        TextSwitcher r127 = this.H;
        if (r127 == null) goto L168;
        r127.setCurrentText(s1.B(R.string.ttlive_dou_plus_indicator_audit));
        return;
    L168:
        return;
    L122:
        n(s1.B(R.string.ttlive_dou_plus_indicator_audit));
        return;
    L115:
        if (r126.intValue() != 2) goto L117;
        this.P = Integer.valueOf(r114);
        p();
        return;
    L124:
        if (r114 != 3) goto L146;
        if (TextUtils.isEmpty(r101.getBuyerNickname()) == true) goto L146;
        String r128 = r101.getBuyerNickname();
        if (r128 == null) goto L133;
        List<String> r129 = this.f566784s;
        if (r129 == null) goto L133;
        ((ArrayList) r129).add(r128);
    L133:
        if (this.N >= r107) goto L136;
        this.N = r107;
    L136:
        if (this.R == 10) goto L138;
        return;
    L138:
        this.P = 3;
        List<String> r130 = this.f566784s;
        if (r130 != null) goto L141;
        return;
    L141:
        if (((ArrayList) r130).size() == 1) goto L143;
        return;
    L143:
        if (this.S == true) goto L173;
        o();
        return;
    L173:
        return;
    L146:
        if (r114 == 6) goto L150;
        if (r114 == 5) goto L150;
        return;
    L150:
        if (TextUtils.isEmpty(r101.getToast()) == true) goto L176;
        String r131 = r101.getToast();
        if (r131 == null) goto L177;
        String r132 = rm3.c.f538539a;
        rm3.c.g(com.bytedance.android.live.core.utils.a.d(), r131, 0, false, 28);
        return;
    L177:
        return;
    L176:
        return;
    L95:
        if (this.R != 10) goto L108;
        this.N = r107;
        Integer r133 = this.P;
        if (r133 != null) goto L100;
    L102:
        this.P = Integer.valueOf(r114);
    L104:
        if (this.S == true) goto L164;
        if (r107 <= 0) goto L107;
        m(r107);
        return;
    L107:
        n(s1.B(R.string.ttlive_dou_plus_indicator_on));
        return;
    L164:
        return;
    L100:
        if (r133.intValue() != 2) goto L102;
        this.P = Integer.valueOf(r114);
        p();
    L34:
        if (this.R != 11) goto L56;
        if (this.T == true) goto L56;
        this.P = Integer.valueOf(r114);
        this.T = true;
        ValueAnimator r134 = this.f566790y;
        if (r134 == null) goto L40;
        r134.cancel();
    L40:
        ValueAnimator r135 = this.f566788w;
        if (r135 == null) goto L43;
        r135.cancel();
    L43:
        this.L.clear();
        ValueAnimator r136 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f566788w = r136;
        if (r136 == null) goto L49;
        r136.addListener(new o(this));
        r136.addUpdateListener(new p(r136, this));
        if (this.f566665c == true) goto L48;
        r136.setDuration(0);
        goto L49
    L48:
        r136.setDuration(500);
    L49:
        ValueAnimator r137 = this.f566788w;
        if (r137 == null) goto L52;
        r137.start();
    L52:
        p();
        if (r107 <= 0) goto L161;
        this.N = r107;
        return;
    L161:
        return;
    L29:
        r106 = 0;
        goto L30
    L25:
        r104 = 0;
    L21:
        r112 = true;
        goto L22
    L12:
        r103 = null;
        goto L13
    L5:
        r100 = null;
        goto L7
    }

    public final void m(int r100) {
        ViewGroup r101 = this.f566779n;
        if (r101 != null) goto L5;
    L9:
        TextSwitcher r102 = this.H;
        if (r102 == null) goto L20;
        if (r102.getVisibility() != 0) goto L20;
        TextSwitcher r103 = this.H;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
    L16:
        TextSwitcher r104 = this.H;
        if (r104 == null) goto L20;
        r104.setCurrentText("");
    L20:
        if (TextUtils.equals(Marker.ANY_NON_NULL_MARKER, this.I) == true) goto L26;
        TextSwitcher r105 = this.F;
        if (r105 == null) goto L24;
        r105.setText(Marker.ANY_NON_NULL_MARKER);
    L24:
        this.I = Marker.ANY_NON_NULL_MARKER;
    L26:
        if (r100 < 10000) goto L56;
        TextView r106 = this.G;
        if (r106 == null) goto L30;
        r106.setVisibility(0);
    L30:
        TextSwitcher r107 = this.A;
        if (r107 != null) goto L33;
    L37:
        TextSwitcher r108 = this.A;
        if (r108 == null) goto L41;
        r108.setText("万");
    L41:
        if (r100 < 10000000) goto L43;
        r100 = 9999000;
    L43:
        if (r100 < 100000) goto L53;
        Integer r109 = com.bytedance.android.live.core.setting.k0.f65336a.getValue();
        if (r109 == null) goto L53;
        if (r109.intValue() != 1) goto L53;
        TextSwitcher r110 = this.A;
        if (r110 == null) goto L52;
        r110.setText("万+");
    L52:
        r100 = 100000;
    L53:
        int r111 = r100 / 1000;
        if ((r100 % 1000) < 500) goto L66;
        r111 = r111 + 1;
    L66:
        if (r100 < 100000) goto L78;
        Integer r112 = com.bytedance.android.live.core.setting.k0.f65336a.getValue();
        if (r112 == null) goto L78;
        if (r112.intValue() != 1) goto L78;
        TextView r113 = this.G;
        if (r113 == null) goto L75;
        r113.setVisibility(8);
    L75:
        TextSwitcher r114 = this.B;
        if (r114 == null) goto L79;
        r114.setVisibility(8);
    L79:
        s(this.C, r111, 10);
        s(this.D, r111, 100);
        s(this.E, r111, 1000);
        this.Q = r111;
        return;
    L78:
        s(this.B, r111, 1);
        goto L79
    L33:
        if (r107.getVisibility() != 8) goto L37;
        TextSwitcher r115 = this.A;
        if (r115 == null) goto L37;
        r115.setVisibility(0);
        goto L37
    L56:
        TextView r116 = this.G;
        if (r116 == null) goto L59;
        r116.setVisibility(8);
    L59:
        TextSwitcher r117 = this.A;
        if (r117 == null) goto L62;
        r117.setText("");
    L62:
        TextSwitcher r118 = this.A;
        if (r118 == null) goto L65;
        r118.setVisibility(8);
    L65:
        r111 = r100;
        goto L66
    L5:
        if (r101.getVisibility() != 8) goto L9;
        ViewGroup r119 = this.f566779n;
        if (r119 == null) goto L9;
        r119.setVisibility(0);
        goto L9
    }

    public final void n(String r100) {
        ViewGroup r101 = this.f566779n;
        if (r101 != null) goto L5;
    L9:
        TextSwitcher r102 = this.H;
        if (r102 != null) goto L12;
    L16:
        TextSwitcher r103 = this.H;
        if (r103 == null) goto L20;
        r103.setCurrentText(r100);
        return;
    L20:
        return;
    L12:
        if (r102.getVisibility() != 8) goto L16;
        TextSwitcher r104 = this.H;
        if (r104 == null) goto L16;
        r104.setVisibility(0);
        goto L16
    L5:
        if (r101.getVisibility() != 0) goto L9;
        ViewGroup r105 = this.f566779n;
        if (r105 == null) goto L9;
        r105.setVisibility(8);
        goto L9
    }

    public final void r(View r100, float r101) {
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        r(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r100 instanceof View) == false) goto L12;
        r100.setAlpha(r101);
        return;
    }

    public final void s(TextSwitcher r100, int r101, int r102) {
        if (r100 == null) goto L19;
        int r103 = this.Q;
        if (r103 == (-1)) goto L7;
        r103 = (r103 / r102) % 10;
    L7:
        int r104 = (r101 / r102) % 10;
        if (r104 != 0) goto L14;
        if (r101 >= (r102 * 10)) goto L14;
        r100.setText("");
        r100.setVisibility(8);
        return;
    L14:
        if (r100.getVisibility() != 8) goto L16;
        r100.setVisibility(0);
    L16:
        if (r104 == r103) goto L21;
        r100.setText(String.valueOf(r104));
        return;
    L21:
        return;
    }

    public l(DataCenter r100, View r101, int r102, View r103) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "parentView");
        super(r100, r101, r103);
        this.f566775j = r102;
        this.f566784s = new ArrayList();
        this.L = new CompositeDisposable();
        this.P = -1;
        this.Q = -1;
        this.R = 11;
    }

    public static final void k(l r100, ViewGroup r101, int r102, int r103) {
        r100.getClass();
        Drawable r104 = null;
        if (r101 == null) goto L5;
        Drawable r105 = r101.getBackground();
    L7:
        if ((r105 instanceof GradientDrawable) == false) goto L14;
        if (r101 == null) goto L10;
        r104 = r101.getBackground();
    L10:
        GradientDrawable r106 = (GradientDrawable) r104;
        if (r106 == null) goto L15;
        r106.setColors(new int[]{r102, r103});
        return;
    L15:
        return;
    L14:
        return;
    L5:
        r105 = null;
        goto L7
    }
}
