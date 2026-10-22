package y81;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.base.model.message.a4;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.u4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.incentiveinfo.model.BizContentType;
import com.bytedance.android.live.room.incentiveinfo.model.BizStatus;
import com.bytedance.android.live.room.incentiveinfo.model.UpdateAreaType;
import com.bytedance.android.livesdk.chatroom.ui.StrokeTextView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
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
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes47.dex */
public final class d0 extends y81.b {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final a f566706h0 = null;
    public BizContentType A;
    public BizContentType B;
    public BizContentType C;
    public RelativeLayout D;
    public StrokeTextView E;
    public LottieAnimationView F;
    public ValueAnimator G;
    public ValueAnimator H;
    public ValueAnimator I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public View f566707J;
    public TextSwitcher K;
    public TextSwitcher L;
    public TextSwitcher M;
    public TextSwitcher N;
    public TextSwitcher O;
    public TextSwitcher P;
    public TextSwitcher Q;
    public String R;
    public List<TextSwitcher> S;
    public List<View> T;
    public List<View> U;
    public Disposable V;
    public final CompositeDisposable W;
    public long X;
    public IRoom Y;
    public long Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f566708a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f566709b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f566710c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f566711d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f566712e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public long f566713f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Integer f566714g0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f566715j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ViewGroup f566716k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ViewGroup f566717l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ViewGroup f566718m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ViewGroup f566719n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImageView f566720o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f566721p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextSwitcher f566722q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ImageView f566723r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ImageView f566724s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public TextView f566725t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public d f566726u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<String> f566727v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<py.k> f566728w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<String> f566729x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<py.k> f566730y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Disposable f566731z;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f566732a;

        public b(ImageView r100) {
            this.f566732a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Bitmap r101 = (Bitmap) r100;
            ImageView r102 = this.f566732a;
            if (r102 == null) goto L6;
            r102.setImageBitmap(r101);
            return;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f566733a;

        public c(ImageView r100) {
            this.f566733a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ImageView r102 = this.f566733a;
            String r103 = null;
            if (r102 == null) goto L9;
            int r104 = r102.getId();
            ImageView r105 = this.f566733a;
            if (r105 == null) goto L9;
            Resources r106 = r105.getResources();
            if (r106 == null) goto L9;
            String r107 = r106.getResourceEntryName(r104);
        L10:
            StringBuilder r108 = new StringBuilder();
            r108.append(r107);
            r108.append(" ----- load icon failed, reason is --- ");
            if (r101 == null) goto L13;
            r103 = r101.getMessage();
        L13:
            r108.append(r103);
            ALogger.i("RoomIndicatorHolder", r108.toString());
            return;
        L9:
            r107 = null;
            goto L10
        }
    }

