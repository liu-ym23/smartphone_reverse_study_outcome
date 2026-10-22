package kma;

import android.R;
import com.obric.oui.color.j0;

/* JADX INFO: loaded from: classes34.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f504121d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int[][] f504122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j0[] f504123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0 f504124c;

    static {
        f504121d = new int[]{R.attr.state_enabled};
    }

    public static boolean a(j0 r100, j0 r101) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r100 == null) goto L18;
        if (r101 == null) goto L18;
        if (r100.f399496a == r101.f399496a) goto L12;
    L16:
        return false;
    L12:
        if (r100.f399497b != r101.f399497b) goto L16;
        if (r100.f399498c != r101.f399498c) goto L16;
        return true;
    L18:
        return false;
    }

    public d(int[][] r100, j0[] r101, j0 r102) {
        if (r100.length != r101.length) goto L11;
        if (r100.length == 0) goto L9;
        this.f504122a = r100;
        this.f504123b = r101;
        this.f504124c = r102;
        return;
    L9:
        throw new IllegalArgumentException("stateSpecs must not be empty");
    L11:
        throw new IllegalArgumentException("stateSpecs.size(" + r100.length + ") must equal strokes.size(" + r101.length + ")");
    }
}
