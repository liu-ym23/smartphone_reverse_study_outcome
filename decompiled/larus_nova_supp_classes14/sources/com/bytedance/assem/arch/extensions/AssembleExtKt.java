package com.bytedance.assem.arch.extensions;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.assem.arch.core.AssemSupervisor;
import com.bytedance.assem.arch.core.Assembler;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AssembleExtKt {
    public static final void a(final Fragment r12, Function1<? super Assembler, Unit> r13) {
        final Assembler r0 = (Assembler) ViewModelProviders.of(r12.requireActivity()).get(Assembler.class);
        Ref.ObjectRef r1 = new Ref.ObjectRef();
        com.bytedance.assem.arch.core.b r2 = r0.findAssemDataNode(r12);
        r1.element = r2;
        if (r2 != null) goto L9;
        FragmentActivity r3 = r12.getParentFragment();
        if (r3 != null) goto L8;
        r3 = r12.requireActivity();
    L8:
        com.bytedance.assem.arch.core.b r4 = new com.bytedance.assem.arch.core.b(r0.findAssemDataNode(r3));
        r1.element = r4;
        r0.setAssemDataNode(r12, r4);
    L9:
        com.bytedance.assem.arch.core.d r5 = r0.findAssemServiceStore(r12);
        if (r5 != null) goto L47;
        FragmentActivity r6 = r12.getParentFragment();
        if (r6 != null) goto L16;
        r6 = r12.requireActivity();
    L16:
        final com.bytedance.assem.arch.core.d r7 = new com.bytedance.assem.arch.core.d(r0.findAssemServiceStore(r6));
        if ((r12 instanceof com.bytedance.assem.arch.service.c) == false) goto L46;
        com.bytedance.assem.arch.service.c r8 = (com.bytedance.assem.arch.service.c) r12;
        Class<?>[] r9 = r8.getClass().getInterfaces();
        int r10 = r9.length;
        int r11 = 0;
    L20:
        if (r11 >= r10) goto L25;
        Class<?> r14 = r9[r11];
        if (com.bytedance.assem.arch.service.c.class.isAssignableFrom(r14) == true) goto L26;
        r11 = r11 + 1;
    L26:
        if (r14 == null) goto L28;
        r8.f();
        boolean r15 = r7.a.containsKey(new com.bytedance.assem.arch.core.l(r14, null));
    L29:
        if (r15 == true) goto L46;
        Class<?> r16 = r8.getClass();
    L32:
        if (r16 == Object.class) goto L46;
        Class<?>[] r17 = r16.getInterfaces();
        ArrayList r18 = new ArrayList();
        int r19 = r17.length;
        int r20 = 0;
    L34:
        if (r20 >= r19) goto L39;
        Class<?> r110 = r17[r20];
        if (com.bytedance.assem.arch.service.c.class.isAssignableFrom(r110) == false) goto L38;
        r18.add(r110);
    L38:
        r20 = r20 + 1;
        goto L34
    L39:
        Iterator r21 = r18.iterator();
    L41:
        if (r21.hasNext() == false) goto L43;
        r7.a((Class) r21.next(), r8);
        goto L41
    L43:
        r16 = r16.getSuperclass();
        if (r16 == null) goto L46;
    L28:
        r15 = false;
        goto L29
    L25:
        r14 = null;
    L46:
        r12.getLifecycle().addObserver(new AssembleExtKt$assemble$$inlined$let$lambda$2(r7, r12, r0));
        r0.setAssemServiceStore(r12, r7);
        r5 = r7;
    L47:
        AssemSupervisor r22 = r0.findAssemSupervisor(r12);
        if (r22 != null) goto L54;
        int r23 = AssemSupervisor.k;
        final AssemSupervisor r24 = new AssemSupervisor(r12, r12.requireActivity(), (com.bytedance.assem.arch.core.b) r1.element, r5);
        FragmentManager r25 = r12.getFragmentManager();
        if (r25 == null) goto L53;
        r25.registerFragmentLifecycleCallbacks(new AssembleExtKt$assemble$$inlined$let$lambda$3(r24, r12, r0), false);
    L53:
        r0.setAssemSupervisor(r12, r24);
        r22 = r24;
    L54:
        View r111 = r12.getView();
        if (r111 == null) goto L59;
        r22.f(r111);
        r13.invoke(r0);
        return;
    L59:
        throw new IllegalArgumentException("The fragment's root view is null, check if it has no layout or the assemble called before Fragment#onCreateView}.".toString());
    }
}
