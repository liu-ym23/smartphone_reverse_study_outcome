package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class ToolReporter$reportItemShow$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map $globalProps;
    final /* synthetic */ ToolVO $item;
    final /* synthetic */ int $position;
    final /* synthetic */ h this$0;

    public ToolReporter$reportItemShow$1(h r1, ToolVO r2, int r3, Map r4) {
        this.this$0 = r1;
        this.$item = r2;
        this.$position = r3;
        this.$globalProps = r4;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1277invoke() {
        ToolVO r0 = this.$item;
        if (r0 == null) goto L6;
        String r1 = r0.getComponentId();
        if (r1 == null) goto L6;
    L8:
        if (r1.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        if (this.this$0.a.contains(r1) == true) goto L17;
        this.this$0.a.add(r1);
        h.a(this.this$0, this.$position, this.$item, this.$globalProps);
        return;
    L17:
        return;
    L10:
        r2 = false;
    L6:
        r1 = "";
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1277invoke();
        return Unit.INSTANCE;
    }
}
