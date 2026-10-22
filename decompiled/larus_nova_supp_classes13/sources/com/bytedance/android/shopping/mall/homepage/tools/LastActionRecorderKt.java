package com.bytedance.android.shopping.mall.homepage.tools;

import com.bytedance.android.ec.hybrid.list.holder.BaseViewHolder;
import com.bytedance.android.shopping.api.mall.common.homepage.card.live.LiveCardData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.video.VideoCardData;
import com.bytedance.android.shopping.mall.homepage.card.live.NativeLiveCard;
import com.bytedance.android.shopping.mall.homepage.card.video.NativeVideoCard;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class LastActionRecorderKt {
    public static final void a(NativeLiveCard r4, boolean r5, final Function1 r6) {
        Intrinsics.checkNotNullParameter(r4, "$this$recordClickLastAction");
        final Ref.ObjectRef r0 = new Ref.ObjectRef();
        LiveCardData r1 = r4.u;
        String r2 = "";
        if (r1 == null) goto L8;
        LiveCardData.Live r3 = r1.getLive();
        if (r3 == null) goto L8;
        String r7 = r3.getRoomId();
        if (r7 == null) goto L8;
    L9:
        r0.element = "1_1_".concat(r7);
        int r8 = com.bytedance.forest.utils.h.a;
        LiveCardData r9 = r4.u;
        if (r9 == null) goto L14;
        LiveCardData.Live r10 = r9.getLive();
        if (r10 == null) goto L14;
        String r11 = r10.getUid();
    L16:
        if (com.bytedance.forest.utils.h.a(r11) == false) goto L26;
        StringBuilder r12 = new StringBuilder();
        r12.append((String) r0.element);
        r12.append('_');
        LiveCardData r13 = r4.u;
        if (r13 == null) goto L25;
        LiveCardData.Live r14 = r13.getLive();
        if (r14 == null) goto L25;
        String r15 = r14.getUid();
        if (r15 == null) goto L25;
        r2 = r15;
    L25:
        r12.append(r2);
        r0.element = r12.toString();
    L26:
        com.bytedance.android.ec.hybrid.list.ability.a r16 = ((BaseViewHolder) r4).b;
        if (r16 == null) goto L32;
        k93.f r17 = (k93.f) r16.getAbility(k93.f.class);
        if (r17 == null) goto L33;
        r17.a((String) r0.element, r5, new LastActionRecorderKt$recordClickLastAction$1(r6, r0));
        return;
    L33:
        return;
    L32:
        return;
    L14:
        r11 = null;
    L8:
        r7 = "";
        goto L9
    }

    public static final void b(NativeVideoCard r2, boolean r3, final Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "$this$recordClickLastAction");
        VideoCardData r0 = r2.O;
        if (r0 == null) goto L8;
        VideoCardData.Video r1 = r0.getVideo();
        if (r1 == null) goto L8;
        String r5 = r1.getItemId();
        if (r5 == null) goto L8;
    L9:
        final String r6 = "1_4_".concat(r5);
        com.bytedance.android.ec.hybrid.list.ability.a r7 = ((BaseViewHolder) r2).b;
        if (r7 == null) goto L15;
        k93.f r8 = (k93.f) r7.getAbility(k93.f.class);
        if (r8 == null) goto L16;
        r8.a(r6, r3, new LastActionRecorderKt$recordClickLastAction$2(r4, r6));
        return;
    L16:
        return;
    L15:
        return;
    L8:
        r5 = "";
        goto L9
    }
}
