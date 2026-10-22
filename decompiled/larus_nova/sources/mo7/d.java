package mo7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.tencent.connect.common.Constants;
import ho7.i;
import java.net.URLConnection;
import java.util.ArrayList;
import oo7.j;
import oo7.n;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class d {

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f514604a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ShareContent f514605b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f514606c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ShareChannelType f514607d;

        public final void a() {
            Intent r100 = new Intent();
            ArrayList r101 = this.f514604a;
            if (r101 != null) goto L5;
        L17:
            r100.setAction("android.intent.action.SEND");
            r100.setType("text/plain");
        L18:
            kn7.a r102 = this.f514605b.getExtraParams();
            String r103 = "";
            if (r102 == null) goto L23;
            Object r104 = r102.f504254h;
            if ((r104 instanceof kn7.c) == false) goto L23;
            kn7.c r105 = (kn7.c) r104;
            r105.getClass();
            String r106 = r105.f504259a;
            String r107 = null;
        L24:
            String r108 = r107;
            if (TextUtils.isEmpty(r107) == false) goto L28;
            r107 = this.f514606c.getString(R.string.share_sdk_action_system_share);
        L28:
            if (TextUtils.isEmpty(r108) == true) goto L31;
            r100.putExtra("android.intent.extra.SUBJECT", r108);
        L34:
            if (TextUtils.isEmpty(r106) == true) goto L36;
            r100.putExtra("android.intent.extra.TEXT", r106);
            r100.putExtra("Kdescription", r106);
        L46:
            kn7.b.a(10000, this.f514605b);
            d.a(this.f514606c, r100, this.f514607d, r107);
            return;
        L36:
            Context r109 = this.f514606c;
            String r110 = this.f514605b.getTitle();
            String r111 = this.f514605b.getTargetUrl();
            if (r110 != null) goto L39;
            r110 = "";
        L39:
            if (r111 == null) goto L43;
            r103 = r111;
        L43:
            if (r110.length() < 70) goto L45;
            r110 = r110.substring(0, 70) + "...";
        L45:
            String r112 = String.format(r109.getString(R.string.share_sdk_system_share_fmt_new2), new Object[]{r110, r103});
            r100.putExtra("android.intent.extra.TEXT", r112);
            r100.putExtra("Kdescription", r112);
            goto L46
        L31:
            if (TextUtils.isEmpty(this.f514605b.getTitle()) == true) goto L34;
            r100.putExtra("android.intent.extra.SUBJECT", this.f514605b.getTitle());
        L23:
            r106 = "";
            r107 = r106;
            goto L24
        L5:
            if (r101.size() <= 0) goto L17;
            String r113 = "image/*";
            if (this.f514604a.size() != 1) goto L16;
            r100.setAction("android.intent.action.SEND");
            String r114 = URLConnection.getFileNameMap().getContentTypeFor(((Uri) ListProtector.get(this.f514604a, 0)).toString());
            if (r114 != null) goto L12;
        L15:
            r100.setType(r113);
            r100.putExtra("android.intent.extra.STREAM", (Parcelable) ListProtector.get(this.f514604a, 0));
            goto L18
        L12:
            if (r114.length() <= 0) goto L15;
            r113 = r114;
            goto L15
        L16:
            r100.setAction("android.intent.action.SEND_MULTIPLE");
            r100.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f514604a);
            r100.setType("image/*");
            goto L18
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ArrayList r100, ShareContent r101, Context r102, ShareChannelType r103) {
            this.f514604a = r100;
            this.f514605b = r101;
            this.f514606c = r102;
            this.f514607d = r103;
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f514608a = null;

        static {
            int[] r100 = new int[ShareContentType.values().length];
            f514608a = r100;
            r100[ShareContentType.TEXT_IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f514608a[ShareContentType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f514608a[ShareContentType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f514608a[ShareContentType.FILE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f514608a[ShareContentType.TEXT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static boolean b(Context r100, ShareChannelType r101, ShareContent r102) {
        if (r100 == null) goto L47;
        if (r102 == null) goto L47;
        int r103 = b.f514608a[r102.getSystemShareType().ordinal()];
        if (r103 != 1) goto L9;
    L28:
        ArrayList r104 = new ArrayList();
        if (TextUtils.isEmpty(r102.getImageUrl()) == true) goto L46;
        if (oo7.g.a(r102.getImageUrl()) == true) goto L35;
        Uri r105 = oo7.f.g(r100, r102.getImageUrl(), false);
        if (r105 == null) goto L46;
        r104.add(r105);
        goto L46
    L35:
        mo7.a r106 = new mo7.a(r100, r104, r101, r102);
        if (TextUtils.isEmpty(r102.getImageUrl()) == true) goto L51;
        eo7.a r107 = eo7.a.b.f473353a;
        if (r107.h() == null) goto L52;
        String r108 = r102.getImageUrl();
        if (TextUtils.isEmpty(r108) == true) goto L53;
        j.b(r102);
        r107.d(r108, new ho7.c(r106, false));
        return true;
    L53:
        return true;
    L52:
        return true;
    L51:
        return true;
    L46:
        return c(r100, r101, r102, r104);
    L9:
        if (r103 == 2) goto L28;
        if (r103 == 3) goto L24;
        if (r103 == 4) goto L17;
        return c(r100, r101, r102, null);
    L17:
        if (TextUtils.isEmpty(r102.getFileUrl()) == true) goto L22;
        if (TextUtils.isEmpty(r102.getFileName()) == true) goto L22;
        ho7.b.C6179b.f486235a.b(r102, new c(r102, r100, r101));
        return true;
    L22:
        return c(r100, r101, r102, null);
    L24:
        if (TextUtils.isEmpty(r102.getVideoUrl()) == true) goto L27;
        new i().b(r102, new mo7.b(r102, r100, r101));
        return true;
    L27:
        return c(r100, r101, r102, null);
    L47:
        return false;
    }

    public static void a(Context r100, Intent r101, ShareChannelType r102, String r103) {
        if (r102 != ShareChannelType.QQ) goto L6;
        r101.setClassName(ShareChannelType.getSharePackageName(r102), "com.tencent.mobileqq.activity.JumpActivity");
        r101.addFlags(268435456);
    L22:
        p.c(r100, r101);
        return;
    L6:
        if (r102 != ShareChannelType.WX) goto L11;
        r101.setClassName(ShareChannelType.getSharePackageName(r102), "com.tencent.mm.ui.tools.ShareImgUI");
        if (n.e() == true) goto L22;
        r101 = Intent.createChooser(r101, r103);
        goto L22
    L11:
        if (r102 != ShareChannelType.WX_TIMELINE) goto L16;
        r101.setClassName(ShareChannelType.getSharePackageName(r102), "com.tencent.mm.ui.tools.ShareToTimeLineUI");
        if (n.e() == true) goto L22;
        r101 = Intent.createChooser(r101, r103);
        goto L22
    L16:
        if (r102 != ShareChannelType.QZONE) goto L19;
        r101.setClassName(Constants.PACKAGE_QZONE, "com.qzonex.module.operation.ui.QZonePublishMoodActivity");
        goto L22
    L19:
        if (r102 != ShareChannelType.WEIBO) goto L21;
        r101.setClassName(ShareChannelType.getSharePackageName(r102), "com.sina.weibo.composerinde.ComposerDispatchActivity");
        goto L22
    L21:
        r101 = Intent.createChooser(r101, r103);
        goto L22
    }

    public static boolean c(Context r100, ShareChannelType r101, ShareContent r102, ArrayList<Uri> r103) {
        if (r102 != null) goto L5;
        return false;
    L5:
        new a(r103, r102, r100, r101).run();
        return true;
    }
}
