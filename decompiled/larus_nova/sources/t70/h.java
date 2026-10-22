package t70;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes45.dex */
public final /* synthetic */ class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f544866a = null;

    static {
        int[] r100 = new int[Lifecycle.State.values().length];
        f544866a = r100;
        r100[Lifecycle.State.INITIALIZED.ordinal()] = 1;
        r100[Lifecycle.State.DESTROYED.ordinal()] = 2;
        r100[Lifecycle.State.CREATED.ordinal()] = 3;
        r100[Lifecycle.State.STARTED.ordinal()] = 4;
        r100[Lifecycle.State.RESUMED.ordinal()] = 5;
    }
}
