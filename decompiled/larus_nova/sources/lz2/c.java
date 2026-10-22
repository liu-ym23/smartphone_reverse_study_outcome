package lz2;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes12.dex */
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f511354e;

    @Override // lz2.a
    public final Regex c() {
        if (this.f511343b == null) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == true) goto L8;
        Regex r101 = new Regex(this.f511354e);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f511343b = r101;
    L8:
        Regex r102 = this.f511343b;
        if (r102 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("_regex");
        return null;
    L13:
        return r102;
    L5:
        r100 = false;
        goto L6
    }

    @Override // lz2.a
    public final String toString() {
        return this.f511342a + ": [" + this.f511354e + ']';
    }

    @Override // lz2.a
    public final int a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        if ((r100 instanceof c) == false) goto L5;
        int r101 = ((c) r100).f511354e.length();
        int r102 = this.f511354e.length();
    L7:
        return r101 - r102;
    L5:
        r101 = r100.b().getPattern().length();
        r102 = b().getPattern().length();
        goto L7
    }

    @Override // lz2.a, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(a r100) {
        return a(r100);
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        Intrinsics.checkNotNullParameter(r101, "regStr");
        super(r100, null);
        this.f511354e = r101;
    }
}
