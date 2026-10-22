package com.larksuite.framework.section;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.ss.android.lark.base.fragment.BaseFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f285694a;

    public static final class a<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<M, Unit> f285695a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super M, Unit> r100) {
            this.f285695a = r100;
        }

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
        @Override // androidx.lifecycle.Observer
        public final void onChanged(M r100) {
            this.f285695a.invoke(r100);
        }
    }

    public void a() {
    }

    public abstract void i();

    public abstract void j();

    public void l(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "newConfig");
    }

    public void m() {
    }

    public final c b() {
        return this.f285694a.c();
    }

    public final BaseFragment c() {
        return this.f285694a.f();
    }

    public final LifecycleOwner d() {
        return this.f285694a.b();
    }

    public final T e() {
        return this.f285694a.a();
    }

    public final Context getContext() {
        return this.f285694a.provideContext();
    }

    public final Resources getResources() {
        return getContext().getResources();
    }

    public h(e<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "viewAbility");
        this.f285694a = r100;
    }

    public void f(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    public void g(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    public void h(com.ss.android.lark.todo.impl.features.detail.viewmodel.a r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
    }

    public final <M> void k(LiveData<M> r100, Function1<? super M, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "block");
        r100.observe(d(), new a(r101));
    }
}
