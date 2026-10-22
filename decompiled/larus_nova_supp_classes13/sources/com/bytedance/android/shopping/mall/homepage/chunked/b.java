package com.bytedance.android.shopping.mall.homepage.chunked;

import com.bytedance.android.ec.hybrid.data.ECHybridDataEngine;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListItemDTO;
import com.bytedance.android.ec.hybrid.list.entity.dto.ECHybridListSectionDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageBffDTO;
import com.bytedance.android.shopping.api.mall.model.HomePageDTO;
import com.bytedance.android.shopping.mall.homepage.tools.DataEngineWrapper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b<V> implements Callable {
    public final /* synthetic */ HomepageChunkedCallback a;
    public final /* synthetic */ HomePageDTO b;

    public b(HomepageChunkedCallback r1, HomePageDTO r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.util.concurrent.Callable
    public final Unit call() {
        HomepageChunkedCallback r0 = this.a;
        HomePageDTO r1 = this.b;
        int r2 = HomepageChunkedCallback.o;
        r0.getClass();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L65
        HomePageBffDTO r4 = r1.getBff();     // Catch: Throwable -> L65
        if (r4 == null) goto L62;
        ECHybridListDTO r5 = r4.getFeed();     // Catch: Throwable -> L65
        if (r5 == null) goto L62;
        List r6 = r5.getSections();     // Catch: Throwable -> L65
        if (r6 == null) goto L62;
        Iterator r7 = r6.iterator();     // Catch: Throwable -> L65
    L11:
        if (r7.hasNext() == false) goto L61;
        ArrayList r8 = ((ECHybridListSectionDTO) r7.next()).getItems();     // Catch: Throwable -> L65
        if (r8 == null) goto L11;
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L65
    L16:
        if (r9.hasNext() == false) goto L11;
        ECHybridListItemDTO r10 = (ECHybridListItemDTO) r9.next();     // Catch: Throwable -> L65
        String r11 = r10.getItemData();     // Catch: Throwable -> L65
        boolean r12 = true;
        if (r11 != null) goto L20;
    L23:
        boolean r13 = true;
    L24:
        if (r13 == true) goto L16;
        String r14 = r10.getRecommendInfoFromChunked();     // Catch: Throwable -> L65
        if (r14 != null) goto L28;
    L31:
        boolean r15 = true;
    L32:
        if (r15 == true) goto L16;
        String r16 = r10.getItemData();     // Catch: Throwable -> L65
        if (r16 == null) goto L37;
        JSONObject r17 = new JSONObject(r16);     // Catch: Throwable -> L65
    L39:
        if (r17 == null) goto L42;
        JSONObject r18 = r17.optJSONObject("extra");     // Catch: Throwable -> L65
    L44:
        if (r18 == null) goto L46;
        String r19 = r18.optString("recommend_info");     // Catch: Throwable -> L65
    L47:
        if (r19 != null) goto L49;
    L52:
        if (r12 == false) goto L57;
        if (r18 == null) goto L55;
        r18.putOpt("recommend_info", r10.getRecommendInfoFromChunked());     // Catch: Throwable -> L65
    L55:
        if (r17 == null) goto L57;
        r17.putOpt("extra", r18);     // Catch: Throwable -> L65
    L57:
        if (r17 == null) goto L59;
        String r20 = r17.toString();     // Catch: Throwable -> L65
    L60:
        r10.setItemData(r20);     // Catch: Throwable -> L65
        goto L16
    L59:
        r20 = null;
        goto L60
    L49:
        if (r19.length() == 0) goto L52;
        r12 = false;
        goto L52
    L46:
        r19 = null;
        goto L47
    L42:
        r18 = null;
        goto L44
    L37:
        r17 = null;
        goto L39
    L28:
        if (r14.length() == 0) goto L31;
        r15 = false;
        goto L32
    L20:
        if (r11.length() == 0) goto L23;
        r13 = false;
        goto L24
    L61:
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L65
    L63:
        Result.constructor-impl(r21);     // Catch: Throwable -> L65
    L67:
        this.a.n.i.invoke(this.b);
        DataEngineWrapper r22 = this.a.c;
        if (r22 == null) goto L86;
        ECHybridDataEngine r23 = r22.a;
        if (r23 == null) goto L87;
        r23.d(GsonProtectorUtils.toJson(new Gson(), this.b));
        return Unit.INSTANCE;
    L87:
        return null;
    L86:
        return null;
    L62:
        r21 = null;
    L65:
        th = move-exception;
        Result.Companion r24 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L67
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
