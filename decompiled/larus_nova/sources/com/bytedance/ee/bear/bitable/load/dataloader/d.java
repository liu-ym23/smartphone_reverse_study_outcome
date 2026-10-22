package com.bytedance.ee.bear.bitable.load.dataloader;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableAppLoader f214529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f214530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f214531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f214532d;

    public d(BitableAppLoader r100, long r101, String r102, String r103) {
        this.f214529a = r100;
        this.f214530b = r101;
        this.f214531c = r102;
        this.f214532d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Throwable r111 = (Throwable) r110;
        BitableAppLoader r100 = this.f214529a;
        BitableAppLoader.AppResourceType r101 = BitableAppLoader.AppResourceType.TableSsrData;
        long r102 = this.f214530b;
        String r103 = r111.getMessage();
        if (r103 != null) goto L5;
        String r104 = "";
    L6:
        BitableAppLoader r105 = this.f214529a;
        Intrinsics.checkNotNull(r111);
        r100.p(r101, new BitableAppLoader.a(r102, -1, r104, BitableAppLoader.j(r105, r111), null, null, 112));
        this.f214529a.o(r101, new BitableAppData("", this.f214531c, this.f214532d), r111);
        return;
    L5:
        r104 = r103;
        goto L6
    }
}
