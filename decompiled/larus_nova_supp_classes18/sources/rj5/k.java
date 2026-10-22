package rj5;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.DocFreshInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.more.fresh.DocFreshNessFragment;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import java.util.Locale;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k extends com.bytedance.ee.bear.more.protocol3.g {

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ k a;

        public b(k r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r21) {
            k r1 = this.a;
            r1.getClass();
            oj5.a r2 = (oj5.a) r1.d(oj5.a.class);
            if (r2 == null) goto L39;
            DocMetaInfo r3 = r2.g;
            if (r3 == null) goto L40;
            DocFreshInfo r4 = r3.getFreshInfo();
            if (r4 == null) goto L41;
            int r5 = r4.getFreshState();
            Bundle r6 = r1.getHost().getHostFragment().getArguments();
            String r7 = r2.c;
            int r8 = r2.getType();
            String r9 = r2.b();
            if (r5 != 0) goto L14;
            String r10 = "docs_timeliness_no_setting";
        L24:
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
            com.bytedance.ee.bear.more.c.c(new com.bytedance.ee.bear.more.i(r6, r7, r8, false, r9, r10, "none", "", "", r2 instanceof oj5.f, r2.k, r2.r, r2.isOwner(), r2.L()));
            FragmentActivity r11 = r1.getHost().getHostFragment().getActivity();
            if (com.bytedance.ee.util.ui.b.a(r11) == false) goto L42;
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(com.bytedance.ee.bear.more.protocol3.f.s.c.a);
            if (r11 == null) goto L34;
            int r12 = DocFreshNessFragment.s;
            Serializable r13 = r2.g;
            String r14 = r2.c;
            int r15 = r2.getType();
            Intrinsics.checkNotNullParameter(r11, "activity");
            Intrinsics.checkNotNullParameter(r13, "meta");
            Intrinsics.checkNotNullParameter(r14, "objToken");
            DocFreshNessFragment r16 = new DocFreshNessFragment();
            Bundle r17 = new Bundle();
            r17.putSerializable("extra_meta", r13);
            r17.putString("extra_token", r14);
            r17.putInt("extra_type", r15);
            r16.setArguments(r17);
            FragmentManager r18 = r11.getSupportFragmentManager();
            LandscapeRestrictionOperation r19 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r16, "DocFreshNessFragment", r19);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r18, r16, r19) == true) goto L34;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L36
        L33:
            r16.show(r18, "DocFreshNessFragment");
        L34:
            r1.getHost().a();
            return;
        L42:
            return;
        L14:
            if (r5 != 1) goto L16;
            r10 = "docs_timeliness_maybe_overdue";
            goto L24
        L16:
            if (r5 != 2) goto L18;
            r10 = "docs_timeliness_overdue";
            goto L24
        L18:
            if (r5 == 3) goto L20;
            r10 = "";
            goto L24
        L20:
            r10 = "docs_timeliness_newest";
            goto L24
        L41:
            return;
        L40:
            return;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.g
    public final com.bytedance.ee.bear.more.protocol3.k a() {
        oj5.a r0 = (oj5.a) d(oj5.a.class);
        if (r0 != null) goto L5;
        return null;
    L5:
        DocMetaInfo r2 = r0.g;
        if (r2 != null) goto L8;
        return null;
    L8:
        DocFreshInfo r3 = r2.getFreshInfo();
        if (r3 != null) goto L11;
        return null;
    L11:
        String r4 = e(pj5.m.a(r3.getFreshState()));
        int r5 = r3.getFreshState();
        int r6 = -1;
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L17;
        if (r5 == 3) goto L16;
        int r7 = -1;
    L19:
        int r9 = r3.getFreshState();
        if (r9 == 2) goto L24;
        if (r9 != 3) goto L25;
        r6 = 2131102145;
    L25:
        boolean r8 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).b();
        String r10 = ((com.bytedance.ee.bear.contract.i0) org.koin.java.a.c(com.bytedance.ee.bear.contract.i0.class, null, null, 6)).a();
        boolean r11 = Intrinsics.areEqual(Locale.CHINESE.getLanguage(), r10);
        boolean r12 = false;
        if (r3.getFreshState() != 1) goto L31;
        if (r3.getFeedBackNum() >= r3.getMaxExpiredShowNum()) goto L31;
        r11 = false;
    L31:
        if (r0.getType() == sbb.e.g.b) goto L33;
        boolean r13 = true;
    L34:
        com.bytedance.ee.bear.more.protocol3.f.s r14 = com.bytedance.ee.bear.more.protocol3.f.s.c;
        com.bytedance.ee.bear.more.protocol3.e.b r15 = new com.bytedance.ee.bear.more.protocol3.e.b(r6, r4, r11, r7);
        BizChecker[] r16 = new BizChecker[2];
        if (r8 == true) goto L44;
        AccountService.Account r1 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r1 == null) goto L40;
        String r17 = r1.tenantId;
        if (r17 == null) goto L40;
    L42:
        if (TextUtils.equals(r17, r0.a()) == false) goto L44;
        boolean r18 = true;
    L45:
        r16[0] = new BizChecker(r18);
        if (r0.isOwner() == false) goto L49;
        if (r13 == false) goto L49;
        r12 = true;
    L49:
        r16[1] = new BizChecker(r12);
        return h(r14, r15, CollectionsKt.listOf(r16), CollectionsKt.emptyList(), new b(this));
    L40:
        r17 = "";
    L44:
        r18 = false;
        goto L45
    L33:
        r13 = false;
        goto L34
    L24:
        r6 = 2131102420;
        goto L25
    L16:
        r7 = 2131256120;
        goto L19
    L17:
        r7 = 2131255223;
        goto L19
    L18:
        r7 = 2131256185;
        goto L19
    }

    public k() {
    }
}
