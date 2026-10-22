package ko5;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    boolean a(Response r100) throws IOException;

    InputStream b(ThumbGlideUrl r100, Response r101, boolean r102) throws IOException;
}
