package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f214518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f214519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f214520d;

    public a(BitableAppLoader r100, long r101, String r102, String r103) {
        this.f214517a = r100;
        this.f214518b = r101;
        this.f214519c = r102;
        this.f214520d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Result r111 = (Result) r110;
        int r100 = r111.code;
        if (r100 != 0) goto L5;
        String r101 = "";
    L6:
        if (r101 != null) goto L8;
        String r102 = "";
    L9:
        BitableAppLoader r112 = this.f214517a;
        BitableAppLoader.AppResourceType r113 = BitableAppLoader.AppResourceType.FirstScreenData;
        r112.p(r113, new BitableAppLoader.a(this.f214518b, r100, r102, "", null, null, 112));
        if (r100 != 0) goto L14;
        DATA r103 = r111.data;
        if (r103 == 0) goto L14;
        this.f214517a.o(r113, (BitableAppData) r103, null);
        return;
    L14:
        this.f214517a.o(r113, new BitableAppData("", this.f214519c, this.f214520d), new Exception(r100 + ',' + r111.msg));
        return;
    L8:
        r102 = r101;
        goto L9
    L5:
        r101 = r111.msg;
        goto L6
    }
}
