package kj3;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements com.bytedance.android.ec.core.arch.event.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f503698a;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.f503698a == ((a) r100).f503698a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r100 = this.f503698a;
        if (r100 == false) goto L6;
        return 1;
    L6:
        return r100 ? 1 : 0;
    }

    public final String toString() {
        return "ChunkMergeCompletedEvent(success=" + this.f503698a + ")";
    }

    public a() {
        this.f503698a = true;
    }
}
