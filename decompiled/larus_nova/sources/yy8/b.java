package yy8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f569499a = 0;

    static {
    }

    public static final void a(Ref.BooleanRef r100, Ref.ObjectRef r101, Function0 r102) {
        if (r100.element == true) goto L10;
        r100.element = true;
        Function0 r103 = (Function0) r101.element;
        r101.element = null;
        if (r103 == null) goto L8;
        r103.invoke();
    L8:
        r102.invoke();
        return;
    }
}
