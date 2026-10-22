package com.bytedance.baidumap.model.mapview;

import com.bytedance.map.api.logger.MapLogger;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.cert.manager.constants.EventConstant;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f199538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f199539b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CustomStyleLoadTrace f199540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f199541d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ a f199542e;

    public final void a() {
        a r100 = this.f199542e;
        int r101 = this.f199538a;
        boolean r102 = false;
        if (r100.f199525c.get() != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L14;
        StringBuilder r104 = new StringBuilder("custom style retry canceled, style operation changed: styleId=");
        r104.append(this.f199539b);
        r104.append(", operationId=");
        r104.append(this.f199538a);
        r104.append(", latestOperationId=");
        r104.append(this.f199542e.f199525c.get());
        r104.append(", traceNull=");
        if (this.f199540c != null) goto L10;
        r102 = true;
    L10:
        r104.append(r102);
        MapLogger.i("BaiduMapView", r104.toString());
        CustomStyleLoadTrace r105 = this.f199540c;
        if (r105 == null) goto L16;
        r105.b(this.f199542e.f199528f, "style_changed", r105.f199519q, r105.f199520r, r105.f199521s, null);
        r105.c();
        return;
    L16:
        return;
    L14:
        this.f199542e.l(this.f199540c, this.f199539b, this.f199541d, EventConstant.Value.RETRY, this.f199538a);
        return;
    L5:
        r103 = false;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public b(a r100, int r101, String r102, CustomStyleLoadTrace r103, String r104) {
        this.f199542e = r100;
        this.f199538a = r101;
        this.f199539b = r102;
        this.f199540c = r103;
        this.f199541d = r104;
    }
}
