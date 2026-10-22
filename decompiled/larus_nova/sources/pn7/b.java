package pn7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import ao7.d;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.larus.nova.R;
import oo7.n;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class b extends lo7.a {

    public class a implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f529981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b f529982b;

        public a(b r100, ShareContent r101) {
            this.f529982b = r100;
            this.f529981a = r101;
        }
    }

    public b(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        eo7.a r101 = eo7.a.b.f473353a;
        if (((Boolean) r101.c("hide_save_image_preview_dialog", Boolean.FALSE)).booleanValue() == false) goto L13;
        if (r100.getImage() != null) goto L11;
        if (TextUtils.isEmpty(r100.getHiddenImageUrl()) == false) goto L9;
        e(false, r100);
        return false;
    L9:
        r101.d(r100.getHiddenImageUrl(), new pn7.a(this, r100));
        return true;
    L11:
        return d(r100);
    L13:
        if (yn7.b.f568571a != null) goto L25;
        monitor-enter(yn7.b.class);
    L21:
        th = move-exception;
        throw th;
    L17:
        if (yn7.b.f568571a != null) goto L19;
        yn7.b.f568571a = new yn7.b();     // Catch: Throwable -> L21
    L19:
        monitor-exit(yn7.b.class);     // Catch: Throwable -> L21
    L25:
        return yn7.b.f568571a.a(ShareChannelType.IMAGE_SHARE, r100);
    }

    public final boolean d(ShareContent r100) {
        Activity r101 = eo7.a.b.f473353a.h();
        a r102 = new a(this, r100);
        if (r101 == null) goto L9;
        if (r100 == null) goto L9;
        if (r100.getImage() == null) goto L9;
        n.d(r101, r100, new ao7.c(r101, r100, r102));
        return true;
    L9:
        e(false, r100);
        return false;
    }

    public final void e(boolean r100, ShareContent r101) {
        if (r100 == false) goto L4;
        o.a(this.f510132a, r101, 8, R.string.share_sdk_had_saved_to_album);
    L5:
        if (r100 == false) goto L7;
        int r102 = 10000;
    L8:
        kn7.b.a(r102, r101);
        return;
    L7:
        r102 = 10002;
        goto L8
    L4:
        o.a(this.f510132a, r101, 9, R.string.share_sdk_image_share_save_failed);
        goto L5
    }
}
