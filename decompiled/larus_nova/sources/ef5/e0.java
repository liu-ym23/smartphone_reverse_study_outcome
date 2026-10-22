package ef5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e0 implements gf5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f472455a;

    public final String toString() {
        return "ReactionShowedEvent(replyId='" + this.f472455a + "')";
    }

    public e0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "replyId");
        this.f472455a = r100;
    }
}
