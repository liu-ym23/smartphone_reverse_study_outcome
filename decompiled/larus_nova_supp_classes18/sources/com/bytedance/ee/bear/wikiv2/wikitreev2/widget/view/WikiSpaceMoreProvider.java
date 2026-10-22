package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import android.content.Context;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import com.bytedance.ee.bear.more.view3.MoreFragmentV3;
import com.bytedance.ee.bear.unbundle.BenefitManagerAPI;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetRootPermPuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpacePerm;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.a3;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiSpaceMoreProvider extends BaseMoreProvider {
    public static final /* synthetic */ int v = 0;
    public final Context m;
    public final NetService n;
    public final BenefitManagerAPI o;
    public final com.bytedance.ee.bear.more.b p;
    public final TreeNode q;
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c r;
    public SpaceInfo s;
    public SpacePerm t;
    public BenefitStore u;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new WikiSpaceMoreProvider$buildMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        BenefitStore r0 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        BenefitStore r3 = this.u;
        if (r3 != null) goto L16;
        TreeNode r4 = this.q;
        String r5 = r4.obj_token;
        int r6 = r4.obj_type;
        if (r5 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == true) goto L15;
        r3 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).g7(this.q.obj_token, r6, BenefitManagerAPI.CacheType.TOKEN);
        if (Intrinsics.areEqual(r3.getFrom(), BenefitStore.FROM_MOCK) == true) goto L16;
        this.u = r3;
        goto L16
    L15:
        r3 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L16
    L7:
        if (r5.length() == 0) goto L10;
        r7 = false;
    L16:
        l(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.a(this.q, r0, r3, this.p));
        sj5.b r1 = f();
        if (r1 == null) goto L21;
        MoreFragmentV3 r2 = r1.getHostFragment();
        if (r2 == null) goto L21;
        com.bytedance.ee.bear.contract.j.a.a.a().observe(r2, new o0(this));
    L21:
        a3 r8 = a3.a;
        String r9 = this.q.space_id;
        r8.getClass();
        Disposable r10 = a3.a(r9).subscribe(new p0(this), new q0(this));
        Intrinsics.checkNotNullParameter(r10, "<this>");
        this.h.add(r10);
        NetService r11 = this.n;
        if (r11 == null) goto L25;
        Disposable r12 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.b(r11).a(new GetRootPermPuller.Params(this.q.space_id)).subscribe(new r0(this), new s0(this));
        Intrinsics.checkNotNullParameter(r12, "<this>");
        this.h.add(r12);
        return;
    }

    public final Context getContext() {
        return this.m;
    }

    public WikiSpaceMoreProvider(Context r2, NetService r3, BenefitManagerAPI r4, com.bytedance.ee.bear.more.b r5, TreeNode r6) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r6, "wikiNode");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        this.p = r5;
        this.q = r6;
        this.r = new com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c();
    }
}
