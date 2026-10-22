package com.larus.utils;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.SharedElementCallback;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, d2 = {"com/larus/utils/ActivityTransition$captureExitSharedElement$1", "Landroidx/core/app/SharedElementCallback;", "onCaptureSharedElementSnapshot", "Landroid/os/Parcelable;", "sharedElement", "Landroid/view/View;", "viewToGlobalMatrix", "Landroid/graphics/Matrix;", "screenBounds", "Landroid/graphics/RectF;", "utils_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ActivityTransition$captureExitSharedElement$1 extends SharedElementCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<View, Parcelable> f375328a;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityTransition$captureExitSharedElement$1(Function1<? super View, ? extends Parcelable> r100) {
        this.f375328a = r100;
    }

    @Override // androidx.core.app.SharedElementCallback
    public final Parcelable onCaptureSharedElementSnapshot(View r100, Matrix r101, RectF r102) {
        Parcelable r103 = this.f375328a.invoke(r100);
        if (r103 == null) goto L5;
        return r103;
    L5:
        return super.onCaptureSharedElementSnapshot(r100, r101, r102);
    }
}
