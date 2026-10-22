package com.larus.common_ui.floatwindow.view;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f327493a = 0;

    static {
    }

    public static Activity a(Activity r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        boolean r101 = false;
        if ((r100 instanceof e19.a) == false) goto L8;
    L13:
        boolean r102 = true;
    L14:
        if (r102 == true) goto L16;
        return r100;
    L16:
        Activity r103 = AppHost.f326268a.a().a(r100, new d());
        if (r103 != null) goto L27;
        if (r100.isFinishing() == false) goto L21;
    L22:
        r101 = true;
    L23:
        if (r101 == true) goto L28;
        return r100;
    L28:
        return null;
    L21:
        if (r100.isDestroyed() == false) goto L23;
    L27:
        return r103;
    L8:
        if (r100.isFinishing() == true) goto L13;
        if (r100.isDestroyed() == true) goto L13;
        r102 = false;
        goto L14
    }

    public static Activity b(AppCompatActivity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Activity r101 = AppHost.f326268a.a().a(r100, new d());
        if (r101 != null) goto L15;
        if (r100.isFinishing() == false) goto L7;
    L10:
        boolean r102 = true;
    L11:
        if (r102 == false) goto L17;
        return null;
    L17:
        return r100;
    L7:
        if (r100.isDestroyed() == true) goto L10;
        r102 = false;
        goto L11
    L15:
        return r101;
    }
}
