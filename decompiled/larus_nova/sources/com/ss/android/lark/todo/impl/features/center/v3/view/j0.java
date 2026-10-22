package com.ss.android.lark.todo.impl.features.center.v3.view;

import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class j0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskItemViewHolder f442045a;

    public j0(TaskItemViewHolder r100) {
        this.f442045a = r100;
    }

    public final void a() {
        ((ImageView) this.f442045a.f441924a.findViewById(R.id.complete_checkbox)).setVisibility(0);
        ((LottieAnimationView) this.f442045a.f441924a.findViewById(R.id.complete_checkbox_lottie)).setVisibility(8);
        ((LottieAnimationView) this.f442045a.f441924a.findViewById(R.id.complete_checkbox_lottie)).cancelAnimation();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
