package ng5;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeResult;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.EmbededDocumentInfo;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.RecordAuthorizeRequest;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.livedata.SingeAuthorizeNode;
import com.bytedance.ee.bear.route.h;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import eu5.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import lg5.p;
import sbb.e;

/* JADX INFO: loaded from: classes18.dex */
public final class a {
    public static ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> c(p r100) {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r101 = new ArrayList();
        BatchAuthorizeResult r102 = r100.f509163a;
        if (r102 != null) goto L5;
    L11:
        BatchAuthorizeResult r103 = r100.f509164b;
        if (r103 != null) goto L14;
    L20:
        BatchAuthorizeResult r104 = r100.f509165c;
        if (r104 != null) goto L23;
    L29:
        BatchAuthorizeResult r105 = r100.f509166d;
        if (r105 != null) goto L32;
    L38:
        return r101;
    L32:
        if (r105.getBatchData() == null) goto L38;
        if (r105.getBatchData().getAuth_res_lists() == null) goto L38;
        if (r105.getBatchData().getAuth_res_lists().size() <= 0) goto L38;
        r101.addAll(r105.getBatchData().getAuth_res_lists());
        goto L38
    L23:
        if (r104.getBatchData() == null) goto L29;
        if (r104.getBatchData().getAuth_res_lists() == null) goto L29;
        if (r104.getBatchData().getAuth_res_lists().size() <= 0) goto L29;
        r101.addAll(r104.getBatchData().getAuth_res_lists());
        goto L29
    L14:
        if (r103.getBatchData() == null) goto L20;
        if (r103.getBatchData().getAuth_res_lists() == null) goto L20;
        if (r103.getBatchData().getAuth_res_lists().size() <= 0) goto L20;
        r101.addAll(r103.getBatchData().getAuth_res_lists());
        goto L20
    L5:
        if (r102.getBatchData() == null) goto L11;
        if (r102.getBatchData().getAuth_res_lists() == null) goto L11;
        if (r102.getBatchData().getAuth_res_lists().size() <= 0) goto L11;
        r101.addAll(r102.getBatchData().getAuth_res_lists());
        goto L11
    }

    public static ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> e(ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r100) {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r101 = new ArrayList();
        if (r100.size() > 0) goto L6;
        return null;
    L6:
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        BatchAuthorizeResult.BatchAuthorizeNode r103 = r102.next();
        if (r103.getAuthorization_response().getAuth_data_code() != 1) goto L8;
        r101.add(r103);
        goto L8
    L12:
        return r101;
    }

