package com.bytedance.ee.bear.wikiv2.spacedetail;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements NetService.c<Result<WikiSpaceInfo>> {

    public class a extends TypeToken<Result<WikiSpaceInfo>> {
        public a() {
        }
    }

    public j() {
    }

    public final Result<WikiSpaceInfo> parse(String r3) {
        return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new a().getType());
    }
}
