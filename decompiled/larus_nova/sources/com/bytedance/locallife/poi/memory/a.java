package com.bytedance.locallife.poi.memory;

import androidx.fragment.app.Fragment;
import com.bytedance.locallife.poi.fragment.PoiDetailBizContainerFragment;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Fragment> f262941a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f262942b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Fragment, Boolean> f262943c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Object, Fragment> f262944d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f262945e;

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
    @Override // com.bytedance.locallife.poi.memory.f
    public final boolean recycle() {
        if (this.f262942b.invoke().booleanValue() == true) goto L5;
        return false;
    L5:
        Fragment r100 = this.f262941a.invoke();
        if (r100 != 0) goto L9;
        return false;
    L9:
        if (r100.isAdded() == true) goto L12;
        return false;
    L12:
        if ((r100 instanceof e) == false) goto L14;
        e r101 = (e) r100;
    L15:
        if (r101 == null) goto L17;
        PoiDetailBizContainerFragment.a r102 = r101.Xd();
    L18:
        this.f262945e = r102;
        if (this.f262943c.invoke(r100).booleanValue() == true) goto L22;
        this.f262945e = null;
        return false;
    L22:
        return true;
    L17:
        r102 = null;
        goto L18
    L14:
        r101 = null;
        goto L15
    }

    @Override // com.bytedance.locallife.poi.memory.f
    public final void restore() {
        if (this.f262942b.invoke().booleanValue() == true) goto L6;
        return;
    L6:
        if (this.f262944d.invoke(this.f262945e) != null) goto L8;
        return;
    L8:
        this.f262945e = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(Function0<? extends Fragment> r100, Function0<Boolean> r101, Function1<? super Fragment, Boolean> r102, Function1<Object, ? extends Fragment> r103) {
        Intrinsics.checkNotNullParameter(r100, "currentFragmentProvider");
        Intrinsics.checkNotNullParameter(r101, "canOperate");
        Intrinsics.checkNotNullParameter(r102, "removeFragment");
        Intrinsics.checkNotNullParameter(r103, "restoreFragment");
        this.f262941a = r100;
        this.f262942b = r101;
        this.f262943c = r102;
        this.f262944d = r103;
    }
}
