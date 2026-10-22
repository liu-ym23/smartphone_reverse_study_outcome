package po7;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.larus.nova.R;
import in7.g;
import java.lang.ref.WeakReference;
import java.util.Locale;
import oo7.f;
import oo7.h;
import oo7.n;
import oo7.o;

/* JADX INFO: loaded from: classes22.dex */
public final class a extends lo7.a {

    /* JADX INFO: renamed from: po7.a$a, reason: collision with other inner class name */
    public class C7220a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f530086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f530087b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f530088c;

        @Override // in7.g
        public final void onDenied() {
            o.a(this.f530086a, this.f530087b, 7, R.string.share_sdk_video_share_save_failed);
        }

        @Override // in7.g
        public final void onGranted() {
            a r100 = this.f530088c;
            Activity r101 = this.f530086a;
            ShareContent r102 = this.f530087b;
            r100.getClass();
            String r103 = r102.getVideoUrl();
            mn7.a r104 = r102.getDownloadProgressDialog();
            if (r104 != null) goto L7;
            r104 = eo7.a.b.f473353a.b(r101);
            if (r104 != null) goto L7;
            return;
        L7:
            WeakReference r105 = new WeakReference(r104);
            String r106 = f.e();
            if (TextUtils.isEmpty(r102.getVideoName()) == true) goto L10;
            String r107 = r102.getVideoName();
        L11:
            r104.a();
            eo7.a r108 = eo7.a.b.f473353a;
            jo7.c.a(new b(r100, r102, r107, r106, r103, r105, r101));
            return;
        L10:
            r107 = String.format(Locale.getDefault(), "%d.mp4", new Object[]{Integer.valueOf(h.a(r103, r106))});
            goto L11
        }

        public C7220a(a r100, Activity r101, ShareContent r102) {
            this.f530088c = r100;
            this.f530086a = r101;
            this.f530087b = r102;
        }
    }

    public a(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        Activity r101 = eo7.a.b.f473353a.h();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100.getVideoUrl()) == true) goto L12;
        if (r101 == null) goto L13;
        n.d(r101, r100, new C7220a(this, r101, r100));
        return true;
    L13:
        return false;
    L12:
        return false;
    }
}
