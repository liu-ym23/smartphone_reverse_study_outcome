package tq5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.list.move.ApplyMoveViewModel;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.selector.WikiSelectorBean;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpacePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.MoveToSpaceStatusPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.WikiDialogs;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w implements td5.d {
    public final Context a;
    public final Fragment b;
    public final ShareFolderUserPermission c;
    public final WikiSelectorBean d;
    public final String e;
    public final String f;
    public final int g;
    public final int h;
    public final boolean i;
    public final int j;
    public final td5.b k;
    public final WikiDialogs l;
    public final CompositeDisposable m;
    public final NetService n;
    public long o;
    public final boolean p;

    public class a extends com.bytedance.ee.bear.widgets.t {
        public final /* synthetic */ w c;

        public a(w r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            tt5.a.h("WikiMoveToSpaceCommand", "show move tips, click confirm.");
            this.c.a();
        }
    }

    public class b extends com.bytedance.ee.bear.widgets.t {
        public b() {
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            tt5.a.h("WikiMoveToSpaceCommand", "show move tips, click cancel.");
        }
    }

    public final void a() {
        final String r1 = "";
        final boolean r2 = true;
        if (this.d.p.can_move == false) goto L12;
        tt5.a.h("WikiMoveToSpaceCommand", "moveSpace()...");
        Context r0 = this.a;
        Toast.showLoading(r0, r0.getString(2131888333));
        this.o = System.currentTimeMillis();
        if (this.g == 4) goto L8;
        r2 = false;
    L8:
        if (r2 == true) goto L11;
        r1 = this.e;
    L11:
        Disposable r3 = new MoveToSpacePuller(this.n).d(new MoveToSpacePuller.Params(this.d.d, r1, r2)).flatMap(new o(this)).subscribe(new p(this, r1), new q(this));
        this.m.add(r3);
        return;
    L12:
        tt5.a.h("WikiMoveToSpaceCommand", "applyMoveSpace()...");
        Context r4 = this.a;
        Toast.showLoading(r4, r4.getString(2131887769));
        if (this.g == 4) goto L16;
        r2 = false;
    L16:
        if (r2 == true) goto L19;
        r1 = this.e;
    L19:
        GetMoveNodeAuthorizedUserInfoPuller r5 = new GetMoveNodeAuthorizedUserInfoPuller(this.n);
        WikiSelectorBean r6 = this.d;
        Disposable r7 = r5.d(new GetMoveNodeAuthorizedUserInfoPuller.Params(r6.d, r6.a)).subscribe(new r(this, r1, r2), new s(this));
        this.m.add(r7);
    }

    @Override // td5.d
    public final void destroy() {
        tt5.a.h("WikiMoveToSpaceCommand", "destroy()...");
        if (this.m.isDisposed() == true) goto L5;
        this.m.clear();
    L5:
        Toast.cancelLoading();
    }

    @Override // td5.d
    public final void execute() {
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...");
        if (this.d != null) goto L7;
        tt5.a.h("WikiMoveToSpaceCommand", "mWikiSelectorBean is null");
        return;
    L7:
        if (this.a != null) goto L10;
        tt5.a.h("WikiMoveToSpaceCommand", "mContext is null");
        return;
    L10:
        ((ApplyMoveViewModel) new ViewModelProvider(this.b).get(ApplyMoveViewModel.class)).getApplyState().observe(this.b, new t(this));
        if (this.g == 4) goto L17;
        if (FolderVersion.isShareFolderV2(Integer.valueOf(this.h)) == true) goto L17;
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...ownerType = " + this.h);
        Context r0 = this.a;
        Toast.showFailureText(r0, r0.getString(2131887318), 0);
        return;
    L17:
        if (com.bytedance.ee.bear.contract.j.a.a.getNetworkState().a() == true) goto L21;
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...failed, offline");
        Context r1 = this.a;
        Toast.showFailureText(r1, r1.getString(2131887951), 0);
        return;
    L21:
        if (this.c != null) goto L23;
    L45:
        tt5.a.h("WikiMoveToSpaceCommand", "execute()...permission is null or deny");
        Context r2 = this.a;
        Toast.showFailureText(r2, r2.getString(2131889874));
        return;
    L23:
        if (((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).u(this.c, "MOVE_TO_HERE").booleanValue() == false) goto L45;
        String r3 = "";
        if (idb.f.a().isCurrentEnable("ccm.permission.newdoc_default_link_move") == false) goto L40;
        WikiSelectorBean r4 = this.d;
        if (r4 != null) goto L31;
    L32:
        boolean r5 = false;
    L34:
        if (r5 == true) goto L36;
        a();
        return;
    L36:
        if (r4.h == false) goto L38;
        c(com.bytedance.ee.bear.list.move.api.a.a(this.f, 0), "");
        return;
    L38:
        NetService r6 = (NetService) org.koin.java.a.a(NetService.class);
        WikiSelectorBean r7 = this.d;
        String r8 = r7.i;
        int r9 = r7.j;
        this.m.add(com.bytedance.ee.bear.list.move.api.a.b(r6, r8, Integer.valueOf(r9), false, this.e, 0, this.f).subscribe(new m(this), new n(this)));
        return;
    L31:
        if (this.g == 4) goto L32;
        r5 = true;
        goto L34
    L40:
        String r10 = this.a.getResources().getString(2131887493);
        if (this.d.h == false) goto L43;
        r3 = this.a.getResources().getString(2131887489);
    L43:
        c(r10, r3);
    }

    public final Flowable<MoveToSpaceStatusPuller.Result> b(final String r6, long r7) throws TimeoutException {
        if ((System.currentTimeMillis() - this.o) <= 30000) goto L5;
        tt5.a.d("WikiMoveToSpaceCommand", "pollingMoveToSpaceStatus()...timeout!");
        throw new TimeoutException();
    L5:
        return Flowable.just(Boolean.TRUE).delay(r7, TimeUnit.MILLISECONDS).flatMap(new u(this, r6)).flatMap(new v(this, r6));
    }

    public final void c(String r7, String r8) {
        WikiDialogs r0 = this.l;
        Context r1 = this.a;
        a r2 = new a(this);
        b r3 = new b();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "message");
        Intrinsics.checkNotNullParameter(r8, "hint");
        Intrinsics.checkNotNullParameter(r2, "confirm");
        Intrinsics.checkNotNullParameter(r3, DocFeed$Value$Result.CANCEL);
        r0.c();
        if (r1 == null) goto L8;
        fp5.a r9 = (fp5.a) ((fp5.a) ((fp5.a) new fp5.a(r1).messageTextColor(2131106622)).messageGravity(8388611)).message(r7);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r8, "tips");
        r9.c = r8;
        fp5.a r10 = (fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) ((fp5.a) r9.title(2131889810)).titleColor(2131106622)).titleBold(true)).cancelOnTouchOutside(false)).maskAlpha(0.3f)).gravity(17);
        r10.e = false;
        UDDialog r11 = ((fp5.a) ((fp5.a) r10.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131887719).onClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.r(r2)).textColorRes(2131105548))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131888316).onClickListener(new com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.s(r3)).textColorRes(2131106622))).build();
        r0.g = r11;
        if (r11 == null) goto L9;
        WikiDialogs.b(r11);
        return;
    L9:
        return;
    }

    public w(Context r2, Fragment r3, ShareFolderUserPermission r4, String r5, String r6, int r7, int r8, boolean r9, int r10, Bundle r11, td5.b r12, ce5.a r13) {
        this.f = "";
        this.l = new WikiDialogs();
        this.m = new CompositeDisposable();
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        this.g = r7;
        this.f = r6;
        this.h = r8;
        this.i = r9;
        this.j = r10;
        this.k = r12;
        this.n = r13.c;
        this.d = (WikiSelectorBean) r11.getParcelable("extra_wiki_bean");
        this.p = r11.getBoolean("src_is_from_folderblock");
    }
}
