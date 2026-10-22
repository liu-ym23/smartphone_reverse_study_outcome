package com.bytedance.locallife.cube.bridge;

import android.app.Application;
import android.graphics.Typeface;
import com.bytedance.locallife.biz.base.cube.d;
import com.bytedance.locallife.cube.experiments.CubeFontFamily;
import com.lynx.tasm.behavior.shadow.text.g;
import kotlin.collections.ArraysKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f257191a = null;

    static {
        f257191a = new b();
    }

    public b() {
    }

    @Override // com.lynx.tasm.behavior.shadow.text.g.b
    public final Typeface a(String r100, int r101) {
        CubeFontFamily r102 = a.f257189c;
        if (r102 == null) goto L9;
        String[] r103 = r102.getAssetFonts();
        if (r103 == null) goto L9;
        boolean r104 = true;
        if (ArraysKt.contains(r103, r100) != true) goto L9;
    L10:
        if (r104 == false) goto L14;
        com.bytedance.locallife.cube.c.c();
        Application r105 = d.f256534a.a();
        if (r105 == null) goto L14;
        return g.e(r105.getAssets(), r100, r101, "fonts/");
    L14:
        return null;
    L9:
        r104 = false;
        goto L10
    }
}
