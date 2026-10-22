package com.bytedance.android.window.shop.repository;

import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.window.shop.repository.api.ECWindowApi;
import com.bytedance.android.window.shop.repository.api.WindowComponentRequestParam;
import com.bytedance.android.window.shop.repository.dto.WindowComponentResponseDTO;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kq3.a;
import lq3.b;
import mq3.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class ShopRepository {
    public static final ShopRepository a = null;

    public ShopRepository() {
    }

    static {
        a = new ShopRepository();
    }

    public static ReplaySubject a(WindowComponentRequestParam r10) {
        Intrinsics.checkNotNullParameter(r10, "reqParam");
        ReplaySubject r1 = ReplaySubject.a();
        int r2 = a.a;
        Intrinsics.checkNotNullParameter(r10, "reqParam");
        ECWindowApi.a.getClass();
        ECWindowApi r3 = ECWindowApi.a.a;
        if (r3 == null) goto L16;
        Integer r4 = Integer.valueOf(r10.isPrefetch());
        String r5 = r10.getSecAuthorId();
        String r6 = r10.getPassThroughApi();
        Integer r7 = r10.getSourceType();
        String r8 = r10.getExtraSchema();
        b<?> r0 = r10.getSceneParams();
        if (r0 == null) goto L9;
        lq3.a<?> r9 = r0.a;
        if (r9 == null) goto L9;
        String r11 = r9.a;
    L10:
        b<?> r12 = r10.getSceneParams();
        if (r12 == null) goto L13;
        String r13 = u0.d(r12.b);
    L14:
        Observable<WindowComponentResponseDTO> r14 = r3.getComponentData(r4, r5, r6, r7, r8, r11, r13);
        if (r14 == null) goto L16;
    L17:
        r14.subscribeOn(Schedulers.io()).subscribe(r1);
        return r1;
    L13:
        r13 = null;
    L9:
        r11 = null;
    L16:
        r14 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L17
    }

    public static ReplaySubject b(mq3.a r18) {
        Intrinsics.checkNotNullParameter(r18, "reqParam");
        ReplaySubject r2 = ReplaySubject.a();
        int r3 = a.a;
        Intrinsics.checkNotNullParameter(r18, "reqParam");
        String r5 = r18.getPath();
        if (r5 != null) goto L5;
        Observable<WindowTabDataListResponseDTODeprecated> r0 = Observable.error(new Throwable("ECNetworkService not init"));
    L40:
        r0.subscribeOn(Schedulers.io()).subscribe(r2);
        return r2;
    L5:
        ECWindowApi.a.getClass();
        ECWindowApi r4 = ECWindowApi.a.a;
        if (r4 == null) goto L39;
        String r6 = r18.getSecAuthorId();
        int r7 = r18.getTabType();
        int r8 = r18.getPageNum();
        Integer r9 = Integer.valueOf(r18.getPageSize());
        String r10 = r18.getPassThroughApi();
        boolean r11 = r18 instanceof c;
        if (r11 == true) goto L10;
        mq3.a r12 = null;
    L11:
        c r13 = (c) r12;
        if (r13 == null) goto L14;
        Long r14 = r13.getSortType();
    L15:
        if (r11 == true) goto L17;
        mq3.a r15 = null;
    L18:
        c r16 = (c) r15;
        if (r16 == null) goto L21;
        Integer r17 = r16.getSort();
    L22:
        String r19 = r18.getCommonPassThroughParam();
        Boolean r110 = Boolean.valueOf(r18.isFirstEnter());
        if (r11 == true) goto L25;
        mq3.a r111 = null;
    L26:
        c r112 = (c) r111;
        if (r112 == null) goto L29;
        String r113 = r112.getClickedProducts();
    L30:
        if (r11 == true) goto L32;
        mq3.a r20 = null;
    L33:
        c r21 = (c) r20;
        if (r21 == null) goto L36;
        String r22 = r21.getTargetCategory();
    L37:
        r0 = r4.getGuessLike(r5, r6, r7, r8, r9, r10, r14, r17, r19, r110, r113, r22, r18.getForceInsertInfo());
        if (r0 != null) goto L40;
    L36:
        r22 = null;
        goto L37
    L32:
        r20 = r18;
        goto L33
    L29:
        r113 = null;
        goto L30
    L25:
        r111 = r18;
        goto L26
    L21:
        r17 = null;
        goto L22
    L17:
        r15 = r18;
        goto L18
    L14:
        r14 = null;
        goto L15
    L10:
        r12 = r18;
    L39:
        r0 = Observable.error(new Throwable("ECNetworkService not init"));
        goto L40
    }

    public static Function1 c(final String r1) {
        Intrinsics.checkNotNullParameter(r1, "path");
        return new ShopRepository$makeFetcher$1(r1);
    }
}
