package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import jc1.k;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\n\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"", "position", "Lcom/bytedance/android/live/core/widget/HSImageView;", "businessLayout", "", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "firstLevelTabFragmentList", "", "invoke", "(ILcom/bytedance/android/live/core/widget/HSImageView;Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1 extends Lambda implements Function3<Integer, HSImageView, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$showBusinessEntryIfNeedAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(3);
    }

    public final void invoke(int r3, HSImageView r4, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r5) {
        Intrinsics.checkNotNullParameter(r5, "firstLevelTabFragmentList");
        BaseFirstLevelTabManager r0 = this.this$0;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r5, "firstLevelTabFragment");
        if (r0.g(r3, r5) == false) goto L16;
        if (r4 == null) goto L6;
        UtilityKotlinExtentionsKt.w(r4);
    L6:
        pb0.a r6 = pb0.b.a;
        String r7 = k.n(IMiddlewareUserService.class).user().n().toString().toString();
        int r8 = ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) ListProtector.get(r5, r3)).VL().getValue();
        if (r8 != FirstLevelTab.OrderedSongTab.getValue()) goto L10;
        String r9 = "banner_ready";
    L13:
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r9, "enterFrom");
        pb0.a r10 = pb0.b.a;
        if (r10 == null) goto L19;
        r10.k(r7, r9);
        return;
    L19:
        return;
    L10:
        if (r8 != FirstLevelTab.OrderSongTab.getValue()) goto L12;
        r9 = "banner_order";
        goto L13
    L12:
        r9 = "";
        goto L13
    L16:
        if (r4 == null) goto L21;
        UtilityKotlinExtentionsKt.t(r4);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        invoke(((Number) r1).intValue(), (HSImageView) r2, (List) r3);
        return Unit.INSTANCE;
    }
}
