package com.bytedance.ee.bear.share.newshare;

import android.content.Context;
import android.view.View;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.view.ShareNewFragment;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f237244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ShareParams f237245b;

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
        c0 r100 = this.f237244a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f();
    }

    public final Context getContext() {
        c0 r100 = this.f237244a;
        if (r100 == null) goto L9;
        b r101 = r100.f();
        if (r101 == null) goto L9;
        ShareNewFragment r102 = r101.getHostFragment();
        if (r102 == null) goto L9;
        return r102.getContext();
    L9:
        return null;
    }

    public z() {
    }

    public final <T extends com.bytedance.ee.bear.share.export.f> T d(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        c0 r101 = this.f237244a;
        if (r101 == null) goto L9;
        Intrinsics.checkNotNullParameter(r100, "clz");
        T r102 = (T) r101.f237202g;
        if (r102 == null) goto L9;
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L9;
        return r102;
    L9:
        return null;
    }

    public void f(c0 r100, ShareParams r101) {
        Intrinsics.checkNotNullParameter(r100, "shareProvider");
        Intrinsics.checkNotNullParameter(r101, "shareParams");
        this.f237244a = r100;
        this.f237245b = r101;
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
    public static e0 g(z r100, b0 r101, a0.a r110, List r111, List r112, View.OnClickListener r113, View r114, int r115) {
        a0 r116 = r110;
        if ((r115 & 2) == 0) goto L5;
        r116 = new a0.b(0);
    L5:
        a0 r102 = r116;
        if ((r115 & 4) == 0) goto L8;
        List r103 = null;
    L10:
        if ((r115 & 8) == 0) goto L12;
        List r104 = null;
    L14:
        if ((r115 & 16) == 0) goto L16;
        View.OnClickListener r105 = null;
    L18:
        if ((r115 & 32) == 0) goto L20;
        r114 = null;
    L20:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "style");
        c0 r117 = r100.f237244a;
        if (r117 == null) goto L29;
        f0 r106 = r117.f237197b;
        if (r106 == 0) goto L30;
        if (r114 != null) goto L26;
        View r107 = r100.e();
    L28:
        return r106.a(r101, r102, r103, r104, r105, r107);
    L26:
        r107 = r114;
        goto L28
    L30:
        return null;
    L29:
        return null;
    L16:
        r105 = r113;
        goto L18
    L12:
        r104 = r112;
        goto L14
    L8:
        r103 = r111;
        goto L10
    }
}
