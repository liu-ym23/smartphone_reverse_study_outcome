package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements NetService.c<Result<ImportResult>> {

    public class a extends TypeToken<Result<ImportResult>> {
        public a() {
        }
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<ImportResult> parse(String r100) throws NetService.ParseException {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
    }
}
