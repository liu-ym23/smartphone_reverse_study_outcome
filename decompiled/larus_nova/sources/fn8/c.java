package fn8;

import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaKind;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f477946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f477947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RichMediaKind f477948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f477949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f477950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f477951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f477952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final b f477953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f477954i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f477946a, r101.f477946a) == true) goto L12;
        return false;
    L12:
        if (this.f477947b == r101.f477947b) goto L15;
        return false;
    L15:
        if (this.f477948c == r101.f477948c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f477949d, r101.f477949d) == true) goto L21;
        return false;
    L21:
        if (this.f477950e == r101.f477950e) goto L24;
        return false;
    L24:
        if (this.f477951f == r101.f477951f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f477952g, r101.f477952g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f477953h, r101.f477953h) == true) goto L33;
        return false;
    L33:
        if (this.f477954i == r101.f477954i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((this.f477946a.hashCode() * 31) + this.f477947b) * 31) + this.f477948c.hashCode()) * 31) + this.f477949d.hashCode()) * 31) + this.f477950e) * 31) + this.f477951f) * 31) + this.f477952g.hashCode()) * 31) + this.f477953h.hashCode()) * 31;
        if (this.f477954i == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "RichMediaItemUiModel(stableKey=" + this.f477946a + ", mediaType=" + this.f477947b + ", mediaKind=" + this.f477948c + ", coverUrl=" + this.f477949d + ", mediaWidth=" + this.f477950e + ", mediaHeight=" + this.f477951f + ", bizTag=" + this.f477952g + ", source=" + this.f477953h + ", holdForNoWatermark=" + this.f477954i + ')';
    }

    public /* synthetic */ c(String r110, int r111, RichMediaKind r112, String r113, int r114, int r115, String r116, b r117) {
        this(r110, r111, r112, r113, r114, r115, r116, r117, false);
    }

    public c(String r100, int r101, RichMediaKind r102, String r103, int r104, int r105, String r106, b r107, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "stableKey");
        Intrinsics.checkNotNullParameter(r102, "mediaKind");
        Intrinsics.checkNotNullParameter(r103, "coverUrl");
        Intrinsics.checkNotNullParameter(r106, "bizTag");
        Intrinsics.checkNotNullParameter(r107, "source");
        this.f477946a = r100;
        this.f477947b = r101;
        this.f477948c = r102;
        this.f477949d = r103;
        this.f477950e = r104;
        this.f477951f = r105;
        this.f477952g = r106;
        this.f477953h = r107;
        this.f477954i = r110;
    }
}
