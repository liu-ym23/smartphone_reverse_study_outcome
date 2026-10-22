package ud3;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.g0;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.LubanParam;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionPackResponse;
import com.bytedance.android.shopping.feed.repository.api.AnchorV3Api;
import com.bytedance.jedi.model.fetcher.AbstractFetcher;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends AbstractFetcher<AnchorV3PromotionRequestParam, PromotionPackResponse, AnchorV3PromotionRequestParam, PromotionPackResponse> {
    public a() {
    }

    public final Object d(Object r2) {
        AnchorV3PromotionRequestParam r3 = (AnchorV3PromotionRequestParam) r2;
        Intrinsics.checkNotNullParameter(r3, "req");
        return r3;
    }

    public final Observable g(Object r36) {
        AnchorV3PromotionRequestParam r0 = (AnchorV3PromotionRequestParam) r36;
        Intrinsics.checkNotNullParameter(r0, "req");
        AnchorV3Api.a.getClass();
        Intrinsics.checkNotNullParameter(r0, "req");
        Integer r1 = r0.getWidth();
        String r3 = null;
        if (r1 != null) goto L6;
    L7:
        Integer r2 = r0.getHeight();
        if (r2 != null) goto L11;
    L13:
        AnchorV3Api r4 = AnchorV3Api.a.a;
        if (r4 == null) goto L24;
        String r5 = r0.getUserId();
        String r6 = r0.getUserId();
        String r7 = r0.getSecUserId();
        List r8 = r0.getPromotionIds();
        String r9 = r0.getItemId();
        String r10 = r0.getSecAuthorId();
        String r11 = r0.getEnterFrom();
        String r12 = r0.getMetaParam();
        String r13 = r0.getAuthorId();
        if (a2.b(r0.getAuthorOpenId()) == false) goto L18;
        String r14 = r0.getAuthorOpenId();
    L19:
        Integer r15 = r0.getWidth();
        Integer r16 = r0.getHeight();
        String r17 = r0.getRankId();
        Integer r18 = r0.getInternalFeedAB();
        LubanParam r19 = r0.getLubanParam();
        if (r19 == null) goto L22;
        r3 = r19.getQianchuanAB();
    L22:
        String r110 = r3;
        String r21 = r0.getCpsTrack();
        String r22 = r0.getAddressId();
        String r23 = r0.getMarketChannel();
        int r20 = g0.a;
        Integer r24 = Integer.valueOf(g0.a(ECAppInfoService.e.getApplicationContext()) ? 1 : 0);
        String r25 = r0.getProductId();
        String r26 = r0.getCreativeId();
        String r27 = r0.getPromotionId();
        String r28 = r0.getInflowMetaParam();
        Map r29 = r0.getPackApiImagesConstraint();
        String r30 = r0.getSourcePage();
        Integer r31 = r0.getSameProductScene();
        Integer r32 = Integer.valueOf(Intrinsics.areEqual(r0.isPreload(), Boolean.TRUE) ? 1 : 0);
        int r33 = f.a;
        Observable r34 = AnchorV3Api.b.a(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, null, r110, 1, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, f.a(r0.getAggParams(), false, false), 16384);
        if (r34 == null) goto L24;
    L39:
        return r34.subscribeOn(Schedulers.io());
    L18:
        r14 = r0.getAuthorId();
    L24:
        r34 = Observable.error(new Throwable());
        goto L39
    L11:
        if (r2.intValue() != 0) goto L13;
    L25:
        AnchorV3Api r35 = AnchorV3Api.a.a;
        if (r35 == null) goto L37;
        String r37 = r0.getUserId();
        String r38 = r0.getUserId();
        String r39 = r0.getSecUserId();
        List r40 = r0.getPromotionIds();
        String r41 = r0.getItemId();
        String r42 = r0.getSecAuthorId();
        String r111 = r0.getEnterFrom();
        String r112 = r0.getMetaParam();
        String r113 = r0.getAuthorId();
        if (a2.b(r0.getAuthorOpenId()) == false) goto L30;
        String r43 = r0.getAuthorOpenId();
    L31:
        String r114 = r43;
        String r115 = r0.getRankId();
        Integer r116 = r0.getInternalFeedAB();
        String r117 = r0.getSourceType();
        LubanParam r44 = r0.getLubanParam();
        if (r44 == null) goto L34;
        String r118 = r44.getQianchuanAB();
    L35:
        String r210 = r0.getCpsTrack();
        String r211 = r0.getAddressId();
        String r212 = r0.getMarketChannel();
        int r45 = g0.a;
        Integer r213 = Integer.valueOf(g0.a(ECAppInfoService.e.getApplicationContext()) ? 1 : 0);
        String r214 = r0.getProductId();
        String r215 = r0.getCreativeId();
        String r216 = r0.getPromotionId();
        String r217 = r0.getInflowMetaParam();
        Map r218 = r0.getPackApiImagesConstraint();
        String r310 = r0.getSourcePage();
        Integer r311 = r0.getSameProductScene();
        Integer r312 = Integer.valueOf(Intrinsics.areEqual(r0.isPreload(), Boolean.TRUE) ? 1 : 0);
        int r46 = f.a;
        r34 = AnchorV3Api.b.a(r35, r37, r38, r39, r40, r41, r42, r111, r112, r113, r114, null, null, r115, r116, r117, r118, 1, r210, r211, r212, r213, r214, r215, r216, r217, r218, r310, r311, r312, f.a(r0.getAggParams(), false, false), 3072);
        if (r34 != null) goto L39;
    L34:
        r118 = null;
        goto L35
    L30:
        r43 = r0.getAuthorId();
    L37:
        r34 = Observable.error(new Throwable());
        goto L39
    L6:
        if (r1.intValue() == 0) goto L25;
        goto L7
    }

    public final Object e(Object r2, Object r3) {
        PromotionPackResponse r4 = (PromotionPackResponse) r3;
        Intrinsics.checkNotNullParameter((AnchorV3PromotionRequestParam) r2, "req");
        Intrinsics.checkNotNullParameter(r4, "resp");
        return r4;
    }
}
