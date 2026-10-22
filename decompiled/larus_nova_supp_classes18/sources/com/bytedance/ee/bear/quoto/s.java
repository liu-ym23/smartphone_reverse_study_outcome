package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements v {
    public final View a;
    public final DialogFragment b;
    public final Context c;
    public AtUserSupportTextView d;
    public final boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final String i;
    public final String j;
    public final View.OnClickListener k;
    public final boolean l;
    public final boolean m;

    @Override // com.bytedance.ee.bear.quoto.v
    public final void w0() {
        this.f = false;
        this.g = true;
        String r1 = this.c.getResources().getString(2131887143);
        if (this.j == null) goto L5;
        r1 = r1 + this.j;
    L5:
        this.d.setText(r1);
        this.a.setVisibility(0);
        c.b(this.m, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
    }

    public final void create() {
        View r0 = this.a.findViewById(2131370202);
        if (r0 != null) goto L5;
    L9:
        this.d = this.a.findViewById(2131387517);
        ((Button) this.a.findViewById(2131369396)).setOnClickListener(new q(this));
        return;
    L5:
        if (this.l == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        goto L9
    L7:
        r1 = 8;
        goto L8
    }

    public final void destroy() {
        boolean r0 = this.m;
        com.bytedance.ee.bear.contract.d r1 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r2 = this.f;
        boolean r3 = this.g;
        boolean r4 = this.e;
        if (this.h == false) goto L5;
        String r5 = "confirm";
    L6:
        c.a(r0, r1, r2, r3, r4, r5, "none");
        return;
    L5:
        r5 = "close";
        goto L6
    }

    public static String h(float r3) {
        return new DecimalFormat("0.00").format(((r3 / 1024.0f) / 1024.0f) / 1024.0f);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void n4(QuotaInfoResult.DataDTO.ContactsDTO r8) {
        this.f = false;
        this.g = false;
        HashMap r1 = new HashMap(3);
        r1.put("Name", "@" + r8.getName());
        ArrayList r2 = new ArrayList();
        r2.add(new ov4.b(this.c, r8.getUid(), r8.getName(), new p(this, false)));
        String r9 = xo5.a.d(this.c, 2131889772, r1);
        if (this.j == null) goto L5;
        r9 = r9 + this.j;
    L5:
        this.d.y(r9, r2);
        this.a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
    }

    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r1) {
        v.a r2 = (v.a) r1;
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void C5(QuotaInfoResult.DataDTO.UrlLink r9, long r10, long r12) {
        this.f = true;
        this.g = false;
        HashMap r2 = new HashMap(3);
        r2.put("num", h(r10));
        r2.put("totalnum", h(r12));
        r2.put("HelpDocs", "@");
        StringBuilder r11 = new StringBuilder();
        r11.append(xo5.a.d(this.c, 2131888821, r2));
        int r13 = r11.indexOf("@") + 1;
        r11.replace(r13, r13 + 1, r9.getTitle());
        String r14 = this.j;
        if (r14 == null) goto L5;
        r11.append(r14);
    L5:
        this.d.x(r11.toString(), new ov4.b(this.c, " ", r9.getTitle(), new o(r9.getUrl())));
        this.a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void k5(QuotaInfoResult.DataDTO.ContactsDTO r8, long r9, long r11) {
        this.f = false;
        this.g = false;
        HashMap r1 = new HashMap(3);
        r1.put("num", h(r9));
        r1.put("totalnum", h(r11));
        r1.put("name", "@" + r8.getName());
        ArrayList r10 = new ArrayList();
        ov4.b r12 = new ov4.b(this.c, r8.getUid(), r8.getName(), new p(this, false));
        ov4.b r13 = new ov4.b(this.c, r8.getUid(), r8.getName(), new p(this, false));
        r10.add(r12);
        r10.add(r13);
        String r14 = xo5.a.d(this.c, 2131888818, r1);
        if (this.j == null) goto L5;
        r14 = r14 + this.j;
    L5:
        this.d.y(r14, r10);
        this.a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void y5(QuotaInfoResult.DataDTO.UrlLink r9, String r10, long r11) {
        this.f = true;
        this.g = false;
        HashMap r2 = new HashMap(3);
        r2.put("departname", r10);
        r2.put("totalnum", h(r11));
        r2.put("HelpDocs", "@");
        StringBuilder r12 = new StringBuilder();
        r12.append(xo5.a.d(this.c, 2131888817, r2));
        int r13 = r12.indexOf("@") + 1;
        r12.replace(r13, r13 + 1, r9.getTitle());
        String r14 = this.j;
        if (r14 == null) goto L5;
        r12.append(r14);
    L5:
        this.d.x(r12.toString(), new ov4.b(this.c, " ", r9.getTitle(), new o(r9.getUrl())));
        this.a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void A1(long r17, long r19, List<QuotaInfoResult.DataDTO.ContactsDTO> r21, int r22) {
        this.f = true;
        this.g = false;
        HashMap r4 = new HashMap();
        r4.put("num", h(r17));
        r4.put("totalnum", h(r19));
        r4.put("Admin", "default_name");
        StringBuilder r5 = new StringBuilder();
        if (r22 != 0) goto L5;
        r5.append(xo5.a.d(this.c, 2131888819, r4));
    L6:
        ArrayList r6 = new ArrayList();
        int r7 = r5.indexOf("default_name");
        StringBuilder r8 = new StringBuilder("@");
        String r9 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a();
        int r10 = 0;
    L8:
        if (r10 >= r21.size()) goto L26;
        if (r22 != 0) goto L13;
        if (r10 > 2) goto L26;
    L13:
        if (r22 != 1) goto L16;
        if (r10 > 9) goto L26;
    L16:
        QuotaInfoResult.DataDTO.ContactsDTO r13 = (QuotaInfoResult.DataDTO.ContactsDTO) ListProtector.get(r21, r10);
        String r3 = ou5.a.a(r9, r13.getDisplayName(), r13.getName(), r13.getEnName());
        if (r22 != 0) goto L19;
        if (r10 >= 2) goto L19;
    L22:
        if (r10 >= (r21.size() - 1)) goto L24;
        r8.append(r3);
        r8.append("、@");
    L25:
        r6.add(new ov4.b(this.c, r13.getUid(), r3, new p(this, true)));
        r10 = r10 + 1;
    L24:
        r8.append(r3);
    L19:
        if (r22 != 1) goto L24;
        if (r10 >= 9) goto L24;
    L26:
        r5.replace(r7, r7 + 12, r8.toString());
        String r1 = this.j;
        if (r1 == null) goto L29;
        r5.append(r1);
    L29:
        this.d.y(r5.toString(), r6);
        this.a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
        return;
    L5:
        r5.append(xo5.a.d(this.c, 2131888820, r4));
        goto L6
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void x5(long r17, List<QuotaInfoResult.DataDTO.ContactsDTO> r19, String r20, int r21) {
        this.f = true;
        this.g = false;
        HashMap r4 = new HashMap();
        r4.put("departname", r20);
        r4.put("totalnum", h(r17));
        r4.put("Admin", "default_name");
        StringBuilder r5 = new StringBuilder();
        if (r21 != 0) goto L5;
        r5.append(xo5.a.d(this.c, 2131888815, r4));
    L6:
        ArrayList r6 = new ArrayList();
        int r7 = r5.indexOf("default_name");
        StringBuilder r8 = new StringBuilder("@");
        String r9 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a();
        int r10 = 0;
    L8:
        if (r10 >= r19.size()) goto L26;
        if (r21 != 0) goto L13;
        if (r10 > 2) goto L26;
    L13:
        if (r21 != 1) goto L16;
        if (r10 > 9) goto L26;
    L16:
        QuotaInfoResult.DataDTO.ContactsDTO r13 = (QuotaInfoResult.DataDTO.ContactsDTO) ListProtector.get(r19, r10);
        String r3 = ou5.a.a(r9, r13.getDisplayName(), r13.getName(), r13.getEnName());
        if (r21 != 0) goto L19;
        if (r10 >= 2) goto L19;
    L22:
        if (r10 >= (r19.size() - 1)) goto L24;
        r8.append(r3);
        r8.append("、@");
    L25:
        r6.add(new ov4.b(this.c, r13.getUid(), r3, new p(this, true)));
        r10 = r10 + 1;
    L24:
        r8.append(r3);
    L19:
        if (r21 != 1) goto L24;
        if (r10 >= 9) goto L24;
    L26:
        r5.replace(r7, r7 + 12, r8.toString());
        String r1 = this.j;
        if (r1 == null) goto L29;
        r5.append(r1);
    L29:
        this.d.y(r5.toString(), r6);
        this.a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f, this.g, this.e, this.i);
        return;
    L5:
        r5.append(xo5.a.d(this.c, 2131888816, r4));
        goto L6
    }

    public s(View r2, DialogFragment r3, Context r4, boolean r5, String r6, String r7, boolean r8, boolean r9, View.OnClickListener r10) {
        this.j = "";
        this.l = true;
        this.m = false;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.e = r5;
        this.i = r6;
        this.j = r7;
        this.l = r9;
        this.k = r10;
        this.m = r8;
    }
}
