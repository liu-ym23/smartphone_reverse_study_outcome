package com.ss.android.lark.share_group;

import android.content.Context;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.dialog.loadingdialog.LoadingDialog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class RecallGroupChatterView implements IView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecallChatterAdapter f440513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LoadingDialog f440514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f440515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f440516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.share_group.a f440517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j> f440518f;

    @BindView(10958)
    public RecyclerView mRecallChatterRV;

    @BindView(10963)
    public CommonTitleBar mRecallTitleBar;

    public interface a {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        this.f440517e = null;
        this.f440516d = null;
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        ButterKnife.bind(this, ((RecallGroupChatterActivity.a) this.f440516d).f440511a);
        if (this.f440517e.W4() == false) goto L5;
        this.mRecallTitleBar.setTitle(UIHelper.getString(R.string.Lark_Groups_RevokeCircleInviteTitle));
    L5:
        LinearLayoutManager r100 = new LinearLayoutManager(this.f440515c, 1, false);
        this.mRecallChatterRV.setLayoutManager(r100);
        RecallChatterAdapter r101 = new RecallChatterAdapter(this.f440515c);
        this.f440513a = r101;
        this.mRecallChatterRV.setAdapter(r101);
        this.mRecallChatterRV.setItemAnimator(null);
        RecallChatterAdapter r102 = this.f440513a;
        r102.f440506b = new h(this);
    }

    public final void h(String r100) {
        com.larksuite.component.ui.dialog.d r101 = new com.larksuite.component.ui.dialog.d(this.f440515c);
        r101.h(r100);
        r101.f284132c.messageGravity(GravityCompat.START);
        r101.f284132c.maskAlpha(0.3f);
        r101.a(R.id.lkui_dialog_btn_left, R.string.Lark_Group_RevokeIKnow, new r0c.g());
        r101.i();
    }

    public final void s6(boolean r100) {
        if (this.f440514b != null) goto L16;
        LoadingDialog r101 = new LoadingDialog(this.f440515c);
        r101.c(LoadingDialog.Style.SPIN_INDETERMINATE);
        LoadingDialog.b r102 = r101.f445780a;
        r102.f445800m = 28;
        r102.f445801n = 28;
        if (r102.f445795h == null) goto L7;
        r102.c();
    L7:
        String r103 = this.f440515c.getString(R.string.Lark_Legacy_Loading);
        LoadingDialog.b r104 = r101.f445780a;
        r104.f445793f = r103;
        TextView r105 = r104.f445791d;
        if (r105 == null) goto L12;
        if (r103 == null) goto L11;
        r105.setText(r103);
        r104.f445791d.setVisibility(0);
        goto L12
    L11:
        r105.setVisibility(8);
    L12:
        r101.f445780a.a(14.0f);
        LoadingDialog.b r106 = r101.f445780a;
        r106.f445797j = 120;
        r106.f445798k = 120;
        if (r106.f445796i == null) goto L15;
        r106.b();
    L15:
        r101.f445783d = 5.0f;
        r101.f445785f = 2;
        r101.f445782c = UIUtils.getColor(this.f440515c, R.color.loading_dialog_background_color);
        r101.f445781b = 0.0f;
        this.f440514b = r101;
    L16:
        if (r100 == true) goto L18;
    L20:
        if (r100 == true) goto L24;
        this.f440514b.a();
        return;
    L24:
        return;
    L18:
        if (this.f440514b.b() == true) goto L20;
        this.f440514b.d();
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        this.f440517e = (com.ss.android.lark.share_group.a) r100;
    }

    public RecallGroupChatterView(Context r100, RecallGroupChatterActivity.a r101) {
        this.f440518f = new ArrayList();
        this.f440515c = r100;
        this.f440516d = r101;
    }
}
