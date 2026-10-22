package com.bytedance.forest.utils.io;

import com.bytedance.forest.model.Response;
import com.bytedance.forest.model.l;

/* JADX INFO: loaded from: classes19.dex */
public final class e extends b {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.forest.utils.io.b, java.io.InputStream
    public final int available() {
        return Math.max(super.available(), 2);
    }

    public e(l r100, Response r101) {
        super(r100, r101);
    }
}
