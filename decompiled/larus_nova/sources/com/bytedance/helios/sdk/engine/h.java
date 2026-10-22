package com.bytedance.helios.sdk.engine;

import android.text.TextUtils;
import com.bytedance.helios.sdk.p;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements v97.d<String> {
    public h() {
    }

    @Override // v97.d
    public final String name() {
        return "last_page";
    }

    @Override // v97.d
    public final String getValue() {
        p r100 = p.f245593n;
        if (TextUtils.equals("null", r100.f245597d) == false) goto L6;
        return r100.f245598e;
    L6:
        return r100.f245597d;
    }
}
