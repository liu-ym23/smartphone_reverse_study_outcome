package com.ss.android.lark.filedetail.impl.folder.manage.page.extract_package;

import android.view.View;
import com.larksuite.component.universe_design.loading.UDLoadingDrawable;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExtractPackageFragment f421721a;

    public c(ExtractPackageFragment r100) {
        this.f421721a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExtractPackageFragment r100 = this.f421721a;     // Catch: Throwable -> L14
        if (r100.f421706n != 2) goto L17;
        UDLoadingDrawable r101 = r100.f421705m;     // Catch: Throwable -> L14
        View r102 = null;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("loadingDrawable");     // Catch: Throwable -> L14
        r101 = null;
    L8:
        r101.start();     // Catch: Throwable -> L14
        View r103 = this.f421721a.f421703k;     // Catch: Throwable -> L14
        if (r103 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("loadingLayout");     // Catch: Throwable -> L14
    L12:
        r102.setVisibility(0);     // Catch: Throwable -> L14
        return;
    L11:
        r102 = r103;
        goto L12
    L17:
        return;
    L14:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L21;
        throw th;
    }
}
