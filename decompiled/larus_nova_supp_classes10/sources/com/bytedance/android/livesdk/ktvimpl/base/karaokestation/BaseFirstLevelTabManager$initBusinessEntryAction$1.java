package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.KtvMode;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.google.android.material.tabs.TabLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u000e\u001a\u00020\u00032\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lcom/bytedance/android/live/core/widget/HSImageView;", "businessLayout", "Lkotlin/Function0;", "", "dismissCallback", "Landroidx/fragment/app/FragmentActivity;", "activity", "", "Lcom/bytedance/android/live/ktv/common/karaokestation/view/firstleveltab/a;", "firstLevelTabFragmentList", "Lcom/google/android/material/tabs/TabLayout;", "firstLevelTabLayout", "invoke", "(Lcom/bytedance/android/live/core/widget/HSImageView;Lkotlin/jvm/functions/Function0;Landroidx/fragment/app/FragmentActivity;Ljava/util/List;Lcom/google/android/material/tabs/TabLayout;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class BaseFirstLevelTabManager$initBusinessEntryAction$1 extends Lambda implements Function5<HSImageView, Function0<? extends Unit>, FragmentActivity, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, TabLayout, Unit> {
    final /* synthetic */ BaseFirstLevelTabManager this$0;

    public BaseFirstLevelTabManager$initBusinessEntryAction$1(BaseFirstLevelTabManager r1) {
        this.this$0 = r1;
        super(5);
    }

    public final void invoke(HSImageView r8, Function0<Unit> r9, FragmentActivity r10, List<? extends com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> r11, TabLayout r12) {
        Intrinsics.checkNotNullParameter(r11, "firstLevelTabFragmentList");
        BaseFirstLevelTabManager r2 = this.this$0;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r11, "firstLevelTabFragmentList");
        if (bb0.b.a() != KtvMode.SOLO_KTV) goto L5;
        return;
    L5:
        if (j.i() == true) goto L18;
        if (r8 == null) goto L19;
        AbstractDraweeController r0 = Fresco.newDraweeControllerBuilder().setUri("https://" + LiveCommonConstants.INSTANCE.getObjectTosPath() + "/obj/live-android/" + ((String) h.G0.getValue(null, h.a[83]))).build();
        GenericDraweeHierarchy r1 = r8.getHierarchy();
        if (r1 == null) goto L10;
        r1.setActualImageScaleType(ScalingUtils.ScaleType.FIT_XY);
    L10:
        r8.setController(r0);
        r8.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) (s1.y() / 9.375f)));
        if ((!r11.isEmpty()) == true) goto L13;
    L15:
        r8.setOnClickListener(new a(r2, r11, r12, r10, r9));
        return;
    L13:
        if (r2.g(0, r11) == false) goto L15;
        UtilityKotlinExtentionsKt.w(r8);
        goto L15
    L19:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r7, Object r8, Object r9, Object r10, Object r11) {
        invoke((HSImageView) r7, (Function0) r8, (FragmentActivity) r9, (List) r10, (TabLayout) r11);
        return Unit.INSTANCE;
    }
}
