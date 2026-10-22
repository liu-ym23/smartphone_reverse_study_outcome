package com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;
import com.bytedance.android.ec.adapter.api.messagev2.model.TraceTimeMetricV2;
import com.bytedance.android.ec.sdk.helper.q;
import com.bytedance.android.livesdk.livecommerce.network.response.PromotionCategory;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.LivePromotionListBaseSubRepo;
import com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.monitor.LivePromotionListRepositoryMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mj2.c;
import tj2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class LivePromotionListCategoryRepository extends LivePromotionListBaseSubRepo implements a {
    public final com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a c;
    public final tj2.b d;
    public final Function0<tj2.a> e;
    public final Function0<qj2.a> f;

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a
    public final void d() {
        MutableLiveData r0 = this.c.c();
        if (r0 == null) goto L35;
        d r1 = (d) r0.getValue();
        if (r1 == null) goto L36;
        tj2.b r2 = this.d;
        PromotionCategory r3 = r2.b();
        ArrayList r4 = null;
        if (r3 == null) goto L9;
        String r5 = r3.getUniqueIndex();
    L10:
        if (r5 != null) goto L12;
        r5 = "";
    L12:
        LiveData<PagedList<c>> r6 = this.c.d();
        if (r6 == null) goto L28;
        PagedList r7 = (PagedList) r6.getValue();
        if (r7 == null) goto L28;
        List r8 = r7.snapshot();
        if (r8 == null) goto L28;
        ArrayList r9 = new ArrayList();
        Iterator r10 = r8.iterator();
    L20:
        if (r10.hasNext() == false) goto L27;
        c r11 = (c) r10.next();
        if (r11 == null) goto L24;
        ql.a r12 = r11.a;
    L25:
        if (r12 == null) goto L20;
        r9.add(r12);
        goto L20
    L24:
        r12 = null;
        goto L25
    L27:
        r4 = r9;
    L28:
        r2.j(r5, r4, r1.getStartPosition(), r1.b(), r1.c(), r1.d());
        return;
    L9:
        r5 = null;
        goto L10
    L36:
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a
    public final PromotionCategory e() {
        return this.d.b();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a
    public final void g() {
        this.d.i();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a
    public final void a(PromotionCategory r2) {
        Intrinsics.checkNotNullParameter(r2, "newSelectedTab");
        d();
        this.d.l(r2);
        com.bytedance.android.livesdk.livecommerce.promotionlist.repository.c r0 = this.c.h();
        if (r0 == null) goto L5;
        r0.b = r2.getUniqueIndex();
    L5:
        i(7, null);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.a
    public final void f(final si2.c r10) {
        Intrinsics.checkNotNullParameter(r10, "message");
        int r0 = sj2.a.a;
        sj2.a.a("[repo] recv category refresh message, enableHandle=" + this.c.g());
        if (this.c.g() == true) goto L5;
        return;
    L5:
        int r1 = pj2.b.a;
        sg2.b r2 = r10.getCommon();
        if (r2 == null) goto L8;
        String r3 = r2.a;
    L9:
        int r4 = LivePromotionListRepositoryMonitor.c;
        Intrinsics.checkNotNullParameter(r10, "$this$serverTimeGap");
        long r5 = System.currentTimeMillis();
        sg2.b r6 = r10.getCommon();
        if (r6 == null) goto L14;
        TraceTimeMetricV2 r7 = r6.d;
        if (r7 == null) goto L14;
        long r8 = r7.getOpTimestamp();
    L15:
        k(new pj2.a.c("category_msg", r3, MapsKt.mapOf(TuplesKt.to("server_to_local", String.valueOf(r5 - r8)))));
        Function0<Unit> r9 = new LivePromotionListCategoryRepository$onRecvCategoryRefreshMessage$1(this, r10);
        q r11 = q.a;
        if (r10.updateTimeStamp < r11.getLong("ec_category_refresh_timestamp", 0)) goto L19;
        r9.invoke();
        r11.e("ec_category_refresh_timestamp", r10.updateTimeStamp);
        return;
    L19:
        return;
    L14:
        r8 = 0;
        goto L15
    L8:
        r3 = null;
        goto L9
    }

    public final void l(String r1, boolean r2) {
        if (r2 == false) goto L4;
        this.d.m();
        return;
    L4:
        tj2.b r3 = this.d;
        if (r1 != null) goto L7;
        r1 = "";
    L7:
        r3.e(r1);
    }

    public LivePromotionListCategoryRepository(com.bytedance.android.livesdk.livecommerce.promotionlist.opt.repo.base.a r2, com.bytedance.android.livesdk.livecommerce.promotionlist.repository.datasource.a r3, Function0 r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r2, "repoContext");
        Intrinsics.checkNotNullParameter(r3, "localDataSource");
        Intrinsics.checkNotNullParameter(r4, "fragmentCallback");
        Intrinsics.checkNotNullParameter(r5, "listStateProvider");
        super(r2);
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
    }
}
