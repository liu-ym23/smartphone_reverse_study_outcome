package com.bytedance.ee.bear.bitable.jsapi.common;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f214389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f214390b;

    public b(FragmentActivity r100, String r101) {
        this.f214389a = r100;
        this.f214390b = r101;
    }

    public final void a() {
        Context r100 = this.f214389a;
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r101 = (Activity) r100;
    L7:
        if (r101 != null) goto L11;
        tt5.a.k("AudioRecordHelper", "showErrorDialog skip, context is not Activity");
        return;
    L11:
        if (r101.isFinishing() == false) goto L13;
    L17:
        tt5.a.k("AudioRecordHelper", "showErrorDialog skip, activity invalid");
        return;
    L13:
        if (r101.isDestroyed() == true) goto L17;
        new UDDialogBuilder(r101).message(this.f214390b).addActionButton(R.id.ud_dialog_btn_primary, ((Activity) this.f214389a).getResources().getString(R.string.View_G_OkButton), null).show();
        return;
    L5:
        r101 = null;
        goto L7
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
}
