package com.bytedance.locallife.biz.mob;

import com.ss.android.ugc.aweme.etkit.Params;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends Params {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f256707a;

    @Override // com.ss.android.ugc.aweme.etkit.Params
    public final Object b() {
        return this.f256707a;
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final JSONObject toJson() {
        return this.f256707a;
    }

    public c(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        this.f256707a = r100;
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final Object get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f256707a.opt(r100);
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (this.f256707a.opt(r100) != null) goto L6;
        put(r100, r101);
        return;
    }

    @Override // com.ss.android.ugc.aweme.etkit.IOperation
    public final void put(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f256707a.put(r100, r101);
    }
}
