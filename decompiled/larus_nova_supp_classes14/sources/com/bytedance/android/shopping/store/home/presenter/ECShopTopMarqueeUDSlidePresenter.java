package com.bytedance.android.shopping.store.home.presenter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.drawable.GradientDrawable;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.marquee.ECStoreTopMultiMarqueeItemVO;
import com.bytedance.android.shopping.store.repository.vo.TabEnum;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentServiceId;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\bJ\b\u0010\u0005\u001a\u00020\u0004H\u0007J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\b\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopTopMarqueeUDSlidePresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroid/view/View$OnClickListener;", "Landroidx/lifecycle/LifecycleObserver;", "", "onPause", "onResume", "onDestroy", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopTopMarqueeUDSlidePresenter extends ECShopBasePresenter implements View.OnClickListener, LifecycleObserver {
    public static final /* synthetic */ int I = 0;
    public ij3.b A;
    public ECStoreTopMultiMarqueeItemVO B;
    public Disposable C;
    public Disposable D;
    public int E;
    public boolean F;
    public final m G;
    public final g H;
    public View u;
    public View v;
    public final List<SimpleDraweeView> w;
    public TextView x;
    public TextView y;
    public ImageView z;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public b(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void accept(Object r9) {
            nm.a r10 = (nm.a) CollectionsKt.getOrNull((List) r9, 0);
            boolean r1 = true;
            if (r10 == null) goto L9;
            Integer r11 = r10.e;
            if (r11 == null) goto L9;
            if (r11.intValue() < 2) goto L9;
            r1 = false;
        L9:
            if (r1 == false) goto L23;
            final ECShopTopMarqueeUDSlidePresenter r12 = this.a;
            View r2 = r12.u;
            if (r2 == null) goto L13;
            ExtensionsKt.visible(r2);
        L13:
            r12.r0();
            View r3 = r12.u;
            if (r3 == null) goto L16;
            wg.a.f(r3, 0, 0, 0, 0);
        L16:
            Disposable r0 = r12.D;
            if (r0 == null) goto L19;
            r0.dispose();
        L19:
            long r5 = 5000;
            r12.D = r12.t0(r5, r5, new ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(r12));
            Disposable r4 = r12.C;
            if (r4 == null) goto L22;
            r4.dispose();
        L22:
            long r6 = 6600;
            r12.C = r12.t0(r6, r6, new ECShopTopMarqueeUDSlidePresenter$setTotalDisposable$1(r12));
            return;
        L23:
            ECShopTopMarqueeUDSlidePresenter r13 = this.a;
            int r7 = ECShopTopMarqueeUDSlidePresenter.I;
            r13.v0();
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r1) {
            ECExceptionMonitor.e((Throwable) r1);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ Function0 a;

        public d(Function0 r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            Function0 r3 = this.a;
            if (r3 == null) goto L6;
            Unit r4 = (Unit) r3.invoke();
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class f implements Action {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final void run() {
        }
    }

    public static final class g implements Animator.AnimatorListener {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public g(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            ECShopTopMarqueeUDSlidePresenter r3 = this.a;
            int r0 = ECShopTopMarqueeUDSlidePresenter.I;
            r3.r0();
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public h(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            com.bytedance.android.shopping.store.home.entity.l r6 = (com.bytedance.android.shopping.store.home.entity.l) r5;
            ij3.b r0 = r6.d;
            boolean r1 = true;
            if (r0 == null) goto L14;
            List<ij3.b.C0136b> r2 = r0.a;
            if (r2 != null) goto L7;
        L10:
            boolean r3 = true;
        L11:
            if (r3 == true) goto L14;
            boolean r4 = false;
        L15:
            ECStoreTopMultiMarqueeItemVO r7 = r6.e;
            if (r7 == null) goto L27;
            List<ECStoreTopMultiMarqueeItemVO.b> r8 = r7.a;
            if (r8 != null) goto L20;
        L23:
            boolean r9 = true;
        L24:
            if (r9 == true) goto L27;
            r1 = false;
            goto L27
        L20:
            if (r8.isEmpty() == true) goto L23;
            r9 = false;
        L27:
            if (r4 == false) goto L30;
            if (r1 == false) goto L30;
            return;
        L30:
            ECShopTopMarqueeUDSlidePresenter r10 = this.a;
            if (r10.A != null) goto L35;
            if (r4 == true) goto L35;
            r10.A = r6.d;
        L35:
            if (r10.B != null) goto L39;
            if (r1 == true) goto L40;
            r10.B = r6.e;
            return;
        L40:
            return;
        L39:
            return;
        L7:
            if (r2.isEmpty() == true) goto L10;
            r3 = false;
        L14:
            r4 = true;
            goto L15
        }
    }

    public static final class i<T> implements Observer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public i(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Float r4 = (Float) r3;
            ECShopTopMarqueeUDSlidePresenter r0 = this.a;
            if (r0.A != null) goto L7;
            if (r0.B != null) goto L7;
            return;
        L7:
            if (r4.floatValue() < 0) goto L12;
            this.a.s0();
            return;
        }
    }

    public static final class j<T> implements Observer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public j(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Float r4 = (Float) r3;
            ECShopTopMarqueeUDSlidePresenter r0 = this.a;
            if (r0.A != null) goto L7;
            if (r0.B != null) goto L7;
            return;
        L7:
            if (r4.floatValue() < 0) goto L12;
            this.a.s0();
            return;
        }
    }

    public static final class k<T> implements Observer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public k(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            ECShopTopMarqueeUDSlidePresenter r4 = this.a;
            if (r4.A == null) goto L5;
        L7:
            r4.s0();
            return;
        L5:
            if (r4.B != null) goto L7;
        }
    }

    public static final class l<T> implements Observer {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        public l(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Pair r3 = (Pair) r2;
            ECShopTopMarqueeUDSlidePresenter r4 = this.a;
            if (r4.A == null) goto L5;
        L7:
            r4.s0();
            return;
        L5:
            if (r4.B != null) goto L7;
        }
    }

    public static final class m implements Animator.AnimatorListener {
        public final /* synthetic */ ECShopTopMarqueeUDSlidePresenter a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public m(ECShopTopMarqueeUDSlidePresenter r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r8) {
            Intrinsics.checkNotNullParameter(r8, "animation");
            ECShopTopMarqueeUDSlidePresenter r9 = this.a;
            int r0 = ECShopTopMarqueeUDSlidePresenter.I;
            Disposable r1 = r9.D;
            if (r1 == null) goto L5;
            r1.dispose();
        L5:
            long r4 = 5000;
            r9.D = r9.t0(r4, r4, new ECShopTopMarqueeUDSlidePresenter$setShowDurationDisposable$1(r9));
        }
    }

    static {
    }

    public ECShopTopMarqueeUDSlidePresenter() {
        this(null);
    }

    public final void r0() {
        ij3.b r1 = this.A;
        if (r1 == null) goto L14;
        List<ij3.b.C0136b> r2 = r1.a;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        boolean r4 = false;
    L15:
        ECStoreTopMultiMarqueeItemVO r5 = this.B;
        if (r5 == null) goto L27;
        List<ECStoreTopMultiMarqueeItemVO.b> r6 = r5.a;
        if (r6 != null) goto L20;
    L23:
        boolean r7 = true;
    L24:
        if (r7 == true) goto L27;
        boolean r8 = false;
    L28:
        if (r4 == false) goto L31;
        if (r8 == false) goto L31;
        return;
    L31:
        Iterator r9 = ((ArrayList) this.w).iterator();
    L33:
        if (r9.hasNext() == false) goto L35;
        ExtensionsKt.gone((SimpleDraweeView) r9.next());
        goto L33
    L35:
        String r10 = "";
        String r11 = null;
        if (r8 == false) goto L76;
        ij3.b r12 = this.A;
        if (r12 == null) goto L42;
        List<ij3.b.C0136b> r13 = r12.a;
        if (r13 == null) goto L42;
        int r14 = r13.size();
    L43:
        ij3.b r15 = this.A;
        if (r15 == null) goto L48;
        List<ij3.b.C0136b> r16 = r15.a;
        if (r16 == null) goto L48;
        ij3.b.C0136b r17 = (ij3.b.C0136b) ListProtector.get(r16, this.E % r14);
    L49:
        SimpleDraweeView r18 = (SimpleDraweeView) CollectionsKt.firstOrNull(this.w);
        if (r18 == null) goto L52;
        ExtensionsKt.visible(r18);
    L52:
        if (r18 == null) goto L57;
        if (r17 == null) goto L55;
        ECUrlModel r19 = r17.b;
    L56:
        com.bytedance.android.ec.core.imagex.h0.d(r18, r19, T().getImageCallerContext(), null, null, null, null, 120);
        goto L57
    L55:
        r19 = null;
    L57:
        TextView r20 = this.x;
        if (r20 == null) goto L63;
        if (r17 == null) goto L61;
        String r21 = r17.a;
    L62:
        r20.setText(r21);
        goto L63
    L61:
        r21 = null;
    L63:
        TextView r22 = this.y;
        if (r22 == null) goto L69;
        if (r17 == null) goto L67;
        String r23 = r17.c;
    L68:
        r22.setText(r23);
        goto L69
    L67:
        r23 = null;
    L69:
        if (r17 == null) goto L71;
        r11 = r17.c;
    L71:
        ECStoreViewModel r24 = T();
        Pair<String, String>[] r25 = new Pair[1];
        if (r11 == null) goto L75;
        r10 = r11;
    L75:
        r25[0] = TuplesKt.to("bubble_type", r10);
        r24.doEventAction("buy_info_bubble_show", r25);
        return;
    L48:
        r17 = null;
    L42:
        r14 = 1;
        goto L43
    L76:
        ECStoreTopMultiMarqueeItemVO r26 = this.B;
        if (r26 == null) goto L81;
        List<ECStoreTopMultiMarqueeItemVO.b> r27 = r26.a;
        if (r27 == null) goto L81;
        int r28 = r27.size();
    L82:
        ECStoreTopMultiMarqueeItemVO r29 = this.B;
        if (r29 == null) goto L87;
        List<ECStoreTopMultiMarqueeItemVO.b> r30 = r29.a;
        if (r30 == null) goto L87;
        ECStoreTopMultiMarqueeItemVO.b r31 = (ECStoreTopMultiMarqueeItemVO.b) ListProtector.get(r30, this.E % r28);
    L88:
        if (r31 == null) goto L99;
        List<ECUrlModel> r32 = r31.b;
        if (r32 == null) goto L99;
        int r33 = r32.size();
        int r110 = 0;
    L92:
        if (r110 >= r33) goto L99;
        SimpleDraweeView r111 = (SimpleDraweeView) CollectionsKt.getOrNull(this.w, r110);
        if (r111 == null) goto L96;
        ExtensionsKt.visible(r111);
    L96:
        if (r111 == null) goto L98;
        com.bytedance.android.ec.core.imagex.h0.d(r111, (ECUrlModel) ListProtector.get(r32, r110), T().getImageCallerContext(), null, null, null, null, 120);
    L98:
        r110 = r110 + 1;
    L99:
        TextView r34 = this.x;
        if (r34 == null) goto L105;
        if (r31 == null) goto L103;
        String r35 = r31.a;
    L104:
        r34.setText(r35);
        goto L105
    L103:
        r35 = null;
    L105:
        TextView r36 = this.y;
        if (r36 == null) goto L111;
        if (r31 == null) goto L109;
        String r37 = r31.c;
    L110:
        r36.setText(r37);
        goto L111
    L109:
        r37 = null;
    L111:
        if (r31 == null) goto L113;
        r11 = r31.c;
    L113:
        ECStoreViewModel r38 = T();
        Pair<String, String>[] r39 = new Pair[1];
        if (r11 == null) goto L117;
        r10 = r11;
    L117:
        r39[0] = TuplesKt.to("bubble_type", r10);
        r38.doEventAction("buy_info_bubble_show", r39);
        return;
    L87:
        r31 = null;
    L81:
        r28 = 1;
        goto L82
    L20:
        if (r6.isEmpty() == true) goto L23;
        r7 = false;
    L27:
        r8 = true;
        goto L28
    L7:
        if (r2.isEmpty() == true) goto L10;
        r3 = false;
    L14:
        r4 = true;
        goto L15
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        W().getLifecycle().removeObserver(this);
    }

    public final void s0() {
        if (T().isKolShop() == true) goto L5;
    L7:
        float r0 = com.bytedance.android.shopping.extensions.k.e((Float) T().getUpglideFactor().getValue(), 0.0f);
    L8:
        uj3.j r1 = T().getCurrentTab();
        if (r1 != null) goto L11;
    L23:
        boolean r2 = false;
    L24:
        if (r2 == false) goto L26;
        ExtensionsKt.visible(y());
        String r3 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        om.a r4 = om.a.a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(om.a.a(com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId(), T().getStoreParam().getSecShopId(), r3)).subscribe(new b(this), c.a), T());
        return;
    L26:
        v0();
        return;
    L11:
        if (r1.d != TabEnum.PRODUCT_TAB.getType()) goto L23;
        if (r0 <= 0.95f) goto L23;
        if (this.F == true) goto L23;
        if (this.A != null) goto L21;
        if (this.B == null) goto L23;
    L21:
        if (Intrinsics.areEqual((Boolean) T().getCouldShowMarquee().getValue(), Boolean.TRUE) == false) goto L23;
        r2 = true;
        goto L24
    L5:
        if (Intrinsics.areEqual(T().getHasGlobalComponent(), Boolean.FALSE) == false) goto L7;
        r0 = com.bytedance.android.shopping.extensions.k.e((Float) T().getCollapseFactor().getValue(), 0.0f);
        goto L8
    }

    public final void v0() {
        ExtensionsKt.visible(y());
        View r0 = this.u;
        if (r0 == null) goto L5;
        ExtensionsKt.gone(r0);
    L5:
        Disposable r1 = this.C;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        Disposable r2 = this.D;
        if (r2 == null) goto L12;
        r2.dispose();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        v0();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        s0();
    }

    public ECShopTopMarqueeUDSlidePresenter(Fragment r1) {
        super(r1);
        this.w = new ArrayList();
        this.G = new m(this);
        this.H = new g(this);
    }

    public final void A(QModel r4) {
        W().getLifecycle().addObserver(this);
        this.v = y().findViewById(2131370976);
        this.u = y().findViewById(2131370977);
        ((ArrayList) this.w).add(y().findViewById(2131379646));
        ((ArrayList) this.w).add(y().findViewById(2131379647));
        ((ArrayList) this.w).add(y().findViewById(2131379648));
        this.x = (TextView) y().findViewById(2131379653);
        this.y = (TextView) y().findViewById(2131379642);
        this.z = (ImageView) y().findViewById(2131379643);
        View r5 = this.v;
        if (r5 == null) goto L5;
        r5.setOnClickListener(this);
    L5:
        ImageView r6 = this.z;
        if (r6 == null) goto L8;
        r6.setOnClickListener(this);
    L8:
        ImageView r7 = this.z;
        if (r7 == null) goto L11;
        ExtensionsKt.visible(r7);
    L11:
        View r8 = this.u;
        ViewGroup.LayoutParams r0 = null;
        if (r8 == null) goto L14;
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
    L16:
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L19;
        r0 = r9;
    L19:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L22;
        r1.height = com.bytedance.android.shopping.extensions.b.b(32);
    L22:
        GradientDrawable r10 = new GradientDrawable();
        r10.setColor(1929379840);
        r10.setCornerRadii(qc3.a.b(68.0f, 68.0f, 68.0f, 68.0f));
        View r2 = this.u;
        if (r2 == null) goto L25;
        Intrinsics.checkNotNullParameter(r2, "$this$setBackgroundCompat");
        r2.setBackground(r10);
    L25:
        T().getFloatArea().a(W(), new h(this), false);
        T().getCollapseFactor().a(W(), new i(this), false);
        T().getUpglideFactor().a(W(), new j(this), false);
        T().getCouldShowMarquee().a(W(), new k(this), false);
        T().getSelectedTabLocation().a(W(), new l(this), false);
        return;
    L14:
        r9 = null;
        goto L16
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        int r4 = r3.getId();
        if (r4 != 2131379643) goto L6;
        v0();
        this.F = true;
        String r5 = DateFormat.format("yyyy-MM-dd", System.currentTimeMillis()).toString();
        om.a r0 = om.a.a;
        com.bytedance.android.ec.core.async.a.a(bg4.b.b(om.a.a(com.bytedance.android.ec.sdk.helper.r.a.getCurrentUserId(), T().getStoreParam().getSecShopId(), r5)).subscribe(new p3(this, r5), q3.a), T());
        u0(CommentServiceId.HOT_SPOT);
        return;
    L6:
        if (r4 != 2131370976) goto L10;
        u0("102");
        return;
    }

    public final void u0(String r6) {
        ij3.b r0 = this.A;
        if (r0 == null) goto L7;
        List<ij3.b.C0136b> r1 = r0.a;
        if (r1 == null) goto L7;
        int r2 = r1.size();
    L8:
        ij3.b r3 = this.A;
        String r4 = null;
        if (r3 == null) goto L13;
        List<ij3.b.C0136b> r5 = r3.a;
        if (r5 == null) goto L13;
        ij3.b.C0136b r7 = (ij3.b.C0136b) ListProtector.get(r5, this.E % r2);
    L14:
        ECStoreViewModel r8 = T();
        Pair<String, String>[] r9 = new Pair[2];
        if (r7 == null) goto L17;
        r4 = r7.c;
    L17:
        if (r4 != null) goto L19;
        r4 = "";
    L19:
        r9[0] = TuplesKt.to("bubble_type", r4);
        r9[1] = TuplesKt.to("click_area", r6);
        r8.doEventAction("buy_info_bubble_click", r9);
        return;
    L13:
        r7 = null;
    L7:
        r2 = 1;
        goto L8
    }

    public final Disposable t0(long r2, long r4, Function0<Unit> r6) {
        return com.bytedance.android.ec.core.rxjava.a.a(r2, r4, TimeUnit.MILLISECONDS).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(r6), e.a, f.a);
    }

    public static final void q0(ECShopTopMarqueeUDSlidePresenter r2, int r3, int r4, Animator.AnimatorListener r5) {
        r2.getClass();
        ValueAnimator r6 = ValueAnimator.ofInt(new int[]{r3, r4});
        r6.setDuration(300);
        r6.setInterpolator(new DecelerateInterpolator());
        r6.addUpdateListener(new r3(r2, r5));
        if (r5 == null) goto L5;
        r6.addListener(r5);
    L5:
        r6.start();
    }
}
