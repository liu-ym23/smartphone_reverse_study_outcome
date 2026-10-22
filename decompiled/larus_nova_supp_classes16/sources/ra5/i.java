package ra5;

import com.bytedance.ee.bear.basesdk.apisupport.m;
import com.bytedance.ee.bear.contract.u;
import com.bytedance.ee.bear.contract.y;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.lark.aidl.IReminderImpl;
import com.bytedance.ee.bear.list.u0;
import com.bytedance.ee.bear.middleground.permission.PermissionDIModuleKt;
import com.bytedance.ee.bear.parcel.BinderParcel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements m {
    public final b a;

    public final void a() {
        b r0 = this.a;
        r0.getClass();
        IReminderImpl r2 = new IReminderImpl();
        DocCallbackImpl r3 = new DocCallbackImpl();
        Boolean r4 = Boolean.valueOf(((com.bytedance.ee.bear.lark.dependency.d) org.koin.java.a.a(com.bytedance.ee.bear.lark.dependency.d.class)).a());
        zw4.a r5 = (zw4.a) org.koin.java.a.a(zw4.a.class);
        ya5.c r6 = (ya5.c) org.koin.java.a.a(ya5.c.class);
        cx4.a r7 = (cx4.a) org.koin.java.a.a(cx4.a.class);
        com.bytedance.ee.bear.contract.g.a r8 = (com.bytedance.ee.bear.contract.g.a) org.koin.java.a.a(com.bytedance.ee.bear.contract.g.a.class);
        lj5.a r9 = (lj5.a) org.koin.java.a.a(lj5.a.class);
        xm4.a.a r10 = (xm4.a.a) org.koin.java.a.a(xm4.a.a.class);
        yj5.a r11 = (yj5.a) org.koin.java.a.a(yj5.a.class);
        yn4.a.a r12 = (yn4.a.a) org.koin.java.a.a(yn4.a.a.class);
        ao4.f r13 = (ao4.f) org.koin.java.a.a(ao4.f.class);
        ao4.e r14 = (ao4.e) org.koin.java.a.a(ao4.e.class);
        u0 r16 = (u0) org.koin.java.a.a(u0.class);
        og5.a r17 = (og5.a) org.koin.java.a.a(og5.a.class);
        com.bytedance.ee.bear.middleground.permission.audit.e r18 = (com.bytedance.ee.bear.middleground.permission.audit.e) org.koin.java.a.a(com.bytedance.ee.bear.middleground.permission.audit.e.class);
        ao4.h.a = new BinderParcel(r2);
        if (r4 == null) goto L5;
        boolean r19 = true;
    L6:
        if (r19 == false) goto L8;
        boolean r20 = r4.booleanValue();
        tt5.a.h("DepImpl", "setIsAppInBackground()... process  = " + eu5.g.c() + ",  isAppFront = " + r20);
        u.a.postValue(Boolean.valueOf(r20));
    L8:
        if (r5 == null) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L13;
        com.bytedance.ee.bear.docshost.m.a = r5;
    L13:
        if (r8 == null) goto L15;
        boolean r21 = true;
    L16:
        if (r21 == true) goto L18;
    L20:
        if (r6 == null) goto L22;
        boolean r22 = true;
    L23:
        if (r22 == true) goto L25;
    L37:
        if (r12 == null) goto L39;
        boolean r23 = true;
    L40:
        if (r23 == false) goto L42;
        yn4.a.a = r12;
        boolean r24 = true;
        yn4.a.b = true;
    L43:
        r0.a(r3);
        if (r9 == null) goto L46;
        boolean r26 = true;
    L47:
        if (r26 == false) goto L49;
        y.b = r9;
    L49:
        if (r11 == null) goto L51;
        boolean r27 = true;
    L52:
        if (r27 == false) goto L54;
        y.c = r11;
    L54:
        if (r7 == null) goto L56;
        boolean r28 = true;
    L57:
        if (r28 == false) goto L59;
        yn4.b.h = r7;
    L59:
        if (r13 == null) goto L61;
        boolean r29 = true;
    L62:
        if (r29 == false) goto L64;
        ao4.i.b.a.a = r13;
    L64:
        if (r14 == null) goto L66;
        boolean r30 = true;
    L67:
        if (r30 == false) goto L69;
        ao4.g.b.a.a = r14;
    L69:
        if (r16 == null) goto L71;
        boolean r31 = true;
    L72:
        if (r31 == false) goto L74;
        ((rc5.a) org.koin.java.a.a(rc5.a.class)).p(r16);
    L74:
        if (r17 != null) goto L77;
        r24 = false;
    L77:
        if (r24 == false) goto L82;
        PermissionDIModuleKt.b = r17;
        return;
    L82:
        return;
    L71:
        r31 = false;
        goto L72
    L66:
        r30 = false;
        goto L67
    L61:
        r29 = false;
        goto L62
    L56:
        r28 = false;
        goto L57
    L51:
        r27 = false;
        goto L52
    L46:
        r26 = false;
        goto L47
    L42:
        r24 = true;
        goto L43
    L39:
        r23 = false;
        goto L40
    L25:
        if (ya5.a.b == null) goto L27;
    L36:
        ya5.a r32 = ya5.a.b;
        r32.getClass();
        tt5.a.h("FeatureSwitch", "init, agent=" + r6);
        r32.a = r6;
        goto L37
    L27:
        monitor-enter(ya5.a.class);
    L33:
        th = move-exception;
        throw th;
    L29:
        if (ya5.a.b != null) goto L31;
        ya5.a.b = new ya5.a();     // Catch: Throwable -> L33
    L31:
        monitor-exit(ya5.a.class);     // Catch: Throwable -> L33
        goto L36
    L22:
        r22 = false;
        goto L23
    L18:
        if (eu5.g.j() == false) goto L20;
        com.bytedance.ee.bear.contract.h.a = r8;
        goto L20
    L15:
        r21 = false;
        goto L16
    L10:
        r1 = false;
        goto L11
    L5:
        r19 = false;
        goto L6
    }

    public i() {
        this.a = new b();
    }
}
