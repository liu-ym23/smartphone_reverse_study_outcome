package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements td5.d {
    public Context a;
    public final String b;
    public final String c;
    public final int d;
    public final boolean e;
    public final SpaceSelectorBean f;
    public final ShareFolderUserPermission g;
    public td5.b h;
    public Disposable i;
    public com.bytedance.ee.bear.widgets.q j;
    public UDDialog k;

    public final void a() {
        UDDialog r0 = this.k;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L28;
        UDDialog r1 = this.k;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
    L21:
        this.k = null;
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
        if (r3 == null) goto L20;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r1);
        throw th;
    L9:
        if (Looper.myLooper() == r2.getLooper()) goto L11;
        r2.post(DialogLancet.createDismissRunnable(r1));
        goto L21
    }

    public final void b() {
        Disposable r0 = this.i;
        if (r0 == null) goto L8;
        if (r0.isDisposed() == true) goto L8;
        this.i.dispose();
    L8:
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L12;
        tt5.a.h("SpaceAddToSpaceCommand", "execute()...failed, offline");
        Context r1 = this.a;
        Toast.showFailureText(r1, r1.getString(2131887951));
        return;
    L12:
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.d)) == false) goto L16;
        Context r2 = this.a;
        Toast.showText(r2, r2.getString(2131887315));
        return;
    L16:
        if (this.g != null) goto L18;
    L22:
        tt5.a.h("SpaceAddToSpaceCommand", "execute()...has no permission.");
        Context r3 = this.a;
        Toast.showFailureText(r3, r3.getString(2131887803));
        return;
    L18:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.g, "MOVE_TO_HERE").booleanValue() == false) goto L22;
        this.j.e();
        NetService r4 = (NetService) org.koin.java.a.a(NetService.class);
        NetService.f r5 = new NetService.f("/api/explorer/object/archive/");
        HashMap r6 = new HashMap();
        r6.put(ResourceData.KEY_OBJ_TOKEN, this.f.b);
        r6.put("dest_token", this.b);
        ((NetService.e) r5).c = 1;
        r5.d(r6);
        this.i = r4.Vc(new i()).a(r5).subscribe(new j(this), new k(this));
    }

    @Override // td5.d
    public final void destroy() {
        Disposable r0 = this.i;
        if (r0 != null) goto L5;
    L7:
        this.a = null;
        this.h = null;
        this.j.a();
        this.j = null;
        a();
        return;
    L5:
        if (r0.isDisposed() == true) goto L7;
        this.i.dispose();
        goto L7
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("SpaceAddToSpaceCommand", "execute()...");
        AccountService.Account r0 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r0 != null) goto L5;
    L11:
        boolean r1 = false;
    L12:
        if (r1 == false) goto L18;
        a();
        Context r2 = this.a;
        String r3 = xo5.a.c(r2, 2131887908, "doc_type", t0.n(r2, this.f.a));
        fp5.a r4 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131888315)).message(r3)).messageGravity(8388611);
        r4.e = false;
        UDDialog r5 = ((fp5.a) ((fp5.a) r4.addActionButton(2131391777, 2131887719, new h(this))).addActionButton(2131391778, 2131887716, null)).build();
        this.k = r5;
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L17:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
        return;
    L18:
        b();
        return;
    L5:
        if (r0.isConsumer() == true) goto L11;
        if (this.e == false) goto L11;
        r1 = this.f.h;
        goto L12
    }

    public m(Context r1, String r2, String r3, int r4, boolean r5, ShareFolderUserPermission r6, Bundle r7, td5.b r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.g = r6;
        this.h = r8;
        this.f = (SpaceSelectorBean) r7.getParcelable("extra_space_bean");
        this.j = new com.bytedance.ee.bear.widgets.q(r1);
    }
}
