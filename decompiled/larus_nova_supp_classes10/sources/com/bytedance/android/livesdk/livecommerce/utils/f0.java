package com.bytedance.android.livesdk.livecommerce.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.io.File;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f0 implements ak2.f<String, String> {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Function2 b;

    public final Object getConfig() {
        File r0 = this.a.getExternalCacheDir();
        if (r0 == null) goto L10;
        PolarisFileWrapper r2 = new PolarisFileWrapper(r0, "/live/ecscreenshot");
        if (r2.exists() == false) goto L7;
    L9:
        dm.a.a("ECScreenshotUtils").i("return " + r2.getAbsolutePath());
        return r2.getAbsolutePath();
    L7:
        if (r2.mkdirs() == true) goto L9;
        dm.a.a("ECScreenshotUtils").i("return " + r0.getAbsolutePath());
        return r0.getAbsolutePath();
    L10:
        dm.a.a("ECScreenshotUtils").i("return no path");
        return "";
    }

    public final void onChanged(Object r3) {
        String r4 = (String) r3;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        this.b.invoke(null, "no path");
        return;
    L5:
        nl2.b.b(Observable.create(new d0(this, r4)).observeOn(AndroidSchedulers.mainThread()).subscribe(new e0(this)));
    }

    public f0(Context r1, Function2 r2) {
        this.a = r1;
        this.b = r2;
    }
}
