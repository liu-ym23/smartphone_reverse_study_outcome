package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.bear.BlockSimpleInfo;
import com.bytedance.ee.bear.contract.NetService;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c0 {
    public final String a;
    public final ArrayList<BlockSimpleInfo> b;
    public final ArrayList<BlockSimpleInfo> c;

    public static final class a {
    }

    static {
    }

    public final Flowable<RoleResult> a() {
        NetService r0 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        StringCompanionObject r1 = StringCompanionObject.INSTANCE;
        return r0.Vc(new h0(this.b, this.c)).a(new NetService.f(String.format("/space/api/bitable/%s/roles", Arrays.copyOf(new Object[]{this.a}, 1))));
    }

    public c0(String r2, ArrayList<BlockSimpleInfo> r3, ArrayList<BlockSimpleInfo> r4) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "tableList");
        Intrinsics.checkNotNullParameter(r4, "blockList");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
