package wb5;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f558984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f558985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f558986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f558987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f558988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f558989f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f558984a, r101.f558984a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f558985b, r101.f558985b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f558986c, r101.f558986c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f558987d, r101.f558987d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f558988e, r101.f558988e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f558989f, r101.f558989f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        Activity r100 = this.f558984a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f558985b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f558986c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f558987d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f558988e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f558989f;
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
        return "IMAddDocToChatTabViewParams(activity=" + this.f558984a + ", objToken=" + this.f558985b + ", docType=" + this.f558986c + ", objName=" + this.f558987d + ", templateId=" + this.f558988e + ", chatId=" + this.f558989f + ')';
    }

    public final Activity getActivity() {
        return this.f558984a;
    }

    public b(FragmentActivity r100, String r101, String r102, String r103, String r104, String r105) {
        this.f558984a = r100;
        this.f558985b = r101;
        this.f558986c = r102;
        this.f558987d = r103;
        this.f558988e = r104;
        this.f558989f = r105;
    }
}
