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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 D2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\bC\u0010AJ(\u0010\n\u001a\u00020\t2\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0014\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J!\u0010\u001a\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0010\b\u0004\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0087\bJ'\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J'\u0010!\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J'\u0010#\u001a\u0004\u0018\u00010\r*\u00020\u000b2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J@\u0010(\u001a\u0004\u0018\u00010\r\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b(\u0010)J@\u0010+\u001a\u0004\u0018\u00010\r\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007¢\u0006\u0004\b+\u0010)J9\u00100\u001a\u00020\t\"\u0010\b\u0000\u0010&*\n\u0012\u0006\b\u0001\u0012\u00020%0$*\u00028\u00002\u0012\u0010-\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030$0,H\u0000¢\u0006\u0004\b.\u0010/J+\u00105\u001a\u00020\t*\u0002012\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J+\u00105\u001a\u00020\t*\u0002062\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J+\u00105\u001a\u00020\t*\u00020\u00052\u001d\u00104\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020302\u0012\u0004\u0012\u00020\t0\u001b¢\u0006\u0002\b\u001dH\u0007J\u0010\u00107\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u00108\u001a\u00020\tH\u0014R#\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r098\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R,\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0011098\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b>\u0010;\u0012\u0004\b@\u0010A\u001a\u0004\b?\u0010=R \u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010;¨\u0006F"}, d2 = {"Lcom/bytedance/assem/arch/core/Assembler;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/assem/arch/core/l;", "identifierArray", "Lcom/bytedance/assem/arch/core/Assem;", "serviceInstance", "Lcom/bytedance/assem/arch/core/d;", "serviceStore", "", "checkAndRegisterService", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/bytedance/assem/arch/core/AssemSupervisor;", "findAssemSupervisor", "supervisor", "setAssemSupervisor", "Lcom/bytedance/assem/arch/core/b;", "findAssemDataNode", "dataStore", "setAssemDataNode", "findAssemServiceStore", "setAssemServiceStore", "Lkotlin/Function0;", "Landroid/view/ViewGroup;", "attach", "rootView", "Lkotlin/Function1;", "Lcom/bytedance/assem/arch/core/a;", "Lkotlin/ExtensionFunctionType;", "assemBuilder", "assem", "Lcom/bytedance/assem/arch/core/n;", "uiSlotAssem", "Lcom/bytedance/assem/arch/core/m;", "uiContentAssem", "Lcom/bytedance/assem/arch/reused/ReusedUIAssem;", "Lcom/bytedance/tiktok/proxy/a;", "REUSED", "Lcom/bytedance/assem/arch/core/k;", "reusedUiSlotAssem", "(Lcom/bytedance/assem/arch/reused/ReusedUIAssem;Lkotlin/jvm/functions/Function1;)Lcom/bytedance/assem/arch/core/AssemSupervisor;", "Lcom/bytedance/assem/arch/core/j;", "reusedUiContentAssem", "Lkotlin/reflect/KClass;", "clazz", "checkAndTriggerLazyLoad$assem_release", "(Lcom/bytedance/assem/arch/reused/ReusedUIAssem;Lkotlin/reflect/KClass;)V", "checkAndTriggerLazyLoad", "Landroidx/fragment/app/FragmentActivity;", "Lcom/bytedance/assem/arch/core/f;", "Lcom/bytedance/assem/arch/extensions/a;", "builder", "hierarchyData", "Landroidx/fragment/app/Fragment;", "clearAsLifecycleOwner", "onCleared", "Ljava/util/WeakHashMap;", "assemSupervisorContainer", "Ljava/util/WeakHashMap;", "getAssemSupervisorContainer", "()Ljava/util/WeakHashMap;", "assemDataNodeContainer", "getAssemDataNodeContainer", "assemDataNodeContainer$annotations", "()V", "assemServiceStoreContainer", "<init>", "Companion", "a", "assem_release"}, k = 1, mv = {1, 4, 0})
@AssemDsl
public final class Assembler extends ViewModel {
    public static final a Companion = null;
    private final WeakHashMap<LifecycleOwner, b> assemDataNodeContainer;
    private final WeakHashMap<LifecycleOwner, d> assemServiceStoreContainer;
    private final WeakHashMap<LifecycleOwner, AssemSupervisor> assemSupervisorContainer;

    public static final class a {
        public a() {
        }

        public static Assembler a(FragmentActivity r1) {
            return (Assembler) ViewModelProviders.of(r1).get(Assembler.class);
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

    public final void clearAsLifecycleOwner(LifecycleOwner r2) {
        if (r2 == null) goto L5;
        this.assemDataNodeContainer.remove(r2);
        this.assemServiceStoreContainer.remove(r2);
        this.assemSupervisorContainer.remove(r2);
        return;
    }

    public final b findAssemDataNode(LifecycleOwner r2) {
        return this.assemDataNodeContainer.get(r2);
    }

    public final d findAssemServiceStore(LifecycleOwner r2) {
        return this.assemServiceStoreContainer.get(r2);
    }

    public final AssemSupervisor findAssemSupervisor(LifecycleOwner r2) {
        return this.assemSupervisorContainer.get(r2);
    }

    @AssemDsl
    public final AssemSupervisor assem(LifecycleOwner r4, Function1<? super com.bytedance.assem.arch.core.a, Unit> r5) {
        AssemSupervisor r6 = this.assemSupervisorContainer.get(r4);
        if (r6 == null) goto L6;
        com.bytedance.assem.arch.core.a r1 = new com.bytedance.assem.arch.core.a();
        r5.invoke(r1);
        Assem r7 = r1.build();
        checkAndRegisterService(r1.b, r7, r6.j);
        r6.d(r7);
        r6.a(null);
        return r6;
    L6:
        return null;
    }

    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> void checkAndTriggerLazyLoad$assem_release(REUSED r4, KClass<? extends ReusedUIAssem<?>> r5) {
        AssemSupervisor r0 = this.assemSupervisorContainer.get(r4);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.d.containsKey(r5) == true) goto L7;
        return;
    L7:
        h r6 = r0.d.remove(r5);
        Assem r1 = null;
        if (r6 == null) goto L10;
        Assem r7 = r6.build();
    L12:
        if ((r7 instanceof ReusedUIAssem) == false) goto L15;
        r1 = r7;
    L15:
        ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a> r2 = (ReusedUIAssem) r1;
        if (r2 == null) goto L28;
        r0.d(r2);
        r2.t();
        IResuedAssemProxy r8 = r4.r;
        if (r8 == null) goto L20;
        r8.jz(r2);
    L20:
        IResuedAssemProxy r9 = r2.r;
        if (r9 == null) goto L25;
        BehaviorSubject<com.bytedance.assem.arch.reused.a> r10 = r9.gl();
        if (r10 == null) goto L25;
        r10.onNext(new com.bytedance.assem.arch.reused.a(FireCase.HostAttach, r2));
    L25:
        r0.a(r2);
        return;
    L28:
        return;
    L10:
        r7 = null;
        goto L12
    }

    @AssemDsl
    public final void hierarchyData(Fragment r3, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r4) {
        f r0 = new f();
        r4.invoke(r0);
        T r5 = r0.a;
        if (r5 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r6 = TuplesKt.to(null, r5);
        String r1 = (String) r6.component1();
        com.bytedance.assem.arch.extensions.a r7 = (com.bytedance.assem.arch.extensions.a) r6.component2();
        b r8 = this.assemDataNodeContainer.get(r3);
        if (r8 == null) goto L9;
        r8.c(r7, r1);
        return;
    }

    @AssemDsl
    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> AssemSupervisor reusedUiContentAssem(REUSED r4, Function1<? super j, Unit> r5) {
        AssemSupervisor r0 = this.assemSupervisorContainer.get(r4);
        if (r0 == null) goto L16;
        j r1 = new j();
        r5.invoke(r1);
        if (r1.a != AssembleMode.LAZY) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        r0.d.put(r1.getType(), r1);
        return r4.j();
    L11:
        ReusedUIContentAssem<? extends com.bytedance.tiktok.proxy.a> r7 = r1.a();
        r0.d(r7);
        IResuedAssemProxy r2 = r4.r;
        if (r2 == null) goto L15;
        r2.jz(r7);
    L15:
        return r4.j();
    L7:
        r6 = false;
        goto L8
    L16:
        return null;
    }

    @AssemDsl
    public final <REUSED extends ReusedUIAssem<? extends com.bytedance.tiktok.proxy.a>> AssemSupervisor reusedUiSlotAssem(REUSED r5, Function1<? super k, Unit> r6) {
        AssemSupervisor r0 = this.assemSupervisorContainer.get(r5);
        if (r0 == null) goto L19;
        k r2 = new k();
        r6.invoke(r2);
        if (r2.a != AssembleMode.LAZY) goto L7;
        boolean r7 = true;
    L8:
        if (r7 == true) goto L10;
        ReusedUISlotAssem<? extends com.bytedance.tiktok.proxy.a> r8 = r2.a();
        r0.d(r8);
        IResuedAssemProxy r1 = r5.r;
        if (r1 == null) goto L18;
        r1.jz(r8);
    L18:
        return r5.j();
    L10:
        if (r0.f == null) goto L12;
        Lazy r9 = HostInjector.a;
    L12:
        r2.c = null;
        r0.d.put(r2.getType(), r2);
        return r5.j();
    L7:
        r7 = false;
        goto L8
    L19:
        return null;
    }

    @AssemDsl
    public final AssemSupervisor rootView(LifecycleOwner r2, Function0<? extends ViewGroup> r3) {
        AssemSupervisor r4 = getAssemSupervisorContainer().get(r2);
        if (r4 == null) goto L5;
        r4.f((ViewGroup) r3.invoke());
        return r4;
    L5:
        return null;
    }

    public final void setAssemDataNode(LifecycleOwner r2, b r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.assemDataNodeContainer.put(r2, r3);
        return;
    L7:
        return;
    }

    public final void setAssemServiceStore(LifecycleOwner r2, d r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.assemServiceStoreContainer.put(r2, r3);
        return;
    L7:
        return;
    }

    public final void setAssemSupervisor(LifecycleOwner r2, AssemSupervisor r3) {
        if (r2 == null) goto L6;
        if (r3 == null) goto L7;
        this.assemSupervisorContainer.put(r2, r3);
        return;
    L7:
        return;
    }

    @AssemDsl
    public final AssemSupervisor uiContentAssem(LifecycleOwner r4, Function1<? super m, Unit> r5) {
        AssemSupervisor r6 = this.assemSupervisorContainer.get(r4);
        if (r6 == null) goto L6;
        m r1 = new m();
        r5.invoke(r1);
        UIContentAssem r7 = r1.a();
        checkAndRegisterService(r1.c, r7, r6.j);
        r6.d(r7);
        r6.a(null);
        return r6;
    L6:
        return null;
    }

    @AssemDsl
    public final AssemSupervisor uiSlotAssem(LifecycleOwner r4, Function1<? super n, Unit> r5) {
        AssemSupervisor r6 = this.assemSupervisorContainer.get(r4);
        if (r6 == null) goto L6;
        n r1 = new n();
        r5.invoke(r1);
        UISlotAssem r7 = r1.a();
        checkAndRegisterService(r1.b, r7, r6.j);
        r6.d(r7);
        r6.a(null);
        return r6;
    L6:
        return null;
    }

    @AssemDsl
    public final void hierarchyData(FragmentActivity r3, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r4) {
        f r0 = new f();
        r4.invoke(r0);
        T r5 = r0.a;
        if (r5 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r6 = TuplesKt.to(null, r5);
        String r1 = (String) r6.component1();
        com.bytedance.assem.arch.extensions.a r7 = (com.bytedance.assem.arch.extensions.a) r6.component2();
        b r8 = this.assemDataNodeContainer.get(r3);
        if (r8 == null) goto L9;
        r8.c(r7, r1);
        return;
    }

    @AssemDsl
    public final void hierarchyData(Assem r3, Function1<? super f<com.bytedance.assem.arch.extensions.a>, Unit> r4) {
        f r0 = new f();
        r4.invoke(r0);
        T r5 = r0.a;
        if (r5 != 0) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("data");
    L5:
        Pair r6 = TuplesKt.to(null, r5);
        String r1 = (String) r6.component1();
        com.bytedance.assem.arch.extensions.a r7 = (com.bytedance.assem.arch.extensions.a) r6.component2();
        b r8 = this.assemDataNodeContainer.get(r3);
        if (r8 == null) goto L9;
        r8.c(r7, r1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void checkAndRegisterService(List<l> r8, Assem r9, d r10) {
        List<l> r0 = r8;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L42;
        Iterator<l> r11 = r8.iterator();
    L12:
        if (r11.hasNext() == false) goto L81;
        l r2 = r11.next();
        if (r2.a.isAssignableFrom(r9.getClass()) == false) goto L40;
        com.bytedance.assem.arch.service.c r3 = (com.bytedance.assem.arch.service.c) r9;
        r10.getClass();
        Class<?> r4 = r2.a;
        if (Intrinsics.areEqual(r4, com.bytedance.assem.arch.service.c.class) == true) goto L38;
        if (Intrinsics.areEqual(r4, com.bytedance.assem.arch.service.b.class) == true) goto L38;
        Objects.toString(r4);
        Objects.toString(r3);
        r10.a.size();
        Objects.toString(r10.a);
        if (r10.a.containsKey(r2) == true) goto L22;
    L26:
        r10.a.put(r2, r3);
        if ((r3 instanceof com.bytedance.assem.arch.service.b) == false) goto L12;
        com.bytedance.assem.arch.service.a r5 = ((com.bytedance.assem.arch.service.b) r3).g();
        MutableLiveData<? extends com.bytedance.assem.arch.service.a> r6 = (MutableLiveData) ((LinkedHashMap) r10.b).get(r2);
        if (r6 != null) goto L32;
        r6 = new MutableLiveData();
        r10.b.put(r2, r6);
    L32:
        if (r6.getValue() != null) goto L12;
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper()) == true) goto L35;
        r6.postValue(r5);
        goto L12
    L35:
        r6.setValue(r5);
        goto L12
    L22:
        if (r3 == ((com.bytedance.assem.arch.service.c) ((LinkedHashMap) r10.a).get(r2))) goto L26;
        Lazy r12 = HostInjector.a;
        StringBuilder r13 = new StringBuilder("(service=");
        r13.append(r4);
        r13.append(", serviceKey =null) has been already registered on service store. the service real instance is ");
        r3.f();
        r13.append(r3);
        r13.append(", the registered service real instance is ");
        r13.append((com.bytedance.assem.arch.service.c) ((LinkedHashMap) r10.a).get(r2));
        throw new IllegalStateException(r13.toString());
    L38:
        throw new IllegalArgumentException("{" + r4 + " - " + r3 + "}: AssemService or AssemObservableService can't be registered directly, use subclass instead");
    L40:
        throw new IllegalStateException("The serviceClazz must be super interface of this Assem".toString());
    L81:
        return;
    L42:
        if ((r9 instanceof com.bytedance.assem.arch.service.c) == false) goto L59;
        com.bytedance.assem.arch.service.c r14 = (com.bytedance.assem.arch.service.c) r9;
        Class<?> r15 = r14.getClass();
    L45:
        if (r15 == Object.class) goto L82;
        Class<?>[] r7 = r15.getInterfaces();
        ArrayList r16 = new ArrayList();
        int r17 = r7.length;
        int r18 = 0;
    L47:
        if (r18 >= r17) goto L52;
        Class<?> r19 = r7[r18];
        if (com.bytedance.assem.arch.service.c.class.isAssignableFrom(r19) == false) goto L51;
        r16.add(r19);
    L51:
        r18 = r18 + 1;
        goto L47
    L52:
        Iterator r20 = r16.iterator();
    L54:
        if (r20.hasNext() == false) goto L56;
        r10.a((Class) r20.next(), r14);
        goto L54
    L56:
        r15 = r15.getSuperclass();
        if (r15 != null) goto L45;
        return;
    L82:
        return;
    L59:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
