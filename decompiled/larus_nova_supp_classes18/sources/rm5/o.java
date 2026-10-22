package rm5;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import com.bytedance.ee.bear.bizwidget.shareview.ExternalShareMinaConfig;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.supervisor.token.Token;
import io.reactivex.Flowable;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            a = r0;
            r0[ShareType.Download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            a[ShareType.QQ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            a[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            a[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            a[ShareType.Weibo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            a[ShareType.Lark.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public interface b {
        void onFail(String r1);

        void onSuccess();
    }

    public static String a(ShareType r2) {
        if (r2 != null) goto L6;
        return "";
    L6:
        switch(a.a[r2.ordinal()]) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L9;
            default: goto L8;
        };
    L9:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        if (km5.c.d() == false) goto L12;
        return "lark";
    L12:
        return "feishu";
    L14:
        return "weibo";
    L16:
        return "wechat_moment";
    L18:
        return "wechat";
    L20:
        return "qq";
    L22:
        return "local";
    L8:
        return r2.name().toLowerCase();
    }

    public static void b(final Context r2, final File r3, final b r4) {
        if ((r2 instanceof Activity) == true) goto L5;
        tt5.a.k("ShareImageHelper", "checkStoragePermissions activityContext error " + r2);
        return;
    L5:
        com.ss.android.lark.utils.h.g((Activity) r2, new g(r2, r3, r4), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_sheet_download_as_image"), new String[0]);
    }

    public static void c(Context r7, final ShareType r8, final File r9) {
        if (r9 == null) goto L22;
        if (r7 != null) goto L5;
        return;
    L5:
        if (r9.exists() == true) goto L7;
        return;
    L7:
        if (r9.isFile() == true) goto L10;
        return;
    L10:
        if (r8.equals(ShareType.Lark) == false) goto L13;
        Uri r10 = Uri.fromFile(r9);
        final ArrayList r0 = new ArrayList();
        r0.add(r10);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new rm5.a()).map(new d(r9, r0)).subscribe(new e(r8), new f(r8));
        return;
    L13:
        m r6 = new m(r8);
        if (r8.equals(ShareType.More) == false) goto L18;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().b(r7, ay4.d.a().t(r9), r6);
        return;
    L18:
        if (com.bytedance.ee.bear.appsetting.c.a.a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig()).isShareChannelBanned(r8) == false) goto L20;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().d(r7, r8, ay4.d.a().t(r9), null, r6);
        return;
    L20:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().a(r7, r8, ay4.d.a().t(r9), r6);
        return;
    }
}
