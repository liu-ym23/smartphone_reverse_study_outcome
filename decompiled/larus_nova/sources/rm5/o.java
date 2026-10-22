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

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f538566a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            f538566a = r100;
            r100[ShareType.Download.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f538566a[ShareType.QQ.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f538566a[ShareType.Wechat.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f538566a[ShareType.WechatMoments.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f538566a[ShareType.Weibo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f538566a[ShareType.Lark.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    public interface b {
        void onFail(String r100);

        void onSuccess();
    }

    public static String a(ShareType r100) {
        if (r100 != null) goto L6;
        return "";
    L6:
        switch(a.f538566a[r100.ordinal()]) {
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
        return r100.name().toLowerCase();
    }

    public static void b(final Context r100, final File r101, final b r102) {
        if ((r100 instanceof Activity) == true) goto L5;
        tt5.a.k("ShareImageHelper", "checkStoragePermissions activityContext error " + r100);
        return;
    L5:
        com.ss.android.lark.utils.h.g((Activity) r100, new g(r100, r101, r102), com.ss.android.lark.utils.n.a(), new Token("LARK-PSDA-ccm_sheet_download_as_image"), new String[0]);
    }

    public static void c(Context r100, final ShareType r101, final File r102) {
        if (r102 == null) goto L22;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r102.exists() == true) goto L7;
        return;
    L7:
        if (r102.isFile() == true) goto L10;
        return;
    L10:
        if (r101.equals(ShareType.Lark) == false) goto L13;
        Uri r103 = Uri.fromFile(r102);
        final ArrayList r104 = new ArrayList();
        r104.add(r103);
        Flowable.just("").subscribeOn(fo5.d.b()).map(new rm5.a()).map(new d(r102, r104)).subscribe(new e(r101), new f(r101));
        return;
    L13:
        m r105 = new m(r101);
        if (r101.equals(ShareType.More) == false) goto L18;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().b(r100, ay4.d.a().t(r102), r105);
        return;
    L18:
        if (((ExternalShareMinaConfig) com.bytedance.ee.bear.appsetting.c.a.f206237a.c("external_share_config", ExternalShareMinaConfig.class, new ExternalShareMinaConfig())).isShareChannelBanned(r101) == false) goto L20;
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().d(r100, r101, ay4.d.a().t(r102), null, r105);
        return;
    L20:
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().a(r100, r101, ay4.d.a().t(r102), r105);
        return;
    }
}
