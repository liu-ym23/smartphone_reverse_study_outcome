package com.ss.android.lark.widget.photo.preview.image;

import com.larksuite.component.universe_design.toast.UDToast;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes38.dex */
public final class v implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f446705a;

    public v(n r100) {
        this.f446705a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UDToast.show(this.f446705a.f446677a, R.string.Lark_Setting_NameNetworkError);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
