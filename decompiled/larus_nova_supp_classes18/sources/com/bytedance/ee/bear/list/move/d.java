package com.bytedance.ee.bear.list.move;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements NetService.c<Result<GetMoveReviewerInfoPuller$Result>> {

    public class a extends TypeToken<Result<GetMoveReviewerInfoPuller$Result>> {
        public a() {
        }
    }

    public d() {
    }

    public final Result<GetMoveReviewerInfoPuller$Result> parse(String r3) {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new a().getType());
    }
}