    public static final class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566734a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            super.handleMessage(r100);
            int r101 = r100.what;
            if (r101 == 1) goto L27;
            if (r101 != 2) goto L6;
            d0 r102 = this.f566734a;
            ValueAnimator r103 = r102.G;
            if (r103 == null) goto L14;
            r103.cancel();
        L14:
            r102.G = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
            Ref.IntRef r104 = new Ref.IntRef();
            r104.element = 0;
            ValueAnimator r105 = r102.G;
            if (r105 == null) goto L17;
            r105.addListener(new p0(r102, r104));
            r105.addUpdateListener(new q0(r105, r102, r104));
            r105.setDuration(200);
            r105.start();
        L17:
            ValueAnimator r106 = r102.I;
            if (r106 == null) goto L20;
            r106.cancel();
        L20:
            ValueAnimator r107 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
            r102.I = r107;
            if (r107 == null) goto L23;
            r107.addListener(new r0(r102));
            r107.addUpdateListener(new s0(r107, r102));
            r107.setDuration(200);
        L23:
            ValueAnimator r108 = r102.I;
            if (r108 == null) goto L38;
            r108.start();
            return;
        L38:
            return;
        L6:
            if (r101 != 3) goto L42;
            d0 r109 = this.f566734a;
            if (r109.f566710c0 == true) goto L36;
            r109.q();
            return;
        L36:
            return;
        L42:
            return;
        L27:
            if (this.f566734a.o() == true) goto L31;
            d r110 = this.f566734a.f566726u;
            if (r110 == null) goto L40;
            r110.sendEmptyMessage(2);
            return;
        L40:
            return;
        L31:
            d r111 = this.f566734a.f566726u;
            if (r111 == null) goto L34;
            r111.sendEmptyMessageDelayed(1, 2000);
        L34:
            this.f566734a.t(false);
        }

        public d(d0 r100, Looper r101) {
            this.f566734a = r100;
            super(r101);
        }
    }

    public static final class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566735a;

        public e(d0 r100) {
            this.f566735a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            String r101 = null;
            if (Intrinsics.areEqual(u4.f65424a.getValue(), Boolean.TRUE) == false) goto L19;
            d0 r102 = this.f566735a;
            tlc.d r103 = r102.f566667e;
            if ((r103 instanceof a4) == true) goto L7;
            r103 = null;
        L7:
            a4 r104 = (a4) r103;
            if (r104 == null) goto L12;
            mm2.b r105 = r104.E();
            if (r105 == null) goto L12;
            String r106 = r105.schema;
        L13:
            if (r106 == null) goto L19;
            if ((!StringsKt.isBlank(r106)) != true) goto L19;
            IBaseLiveActionHandler r107 = (IBaseLiveActionHandler) jc1.k.f(IBaseLiveActionHandler.class);
            if (r107 == null) goto L19;
            r107.handle(r102.f566669g.getContext(), r106);
        L12:
            r106 = null;
        L19:
            d0 r108 = this.f566735a;
            tlc.d r109 = r108.f566667e;
            if ((r109 instanceof a4) == true) goto L22;
            r109 = null;
        L22:
            a4 r110 = (a4) r109;
            HashMap r111 = new HashMap();
            if (r110 == null) goto L25;
            r111.put("biz_type", String.valueOf(r110.G()));
        L25:
            int r112 = x81.c.f562885a;
            DataCenter r113 = r108.f566668f;
            if (r110 == null) goto L30;
            mm2.b r114 = r110.E();
            if (r114 == null) goto L30;
            r101 = r114.extra;
        L30:
            x81.c.a("livesdk_new_anchor_support_plan_click", r113, r101, r111);
        }
    }

    public static final class f extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f566737b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            super.onAnimationCancel(r100);
            StrokeTextView r101 = this.f566736a.E;
            if (r101 == null) goto L6;
            r101.setGravity(1);
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r101 = this.f566736a;
            LottieAnimationView r102 = r101.F;
            if (r102 != null) goto L5;
            d0.l(r101);
        L6:
            d r103 = this.f566736a.f566726u;
            if (r103 == null) goto L9;
            r103.sendEmptyMessageDelayed(1, 4000);
        L9:
            StrokeTextView r104 = this.f566736a.E;
            if (r104 == null) goto L13;
            r104.setGravity(1);
            return;
        L13:
            return;
        L5:
            r102.playAnimation();
            goto L6
        }

        public f(d0 r100, Ref.IntRef r101) {
            this.f566736a = r100;
            this.f566737b = r101;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            View r102 = this.f566736a.f566707J;
            if (r102 == null) goto L5;
            r102.setVisibility(8);
        L5:
            Ref.IntRef r103 = this.f566737b;
            ViewGroup r104 = this.f566736a.f566716k;
            if (r104 == null) goto L8;
            int r105 = r104.getWidth();
        L9:
            r103.element = r105;
            StrokeTextView r106 = this.f566736a.E;
            if (r106 == null) goto L12;
            r106.setGravity(GravityCompat.START);
        L12:
            this.f566736a.t(true);
            return;
        L8:
            r105 = 0;
            goto L9
        }
    }

    public static final class g implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f566739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f566740c;

        public g(ValueAnimator r100, d0 r101, Ref.IntRef r102) {
            this.f566738a = r100;
            this.f566739b = r101;
            this.f566740c = r102;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "<anonymous parameter 0>");
            Object r101 = this.f566738a.getAnimatedValue();
            if (r101 == null) goto L26;
            float r102 = ((Float) r101).floatValue();
            ViewGroup r103 = this.f566739b.f566717l;
            if (r103 == null) goto L9;
            float r104 = 52;
            if (this.f566740c.element <= UtilityKotlinExtentionsKt.h(r104)) goto L9;
            ViewGroup.LayoutParams r105 = r103.getLayoutParams();
            r105.width = ((int) ((this.f566740c.element - UtilityKotlinExtentionsKt.h(r104)) * r102)) + ((int) UtilityKotlinExtentionsKt.h(r104));
            r103.setLayoutParams(r105);
        L9:
            RelativeLayout r106 = this.f566739b.D;
            if (r106 == null) goto L14;
            float r107 = 52;
            if (this.f566740c.element <= UtilityKotlinExtentionsKt.h(r107)) goto L14;
            ViewGroup.LayoutParams r108 = r106.getLayoutParams();
            r108.width = (int) ((this.f566740c.element - UtilityKotlinExtentionsKt.h(r107)) * (1 - r102));
            r106.setLayoutParams(r108);
        L14:
            d0.v(this.f566739b.D, 1 - r102);
            TextSwitcher r109 = this.f566739b.f566722q;
            if (r109 == null) goto L17;
            r109.setAlpha(3 * r102);
        L17:
            int r110 = e0.f566752a[this.f566739b.C.ordinal()];
            if (r110 != 1) goto L20;
            d0.v(this.f566739b.f566725t, 3 * r102);
            return;
        L20:
            if (r110 == 2) goto L22;
            d0.v(this.f566739b.f566725t, 3 * r102);
            return;
        L22:
            d0.v(this.f566739b.f566724s, 3 * r102);
            return;
        L26:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class h extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566741a;

        public h(d0 r100) {
            this.f566741a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r101 = this.f566741a;
            d0.k(r101, r101.f566717l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#80FF356F"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r102 = this.f566741a;
            d0.k(r102, r102.f566717l, ColorProtector.parseColor("#29FF356F"), ColorProtector.parseColor("#29FF356F"));
        }
    }

    public static final class i implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566742a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f566743b;

        public i(ValueAnimator r100, d0 r101) {
            this.f566742a = r100;
            this.f566743b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566742a.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            d0 r103 = this.f566743b;
            d0.k(r103, r103.f566717l, ColorProtector.parseColor("#29FF356F"), r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class j extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566744a;

        public j(d0 r100) {
            this.f566744a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r101 = this.f566744a;
            d0.k(r101, r101.f566717l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#80ff356f"));
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r102 = this.f566744a;
            d0.k(r102, r102.f566717l, ColorProtector.parseColor("#26000000"), ColorProtector.parseColor("#26000000"));
        }
    }

    public static final class k implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566745a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f566746b;

        public k(ValueAnimator r100, d0 r101) {
            this.f566745a = r100;
            this.f566746b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566745a.getAnimatedValue();
            if (r101 == null) goto L7;
            int r102 = ((Integer) r101).intValue();
            d0 r103 = this.f566746b;
            d0.k(r103, r103.f566717l, ColorProtector.parseColor("#26000000"), r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class l extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d0 f566747a;

        public l(d0 r100) {
            this.f566747a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0.v(this.f566747a.f566718m, 1.0f);
            d0 r101 = this.f566747a;
            r101.f566711d0 = false;
            r101.f566709b0 = 10;
            if (r101.o() == false) goto L8;
            d r102 = this.f566747a.f566726u;
            if (r102 == null) goto L9;
            r102.sendEmptyMessageDelayed(3, 1000);
            return;
        L9:
            return;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            d0 r101 = this.f566747a;
            r101.f566711d0 = false;
            r101.f566709b0 = 10;
            d0.l(r101);
            this.f566747a.m();
            if (this.f566747a.o() == false) goto L8;
            d r102 = this.f566747a.f566726u;
            if (r102 == null) goto L9;
            r102.sendEmptyMessageDelayed(3, 1000);
            return;
        L9:
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ViewGroup r102 = this.f566747a.f566718m;
            if (r102 == null) goto L5;
            r102.setVisibility(0);
        L5:
            d0.v(this.f566747a.f566718m, 0.0f);
        }
    }

    public static final class m implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueAnimator f566748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d0 f566749b;

        public m(ValueAnimator r100, d0 r101) {
            this.f566748a = r100;
            this.f566749b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = this.f566748a.getAnimatedValue();
            if (r101 == null) goto L7;
            float r102 = ((Float) r101).floatValue();
            d0.v(this.f566749b.f566718m, r102);
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    @Override // u81.d
    public final void f(String r100) {
    }

    public final void q() {
        i(1);
        this.W.clear();
        if (this.f566711d0 == false) goto L6;
        this.f566710c0 = false;
        return;
    L6:
        List<TextSwitcher> r100 = this.S;
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
        this.f566710c0 = true;
        ValueAnimator r105 = this.G;
        if (r105 == null) goto L25;
        r105.cancel();
    L25:
        this.G = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        Ref.IntRef r106 = new Ref.IntRef();
        r106.element = 0;
        ValueAnimator r107 = this.G;
        if (r107 == null) goto L28;
        r107.addListener(new f(this, r106));
        r107.addUpdateListener(new g(r107, this, r106));
        r107.setStartDelay(500);
        r107.setDuration(500);
        r107.start();
    L28:
        ValueAnimator r108 = this.I;
        if (r108 == null) goto L31;
        r108.cancel();
    L31:
        ValueAnimator r109 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#29FF356F")), Integer.valueOf(ColorProtector.parseColor("#80FF356F"))});
        this.I = r109;
        if (r109 == null) goto L34;
        r109.addListener(new h(this));
        r109.addUpdateListener(new i(r109, this));
        r109.setStartDelay(500);
        r109.setDuration(500);
    L34:
        ValueAnimator r110 = this.I;
        if (r110 == null) goto L44;
        r110.start();
        return;
    }

    public final void u() {
        this.f566708a0 = -1;
        this.X = 0;
        this.R = null;
        ValueAnimator r100 = this.I;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        ValueAnimator r101 = this.G;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.Z = BizStatus.UNKNOW.getValue();
        this.f566709b0 = 11;
        int r102 = 0;
        this.f566710c0 = false;
        this.f566712e0 = false;
        TextSwitcher r103 = this.Q;
        if (r103 == null) goto L11;
        r103.setCurrentText("");
    L11:
        TextSwitcher r104 = this.f566722q;
        if (r104 == null) goto L14;
        r104.setCurrentText("");
    L14:
        ViewGroup r105 = this.f566717l;
        if (r105 == null) goto L17;
        r105.setVisibility(8);
    L17:
        j();
        this.W.clear();
        Disposable r106 = this.V;
        if (r106 == null) goto L20;
        r106.dispose();
    L20:
        LottieAnimationView r107 = this.F;
        if (r107 == null) goto L23;
        r107.setVisibility(8);
    L23:
        List<TextSwitcher> r108 = this.S;
        if (r108 == null) goto L41;
        Iterator<T> r109 = r108.iterator();
    L27:
        if (r109.hasNext() == false) goto L41;
        TextSwitcher r110 = (TextSwitcher) r109.next();
        if (r110 == null) goto L31;
        View r111 = r110.getCurrentView();
    L33:
        if ((r111 instanceof TextView) == false) goto L39;
        View r112 = r110.getCurrentView();
        if (r112 == null) goto L38;
        ((TextView) r112).setTextColor(s1.h(R.color.commonui_white));
        goto L39
    L38:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L39:
        if (r110 == null) goto L27;
        r110.setCurrentText("");
        goto L27
    L31:
        r111 = null;
    L41:
        TextSwitcher r113 = this.Q;
        if (r113 == null) goto L44;
        View r114 = r113.getCurrentView();
    L46:
        if ((r114 instanceof TextView) == true) goto L48;
        r114 = null;
    L48:
        TextView r115 = (TextView) r114;
        if (r115 == null) goto L51;
        r115.setTextColor(s1.h(R.color.commonui_white));
    L51:
        List<View> r116 = this.T;
        if (r116 == null) goto L59;
        Iterator<T> r117 = r116.iterator();
    L55:
        if (r117.hasNext() == false) goto L59;
        View r118 = (View) r117.next();
        if (r118 == null) goto L55;
        UtilityKotlinExtentionsKt.z(r118, false);
    L59:
        List<View> r119 = this.U;
        if (r119 == null) goto L67;
        Iterator<T> r120 = r119.iterator();
    L63:
        if (r120.hasNext() == false) goto L67;
        View r121 = (View) r120.next();
        if (r121 == null) goto L63;
        UtilityKotlinExtentionsKt.z(r121, false);
    L67:
        TextSwitcher r122 = this.f566722q;
        if (r122 == null) goto L79;
        int r123 = r122.getChildCount();
        if (r123 < 0) goto L79;
    L71:
        View r124 = r122.getChildAt(r102);
        if ((r124 instanceof TextView) == true) goto L74;
        r124 = null;
    L74:
        TextView r125 = (TextView) r124;
        if (r125 == null) goto L77;
        r125.setTextColor(s1.h(R.color.commonui_white));
        r125.setMaxEms(6);
        r125.setEllipsize(TextUtils.TruncateAt.END);
        r125.setMaxLines(1);
        r125.setText("");
    L77:
        if (r102 == r123) goto L79;
        r102 = r102 + 1;
    L79:
        TextView r126 = this.f566721p;
        if (r126 == null) goto L82;
        r126.setText("");
    L82:
        BizContentType r127 = BizContentType.UNKNOW;
        this.A = r127;
        this.B = r127;
        this.C = r127;
        ((ArrayList) this.f566728w).clear();
        ((ArrayList) this.f566727v).clear();
        ((ArrayList) this.f566729x).clear();
        ((ArrayList) this.f566730y).clear();
        return;
    L44:
        r114 = null;
        goto L46
    }

    static {
        f566706h0 = new a();
    }

    @Override // u81.d
    public final com.bytedance.android.live.room.incentiveinfo.c c() {
        return new com.bytedance.android.live.room.incentiveinfo.c();
    }

    @Override // u81.d
    public final v81.b e() {
        return new v81.b();
    }

    public final void m() {
        tlc.d r100 = this.f566667e;
        if ((r100 instanceof a4) == true) goto L5;
        r100 = null;
    L5:
        a4 r101 = (a4) r100;
        if (r101 == null) goto L8;
        Long r102 = r101.getStatus();
    L9:
        if (r102 == null) goto L147;
        r102.longValue();
        if (this.Z == r102.longValue()) goto L13;
        this.Z = r102.longValue();
    L13:
        tlc.d r103 = this.f566667e;
        if ((r103 instanceof a4) == true) goto L16;
        r103 = null;
    L16:
        a4 r104 = (a4) r103;
        if (r104 == null) goto L21;
        mm2.b r105 = r104.E();
        if (r105 == null) goto L21;
        List<mm2.a> r106 = r105.contents;
    L22:
        if (r106 == null) goto L168;
        Iterator r107 = r106.iterator();
        int r108 = 0;
    L25:
        if (r107.hasNext() == false) goto L169;
        Object r109 = r107.next();
        int r110 = r108 + 1;
        if (r108 >= 0) goto L29;
        CollectionsKt.throwIndexOverflow();
    L29:
        mm2.a r111 = (mm2.a) r109;
        long r112 = r102.longValue();
        boolean r113 = true;
        if (r108 != UpdateAreaType.FIRST_LINE.getValue()) goto L68;
        int r114 = r111.contentType;
        BizContentType r115 = BizContentType.TEXT;
        if (r114 == r115.getValue()) goto L34;
        BizContentType r116 = BizContentType.IMAGE;
        if (r114 == r116.getValue()) goto L56;
    L145:
        Iterator r117 = r107;
    L146:
        r108 = r110;
        r107 = r117;
        goto L25
    L56:
        if (r112 != BizStatus.NEW_ORDER.getValue()) goto L61;
        py.k r118 = r111.icon;
        if (r118 == null) goto L60;
        ((ArrayList) this.f566728w).add(r118);
    L60:
        this.B = r116;
        goto L145
    L61:
        ImageView r119 = this.f566720o;
        if (r119 != null) goto L64;
    L66:
        this.A = r116;
        n(this.f566720o, r111.icon);
        goto L145
    L64:
        if (r119.getVisibility() != 8) goto L66;
        s(this.f566720o, this.T);
        goto L66
    L34:
        if (r112 != BizStatus.NEW_ORDER.getValue()) goto L44;
        String r120 = r111.content;
        if (r120 != null) goto L38;
    L43:
        this.B = r115;
        goto L145
    L38:
        if ((!StringsKt.isBlank(r120)) == true) goto L41;
        r120 = null;
    L41:
        if (r120 == null) goto L43;
        ((ArrayList) this.f566727v).add(r120);
        goto L43
    L44:
        TextView r121 = this.f566721p;
        if (r121 != null) goto L47;
    L49:
        TextView r122 = this.f566721p;
        if (r122 == null) goto L52;
        r122.setText(r111.content);
    L52:
        this.A = r115;
        goto L145
    L47:
        if (r121.getVisibility() != 8) goto L49;
        s(this.f566721p, this.T);
        goto L49
    L68:
        if (r108 != UpdateAreaType.SECOND_LINE.getValue()) goto L145;
        int r123 = r111.contentType;
        BizContentType r124 = BizContentType.TEXT;
        if (r123 == r124.getValue()) goto L72;
        r117 = r107;
        BizContentType r125 = BizContentType.IMAGE;
        if (r123 != r125.getValue()) goto L113;
        if (r112 != BizStatus.NEW_ORDER.getValue()) goto L146;
        py.k r126 = r111.icon;
        if (r126 == null) goto L111;
        ((ArrayList) this.f566730y).add(r126);
    L111:
        this.C = r125;
        goto L146
    L113:
        if (r123 != BizContentType.NUMBER.getValue()) goto L124;
        long r127 = r111.number;
        if (r127 < this.X) goto L146;
        this.X = r127;
        ViewGroup r128 = this.f566719n;
        if (r128 != null) goto L120;
    L122:
        p((int) r111.number);
        goto L146
    L120:
        if (r128.getVisibility() != 8) goto L122;
        s(this.f566719n, this.U);
        goto L122
    L124:
        if (r123 != BizContentType.HOT_INFO.getValue()) goto L146;
        mm2.c r129 = r111.hotText;
        if (r129 == null) goto L146;
        String r130 = r129.showText;
        if (r130 != null) goto L130;
    L133:
        if (r113 == true) goto L146;
        long r131 = r129.number;
        if (r131 < this.X) goto L146;
        this.X = r131;
        TextSwitcher r132 = this.Q;
        if (r132 != null) goto L140;
    L142:
        TextSwitcher r133 = this.Q;
        if (r133 == null) goto L146;
        r133.setCurrentText(r129.showText);
        goto L146
    L140:
        if (r132.getVisibility() != 8) goto L142;
        s(this.Q, this.U);
        goto L142
    L130:
        if (StringsKt.isBlank(r130) == true) goto L133;
        r113 = false;
        goto L133
    L72:
        if (g81.d.f480371a.getValue().booleanValue() == false) goto L84;
        long r134 = r111.timestamp;
        r117 = r107;
        if (r134 == 0) goto L86;
        if (r134 <= (System.currentTimeMillis() / ((long) 1000))) goto L146;
        Result.Companion r135 = Result.Companion;     // Catch: Throwable -> L82
        String r136 = r111.endText;     // Catch: Throwable -> L82
        this.f566713f0 = r134;     // Catch: Throwable -> L82
        Disposable r137 = this.f566731z;     // Catch: Throwable -> L82
        if (r137 == null) goto L80;
        r137.dispose();     // Catch: Throwable -> L82
    L80:
        this.f566731z = Observable.interval(0, 1, TimeUnit.SECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new t0(this, r136));     // Catch: Throwable -> L82
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L82
    L82:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L86:
        if (r112 != BizStatus.NEW_ORDER.getValue()) goto L96;
        String r139 = r111.content;
        if (r139 != null) goto L90;
    L95:
        this.C = r124;
        goto L146
    L90:
        if ((!StringsKt.isBlank(r139)) == true) goto L93;
        r139 = null;
    L93:
        if (r139 == null) goto L95;
        ((ArrayList) this.f566729x).add(r139);
        goto L95
    L96:
        TextSwitcher r140 = this.Q;
        if (r140 != null) goto L99;
    L101:
        TextSwitcher r141 = this.Q;
        if (r141 == null) goto L146;
        r141.setCurrentText(r111.content);
        goto L146
    L99:
        if (r140.getVisibility() != 8) goto L101;
        s(this.Q, this.U);
        goto L101
    L84:
        r117 = r107;
        goto L86
    L169:
        return;
    L168:
        return;
    L21:
        r106 = null;
        goto L22
    L147:
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final boolean o() {
        if ((!this.f566727v.isEmpty()) == false) goto L7;
        if ((!this.f566729x.isEmpty()) == false) goto L7;
        return true;
    L7:
        if ((!this.f566727v.isEmpty()) == false) goto L11;
        if ((!this.f566730y.isEmpty()) == false) goto L11;
        return true;
    L11:
        if ((!this.f566728w.isEmpty()) == false) goto L15;
        if ((!this.f566729x.isEmpty()) == false) goto L15;
        return true;
    L15:
        if ((!this.f566728w.isEmpty()) == true) goto L17;
    L19:
        return false;
    L17:
        if ((!this.f566730y.isEmpty()) == false) goto L19;
        return true;
    }

    @Override // u81.d
    public final void onInit() {
        View r100 = this.f566670h;
        TextSwitcher r101 = null;
        if (r100 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.online_info_root_view);
    L6:
        this.f566716k = r102;
        View r103 = this.f566670h;
        if (r103 == null) goto L9;
        ViewGroup r104 = (ViewGroup) r103.findViewById(R.id.dou_plus_root_view);
    L10:
        this.f566717l = r104;
        View r105 = this.f566669g;
        if (r105 == null) goto L13;
        ViewGroup r106 = (ViewGroup) r105.findViewById(R.id.alpha_change_area);
    L14:
        this.f566718m = r106;
        View r107 = this.f566669g;
        if (r107 == null) goto L17;
        ViewGroup r108 = (ViewGroup) r107.findViewById(R.id.data_info_area);
    L18:
        this.f566719n = r108;
        View r109 = this.f566670h;
        if (r109 == null) goto L21;
        LottieAnimationView r110 = (LottieAnimationView) r109.findViewById(R.id.sweep_anim);
    L22:
        this.F = r110;
        View r111 = this.f566669g;
        if (r111 == null) goto L25;
        ImageView r112 = (ImageView) r111.findViewById(R.id.indicator_icon);
    L26:
        this.f566720o = r112;
        View r113 = this.f566669g;
        if (r113 == null) goto L29;
        TextView r114 = (TextView) r113.findViewById(R.id.indicator_tv);
    L30:
        this.f566721p = r114;
        View r115 = this.f566669g;
        if (r115 == null) goto L33;
        View r116 = r115.findViewById(R.id.indicator_boundary);
    L34:
        this.f566707J = r116;
        View r117 = this.f566670h;
        if (r117 == null) goto L37;
        RelativeLayout r118 = (RelativeLayout) r117.findViewById(R.id.online_info_area);
    L38:
        this.D = r118;
        View r119 = this.f566670h;
        if (r119 == null) goto L41;
        StrokeTextView r120 = (StrokeTextView) r119.findViewById(R.id.online_info);
    L42:
        this.E = r120;
        View r121 = this.f566669g;
        if (r121 == null) goto L45;
        TextSwitcher r122 = (TextSwitcher) r121.findViewById(R.id.indicator_new_order_user_name);
    L46:
        this.f566722q = r122;
        View r123 = this.f566669g;
        if (r123 == null) goto L49;
        TextView r124 = (TextView) r123.findViewById(R.id.indicator_new_order_copy_writer);
    L50:
        this.f566725t = r124;
        this.f566724s = (ImageView) this.f566669g.findViewById(R.id.indicator_new_order_icon);
        this.f566723r = (ImageView) this.f566669g.findViewById(R.id.indicator_new_order_user_icon);
        this.f566726u = new d(this, Looper.getMainLooper());
        DataCenter r125 = this.f566668f;
        if (r125 == null) goto L53;
        IRoom r126 = com.bytedance.android.live.core.utils.a0.m(r125).f66427a;
    L54:
        this.Y = r126;
        View r127 = this.f566669g;
        if (r127 == null) goto L57;
        TextSwitcher r128 = (TextSwitcher) r127.findViewById(R.id.plus);
    L58:
        this.P = r128;
        View r129 = this.f566669g;
        if (r129 == null) goto L61;
        TextSwitcher r130 = (TextSwitcher) r129.findViewById(R.id.bits);
    L62:
        this.K = r130;
        View r131 = this.f566669g;
        if (r131 == null) goto L65;
        TextSwitcher r132 = (TextSwitcher) r131.findViewById(R.id.decade);
    L66:
        this.L = r132;
        View r133 = this.f566669g;
        if (r133 == null) goto L69;
        TextSwitcher r134 = (TextSwitcher) r133.findViewById(R.id.hundreds);
    L70:
        this.M = r134;
        View r135 = this.f566669g;
        if (r135 == null) goto L73;
        TextSwitcher r136 = (TextSwitcher) r135.findViewById(R.id.thousand);
    L74:
        this.N = r136;
        View r137 = this.f566669g;
        if (r137 == null) goto L77;
        TextSwitcher r138 = (TextSwitcher) r137.findViewById(R.id.wan);
    L78:
        this.O = r138;
        View r139 = this.f566669g;
        if (r139 == null) goto L81;
        r101 = (TextSwitcher) r139.findViewById(R.id.info_label);
    L81:
        this.Q = r101;
        this.S = CollectionsKt.mutableListOf(new TextSwitcher[]{this.K, this.L, this.M, this.N, this.O, this.P});
        this.T = CollectionsKt.mutableListOf(new View[]{this.f566720o, this.f566721p, this.f566722q, this.f566723r});
        this.U = CollectionsKt.mutableListOf(new View[]{this.f566719n, this.f566725t, this.f566724s, this.Q});
        ViewGroup r140 = this.f566718m;
        if (r140 == null) goto L84;
        r140.setOnClickListener(new e(this));
    L84:
        u();
        return;
    L77:
        r138 = null;
        goto L78
    L73:
        r136 = null;
        goto L74
    L69:
        r134 = null;
        goto L70
    L65:
        r132 = null;
        goto L66
    L61:
        r130 = null;
        goto L62
    L57:
        r128 = null;
        goto L58
    L53:
        r126 = null;
        goto L54
    L49:
        r124 = null;
        goto L50
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

    public final void r() {
        ValueAnimator r100 = this.I;
        if (r100 == null) goto L5;
        r100.cancel();
    L5:
        this.W.clear();
        ValueAnimator r101 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(ColorProtector.parseColor("#26000000")), Integer.valueOf(ColorProtector.parseColor("#80ff356f"))});
        this.I = r101;
        if (r101 == null) goto L11;
        r101.addListener(new j(this));
        r101.addUpdateListener(new k(r101, this));
        if (this.f566665c == true) goto L10;
        r101.setStartDelay(0);
        r101.setDuration(0);
        goto L11
    L10:
        r101.setStartDelay(200);
        r101.setDuration(300);
    L11:
        ValueAnimator r102 = this.I;
        if (r102 == null) goto L14;
        r102.start();
    L14:
        List<TextSwitcher> r103 = this.S;
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
        ValueAnimator r108 = this.H;
        if (r108 == null) goto L33;
        r108.cancel();
    L33:
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.H = r109;
        if (r109 == null) goto L36;
        r109.addListener(new l(this));
        r109.addUpdateListener(new m(r109, this));
        r109.setStartDelay(500);
        r109.setDuration(200);
    L36:
        ValueAnimator r110 = this.H;
        if (r110 == null) goto L46;
        r110.start();
        return;
    }

    @Override // y81.b, u81.d
    public final void onDestroy() {
        super.onDestroy();
        this.W.clear();
        Disposable r100 = this.V;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        LottieAnimationView r101 = this.F;
        if (r101 == null) goto L8;
        r101.cancelAnimation();
    L8:
        ValueAnimator r102 = this.G;
        if (r102 == null) goto L11;
        r102.cancel();
    L11:
        ValueAnimator r103 = this.H;
        if (r103 == null) goto L14;
        r103.cancel();
    L14:
        ValueAnimator r104 = this.I;
        if (r104 == null) goto L17;
        r104.cancel();
    L17:
        Disposable r105 = this.f566731z;
        if (r105 == null) goto L20;
        r105.dispose();
    L20:
        this.f566731z = null;
        u();
    }

    @Override // y81.b, u81.d
    public final Integer b() {
        return this.f566714g0;
    }

    @Override // u81.d
    public final int getItemType() {
        return this.f566715j;
    }

    public static final void l(d0 r100) {
        LottieAnimationView r101 = r100.F;
        if (r101 == null) goto L5;
        r101.setVisibility(0);
    L5:
        LottieAnimationView r102 = r100.F;
        if (r102 == null) goto L8;
        r102.addAnimatorListener(new u0(r102, r100));
        r102.setAnimation("rank_indicator_sweep.json");
        r102.setImageAssetsFolder("rank_indicator/");
        r102.loop(false);
    L8:
        r100.V = ((ObservableSubscribeProxy) du2.a.b(0, 1, TimeUnit.MINUTES).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r100.f566669g))).subscribe(new v0(r100), RxUtil.getNoOpThrowable());
    }

    @Override // u81.d
    public final void g(w81.a r110) {
        View r100 = null;
        if (r110 == null) goto L5;
        tlc.d r101 = r110.f558609a;
    L6:
        this.f566667e = r101;
        if ((r101 instanceof a4) == true) goto L9;
        r101 = null;
    L9:
        a4 r102 = (a4) r101;
        StringBuilder r103 = new StringBuilder("process holder binding, status: ");
        if (r102 == null) goto L12;
        Long r104 = r102.getStatus();
    L13:
        r103.append(r104);
        r103.append(", curStatus: ");
        r103.append(this.Z);
        r103.append(", showStatus: ");
        r103.append(this.f566709b0);
        ALogger.d("RoomIndicatorHolder", r103.toString());
        if (r102 != null) goto L17;
        return;
    L17:
        if (r110 == null) goto L21;
        Boolean r111 = r110.f558610b;
        if (r111 == null) goto L21;
        boolean r112 = r111.booleanValue();
    L22:
        this.f566665c = r112;
        Long r113 = r102.getStatus();
        BizStatus r105 = BizStatus.START;
        long r106 = r105.getValue();
        long r107 = 0;
        if (r113 != null) goto L26;
    L66:
        Long r114 = r102.getStatus();
        BizStatus r108 = BizStatus.END;
        long r109 = r108.getValue();
        if (r114 != null) goto L70;
    L124:
        Long r115 = r102.getStatus();
        long r116 = BizStatus.UPDATE.getValue();
        if (r115 != null) goto L128;
    L140:
        Long r117 = r102.getStatus();
        BizStatus r118 = BizStatus.NEW_ORDER;
        long r119 = r118.getValue();
        if (r117 != null) goto L144;
        return;
    L144:
        if (r117.longValue() == r119) goto L146;
        return;
    L146:
        if (this.Z != r108.getValue()) goto L148;
        return;
    L148:
        if (this.f566709b0 != 10) goto L167;
        this.Z = r118.getValue();
        m();
        if (o() == true) goto L152;
        return;
    L152:
        if (this.f566710c0 == true) goto L169;
        ALogger.i("RoomIndicatorHolder", "show new order");
        q();
        return;
    L169:
        return;
    L167:
        return;
    L128:
        if (r115.longValue() != r116) goto L140;
        if (this.Z == r108.getValue()) goto L140;
        if (this.f566709b0 != 10) goto L140;
        Long r120 = r102.getStatus();
        if (r120 == null) goto L136;
        long r121 = r120.longValue();
    L137:
        this.Z = r121;
        if (this.f566710c0 == true) goto L163;
        ALogger.i("RoomIndicatorHolder", "show update");
        m();
        return;
    L163:
        return;
    L136:
        r121 = BizStatus.UNKNOW.getValue();
        goto L137
    L70:
        if (r114.longValue() != r109) goto L124;
        if (this.Z == r108.getValue()) goto L124;
        if (this.f566709b0 != 10) goto L124;
        Long r122 = r102.getStatus();
        if (r122 == null) goto L78;
        long r123 = r122.longValue();
    L79:
        this.Z = r123;
        this.X = 0;
        this.f566710c0 = false;
        ALogger.i("RoomIndicatorHolder", "show end");
        i(1);
        Disposable r124 = this.V;
        if (r124 == null) goto L82;
        r124.dispose();
    L82:
        this.W.clear();
        LottieAnimationView r125 = this.F;
        if (r125 == null) goto L85;
        r125.cancelAnimation();
    L85:
        LottieAnimationView r126 = this.F;
        if (r126 == null) goto L88;
        r126.setVisibility(8);
    L88:
        ViewGroup r127 = this.f566719n;
        if (r127 != null) goto L91;
    L108:
        TextSwitcher r128 = this.Q;
        if (r128 != null) goto L111;
    L123:
        CompositeDisposable r129 = this.W;
        Observable r130 = Observable.just(this);
        TimeUnit r131 = TimeUnit.MILLISECONDS;
        r129.add(r130.delay(5000, r131).compose(RxUtil.rxSchedulerHelper()).subscribe(new f0(this), RxUtil.getNoOpThrowable()));
        this.W.add(Observable.just(this).delay(9000, r131).compose(RxUtil.rxSchedulerHelper()).subscribe(new g0(this), RxUtil.getNoOpThrowable()));
        return;
    L111:
        if (r128.getVisibility() != 0) goto L123;
        TextSwitcher r132 = this.Q;
        if (r132 == null) goto L115;
        View r133 = r132.getCurrentView();
    L117:
        if ((r133 instanceof TextView) == false) goto L120;
        r100 = r133;
    L120:
        TextView r134 = (TextView) r100;
        if (r134 == null) goto L123;
        r134.setTextColor(s1.h(R.color.ttlive_dou_plus_end_data_color));
        goto L123
    L115:
        r133 = null;
        goto L117
    L91:
        if (r127.getVisibility() != 0) goto L108;
        List<TextSwitcher> r135 = this.S;
        if (r135 == null) goto L123;
        Iterator<T> r136 = r135.iterator();
    L96:
        if (r136.hasNext() == false) goto L123;
        TextSwitcher r137 = (TextSwitcher) r136.next();
        if (r137 == null) goto L100;
        View r138 = r137.getCurrentView();
    L102:
        if ((r138 instanceof TextView) == false) goto L96;
        View r139 = r137.getCurrentView();
        if (r139 == null) goto L107;
        ((TextView) r139).setTextColor(s1.h(R.color.ttlive_dou_plus_end_data_color));
        goto L96
    L107:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    L100:
        r138 = null;
        goto L102
    L78:
        r123 = BizStatus.UNKNOW.getValue();
        goto L79
    L26:
        if (r113.longValue() != r106) goto L66;
        if (this.Z == r105.getValue()) goto L66;
        if (this.f566709b0 != 11) goto L54;
        if (this.f566711d0 == true) goto L54;
        Long r140 = r102.getStatus();
        if (r140 == null) goto L36;
        long r141 = r140.longValue();
    L37:
        this.Z = r141;
        ALogger.i("RoomIndicatorHolder", "show first start");
        this.f566711d0 = true;
        ValueAnimator r142 = this.I;
        if (r142 == null) goto L40;
        r142.cancel();
    L40:
        ValueAnimator r143 = this.G;
        if (r143 == null) goto L43;
        r143.cancel();
    L43:
        this.W.clear();
        ValueAnimator r144 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.G = r144;
        if (r144 == null) goto L49;
        r144.addListener(new h0(this));
        r144.addUpdateListener(new i0(r144, this));
        if (this.f566665c == true) goto L48;
        r144.setDuration(0);
        goto L49
    L48:
        r144.setDuration(500);
    L49:
        ValueAnimator r145 = this.G;
        if (r145 == null) goto L52;
        r145.start();
    L52:
        r();
    L62:
        Long r146 = r102.G();
        if (r146 == null) goto L65;
        r107 = r146.longValue();
    L65:
        String r147 = String.valueOf(r107);
        HashMap r148 = new HashMap();
        r148.put("biz_type", r147);
        int r149 = x81.c.f562885a;
        x81.c.a("livesdk_audience_live_hot_indicator_show", this.f566668f, null, r148);
        return;
    L36:
        r141 = BizStatus.UNKNOW.getValue();
    L54:
        if (this.Z != BizStatus.END.getValue()) goto L62;
        if (this.f566712e0 == true) goto L62;
        Long r150 = r102.getStatus();
        if (r150 == null) goto L60;
        long r151 = r150.longValue();
    L61:
        this.Z = r151;
        ALogger.i("RoomIndicatorHolder", "show start after end");
        r();
        goto L62
    L60:
        r151 = BizStatus.UNKNOW.getValue();
    L21:
        r112 = true;
        goto L22
    L12:
        r104 = null;
        goto L13
    L5:
        r101 = null;
        goto L6
    }

    public final void p(int r100) {
        ViewGroup r101 = this.f566719n;
        if (r101 != null) goto L5;
    L9:
        TextSwitcher r102 = this.Q;
        if (r102 == null) goto L20;
        if (r102.getVisibility() != 0) goto L20;
        TextSwitcher r103 = this.Q;
        if (r103 == null) goto L16;
        r103.setVisibility(8);
    L16:
        TextSwitcher r104 = this.Q;
        if (r104 == null) goto L20;
        r104.setCurrentText("");
    L20:
        if (TextUtils.equals(Marker.ANY_NON_NULL_MARKER, this.R) == true) goto L25;
        TextSwitcher r105 = this.P;
        if (r105 == null) goto L24;
        r105.setText(Marker.ANY_NON_NULL_MARKER);
    L24:
        this.R = Marker.ANY_NON_NULL_MARKER;
    L25:
        w(this.K, r100, 1);
        w(this.L, r100, 10);
        w(this.M, r100, 100);
        w(this.N, r100, 1000);
        w(this.O, r100, 10000);
        this.f566708a0 = r100;
        return;
    L5:
        if (r101.getVisibility() != 8) goto L9;
        ViewGroup r106 = this.f566719n;
        if (r106 == null) goto L9;
        r106.setVisibility(0);
        goto L9
    }

    public final void t(boolean r100) {
        BizContentType r101 = this.B;
        int r102 = e0.f566755d[r101.ordinal()];
        if (r102 == 1) goto L7;
        if (r102 == 2) goto L6;
        ALogger.i("RoomIndicatorHolder", "first line ----- illegal new order data type");
    L15:
        BizContentType r103 = this.C;
        int r104 = e0.f566756e[r103.ordinal()];
        if (r104 == 1) goto L20;
        if (r104 == 2) goto L19;
        ALogger.i("RoomIndicatorHolder", "second line ----- illegal new order data type");
        return;
    L19:
        s(this.f566724s, this.U);
        py.k r105 = (py.k) ListProtector.remove(this.f566730y, 0);
        n(this.f566724s, r105);
        return;
    L20:
        s(this.f566725t, this.U);
        String r106 = (String) ListProtector.remove(this.f566729x, 0);
        TextView r107 = this.f566725t;
        if (r107 == null) goto L26;
        r107.setText(r106);
        return;
    L26:
        return;
    L6:
        s(this.f566723r, this.T);
        py.k r108 = (py.k) ListProtector.remove(this.f566728w, 0);
        n(this.f566723r, r108);
        goto L15
    L7:
        s(this.f566722q, this.T);
        String r109 = (String) ListProtector.remove(this.f566727v, 0);
        if (r100 == false) goto L12;
        TextSwitcher r110 = this.f566722q;
        if (r110 == null) goto L15;
        r110.setCurrentText(r109);
        goto L15
    L12:
        TextSwitcher r111 = this.f566722q;
        if (r111 == null) goto L15;
        r111.setText(r109);
        goto L15
    }

    public static void s(View r100, List r101) {
        if (r101 == null) goto L20;
        Iterator r102 = r101.iterator();
    L5:
        if (r102.hasNext() == false) goto L38;
        View r103 = (View) r102.next();
        if (Intrinsics.areEqual(r103, r100) == false) goto L14;
        if (r103 == null) goto L11;
        if (r103.getVisibility() == 0) goto L14;
    L11:
        if (r103 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r103, true);
    L14:
        if ((!Intrinsics.areEqual(r103, r100)) == false) goto L5;
        if (r103 == null) goto L18;
        if (r103.getVisibility() == 8) goto L5;
    L18:
        if (r103 == null) goto L5;
        UtilityKotlinExtentionsKt.z(r103, false);
        goto L5
    L38:
        return;
    }

    public static void v(View r100, float r101) {
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ViewGroup r102 = (ViewGroup) r100;
        int r103 = r102.getChildCount();
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L13;
        v(r102.getChildAt(r104), r101);
        r104 = r104 + 1;
        goto L5
    L13:
        return;
    L8:
        if ((r100 instanceof View) == false) goto L12;
        r100.setAlpha(r101);
        return;
    }

    public final void n(ImageView r100, py.k r101) {
        if (r101 == null) goto L22;
        if (r100 == null) goto L5;
        ViewGroup.LayoutParams r102 = r100.getLayoutParams();
    L6:
        int r103 = -2;
        if (r102 != null) goto L9;
    L13:
        if (r102 != null) goto L15;
    L18:
        if (r100 == null) goto L20;
        r100.setLayoutParams(r102);
    L20:
        Disposable r104 = a1.k(r101).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(r100), new c(r100));
        Intrinsics.checkNotNullParameter(r104, "$this$autoBind");
        this.f566664b.add(r104);
        return;
    L15:
        if (r101.getHeight() <= 0) goto L17;
        r103 = UtilityKotlinExtentionsKt.i(r101.getHeight());
    L17:
        r102.height = r103;
        goto L18
    L9:
        if (r101.getWidth() <= 0) goto L11;
        int r105 = UtilityKotlinExtentionsKt.i(r101.getWidth());
    L12:
        r102.width = r105;
        goto L13
    L11:
        r105 = -2;
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public final void w(TextSwitcher r100, int r101, int r102) {
        if (r100 == null) goto L19;
        int r103 = this.f566708a0;
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

    public static final void k(d0 r100, ViewGroup r101, int r102, int r103) {
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

    public d0(DataCenter r100, View r101, int r102, View r103, Integer r104) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        Intrinsics.checkNotNullParameter(r103, "parentView");
        super(r100, r101, r103);
        this.f566714g0 = r104;
        this.f566715j = r102;
        this.f566727v = new ArrayList();
        this.f566728w = new ArrayList();
        this.f566729x = new ArrayList();
        this.f566730y = new ArrayList();
        BizContentType r105 = BizContentType.UNKNOW;
        this.A = r105;
        this.B = r105;
        this.C = r105;
        this.W = new CompositeDisposable();
        this.Z = BizStatus.UNKNOW.getValue();
        this.f566708a0 = -1;
        this.f566709b0 = 11;
    }
}
