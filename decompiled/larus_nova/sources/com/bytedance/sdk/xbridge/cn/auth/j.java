package com.bytedance.sdk.xbridge.cn.auth;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.HashMap;
import kotlin.Pair;

/* JADX INFO: loaded from: classes22.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, ld7.o> f269847a;

    public j() {
        this.f269847a = new HashMap();
    }

    public static Pair a(String r100, String r101) {
        return new Pair(Boolean.valueOf(PatternProtector.compile(r100, 2).matcher(r101).find()), null);
    L5:
        e = move-exception;
        return new Pair(Boolean.FALSE, e);
    }
}
