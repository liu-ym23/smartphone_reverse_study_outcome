package pp1;

/* JADX INFO: loaded from: classes8.dex */
public final class g extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f530187a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof g) == true) goto L6;
        return false;
    L6:
        if (this.f530187a == ((g) r100).f530187a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f530187a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "MoveButtonCommand(fold=" + this.f530187a + ")";
    }

    public g(boolean r100) {
        this.f530187a = r100;
    }
}
