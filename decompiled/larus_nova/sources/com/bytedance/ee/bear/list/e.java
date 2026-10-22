package com.bytedance.ee.bear.list;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public abstract class e<R extends Result<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f227916a;

    public abstract NetService.d<R> m();

    public abstract String n();

    public e() {
        this.f227916a = new CompositeDisposable();
    }

    public static NetService.f j(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        Intrinsics.checkNotNullParameter(r101, "json");
        NetService.f r102 = new NetService.f(r100);
        boolean r103 = true;
        r102.f216906c = 1;
        if (r101.length() > 0) goto L6;
        r103 = false;
    L6:
        if (r103 == false) goto L8;
        r102.f216913j = r101;
    L8:
        return r102;
    }

    public static NetService.f k(String r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "path");
        NetService.f r102 = new NetService.f(r100);
        r102.f216906c = 1;
        if (r101 == null) goto L5;
        r102.d(r101);
    L5:
        return r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [T, io.reactivex.disposables.Disposable] */
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
    public final d l(NetService.f r100, nc5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "callback");
        tt5.a.h(n(), "execute");
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        ?? r103 = m().a(r100).doFinally(new a(r102, this)).subscribe(new b(r101), new c(r101));
        r102.element = r103;
        this.f227916a.add(r103);
        return new d(this, r102);
    }
}
