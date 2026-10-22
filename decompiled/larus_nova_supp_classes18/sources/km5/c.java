package km5;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.externalshare.OnIpcShareCallback;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import com.ss.android.lark.utils.ApiUtils;
import java.util.Collections;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rm5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c {

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            a = r0;
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            a[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            a[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static boolean d() {
        boolean r1 = ((z6c.a) ApiUtils.getApi(z6c.a.class)).a().isGooglePlay();     // Catch: Exception -> L5
    L7:
        tt5.a.b("ExternalShareHelper", "IsGooglePlay = " + r1);
        return r1;
    L5:
        e = move-exception;
        tt5.a.d("ExternalShareHelper", "ThirdShareModule should be initialized in Lark App. error = " + e);
        r1 = false;
        goto L7
    }

    public static ShareActionType a(ShareType r1) {
        int r2 = a.a[r1.ordinal()];
        if (r2 == 1) goto L19;
        if (r2 == 2) goto L17;
        if (r2 == 3) goto L15;
        if (r2 == 4) goto L13;
        return null;
    L13:
        return ShareActionType.WB;
    L15:
        return ShareActionType.QQ;
    L17:
        return ShareActionType.WX_TIMELINE;
    L19:
        return ShareActionType.WX;
    }

    public static void f(Context r4) {
        if (e(r4, ShareType.Wechat) == true) goto L10;
        return;
    L10:
        Intent r0 = new Intent("android.intent.action.MAIN");     // Catch: ActivityNotFoundException -> L7
        ComponentName r1 = new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI");     // Catch: ActivityNotFoundException -> L7
        r0.addCategory("android.intent.category.LAUNCHER");     // Catch: ActivityNotFoundException -> L7
        r0.addFlags(268435456);     // Catch: ActivityNotFoundException -> L7
        r0.setComponent(r1);     // Catch: ActivityNotFoundException -> L7
        r4.startActivity(r0);     // Catch: ActivityNotFoundException -> L7
        return;
    L7:
        e = move-exception;
        tt5.a.d("ExternalShareHelper", "jumpToWechat, error = " + e.getMessage());
    }

    public static void b(Activity r2, String r3) {
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.SEND");
        r0.putExtra("android.intent.extra.TEXT", r3);
        r0.setType("text/plain");
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r0.addFlags(1);
        r0.addFlags(2);
    L9:
        r2.startActivity(Intent.createChooser(r0, r2.getResources().getString(2131887766)));     // Catch: Exception -> L7
        return;
    L7:
        Toast.showFailureText(r2, r2.getResources().getString(2131887802), 0);
    }

    public static String c(Context r1, ShareType r2) {
        int r3 = a.a[r2.ordinal()];
        if (r3 == 1) goto L19;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L15;
        if (r3 == 4) goto L13;
        return null;
    L13:
        return r1.getResources().getString(2131888253);
    L15:
        return r1.getResources().getString(2131888240);
    L17:
        return r1.getResources().getString(2131888228);
    L19:
        return r1.getResources().getString(2131888252);
    }

    public static boolean e(Context r3, ShareType r4) {
        ComponentName r5 = d.a(r4);
        if (r3 == null) goto L21;
        if (r5 == null) goto L21;
        String r6 = r5.getPackageName();
        if (TextUtils.isEmpty(r6) == false) goto L22;
    L17:
        boolean r7 = false;
    L18:
        if (r7 == true) goto L20;
        Toast.showFailureText(r3, r3.getResources().getString(2131888201), 0);
    L20:
        return r7;
    L22:
        PackageInfo r8 = r3.getPackageManager().getPackageInfo(r6, 0);     // Catch: Exception -> L15
        if (r8 == null) goto L17;
        ApplicationInfo r9 = r8.applicationInfo;     // Catch: Exception -> L15
        if (r9 == null) goto L17;
        if (r9.enabled == false) goto L17;
        r7 = true;
    L15:
        e = move-exception;
        tt5.a.d("ExternalShareHelper", "isInstalledApp()... error = " + e);
    L21:
        return false;
    }

    public static boolean g(Context r2, ShareEntity r3) {
        ((z6c.a) ApiUtils.getApi(z6c.a.class)).share();     // Catch: Exception -> L5
        return true;
    L5:
        e = move-exception;
        Toast.showFailureText(r2, r2.getResources().getString(2131887802), 0);
        tt5.a.d("ExternalShareHelper", "performSdkShare fail, exception : " + e);
        return false;
    }

    public static void h(Context r19, String r20, ShareParams r21) {
        if (e(r19, ShareType.Wechat) == true) goto L5;
        return;
    L5:
        int r1 = e.a;
        int r2 = r21.getType();
        String r4 = r21.getToken();
        Intrinsics.checkNotNullParameter(r4, "docToken");
        String r3 = StringsKt.replace$default(StringsKt.replace$default("pages/web-view/index?type=doc_type&obj_token=doc_token", "doc_type", String.valueOf(r2), false, 4, null), "doc_token", r4, false, 4, null);
        int r5 = r21.getType();
        String r6 = r21.getSubType();
        Intrinsics.checkNotNullParameter(r19, "context");
        if (r5 != 2) goto L8;
        Bitmap r7 = e.a(r19, 2131243977);
    L42:
        if (r7 != null) goto L45;
        tt5.a.d("ExternalShareHelper", "performSdkShareMiniApp()... bitmap is null");
        return;
    L45:
        ShareEntity.a r8 = new ShareEntity.a(r3, r21.getDocName(), u6c.c.f(r7, com.ss.android.lark.core.storage.a.b()), r20);
        r8.c(Collections.singletonList(ShareActionType.WX));
        r8.b(OnIpcShareCallback.class);
        g(r19, r8.a());
        return;
    L8:
        if (r5 != 3) goto L10;
        r7 = e.a(r19, 2131243983);
        goto L42
    L10:
        if (r5 != 11) goto L12;
        r7 = e.a(r19, 2131243980);
        goto L42
    L12:
        if (r5 == 12) goto L15;
        r7 = e.a(r19, 2131243985);
        goto L42
    L15:
        if (e.b(r6, new String[]{"xls", "xlsx", "xlsm", "csv"}) == false) goto L18;
        r7 = e.a(r19, 2131243978);
        goto L42
    L18:
        if (e.b(r6, new String[]{"jpg", "jpeg", "png", "bmp", "tif", "tiff", "svg", "raw", "gif", "heic", "heif", "webp"}) == false) goto L21;
        r7 = e.a(r19, 2131243979);
        goto L42
    L21:
        if (e.b(r6, new String[]{ExportFileExtension.PDF}) == false) goto L24;
        r7 = e.a(r19, 2131243981);
        goto L42
    L24:
        if (e.b(r6, new String[]{"ppt", ExportFileExtension.PPTX, "pps", "ppsx", "pot", "potx"}) == false) goto L27;
        r7 = e.a(r19, 2131243982);
        goto L42
    L27:
        if (e.b(r6, new String[]{"txt", "rtf"}) == false) goto L30;
        r7 = e.a(r19, 2131243984);
        goto L42
    L30:
        if (e.b(r6, new String[]{"mp4", "mov", "wmv", "m4v", "avi", "mpg", "mpeg", "rm", "rmvb", "flv", "mkv", "ogv", "ogg"}) == false) goto L33;
        r7 = e.a(r19, 2131243986);
        goto L42
    L33:
        if (e.b(r6, new String[]{DocumentType.DOC_NAME, DocumentType.DOCX_NAME, "dot", "dotx"}) == false) goto L36;
        r7 = e.a(r19, 2131243987);
        goto L42
    L36:
        if (e.b(r6, new String[]{"zip", "rar", "tar", "gz", "tgz", "tarGz", "bz2", "tarBz2", "lzma", "tarLzma", "is7z"}) == false) goto L38;
        r7 = e.a(r19, 2131243988);
        goto L42
    L38:
        r7 = e.a(r19, 2131243985);
        goto L42
    }

    public static void i(Context r1, ShareType r2, String r3, n r4) {
        if (e(r1, r2) == true) goto L7;
        if (r4 == null) goto L13;
        r4.onFailed("App not installed.");
        return;
    L13:
        return;
    L7:
        ShareActionType r5 = a(r2);
        ShareEntity.a r0 = new ShareEntity.a(r3);
        r0.c(Collections.singletonList(r5));
        r0.b(OnIpcShareCallback.class);
        boolean r6 = g(r1, r0.a());
        if (r4 == null) goto L14;
        if (r6 == false) goto L11;
        r4.onSuccess();
        return;
    L11:
        r4.onFailed(r1.getResources().getString(2131887802));
        return;
    }

    public static void j(Context r1, ShareType r2, String r3, n r4) {
        if (e(r1, r2) == true) goto L7;
        if (r4 == null) goto L22;
        r4.onFailed("App not installed.");
        return;
    L22:
        return;
    L7:
        Intent r0 = new Intent();
        r0.setComponent(d.a(r2));
        r0.setAction("android.intent.action.SEND");
        if (TextUtils.isEmpty(r3) == false) goto L10;
        r3 = "";
    L10:
        r0.putExtra("android.intent.extra.TEXT", r3);
        r0.setType("text/plain");
        r1.startActivity(r0);     // Catch: Exception -> L13
    L17:
        if (r4 == null) goto L23;
        r4.onSuccess();
        return;
    L23:
        return;
    L13:
        String r5 = r1.getResources().getString(2131887802);
        if (r4 == null) goto L16;
        r4.onFailed(r5);
    L16:
        Toast.showFailureText(r1, r5, 0);
        goto L17
    }
}
