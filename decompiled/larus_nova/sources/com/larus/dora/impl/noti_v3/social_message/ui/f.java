package com.larus.dora.impl.noti_v3.social_message.ui;

import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.dora.impl.databinding.LarusDoraPageNotiV3SocialMessageBinding;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes27.dex */
public final class f<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ NotificationBroadcastV3SocialMessageFragment f336484a;

    public f(NotificationBroadcastV3SocialMessageFragment r100) {
        this.f336484a = r100;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object r100, Continuation r101) {
        q59.a r102 = (q59.a) r100;
        NotificationBroadcastV3SocialMessageFragment r103 = this.f336484a;
        r103.f336476h = r102.f531748c;
        r103.f336477i = r102.f531749d;
        LarusDoraPageNotiV3SocialMessageBinding r104 = r103.f336474f;
        if (r104 == null) goto L7;
        ItemTextArrow r105 = r104.f333090c;
        if (r105 == null) goto L7;
        String r106 = r103.W90().resolveSingleMessageSummary(r102.f531748c);
        int r107 = ItemTextArrow.f316958k;
        r105.Z5(r106, null);
    L7:
        NotificationBroadcastV3SocialMessageFragment r108 = this.f336484a;
        LarusDoraPageNotiV3SocialMessageBinding r109 = r108.f336474f;
        if (r109 == null) goto L12;
        ItemTextArrow r110 = r109.f333089b;
        if (r110 == null) goto L12;
        String r111 = r108.W90().resolveGroupMessageSummary(r102.f531749d);
        int r112 = ItemTextArrow.f316958k;
        r110.Z5(r111, null);
    L12:
        NotificationBroadcastV3SocialMessageFragment r113 = this.f336484a;
        LarusDoraPageNotiV3SocialMessageBinding r114 = r113.f336474f;
        if (r114 == null) goto L18;
        ItemTextArrow r115 = r114.f333091d;
        if (r115 == null) goto L18;
        String r116 = r113.W90().resolveSpecialMessageSummary(r102.f531750e, r102.f531751f);
        int r117 = ItemTextArrow.f316958k;
        r115.Z5(r116, null);
    L18:
        return Unit.INSTANCE;
    }
}
