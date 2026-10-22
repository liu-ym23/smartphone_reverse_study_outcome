package ko5;

import android.text.TextUtils;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import java.io.IOException;
import java.io.InputStream;
import jo5.c;
import jo5.d;
import jo5.f;
import jo5.g;
import jo5.h;
import jo5.i;
import jo5.j;
import jo5.k;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements b {
    public a() {
    }

    @Override // ko5.b
    public final boolean a(Response r100) throws IOException {
        return TextUtils.equals(r100.header("access-new-default-thumbnail"), "true");
    }

    @Override // ko5.b
    public final InputStream b(ThumbGlideUrl r100, Response r101, boolean r102) throws IOException {
        if (TextUtils.equals(r100.getSource(), "chat") == false) goto L6;
        g r103 = new c();
    L25:
        return r103.a(r100, r101, r102);
    L6:
        if (TextUtils.equals(r100.getSource(), "announcement") == false) goto L9;
        r103 = new jo5.b();
        goto L25
    L9:
        if (TextUtils.equals(r100.getSource(), ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L12;
        r103 = new j();
        goto L25
    L12:
        if (TextUtils.equals(r100.getSource(), ThumbGlideUrl.SOURCE_VC) == false) goto L15;
        r103 = new k();
        goto L25
    L15:
        if (TextUtils.equals(r100.getSource(), ThumbGlideUrl.SOURCE_SPACE_LIST_ICON) == false) goto L18;
        r103 = new i();
        goto L25
    L18:
        if (TextUtils.equals(r100.getSource(), ThumbGlideUrl.SOURCE_FOLDER_BLOCK_ICON) == false) goto L21;
        r103 = new d();
        goto L25
    L21:
        if (TextUtils.equals(r100.getSource(), "search") == false) goto L23;
        r103 = new h();
        goto L25
    L23:
        r103 = new f();
        goto L25
    }
}
