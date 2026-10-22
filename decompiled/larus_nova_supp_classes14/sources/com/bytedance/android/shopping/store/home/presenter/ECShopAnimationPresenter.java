package com.bytedance.android.shopping.store.home.presenter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import com.bytedance.android.ec.store.utils.taskmanager.ECTaskManager;
import com.bytedance.android.ec.store.utils.taskmanager.TaskPriority;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/store/home/presenter/ECShopAnimationPresenter;", "Lcom/bytedance/android/shopping/store/home/presenter/ECShopBasePresenter;", "Landroidx/lifecycle/LifecycleObserver;", "a", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopAnimationPresenter extends ECShopBasePresenter implements LifecycleObserver {
    public static final /* synthetic */ int w = 0;
    public final Lazy u;
    public boolean v;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ ECShopAnimationPresenter a;
        public final /* synthetic */ View b;
        public final /* synthetic */ Ref.ObjectRef c;
        public final /* synthetic */ i4 d;
        public final /* synthetic */ View e;

        public b(ECShopAnimationPresenter r1, View r2, Ref.ObjectRef r3, i4 r4, View r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }

        public final void onChanged(Object r9) {
            Float r10 = (Float) r9;
            if (this.a.T().needShopProfilePin2Top() == true) goto L8;
            this.b.setVisibility(0);
            View r11 = (View) this.c.element;
            if (r11 == null) goto L7;
            r11.setVisibility(8);
        L7:
            this.b.setAlpha(1.0f);
            return;
        L8:
            ECShopAnimationPresenter r0 = this.a;
            if (r0.v == true) goto L12;
            this.c.element = r0.r0(this.b);
            return;
        L12:
            if (Intrinsics.areEqual(r10, 0.0f) == false) goto L20;
            this.d.a();
            this.b.setVisibility(0);
            View r12 = (View) this.c.element;
            if (r12 == null) goto L16;
            r12.setVisibility(8);
        L16:
            View r13 = (View) this.c.element;
            if (r13 == null) goto L42;
            wg.a.i(r13, this.d.c);
            wg.a.d(r13, this.d.d);
            r13.setX(this.d.g);
            r13.setY(this.d.h);
            return;
        L42:
            return;
        L20:
            if (Intrinsics.areEqual(r10, 1.0f) == false) goto L33;
            View r14 = (View) this.c.element;
            if (r14 == null) goto L24;
            wg.a.i(r14, this.d.e);
            wg.a.d(r14, this.d.f);
            r14.setX(this.d.i - (r14.getWidth() / 2));
            r14.setY(this.d.j + (r14.getHeight() / 2));
        L24:
            i4 r15 = this.d;
            r15.b = wg.a.c(r15.l);
            r15.e = r15.l.getWidth();
            r15.f = r15.l.getHeight();
            int[] r1 = r15.b;
            if (r1 != null) goto L27;
            Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
        L27:
            r15.i = r1[0] + (r15.e / 2);
            int[] r2 = r15.b;
            if (r2 != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("targetLocationInScreen");
        L30:
            r15.j = r2[1] - (r15.f / 2);
            this.e.setVisibility(0);
            View r16 = (View) this.c.element;
            if (r16 == null) goto L44;
            r16.post(new e(this));
            return;
        L44:
            return;
        L33:
            float r17 = RangesKt.coerceAtMost(RangesKt.coerceAtLeast(r10.floatValue() * 1.5f, 0.0f), 1.0f);
            this.e.setVisibility(4);
            this.b.setVisibility(4);
            View r3 = (View) this.c.element;
            if (r3 == null) goto L36;
            r3.setVisibility(0);
        L36:
            View r4 = (View) this.c.element;
            if (r4 == null) goto L46;
            i4 r5 = this.d;
            int r6 = r5.e;
            int r7 = r5.c;
            int r8 = r5.f;
            int r18 = r5.d;
            int r19 = r5.i - r5.g;
            int r20 = r5.j - r5.h;
            int r21 = r7 + ((int) ((r6 - r7) * r17));
            int r22 = r18 + ((int) ((r8 - r18) * r17));
            wg.a.i(r4, r21);
            wg.a.d(r4, r22);
            i4 r23 = this.d;
            float r24 = (r23.g + (r19 * r17)) - (r21 / 2);
            float r25 = (r23.h + (r20 * r17)) + (r22 / 2);
            r4.setX(r24);
            r4.setY(r25);
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ i4 a;

        public c(i4 r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Float r5 = (Float) r4;
            if (Intrinsics.areEqual(r5, 1.0f) == false) goto L6;
            this.a.a();
            dm.a.a("ECShopAnimationPresenter").a("collapseFactor: " + r5 + ',' + this.a.h);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ ECShopAnimationPresenter a;

        public d(ECShopAnimationPresenter r1) {
            this.a = r1;
        }

        public final void onChanged(Object r5) {
            if (((com.bytedance.android.shopping.store.home.entity.n) r5) == null) goto L7;
            Lazy r6 = ECTaskManager.b;
            ECTaskManager.a.a().a(this.a.T().getStoreParam().getLifecycleMonitorId(), TaskPriority.AFTER_FIRST_SCREEN, new ECShopAnimationPresenter$onBind$1$1(this));
            return;
        }
    }

    static {
    }

    public ECShopAnimationPresenter(Fragment r2) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        super(r2);
        this.u = LazyKt.lazy(new ECShopAnimationPresenter$animationLayout$2(this));
    }

    public final void A(QModel r4) {
        T().getHeaderArea().a(W(), new d(this), false);
    }

    public final ImageView r0(View r5) {
        r5.setAlpha(1.0f);
        Intrinsics.checkNotNullParameter(r5, "$this$clone2Bitmap");
        if (r5.getWidth() > 0) goto L5;
    L8:
        Bitmap r0 = null;
    L9:
        if (r0 != null) goto L11;
        return null;
    L11:
        ImageView r1 = new ImageView(r5.getContext());
        r1.setImageBitmap(r0);
        r1.setLayoutParams(r5.getLayoutParams());
        r1.setClickable(false);
        ((ViewGroup) this.u.getValue()).addView(r1);
        r1.setX(wg.a.c(r5)[0]);
        r1.setY(wg.a.c(r5)[1]);
        r1.setVisibility(8);
        this.v = true;
        return r1;
    L5:
        if (r5.getHeight() <= 0) goto L8;
        r0 = Bitmap.createBitmap(r5.getWidth(), r5.getHeight(), Bitmap.Config.ARGB_8888);
        r5.draw(new Canvas(r0));
        goto L9
    }

    public final void q0(View r11, View r12) {
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = null;
        i4 r6 = new i4(r11, r12);
        r3.element = r0(r11);
        T().getUpglideFactor().a(W(), new b(this, r11, r3, r6, r12), false);
        T().getCollapseFactor().a(W(), new c(r6), false);
    }
}
