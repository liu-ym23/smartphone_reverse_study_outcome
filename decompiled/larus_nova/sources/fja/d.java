package fja;

import android.view.Choreographer;
import android.view.View;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f477533d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f477534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public fja.a f477535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f477536c;

    public static final class a {
    }

    static {
        new mja.b();
    }

    public d() {
        this.f477534a = new c();
        int r100 = f477533d;
        f477533d = r100 + 1;
        this.f477536c = r100;
    }

    public final void a(boolean r100) {
        mja.a.C6822a r101 = mja.a.f514263a;
        mja.a.d("AnimationManager", "cancel, instanceId: [" + this.f477536c + "], clearVelocity: " + r100);
        fja.a r102 = this.f477535b;
        if (r102 == null) goto L9;
        mja.a.c("cancelAnimation, clearVelocity: " + r100);
        Choreographer.getInstance().removeFrameCallback(r102.f477513a);
        r102.f477514b.a(r100);
        Function2<? super Boolean, ? super Throwable, Unit> r103 = r102.f477516d;
        if (r103 == null) goto L7;
        Unit r104 = r103.invoke(Boolean.FALSE, null);
    L7:
        mja.a.a("AnimatableRunner", "releaseCallbacks, scene: ".concat("cancelAnimation"));
        r102.f477515c = null;
        r102.f477516d = null;
        return;
    }

    public final void b(float r110, boolean r111, View r210, RunMode r211, float r212, RepeatMode r213, List<? extends bja.a<?>> r214, Function3<? super String, Object, ? super Float, Unit> r215, Function2<? super Boolean, ? super Throwable, Unit> r216) {
        mja.a.C6822a r100 = mja.a.f514263a;
        StringBuilder r101 = new StringBuilder("start, instanceId: [");
        r101.append(this.f477536c);
        r101.append("], runAnimation, mode: ");
        r101.append(r211);
        r101.append(", speed: ");
        r101.append(r212);
        r101.append(", repeatMode: ");
        r101.append(r213);
        r101.append(", animationInfos: ");
        List<? extends bja.a<?>> r102 = r214;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        bja.a r105 = (bja.a) r104.next();
        r105.getClass();
        r103.add("AnimationInfo(property: " + r105.f19258e + ", initialValue: " + r105.f19259f + ", targetValue: " + r105.f19260g + ", spec: " + r105.f19261h.dump() + ", initialVelocity: " + r105.f19262i + ", valueClass: " + r105.f19263j + ", currentVelocity: " + r105.f19264k + ", durationNanos: " + r105.f19254a + ", firstFrameTimeNanos: " + r105.f19255b + ", lastFrameTimeNanos: " + r105.f19256c + ", isRunning: " + r105.f19257d + ')');
        goto L4
    L6:
        r101.append(CollectionsKt.joinToString$default(r103, "\n", null, null, 0, null, null, 62, null));
        mja.a.d("AnimationManager", r101.toString());
        c r106 = this.f477534a;
        r106.f477521b = r110;
        Intrinsics.checkNotNullParameter(r211, "runMode");
        r106.f477522c = r211;
        c r107 = this.f477534a;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r213, "repeatMode");
        r107.f477523d = r213;
        c r108 = this.f477534a;
        r108.getClass();
        Intrinsics.checkNotNullParameter(r214, "animationInfos");
        r108.f477524e = r214;
        c r109 = this.f477534a;
        r109.getClass();
        if (r210 == null) goto L9;
        boolean r112 = true;
    L10:
        r109.f477531l = r112;
        r109.f477525f = new WeakReference(r210);
        c r113 = this.f477534a;
        r113.f477528i = r212;
        r113.f477532m = r111;
        fja.a r114 = new fja.a(this.f477534a, r215, r216);
        this.f477535b = r114;
        Choreographer.getInstance().postFrameCallback(r114.f477513a);
        return;
    L9:
        r112 = false;
        goto L10
    }
}
