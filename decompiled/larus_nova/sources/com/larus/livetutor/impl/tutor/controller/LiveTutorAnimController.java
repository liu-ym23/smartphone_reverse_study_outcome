package com.larus.livetutor.impl.tutor.controller;

import android.animation.AnimatorSet;
import android.widget.ImageView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.livetutor.impl.hybrid.LiveTutorHybridContainer;
import com.larus.livetutor.impl.repository.viewmodel.LiveTutorViewModel;
import com.larus.livetutor.impl.utils.UtilsKt;
import com.larus.nova.R;
import kotlin.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class LiveTutorAnimController {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f356428f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LiveTutorViewModel f356429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveTutorHybridContainer f356430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LottieAnimationView f356431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f356432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AnimatorSet f356433e;

    public static final class a {
    }

    public static final class b implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f356434a;

        public b(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f356434a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f356434a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f356434a.invoke(r100);
        }
    }

    static {
    }

    public final void c() {
        LottieAnimationView r100 = this.f356431c;
        if (r100 == null) goto L5;
        j19.c.d(r100);
        r100.cancelAnimation();
    L5:
        AnimatorSet r101 = this.f356433e;
        if (r101 == null) goto L8;
        r101.cancel();
    L8:
        this.f356432d = false;
    }

    public LiveTutorAnimController(LiveTutorViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        this.f356429a = r100;
    }

    public final void a(final LiveTutorViewModel r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        LifecycleOwner r101 = r100.getLifecycleOwner();
        if (r101 != null) goto L5;
        return;
    L5:
        UtilsKt.m(LifecycleOwnerKt.getLifecycleScope(r101), null, new LiveTutorAnimController$initObserver$1(r100, this, null), 3);
        r100.addClosePageListener(new com.larus.livetutor.impl.tutor.controller.b(this));
        r100.getKeyboardStatus().observe(r101, new b(new c(this)));
        r100.getActivityConfiguration().observe(r101, new b(new d(this)));
        r100.getPressState().observe(r101, new b(new e(this)));
        r100.getPauseRtc().observe(r101, new b(new f(this, r100)));
    }

    public final void b(LiveTutorHybridContainer r100) {
        this.f356430b = r100;
        if (r100 == null) goto L10;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ImageView r101 = (ImageView) r100.getContext().findViewById(R.id.state_anim);
        LiveTutorHybridContainer r102 = this.f356430b;
        if (r102 == null) goto L7;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        LottieAnimationView r103 = (LottieAnimationView) r102.getContext().findViewById(R.id.live_tutor_transition_lottie);
    L8:
        this.f356431c = r103;
        return;
    L7:
        r103 = null;
        goto L8
    }
}
