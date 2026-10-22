package lh5;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.bytedance.ee.bear.middleground.permission.dlp.cache.DlpCacheModel;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpCheckResult;
import com.bytedance.ee.bear.middleground.permission.dlp.model.DlpPolicyModel;

/* JADX INFO: loaded from: classes18.dex */
public final class c {
    public static int a(String r100) {
        DlpCacheModel.NodeData r101 = b.c.f509256a.f509244a.c(r100);
        if (r101 != null) goto L5;
    L12:
        int r102 = -1;
    L14:
        if (r102 <= 0) goto L16;
        if (r102 >= 900) goto L16;
    L18:
        if (r102 >= 60) goto L21;
        r102 = 60;
    L21:
        return r102 / 60;
    L16:
        r102 = 900;
        goto L18
    L5:
        if (r101.getPolicyModel() == null) goto L12;
        if (r101.getPolicyModel().getPolicy() == null) goto L12;
        if (r101.getPolicyModel().getPolicy().getSetting() == null) goto L12;
        r102 = r101.getPolicyModel().getPolicy().getSetting().getDLPCheckTime();
        goto L14
    }

    public static boolean c(DlpPolicyModel r100) {
        if (r100 != null) goto L5;
    L13:
        return false;
    L5:
        if (r100.getPolicy() == null) goto L13;
        DlpPolicyModel.Policy r101 = r100.getPolicy();
        long r102 = System.currentTimeMillis() - r101.getDlpUpdateTime();
        if (r102 <= 0) goto L13;
        if ((r102 / 1000) >= r101.getTimeout()) goto L13;
        return true;
    }

    public static String d(int r100) {
        if (r100 != sbb.e.f541296g.f541317b) goto L7;
        return PreloadConfigModel.VERSION_CHECK_TYPE_DOC;
    L7:
        if (r100 != sbb.e.f541297h.f541317b) goto L11;
        return "SHEET";
    L11:
        if (r100 != sbb.e.f541298i.f541317b) goto L15;
        return "BITABLE";
    L15:
        if (r100 != sbb.e.f541300k.f541317b) goto L19;
        return PreloadConfigModel.VERSION_CHECK_TYPE_MINDNOTE;
    L19:
        if (r100 != sbb.e.f541301l.f541317b) goto L23;
        return "FILE";
    L23:
        if (r100 != sbb.e.f541304o.f541317b) goto L27;
        return PreloadConfigModel.VERSION_CHECK_TYPE_DOCX;
    L27:
        if (r100 != sbb.e.f541307r.f541317b) goto L31;
        return "BITABLE_SHARE_FORM";
    L31:
        if (r100 != sbb.e.f541302m.f541317b) goto L34;
        return "SLIDES";
    L34:
        tt5.a.d("DlpCheckUtils", "getEntityTypeByType()...illegal type, type = " + r100);
        return "";
    }

    public static boolean b(boolean r100, DlpCheckResult r101, String r102) {
        if (r100 == true) goto L5;
        return true;
    L5:
        if (r101 != null) goto L7;
        return false;
    L7:
        if (r101.getResultMap() != null) goto L9;
        return false;
    L9:
        if (r101.getResultMap().size() <= 0) goto L24;
        DlpCheckResult.DlpResult r103 = r101.getResultMap().get(r102);
        if (r103 == null) goto L21;
        long r104 = System.currentTimeMillis() - r103.getScsUpdateTime();
        if (r104 > 0) goto L16;
        return false;
    L16:
        if ((r104 / 1000) >= r101.getTimeout()) goto L23;
        return true;
    L23:
        return false;
    L21:
        return false;
    L24:
        return false;
    }
}
