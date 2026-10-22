package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f402124a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f402125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f402126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ContextThemeWrapper f402127d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f402128e;

    public abstract View b();

    public final Context getContext() {
        return this.f402124a;
    }

    public d(Context r100) {
        this.f402124a = r100;
        this.f402125b = false;
        this.f402126c = 0;
        this.f402128e = true;
    }

    public static ContextThemeWrapper a(d r100, Context r101) {
        boolean r102 = r100.f402125b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "baseContext");
        if (r100.f402126c != 0) goto L10;
        if (r102 == false) goto L7;
        ContextThemeWrapper r103 = new ContextThemeWrapper(r101, R.style.OBasicPanelDayNightSwitch);
    L8:
        r100.f402127d = r103;
        return r103;
    L7:
        r103 = new ContextThemeWrapper(r101, R.style.OBasicPanelConstLight);
        goto L8
    L10:
        return new ContextThemeWrapper(r101, r100.f402126c);
    }
}