    public static ArrayList<EmbededDocumentInfo.NodeInfo> a(ArrayList<EmbededDocumentInfo.NodeInfo> r100, Boolean r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.size() <= 0) goto L24;
        ArrayList<EmbededDocumentInfo.NodeInfo> r102 = new ArrayList();
        Iterator<EmbededDocumentInfo.NodeInfo> r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L14;
        EmbededDocumentInfo.NodeInfo r104 = r103.next();
        if (r104.isSenderHasSharePermission() == false) goto L8;
        if (r101.booleanValue() != r104.isChat_has_permission()) goto L8;
        r102.add(r104);
        goto L8
    L14:
        return r102;
    L24:
        return null;
    }

    public static String b(Context r100, int r101) {
        if (r100 != null) goto L6;
        tt5.a.h("MentionTitleFunction", "context is null");
        return "";
    L6:
        if (r101 != e.f541296g.f541317b) goto L10;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledDocument);
    L10:
        if (r101 != e.f541297h.f541317b) goto L14;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledSheet);
    L14:
        if (r101 != e.f541298i.f541317b) goto L18;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledBitable);
    L18:
        if (r101 != e.f541299j.f541317b) goto L22;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledBitable);
    L22:
        if (r101 != e.f541300k.f541317b) goto L26;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledMindnote);
    L26:
        if (r101 != e.f541301l.f541317b) goto L30;
        return r100.getResources().getString(R.string.Doc_Contract_UntitledFile);
    L30:
        if (r101 != e.f541302m.f541317b) goto L34;
        return r100.getResources().getString(R.string.LarkCCM_Slides_Untitled);
    L34:
        if (r101 != 125) goto L38;
        return r100.getResources().getString(R.string.LarkCCM_ChatShare_UntitledChat_Text);
    L38:
        return r100.getResources().getString(R.string.Doc_Contract_UntitledDocument);
    }

    public static void h(SingeAuthorizeNode r100, Context r101) {
        if (r100.getAuthDataCode() != 2002) goto L7;
        Activity r102 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        String r103 = r101.getString(R.string.LarkCCM_Workspace_ConAccess_ShareDenied_Tooltip);
        BearUDDialogBuilder r104 = new BearUDDialogBuilder(r102);
        r104.f240192a.title(R.string.LarkCCM_Workspace_ConAccess_ShareFail_Title);
        r104.f(r103);
        r104.b(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_GotIt, R.color.primary_fill_default, null);
        r104.f240192a.style(R.style.ActionSheetDialogStyle);
        r104.h();
        return;
    L7:
        if (r100.getAuthDataCode() != 2005) goto L14;
        Activity r105 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        if (r105 != null) goto L11;
        tt5.a.k("BatchAuthorizeUtils", "showDialog currentActivity is null");
        return;
    L11:
        String r106 = r105.getString(R.string.LarkCCM_Docs_SomePermGrantFail_Toast);
        BearUDDialogBuilder r107 = new BearUDDialogBuilder(r105);
        r107.f240192a.title(R.string.LarkCCM_Workspace_ConAccess_ShareFail_Title);
        r107.f(r106);
        r107.b(R.id.ud_dialog_btn_primary, R.string.Doc_Facade_GotIt, R.color.primary_fill_default, null);
        r107.f240192a.style(R.style.ActionSheetDialogStyle);
        r107.h();
        return;
    L14:
        if (r100.isAuthorizing() == false) goto L27;
        if (r100.isSuccess() == false) goto L19;
        String r108 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_Granted);
    L34:
        if (TextUtils.isEmpty(r108) == false) goto L36;
        return;
    L36:
        if (r100.isSuccess() == false) goto L38;
        Toast.showSuccessText(r101, r108);
        return;
    L38:
        Toast.showFailureText(r101, r108);
        return;
    L19:
        if (r100.getErrorCode() != 10014) goto L23;
        Activity r109 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        String r110 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_MaxCollaborator);
        BearUDDialogBuilder r111 = new BearUDDialogBuilder(r109);
        r111.f240192a.title(R.string.LarkCCM_EmbeddedFiles_NoPermissionToGrantAccess_Title);
        r111.f(r110);
        r111.b(R.id.ud_dialog_btn_primary, R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_ConfirmButton, R.color.primary_fill_default, null);
        r111.f240192a.style(R.style.ActionSheetDialogStyle);
        r111.h();
        return;
    L23:
        if (r100.getErrorCode() != 4) goto L25;
        r108 = r101.getString(R.string.LarkCCM_EmbeddedFiles_NoPermissionToGrantAccess_Toast);
        goto L34
    L25:
        r108 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoGrant);
        goto L34
    L27:
        if (r100.isSuccess() == false) goto L30;
        r108 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_Revoked);
        goto L34
    L30:
        if (r100.getErrorCode() != 4) goto L32;
        r108 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_NoPermRevoke);
        goto L34
    L32:
        r108 = r101.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevoke);
        goto L34
    }

    public static ArrayList<RecordAuthorizeRequest.AuthObject> d(HashMap<String, Integer> r100, ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r101, int r102) {
        if (r101.size() > 0) goto L5;
        return null;
    L5:
        if (r100.size() <= 0) goto L24;
        ArrayList<RecordAuthorizeRequest.AuthObject> r103 = new ArrayList();
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r104 = r101.iterator();
    L9:
        if (r104.hasNext() == false) goto L16;
        BatchAuthorizeResult.BatchAuthorizeNode r105 = r104.next();
        RecordAuthorizeRequest.AuthObject r106 = new RecordAuthorizeRequest.AuthObject();
        r106.setObjectToken(r105.getToken());
        r106.setObjectType(r105.getEntity_type());
        r106.setPermType(r100.get(r105.getToken()).intValue());     // Catch: Throwable -> L13
    L15:
        r106.setPermission(r102);
        r103.add(r106);
    L13:
        th = move-exception;
        tt5.a.c(th.getMessage());
        goto L15
    L16:
        return r103;
    L24:
        return null;
    }

    public static void f(p r100, ArrayList<SingeAuthorizeNode> r101, Boolean r102) {
        Application r103 = b.f474075a;
        if (r101 == null) goto L46;
        if (r101.size() <= 0) goto L46;
        int r104 = 0;
        if (r102.booleanValue() == true) goto L10;
        h((SingeAuthorizeNode) ListProtector.get(r101, 0), r103);
        return;
    L10:
        if (r100.f509163a.isSuccess() == true) goto L20;
        if (r100.f509164b.isSuccess() == true) goto L20;
        if (r100.f509165c.isSuccess() == true) goto L20;
        if (r100.f509166d.isSuccess() == true) goto L20;
        Toast.showFailureText(r103, r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_AllFailed_Toast_Mobile));
        return;
    L20:
        if (r100.f509163a.isSuccess() == true) goto L22;
    L42:
        Toast.showFailureText(r103, r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_AllFailed_Toast_Mobile));
        return;
    L22:
        if (r100.f509164b.isSuccess() == false) goto L42;
        if (r100.f509165c.isSuccess() == false) goto L42;
        if (r100.f509166d.isSuccess() == false) goto L42;
        Iterator<SingeAuthorizeNode> r105 = r101.iterator();
    L30:
        if (r105.hasNext() == false) goto L37;
        SingeAuthorizeNode r106 = r105.next();
        if (r106.isAuthorizing() == false) goto L30;
        if (r106.isSuccess() == false) goto L30;
        r104 = r104 + 1;
        goto L30
    L37:
        if (r104 != r101.size()) goto L39;
        String r107 = r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_Toast_Mobile);
        Toast.showSuccessText(b.f474075a, r107);
        return;
    L39:
        if (r104 <= 0) goto L41;
        Toast.showFailureText(r103, r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_PartlyFailed_Toast_Mobile));
        return;
    L41:
        Toast.showFailureText(r103, r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_AllFailed_Toast_Mobile));
        return;
    L46:
        if (r102.booleanValue() == false) goto L48;
        String r108 = r103.getString(R.string.LarkCCM_EmbeddedFiles_GrantedAllPermission_AllFailed_Toast_Mobile);
    L49:
        Toast.showFailureText(r103, r108);
        return;
    L48:
        r108 = r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoGrant);
        goto L49
    }

    public static void g(p r100, ArrayList<SingeAuthorizeNode> r101, Boolean r102) {
        Application r103 = b.f474075a;
        if (r101 != null) goto L5;
    L45:
        Toast.showFailureText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevoke));
        return;
    L5:
        if (r101.size() <= 0) goto L45;
        int r104 = 0;
        if (r102.booleanValue() == true) goto L10;
        h((SingeAuthorizeNode) ListProtector.get(r101, 0), r103);
        return;
    L10:
        if (r100.f509163a.isSuccess() == true) goto L20;
        if (r100.f509164b.isSuccess() == true) goto L20;
        if (r100.f509165c.isSuccess() == true) goto L20;
        if (r100.f509166d.isSuccess() == true) goto L20;
        Toast.showFailureText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevoke));
        return;
    L20:
        if (r100.f509163a.isSuccess() == true) goto L22;
    L42:
        Toast.showFailureText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevoke));
        return;
    L22:
        if (r100.f509164b.isSuccess() == false) goto L42;
        if (r100.f509165c.isSuccess() == false) goto L42;
        if (r100.f509166d.isSuccess() == false) goto L42;
        Iterator<SingeAuthorizeNode> r105 = r101.iterator();
    L30:
        if (r105.hasNext() == false) goto L37;
        SingeAuthorizeNode r106 = r105.next();
        if (r106.isAuthorizing() == true) goto L30;
        if (r106.isSuccess() == false) goto L30;
        r104 = r104 + 1;
        goto L30
    L37:
        if (r104 != r101.size()) goto L39;
        Toast.showSuccessText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_AllRevoked));
        return;
    L39:
        if (r104 <= 0) goto L41;
        Toast.showFailureText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevokeSome));
        return;
    L41:
        Toast.showFailureText(r103, r103.getString(R.string.CreationMobile_Docs_EmbeddedFiles_AccessDetails_Toast_FailedtoRevoke));
    }

    public static ArrayList<SingeAuthorizeNode> i(ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r100, boolean r101, int r102) {
        ArrayList<SingeAuthorizeNode> r103 = new ArrayList();
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L21;
        BatchAuthorizeResult.BatchAuthorizeNode r105 = r104.next();
        if (r105 == null) goto L4;
        if (r105.getAuthorization_response() == null) goto L4;
        boolean r106 = false;
        if (r105.getAuthorization_response().getAuth_data_code() != 1) goto L13;
        boolean r107 = true;
    L14:
        SingeAuthorizeNode r108 = new SingeAuthorizeNode(r107, r105.getAuthorization_response().getErr_code(), r101);
        if (r101 == false) goto L17;
        if (r107 == false) goto L17;
    L19:
        r106 = true;
    L20:
        r108.setHasPermission(r106);
        r108.setAuthDataCode(r105.getAuthorization_response().getAuth_data_code());
        r108.setToken(r105.getToken());
        r108.setCancelTotalNum(r102);
        r103.add(r108);
    L17:
        if (r101 == true) goto L20;
        if (r107 == true) goto L20;
    L13:
        r107 = false;
        goto L14
    L21:
        return r103;
    }
}
