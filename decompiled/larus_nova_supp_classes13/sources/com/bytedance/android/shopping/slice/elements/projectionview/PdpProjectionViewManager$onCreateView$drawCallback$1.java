package com.bytedance.android.shopping.slice.elements.projectionview;

import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.v;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import vg3.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "status", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class PdpProjectionViewManager$onCreateView$drawCallback$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ AnchorV4VM $anchorV4VM;
    final /* synthetic */ l $headAbility;

    public PdpProjectionViewManager$onCreateView$drawCallback$1(l r1, AnchorV4VM r2) {
        this.$headAbility = r1;
        this.$anchorV4VM = r2;
        super(1);
    }

    public final void invoke(boolean r2) {
        l r0 = this.$headAbility;
        if (r0 == null) goto L5;
        r0.z5(r2);
    L5:
        AnchorV4VM r1 = this.$anchorV4VM;
        if (r1 == null) goto L11;
        v r3 = r1.getHeadViewAbilityV2New();
        if (r3 == null) goto L12;
        r3.z5(r2);
        return;
    L12:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke(((Boolean) r1).booleanValue());
        return Unit.INSTANCE;
    }
}
