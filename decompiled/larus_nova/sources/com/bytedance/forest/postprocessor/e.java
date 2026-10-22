package com.bytedance.forest.postprocessor;

import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;

/* JADX INFO: loaded from: classes3.dex */
public final class e<T> extends RequestParams {
    public final ForestPostProcessor<T> O;

    public e() {
        throw null;
    }

    public e(RequestParams r100, ForestPostProcessor r101) {
        super(r100, r100.f244296z);
        this.O = r101;
    }

    public e(ForestPostProcessor<T> r100, Scene r101) {
        super(r101);
        this.O = r100;
    }
}
