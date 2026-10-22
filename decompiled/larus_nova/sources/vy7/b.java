package vy7;

import android.view.View;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.ss.android.lark.utils.UIHelper;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f557623a = null;

    static {
        f557623a = new b();
    }

    public b() {
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View r100, WindowInsetsCompat r101) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        Intrinsics.checkNotNullParameter(r101, "insets");
        if (r101.getDisplayCutout() == null) goto L11;
        DisplayCutoutCompat r102 = r101.getDisplayCutout();
        if (r102 == null) goto L7;
        Integer r103 = Integer.valueOf(r102.getSafeInsetLeft());
    L8:
        if (r103 == null) goto L11;
        r100.setPadding(r103.intValue(), r100.getPaddingTop(), r100.getPaddingRight(), UIHelper.dp2px(16.0f));
        goto L11
    L7:
        r103 = null;
    L11:
        return WindowInsetsCompat.CONSUMED;
    }
}
