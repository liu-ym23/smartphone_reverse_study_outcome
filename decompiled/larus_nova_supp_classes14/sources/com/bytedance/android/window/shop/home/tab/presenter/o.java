package com.bytedance.android.window.shop.home.tab.presenter;

import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.window.shop.holder.ShopWindowItemHolder;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.bytedance.awemeopen.apps.framework.comment.api.root.CommentScene;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class o implements Runnable {
    public final /* synthetic */ ECWindowTabPresenter a;

    public o(ECWindowTabPresenter r1) {
        this.a = r1;
    }

    public final void a() {
        ECWindowTabPresenter r0 = this.a;
        int r1 = ECWindowTabPresenter.C;
        com.bytedance.android.window.shop.widget.holderprocessor.c r2 = r0.e0().d;
        Iterator<T> r3 = r2.b.entrySet().iterator();
    L3:
        String r4 = null;
        if (r3.hasNext() == false) goto L8;
        Object r5 = r3.next();
        if ((!((com.bytedance.android.window.shop.widget.holderprocessor.a) ((Map.Entry) r5).getValue()).c) == false) goto L3;
    L9:
        Map.Entry r6 = (Map.Entry) r5;
        if (r6 == null) goto L28;
        com.bytedance.android.window.shop.widget.holderprocessor.a r7 = (com.bytedance.android.window.shop.widget.holderprocessor.a) r6.getValue();
        if (r7 == null) goto L28;
        ConcurrentHashMap<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a> r8 = r2.b;
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<Map.Entry<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a>> r10 = r8.entrySet().iterator();
    L16:
        if (r10.hasNext() == false) goto L20;
        Map.Entry<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a> r11 = r10.next();
        if ((!r11.getValue().c) == false) goto L16;
        r9.put(r11.getKey(), r11.getValue());
        goto L16
    L20:
        Iterator r12 = r9.entrySet().iterator();
    L22:
        if (r12.hasNext() == false) goto L29;
        Map.Entry r13 = (Map.Entry) r12.next();
        if (((com.bytedance.android.window.shop.widget.holderprocessor.a) r13.getValue()).b == (-1)) goto L22;
        if (((com.bytedance.android.window.shop.widget.holderprocessor.a) r13.getValue()).b <= r7.b) goto L22;
        r7 = (com.bytedance.android.window.shop.widget.holderprocessor.a) r13.getValue();
    L29:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r14 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r15 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.i0().getLifecycleMonitorId());
        long r16 = 0;
        if (r15 == null) goto L36;
        ECWindowParam r17 = this.a.h0().getShopParam();
        if (r7 == null) goto L34;
        long r18 = r7.b;
    L35:
        com.bytedance.android.window.shop.lifecycle.e.a.a(r15, r17, r18);
        goto L36
    L34:
        r18 = 0;
    L36:
        com.bytedance.android.window.shop.widget.holderprocessor.c r19 = this.a.e0().d;
        Map.Entry r20 = (Map.Entry) CollectionsKt.firstOrNull(r19.b.entrySet());
        if (r20 == null) goto L79;
        com.bytedance.android.window.shop.widget.holderprocessor.a r21 = (com.bytedance.android.window.shop.widget.holderprocessor.a) r20.getValue();
        if (r21 == null) goto L79;
        ConcurrentHashMap<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a> r22 = r19.b;
        if (r22.isEmpty() == true) goto L55;
        Iterator<Map.Entry<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a>> r23 = r22.entrySet().iterator();
    L46:
        if (r23.hasNext() == false) goto L55;
        Map.Entry<ShopWindowItemHolder<? extends com.bytedance.android.window.shop.repository.tab.entity.f>, com.bytedance.android.window.shop.widget.holderprocessor.a> r24 = r23.next();
        if (r24.getValue().b == (-1)) goto L50;
    L52:
        boolean r25 = false;
    L53:
        if (r25 == false) goto L46;
        boolean r26 = true;
    L56:
        r19.a = r26;
        Iterator<T> r27 = r19.b.entrySet().iterator();
        if (r27.hasNext() == true) goto L59;
        Object r28 = null;
    L74:
        Map.Entry r29 = (Map.Entry) r28;
        if (r29 == null) goto L80;
        com.bytedance.android.window.shop.widget.holderprocessor.a r30 = (com.bytedance.android.window.shop.widget.holderprocessor.a) r29.getValue();
        if (r30 == null) goto L80;
        r21 = r30;
    L80:
        ConcurrentHashMap<Long, com.bytedance.android.window.shop.lifecycle.f> r31 = com.bytedance.android.window.shop.lifecycle.c.a;
        com.bytedance.android.window.shop.lifecycle.f r32 = com.bytedance.android.window.shop.lifecycle.c.a(this.a.i0().getLifecycleMonitorId());
        if (r32 == null) goto L126;
        ECWindowParam r33 = this.a.h0().getShopParam();
        if (r21 == null) goto L85;
        r16 = r21.b;
    L85:
        JSONObject r34 = new JSONObject();
        r34.put("current_category_id", this.a.i0().getLastCategoryId());
        r34.put("current_category_name", this.a.i0().getCategoryName());
        String r35 = this.a.i0().getLastCategoryId();
        WindowTabDataListResponseDTODeprecated r36 = (WindowTabDataListResponseDTODeprecated) this.a.h0().getHeaderSubTabsParam().c.getValue();
        if (r36 == null) goto L88;
        r4 = r36.getSelectCategoryId();
    L88:
        r34.put("is_default_category", Intrinsics.areEqual(r35, r4) ? 1 : 0);
        Long r37 = this.a.h0().getShopParam().getStartGapTime();
        if (r37 == null) goto L91;
        long r38 = r37.longValue();
    L92:
        r34.put("flag_open_gap", String.valueOf(r38));
        if (this.a.e0().d.a == false) goto L95;
        String r39 = "0";
    L96:
        r34.put("is_lynx_time_out", r39);
        if (r21 == null) goto L101;
        Map<String, String> r40 = r21.d;
        if (r40 == null) goto L101;
        z1.b(r34, com.bytedance.android.ec.hybrid.list.util.k.b(r40));
    L101:
        Unit r41 = Unit.INSTANCE;
        com.bytedance.android.window.shop.lifecycle.e.a.b(r32, r33, r16, r34);
        return;
    L95:
        r39 = CommentScene.COMMENTSCENE_NO_AWEME;
        goto L96
    L91:
        r38 = Long.MAX_VALUE;
        goto L92
    L126:
        return;
    L59:
        r28 = r27.next();
        if (r27.hasNext() == false) goto L74;
        if (((com.bytedance.android.window.shop.widget.holderprocessor.a) ((Map.Entry) r28).getValue()).b <= r21.b) goto L65;
        char r42 = 1;
    L66:
        Object r43 = r27.next();
        if (((com.bytedance.android.window.shop.widget.holderprocessor.a) ((Map.Entry) r43).getValue()).b <= r21.b) goto L69;
        char r44 = 1;
    L70:
        if (r42 >= r44) goto L73;
        r28 = r43;
        r42 = r44;
    L73:
        if (r27.hasNext() == true) goto L66;
    L69:
        r44 = 0;
        goto L70
    L65:
        r42 = 0;
        goto L66
    L50:
        if (r24.getValue().c == false) goto L52;
        r25 = true;
    L55:
        r26 = false;
    L79:
        r21 = null;
    L28:
        r7 = null;
        goto L29
    L8:
        r5 = null;
        goto L9
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
