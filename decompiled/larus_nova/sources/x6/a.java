package x6;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final Uri.Builder a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return UriProtector.parse("sslocal://webcast_webview?hybrid_type=h5").buildUpon().appendQueryParameter("url", r100);
    }

    @JvmStatic
    public static final Uri b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return UriProtector.parse("sslocal://webcast_webview?hybrid_type=h5").buildUpon().appendQueryParameter("url", r100).build();
    }

    @JvmStatic
    public static final Uri.Builder c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter("url", r100);
    }

    @JvmStatic
    public static final Uri d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return UriProtector.parse("sslocal://webcast_lynxview?hybrid_type=lynx").buildUpon().appendQueryParameter("url", r100).build();
    }
}
