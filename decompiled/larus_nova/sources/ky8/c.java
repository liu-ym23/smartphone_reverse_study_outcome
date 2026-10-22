package ky8;

import com.larus.canvas.service.bean.ImageObject;
import com.larus.canvas.service.bean.InstructionTab;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f506679a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f506680b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506681c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Long f506682d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f506683e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<InstructionTab> f506684f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageObject f506685g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f506686h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<ImageObject> f506687i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f506688j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f506689k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f506690l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f506691m;

    public c() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f506679a == r101.f506679a) goto L12;
        return false;
    L12:
        if (this.f506680b == r101.f506680b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506681c, r101.f506681c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f506682d, r101.f506682d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506683e, r101.f506683e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506684f, r101.f506684f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f506685g, r101.f506685g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f506686h, r101.f506686h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506687i, r101.f506687i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f506688j, r101.f506688j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f506689k, r101.f506689k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f506690l, r101.f506690l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f506691m, r101.f506691m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f506679a * 31) + this.f506680b) * 31) + this.f506681c.hashCode()) * 31;
        Long r101 = this.f506682d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Long r105 = this.f506683e;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        List<InstructionTab> r108 = this.f506684f;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f506685g.hashCode()) * 31;
        String r111 = this.f506686h;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        List<ImageObject> r114 = this.f506687i;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f506688j;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f506689k;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f506690l;
        if (r123 != null) goto L33;
        int r124 = 0;
    L34:
        int r125 = (r122 + r124) * 31;
        String r126 = this.f506691m;
        if (r126 == null) goto L39;
        r102 = r126.hashCode();
    L39:
        return r125 + r102;
    L33:
        r124 = r123.hashCode();
        goto L34
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "CanvasGenerateParam(canvasType=" + this.f506679a + ", generateType=" + this.f506680b + ", localId=" + this.f506681c + ", canvasId=" + this.f506682d + ", canvasSubId=" + this.f506683e + ", instructionTabList=" + this.f506684f + ", originImage=" + this.f506685g + ", prompt=" + this.f506686h + ", refImages=" + this.f506687i + ", sendMsgId=" + this.f506688j + ", replyMsgId=" + this.f506689k + ", conversationId=" + this.f506690l + ", displayPromptPerRound=" + this.f506691m + ')';
    }

    public c(int r100, String r101, Long r102, Long r103, List r104, ImageObject r105, String r106, String r107, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r101, "localId");
        Intrinsics.checkNotNullParameter(r105, "originImage");
        this.f506679a = 1;
        this.f506680b = r100;
        this.f506681c = r101;
        this.f506682d = r102;
        this.f506683e = r103;
        this.f506684f = r104;
        this.f506685g = r105;
        this.f506686h = r106;
        this.f506687i = null;
        this.f506688j = r107;
        this.f506689k = r110;
        this.f506690l = r111;
        this.f506691m = r112;
    }
}
