package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.q;
import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.k;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import com.bytedance.kmp.ec.yata.chain.core.EventChain;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class DynamicFeatureComponent<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> extends com.bytedance.android.shopping.prepurchase.arch.container.component.i<STATE, STORE> implements com.bytedance.android.shopping.prepurchase.arch.container.ability.f {
    public static final /* synthetic */ int l = 0;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;

    public static final class a {
    }

    public interface b extends k {
        boolean a();
    }

    static {
    }

    public final LynxAbilityImpl a2() {
        return (LynxAbilityImpl) this.k.getValue();
    }

    public final o b2() {
        return (o) this.j.getValue();
    }

    public DynamicFeatureComponent() {
        this.i = LazyKt.lazy(new DynamicFeatureComponent$provider$2(this));
        this.j = LazyKt.lazy(new DynamicFeatureComponent$sliceService$2(this));
        this.k = LazyKt.lazy(new DynamicFeatureComponent$lynxAbility$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.f
    public final LynxAbilityImpl D0() {
        return a2();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void T1() {
        super.T1();
        Z1(l.class, new DynamicFeatureComponent$onAttach$1(this, null));
        AbsComponent.Y1(this, com.bytedance.android.shopping.prepurchase.arch.container.ability.f.class, this, false, 12);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public void U1() {
        super.U1();
        o r0 = b2();
        ((com.bytedance.android.ecom.slice.ext.template.gecko.c) r0.c.getValue()).release();
        r0.a.d();
        EventChain r1 = r0.e;
        if (r1 == null) goto L5;
        r1.b();
    L5:
        LynxAbilityImpl r2 = a2();
        Iterator r3 = ((HashMap) r2.a).entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L9;
        Map.Entry r4 = (Map.Entry) r3.next();
        ECLiveHybridUtil.p(((f) r4.getValue()).a, ((f) r4.getValue()).b);
        goto L7
    L9:
        ((HashMap) r2.a).clear();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.f
    public final o r() {
        return b2();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.f
    public final DynamicViewWidgetOpt b0(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.b r0 = new com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.b(this);
        DynamicViewWidgetOpt r1 = new DynamicViewWidgetOpt(r4, O1().b());
        Intrinsics.checkNotNullParameter(r0, "sliceService");
        r1.a = r0;
        return r1;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.f
    public final void C1(q r4, boolean r5, final com.bytedance.android.shopping.prepurchase.business.pdp.services.sku.b r6) {
        Intrinsics.checkNotNullParameter(r4, "eventName");
        Intrinsics.checkNotNullParameter(r6, "subscriber");
        a2().l0(r4.b, r5, new DynamicFeatureComponent$registerDynamicHandler$1(r6));
        o r7 = b2();
        String r8 = r4.a;
        DynamicFeatureComponent$registerDynamicHandler$2 r0 = new DynamicFeatureComponent$registerDynamicHandler$2(this, r6);
        r7.getClass();
        Intrinsics.checkNotNullParameter(r8, "name");
        Intrinsics.checkNotNullParameter(r0, "actionHandler");
        ActionContext r9 = r7.a.r0;
        if (r9 == null) goto L6;
        Intrinsics.checkNotNullParameter(r8, "actionType");
        Intrinsics.checkNotNullParameter(r0, "actionHandlerCreator");
        r9.a.put(r8, r0);
        return;
    }
}
