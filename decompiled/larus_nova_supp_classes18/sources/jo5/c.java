package jo5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.ui.n;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends a {
    public c() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r9, Response r10, boolean r11) throws IOException {
        return b(new e(r9, r10, n.d(4), n.d(18), n.d(6), r11));
    }
}
