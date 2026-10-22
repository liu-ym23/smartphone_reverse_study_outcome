package kotlinx.datetime.internal.format.parser;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes42.dex */
public final class d0<Receiver> extends e<Receiver> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f505311c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f505312d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<Receiver, Integer> f505313e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f505314f;

    @Override // kotlinx.datetime.internal.format.parser.e
    public final f a(c r100, CharSequence r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r101, "input");
        Integer r104 = this.f505312d;
        if (r104 != null) goto L5;
    L7:
        Integer r105 = this.f505311c;
        if (r105 != null) goto L10;
    L12:
        int r106 = 0;
    L14:
        if (r102 >= r103) goto L19;
        r106 = (r106 * 10) + (r101.charAt(r102) - '0');
        if (r106 < 0) goto L17;
        r102 = r102 + 1;
        goto L14
    L17:
        Integer r107 = null;
    L20:
        if (r107 == null) goto L34;
        a<Receiver, Integer> r108 = this.f505313e;
        boolean r109 = this.f505314f;
        int r110 = r107.intValue();
        if (r109 == false) goto L25;
        r110 = -r110;
    L25:
        Integer r111 = r108.c(r100, Integer.valueOf(r110));
        if (r111 != null) goto L29;
        return null;
    L29:
        return new f.a(r111);
    L34:
        return f.b.f505318a;
    L19:
        r107 = Integer.valueOf(r106);
        goto L20
    L10:
        if ((r103 - r102) >= r105.intValue()) goto L12;
        return new f.c(this.f505311c.intValue());
    L5:
        if ((r103 - r102) <= r104.intValue()) goto L7;
        return new f.d(this.f505312d.intValue());
    }

    public d0(Integer r100, Integer r101, kotlinx.datetime.internal.format.b r102, String r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r102, "setter");
        Intrinsics.checkNotNullParameter(r103, "name");
        if (Intrinsics.areEqual(r100, r101) == false) goto L5;
        Integer r105 = r100;
    L6:
        super(r105, r103);
        this.f505311c = r100;
        this.f505312d = r101;
        this.f505313e = r102;
        this.f505314f = r104;
        boolean r106 = true;
        if (r105 != null) goto L9;
    L12:
        if (r106 == false) goto L15;
        return;
    L15:
        throw new IllegalArgumentException(("Invalid length for field " + r103 + ": " + r105).toString());
    L9:
        if (new IntRange(1, 9).contains(r105.intValue()) == true) goto L12;
        r106 = false;
        goto L12
    L5:
        r105 = null;
        goto L6
    }
}
