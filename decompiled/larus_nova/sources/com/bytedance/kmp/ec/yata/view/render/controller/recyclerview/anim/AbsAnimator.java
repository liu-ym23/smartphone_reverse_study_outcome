package com.bytedance.kmp.ec.yata.view.render.controller.recyclerview.anim;

import android.view.ViewPropertyAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimateType f251905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerViewItemAnimator f251906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f251907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<RecyclerView.ViewHolder> f251908d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f251909a = null;

        static {
            int[] r100 = new int[AnimateType.values().length];
            r100[AnimateType.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[AnimateType.MOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[AnimateType.REMOVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f251909a = r100;
        }
    }

    public abstract ViewPropertyAnimator e(RecyclerView.ViewHolder r100);

    public abstract void h(RecyclerView.ViewHolder r100);

    public final boolean f() {
        if ((!this.f251907c.isEmpty()) == false) goto L5;
        return true;
    L5:
        if ((!this.f251908d.isEmpty()) == true) goto L10;
        return false;
    L10:
        return true;
    }

    public final void g() {
        if (this.f251907c.isEmpty() == false) goto L5;
        return;
    L5:
        String r100 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$runPendingAnimations$1(this));
        List r101 = CollectionsKt.toList(this.f251907c);
        this.f251907c.clear();
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        final RecyclerView.ViewHolder r103 = (RecyclerView.ViewHolder) r102.next();
        String r104 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$handleAnimateImpl$1(this, r103));
        this.f251908d.add(r103);
        final ViewPropertyAnimator r105 = e(r103);
        r105.setListener(new AbsAnimator$handleAnimateImpl$2(this, r103, r105)).start();
        goto L7
    }

    public final void d() {
        if (f() == true) goto L6;
        String r100 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$endAnimations$1(this));
        return;
    L6:
        String r101 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$endAnimations$2(this));
        List r102 = CollectionsKt.toList(this.f251907c);
        this.f251907c.clear();
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        RecyclerView.ViewHolder r104 = (RecyclerView.ViewHolder) r103.next();
        h(r104);
        this.f251906b.dispatchAddFinished(r104);
        goto L8
    L10:
        Iterator r105 = CollectionsKt.toList(this.f251908d).iterator();
    L12:
        if (r105.hasNext() == false) goto L16;
        ViewPropertyAnimator r106 = ((RecyclerView.ViewHolder) r105.next()).itemView.animate();
        if (r106 == null) goto L12;
        r106.cancel();
        goto L12
    }

    public final void b(RecyclerView.ViewHolder r100) {
        int r101 = a.f251909a[this.f251905a.ordinal()];
        if (r101 != 1) goto L5;
        this.f251906b.dispatchAddFinished(r100);
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f251906b.dispatchMoveFinished(r100);
        return;
    L7:
        if (r101 == 3) goto L9;
        String r102 = YaTaLog.f251436a;
        YaTaLog.b("RecyclerViewItemAnimator-AbsAnimator", "仅支持ADD、MOVE、REMOVE动画，不支持" + this.f251905a);
        return;
    L9:
        this.f251906b.dispatchRemoveFinished(r100);
    }

    public final void c(final RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        r100.itemView.animate().cancel();
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L8;
        if (this.f251908d.contains(r100) == false) goto L8;
        YaTaLog.b("RecyclerViewItemAnimator-AbsAnimator", "after animation is cancelled, item should not be in progressing");
    L8:
        if (this.f251907c.remove(r100) == false) goto L10;
    L11:
        String r101 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$endAnimation$1(this, r100));
        h(r100);
        this.f251906b.dispatchAddFinished(r100);
        return;
    L10:
        if (this.f251908d.remove(r100) == true) goto L11;
    }

    public AbsAnimator(AnimateType r100, RecyclerViewItemAnimator r101) {
        Intrinsics.checkNotNullParameter(r100, "animateType");
        Intrinsics.checkNotNullParameter(r101, "viewItemAnimator");
        this.f251905a = r100;
        this.f251906b = r101;
        this.f251907c = new ArrayList();
        this.f251908d = new ArrayList();
    }

    public final boolean a(final RecyclerView.ViewHolder r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r102, "setAnimStartStateAction");
        this.f251906b.endAnimation(r100);
        if (r101 == false) goto L6;
        r102.invoke();
        this.f251907c.add(r100);
        String r103 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$animateXXX$1(this, r100));
        return true;
    L6:
        b(r100);
        String r104 = YaTaLog.f251436a;
        YaTaLog.c("RecyclerViewItemAnimator-AbsAnimator", new AbsAnimator$animateXXX$2(this, r100));
        return false;
    }
}
