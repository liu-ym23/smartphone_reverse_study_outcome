package com.ss.android.lark.appcontext.applifecycle2.impl;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/appcontext/applifecycle2/impl/ActivityRecorder2$ObjectRef;", "Landroid/app/Activity;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/appcontext/applifecycle2/impl/ActivityRecorder2$ObjectRef;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class ActivityRecorder2$getFrontActivities$1 extends Lambda implements Function1<ActivityRecorder2.a<Activity>, Boolean> {
    final /* synthetic */ List<Activity> $result;
    final /* synthetic */ ActivityRecorder2 this$0;

    public ActivityRecorder2$getFrontActivities$1(ActivityRecorder2 r100, List<Activity> r101) {
        this.this$0 = r100;
        this.$result = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(ActivityRecorder2.a<Activity> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        ActivityRecorder2 r101 = this.this$0;
        Lifecycle.Event r102 = r100.f408877a;
        r101.getClass();
        int r103 = ActivityRecorder2.b.f408880a[r102.ordinal()];
        if (r103 != 2) goto L5;
    L9:
        boolean r104 = true;
    L10:
        if (r104 == false) goto L15;
        Activity r105 = r100.get();
        if (r105 == null) goto L15;
        this.$result.add(r105);
    L15:
        return Boolean.FALSE;
    L5:
        if (r103 == 3) goto L9;
        if (r103 == 4) goto L9;
        r104 = false;
        goto L10
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(ActivityRecorder2.a<Activity> r100) {
        return invoke2(r100);
    }
}
