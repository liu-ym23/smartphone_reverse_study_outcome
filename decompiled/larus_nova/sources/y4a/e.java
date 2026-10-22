package y4a;

import android.net.Uri;
import com.facebook.common.util.UriUtil;

/* JADX INFO: loaded from: classes32.dex */
public final class e {
    public static String a(String r100) {
        return new Uri.Builder().scheme(UriUtil.LOCAL_ASSET_SCHEME).authority("").path(r100).build().toString();
    }
}
