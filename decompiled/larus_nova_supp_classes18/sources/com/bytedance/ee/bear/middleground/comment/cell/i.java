package com.bytedance.ee.bear.middleground.comment.cell;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.route.parcelable.DriveRouteBean;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.ee.bear.route.RouteBean;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements un5.a.InterfaceC0318a {
    public final boolean a;
    public final boolean b;
    public final Activity c;
    public a d;
    public final boolean e;
    public final int f;
    public final Function1<String, Boolean> g;

    public interface a {
        void a(String r1, String r2, MentionUserState r3);

        void b(String r1);

        void c(String r1);

        boolean isSameSpace(String r1);
    }

    @Override // un5.a.InterfaceC0318a
    public final void B3(un5.a r7) {
        if (this.b == true) goto L6;
        return;
    L6:
        if (this.c == null) goto L101;
        if (r7 == null) goto L102;
        boolean r1 = true;
        boolean r2 = false;
        if ((r7 instanceof un5.e) == false) goto L56;
        un5.e r8 = (un5.e) r7;
        String r0 = r8.e;
        int r3 = r8.getType();
        a r4 = this.d;
        if (r4 == null) goto L16;
        if (r4.isSameSpace(r0) == false) goto L16;
        return;
    L16:
        if (r3 != 12) goto L19;
        RouteBean r5 = new DriveRouteBean();
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r8.e, r5);
    L94:
        a r9 = this.d;
        if (r9 == null) goto L103;
        if (r2 == true) goto L104;
        r9.b(r0);
        return;
    L104:
        return;
    L103:
        return;
    L19:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("apaas.miaoda.migrate_to_ccm") == true) goto L21;
        boolean r6 = false;
    L22:
        if (r6 == false) goto L54;
        String r10 = r8.e;
        if (TextUtils.isEmpty(r10) == true) goto L33;
        Uri r11 = UriProtector.parse(r10);
        String r12 = r11.getScheme();
        if (TextUtils.isEmpty(r11.getHost()) == true) goto L33;
        if (TextUtils.equals("http", r12) == false) goto L31;
    L32:
        boolean r13 = true;
    L35:
        if (r13 == false) goto L48;
        Function1<String, Boolean> r14 = this.g;
        if (r14 == null) goto L48;
    L45:
        Activity r15 = this.c;
        if (r15 == null) goto L51;
        Toast.showFailureText(r15, 2131887802);
    L51:
        r1 = false;
    L52:
        if (r1 == true) goto L94;
        return;
    L40:
        if (Boolean.TRUE.equals(r14.invoke(r10)) == true) goto L52;
        Activity r16 = this.c;     // Catch: RuntimeException -> L45
        if (r16 == null) goto L51;
        Toast.showFailureText(r16, 2131887802);     // Catch: RuntimeException -> L45
    L48:
        Activity r17 = this.c;
        if (r17 == null) goto L51;
        Toast.showFailureText(r17, 2131887802);
        goto L51
    L31:
        if (TextUtils.equals("https", r12) == true) goto L32;
    L33:
        r13 = false;
        goto L35
    L54:
        this.g.invoke(r8.e);
        goto L94
    L21:
        r6 = sbb.g.b(r3);
        goto L22
    L56:
        if ((r7 instanceof un5.l) == false) goto L86;
        un5.l r18 = (un5.l) r7;
        boolean r19 = r18.j;
        if (r19 == true) goto L61;
        MentionUserState r20 = MentionUserState.PERMITTED;
    L64:
        if (r19 == false) goto L73;
        a r21 = this.d;
        if (r21 == null) goto L73;
        if (r18.k == false) goto L70;
    L71:
        r21.a(r18.d, r18.i, r20);
        return;
    L70:
        if (this.a == true) goto L71;
    L73:
        a r22 = this.d;
        if (r22 == null) goto L79;
        if (this.e == true) goto L79;
        r22.c(r18.d);
    L79:
        if (this.f != 2) goto L81;
    L84:
        r2 = r1;
    L93:
        r0 = "";
        goto L94
    L81:
        if (this.e == true) goto L84;
        r1 = false;
        goto L84
    L61:
        if (r18.k == false) goto L63;
        r20 = MentionUserState.NO_PERMISSION_SHARABLE;
        goto L64
    L63:
        r20 = MentionUserState.NO_PERMISSION_UNSHARABLE_ASK_OWNER;
        goto L64
    L86:
        if ((r7 instanceof un5.h) == false) goto L93;
        r0 = ((un5.h) r7).d;
        a r23 = this.d;
        if (r23 != null) goto L90;
    L92:
        this.g.invoke(r0);
        goto L94
    L90:
        if (r23.isSameSpace(r0) == false) goto L92;
        return;
    L102:
        return;
    }

    public i(Activity r5, com.bytedance.ee.bear.middleground.comment.f r6) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.a = r1;
        this.b = true;
        this.c = r5;
        this.e = false;
        this.f = 1;
        this.g = r6;
        return;
    L5:
        if (r0.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r1 = true;
        goto L8
    }

    public i(FragmentActivity r4, boolean r5, Function1 r6) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r1 = false;
    L8:
        this.a = r1;
        this.b = true;
        this.c = r4;
        this.e = r5;
        this.f = 1;
        this.g = r6;
        return;
    L5:
        if (r0.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r1 = true;
        goto L8
    }
}
