package com.ss.android.lark.optrace.core;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.lark.optrace.api.TracingSpanData;
import java.util.UUID;

/* JADX INFO: loaded from: classes37.dex */
public class TracingSpanMemData implements TracingSpanData {
    private final String span;

    public String toString() {
        return "TracingSpanMemData{span='" + this.span + "'}";
    }

    public TracingSpanMemData() {
        String[] r100 = lyb.a.f511331a;
        String r101 = UUID.randomUUID().toString().replace("-", "");
        StringBuilder r102 = new StringBuilder();     // Catch: Exception -> L8
        int r103 = 0;
    L4:
        if (r103 >= 8) goto L6;
        int r104 = r103 * 4;     // Catch: Exception -> L8
        int r105 = CastIntegerProtector.parseInt(r101.substring(r104, r104 + 4), 16);     // Catch: Exception -> L8
        String[] r106 = lyb.a.f511331a;     // Catch: Exception -> L8
        r102.append(r106[r105 % r106.length]);     // Catch: Exception -> L8
        r103 = r103 + 1;     // Catch: Exception -> L8
        goto L4
    L6:
        String r107 = r102.toString();     // Catch: Exception -> L8
    L9:
        this.span = r107;
        return;
    L8:
        r107 = r101.substring(0, 8);
        goto L9
    }

    @Override // com.ss.android.lark.optrace.api.TracingSpanData
    public String getSpan() {
        return this.span;
    }
}
