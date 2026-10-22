package com.larus.agents.impl.webfetch;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.mime.TypedInput;

/* JADX INFO: loaded from: classes24.dex */
public final class g implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Call<TypedInput> f286853a;

    public final e a() {
        return new e(this.f286853a.execute());
    }

    @Override // com.larus.agents.impl.webfetch.t
    public final void cancel() {
        this.f286853a.cancel();
    }

    public g(Call<TypedInput> r100) {
        this.f286853a = r100;
    }
}
