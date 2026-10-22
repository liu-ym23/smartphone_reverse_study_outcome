package iu4;

import com.bytedance.ee.bear.bitable.dao.resourcedata.BitableResourceData;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements NetService.c<Result<BitableResourceData>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f495791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f495792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495793c;

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<BitableResourceData> parse(String r100) {
        Result<BitableResourceData> r101 = new Result();
        BitableResourceData r102 = new BitableResourceData();
        r102.setBaseToken(this.f495791a);
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r102.setResValue(r100);
        r102.setBlockId(this.f495792b);
        r102.setViewId(this.f495793c);
        r102.setResKey("BITABLE_CLIENT_VARS");
        r101.data = r102;
        return r101;
    }

    public b(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "baseToken");
        Intrinsics.checkNotNullParameter(r101, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r102, "viewId");
        this.f495791a = r100;
        this.f495792b = r101;
        this.f495793c = r102;
    }
}
