package com.bytedance.android.window.shop.widget.childcategory;

import com.bytedance.android.window.shop.repository.tab.entity.WindowChildCategoryVO;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "p1", "Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;", "p2", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class HorizontalWeightedGroupView$bindData$1$1$1 extends FunctionReferenceImpl implements Function2<WindowChildCategoryVO.ChildCategoryVO, Boolean, Unit> {
    public HorizontalWeightedGroupView$bindData$1$1$1(HorizontalWeightedGroupView r8) {
        super(2, r8, HorizontalWeightedGroupView.class, "onSelectionChanged", "onSelectionChanged(Lcom/bytedance/android/window/shop/repository/tab/entity/WindowChildCategoryVO$ChildCategoryVO;Z)V", 0);
    }

    public final void invoke(WindowChildCategoryVO.ChildCategoryVO r5, boolean r6) {
        HorizontalWeightedGroupView r0 = (HorizontalWeightedGroupView) ((CallableReference) this).receiver;
        if (r6 == true) goto L7;
        HorizontalWeightedGroupView.d r7 = r0.b;
        if (r7 == null) goto L23;
        r7.a(null);
        return;
    L23:
        return;
    L7:
        Iterator r8 = ((LinkedHashMap) r0.c).entrySet().iterator();
    L9:
        if (r8.hasNext() == false) goto L14;
        Map.Entry r1 = (Map.Entry) r8.next();
        WindowChildCategoryVO.ChildCategoryVO r2 = (WindowChildCategoryVO.ChildCategoryVO) r1.getKey();
        HorizontalWeightedGroupView.a r3 = (HorizontalWeightedGroupView.a) r1.getValue();
        if (Intrinsics.areEqual(r2, r5) == true) goto L9;
        r2.setSelected(false);
        r3.a(r2);
        goto L9
    L14:
        HorizontalWeightedGroupView.d r9 = r0.b;
        if (r9 == null) goto L25;
        r9.a(r5);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((WindowChildCategoryVO.ChildCategoryVO) r1, ((Boolean) r2).booleanValue());
        return Unit.INSTANCE;
    }
}
