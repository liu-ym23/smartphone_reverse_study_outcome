package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.collect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.lifecycle.Observer;
import com.bytedance.awemeopen.apps.framework.utils.o;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimConfig;
import com.bytedance.awemeopen.infra.base.anim.lottie.AoAnimationLottieView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class CollectElementView extends com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c<g, i> {
    public final String e;
    public LinearLayout f;
    public AoAnimationLottieView g;
    public TextView h;
    public boolean i;
    public State j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/collect/CollectElementView$State;", "", "AnimToCollect", "AnimToUnCollect", "UnCollect", "Collect", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
    public static final enum State extends Enum<State> {
        public static final State AnimToCollect = null;
        public static final State AnimToUnCollect = null;
        public static final State Collect = null;
        public static final State UnCollect = null;
        public static final /* synthetic */ State[] a = null;

        public static State valueOf(String r1) {
            return (State) r27.a.a(State.class, r1);
        }

        public static State[] values() {
            return (State[]) a.clone();
        }

        static {
            State r0 = new State("AnimToCollect", 0);
            AnimToCollect = r0;
            State r1 = new State("AnimToUnCollect", 1);
            AnimToUnCollect = r1;
            State r3 = new State("UnCollect", 2);
            UnCollect = r3;
            State r5 = new State("Collect", 3);
            Collect = r5;
            a = new State[]{r0, r1, r3, r5};
        }

        public State(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a extends o {
        public final /* synthetic */ CollectElementView d;

        @Override // com.bytedance.awemeopen.apps.framework.utils.o
        public final void a() {
            ((g) this.d.b).a.b(Unit.INSTANCE);
        }

        public a(CollectElementView r1) {
            this.d = r1;
        }
    }

    public final void d() {
        AppCompatImageView r0 = this.g;
        AppCompatImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r0 = null;
    L5:
        r0.setImageResource(2131231455);
        ImageView r2 = this.g;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r2 = null;
    L9:
        if (r2.isShown() == true) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r2.isRunning() == false) goto L19;
        ((AoAnimationLottieView) r2).h.cancelAnimation();
        return;
    L19:
        if (r4 == false) goto L21;
        r2.setMinAndMaxFrame(0, 40);
        this.j = State.AnimToCollect;
        r2.start();
        return;
    L21:
        r2.setMinAndMaxFrame(40, 40);
        this.j = State.Collect;
        AppCompatImageView r3 = this.g;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
    L25:
        r1.setImageResource(2131231455);
        return;
    L24:
        r1 = r3;
        goto L25
    L11:
        if (this.i == false) goto L13;
        r4 = true;
        goto L15
    }

    public final void e() {
        AppCompatImageView r0 = this.g;
        AppCompatImageView r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r0 = null;
    L5:
        r0.setImageResource(2131231454);
        ImageView r2 = this.g;
        if (r2 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r2 = null;
    L9:
        if (r2.isShown() == true) goto L11;
    L13:
        boolean r4 = false;
    L15:
        if (r2.isRunning() == false) goto L19;
        ((AoAnimationLottieView) r2).h.cancelAnimation();
        return;
    L19:
        if (r4 == false) goto L21;
        r2.setMinAndMaxFrame(40, 64);
        this.j = State.AnimToUnCollect;
        r2.start();
        return;
    L21:
        r2.setMinAndMaxFrame(64, 64);
        this.j = State.UnCollect;
        AppCompatImageView r3 = this.g;
        if (r3 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
    L25:
        r1.setImageResource(2131231454);
        return;
    L24:
        r1 = r3;
        goto L25
    L11:
        if (this.i == false) goto L13;
        r4 = true;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final void c() {
        this.f = (LinearLayout) b().findViewById(2131367159);
        this.h = (TextView) b().findViewById(2131367135);
        AppCompatImageView r0 = (AoAnimationLottieView) b().findViewById(2131367146);
        this.g = r0;
        LinearLayout r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r0 = null;
    L5:
        r0.setImageResource(2131231454);
        AoAnimationLottieView r2 = this.g;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r2 = null;
    L8:
        r2.setImagesAssetsFolder("aos_anim_collect_img_star");
        String r5 = com.bytedance.awemeopen.infra.util.f.b(getContext().getAssets().open("aos_anim_collect.json"));
        AoAnimationLottieView r3 = this.g;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("collectLottie");
        r3 = null;
    L11:
        r3.setAnimationConfigAndStartLoad(new AoAnimConfig(AoAnimConfig.ResMode.JSON_STRING, r5, new f(this), new CollectElementView$initCollectView$2(this), 4));
        LinearLayout r4 = this.f;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("collectContainer");
    L15:
        r1.setOnClickListener(new a(this));
        i r6 = (i) this.c;
        Observer<Unit> r7 = new b(this);
        r6.getClass();
        Intrinsics.checkNotNullParameter(r7, "observer");
        r6.a.a(r7);
        i r8 = (i) this.c;
        Observer<Boolean> r9 = new c(this);
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, "observer");
        r8.c.a(r9);
        i r10 = (i) this.c;
        Observer<Long> r11 = new d(this);
        r10.getClass();
        Intrinsics.checkNotNullParameter(r11, "observer");
        r10.b.a(r11);
        i r12 = (i) this.c;
        Observer<Boolean> r13 = new e(this);
        r12.getClass();
        Intrinsics.checkNotNullParameter(r13, "observer");
        r12.d.a(r13);
        return;
    L14:
        r1 = r4;
        goto L15
    }

    @Override // com.bytedance.awemeopen.apps.framework.feed.slide.framework.element.c
    public final View a(ViewGroup r4) {
        Intrinsics.checkNotNullParameter(r4, "parentView");
        return LayoutInflater.from(r4.getContext()).inflate(2131558608, r4, false);
    }

    public CollectElementView(Context r2, g r3, i r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "model");
        super(r2, r3, r4);
        this.e = "CollectElementView";
        this.i = true;
        this.j = State.UnCollect;
    }
}
