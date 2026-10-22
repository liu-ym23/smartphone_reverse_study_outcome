package com.bytedance.assem.arch.service;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.assem.arch.core.Assembler;
import com.bytedance.assem.arch.core.l;
import java.util.LinkedHashMap;
import kotlin.TypeCastException;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e {
    public static c a(Fragment r3, KClass r4) throws IllegalStateException {
        if (r3.isAdded() == true) goto L6;
        return null;
    L6:
        if (r3.getActivity() == null) goto L27;
        FragmentActivity r0 = r3.getActivity();
        if (r0 != null) goto L10;
    L12:
        FragmentActivity r1 = r3.getActivity();
        if (r1 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        com.bytedance.assem.arch.core.d r5 = ((Assembler) ViewModelProviders.of(r1).get(Assembler.class)).findAssemServiceStore(r3);
        if (r5 == null) goto L30;
        l r2 = new l(JvmClassMappingKt.getJavaClass(r4), null);
    L18:
        if (r5 == null) goto L34;
        if (r5.a.containsKey(r2) == true) goto L21;
        r5 = r5.c;
        goto L18
    L21:
        Object r6 = ((LinkedHashMap) r5.a).get(r2);
        if (r6 == null) goto L25;
        return (c) r6;
    L25:
        throw new TypeCastException("null cannot be cast to non-null type SERVICE");
    L34:
        return null;
    L30:
        return null;
    L10:
        if (r0.isFinishing() != true) goto L12;
        return null;
    L27:
        return null;
    }
}
