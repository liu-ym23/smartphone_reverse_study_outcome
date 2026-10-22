package nv3;

import android.net.Uri;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f520838a = 0;

    static {
    }

    public static boolean a(Uri r100, String r101) {
        if (r100 == null) goto L4;
        String r102 = r100.getScheme();
    L6:
        if (Intrinsics.areEqual(r102, "doubao") == true) goto L8;
    L12:
        return false;
    L8:
        if (Intrinsics.areEqual(r100.getHost(), BytedCertConstant.CertKey.FLOW) == false) goto L12;
        if (Intrinsics.areEqual(r100.getPath(), r101) == false) goto L12;
        return true;
    L4:
        r102 = null;
        goto L6
    }
}
