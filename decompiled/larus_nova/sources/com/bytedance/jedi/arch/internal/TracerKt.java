package com.bytedance.jedi.arch.internal;

import com.bytedance.jedi.arch.JediViewModel;
import io.reactivex.subjects.BehaviorSubject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0007¨\u0006\u0004"}, d2 = {"stateTrace", "", "viewModel", "Lcom/bytedance/jedi/arch/JediViewModel;", "arch_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class TracerKt {
    @Deprecated(level = DeprecationLevel.WARNING, message = "only call this in debug sessions")
    public static final Object stateTrace(JediViewModel<?> r100) {
        Method r101 = JediViewModel.class.getDeclaredMethod("getStoreOwner", new Class[0]);
        r101.setAccessible(true);
        if (r100 == null) goto L11;
        Object r102 = r101.invoke(r100, new Object[0]);
        Field r103 = r102.getClass().getDeclaredField("realStore");
        r103.setAccessible(true);
        Object r104 = r103.get(r102);
        Field r105 = r104.getClass().getDeclaredField(com.bytedance.android.ec.core.event.a.KEY_SUBJECT);
        r105.setAccessible(true);
        Object r106 = r105.get(r104);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type io.reactivex.subjects.BehaviorSubject<kotlin.Any>");
        Object r107 = ((BehaviorSubject) r106).getValue();
        if ((r107 instanceof Pair) == false) goto L9;
        Object r108 = ((Pair) r107).getSecond();
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type kotlin.Any");
        return r108;
    L9:
        throw new IllegalStateException("need JediDevTools".toString());
    L11:
        throw new IllegalArgumentException("viewModel is null".toString());
    }
}
