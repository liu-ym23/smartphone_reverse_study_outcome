package s05;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d {
    public final ConcurrentHashMap<String, qz4.a> a;
    public final ConcurrentHashMap<String, qz4.b> b;

    public static final class a {
    }

    static {
    }

    public d() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
    }

    public final qz4.b a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "command");
        Intrinsics.checkNotNullParameter(r4, "module");
        tt5.a.h("DComponent_CallbackMapper", "getEventHandler() called with: command = " + r3 + ", module = " + r4);
        return this.b.get(r3 + '_' + r4);
    }
}
