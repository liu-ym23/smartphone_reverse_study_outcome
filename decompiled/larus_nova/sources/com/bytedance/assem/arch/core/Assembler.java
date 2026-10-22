package com.bytedance.assem.arch.core;

import android.os.Looper;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.assem.arch.extensions.AssemDsl;
import com.bytedance.assem.arch.extensions.HostInjector;
import com.bytedance.assem.arch.reused.FireCase;
import com.bytedance.assem.arch.reused.IResuedAssemProxy;
import com.bytedance.assem.arch.reused.ReusedUIAssem;
import com.bytedance.assem.arch.reused.ReusedUIContentAssem;
import com.bytedance.assem.arch.reused.ReusedUISlotAssem;
import com.bytedance.assem.arch.view.UIContentAssem;
import com.bytedance.assem.arch.view.UISlotAssem;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bC\u0010AJ(\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J!\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0010\b\u0004\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0087\bJ'\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J'\u0010!\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J'\u0010#\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J@\u0010(\u001a\u0004\u0018\u00010\r\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b(\u0010)J@\u0010+\u001a\u0004\u0018\u00010\r\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b+\u0010)J9\u00100\u001a\u00020\t\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0012\u0010-\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030$0,H\u0000¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u00020\t*\u0002012\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J+\u00105\u001a\u00020\t*\u0002062\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J+\u00105\u001a\u00020\t*\u00020\u00052\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J\u0010\u00107\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u00108\u001a\u00020\tH\u0014R#\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R,\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011098\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b>\u0010;\u0012\u0004\b@\u0010A\u001a\u0004\b?\u0010=R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010;¨\u0006F"}, d2 = {"Lcom/bytedance/assem/arch/core/Assembler;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/assem/arch/core/l;", "identifierArray", "Lcom/bytedance/assem/arch/core/Assem;", "serviceInstance", "Lcom/bytedance/assem/arch/core/d;", "serviceStore", "", "checkAndRegisterService", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/bytedance/assem/arch/core/AssemSupervisor;", "findAssemSupervisor", "supervisor", "setAssemSupervisor", "Lcom/bytedance/assem/arch/core/b;", "findAssemDataNode", "dataStore", "setAssemDataNode", "findAssemServiceStore", "setAssemServiceStore", "Lkotlin/Function0;", "Landroid/view/ViewGroup;", LynxViewpagerItem.BIND_ON_ATTACH, "rootView", "Lkotlin/Function1;", "Lcom/bytedance/assem/arch/core/a;", "Lkotlin/ExtensionFunctionType;", "assemBuilder", "assem", "Lcom/bytedance/assem/arch/core/n;", "uiSlotAssem", "Lcom/bytedance/assem/arch/core/m;", "uiContentAssem", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "Lcom/bytedance/tiktok/proxy/a;", "REUSED", "Lcom/bytedance/assem/arch/core/k;", "reusedUiSlotAssem", "(Lcom/bytedance/assem/arch/reused/ReusedUIAssem;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/assem/arch/core/AssemSupervisor;", "Lcom/bytedance/assem/arch/core/j;", "reusedUiContentAssem", "Lkotlin/reflect/KClass;", "clazz", "checkAndTriggerLazyLoad$assem_release", "(Lcom/bytedance/assem/arch/reused/ReusedUIAssem;Lkotlin/reflect/KClass;)V", "checkAndTriggerLazyLoad", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/assem/arch/core/f;", "Lcom/bytedance/assem/arch/extensions/a;", "builder", "hierarchyData", "Landroidx/fragment/app/Fragment;", "clearAsLifecycleOwner", "onCleared", "Ljava/util/WeakHashMap;", "assemSupervisorContainer", "Ljava/util/WeakHashMap;", "getAssemSupervisorContainer", "()Ljava/util/WeakHashMap;", "assemDataNodeContainer", "getAssemDataNodeContainer", "assemDataNodeContainer$annotations", "()V", "assemServiceStoreContainer", "<init>", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "assem_release"}, k = 1, mv = {1, 4, 0})
@AssemDsl
public final class Assembler extends ViewModel {
    public static final a Companion = null;
    private final WeakHashMap<LifecycleOwner, b> assemDataNodeContainer;
    private final WeakHashMap<LifecycleOwner, d> assemServiceStoreContainer;
    private final WeakHashMap<LifecycleOwner, AssemSupervisor> assemSupervisorContainer;

    public static final class a {
        public a() {
        }

        public static Assembler a(FragmentActivity r100) {
            return (Assembler) ViewModelProviders.of(r100).get(Assembler.class);
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ void assemDataNodeContainer$annotations() {
    }

    public Assembler() {
        this.assemSupervisorContainer = new WeakHashMap();
        this.assemDataNodeContainer = new WeakHashMap();
        this.assemServiceStoreContainer = new WeakHashMap();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.assemDataNodeContainer.clear();
        this.assemSupervisorContainer.clear();
        this.assemServiceStoreContainer.clear();
    }

    public final WeakHashMap<LifecycleOwner, b> getAssemDataNodeContainer() {
        return this.assemDataNodeContainer;
    }

    public final WeakHashMap<LifecycleOwner, AssemSupervisor> getAssemSupervisorContainer() {
        return this.assemSupervisorContainer;
    }

    public final void clearAsLifecycleOwner(LifecycleOwner r100) {
        if (r100 == null) goto L5;
        this.assemDataNodeContainer.remove(r100);
        this.assemServiceStoreContainer.remove(r100);
        this.assemSupervisorContainer.remove(r100);
        return;
    }

    public final b findAssemDataNode(LifecycleOwner r100) {
        return this.assemDataNodeContainer.get(r100);
    }

    public final d findAssemServiceStore(LifecycleOwner r100) {
        return this.assemServiceStoreContainer.get(r100);
    }

    public final AssemSupervisor findAssemSupervisor(LifecycleOwner r100) {
        return this.assemSupervisorContainer.get(r100);
    }

    @AssemDsl
    public final AssemSupervisor assem(LifecycleOwner r100, Function1<? super com.bytedance.assem.arch.core.a, Unit> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 == null) goto L6;
        com.bytedance.assem.arch.core.a r103 = new com.bytedance.assem.arch.core.a();
        r101.invoke(r103);
        Assem r104 = r103.build();
        checkAndRegisterService(r103.f192885b, r104, r102.f192879j);
        r102.d(r104);
        r102.a(null);
        return r102;
    L6:
        return null;
    }

    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> void checkAndTriggerLazyLoad$assem_release(REUSED r100, KClass<? extends ReusedUIAssem<?>> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 != null) goto L5;
        return;
    L5:
        if (r102.f192873d.containsKey(r101) == true) goto L7;
        return;
    L7:
        h r103 = r102.f192873d.remove(r101);
        Assem r104 = null;
        if (r103 == null) goto L10;
        Assem r105 = r103.build();
    L12:
        if ((r105 instanceof ReusedUIAssem) == false) goto L15;
        r104 = r105;
    L15:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r106 = (ReusedUIAssem) r104;
        if (r106 == null) goto L28;
        r102.d(r106);
        r106.t();
        IResuedAssemProxy r107 = r100.f192994r;
        if (r107 == null) goto L20;
        r107.jz(r106);
    L20:
        IResuedAssemProxy r108 = r106.f192994r;
        if (r108 == null) goto L25;
        BehaviorSubject<com.bytedance.assem.arch.reused.a> r109 = r108.gl();
        if (r109 == null) goto L25;
        r109.onNext(new com.bytedance.assem.arch.reused.a(FireCase.HostAttach, r106));
    L25:
        r102.a(r106);
        return;
    L28:
        return;
    L10:
        r105 = null;
        goto L12
    }

    @AssemDsl
    public final void hierarchyData(Fragment r100, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r101) {
        f r102 = new f();
        r101.invoke(r102);
        T r103 = r102.f192893a;
        if (r103 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r104 = TuplesKt.to(null, r103);
        String r105 = (String) r104.component1();
        com.bytedance.assem.arch.extensions.a r106 = (com.bytedance.assem.arch.extensions.a) r104.component2();
        b r107 = this.assemDataNodeContainer.get(r100);
        if (r107 == null) goto L9;
        r107.c(r106, r105);
        return;
    }

    @AssemDsl
    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> AssemSupervisor reusedUiContentAssem(REUSED r100, Function1<? super j, Unit> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 == null) goto L16;
        j r103 = new j();
        r101.invoke(r103);
        if (r103.f192898a != AssembleMode.LAZY) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L11;
        r102.f192873d.put(r103.getType(), r103);
        return r100.j();
    L11:
        ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> r105 = r103.a();
        r102.d(r105);
        IResuedAssemProxy r106 = r100.f192994r;
        if (r106 == null) goto L15;
        r106.jz(r105);
    L15:
        return r100.j();
    L7:
        r104 = false;
        goto L8
    L16:
        return null;
    }

    @AssemDsl
    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> AssemSupervisor reusedUiSlotAssem(REUSED r100, Function1<? super k, Unit> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 == null) goto L19;
        k r103 = new k();
        r101.invoke(r103);
        if (r103.f192899a != AssembleMode.LAZY) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L10;
        ReusedUISlotAssem<? extends com.bytedance.tiktok.proxy.a> r105 = r103.a();
        r102.d(r105);
        IResuedAssemProxy r106 = r100.f192994r;
        if (r106 == null) goto L18;
        r106.jz(r105);
    L18:
        return r100.j();
    L10:
        if (r102.f192875f == null) goto L12;
        Lazy r107 = HostInjector.f192919a;
    L12:
        r103.f192901c = null;
        r102.f192873d.put(r103.getType(), r103);
        return r100.j();
    L7:
        r104 = false;
        goto L8
    L19:
        return null;
    }

    @AssemDsl
    public final AssemSupervisor rootView(LifecycleOwner r100, Function0<? extends ViewGroup> r101) {
        AssemSupervisor r102 = getAssemSupervisorContainer().get(r100);
        if (r102 == null) goto L5;
        r102.f(r101.invoke());
        return r102;
    L5:
        return null;
    }

    public final void setAssemDataNode(LifecycleOwner r100, b r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.assemDataNodeContainer.put(r100, r101);
        return;
    L7:
        return;
    }

    public final void setAssemServiceStore(LifecycleOwner r100, d r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.assemServiceStoreContainer.put(r100, r101);
        return;
    L7:
        return;
    }

    public final void setAssemSupervisor(LifecycleOwner r100, AssemSupervisor r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        this.assemSupervisorContainer.put(r100, r101);
        return;
    L7:
        return;
    }

    @AssemDsl
    public final AssemSupervisor uiContentAssem(LifecycleOwner r100, Function1<? super m, Unit> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 == null) goto L6;
        m r103 = new m();
        r101.invoke(r103);
        UIContentAssem r104 = r103.a();
        checkAndRegisterService(r103.f192906c, r104, r102.f192879j);
        r102.d(r104);
        r102.a(null);
        return r102;
    L6:
        return null;
    }

    @AssemDsl
    public final AssemSupervisor uiSlotAssem(LifecycleOwner r100, Function1<? super n, Unit> r101) {
        AssemSupervisor r102 = this.assemSupervisorContainer.get(r100);
        if (r102 == null) goto L6;
        n r103 = new n();
        r101.invoke(r103);
        UISlotAssem r104 = r103.a();
        checkAndRegisterService(r103.f192909b, r104, r102.f192879j);
        r102.d(r104);
        r102.a(null);
        return r102;
    L6:
        return null;
    }

    @AssemDsl
    public final void hierarchyData(FragmentActivity r100, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r101) {
        f r102 = new f();
        r101.invoke(r102);
        T r103 = r102.f192893a;
        if (r103 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r104 = TuplesKt.to(null, r103);
        String r105 = (String) r104.component1();
        com.bytedance.assem.arch.extensions.a r106 = (com.bytedance.assem.arch.extensions.a) r104.component2();
        b r107 = this.assemDataNodeContainer.get(r100);
        if (r107 == null) goto L9;
        r107.c(r106, r105);
        return;
    }

    @AssemDsl
    public final void hierarchyData(Assem r100, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r101) {
        f r102 = new f();
        r101.invoke(r102);
        T r103 = r102.f192893a;
        if (r103 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r104 = TuplesKt.to(null, r103);
        String r105 = (String) r104.component1();
        com.bytedance.assem.arch.extensions.a r106 = (com.bytedance.assem.arch.extensions.a) r104.component2();
        b r107 = this.assemDataNodeContainer.get(r100);
        if (r107 == null) goto L9;
        r107.c(r106, r105);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkAndRegisterService(List<l> r100, Assem r101, d r110) {
        List<l> r102 = r100;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L42;
        Iterator<l> r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L81;
        l r105 = r104.next();
        if (r105.f192902a.isAssignableFrom(r101.getClass()) == false) goto L40;
        com.bytedance.assem.arch.service.c r106 = (com.bytedance.assem.arch.service.c) r101;
        r110.getClass();
        Class<?> r107 = r105.f192902a;
        if (Intrinsics.areEqual(r107, com.bytedance.assem.arch.service.c.class) == true) goto L38;
        if (Intrinsics.areEqual(r107, com.bytedance.assem.arch.service.b.class) == true) goto L38;
        Objects.toString(r107);
        Objects.toString(r106);
        r110.f192888a.size();
        Objects.toString(r110.f192888a);
        if (r110.f192888a.containsKey(r105) == true) goto L22;
    L26:
        r110.f192888a.put(r105, r106);
        if ((r106 instanceof com.bytedance.assem.arch.service.b) == false) goto L12;
        com.bytedance.assem.arch.service.a r108 = ((com.bytedance.assem.arch.service.b) r106).g();
        MutableLiveData<? extends com.bytedance.assem.arch.service.a> r109 = (MutableLiveData) ((LinkedHashMap) r110.f192889b).get(r105);
        if (r109 != null) goto L32;
        r109 = new MutableLiveData();
        r110.f192889b.put(r105, r109);
    L32:
        if (r109.getValue() != null) goto L12;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L35;
        r109.postValue(r108);
        goto L12
    L35:
        r109.setValue(r108);
        goto L12
    L22:
        if (r106 == ((com.bytedance.assem.arch.service.c) ((LinkedHashMap) r110.f192888a).get(r105))) goto L26;
        Lazy r111 = HostInjector.f192919a;
        StringBuilder r112 = new StringBuilder("(service=");
        r112.append(r107);
        r112.append(", serviceKey =null) has been already registered on service store. the service real instance is ");
        r106.f();
        r112.append(r106);
        r112.append(", the registered service real instance is ");
        r112.append((com.bytedance.assem.arch.service.c) ((LinkedHashMap) r110.f192888a).get(r105));
        throw new IllegalStateException(r112.toString());
    L38:
        throw new IllegalArgumentException("{" + r107 + " - " + r106 + "}: AssemService or AssemObservableService can't be registered directly, use subclass instead");
    L40:
        throw new IllegalStateException("The serviceClazz must be super interface of this Assem".toString());
    L81:
        return;
    L42:
        if ((r101 instanceof com.bytedance.assem.arch.service.c) == false) goto L59;
        com.bytedance.assem.arch.service.c r113 = (com.bytedance.assem.arch.service.c) r101;
        Class<?> r114 = r113.getClass();
    L45:
        if (r114 == Object.class) goto L82;
        Class<?>[] r115 = r114.getInterfaces();
        ArrayList r116 = new ArrayList();
        int r117 = r115.length;
        int r118 = 0;
    L47:
        if (r118 >= r117) goto L52;
        Class<?> r119 = r115[r118];
        if (com.bytedance.assem.arch.service.c.class.isAssignableFrom(r119) == false) goto L51;
        r116.add(r119);
    L51:
        r118 = r118 + 1;
        goto L47
    L52:
        Iterator r120 = r116.iterator();
    L54:
        if (r120.hasNext() == false) goto L56;
        r110.a((Class) r120.next(), r113);
        goto L54
    L56:
        r114 = r114.getSuperclass();
        if (r114 != null) goto L45;
        return;
    L82:
        return;
    L59:
        return;
    L5:
        if (r102.isEmpty() == true) goto L8;
        r103 = false;
        goto L9
    }
}
