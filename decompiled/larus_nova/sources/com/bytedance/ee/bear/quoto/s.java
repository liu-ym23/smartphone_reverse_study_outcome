package com.bytedance.ee.bear.quoto;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.bizwidget.at.AtUserSupportTextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.framework.mvp.IView;
import com.larus.nova.R;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class s implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f236427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DialogFragment f236428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f236429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtUserSupportTextView f236430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f236431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f236432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f236433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f236434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f236435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f236436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final View.OnClickListener f236437k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f236438l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f236439m;

    @Override // com.bytedance.ee.bear.quoto.v
    public final void w0() {
        this.f236432f = false;
        this.f236433g = true;
        String r100 = this.f236429c.getResources().getString(R.string.CreationMobile_Common_storage_full_toast);
        if (this.f236436j == null) goto L5;
        r100 = r100 + this.f236436j;
    L5:
        this.f236430d.setText(r100);
        this.f236427a.setVisibility(0);
        c.b(this.f236439m, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        View r100 = this.f236427a.findViewById(R.id.dragView);
        if (r100 != null) goto L5;
    L9:
        this.f236430d = (AtUserSupportTextView) this.f236427a.findViewById(R.id.subTitle);
        ((Button) this.f236427a.findViewById(R.id.done)).setOnClickListener(new q(this));
        return;
    L5:
        if (this.f236438l == false) goto L7;
        int r101 = 0;
    L8:
        r100.setVisibility(r101);
        goto L9
    L7:
        r101 = 8;
        goto L8
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        boolean r100 = this.f236439m;
        com.bytedance.ee.bear.contract.d r101 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class);
        boolean r102 = this.f236432f;
        boolean r103 = this.f236433g;
        boolean r104 = this.f236431e;
        if (this.f236434h == false) goto L5;
        String r105 = "confirm";
    L6:
        c.a(r100, r101, r102, r103, r104, r105, "none");
        return;
    L5:
        r105 = "close";
        goto L6
    }

    public static String h(float r100) {
        return new DecimalFormat("0.00").format(((r100 / 1024.0f) / 1024.0f) / 1024.0f);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void n4(QuotaInfoResult.DataDTO.ContactsDTO r100) {
        this.f236432f = false;
        this.f236433g = false;
        HashMap r101 = new HashMap(3);
        r101.put("Name", "@" + r100.getName());
        ArrayList r102 = new ArrayList();
        r102.add(new ov4.b(this.f236429c, r100.getUid(), r100.getName(), new p(this, false)));
        String r103 = xo5.a.d(this.f236429c, R.string.LarkCCM_StorageLimitByDepart_FreeUpSpaceToContinue_Toast, r101);
        if (this.f236436j == null) goto L5;
        r103 = r103 + this.f236436j;
    L5:
        this.f236430d.y(r103, r102);
        this.f236427a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
    }

    @Override // com.larksuite.framework.mvp.IView
    public final /* bridge */ /* synthetic */ void setViewDelegate(IView.IViewDelegate r100) {
        v.a r101 = (v.a) r100;
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void C5(QuotaInfoResult.DataDTO.UrlLink r100, long r110, long r111) {
        this.f236432f = true;
        this.f236433g = false;
        HashMap r101 = new HashMap(3);
        r101.put("num", h(r110));
        r101.put("totalnum", h(r111));
        r101.put("HelpDocs", "@");
        StringBuilder r112 = new StringBuilder();
        r112.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Personal_ViewHelpDocsForStorage_Desc, r101));
        int r113 = r112.indexOf("@") + 1;
        r112.replace(r113, r113 + 1, r100.getTitle());
        String r114 = this.f236436j;
        if (r114 == null) goto L5;
        r112.append(r114);
    L5:
        this.f236430d.x(r112.toString(), new ov4.b(this.f236429c, " ", r100.getTitle(), new o(r100.getUrl())));
        this.f236427a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void k5(QuotaInfoResult.DataDTO.ContactsDTO r100, long r101, long r110) {
        this.f236432f = false;
        this.f236433g = false;
        HashMap r102 = new HashMap(3);
        r102.put("num", h(r101));
        r102.put("totalnum", h(r110));
        r102.put("name", "@" + r100.getName());
        ArrayList r103 = new ArrayList();
        ov4.b r111 = new ov4.b(this.f236429c, r100.getUid(), r100.getName(), new p(this, false));
        ov4.b r112 = new ov4.b(this.f236429c, r100.getUid(), r100.getName(), new p(this, false));
        r103.add(r111);
        r103.add(r112);
        String r104 = xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_DocOwner_FreeUpSpaceToProceed_Desc, r102);
        if (this.f236436j == null) goto L5;
        r104 = r104 + this.f236436j;
    L5:
        this.f236430d.y(r104, r103);
        this.f236427a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void y5(QuotaInfoResult.DataDTO.UrlLink r100, String r110, long r111) {
        this.f236432f = true;
        this.f236433g = false;
        HashMap r101 = new HashMap(3);
        r101.put("departname", r110);
        r101.put("totalnum", h(r111));
        r101.put("HelpDocs", "@");
        StringBuilder r112 = new StringBuilder();
        r112.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Depart_ViewHelpDocsForStorage_Desc, r101));
        int r113 = r112.indexOf("@") + 1;
        r112.replace(r113, r113 + 1, r100.getTitle());
        String r114 = this.f236436j;
        if (r114 == null) goto L5;
        r112.append(r114);
    L5:
        this.f236430d.x(r112.toString(), new ov4.b(this.f236429c, " ", r100.getTitle(), new o(r100.getUrl())));
        this.f236427a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void A1(long r110, long r111, List<QuotaInfoResult.DataDTO.ContactsDTO> r210, int r211) {
        this.f236432f = true;
        this.f236433g = false;
        HashMap r100 = new HashMap();
        r100.put("num", h(r110));
        r100.put("totalnum", h(r111));
        r100.put("Admin", "default_name");
        StringBuilder r101 = new StringBuilder();
        if (r211 != 0) goto L5;
        r101.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Personal_ContactMultiAdminsForStorage_Desc, r100));
    L6:
        ArrayList r102 = new ArrayList();
        int r103 = r101.indexOf("default_name");
        StringBuilder r104 = new StringBuilder("@");
        String r105 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a();
        int r106 = 0;
    L8:
        if (r106 >= r210.size()) goto L26;
        if (r211 != 0) goto L13;
        if (r106 > 2) goto L26;
    L13:
        if (r211 != 1) goto L16;
        if (r106 > 9) goto L26;
    L16:
        QuotaInfoResult.DataDTO.ContactsDTO r112 = (QuotaInfoResult.DataDTO.ContactsDTO) ListProtector.get(r210, r106);
        String r107 = ou5.a.a(r105, r112.getDisplayName(), r112.getName(), r112.getEnName());
        if (r211 != 0) goto L19;
        if (r106 >= 2) goto L19;
    L22:
        if (r106 >= (r210.size() - 1)) goto L24;
        r104.append(r107);
        r104.append("、@");
    L25:
        r102.add(new ov4.b(this.f236429c, r112.getUid(), r107, new p(this, true)));
        r106 = r106 + 1;
    L24:
        r104.append(r107);
    L19:
        if (r211 != 1) goto L24;
        if (r106 >= 9) goto L24;
    L26:
        r101.replace(r103, r103 + 12, r104.toString());
        String r108 = this.f236436j;
        if (r108 == null) goto L29;
        r101.append(r108);
    L29:
        this.f236430d.y(r101.toString(), r102);
        this.f236427a.setVisibility(0);
        c.b(false, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
        return;
    L5:
        r101.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Personal_ContactOneAdminForStorage_Desc, r100));
        goto L6
    }

    @Override // com.bytedance.ee.bear.quoto.v
    public final void x5(long r110, List<QuotaInfoResult.DataDTO.ContactsDTO> r111, String r210, int r211) {
        this.f236432f = true;
        this.f236433g = false;
        HashMap r100 = new HashMap();
        r100.put("departname", r210);
        r100.put("totalnum", h(r110));
        r100.put("Admin", "default_name");
        StringBuilder r101 = new StringBuilder();
        if (r211 != 0) goto L5;
        r101.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Depart_ContactMultiAdminsForStorage_Desc, r100));
    L6:
        ArrayList r102 = new ArrayList();
        int r103 = r101.indexOf("default_name");
        StringBuilder r104 = new StringBuilder("@");
        String r105 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.a(com.bytedance.ee.bear.contract.i0.class)).a();
        int r106 = 0;
    L8:
        if (r106 >= r111.size()) goto L26;
        if (r211 != 0) goto L13;
        if (r106 > 2) goto L26;
    L13:
        if (r211 != 1) goto L16;
        if (r106 > 9) goto L26;
    L16:
        QuotaInfoResult.DataDTO.ContactsDTO r112 = (QuotaInfoResult.DataDTO.ContactsDTO) ListProtector.get(r111, r106);
        String r107 = ou5.a.a(r105, r112.getDisplayName(), r112.getName(), r112.getEnName());
        if (r211 != 0) goto L19;
        if (r106 >= 2) goto L19;
    L22:
        if (r106 >= (r111.size() - 1)) goto L24;
        r104.append(r107);
        r104.append("、@");
    L25:
        r102.add(new ov4.b(this.f236429c, r112.getUid(), r107, new p(this, true)));
        r106 = r106 + 1;
    L24:
        r104.append(r107);
    L19:
        if (r211 != 1) goto L24;
        if (r106 >= 9) goto L24;
    L26:
        r101.replace(r103, r103 + 12, r104.toString());
        String r108 = this.f236436j;
        if (r108 == null) goto L29;
        r101.append(r108);
    L29:
        this.f236430d.y(r101.toString(), r102);
        this.f236427a.setVisibility(0);
        c.b(true, (com.bytedance.ee.bear.contract.d) org.koin.java.a.a(com.bytedance.ee.bear.contract.d.class), this.f236432f, this.f236433g, this.f236431e, this.f236435i);
        return;
    L5:
        r101.append(xo5.a.d(this.f236429c, R.string.LarkCCM_CM_StorageMgmt_Depart_ContactOneAdminForStorage_Desc, r100));
        goto L6
    }

    public s(View r100, DialogFragment r101, Context r102, boolean r103, String r104, String r105, boolean r106, boolean r107, View.OnClickListener r110) {
        this.f236436j = "";
        this.f236438l = true;
        this.f236439m = false;
        this.f236427a = r100;
        this.f236428b = r101;
        this.f236429c = r102;
        this.f236431e = r103;
        this.f236435i = r104;
        this.f236436j = r105;
        this.f236438l = r107;
        this.f236437k = r110;
        this.f236439m = r106;
    }
}
