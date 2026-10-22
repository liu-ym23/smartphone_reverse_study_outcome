package com.bytedance.android.shopping.store.tabkit.anniex.component;

import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import kk3.a;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class TabHybridComponent$prefetchCallbackV2$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isFromNetEnd;
    final /* synthetic */ LynxView $lynxView;
    final /* synthetic */ String $result;
    final /* synthetic */ TabHybridComponent$prefetchCallbackV2$1 this$0;

    public TabHybridComponent$prefetchCallbackV2$1$onSuccess$1(TabHybridComponent$prefetchCallbackV2$1 r1, boolean r2, String r3, LynxView r4) {
        this.this$0 = r1;
        this.$isFromNetEnd = r2;
        this.$result = r3;
        this.$lynxView = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m431invoke() {
        TabHybridComponent r0 = this.this$0.a;
        boolean r1 = this.$isFromNetEnd;
        int r2 = TabHybridComponent.k;
        v r3 = r0.h();
        if (r3 == null) goto L12;
        if (r1 == false) goto L7;
        String r4 = "net_end";
    L10:
        r3.e = r4;
        goto L12
    L7:
        if (r0.b == false) goto L9;
        r4 = "load_success";
        goto L10
    L9:
        r4 = "runtime_ready";
    L12:
        if (this.this$0.a.d == false) goto L14;
        TemplateData r5 = TemplateData.fromString(this.$result);
        LynxView r6 = this.$lynxView;
        TemplateData r7 = TemplateData.empty();
        r7.put("na_prefetch_inject_raw", r5);
        r7.put("na_prefetch_inject_info", this.this$0.a.d());
        Unit r8 = Unit.INSTANCE;
        r6.updateData(r7);
    L15:
        a r9 = this.this$0.a.c();
        if (r9 == null) goto L19;
        r9.c(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, null);
        return;
    L19:
        return;
    L14:
        this.$lynxView.updateData(MapsKt.mapOf(new Pair[]{TuplesKt.to("na_prefetch_inject_raw", new JSONObject(this.$result)), TuplesKt.to("na_prefetch_inject_info", this.this$0.a.d())}));
        goto L15
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m431invoke();
        return Unit.INSTANCE;
    }
}
