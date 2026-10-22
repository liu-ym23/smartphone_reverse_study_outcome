package com.bytedance.android.shopping.store.tabkit.anniex.component;

import com.bytedance.android.shopping.store.tabkit.model.v;
import com.bytedance.android.shopping.store.tabkit.monitor.TabkitSwitchTabPref;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.TemplateData;
import kk3.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class TabHybridComponent$prefetchCallback$1$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isFromNetEnd;
    final /* synthetic */ LynxView $lynxView;
    final /* synthetic */ String $result;
    final /* synthetic */ TabHybridComponent$prefetchCallback$1 this$0;

    public TabHybridComponent$prefetchCallback$1$onSuccess$1(TabHybridComponent$prefetchCallback$1 r1, boolean r2, LynxView r3, String r4) {
        this.this$0 = r1;
        this.$isFromNetEnd = r2;
        this.$lynxView = r3;
        this.$result = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m430invoke() {
        TabHybridComponent r0 = this.this$0.a;
        boolean r1 = this.$isFromNetEnd;
        int r2 = TabHybridComponent.k;
        v r3 = r0.h();
        if (r3 == null) goto L11;
        if (r1 == false) goto L7;
        String r4 = "net_end";
    L10:
        r3.e = r4;
        goto L11
    L7:
        if (r0.b == false) goto L9;
        r4 = "load_success";
        goto L10
    L9:
        r4 = "runtime_ready";
    L11:
        this.$lynxView.updateData(TemplateData.fromString(this.$result));
        a r5 = this.this$0.a.c();
        if (r5 == null) goto L15;
        r5.c(TabkitSwitchTabPref.T_TAB_UPDATE_END_TIME, null);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m430invoke();
        return Unit.INSTANCE;
    }
}
