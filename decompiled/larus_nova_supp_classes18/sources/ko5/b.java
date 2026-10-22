package ko5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    boolean a(Response r1) throws IOException;

    InputStream b(ThumbGlideUrl r1, Response r2, boolean r3) throws IOException;
}
