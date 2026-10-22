package com.bytedance.awemeopen.apps.framework.feed.pinch.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.awemeopen.apps.framework.base.view.seekbar.SupportSeekBarFrameLayout;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.e0;
import com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m;
import com.bytedance.awemeopen.apps.framework.utils.r0;
import com.bytedance.awemeopen.apps.photo.pinch.PinchEnterMethod;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0013B'\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/pinch/ui/VideoPinchView;", "Lcom/bytedance/awemeopen/apps/framework/base/view/seekbar/SupportSeekBarFrameLayout;", "Lcom/bytedance/awemeopen/apps/framework/utils/r0$a;", "", "enterMethod", "", "setEnterMethod", "Landroid/view/View;", "getMOriginView", "()Landroid/view/View;", "mOriginView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class VideoPinchView extends SupportSeekBarFrameLayout implements r0.a {
    public static final /* synthetic */ int s = 0;
    public ViewGroup c;
    public ViewGroup d;
    public FrameLayout e;
    public View f;
    public View g;
    public qz3.b h;
    public qz3.a i;
    public boolean j;
    public final r0 k;
    public boolean l;
    public sz3.c m;
    public m n;
    public final View o;
    public final e0 p;
    public String q;
    public long r;

    public static final class a {
    }

    static {
    }

    public VideoPinchView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public VideoPinchView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final void c() {
        this.j = true;
        qz3.b r1 = this.h;
        if (r1 == null) goto L5;
        r1.o(true);
    L5:
        View r2 = this.f;
        if (r2 == null) goto L8;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(r2, 0);
    L8:
        requestFocus();
        m r3 = this.n;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r3 = null;
    L11:
        r3.l = true;
    }

    private final View getMOriginView() {
        sz3.c r0 = this.m;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r0 = null;
    L5:
        Function0<? extends View> r1 = r0.j;
        if (r1 != null) goto L8;
        return null;
    L8:
        return (View) r1.invoke();
    }

    public final void d() {
        if (this.j == true) goto L5;
        return;
    L5:
        qz3.a r0 = this.i;
        if (r0 == null) goto L8;
        r0.e();
    L8:
        qz3.b r1 = this.h;
        if (r1 == null) goto L15;
        sz3.c r2 = this.m;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r2 = null;
    L13:
        r1.l(r2.f);
        return;
    }

    public final boolean e() {
        if (getParent() != null) goto L5;
    L7:
        return false;
    L5:
        if (getVisibility() != 0) goto L7;
        return true;
    }

    public static void g(VideoPinchView r1) {
        if (r1.e() == false) goto L10;
        h(r1);
        qz3.b r2 = r1.h;
        if (r2 == null) goto L9;
        r2.v(false);
        return;
    L9:
        return;
    }

    public static void h(final VideoPinchView r3) {
        if (r3.e() == false) goto L32;
        ViewParent r0 = r3.getParent();
        sz3.c r2 = null;
        if ((r0 instanceof ViewGroup) == false) goto L8;
        final ViewGroup r1 = (ViewGroup) r0;
    L9:
        if (r1 == null) goto L11;
        r1.post(new d(r1, r3));
    L11:
        r3.p.f();
        ((ImageCanvasView) r3.o.findViewById(2131375091)).setTranslationY(0.0f);
        ViewGroup r4 = r3.c;
        if (r4 == null) goto L14;
        r4.setBackgroundColor(0);
    L14:
        m r5 = r3.n;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r5 = null;
    L17:
        r5.l = false;
        r3.j = false;
        qz3.b r6 = r3.h;
        if (r6 == null) goto L20;
        r6.o(false);
    L20:
        sz3.c r7 = r3.m;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
    L24:
        Function0<Unit> r8 = r2.q;
        if (r8 == null) goto L27;
        r8.invoke();
    L27:
        qz3.b r9 = r3.h;
        if (r9 == null) goto L31;
        r9.f();
        return;
    L31:
        return;
    L23:
        r2 = r7;
        goto L24
    L8:
        r1 = null;
        goto L9
    }

    public final void f(String r9) {
        Intrinsics.checkNotNullParameter(r9, "exitMethod");
        LinkedHashMap r3 = new LinkedHashMap();
        m r0 = this.n;
        m r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r0 = null;
    L5:
        sz3.c r2 = r0.d;
        String r4 = "";
        if (r2 == null) goto L10;
        r14.c r5 = r2.f;
        if (r5 == null) goto L10;
        Object r6 = Integer.valueOf(r5.i());
    L11:
        r3.put("aweme_type", r6);
        m r7 = this.n;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r7 = null;
    L14:
        sz3.c r8 = r7.d;
        if (r8 == null) goto L18;
        String r10 = r8.e;
        if (r10 == null) goto L18;
    L19:
        r3.put("enter_from", r10);
        m r11 = this.n;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r11 = null;
    L22:
        sz3.c r12 = r11.d;
        if (r12 == null) goto L28;
        r14.c r13 = r12.f;
        if (r13 == null) goto L28;
        String r14 = r13.c();
        if (r14 == null) goto L28;
    L29:
        r3.put("group_id", r14);
        m r15 = this.n;
        if (r15 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r15 = null;
    L32:
        sz3.c r16 = r15.d;
        if (r16 == null) goto L42;
        r14.c r17 = r16.f;
        if (r17 == null) goto L42;
        User r18 = r17.f();
        if (r18 == null) goto L42;
        String r19 = r18.u();
        if (r19 == null) goto L42;
        r4 = r19;
    L42:
        r3.put("author_id", r4);
        r3.put("enter_method", this.q);
        r3.put("exit_method", r9);
        m r20 = this.n;
        if (r20 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
    L46:
        sz3.c r21 = r1.d;
        if (r21 == null) goto L51;
        r14.c r22 = r21.f;
        if (r22 == null) goto L51;
        int r23 = r22.q();
    L52:
        r3.put("item_duration", Integer.valueOf(r23));
        r3.put("duration", Long.valueOf(System.currentTimeMillis() - this.r));
        AosEventReporter.s(AosEventReporter.a, "quit_clear_screen_mode", r3, null, null, null, 28);
        return;
    L51:
        r23 = 0;
        goto L52
    L45:
        r1 = r20;
    L28:
        r14 = "";
    L18:
        r10 = "";
    L10:
        r6 = "";
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.utils.r0.a
    public final void handleMsg(Message r3) {
        if (r3 == null) goto L4;
        Integer r4 = Integer.valueOf(r3.what);
    L5:
        if (r4 != null) goto L8;
    L10:
        if (r4 != null) goto L13;
    L15:
        if (r4 != null) goto L18;
        return;
    L18:
        if (r4.intValue() != 3) goto L23;
        e();
        return;
    L23:
        return;
    L13:
        if (r4.intValue() != 1) goto L15;
        d();
        return;
    L8:
        if (r4.intValue() != 0) goto L10;
        d();
        return;
    L4:
        r4 = null;
        goto L5
    }

    public final void setEnterMethod(String r3) {
        Intrinsics.checkNotNullParameter(r3, "enterMethod");
        this.q = r3;
        this.r = System.currentTimeMillis();
    }

    public static void a(VideoPinchView r7, Triple r8) {
        Intrinsics.checkNotNullParameter(r7, "this$0");
        if (r7.isAttachedToWindow() == false) goto L98;
        Object r0 = r8.getFirst();
        View r1 = r7.getMOriginView();
        Integer r2 = null;
        if (r1 == null) goto L7;
        Integer r3 = Integer.valueOf(r1.hashCode());
    L9:
        if (Intrinsics.areEqual(r0, r3) == true) goto L11;
        return;
    L11:
        if (r8.getFirst() == null) goto L13;
    L15:
        boolean r9 = ((Boolean) r8.getSecond()).booleanValue();
        r7.l = r9;
        if (r9 == true) goto L24;
        sz3.c r10 = r7.m;
        if (r10 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r10 = null;
    L21:
        if ((!Intrinsics.areEqual(r10.n, Boolean.FALSE)) == true) goto L24;
        g(r7);
    L56:
        sz3.c r11 = r7.m;
        if (r11 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r11 = null;
    L60:
        if (TextUtils.equals(r11.e, "graphic_detail") == true) goto L62;
        return;
    L62:
        if (r7.l == false) goto L75;
        m r12 = r7.n;
        if (r12 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r12 = null;
    L67:
        if (r12.m == true) goto L75;
        qz3.b r13 = r7.h;
        if (r13 == null) goto L101;
        View r14 = r7.getMOriginView();
        if (r14 == null) goto L73;
        r2 = Integer.valueOf(r14.hashCode());
    L73:
        r13.d(r2, true);
        return;
    L101:
        return;
    L75:
        if (r7.l == true) goto L103;
        m r15 = r7.n;
        if (r15 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r15 = null;
    L80:
        if (r15.j.o >= 1.0f) goto L104;
        m r16 = r7.n;
        if (r16 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r16 = null;
    L85:
        if (r16.m == false) goto L105;
        m r17 = r7.n;
        if (r17 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r17 = null;
    L90:
        if (r17.n == false) goto L106;
        qz3.b r18 = r7.h;
        if (r18 == null) goto L107;
        View r19 = r7.getMOriginView();
        if (r19 == null) goto L96;
        r2 = Integer.valueOf(r19.hashCode());
    L96:
        r18.d(r2, false);
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L104:
        return;
    L103:
        return;
    L24:
        if (r7.l == true) goto L44;
        m r20 = r7.n;
        if (r20 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r20 = null;
    L29:
        if (r20.l == false) goto L44;
        m r21 = r7.n;
        if (r21 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r21 = null;
    L34:
        if (r21.j.q != 1.0f) goto L36;
        boolean r22 = true;
    L37:
        if (r22 == false) goto L44;
        m r23 = r7.n;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r23 = null;
    L42:
        if (r23.j.o >= 1.0f) goto L44;
        r7.f("zoom_in");
        g(r7);
        goto L56
    L36:
        r22 = false;
    L44:
        boolean r24 = r7.l;
        if (r24 == true) goto L47;
        r7.c();
        goto L56
    L47:
        if (r24 == false) goto L56;
        m r25 = r7.n;
        if (r25 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("pinchUtil");
        r25 = null;
    L52:
        if (r25.l == false) goto L56;
        r7.j = false;
        qz3.b r26 = r7.h;
        if (r26 == null) goto L56;
        r26.o(false);
        goto L56
    L13:
        if (r7.getMOriginView() != null) goto L15;
        return;
    L7:
        r3 = null;
        goto L9
    }

    public final void b(sz3.c r2, m r3) {
        Intrinsics.checkNotNullParameter(r2, "videoPinchParams");
        Intrinsics.checkNotNullParameter(r3, "pinchUtil");
        this.m = r2;
        r2.d = this.k;
        this.n = r3;
        this.p.b(r2, r3);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r3, KeyEvent r4) {
        if (r3 != 4) goto L18;
        qz3.b r5 = this.h;
        if (r5 != null) goto L7;
    L9:
        boolean r6 = false;
    L11:
        if (r6 == false) goto L15;
        qz3.b r7 = this.h;
        if (r7 == null) goto L16;
        r7.e(TuplesKt.to(Boolean.FALSE, "back"));
    L16:
        return true;
    L15:
        f("back");
        g(this);
        goto L16
    L7:
        if (r5.A() != true) goto L9;
        r6 = true;
        goto L11
    L18:
        return super.onKeyDown(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.ui.g] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public VideoPinchView(Context r4, sz3.c r5, m r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "videoPinchParams");
        Intrinsics.checkNotNullParameter(r6, "pinchUtil");
        sz3.c r2 = null;
        this(r4, 0 == true ? 1 : 0, 6, 0);
        this.m = r5;
        r5.d = this.k;
        this.n = r6;
        this.c = (ViewGroup) this.o.findViewById(2131367728);
        this.e = (FrameLayout) this.o.findViewById(2131366954);
        this.d = (ViewGroup) this.o.findViewById(2131382321);
        this.f = this.o.findViewById(2131364548);
        this.g = this.o.findViewById(2131364998);
        Resources r7 = Resources.getSystem();
        int r8 = MathKt.roundToInt(TypedValue.applyDimension(1, 56, WindowDisplayMetricsOverride.apply(r7, r7.getDisplayMetrics())));
        FrameLayout r9 = this.e;
        if (r9 == null) goto L5;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
    L7:
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L9;
        ViewGroup.MarginLayoutParams r11 = (ViewGroup.MarginLayoutParams) r10;
    L10:
        if (r11 == null) goto L15;
        r11.bottomMargin = r8;
        FrameLayout r0 = this.e;
        if (r0 == null) goto L15;
        r0.setLayoutParams(r11);
    L15:
        View r12 = this.g;
        if (r12 == null) goto L18;
        com.bytedance.awemeopen.apps.framework.comment.util.c.a(r12, r8);
    L18:
        FrameLayout r13 = this.e;
        if (r13 == null) goto L21;
        r13.setOnTouchListener(new e());
    L21:
        sz3.c r14 = this.m;
        if (r14 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r14 = null;
    L24:
        LifecycleOwner r15 = r14.b;
        sz3.c r1 = this.m;
        if (r1 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
        r1 = null;
    L27:
        this.h = r1.i;
        sz3.c r3 = this.m;
        if (r3 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("mVideoPinchParams");
    L31:
        this.i = r2.h;
        qz3.b r16 = this.h;
        if (r16 == null) goto L34;
        r16.i(r15, new f(this));
    L34:
        qz3.b r17 = this.h;
        if (r17 == null) goto L37;
        r17.n();
    L37:
        qz3.b r18 = this.h;
        if (r18 == 0) goto L40;
        r18.s(r15, new g(this));
    L40:
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        return;
    L30:
        r2 = r3;
        goto L31
    L9:
        r11 = null;
        goto L10
    L5:
        r10 = null;
        goto L7
    }

    public VideoPinchView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2, r3, r4);
        this.k = new r0(this);
        this.l = true;
        View r5 = LayoutInflater.from(r2).inflate(2131561095, this);
        this.o = r5;
        this.p = new e0(r5);
        this.q = PinchEnterMethod.PINCH;
    }

    public /* synthetic */ VideoPinchView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
