package com.obric.common.oea.foundation.animation.easy;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Landroid/view/View;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/obric/common/oea/foundation/animation/easy/b;", "it", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/obric/common/oea/foundation/animation/easy/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class ViewPropertySpringAnimator$setListener$2 extends Lambda implements Function1<b<View>, Unit> {
    public static final ViewPropertySpringAnimator$setListener$2 INSTANCE = null;

    static {
        INSTANCE = new ViewPropertySpringAnimator$setListener$2();
    }

    public ViewPropertySpringAnimator$setListener$2() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(b<View> r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(b<View> r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
