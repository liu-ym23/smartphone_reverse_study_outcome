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
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@UserScope
public final class a implements hm5.a {

    /* JADX INFO: renamed from: gi5.a$a, reason: collision with other inner class name */
    public static final class C0235a {
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
    public a(by4.b r2) {
        Intrinsics.checkNotNullParameter(r2, "kvStorage");
    }

    @Override // hm5.a
    public final void Sb(FragmentManager r26, Context r27, int r28, String r29, DocReportPubParam r30) {
        Intrinsics.checkNotNullParameter(r26, "fm");
        Intrinsics.checkNotNullParameter(r27, "context");
        Intrinsics.checkNotNullParameter(r29, "blockUrl");
        Intrinsics.checkNotNullParameter(r30, "pubParam");
        Integer r2 = r30.getFileType();
        boolean r3 = true;
        if (r2 != null) goto L6;
    L8:
        boolean r4 = false;
    L9:
        int r5 = ui5.b.a;
        Intrinsics.checkNotNullParameter(r30, "param");
        String r6 = DeviceUtils.getOSVersion();
        String r7 = r30.getFileId();
        String r8 = "";
        if (r7 != null) goto L12;
        r7 = "";
    L12:
        Integer r9 = r30.getFileType();
        if (r9 == null) goto L15;
        int r10 = r9.intValue();
    L16:
        String r11 = r30.getAppForm();
        String r12 = "none";
        if (r11 != null) goto L19;
        r11 = "none";
    L19:
        String r13 = r30.getModule();
        if (r13 != null) goto L22;
        r13 = "";
    L22:
        String r14 = r30.getSubModule();
        if (r14 == null) goto L26;
        r8 = r14;
    L26:
        String r15 = r30.getCreatorId();
        String r16 = "0";
        if (r15 != null) goto L29;
        r15 = "0";
    L29:
        String r17 = r30.getOwnerId();
        if (r17 != null) goto L32;
        r17 = "0";
    L32:
        String r1 = r30.getCreatorTenantId();
        if (r1 == null) goto L36;
        r16 = r1;
    L36:
        HashMap r18 = new HashMap();
        r18.put("os_name", "Android");
        r18.put("os_version", r6);
        r18.put("platform", "lark");
        r18.put("sub_platform", "android_native");
        r18.put("creator_id", du5.b.g(r15));
        r18.put("owner_id", du5.b.g(r17));
        r18.put("owner_tenant_id", du5.b.g(r16));
        if (r4 == false) goto L56;
        String r19 = du5.b.g(r7);
        String r20 = sbb.e.c(r10);
        if (r13.length() <= 0) goto L41;
        boolean r21 = true;
    L42:
        if (r21 != true) goto L44;
        boolean r22 = true;
    L45:
        if (r22 == true) goto L49;
        r13 = r20;
    L49:
        if (r8.length() == 0) goto L52;
        r3 = false;
    L52:
        if (r3 == true) goto L55;
        r12 = r8;
    L55:
        r18.put("file_id", r19);
        r18.put("file_type", r20);
        r18.put("app_form", r11);
        r18.put("module", r13);
        r18.put("sub_module", r12);
    L60:
        av5.c.b(r29, r18, false);
        ((y) LarkContext.spiByDwarf(y.class)).d();
        tt5.a.h("LarkPermissionService", "showInterComBlockFragment: failed to create web container fragment");
        return;
    L44:
        r22 = false;
        goto L45
    L41:
        r21 = false;
        goto L42
    L56:
        String r23 = com.bytedance.ee.bear.middleground.permission.c.a;
        Intrinsics.checkNotNullParameter(r18, "hashMap");
        JSONObject r24 = new JSONObject();
        String r110 = com.bytedance.ee.bear.middleground.permission.c.f;
        int r111 = com.bytedance.ee.bear.middleground.permission.c.g;
        if (com.bytedance.ee.bear.middleground.permission.c.c == false) goto L59;
        r12 = ThumbGlideUrl.SOURCE_VC;
    L59:
        com.bytedance.ee.bear.middleground.permission.c.a(r24, r110, r111, r12, com.bytedance.ee.bear.middleground.permission.c.h, com.bytedance.ee.bear.middleground.permission.c.d, com.bytedance.ee.bear.middleground.permission.c.e, com.bytedance.ee.bear.middleground.permission.c.a, com.bytedance.ee.bear.middleground.permission.c.b, com.bytedance.ee.bear.middleground.permission.c.i);
        r18.put("file_id", r24.optString("file_id"));
        r18.put("file_type", r24.optString("file_type"));
        r18.put("app_form", r24.optString("app_form"));
        r18.put("module", r24.optString("module"));
        r18.put("sub_module", r24.optString("sub_module"));
        goto L60
    L15:
        r10 = -1;
        goto L16
    L6:
        if (r2.intValue() != 0) goto L8;
        r4 = true;
        goto L9
    }
}
