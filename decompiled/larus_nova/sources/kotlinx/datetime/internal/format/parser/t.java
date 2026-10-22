package kotlinx.datetime.internal.format.parser;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
public final class t {
    public static /* synthetic */ u b(Integer r100, Integer r101, Integer r102, kotlinx.datetime.internal.format.b r103, String r110) {
        return a(r100, r101, r102, r103, r110, false);
    }

    public static final u c(boolean r100, kotlinx.datetime.internal.format.b r110, String r111, int r112, int r113) {
        if (r113 < ((r100 ? 1 : 0) + 1)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L13;
        List r102 = CollectionsKt.createListBuilder();
        if (r100 == false) goto L10;
        r102.add(new x("-"));
    L10:
        r102.add(new j(CollectionsKt.listOf(new d0(Integer.valueOf(r112 - (r100 ? 1 : 0)), Integer.valueOf(r113 - (r100 ? 1 : 0)), r110, r111, r100))));
        return new u(CollectionsKt.build(r102), CollectionsKt.emptyList());
    L13:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r101 = false;
        goto L6
    }

    public static final u a(Integer r110, Integer r111, Integer r112, kotlinx.datetime.internal.format.b r113, String r210, boolean r211) {
        Intrinsics.checkNotNullParameter(r113, "setter");
        Intrinsics.checkNotNullParameter(r210, "name");
        if (r110 == null) goto L5;
        int r100 = r110.intValue();
    L6:
        int r101 = r100 + (r211 ? 1 : 0);
        if (r111 == null) goto L11;
        int r102 = r111.intValue();
        if (r211 == false) goto L13;
        r102 = r102 + 1;
    L13:
        if (r112 == null) goto L15;
        int r103 = r112.intValue();
    L16:
        int r104 = Math.min(r102, r103);
        if (r101 >= r104) goto L19;
        u r105 = c(r211, r113, r210, r101, r101);
    L22:
        if (r101 >= r104) goto L24;
        r101 = r101 + 1;
        r105 = new u(CollectionsKt.emptyList(), CollectionsKt.listOf(new u[]{c(r211, r113, r210, r101, r101), q.a(CollectionsKt.listOf(new u[]{new u(CollectionsKt.listOf(new x(" ")), CollectionsKt.emptyList()), r105}))}));
        goto L22
    L24:
        if (r103 <= r102) goto L27;
        return q.a(CollectionsKt.listOf(new u[]{new u(CollectionsKt.listOf(new x(StringsKt.repeat(" ", r103 - r102))), CollectionsKt.emptyList()), r105}));
    L27:
        if (r103 != r102) goto L30;
        return r105;
    L30:
        return new u(CollectionsKt.emptyList(), CollectionsKt.listOf(new u[]{c(r211, r113, r210, r103 + 1, r102), r105}));
    L19:
        return c(r211, r113, r210, r101, r102);
    L15:
        r103 = 0;
        goto L16
    L11:
        r102 = Integer.MAX_VALUE;
        goto L13
    L5:
        r100 = 1;
        goto L6
    }
}
