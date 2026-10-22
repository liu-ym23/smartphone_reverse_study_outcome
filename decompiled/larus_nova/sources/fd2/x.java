package fd2;

import com.bytedance.android.livesdk.message.model.MusicPanel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class x implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f476498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f476499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f476500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MusicPanel f476501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Boolean f476502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f476503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f476504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Boolean f476505h;

    public x() {
        this(null, null, null, null, null, null, null, null, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof x) == false) goto L22;
        x r101 = (x) r100;
        if (Intrinsics.areEqual(this.f476498a, r101.f476498a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f476499b, r101.f476499b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f476500c, r101.f476500c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f476501d, r101.f476501d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f476502e, r101.f476502e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f476503f, r101.f476503f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f476504g, r101.f476504g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f476505h, r101.f476505h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f476498a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f476499b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f476500c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        MusicPanel r110 = this.f476501d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.f476502e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f476503f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f476504g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Boolean r122 = this.f476505h;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "KtvComponentCmd(switch=" + this.f476498a + ", audienceSingEnable=" + this.f476499b + ", source=" + this.f476500c + ", musicPanel=" + this.f476501d + ", showMainDialog=" + this.f476502e + ", showMainDialogEnterFrom=" + this.f476503f + ", openSource=" + this.f476504g + ", isOpenVideoChorus=" + this.f476505h + ")";
    }

    public x(Integer r100, Boolean r101, String r102, MusicPanel r103, Boolean r104, String r105, Integer r106, Boolean r110, int r111) {
        if ((r111 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r104 = Boolean.FALSE;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r111 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r111 & 128) == 0) goto L26;
        r110 = null;
    L26:
        this.f476498a = r100;
        this.f476499b = r101;
        this.f476500c = r102;
        this.f476501d = r103;
        this.f476502e = r104;
        this.f476503f = r105;
        this.f476504g = r106;
        this.f476505h = r110;
    }
}
