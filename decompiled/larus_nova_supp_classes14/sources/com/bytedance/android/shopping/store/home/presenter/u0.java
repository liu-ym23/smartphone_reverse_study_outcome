package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.view.ViewGroup;
import com.bytedance.android.ec.base.service.ECServiceManager;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.store.home.ECShopHeaderVideoManager;
import com.bytedance.android.shopping.store.moments.vo.Author;
import com.bytedance.android.shopping.store.moments.vo.Aweme;
import com.bytedance.android.shopping.store.moments.vo.Video;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ECStoreViewModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u0<T> implements Observer {
    public final /* synthetic */ ECShopLinkageHeaderVideoPresenter a;

    public u0(ECShopLinkageHeaderVideoPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r13) {
        ShopHeaderVideoVO r14 = (ShopHeaderVideoVO) r13;
        List<ShopHeaderVideoInfoVO> r0 = r14.getFeedData();
        String r1 = "";
        if (r0 == null) goto L22;
        Iterator<T> r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L22;
        String r3 = ((ShopHeaderVideoInfoVO) r2.next()).getAwemedata();
        if (r3 == null) goto L6;
        int r4 = com.bytedance.android.ec.store.utils.h.a;
        Aweme r5 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r3, new s0().getType());
        String r6 = r5.getAwemeId();
        if (r6 != null) goto L12;
        r6 = "";
    L12:
        boolean r7 = ECServiceManager.a;
        s83.f r8 = ((s83.g) ECServiceManager.c(s83.g.class)).p();
        if (r8 == null) goto L15;
        r8.r(r6);
    L15:
        ((ArrayList) this.a.I).add(r6);
        Map<String, String> r9 = this.a.J;
        Author r10 = r5.getAuthor();
        if (r10 == null) goto L19;
        String r11 = r10.getUid();
        if (r11 == null) goto L19;
    L20:
        r9.put(r6, r11);
    L19:
        r11 = "";
    L22:
        if (((ArrayList) this.a.I).size() <= 0) goto L50;
        List<ShopHeaderVideoInfoVO> r15 = r14.getFeedData();
        if (r15 == null) goto L50;
        ShopHeaderVideoInfoVO r16 = (ShopHeaderVideoInfoVO) ListProtector.get(r15, 0);
        if (r16 == null) goto L50;
        String r17 = r16.getAwemedata();
        if (r17 == null) goto L50;
        int r12 = com.bytedance.android.ec.store.utils.h.a;
        Aweme r18 = (Aweme) GsonProtectorUtils.fromJson(new Gson(), r17, new t0().getType());
        this.a.T().getVideoManager().b(this.a.I);
        SimpleDraweeView r19 = this.a.y;
        if (r19 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L32:
        Video r110 = r18.getVideo();
        if (r110 == null) goto L35;
        ECUrlModel r111 = r110.getOriginCover();
    L36:
        com.bytedance.android.ec.core.imagex.h0.d(r19, r111, null, null, null, null, null, 120);
        ECShopLinkageHeaderVideoPresenter r112 = this.a;
        ViewGroup r20 = r112.z;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("videoElementLayer");
    L39:
        r20.setVisibility(0);
        ECShopHeaderVideoManager r21 = r112.T().getVideoManager();
        Context r22 = r112.u().c();
        ViewGroup r23 = r112.x;
        if (r23 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("videoSceneContainer");
    L42:
        SimpleDraweeView r24 = r112.y;
        if (r24 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("videoCover");
    L45:
        r21.f(r22, r23, r24);
        r112.F = true;
        ECStoreViewModel r25 = r112.T();
        Pair<String, String>[] r26 = new Pair[2];
        r26[0] = TuplesKt.to("video_id", r112.T().getVideoManager().b);
        Map<String, String> r27 = r112.J;
        LinkedHashMap r28 = (LinkedHashMap) r27;
        String r113 = (String) r28.get(r112.T().getVideoManager().b);
        if (r113 == null) goto L49;
        r1 = r113;
    L49:
        r26[1] = TuplesKt.to("author_id", r1);
        r25.doEventAction("store_video_show", r26);
        goto L50
    L35:
        r111 = null;
    L50:
        ViewGroup r114 = this.a.v;
        if (r114 != null) goto L53;
        Intrinsics.throwUninitializedPropertyAccessException("videoContainer");
    L53:
        wg.a.d(r114, th.a.e(this.a.u().c(), true).getResources().getDimensionPixelSize(2131166417));
    }
}
