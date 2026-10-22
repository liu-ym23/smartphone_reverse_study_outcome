package com.bytedance.bdp.bdpbase.util;

import android.content.Context;
import android.widget.Toast;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes11.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f201346a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f201347b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f201348c;

    public n(Context r100, String r101, Ref.IntRef r102) {
        this.f201346a = r100;
        this.f201347b = r101;
        this.f201348c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Toast.makeText(this.f201346a, this.f201347b, this.f201348c.element).show();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
