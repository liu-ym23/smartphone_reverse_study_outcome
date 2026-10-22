package tq5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x implements td5.d {
    public static final /* synthetic */ int k = 0;
    public final Context a;
    public final WikiMovToFragment b;
    public final WikiTreeActivityContract c;
    public final WikiSelectorBean d;
    public final WikiSelectorBean e;
    public final SelectorConfig f;
    public final boolean g;
    public final CompositeDisposable h;
    public final WikiDialogs i;
    public UDDialog j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ x a;

        public b(x r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Pair r3 = (Pair) r2;
            if (((Boolean) r3.getFirst()).booleanValue() == false) goto L5;
            this.a.b((String) r3.getSecond());
            return;
        L5:
            this.a.a();
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ x a;

        public c(x r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            int r0 = x.k;
            tt5.a.e("WikiMoveToWikiCommand", "pullMoveNodeHint, err: ", (Throwable) r4, false);
            x r5 = this.a;
            WikiSelectorBean r1 = r5.d;
            String r2 = r1.g;
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r5.b(com.bytedance.ee.bear.list.move.api.a.a(r2, Integer.valueOf(r1.j)));
        }
    }

    public static final class d implements DialogInterface.OnClickListener {
        public final /* synthetic */ x a;

        public d(x r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            this.a.a();
        }
    }

    static {
    }

    public final void a() {
        WikiSelectorBean r0 = this.e;
        boolean r1 = false;
        boolean r2 = true;
        if (r0 == null) goto L9;
        WikNodePerm r3 = r0.p;
        if (r3 == null) goto L9;
        if (r3.can_move == true) goto L9;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L17;
        String r5 = this.d.d;
        if (this.a == null) goto L77;
        if (r0 == null) goto L84;
        tt5.a.h("WikiMoveToWikiCommand", "applyMoveToWiki()...focusToken = " + du5.b.g(r5));
        Context r6 = this.a;
        Toast.showLoading(r6, r6.getResources().getString(2131887769));
        this.h.add(new GetMoveNodeAuthorizedUserInfoPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetMoveNodeAuthorizedUserInfoPuller.Params(this.c.getSrcToken(), this.c.getSrcSpaceId())).subscribe(new y(this, r0, r5), new z(this, r0)));
        return;
    L84:
        return;
    L77:
        return;
    L17:
        SelectorConfig r7 = this.f;
        if (r7 != null) goto L20;
    L22:
        boolean r8 = false;
    L23:
        if (r8 == true) goto L71;
        if (r7 != null) goto L26;
    L28:
        r2 = false;
    L29:
        if (r2 == true) goto L71;
        tt5.a.h("WikiMoveToWikiCommand", "doMove()...wikiSelectorBean is null.");
        WikiMovToFragment r9 = this.b;
        String r10 = this.d.d;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "focusToken");
        tt5.a.h("Wiki_WikiMovToFragment", "setResultThenFinish()...focusToken = " + du5.b.g(r10));
        WikiCreateToFragment.aa0(r9, Integer.valueOf(r9.Y90().getSrcObjType()));
        Bundle r11 = r9.getArguments();
        if (r11 == null) goto L34;
        r1 = r11.getBoolean("src_is_from_folderblock");
    L34:
        Intent r12 = new Intent();
        WikiTreeActivityContract r13 = r9.Y90();
        String r14 = "";
        if (r13 == null) goto L38;
        String r15 = r13.getSrcToken();
        if (r15 == null) goto L38;
    L39:
        r12.putExtra("src_token", r15);
        WikiTreeActivityContract r16 = r9.Y90();
        if (r16 == null) goto L43;
        String r17 = r16.getSrcParentToken();
        if (r17 == null) goto L43;
    L44:
        r12.putExtra("src_parent_token", r17);
        WikiTreeActivityContract r18 = r9.Y90();
        if (r18 == null) goto L48;
        String r19 = r18.getSrcSpaceId();
        if (r19 == null) goto L48;
    L49:
        r12.putExtra("src_space_id", r19);
        WikiTreeActivityContract r20 = r9.Y90();
        if (r20 == null) goto L53;
        String r21 = r20.getSpaceId();
        if (r21 == null) goto L53;
    L54:
        r12.putExtra("space_id", r21);
        r12.putExtra("dest_token", r10);
        WikiTreeActivityContract r22 = r9.Y90();
        if (r22 == null) goto L60;
        String r23 = r22.getDocumentName();
        if (r23 == null) goto L60;
        r14 = r23;
    L60:
        r12.putExtra("space_name", r14);
        r12.putExtra("src_is_from_folderblock", r1);
        if (ForsetiHelper.s(r9) == false) goto L68;
        com.suite.lark.component.navroute.forseti.g r24 = com.suite.lark.component.navroute.forseti.f.b(r9);
        if (r24 == null) goto L79;
        Bundle r25 = r12.getExtras();
        if (r25 != null) goto L67;
        r25 = new Bundle();
    L67:
        r24.c(-1, r25);
        return;
    L79:
        return;
    L68:
        FragmentActivity r26 = r9.getActivity();
        if (r26 == null) goto L81;
        r26.setResult(-1, r12);
        r26.finish();
        return;
    L81:
        return;
    L53:
        r21 = "";
    L48:
        r19 = "";
    L43:
        r17 = "";
    L38:
        r15 = "";
        goto L39
    L26:
        if (r7.g != 1031) goto L28;
    L71:
        String r27 = this.d.d;
        if (this.a == null) goto L83;
        if (r0 == null) goto L85;
        tt5.a.h("WikiMoveToWikiCommand", "moveToWiki()...focusToken = " + du5.b.g(r27));
        Context r28 = this.a;
        Toast.showLoading(r28, r28.getResources().getString(2131887769));
        this.h.add(new MoveNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new MoveNodePuller.Params(r0.a, r0.f, this.c.getSpaceId(), r27, r0.d, "")).subscribe(new a0(this, r0, r27), new b0(this)));
        return;
    L85:
        return;
    L83:
        return;
    L20:
        if (r7.g != 1029) goto L22;
        r8 = true;
    L9:
        r4 = false;
        goto L11
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMoveToWikiCommand", "destroy()...");
        if (this.h.isDisposed() == true) goto L6;
        this.h.clear();
        return;
    }

    @Override // td5.d
    public final void execute() {
        WikiSelectorBean r0 = this.e;
        boolean r1 = false;
        if (r0 != null) goto L6;
    L12:
        boolean r2 = false;
    L14:
        if (r2 == true) goto L16;
    L48:
        a();
        return;
    L16:
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L48;
        WikiSelectorBean r3 = this.e;
        if (r3 != null) goto L20;
    L22:
        String r4 = "";
        if (r1 == false) goto L29;
        WikiSelectorBean r5 = this.d;
        String r6 = r5.g;
        if (r6 == null) goto L28;
        r4 = r6;
    L28:
        b(com.bytedance.ee.bear.list.move.api.a.a(r4, Integer.valueOf(r5.j)));
        return;
    L29:
        Integer r7 = null;
        NetService r8 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        WikiSelectorBean r9 = this.e;
        if (r9 == null) goto L32;
        String r10 = r9.i;
    L33:
        if (r9 == null) goto L35;
        r7 = Integer.valueOf(r9.j);
    L35:
        Integer r11 = r7;
        boolean r12 = this.g;
        if (r12 == false) goto L38;
        String r13 = this.d.d;
    L39:
        String r14 = r13;
        if (r12 == false) goto L42;
        int r15 = 23;
    L43:
        Integer r16 = Integer.valueOf(r15);
        String r17 = this.d.g;
        if (r17 != null) goto L46;
        String r18 = "";
    L47:
        this.h.add(com.bytedance.ee.bear.list.move.api.a.b(r8, r10, r11, false, r14, r16, r18).subscribe(new b(this), new c(this)));
        return;
    L46:
        r18 = r17;
        goto L47
    L42:
        r15 = this.d.j;
        goto L43
    L38:
        r13 = this.d.i;
        goto L39
    L32:
        r10 = null;
        goto L33
    L20:
        if (r3.h != true) goto L22;
        r1 = true;
        goto L22
    L6:
        if (r0.l == true) goto L12;
        if (this.d.n == true) goto L11;
    L13:
        r2 = true;
        goto L14
    L11:
        if (this.g == false) goto L13;
        goto L12
    }

    public final Context getContext() {
        return this.a;
    }

    public final void b(String r7) {
        if (this.a != null) goto L5;
        return;
    L5:
        UDDialog r0 = this.j;
        if (r0 == null) goto L10;
        boolean r2 = true;
        if (true != r0.isShowing()) goto L10;
    L12:
        if (r2 == false) goto L33;
        UDDialog r3 = this.j;
        if (r3 == null) goto L32;
        Handler r4 = DialogLancet.resolveDialogHandler(r3);
        if (r4 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r3);
        goto L32
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r5 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r5 == null) goto L29;
        com.bytedance.crash.d.d(r5, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L18:
        if (Looper.myLooper() == r4.getLooper()) goto L20;
        r4.post(DialogLancet.createDismissRunnable(r3));
    L32:
        this.j = null;
    L33:
        fp5.a r8 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(this.a).title(2131889891)).message(r7)).messageGravity(8388611);
        r8.e = false;
        UDDialog r9 = ((fp5.a) ((fp5.a) r8.addActionButton(2131391777, 2131887719, new d(this))).addActionButton(2131391778, 2131887716, null)).build();
        this.j = r9;
        if (r9 != null) goto L36;
        return;
    L36:
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r9);
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L39:
        DialogLancet.beforeDialogShow(r9);
        r9.show();
        DialogLancet.afterDialogShow(r9);
        return;
    L10:
        r2 = false;
        goto L12
    }

    public x(Context r2, WikiMovToFragment r3, WikiTreeActivityContract r4, WikiSelectorBean r5, WikiSelectorBean r6, SelectorConfig r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "fragment");
        Intrinsics.checkNotNullParameter(r4, "contract");
        Intrinsics.checkNotNullParameter(r5, "destWikiSelectorBean");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = new CompositeDisposable();
        this.i = new WikiDialogs();
    }
}
