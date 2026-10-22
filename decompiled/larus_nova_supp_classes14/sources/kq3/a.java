package kq3;

import com.bytedance.android.ec.window.base.dynamicview.common.WindowDynamicViewCache;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.api.ShopHeaderRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import io.reactivex.Observable;
import kotlin.jvm.internal.Intrinsics;
import mq3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Observable a(ShopHeaderRequestParam r9) {
        Intrinsics.checkNotNullParameter(r9, "reqParam");
        ECWindowApi.a.getClass();
        ECWindowApi r1 = ECWindowApi.a.a;
        if (r1 == null) goto L7;
        Observable<WindowHeaderResponseDTO> r10 = r1.getShopHeader(Integer.valueOf(r9.isPrefetch()), r9.getSecAuthorId(), r9.getSourceType(), r9.getPassThroughApi(), r9.getUpgradeVersion(), r9.getSceneType(), r9.getEcExtra());
        if (r10 == null) goto L7;
        return r10;
    L7:
        return Observable.error(new Throwable("ECNetworkService not init"));
    }

    public static Observable b(mq3.a r22) {
        mq3.a r0 = r22;
        Intrinsics.checkNotNullParameter(r0, "reqParam");
        ECWindowApi.a.getClass();
        ECWindowApi r2 = ECWindowApi.a.b;
        if (r2 == null) goto L65;
        Integer r3 = Integer.valueOf(r22.isPrefetch());
        String r4 = r22.getSecAuthorId();
        int r5 = r22.getTabType();
        int r6 = r22.getPageNum();
        Integer r7 = Integer.valueOf(r22.getPageSize());
        String r8 = r22.getPassThroughApi();
        boolean r1 = r0 instanceof c;
        if (r1 == true) goto L7;
        mq3.a r10 = null;
    L8:
        c r11 = (c) r10;
        if (r11 == null) goto L11;
        Long r12 = r11.getSortType();
    L12:
        if (r1 == true) goto L14;
        mq3.a r13 = null;
    L15:
        c r14 = (c) r13;
        if (r14 == null) goto L18;
        Integer r15 = r14.getSort();
    L19:
        if (r1 == true) goto L21;
        mq3.a r16 = null;
    L22:
        c r17 = (c) r16;
        if (r17 == null) goto L25;
        String r18 = r17.getTargetFilterType();
    L26:
        String r19 = r22.getCommonPassThroughParam();
        Boolean r110 = Boolean.valueOf(r22.isFirstEnter());
        if (r1 == true) goto L29;
        mq3.a r111 = null;
    L30:
        c r112 = (c) r111;
        if (r112 == null) goto L33;
        String r113 = r112.getClickedProducts();
    L34:
        if (r1 == true) goto L36;
        mq3.a r114 = null;
    L37:
        c r115 = (c) r114;
        if (r115 == null) goto L40;
        String r116 = r115.getTargetCategory();
    L41:
        Integer r117 = r22.getUpgradeVersion();
        String r118 = r22.getForceInsertInfo();
        String r119 = r22.getEcExtra();
        WindowDynamicViewCache r20 = WindowDynamicViewCache.g;
        monitor-enter(r20);
        String r21 = WindowDynamicViewCache.e.toString();     // Catch: Throwable -> L61
        monitor-exit(r20);
        if (r1 == true) goto L47;
        mq3.a r23 = null;
    L48:
        c r24 = (c) r23;
        if (r24 == null) goto L51;
        String r25 = r24.getTargetSubCategory();
    L52:
        if (r1 == true) goto L54;
        r0 = null;
    L54:
        c r9 = (c) r0;
        if (r9 == null) goto L57;
        String r26 = r9.getChildCategory();
    L58:
        Observable<WindowHybridTabDataListResponseDTO> r27 = r2.getWindowTabBffDataList(r3, r4, r5, r6, r7, r8, r12, r15, r18, r19, r110, r113, r116, r117, r118, r119, r21, r25, r26);
        if (r27 == null) goto L65;
        return r27;
    L57:
        r26 = null;
        goto L58
    L51:
        r25 = null;
        goto L52
    L47:
        r23 = r0;
    L61:
        th = move-exception;
        throw th;
    L40:
        r116 = null;
        goto L41
    L36:
        r114 = r0;
        goto L37
    L33:
        r113 = null;
        goto L34
    L29:
        r111 = r0;
        goto L30
    L25:
        r18 = null;
        goto L26
    L21:
        r16 = r0;
        goto L22
    L18:
        r15 = null;
        goto L19
    L14:
        r13 = r0;
        goto L15
    L11:
        r12 = null;
        goto L12
    L7:
        r10 = r0;
    L65:
        return Observable.error(new Throwable("ECNetworkService not init"));
    }

    public static Observable c(mq3.a r20) {
        mq3.a r0 = r20;
        Intrinsics.checkNotNullParameter(r0, "reqParam");
        ECWindowApi.a.getClass();
        ECWindowApi r2 = ECWindowApi.a.a;
        if (r2 == null) goto L58;
        Integer r3 = Integer.valueOf(r20.isPrefetch());
        String r4 = r20.getSecAuthorId();
        int r5 = r20.getTabType();
        int r6 = r20.getPageNum();
        Integer r7 = Integer.valueOf(r20.getPageSize());
        String r8 = r20.getPassThroughApi();
        boolean r1 = r0 instanceof c;
        if (r1 == true) goto L7;
        mq3.a r10 = null;
    L8:
        c r11 = (c) r10;
        if (r11 == null) goto L11;
        Long r12 = r11.getSortType();
    L12:
        if (r1 == true) goto L14;
        mq3.a r13 = null;
    L15:
        c r14 = (c) r13;
        if (r14 == null) goto L18;
        Integer r15 = r14.getSort();
    L19:
        if (r1 == true) goto L21;
        mq3.a r16 = null;
    L22:
        c r17 = (c) r16;
        if (r17 == null) goto L25;
        String r18 = r17.getTargetFilterType();
    L26:
        String r19 = r20.getCommonPassThroughParam();
        Boolean r110 = Boolean.valueOf(r20.isFirstEnter());
        if (r1 == true) goto L29;
        mq3.a r111 = null;
    L30:
        c r112 = (c) r111;
        if (r112 == null) goto L33;
        String r113 = r112.getClickedProducts();
    L34:
        if (r1 == true) goto L36;
        mq3.a r114 = null;
    L37:
        c r115 = (c) r114;
        if (r115 == null) goto L40;
        String r116 = r115.getTargetCategory();
    L41:
        Integer r117 = r20.getUpgradeVersion();
        String r118 = r20.getForceInsertInfo();
        if (r1 == true) goto L44;
        mq3.a r119 = null;
    L45:
        c r120 = (c) r119;
        if (r120 == null) goto L48;
        String r121 = r120.getTargetSubCategory();
    L49:
        if (r1 == true) goto L51;
        r0 = null;
    L51:
        c r9 = (c) r0;
        if (r9 == null) goto L54;
        String r21 = r9.getChildCategory();
    L55:
        Observable<WindowTabDataListResponseDTODeprecated> r22 = r2.getShopTabDataList(r3, r4, r5, r6, r7, r8, r12, r15, r18, r19, r110, r113, r116, r117, r118, r121, r21);
        if (r22 == null) goto L58;
        return r22;
    L54:
        r21 = null;
        goto L55
    L48:
        r121 = null;
        goto L49
    L44:
        r119 = r0;
        goto L45
    L40:
        r116 = null;
        goto L41
    L36:
        r114 = r0;
        goto L37
    L33:
        r113 = null;
        goto L34
    L29:
        r111 = r0;
        goto L30
    L25:
        r18 = null;
        goto L26
    L21:
        r16 = r0;
        goto L22
    L18:
        r15 = null;
        goto L19
    L14:
        r13 = r0;
        goto L15
    L11:
        r12 = null;
        goto L12
    L7:
        r10 = r0;
    L58:
        return Observable.error(new Throwable("ECNetworkService not init"));
    }
}
