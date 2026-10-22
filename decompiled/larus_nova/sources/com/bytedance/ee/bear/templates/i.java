package com.bytedance.ee.bear.templates;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;

/* JADX INFO: loaded from: classes18.dex */
public final class i<T extends Result> implements NetService.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T> f239119a = null;

    static {
        f239119a = new i();
    }

    public i() {
    }

    @Override // com.bytedance.ee.bear.contract.NetService.c
    public final Result<Serializable> parse(String r100) {
        return new Result();
    }
}
