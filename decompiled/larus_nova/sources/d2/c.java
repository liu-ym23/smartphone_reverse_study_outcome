package d2;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f466496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f466497b;

    public c(String r100, String r101) {
        String r102 = "";
        if (r100 == null) goto L5;
        String r103 = r100.toLowerCase();
    L6:
        this.f466496a = r103;
        if (r101 == null) goto L9;
        r102 = r101.toLowerCase();
    L9:
        this.f466497b = r102;
        return;
    L5:
        r103 = "";
        goto L6
    }
}
