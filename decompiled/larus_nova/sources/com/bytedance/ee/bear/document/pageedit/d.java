package com.bytedance.ee.bear.document.pageedit;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.j;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.more.protocol3.m;
import com.bytedance.ee.bear.more.protocol3.panel.y;
import com.larus.nova.R;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends com.bytedance.ee.bear.more.protocol3.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DocumentPluginHost f220813c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f220814a;

        public b(d r100) {
            this.f220814a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            this.f220814a.f220813c.getWeb().execJS("javascript:window.lark.biz.docInfo.docInfoEntryClick()");
            this.f220814a.getHost().a();
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f220815a;

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final View.OnClickListener a() {
            return null;
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final String b() {
            String r100 = d.k(this.f220815a);
            String r101 = null;
            if (Intrinsics.areEqual(r100, "network") == false) goto L13;
            FragmentActivity r102 = this.f220815a.f220813c.getActivity();
            if (r102 == null) goto L9;
            Resources r103 = r102.getResources();
            if (r103 == null) goto L9;
            r101 = r103.getString(R.string.Doc_List_OperateFailedNoNet);
        L9:
            if (r101 != null) goto L27;
            return "";
        L27:
            return r101;
        L13:
            if (Intrinsics.areEqual(r100, "admin_preview_block") == false) goto L21;
            FragmentActivity r104 = this.f220815a.f220813c.getActivity();
            if (r104 == null) goto L19;
            Resources r105 = r104.getResources();
            if (r105 == null) goto L19;
            r101 = r105.getString(R.string.CreationMobile_ECM_AdminDisableToast);
        L19:
            if (r101 != null) goto L27;
            return "";
        L21:
            FragmentActivity r106 = this.f220815a.f220813c.getActivity();
            if (r106 == null) goto L26;
            Resources r107 = r106.getResources();
            if (r107 == null) goto L26;
            r101 = r107.getString(R.string.LarkCCM_Docs_MoreMenu_PageSettings_NoPermToEditSettings_Toast_Mob);
        L26:
            if (r101 != null) goto L27;
            return "";
        }

        @Override // com.bytedance.ee.bear.more.protocol3.a
        public final boolean isEnable() {
            oj5.c r100 = this.f220815a.c();
            boolean r101 = false;
            if (r100 != null) goto L5;
        L7:
            boolean r102 = false;
        L9:
            if (y.a() == false) goto L16;
            if (r102 == true) goto L12;
        L17:
            String r103 = d.k(this.f220815a);
            String r104 = com.bytedance.ee.bear.more.protocol3.f.z.f234883c.f234853a;
            if (r101 == false) goto L20;
            String r105 = "";
        L21:
            y.b("PageEditMoreItem", r104, true, r101, r105, r103);
            return r101;
        L20:
            r105 = r103;
            goto L21
        L12:
            if (j.a.f217090a.getNetworkState().a() == false) goto L17;
            if (this.f220815a.l() == true) goto L17;
            r101 = true;
            goto L17
        L16:
            y.c("PageEditMoreItem", com.bytedance.ee.bear.more.protocol3.f.z.f234883c.f234853a);
            r101 = r102;
            goto L17
        L5:
            if (r100.n() != true) goto L7;
            r102 = true;
            goto L9
        }

        public c(d r100) {
            this.f220815a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.pageedit.d$d, reason: collision with other inner class name */
    public static final class C3146d implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f220816a;

        @Override // com.bytedance.ee.bear.more.protocol3.m
        public final boolean isVisible() {
            oj5.c r100 = this.f220816a.c();
            if (r100 == null) goto L5;
            String r101 = r100.b();
        L6:
            sbb.e r102 = sbb.e.f541304o;
            if (TextUtils.equals(r101, r102.getType()) == true) goto L18;
            oj5.c r103 = this.f220816a.c();
            if (r103 != null) goto L11;
        L13:
            boolean r104 = false;
        L14:
            if (r104 == true) goto L19;
            return false;
        L19:
            return true;
        L11:
            if (r103.getType() != r102.f541317b) goto L13;
            r104 = true;
            goto L14
        L18:
            return true;
        L5:
            r101 = null;
            goto L6
        }

        public C3146d(d r100) {
            this.f220816a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        com.bytedance.ee.bear.more.protocol3.f.z r100 = com.bytedance.ee.bear.more.protocol3.f.z.f234883c;
        b r101 = new b(this);
        ArrayList r102 = new ArrayList();
        r102.add(new c(this));
        ArrayList r103 = new ArrayList();
        r103.add(new C3146d(this));
        r103.add(new com.bytedance.ee.bear.more.protocol3.checker.a(r100.f234853a));
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r100, null, r103, r102, r101, 2);
    }

    public final boolean l() {
        oj5.c r100 = c();
        if (r100 != null) goto L5;
        return false;
    L5:
        DocPermission r101 = r100.c();
        if (r101 != null) goto L8;
        return false;
    L8:
        IDocUserPermission r102 = r101.f234419a;
        if (r102 != null) goto L12;
        return false;
    L12:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r100, r102, "PERCEIVE_CONTROL").booleanValue();
    }

    public d(DocumentPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "pluginHost");
        this.f220813c = r100;
    }

    public static final String k(d r100) {
        r100.getClass();
        if (y.a() == true) goto L6;
        return "legacy";
    L6:
        if (j.a.f217090a.getNetworkState().a() == true) goto L9;
        return "network";
    L9:
        if (r100.l() == false) goto L11;
        return "admin_preview_block";
    L11:
        oj5.c r101 = r100.c();
        if (r101 == null) goto L16;
        boolean r102 = true;
        if (r101.n() != true) goto L16;
    L17:
        if (r102 == true) goto L19;
        return "permission";
    L19:
        return "none";
    L16:
        r102 = false;
        goto L17
    }
}
