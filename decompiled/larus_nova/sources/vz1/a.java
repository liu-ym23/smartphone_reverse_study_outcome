package vz1;

import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.CardStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f557635a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f557636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f557637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f557638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f557639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l1 f557640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final n f557641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f557642h;

    public a() {
        this(0, null, 0, null, false, null, null, 0, 255);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (this.f557635a == r101.f557635a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f557636b, r101.f557636b) == true) goto L10;
        return false;
    L10:
        if (this.f557637c == r101.f557637c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f557638d, r101.f557638d) == true) goto L14;
        return false;
    L14:
        if (this.f557639e == r101.f557639e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f557640f, r101.f557640f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f557641g, r101.f557641g) == true) goto L20;
        return false;
    L20:
        if (this.f557642h == r101.f557642h) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    public final int hashCode() {
        int r100 = this.f557635a * 31;
        String r101 = this.f557636b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (((r100 + r103) * 31) + this.f557637c) * 31;
        String r105 = this.f557638d;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        boolean r108 = this.f557639e;
        ?? r109 = r108;
        if (r108 == false) goto L13;
        r109 = 1;
    L13:
        int r110 = (r107 + r109) * 31;
        l1 r111 = this.f557640f;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        n r114 = this.f557641g;
        if (r114 == null) goto L21;
        r102 = r114.hashCode();
    L21:
        return ((r113 + r102) * 31) + this.f557642h;
    L16:
        r112 = 0;
        goto L17
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "CardInfo(locked=" + this.f557635a + ", cell_text=" + this.f557636b + ", diamondCount=" + this.f557637c + ", sendButtonText=" + this.f557638d + ", useCustomSendButtonColor=" + this.f557639e + ", buffInfo=" + this.f557640f + ", diyInfo=" + this.f557641g + ", selectedStyle=" + this.f557642h + ")";
    }

    public a(int r100, String r101, int r102, String r103, boolean r104, l1 r105, n r110, int r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = CardStatus.INSTANCE.getUNLOCK();
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = 0;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = "";
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = false;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r110 = null;
    L24:
        if ((r112 & 128) == 0) goto L26;
        r111 = 0;
    L26:
        Intrinsics.checkNotNullParameter(r103, "sendButtonText");
        this.f557635a = r100;
        this.f557636b = r101;
        this.f557637c = r102;
        this.f557638d = r103;
        this.f557639e = r104;
        this.f557640f = r105;
        this.f557641g = r110;
        this.f557642h = r111;
    }
}
