package com.bytedance.android.livesdk.livecommerce.room.widgets.start_live;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.ec.adapter.api.handler.viewinterface.ECExternalViewGroupAction;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContextContainer;
import com.bytedance.android.livesdk.livecommerce.utils.x0;
import com.bytedance.android.livesdkapi.room.handler.viewinterface.Rect;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import sg2.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class StartLivePromotionButton extends ak2.b {
    public static final /* synthetic */ KProperty[] j = null;
    public final Lazy a;
    public com.bytedance.android.livesdk.livecommerce.room.api.a b;
    public final Lazy c;
    public final a d;
    public final b e;
    public final Function3<wd.f, wd.e, ECExternalViewGroupAction, Unit> f;
    public final Context g;
    public final com.bytedance.android.livesdk.livecommerce.room.api.e h;
    public final Function0<com.bytedance.android.ec.adapter.api.state.c> i;

    public static final class a extends ObservableProperty<Integer> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ StartLivePromotionButton b;

        public a(Object r1, Object r2, StartLivePromotionButton r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Integer r3, Integer r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            int r5 = r4.intValue();
            r3.intValue();
            StartLivePromotionButton.u(this.b);
            if (r5 <= 0) goto L16;
            com.bytedance.android.livesdk.livecommerce.room.api.a r6 = this.b.b;
            if (r6 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
        L7:
            r6.a(this.b);
            return;
        L16:
            com.bytedance.android.livesdk.livecommerce.room.api.a r7 = this.b.b;     // Catch: Exception -> L13
            if (r7 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewGroup");     // Catch: Exception -> L13
        L11:
            r7.b(this.b);     // Catch: Exception -> L13
            return;
        L13:
            e = move-exception;
            ECExceptionMonitor.e(e);
        }
    }

    public static final class b extends ObservableProperty<Boolean> {
        public final /* synthetic */ Object a;
        public final /* synthetic */ StartLivePromotionButton b;

        public b(Object r1, Object r2, StartLivePromotionButton r3) {
            this.a = r1;
            this.b = r3;
            super(r2);
        }

        public final void afterChange(KProperty<?> r2, Boolean r3, Boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "property");
            r4.booleanValue();
            r3.booleanValue();
            StartLivePromotionButton.u(this.b);
        }
    }

    public static final class c implements z {
        public final /* synthetic */ StartLivePromotionButton a;

        public c(StartLivePromotionButton r1) {
            this.a = r1;
        }

        @Override // sg2.z
        public final void a(int r5) {
            StartLivePromotionButton r0 = this.a;
            r0.d.setValue(r0, StartLivePromotionButton.j[0], Integer.valueOf(r5));
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ StartLivePromotionButton a;

        public d(StartLivePromotionButton r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            StartLivePromotionButton r0 = this.a;
            int r6 = ((wk.d) r5).a;
            r0.d.setValue(r0, StartLivePromotionButton.j[0], Integer.valueOf(r6));
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
            if (r2 == null) goto L6;
            r2.getMessage();
            return;
        }
    }

    static {
        j = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartLivePromotionButton.class, "selectedCount", "getSelectedCount()I", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(StartLivePromotionButton.class, "ban", "getBan()Z", 0))};
    }

    public final View v() {
        return (View) this.a.getValue();
    }

    public final CompositeDisposable w() {
        return (CompositeDisposable) this.c.getValue();
    }

    public final int x() {
        return ((Number) this.d.getValue(this, j[0])).intValue();
    }

    public final View getView() {
        return v();
    }

    @Override // ak2.b
    public final void onLoad() {
        super.onLoad();
        com.bytedance.android.livesdk.livecommerce.room.api.e r0 = this.h;
        xd.g r1 = xd.g.a;
        this.b = r0.F();
        if (w().isDisposed() == true) goto L5;
        w().clear();
    L5:
        c r2 = new c(this);
        if (((com.bytedance.android.ec.adapter.api.state.c) this.i.invoke()) == null) goto L8;
        com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.d r3 = new com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.d(r2);
        String r4 = vi2.h.a;
        final String r5 = si2.g.i;
        Disposable r6 = vi2.h.e(null, null, r5, new vi2.f(r5)).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.livecommerce.room.widgets.start_live.e(r3), new f(r3));
        w().add(r6);
    L8:
        w().add(x0.a().a.ofType(wk.d.class).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this), e.a));
    }

    @Override // ak2.b
    public final void onUnload() {
        super.onUnload();
        if (w().isDisposed() == true) goto L6;
        w().clear();
        return;
    }

    @Override // ak2.b
    public final void onViewDetached() {
        super.onViewDetached();
        com.bytedance.android.livesdk.livecommerce.room.api.a r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r0.d(this.f);
    }

    public static final void u(StartLivePromotionButton r3) {
        if (r3.x() <= 0) goto L10;
        TextView r0 = (TextView) r3.v().findViewById(2131390377);
        if (r0 == null) goto L7;
        r0.setVisibility(0);
    L7:
        TextView r1 = (TextView) r3.v().findViewById(2131390377);
        if (r1 == null) goto L14;
        r1.setText(String.valueOf(r3.x()));
    L14:
        if (((Boolean) r3.e.getValue(r3, j[1])).booleanValue() == false) goto L16;
        r3.v().setAlpha(0.5f);
    L17:
        Object r2 = r3.v().getTag();
        if (TypeIntrinsics.isFunctionOfArity(r2, 1) == true) goto L20;
        r2 = null;
    L20:
        Function1 r4 = (Function1) r2;
        if (r4 == null) goto L24;
        Unit r5 = (Unit) r4.invoke(Integer.valueOf(r3.x()));
        return;
    L24:
        return;
    L16:
        r3.v().setAlpha(1.0f);
        goto L17
    L10:
        TextView r6 = (TextView) r3.v().findViewById(2131390377);
        if (r6 == null) goto L14;
        r6.setVisibility(8);
        goto L14
    }

    @Override // ak2.b
    public final void onViewAttached(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        super.onViewAttached(r2);
        ViewGroup.LayoutParams r3 = v().getLayoutParams();
        r3.height = -1;
        r3.width = -1;
        v().setLayoutParams(r3);
        v().requestLayout();
    }

    @Override // ak2.b
    public final void onViewWillAttach(Rect r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        com.bytedance.android.livesdk.livecommerce.room.api.a r3 = this.b;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r3.c(this.f);
    }

    @Override // ak2.b
    public final void onViewAttached(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        super.onViewAttached(r2);
        ViewGroup.LayoutParams r3 = v().getLayoutParams();
        r3.height = -1;
        r3.width = -1;
        v().setLayoutParams(r3);
        v().requestLayout();
    }

    @Override // ak2.b
    public final void onViewWillAttach(wd.c r2) {
        Intrinsics.checkNotNullParameter(r2, "viewContainerLayoutParam");
        com.bytedance.android.livesdk.livecommerce.room.api.a r3 = this.b;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewGroup");
    L5:
        r3.c(this.f);
    }

    public StartLivePromotionButton(Context r2, com.bytedance.android.livesdk.livecommerce.room.api.e r3, Function0<com.bytedance.android.ec.adapter.api.state.c> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "handler");
        Intrinsics.checkNotNullParameter(r4, "param");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = LazyKt.lazy(new StartLivePromotionButton$buttonView$2(this));
        this.c = LazyKt.lazy(StartLivePromotionButton$disposables$2.INSTANCE);
        int r5 = ECContextContainer.b;
        ECContextContainer.a.b();
        Delegates r6 = Delegates.INSTANCE;
        this.d = new a(0, 0, this);
        Boolean r7 = Boolean.FALSE;
        this.e = new b(r7, r7, this);
        this.f = new StartLivePromotionButton$listenerV1$1(this);
    }
}
