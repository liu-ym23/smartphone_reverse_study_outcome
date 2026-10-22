package xy8;

import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocalMediaType f565423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f565424b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f565425c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f565423a == r101.f565423a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f565424b, r101.f565424b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f565425c, r101.f565425c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f565423a.hashCode() * 31;
        String r101 = this.f565424b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f565425c;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "LocalMediaResource(type=" + this.f565423a + ", primaryUri=" + this.f565424b + ", primaryPath=" + this.f565425c + ')';
    }

    public final LocalMediaType getType() {
        return this.f565423a;
    }

    public c(LocalMediaType r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.f565423a = r100;
        this.f565424b = r101;
        this.f565425c = r102;
    }
}
