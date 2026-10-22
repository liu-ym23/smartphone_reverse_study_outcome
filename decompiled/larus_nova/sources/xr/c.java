package xr;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes44.dex */
public interface c {
    void attachViewAppearObserver(View r100, Function2<? super Boolean, ? super Float, Unit> r101);

    void detachViewAppearObserver();

    boolean viewIsWillDetached();
}
