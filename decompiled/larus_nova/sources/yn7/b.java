package yn7;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import java.lang.ref.WeakReference;
import jn7.l;
import oo7.j;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f568571a;

    public b() {
    }

    public static void b(Activity r100, ShareContent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.getImage() == null) goto L15;
        r101.getImageTokenDialog();
        l r102 = eo7.a.b.f473353a.f473336j;
        if (r102 == null) goto L9;
        r102.l();
    L9:
        l r103 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r103 == null) goto L14;
        r103.l();
        return;
    L14:
        return;
    }

    public final boolean a(ShareChannelType r100, ShareContent r101) {
        if (r101 == null) goto L14;
        if (r100 == null) goto L14;
        eo7.a r102 = eo7.a.b.f473353a;
        Activity r103 = r102.h();
        if (r103 == null) goto L14;
        if (TextUtils.isEmpty(r101.getHiddenImageUrl()) == true) goto L12;
        String r104 = r101.getHiddenImageUrl();
        j.b(r101);
        r102.d(r104, new a(this, new WeakReference(r103), r101));
        return true;
    L12:
        if (r101.getImage() == null) goto L14;
        b(r103, r101);
    L14:
        return false;
    }
}
