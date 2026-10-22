package com.bytedance.awemeopen.apps.framework.feed.pinch.presenter;

import android.app.Activity;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.bytedance.awemeopen.apps.framework.feed.AosEventReporter;
import com.bytedance.awemeopen.apps.framework.feed.pinch.vm.FeedSpeedControlViewModel;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.FeedSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper;
import com.bytedance.awemeopen.apps.framework.player.FeedPlayerHelper;
import com.bytedance.awemeopen.bizmodels.profile.User;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class PinchButtonBarGroupPresenter extends com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.a {
    public final View i;
    public b j;
    public final Lazy k;
    public final Lazy l;
    public SingleVideoSeekBarHelper m;

    public static final class a implements SingleVideoSeekBarHelper.b {
        public float a;
        public final /* synthetic */ SingleVideoSeekBarHelper b;
        public final /* synthetic */ PinchButtonBarGroupPresenter c;

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper.b
        public final void a() {
            this.a = this.b.f();
        }

        @Override // com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.SingleVideoSeekBarHelper.b
        public final void b() {
            float r0 = this.b.f();
            PinchButtonBarGroupPresenter r1 = this.c;
            if (r0 <= this.a) goto L5;
            String r2 = "front";
        L6:
            r1.getClass();
            LinkedHashMap r4 = new LinkedHashMap();
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r3 = r1.c;
            String r5 = "";
            if (r3 == null) goto L12;
            sz3.c r6 = r3.d;
            if (r6 == null) goto L12;
            String r7 = r6.e;
            if (r7 == null) goto L12;
        L13:
            r4.put("enter_from", r7);
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r8 = r1.c;
            if (r8 == null) goto L21;
            sz3.c r9 = r8.d;
            if (r9 == null) goto L21;
            r14.c r10 = r9.f;
            if (r10 == null) goto L21;
            String r11 = r10.c();
            if (r11 == null) goto L21;
        L22:
            r4.put("group_id", r11);
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r12 = r1.c;
            if (r12 == null) goto L34;
            sz3.c r13 = r12.d;
            if (r13 == null) goto L34;
            r14.c r14 = r13.f;
            if (r14 == null) goto L34;
            User r15 = r14.f();
            if (r15 == null) goto L34;
            String r16 = r15.u();
            if (r16 == null) goto L34;
            r5 = r16;
        L34:
            r4.put("author_id", r5);
            r4.put("pinch_zoom", CommentScene.COMMENTSCENE_NO_AWEME);
            com.bytedance.awemeopen.apps.framework.feed.pinch.utils.m r17 = r1.c;
            if (r17 == null) goto L41;
            sz3.c r18 = r17.d;
            if (r18 == null) goto L41;
            r14.c r19 = r18.f;
            if (r19 == null) goto L41;
            int r20 = r19.i();
        L42:
            r4.put("aweme_type", Integer.valueOf(r20));
            r4.put("action_type", r2);
            AosEventReporter.s(AosEventReporter.a, "click_progress_bar", r4, null, null, null, 28);
            return;
        L41:
            r20 = 0;
        L21:
            r11 = "";
        L12:
            r7 = "";
            goto L13
        L5:
            r2 = "back";
            goto L6
        }

        public a(SingleVideoSeekBarHelper r1, PinchButtonBarGroupPresenter r2) {
            this.b = r1;
            this.c = r2;
        }
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void c() {
    }

    public final void a() {
        ViewGroup.LayoutParams r0 = this.i.getLayoutParams();
        rz3.a r2 = null;
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L5;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
    L6:
        if (r1 == null) goto L9;
        r1.bottomMargin = 0;
    L9:
        this.i.requestLayout();
        this.i.setBackgroundColor(-16777216);
        Object r3 = this.j;
        if ((r3 instanceof rz3.a) == false) goto L12;
        r2 = (rz3.a) r3;
    L12:
        if (r2 == null) goto L15;
        r2.a();
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.l] */
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
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void d() {
        sz3.c r0 = this.b;
        if (r0 == null) goto L7;
        qz3.b r1 = r0.i;
        if (r1 == null) goto L7;
        r1.C(r0.b, new k(this));
    L7:
        sz3.c r2 = this.b;
        if (r2 == null) goto L12;
        qz3.b r3 = r2.i;
        if (r3 == 0) goto L12;
        r3.g(r2.b, new l(this));
    L12:
        sz3.c r4 = this.b;
        if (r4 == null) goto L28;
        LifecycleOwner r5 = r4.b;
        if (r5 == null) goto L29;
        FeedSpeedControlViewModel.a r6 = FeedSpeedControlViewModel.Companion;
        Activity r7 = r4.getActivity();
        if ((r7 instanceof LifecycleOwner) == false) goto L19;
        LifecycleOwner r8 = (LifecycleOwner) r7;
    L20:
        if (r8 != null) goto L22;
        r8 = r5;
    L22:
        r6.getClass();
        FeedSpeedControlViewModel r9 = FeedSpeedControlViewModel.a.a(r8, "");
        if (r9 == null) goto L30;
        MutableLiveData<Pair<String, Boolean>> r10 = r9.getFastSpeedModeEvent();
        if (r10 == null) goto L31;
        final Function1<Pair<? extends String, ? extends Boolean>, Unit> r11 = new PinchButtonBarGroupPresenter$initObserverOnce$3$1(this);
        r10.observe(r5, new m(r11));
        return;
    L31:
        return;
    L30:
        return;
    L19:
        r8 = null;
        goto L20
    L29:
        return;
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
    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void e() {
        this.i.setOnTouchListener(new n());
        sz3.c r0 = this.b;
        if (r0 == null) goto L9;
        qz3.b r1 = r0.i;
        if (r1 == null) goto L9;
        if (r1.B() == true) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
        g(8);
    L13:
        this.i.findViewById(2131386894).setVisibility(8);
        this.i.findViewById(2131392260).setVisibility(8);
        this.i.findViewById(2131392261).setVisibility(8);
        Iterator<b> r3 = this.h.iterator();
    L15:
        if (r3.hasNext() == false) goto L17;
        r3.next().f();
        goto L15
    L17:
        this.h.clear();
        int r4 = com.bytedance.awemeopen.bizmodels.user.d.a;
        if (com.bytedance.awemeopen.bizmodels.user.d.b(this.f) == false) goto L20;
        b r5 = (w) this.k.getValue();
    L21:
        this.j = r5;
        if (r5 == null) goto L24;
        this.h.add(r5);
    L24:
        a();
        if (this.m != null) goto L85;
        sz3.c r6 = this.b;
        if (r6 == null) goto L33;
        r14.c r7 = r6.f;
        if (r7 == null) goto L33;
        if (com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.c.a(r7) != 1) goto L33;
        boolean r8 = true;
    L34:
        if (r8 == false) goto L86;
        sz3.c r9 = this.b;
        ViewGroup r10 = null;
        if (r9 == null) goto L40;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r11 = r9.c;
        if (r11 == null) goto L40;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r12 = r11.getISeekBar();
    L42:
        if ((r12 instanceof FeedSeekBarHelper) == false) goto L44;
        FeedSeekBarHelper r13 = (FeedSeekBarHelper) r12;
    L45:
        if (r13 == null) goto L48;
        FeedPlayerHelper r14 = r13.b;
        if (r14 == null) goto L48;
    L61:
        if (r14 == null) goto L63;
        SingleVideoSeekBarHelper r15 = new SingleVideoSeekBarHelper(new WeakReference(this.i.getContext()), r14, false, 12);
        a r16 = new a(r15, this);
        Intrinsics.checkNotNull(r16);
        Intrinsics.checkNotNullParameter(r16, "callback");
        r15.F = r16;
        this.m = r15;
    L63:
        SingleVideoSeekBarHelper r17 = this.m;
        if (r17 == null) goto L70;
        sz3.c r18 = this.b;
        if (r18 == null) goto L68;
        r14.c r19 = r18.f;
    L69:
        r17.i(r19);
        goto L70
    L68:
        r19 = null;
    L70:
        SingleVideoSeekBarHelper r20 = this.m;
        if (r20 == null) goto L73;
        r20.e();
    L73:
        View r21 = this.a;
        if ((r21 instanceof ViewGroup) == false) goto L76;
        r10 = (ViewGroup) r21;
    L76:
        if (r10 == null) goto L87;
        SingleVideoSeekBarHelper r22 = this.m;
        if (r22 == null) goto L80;
        Resources r23 = Resources.getSystem();
        r22.h(r10, MathKt.roundToInt(TypedValue.applyDimension(1, 62, WindowDisplayMetricsOverride.apply(r23, r23.getDisplayMetrics()))));
    L80:
        SingleVideoSeekBarHelper r24 = this.m;
        if (r24 == null) goto L88;
        float r25 = 4;
        r24.h.setPadding(MathKt.roundToInt(TypedValue.applyDimension(1, r25, SingleVideoSeekBarHelper.d(Resources.getSystem()))), r24.h.getPaddingTop(), MathKt.roundToInt(TypedValue.applyDimension(1, r25, SingleVideoSeekBarHelper.d(Resources.getSystem()))), r24.h.getPaddingBottom());
        return;
    L88:
        return;
    L87:
        return;
    L48:
        sz3.c r26 = this.b;
        if (r26 == null) goto L53;
        com.bytedance.awemeopen.apps.framework.framework.viewpager.o r27 = r26.c;
        if (r27 == null) goto L53;
        com.bytedance.awemeopen.apps.framework.feed.ui.seekbar.d r28 = r27.getISeekBar();
    L55:
        if ((r28 instanceof SingleVideoSeekBarHelper) == false) goto L57;
        SingleVideoSeekBarHelper r29 = (SingleVideoSeekBarHelper) r28;
    L58:
        if (r29 == null) goto L60;
        r14 = r29.b;
        goto L61
    L60:
        r14 = null;
        goto L61
    L57:
        r29 = null;
    L53:
        r28 = null;
        goto L55
    L44:
        r13 = null;
    L40:
        r12 = null;
        goto L42
    L86:
        return;
    L33:
        r8 = false;
        goto L34
    L85:
        return;
    L20:
        r5 = (b) this.l.getValue();
    L9:
        r2 = false;
        goto L11
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.a, com.bytedance.awemeopen.apps.framework.feed.pinch.presenter.b
    public final void f() {
        super.f();
        g(8);
        this.h.clear();
        SingleVideoSeekBarHelper r0 = this.m;
        if (r0 == null) goto L7;
        r0.A = false;
        r0.removeSeekBarChangeListener(r0.G);
        r0.I.clear();
        r0.q.removeCallbacksAndMessages(null);
        r0.m("destroy");
        r0.b.g(r0.H);
        ViewGroup r2 = (ViewGroup) r0.e.getParent();
        if (r2 == null) goto L7;
        r2.removeView(r0.e);
    L7:
        this.m = null;
    }

    public final void g(int r2) {
        this.i.setVisibility(r2);
        if (r2 != 0) goto L7;
        SingleVideoSeekBarHelper r3 = this.m;
        if (r3 == null) goto L11;
        r3.a();
        return;
    L11:
        return;
    L7:
        SingleVideoSeekBarHelper r4 = this.m;
        if (r4 == null) goto L13;
        r4.b();
        return;
    }

    public PinchButtonBarGroupPresenter(final View r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Intrinsics.checkNotNullParameter(r3, "view");
        super(r2);
        this.i = r3;
        this.k = LazyKt.lazy(new PinchButtonBarGroupPresenter$slidesBarPresenter$2(r2, this));
        this.l = LazyKt.lazy(new PinchButtonBarGroupPresenter$videoBarPresenterV2$2(r2, this));
    }
}
