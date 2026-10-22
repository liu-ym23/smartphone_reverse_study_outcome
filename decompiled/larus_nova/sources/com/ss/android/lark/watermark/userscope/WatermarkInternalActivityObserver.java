package com.ss.android.lark.watermark.userscope;

import android.app.Activity;
import androidx.lifecycle.Observer;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/watermark/userscope/WatermarkInternalActivityObserver;", "Landroidx/lifecycle/Observer;", "Lcom/ss/android/lark/watermark/v2/WatermarkState;", "activity", "Landroid/app/Activity;", "binder", "Lcom/ss/android/lark/watermark/v2/WatermarkBinder;", "<init>", "(Landroid/app/Activity;Lcom/ss/android/lark/watermark/v2/WatermarkBinder;)V", "getActivity", "()Landroid/app/Activity;", "onChanged", "", "t", "watermark_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkInternalActivityObserver implements Observer<com.ss.android.lark.watermark.v2.v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f445374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.watermark.v2.q<Activity> f445375b;

    public final Activity getActivity() {
        return this.f445374a;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(com.ss.android.lark.watermark.v2.v r100) {
        com.ss.android.lark.watermark.v2.v r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "t");
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.security.watermark_thread_opt_disabled.android") == true) goto L5;
        s.a(r101, this.f445374a, this.f445375b);
        return;
    L5:
        Log.i("watermarkV3", "fg watermark_thread_opt_disabled is enabled");
        com.ss.android.lark.watermark.v2.u r102 = new com.ss.android.lark.watermark.v2.u(r101, this.f445374a);
        this.f445375b.b(r102, this.f445374a);
    }

    public WatermarkInternalActivityObserver(Activity r100, com.ss.android.lark.watermark.v2.q<Activity> r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "binder");
        this.f445374a = r100;
        this.f445375b = r101;
    }
}
