package com.ss.android.lark.multitask.task;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/multitask/task/TaskWrapper;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/ss/android/lark/multitask/task/TaskWrapper;)Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
final class TaskWrapperHolder$trimNulls$1 extends Lambda implements Function1<e, Boolean> {
    public static final TaskWrapperHolder$trimNulls$1 INSTANCE = null;

    static {
        INSTANCE = new TaskWrapperHolder$trimNulls$1();
    }

    public TaskWrapperHolder$trimNulls$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(e r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        if ((r100 instanceof b) == true) goto L5;
    L7:
        boolean r101 = false;
    L9:
        return Boolean.valueOf(r101);
    L5:
        if (((b) r100).a() != null) goto L7;
        r101 = true;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(e r100) {
        return invoke2(r100);
    }
}
