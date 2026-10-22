package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d0 implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472452a;

    public final String toString() {
        return "ReactionMenuClickEvent(menuId='" + this.f472452a + "')";
    }

    public d0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "menuId");
        this.f472452a = r100;
    }
}
