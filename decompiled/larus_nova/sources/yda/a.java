package yda;

import com.obric.assistant.IObricAvailableManager;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p1a.b;

/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static final void a(b r100, Function1<? super b, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "block");
        IObricAvailableManager.f385118a.getClass();
        IObricAvailableManager r102 = IObricAvailableManager.a.a();
        if (r102 == null) goto L7;
        boolean r103 = true;
        if (r102.a() != true) goto L7;
    L8:
        if (r103 == false) goto L11;
        r101.invoke(r100);
        return;
    L11:
        return;
    L7:
        r103 = false;
        goto L8
    }
}
