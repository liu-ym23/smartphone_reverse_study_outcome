package tq5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class w implements td5.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f547177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f547178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ShareFolderUserPermission f547179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WikiSelectorBean f547180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f547181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f547182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f547183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f547184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f547185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f547186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final td5.b f547187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final WikiDialogs f547188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CompositeDisposable f547189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NetService f547190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f547191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f547192p;

    public class a extends com.bytedance.ee.bear.widgets.t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w f547193c;

        public a(w r100) {
            this.f547193c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            tt5.a.h("WikiMoveToSpaceCommand", "show move tips, click confirm.");
            this.f547193c.a();
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public b() {
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            tt5.a.h("WikiMoveToSpaceCommand", "show move tips, click cancel.");
        }
    }

    public final void a() {
        final String r100 = "";
        final boolean r101 = true;
        if (this.f547180d.f241143p.can_move == false) goto L12;
        tt5.a.h("WikiMoveToSpaceCommand", "moveSpace()...");
        Context r102 = this.f547177a;
        Toast.showLoading(r102, r102.getString(R.string.Doc_Wiki_MovePageMoving));
        this.f547191o = System.currentTimeMillis();
        if (this.f547183g == 4) goto L8;
        r101 = false;
    L8:
        if (r101 == true) goto L11;
        r100 = this.f547181e;
    L11:
        Disposable r103 = new MoveToSpacePuller(this.f547190n).d(new MoveToSpacePuller.Params(this.f547180d.f241131d, r100, r101)).flatMap(new o(this)).subscribe(new p(this, r100), new q(this));
        this.f547189m.add(r103);
        return;
    L12:
        tt5.a.h("WikiMoveToSpaceCommand", "applyMoveSpace()...");
        Context r104 = this.f547177a;
        Toast.showLoading(r104, r104.getString(R.string.Doc_Facade_Loading));
        if (this.f547183g == 4) goto L16;
        r101 = false;
    L16:
        if (r101 == true) goto L19;
        r100 = this.f547181e;
    L19:
        GetMoveNodeAuthorizedUserInfoPuller r105 = new GetMoveNodeAuthorizedUserInfoPuller(this.f547190n);
        WikiSelectorBean r106 = this.f547180d;
        Disposable r107 = r105.d(new GetMoveNodeAuthorizedUserInfoPuller.Params(r106.f241131d, r106.f241128a)).subscribe(new r(this, r100, r101), new s(this));
        this.f547189m.add(r107);
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMoveToSpaceCommand", "destroy()...");
        if (this.f547189m.isDisposed() == true) goto L5;
        this.f547189m.clear();
    L5:
        Toast.cancelLoading();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...");
        if (this.f547180d != null) goto L7;
        tt5.a.h("WikiMoveToSpaceCommand", "mWikiSelectorBean is null");
        return;
    L7:
        if (this.f547177a != null) goto L10;
        tt5.a.h("WikiMoveToSpaceCommand", "mContext is null");
        return;
    L10:
        ((ApplyMoveViewModel) new ViewModelProvider(this.f547178b).get(ApplyMoveViewModel.class)).getApplyState().observe(this.f547178b, new t(this));
        if (this.f547183g == 4) goto L17;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.f547184h)) == true) goto L17;
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...ownerType = " + this.f547184h);
        Context r100 = this.f547177a;
        Toast.showFailureText(r100, r100.getString(R.string.CreationMobile_ECM_UnableMoveDocToast), 0);
        return;
    L17:
        if (com.bytedance.ee.bear.contract.j.a.f217090a.getNetworkState().a() == true) goto L21;
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...failed, offline");
        Context r101 = this.f547177a;
        Toast.showFailureText(r101, r101.getString(R.string.Doc_List_OperateFailedNoNet), 0);
        return;
    L21:
        if (this.f547179c != null) goto L23;
    L45:
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...permission is null or deny");
        Context r102 = this.f547177a;
        Toast.showFailureText(r102, r102.getString(R.string.LarkCCM_Workspace_FolderPerm_CantMove_Tooltip));
        return;
    L23:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.f547179c, "MOVE_TO_HERE").booleanValue() == false) goto L45;
        String r103 = "";
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L40;
        WikiSelectorBean r104 = this.f547180d;
        if (r104 != null) goto L31;
    L32:
        boolean r105 = false;
    L34:
        if (r105 == true) goto L36;
        a();
        return;
    L36:
        if (r104.f241135h == false) goto L38;
        c(com.bytedance.ee.bear.list.move.api.a.a(this.f547182f, 0), "");
        return;
    L38:
        NetService r106 = (NetService) org.koin.java.a.a(NetService.class);
        WikiSelectorBean r107 = this.f547180d;
        String r108 = r107.f241136i;
        int r109 = r107.f241137j;
        this.f547189m.add(com.bytedance.ee.bear.list.move.api.a.b(r106, r108, Integer.valueOf(r109), false, this.f547181e, 0, this.f547182f).subscribe(new m(this), new n(this)));
        return;
    L31:
        if (this.f547183g == 4) goto L32;
        r105 = true;
        goto L34
    L40:
        String r110 = this.f547177a.getResources().getString(R.string.CreationMobile_Wiki_MoveToSpace_OnceRemoved_Permission);
        if (this.f547180d.f241135h == false) goto L43;
        r103 = this.f547177a.getResources().getString(R.string.CreationMobile_Wiki_MoveToSpace_MoveTips_NoticeSubpage);
    L43:
        c(r110, r103);
    }

    public final Flowable<MoveToSpaceStatusPuller.Result> b(final String r100, long r101) throws TimeoutException {
        if ((System.currentTimeMillis() - this.f547191o) <= 30000) goto L5;
        tt5.a.d("WikiMoveToSpaceCommand", "pollingMoveToSpaceStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r101, TimeUnit.MILLISECONDS).flatMap(new u(this, r100)).flatMap(new v(this, r100));
    }

    public final void c(String r100, String r101) {
        WikiDialogs r102 = this.f547188l;
        Context r103 = this.f547177a;
        a r104 = new a(this);
        b r105 = new b();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "message");
        Intrinsics.checkNotNullParameter(r101, "hint");
        Intrinsics.checkNotNullParameter(r104, "confirm");
        Intrinsics.checkNotNullParameter(r105, "cancel");
        r102.c();
        if (r103 == null) goto L8;
        fp5.a r106 = new fp5.a(r103).messageTextColor(R.color.text_title).messageGravity(GravityCompat.START).message(r100);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r101, "tips");
        r106.f478272c = r101;
        fp5.a r107 = r106.title(R.string.LarkCCM_Wiki_MovePage_ConfirmMove_Title).titleColor(R.color.text_title).titleBold(true).cancelOnTouchOutside(false).maskAlpha(0.3f).gravity(17);
        r107.f478274e = false;
        UDDialog r108 = r107.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).text(R.string.Doc_Facade_Confirm).onClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.r(r104)).textColorRes(R.color.primary_fill_default)).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_secondary).text(R.string.Doc_Wiki_Cancel).onClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.s(r105)).textColorRes(R.color.text_title)).build();
        r102.f242256g = r108;
        if (r108 == null) goto L9;
        WikiDialogs.b(r108);
        return;
    L9:
        return;
    }

    public w(Context r100, Fragment r101, ShareFolderUserPermission r102, String r103, String r104, int r105, int r106, boolean r107, int r110, Bundle r111, td5.b r112, ce5.a r113) {
        this.f547182f = "";
        this.f547188l = new WikiDialogs();
        this.f547189m = new CompositeDisposable();
        this.f547177a = r100;
        this.f547178b = r101;
        this.f547179c = r102;
        this.f547181e = r103;
        this.f547183g = r105;
        this.f547182f = r104;
        this.f547184h = r106;
        this.f547185i = r107;
        this.f547186j = r110;
        this.f547187k = r112;
        this.f547190n = r113.f23448c;
        this.f547180d = (WikiSelectorBean) r111.getParcelable("extra_wiki_bean");
        this.f547192p = r111.getBoolean("src_is_from_folderblock");
    }
}
