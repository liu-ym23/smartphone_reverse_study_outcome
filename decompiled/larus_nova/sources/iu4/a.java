package iu4;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableAppData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements NetService.c<Result<BitableAppData>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495789a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495790b;

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<BitableAppData> parse(String r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        Result<BitableAppData> r101 = new Result();
        r101.data = new BitableAppData(r100, this.f495789a, this.f495790b);
        return r101;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        this.f495789a = r100;
        this.f495790b = r101;
    }
}
