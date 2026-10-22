package gi5;

import ah5.d;
import ah5.e;
import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.lark.dependency.y;
import com.bytedance.ee.bear.middleground.permission.export.ui.model.DocReportPubParam;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.larksuite.framework.utils.DeviceUtils;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@UserScope
public final class a implements hm5.a {

    /* JADX INFO: renamed from: gi5.a$a, reason: collision with other inner class name */
    public static final class C6028a {
    }

    static {
    }

    @Override // hm5.a
    public final ArrayList<Class<? extends XBridgeMethod>> Id() {
        return CollectionsKt.arrayListOf(new Class[]{e.class, d.class, ah5.a.class, ah5.b.class, ah5.c.class});
    }

    @Override // hm5.a
    public final void onDestroy() {
    }

    @Inject
    public a(by4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "kvStorage");
    }

    @Override // hm5.a
    public final void Sb(FragmentManager r210, Context r211, int r212, String r213, DocReportPubParam r310) {
        Intrinsics.checkNotNullParameter(r210, "fm");
        Intrinsics.checkNotNullParameter(r211, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r213, "blockUrl");
        Intrinsics.checkNotNullParameter(r310, "pubParam");
        Integer r100 = r310.getFileType();
        boolean r101 = true;
        if (r100 != null) goto L6;
    L8:
        boolean r102 = false;
    L9:
        int r103 = ui5.b.f550207a;
        Intrinsics.checkNotNullParameter(r310, "param");
        String r104 = DeviceUtils.getOSVersion();
        String r105 = r310.getFileId();
        String r106 = "";
        if (r105 != null) goto L12;
        r105 = "";
    L12:
        Integer r107 = r310.getFileType();
        if (r107 == null) goto L15;
        int r108 = r107.intValue();
    L16:
        String r109 = r310.getAppForm();
        String r110 = "none";
        if (r109 != null) goto L19;
        r109 = "none";
    L19:
        String r111 = r310.getModule();
        if (r111 != null) goto L22;
        r111 = "";
    L22:
        String r112 = r310.getSubModule();
        if (r112 == null) goto L26;
        r106 = r112;
    L26:
        String r113 = r310.getCreatorId();
        String r114 = "0";
        if (r113 != null) goto L29;
        r113 = "0";
    L29:
        String r115 = r310.getOwnerId();
        if (r115 != null) goto L32;
        r115 = "0";
    L32:
        String r116 = r310.getCreatorTenantId();
        if (r116 == null) goto L36;
        r114 = r116;
    L36:
        HashMap r117 = new HashMap();
        r117.put("os_name", "Android");
        r117.put("os_version", r104);
        r117.put("platform", "lark");
        r117.put("sub_platform", "android_native");
        r117.put("creator_id", du5.b.g(r113));
        r117.put("owner_id", du5.b.g(r115));
        r117.put("owner_tenant_id", du5.b.g(r114));
        if (r102 == false) goto L56;
        String r118 = du5.b.g(r105);
        String r119 = sbb.e.c(r108);
        if (r111.length() <= 0) goto L41;
        boolean r120 = true;
    L42:
        if (r120 != true) goto L44;
        boolean r121 = true;
    L45:
        if (r121 == true) goto L49;
        r111 = r119;
    L49:
        if (r106.length() == 0) goto L52;
        r101 = false;
    L52:
        if (r101 == true) goto L55;
        r110 = r106;
    L55:
        r117.put("file_id", r118);
        r117.put("file_type", r119);
        r117.put("app_form", r109);
        r117.put(EventConstant.Key.MODULE, r111);
        r117.put("sub_module", r110);
    L60:
        av5.c.b(r213, r117, false);
        ((y) LarkContext.spiByDwarf(y.class)).d();
        tt5.a.h("LarkPermissionService", "showInterComBlockFragment: failed to create web container fragment");
        return;
    L44:
        r121 = false;
        goto L45
    L41:
        r120 = false;
        goto L42
    L56:
        String r122 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r117, "hashMap");
        JSONObject r123 = new JSONObject();
        String r124 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r125 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L59;
        r110 = ThumbGlideUrl.SOURCE_VC;
    L59:
        com.bytedance.ee.bear.middleground.permission.c.a(r123, r124, r125, r110, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r117.put("file_id", r123.optString("file_id"));
        r117.put("file_type", r123.optString("file_type"));
        r117.put("app_form", r123.optString("app_form"));
        r117.put(EventConstant.Key.MODULE, r123.optString(EventConstant.Key.MODULE));
        r117.put("sub_module", r123.optString("sub_module"));
        goto L60
    L15:
        r108 = -1;
        goto L16
    L6:
        if (r100.intValue() != 0) goto L8;
        r102 = true;
        goto L9
    }
}
