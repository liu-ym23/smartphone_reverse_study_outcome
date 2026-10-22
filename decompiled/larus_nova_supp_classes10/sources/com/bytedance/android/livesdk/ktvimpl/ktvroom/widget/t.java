package com.bytedance.android.livesdk.ktvimpl.ktvroom.widget;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t<T> implements Consumer {
    public final /* synthetic */ u a;

    public t(u r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if (((Boolean) r2).booleanValue() == false) goto L6;
        this.a.a.yq("onValueChanged");
        return;
    }
}
