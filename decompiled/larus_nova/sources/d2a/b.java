package d2a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {
    public static final void a(Function1 r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r100, "callback");
        d r101 = new d();
        r100.invoke(r101);
        AnimatorSet r102 = new AnimatorSet();
        int r103 = r101.f466558a.size();
        if (r103 <= 0) goto L21;
        ArrayList r104 = new ArrayList();
        int r105 = 0;
    L5:
        if (r105 >= r103) goto L20;
        List<Animator> r106 = r101.f466558a.valueAt(r105);
        int r107 = r101.f466558a.keyAt(r105);
        List<Animator> r108 = r106;
        if (r108 != null) goto L9;
    L12:
        boolean r109 = true;
    L13:
        if (r109 == true) goto L19;
        AnimatorSet r110 = new AnimatorSet();
        r110.playTogether(r108);
        r104.add(r110);
        final List<Animator> r111 = r101.f466559b.get(r107);
        if (r111 != null) goto L18;
        r111 = CollectionsKt.emptyList();
    L18:
        r101.f466559b.remove(r107);
        g.b(r110, new c(r111), null, null, 14);
    L19:
        r105 = r105 + 1;
        goto L5
    L9:
        if (r108.isEmpty() == true) goto L12;
        r109 = false;
        goto L13
    L20:
        r102.playSequentially(r104);
    L21:
        r102.start();
    }
}
