package pp1;

/* JADX INFO: loaded from: classes8.dex */
public final class f extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530186a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof f) == true) goto L6;
        return false;
    L6:
        if (this.f530186a == ((f) r100).f530186a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.f530186a;
    }

    public final String toString() {
        return "LandscapeVisibilityCommand(visibility=" + this.f530186a + ")";
    }

    public f(int r100) {
        this.f530186a = r100;
    }
}
