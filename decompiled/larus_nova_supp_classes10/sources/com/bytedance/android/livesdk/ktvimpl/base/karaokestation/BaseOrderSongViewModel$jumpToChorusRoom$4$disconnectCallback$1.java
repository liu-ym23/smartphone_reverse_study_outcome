package com.bytedance.android.livesdk.ktvimpl.base.karaokestation;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.soloktv.model.JumpRealTimeChorusRoomParams;
import com.bytedance.android.live.soloktv.model.JumpRoomInfo;
import com.bytedance.android.live.soloktv.model.JumpScene;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.RecommendRealTimeChorusInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import io.reactivex.disposables.Disposable;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1 implements rj0.c {
    public final /* synthetic */ BaseOrderSongViewModel.AnonymousClass4 a;

    public final void disconnectFailed() {
        f2.b(2131919333, 0);
    }

    public final void disconnectSuccess() {
        int r0 = sd2.a.a;
        sd2.a r1 = sd2.a.b.a;
        long r2 = System.currentTimeMillis();
        Integer r3 = Integer.valueOf(JumpScene.KTV.getValue());
        Gson r5 = GsonHelper.getDefault();
        MusicPanel r6 = this.a.$musicPanel;
        if (r6 == null) goto L13;
        KtvMusic r7 = r6.a;
        if (r7 == null) goto L13;
        List r8 = r7.getRecommendRealTimeChorusInfos();
        if (r8 == null) goto L13;
        RecommendRealTimeChorusInfo r9 = (RecommendRealTimeChorusInfo) CollectionsKt.getOrNull(r8, 0);
        if (r9 == null) goto L13;
        Long r10 = r9.getRoomId();
        if (r10 == null) goto L13;
        String r11 = String.valueOf(r10.longValue());
    L14:
        MusicPanel r12 = this.a.$musicPanel;
        if (r12 == null) goto L17;
        String r13 = String.valueOf(r12.c());
    L18:
        Disposable r4 = r1.a(r2, new JumpRealTimeChorusRoomParams(r3, GsonProtectorUtils.toJson(r5, CollectionsKt.listOf(new JumpRoomInfo(r11, r13, null, 4, null)))), new BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1$disconnectSuccess$1(this), BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1$disconnectSuccess$2.INSTANCE);
        if (r4 == null) goto L22;
        RxUtilKt.c(r4, this.a.this$0.getCompositeDisposable());
        return;
    L22:
        return;
    L17:
        r13 = null;
    L13:
        r11 = null;
        goto L14
    }

    public BaseOrderSongViewModel$jumpToChorusRoom$4$disconnectCallback$1(BaseOrderSongViewModel.AnonymousClass4 r1) {
        this.a = r1;
    }
}
