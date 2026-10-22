package com.ss.android.lark.forwardv3.utils;

import android.content.Context;
import android.content.DialogInterface;
import com.bytedance.lark.pb.im.v1.FilePermCheckBlockInfo;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f425569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FilePermCheckBlockInfo f425570b;

    public static final class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f425571a = null;

        static {
            f425571a = new a();
        }

        public a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            r100.dismiss();
        }
    }

    public c(Context r100, FilePermCheckBlockInfo r101) {
        this.f425569a = r100;
        this.f425570b = r101;
    }

    public final void a() {
        new UDDialogBuilder(this.f425569a).title(this.f425570b.popup_title).message(this.f425570b.popup_text).addActionButton(R.id.ud_dialog_btn_primary, this.f425570b.button, a.f425571a).show();
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
