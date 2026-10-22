package lh5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements com.bytedance.ee.bear.middleground_permission_export.model.d {
    public i() {
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final int b(String r8) {
        if (com.bytedance.ee.bear.middleground.permission.b.f() == true) goto L5;
        return 0;
    L5:
        int r9 = e(r8, 12, "CCM_CONTENT_COPY", "", "");
        if (r9 != 1) goto L8;
        return 900099002;
    L8:
        if (r9 != 2) goto L10;
        return 900099004;
    L10:
        if (r9 != 3) goto L18;
        return -900099004;
    L18:
        return 0;
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final long g(String r3) {
        DlpCacheModel.NodeData r4 = b.c.a.a.c(r3);
        if (r4 != null) goto L5;
    L8:
        int r5 = -1;
    L10:
        if (r5 <= 0) goto L12;
        if (r5 >= 600) goto L12;
    L14:
        if (r5 >= 60) goto L17;
        r5 = 60;
    L17:
        return r5 * CCMLynxCardView.ViewType.BANNER;
    L12:
        r5 = 600;
        goto L14
    L5:
        if (r4.getCheckResult() == null) goto L8;
        r5 = (int) r4.getCheckResult().getTimeout();
        goto L10
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final void c(String r9, int r10) {
        if (com.bytedance.ee.bear.middleground.permission.b.f() == true) goto L5;
        return;
    L5:
        tt5.a.b("DlpProxyImpl", "asyncFetchDlpData enters");
        String r1 = c.d(r10);     // Catch: Throwable -> L8
        e(r9, r10, "CCM_OPEN_EXTERNAL_ACCESS", "", "");     // Catch: Throwable -> L8
        b.c.a.b(r9, r1, "", null);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.f("DlpProxyImpl", th, false);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final String f(String r20, String r21, int r22) {
        String r3 = "";
        if (com.bytedance.ee.bear.middleground.permission.b.f() == true) goto L5;
        return "";
    L5:
        tt5.a.b("DlpProxyImpl", "getDLpErrorMsg enter " + r21 + "," + r22);
        long r5 = (long) c.a(r20);
        boolean r7 = true;
        boolean r8 = false;
        if ("CCM_ATTACHMENT_DOWNLOAD".equals(r21) == true) goto L20;
        if ("CCM_EXPORT".equals(r21) == true) goto L20;
        if (900099002 != r22) goto L12;
        String r1 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r5 + "");
    L25:
        r3 = r1;
    L33:
        r8 = true;
    L34:
        String r2 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r21, "triggerReason");
        JSONObject r4 = new JSONObject();
        String r10 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r11 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L37;
        String r6 = ThumbGlideUrl.SOURCE_VC;
    L38:
        com.bytedance.ee.bear.middleground.permission.c.a(r4, r10, r11, r6, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r4.put("trigger_reason", r21);
        if (r7 == false) goto L41;
        String r9 = "before_checked";
    L42:
        r4.put("trigger_opportunity", r9);
        if (r8 == false) goto L45;
        String r12 = "true";
    L46:
        r4.put("is_tenant_cross", r12);
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_dlp_security_intercept_toast_view", r4);
        if (TextUtils.isEmpty(r20) == false) goto L49;
    L52:
        tt5.a.b("DlpProxyImpl", "getDLpErrorMsg empty operate");
        return r3;
    L49:
        if (TextUtils.isEmpty(r21) == true) goto L52;
        return r3;
    L45:
        r12 = "false";
        goto L46
    L41:
        r9 = "after_checked";
        goto L42
    L37:
        r6 = "none";
        goto L38
    L12:
        if (900099004 != r22) goto L15;
        r3 = UIHelper.getString(2131889029);
    L32:
        r7 = false;
        goto L33
    L15:
        if ((-900099004) != r22) goto L32;
        if ("CCM_CONTENT_COPY".equals(r21) == false) goto L32;
        r3 = UIHelper.getString(2131889023);
    L20:
        if (900099001 != r22) goto L23;
        String r13 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r5 + "");
    L22:
        r3 = r13;
        r7 = false;
        goto L34
    L23:
        if (900099002 != r22) goto L27;
        r1 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r5 + "");
        goto L25
    L27:
        if (900099003 != r22) goto L30;
        r13 = UIHelper.getString(2131889027);
        goto L22
    L30:
        if (900099004 != r22) goto L32;
        r3 = UIHelper.getString(2131889029);
        goto L32
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final String a(String r9, int r10, String r11, String r12, String r13) {
        String r1 = "";
        if (com.bytedance.ee.bear.middleground.permission.b.f() == true) goto L5;
        return "";
    L5:
        int r14 = e(r9, r10, r11, r12, r13);
        if (r14 != 0) goto L8;
        return "";
    L8:
        boolean r0 = false;
        if (((h0) org.koin.java.a.a(h0.class)).G2() == null) goto L17;
        String r15 = ((h0) org.koin.java.a.a(h0.class)).G2().tenantId;
        if (TextUtils.isEmpty(r15) == true) goto L17;
        if (TextUtils.isEmpty(r13) == true) goto L17;
        if (r13.equals(r15) == true) goto L17;
        boolean r16 = true;
    L18:
        long r3 = c.a(r9);
        if ("CCM_ATTACHMENT_DOWNLOAD".equals(r11) == false) goto L21;
    L38:
        if (r14 != 1) goto L43;
        if (r16 == false) goto L41;
        String r17 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r3 + "");
    L42:
        r1 = r17;
    L47:
        String r18 = com.bytedance.ee.bear.middleground.permission.c.a;
        if (r14 != 2) goto L50;
        r0 = true;
    L50:
        com.bytedance.ee.bear.middleground.permission.c.t(r11, r0);
        return r1;
    L41:
        r17 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r3 + "");
        goto L42
    L43:
        if (r14 != 2) goto L47;
        if (r16 == false) goto L46;
        r17 = UIHelper.getString(2131889029);
        goto L42
    L46:
        r17 = UIHelper.getString(2131889027);
        goto L42
    L21:
        if ("CCM_EXPORT".equals(r11) == true) goto L38;
        if ("CCM_OPEN_EXTERNAL_ACCESS".equals(r11) == false) goto L26;
    L29:
        if (r14 != 2) goto L31;
        r1 = UIHelper.getString(2131889029);
        goto L47
    L31:
        if (r14 != 1) goto L36;
        if (r16 == false) goto L34;
        r17 = UIHelper.mustacheFormat(2131889028, SheetInputData.InputData.FormatType.NUMBER, r3 + "");
        goto L42
    L34:
        r17 = UIHelper.getString(2131889029);
        goto L42
    L36:
        if (r14 != 3) goto L47;
        r1 = UIHelper.getString(2131889023);
        goto L47
    L26:
        if ("CCM_CREATE_COPY".equals(r11) == true) goto L29;
        if ("CCM_CONTENT_COPY".equals(r11) == false) goto L47;
    L17:
        r16 = false;
        goto L18
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final void d(String r8, int r9, String r10, String r11, com.bytedance.ee.bear.middleground_permission_export.model.d.a r12) {
        if (com.bytedance.ee.bear.middleground.permission.b.f() == true) goto L5;
        return;
    L5:
        String r3 = c.d(r9);
        b.c.a.f(r8, r3, r10, r11, r12);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        tt5.a.f("DlpProxyImpl", th, false);
    }

    @Override // com.bytedance.ee.bear.middleground_permission_export.model.d
    public final int e(String r7, int r8, String r9, String r10, String r11) {
        String r2 = c.d(r8);
        return b.c.a.d(r7, r2, r9, r10, r11);
    L5:
        th = move-exception;
        tt5.a.f("DlpProxyImpl", th, false);
        return 0;
    }
}
