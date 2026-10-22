package ul7;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f550611a = 0;

    static {
    }

    @JvmStatic
    public static final String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Uri r101 = UriProtector.parse(r100);
        return Intrinsics.stringPlus(r101.getHost(), r101.getPath());
    }

    @JvmStatic
    public static final String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return "";
    L6:
        Uri r101 = UriProtector.parse(r100);
        String r102 = UriProtector.getQueryParameter(r101, "surl");
        if (TextUtils.isEmpty(r102) == true) goto L10;
        return r102;
    L10:
        return UriProtector.getQueryParameter(r101, "url");
    }
}
