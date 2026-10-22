package com.bytedance.android.window.shop.home.tab.presenter;

import android.graphics.Color;
import android.view.View;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.window.shop.repository.dto.WindowHybridTabDataListResponseDTO;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b<T> implements Observer {
    public final /* synthetic */ ECWindowHybridTabPresenter a;

    public b(ECWindowHybridTabPresenter r1) {
        this.a = r1;
    }

    public final void onChanged(Object r6) {
        Iterator<T> r7 = ((WindowHybridTabDataListResponseDTO) r6).categories().iterator();
    L3:
        float[] r1 = null;
        if (r7.hasNext() == false) goto L8;
        T r0 = r7.next();
        if (Intrinsics.areEqual(((com.bytedance.android.window.shop.repository.dto.p) r0).b(), this.a.l0().getLastCategoryId()) == false) goto L3;
    L9:
        com.bytedance.android.window.shop.repository.dto.p r2 = r0;
        if (r2 == null) goto L12;
        com.bytedance.android.window.shop.repository.dto.a0 r8 = r2.h();
    L13:
        if (r8 != null) goto L43;
    L23:
        ArrayList r3 = null;
    L24:
        View r4 = this.a.Z().b(2131370823).f();
        if (r8 == null) goto L50;
        if (r3 != null) goto L28;
    L31:
        boolean r5 = true;
    L32:
        if (r5 == true) goto L51;
        int r9 = r3.size();
        List<Float> r10 = r8.b();
        if (r10 != null) goto L36;
        return;
    L36:
        if (r9 != r10.size()) goto L53;
        int[] r11 = CollectionsKt.toIntArray(r3);
        List<Float> r12 = r8.b();
        if (r12 == null) goto L41;
        r1 = CollectionsKt.toFloatArray(r12);
    L41:
        r4.setBackgroundDrawable(new br3.a(r11, r1));
        return;
    L53:
        return;
    L51:
        return;
    L28:
        if (r3.isEmpty() == true) goto L31;
        r5 = false;
        goto L32
    L50:
        return;
    L43:
        List<String> r13 = r8.a();     // Catch: Exception -> L21
        if (r13 == null) goto L23;
        List<String> r14 = r13;     // Catch: Exception -> L21
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));     // Catch: Exception -> L21
        Iterator<T> r15 = r14.iterator();     // Catch: Exception -> L21
    L18:
        if (r15.hasNext() == false) goto L24;
        r3.add(Integer.valueOf(Color.parseColor((String) r15.next())));     // Catch: Exception -> L21
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
