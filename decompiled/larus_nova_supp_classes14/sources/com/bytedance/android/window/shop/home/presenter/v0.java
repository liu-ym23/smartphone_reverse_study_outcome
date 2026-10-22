package com.bytedance.android.window.shop.home.presenter;

import android.content.Context;
import com.bytedance.android.ec.window.base.floatlayout.WindowFloatLayout;
import com.bytedance.android.window.shop.home.ECWindowDialogFragment;
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
public final class v0<T> implements Consumer {
    public final /* synthetic */ ECWindowFloatLayerPresenter a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ com.bytedance.android.ec.window.base.repository.dto.t d;
    public final /* synthetic */ com.bytedance.android.ec.window.base.repository.dto.t e;
    public final /* synthetic */ com.bytedance.android.ec.window.base.repository.vo.d f;
    public final /* synthetic */ String g;
    public final /* synthetic */ String h;
    public final /* synthetic */ Map i;

    public v0(ECWindowFloatLayerPresenter r1, String r2, String r3, com.bytedance.android.ec.window.base.repository.dto.t r4, com.bytedance.android.ec.window.base.repository.dto.t r5, com.bytedance.android.ec.window.base.repository.vo.d r6, String r7, String r8, Map r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }

    public final void accept(Object r15) {
        List r16 = (List) r15;
        Map r0 = ECWindowFloatLayerPresenter.a0(this.a, r16, this.b, 0);
        final Map r7 = ECWindowFloatLayerPresenter.a0(this.a, r16, this.c, 1);
        com.bytedance.android.ec.window.base.repository.dto.t r17 = this.d;
        if (r17 == null) goto L12;
        Integer r18 = r17.b();
        io.a r3 = (io.a) ((LinkedHashMap) r0).get(this.b);
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.g);
    L9:
        if (ComparisonsKt.compareValues(r18, r4) > 0) goto L12;
        boolean r19 = false;
    L13:
        com.bytedance.android.ec.window.base.repository.dto.t r5 = this.e;
        if (r5 == null) goto L23;
        Integer r6 = r5.b();
        io.a r8 = (io.a) ((LinkedHashMap) r7).get(this.c);
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.g);
    L20:
        if (ComparisonsKt.compareValues(r6, r9) > 0) goto L23;
        boolean r10 = false;
    L24:
        if (r19 == false) goto L30;
        if (r10 == false) goto L30;
        if (this.d == null) goto L29;
        ECWindowFloatLayerPresenter.b0(this.a, (io.a) ((LinkedHashMap) r0).get(this.b), this.f.e(), this.b, 0, this.g);
    L29:
        final Context r11 = this.a.u().c();
        final ECWindowDialogFragment r12 = this.a.I();
        final JSONObject r13 = com.bytedance.android.ec.core.utils.z1.g(this.f.c());
        final String r14 = this.f.e();
        WindowFloatLayout r110 = new ECWindowFloatLayerPresenter$createFrequencyControlFloatLayout$1$1(this, r7, r11, r12, r13, r14);
        this.a.o = r110;
        r110.e(this.f.d(), MapsKt.mapOf(new Pair[]{TuplesKt.to("metaInfo", this.i), TuplesKt.to("data", this.f.c()), TuplesKt.to("name", this.f.e()), TuplesKt.to("component", com.bytedance.android.shopping.extensions.k.v(this.f))}), null);
        this.a.c0();
        return;
    L30:
        this.a.O().getFloatLayerShowDenied().postValue(this.f.e());
        return;
    L18:
        r9 = null;
    L23:
        r10 = true;
        goto L24
    L7:
        r4 = null;
    L12:
        r19 = true;
        goto L13
    }
}
