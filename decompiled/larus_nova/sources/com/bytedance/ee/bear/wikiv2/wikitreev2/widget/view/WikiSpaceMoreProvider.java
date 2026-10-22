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
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiSpaceMoreProvider extends BaseMoreProvider {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f242290v = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Context f242291m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final NetService f242292n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final BenefitManagerAPI f242293o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final com.bytedance.ee.bear.more.b f242294p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final TreeNode f242295q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c f242296r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SpaceInfo f242297s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SpacePerm f242298t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public BenefitStore f242299u;

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
        BenefitStore r100 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).n1();
        BenefitStore r101 = this.f242299u;
        if (r101 != null) goto L16;
        TreeNode r102 = this.f242295q;
        String r103 = r102.obj_token;
        int r104 = r102.obj_type;
        if (r103 != null) goto L7;
    L10:
        boolean r105 = true;
    L11:
        if (r105 == true) goto L15;
        r101 = ((BenefitManagerAPI) org.koin.java.a.c(BenefitManagerAPI.class, null, null, 6)).g7(this.f242295q.obj_token, r104, BenefitManagerAPI.CacheType.TOKEN);
        if (Intrinsics.areEqual(r101.getFrom(), BenefitStore.FROM_MOCK) == true) goto L16;
        this.f242299u = r101;
        goto L16
    L15:
        r101 = new BenefitStore("", new LinkedHashMap(), "", null, false, 24, null);
        goto L16
    L7:
        if (r103.length() == 0) goto L10;
        r105 = false;
    L16:
        l(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.d.a(this.f242295q, r100, r101, this.f242294p));
        sj5.b r106 = f();
        if (r106 == null) goto L21;
        MoreFragmentV3 r107 = r106.getHostFragment();
        if (r107 == null) goto L21;
        com.bytedance.ee.bear.contract.j.a.f217090a.a().observe(r107, new o0(this));
    L21:
        a3 r108 = a3.f241764a;
        String r109 = this.f242295q.space_id;
        r108.getClass();
        Disposable r110 = a3.a(r109).subscribe(new p0(this), new q0(this));
        Intrinsics.checkNotNullParameter(r110, "<this>");
        this.f234893h.add(r110);
        NetService r111 = this.f242292n;
        if (r111 == null) goto L25;
        Disposable r112 = com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.l0.b(r111).a(new GetRootPermPuller.Params(this.f242295q.space_id)).subscribe(new r0(this), new s0(this));
        Intrinsics.checkNotNullParameter(r112, "<this>");
        this.f234893h.add(r112);
        return;
    }

    public final Context getContext() {
        return this.f242291m;
    }

    public WikiSpaceMoreProvider(Context r100, NetService r101, BenefitManagerAPI r102, com.bytedance.ee.bear.more.b r103, TreeNode r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r104, "wikiNode");
        this.f242291m = r100;
        this.f242292n = r101;
        this.f242293o = r102;
        this.f242294p = r103;
        this.f242295q = r104;
        this.f242296r = new com.bytedance.ee.bear.wikiv2.wikitreev2.ai.c();
    }
}
