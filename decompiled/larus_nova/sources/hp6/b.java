package hp6;

import android.content.Context;
import android.graphics.PointF;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f486450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f486451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PointF f486452c;

    public b(Context r100) {
        if (r100 == null) goto L5;
        int r101 = ViewConfiguration.get(r100).getScaledTouchSlop();
    L6:
        this.f486450a = r101;
        return;
    L5:
        r101 = 8;
        goto L6
    }
}
