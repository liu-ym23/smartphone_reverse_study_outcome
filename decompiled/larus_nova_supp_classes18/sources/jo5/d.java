package jo5;

import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends jo5.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // jo5.a
    public final InputStream b(e r10) {
        Intrinsics.checkNotNullParameter(r10, "param");
        tt5.a.h("FolderBlockDefaultImgFileProvider", "getDefaultPlaceHolder");
        Response r1 = r10.b;
        if (r1 == null) goto L5;
        int r2 = r1.code();
    L6:
        ThumbGlideUrl r3 = r10.a;
        byte[] r4 = null;
        if (r3 != null) goto L9;
        return null;
    L9:
        boolean r6 = true;
        if ((r2 / 100) != 3) goto L26;
        tt5.a.h("FolderBlockDefaultImgFileProvider", "statusCode=" + r2 + ", use cache， need not decrypt");
        String r11 = r3.getEncryptCacheKey();
        if (TextUtils.isEmpty(r11) == true) goto L17;
        aw4.a r0 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r0 == null) goto L17;
        r4 = (byte[]) r0.get(r11);
    L17:
        if (r4 != null) goto L19;
    L23:
        ho5.c.d().h(r3.getUrl(), r3.getVersion());
    L25:
        return new ByteArrayInputStream(r4);
    L19:
        if (r4.length == 0) goto L22;
        r6 = false;
    L22:
        if (r6 == false) goto L25;
    L26:
        if (r1 == null) goto L28;
        ResponseBody r5 = r1.body();
    L29:
        if (r5 != null) goto L32;
        tt5.a.d("FolderBlockDefaultImgFileProvider", "response.body() == null");
        return null;
    L32:
        ResponseBody r7 = r1.body();
        if (r7 == null) goto L35;
        byte[] r8 = r7.bytes();
    L37:
        if (r10.g == false) goto L50;
        tt5.a.d("FolderBlockDefaultImgFileProvider", "url is encrypt, decode data");
        int r12 = r3.getDecodeType();
        String r9 = r3.getDecodeKey();
        String r13 = r3.getDecodeNonce();
        if (r12 != 1) goto L42;
        io5.c r14 = new io5.b();
    L47:
        if (r14 == null) goto L50;
        byte[] r15 = r14.a(r9, r13, r8);
    L51:
        if (r15 != null) goto L59;
        StringBuilder r16 = new StringBuilder("decodeData == null, origin data is null = ");
        if (r8 == null) goto L56;
        r6 = false;
    L56:
        r16.append(r6);
        tt5.a.d("FolderBlockDefaultImgFileProvider", r16.toString());
        return null;
    L59:
        return new ByteArrayInputStream(r15);
    L42:
        if (r12 != 2) goto L44;
        r14 = new io5.a();
        goto L47
    L44:
        if (r12 != 3) goto L46;
        r14 = new io5.d();
        goto L47
    L46:
        r14 = null;
    L50:
        r15 = r8;
        goto L51
    L35:
        r8 = null;
        goto L37
    L28:
        r5 = null;
        goto L29
    L5:
        r2 = -1;
        goto L6
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r9, Response r10, boolean r11) {
        return b(new e(r9, r10, 0, 0, 0, r11));
    }
}
