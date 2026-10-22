package lo7;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.nova.R;
import oo7.k;
import oo7.m;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends a {
    public c(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        if (this.f510132a != null) goto L7;
        if (r100 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r100.getCopyUrl()) == false) goto L9;
        String r101 = r100.getTargetUrl();
    L10:
        k.a("CopyLinkShare", "copy url" + r101);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        oo7.d.d(this.f510132a, r101);
        m.a().c("user_copy_content", r101);
        o.a(this.f510132a.getApplicationContext(), r100, 0, R.string.share_sdk_clip_sucess);
        kn7.b.a(10000, r100);
        k.a("CopyLinkShare", "copy url success" + r101);
    L14:
        return true;
    L13:
        o.a(this.f510132a.getApplicationContext(), r100, 1, R.string.share_sdk_clip_failed);
        kn7.b.a(10002, r100);
        k.a("CopyLinkShare", "copy url failed" + r101);
        goto L14
    L9:
        r101 = r100.getCopyUrl();
        goto L10
    }
}
