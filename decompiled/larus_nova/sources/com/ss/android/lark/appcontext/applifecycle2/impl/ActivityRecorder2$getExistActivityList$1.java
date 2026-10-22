package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/appcontext/applifecycle2/impl/ActivityRecorder2$ObjectRef;", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/appcontext/applifecycle2/impl/ActivityRecorder2$ObjectRef;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ActivityRecorder2$getExistActivityList$1 extends Lambda implements Function1<ActivityRecorder2.a<Activity>, Boolean> {
    final /* synthetic */ ArrayList<Activity> $list;

    public ActivityRecorder2$getExistActivityList$1(ArrayList<Activity> r100) {
        this.$list = r100;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ActivityRecorder2.a<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if (ArraysKt.contains(new Lifecycle.Event[]{Lifecycle.Event.ON_CREATE, Lifecycle.Event.ON_START, Lifecycle.Event.ON_RESUME, Lifecycle.Event.ON_PAUSE, Lifecycle.Event.ON_STOP}, r100.f408877a) == false) goto L8;
        Activity r101 = r100.get();
        if (r101 == null) goto L8;
        this.$list.add(r101);
    L8:
        return Boolean.FALSE;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ActivityRecorder2.a<Activity> r100) {
        return invoke2(r100);
    }
}
