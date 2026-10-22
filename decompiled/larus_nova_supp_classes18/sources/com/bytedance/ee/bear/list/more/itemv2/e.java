package com.bytedance.ee.bear.list.more.itemv2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.ee.bear.lynx.api.CCMLynxPageRouter;
import com.bytedance.ee.bear.more.i;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.more.protocol3.f;
import com.bytedance.ee.bear.more.protocol3.g;
import com.bytedance.ee.bear.more.protocol3.h;
import com.bytedance.ee.bear.more.protocol3.j;
import com.bytedance.ee.bear.more.protocol3.k;
import com.bytedance.ee.bear.retention.RetentionSettingVisible;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends g {
    public boolean c;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r21) {
            e r1 = this.a;
            r1.getClass();
            oj5.a r2 = (oj5.a) r1.d(oj5.a.class);
            if (r2 == null) goto L31;
            Context r3 = r1.getHost().getHostFragment().getContext();
            if (r3 == null) goto L32;
            tt5.a.b("RetentionLabelItem", "openRetentionLabelPage.");
            HashMap r4 = new HashMap();
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().getClass();
            r4.put("host", bi5.a.b());
            r4.put(ResourceData.KEY_TOKEN, r2.c);
            r4.put(ResourceData.KEY_TYPE, Integer.valueOf(r2.getType()));
            Bundle r5 = r1.getHost().getHostFragment().getArguments();
            if (r5 == null) goto L22;
            String r8 = r5.getString("module", "");
            String r11 = r5.getString("sub_module", "");
            String r13 = r5.getString("container_id", "");
            String r6 = r5.getString("container_type", "");
            if (TextUtils.isEmpty(r13) == true) goto L14;
            r4.put("container_id", du5.b.g(r13));
        L14:
            if (TextUtils.isEmpty(r6) == true) goto L17;
            r4.put("container_type", r6);
        L17:
            if (TextUtils.isEmpty(r8) == true) goto L20;
            r4.put("_module", r8);
        L20:
            if (TextUtils.isEmpty(r11) == true) goto L22;
            r4.put("sub_module", r11);
        L22:
            r4.put("file_id", du5.b.g(r2.c));
            r4.put("file_type", sbb.e.f(r2.getType()));
            if (TextUtils.isEmpty(r2.b()) == true) goto L25;
            r4.put("sub_file_type", r2.b());
        L25:
            ((CCMLynxPageRouter) org.koin.java.a.c(CCMLynxPageRouter.class, null, null, 6)).a(r3, r4);
            com.bytedance.ee.bear.more.b r7 = (com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6);
            Bundle r9 = r1.getHost().getHostFragment().getArguments();
            String r10 = r2.c;
            int r12 = r2.getType();
            String r14 = r2.b();
            if (r2.getType() != sbb.e.n.b) goto L28;
            boolean r15 = true;
        L29:
            r7.c(new i(r9, r10, r12, false, r14, "retention", "ccm_space_retention_setting_view", "", "", r15, false, r2.r, r2.isOwner(), r2.L()));
            r1.getHost().a();
            return;
        L28:
            r15 = false;
            goto L29
        L32:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ e a;

        public c(e r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            this.a.c = ((RetentionSettingVisible) r2).isCanSetRetentionLabel();
            tt5.a.h("RetentionLabelItem", "fetchRetentionLabel ok: " + this.a.c);
            this.a.f();
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e("RetentionLabelItem", "fetchRetentionSettingVisible err", r5, false);
        }
    }

    static {
    }

    public static boolean k() {
        boolean r0 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1().hasBenefit("admin_security_retention");
        tt5.a.h("RetentionLabelItem", "getRetentionLabelBenefits() hasBenefit: " + r0);
        return r0;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final k a() {
        f.e0 r1 = f.e0.c;
        b r5 = new b(this);
        j[] r2 = new j[4];
        boolean r4 = com.bytedance.ee.bear.appsetting.c.a.a.g("suite.admin.vault.retention_new");
        tt5.a.h("RetentionLabelItem", "isRetentionLabelFgEnable: " + r4);
        if (r4 == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        r2[0] = new BizChecker(r6);
        oj5.c r7 = c();
        if (r7 == null) goto L12;
        boolean r8 = r7.m();
    L13:
        r2[1] = new BizChecker(!r8);
        r2[2] = new com.bytedance.ee.bear.more.protocol3.checker.b(new sbb.e[]{sbb.e.g, sbb.e.o, sbb.e.h, sbb.e.i, sbb.e.k, sbb.e.l, sbb.e.m, sbb.e.t, sbb.e.u});
        r2[3] = new BizChecker(this.c);
        return g.i(this, r1, null, CollectionsKt.listOf(r2), null, r5, 10);
    L12:
        r8 = false;
        goto L13
    L5:
        if (k() == true) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g, com.bytedance.ee.bear.more.protocol3.b, com.bytedance.ee.bear.more.moreprotocol.ITextMoreItem, com.bytedance.ee.bear.more.moreprotocol.IIconFontMoreItem
    public final void create() {
        oj5.c r0 = c();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = com.bytedance.ee.bear.appsetting.c.a.a.g("suite.admin.vault.retention_new");
        tt5.a.h("RetentionLabelItem", "isRetentionLabelFgEnable: " + r1);
        tt5.a.h("RetentionLabelItem", "isRetentionLabelFgEnable: " + r1);
        boolean r2 = k();
        tt5.a.h("RetentionLabelItem", "hasBenefit: " + r2);
        if (r0.getType() == sbb.e.n.b) goto L15;
        if (r1 == true) goto L9;
        if (r2 == true) goto L9;
        return;
    L9:
        h r3 = null;
        Disposable r4 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().d(r0.getType(), r0.getToken()).subscribe(new c(this), d.a);
        Intrinsics.checkNotNullParameter(r4, "<this>");
        h r5 = this.a;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("hostProvider");
    L13:
        r3.h.add(r4);
        return;
    L12:
        r3 = r5;
        goto L13
    }

    public e() {
    }
}
