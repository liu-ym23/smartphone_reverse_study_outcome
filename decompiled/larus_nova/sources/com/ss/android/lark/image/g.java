package com.ss.android.lark.image;

import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.image.impl.PerfCompressPicMonitor;
import com.ss.android.lark.utils.p;
import io.reactivex.functions.Consumer;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements Consumer<File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f426360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f426361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f426362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f426363d;

    @Override // io.reactivex.functions.Consumer
    public final void accept(File r100) throws Exception {
        File r101 = r100;
        String r102 = r101.getPath();
        if (this.f426360a == false) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == false) goto L10;
        PerfCompressPicMonitor.reportCompressEvent(System.currentTimeMillis() - this.f426362c, this.f426361b, r102);
    L10:
        com.ss.android.lark.image.entity.d r104 = new com.ss.android.lark.image.entity.d(r101, p.g(r101.getPath()));
        this.f426363d.onSuccess(r104);
        return;
    L5:
        if (Objects.equals(this.f426361b, r102) == true) goto L7;
        r103 = true;
        goto L8
    }

    public g(boolean r100, String r101, long r102, IGetDataCallback r103) {
        this.f426360a = r100;
        this.f426361b = r101;
        this.f426362c = r102;
        this.f426363d = r103;
    }
}
