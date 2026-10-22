package com.bytedance.android.shopping.card_list.repo;

import ab3.b;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.sdk.helper.n;
import com.bytedance.android.shopping.card_list.container.init.LauncherBizType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListErrorMonitorType;
import com.bytedance.android.shopping.card_list.monitor.error.CardListRunCatchExtKt;
import com.bytedance.keva.Keva;
import com.bytedance.kmp.ec.yata.common.protocol.data.e;
import com.bytedance.retrofit2.SsResponse;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b(\u0010)J2\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J&\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0001J,\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00060\u000f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0002J*\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016R\u001f\u0010\u001b\u001a\n \u001a*\u0004\u0018\u00010\u00190\u00198\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R2\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/shopping/card_list/repo/CardListRepository;", "", "", "monitorId", "Lcom/bytedance/android/shopping/card_list/monitor/error/a;", "errorMonitor", "Lcom/bytedance/retrofit2/SsResponse;", "response", "Lorg/json/JSONObject;", "extra", "", "reportForNetworkErr", "host", "url", "req", "Lio/reactivex/Observable;", "Lab3/a;", "queryForCoupon", "Lab3/b;", "getQuery", "Lcom/bytedance/kmp/ec/yata/common/protocol/data/e;", "transformToDTO", "Lcom/bytedance/android/shopping/card_list/container/init/LauncherBizType;", "bizType", "getCacheSourceType", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "responseKeva", "Lcom/bytedance/keva/Keva;", "getResponseKeva", "()Lcom/bytedance/keva/Keva;", "TAG", "Ljava/lang/String;", "Lkotlin/Pair;", "cacheResponse", "Lkotlin/Pair;", "getCacheResponse", "()Lkotlin/Pair;", "setCacheResponse", "(Lkotlin/Pair;)V", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CardListRepository {
    public static final CardListRepository INSTANCE = null;
    private static final String TAG = "CardListRepository";
    private static Pair<? extends LauncherBizType, ? extends e> cacheResponse;
    private static final Keva responseKeva = null;

    private CardListRepository() {
    }

    static {
        INSTANCE = new CardListRepository();
        responseKeva = Keva.getRepo("ecom_card_list_response_storage", 1);
    }

    public final Pair<LauncherBizType, e> getCacheResponse() {
        return cacheResponse;
    }

    public final Keva getResponseKeva() {
        return responseKeva;
    }

    public final String getCacheSourceType(LauncherBizType r4) {
        Intrinsics.checkNotNullParameter(r4, "bizType");
        return responseKeva.getString("card_list_cache_source" + r4.name(), "");
    }

    public final void setCacheResponse(Pair<? extends LauncherBizType, ? extends e> r1) {
        cacheResponse = r1;
    }

    public final Observable<SsResponse<String>> getQuery(String r4, b r5, String r6) {
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "req");
        CardListApi.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "url");
        Intrinsics.checkNotNullParameter(r5, "req");
        return ((CardListApi) n.a.create(r6, CardListApi.class)).getQuery(r6 + '/' + r4, 10485760, r5);
    }

    public final Observable<ab3.a> queryForCoupon(String r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "req");
        CardListApi.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "url");
        Intrinsics.checkNotNullParameter(r6, "req");
        return ((CardListApi) n.a.create(r4, CardListApi.class)).getCouponSchema(r4 + '/' + r5, r6);
    }

    public final e transformToDTO(String r10, com.bytedance.android.shopping.card_list.monitor.error.a r11, SsResponse<String> r12) {
        Intrinsics.checkNotNullParameter(r12, "response");
        Integer r2 = null;
        boolean r3 = false;
        boolean r5 = true;
        if (r12.isSuccessful() == true) goto L6;
    L10:
        r3 = true;
    L11:
        com.bytedance.kmp.ec.yata.common.protocol.data.a r4 = (e) u0.b((String) r12.body(), e.class);     // Catch: Throwable -> L29
        if (r4 != null) goto L56;
        Integer r6 = null;
    L17:
        if (r6 == null) goto L23;
        if (r6.intValue() != 0) goto L23;
        r5 = r3;
    L14:
        th = move-exception;
        com.bytedance.kmp.ec.yata.common.protocol.data.a r7 = r4;
        th = th;
    L31:
        if (r11 != null) goto L52;
    L45:
        if (r3 == false) goto L51;
        JSONObject r1 = new JSONObject();
        if (r7 == null) goto L49;
        Integer r8 = r7.a();
    L50:
        r1.put("biz_status_code", r8);
        Unit r0 = Unit.INSTANCE;
        reportForNetworkErr(r10, r11, r12, r1);
        goto L51
    L49:
        r8 = null;
    L51:
        return null;
    L52:
        CardListErrorMonitorType r9 = CardListErrorMonitorType.TRANSFORM_TO_DTO;     // Catch: Throwable -> L38
        StringBuilder r13 = new StringBuilder("CardListRepository-");     // Catch: Throwable -> L38
        r13.append(th.getMessage());     // Catch: Throwable -> L38
        r13.append('-');     // Catch: Throwable -> L38
        Throwable r14 = th.getCause();     // Catch: Throwable -> L38
        if (r14 == null) goto L35;
        String r15 = r14.getMessage();     // Catch: Throwable -> L38
    L36:
        r13.append(r15);     // Catch: Throwable -> L38
        String r16 = r13.toString();     // Catch: Throwable -> L38
        Map<String, com.bytedance.android.shopping.card_list.monitor.error.a> r17 = com.bytedance.android.shopping.card_list.monitor.error.a.b;     // Catch: Throwable -> L38
        r11.b(r9, r16, null);     // Catch: Throwable -> L38
        goto L45
    L35:
        r15 = null;
    L38:
        th = move-exception;
        if (r3 == false) goto L44;
        JSONObject r18 = new JSONObject();
        if (r7 == null) goto L43;
        r2 = r7.a();
    L43:
        r18.put("biz_status_code", r2);
        Unit r19 = Unit.INSTANCE;
        reportForNetworkErr(r10, r11, r12, r18);
    L44:
        throw th;
    L23:
        if (r5 == false) goto L28;
        JSONObject r20 = new JSONObject();
        if (r4 == null) goto L27;
        r2 = r4.a();
    L27:
        r20.put("biz_status_code", r2);
        Unit r21 = Unit.INSTANCE;
        reportForNetworkErr(r10, r11, r12, r20);
    L28:
        return r4;
    L56:
        r6 = r4.a();     // Catch: Throwable -> L14
        goto L17
    L6:
        if (((CharSequence) r12.body()).length() != 0) goto L8;
        boolean r22 = true;
    L9:
        if (r22 == false) goto L11;
    L8:
        r22 = false;
    L29:
        th = th;
        r7 = null;
        goto L31
    }

    private final void reportForNetworkErr(String r2, final com.bytedance.android.shopping.card_list.monitor.error.a r3, final SsResponse<String> r4, final JSONObject r5) {
        CardListRunCatchExtKt.a(r2, "reportForNetworkErr", new AnonymousClass1(r4, r5, r3));
    }
}
