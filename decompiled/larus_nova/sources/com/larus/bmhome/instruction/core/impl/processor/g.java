package com.larus.bmhome.instruction.core.impl.processor;

import com.larus.im.internal.delegate.c0;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import xp8.i;

/* JADX INFO: loaded from: classes4.dex */
public final class g extends i<aq8.c.g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass<aq8.c.g> f312040b;

    public static final class a {
    }

    static {
    }

    public g() {
        this.f312040b = Reflection.getOrCreateKotlinClass(aq8.c.g.class);
    }

    @Override // xp8.i
    public final aq8.f a(aq8.c r100) {
        aq8.c.g r101 = (aq8.c.g) r100;
        Intrinsics.checkNotNullParameter(r101, "intent");
        Iterator<T> r102 = getContext().a(r101.f15936b).values().iterator();
        boolean r103 = true;
    L4:
        if (r102.hasNext() == false) goto L9;
        com.larus.bmhome.instruction.core.impl.base.e r104 = (com.larus.bmhome.instruction.core.impl.base.e) r102.next();
        boolean r105 = r104.a();
        if (r105 == true) goto L8;
        c0.f348199b.i("ValidateFormProcessor", "[process] invalid controller type=" + r104.getType());
    L8:
        r103 = r103 & r105;
        goto L4
    L9:
        c0.f348199b.i("ValidateFormProcessor", "[process] legality=" + r103);
        return new aq8.f.c(Boolean.valueOf(r103));
    }
}
