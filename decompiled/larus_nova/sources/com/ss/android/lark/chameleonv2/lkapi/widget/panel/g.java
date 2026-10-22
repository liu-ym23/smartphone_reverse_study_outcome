package com.ss.android.lark.chameleonv2.lkapi.widget.panel;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f411511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f411512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PanelItem f411513c;

    public g() {
        this(null, null, null);
    }

    public final int hashCode() {
        String r100 = this.f411511a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f411511a, ((g) r100).f411511a);
    }

    public g(String r100, View r101, PanelItem r102) {
        this.f411511a = r100;
        this.f411512b = r101;
        this.f411513c = r102;
    }
}
