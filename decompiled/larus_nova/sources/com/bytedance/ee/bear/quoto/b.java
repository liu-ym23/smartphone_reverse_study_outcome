package com.bytedance.ee.bear.quoto;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements NetService.c<Result<BusinessInfoRequester$BusinessInfoResult>> {

    public class a extends TypeToken<Result<BusinessInfoRequester$BusinessInfoResult>> {
        public a() {
        }
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<BusinessInfoRequester$BusinessInfoResult> parse(String r100) throws NetService.ParseException {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
    }
}
