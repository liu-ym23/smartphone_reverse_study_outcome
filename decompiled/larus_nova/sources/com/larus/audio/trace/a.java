package com.larus.audio.trace;

import com.mammon.audiosdk.SAMICoreTraceSpanCallback;
import m58.h;
import m58.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements SAMICoreTraceSpanCallback {
    public a() {
    }

    @Override // com.mammon.audiosdk.SAMICoreTraceSpanCallback
    public final void onSpan(int r100, String r101, String r102, String r103, String r104, JSONObject r105) {
        if (r100 != 1) goto L5;
        u r106 = h.f512141l;
        if (r106 == null) goto L16;
        r106.d(r104, r102, r101);
        return;
    L16:
        return;
    L5:
        if (r100 != 2) goto L17;
        u r107 = h.f512141l;
        if (r107 == null) goto L14;
        r107.b(r104, r102, r101, r105);
        return;
    L14:
        return;
    }
}
