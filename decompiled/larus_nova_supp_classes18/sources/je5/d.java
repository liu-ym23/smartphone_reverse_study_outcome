package je5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends c66.a {
    public final String b;

    public d() {
        this.b = "ccm.log";
    }

    public String getName() {
        return this.b;
    }

    public String e(String r3) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        return "ccm-lynx: " + r3;
    }
}
