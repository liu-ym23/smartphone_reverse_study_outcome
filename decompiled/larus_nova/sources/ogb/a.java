package ogb;

import com.ss.android.lark.chat.preview.entity.component.property.DocImageProperty;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DocImageProperty f523230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public File f523231b;

    public a() {
        this(null, 3);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f523230a, r101.f523230a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f523231b, r101.f523231b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        DocImageProperty r100 = this.f523230a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        File r104 = this.f523231b;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "FlowYunPanImagePhotoItem(docImageProperty=" + this.f523230a + ", showFile=" + this.f523231b + ')';
    }

    public a(DocImageProperty r100, int r101) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this.f523230a = r100;
        this.f523231b = null;
    }
}
