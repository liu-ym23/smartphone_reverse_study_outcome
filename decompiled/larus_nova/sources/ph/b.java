package ph;

import android.view.View;
import com.bytedance.android.ec.core.opt.ab.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f529227a = 0;

    static {
    }

    public static void b(View r100) {
        if (r100 != null) goto L5;
    L6:
        if (r100 == null) goto L10;
        r100.setLayerType(2, null);
        return;
    L10:
        return;
    L5:
        if (r100.getLayerType() != 2) goto L6;
    }

    public static void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (j.a().g() == false) goto L15;
        if (r101 == false) goto L7;
        b(r100);
        return;
    L7:
        if (r100 == null) goto L9;
        Integer r102 = Integer.valueOf(r100.getLayerType());
    L11:
        if (r102.intValue() == 0) goto L17;
        if (r100 == null) goto L18;
        r100.setLayerType(0, null);
        return;
    L18:
        return;
    L17:
        return;
    L9:
        r102 = null;
        goto L11
    }

    public static void c(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (j.a().i() == false) goto L10;
        if (r101 == false) goto L7;
        b(r100);
        return;
    L7:
        if (Integer.valueOf(r100.getLayerType()).intValue() == 0) goto L12;
        r100.setLayerType(0, null);
        return;
    L12:
        return;
    }
}
