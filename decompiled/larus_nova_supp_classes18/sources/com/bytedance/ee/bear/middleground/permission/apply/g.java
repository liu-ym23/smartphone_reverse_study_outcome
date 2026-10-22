package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements n {
    public final /* synthetic */ View.OnClickListener a;
    public final /* synthetic */ p b;
    public final /* synthetic */ ApplyPermissionController c;

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void b() {
        ApplyPermissionController r0 = this.c;
        if (TextUtils.isEmpty(r0.b.getOwnerId()) == true) goto L6;
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(r0.b.getOwnerId(), "");
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void onBackClick() {
        View.OnClickListener r0 = this.a;
        if (r0 == null) goto L5;
        r0.onClick(this.b.getRootView());
        return;
    L5:
        ApplyPermissionController r1 = this.c;
        com.bytedance.ee.bear.middleground.permission.c.h(r1.b.getToken(), sbb.e.g(r1.b.getDocumentType()), r1.b.getSubType(), r1.b.getFromVc(), r1.b.isWiki(), r1.b.getModule(), r1.b.getUserPerm(), r1.b.getPublicPerm(), r1.d());
        if (r1.c != ApplyPermissionPageMode.NORMAL) goto L17;
        com.bytedance.ee.bear.route.h r2 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r3 = r1.b.getOriginalBearUrlToken();
        if (r3 != null) goto L10;
        FragmentActivity r4 = r1.a.getActivity();
        if (r4 == null) goto L25;
        r4.onBackPressed();
        return;
    L25:
        return;
    L10:
        if (r2.D4(r3) == true) goto L22;
        FragmentActivity r5 = r1.a.getActivity();
        if (r5 == null) goto L23;
        r5.onBackPressed();
        return;
    L23:
        return;
    L22:
        return;
    L17:
        FragmentActivity r6 = r1.a.getActivity();
        if (r6 == null) goto L27;
        r6.onBackPressed();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void a(View r13) {
        Intrinsics.checkNotNullParameter(r13, "anchor");
        rcb.c.d(r13);
        ApplyPermissionController r14 = this.c;
        String r10 = this.b.getReason();
        p r0 = r14.d;
        if (r0 == null) goto L26;
        r0.a(true, r14.e());
        ApplyPermissionPageMode r1 = r14.c;
        int r2 = ApplyPermissionController.b.a[r1.ordinal()];
        if (r2 != 1) goto L8;
        PermApplyViewModel r3 = r14.c();
        if (r3 == null) goto L23;
        Flowable<Boolean> r4 = r3.requestPerm(r10);
        if (r4 == null) goto L23;
    L24:
        Disposable r5 = r4.observeOn(fo5.d.d()).subscribe(new k(r0, r14, r10), new l(r0, r14, r10));
        com.bytedance.ee.bear.middleground.permission.c.i(r14.b.getToken(), sbb.e.g(r14.b.getDocumentType()), r14.b.getSubType(), r14.b.getFromVc(), r14.b.isWiki(), r14.b.getModule(), r14.b.getUserPerm(), r14.b.getPublicPerm(), r14.a(), r10, r14.d());
        r14.e.add(r5);
        return;
    L23:
        r4 = Flowable.just(Boolean.FALSE);
        goto L24
    L8:
        if (r2 != 2) goto L18;
        NetService r6 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        if (((a) r14.g.getValue()) == null) goto L16;
        Flowable r7 = a.b(r14.b.getToken(), r14.b(), r10, 1, r6);
        if (r7 == null) goto L16;
        r4 = r7.map(m.a);
        if (r4 != null) goto L24;
    L16:
        r4 = Flowable.just(Boolean.FALSE);
        goto L24
    L18:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void c(View r12) {
        Intrinsics.checkNotNullParameter(r12, "anchor");
        rcb.c.d(r12);
        ApplyPermissionController r13 = this.c;
        FragmentActivity r0 = r13.a.getActivity();
        if (r0 == null) goto L14;
        com.bytedance.ee.bear.widgets.a r1 = new com.bytedance.ee.bear.widgets.a(r0);
        CharSequence r2 = r0.getText(2131887806);
        i r3 = new i(r13);
        if (r13.a() != 1) goto L7;
        int r4 = r0.getResources().getColor(2131105548);
    L8:
        cp5.b r8 = new cp5.b();
        r8.a = r2;
        r8.d = false;
        r8.e = null;
        r8.f = r3;
        r8.c = false;
        r8.b = r4;
        r8.g = true;
        r8.h = 1.0f;
        r8.i = true;
        r1.f(r8);
        CharSequence r5 = r0.getText(2131887750);
        j r9 = new j(r13);
        if (r13.a() != 4) goto L11;
        int r14 = r0.getResources().getColor(2131105548);
    L12:
        cp5.b r6 = new cp5.b();
        r6.a = r5;
        r6.d = false;
        r6.e = null;
        r6.f = r9;
        r6.c = false;
        r6.b = r14;
        r6.g = true;
        r6.h = 1.0f;
        r6.i = true;
        r1.f(r6);
        r1.a();
        r1.q();
        return;
    L11:
        r14 = r0.getResources().getColor(2131106622);
        goto L12
    L7:
        r4 = r0.getResources().getColor(2131106622);
        goto L8
    }

    public g(View.OnClickListener r1, p0 r2, ApplyPermissionController r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
