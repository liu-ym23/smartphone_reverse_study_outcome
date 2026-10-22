package rj5;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.k0;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.ErrorResponse;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import java.util.HashMap;

/* JADX INFO: loaded from: classes18.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f538073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.widgets.q f538074b;

    public class a implements com.bytedance.ee.bear.contract.c0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f538075a;

        @Override // com.bytedance.ee.bear.contract.c0.a
        public final void a() {
            tt5.a.b("DeleteItemCallbackV2", "deleteDoc: onPostExecuteSuccess");
            this.f538075a.f538074b.a();
            Context r100 = this.f538075a.f538073a;
            Toast.showSuccessText(r100, r100.getString(R.string.Doc_Facade_DeleteSuccessfully), 0);
        }

        @Override // com.bytedance.ee.bear.contract.c0.a
        public final void c() {
            tt5.a.b("DeleteItemCallbackV2", "deleteDoc: onPreExecute");
            this.f538075a.f538074b.e();
        }

        public a(g r100) {
            this.f538075a = r100;
        }

        @Override // com.bytedance.ee.bear.contract.c0.a
        public final void b(boolean r100) {
            tt5.a.h("DeleteItemCallbackV2", "deleteDoc: onOfflinePostExecute, success = " + r100);
            this.f538075a.f538074b.a();
            if (r100 == true) goto L6;
            g.a(this.f538075a, -1);
            return;
        }

        @Override // com.bytedance.ee.bear.contract.c0.a
        public final void d(int r100, Throwable r101, String r102, int r103) {
            tt5.a.h("DeleteItemCallbackV2", "deleteDoc: onPostExecuteFail");
            this.f538075a.f538074b.a();
            ((cj5.b) org.koin.java.a.a(cj5.b.class)).getConfig();
            boolean r104 = jg5.e.a.f499003a.g();
            if (r104 == false) goto L5;
            ErrorResponse r105 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).e(r102, Integer.valueOf(r103), "DELETE_ENTITY", r101);
        L6:
            if (r104 == false) goto L12;
            if (r105 == null) goto L12;
            if (r105.getHasHandledUiAction() == false) goto L12;
            r105.getCallback().a(this.f538075a.f538073a, r105);
            return;
        L12:
            if (r104 == true) goto L18;
            gj5.b r106 = (gj5.b) org.koin.java.a.a(gj5.b.class);
            if (r100 != 900099011) goto L18;
            ((gj5.b) org.koin.java.a.a(gj5.b.class)).c("CCM_MOVE_RECYCLE_BIN", FileBizDomain.FileBizDomainCCM, r103, r102);
            return;
        L18:
            if (r100 == 233525003) goto L20;
            g.a(this.f538075a, r100);
            return;
        L20:
            if ((this.f538075a.f538073a instanceof FragmentActivity) == true) goto L22;
            return;
        L22:
            if ((r101 instanceof NetService.ServerErrorException) == false) goto L27;
            String r107 = ((NetService.ServerErrorException) r101).getData();
            ((com.bytedance.ee.bear.contract.c0) org.koin.java.a.a(com.bytedance.ee.bear.contract.c0.class)).a0(((FragmentActivity) this.f538075a.f538073a).getSupportFragmentManager(), r107, r102, r103);
            return;
        L27:
            return;
        L5:
            r105 = null;
            goto L6
        }
    }

    public g(Activity r100) {
        this.f538073a = r100;
        this.f538074b = new com.bytedance.ee.bear.widgets.q(r100, 0);
    }

    public final void b(final oj5.c r110) {
        tt5.a.b("DeleteItemCallbackV2", "onItemClick: docInfoData = " + r110);
        com.bytedance.ee.bear.more.c.b(r110, "delete");
        if (r110 == null) goto L48;
        final a r100 = new a(this);
        HashMap r101 = new HashMap();
        if (TextUtils.isEmpty(r110.getTitle()) == false) goto L7;
        String r102 = ((rc5.a) org.koin.java.a.a(rc5.a.class)).getDocumentDefaultName(this.f538073a, r110.getType());
    L8:
        r101.put("filename", r102);
        if (LarkAppContext.inst().buildConfig().isOfficeSDK() == true) goto L11;
    L13:
        boolean r103 = false;
    L14:
        if (r103 == false) goto L16;
    L18:
        String r104 = "";
    L20:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("lark.scs.legalhold.delete") == false) goto L22;
        int r105 = 60;
    L23:
        String r106 = String.valueOf(r105);
        if (r103 == false) goto L26;
        String r107 = this.f538073a.getString(R.string.LarkCCM_Doubao_Drive_SingleDeleteConfirm_Title);
    L27:
        if (r103 == false) goto L29;
        String r108 = this.f538073a.getString(R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Desc);
    L30:
        fp5.a r109 = new fp5.a(this.f538073a).title(r107).titleSize(16).titleGravity(GravityCompat.START).message(r108).messageTextSize(14).messageGravity(GravityCompat.START);
        r109.b(r104);
        r109.f478274e = false;
        UDBaseDialogBuilder.ActionBuilder r111 = new UDBaseDialogBuilder.ActionBuilder().actionResId(R.id.ud_dialog_btn_primary).textColorRes(R.color.function_danger_fill_default);
        if (r103 == false) goto L33;
        int r112 = R.string.LarkCCM_Doubao_Drive_BatchDeleteConfirm_Button;
    L34:
        fp5.a r113 = r109.addActionButton(r111.text(r112).onClickListener(new f(this, r110, r100)));
        if (r103 == false) goto L37;
        int r114 = R.string.LarkCCM_Common_Cancel_Button;
    L38:
        UDDialog r115 = r113.addActionButton(R.id.ud_dialog_btn_secondary, r114, null).build();
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L46;
        DialogLancet.handleBlockedDialogShow(r115);
    L43:
        ((zo5.b) org.koin.java.a.a(zo5.b.class)).j(r110.getToken(), r110.getType(), r115);
        return;
    L46:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L45
    L42:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
        goto L43
    L37:
        r114 = R.string.Doc_Facade_Cancel;
        goto L38
    L33:
        r112 = R.string.Doc_Facade_Delete;
        goto L34
    L29:
        r108 = xo5.a.c(this.f538073a, R.string.LarkCCM_NewCM_DeletedItemsGoToTrash_DayVar_Desc, "num", r106);
        goto L30
    L26:
        r107 = xo5.a.d(this.f538073a, R.string.LarkCCM_NewCM_DeleteFilesOrNot_Title, r101);
        goto L27
    L22:
        r105 = 30;
        goto L23
    L16:
        if (r110.isOwner() == true) goto L18;
        r104 = this.f538073a.getResources().getString(R.string.LarkCCM_NewCM_DeleteDocsToTrash_PageOwnerNotifiedOnceDeleted_Desc);
        goto L20
    L11:
        if (DowngradeSettingUtil.a("downgradeNewDocDelete") == true) goto L13;
        r103 = true;
        goto L14
    L7:
        r102 = r110.getTitle();
        goto L8
    }

    public static void a(g r100, int r101) {
        r100.getClass();
        if (k0.b(r101) == false) goto L6;
        return;
    L6:
        if (r101 != 4202) goto L8;
        Toast.showFailureText(r100.f538073a.getApplicationContext(), R.string.CreationMobile_DataUpgrade_Locked_toast);
        return;
    L8:
        Toast.showFailureText(r100.f538073a.getApplicationContext(), r100.f538073a.getString(R.string.Doc_Facade_DeleteFailed), 0);
    }
}
