package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.HeadRecyclerView;
import com.bytedance.common.utility.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/HeadPagerSnapHelper;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/BaseHeadPagerSnapHelper;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HeadPagerSnapHelper extends BaseHeadPagerSnapHelper {
    public final HeadRecyclerView d;

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
    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.BaseHeadPagerSnapHelper
    public final View findSnapView(RecyclerView.LayoutManager r6) {
        Intrinsics.checkNotNullParameter(r6, "layoutManager");
        if (this.c.s() == false) goto L12;
        View r7 = super.findSnapView(r6);
        if (this.d.t(false) == true) goto L7;
        return r7;
    L7:
        if (this.d.getChildCount() <= 0) goto L21;
        RecyclerView r0 = this.d;
        View r1 = r0.getChildAt(r0.getChildCount() - 1);
        if (r1.getX() < (this.d.getWidth() - (r1.getWidth() / 2.0f))) goto L11;
        return r7;
    L11:
        return r1;
    L21:
        return r7;
    L12:
        View r8 = a(r6);
        if (this.d.t(false) == true) goto L15;
        return r8;
    L15:
        if (this.d.getChildCount() <= 0) goto L24;
        RecyclerView r2 = this.d;
        View r3 = r2.getChildAt(r2.getChildCount() - 1);
        if (r3.getX() < (this.d.getWidth() - (r3.getWidth() / 2.0f))) goto L19;
        return r8;
    L19:
        return r3;
    L24:
        return r8;
    }

    public HeadPagerSnapHelper(HeadRecyclerView r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        Intrinsics.checkNotNullParameter(r3, "headAbilityNeeded");
        super(r3);
        this.d = r2;
        r2.setPagerSnapHelper(this);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper.BaseHeadPagerSnapHelper
    public final int[] calculateDistanceToFinalSnap(RecyclerView.LayoutManager r5, View r6) {
        Intrinsics.checkNotNullParameter(r5, "layoutManager");
        Intrinsics.checkNotNullParameter(r6, "targetView");
        if (this.c.XU() != 1) goto L20;
        if (this.c.wq() == true) goto L20;
        int[] r0 = new int[2];
        AnchorV4HeadV2VO r2 = this.c.K10();
        if (r2 == null) goto L9;
        int r3 = r2.getLastScaleIndex();
    L10:
        if (r3 <= 0) goto L18;
        if ((r5 instanceof LinearLayoutManager) == false) goto L18;
        if (r5.getPosition(r6) != r3) goto L18;
        r0[0] = (r5.getDecoratedRight(r6) - UIUtils.getScreenWidth(this.d.getContext())) + com.bytedance.android.shopping.extensions.b.b(12);
        r0[1] = 0;
        return r0;
    L18:
        return super.calculateDistanceToFinalSnap(r5, r6);
    L9:
        r3 = -1;
    L20:
        return super.calculateDistanceToFinalSnap(r5, r6);
    }
}
