package lp;

import android.app.Activity;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class h implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f510198a;

    public h(b r100) {
        this.f510198a = r100;
    }

    @Override // lp.b
    public final void a(Object r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "activity");
        e r102 = e.f510175s;
        np.b r103 = e.f510177u.f510195r;
        if (r103 == null) goto L5;
        r103.b(r100, r101);
    L5:
        boolean r104 = r100 instanceof np.b;
        Object r105 = null;
        if (r104 == true) goto L8;
        Object r106 = null;
    L9:
        np.b r107 = (np.b) r106;
        if (r107 == null) goto L12;
        r107.b(r100, r101);
    L12:
        b r108 = this.f510198a;
        if (r108 == null) goto L15;
        r108.a(r100, r101);
    L15:
        if (r104 == false) goto L18;
        r105 = r100;
    L18:
        np.b r109 = (np.b) r105;
        if (r109 == null) goto L21;
        r109.a(r100, r101);
    L21:
        if (r103 == null) goto L24;
        r103.a(r100, r101);
        return;
    L24:
        return;
    L8:
        r106 = r100;
        goto L9
    }

    @Override // lp.b
    public final void b(Object r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r101, "activity");
        b r102 = this.f510198a;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }
}
