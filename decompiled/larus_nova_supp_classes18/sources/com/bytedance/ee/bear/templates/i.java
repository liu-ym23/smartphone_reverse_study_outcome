package com.bytedance.ee.bear.templates;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T extends Result> implements NetService.c {
    public static final i<T> a = null;

    static {
        a = new i();
    }

    public i() {
    }

    public final Result<Serializable> parse(String r1) {
        return new Result();
    }
}
