package lh5;

import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {
    public static int a(String r1) {
        DlpCacheModel.NodeData r2 = b.c.a.a.c(r1);
        if (r2 != null) goto L5;
    L12:
        int r3 = -1;
    L14:
        if (r3 <= 0) goto L16;
        if (r3 >= 900) goto L16;
    L18:
        if (r3 >= 60) goto L21;
        r3 = 60;
    L21:
        return r3 / 60;
    L16:
        r3 = 900;
        goto L18
    L5:
        if (r2.getPolicyModel() == null) goto L12;
        if (r2.getPolicyModel().getPolicy() == null) goto L12;
        if (r2.getPolicyModel().getPolicy().getSetting() == null) goto L12;
        r3 = r2.getPolicyModel().getPolicy().getSetting().getDLPCheckTime();
        goto L14
    }

    public static boolean c(DlpPolicyModel r6) {
        if (r6 != null) goto L5;
    L13:
        return false;
    L5:
        if (r6.getPolicy() == null) goto L13;
        DlpPolicyModel.Policy r7 = r6.getPolicy();
        long r1 = System.currentTimeMillis() - r7.getDlpUpdateTime();
        if (r1 <= 0) goto L13;
        if ((r1 / 1000) >= r7.getTimeout()) goto L13;
        return true;
    }

    public static String d(int r2) {
        if (r2 != sbb.e.g.b) goto L7;
        return "DOC";
    L7:
        if (r2 != sbb.e.h.b) goto L11;
        return "SHEET";
    L11:
        if (r2 != sbb.e.i.b) goto L15;
        return "BITABLE";
    L15:
        if (r2 != sbb.e.k.b) goto L19;
        return "MINDNOTE";
    L19:
        if (r2 != sbb.e.l.b) goto L23;
        return "FILE";
    L23:
        if (r2 != sbb.e.o.b) goto L27;
        return "DOCX";
    L27:
        if (r2 != sbb.e.r.b) goto L31;
        return "BITABLE_SHARE_FORM";
    L31:
        if (r2 != sbb.e.m.b) goto L34;
        return "SLIDES";
    L34:
        tt5.a.d("DlpCheckUtils", "getEntityTypeByType()...illegal type, type = " + r2);
        return "";
    }

    public static boolean b(boolean r5, DlpCheckResult r6, String r7) {
        if (r5 == true) goto L5;
        return true;
    L5:
        if (r6 != null) goto L7;
        return false;
    L7:
        if (r6.getResultMap() != null) goto L9;
        return false;
    L9:
        if (r6.getResultMap().size() <= 0) goto L24;
        DlpCheckResult.DlpResult r8 = r6.getResultMap().get(r7);
        if (r8 == null) goto L21;
        long r1 = System.currentTimeMillis() - r8.getScsUpdateTime();
        if (r1 > 0) goto L16;
        return false;
    L16:
        if ((r1 / 1000) >= r6.getTimeout()) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L24:
        return false;
    }
}
