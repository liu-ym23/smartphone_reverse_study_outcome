package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Lifecycle;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.ECPDPBaseVideo;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.base.LocalImage;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackEntryApi;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.api.PlaybackVideoRequestParams;
import com.bytedance.android.shopping.anchorv4.voavhs.base.extensions.ImageExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0010B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/business/pdp/view/AnchorV4PlaybackAreaV2;", "Landroidx/cardview/widget/CardView;", "Lfa3/d;", "", "getCurVideoProgress", "Lij/a;", "event", "", "onPlaybackPageReturned", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4PlaybackAreaV2 extends CardView implements fa3.d {
    public final /* synthetic */ fa3.b A;
    public final View a;
    public final View b;
    public final SimpleDraweeView c;
    public final LottieAnimationView d;
    public final View e;
    public PlayerBlock f;
    public final View g;
    public final SimpleDraweeView h;
    public final TextView i;
    public final TextView j;
    public final ECLottieAnimationView k;
    public final View l;
    public final SimpleDraweeView m;
    public int n;
    public int o;
    public boolean p;
    public n73.a q;
    public Integer r;
    public Integer s;
    public boolean t;
    public fj.d u;
    public ECPDPBaseVideo v;
    public long w;
    public boolean x;
    public boolean y;
    public Function0<Unit> z;

    public static final class a {
    }

    static {
    }

    public AnchorV4PlaybackAreaV2(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4PlaybackAreaV2(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.A.add(r2);
        return r2;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r1) {
        return true;
    }

    private final int getCurVideoProgress() {
        PlayerBlock r0 = this.f;
        if (r0 == null) goto L5;
        float r1 = r0.getPlayProgress();
    L6:
        float r2 = r1 / 100;
        PlayerBlock r3 = this.f;
        if (r3 == null) goto L11;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r4 = r3.getVideoModel();
        if (r4 == null) goto L11;
        long r5 = r4.a();
    L13:
        return (int) ((r2 * r5) / 1000.0f);
    L11:
        r5 = 0;
        goto L13
    L5:
        r1 = 0.0f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        if (this.f == null) goto L5;
        return;
    L5:
        ViewGroup r0 = (ViewGroup) findViewById(2131392430);
        PlayerBlock r9 = new PlayerBlock(getContext(), null, 0, null, false, false, 510);
        int r1 = com.bytedance.android.shopping.extensions.b.a(30);
        int r2 = com.bytedance.android.shopping.extensions.b.a(36);
        ImageView r3 = r9.a;
        ViewGroup.LayoutParams r4 = r3.getLayoutParams();
        r4.width = r1;
        r4.height = r2;
        Unit r5 = Unit.INSTANCE;
        r3.setLayoutParams(r4);
        if (r0 == null) goto L8;
        r0.addView(r9, 0, new FrameLayout.LayoutParams(-1, -1));
    L8:
        this.f = r9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        s0.c(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        s0.e(this);
    }

    @Subscribe
    public final void onPlaybackPageReturned(ij.a r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        long r0 = this.w;
        if (r0 <= 0) goto L9;
        float r7 = r6.a;
        if ((r7 - (r0 * ((long) 1000))) <= 0) goto L13;
        PlayerBlock r1 = this.f;
        if (r1 == null) goto L14;
        r1.J(r7);
        return;
    L14:
        return;
    L13:
        return;
    L9:
        PlayerBlock r2 = this.f;
        if (r2 == null) goto L16;
        r2.J(r6.a);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4PlaybackAreaV2(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.A = new fa3.b();
        this.n = -1;
        this.o = -1;
        if (PdpPerfOpt.b().j() == false) goto L5;
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131564616, this, true);
    L6:
        setRadius(com.bytedance.android.shopping.extensions.b.b(12));
        setElevation(com.bytedance.android.shopping.extensions.b.b(10));
        setMaxCardElevation(com.bytedance.android.shopping.extensions.b.b(10));
        setCardBackgroundColor(0);
        setAlpha(0.99f);
        this.a = findViewById(2131384324);
        this.b = findViewById(2131384323);
        this.c = findViewById(2131389202);
        this.d = findViewById(2131389203);
        this.e = findViewById(2131392430);
        if (PdpPerfOpt.e() == true) goto L9;
        c();
    L9:
        this.g = findViewById(2131364455);
        this.h = findViewById(2131364501);
        this.j = (TextView) findViewById(2131364457);
        this.i = (TextView) findViewById(2131364456);
        this.l = findViewById(2131392496);
        this.k = findViewById(2131392495);
        this.m = findViewById(2131392291);
        setVisibility(4);
        return;
    L5:
        th.a.c(r2, 2131564616, this, true);
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.lifecycle.LifecycleObserver, com.bytedance.android.shopping.prepurchase.business.pdp.view.AnchorV4PlaybackAreaV2$bindData$4] */
    public final void b(final PlayBackEntryVO r10, n73.a r11, final com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.d r12) {
        Intrinsics.checkNotNullParameter(r12, "dependency");
        setVisibility(8);
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.isFloatEntryVisible() == true) goto L8;
        return;
    L8:
        if (r10.isShowLiveIcon() == true) goto L10;
    L12:
        setVisibility(0);
        boolean r2 = r12.e();
        this.y = r2;
        if (r2 == true) goto L15;
    L19:
        this.q = r11;
        setOnClickListener(new com.bytedance.android.shopping.prepurchase.business.pdp.view.a(this, r11, r10, r12));
        ImageModel r3 = r10.getPlayBackIcon();
        LocalImage r4 = null;
        if (r3 == null) goto L22;
        ECUrlModel r5 = r3.getRemote();
    L24:
        if (r5 == null) goto L26;
        y.a(this.c, r10.getPlayBackIcon().getRemote());
    L34:
        this.i.setText(r10.getEntryText());
        this.j.setText(r10.getEntryText());
        y.a(this.h, r10.getBottomPrefixIcon());
        y.a(this.m, r10.getVideoCoverImage());
        ECLottieAnimationView r6 = this.k;
        ImageModel r7 = r10.getLottie();
        if (r7 == null) goto L46;
        LocalImage r8 = r7.getLocal();
        if (r8 == null) goto L46;
        String r9 = r8.getName();
        if (r9 == null) goto L46;
        if (com.bytedance.android.shopping.extensions.k.c(r9) == true) goto L44;
        r9 = null;
    L44:
        if (r9 == null) goto L46;
        r6.setAnimation(r9.concat(".json"));
    L46:
        this.p = r10.shouldGoneWithHead();
        Integer r13 = r10.getShowStyle();
        if (r13 != null) goto L50;
    L52:
        boolean r14 = false;
    L53:
        this.x = r14;
        if (r10.showNewStylePlayBackEntry(Boolean.valueOf(r12.isFullScreen())) == false) goto L69;
        Link r15 = r10.getReplayLink();
        if (r15 == null) goto L58;
        String r16 = r15.getLinkUrl();
    L59:
        com.bytedance.android.shopping.anchorv4.video.f r17 = r12.d();
        if (r16 != null) goto L62;
    L65:
        boolean r18 = true;
    L66:
        if (r18 == true) goto L71;
        PlaybackEntryApi.a r19 = PlaybackEntryApi.a;
        PlaybackVideoRequestParams.Companion.getClass();
        PlaybackVideoRequestParams r110 = PlaybackVideoRequestParams.a.a(r16);
        r19.getClass();
        fa3.c.a(bg4.b.b(PlaybackEntryApi.a.a(r110)).subscribe(new d(this, r17), e.a), this);
    L71:
        boolean r111 = r10.showNewStylePlayBackEntry(Boolean.valueOf(r12.isFullScreen()));
        if (r111 == true) goto L85;
        this.c.setVisibility(8);
        this.d.setVisibility(8);
        ImageModel r112 = r10.getPlayBackIcon();
        if (r112 == null) goto L76;
        ECUrlModel r113 = r112.getRemote();
    L77:
        if (r113 == null) goto L79;
        this.c.setVisibility(0);
    L84:
        this.i.setVisibility(0);
        this.e.setVisibility(8);
        this.g.setVisibility(8);
    L87:
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r20 = r12.b();
        int r21 = r12.c();
        int r114 = r20.a;
        Boolean r0 = r10.isHeadAreaLengthened();
        Boolean r1 = Boolean.TRUE;
        if (Intrinsics.areEqual(r0, r1) == false) goto L90;
        int r115 = (r114 * 4) / 3;
    L90:
        int r22 = com.bytedance.android.shopping.extensions.j.a(2131165695);
        if (Intrinsics.areEqual(r10.isHeadHasScrollMore(), r1) == false) goto L93;
        com.bytedance.android.shopping.extensions.b.b(146);
    L93:
        setVisibility(4);
        post(new f(this, r22, r20, r21, r12, r10));
        Function0<Unit> r116 = this.z;
        if (r116 == null) goto L96;
        Unit r117 = (Unit) r116.invoke();
    L96:
        Lifecycle r118 = r12.getLifecycleOwner().getLifecycleCompat();
        if (r118 == null) goto L101;
        final ?? r23 = new AnchorV4PlaybackAreaV2$bindData$4(this, r10, r12);
        this.z = new AnchorV4PlaybackAreaV2$bindData$$inlined$apply$lambda$1(r23, this, r12);
        Unit r119 = Unit.INSTANCE;
        r118.addObserver(r23);
        return;
    L101:
        return;
    L79:
        ImageModel r120 = r10.getPlayBackIcon();
        if (r120 == null) goto L82;
        r4 = r120.getLocal();
    L82:
        if (r4 == null) goto L84;
        this.d.setVisibility(0);
        goto L84
    L76:
        r113 = null;
        goto L77
    L85:
        if (r111 != true) goto L87;
        this.g.setVisibility(0);
        this.i.setVisibility(8);
        this.e.setVisibility(0);
        goto L87
    L62:
        if (r16.length() == 0) goto L65;
        r18 = false;
        goto L66
    L58:
        r16 = null;
        goto L59
    L69:
        if (r11 == null) goto L71;
        r11.a(null);
        goto L71
    L50:
        if (r13.intValue() != 0) goto L52;
        r14 = true;
        goto L53
    L26:
        ImageModel r24 = r10.getPlayBackIcon();
        if (r24 == null) goto L29;
        LocalImage r25 = r24.getLocal();
    L30:
        if (r25 == null) goto L34;
        ImageExtensionsKt.e(this.d, r10.getPlayBackIcon());
        Object r26 = this.d.getTag();
        Boolean r27 = Boolean.TRUE;
        if ((!Intrinsics.areEqual(r26, r27)) == false) goto L34;
        this.d.setTag(r27);
        this.d.addOnAttachStateChangeListener(new b(this));
        goto L34
    L29:
        r25 = null;
        goto L30
    L22:
        r5 = null;
        goto L24
    L15:
        if (r12.isFullScreen() == true) goto L19;
        if (r12.f() == true) goto L19;
        setAlpha(0.0f);
        goto L19
    L10:
        if (r12.a() == false) goto L12;
    }

    public /* synthetic */ AnchorV4PlaybackAreaV2(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public static final int a(AnchorV4PlaybackAreaV2 r0, int r1, int r2, float r3) {
        r0.getClass();
        return (int) (r1 + ((r2 - r1) * r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        int r0 = this.n;
        if (r0 < 0) goto L9;
        int r1 = this.o;
        if (r1 < 0) goto L9;
        if (r0 != r4) goto L8;
        if (r1 == r5) goto L9;
    L8:
        layout(r0, r1, (r6 - r4) + r0, (r7 - r5) + r1);
        return;
    L9:
        super/*android.widget.FrameLayout*/.onLayout(r3, r4, r5, r6, r7);
    }
}
