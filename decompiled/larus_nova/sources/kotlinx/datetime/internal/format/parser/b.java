package kotlinx.datetime.internal.format.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class b<Receiver> extends e<Receiver> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f505301c;

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "expected");
        super(Integer.valueOf(r100.length()), "the predefined string ".concat(r100));
        this.f505301c = r100;
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public final f a(c r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "input");
        if (Intrinsics.areEqual(r101.subSequence(r102, r103).toString(), this.f505301c) == false) goto L6;
        return null;
    L6:
        return new f.e(this.f505301c);
    }
}
