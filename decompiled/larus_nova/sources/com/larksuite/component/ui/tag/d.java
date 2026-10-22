package com.larksuite.component.ui.tag;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import java.util.HashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class d extends StateListDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<int[], Drawable> f284455a;

    public d() {
        this.f284455a = new HashMap(2);
    }

    @Override // android.graphics.drawable.StateListDrawable
    public final void addState(int[] r100, Drawable r101) {
        super.addState(r100, r101);
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        this.f284455a.put(r100, r101);
        return;
    L8:
        return;
    }
}
