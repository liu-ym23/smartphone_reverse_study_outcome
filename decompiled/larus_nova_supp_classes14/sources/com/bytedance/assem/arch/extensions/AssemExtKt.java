package com.bytedance.assem.arch.extensions;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.assem.arch.core.Assem;
import com.bytedance.assem.arch.core.AssemContainerBridge;
import com.bytedance.assem.arch.reused.IAssembleComponent;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class AssemExtKt {
    public static final FragmentActivity a(LifecycleOwner r3) {
        if ((r3 instanceof Fragment) == false) goto L6;
        return ((Fragment) r3).getActivity();
    L6:
        if ((r3 instanceof IAssembleComponent) == false) goto L9;
        return ((IAssembleComponent) r3).getActivity();
    L9:
        if ((r3 instanceof FragmentActivity) == false) goto L12;
        return (FragmentActivity) r3;
    L12:
        if ((r3 instanceof Assem) == false) goto L16;
        Assem r4 = (Assem) r3;
        return a(r4.f.getValue(r4, Assem.g[0]));
    L16:
        throw new IllegalStateException("Don't support this LifecycleOwner for find.");
    }

    public static final Fragment b(LifecycleOwner r3) {
        if ((r3 instanceof Fragment) == false) goto L6;
        return (Fragment) r3;
    L6:
        if ((r3 instanceof FragmentActivity) == false) goto L9;
        return null;
    L9:
        if ((r3 instanceof Assem) == false) goto L12;
        Assem r4 = (Assem) r3;
        return b(r4.f.getValue(r4, Assem.g[0]));
    L12:
        if ((r3 instanceof IAssembleComponent) == false) goto L20;
        LifecycleOwner r5 = ((IAssembleComponent) r3).GV();
        if (r5 == null) goto L18;
        return b(r5);
    L18:
        throw new IllegalArgumentException("Required value was null.".toString());
    L20:
        throw new IllegalStateException("Don't support this LifecycleOwner for find.");
    }

    public static final void requestPermissions(final Assem r9, final String[] r10, final int r11, final Function1<? super int[], Unit> r12) {
        final FragmentActivity r2 = a(r9);
        if (r2 == null) goto L9;
        int r0 = AssemContainerBridge.g;
        final AssemContainerBridge r3 = AssemContainerBridge.a.a(r2);
        if (r3.isAdded() == false) goto L7;
        r3.requestPermissions(r9, r10, r11, r12);
        return;
    L7:
        r3.f.add(new AnonymousClass1(r9, r2, r3, r10, r11, r12));
        return;
    }

    public static final void startActivityForResult(Assem r10, final LifecycleOwner r11, final Intent r12, final int r13, final Bundle r14, final Function3<? super Integer, ? super Integer, ? super Intent, Unit> r15) {
        final FragmentActivity r1 = a(r10);
        if (r1 == null) goto L9;
        int r16 = AssemContainerBridge.g;
        final AssemContainerBridge r17 = AssemContainerBridge.a.a(r1);
        if (r17.isAdded() == false) goto L7;
        r17.startActivityForResult(r11, r12, r13, r14, r15);
        return;
    L7:
        r17.f.add(new C02131(r1, r11, r17, r12, r13, r14, r15));
        return;
    }
}
