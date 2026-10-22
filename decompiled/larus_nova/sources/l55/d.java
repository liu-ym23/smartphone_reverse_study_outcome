package l55;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.biz.importfile.request.CheckImportRequester$ImportCheckResult;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements NetService.c<Result<CheckImportRequester$ImportCheckResult>> {
    public d() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<CheckImportRequester$ImportCheckResult> parse(String r100) {
        Result<CheckImportRequester$ImportCheckResult> r101 = new Result();
        r101.setData((CheckImportRequester$ImportCheckResult) JSON.parseObject(r100, CheckImportRequester$ImportCheckResult.class));
        return r101;
    }
}
