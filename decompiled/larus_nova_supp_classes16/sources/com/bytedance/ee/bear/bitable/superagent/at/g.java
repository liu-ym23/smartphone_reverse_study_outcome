package com.bytedance.ee.bear.bitable.superagent.at;

import android.webkit.ValueCallback;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g<T> implements ValueCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ BitableSuperAgentAtViewModel b;

    public g(int r1, BitableSuperAgentAtViewModel r2) {
        this.a = r1;
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7 */
    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object r6) {
        String r7 = (String) r6;
        if (this.a != this.b.q.get()) goto L50;
        this.b.getClass();
        if (r7 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
    L41:
        ?? r8 = CollectionsKt.emptyList();
    L42:
        BitableSuperAgentAtViewModel r0 = this.b;
        r0.a.runOnUiThread(new f(r0, r8));
        return;
    L14:
        if (Intrinsics.areEqual(r7, "null") == true) goto L41;
        JSONObject r9 = JSON.parseObject(r7);     // Catch: Exception -> L38
        if (r9 == null) goto L36;
        JSONArray r10 = r9.getJSONArray("tables");     // Catch: Exception -> L38
        if (r10 == null) goto L36;
        IntRange r2 = RangesKt.until(0, r10.size());     // Catch: Exception -> L38
        ?? r3 = new ArrayList();     // Catch: Exception -> L38
        IntIterator r4 = r2.iterator();     // Catch: Exception -> L38
    L23:
        if (r4.hasNext() == false) goto L40;
        JSONObject r5 = r10.getJSONObject(r4.nextInt());     // Catch: Exception -> L38
        if (r5 == null) goto L32;
        String r11 = r5.getString("id");     // Catch: Exception -> L38
        if (r11 == null) goto L32;
        String r12 = r5.getString("name");     // Catch: Exception -> L38
        if (r12 == null) goto L32;
        BitableSuperAgentAtViewModel.b r13 = new BitableSuperAgentAtViewModel.b(r11, r12);     // Catch: Exception -> L38
    L34:
        if (r13 == null) goto L23;
        r3.add(r13);     // Catch: Exception -> L38
    L32:
        r13 = null;
    L40:
        r8 = r3;
    L36:
        r8 = CollectionsKt.emptyList();     // Catch: Exception -> L38
    L38:
        e = move-exception;
        tt5.a.k("BitableSuperAgentAtVM", "parseTables error: " + e.getMessage());
        r3 = CollectionsKt.emptyList();
        goto L40
    L8:
        if (StringsKt.isBlank(r7) == true) goto L11;
        r1 = false;
        goto L12
    }
}
