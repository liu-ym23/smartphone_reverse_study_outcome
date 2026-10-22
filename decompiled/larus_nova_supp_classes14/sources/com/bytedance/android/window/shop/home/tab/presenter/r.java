package com.bytedance.android.window.shop.home.tab.presenter;

import android.graphics.Color;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.window.shop.repository.dto.WindowTabDataListResponseDTODeprecated;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r<T> implements Observer {
    public final /* synthetic */ ECWindowTabPresenter a;

    public r(ECWindowTabPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Iterator<T> r7 = ((WindowTabDataListResponseDTODeprecated) r6).categories().iterator();
    L3:
        float[] r1 = null;
        if (r7.hasNext() == false) goto L8;
        T r0 = r7.next();
        String r2 = ((com.bytedance.android.window.shop.repository.dto.p) r0).b();
        ECWindowTabPresenter r3 = this.a;
        int r4 = ECWindowTabPresenter.C;
        if (Intrinsics.areEqual(r2, r3.i0().getLastCategoryId()) == false) goto L3;
    L9:
        com.bytedance.android.window.shop.repository.dto.p r5 = r0;
        if (r5 == null) goto L12;
        com.bytedance.android.window.shop.repository.dto.a0 r8 = r5.h();
    L13:
        if (r8 != null) goto L43;
    L23:
        ArrayList r9 = null;
    L24:
        ECWindowTabPresenter r10 = this.a;
        int r11 = ECWindowTabPresenter.C;
        View r12 = r10.Z().b(2131370823).f();
        if (r8 == null) goto L50;
        if (r9 != null) goto L28;
    L31:
        boolean r13 = true;
    L32:
        if (r13 == true) goto L51;
        int r14 = r9.size();
        List<Float> r15 = r8.b();
        if (r15 != null) goto L36;
        return;
    L36:
        if (r14 != r15.size()) goto L53;
        int[] r16 = CollectionsKt.toIntArray(r9);
        List<Float> r17 = r8.b();
        if (r17 == null) goto L41;
        r1 = CollectionsKt.toFloatArray(r17);
    L41:
        r12.setBackgroundDrawable(new br3.a(r16, r1));
        return;
    L53:
        return;
    L51:
        return;
    L28:
        if (r9.isEmpty() == true) goto L31;
        r13 = false;
        goto L32
    L50:
        return;
    L43:
        List<String> r18 = r8.a();     // Catch: Exception -> L21
        if (r18 == null) goto L23;
        List<String> r19 = r18;     // Catch: Exception -> L21
        r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r19, 10));     // Catch: Exception -> L21
        Iterator<T> r20 = r19.iterator();     // Catch: Exception -> L21
    L18:
        if (r20.hasNext() == false) goto L24;
        r9.add(Integer.valueOf(Color.parseColor((String) r20.next())));     // Catch: Exception -> L21
    L21:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L23
    L12:
        r8 = null;
        goto L13
    L8:
        r0 = (T) null;
        goto L9
    }
}
