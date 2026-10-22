package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.AudienceSingFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.firstleveltab.WantListenFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.MineFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderFirstLevelTabFragment;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.firstleveltab.OrderedFirstLevelTabFragment;
import com.bytedance.android.livesdkapi.model.TabName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "firstLevelTabFragmentList", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1 extends Lambda implements Function1<List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$bindFirstLevelTabFragmentAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r8) {
        Intrinsics.checkNotNullParameter(r8, "firstLevelTabFragmentList");
        BaseFirstLevelTabManager r1 = this.this$0;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r8, "firstLevelTabFragmentList");
        Integer r0 = r1.h;
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        String r3 = r1.i;
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        String r4 = (String) r1.k(r2, r3).component2();
        Iterator<T> r5 = r1.l().iterator();
    L11:
        if (r5.hasNext() == false) goto L30;
        String r6 = (String) r5.next();
        if (Intrinsics.areEqual(r6, TabName.MY_SONG.getValue()) == true) goto L14;
        if (Intrinsics.areEqual(r6, TabName.ORDERED_SONG.getValue()) == true) goto L17;
        if (Intrinsics.areEqual(r6, TabName.ORDER_SONG.getValue()) == true) goto L20;
        if (Intrinsics.areEqual(r6, TabName.AUDIENCE_SING.getValue()) == true) goto L23;
        if (Intrinsics.areEqual(r6, TabName.WANT_LISTEN.getValue()) == true) goto L26;
        if (Intrinsics.areEqual(r6, TabName.EFFECT_MUSIC.getValue()) == false) goto L11;
        int r7 = OrderFirstLevelTabFragment.E;
        r8.add(new OrderFirstLevelTabFragment(r4, r1.k, r1.m, r1.l));
        goto L11
    L26:
        int r9 = WantListenFirstLevelTabFragment.C;
        r8.add(new WantListenFirstLevelTabFragment(r4, r1.k, r1.m, r1.l));
        goto L11
    L23:
        int r10 = AudienceSingFirstLevelTabFragment.w;
        r8.add(new AudienceSingFirstLevelTabFragment(r4, r1.k, r1.m));
        goto L11
    L20:
        int r11 = OrderFirstLevelTabFragment.E;
        r8.add(new OrderFirstLevelTabFragment(r4, r1.k, r1.m, r1.l));
        goto L11
    L17:
        int r12 = OrderedFirstLevelTabFragment.u;
        r8.add(new OrderedFirstLevelTabFragment(r4, r1.k, r1.m));
        goto L11
    L14:
        int r13 = MineFirstLevelTabFragment.G;
        r8.add(new MineFirstLevelTabFragment(r4, r1.k, r1.m, r1.n));
        goto L11
    L30:
        r1.o().clear();
        r1.o().addAll(r8);
        return;
    L5:
        r2 = FirstLevelTab.OrderSongTab.getValue();
        goto L6
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((List) r1);
        return Unit.INSTANCE;
    }
}
