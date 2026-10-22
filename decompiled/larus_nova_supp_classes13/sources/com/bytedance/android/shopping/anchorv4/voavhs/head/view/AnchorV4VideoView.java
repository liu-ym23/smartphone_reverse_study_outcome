package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.opt.asyncInflate.ShoppingAsyncInflater;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerBlock;
import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayerViewScene;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.bytedance.android.shopping.anchorv4.video.AnchorV4PlayerStateManager;
import com.bytedance.android.shopping.anchorv4.voavhs.base.elements.TextWithOneIconElementView;
import com.bytedance.android.shopping.anchorv4.voavhs.head.SlidesAndIndicatorV4Component;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.vo.CommentVideoInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.item.video.VideoCoverLayout;
import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000f\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/AnchorV4VideoView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/o;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/base/k;", "Lfa3/d;", "", "getVideoType", "Ld83/b;", "getHeadAbility", "", "isSmall", "", "setIsSmallComponent", "Lcom/bytedance/android/shopping/anchorv3/detail/widget/playerblock/PlayerBlock;", "getPlayerBlock", "", "getVideoProgress", "()Ljava/lang/Float;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4VideoView extends FrameLayout implements com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.o, com.bytedance.android.shopping.anchorv4.voavhs.head.base.k, fa3.d {
    public static final /* synthetic */ int F = 0;
    public boolean A;
    public boolean B;
    public VideoCoverLayout C;
    public com.bytedance.android.shopping.anchorv4.voavhs.head.base.d D;
    public final /* synthetic */ fa3.b E;
    public ImageView a;
    public View b;
    public ProgressBar c;
    public final PlayerBlock d;
    public com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b e;
    public Function0<Unit> f;
    public String g;
    public h83.g h;
    public final List<Function1<Float, Unit>> i;
    public c63.d j;
    public GaussianBlurConfig k;
    public final View l;
    public final ECDraweeView m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public long r;
    public String s;
    public boolean t;
    public final AnchorV4CommentVideoEntryLayout u;
    public boolean v;
    public Bitmap w;
    public Bitmap x;
    public final c y;
    public Object z;

    public static final class a implements Runnable {
        public final /* synthetic */ AnchorV4VideoView a;

        public a(AnchorV4VideoView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getHeight();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b {
    }

    public static final class c implements com.bytedance.android.ec.model.j {
        public final /* synthetic */ AnchorV4VideoView a;

        public final void onClick() {
        }

        public final void onClose(boolean r1) {
        }

        public final void onReturnClick() {
        }

        public final void onShow() {
        }

        public c(AnchorV4VideoView r1) {
            this.a = r1;
        }

        public final void onMuteButtonClick(boolean r3) {
            if (r3 == true) goto L17;
            PlayerBlock r4 = this.a.d;
            if (r4 != null) goto L6;
            return;
        L6:
            if (r4.isPlaying() != true) goto L19;
            PlayerBlock r5 = this.a.d;
            if (r5 != null) goto L10;
        L12:
            if (r5 != null) goto L14;
            return;
        L14:
            if (r5.t() == true) goto L21;
            PlayerBlock.o(r5, false, 2);
            return;
        L21:
            return;
        L10:
            if (r5.o != true) goto L12;
            return;
        L19:
            return;
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ AnchorV4VideoView a;

        public d(AnchorV4VideoView r1, int r2) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            Intrinsics.checkNotNullParameter((Long) r2, "it");
            final AnchorV4VideoView r3 = this.a;
            int r0 = AnchorV4VideoView.F;
            r3.getClass();
            return Observable.create(new AnchorV4VideoView$getVideoFrame$1(r3));
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AnchorV4VideoView a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ GaussianBlurConfig c;

        public e(AnchorV4VideoView r1, boolean r2, GaussianBlurConfig r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r3) {
            Bitmap r4 = (Bitmap) r3;
            if (this.b == false) goto L8;
            AnchorV4VideoView r0 = this.a;
            if (r0.v == true) goto L7;
            this.c.getMaskColor();
            AnchorV4VideoView.g(r0, r4);
        L7:
            this.a.v = true;
            return;
        L8:
            AnchorV4VideoView r1 = this.a;
            this.c.getMaskColor();
            AnchorV4VideoView.g(r1, r4);
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    static {
    }

    public AnchorV4VideoView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AnchorV4VideoView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void W(boolean r1) {
    }

    @Override // fa3.d
    public final Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.E.add(r2);
        return r2;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onPause() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onResume() {
    }

    private final d83.b getHeadAbility() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r0 = this.D;
        if (r0 == null) goto L5;
        SlidesAndIndicatorV4Component r1 = r0.r();
    L7:
        if ((r1 instanceof d83.b) == true) goto L10;
        return null;
    L10:
        return r1;
    L5:
        r1 = null;
        goto L7
    }

    private final String getVideoType() {
        h83.g r0 = this.h;
        if (r0 != null) goto L5;
    L7:
        return "main_video";
    L5:
        if (r0.i != true) goto L7;
        return "test_tab";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void c() {
        PlayerBlock r0 = this.d;
        if (r0 == null) goto L5;
        int r1 = PlayerBlock.T;
        r0.D(false, false, false);
    L5:
        this.E.a();
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void d() {
        h83.g r0 = this.h;
        if (r0 != null) goto L5;
    L9:
        d83.b r1 = getHeadAbility();
        if (r1 != null) goto L12;
    L13:
        PlayerBlock r2 = this.d;
        if (r2 == null) goto L20;
        int r3 = PlayerBlock.T;
        r2.F(true);
        return;
    L20:
        return;
    L12:
        if (r1.a() != true) goto L13;
        return;
    L5:
        if (r0.i != true) goto L9;
        PlayerBlock r4 = this.d;
        if (r4 == null) goto L17;
        r4.F(false);
        return;
    }

    public final Float getVideoProgress() {
        PlayerBlock r0 = this.d;
        if (r0 != null) goto L7;
        return null;
    L7:
        return Float.valueOf(r0.getPlayProgress());
    }

    public final void l() {
        h83.g r0 = this.h;
        if (r0 == null) goto L14;
        ECUrlModel r1 = r0.c;
        if (r1 == null) goto L15;
        String r2 = r1.getFirstUrl();
        if (r2 != null) goto L10;
        return;
    L10:
        if (this.B == true) goto L17;
        this.B = true;
        fa3.c.a(Observable.create(new r(r2)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new s(this)), this);
        return;
    L17:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.l
    public final void onDestroy() {
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r0 = this.e;
        if (r0 == null) goto L5;
        Integer r1 = r0.h();
    L6:
        n("quit", r1, false);
        this.t = true;
        PlayerBlock r2 = this.d;
        if (r2 == null) goto L9;
        r2.B();
    L9:
        this.E.a();
        if (this.A == false) goto L20;
        Object r3 = this.z;
        if (r3 == null) goto L18;
        int r4 = ECSdk.a;
        IAdapterService r5 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r5 == null) goto L18;
        com.bytedance.android.ec.adapter.api.j r6 = r5.getLiveWindowService();
        if (r6 == null) goto L18;
        r6.d(r3);
    L18:
        this.A = false;
        return;
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final PlayerBlock getPlayerBlock() {
        return this.d;
    }

    public static final /* synthetic */ String h(AnchorV4VideoView r0) {
        return r0.getVideoType();
    }

    public final void Q(float r4) {
        float r0 = (float) Math.floor(r4);
        ProgressBar r1 = this.c;
        if (r1 == null) goto L5;
        r1.setProgress((int) r0);
    L5:
        Iterator r2 = ((ArrayList) this.i).iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        Function1 r3 = (Function1) r2.next();
        if (r3 == null) goto L7;
        Unit r5 = (Unit) r3.invoke(Float.valueOf(r4));
        goto L7
    L11:
        VideoCoverLayout r6 = this.C;
        if (r6 == null) goto L20;
        r6.setProgress(r4 / 100);
        return;
    }

    public final void R(boolean r2) {
        View r0 = this.b;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        int r3 = 0;
    L7:
        r0.setVisibility(r3);
        goto L8
    L6:
        r3 = 8;
    L8:
        c63.d r4 = this.j;
        if (r4 == null) goto L12;
        r4.d();
        return;
    }

    public final void V(boolean r3) {
        ImageView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setSelected(!r3);
    L5:
        VideoCoverLayout r1 = this.C;
        if (r1 == null) goto L9;
        r1.setAudioState(r3);
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.head.base.k
    public final void e(boolean r5) {
        PlayerBlock r0 = this.d;
        if (r0 == null) goto L5;
        int r3 = PlayerBlock.T;
        r0.D(true, r5, false);
    L5:
        PlayerBlock r6 = this.d;
        if (r6 != null) goto L8;
    L10:
        o(true);
        c63.d r7 = this.j;
        String r1 = null;
        if (r7 == null) goto L17;
        String r2 = this.g;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r4 = this.e;
        if (r4 == null) goto L15;
        String r8 = r4.j();
    L16:
        r7.F(r2, r8);
        goto L17
    L15:
        r8 = null;
    L17:
        this.s = "click_tab";
        c63.d r9 = this.j;
        if (r9 == null) goto L24;
        String r10 = getVideoType();
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r11 = this.e;
        if (r11 == null) goto L22;
        r1 = r11.j();
    L22:
        r9.s(r10, r1);
        return;
    L24:
        return;
    L8:
        if (r6.getCompleteMode() == true) goto L10;
        o(false);
        goto L10
    }

    public final void m(GaussianBlurConfig r2) {
        this.k = r2;
        if (r2 == null) goto L8;
        l();
        PlayerBlock r3 = this.d;
        if (r3 == null) goto L9;
        r3.g(new AnchorV4VideoView$configBlurSetting$1(this));
        return;
    L9:
        return;
    }

    public final void o(boolean r14) {
        GaussianBlurConfig r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        Integer r1 = r0.getFps();
        if (r1 == null) goto L8;
        int r2 = r1.intValue();
    L9:
        Integer r3 = r0.getRadius();
        if (r3 == null) goto L12;
        int r4 = r3.intValue();
    L13:
        if (r14 == false) goto L15;
        this.v = false;
        long r9 = 1000 / ((long) r2);
        Observable r5 = com.bytedance.android.ec.core.rxjava.a.b(r9, r9, TimeUnit.MILLISECONDS, Schedulers.computation()).filter(new t(this));
    L16:
        fa3.c.a(r5.observeOn(Schedulers.computation()).flatMap(new d(this, r4)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e(this, r14, r0), f.a), this);
        return;
    L15:
        r5 = Observable.rangeLong(0, 5).subscribeOn(Schedulers.computation()).filter(new u(this));
        goto L16
    L12:
        r4 = com.bytedance.android.shopping.extensions.b.b(20);
        goto L13
    L8:
        r2 = 24;
        goto L9
    }

    public final void setIsSmallComponent(boolean r10) {
        boolean r0 = false;
        if (r10 == false) goto L5;
    L20:
        VideoCoverLayout r11 = this.C;
        if (r11 != null) goto L58;
        ImageView r12 = this.a;
        if (r12 == null) goto L30;
        PlayerBlock r3 = this.d;
        if (r3 != null) goto L27;
    L28:
        r0 = true;
    L29:
        r12.setSelected(r0);
        goto L30
    L27:
        if (r3.o == true) goto L29;
    L30:
        ImageView r13 = this.a;
        if (r13 == null) goto L33;
        r13.setOnClickListener(new v(this));
    L33:
        View r14 = this.b;
        if (r14 == null) goto L36;
        r14.setVisibility(8);
    L36:
        boolean r15 = com.bytedance.android.shopping.anchorv4.experiment.d.a();
        if (r15 == false) goto L41;
        View r1 = this.b;
        if (r1 == null) goto L41;
        r1.setPadding(com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8), com.bytedance.android.shopping.extensions.b.b(15), com.bytedance.android.shopping.extensions.b.b(8));
    L41:
        ImageView r2 = this.a;
        if (r2 == null) goto L52;
        ViewGroup.LayoutParams r4 = r2.getLayoutParams();
        if (r15 == false) goto L46;
        int r5 = 40;
    L47:
        r4.width = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5));
        if (r15 == false) goto L50;
        int r6 = 20;
    L51:
        r4.height = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r6));
        Unit r7 = Unit.INSTANCE;
        r2.setLayoutParams(r4);
        goto L52
    L50:
        r6 = 24;
        goto L51
    L46:
        r5 = 36;
    L52:
        ImageView r8 = this.a;
        if (r8 == null) goto L67;
        if (r15 == false) goto L56;
        int r16 = 2131233375;
    L57:
        r8.setImageResource(r16);
        return;
    L56:
        r16 = 2131233374;
        goto L57
    L67:
        return;
    L58:
        PlayerBlock r9 = this.d;
        if (r9 != null) goto L61;
    L63:
        r11.setAudioState(r0);
        return;
    L61:
        if (r9.o != true) goto L63;
        r0 = true;
        goto L63
    L5:
        if (com.bytedance.android.shopping.anchorv4.video.float.e.b() == false) goto L20;
        View r17 = this.b;
        if (r17 == null) goto L9;
        r17.setVisibility(8);
    L9:
        ProgressBar r18 = this.c;
        if (r18 == null) goto L12;
        r18.setVisibility(8);
    L12:
        this.a = null;
        this.b = null;
        this.c = null;
        VideoCoverLayout r19 = new VideoCoverLayout(getContext(), new n(this));
        this.C = r19;
        Unit r20 = Unit.INSTANCE;
        ViewGroup.LayoutParams r21 = new FrameLayout.LayoutParams(-1, -1);
        PlayerBlock r22 = this.d;
        int r23 = getChildCount();
        int r24 = 0;
        int r25 = -1;
    L13:
        if (r24 >= r23) goto L18;
        if (Intrinsics.areEqual(getChildAt(r24), r22) == true) goto L19;
        r25 = r24;
        r24 = r24 + 1;
    L19:
        addView(r19, r24 + 1, r21);
        goto L20
    L18:
        r24 = r25;
        goto L19
    }

    public static final void g(AnchorV4VideoView r4, Bitmap r5) {
        View r0 = r4.l;
        if (r0 == null) goto L24;
        ImageView r1 = (ImageView) r0.findViewById(2131382459);
        r1.setVisibility(0);
        r0.findViewById(2131382461);
        if (r4.o == true) goto L9;
        r0.setVisibility(0);
        r4.o = true;
    L9:
        if (r4.p == true) goto L11;
    L13:
        float r6 = 2.0f;
    L14:
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        r2.width = (int) (r5.getWidth() * r6);
        r2.height = (int) (r6 * r5.getHeight());
        Unit r7 = Unit.INSTANCE;
        r1.setLayoutParams(r2);
        Drawable r8 = r1.getDrawable();
        if ((r8 instanceof BitmapDrawable) == true) goto L17;
        r8 = null;
    L17:
        BitmapDrawable r9 = (BitmapDrawable) r8;
        if (r9 == null) goto L22;
        Bitmap r10 = r9.getBitmap();
        if (r10 == null) goto L22;
        r10.recycle();
    L22:
        r1.setImageBitmap(r5);
        return;
    L11:
        if (r4.q == false) goto L13;
        r6 = 2.5f;
        goto L14
    }

    public AnchorV4VideoView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.E = new fa3.b();
        this.i = new ArrayList();
        this.r = -1;
        this.s = "auto";
        this.y = new c(this);
        ShoppingAsyncInflater.e.getClass();
        ShoppingAsyncInflater.a.a(r2).aU(2131560500, this, true);
        this.a = (ImageView) findViewById(2131376015);
        this.b = findViewById(2131376016);
        this.c = (ProgressBar) findViewById(2131382056);
        PlayerBlock r5 = findViewById(2131382458);
        this.d = r5;
        ViewGroup.LayoutParams r6 = null;
        if (r5 == null) goto L5;
        int r0 = PlayerBlock.T;
        r5.q(true, null, null);
    L5:
        if (r5 == null) goto L7;
        r5.setPlayBlockClickListener(new AnonymousClass1(this));
    L7:
        if (r5 == null) goto L9;
        r5.g(new AnonymousClass2(this));
    L9:
        if (r5 == null) goto L11;
        r5.i(this);
    L11:
        if (r5 == null) goto L13;
        r5.i = new AnonymousClass3(this);
    L13:
        if (r5 == null) goto L15;
        r5.post(new a(this));
    L15:
        View r7 = findViewById(2131382460);
        this.l = r7;
        if (r7 == null) goto L20;
        wg.a.a(r7);
        if (r5 == null) goto L20;
        r5.addView(r7, 0);
    L20:
        if (r5 == null) goto L22;
        ECDraweeView r8 = (ECDraweeView) r5.findViewById(2131364311);
    L23:
        this.m = r8;
        AnchorV4CommentVideoEntryLayout r9 = (AnchorV4CommentVideoEntryLayout) findViewById(2131367464);
        this.u = r9;
        d83.b r10 = getHeadAbility();
        if (r10 == null) goto L26;
        Boolean r11 = Boolean.valueOf(r10.g());
    L28:
        if (com.bytedance.android.shopping.extensions.k.i(r11) == false) goto L38;
        if (r9 == null) goto L39;
        ViewGroup.LayoutParams r12 = r9.getLayoutParams();
        if ((r12 instanceof ViewGroup.MarginLayoutParams) == false) goto L34;
        r6 = r12;
    L34:
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r6;
        if (r13 == null) goto L40;
        r13.bottomMargin = com.bytedance.android.shopping.extensions.b.b(48);
        r9.setLayoutParams(r13);
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L26:
        r11 = null;
        goto L28
    L22:
        r8 = null;
        goto L23
    }

    public final void n(String r15, Integer r16, boolean r17) {
        if (this.r >= 0) goto L5;
        return;
    L5:
        long r1 = SystemClock.elapsedRealtime();
        c63.d r3 = this.j;
        if (r3 == null) goto L16;
        String r4 = this.s;
        if (this.q == false) goto L10;
        String r5 = "inflow";
    L11:
        long r6 = r1 - this.r;
        String r10 = getVideoType();
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r2 = this.e;
        if (r2 == null) goto L14;
        String r7 = r2.j();
    L15:
        r3.w(r4, r5, r6, r15, r16, r10, r7, r17, null);
        goto L16
    L14:
        r7 = null;
        goto L15
    L10:
        r5 = "product";
    L16:
        this.r = -1;
    }

    public /* synthetic */ AnchorV4VideoView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    public final void k(final h83.g r22, final com.bytedance.android.shopping.anchorv4.voavhs.head.base.d r23, final com.bytedance.android.shopping.anchorv4.voavhs.head.holder.s r24, Function0 r25) {
        if (r22 != null) goto L5;
        return;
    L5:
        this.h = r22;
        if (r23 == null) goto L8;
        r23.l();
    L8:
        int r4 = 0;
        boolean r5 = true;
        if (r23 != null) goto L11;
    L13:
        boolean r6 = false;
    L14:
        this.p = r6;
        this.q = r22.i;
        String r7 = null;
        if (r23 == null) goto L17;
        c63.d r8 = r23.t();
    L18:
        this.j = r8;
        if (r23 == null) goto L21;
        r23.u1();
    L21:
        PlayerBlock r9 = this.d;
        if (r9 == null) goto L24;
        r9.setLogAction(this.j);
    L24:
        PlayerBlock r10 = this.d;
        if (r10 == null) goto L27;
        r10.setForbidPlay(r22.e);
    L27:
        PlayerBlock r11 = this.d;
        if (r11 == null) goto L30;
        r11.setVideoType(getVideoType());
    L30:
        this.D = r23;
        PlayerBlock r12 = this.d;
        if (r12 == null) goto L33;
        r12.setAudioInterceptor(new p(r23));
    L33:
        if (r23 == null) goto L39;
        AnchorV4PlayerStateManager r13 = r23.e();
        if (r13 == null) goto L39;
        PlayerBlock r14 = this.d;
        if (r14 == null) goto L39;
        r14.u(r13, new o(r23));
    L39:
        PlayerBlock r15 = this.d;
        if (r15 == null) goto L42;
        r15.setCollisionNegotiator(r22.d);
    L42:
        PlayerBlock r16 = this.d;
        if (r16 == null) goto L50;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r17 = r22.a;
        if (r17 == null) goto L47;
        PlayerViewScene r18 = r17.e;
    L48:
        if (r18 == null) goto L50;
        r16.z = r18;
        goto L50
    L47:
        r18 = null;
    L50:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r19 = r22.a;
        ECUrlModel r110 = r22.c;
        if (r22.h == null) goto L53;
        boolean r111 = true;
    L54:
        Function0<Unit> r20 = new AnchorV4VideoView$bindVideoView$3(r23);
        this.e = r19;
        PlayerBlock r21 = this.d;
        if (r21 == null) goto L57;
        PlayerBlock.m(r21, r19, r110, r111, AVScene.CONTENT_PRODUCT_DETAIL_HEADER, null, r25, 16);
    L57:
        this.f = r20;
        PlayerBlock r2 = this.d;
        if (r2 == null) goto L61;
        r2.setPlayBlockClickListener(new AnchorV4VideoView$bindVideoModel$1(this));
    L61:
        if (this.A == true) goto L69;
        int r3 = ECSdk.a;
        IAdapterService r26 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r26 == null) goto L67;
        com.bytedance.android.ec.adapter.api.j r27 = r26.getLiveWindowService();
        if (r27 == null) goto L67;
        Object r28 = r27.f(this.y);
    L68:
        this.z = r28;
        this.A = true;
    L67:
        r28 = null;
    L69:
        PlayerBlock r29 = this.d;
        if (r29 == null) goto L72;
        r29.setPlayBlockClickListener(new AnchorV4VideoView$bindVideoView$4(this, r22, r24));
    L72:
        View r30 = this.l;
        if (r30 == null) goto L75;
        r30.setVisibility(0);
    L75:
        ECDraweeView r31 = this.m;
        if (r31 == null) goto L95;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r32 = r22.a;
        if (r32 == null) goto L82;
        Integer r33 = r32.l();
        if (r33 == null) goto L82;
        int r34 = r33.intValue();
    L83:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r35 = r22.a;
        if (r35 == null) goto L88;
        Integer r36 = r35.c();
        if (r36 == null) goto L88;
        int r37 = r36.intValue();
    L89:
        r31.setVisibility(0);
        if (r34 <= r37) goto L94;
        ViewGroup.LayoutParams r38 = r31.getLayoutParams();
        r38.width = -1;
        r38.height = -2;
        Unit r39 = Unit.INSTANCE;
        r31.setLayoutParams(r38);
        ECDraweeView r40 = this.m;
        if (r40 == null) goto L94;
        r40.setAdjustMode(2);
    L94:
        y.a(r31, r22.c);
    L88:
        r37 = 1;
    L82:
        r34 = 1;
    L95:
        String r41 = r22.f;
        PlayerBlock r42 = this.d;
        if (r42 == null) goto L98;
        r42.setIndicatorInfo(r41);
    L98:
        PlayerBlock r43 = this.d;
        if (r43 == null) goto L101;
        r43.setContentDescription(r22.g);
    L101:
        this.g = r22.b;
        PlayerBlock r44 = this.d;
        if (r44 == null) goto L104;
        r44.h(new q(this));
    L104:
        Integer r45 = r73.b.b;
        if (r45 == null) goto L107;
        int r46 = r45.intValue();
    L108:
        if (r46 <= 0) goto L110;
        boolean r47 = true;
    L111:
        if (r47 == false) goto L120;
        View r48 = this.b;
        if (r48 == null) goto L120;
        ViewGroup.LayoutParams r49 = r48.getLayoutParams();
        if ((r49 instanceof ViewGroup.MarginLayoutParams) == true) goto L117;
        r49 = null;
    L117:
        ViewGroup.MarginLayoutParams r50 = (ViewGroup.MarginLayoutParams) r49;
        if (r50 == null) goto L120;
        r50.bottomMargin = com.bytedance.android.shopping.extensions.b.b(4);
        r48.setLayoutParams(r50);
    L120:
        h83.a r51 = r22.j;
        if (r51 == null) goto L142;
        AnchorV4CommentVideoEntryLayout r52 = this.u;
        if (r52 == null) goto L137;
        TextWithOneIconElementView r53 = r52.a;
        CommentVideoInfo r112 = r51.a;
        if (r112 == null) goto L127;
        TextWithOneIconElement r113 = r112.getAuthorHead();
    L128:
        TextWithOneIconElementView.b(r53, r113, null, false, null, 14);
        TextWithOneIconElementView r114 = r52.b;
        CommentVideoInfo r54 = r51.a;
        if (r54 == null) goto L131;
        TextWithOneIconElement r115 = r54.getAuthorName();
    L132:
        TextWithOneIconElementView.b(r114, r115, null, false, null, 14);
        TextWithOneIconElementView r55 = r52.c;
        CommentVideoInfo r56 = r51.a;
        if (r56 == null) goto L135;
        TextWithOneIconElement r116 = r56.getMoreText();
    L136:
        TextWithOneIconElementView.b(r55, r116, null, false, null, 14);
        r52.setOnClickListener(new com.bytedance.android.shopping.anchorv4.voavhs.head.view.a(r24));
        goto L137
    L135:
        r116 = null;
        goto L136
    L131:
        r115 = null;
        goto L132
    L127:
        r113 = null;
    L137:
        AnchorV4CommentVideoEntryLayout r57 = this.u;
        if (r57 == null) goto L140;
        r57.setVisibility(0);
        Unit r58 = Unit.INSTANCE;
    L141:
        if (r58 == null) goto L142;
    L145:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r59 = r22.a;
        if (r59 != null) goto L148;
    L177:
        PlayerBlock r1 = this.d;
        if (r1 == null) goto L180;
        r1.g(new AnchorV4VideoView$bindVideoView$10(this));
    L180:
        VideoCoverLayout r60 = this.C;
        if (r60 == null) goto L187;
        PlayerBlock r61 = this.d;
        if (r61 == null) goto L185;
        r4 = (int) r61.s();
    L185:
        r60.setTotalDuration(r4);
        return;
    L187:
        return;
    L148:
        if (r59.m() != true) goto L177;
        PlayerBlock r62 = this.d;
        if (r62 == null) goto L160;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r63 = r22.a;
        r63.p();
        fj.d r64 = r63.b;
        if (r64 == null) goto L154;
        long r117 = r64.o;
    L156:
        if (r117 > 0) goto L159;
        r5 = false;
    L159:
        PlayerBlock.l(r62, Boolean.valueOf(r5), 2);
        goto L160
    L154:
        r117 = 0;
    L160:
        c63.d r65 = this.j;
        if (r65 == null) goto L177;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r66 = this.e;
        if (r66 == null) goto L165;
        String r118 = r66.k(null);
    L166:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r67 = this.e;
        if (r67 == null) goto L169;
        Integer r119 = r67.h();
    L170:
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r68 = this.e;
        if (r68 == null) goto L173;
        String r120 = r68.a;
    L174:
        if (r68 == null) goto L176;
        r7 = r68.j();
    L176:
        r65.x("main_picture", "dynamic_auto_slient_play", r118, r119, r120, r7);
        goto L177
    L173:
        r120 = null;
        goto L174
    L169:
        r119 = null;
        goto L170
    L165:
        r118 = null;
        goto L166
    L140:
        r58 = null;
    L142:
        AnchorV4CommentVideoEntryLayout r69 = this.u;
        if (r69 == null) goto L145;
        r69.setVisibility(8);
        Unit r70 = Unit.INSTANCE;
        goto L145
    L110:
        r47 = false;
        goto L111
    L107:
        r46 = r73.b.a;
        goto L108
    L53:
        r111 = false;
        goto L54
    L17:
        r8 = null;
        goto L18
    L11:
        if (r23.i() != true) goto L13;
        r6 = true;
        goto L14
    }
}
