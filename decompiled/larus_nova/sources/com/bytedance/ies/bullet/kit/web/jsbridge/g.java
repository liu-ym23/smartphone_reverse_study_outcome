package com.bytedance.ies.bullet.kit.web.jsbridge;

import com.bytedance.ies.web.jsbridge2.q;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f247066a;

    public g(f r100) {
        this.f247066a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.q
    public final <T> String a(T r100) {
        return GsonProtectorUtils.toJson((Gson) this.f247066a.f247064q.getValue(), r100);
    }

    @Override // com.bytedance.ies.web.jsbridge2.q
    public final <T> T b(String r100, Type r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "type");
        return (T) GsonProtectorUtils.fromJson((Gson) this.f247066a.f247064q.getValue(), r100, r101);
    }
}
