package com.bytedance.locallife.dito.helper;

import com.bytedance.locallife.dito.model.BaseDitoModel;

/* JADX INFO: loaded from: classes21.dex */
public final class f {

    public static final class a {
    }

    static {
    }

    public f() {
    }

    public static void a(BaseDitoModel r100, int r101, int r102, int r103, int r104, int r105, int r106) {
        if (r100 == null) goto L5;
        r100.i("top", Integer.valueOf(r101));
        r100.i("bottom", Integer.valueOf(r102));
        r100.i("height", Integer.valueOf(r102 - r101));
        r100.i("padding_top", Integer.valueOf(r103));
        r100.i("padding_bottom", Integer.valueOf(r104));
        r100.i("margin_top", Integer.valueOf(r105));
        r100.i("margin_bottom", Integer.valueOf(r106));
        return;
    }
}
