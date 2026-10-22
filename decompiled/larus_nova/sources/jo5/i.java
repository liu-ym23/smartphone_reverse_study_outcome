package jo5;

import android.content.res.Resources;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import fd5.m;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class i extends a {
    public i() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r100, Response r101, boolean r102) {
        String r103 = r100.getSubType();
        if (m.a() == false) goto L5;
        int r104 = rbb.b.e(r103);
    L7:
        if (r100.getImageView() == null) goto L10;
        Resources r105 = r100.getImageView().getResources();
    L14:
        return r105.openRawResource(r104);
    L10:
        if (((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity() == null) goto L12;
        r105 = ((com.bytedance.ee.bear.route.h) org.koin.java.a.a(com.bytedance.ee.bear.route.h.class)).getCurrentActivity().getResources();
        goto L14
    L12:
        r105 = null;
        goto L14
    L5:
        r104 = ua5.a.h(r103);
        goto L7
    }
}
