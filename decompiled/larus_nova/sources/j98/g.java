package j98;

import com.larus.avlink.env.diary.feedback.model.DiaryFeedbackToastType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f497814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DiaryFeedbackToastType f497815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f497816c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f497814a == r101.f497814a) goto L12;
        return false;
    L12:
        if (this.f497815b == r101.f497815b) goto L15;
        return false;
    L15:
        if (this.f497816c == r101.f497816c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f497814a * 31) + this.f497815b.hashCode()) * 31;
        long r101 = this.f497816c;
        return r100 + ((int) (r101 ^ (r101 >>> 32)));
    }

    public final String toString() {
        return "DiaryFeedbackToastEffect(messageRes=" + this.f497814a + ", toastType=" + this.f497815b + ", effectId=" + this.f497816c + ')';
    }

    public g(int r100, DiaryFeedbackToastType r101) {
        long r102 = System.nanoTime();
        Intrinsics.checkNotNullParameter(r101, "toastType");
        this.f497814a = r100;
        this.f497815b = r101;
        this.f497816c = r102;
    }
}
