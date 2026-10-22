package com.ss.android.ugc.route_monitor.impl.route_out;

import android.app.Activity;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 16})
final class AppLifeMonitor$cleanResumeActivityList$1 extends Lambda implements Function1<WeakReference<Activity>, Boolean> {
    final /* synthetic */ Activity $activity;

    public AppLifeMonitor$cleanResumeActivityList$1(Activity r100) {
        this.$activity = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(WeakReference<Activity> r100) {
        Activity r101 = r100.get();
        if (r101 != null) goto L5;
    L8:
        return true;
    L5:
        if (r101 == this.$activity) goto L8;
        return false;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(WeakReference<Activity> r100) {
        return Boolean.valueOf(invoke2(r100));
    }
}
