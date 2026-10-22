package com.bytedance.android.livesdk.livecommerce.promotion.card.module;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.ec.common.api.jump.model.LiveRoomParams;
import com.bytedance.android.ec.common.api.jump.model.g;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.promotion.card.ILivePromotionCardContainerHandler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import w83.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lw83/i;", "invoke", "()Lw83/i;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class ListItemRootModule$ligoViewManager$1 extends Lambda implements Function0<i> {
    final /* synthetic */ ListItemRootModule this$0;

    public ListItemRootModule$ligoViewManager$1(ListItemRootModule r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final i m914invoke() {
        g r0 = (g) this.this$0.l.b.invoke();
        FragmentActivity r1 = null;
        if (r0 == null) goto L7;
        LiveRoomParams r2 = r0.getParamsModel(Reflection.getOrCreateKotlinClass(LiveRoomParams.class));
        if (r2 == null) goto L7;
        String r3 = r2.getRoomUniqueKey();
    L8:
        this.this$0.m.b("room_unique_key", r3);
        int r4 = ECSdk.a;
        w83.g r5 = (w83.g) ECSdk.a(w83.g.class);
        if (r5 == null) goto L30;
        ListItemRootModule r6 = this.this$0;
        FragmentActivity r7 = r6.o.getContext();
        if ((r7 instanceof FragmentActivity) == false) goto L14;
        r1 = r7;
    L14:
        FragmentActivity r8 = r1;
        if (r8 == null) goto L21;
        FragmentManager r9 = r8.getSupportFragmentManager();
        if (r9 == null) goto L21;
        LifecycleOwner r10 = r9.findFragmentByTag("live_promotion_fragment");
        if (r10 == null) goto L21;
        LifecycleOwner r11 = r10;
    L24:
        i r12 = r5.a(r11, this.this$0.p.b.e(ILivePromotionCardContainerHandler.ContainerPriority.LigoInitDataMap), this.this$0.m, new ListItemRootModule$ligoViewManager$1$manager$1(this), new ListItemRootModule$ligoViewManager$1$manager$2(this));
        if (r12 == null) goto L30;
        return r12;
    L21:
        LifecycleOwner r13 = com.bytedance.android.ec.sdk.plugin.e.getActivity(r6.o.getContext());
        if (r13 == null) goto L28;
        r11 = r13;
        goto L24
    L28:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    L30:
        return new y83.c();
    L7:
        r3 = null;
        goto L8
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        return m914invoke();
    }
}
