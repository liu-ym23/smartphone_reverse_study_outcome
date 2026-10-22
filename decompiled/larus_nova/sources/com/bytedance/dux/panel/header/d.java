package com.bytedance.dux.panel.header;

import android.content.Context;
import android.view.View;
import com.bytedance.dux.theme.DuxContextThemeWrapper;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f205389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f205390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f205391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public DuxContextThemeWrapper f205392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f205393e;

    public abstract View c();

    public final DuxContextThemeWrapper b() {
        DuxContextThemeWrapper r100 = this.f205392d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return a(this, this.f205389a);
    }

    public final Context getContext() {
        return this.f205389a;
    }

    public static DuxContextThemeWrapper a(d r100, Context r101) {
        boolean r102 = r100.f205390b;
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "baseContext");
        if (r100.f205391c != 0) goto L10;
        if (r102 == false) goto L7;
        DuxContextThemeWrapper r103 = new DuxContextThemeWrapper(r101, R.style.DuxBasicPanelDayNightSwitch);
    L8:
        r100.f205392d = r103;
        return r103;
    L7:
        r103 = new DuxContextThemeWrapper(r101, R.style.DuxBasicPanelConstLight);
        goto L8
    L10:
        return new DuxContextThemeWrapper(r101, r100.f205391c);
    }

    public d(Context r100, boolean r101, boolean r102) {
        this.f205389a = r100;
        this.f205390b = r101;
        this.f205391c = 0;
        this.f205393e = true;
    }
}
