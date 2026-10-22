package com.bytedance.android.livesdk.livecommerce.playback.multicards;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g;
import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.playback.ReplayParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.playback.model.ExplainPlaybackFinalParams;
import com.bytedance.bdlocation.exception.BDLocationException;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements xk.a {
    public final /* synthetic */ ExplainPlaybackMultiCardsPresenter a;
    public final /* synthetic */ List b;
    public final /* synthetic */ MutableLiveData c;
    public final /* synthetic */ Ref.ObjectRef d;
    public final /* synthetic */ Ref.ObjectRef e;
    public final /* synthetic */ ReplayCards f;

    public final void getEnterFrom() {
    }

    public final long getReplayProgress() {
        return 0 * ((long) 1000);
    }

    public final ExplainPlaybackRequest a() {
        com.bytedance.android.livesdk.livecommerce.playback.main.b r0 = this.a.e0().getExplainPlaybackOriginParams();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public final Map<String, String> b() {
        cj2.c r0 = cj2.a.a;
        cj2.c r1 = cj2.a.a;
        if (r1 == null) goto L5;
        Double r2 = Double.valueOf(r1.b);
    L6:
        Pair[] r3 = new Pair[3];
        if (cj2.a.b == false) goto L9;
        String r4 = "1";
    L10:
        r3[0] = TuplesKt.to("subtitle_status", r4);
        if (r2 == null) goto L14;
        String r5 = String.valueOf(r2.doubleValue());
        if (r5 == null) goto L14;
    L15:
        r3[1] = TuplesKt.to("system_volume_pct", r5);
        r3[2] = TuplesKt.to("end_volume_pct", String.valueOf(g.a()));
        return MapsKt.mapOf(r3);
    L14:
        r5 = "-1";
        goto L15
    L9:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final Map<String, String> e() {
        cj2.c r0 = cj2.a.a;
        cj2.c r1 = cj2.a.a;
        if (r1 == null) goto L5;
        Double r2 = Double.valueOf(r1.b);
    L6:
        Pair[] r3 = new Pair[3];
        if (cj2.a.b == false) goto L9;
        String r4 = "1";
    L10:
        r3[0] = TuplesKt.to("subtitle_status", r4);
        if (r2 == null) goto L14;
        String r5 = String.valueOf(r2.doubleValue());
        if (r5 == null) goto L14;
    L15:
        r3[1] = TuplesKt.to("system_volume_pct", r5);
        r3[2] = TuplesKt.to("end_volume_pct", String.valueOf(g.a()));
        return MapsKt.mapOf(r3);
    L14:
        r5 = "-1";
        goto L15
    L9:
        r4 = BDLocationException.ERROR_TIMEOUT;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final ReplayParams f() {
        ReplayParams r0 = new ReplayParams();
        r0.setFromProductDetail(Boolean.valueOf(this.a.e0().isFromProductDetail()));
        r0.setFromLive(Boolean.valueOf(this.a.e0().isFromLive()));
        r0.setNewSourceType(this.a.e0().getNewSourceType());
        JSONObject r1 = new JSONObject();
        com.bytedance.android.livesdk.livecommerce.playback.main.b r2 = this.a.e0().getExplainPlaybackOriginParams();
        if (r2 == null) goto L7;
        ExplainPlaybackRequest r3 = r2.a;
        if (r3 == null) goto L7;
        String r4 = r3.getAuthorId();
    L8:
        String r5 = a2.d(r4);
        if (r5 == null) goto L11;
        r1.put("anchor_id", r5);
    L11:
        Unit r6 = Unit.INSTANCE;
        r0.setReplayBackQueryEntranceInfo(r1);
        r0.setTargetEntranceInfo(this.a.e0().getTargetEntranceInfo());
        return r0;
    L7:
        r4 = null;
        goto L8
    }

    public final JSONObject getEcomLiveParams() {
        return new JSONObject();
    }

    public final String h() {
        cj2.c r0 = cj2.a.a;
        ExplainPlaybackFinalParams r1 = this.a.e0().getExplainPlaybackFinalFinalParams();
        if (r1 == null) goto L7;
        ReplayCards r2 = r1.getReplayCards();
        if (r2 == null) goto L7;
        int r3 = r2.getProductReplayCnt();
    L9:
        if (r3 != 1) goto L11;
        return "product";
    L11:
        if (r3 <= 1) goto L13;
        return "scroll";
    L13:
        return null;
    L7:
        r3 = 0;
        goto L9
    }

    public final long i() {
        ExplainPlaybackFinalParams r0 = this.a.e0().getExplainPlaybackFinalFinalParams();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getServerTime();
    }

    public final Map<String, String> reportParams() {
        if (TextUtils.equals((String) this.d.element, this.a.e0().getTargetEntranceInfo()) == true) goto L6;
        Ref.ObjectRef r0 = this.d;
        r0.element = this.a.e0().getTargetEntranceInfo();
        Ref.ObjectRef r1 = this.e;
        r1.element = this.a.d0((String) this.d.element);
    L6:
        return (Map) this.e.element;
    }

    public final ReplayCards d() {
        return this.f;
    }

    public final void addReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.add(r2);
    }

    public final void g(boolean r3) {
        com.bytedance.android.ec.core.arch.event.c.d(this.a.e0(), new com.bytedance.android.livesdk.livecommerce.playback.main.a.b(r3));
    }

    public final void removeReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b.remove(r2);
    }

    public final void seekReplayProgress(long r2) {
        this.c.postValue(Integer.valueOf(((int) r2) / 1000));
    }

    public final void c(int r4, ECUIPromotion r5) {
        if (cj2.b.e == false) goto L8;
        cj2.b.c();
        com.bytedance.android.ec.monitor.duration.d r0 = i.a.get(cj2.b.a);
        if (r0 == null) goto L7;
        r0.b("not_complete_load_reason", "change_card");
    L7:
        cj2.b.e(false);
    L8:
        this.a.e0().onProductCardShow(r4, r5);
    }

    public final void j(ECUIPromotion r3, ExplainPlaybackVideoInfo r4, ECReplayVideo r5, List<ExplainReplaySubTitle> r6) {
        if (this.a.e0().isVideoPreload(r4) == true) goto L5;
        com.bytedance.android.ec.core.arch.event.c.d(this.a.e0(), new com.bytedance.android.livesdk.livecommerce.playback.main.a.i(r3, r4));
        this.a.e0().updateVideo(r4, r5, r6);
        this.a.e0().resetPreloadVideoStatus();
    L7:
        if (this.a.e0().canEnableSubTitle() == false) goto L10;
        if (r6 == null) goto L10;
        boolean r7 = true;
    L11:
        cj2.a.b = r7;
        ExplainPlaybackMultiCardsPresenter r8 = this.a;
        if (r3 == null) goto L30;
        String r9 = r8.e0().getTargetEntranceInfo();
        if (r9 == null) goto L17;
        JSONObject r10 = com.bytedance.android.livesdk.livecommerce.playback.main.c.c(r9);
        if (r10 == null) goto L17;
    L18:
        r10.put("promotion_id", r3.getPromotionId());
        if (r4 == null) goto L23;
        String r11 = r4.getFragmentId();
        if (r11 == null) goto L23;
    L24:
        r10.put("fragment_id", r11);
        if (r10.has("product_id") == false) goto L29;
        String r12 = r3.getProductId();
        if (r12 == null) goto L29;
        r10.put("product_id", r12);
    L29:
        r8.e0().setTargetEntranceInfo(r10.toString());
        return;
    L23:
        r11 = null;
    L17:
        r10 = new JSONObject();
        goto L18
    L30:
        r8.getClass();
        return;
    L10:
        r7 = false;
        goto L11
    L5:
        com.bytedance.android.ec.core.arch.event.c.d(this.a.e0(), new com.bytedance.android.livesdk.livecommerce.playback.main.a.e(r3, r4));
        goto L7
    }

    public c(ExplainPlaybackMultiCardsPresenter r1, List r2, MutableLiveData r3, Ref.ObjectRef r4, Ref.ObjectRef r5, ReplayCards r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
