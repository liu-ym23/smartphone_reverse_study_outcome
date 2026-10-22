package com.ss.android.lark.multitask.task;

import android.app.Activity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/ref/WeakReference;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ActivityLifecycle$onActivityDestroyed$1 extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
    final /* synthetic */ Activity $activity;

    public ActivityLifecycle$onActivityDestroyed$1(Activity r100) {
        this.$activity = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(WeakReference<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        return Boolean.valueOf(Intrinsics.areEqual(r100.get(), this.$activity));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Activity> r100) {
        return invoke2(r100);
    }
}
