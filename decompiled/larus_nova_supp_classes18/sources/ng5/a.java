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
import eu5.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import lg5.p;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> c(p r3) {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r0 = new ArrayList();
        BatchAuthorizeResult r1 = r3.a;
        if (r1 != null) goto L5;
    L11:
        BatchAuthorizeResult r2 = r3.b;
        if (r2 != null) goto L14;
    L20:
        BatchAuthorizeResult r4 = r3.c;
        if (r4 != null) goto L23;
    L29:
        BatchAuthorizeResult r5 = r3.d;
        if (r5 != null) goto L32;
    L38:
        return r0;
    L32:
        if (r5.getBatchData() == null) goto L38;
        if (r5.getBatchData().getAuth_res_lists() == null) goto L38;
        if (r5.getBatchData().getAuth_res_lists().size() <= 0) goto L38;
        r0.addAll(r5.getBatchData().getAuth_res_lists());
        goto L38
    L23:
        if (r4.getBatchData() == null) goto L29;
        if (r4.getBatchData().getAuth_res_lists() == null) goto L29;
        if (r4.getBatchData().getAuth_res_lists().size() <= 0) goto L29;
        r0.addAll(r4.getBatchData().getAuth_res_lists());
        goto L29
    L14:
        if (r2.getBatchData() == null) goto L20;
        if (r2.getBatchData().getAuth_res_lists() == null) goto L20;
        if (r2.getBatchData().getAuth_res_lists().size() <= 0) goto L20;
        r0.addAll(r2.getBatchData().getAuth_res_lists());
        goto L20
    L5:
        if (r1.getBatchData() == null) goto L11;
        if (r1.getBatchData().getAuth_res_lists() == null) goto L11;
        if (r1.getBatchData().getAuth_res_lists().size() <= 0) goto L11;
        r0.addAll(r1.getBatchData().getAuth_res_lists());
        goto L11
    }

    public static ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> e(ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r4) {
        ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r0 = new ArrayList();
        if (r4.size() > 0) goto L6;
        return null;
    L6:
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L12;
        BatchAuthorizeResult.BatchAuthorizeNode r1 = r5.next();
        if (r1.getAuthorization_response().getAuth_data_code() != 1) goto L8;
        r0.add(r1);
        goto L8
    L12:
        return r0;
    }

    public static ArrayList<EmbededDocumentInfo.NodeInfo> a(ArrayList<EmbededDocumentInfo.NodeInfo> r4, Boolean r5) {
        if (r4 != null) goto L4;
        return null;
    L4:
        if (r4.size() <= 0) goto L24;
        ArrayList<EmbededDocumentInfo.NodeInfo> r0 = new ArrayList();
        Iterator<EmbededDocumentInfo.NodeInfo> r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        EmbededDocumentInfo.NodeInfo r1 = r6.next();
        if (r1.isSenderHasSharePermission() == false) goto L8;
        if (r5.booleanValue() != r1.isChat_has_permission()) goto L8;
        r0.add(r1);
        goto L8
    L14:
        return r0;
    L24:
        return null;
    }

    public static String b(Context r3, int r4) {
        if (r3 != null) goto L6;
        tt5.a.h("MentionTitleFunction", "context is null");
        return "";
    L6:
        if (r4 != e.g.b) goto L10;
        return r3.getResources().getString(2131887640);
    L10:
        if (r4 != e.h.b) goto L14;
        return r3.getResources().getString(2131887643);
    L14:
        if (r4 != e.i.b) goto L18;
        return r3.getResources().getString(2131887639);
    L18:
        if (r4 != e.j.b) goto L22;
        return r3.getResources().getString(2131887639);
    L22:
        if (r4 != e.k.b) goto L26;
        return r3.getResources().getString(2131887642);
    L26:
        if (r4 != e.l.b) goto L30;
        return r3.getResources().getString(2131887641);
    L30:
        if (r4 != e.m.b) goto L34;
        return r3.getResources().getString(2131889771);
    L34:
        if (r4 != 125) goto L38;
        return r3.getResources().getString(2131888885);
    L38:
        return r3.getResources().getString(2131887640);
    }

    public static void h(SingeAuthorizeNode r8, Context r9) {
        if (r8.getAuthDataCode() != 2002) goto L7;
        Activity r10 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        String r11 = r9.getString(2131889848);
        BearUDDialogBuilder r0 = new BearUDDialogBuilder(r10);
        r0.a.title(2131889849);
        r0.f(r11);
        r0.b(2131391777, 2131887759, 2131105548, null);
        r0.a.style(2131951622);
        r0.h();
        return;
    L7:
        if (r8.getAuthDataCode() != 2005) goto L14;
        Activity r12 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        if (r12 != null) goto L11;
        tt5.a.k("BatchAuthorizeUtils", "showDialog currentActivity is null");
        return;
    L11:
        String r13 = r12.getString(2131889265);
        BearUDDialogBuilder r1 = new BearUDDialogBuilder(r12);
        r1.a.title(2131889849);
        r1.f(r13);
        r1.b(2131391777, 2131887759, 2131105548, null);
        r1.a.style(2131951622);
        r1.h();
        return;
    L14:
        if (r8.isAuthorizing() == false) goto L27;
        if (r8.isSuccess() == false) goto L19;
        String r2 = r9.getString(2131887201);
    L34:
        if (TextUtils.isEmpty(r2) == false) goto L36;
        return;
    L36:
        if (r8.isSuccess() == false) goto L38;
        Toast.showSuccessText(r9, r2);
        return;
    L38:
        Toast.showFailureText(r9, r2);
        return;
    L19:
        if (r8.getErrorCode() != 10014) goto L23;
        Activity r14 = ((h) org.koin.java.a.a(h.class)).getCurrentActivity();
        String r15 = r9.getString(2131887202);
        BearUDDialogBuilder r3 = new BearUDDialogBuilder(r14);
        r3.a.title(2131889476);
        r3.f(r15);
        r3.b(2131391777, 2131887182, 2131105548, null);
        r3.a.style(2131951622);
        r3.h();
        return;
    L23:
        if (r8.getErrorCode() != 4) goto L25;
        r2 = r9.getString(2131889477);
        goto L34
    L25:
        r2 = r9.getString(2131887198);
        goto L34
    L27:
        if (r8.isSuccess() == false) goto L30;
        r2 = r9.getString(2131887204);
        goto L34
    L30:
        if (r8.getErrorCode() != 4) goto L32;
        r2 = r9.getString(2131887203);
        goto L34
    L32:
        r2 = r9.getString(2131887199);
        goto L34
    }

    public static ArrayList<RecordAuthorizeRequest.AuthObject> d(HashMap<String, Integer> r4, ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r5, int r6) {
        if (r5.size() > 0) goto L5;
        return null;
    L5:
        if (r4.size() <= 0) goto L24;
        ArrayList<RecordAuthorizeRequest.AuthObject> r0 = new ArrayList();
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r7 = r5.iterator();
    L9:
        if (r7.hasNext() == false) goto L16;
        BatchAuthorizeResult.BatchAuthorizeNode r1 = r7.next();
        RecordAuthorizeRequest.AuthObject r2 = new RecordAuthorizeRequest.AuthObject();
        r2.setObjectToken(r1.getToken());
        r2.setObjectType(r1.getEntity_type());
        r2.setPermType(r4.get(r1.getToken()).intValue());     // Catch: Throwable -> L13
    L15:
        r2.setPermission(r6);
        r0.add(r2);
    L13:
        th = move-exception;
        tt5.a.c(th.getMessage());
        goto L15
    L16:
        return r0;
    L24:
        return null;
    }

    public static void f(p r4, ArrayList<SingeAuthorizeNode> r5, Boolean r6) {
        Application r0 = b.a;
        if (r5 == null) goto L46;
        if (r5.size() <= 0) goto L46;
        int r2 = 0;
        if (r6.booleanValue() == true) goto L10;
        h((SingeAuthorizeNode) ListProtector.get(r5, 0), r0);
        return;
    L10:
        if (r4.a.isSuccess() == true) goto L20;
        if (r4.b.isSuccess() == true) goto L20;
        if (r4.c.isSuccess() == true) goto L20;
        if (r4.d.isSuccess() == true) goto L20;
        Toast.showFailureText(r0, r0.getString(2131889473));
        return;
    L20:
        if (r4.a.isSuccess() == true) goto L22;
    L42:
        Toast.showFailureText(r0, r0.getString(2131889473));
        return;
    L22:
        if (r4.b.isSuccess() == false) goto L42;
        if (r4.c.isSuccess() == false) goto L42;
        if (r4.d.isSuccess() == false) goto L42;
        Iterator<SingeAuthorizeNode> r7 = r5.iterator();
    L30:
        if (r7.hasNext() == false) goto L37;
        SingeAuthorizeNode r8 = r7.next();
        if (r8.isAuthorizing() == false) goto L30;
        if (r8.isSuccess() == false) goto L30;
        r2 = r2 + 1;
        goto L30
    L37:
        if (r2 != r5.size()) goto L39;
        String r9 = r0.getString(2131889475);
        Toast.showSuccessText(b.a, r9);
        return;
    L39:
        if (r2 <= 0) goto L41;
        Toast.showFailureText(r0, r0.getString(2131889474));
        return;
    L41:
        Toast.showFailureText(r0, r0.getString(2131889473));
        return;
    L46:
        if (r6.booleanValue() == false) goto L48;
        String r10 = r0.getString(2131889473);
    L49:
        Toast.showFailureText(r0, r10);
        return;
    L48:
        r10 = r0.getString(2131887198);
        goto L49
    }

    public static void g(p r4, ArrayList<SingeAuthorizeNode> r5, Boolean r6) {
        Application r0 = b.a;
        if (r5 != null) goto L5;
    L45:
        Toast.showFailureText(r0, r0.getString(2131887199));
        return;
    L5:
        if (r5.size() <= 0) goto L45;
        int r2 = 0;
        if (r6.booleanValue() == true) goto L10;
        h((SingeAuthorizeNode) ListProtector.get(r5, 0), r0);
        return;
    L10:
        if (r4.a.isSuccess() == true) goto L20;
        if (r4.b.isSuccess() == true) goto L20;
        if (r4.c.isSuccess() == true) goto L20;
        if (r4.d.isSuccess() == true) goto L20;
        Toast.showFailureText(r0, r0.getString(2131887199));
        return;
    L20:
        if (r4.a.isSuccess() == true) goto L22;
    L42:
        Toast.showFailureText(r0, r0.getString(2131887199));
        return;
    L22:
        if (r4.b.isSuccess() == false) goto L42;
        if (r4.c.isSuccess() == false) goto L42;
        if (r4.d.isSuccess() == false) goto L42;
        Iterator<SingeAuthorizeNode> r7 = r5.iterator();
    L30:
        if (r7.hasNext() == false) goto L37;
        SingeAuthorizeNode r8 = r7.next();
        if (r8.isAuthorizing() == true) goto L30;
        if (r8.isSuccess() == false) goto L30;
        r2 = r2 + 1;
        goto L30
    L37:
        if (r2 != r5.size()) goto L39;
        Toast.showSuccessText(r0, r0.getString(2131887197));
        return;
    L39:
        if (r2 <= 0) goto L41;
        Toast.showFailureText(r0, r0.getString(2131887200));
        return;
    L41:
        Toast.showFailureText(r0, r0.getString(2131887199));
    }

    public static ArrayList<SingeAuthorizeNode> i(ArrayList<BatchAuthorizeResult.BatchAuthorizeNode> r7, boolean r8, int r9) {
        ArrayList<SingeAuthorizeNode> r0 = new ArrayList();
        Iterator<BatchAuthorizeResult.BatchAuthorizeNode> r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L21;
        BatchAuthorizeResult.BatchAuthorizeNode r1 = r10.next();
        if (r1 == null) goto L4;
        if (r1.getAuthorization_response() == null) goto L4;
        boolean r3 = false;
        if (r1.getAuthorization_response().getAuth_data_code() != 1) goto L13;
        boolean r2 = true;
    L14:
        SingeAuthorizeNode r5 = new SingeAuthorizeNode(r2, r1.getAuthorization_response().getErr_code(), r8);
        if (r8 == false) goto L17;
        if (r2 == false) goto L17;
    L19:
        r3 = true;
    L20:
        r5.setHasPermission(r3);
        r5.setAuthDataCode(r1.getAuthorization_response().getAuth_data_code());
        r5.setToken(r1.getToken());
        r5.setCancelTotalNum(r9);
        r0.add(r5);
    L17:
        if (r8 == true) goto L20;
        if (r2 == true) goto L20;
    L13:
        r2 = false;
        goto L14
    L21:
        return r0;
    }
}
