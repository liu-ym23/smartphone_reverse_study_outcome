package dh3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public boolean a;
    public String b;

    /* JADX INFO: renamed from: dh3.a$a, reason: collision with other inner class name */
    public static final class C0191a {
    }

    static {
    }

    public final void buildParams() {
        if (this.a == false) goto L5;
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        appendParam("module_label", "guess_you_like_product", com.bytedance.android.ec.core.event.a.b.a.a);
    L5:
        appendParam("show_position", String.valueOf(this.b));
    }

    public a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        super(r2);
    }
}
