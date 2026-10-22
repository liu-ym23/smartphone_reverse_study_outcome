package nk9;

import android.graphics.Rect;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class l<T> implements Comparator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f519501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<T, Rect> f519502b;

    /* JADX WARN: Multi-variable type inference failed */
    public l(int r100, Function1<? super T, Rect> r101) {
        Intrinsics.checkNotNullParameter(r101, "rectAdapter");
        this.f519501a = r100;
        this.f519502b = r101;
    }

    @Override // java.util.Comparator
    public final int compare(T r100, T r101) {
        Rect r102 = this.f519502b.invoke(r100);
        Rect r103 = this.f519502b.invoke(r101);
        int r104 = r102.left - r103.left;
        int r105 = r102.top - r103.top;
        if (this.f519501a != 0) goto L7;
        if (r104 == 0) goto L6;
        return r104;
    L6:
        return r105;
    L7:
        if (r105 != 0) goto L10;
        return r104;
    L10:
        return r105;
    }
}
