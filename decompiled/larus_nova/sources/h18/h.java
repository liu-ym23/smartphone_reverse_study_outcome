package h18;

import android.view.View;
import androidx.core.view.ViewCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class h {
    public static final boolean a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (ViewCompat.getLayoutDirection(r100) == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
