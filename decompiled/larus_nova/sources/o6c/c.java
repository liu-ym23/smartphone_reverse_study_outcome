package o6c;

import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f522230c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f522231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StringBuilder f522232b;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return this.f522232b.toString();
    }

    public c(String r100) {
        this.f522231a = r100;
        this.f522232b = new StringBuilder();
    }

    public final void a(CharSequence r100, boolean r101) {
        if (r100 == null) goto L22;
        boolean r102 = true;
        if (r100.length() != 0) goto L6;
        boolean r103 = true;
    L7:
        if (r103 == false) goto L11;
        if (r101 == true) goto L11;
        return;
    L11:
        if (this.f522232b.length() > 0) goto L14;
        r102 = false;
    L14:
        if (r102 == true) goto L16;
    L20:
        this.f522232b.append(r100);
        return;
    L16:
        if (StringsKt.endsWith$default(this.f522232b, this.f522231a, false, 2, null) == true) goto L20;
        if (StringsKt.startsWith$default(r100, this.f522231a, false, 2, null) == true) goto L20;
        this.f522232b.append(this.f522231a);
        goto L20
    L6:
        r103 = false;
        goto L7
    }
}
