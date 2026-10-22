package kotlinx.datetime.internal.format.parser;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
public final class d<Receiver> extends e<Receiver> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f505308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f505309d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<Receiver, guc.a> f505310e;

    public d(int r100, int r101, kotlinx.datetime.internal.format.b r102, String r103) {
        Intrinsics.checkNotNullParameter(r102, "setter");
        Intrinsics.checkNotNullParameter(r103, "name");
        if (r100 != r101) goto L5;
        Integer r104 = Integer.valueOf(r100);
    L6:
        super(r104, r103);
        this.f505308c = r100;
        this.f505309d = r101;
        this.f505310e = r102;
        boolean r105 = false;
        if (1 > r100) goto L10;
        if (r100 >= 10) goto L10;
        boolean r106 = true;
    L12:
        if (r106 == false) goto L21;
        if (r100 > r101) goto L16;
        if (r101 >= 10) goto L16;
        r105 = true;
    L16:
        if (r105 == false) goto L19;
        return;
    L19:
        throw new IllegalArgumentException(("Invalid maximum length " + r101 + " for field " + r103 + ": expected " + r100 + "..9").toString());
    L21:
        throw new IllegalArgumentException(("Invalid minimum length " + r100 + " for field " + r103 + ": expected 1..9").toString());
    L10:
        r106 = false;
        goto L12
    L5:
        r104 = null;
        goto L6
    }

    @Override // kotlinx.datetime.internal.format.parser.e
    public final f a(c r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "input");
        int r104 = r103 - r102;
        int r105 = this.f505308c;
        if (r104 < r105) goto L17;
        int r106 = this.f505309d;
        if (r104 > r106) goto L18;
        a<Receiver, guc.a> r107 = this.f505310e;
        int r108 = 0;
    L9:
        if (r102 >= r103) goto L11;
        r108 = (r108 * 10) + (r101.charAt(r102) - '0');
        r102 = r102 + 1;
        goto L9
    L11:
        guc.a r109 = r107.c(r100, new guc.a(r108, r104));
        if (r109 != null) goto L15;
        return null;
    L15:
        return new f.a(r109);
    L18:
        return new f.d(r106);
    L17:
        return new f.c(r105);
    }
}
