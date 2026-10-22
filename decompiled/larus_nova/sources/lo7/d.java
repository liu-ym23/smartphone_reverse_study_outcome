package lo7;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import oo7.j;
import oo7.n;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class d extends lo7.a {

    public class a implements co7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f510138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f510139b;

        @Override // co7.b
        public final void a() {
        }

        @Override // co7.b
        public final void b(String r100) {
            this.f510139b.f(this.f510138a, r100, true);
        }

        public a(d r100, ShareContent r101) {
            this.f510139b = r100;
            this.f510138a = r101;
        }
    }

    public class b implements co7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ShareContent f510140a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f510141b;

        @Override // co7.b
        public final void a() {
        }

        @Override // co7.b
        public final void b(String r100) {
            this.f510141b.f(this.f510140a, r100, false);
        }

        public b(d r100, ShareContent r101) {
            this.f510141b = r100;
            this.f510140a = r101;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f510142a = null;

        static {
            int[] r100 = new int[ShareContentType.values().length];
            f510142a = r100;
            r100[ShareContentType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f510142a[ShareContentType.TEXT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f510142a[ShareContentType.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f510142a[ShareContentType.VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public d(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        if (this.f510132a != null) goto L6;
        if (r100 != null) goto L6;
        return false;
    L6:
        int r101 = c.f510142a[r100.getShareContentType().ordinal()];
        if (r101 == 1) goto L37;
        if (r101 == 2) goto L35;
        if (r101 == 3) goto L33;
        if (r101 == 4) goto L28;
        if (e(r100) == false) goto L17;
    L25:
        return true;
    L17:
        if (f(r100, null, true) == true) goto L25;
        if (d(r100) == true) goto L25;
        if (TextUtils.isEmpty(r100.getVideoUrl()) == false) goto L23;
        boolean r102 = false;
    L24:
        if (r102 == true) goto L25;
        return false;
    L23:
        new ho7.i().b(r100, new e(this, r100));
        r102 = true;
        goto L24
    L28:
        if (TextUtils.isEmpty(r100.getVideoUrl()) == true) goto L39;
        new ho7.i().b(r100, new e(this, r100));
        return true;
    L39:
        return false;
    L33:
        return d(r100);
    L35:
        return e(r100);
    L37:
        return f(r100, null, true);
    }

    public final boolean d(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L6;
        return false;
    L6:
        if (oo7.g.a(r100.getImageUrl()) == false) goto L8;
        b r101 = new b(this, r100);
        if (TextUtils.isEmpty(r100.getImageUrl()) == true) goto L21;
        eo7.a r102 = eo7.a.b.f473353a;
        if (r102.h() == null) goto L22;
        String r103 = r100.getImageUrl();
        if (TextUtils.isEmpty(r103) == true) goto L23;
        j.b(r100);
        r102.d(r103, new ho7.c(r101, false));
        return true;
    L23:
        return true;
    L22:
        return true;
    L21:
        return true;
    L8:
        return f(r100, r100.getImageUrl(), false);
    }

    public final boolean e(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L6;
        return false;
    L6:
        if (oo7.g.a(r100.getImageUrl()) == false) goto L8;
        a r101 = new a(this, r100);
        if (TextUtils.isEmpty(r100.getImageUrl()) == true) goto L19;
        eo7.a r102 = eo7.a.b.f473353a;
        if (r102.h() == null) goto L19;
        String r103 = r100.getImageUrl();
        if (TextUtils.isEmpty(r103) == true) goto L19;
        j.b(r100);
        r102.d(r103, new ho7.c(r101, false));
    L19:
        return true;
    L8:
        return f(r100, r100.getImageUrl(), true);
    }

    public final boolean f(ShareContent r100, String r101, boolean r102) {
        Intent r103 = new Intent("android.intent.action.SEND");
        r103.setType("message/rfc882");
        if (r102 == false) goto L6;
        r103.putExtra("android.intent.extra.SUBJECT", r100.getTitle());
        r103.putExtra("android.intent.extra.TEXT", r100.getText());
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L8;
        r103.putExtra("android.intent.extra.STREAM", n.b(r101));
    L8:
        kn7.b.a(10000, r100);
        return p.c(this.f510132a, r103);
    }
}
