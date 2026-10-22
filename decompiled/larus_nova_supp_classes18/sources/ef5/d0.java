package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements gf5.c {
    public final String a;

    public final String toString() {
        return "ReactionMenuClickEvent(menuId='" + this.a + "')";
    }

    public d0(String r2) {
        Intrinsics.checkNotNullParameter(r2, "menuId");
        this.a = r2;
    }
}
