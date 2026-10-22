package dtc;

import android.os.Build;
import android.text.style.LineHeightSpan;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f470019a = 0;

    static {
    }

    public static LineHeightSpan a(int r100) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        return new LineHeightSpan.Standard(r100);
    L6:
        return new c(r100);
    }
}
