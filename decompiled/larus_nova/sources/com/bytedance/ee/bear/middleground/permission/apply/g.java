package com.bytedance.ee.bear.middleground.permission.apply;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.contract.NetService;
import com.larus.nova.R;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View.OnClickListener f233019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f233020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ApplyPermissionController f233021c;

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void b() {
        ApplyPermissionController r100 = this.f233021c;
        if (TextUtils.isEmpty(r100.f232873b.getOwnerId()) == true) goto L6;
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(r100.f232873b.getOwnerId(), "");
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void onBackClick() {
        View.OnClickListener r100 = this.f233019a;
        if (r100 == null) goto L5;
        r100.onClick(this.f233020b.getRootView());
        return;
    L5:
        ApplyPermissionController r101 = this.f233021c;
        com.bytedance.ee.bear.middleground.permission.c.h(r101.f232873b.getToken(), sbb.e.g(r101.f232873b.getDocumentType()), r101.f232873b.getSubType(), r101.f232873b.getFromVc(), r101.f232873b.isWiki(), r101.f232873b.getModule(), r101.f232873b.getUserPerm(), r101.f232873b.getPublicPerm(), r101.d());
        if (r101.f232874c != ApplyPermissionPageMode.NORMAL) goto L17;
        com.bytedance.ee.bear.route.h r102 = (com.bytedance.ee.bear.route.h) org.koin.java.a.c(com.bytedance.ee.bear.route.h.class, null, null, 6);
        String r103 = r101.f232873b.getOriginalBearUrlToken();
        if (r103 != null) goto L10;
        FragmentActivity r104 = r101.f232872a.getActivity();
        if (r104 == null) goto L25;
        r104.onBackPressed();
        return;
    L25:
        return;
    L10:
        if (r102.D4(r103) == true) goto L22;
        FragmentActivity r105 = r101.f232872a.getActivity();
        if (r105 == null) goto L23;
        r105.onBackPressed();
        return;
    L23:
        return;
    L22:
        return;
    L17:
        FragmentActivity r106 = r101.f232872a.getActivity();
        if (r106 == null) goto L27;
        r106.onBackPressed();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void a(View r110) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        rcb.c.d(r110);
        ApplyPermissionController r111 = this.f233021c;
        String r112 = this.f233020b.getReason();
        p r100 = r111.f232875d;
        if (r100 == null) goto L26;
        r100.a(true, r111.e());
        ApplyPermissionPageMode r101 = r111.f232874c;
        int r102 = ApplyPermissionController.b.f232879a[r101.ordinal()];
        if (r102 != 1) goto L8;
        PermApplyViewModel r103 = r111.c();
        if (r103 == null) goto L23;
        Flowable<Boolean> r104 = r103.requestPerm(r112);
        if (r104 == null) goto L23;
    L24:
        Disposable r105 = r104.observeOn(fo5.d.d()).subscribe(new k(r100, r111, r112), new l(r100, r111, r112));
        com.bytedance.ee.bear.middleground.permission.c.i(r111.f232873b.getToken(), sbb.e.g(r111.f232873b.getDocumentType()), r111.f232873b.getSubType(), r111.f232873b.getFromVc(), r111.f232873b.isWiki(), r111.f232873b.getModule(), r111.f232873b.getUserPerm(), r111.f232873b.getPublicPerm(), r111.a(), r112, r111.d());
        r111.f232876e.add(r105);
        return;
    L23:
        r104 = Flowable.just(Boolean.FALSE);
        goto L24
    L8:
        if (r102 != 2) goto L18;
        NetService r106 = (NetService) e0c.k.a(LarkContext.getApplication(), NetService.class);
        if (((a) r111.f232878g.getValue()) == null) goto L16;
        Flowable r107 = a.b(r111.f232873b.getToken(), r111.b(), r112, 1, r106);
        if (r107 == null) goto L16;
        r104 = r107.map(m.f233044a);
        if (r104 != null) goto L24;
    L16:
        r104 = Flowable.just(Boolean.FALSE);
        goto L24
    L18:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.ee.bear.middleground.permission.apply.n
    public final void c(View r110) {
        Intrinsics.checkNotNullParameter(r110, "anchor");
        rcb.c.d(r110);
        ApplyPermissionController r111 = this.f233021c;
        FragmentActivity r100 = r111.f232872a.getActivity();
        if (r100 == null) goto L14;
        com.bytedance.ee.bear.widgets.a r101 = new com.bytedance.ee.bear.widgets.a(r100);
        CharSequence r102 = r100.getText(R.string.Doc_Facade_ReadPermission);
        i r103 = new i(r111);
        if (r111.a() != 1) goto L7;
        int r104 = r100.getResources().getColor(R.color.primary_fill_default);
    L8:
        cp5.b r105 = new cp5.b();
        r105.f464689a = r102;
        r105.f464692d = false;
        r105.f464693e = null;
        r105.f464694f = r103;
        r105.f464691c = false;
        r105.f464690b = r104;
        r105.f464695g = true;
        r105.f464696h = 1.0f;
        r105.f464697i = true;
        r101.f(r105);
        CharSequence r106 = r100.getText(R.string.Doc_Facade_EditPermission);
        j r107 = new j(r111);
        if (r111.a() != 4) goto L11;
        int r112 = r100.getResources().getColor(R.color.primary_fill_default);
    L12:
        cp5.b r108 = new cp5.b();
        r108.f464689a = r106;
        r108.f464692d = false;
        r108.f464693e = null;
        r108.f464694f = r107;
        r108.f464691c = false;
        r108.f464690b = r112;
        r108.f464695g = true;
        r108.f464696h = 1.0f;
        r108.f464697i = true;
        r101.f(r108);
        r101.a();
        r101.q();
        return;
    L11:
        r112 = r100.getResources().getColor(R.color.text_title);
        goto L12
    L7:
        r104 = r100.getResources().getColor(R.color.text_title);
        goto L8
    }

    public g(View.OnClickListener r100, p0 r101, ApplyPermissionController r102) {
        this.f233019a = r100;
        this.f233020b = r101;
        this.f233021c = r102;
    }
}
