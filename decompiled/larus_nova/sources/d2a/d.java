package d2a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<List<Animator>> f466558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<List<Animator>> f466559b;

    public d() {
        this.f466558a = new SparseArray();
        this.f466559b = new SparseArray();
    }

    public final void a(View r100, Function1<? super k, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "callback");
        a r102 = new a(r100);
        r101.invoke(r102);
        Animator r103 = r102.f466566a;
        if (r103 != null) goto L5;
        r103 = r102.f466573h;
    L5:
        r103.setStartDelay(0);
        r103.setDuration(r102.f466567b);
        r103.setInterpolator(r102.f466568c);
        if ((r103 instanceof ValueAnimator) == false) goto L8;
        ValueAnimator r104 = (ValueAnimator) r103;
        r104.setRepeatCount(0);
        r104.setRepeatMode(1);
    L8:
        g.a(r103, r102.f466569d, r102.f466570e, r102.f466571f, r102.f466572g);
        SparseArray<List<Animator>> r105 = this.f466558a;
        List<Animator> r106 = r105.get(0);
        if (r106 != null) goto L12;
        r106 = new ArrayList();
        r105.put(0, r106);
    L12:
        r106.add(r103);
    }
}
