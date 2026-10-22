package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements NetService.c<Result<PinPuller$Result>> {

    public class a extends TypeToken<Result<PinPuller$Result>> {
        public a() {
        }
    }

    public j() {
    }

    public final Result<PinPuller$Result> parse(String r3) throws NetService.ParseException {
        return (Result) new Gson().fromJson(r3, new a().getType());
    L4:
        e = move-exception;
        tt5.a.d("PinPuller", "PinResultParser fail: " + e);
        throw new NetService.ParseException();
    }
}
