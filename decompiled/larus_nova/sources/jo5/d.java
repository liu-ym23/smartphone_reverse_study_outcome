package jo5;

import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends jo5.a {

    public static final class a {
    }

    static {
    }

    public d() {
    }

    @Override // jo5.a
    public final InputStream b(e r110) {
        Intrinsics.checkNotNullParameter(r110, "param");
        tt5.a.h("FolderBlockDefaultImgFileProvider", "getDefaultPlaceHolder");
        Response r100 = r110.f499898b;
        if (r100 == null) goto L5;
        int r101 = r100.code();
    L6:
        ThumbGlideUrl r102 = r110.f499897a;
        byte[] r103 = null;
        if (r102 != null) goto L9;
        return null;
    L9:
        boolean r104 = true;
        if ((r101 / 100) != 3) goto L26;
        tt5.a.h("FolderBlockDefaultImgFileProvider", "statusCode=" + r101 + ", use cache， need not decrypt");
        String r111 = r102.getEncryptCacheKey();
        if (TextUtils.isEmpty(r111) == true) goto L17;
        aw4.a r105 = (aw4.a) org.koin.java.a.a(aw4.a.class);
        if (r105 == null) goto L17;
        r103 = (byte[]) r105.get(r111);
    L17:
        if (r103 != null) goto L19;
    L23:
        ho5.c.d().h(r102.getUrl(), r102.getVersion());
    L25:
        return new ByteArrayInputStream(r103);
    L19:
        if (r103.length == 0) goto L22;
        r104 = false;
    L22:
        if (r104 == false) goto L25;
    L26:
        if (r100 == null) goto L28;
        ResponseBody r106 = r100.body();
    L29:
        if (r106 != null) goto L32;
        tt5.a.d("FolderBlockDefaultImgFileProvider", "response.body() == null");
        return null;
    L32:
        ResponseBody r107 = r100.body();
        if (r107 == null) goto L35;
        byte[] r108 = r107.bytes();
    L37:
        if (r110.f499903g == false) goto L50;
        tt5.a.d("FolderBlockDefaultImgFileProvider", "url is encrypt, decode data");
        int r112 = r102.getDecodeType();
        String r109 = r102.getDecodeKey();
        String r113 = r102.getDecodeNonce();
        if (r112 != 1) goto L42;
        io5.c r114 = new io5.b();
    L47:
        if (r114 == null) goto L50;
        byte[] r115 = r114.a(r109, r113, r108);
    L51:
        if (r115 != null) goto L59;
        StringBuilder r116 = new StringBuilder("decodeData == null, origin data is null = ");
        if (r108 == null) goto L56;
        r104 = false;
    L56:
        r116.append(r104);
        tt5.a.d("FolderBlockDefaultImgFileProvider", r116.toString());
        return null;
    L59:
        return new ByteArrayInputStream(r115);
    L42:
        if (r112 != 2) goto L44;
        r114 = new io5.a();
        goto L47
    L44:
        if (r112 != 3) goto L46;
        r114 = new io5.d();
        goto L47
    L46:
        r114 = null;
    L50:
        r115 = r108;
        goto L51
    L35:
        r108 = null;
        goto L37
    L28:
        r106 = null;
        goto L29
    L5:
        r101 = -1;
        goto L6
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r100, Response r110, boolean r111) {
        return b(new e(r100, r110, 0, 0, 0, r111));
    }
}
