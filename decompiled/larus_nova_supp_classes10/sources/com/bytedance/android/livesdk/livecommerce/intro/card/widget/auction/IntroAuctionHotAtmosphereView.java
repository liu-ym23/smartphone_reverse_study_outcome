package com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.toolbox.text.c;
import com.bytedance.android.ec.core.toolbox.text.d;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.f;
import com.bytedance.android.ec.core.utils.font.ECFontHelper;
import com.bytedance.android.ec.core.utils.y;
import com.bytedance.android.ec.core.widget.ItalicTextView;
import com.bytedance.android.ec.core.widget.h;
import com.bytedance.android.ec.model.response.ECHotAtmosphere;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.MonitorLevel;
import com.bytedance.android.ui.ec.widget.ecdraweeview.ECDraweeView;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.utility.UIUtils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\t\u0018\u00002\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000e\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/auction/IntroAuctionHotAtmosphereView;", "Landroid/widget/LinearLayout;", "", "width", "", "setMaxWidth", "Lcom/bytedance/android/ec/core/widget/h;", "callback", "setCallback", "com/bytedance/android/livesdk/livecommerce/intro/card/widget/auction/IntroAuctionHotAtmosphereView$hideHotAtmosphereAction$2$a", "n", "Lkotlin/Lazy;", "getHideHotAtmosphereAction", "()Lcom/bytedance/android/livesdk/livecommerce/intro/card/widget/auction/IntroAuctionHotAtmosphereView$hideHotAtmosphereAction$2$a;", "hideHotAtmosphereAction", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroAuctionHotAtmosphereView extends LinearLayout {
    public static final /* synthetic */ int s = 0;
    public boolean a;
    public boolean b;
    public ECDraweeView c;
    public b d;
    public ImageView e;
    public ViewGroup f;
    public Animator g;
    public Integer h;
    public boolean i;
    public boolean j;
    public boolean k;
    public final LinkedList<ECHotAtmosphere> l;
    public ECHotAtmosphere m;
    public final Lazy n;
    public h o;
    public boolean p;
    public int q;
    public int r;

    public static final class a {
    }

    public static final class b extends ItalicTextView {
        public final /* synthetic */ FrameLayout a;

        public b(FrameLayout r1, Context r2) {
            this.a = r1;
            super(r2, null);
        }

        public final void onMeasure(int r2, int r3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(r2), 0), r3);
        }
    }

    static {
    }

    private final IntroAuctionHotAtmosphereView$hideHotAtmosphereAction$2.a getHideHotAtmosphereAction() {
        return (IntroAuctionHotAtmosphereView$hideHotAtmosphereAction$2.a) this.n.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasTransientState() {
        return false;
    }

    public final void b() {
        ECHotAtmosphere r0 = this.l.peek();
        ECHotAtmosphere r1 = this.m;
        if (r1 != null) goto L8;
        if (r0 == null) goto L8;
        h r2 = this.o;
        if (r2 == null) goto L36;
        r2.c(r0);
    L36:
        ECHotAtmosphere r3 = this.m;
        ECHotAtmosphere r4 = this.l.peek();
        if (r3 == null) goto L42;
        if (r4 == null) goto L42;
        if (r3.type == r4.type) goto L42;
        boolean r5 = true;
    L43:
        if (r5 == false) goto L55;
        if (this.j == false) goto L47;
        return;
    L47:
        if (this.k == true) goto L70;
        h r6 = this.o;
        if (r6 == null) goto L52;
        r6.a(this.l.peek());
    L52:
        this.j = true;
        ViewPropertyAnimator r7 = animate().alpha(0.0f).setDuration(300);
        f.b(r7, new IntroAuctionHotAtmosphereView$consumeNextItem$1(this));
        r7.start();
        return;
    L70:
        return;
    L55:
        if (this.l.size() <= 0) goto L72;
        ViewGroup r8 = this.f;
        if (r8 == null) goto L67;
        if (r8.getVisibility() != 8) goto L67;
        ViewGroup r9 = this.f;
        if (r9 == null) goto L63;
        r9.setVisibility(4);
    L63:
        ECHotAtmosphere r10 = this.l.peekFirst();
        if (r10 == null) goto L67;
        k(r10);
    L67:
        if (this.i == false) goto L73;
        g(false);
        return;
    L73:
        return;
    L72:
        return;
    L42:
        r5 = false;
    L8:
        if (r0 == null) goto L36;
        if (r1 == null) goto L36;
        if (r0.type == r1.type) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == false) goto L18;
        h r12 = this.o;
        if (r12 == null) goto L36;
        r12.c(r0);
        goto L36
    L18:
        String r13 = r0.num;
        String r14 = r1.num;
        if (r13 == null) goto L36;
        if (r14 == null) goto L36;
        if (r13.length() <= 0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L36;
        if (r14.length() <= 0) goto L29;
        boolean r16 = true;
    L30:
        if (r16 == false) goto L36;
        if ((!Intrinsics.areEqual(r13, r14)) == false) goto L36;
        h r17 = this.o;
        if (r17 == null) goto L36;
        r17.c(r0);
        goto L36
    L29:
        r16 = false;
        goto L30
    L24:
        r15 = false;
        goto L25
    L13:
        r11 = false;
        goto L14
    }

    public final void h() {
        this.l.clear();
        Animator r0 = this.g;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        SystemClock.elapsedRealtime();
        this.i = false;
        ViewGroup r1 = this.f;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        ECDraweeView r2 = this.c;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        this.m = null;
    }

    public final void a() {
        animate().setListener(null).cancel();
        ViewGroup r0 = this.f;
        if (r0 == null) goto L9;
        ViewPropertyAnimator r1 = r0.animate();
        if (r1 == null) goto L9;
        ViewPropertyAnimator r2 = r1.setListener(null);
        if (r2 == null) goto L9;
        r2.cancel();
    L9:
        ECDraweeView r3 = this.c;
        if (r3 == null) goto L17;
        ViewPropertyAnimator r4 = r3.animate();
        if (r4 == null) goto L18;
        ViewPropertyAnimator r5 = r4.setListener(null);
        if (r5 == null) goto L19;
        r5.cancel();
        return;
    L19:
        return;
    L18:
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        h r0 = this.o;
        if (r0 == null) goto L6;
        r0.onAttachedToWindow();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h r0 = this.o;
        if (r0 == null) goto L5;
        r0.onDetachedFromWindow();
    L5:
        this.p = false;
    }

    public final float d(float r2) {
        return UIUtils.dip2Px(getContext(), r2);
    }

    public final void g(boolean r5) {
        Animator r0 = this.g;
        boolean r1 = true;
        if (r0 == null) goto L8;
        if (r0.isRunning() != true) goto L8;
        return;
    L8:
        if (this.j == false) goto L10;
        return;
    L10:
        ECHotAtmosphere r2 = this.m;
        ECHotAtmosphere r3 = this.l.peekFirst();
        if (r2 == null) goto L16;
        if (r3 == null) goto L16;
        if (r2.type == r3.type) goto L16;
    L17:
        if (r1 == false) goto L20;
        if (r5 == true) goto L20;
        return;
    L20:
        ECHotAtmosphere r6 = this.l.poll();
        ViewGroup r4 = this.f;
        if (r6 == null) goto L25;
        if (r4 == null) goto L26;
        ECHotAtmosphere r7 = r6;
        this.m = r7;
        j(false);
        removeCallbacks(getHideHotAtmosphereAction());
        AnimatorSet r8 = f.c(r4, new float[]{1.0f, 1.3f, 1.0f});
        r8.setDuration(250);
        f.a(r8, new IntroAuctionHotAtmosphereView$onTextChange$$inlined$lets2$lambda$1(this));
        r8.start();
        Unit r9 = Unit.INSTANCE;
        this.g = r8;
        k(r7);
        return;
    L26:
        return;
    L25:
        return;
    L16:
        r1 = false;
        goto L17
    }

    public final void j(boolean r2) {
        ViewGroup r0 = this.f;
        if (r0 == null) goto L8;
        if (r2 == false) goto L6;
        r0.setVisibility(8);
        return;
    L6:
        r0.animate().cancel();
        r0.setVisibility(0);
        r0.setAlpha(1.0f);
        r0.setTranslationX(0.0f);
        return;
    }

    public final void k(final ECHotAtmosphere r12) {
        ECDraweeView r0 = this.c;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        ECDraweeView r1 = this.c;
        Integer r3 = null;
        if (r1 == null) goto L17;
        Object r4 = r1.getTag();
        if ((r4 instanceof ECHotAtmosphere) == true) goto L10;
        r4 = null;
    L10:
        ECHotAtmosphere r5 = (ECHotAtmosphere) r4;
        if (r5 != null) goto L13;
    L16:
        r1.setTag(r12);
        r1.setAutoPlayAnimation(true);
        y.d(r1, r12.img);
        goto L17
    L13:
        if (r5.type != r12.type) goto L16;
        if ((!Intrinsics.areEqual(r5.img, r12.img)) == true) goto L16;
    L17:
        String r2 = r12.topImg;
        if (r2 != null) goto L20;
    L25:
        Integer r6 = Integer.valueOf(r12.afterTextIconResId);
        if (r6.intValue() == 0) goto L28;
        boolean r7 = true;
    L29:
        if (r7 == false) goto L31;
        r3 = r6;
    L31:
        if (r3 == null) goto L38;
        int r8 = r3.intValue();
        ImageView r9 = this.e;
        if (r9 == null) goto L35;
        r9.setVisibility(0);
    L35:
        ImageView r10 = this.e;
        if (r10 == null) goto L42;
        r10.setImageResource(r8);
    L42:
        ItalicTextView r11 = this.d;
        if (r11 == null) goto L45;
        r11.setVisibility(0);
    L45:
        ViewGroup r13 = this.f;
        if (r13 == null) goto L48;
        r13.setVisibility(0);
    L48:
        ItalicTextView r14 = this.d;
        if (r14 == null) goto L73;
        final long r15 = r12.getNumLong();
        d r16 = new d(new SpannableStringBuilder());
        int r17 = r12.type;
        if (r17 != 10001) goto L53;
    L62:
        r16.h(10, IntroAuctionHotAtmosphereView$buildAnimTextStr$1$1.INSTANCE);
        c.a.a(r16, (int) d(1.0f));
        r16.h(this.r, new IntroAuctionHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$1(this, r12, r15));
    L64:
        if (r12.type == 2) goto L66;
    L72:
        r14.setText(r16.f());
        goto L73
    L66:
        if (r12.uiType != 2) goto L72;
        if (r12.getNumLong() >= MonitorLevel.FATAL) goto L70;
    L71:
        c.a.a(r16, (int) d(2.5f));
        r16.h(13, new IntroAuctionHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$3(this, r12, r15));
        goto L72
    L70:
        if (r12.getNumLong() < 10000) goto L72;
    L53:
        if (r17 == 10002) goto L62;
        if (r17 == 2) goto L57;
        if (r17 == 1) goto L57;
    L59:
        if (Intrinsics.areEqual(r12.auctionType, "digital") == false) goto L61;
        r16.h(10, IntroAuctionHotAtmosphereView$buildAnimTextStr$1$4.INSTANCE);
        c.a.a(r16, (int) d(1.0f));
    L61:
        r16.h(this.r, new IntroAuctionHotAtmosphereView$buildAnimTextStr$$inlined$buildSpannedString$lambda$2(this, r12, r15));
    L57:
        r16.h(10, IntroAuctionHotAtmosphereView$buildAnimTextStr$1$3.INSTANCE);
        c.a.a(r16, (int) d(1.0f));
    L73:
        int r18 = this.q;
        if (r18 == 2) goto L76;
        if (r18 == 1) goto L76;
        return;
    L76:
        ItalicTextView r19 = this.d;
        if (r19 == null) goto L81;
        r19.setTranslationY(-1.0f);
        return;
    L81:
        return;
    L38:
        ImageView r20 = this.e;
        if (r20 == null) goto L41;
        r20.setVisibility(8);
    L41:
        Unit r21 = Unit.INSTANCE;
        goto L42
    L28:
        r7 = false;
        goto L29
    L20:
        if (r2.length() <= 0) goto L22;
        boolean r22 = true;
    L23:
        if (r22 != true) goto L25;
        y.d(null, r12.topImg);
        goto L25
    L22:
        r22 = false;
        goto L23
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        super.onDraw(r2);
        if (this.m != null) goto L6;
        ECHotAtmosphere r3 = this.l.peek();
        return;
    }

    public final void setCallback(h r1) {
        this.o = r1;
    }

    public final void setMaxWidth(int r1) {
        this.h = Integer.valueOf(r1);
    }

    public IntroAuctionHotAtmosphereView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.l = new LinkedList();
        this.n = LazyKt.lazy(new IntroAuctionHotAtmosphereView$hideHotAtmosphereAction$2(this));
        this.q = 1;
        this.r = 18;
        setWillNotDraw(false);
        setClipToPadding(false);
        setOrientation(1);
    }

    public static String e(long r5, int r7) {
        if (r7 == 2) goto L10;
        if (r5 <= 999) goto L8;
        return "999+";
    L8:
        return String.valueOf(r5);
    L10:
        if (r5 <= 9999) goto L19;
        if (((r5 / ((long) 1000)) % ((long) 10)) == 0) goto L23;
        StringCompanionObject r8 = StringCompanionObject.INSTANCE;     // Catch: Exception -> L16
        return String.format(Locale.US, "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(r5 / 10000.0d)}, 1));
    L16:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return "";
    L23:
        return String.valueOf(r5 / ((long) 10000));
    L19:
        return String.valueOf(r5);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        boolean r1 = true;
        if (this.b == true) goto L5;
    L9:
        Integer r0 = this.h;
        if (r0 != null) goto L13;
        r0 = Integer.valueOf(View.MeasureSpec.getSize(r7));
    L13:
        if (getLayoutParams().width == (-1)) goto L16;
        r7 = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
    L16:
        CharSequence r4 = null;
        if (this.a == true) goto L26;
        ViewGroup.LayoutParams r3 = getLayoutParams();
        if ((r3 instanceof ViewGroup.MarginLayoutParams) == true) goto L21;
        r3 = null;
    L21:
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r3;
        if (r5 == null) goto L26;
        if (r5.topMargin == 0) goto L26;
        r5.topMargin = 0;
        setLayoutParams(r5);
    L26:
        super.onMeasure(r7, r8);
        if (getMeasuredWidth() <= r0.intValue()) goto L30;
        setMeasuredDimension(r0.intValue(), getMeasuredHeight());
    L30:
        if (getMeasuredWidth() <= 0) goto L69;
        ItalicTextView r9 = this.d;
        if (r9 == null) goto L70;
        int r10 = (getMeasuredWidth() - getPaddingRight()) - getPaddingLeft();
        ECDraweeView r2 = this.c;
        if (r2 == null) goto L36;
        int r6 = r2.getMeasuredWidth();
    L37:
        int r11 = r10 - r6;
        CharSequence r12 = r9.getText();
        if (r12 != null) goto L40;
    L47:
        int r13 = 0;
    L48:
        ImageView r14 = this.e;
        if (r14 != null) goto L51;
    L57:
        r9.measure(View.MeasureSpec.makeMeasureSpec((int) d(60.0f), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        if (r13 <= 0) goto L61;
        float r15 = r11;
    L60:
        float r16 = r15 / r13;
    L63:
        if (r16 < 1.0f) goto L65;
    L67:
        r9.setScaleX(1.0f);
        r9.setScaleY(1.0f);
        return;
    L65:
        if (r16 <= 0.0f) goto L67;
        r9.setScaleX(r16);
        r9.setScaleY(r16);
        r9.setPivotX(0.0f);
        r9.setPivotY(r9.getMeasuredHeight() / 2.0f);
        return;
    L61:
        r16 = 1.0f;
        goto L63
    L51:
        if (r14.getVisibility() != 0) goto L57;
        if (r9.getMeasuredWidth() == 0) goto L61;
        r15 = r11;
        r13 = r9.getMeasuredWidth();
        goto L60
    L40:
        if (r12.length() > 0) goto L43;
        r1 = false;
    L43:
        if (r1 == false) goto L45;
        r4 = r12;
    L45:
        if (r4 == null) goto L47;
        r13 = (int) r9.getPaint().measureText(r4, 0, r4.length());
        goto L48
    L36:
        r6 = 0;
        goto L37
    L70:
        return;
    L69:
        return;
    L5:
        if (this.a == true) goto L9;
        if (this.p == true) goto L9;
        this.p = true;
        c(this, false, 0);
        goto L9
    }

    public static void c(View r1, boolean r2, int r3) {
        if (r2 == false) goto L4;
        return;
    L4:
        if (r3 > 4) goto L17;
        if (r1 != null) goto L8;
        return;
    L8:
        if ((r1 instanceof ViewGroup) == false) goto L10;
        ViewGroup r4 = (ViewGroup) r1;
        r4.setClipChildren(false);
        r4.setClipToPadding(false);
    L10:
        Object r5 = r1.getParent();
        if ((r5 instanceof View) == true) goto L13;
        r5 = null;
    L13:
        c((View) r5, r1 instanceof RecyclerView, r3 + 1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.view.View, android.widget.TextView, com.bytedance.android.livesdk.livecommerce.intro.card.widget.auction.IntroAuctionHotAtmosphereView$b] */
    public final void f(int r10, float r11, int r12) {
        this.a = this.a;
        this.q = r10;
        this.r = r12;
        this.b = true;
        if (getChildCount() != 0) goto L7;
        setPadding(0, 0, (int) d(8.0f), 0);
        int r13 = (int) d(r11);
        LinearLayout r14 = new LinearLayout(getContext());
        r14.setOrientation(0);
        r14.setGravity(80);
        r14.setClipChildren(false);
        ECDraweeView r8 = new ECDraweeView(r14.getContext(), null, 0, 6, null);
        this.c = r8;
        r8.setAdjustMode(1);
        r8.setAutoPlayAnimation(true);
        LinearLayout.LayoutParams r2 = new LinearLayout.LayoutParams(-2, r13);
        r2.gravity = 80;
        r2.rightMargin = (int) d(1.0f);
        Unit r4 = Unit.INSTANCE;
        r8.setLayoutParams(r2);
        r14.addView(r8);
        FrameLayout r3 = new FrameLayout(r14.getContext());
        this.f = r3;
        r3.setVisibility(8);
        r3.setLayoutParams(new LinearLayout.LayoutParams(-2, r13));
        r3.setClipChildren(false);
        r3.setClipToPadding(false);
        ?? r15 = new b(r3, r3.getContext());
        this.d = r15;
        r15.setIncludeFontPadding(false);
        r15.setTypeface(ECFontHelper.e.b("DouyinNumberABC", 600, false));
        r15.setTextColor(-1);
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(-2, com.bytedance.android.shopping.extensions.b.b(20));
        r5.gravity = 16;
        r15.setLayoutParams(r5);
        r3.addView(r15);
        r14.addView(r3);
        ImageView r16 = new ImageView(r14.getContext());
        this.e = r16;
        r16.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        r16.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r16.setAdjustViewBounds(true);
        r16.setPadding((int) d(2.0f), 0, 0, 0);
        r14.addView(r16);
        addView(r14);
        ViewGroup r17 = this.f;
        if (r17 == null) goto L18;
        r17.setPadding((int) d(1.0f), 0, 0, 0);
        return;
    L18:
        return;
    L7:
        int r18 = (int) d(r11);
        ECDraweeView r19 = this.c;
        if (r19 == null) goto L12;
        ViewGroup.LayoutParams r110 = r19.getLayoutParams();
        if (r110 == null) goto L12;
        r110.height = r18;
    L12:
        ViewGroup r111 = this.f;
        if (r111 == null) goto L20;
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 == null) goto L21;
        r112.height = r18;
        return;
    L21:
        return;
    }

    public final void i(ECHotAtmosphere r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.INFO);
        ImagePipeline r0 = Fresco.getImagePipeline();
        if (r0 != null) goto L5;
    L10:
        if (r8 == false) goto L43;
        ECHotAtmosphere r10 = r7.copy();
        ECHotAtmosphere r11 = this.l.peek();
        if (r11 != null) goto L14;
    L15:
        this.l.clear();
    L16:
        ECHotAtmosphere r12 = this.l.peekLast();
        if (r12 != null) goto L19;
        r12 = this.m;
    L19:
        int r13 = r10.type;
        boolean r1 = true;
        if (r13 != 2) goto L22;
        if (r12 != null) goto L35;
    L40:
        if (r1 == false) goto L42;
        this.l.offer(r10);
    L42:
        b();
        return;
    L35:
        if (r12.getNumLong() < r10.getNumLong()) goto L37;
    L39:
        r1 = false;
        goto L40
    L37:
        if ((!Intrinsics.areEqual(e(r12.getNumLong(), r12.uiType), e(r10.getNumLong(), r12.uiType))) == false) goto L39;
    L22:
        if (r13 != 4) goto L24;
        if (r12 == null) goto L40;
        if (r12.getNumLong() >= r10.getNumLong()) goto L39;
    L24:
        if (r13 != 10001) goto L26;
    L28:
        r1 = true ^ r10.isEquals(r12);
        goto L40
    L26:
        if (r13 == 10002) goto L28;
    L14:
        if (r11.type == r10.type) goto L16;
    L43:
        this.l.clear();
        a();
        setAlpha(1.0f);
        this.m = r7;
        j(r9);
        k(r7);
        return;
    L5:
        if (a2.b(r7.img) == false) goto L10;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        Result.constructor-impl(r0.prefetchToDiskCache(ImageRequest.fromUri(r7.img), getContext()));     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // android.view.View
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
    }
}
