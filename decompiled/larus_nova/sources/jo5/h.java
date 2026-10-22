package jo5;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.UIHelper;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: classes18.dex */
public final class h extends jo5.a {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r100, Response r110, boolean r111) {
        ViewGroup.LayoutParams r101 = null;
        if (r100 == null) goto L5;
        ImageView r102 = r100.getImageView();
    L6:
        if (r102 == null) goto L8;
        r101 = r102.getLayoutParams();
    L8:
        if (r101 == null) goto L10;
        int r103 = r101.height;
    L11:
        e r104 = new e(r100, r110, 0, (r103 - UIHelper.dp2px(95.0f)) / 2, 0, r111);
        r104.f499904h = true;
        return b(r104);
    L10:
        r103 = 0;
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
