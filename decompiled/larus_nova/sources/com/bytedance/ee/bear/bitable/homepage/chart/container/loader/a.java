package com.bytedance.ee.bear.bitable.homepage.chart.container.loader;

import com.ss.android.lark.utils.LarkContext;
import java.io.InputStream;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements uqb.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile byte[] f212442a;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.homepage.chart.container.loader.a$a, reason: collision with other inner class name */
    public static final class C3047a {
    }

    static {
    }

    public a() {
    }

    @Override // uqb.b
    public final synchronized void a(String r100, uqb.a r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "templatePath");     // Catch: Throwable -> L30
        Intrinsics.checkNotNullParameter(r101, "resourceCallBack");     // Catch: Throwable -> L30
        if (this.f212442a != null) goto L21;
        tt5.a.h("AssetsTemplateLoader", "fileBytes is null, load from assets");     // Catch: Throwable -> L30
        InputStream r102 = LarkContext.getApplication().getAssets().open("bitable/chart/template.js");     // Catch: Throwable -> L11
        this.f212442a = new byte[r102.available()];     // Catch: Throwable -> L9
        r102.read(this.f212442a);     // Catch: Throwable -> L9
    L15:
        r102.close();     // Catch: Throwable -> L30
    L9:
        th = th;
    L37:
        tt5.a.e("AssetsTemplateLoader", "load failed", th, false);     // Catch: Throwable -> L16
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L16
        if (r102 == null) goto L21;
    L16:
        th = move-exception;
        if (r102 == null) goto L19;
        r102.close();     // Catch: Throwable -> L30
    L19:
        throw th;     // Catch: Throwable -> L30
    L11:
        th = th;
        r102 = null;
    L21:
        if (this.f212442a == null) goto L27;
        byte[] r104 = this.f212442a;     // Catch: Throwable -> L30
        if (r104 == null) goto L26;
        r101.a(new uqb.c(r104, null, null, 14));     // Catch: Throwable -> L30
    L28:
        monitor-exit(this);
        return;
    L26:
        throw new IllegalArgumentException("Required value was null.".toString());     // Catch: Throwable -> L30
    L27:
        r101.onFailed(new IllegalStateException("load template failed"));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }
}
