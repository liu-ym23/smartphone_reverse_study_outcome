package com.bytedance.android.livesdk.ktvimpl.ktvroom.seat.vm;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.viewbinder.MultiLinkGuestViewBinder;
import com.bytedance.android.live.liveinteract.plantform.model.LinkPlayerInfo;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ KtvRoomViewManager a;

    public e(a r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v4, types: [boolean] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void accept(Object r8) {
        Map r9 = (Map) r8;
        BehaviorSubject<List<tf0.e>> r0 = this.a.k1.b;
        LinkPlayerInfo r3 = null;
        if (r0 == null) goto L23;
        List r1 = (List) r0.getValue();
        if (r1 == null) goto L23;
        Iterator<T> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L21;
        T r4 = r2.next();
        MultiLinkGuestViewBinder.a r5 = (tf0.e) r4;
        if ((r5 instanceof MultiLinkGuestViewBinder.a) == false) goto L18;
        IBaseUser r6 = r5.k.a.getUser();
        if (r6 == null) goto L14;
        String r7 = r6.getIdString();
    L16:
        if (Intrinsics.areEqual(r7, this.a.d.toString()) == false) goto L18;
        boolean r10 = true;
    L19:
        if (r10 == false) goto L8;
    L22:
        tf0.e r11 = (tf0.e) r4;
    L25:
        if ((r11 instanceof MultiLinkGuestViewBinder.a) == true) goto L27;
        r11 = null;
    L27:
        MultiLinkGuestViewBinder.a r12 = (MultiLinkGuestViewBinder.a) r11;
        if (r12 == null) goto L53;
        ?? r13 = Intrinsics.areEqual((Boolean) r9.get(r12.k.a.getInteractId()), Boolean.TRUE);
        if ((!Intrinsics.areEqual(Boolean.valueOf(r13), this.a.R)) == false) goto L54;
        this.a.R = Boolean.valueOf(r13);
        KtvRoomViewManager r14 = this.a;
        r14.getClass();
        if (r12.k.a.getSilenceStatus() == 0) goto L34;
        r14.I();
    L40:
        LinkPlayerInfo r15 = r12.k.a;
        if ((r15 instanceof LinkPlayerInfo) == false) goto L44;
        r3 = r15;
    L44:
        LinkPlayerInfo r16 = r3;
        if (r16 == null) goto L55;
        this.a.F(r16, r13);
        return;
    L55:
        return;
    L34:
        if (r13 <= 0) goto L39;
        HSImageView r17 = r14.o;
        if (r17 == null) goto L38;
        r17.setVisibility(0);
    L38:
        r14.H(r12, r13 == true ? 1 : 0);
        goto L40
    L39:
        r14.B(r12);
        goto L40
    L54:
        return;
    L53:
        return;
    L14:
        r7 = null;
    L18:
        r10 = false;
        goto L19
    L21:
        r4 = null;
    L23:
        r11 = null;
        goto L25
    }
}
