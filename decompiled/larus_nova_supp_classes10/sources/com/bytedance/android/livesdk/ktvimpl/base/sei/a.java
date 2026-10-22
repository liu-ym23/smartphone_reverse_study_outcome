package com.bytedance.android.livesdk.ktvimpl.base.sei;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a {
    public a() {
    }

    public final String a() {
        if ((this instanceof k) == false) goto L7;
        return ((k) this).A();
    L7:
        if ((this instanceof i) == false) goto L11;
        return ((i) this).h();
    L11:
        if ((this instanceof h) == true) goto L13;
        return null;
    L13:
        return ((h) this).h();
    }
}
