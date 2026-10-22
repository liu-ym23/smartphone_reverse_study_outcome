package com.bytedance.ee.bear.more.protocol3.panel;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements q {
    public final String a;
    public final boolean b;
    public final boolean c;
    public final Function0<Boolean> d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.protocol3.panel.a$a, reason: collision with other inner class name */
    public static final class C0121a {
    }

    static {
    }

    public final String toString() {
        return this.a + " -> " + super.toString();
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final i a(x r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r5 = ((Boolean) this.d.invoke()).booleanValue();     // Catch: Throwable -> L5
    L7:
        if (r5 == false) goto L9;
        tt5.a.h("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction success, itemId=" + this.a);
        return i.a.a;
    L9:
        tt5.a.h("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction not handled, itemId=" + this.a);
        return i.b.a;
    L5:
        th = move-exception;
        tt5.a.e("BaselineClickDelegate", "BaselineClickDelegate.onClick: clickAction error, itemId=" + this.a, th, false);
        r5 = false;
        goto L7
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean b(x r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.b;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.panel.q
    public final boolean c(x r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return this.c;
    }

    public a(String r2, boolean r3, boolean r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r5, "clickAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
