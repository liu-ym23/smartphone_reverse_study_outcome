package com.bytedance.forest.model;

import com.bytedance.forest.pollyfill.NetWorker;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f244351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f244352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f244353c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PreloadType f244354d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, List<p>> f244355e;

    public final PreloadType getType() {
        return this.f244354d;
    }

    public n(PreloadType r100, Map r101) {
        this(null, r100, r101, true, false, NetWorker.Downloader);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(p r100, PreloadType r101, Map<String, ? extends List<p>> r102) {
        this.f244353c = r100;
        this.f244354d = r101;
        this.f244355e = r102;
    }

    public n(String r100, PreloadType r101, Map<String, ? extends List<p>> r110, boolean r111, boolean r112, NetWorker r113) {
        if (r100 != null) goto L4;
    L7:
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        p r103 = null;
    L11:
        this(r103, r101, r110);
        return;
    L10:
        r103 = new p(r100, r111, r112, r113, 4);
        goto L11
    L4:
        if (r100.length() == 0) goto L7;
        r102 = false;
        goto L8
    }
}
