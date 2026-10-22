package lt;

import android.view.ViewGroup;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f510633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f510634b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f510635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewGroup.LayoutParams f510636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup.LayoutParams f510637e;

    public /* synthetic */ b(int r100, boolean r110, ViewGroup.LayoutParams r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        int r101 = 0;
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        boolean r103 = true;
    L14:
        this(r101, r102, r103, null, r111);
        return;
    L13:
        r103 = r110;
        goto L14
    L9:
        r102 = 80;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public b(int r100, int r101, boolean r102, ViewGroup.LayoutParams r103, ViewGroup.LayoutParams r104) {
        Intrinsics.checkNotNullParameter(r104, "bottomContainerParams");
        this.f510633a = r100;
        this.f510634b = r101;
        this.f510635c = r102;
        this.f510636d = r103;
        this.f510637e = r104;
    }
}
