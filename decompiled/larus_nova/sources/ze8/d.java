package ze8;

import com.larus.bmhome.chat.input.swipe.InputContentMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f571562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f571563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f571564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f571565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f571566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f571567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f571568g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c f571569h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final InputContentMode f571570i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f571562a, r101.f571562a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f571563b, r101.f571563b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f571564c, r101.f571564c) == true) goto L18;
        return false;
    L18:
        if (this.f571565d == r101.f571565d) goto L21;
        return false;
    L21:
        if (this.f571566e == r101.f571566e) goto L24;
        return false;
    L24:
        if (this.f571567f == r101.f571567f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f571568g, r101.f571568g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f571569h, r101.f571569h) == true) goto L33;
        return false;
    L33:
        if (this.f571570i == r101.f571570i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f571562a.hashCode() * 31) + this.f571563b.hashCode()) * 31;
        String r101 = this.f571564c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((((r100 + r103) * 31) + this.f571565d) * 31) + this.f571566e) * 31;
        if (this.f571567f == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Integer r107 = this.f571568g;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c r110 = this.f571569h;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        InputContentMode r113 = this.f571570i;
        if (r113 == null) goto L23;
        r102 = r113.hashCode();
    L23:
        return r112 + r102;
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "InputContentSpec(key=" + this.f571562a + ", text=" + this.f571563b + ", hint=" + this.f571564c + ", selectionStart=" + this.f571565d + ", selectionEnd=" + this.f571566e + ", showSendButton=" + this.f571567f + ", actionSendImageResId=" + this.f571568g + ", actionVisibility=" + this.f571569h + ", inputMode=" + this.f571570i + ')';
    }

    public d(String r100, String r101, String r102, int r103, int r104, Integer r105, c r106, InputContentMode r110) {
        boolean r107 = !StringsKt.isBlank(r101);
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f571562a = r100;
        this.f571563b = r101;
        this.f571564c = r102;
        this.f571565d = r103;
        this.f571566e = r104;
        this.f571567f = r107;
        this.f571568g = r105;
        this.f571569h = r106;
        this.f571570i = r110;
    }
}
