package h0c;

import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.passportc.impl.v2.entity.UpdateUserContext;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d<S, E, C, R> implements c<S, E, C, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e<S, E, C, R> f483507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f<C, S, R> f483508c;

    public d(e<S, E, C, R> r100) {
        Intrinsics.checkNotNullParameter(r100, "stateMap");
        this.f483507b = r100;
    }

    @Override // h0c.c
    public final void b(com.ss.android.lark.passportc.impl.v2.d r100) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        this.f483508c = r100;
    }

    @Override // h0c.c
    public final b a(UpdateUserContext r100, UserState r101, UserState r102) {
        f<C, S, R> r103 = this.f483508c;
        if (r103 == null) goto L5;
        r103.d(r100, r101, r102);
    L5:
        ArrayList r104 = new ArrayList();
        e<S, E, C, R> r105 = this.f483507b;
        Iterator r106 = r105.a(r101, r102, r105.f483509a.size()).iterator();
        boolean r107 = true;
    L7:
        if (r106.hasNext() == false) goto L20;
        i0c.d r108 = (i0c.d) r106.next();
        f<C, S, R> r109 = this.f483508c;
        if (r109 == null) goto L11;
        r109.f(r100, r108);
    L11:
        b r110 = r108.a(r100);
        f<C, S, R> r111 = this.f483508c;
        if (r111 == null) goto L14;
        r111.s(r100, r108, r110);
    L14:
        r110.getClass();
        if ((r110 instanceof b.c) == false) goto L16;
        T r112 = r110.f483504a;
        if (r112 == 0) goto L7;
        r104.add(r112);
        goto L7
    L16:
        r107 = false;
        goto L7
    L20:
        if (r107 == false) goto L22;
        int r113 = b.f483503b;
        b r114 = new b.c(r104);
    L23:
        f<C, S, R> r115 = this.f483508c;
        if (r115 == null) goto L26;
        r115.l(r100, r101, r102, r114);
    L26:
        return r114;
    L22:
        int r116 = b.f483503b;
        r114 = new b.C6088b(r104);
        goto L23
    }
}
