package d18;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class e implements e18.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String[] f466436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f466437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f466438c;

    public final class a implements e18.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466439a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f466440b;

        @Override // e18.c
        public final String a() {
            int r100 = this.f466440b.getItemsCount();
            int r101 = this.f466439a;
            boolean r102 = true;
            if (r101 < 0) goto L6;
            if (r101 >= r100) goto L6;
            boolean r103 = true;
        L7:
            if (r103 == false) goto L9;
            int r104 = (this.f466440b.f466437b + r101) - 1;
        L10:
            if (r104 >= 0) goto L12;
        L14:
            r102 = false;
        L15:
            if (r102 == true) goto L19;
            return "";
        L19:
            return this.f466440b.f466436a[r104];
        L12:
            if (r104 >= this.f466440b.f466436a.length) goto L14;
        L9:
            r104 = -1;
        L6:
            r103 = false;
            goto L7
        }

        public a(e r100, int r101) {
            this.f466440b = r100;
            this.f466439a = r101;
        }
    }

    @Override // e18.a
    public final int getItemsCount() {
        return (this.f466438c - this.f466437b) + 1;
    }

    @Override // e18.a
    public final int a(Object r100) {
        return e18.a.C5729a.a(this, r100);
    }

    @Override // e18.a
    public final a getItem(int r100) {
        return new a(this, r100);
    }

    @Override // e18.a
    public final int indexOf(a r100) {
        a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "o");
        return r101.f466439a;
    }

    public e(int r100, int r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r102, "monthStringArray");
        this.f466436a = r102;
        this.f466437b = r100;
        this.f466438c = r101;
    }
}
