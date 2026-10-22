package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.view.View;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.android.material.tabs.TabLayout;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "position", "", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "firstLevelTabFragmentList", "Lcom/google/android/material/tabs/TabLayout;", "firstLevelTabLayout", "", "invoke", "(ILjava/util/List;Lcom/google/android/material/tabs/TabLayout;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1 extends Lambda implements Function3<Integer, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$firstLevelTabPageSelectedAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(int r3, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r4, TabLayout r5) {
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabFragmentList");
        BaseFirstLevelTabManager r1 = this.this$0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r4, "firstLevelTabFragmentList");
        int r6 = ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r4, r3)).VL().getValue();
        FirstLevelTab r7 = FirstLevelTab.MySongTab;
        if (r6 == r7.getValue()) goto L5;
        return;
    L5:
        if (r1.p() == true) goto L7;
        return;
    L7:
        if (r5 == null) goto L15;
        Integer r8 = (Integer) ((LinkedHashMap) r1.c).get(r7);
        if (r8 == null) goto L11;
        int r9 = r8.intValue();
    L12:
        TabLayout.Tab r10 = r5.getTabAt(r9);
        if (r10 == null) goto L15;
        View r11 = r10.getCustomView();
    L17:
        if ((r11 instanceof kb0.a) == true) goto L19;
        r11 = null;
    L19:
        kb0.a r12 = (kb0.a) r11;
        if (r12 == null) goto L23;
        r12.G5(8);
    L23:
        if (r1.p() == false) goto L28;
        com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.c.i;
        KtvContext.Companion.getClass();
        Object r14 = KtvContext.a.g().getKtvAddDressVersion().getValue();
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r14);
        KtvContext.a.g().getKtvAddDressVersion().setValue(null);
        return;
    L28:
        return;
    L11:
        r9 = -1;
    L15:
        r11 = null;
        goto L17
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Number) r1).intValue(), (List) r2, (TabLayout) r3);
        return Unit.INSTANCE;
    }
}
