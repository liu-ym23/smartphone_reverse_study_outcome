package com.bytedance.android.livesdk.livecommerce.messagev2.interceptor;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class w implements Observer {
    public final /* synthetic */ File a;

    public w(File r1) {
        this.a = r1;
    }

    @Override // java.util.Observer
    public final void update(Observable r1, Object r2) {
        this.a.delete();
    }
}
