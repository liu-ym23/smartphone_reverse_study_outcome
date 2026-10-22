package com.bytedance.awemeopen.apps.framework.comment.util;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/Animator;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 176)
public final class AnimatorUtilKt$addListener$3 extends Lambda implements Function1<Animator, Unit> {
    public static final AnimatorUtilKt$addListener$3 INSTANCE = null;

    static {
        INSTANCE = new AnimatorUtilKt$addListener$3();
    }

    public AnimatorUtilKt$addListener$3() {
        super(1);
    }

    public final void invoke(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((Animator) r1);
        return Unit.INSTANCE;
    }
}
