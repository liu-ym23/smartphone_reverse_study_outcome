package com.larus.canvas.feature.component.resultdisplay.image.widget;

import android.view.ViewStub;
import com.larus.bmhome.chat.layout.holder.progressloading.ISketchLoadingController;
import com.larus.canvas.feature.component.logic.loading.CanvasProgressState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f323661f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f323662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<CanvasProgressState> f323663b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f323664c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Job f323665d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f323666e;

    public static final class a {
    }

    static {
    }

    public s(final ViewStub r100, CoroutineScope r101, Function0<CanvasProgressState> r102) {
        Intrinsics.checkNotNullParameter(r100, "sketchProgressLoadingViewStub");
        Intrinsics.checkNotNullParameter(r101, "scope");
        Intrinsics.checkNotNullParameter(r102, "canvasProgressStateGetter");
        this.f323662a = r101;
        this.f323663b = r102;
        this.f323664c = LazyKt.lazy(new r(r100));
    }

    public final void a(boolean r100, String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "id");
        Intrinsics.checkNotNullParameter(r111, "description");
        if (r100 == false) goto L10;
        ISketchLoadingController.a.b((ISketchLoadingController) this.f323664c.getValue(), false, null, 0, 7);
        if (Intrinsics.areEqual(this.f323666e, r110) == true) goto L15;
        this.f323666e = r110;
        ISketchLoadingController.a.a((ISketchLoadingController) this.f323664c.getValue(), r111, i5.m(), 4);
        Job r101 = this.f323665d;
        if (r101 == null) goto L9;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L9:
        this.f323665d = BuildersKt.launch$default(this.f323662a, null, null, new LoadingProgressController$observeProgress$1(this, r110, null), 3, null);
        return;
    L15:
        return;
    L10:
        ((ISketchLoadingController) this.f323664c.getValue()).hide();
        Job r102 = this.f323665d;
        if (r102 == null) goto L13;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L13:
        this.f323665d = null;
    }
}
