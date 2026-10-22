package kotlinx.datetime.internal.format.parser;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class z<Output> implements r<Output> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function2<Output, Boolean, Unit> f505352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f505353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f505354c;

    public final String toString() {
        return this.f505354c;
    }

    public z(kotlinx.datetime.internal.format.u r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "isNegativeSetter");
        Intrinsics.checkNotNullParameter(r102, "whatThisExpects");
        this.f505352a = r100;
        this.f505353b = r101;
        this.f505354c = r102;
    }

    @Override // kotlinx.datetime.internal.format.parser.r
    public final Object a(c r100, CharSequence r101, int r102) {
        Intrinsics.checkNotNullParameter(r101, "input");
        if (r102 < r101.length()) goto L6;
        int r103 = l.f505334a;
        return Integer.valueOf(r102);
    L6:
        final char r104 = r101.charAt(r102);
        if (r104 != '-') goto L11;
        this.f505352a.invoke(r100, Boolean.TRUE);
        int r105 = l.f505334a;
        return Integer.valueOf(r102 + 1);
    L11:
        if (r104 == '+') goto L13;
    L16:
        int r106 = l.f505334a;
        return l.a.a(r102, new y(this, r104));
    L13:
        if (this.f505353b == false) goto L16;
        this.f505352a.invoke(r100, Boolean.FALSE);
        int r107 = l.f505334a;
        return Integer.valueOf(r102 + 1);
    }
}
