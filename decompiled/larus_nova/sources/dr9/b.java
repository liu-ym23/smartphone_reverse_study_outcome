package dr9;

import com.larus.platform.model.preview.MediaEntry;
import com.larus.platform.model.preview.MediaEntryScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaEntryScene f469781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaEntry f469782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f469783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f469784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f469785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f469786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f469787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f469788h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f469781a == r101.f469781a) goto L12;
        return false;
    L12:
        if (this.f469782b == r101.f469782b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f469783c, r101.f469783c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f469784d, r101.f469784d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f469785e, r101.f469785e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f469786f, r101.f469786f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f469787g, r101.f469787g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f469788h, r101.f469788h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f469781a.hashCode() * 31) + this.f469782b.hashCode()) * 31) + this.f469783c.hashCode()) * 31;
        String r101 = this.f469784d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Integer r105 = this.f469785e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f469786f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f469787g;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        c r114 = this.f469788h;
        if (r114 == null) goto L23;
        r102 = r114.hashCode();
    L23:
        return r113 + r102;
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MediaEntryContext(scene=" + this.f469781a + ", entry=" + this.f469782b + ", sourceNodeId=" + this.f469783c + ", conversationId=" + this.f469784d + ", botConversationType=" + this.f469785e + ", instructionType=" + this.f469786f + ", cameraScene=" + this.f469787g + ", hostAbility=" + this.f469788h + ')';
    }

    public b(MediaEntryScene r100, MediaEntry r101, String r102, String r103, Integer r104, c r105, int r106) {
        if ((r106 & 8) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 32) == 0) goto L9;
        r104 = null;
    L9:
        if ((r106 & 128) == 0) goto L11;
        r105 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "entry");
        Intrinsics.checkNotNullParameter(r102, "sourceNodeId");
        this.f469781a = r100;
        this.f469782b = r101;
        this.f469783c = r102;
        this.f469784d = r103;
        this.f469785e = null;
        this.f469786f = r104;
        this.f469787g = null;
        this.f469788h = r105;
    }
}
