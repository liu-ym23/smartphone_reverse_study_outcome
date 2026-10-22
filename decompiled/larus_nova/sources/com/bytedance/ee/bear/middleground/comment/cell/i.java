package com.bytedance.ee.bear.middleground.comment.cell;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.route.parcelable.DriveRouteBean;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.MentionUserState;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.nova.R;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements un5.a.InterfaceC7903a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f231057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f231058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Activity f231059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f231060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f231061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f231062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function1<String, Boolean> f231063g;

    public interface a {
        void a(String r100, String r101, MentionUserState r102);

        void b(String r100);

        void c(String r100);

        boolean isSameSpace(String r100);
    }

    @Override // un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        if (this.f231058b == true) goto L6;
        return;
    L6:
        if (this.f231059c == null) goto L101;
        if (r100 == null) goto L102;
        boolean r101 = true;
        boolean r102 = false;
        if ((r100 instanceof un5.e) == false) goto L56;
        un5.e r103 = (un5.e) r100;
        String r104 = r103.f550787e;
        int r105 = r103.getType();
        a r106 = this.f231060d;
        if (r106 == null) goto L16;
        if (r106.isSameSpace(r104) == false) goto L16;
        return;
    L16:
        if (r105 != 12) goto L19;
        DriveRouteBean r107 = new DriveRouteBean();
        ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).m9(r103.f550787e, r107);
    L94:
        a r108 = this.f231060d;
        if (r108 == null) goto L103;
        if (r102 == true) goto L104;
        r108.b(r104);
        return;
    L104:
        return;
    L103:
        return;
    L19:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("apaas.miaoda.migrate_to_ccm") == true) goto L21;
        boolean r109 = false;
    L22:
        if (r109 == false) goto L54;
        String r110 = r103.f550787e;
        if (TextUtils.isEmpty(r110) == true) goto L33;
        Uri r111 = UriProtector.parse(r110);
        String r112 = r111.getScheme();
        if (TextUtils.isEmpty(r111.getHost()) == true) goto L33;
        if (TextUtils.equals("http", r112) == false) goto L31;
    L32:
        boolean r113 = true;
    L35:
        if (r113 == false) goto L48;
        Function1<String, Boolean> r114 = this.f231063g;
        if (r114 == null) goto L48;
    L45:
        Activity r115 = this.f231059c;
        if (r115 == null) goto L51;
        Toast.showFailureText(r115, R.string.Doc_Facade_OperateFailed);
    L51:
        r101 = false;
    L52:
        if (r101 == true) goto L94;
        return;
    L40:
        if (Boolean.TRUE.equals(r114.invoke(r110)) == true) goto L52;
        Activity r116 = this.f231059c;     // Catch: RuntimeException -> L45
        if (r116 == null) goto L51;
        Toast.showFailureText(r116, R.string.Doc_Facade_OperateFailed);     // Catch: RuntimeException -> L45
    L48:
        Activity r117 = this.f231059c;
        if (r117 == null) goto L51;
        Toast.showFailureText(r117, R.string.Doc_Facade_OperateFailed);
        goto L51
    L31:
        if (TextUtils.equals("https", r112) == true) goto L32;
    L33:
        r113 = false;
        goto L35
    L54:
        this.f231063g.invoke(r103.f550787e);
        goto L94
    L21:
        r109 = sbb.g.b(r105);
        goto L22
    L56:
        if ((r100 instanceof un5.l) == false) goto L86;
        un5.l r118 = (un5.l) r100;
        boolean r119 = r118.f550821j;
        if (r119 == true) goto L61;
        MentionUserState r120 = MentionUserState.PERMITTED;
    L64:
        if (r119 == false) goto L73;
        a r121 = this.f231060d;
        if (r121 == null) goto L73;
        if (r118.f550822k == false) goto L70;
    L71:
        r121.a(r118.f550815d, r118.f550820i, r120);
        return;
    L70:
        if (this.f231057a == true) goto L71;
    L73:
        a r122 = this.f231060d;
        if (r122 == null) goto L79;
        if (this.f231061e == true) goto L79;
        r122.c(r118.f550815d);
    L79:
        if (this.f231062f != 2) goto L81;
    L84:
        r102 = r101;
    L93:
        r104 = "";
        goto L94
    L81:
        if (this.f231061e == true) goto L84;
        r101 = false;
        goto L84
    L61:
        if (r118.f550822k == false) goto L63;
        r120 = MentionUserState.NO_PERMISSION_SHARABLE;
        goto L64
    L63:
        r120 = MentionUserState.NO_PERMISSION_UNSHARABLE_ASK_OWNER;
        goto L64
    L86:
        if ((r100 instanceof un5.h) == false) goto L93;
        r104 = ((un5.h) r100).f550805d;
        a r123 = this.f231060d;
        if (r123 != null) goto L90;
    L92:
        this.f231063g.invoke(r104);
        goto L94
    L90:
        if (r123.isSameSpace(r104) == false) goto L92;
        return;
    L102:
        return;
    }

    public i(Activity r100, com.bytedance.ee.bear.middleground.comment.f r101) {
        com.bytedance.ee.bear.appsetting.c r102 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r102.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        this.f231057a = r103;
        this.f231058b = true;
        this.f231059c = r100;
        this.f231061e = false;
        this.f231062f = 1;
        this.f231063g = r101;
        return;
    L5:
        if (r102.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r103 = true;
        goto L8
    }

    public i(FragmentActivity r100, boolean r101, Function1 r102) {
        com.bytedance.ee.bear.appsetting.c r103 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r103.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.f231057a = r104;
        this.f231058b = true;
        this.f231059c = r100;
        this.f231061e = r101;
        this.f231062f = 1;
        this.f231063g = r102;
        return;
    L5:
        if (r103.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r104 = true;
        goto L8
    }
}
