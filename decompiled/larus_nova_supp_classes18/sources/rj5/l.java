package rj5;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.DocFreshInfo;
import com.bytedance.ee.bear.DocMetaInfo;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.more.fresh.ExpiredContentReasonFragment;
import com.bytedance.ee.bear.more.protocol3.checker.BizChecker;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.io.Serializable;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l extends com.bytedance.ee.bear.more.protocol3.g {

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ l a;

        public b(l r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r24) {
            l r1 = this.a;
            r1.getClass();
            oj5.a r2 = (oj5.a) r1.d(oj5.a.class);
            if (r2 == null) goto L30;
            String r3 = r2.c;
            int r4 = r2.getType();
            if (r4 == 16) goto L8;
        L13:
            ((com.bytedance.ee.bear.more.b) org.koin.java.a.c(com.bytedance.ee.bear.more.b.class, null, null, 6)).b(com.bytedance.ee.bear.more.protocol3.f.r.c.a);
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type com.bytedance.ee.bear.more.export.DocMoreInfo");
            com.bytedance.ee.bear.more.c.c(new com.bytedance.ee.bear.more.i(r1.getHost().getHostFragment().getArguments(), r2.c, r2.getType(), false, r2.b(), "reminde_update", "none", "", "", r2 instanceof oj5.f, r2.k, r2.r, r2.isOwner(), r2.L()));
            sj5.b r5 = r1.getHost();
            if (r5 == null) goto L18;
            MoreFragmentV3 r6 = r5.getHostFragment();
            if (r6 == null) goto L18;
            FragmentActivity r7 = r6.getActivity();
        L19:
            if (r7 == null) goto L25;
            int r8 = ExpiredContentReasonFragment.l;
            Serializable r9 = r2.g;
            Intrinsics.checkNotNullParameter(r7, "activity");
            Intrinsics.checkNotNullParameter(r3, "objToken");
            Intrinsics.checkNotNullParameter(r9, "docMetaInfo");
            ExpiredContentReasonFragment r10 = new ExpiredContentReasonFragment();
            Bundle r11 = new Bundle();
            r11.putString("extra_token", r3);
            r11.putInt("extra_type", r4);
            r11.putSerializable("extra_meta", r9);
            r10.setArguments(r11);
            FragmentManager r12 = r7.getSupportFragmentManager();
            LandscapeRestrictionOperation r13 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r10, "ExpiredContentReasonFragment", r13);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r12, r10, r13) == true) goto L25;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
        L24:
            r10.show(r12, "ExpiredContentReasonFragment");
        L25:
            r1.getHost().a();
            return;
        L18:
            r7 = null;
            goto L19
        L8:
            if (r2.o.length() <= 0) goto L10;
            boolean r14 = true;
        L11:
            if (r14 == false) goto L13;
            r3 = r2.o + "";
            r4 = r2.i();
            goto L13
        L10:
            r14 = false;
            goto L11
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
        boolean r4 = ((com.bytedance.ee.bear.contract.b0) org.koin.java.a.c(com.bytedance.ee.bear.contract.b0.class, null, null, 6)).b();
        int r5 = r3.getFreshState();
        boolean r6 = false;
        if (r5 != 2) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == true) goto L19;
    L21:
        boolean r8 = false;
    L22:
        com.bytedance.ee.bear.more.protocol3.f.r r9 = com.bytedance.ee.bear.more.protocol3.f.r.c;
        com.bytedance.ee.bear.more.protocol3.e.c r10 = new com.bytedance.ee.bear.more.protocol3.e.c();
        BizChecker[] r11 = new BizChecker[2];
        if (r4 == true) goto L32;
        AccountService.Account r1 = ((com.bytedance.ee.bear.contract.h0) org.koin.java.a.c(com.bytedance.ee.bear.contract.h0.class, null, null, 6)).G2();
        if (r1 == null) goto L28;
        String r12 = r1.tenantId;
        if (r12 == null) goto L28;
    L30:
        if (TextUtils.equals(r12, r0.a()) == false) goto L32;
        boolean r13 = true;
    L33:
        r11[0] = new BizChecker(r13);
        if (r8 == true) goto L36;
    L38:
        r11[1] = new BizChecker(r6);
        return h(r9, r10, CollectionsKt.listOf(r11), CollectionsKt.emptyList(), new b(this));
    L36:
        if (r0.isOwner() == true) goto L38;
        r6 = true;
    L28:
        r12 = "";
    L32:
        r13 = false;
        goto L33
    L19:
        if (r0.getType() == sbb.e.g.b) goto L21;
        r8 = true;
        goto L22
    L14:
        if (r5 == 3) goto L16;
        r7 = true;
        goto L17
    }

    public l() {
    }
}
