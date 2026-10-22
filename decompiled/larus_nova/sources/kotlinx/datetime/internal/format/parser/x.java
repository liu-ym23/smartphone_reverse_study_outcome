package kotlinx.datetime.internal.format.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class x<Output> implements r<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f505349a;

    public final String toString() {
        return "'" + this.f505349a + '\'';
    }

    public x(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        this.f505349a = r100;
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L17;
        if ((!guc.d.a(r100.charAt(0))) == false) goto L15;
        if ((!guc.d.a(r100.charAt(r100.length() - 1))) == false) goto L13;
        return;
    L13:
        throw new IllegalArgumentException(("String '" + r100 + "' ends with a digit").toString());
    L15:
        throw new IllegalArgumentException(("String '" + r100 + "' starts with a digit").toString());
    L17:
        throw new IllegalArgumentException("Empty string is not allowed".toString());
    L5:
        r101 = false;
        goto L6
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public final Object a(c r100, final CharSequence r101, final int r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        if ((this.f505349a.length() + r102) <= r101.length()) goto L6;
        int r103 = l.f505334a;
        return l.a.a(r102, new v(this));
    L6:
        int r104 = this.f505349a.length();
        final int r105 = 0;
    L7:
        if (r105 >= r104) goto L13;
        if (r101.charAt(r102 + r105) != this.f505349a.charAt(r105)) goto L10;
        r105 = r105 + 1;
        goto L7
    L10:
        int r106 = l.f505334a;
        return l.a.a(r102, new w(this, r101, r102, r105));
    L13:
        int r107 = l.f505334a;
        return Integer.valueOf(r102 + this.f505349a.length());
    }
}
