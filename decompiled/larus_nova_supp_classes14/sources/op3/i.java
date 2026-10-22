package op3;

import android.view.View;
import com.bytedance.android.window.shop.repository.tab.entity.WindowLayoutType;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends QPresenter {
    public final b<com.bytedance.android.window.shop.repository.tab.entity.l> e;
    public View f;
    public List<c<com.bytedance.android.window.shop.repository.tab.entity.l>> g;
    public final WindowLayoutType h;

    public i(WindowLayoutType r2) {
        this.h = r2;
        this.e = new b(new h());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void A(QModel r11) {
        WindowLayoutType r0 = this.h;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isDoubleColumn() != true) goto L81;
        b<com.bytedance.android.window.shop.repository.tab.entity.l> r1 = this.e;
        View r2 = y();
        List<c<com.bytedance.android.window.shop.repository.tab.entity.l>> r3 = this.g;
        int r4 = 0;
        if (r3 != null) goto L10;
    L12:
        d r5 = g.a;
        c[] r6 = new c[7];
        View r7 = r2.findViewById(2131371328);
        if (r7 == null) goto L15;
        c r8 = new c(g.c, new a(r7));
    L16:
        r6[0] = r8;
        View r9 = r2.findViewById(2131393297);
        if (r9 == null) goto L19;
        c r10 = new c(g.d, new l(r9));
    L20:
        r6[1] = r10;
        View r12 = r2.findViewById(2131387398);
        if (r12 == null) goto L23;
        c r13 = new c(g.e, new m(r12));
    L24:
        r6[2] = r13;
        View r14 = r2.findViewById(2131387407);
        if (r14 == null) goto L27;
        c r15 = new c(g.f, new o(r14));
    L28:
        r6[3] = r15;
        View r16 = r2.findViewById(2131387384);
        if (r16 == null) goto L31;
        c r17 = new c(g.g, new n(r16));
    L32:
        r6[4] = r17;
        View r18 = r2.findViewById(2131387397);
        if (r18 == null) goto L35;
        c r19 = new c(g.h, new a(r18));
    L36:
        r6[5] = r19;
        View r20 = r2.findViewById(2131371322);
        if (r20 == null) goto L39;
        c r21 = new c(g.i, new k(r20));
    L40:
        r6[6] = r21;
        r3 = CollectionsKt.listOfNotNull(r6);
        this.f = r2;
        this.g = r3;
    L42:
        if ((r11 instanceof com.bytedance.android.window.shop.repository.tab.entity.l) == true) goto L44;
        r11 = null;
    L44:
        com.bytedance.android.window.shop.repository.tab.entity.l r110 = (com.bytedance.android.window.shop.repository.tab.entity.l) r11;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r3, "modulesInOrder");
        List<c<com.bytedance.android.window.shop.repository.tab.entity.l>> r22 = r3;
        Iterator<T> r23 = r22.iterator();
    L46:
        if (r23.hasNext() == false) goto L48;
        c r24 = (c) r23.next();
        r24.b.a(0);
        r24.b.b(0);
        goto L46
    L48:
        ArrayList r25 = new ArrayList();
        Iterator<T> r26 = r22.iterator();
    L50:
        if (r26.hasNext() == false) goto L54;
        Object r27 = r26.next();
        if (((c) r27).b.c(r110) == false) goto L50;
        r25.add(r27);
        goto L50
    L54:
        Iterator r111 = r25.iterator();
    L56:
        if (r111.hasNext() == false) goto L66;
        Object r28 = r111.next();
        int r29 = r4 + 1;
        if (r4 >= 0) goto L60;
        CollectionsKt.throwIndexOverflow();
    L60:
        c r30 = (c) r28;
        c r31 = (c) CollectionsKt.getOrNull(r25, r4 - 1);
        if (r31 == null) goto L64;
        d r32 = r31.a;
        if (r32 == null) goto L64;
    L65:
        int r33 = r1.a.a(r32, r30.a);
        f<M> r34 = r30.b;
        r34.a(r34.d(r33));
        r4 = r29;
    L64:
        r32 = g.a;
        goto L65
    L66:
        c r112 = (c) CollectionsKt.lastOrNull(r25);
        if (r112 == null) goto L80;
        f<M> r35 = r112.b;
        r35.b(r35.d(r1.a.a(r112.a, g.b)));
        return;
    L80:
        return;
    L39:
        r21 = null;
        goto L40
    L35:
        r19 = null;
        goto L36
    L31:
        r17 = null;
        goto L32
    L27:
        r15 = null;
        goto L28
    L23:
        r13 = null;
        goto L24
    L19:
        r10 = null;
        goto L20
    L15:
        r8 = null;
        goto L16
    L10:
        if (this.f != r2) goto L12;
    }
}
