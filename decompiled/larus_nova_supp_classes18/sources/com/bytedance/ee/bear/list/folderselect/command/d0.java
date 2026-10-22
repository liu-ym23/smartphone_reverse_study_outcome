package com.bytedance.ee.bear.list.folderselect.command;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.list.move.GetMoveReviewerInfoPuller$Params;
import com.bytedance.ee.bear.list.selector.SpaceSelectorBean;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements td5.d {
    public Context a;
    public final Fragment b;
    public final String c;
    public final String d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final ShareFolderUserPermission i;
    public final SpaceSelectorBean j;
    public td5.b k;
    public com.bytedance.ee.bear.widgets.q l;
    public UDDialog m;
    public final CompositeDisposable n;

    public final void a() {
        UDDialog r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() == false) goto L28;
        UDDialog r1 = this.m;
        Handler r2 = DialogLancet.resolveDialogHandler(r1);
        if (r2 != null) goto L9;
    L11:
        DialogLancet.beforeDialogDismiss(r1);
        r1.dismiss();     // Catch: Throwable -> L14 Exception -> L16
    L20:
        DialogLancet.afterDialogDismiss(r1);
    L21:
        this.m = null;
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
        if (this.l != null) goto L5;
        this.l = new com.bytedance.ee.bear.widgets.q(this.a);
    L5:
        this.l.e();
        NetService r0 = (NetService) org.koin.java.a.a(NetService.class);
        HashMap r1 = new HashMap();
        r1.put("src_token", this.j.d);
        r1.put("dest_token", this.c);
        if (this.j.g == false) goto L8;
        String r2 = "/space/api/explorer/v2/move/";
    L9:
        NetService.f r3 = new NetService.f(r2);
        ((NetService.e) r3).c = 1;
        r3.d(r1);
        Disposable r4 = r0.Vc(new x()).a(r3).subscribe(new y(this), new z(this));
        this.n.add(r4);
        return;
    L8:
        r2 = "/space/api/explorer/move/";
        goto L9
    }

    public final void c() {
        tt5.a.h("SpaceMoveToSpaceCommand", "sendRequest()...");
        boolean r2 = true;
        if ((!com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a()) == false) goto L7;
        tt5.a.h("SpaceMoveToSpaceCommand", "sendRequest()...failed, offline");
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887951));
        return;
    L7:
        if (this.j.g == false) goto L13;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.f)) == true) goto L13;
        Context r1 = this.a;
        Toast.showText(r1, r1.getString(2131887318));
        return;
    L13:
        if (this.j.g == true) goto L23;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.f)) == false) goto L23;
        if (this.j.a == sbb.e.f.b) goto L19;
    L20:
        Context r3 = this.a;
        Toast.showText(r3, r3.getString(2131887319));
        return;
    L19:
        if (this.e != 4) goto L20;
    L23:
        if (this.n.isDisposed() == true) goto L25;
        this.n.clear();
    L25:
        Toast.cancelLoading();
        SpaceSelectorBean r4 = this.j;
        if (r4.g == true) goto L28;
    L30:
        r2 = false;
    L31:
        if (r2 == true) goto L33;
        b();
        return;
    L33:
        if (this.a == null) goto L37;
        tt5.a.h("SpaceMoveToSpaceCommand", "applyMoveToSpace...destToken = " + du5.b.g(this.c));
        Context r5 = this.a;
        Toast.showLoading(r5, r5.getResources().getString(2131887769));
        NetService r6 = (NetService) org.koin.java.a.a(NetService.class);
        GetMoveReviewerInfoPuller$Params r7 = new GetMoveReviewerInfoPuller$Params(this.j.d, "", -1, this.c);
        NetService.f r8 = new NetService.f("/space/api/explorer/v2/move_reviewer/");
        ((NetService.e) r8).c = 2;
        r8.b("src_token", r7.src_token);
        r8.b("src_obj_token", r7.src_obj_token);
        r8.b("src_obj_type", String.valueOf(r7.src_obj_type));
        r8.b("dest_token", r7.dest_token);
        this.n.add(r6.Vc(new com.bytedance.ee.bear.list.move.d()).a(r8).map(new com.bytedance.ee.bear.list.move.c()).subscribe(new s(this), new u(this)));
        return;
    L37:
        return;
    L28:
        if (r4.j == true) goto L30;
        goto L30
    }

    @Override // td5.d
    public final void destroy() {
        if (this.n.isDisposed() == true) goto L5;
        this.n.clear();
    L5:
        Toast.cancelLoading();
        this.a = null;
        this.k = null;
        com.bytedance.ee.bear.widgets.q r1 = this.l;
        if (r1 == null) goto L8;
        r1.a();
        this.l = null;
    L8:
        a();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("SpaceMoveToSpaceCommand", "execute()...");
        if (this.j != null) goto L6;
        tt5.a.d("SpaceMoveToSpaceCommand", "execute()...spaceSelectorBean is null.");
        return;
    L6:
        ((ApplyMoveViewModel) new ViewModelProvider(this.b).get(ApplyMoveViewModel.class)).getApplyState().observe(this.b, new b0(this));
        if (this.i != null) goto L9;
    L84:
        tt5.a.h("SpaceMoveToSpaceCommand", "sendRequest()...has no permission.");
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131889874));
        return;
    L9:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.i, "MOVE_TO_HERE").booleanValue() == false) goto L84;
        boolean r2 = true;
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L44;
        SpaceSelectorBean r1 = this.j;
        if (r1 != null) goto L17;
    L32:
        boolean r3 = false;
    L34:
        if (r3 == false) goto L43;
        SpaceSelectorBean r4 = this.j;
        if (r4 != null) goto L38;
        tt5.a.k("SpaceMoveToSpaceCommand", "spaceSelectorBean is null");
        return;
    L38:
        String r5 = r4.b;
        int r6 = r4.a;
        if (r6 != 0) goto L41;
        boolean r7 = true;
    L42:
        Disposable r8 = com.bytedance.ee.bear.list.move.api.a.b((NetService) org.koin.java.a.a(NetService.class), r5, Integer.valueOf(r6), r7, this.c, Integer.valueOf(this.e), this.d).subscribe(new v(this), new w(this));
        this.n.add(r8);
        return;
    L41:
        r7 = false;
        goto L42
    L43:
        c();
        return;
    L17:
        if (r1.j == true) goto L32;
        if (TextUtils.isEmpty(this.c) == false) goto L25;
        if (this.h == false) goto L32;
    L25:
        if (TextUtils.isEmpty(this.c) == false) goto L27;
    L33:
        r3 = true;
        goto L34
    L27:
        if (this.h == true) goto L33;
        if (TextUtils.isEmpty(this.j.c) == true) goto L33;
        if (this.j.l == true) goto L33;
    L44:
        AccountService.Account r9 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.a(com.bytedance.ee.bear.contract.h0.class)).G2();
        if (r9 != null) goto L47;
    L59:
        boolean r10 = false;
    L60:
        if (r10 == false) goto L72;
        a();
        Context r11 = this.a;
        String r12 = xo5.a.c(r11, 2131887277, ResourceData.KEY_TYPE, t0.n(r11, this.j.a));
        fp5.a r13 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131887278)).message(r12)).messageGravity(8388611);
        SpaceSelectorBean r14 = this.j;
        if (r14.i == false) goto L64;
    L66:
        String r15 = "";
    L67:
        r13.b(r15);
        r13.e = false;
        UDDialog r16 = ((fp5.a) ((fp5.a) r13.addActionButton(2131391777, 2131887719, new a0(this))).addActionButton(2131391778, 2131887716, null)).build();
        this.m = r16;
        if (DialogLancet.shouldBlockDialogShow(r16) == false) goto L87;
        DialogLancet.handleBlockedDialogShow(r16);
        return;
    L87:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L86
    L71:
        DialogLancet.beforeDialogShow(r16);
        r16.show();
        DialogLancet.afterDialogShow(r16);
        return;
    L64:
        if (r14.j == true) goto L66;
        r15 = this.a.getString(2131889889);
        goto L67
    L72:
        SpaceSelectorBean r17 = this.j;
        if (r17.g == true) goto L75;
    L79:
        r2 = false;
    L80:
        if (r2 == false) goto L82;
        d(this.a.getResources().getString(2131889888));
        return;
    L82:
        c();
        return;
    L75:
        if (this.h == true) goto L80;
        if (r17.k == false) goto L79;
    L47:
        if (r9.isConsumer() == true) goto L59;
        if (this.g == false) goto L59;
        SpaceSelectorBean r18 = this.j;
        if (r18.g == false) goto L55;
    L58:
        r10 = true;
        goto L60
    L55:
        if (r18.a == sbb.e.f.b) goto L58;
        r10 = r18.h;
        goto L60
    }

    public final void d(String r4) {
        a();
        fp5.a r5 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131889891)).message(r4)).messageGravity(8388611);
        SpaceSelectorBean r0 = this.j;
        if (r0.i == false) goto L5;
    L7:
        String r1 = "";
    L8:
        r5.b(r1);
        r5.e = false;
        UDDialog r6 = ((fp5.a) ((fp5.a) r5.addActionButton(2131391777, 2131887719, new c0(this))).addActionButton(2131391778, 2131887716, null)).build();
        this.m = r6;
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L15;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L15:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L14
    L12:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L5:
        if (r0.j == true) goto L7;
        r1 = this.a.getString(2131889889);
        goto L8
    }

    public d0(Context r2, Fragment r3, String r4, String r5, int r6, int r7, boolean r8, boolean r9, ShareFolderUserPermission r10, Bundle r11, td5.b r12) {
        this.n = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
        this.k = r12;
        this.j = (SpaceSelectorBean) r11.getParcelable("extra_space_bean");
    }
}
