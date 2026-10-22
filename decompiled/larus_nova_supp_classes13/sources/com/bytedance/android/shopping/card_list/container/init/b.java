package com.bytedance.android.shopping.card_list.container.init;

import android.view.Choreographer;
import com.bytedance.android.shopping.card_list.common_params.CardListContainerConfig;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.repo.CardListRepository;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Choreographer.FrameCallback {
    public final /* synthetic */ BaseCardListContainer a;

    public b(BaseCardListContainer r1) {
        this.a = r1;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r4) {
        BaseCardListContainer r5 = this.a;
        int r6 = r5.r;
        if (r6 >= 1) goto L6;
        r5.r = r6 + 1;
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L6:
        if (r5.f().e.h.c == true) goto L39;
        CardListRepository r7 = CardListRepository.INSTANCE;
        Pair<LauncherBizType, com.bytedance.kmp.ec.yata.common.protocol.data.e> r8 = r7.getCacheResponse();
        LauncherBizType r1 = null;
        if (r8 == null) goto L10;
        com.bytedance.kmp.ec.yata.common.protocol.data.e r9 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r8.getSecond();
    L11:
        if (r9 == null) goto L36;
        Pair<LauncherBizType, com.bytedance.kmp.ec.yata.common.protocol.data.e> r10 = r7.getCacheResponse();
        if (r10 == null) goto L15;
        LauncherBizType r11 = (LauncherBizType) r10.getFirst();
    L16:
        CardListContainerConfig r2 = this.a.j;
        if (r2 == null) goto L19;
        r1 = r2.getBizType();
    L19:
        if (r11 != r1) goto L36;
        Pair<LauncherBizType, com.bytedance.kmp.ec.yata.common.protocol.data.e> r12 = r7.getCacheResponse();
        if (r12 == null) goto L40;
        final com.bytedance.kmp.ec.yata.common.protocol.data.e r13 = (com.bytedance.kmp.ec.yata.common.protocol.data.e) r12.getSecond();
        if (r13 == null) goto L41;
        final BaseCardListContainer r14 = this.a;
        CardListObjectContainer r3 = r14.a;
        if (r3 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("objectContainer");
    L27:
        r3.e.h.a = true;
        Map<String, Map<String, Long>> r0 = com.bytedance.android.shopping.card_list.monitor.firstScreen.a.a;
        String r15 = r14.l;
        if (r15 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("sessionId");
    L30:
        com.bytedance.android.shopping.card_list.monitor.firstScreen.a.b(r15, "CacheStartRender");
        CardPassThroughData r16 = r14.i;
        if (r16 == null) goto L34;
        String r17 = r16.getMonitorId();
        if (r17 == null) goto L34;
    L35:
        CardListRunCatchExtKt.b(r17, "BaseCardListContainer-onGetCacheSuccess", new BaseCardListContainer$cacheFirstPaint$1(r14, r13), new BaseCardListContainer$cacheFirstPaint$2(r14));
        return;
    L34:
        r17 = "";
        goto L35
    L41:
        return;
    L40:
        return;
    L15:
        r11 = null;
    L36:
        Choreographer.getInstance().postFrameCallback(this);
        return;
    L10:
        r9 = null;
        goto L11
    }
}
