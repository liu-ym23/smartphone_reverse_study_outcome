package com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository;

import android.text.TextUtils;
import androidx.paging.PageKeyedDataSource;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ProductIndex;
import com.bytedance.android.ec.model.playback.ReplayCard;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.ECPromotionBottomBanner;
import com.bytedance.android.ec.monitor.duration.d;
import com.bytedance.android.ec.monitor.duration.i;
import com.bytedance.android.livesdk.livecommerce.livereplay.repository.NetState;
import com.bytedance.android.livesdk.livecommerce.model.FilterNullArrayList;
import com.bytedance.android.livesdk.livecommerce.playback.utils.ExplainPlaybackUtils;
import com.bytedance.android.livesdk.livecommerce.room.f;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import el2.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nl2.c;
import org.json.JSONObject;
import si2.g;
import si2.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/replayrepository/ECReplayScrollProductCardDataSource;", "Landroidx/paging/PageKeyedDataSource;", "", "Lni2/a;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECReplayScrollProductCardDataSource extends PageKeyedDataSource<Integer, ni2.a> {
    public final l a;
    public final oi2.a b;
    public final com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a c;
    public final c d;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ ECReplayScrollProductCardDataSource a;
        public final /* synthetic */ PageKeyedDataSource.LoadCallback b;
        public final /* synthetic */ PageKeyedDataSource.LoadParams c;

        public a(ECReplayScrollProductCardDataSource r1, PageKeyedDataSource.LoadCallback r2, PageKeyedDataSource.LoadParams r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void accept(Object r8) {
            ol.a r9 = (ol.a) r8;
            d r0 = i.a.get(mi2.a.a);
            if (r0 == null) goto L6;
            r0.a("request_end");
        L6:
            if (r9 != null) goto L8;
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("response is null", null);
            return;
        L8:
            ReplayCards r1 = r9.j();
            if (r1 == null) goto L11;
            List<ReplayCard> r2 = r1.getProductReplayCards();
        L12:
            List<ReplayCard> r3 = r2;
            if (r3 != null) goto L15;
        L18:
            boolean r4 = true;
        L19:
            if (r4 == true) goto L21;
            this.a.c.setNetworkState(NetState.SUCCESS);
            this.b.onResult(this.a.e(r2, r9.getServerTime(), false), Integer.valueOf(((Number) this.c.key).intValue() + 1));
            return;
        L21:
            this.a.c.setNetworkState(NetState.LOAD_MORE_ERROR);
            com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadMore response.replayCards is null or empty", null);
            return;
        L15:
            if (r3.isEmpty() == true) goto L18;
            r4 = false;
            goto L19
        L11:
            r2 = null;
            goto L12
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ ECReplayScrollProductCardDataSource a;

        public b(ECReplayScrollProductCardDataSource r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.c.setNetworkState(NetState.LOAD_MORE_ERROR);
            ECExceptionMonitor.e((Throwable) r3);
        }
    }

    public final void f(PageKeyedDataSource.LoadParams<Integer> r23, PageKeyedDataSource.LoadCallback<Integer, ni2.a> r24) {
        ExplainPlaybackRequest r2 = this.b.a;
        if (r2 != null) goto L6;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitialRequest is null.", null);
        return;
    L6:
        String r5 = r2.getPromotionId();
        String r6 = r2.getRoomId();
        String r7 = r2.getAuthorId();
        String r9 = r2.getSourcePage();
        String r4 = r2.getEntranceInfo();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        String r10 = r4;
        String r12 = r2.getCarrierSource();
        String r8 = r2.getSecAuthorId();
        boolean r11 = r2.getNeedAdaptAddr();
        Integer r13 = r2.getModelType();
        String r14 = r2.getEnterScene();
        String r15 = r2.getOriginFragmentId();
        Integer r16 = r2.getEnableMultiCard();
        Integer r17 = r2.getPageSize();
        int r18 = ((Number) r23.key).intValue();
        int r3 = r23.requestedLoadSize;
        int r19 = r3 * r18;
        int r20 = r3 * (r18 + 1);
        List<String> r21 = this.b.d;
        if (r21 == null) goto L12;
        int r22 = r21.size();
    L13:
        if (r19 <= r22) goto L15;
        String r110 = r15;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("startSize:" + r19 + ", totalSize is: " + r22);
    L18:
        List<String> r1 = null;
    L19:
        ExplainPlaybackRequest r25 = new ExplainPlaybackRequest(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r110, r16, r17, 0, r1);
        if (this.b.b <= 0) goto L48;
        PageKeyedDataSource.LoadParams<Integer> r26 = r23;
        if (((Number) r26.key).intValue() <= 0) goto L49;
        List r27 = r25.getPromotionIDs();
        if (r27 != null) goto L26;
    L29:
        boolean r28 = true;
    L30:
        if (r28 == false) goto L33;
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("promotionIDs is empty, no need to continue");
        return;
    L33:
        FilterNullArrayList<k> r29 = ExplainPlaybackUtils.a(r25);
        d r30 = i.a.get(mi2.a.a);
        if (r30 == null) goto L36;
        r30.a("request_start");
    L36:
        l r31 = this.a;
        if (r31 == null) goto L51;
        Observable r32 = r31.a(g.W, r29, ol.a.class, null);
        if (r32 == null) goto L52;
        Observable r33 = r32.subscribeOn(Schedulers.io());
        if (r33 == null) goto L53;
        Observable r34 = r33.observeOn(AndroidSchedulers.mainThread());
        if (r34 == null) goto L54;
        Disposable r35 = r34.subscribe(new a(this, r24, r26), new b(this));
        if (r35 == null) goto L55;
        nl2.b.a(r35, this.d);
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L51:
        return;
    L26:
        if (r27.isEmpty() == true) goto L29;
        r28 = false;
    L49:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadRange params.loadSize: " + ((Integer) r26.key) + " this.params.pageSize: " + this.b.b + " is error, loadMoreRequestParams: false", null);
        return;
    L48:
        r26 = r23;
        goto L49
    L15:
        r110 = r15;
        List<String> r36 = this.b.d;
        if (r36 == null) goto L18;
        r1 = r36.subList(r19, Math.min(r20, r22));
        goto L19
    L12:
        r22 = 0;
        goto L13
    }

    public final void loadAfter(PageKeyedDataSource.LoadParams<Integer> r3, PageKeyedDataSource.LoadCallback<Integer, ni2.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("loadRange");
        f(r3, r4);
    }

    public final void loadBefore(PageKeyedDataSource.LoadParams<Integer> r3, PageKeyedDataSource.LoadCallback<Integer, ni2.a> r4) {
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("loadBefore");
        f(r3, r4);
    }

    public final void loadInitial(PageKeyedDataSource.LoadInitialParams<Integer> r9, PageKeyedDataSource.LoadInitialCallback<Integer, ni2.a> r10) {
        Intrinsics.checkNotNullParameter(r9, "params");
        Intrinsics.checkNotNullParameter(r10, "callback");
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().i("loadInitial");
        List<ReplayCard> r11 = this.b.e;
        List<ReplayCard> r0 = r11;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L16;
        this.c.setNetworkState(NetState.SUCCESS);
        long r4 = this.b.f;
        if (r11.size() != 1) goto L14;
        boolean r2 = true;
    L15:
        List<ni2.a> r3 = e(r11, r4, r2);
        this.c.selectFirstCard(((ni2.a) ListProtector.get(r3, 0)).j, ((ReplayCard) ListProtector.get(r11, 0)).getVideoInfo(), ((ReplayCard) ListProtector.get(r11, 0)).getVideoMbr(), ((ReplayCard) ListProtector.get(r11, 0)).getSubTitle());
        r10.onResult(r3, null, 1);
        return;
    L14:
        r2 = false;
        goto L15
    L16:
        this.c.setNetworkState(NetState.REPLAY_CARDS_EMPTY);
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().b("loadInitial response.replayCards is null or empty", null);
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L10
    }

    public final List<ni2.a> e(List<ReplayCard> r22, long r23, boolean r25) {
        List<ReplayCard> r0 = r22;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r3 = r0.iterator();
    L4:
        if (r3.hasNext() == false) goto L131;
        ReplayCard r4 = (ReplayCard) r3.next();
        ECPromotion r1 = r4.getPromotion();
        String r5 = null;
        boolean r6 = true;
        if (r1 == null) goto L35;
        ECPromotion r8 = r4.getPromotion();
        if (r8 == null) goto L10;
        String r9 = r8.promotionId;
    L11:
        ECPromotion r10 = r4.getPromotion();
        if (r10 == null) goto L14;
        int r11 = r10.index;
    L15:
        if (r11 != 0) goto L34;
        List<ProductIndex> r12 = this.b.c;
        List<ProductIndex> r13 = r12;
        if (r13 != null) goto L20;
    L23:
        boolean r14 = true;
    L24:
        if (r14 == true) goto L33;
        Iterator<ProductIndex> r15 = r12.iterator();
    L28:
        if (r15.hasNext() == false) goto L32;
        ProductIndex r16 = r15.next();
        if (TextUtils.equals(r16.getPromotionId(), r9) == false) goto L28;
        r11 = r16.getIndex();
        goto L34
    L32:
        com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.c().w("not in list", null);
    L33:
        r11 = 0;
        goto L34
    L20:
        if (r13.isEmpty() == true) goto L23;
        r14 = false;
    L34:
        r1.index = r11;
        goto L35
    L14:
        r11 = 0;
        goto L15
    L10:
        r9 = null;
    L35:
        ECPromotion r7 = r4.getPromotion();
        if (r7 == null) goto L38;
        String r17 = r7.promotionId;
    L39:
        List<ProductIndex> r18 = this.b.c;
        if (r18 == null) goto L44;
        ProductIndex r19 = (ProductIndex) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L44;
        String r20 = r19.getPromotionId();
    L46:
        if (TextUtils.isEmpty(r17) == false) goto L48;
    L51:
        Logger.w("Current promotionId or firstPromotionId is empty");
        Integer r21 = null;
    L52:
        Boolean r24 = this.b.h;
        if (r24 == null) goto L55;
        boolean r26 = r24.booleanValue();
    L56:
        ECUIPromotion r27 = com.bytedance.android.livesdk.livecommerce.utils.k.d(r4.getPromotion(), f.a(), r23, Boolean.valueOf(r26));
        JSONObject r110 = r27.getExtraTransmissibleLogParams();
        if (r110 != null) goto L59;
        r110 = new JSONObject();
    L59:
        ExplainPlaybackVideoInfo r111 = r4.getVideoInfo();
        if (r111 == null) goto L62;
        String r112 = r111.getFragmentId();
    L63:
        if (r26 == true) goto L106;
        JSONObject r28 = com.bytedance.android.livesdk.livecommerce.playback.main.c.c(this.b.i);
        if (r28 == null) goto L106;
        r28.put("promotion_id", r27.getPromotionId());
        r28.put("fragment_id", r112);
        String r113 = r28.optString("room_id");
        ExplainPlaybackRequest r114 = this.b.a;
        if (r114 == null) goto L70;
        String r115 = r114.getRoomId();
    L72:
        if ((!Intrinsics.areEqual(r113, r115)) == false) goto L83;
        ExplainPlaybackRequest r116 = this.b.a;
        if (r116 == null) goto L83;
        String r117 = r116.getRoomId();
        if (r117 == null) goto L83;
        if (r117.length() <= 0) goto L80;
        boolean r118 = true;
    L81:
        if (r118 != true) goto L83;
        r28.put("room_id", this.b.a.getRoomId());
        goto L83
    L80:
        r118 = false;
    L83:
        String r119 = r28.optString("anchor_id");
        ExplainPlaybackRequest r120 = this.b.a;
        if (r120 == null) goto L87;
        r5 = r120.getAuthorId();
    L87:
        if ((!Intrinsics.areEqual(r119, r5)) == false) goto L132;
        ExplainPlaybackRequest r29 = this.b.a;
        if (r29 == null) goto L132;
        String r30 = r29.getAuthorId();
        if (r30 == null) goto L132;
        if (r30.length() <= 0) goto L95;
        boolean r31 = true;
    L96:
        if (r31 != true) goto L132;
        r28.put("anchor_id", this.b.a.getAuthorId());
        goto L132
    L95:
        r31 = false;
    L132:
        Result.Companion r32 = Result.Companion;     // Catch: Throwable -> L104
        JSONObject r33 = r27.getExtraTransmissibleLogParams();     // Catch: Throwable -> L104
        Iterator<String> r121 = r28.keys();     // Catch: Throwable -> L104
    L100:
        if (r121.hasNext() == false) goto L102;
        String r122 = r121.next();     // Catch: Throwable -> L104
        r28.put(r122, r28.get(r122));     // Catch: Throwable -> L104
        goto L100
    L102:
        Result.constructor-impl(r33);     // Catch: Throwable -> L104
    L104:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L106
    L70:
        r115 = null;
    L106:
        r110.put("ecom_entrance_form", "replay_popup_card");
        String r123 = this.b.g;
        if (r123 == null) goto L110;
        r110.put("replay_type", r123);
    L110:
        if (r21 == null) goto L112;
        r110.put("is_replay_default_product", r21.intValue());
    L112:
        Unit r124 = Unit.INSTANCE;
        r27.setExtraTransmissibleLogParams(r110);
        Map r125 = r27.getEventParams();
        if (r125 != null) goto L115;
        r125 = new LinkedHashMap();
    L115:
        r125.put("ecom_entrance_form", "replay_popup_card");
        String r35 = this.b.g;
        if (r35 == null) goto L118;
        String r36 = (String) r125.put("replay_type", r35);
    L118:
        if (r21 == null) goto L120;
        r125.put("is_replay_default_product", String.valueOf(r21.intValue()));
    L120:
        r27.setEventParams(r125);
        r27.setExplainType(1);
        ECPromotionBottomBanner r37 = new ECPromotionBottomBanner();
        r37.setText("回放中");
        r27.bottomBanner = r37;
        r27.getClientData().b = true;
        ni2.a r38 = new ni2.a(r27, 0, 0, false);
        r38.d = r4.getVideoInfo();
        if (ECSettingKeys.I0() == false) goto L123;
        r38.e = r4.getVideoMbr();
    L123:
        r38.f = this.b.g;
        r38.g = r21;
        if (r25 == false) goto L129;
        if (r27.getIronIndex() != 0) goto L129;
        r6 = false;
    L129:
        r38.h = r6;
        r38.i = r4.getSubTitle();
        r2.add(r38);
        goto L4
    L62:
        r112 = null;
        goto L63
    L55:
        r26 = false;
        goto L56
    L48:
        if (TextUtils.isEmpty(r20) == true) goto L51;
        r21 = Integer.valueOf(com.bytedance.android.shopping.extensions.k.q(Boolean.valueOf(TextUtils.equals(r17, r20))));
    L44:
        r20 = null;
        goto L46
    L38:
        r17 = null;
        goto L39
    L131:
        return CollectionsKt.toMutableList(r2);
    }

    public ECReplayScrollProductCardDataSource(l r2, oi2.a r3, com.bytedance.android.livesdk.livecommerce.livereplay.replayrepository.a r4, c r5) {
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        Intrinsics.checkNotNullParameter(r4, "callback");
        Intrinsics.checkNotNullParameter(r5, "disposableScope");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
