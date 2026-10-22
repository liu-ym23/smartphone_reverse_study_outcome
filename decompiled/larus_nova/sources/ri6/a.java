package ri6;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f537886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f537887b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L10;
        a r101 = (a) r100;
        if (this.f537886a == r101.f537886a) goto L8;
        return false;
    L8:
        if (this.f537887b == r101.f537887b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean r100 = this.f537886a;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (r101 * 31) + this.f537887b;
    }

    public final String toString() {
        return "AudioInfo(isTalking=" + this.f537886a + ", talkVolume=" + this.f537887b + ")";
    }

    public a() {
        this.f537886a = false;
        this.f537887b = 0;
    }
}
