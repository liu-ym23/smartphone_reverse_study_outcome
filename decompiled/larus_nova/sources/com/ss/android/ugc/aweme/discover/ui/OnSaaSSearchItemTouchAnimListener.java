package com.ss.android.ugc.aweme.discover.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/OnSaaSSearchItemTouchAnimListener;", "Lcom/ss/android/ugc/aweme/discover/ui/OnSaaSTouchAnimListener;", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class OnSaaSSearchItemTouchAnimListener extends OnSaaSTouchAnimListener {
    public OnSaaSSearchItemTouchAnimListener() {
    }

    @Override // com.ss.android.ugc.aweme.discover.ui.OnSaaSTouchAnimListener
    public final Animator a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, "alpha", new float[]{0.5f, 1.0f});
        r101.setDuration(150);
        return r101;
    }
}
