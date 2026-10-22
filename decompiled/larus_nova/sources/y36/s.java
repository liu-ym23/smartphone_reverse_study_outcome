package y36;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class s extends i<Uri> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // t36.c
    public final String a() {
        Uri r100 = (Uri) this.f565862b;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.toString();
    }

    public s(Uri r100) {
        super(r100);
    }

    @Override // y36.i
    public final Uri d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "string");
        Uri r101 = UriProtector.parse(r100);
        if (r101.isAbsolute() == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == true) goto L12;
        return null;
    L12:
        return r101;
    L5:
        if (r101.isHierarchical() == false) goto L7;
        r102 = true;
        goto L8
    }

    public s(t36.d r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Intrinsics.checkNotNullParameter(r101, "key");
        super(null);
        b(r100, r101, null);
    }
}
