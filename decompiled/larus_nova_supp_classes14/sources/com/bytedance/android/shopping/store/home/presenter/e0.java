package com.bytedance.android.shopping.store.home.presenter;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.floatlayout.StoreFloatLayout;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e0<T> implements Consumer {
    public final /* synthetic */ ECShopFloatLynxPresenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.ec.store.repository.dto.f d;
    public final /* synthetic */ com.bytedance.android.ec.store.repository.dto.f e;
    public final /* synthetic */ com.bytedance.android.ec.store.repository.vo.i f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;

    public e0(ECShopFloatLynxPresenter r1, String r2, String r3, com.bytedance.android.ec.store.repository.dto.f r4, com.bytedance.android.ec.store.repository.dto.f r5, com.bytedance.android.ec.store.repository.vo.i r6, String r7, String r8) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }

    public final void accept(Object r15) {
        List r16 = (List) r15;
        Map r0 = ECShopFloatLynxPresenter.q0(this.a, r16, this.b, 0);
        final Map r7 = ECShopFloatLynxPresenter.q0(this.a, r16, this.c, 1);
        com.bytedance.android.ec.store.repository.dto.f r17 = this.d;
        Integer r1 = null;
        if (r17 == null) goto L12;
        Integer r18 = r17.b();
        nm.b r3 = (nm.b) ((LinkedHashMap) r0).get(this.b);
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.g);
    L9:
        if (ComparisonsKt.compareValues(r18, r4) > 0) goto L12;
        boolean r19 = false;
    L13:
        com.bytedance.android.ec.store.repository.dto.f r5 = this.e;
        if (r5 == null) goto L22;
        Integer r6 = r5.b();
        nm.b r8 = (nm.b) ((LinkedHashMap) r7).get(this.c);
        if (r8 == null) goto L19;
        r1 = Integer.valueOf(r8.g);
    L19:
        if (ComparisonsKt.compareValues(r6, r1) > 0) goto L22;
        boolean r2 = false;
    L23:
        if (r19 == false) goto L34;
        if (r2 == true) goto L26;
        return;
    L26:
        if (this.d == null) goto L28;
        ECShopFloatLynxPresenter.r0(this.a, (nm.b) ((LinkedHashMap) r0).get(this.b), this.f.f(), this.b, 0, this.g);
    L28:
        final Context r9 = this.a.u().c();
        final Fragment r10 = this.a.u().a;
        final JSONObject r11 = com.bytedance.android.ec.core.utils.z1.g(this.f.d());
        final String r12 = this.f.f();
        if (this.f.c() == false) goto L31;
        final int r13 = 0;
    L32:
        View r110 = new ECShopFloatLynxPresenter$createFrequencyControlFloatLayout$asyncTask$1$1(this, r7, r9, r10, r11, r12, r13);
        StoreFloatLayout.d(r110, this.f.e(), MapsKt.mapOf(new Pair[]{TuplesKt.to("metaInfo", this.a.T().getMetaInfo(0)), TuplesKt.to("data", this.f.d())}));
        ECShopFloatLynxPresenter r14 = this.a;
        r14.v = r110;
        r14.x0(r110);
        return;
    L31:
        r13 = this.a.e0();
        goto L32
    L34:
        return;
    L22:
        r2 = true;
        goto L23
    L7:
        r4 = null;
    L12:
        r19 = true;
        goto L13
    }
}
