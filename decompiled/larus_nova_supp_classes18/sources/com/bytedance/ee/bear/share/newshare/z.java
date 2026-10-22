package com.bytedance.ee.bear.share.newshare;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class z {
    public c0 a;
    public ShareParams b;

    public abstract e0 a();

    public ShareItemList b() {
        return null;
    }

    public abstract View e();

    public void h() {
    }

    public void i() {
    }

    public final b c() {
        c0 r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.f();
    }

    public final Context getContext() {
        c0 r0 = this.a;
        if (r0 == null) goto L9;
        b r1 = r0.f();
        if (r1 == null) goto L9;
        ShareNewFragment r2 = r1.getHostFragment();
        if (r2 == null) goto L9;
        return r2.getContext();
    L9:
        return null;
    }

    public z() {
    }

    public final <T extends com.bytedance.ee.bear.share.export.f> T d(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "clz");
        c0 r1 = this.a;
        if (r1 == null) goto L9;
        Intrinsics.checkNotNullParameter(r3, "clz");
        T r0 = (T) r1.g;
        if (r0 == null) goto L9;
        if (r3.isAssignableFrom(r0.getClass()) == false) goto L9;
        return r0;
    L9:
        return null;
    }

    public void f(c0 r2, ShareParams r3) {
        Intrinsics.checkNotNullParameter(r2, "shareProvider");
        Intrinsics.checkNotNullParameter(r3, "shareParams");
        this.a = r2;
        this.b = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    public static e0 g(z r8, b0 r9, a0.a r10, List r11, List r12, View.OnClickListener r13, View r14, int r15) {
        a0 r16 = r10;
        if ((r15 & 2) == 0) goto L5;
        r16 = new a0.b(0);
    L5:
        a0 r3 = r16;
        if ((r15 & 4) == 0) goto L8;
        List r4 = null;
    L10:
        if ((r15 & 8) == 0) goto L12;
        List r5 = null;
    L14:
        if ((r15 & 16) == 0) goto L16;
        View.OnClickListener r6 = null;
    L18:
        if ((r15 & 32) == 0) goto L20;
        r14 = null;
    L20:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r3, "style");
        c0 r17 = r8.a;
        if (r17 == null) goto L29;
        f0 r1 = r17.b;
        if (r1 == 0) goto L30;
        if (r14 != null) goto L26;
        View r7 = r8.e();
    L28:
        return r1.a(r9, r3, r4, r5, r6, r7);
    L26:
        r7 = r14;
        goto L28
    L30:
        return null;
    L29:
        return null;
    L16:
        r6 = r13;
        goto L18
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = r11;
        goto L10
    }
}
