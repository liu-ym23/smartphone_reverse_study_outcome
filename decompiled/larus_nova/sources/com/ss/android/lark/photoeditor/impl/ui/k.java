package com.ss.android.lark.photoeditor.impl.ui;

import android.util.Pair;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import java.io.File;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f438585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f438586b;

    public final void a() {
        if (UIUtils.isActivityRunning(this.f438586b.f438588b.f438593c.f438590a.f438596a) == true) goto L5;
        return;
    L5:
        l r100 = this.f438586b;
        o r101 = r100.f438588b.f438593c.f438590a;
        o.a r102 = r101.f438601f;
        if (r102 != null) goto L8;
        return;
    L8:
        if (this.f438585a != null) goto L10;
        PhotoEditorFragment.b r103 = (PhotoEditorFragment.b) r102;
        r103.a(r100.f438587a.getAbsolutePath(), new Pair(Integer.valueOf(this.f438586b.f438588b.f438591a.getWidth()), Integer.valueOf(this.f438586b.f438588b.f438591a.getHeight())), this.f438586b.f438588b.f438592b);
        return;
    L10:
        if ("from_preview".equals(r101.f438598c) == false) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L18;
        b r105 = this.f438586b.f438588b.f438593c.f438590a.getView();
        String r106 = this.f438585a.getAbsolutePath();
        o r107 = this.f438586b.f438588b.f438593c.f438590a;
        r105.v2(r106, r107.f438599d, r107.f438600e, r107.f438602g, r107.f438603h, r107.f438604i, r107.f438605j);
        return;
    L18:
        l r108 = this.f438586b;
        o.a r109 = r108.f438588b.f438593c.f438590a.f438601f;
        PhotoEditorFragment.b r110 = (PhotoEditorFragment.b) r109;
        r110.b(r108.f438587a.getAbsolutePath(), this.f438585a.getAbsolutePath(), new Pair(Integer.valueOf(this.f438586b.f438588b.f438591a.getWidth()), Integer.valueOf(this.f438586b.f438588b.f438591a.getHeight())), this.f438586b.f438588b.f438592b);
        return;
    L12:
        if ("from_screenshot_forward_preview".equals(r101.f438598c) == true) goto L15;
        r104 = false;
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public k(l r100, PolarisFileWrapper r101) {
        this.f438586b = r100;
        this.f438585a = r101;
    }
}
