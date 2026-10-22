package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.view.View;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.google.android.material.tabs.TabLayout;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Landroid/view/View;", "rootView", "Lcom/google/android/material/tabs/TabLayout;", "firstLevelTabLayout", "", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "firstLevelTabFragmentList", "", "invoke", "(Landroid/view/View;Lcom/google/android/material/tabs/TabLayout;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$setCartAnimAction$1 extends Lambda implements Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$setCartAnimAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(View r8, TabLayout r9, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r10) {
        Intrinsics.checkNotNullParameter(r10, "firstLevelTabFragmentList");
        BaseFirstLevelTabManager r1 = this.this$0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "firstLevelTabFragmentList");
        ((LinkedHashMap) r1.c).clear();
        List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r11 = r10;
        Iterator<T> r0 = r11.iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r1.c.put(((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r3).VL(), Integer.valueOf(r2));
        r2 = r4;
        goto L4
    L9:
        Iterator<T> r12 = r11.iterator();
    L11:
        if (r12.hasNext() == false) goto L72;
        com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a r5 = (com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r12.next();
        int r6 = -1;
        View r7 = null;
        if (r5.VL() == FirstLevelTab.OrderSongTab) goto L14;
        FirstLevelTab r13 = r5.VL();
        FirstLevelTab r14 = FirstLevelTab.MySongTab;
        if (r13 == r14) goto L33;
        if (r5.VL() == FirstLevelTab.WantListenTab) goto L44;
        FirstLevelTab r15 = r5.VL();
        FirstLevelTab r16 = FirstLevelTab.OrderedSongTab;
        if (r15 != r16) goto L11;
        if (r9 == null) goto L63;
        Integer r17 = (Integer) ((LinkedHashMap) r1.c).get(r16);
        if (r17 == null) goto L59;
        int r18 = r17.intValue();
    L60:
        TabLayout.Tab r19 = r9.getTabAt(r18);
        if (r19 == null) goto L63;
        View r20 = r19.getCustomView();
    L64:
        if (r9 == null) goto L71;
        Integer r21 = (Integer) ((LinkedHashMap) r1.c).get(r14);
        if (r21 == null) goto L68;
        r6 = r21.intValue();
    L68:
        TabLayout.Tab r22 = r9.getTabAt(r6);
        if (r22 == null) goto L71;
        r7 = r22.getCustomView();
    L71:
        r5.y40(r8, r20, r7);
        goto L11
    L59:
        r18 = -1;
    L63:
        r20 = null;
        goto L64
    L44:
        if (r9 == null) goto L51;
        Integer r23 = (Integer) ((LinkedHashMap) r1.c).get(r14);
        if (r23 == null) goto L48;
        r6 = r23.intValue();
    L48:
        TabLayout.Tab r24 = r9.getTabAt(r6);
        if (r24 == null) goto L51;
        View r25 = r24.getCustomView();
    L52:
        r5.y40(r8, null, r25);
    L51:
        r25 = null;
        goto L52
    L33:
        if (r9 == null) goto L40;
        Integer r26 = (Integer) ((LinkedHashMap) r1.c).get(FirstLevelTab.OrderedSongTab);
        if (r26 == null) goto L37;
        r6 = r26.intValue();
    L37:
        TabLayout.Tab r27 = r9.getTabAt(r6);
        if (r27 == null) goto L40;
        View r28 = r27.getCustomView();
    L41:
        r5.y40(r8, r28, null);
    L40:
        r28 = null;
        goto L41
    L14:
        if (r9 == null) goto L22;
        Integer r29 = (Integer) ((LinkedHashMap) r1.c).get(FirstLevelTab.OrderedSongTab);
        if (r29 == null) goto L18;
        int r30 = r29.intValue();
    L19:
        TabLayout.Tab r31 = r9.getTabAt(r30);
        if (r31 == null) goto L22;
        View r32 = r31.getCustomView();
    L23:
        if (r9 == null) goto L30;
        Integer r33 = (Integer) ((LinkedHashMap) r1.c).get(FirstLevelTab.MySongTab);
        if (r33 == null) goto L27;
        r6 = r33.intValue();
    L27:
        TabLayout.Tab r34 = r9.getTabAt(r6);
        if (r34 == null) goto L30;
        r7 = r34.getCustomView();
    L30:
        r5.y40(r8, r32, r7);
        goto L11
    L18:
        r30 = -1;
    L22:
        r32 = null;
        goto L23
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke((View) r1, (TabLayout) r2, (List) r3);
        return Unit.INSTANCE;
    }
}
