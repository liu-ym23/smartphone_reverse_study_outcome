package com.bytedance.android.shopping.card_list.container.init;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.card_list.abilities.CardMultiUpdateComponent;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListEventCenterComponent;
import com.bytedance.android.shopping.card_list.components.CardListLoadMoreComponent;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent;
import com.bytedance.android.shopping.card_list.components.CardListPopupLayerComponent;
import com.bytedance.android.shopping.card_list.components.CardListSliceCustomWidgetAdapterComponent;
import com.bytedance.android.shopping.card_list.components.CardListTrackerComponent;
import com.bytedance.android.shopping.card_list.components.i;
import com.bytedance.android.shopping.card_list.components.j;
import com.bytedance.android.shopping.card_list.container.CardListTemplateMgr;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class BaseCartListLauncher implements f {
    public BaseCartListLauncher() {
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.f
    public void b(CardPassThroughData r2, Function3<? super String, ? super String, ? super Map<String, String>, Unit> r3) {
        Intrinsics.checkNotNullParameter(r2, "passThroughData");
        Intrinsics.checkNotNullParameter(r3, "cb");
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.f
    public void a(final CardListObjectContainer r5, final View r6) {
        Intrinsics.checkNotNullParameter(r5, "objectContainer");
        Intrinsics.checkNotNullParameter(r6, "rootContainerView");
        KClass<? extends com.bytedance.android.shopping.card_list.components.a> r0 = Reflection.getOrCreateKotlinClass(CardListBodyComponent.class);
        Boolean r1 = Boolean.TRUE;
        r5.e(r0, r1, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$1(r5, r6, r5));
        KClass<? extends com.bytedance.android.shopping.card_list.components.a> r2 = Reflection.getOrCreateKotlinClass(CardListLoadMoreComponent.class);
        Function0<CardListLoadMoreComponent> r3 = new BaseCartListLauncher$onLaunch$1$2(r5);
        Boolean r4 = Boolean.FALSE;
        r5.e(r2, r4, r3);
        r5.e(Reflection.getOrCreateKotlinClass(j.class), r4, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$2(r5, r6, r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardListPopupLayerComponent.class), r4, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$3(r5, r6, r5));
        r5.e(Reflection.getOrCreateKotlinClass(i.class), r4, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$4(r5, r6, r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardListPageCallBackComponent.class), r4, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$5(r5, r6, r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardMultiUpdateComponent.class), r4, new BaseCartListLauncher$onLaunch$1$7(r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardListTrackerComponent.class), r4, new BaseCartListLauncher$onLaunch$1$8(r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardListEventCenterComponent.class), r1, new BaseCartListLauncher$onLaunch$1$9(r5));
        r5.e(Reflection.getOrCreateKotlinClass(CardListSliceCustomWidgetAdapterComponent.class), r1, new BaseCartListLauncher$onLaunch$$inlined$apply$lambda$6(r5, r6, r5));
    }

    @Override // com.bytedance.android.shopping.card_list.container.init.f
    public void c(CardListObjectContainer r5, f.b r6, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r7, Function2<? super f.b, ? super com.bytedance.kmp.ec.yata.view.render.delegate.v2.a, Unit> r8) {
        Intrinsics.checkNotNullParameter(r5, "objectContainer");
        Intrinsics.checkNotNullParameter(r6, "sdkParams");
        Intrinsics.checkNotNullParameter(r8, "cb");
        Context r9 = r5.getContext();
        if (r9 == null) goto L5;
        CardListTemplateMgr.INSTANCE.preload(r9, r6.c, r6.b, r6.d);
    L5:
        r8.invoke(r6, r7);
    }
}
