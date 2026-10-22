package com.ss.android.bytedcert.web.v2.jsb.impl;

import android.content.DialogInterface;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.bytedcert.dialog.DialogHelper;
import com.ss.android.cert.manager.web.jsb.IBridgeContext;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f407953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IBridgeContext f407954b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f407955c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f407956d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ String f407957e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ String f407958f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ DialogJsb f407959g;

    /* JADX INFO: renamed from: com.ss.android.bytedcert.web.v2.jsb.impl.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC4720a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f407960a;

        public DialogInterfaceOnClickListenerC4720a(a r100) {
            this.f407960a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            a r102 = this.f407960a;
            DialogJsb.access$000(r102.f407959g, r102.f407954b, 1);
        }
    }

    public class b implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f407961a;

        public b(a r100) {
            this.f407961a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            a r102 = this.f407961a;
            DialogJsb.access$000(r102.f407959g, r102.f407954b, 2);
        }
    }

    public final void a() {
        int r100 = this.f407953a;
        if (r100 != 2) goto L5;
        DialogHelper.showJsbIdEmpDialog(this.f407954b.getActivity());
        return;
    L5:
        if (r100 != 0) goto L7;
    L8:
        if (r100 != 0) goto L10;
        String r101 = "";
    L11:
        String r102 = r101;
        DialogHelper.showAlertDialog(this.f407954b.getActivity(), this.f407956d, r102, this.f407957e, this.f407958f, new DialogInterfaceOnClickListenerC4720a(this), new b(this));
        return;
    L10:
        r101 = this.f407955c;
        goto L11
    L7:
        if (r100 == 1) goto L8;
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

    public a(DialogJsb r100, int r101, IBridgeContext r102, String r103, String r104, String r105, String r106) {
        this.f407959g = r100;
        this.f407953a = r101;
        this.f407954b = r102;
        this.f407955c = r103;
        this.f407956d = r104;
        this.f407957e = r105;
        this.f407958f = r106;
    }
}
