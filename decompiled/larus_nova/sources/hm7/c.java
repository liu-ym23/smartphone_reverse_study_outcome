package hm7;

import android.graphics.Bitmap;
import com.bytedance.ug.sdk.luckydog.task.tasktimer.view.TimerTaskPendantState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f485943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimerTaskPendantState f485944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f485945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Bitmap f485946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Bitmap f485947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final tk7.a f485948g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L28:
        return true;
    L5:
        if ((r100 instanceof c) == false) goto L27;
        c r101 = (c) r100;
        if (this.f485942a != r101.f485942a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L27;
        if (this.f485943b != r101.f485943b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L27;
        if (Intrinsics.areEqual(this.f485944c, r101.f485944c) == false) goto L27;
        if (Intrinsics.areEqual(this.f485945d, r101.f485945d) == false) goto L27;
        if (Intrinsics.areEqual(this.f485946e, r101.f485946e) == false) goto L27;
        if (Intrinsics.areEqual(this.f485947f, r101.f485947f) == false) goto L27;
        if (Intrinsics.areEqual(this.f485948g, r101.f485948g) == false) goto L27;
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L27:
        return false;
    }

    public final int hashCode() {
        int r100 = ((this.f485942a * 31) + this.f485943b) * 31;
        TimerTaskPendantState r101 = this.f485944c;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        a r105 = this.f485945d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Bitmap r108 = this.f485946e;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Bitmap r111 = this.f485947f;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        tk7.a r114 = this.f485948g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        return r113 + r102;
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "TaskTimerModel(wholeTime=" + this.f485942a + ", doneTime=" + this.f485943b + ", state=" + this.f485944c + ", pendant=" + this.f485945d + ", completeBitmap=" + this.f485946e + ", doingBitmap=" + this.f485947f + ", timerDataModel=" + this.f485948g + ")";
    }

    public c(int r100, int r101, TimerTaskPendantState r102, a r103, Bitmap r104, Bitmap r105, tk7.a r106) {
        this.f485942a = r100;
        this.f485943b = r101;
        this.f485944c = r102;
        this.f485945d = r103;
        this.f485946e = r104;
        this.f485947f = r105;
        this.f485948g = r106;
    }
}
