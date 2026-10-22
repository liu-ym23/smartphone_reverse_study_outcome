package tq5;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.selector.SelectorConfig;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeActivityContract;
import com.bytedance.ee.bear.wikiv2.wikitreev2.create.WikiCreateToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.WikiMovToFragment;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements td5.d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f547194k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f547195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WikiMovToFragment f547196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WikiTreeActivityContract f547197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WikiSelectorBean f547198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WikiSelectorBean f547199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectorConfig f547200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f547201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f547202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WikiDialogs f547203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public UDDialog f547204j;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f547205a;

        public b(x r100) {
            this.f547205a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Pair r101 = (Pair) r100;
            if (((Boolean) r101.getFirst()).booleanValue() == false) goto L5;
            this.f547205a.b((String) r101.getSecond());
            return;
        L5:
            this.f547205a.a();
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f547206a;

        public c(x r100) {
            this.f547206a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            int r101 = x.f547194k;
            tt5.a.e("WikiMoveToWikiCommand", "pullMoveNodeHint, err: ", (Throwable) r100, false);
            x r102 = this.f547206a;
            WikiSelectorBean r103 = r102.f547198d;
            String r104 = r103.f241134g;
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            r102.b(com.bytedance.ee.bear.list.move.api.a.a(r104, Integer.valueOf(r103.f241137j)));
        }
    }

    public static final class d implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f547207a;

        public d(x r100) {
            this.f547207a = r100;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r100, int r101) {
            this.f547207a.a();
        }
    }

    static {
    }

    public final void a() {
        WikiSelectorBean r100 = this.f547199e;
        boolean r101 = false;
        boolean r102 = true;
        if (r100 == null) goto L9;
        WikNodePerm r103 = r100.f241143p;
        if (r103 == null) goto L9;
        if (r103.can_move == true) goto L9;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L17;
        String r105 = this.f547198d.f241131d;
        if (this.f547195a == null) goto L77;
        if (r100 == null) goto L84;
        tt5.a.h("WikiMoveToWikiCommand", "applyMoveToWiki()...focusToken = " + du5.b.g(r105));
        Context r106 = this.f547195a;
        Toast.showLoading(r106, r106.getResources().getString(R.string.Doc_Facade_Loading));
        this.f547202h.add(new GetMoveNodeAuthorizedUserInfoPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new GetMoveNodeAuthorizedUserInfoPuller.Params(this.f547197c.getSrcToken(), this.f547197c.getSrcSpaceId())).subscribe(new y(this, r100, r105), new z(this, r100)));
        return;
    L84:
        return;
    L77:
        return;
    L17:
        SelectorConfig r107 = this.f547200f;
        if (r107 != null) goto L20;
    L22:
        boolean r108 = false;
    L23:
        if (r108 == true) goto L71;
        if (r107 != null) goto L26;
    L28:
        r102 = false;
    L29:
        if (r102 == true) goto L71;
        tt5.a.h("WikiMoveToWikiCommand", "doMove()...wikiSelectorBean is null.");
        WikiMovToFragment r109 = this.f547196b;
        String r110 = this.f547198d.f241131d;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "focusToken");
        tt5.a.h("Wiki_WikiMovToFragment", "setResultThenFinish()...focusToken = " + du5.b.g(r110));
        WikiCreateToFragment.aa0(r109, Integer.valueOf(r109.Y90().getSrcObjType()));
        Bundle r111 = r109.getArguments();
        if (r111 == null) goto L34;
        r101 = r111.getBoolean("src_is_from_folderblock");
    L34:
        Intent r112 = new Intent();
        WikiTreeActivityContract r113 = r109.Y90();
        String r114 = "";
        if (r113 == null) goto L38;
        String r115 = r113.getSrcToken();
        if (r115 == null) goto L38;
    L39:
        r112.putExtra("src_token", r115);
        WikiTreeActivityContract r116 = r109.Y90();
        if (r116 == null) goto L43;
        String r117 = r116.getSrcParentToken();
        if (r117 == null) goto L43;
    L44:
        r112.putExtra("src_parent_token", r117);
        WikiTreeActivityContract r118 = r109.Y90();
        if (r118 == null) goto L48;
        String r119 = r118.getSrcSpaceId();
        if (r119 == null) goto L48;
    L49:
        r112.putExtra("src_space_id", r119);
        WikiTreeActivityContract r120 = r109.Y90();
        if (r120 == null) goto L53;
        String r121 = r120.getSpaceId();
        if (r121 == null) goto L53;
    L54:
        r112.putExtra(DocViewModel.EXTRA_SPACE_ID, r121);
        r112.putExtra("dest_token", r110);
        WikiTreeActivityContract r122 = r109.Y90();
        if (r122 == null) goto L60;
        String r123 = r122.getDocumentName();
        if (r123 == null) goto L60;
        r114 = r123;
    L60:
        r112.putExtra("space_name", r114);
        r112.putExtra("src_is_from_folderblock", r101);
        if (ForsetiHelper.s(r109) == false) goto L68;
        com.suite.lark.component.navroute.forseti.g r124 = com.suite.lark.component.navroute.forseti.f.b(r109);
        if (r124 == null) goto L79;
        Bundle r125 = r112.getExtras();
        if (r125 != null) goto L67;
        r125 = new Bundle();
    L67:
        r124.c(-1, r125);
        return;
    L79:
        return;
    L68:
        FragmentActivity r126 = r109.getActivity();
        if (r126 == null) goto L81;
        r126.setResult(-1, r112);
        r126.finish();
        return;
    L81:
        return;
    L53:
        r121 = "";
    L48:
        r119 = "";
    L43:
        r117 = "";
    L38:
        r115 = "";
        goto L39
    L26:
        if (r107.f229375g != 1031) goto L28;
    L71:
        String r127 = this.f547198d.f241131d;
        if (this.f547195a == null) goto L83;
        if (r100 == null) goto L85;
        tt5.a.h("WikiMoveToWikiCommand", "moveToWiki()...focusToken = " + du5.b.g(r127));
        Context r128 = this.f547195a;
        Toast.showLoading(r128, r128.getResources().getString(R.string.Doc_Facade_Loading));
        this.f547202h.add(new MoveNodePuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).d(new MoveNodePuller.Params(r100.f241128a, r100.f241133f, this.f547197c.getSpaceId(), r127, r100.f241131d, "")).subscribe(new a0(this, r100, r127), new b0(this)));
        return;
    L85:
        return;
    L83:
        return;
    L20:
        if (r107.f229375g != 1029) goto L22;
        r108 = true;
    L9:
        r104 = false;
        goto L11
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMoveToWikiCommand", "destroy()...");
        if (this.f547202h.isDisposed() == true) goto L6;
        this.f547202h.clear();
        return;
    }

    @Override // td5.d
    public final void execute() {
        WikiSelectorBean r100 = this.f547199e;
        boolean r101 = false;
        if (r100 != null) goto L6;
    L12:
        boolean r102 = false;
    L14:
        if (r102 == true) goto L16;
    L48:
        a();
        return;
    L16:
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L48;
        WikiSelectorBean r103 = this.f547199e;
        if (r103 != null) goto L20;
    L22:
        String r104 = "";
        if (r101 == false) goto L29;
        WikiSelectorBean r105 = this.f547198d;
        String r106 = r105.f241134g;
        if (r106 == null) goto L28;
        r104 = r106;
    L28:
        b(com.bytedance.ee.bear.list.move.api.a.a(r104, Integer.valueOf(r105.f241137j)));
        return;
    L29:
        Integer r107 = null;
        NetService r108 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        WikiSelectorBean r109 = this.f547199e;
        if (r109 == null) goto L32;
        String r110 = r109.f241136i;
    L33:
        if (r109 == null) goto L35;
        r107 = Integer.valueOf(r109.f241137j);
    L35:
        Integer r111 = r107;
        boolean r112 = this.f547201g;
        if (r112 == false) goto L38;
        String r113 = this.f547198d.f241131d;
    L39:
        String r114 = r113;
        if (r112 == false) goto L42;
        int r115 = 23;
    L43:
        Integer r116 = Integer.valueOf(r115);
        String r117 = this.f547198d.f241134g;
        if (r117 != null) goto L46;
        String r118 = "";
    L47:
        this.f547202h.add(com.bytedance.ee.bear.list.move.api.a.b(r108, r110, r111, false, r114, r116, r118).subscribe(new b(this), new c(this)));
        return;
    L46:
        r118 = r117;
        goto L47
    L42:
        r115 = this.f547198d.f241137j;
        goto L43
    L38:
        r113 = this.f547198d.f241136i;
        goto L39
    L32:
        r110 = null;
        goto L33
    L20:
        if (r103.f241135h != true) goto L22;
        r101 = true;
        goto L22
    L6:
        if (r100.f241139l == true) goto L12;
        if (this.f547198d.f241141n == true) goto L11;
    L13:
        r102 = true;
        goto L14
    L11:
        if (this.f547201g == false) goto L13;
        goto L12
    }

    public final Context getContext() {
        return this.f547195a;
    }

    public final void b(String r100) {
        if (this.f547195a != null) goto L5;
        return;
    L5:
        UDDialog r101 = this.f547204j;
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (true != r101.isShowing()) goto L10;
    L12:
        if (r102 == false) goto L33;
        UDDialog r103 = this.f547204j;
        if (r103 == null) goto L32;
        Handler r104 = DialogLancet.resolveDialogHandler(r103);
        if (r104 != null) goto L18;
    L20:
        DialogLancet.beforeDialogDismiss(r103);
        r103.dismiss();     // Catch: Throwable -> L23 Exception -> L25
    L29:
        DialogLancet.afterDialogDismiss(r103);
        goto L32
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r105 == null) goto L29;
        com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r103);
        throw th;
    L18:
        if (Looper.myLooper() == r104.getLooper()) goto L20;
        r104.post(DialogLancet.createDismissRunnable(r103));
    L32:
        this.f547204j = null;
    L33:
        fp5.a r106 = new fp5.a(this.f547195a).title(R.string.LarkCCM_Workspace_MoveConfirm_Title_Mob).message(r100).messageGravity(GravityCompat.START);
        r106.f478274e = false;
        UDDialog r107 = r106.addActionButton(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_Confirm, new d(this)).addActionButton(R.id.ud_dialog_btn_secondary, R.string.Doc_Facade_Cancel, null).build();
        this.f547204j = r107;
        if (r107 != null) goto L36;
        return;
    L36:
        if (DialogLancet.shouldBlockDialogShow(r107) == false) goto L42;
        DialogLancet.handleBlockedDialogShow(r107);
        return;
    L42:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L41
    L39:
        DialogLancet.beforeDialogShow(r107);
        r107.show();
        DialogLancet.afterDialogShow(r107);
        return;
    L10:
        r102 = false;
        goto L12
    }

    public x(Context r100, WikiMovToFragment r101, WikiTreeActivityContract r102, WikiSelectorBean r103, WikiSelectorBean r104, SelectorConfig r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r101, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r102, "contract");
        Intrinsics.checkNotNullParameter(r103, "destWikiSelectorBean");
        this.f547195a = r100;
        this.f547196b = r101;
        this.f547197c = r102;
        this.f547198d = r103;
        this.f547199e = r104;
        this.f547200f = r105;
        this.f547201g = r106;
        this.f547202h = new CompositeDisposable();
        this.f547203i = new WikiDialogs();
    }
}
