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
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends com.bytedance.ee.bear.more.protocol3.g {
    public final DocumentPluginHost c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ d a;

        public b(d r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.a.c.getWeb().execJS("javascript:window.lark.biz.docInfo.docInfoEntryClick()");
            this.a.getHost().a();
        }
    }

    public static final class c implements com.bytedance.ee.bear.more.protocol3.a {
        public final /* synthetic */ d a;

        public final View.OnClickListener a() {
            return null;
        }

        public final String b() {
            String r0 = d.k(this.a);
            String r3 = null;
            if (Intrinsics.areEqual(r0, "network") == false) goto L13;
            FragmentActivity r1 = this.a.c.getActivity();
            if (r1 == null) goto L9;
            Resources r2 = r1.getResources();
            if (r2 == null) goto L9;
            r3 = r2.getString(2131887951);
        L9:
            if (r3 != null) goto L27;
            return "";
        L27:
            return r3;
        L13:
            if (Intrinsics.areEqual(r0, "admin_preview_block") == false) goto L21;
            FragmentActivity r4 = this.a.c.getActivity();
            if (r4 == null) goto L19;
            Resources r5 = r4.getResources();
            if (r5 == null) goto L19;
            r3 = r5.getString(2131887246);
        L19:
            if (r3 != null) goto L27;
            return "";
        L21:
            FragmentActivity r6 = this.a.c.getActivity();
            if (r6 == null) goto L26;
            Resources r7 = r6.getResources();
            if (r7 == null) goto L26;
            r3 = r7.getString(2131889132);
        L26:
            if (r3 != null) goto L27;
            return "";
        }

        public final boolean isEnable() {
            oj5.c r0 = this.a.c();
            boolean r1 = false;
            if (r0 != null) goto L5;
        L7:
            boolean r2 = false;
        L9:
            if (y.a() == false) goto L16;
            if (r2 == true) goto L12;
        L17:
            String r8 = d.k(this.a);
            String r4 = ((com.bytedance.ee.bear.more.protocol3.f) com.bytedance.ee.bear.more.protocol3.f.z.c).a;
            if (r1 == false) goto L20;
            String r7 = "";
        L21:
            y.b("PageEditMoreItem", r4, true, r1, r7, r8);
            return r1;
        L20:
            r7 = r8;
            goto L21
        L12:
            if (j.a.a.getNetworkState().a() == false) goto L17;
            if (this.a.l() == true) goto L17;
            r1 = true;
            goto L17
        L16:
            y.c("PageEditMoreItem", ((com.bytedance.ee.bear.more.protocol3.f) com.bytedance.ee.bear.more.protocol3.f.z.c).a);
            r1 = r2;
            goto L17
        L5:
            if (r0.n() != true) goto L7;
            r2 = true;
            goto L9
        }

        public c(d r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.pageedit.d$d, reason: collision with other inner class name */
    public static final class C0090d implements m {
        public final /* synthetic */ d a;

        public final boolean isVisible() {
            oj5.c r0 = this.a.c();
            if (r0 == null) goto L5;
            String r1 = r0.b();
        L6:
            sbb.e r2 = sbb.e.o;
            if (TextUtils.equals(r1, r2.getType()) == true) goto L18;
            oj5.c r3 = this.a.c();
            if (r3 != null) goto L11;
        L13:
            boolean r4 = false;
        L14:
            if (r4 == true) goto L19;
            return false;
        L19:
            return true;
        L11:
            if (r3.getType() != r2.b) goto L13;
            r4 = true;
            goto L14
        L18:
            return true;
        L5:
            r1 = null;
            goto L6
        }

        public C0090d(d r1) {
            this.a = r1;
        }
    }

    static {
    }

    public final k a() {
        com.bytedance.ee.bear.more.protocol3.f.z r1 = com.bytedance.ee.bear.more.protocol3.f.z.c;
        b r5 = new b(this);
        ArrayList r4 = new ArrayList();
        r4.add(new c(this));
        ArrayList r3 = new ArrayList();
        r3.add(new C0090d(this));
        r3.add(new com.bytedance.ee.bear.more.protocol3.checker.a(((com.bytedance.ee.bear.more.protocol3.f) r1).a));
        return com.bytedance.ee.bear.more.protocol3.g.i(this, r1, null, r3, r4, r5, 2);
    }

    public final boolean l() {
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return false;
    L5:
        DocPermission r2 = r0.c();
        if (r2 != null) goto L8;
        return false;
    L8:
        IDocUserPermission r3 = r2.a;
        if (r3 != null) goto L12;
        return false;
    L12:
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).v(r0, r3, "PERCEIVE_CONTROL").booleanValue();
    }

    public d(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginHost");
        this.c = r2;
    }

    public static final String k(d r1) {
        r1.getClass();
        if (y.a() == true) goto L6;
        return "legacy";
    L6:
        if (j.a.a.getNetworkState().a() == true) goto L9;
        return "network";
    L9:
        if (r1.l() == false) goto L11;
        return "admin_preview_block";
    L11:
        oj5.c r2 = r1.c();
        if (r2 == null) goto L16;
        boolean r0 = true;
        if (r2.n() != true) goto L16;
    L17:
        if (r0 == true) goto L19;
        return "permission";
    L19:
        return "none";
    L16:
        r0 = false;
        goto L17
    }
}
