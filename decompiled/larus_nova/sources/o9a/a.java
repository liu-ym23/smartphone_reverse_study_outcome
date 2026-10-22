package o9a;

import com.obric.aiagent.assistant_card.provider_core.IHostApiCallback;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f522487g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522490c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f522491d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IHostApiCallback f522492e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IHostApiCallback f522493f;

    /* JADX INFO: renamed from: o9a.a$a, reason: collision with other inner class name */
    public static final class C7025a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f522488a, r101.f522488a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522489b, r101.f522489b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522490c, r101.f522490c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522491d, r101.f522491d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522492e, r101.f522492e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f522493f, r101.f522493f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f522488a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f522489b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f522490c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f522491d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        IHostApiCallback r113 = this.f522492e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        IHostApiCallback r116 = this.f522493f;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
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
        return "DialogBean(title=" + this.f522488a + ", message=" + this.f522489b + ", cancelText=" + this.f522490c + ", confirmText=" + this.f522491d + ", cancelClickListener=" + this.f522492e + ", confirmClickListener=" + this.f522493f + ')';
    }

    public a(String r100, String r101, String r102, String r103, IHostApiCallback r104, IHostApiCallback r105) {
        this.f522488a = r100;
        this.f522489b = r101;
        this.f522490c = r102;
        this.f522491d = r103;
        this.f522492e = r104;
        this.f522493f = r105;
    }
}
