package com.bytedance.dux.window.controller;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.lifecycle.Observer;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import em4.d;
import hm4.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/window/controller/DuxWindowSizeController;", "", "Landroidx/lifecycle/Observer;", "Lhm4/f;", "<init>", "()V", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxWindowSizeController implements Observer<f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DuxWindowSizeController f205934a = null;

    static {
        f205934a = new DuxWindowSizeController();
    }

    private DuxWindowSizeController() {
    }

    public final hm4.a a(View r100) {
        boolean r101 = false;
        if (r100 == null) goto L5;
        int r102 = r100.getWidth();
    L6:
        if (r102 <= 0) goto L19;
        if (r100 == null) goto L9;
        int r103 = r100.getHeight();
    L10:
        if (r103 <= 0) goto L19;
        if (r100 != null) goto L13;
    L15:
        if (r101 == false) goto L19;
        Resources r104 = Resources.getSystem();
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());
        return new hm4.a(r100.getWidth() / r105.density, r100.getHeight() / r105.density);
    L13:
        if (r100.isAttachedToWindow() != true) goto L15;
        r101 = true;
        goto L15
    L9:
        r103 = 0;
    L19:
        return b.b().f485936d;
    L5:
        r102 = 0;
        goto L6
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(f r100) {
        f r101 = r100;
        if (r101 == null) goto L5;
        r101.getClass();
    L5:
        d.b("DuxWindowSizeController", "onChanged：view is null!");
    }
}
