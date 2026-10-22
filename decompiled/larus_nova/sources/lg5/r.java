package lg5;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.AuthDocViewHolder;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class r extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AuthDocViewHolder f509169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ EmbededDocumentInfo.NodeInfo f509170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f509171e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        this.f509169c.f233102a.f();
        if (this.f509170d.isChat_has_permission() == false) goto L5;
        Toast.showFailureText(this.f509171e, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_NoPermRevoke);
        return;
    L5:
        BearUDDialogBuilder r101 = new BearUDDialogBuilder(this.f509171e);
        r101.f240192a.title(R.string.LarkCCM_EmbeddedFiles_NoPermissionToGrantAccess_Title);
        r101.f(this.f509171e.getString(R.string.CreationMobile_Docs_EmbeddedFiles_NoPermToGrant_Tooltip));
        r101.b(R.id.ud_dialog_btn_primary, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_ConfirmButton, R.color.primary_fill_default, null);
        r101.f240192a.style(R.style.ActionSheetDialogStyle);
        r101.h();
    }

    public r(AuthDocViewHolder r100, EmbededDocumentInfo.NodeInfo r101, Context r102) {
        this.f509169c = r100;
        this.f509170d = r101;
        this.f509171e = r102;
    }
}
