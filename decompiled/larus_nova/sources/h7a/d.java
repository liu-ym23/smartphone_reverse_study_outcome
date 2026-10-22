package h7a;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewParent f484007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewParent f484008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f484009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f484010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int[] f484011e;

    public d(View r100) {
        this.f484009c = r100;
    }

    public final ViewParent a(int r100) {
        if (r100 != 0) goto L5;
        return this.f484007a;
    L5:
        return this.f484008b;
    }
}
