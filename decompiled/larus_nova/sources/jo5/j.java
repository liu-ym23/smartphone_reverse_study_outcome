package jo5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.util.ui.n;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends a {
    public j() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r100, Response r110, boolean r111) throws IOException {
        int r101 = n.d(5);
        return b(new e(r100, r110, n.d(1), r101, 0, r111));
    }
}
