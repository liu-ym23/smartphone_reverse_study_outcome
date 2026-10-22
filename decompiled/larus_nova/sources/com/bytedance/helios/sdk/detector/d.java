package com.bytedance.helios.sdk.detector;

import com.bytedance.android.live.uikit.util.RTLUtil;
import com.bytedance.helios.api.consumer.PrivacyEvent;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d f245520e = null;

    static {
        d r100 = new d();
        f245520e = r100;
        r100.h(c.f245519c);
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final int[] e() {
        int[] r100 = c.f245517a;
        return c.f245517a;
    }

    @Override // com.bytedance.helios.sdk.detector.l
    public final String k() {
        int[] r100 = c.f245517a;
        return RTLUtil.ARABIA_LANG;
    }

    public d() {
    }

    @Override // com.bytedance.helios.sdk.detector.b
    public final void g(PrivacyEvent r100) {
        ApiConfig r101 = this.f245516a.get(r100.f245366c);
        if (r101.f245513b != 3) goto L15;
        int r102 = r100.f245366c;
        if (r102 != 100401) goto L7;
    L14:
        o(r100);
        return;
    L7:
        if (r102 == 100403) goto L14;
        switch(r102) {
            case 102200: goto L13;
            case 102201: goto L12;
            case 102202: goto L11;
            default: goto L21;
        };
    L11:
        com.bytedance.helios.common.utils.d.f().post(new m(this, CollectionsKt.listOf(new Integer[]{100400, 100402}), r100, r101));
        return;
    L12:
        com.bytedance.helios.common.utils.d.f().post(new m(this, CollectionsKt.listOf(100404), r100, r101));
        return;
    L13:
        com.bytedance.helios.common.utils.d.f().post(new m(this, CollectionsKt.listOf(100400), r100, r101));
        return;
    L21:
        return;
    L15:
        n(r101, r100);
    }

    @Override // com.bytedance.helios.sdk.detector.l
    public final List<Integer> j(int r100) {
        switch(r100) {
            case 100404: goto L9;
            case 100405: goto L13;
            case 100501: goto L12;
            case 100503: goto L11;
            default: goto L10;
        };
    L10:
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(100502);
    L12:
        return CollectionsKt.listOf(100500);
    L13:
        return CollectionsKt.listOf(new Integer[]{100402, 100400});
    L9:
        return CollectionsKt.listOf(100400);
    }
}
