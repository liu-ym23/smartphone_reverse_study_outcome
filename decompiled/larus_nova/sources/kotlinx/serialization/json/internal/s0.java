package kotlinx.serialization.json.internal;

import com.ss.android.cert.manager.constants.EventConstant;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes5.dex */
public final class s0 {
    public static final luc.f a(luc.f r100, kotlinx.serialization.modules.d r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, EventConstant.Key.MODULE);
        if (Intrinsics.areEqual(r100.getKind(), luc.o.a.f510875a) == false) goto L16;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        KClass<?> r102 = luc.b.a(r100);
        if (r102 == null) goto L9;
        juc.d r103 = kotlinx.serialization.modules.d.c(r101, r102);
        if (r103 == null) goto L9;
        luc.f r104 = r103.getDescriptor();
    L10:
        if (r104 == null) goto L19;
        luc.f r105 = a(r104, r101);
        if (r105 != null) goto L20;
        return r100;
    L20:
        return r105;
    L19:
        return r100;
    L9:
        r104 = null;
        goto L10
    L16:
        if (r100.isInline() == true) goto L18;
        return r100;
    L18:
        return a(r100.h(0), r101);
    }

    public static final WriteMode b(ouc.a r100, luc.f r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SocialConstants.PARAM_APP_DESC);
        luc.o r102 = r101.getKind();
        if ((r102 instanceof luc.d) == false) goto L6;
        return WriteMode.POLY_OBJ;
    L6:
        if (Intrinsics.areEqual(r102, luc.p.b.f510878a) == false) goto L9;
        return WriteMode.LIST;
    L9:
        if (Intrinsics.areEqual(r102, luc.p.c.f510879a) == false) goto L22;
        luc.f r103 = a(r101.h(0), r100.f526800b);
        luc.o r104 = r103.getKind();
        if ((r104 instanceof luc.e) == true) goto L26;
        if (Intrinsics.areEqual(r104, luc.o.b.f510876a) == true) goto L26;
        if (r100.f526799a.f526835d == false) goto L19;
        return WriteMode.LIST;
    L19:
        throw s.b(r103);
    L26:
        return WriteMode.MAP;
    L22:
        return WriteMode.OBJ;
    }
}
