package com.larus.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375426a = 0;

    static {
    }

    public j0() {
    }

    public static int a(int r100) {
        return ContextCompat.getColor(AppHost.f326268a.getApplication(), r100);
    }

    public static int b(int r100) {
        return AppHost.f326268a.getApplication().getResources().getDimensionPixelSize(r100);
    }

    public static Drawable c(int r100) {
        Drawable r101 = AppCompatResources.getDrawable(AppHost.f326268a.getApplication(), r100);
        Intrinsics.checkNotNull(r101);
        return r101;
    }

    public static String d(int r100) {
        return AppHost.f326268a.getApplication().getString(r100);
    }

    public static String e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        AppHost.Companion r101 = AppHost.f326268a;
        Resources r102 = r101.getApplication().getResources();
        if (StringsKt.startsWith$default(r100, "larus_", false, 2, null) == false) goto L5;
        String r103 = r100;
    L6:
        int r104 = r102.getIdentifier(r103, "string", r101.getApplication().getPackageName());
        if (r104 != 0) goto L9;
        return r100;
    L9:
        return r102.getString(r104);
    L5:
        r103 = "larus_" + r100;
        goto L6
    }

    public static Drawable f(int r100, int r101) {
        Drawable r102 = c(r100).mutate();
        DrawableCompat.setTint(r102, r101);
        return r102;
    }
}
