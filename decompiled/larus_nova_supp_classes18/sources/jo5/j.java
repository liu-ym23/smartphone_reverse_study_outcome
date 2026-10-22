package jo5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.ui.n;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends a {
    public j() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r9, Response r10, boolean r11) throws IOException {
        int r5 = n.d(5);
        return b(new e(r9, r10, n.d(1), r5, 0, r11));
    }
}
