package com.bytedance.ee.bear.drive.biz.importfile.im.entity;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements NetService.c<Result<CreateResult>> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.importfile.im.entity.a$a, reason: collision with other inner class name */
    public class C0129a extends TypeToken<Result<CreateResult>> {
        public C0129a() {
        }
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<CreateResult> parse(String r3) throws NetService.ParseException {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new C0129a().getType());
    }
}
