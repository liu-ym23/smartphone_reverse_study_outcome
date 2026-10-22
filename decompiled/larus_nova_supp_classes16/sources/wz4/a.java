package wz4;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a {
    void dismiss();

    void onHideShotView();

    void setDismissListener(Function0<Unit> r1);

    void setOnBackPressListener(Function0<Unit> r1);

    void setSnapState(boolean r1);
}
