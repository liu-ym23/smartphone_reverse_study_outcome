package ky8;

import com.larus.canvas.service.bean.InstructionTab;
import com.larus.canvas.service.bean.OptionItem;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InstructionTab f506707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OptionItem f506708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f506709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f506710d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f506711e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f506712f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f506713g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f506714h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<InstructionTab> f506715i;

    public i() {
        this(null, null, null, false, null, null, 0, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f506707a, r101.f506707a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f506708b, r101.f506708b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f506709c, r101.f506709c) == true) goto L18;
        return false;
    L18:
        if (this.f506710d == r101.f506710d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f506711e, r101.f506711e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f506712f, r101.f506712f) == true) goto L27;
        return false;
    L27:
        if (this.f506713g == r101.f506713g) goto L30;
        return false;
    L30:
        if (this.f506714h == r101.f506714h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f506715i, r101.f506715i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        InstructionTab r100 = this.f506707a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        OptionItem r104 = this.f506708b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f506709c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f506710d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        String r112 = this.f506711e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        String r115 = this.f506712f;
        if (r115 != null) goto L25;
        int r116 = 0;
    L26:
        int r117 = (r114 + r116) * 31;
        long r118 = this.f506713g;
        int r119 = (((r117 + ((int) (r118 ^ (r118 >>> 32)))) * 31) + this.f506714h) * 31;
        List<InstructionTab> r120 = this.f506715i;
        if (r120 == null) goto L31;
        r101 = r120.hashCode();
    L31:
        return r119 + r101;
    L25:
        r116 = r115.hashCode();
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputDataSnapShot(clickInstructionTab=" + this.f506707a + ", clickOptionItem=" + this.f506708b + ", inputContent=" + this.f506709c + ", isRegenerate=" + this.f506710d + ", scene=" + this.f506711e + ", instructionTraceContent=" + this.f506712f + ", createTime=" + this.f506713g + ", generateType=" + this.f506714h + ", instructionTabList=" + this.f506715i + ')';
    }

    public final String a() {
        String r100 = this.f506709c;
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        if (r100.length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L21;
        OptionItem r102 = this.f506708b;
        if (r102 == null) goto L13;
        r100 = r102.getMessageText();
        goto L21
    L13:
        InstructionTab r103 = this.f506707a;
        if (r103 == null) goto L20;
        OptionItem r104 = r103.getSingleOption();
        if (r104 == null) goto L18;
        r100 = r104.getMessageText();
    L19:
        if (r100 != null) goto L21;
    L18:
        r100 = null;
    L20:
        r100 = "";
    L21:
        if (r100 != null) goto L24;
        return "";
    L24:
        return r100;
    L8:
        r101 = false;
        goto L9
    }

    public final boolean c() {
        InstructionTab r100 = this.f506707a;
        if (r100 == null) goto L10;
        Integer r101 = r100.getTabType();
        if (r101 == null) goto L10;
        if (r101.intValue() != 4) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L25;
        InstructionTab r103 = this.f506707a;
        if (r103 == null) goto L20;
        Integer r104 = r103.getTabType();
        if (r104 == null) goto L20;
        if (r104.intValue() != 3) goto L20;
        boolean r105 = true;
    L21:
        if (r105 == true) goto L26;
        return false;
    L26:
        return true;
    L20:
        r105 = false;
        goto L21
    L25:
        return true;
    L10:
        r102 = false;
        goto L11
    }

    public final Long b() {
        if (c() == false) goto L12;
        InstructionTab r100 = this.f506707a;
        if (r100 == null) goto L9;
        OptionItem r101 = r100.getSingleOption();
        if (r101 == null) goto L9;
    L14:
        return Long.valueOf(r101.getId());
    L9:
        r101 = this.f506708b;
        if (r101 != null) goto L14;
    L12:
        return null;
    }

    public i(InstructionTab r100, OptionItem r101, String r102, boolean r103, String r104, String r110, int r111, List r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = false;
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r113 & 32) == 0) goto L21;
        r110 = null;
    L21:
        if ((r113 & 64) == 0) goto L23;
        long r105 = System.currentTimeMillis();
    L25:
        if ((r113 & 128) == 0) goto L28;
        r111 = 1;
    L28:
        if ((r113 & 256) == 0) goto L30;
        r112 = null;
    L30:
        this.f506707a = r100;
        this.f506708b = r101;
        this.f506709c = r102;
        this.f506710d = r103;
        this.f506711e = r104;
        this.f506712f = r110;
        this.f506713g = r105;
        this.f506714h = r111;
        this.f506715i = r112;
        return;
    L23:
        r105 = 0;
        goto L25
    }
}
