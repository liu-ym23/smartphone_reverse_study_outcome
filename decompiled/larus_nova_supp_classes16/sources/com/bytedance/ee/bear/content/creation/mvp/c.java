package com.bytedance.ee.bear.content.creation.mvp;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuConfig;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileAuthResultFrom;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements a {
    public final ArrayList<SelectCreationMenuItem> a;
    public final ArrayList<SelectCreationMenuItem> b;
    public final SelectCreationMenuConfig c;
    public final Context d;

    public final void create() {
    }

    public final void destroy() {
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.a
    public final ArrayList<SelectCreationMenuItem> D3() {
        return this.a;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.a
    public final ArrayList<SelectCreationMenuItem> p7() {
        return this.b;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.a
    public final void n8(boolean r24) {
        BenefitStore r0 = ((BenefitManagerAPI) org.koin.java.a.a(BenefitManagerAPI.class)).n1();
        boolean r2 = r0.hasBenefit("ccm_create_doc");
        boolean r3 = r0.hasBenefit("ccm_create_base");
        tt5.a.h("SelectCreationMenuModel", "canCreateDocs = " + r2 + ", ccmCanCreateBitable = " + r3);
        if (this.c.p == false) goto L6;
        if (r2 == false) goto L6;
        boolean r11 = true;
    L7:
        this.a.clear();
        this.b.clear();
        gj5.c r8 = new gj5.c(true, FileAuthResultFrom.COME_FROM_UNKNOWN);
        if (r11 == false) goto L22;
        ArrayList<SelectCreationMenuItem> r5 = this.a;
        SelectCreationMenuItem.ItemType r13 = SelectCreationMenuItem.ItemType.ADD_DOCX;
        String r12 = this.d.getString(2131887745);
        String r14 = (String) com.bytedance.ee.bear.appsetting.c.a.a.d("docx_i18n_name", "");
        if (TextUtils.isEmpty(r14) == false) goto L85;
    L19:
        String r16 = r12;
    L20:
        r5.add(new SelectCreationMenuItem(r13, r16, kac.a.b(2131254436), this.c.i, true, r8));
        goto L22
    L85:
        r16 = new JSONObject(r14).optString(((i0) org.koin.java.a.a(i0.class)).a(), "");     // Catch: JSONException -> L17
        if (TextUtils.isEmpty(r16) == true) goto L19;
        tt5.a.h("SelectCreationMenuModel", "parseDocXName()...docXName = " + r16);     // Catch: JSONException -> L15
    L15:
        e = e;
        r12 = r16;
    L18:
        tt5.a.d("SelectCreationMenuModel", "parseDocXName()...error = " + e);
    L17:
        e = e;
    L22:
        if (this.c.c == false) goto L25;
        if (r2 == false) goto L25;
        boolean r1 = true;
    L26:
        if (r1 == false) goto L28;
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_SHEET, this.d.getText(2131887733), kac.a.b(2131254696), this.c.b, true, r8));
    L28:
        SelectCreationMenuConfig r4 = this.c;
        if (r4.q == false) goto L32;
        if (r3 == false) goto L32;
        boolean r19 = true;
    L34:
        if (r4.l == false) goto L37;
        if (r2 == false) goto L37;
        boolean r20 = true;
    L39:
        if (r19 == true) goto L50;
        if (r20 == false) goto L50;
        if (r11 == false) goto L47;
        if (r24 == true) goto L47;
        if (r4.m == true) goto L47;
        boolean r17 = false;
    L48:
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_MINDNOTE, this.d.getText(2131887774), kac.a.b(2131254561), this.c.e, r17, r8));
    L47:
        r17 = true;
    L50:
        if (this.c.o == false) goto L53;
        if (r3 == false) goto L53;
        boolean r6 = true;
    L54:
        if (r6 == false) goto L56;
        int r18 = 2131887774;
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_BITABLE, this.d.getText(2131887893), kac.a.b(2131254400), this.c.h, r24, r8));
    L57:
        if (r19 == false) goto L70;
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_SURVEY, this.d.getText(2131886600), kac.a.b(2131254460), this.c.j, r24, r8));
        if (r20 == false) goto L70;
        if (r11 == false) goto L66;
        if (r24 == true) goto L66;
        if (this.c.m == true) goto L66;
        boolean r110 = false;
    L67:
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_MINDNOTE, this.d.getText(r18), kac.a.b(2131254561), this.c.e, r110, r8));
    L66:
        r110 = true;
    L70:
        if (this.c.n == false) goto L73;
        this.a.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.ADD_FOLDER, this.d.getText(2131887732), kac.a.b(2131254455), this.c.d, r24, r8));
    L73:
        if (this.c.k == false) goto L87;
        if (r11 == false) goto L76;
        int r7 = 2131256095;
    L77:
        int r9 = kac.a.b(r7);
        if (r11 == false) goto L80;
        int r10 = 2131254464;
    L81:
        int r21 = kac.a.b(r10);
        PermissionResponse r22 = ((ph5.b) org.koin.java.a.a(ph5.b.class)).f(new PermissionRequest(new BaseEntity("", sbb.e.l, BizDomain.FileBizDomainCCM, r7), "UPLOAD"), null);
        this.b.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.UPLOAD_PHOTOS, this.d.getText(2131887224), r21, this.c.f, r24, r22));
        this.b.add(new SelectCreationMenuItem(SelectCreationMenuItem.ItemType.UPLOAD_FILE, this.d.getText(2131887223), r9, this.c.g, r24, r22));
        return;
    L80:
        r10 = 2131254905;
        goto L81
    L76:
        r7 = 2131256094;
        goto L77
    L87:
        return;
    L56:
        r18 = 2131887774;
    L53:
        r6 = false;
    L37:
        r20 = false;
    L32:
        r19 = false;
    L25:
        r1 = false;
    L6:
        r11 = false;
        goto L7
    }

    public c(SelectCreationMenuConfig r2, Context r3) {
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = r2;
        this.d = r3;
    }
}
