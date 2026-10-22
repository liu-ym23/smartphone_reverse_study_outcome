package com.bytedance.locallife.biz.mob;

import com.ss.android.ugc.aweme.etkit.Params;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class e extends Params {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f256709a;

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final JSONObject toJson() {
        int r100 = com.bytedance.locallife.common.utils.b.f257134a;
        return com.bytedance.locallife.common.utils.b.b(this.f256709a);
    }

    @Override // com.ss.android.ugc.aweme.etkit.Params
    public final Object b() {
        return this.f256709a;
    }

    public e(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        this.f256709a = r100;
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final Object get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f256709a.get(r100);
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        com.bytedance.locallife.common.utils.a.d(this.f256709a, r100, String.valueOf(r101));
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final void put(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f256709a.put(r100, String.valueOf(r101));
    }
}
