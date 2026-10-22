package com.bytedance.ee.bear.clip.handlers;

import at5.j;
import com.bytedance.ee.larkwebview.bridge.Status;
import com.ss.android.lark.vfs.VFSFile;
import io.reactivex.functions.Consumer;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ long a;
    public final /* synthetic */ ClipFetchHandler.FetchData b;
    public final /* synthetic */ String c;
    public final /* synthetic */ j d;

    public a(long r1, ClipFetchHandler.FetchData r3, String r4, at5.d r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r10) {
        ClipFetchHandler.FetchResult r11 = (ClipFetchHandler.FetchResult) r10;
        Intrinsics.checkNotNullParameter(r11, "fetchResult");
        long r0 = System.currentTimeMillis() - this.a;
        StringBuilder r2 = new StringBuilder("fetch result for url: ");
        String r3 = this.b.getUrl();
        VFSFile r4 = null;
        if (r3 != null) goto L5;
        r3 = null;
    L5:
        r2.append(du5.b.f(r3));
        r2.append(", result: ");
        r2.append(du5.b.f(r11));
        tt5.a.h("DocsClip#ClipFetchHandler", r2.toString());
        if (this.b.getFile() == null) goto L24;
        ClipFetchHandler.FileInfo r5 = this.b.getFile();
        Intrinsics.checkNotNull(r5);
        String r6 = r5.getFileName();
        if (r6 != null) goto L10;
    L13:
        boolean r7 = true;
    L14:
        if (r7 == true) goto L24;
        ClipFetchHandler.FileInfo r8 = this.b.getFile();
        if (r8 == null) goto L20;
        String r9 = r8.getFileName();
        if (r9 == null) goto L20;
        r4 = ay4.d.a().D(com.bytedance.ee.bear.clip.a.e(), r9);
    L20:
        if (r4 == null) goto L24;
        if (r4.exists() == false) goto L24;
        long r12 = r4.length();
    L26:
        if (r11.getCode() != 0) goto L28;
        int r13 = cw4.a.a;
        cw4.a.a("fetch", r0, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("url", this.c), TuplesKt.to("file_size", Long.valueOf(r12))}));
    L28:
        this.d.a(Status.SUCCESS, r11);
        return;
    L10:
        if (r6.length() == 0) goto L13;
        r7 = false;
    L24:
        r12 = 0;
        goto L26
    }
}
