package f1b;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.bytedance.mt.protector.impl.UriProtector;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends y0b.c {
    public c() {
    }

    @Override // y0b.c
    public final WebResourceResponse a(Uri r100) {
        if (r100 == null) goto L5;
        String r101 = UriProtector.getQueryParameter(r100, "key");
    L6:
        if (r101 == null) goto L14;
        Bitmap r102 = qsb.b.a().v1(r101);
        if (r102 == null) goto L15;
        ByteArrayOutputStream r103 = new ByteArrayOutputStream();
        if (r102.compress(Bitmap.CompressFormat.PNG, 100, r103) == false) goto L16;
        byte[] r104 = r103.toByteArray();
        r103.close();
        return new WebResourceResponse("image/png", Charset.defaultCharset().name(), new ByteArrayInputStream(r104));
    L16:
        return null;
    L15:
        return null;
    L14:
        return null;
    L5:
        r101 = null;
        goto L6
    }
}
