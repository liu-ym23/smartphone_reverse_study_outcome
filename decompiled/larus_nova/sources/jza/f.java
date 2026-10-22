package jza;

import com.ss.android.lark.biz.officesdk.im.file.OpenFeishuFileSecurityUiType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OpenFeishuFileSecurityUiType f501227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f501228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f501229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f501230d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f501231e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (this.f501227a == r101.f501227a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f501228b, r101.f501228b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f501229c, r101.f501229c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f501230d, r101.f501230d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f501231e, r101.f501231e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f501227a.hashCode() * 31;
        String r101 = this.f501228b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f501229c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f501230d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f501231e;
        if (r111 == null) goto L19;
        r102 = r111.hashCode();
    L19:
        return r110 + r102;
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
        return "OpenFeishuFileSecurityUiConfig(type=" + this.f501227a + ", title=" + this.f501228b + ", message=" + this.f501229c + ", confirmText=" + this.f501230d + ", cancelText=" + this.f501231e + ')';
    }

    public f() {
        OpenFeishuFileSecurityUiType r100 = OpenFeishuFileSecurityUiType.TOAST;
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f501227a = r100;
        this.f501228b = null;
        this.f501229c = null;
        this.f501230d = null;
        this.f501231e = null;
    }

    public final OpenFeishuFileSecurityUiType getType() {
        return this.f501227a;
    }
}
