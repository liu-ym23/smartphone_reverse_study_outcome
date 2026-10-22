package lo7;

import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.larus.nova.R;
import oo7.j;
import oo7.n;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class g extends lo7.a {

    public class a implements co7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f510146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f510147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f510148c;

        @Override // co7.b
        public final void a() {
        }

        @Override // co7.b
        public final void b(String r100) {
            this.f510146a.putExtra("android.intent.extra.STREAM", n.b(r100));
            kn7.b.a(10000, this.f510147b);
            p.c(this.f510148c.f510132a, this.f510146a);
        }

        public a(g r100, Intent r101, ShareContent r102) {
            this.f510148c = r100;
            this.f510146a = r101;
            this.f510147b = r102;
        }
    }

    public class b implements co7.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f510149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f510150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f510151c;

        @Override // co7.e
        public final void a() {
        }

        @Override // co7.e
        public final void b(String r100) {
            this.f510149a.putExtra("android.intent.extra.STREAM", n.b(r100));
            kn7.b.a(10000, this.f510150b);
            p.c(this.f510151c.f510132a, this.f510149a);
        }

        public b(g r100, Intent r101, ShareContent r102) {
            this.f510151c = r100;
            this.f510149a = r101;
            this.f510150b = r102;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f510152a = null;

        static {
            int[] r100 = new int[ShareContentType.values().length];
            f510152a = r100;
            r100[ShareContentType.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f510152a[ShareContentType.TEXT_IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f510152a[ShareContentType.IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f510152a[ShareContentType.VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public g(Context r100) {
        super(r100);
    }

    @Override // no7.a
    public final boolean a(ShareContent r100) {
        this.f510133b = r100;
        if (this.f510132a != null) goto L6;
        if (r100 != null) goto L6;
        return false;
    L6:
        int r101 = c.f510152a[r100.getShareContentType().ordinal()];
        if (r101 == 1) goto L31;
        if (r101 == 2) goto L29;
        if (r101 == 3) goto L27;
        if (r101 == 4) goto L25;
        if (e(r100, true) == false) goto L17;
    L22:
        return true;
    L17:
        if (f(r100) == true) goto L22;
        if (e(r100, false) == true) goto L22;
        if (g(r100) == true) goto L22;
        return false;
    L25:
        return g(r100);
    L27:
        return e(r100, false);
    L29:
        return e(r100, true);
    L31:
        return f(r100);
    }

    public final boolean f(ShareContent r100) {
        Intent r101 = new Intent("android.intent.action.SEND");
        r101.setType("text/plain");
        r101.putExtra("android.intent.extra.TEXT", d(r100.getTitle(), r100.getTargetUrl()));
        String r102 = Telephony.Sms.getDefaultSmsPackage(this.f510132a);
        if (r102 == null) goto L5;
        r101.setPackage(r102);
    L5:
        kn7.b.a(10000, r100);
        return p.c(this.f510132a, r101);
    }

    public final boolean g(ShareContent r100) {
        if (TextUtils.isEmpty(r100.getVideoUrl()) == false) goto L6;
        return false;
    L6:
        Intent r101 = new Intent("android.intent.action.SEND");
        r101.setType("video/*");
        String r102 = Telephony.Sms.getDefaultSmsPackage(this.f510132a);
        if (r102 == null) goto L9;
        r101.setPackage(r102);
    L9:
        new ho7.i().b(r100, new b(this, r101, r100));
        return true;
    }

    public final String d(String r100, String r101) {
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        return String.format(this.f510132a.getString(R.string.share_sdk_system_share_fmt_new2), new Object[]{r100, r101});
    }

    public final boolean e(ShareContent r100, boolean r101) {
        if (TextUtils.isEmpty(r100.getImageUrl()) == false) goto L5;
        return false;
    L5:
        Intent r102 = new Intent("android.intent.action.SEND");
        r102.setType("image/*");
        String r103 = Telephony.Sms.getDefaultSmsPackage(this.f510132a);
        if (r103 == null) goto L8;
        r102.setPackage(r103);
    L8:
        if (r101 == false) goto L11;
        r102.putExtra("android.intent.extra.TEXT", d(r100.getTitle(), r100.getTargetUrl()));
    L11:
        if (oo7.g.a(r100.getImageUrl()) == true) goto L14;
        r102.putExtra("android.intent.extra.STREAM", n.b(r100.getImageUrl()));
        kn7.b.a(10000, r100);
        return p.c(this.f510132a, r102);
    L14:
        a r104 = new a(this, r102, r100);
        if (TextUtils.isEmpty(r100.getImageUrl()) == true) goto L26;
        eo7.a r105 = eo7.a.b.f473353a;
        if (r105.h() == null) goto L27;
        String r106 = r100.getImageUrl();
        if (TextUtils.isEmpty(r106) == true) goto L28;
        j.b(r100);
        r105.d(r106, new ho7.c(r104, false));
        return true;
    L28:
        return true;
    L27:
        return true;
    L26:
        return true;
    }
}
