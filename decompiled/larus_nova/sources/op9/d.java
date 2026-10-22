package op9;

import com.larus.photopicker.v2.impl.model.MediaViewType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final mp9.c f524790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f524791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f524792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MediaViewType f524793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f524794e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f524790a, r101.f524790a) == true) goto L12;
        return false;
    L12:
        if (this.f524791b == r101.f524791b) goto L15;
        return false;
    L15:
        if (this.f524792c == r101.f524792c) goto L18;
        return false;
    L18:
        if (this.f524793d == r101.f524793d) goto L21;
        return false;
    L21:
        if (this.f524794e == r101.f524794e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f524790a.hashCode() * 31;
        int r101 = 1231;
        if (this.f524791b == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (((((r100 + r102) * 31) + this.f524792c) * 31) + this.f524793d.hashCode()) * 31;
        if (this.f524794e == true) goto L11;
        r101 = 1237;
    L11:
        return r103 + r101;
    L5:
        r102 = 1237;
        goto L6
    }

    public final String toString() {
        return "UIMediaItem(mediaItem=" + this.f524790a + ", isSelected=" + this.f524791b + ", selectionOrder=" + this.f524792c + ", mediaViewType=" + this.f524793d + ", selectableByType=" + this.f524794e + ')';
    }

    public /* synthetic */ d(mp9.c r100, boolean r110, int r111, MediaViewType r112, int r113) {
        if ((r113 & 2) == 0) goto L5;
        boolean r101 = false;
    L7:
        if ((r113 & 4) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r113 & 8) == 0) goto L13;
        r112 = MediaViewType.ITEM;
    L13:
        MediaViewType r103 = r112;
        if ((r113 & 16) == 0) goto L16;
        boolean r104 = true;
    L17:
        this(r100, r101, r102, r103, r104);
        return;
    L16:
        r104 = false;
        goto L17
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public d(mp9.c r100, boolean r101, int r102, MediaViewType r103, boolean r104) {
        Intrinsics.checkNotNullParameter(r100, "mediaItem");
        Intrinsics.checkNotNullParameter(r103, "mediaViewType");
        this.f524790a = r100;
        this.f524791b = r101;
        this.f524792c = r102;
        this.f524793d = r103;
        this.f524794e = r104;
    }

    public static d a(d r100, mp9.c r101, boolean r102, int r103, boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L5;
        r101 = r100.f524790a;
    L5:
        mp9.c r104 = r101;
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.f524791b;
    L8:
        boolean r105 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.f524792c;
    L11:
        int r106 = r103;
        if ((r111 & 8) == 0) goto L14;
        MediaViewType r107 = r100.f524793d;
    L15:
        MediaViewType r108 = r107;
        if ((r111 & 16) == 0) goto L18;
        r110 = r100.f524794e;
    L18:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r104, "mediaItem");
        Intrinsics.checkNotNullParameter(r108, "mediaViewType");
        return new d(r104, r105, r106, r108, r110);
    L14:
        r107 = null;
        goto L15
    }
}
