package qa7;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements View.OnApplyWindowInsetsListener {
    public d() {
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public final WindowInsets onApplyWindowInsets(View r100, WindowInsets r101) {
        WindowInsets r102 = new WindowInsets(r101);
        ViewGroup r103 = (ViewGroup) r100;
        int r104 = r103.getChildCount();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L5;
        r103.getChildAt(r105).dispatchApplyWindowInsets(r102);
        r105 = r105 + 1;
        goto L3
    L5:
        int r106 = Build.VERSION.SDK_INT;
        if (r106 < 30) goto L10;
        return WindowInsets.CONSUMED;
    L10:
        if (r106 < 28) goto L14;
        return r101.consumeSystemWindowInsets().consumeDisplayCutout();
    L14:
        return r101.consumeSystemWindowInsets();
    }
}
