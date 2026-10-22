package wb5;

import android.content.Context;
import com.larksuite.framework.callback.OnUpdateProgressListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f559003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f559004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f559005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f559006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final OnUpdateProgressListener f559007e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f559003a, r101.f559003a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f559004b, r101.f559004b) == true) goto L15;
        return false;
    L15:
        if (this.f559005c == r101.f559005c) goto L18;
        return false;
    L18:
        if (this.f559006d == r101.f559006d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f559007e, r101.f559007e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Context r100 = this.f559003a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f559004b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        int r107 = 1231;
        if (this.f559005c == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f559006d == true) goto L18;
        r107 = 1237;
    L18:
        int r110 = (r109 + r107) * 31;
        OnUpdateProgressListener r111 = this.f559007e;
        if (r111 == null) goto L23;
        r101 = r111.hashCode();
    L23:
        return r110 + r101;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "UploadEncryptImageParams(context=" + this.f559003a + ", photoPath=" + this.f559004b + ", keepOrigin=" + this.f559005c + ", isPost=" + this.f559006d + ", progressListener=" + this.f559007e + ')';
    }

    public final Context getContext() {
        return this.f559003a;
    }

    public e(Context r100, String r101) {
        this.f559003a = r100;
        this.f559004b = r101;
        this.f559005c = true;
        this.f559006d = true;
        this.f559007e = null;
    }
}
