package d18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements e18.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f466416a;

    @Override // e18.a
    public final int getItemsCount() {
        return 2;
    }

    public a(String[] r100) {
        Intrinsics.checkNotNullParameter(r100, "mAMPMArray");
        this.f466416a = r100;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final String getItem(int r100) {
        if (r100 >= 0) goto L4;
    L7:
        return "";
    L4:
        if (r100 > 1) goto L7;
        return this.f466416a[r100];
    }

    @Override // e18.a
    public final int indexOf(String r100) {
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return !Intrinsics.areEqual(r101, this.f466416a[0]) ? 1 : 0;
    }
}
