package md3;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.ugc.aweme.search.vision.model.data.PhotoEnterModel;

/* JADX INFO: loaded from: classes13.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f513277a = 0;

    static {
    }

    public static String a(String r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r101 != null) goto L7;
        return r100;
    L7:
        Uri.Builder r102 = UriProtector.parse(r100).buildUpon();
        r102.appendQueryParameter(PhotoEnterModel.SOURCE_BTM_TOKEN, r101);
        return r102.toString();
    }
}
