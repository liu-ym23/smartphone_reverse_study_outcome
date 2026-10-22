package com.ss.android.lark.auditsdk.v2.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Integer f409691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f409692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Integer f409693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Context f409694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Integer f409695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f409696f;

    public a(Integer r100, String r101, Integer r102, Context r103, Integer r104, DialogInterface.OnDismissListener r105) {
        this.f409691a = r100;
        this.f409692b = r101;
        this.f409693c = r102;
        this.f409694d = r103;
        this.f409695e = r104;
        this.f409696f = r105;
    }

    public final void a() {
        Lazy r100 = AuditUtilsV2.f409687a;
        String r101 = AuditUtilsV2.a(this.f409691a, this.f409692b, this.f409693c);
        if (r101 == null) goto L13;
        Context r102 = this.f409694d;
        Integer r103 = this.f409695e;
        DialogInterface.OnDismissListener r104 = this.f409696f;
        Log.i("AuditUtilsV2", "Show authorization failed dialog, msg = ".concat(r101));
        if ((r102 instanceof Activity) == false) goto L11;
        UDDialogBuilder r105 = new UDDialogBuilder(r102);
        if (r103 == null) goto L9;
        int r106 = r103.intValue();
    L10:
        r105.title(r106).message(r101).addActionButton(R.id.ud_dialog_btn_primary, R.string.Lark_Group_RevokeIKnow, null).onDismissListener(r104).show();
        return;
    L9:
        r106 = R.string.Lark_IM_NoPermissionToPreviewOrView_Title;
        goto L10
    L11:
        Log.i("AuditUtilsV2", "context is not Activity");
        return;
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
