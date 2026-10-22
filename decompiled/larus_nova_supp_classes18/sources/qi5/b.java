package qi5;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.ee.bear.middleground.permission.setting.linkshare.LinkShareItem;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.permissionset.DocPermSetInfo;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Map b(int r3, Context r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r3 != 5) goto L5;
        r0.put("permType1", r4.getString(2131888224));
    L6:
        r0.put("permType2", r4.getString(2131889690));
        return r0;
    L5:
        r0.put("permType1", r4.getString(2131888223));
        goto L6
    }

    public static HashMap e(String r4, DocPermSetInfo r5) {
        Intrinsics.checkNotNullParameter(r4, "module");
        Intrinsics.checkNotNullParameter(r5, "permSerInfo");
        HashMap r1 = new HashMap();
        r1.put("file_id", du5.b.g(r5.c));
        r1.put("file_type", e.f(r5.getType()));
        r1.put("app_form", "none");
        r1.put("sub_file_type", r5.e.getSubType());
        r1.put("module", r4);
        r1.put("user_permission", r5.f.a.getReportJson());
        r1.put("file_permission", r5.f.b.getReportJson());
        if (r5.b() == false) goto L5;
        String r6 = "true";
    L6:
        r1.put("is_owner", r6);
        return r1;
    L5:
        r6 = "false";
        goto L6
    }

    public static void d(boolean r3, TextView r4, DocPermSetInfo r5) {
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.a() == true) goto L5;
    L12:
        if (r3 == false) goto L15;
        if (r4 == null) goto L19;
        r4.setText(2131889104);
        return;
    L19:
        return;
    L15:
        if (r4 == null) goto L21;
        r4.setText(2131889103);
        return;
    L21:
        return;
    L5:
        if (r5.getType() != 28) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == true) goto L12;
        if (r4 == null) goto L18;
        r4.setText(2131888766);
        return;
    L18:
        return;
    L7:
        r6 = false;
        goto L8
    }

    public static String a(LinkShareItem r3, int r4, boolean r5, DocPermSetInfo r6, Context r7, Boolean r8) {
        Intrinsics.checkNotNullParameter(r3, "linkShareItem");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (com.bytedance.ee.bear.middleground.permission.b.k() == false) goto L5;
        boolean r1 = false;
        if (r6.a() == true) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
    L18:
        if (r5 == false) goto L22;
        return r3.getDescription();
    L22:
        if (r6.getType() != e.q.b) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L67;
        if (r6.getType() != e.r.b) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L67;
        if (r6.getType() != 44) goto L34;
        r1 = true;
    L34:
        if (r1 == true) goto L67;
        if (r4 == 2) goto L39;
        int r11 = r3.getType();
        if (r11 == 3) goto L65;
        if (r11 == 4) goto L75;
        if (r11 == 5) goto L60;
        if (r11 == 6) goto L56;
        if (r11 == 12) goto L70;
        if (r11 == 13) goto L69;
        return r3.getDescription();
    L69:
        return r7.getString(2131888773);
    L70:
        return r7.getString(2131888775);
    L56:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L58;
        String r12 = r7.getString(2131888758);
        Intrinsics.checkNotNull(r12);
        return r12;
    L58:
        String r13 = r7.getString(2131888762);
        Intrinsics.checkNotNull(r13);
        return r13;
    L60:
        if (Intrinsics.areEqual(r8, Boolean.TRUE) == false) goto L62;
        String r14 = r7.getString(2131888760);
        Intrinsics.checkNotNull(r14);
        return r14;
    L62:
        String r15 = r7.getString(2131888764);
        Intrinsics.checkNotNull(r15);
        return r15;
    L75:
        return r7.getString(2131888770);
    L65:
        return r7.getString(2131888771);
    L39:
        return r3.getDescription();
    L29:
        r10 = false;
    L67:
        return r3.getDescription();
    L24:
        r9 = false;
        goto L25
    L12:
        if (r6.d == true) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        return r3.getDescription();
    L14:
        r2 = false;
        goto L15
    L9:
        r0 = false;
        goto L10
    L5:
        return r3.getDescription();
    }

    public static String c(LinkShareItem r3, int r4, boolean r5, DocPermSetInfo r6, Context r7, IDocPublicPermission r8) {
        Intrinsics.checkNotNullParameter(r3, "linkShareItem");
        Intrinsics.checkNotNullParameter(r7, "context");
        if (com.bytedance.ee.bear.middleground.permission.b.k() == false) goto L5;
        boolean r1 = false;
        if (r6.a() == true) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L12;
    L18:
        if (r5 == false) goto L22;
        return r3.getDescription();
    L22:
        if (r6.getType() != e.q.b) goto L24;
        boolean r9 = true;
    L25:
        if (r9 == true) goto L117;
        if (r6.getType() != e.r.b) goto L29;
        boolean r10 = true;
    L30:
        if (r10 == true) goto L117;
        if (r6.getType() != 44) goto L34;
        boolean r11 = true;
    L35:
        if (r11 == true) goto L117;
        if (r8.isLinkSharePartnerTenantRead() != true) goto L40;
        boolean r12 = true;
    L41:
        if (r12 == true) goto L115;
        if (r8.isLinkSharePartnerTenantEdit() != true) goto L45;
        boolean r13 = true;
    L46:
        if (r13 == true) goto L115;
        if (r8.adminPartnerTenantCross() != true) goto L51;
        boolean r14 = true;
    L53:
        if (r14 == false) goto L90;
        if (r6.d != true) goto L57;
        boolean r15 = true;
    L58:
        if (r15 == false) goto L88;
        if (r8.getLinkSharePartnerTenantReadBlockValue() != 1) goto L62;
        boolean r16 = true;
    L63:
        if (r16 == false) goto L65;
    L70:
        boolean r17 = false;
    L71:
        if (r17 == true) goto L86;
        if (r8.getLinkSharePartnerTenantEditBlockValue() != 1) goto L75;
        boolean r18 = true;
    L76:
        if (r18 == false) goto L78;
    L83:
        boolean r19 = false;
    L84:
        if (r19 == false) goto L90;
    L78:
        if (r8.getLinkSharePartnerTenantEditBlockValue() != 4) goto L80;
        boolean r20 = true;
    L81:
        if (r20 == true) goto L83;
        r19 = true;
        goto L84
    L80:
        r20 = false;
        goto L81
    L75:
        r18 = false;
    L86:
        return r3.getDescription();
    L65:
        if (r8.getLinkSharePartnerTenantReadBlockValue() != 4) goto L67;
        boolean r21 = true;
    L68:
        if (r21 == true) goto L70;
        r17 = true;
        goto L71
    L67:
        r21 = false;
        goto L68
    L62:
        r16 = false;
        goto L63
    L88:
        return r3.getDescription();
    L57:
        r15 = false;
    L90:
        if (r4 == 2) goto L92;
        int r22 = r3.getType();
        if (r22 == 3) goto L109;
        if (r22 == 4) goto L109;
        if (r22 == 5) goto L102;
        if (r22 == 6) goto L102;
        return r3.getDescription();
    L102:
        if (r8.hasLinkPassword() != true) goto L104;
        r1 = true;
    L104:
        if (r1 == false) goto L106;
        String r23 = xo5.a.d(r7, 2131889682, b(r3.getType(), r7));
    L107:
        Intrinsics.checkNotNull(r23);
        return r23;
    L106:
        r23 = xo5.a.d(r7, 2131889688, b(r3.getType(), r7));
    L109:
        if (r3.getType() != 3) goto L111;
        String r24 = r7.getString(2131889692);
    L113:
        return xo5.a.c(r7, 2131889687, "permType", r24);
    L111:
        r24 = r7.getString(2131889691);
        goto L113
    L92:
        return r3.getDescription();
    L51:
        r14 = false;
        goto L53
    L45:
        r13 = false;
    L115:
        return r3.getDescription();
    L40:
        r12 = false;
        goto L41
    L34:
        r11 = false;
        goto L35
    L29:
        r10 = false;
    L117:
        return r3.getDescription();
    L24:
        r9 = false;
        goto L25
    L12:
        if (r6.d == true) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L18;
        return r3.getDescription();
    L14:
        r2 = false;
        goto L15
    L9:
        r0 = false;
        goto L10
    L5:
        return r3.getDescription();
    }
}
