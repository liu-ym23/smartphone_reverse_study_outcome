package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.l;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/bytedance/android/shopping/prepurchase/arch/container/state/h;", "STATE", "STORE", "Lcom/bytedance/android/ecom/arch/slice/action/l;", "Lcom/bytedance/android/ecom/arch/slice/action/SlcCommonAction;", "invoke", "()Lcom/bytedance/android/ecom/arch/slice/action/l;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class DynamicFeatureComponent$registerDynamicHandler$2 extends Lambda implements Function0<l<SlcCommonAction>> {
    final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.ability.d $subscriber;
    final /* synthetic */ DynamicFeatureComponent this$0;

    public static final class a implements l<SlcCommonAction> {
        public final /* synthetic */ DynamicFeatureComponent$registerDynamicHandler$2 a;

        public a(DynamicFeatureComponent$registerDynamicHandler$2 r1) {
            this.a = r1;
        }

        public final void handle(ActionContext r1, IAction r2, com.bytedance.android.ecom.arch.slice.action.c r3, final com.bytedance.android.ecom.arch.slice.action.i r4) {
            SlcCommonAction r5 = (SlcCommonAction) r2;
            Intrinsics.checkNotNullParameter(r1, "actionContext");
            Intrinsics.checkNotNullParameter(r5, "action");
            Map<String, ? extends Object> r6 = r5.getParams();
            if (r6 != null) goto L5;
            r6 = MapsKt.emptyMap();
        L5:
            this.a.$subscriber.a(r6, new DynamicFeatureComponent$registerDynamicHandler$2$1$handle$1(this, r4));
        }
    }

    public DynamicFeatureComponent$registerDynamicHandler$2(DynamicFeatureComponent r1, com.bytedance.android.shopping.prepurchase.arch.container.ability.d r2) {
        this.this$0 = r1;
        this.$subscriber = r2;
        super(0);
    }

    public final l<SlcCommonAction> invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2510invoke() {
        return invoke();
    }
}
