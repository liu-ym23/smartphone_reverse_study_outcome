package v19;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes27.dex */
public final class g7 implements Function1<Throwable, Unit> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f552475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h7 f552476b;

    public g7(View r100, h7 r101) {
        this.f552475a = r100;
        this.f552476b = r101;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable r100) {
        this.f552475a.getViewTreeObserver().removeOnGlobalLayoutListener(this.f552476b);
        return Unit.INSTANCE;
    }
}
