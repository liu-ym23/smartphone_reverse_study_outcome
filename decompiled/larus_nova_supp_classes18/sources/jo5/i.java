package jo5;

import android.content.res.Resources;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import fd5.m;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends a {
    public i() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r1, Response r2, boolean r3) {
        String r4 = r1.getSubType();
        if (m.a() == false) goto L5;
        int r5 = rbb.b.e(r4);
    L7:
        if (r1.getImageView() == null) goto L10;
        Resources r6 = r1.getImageView().getResources();
    L14:
        return r6.openRawResource(r5);
    L10:
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity() == null) goto L12;
        r6 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity().getResources();
        goto L14
    L12:
        r6 = null;
        goto L14
    L5:
        r5 = ua5.a.h(r4);
        goto L7
    }
}
