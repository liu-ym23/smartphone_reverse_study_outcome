package jo5;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.utils.UIHelper;
import java.io.InputStream;
import okhttp3.Response;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h extends jo5.a {

    public static final class a {
    }

    static {
    }

    public h() {
    }

    @Override // jo5.g
    public final InputStream a(ThumbGlideUrl r9, Response r10, boolean r11) {
        ViewGroup.LayoutParams r0 = null;
        if (r9 == null) goto L5;
        ImageView r1 = r9.getImageView();
    L6:
        if (r1 == null) goto L8;
        r0 = r1.getLayoutParams();
    L8:
        if (r0 == null) goto L10;
        int r2 = r0.height;
    L11:
        e r3 = new e(r9, r10, 0, (r2 - UIHelper.dp2px(95.0f)) / 2, 0, r11);
        r3.h = true;
        return b(r3);
    L10:
        r2 = 0;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
