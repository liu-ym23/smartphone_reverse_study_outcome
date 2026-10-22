package com.lynx.tasm.behavior.ui;

import android.graphics.Rect;
import java.util.Comparator;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements Comparator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f382470a;

    public b(c r100) {
        this.f382470a = r100;
    }

    @Override // java.util.Comparator
    public final int compare(Object r100, Object r101) {
        Rect r102 = ((c.a) r100).f382483c;
        Rect r103 = ((c.a) r101).f382483c;
        int r104 = this.f382470a.f382472a;
        if (r104 != 0) goto L5;
        int r105 = r102.top - r103.top;
    L6:
        int r106 = r102.left - r103.left;
        if (r105 == 0) goto L9;
        return r105;
    L9:
        return r106;
    L5:
        r105 = (r102.top / r104) - (r103.top / r104);
        goto L6
    }
}
