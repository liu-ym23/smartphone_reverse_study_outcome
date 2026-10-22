package dxc;

import android.content.Context;
import exc.e;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements a {
    public b() {
    }

    @Override // dxc.a
    public final void a(Context r100, int r101) {
        if (r101 < 3) goto L6;
        e.b("PropertiesGrade", "newVersion is less then oldVersion, onUpgrade error");
        return;
    L6:
        e.c("PropertiesGrade", "update settings.properties when version update");
    }
}
