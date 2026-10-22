package com.bytedance.ee.bear.tts.impl;

import android.content.DialogInterface;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ d b;

    public static final class a implements wfb.g {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void a(boolean r4) {
            tt5.a.h("TtsSession", "showPermissionDialog, permissionResult: " + r4 + ", isFloatViewWaitingPermission: " + this.a.o);
            d r0 = this.a;
            if (r0.b == false) goto L5;
            return;
        L5:
            if (r4 == false) goto L10;
            if (r0.o == false) goto L10;
            r0.h();
            return;
        L10:
            if (r0.l() == true) goto L17;
            this.a.getClass();
            if (d.s() == false) goto L14;
            tt5.a.h("TtsSession", "showPermissionDialogWithoutFloatPermission, deny permission");
            this.a.h();
            return;
        L14:
            tt5.a.h("TtsSession", "showPermissionDialog, request not granted, destroy session.");
            this.a.j();
            return;
        }
    }

    public f(FragmentActivity r1, d r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r2, int r3) {
        com.ss.android.lark.floating.b.b(this.a, new a(this.b));
    }
}
