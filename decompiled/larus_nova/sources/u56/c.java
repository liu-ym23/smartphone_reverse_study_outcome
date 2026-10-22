package u56;

import com.bytedance.retrofit2.mime.MimeUtil;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f548843a = 0;

    static {
    }

    public static String a(TypedInput r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof TypedByteArray) == false) goto L17;
        String r101 = "UTF-8";
        if (r100.mimeType() == null) goto L11;
        r101 = MimeUtil.parseCharset(r100.mimeType(), "UTF-8");     // Catch: Throwable -> L14
    L11:
        return new String(((TypedByteArray) r100).getBytes(), Charset.forName(r101));
    L18:
        return null;
    L17:
        return null;
    }
}
