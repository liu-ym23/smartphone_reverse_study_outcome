package ho7;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.os.Handler;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import jn7.l;
import oo7.m;
import oo7.p;

/* JADX INFO: loaded from: classes22.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f486252a;

    public g() {
        this.f486252a = new Handler(Looper.getMainLooper());
    }

    public static void a(Activity r100, ShareContent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        int r102 = 0;
        MediaScannerConnection.scanFile(r100, new String[]{r101.getVideoUrl()}, new String[]{MimeTypeMap.getSingleton().getMimeTypeFromExtension("mp4")}, null);
        r101.getVideoDialogCallback();
        eo7.a r103 = eo7.a.b.f473353a;
        if (((Integer) r103.c("save_video_continue_share_dialog_times", -1)).intValue() != (-1)) goto L13;
        r101.getVideoShareDialog();
        l r104 = r103.f473336j;
        if (r104 == null) goto L9;
        r104.d();
    L9:
        l r105 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r105 == null) goto L32;
        r105.d();
        return;
    L32:
        return;
    L13:
        SharedPreferences r106 = m.a().f524630a;
        if (r106 == null) goto L17;
        r102 = r106.getInt("show_share_video_continue_share_dialog", 0);
    L17:
        if (r102 < ((Integer) r103.c("save_video_continue_share_dialog_times", -1)).intValue()) goto L22;
        Intent r107 = r100.getPackageManager().getLaunchIntentForPackage(ShareChannelType.getSharePackageName(r101.getShareChanelType()));
        if (r107 == null) goto L21;
        p.c(r100, r107);
    L21:
        kn7.b.a(10000, r101);
        return;
    L22:
        int r108 = r102 + 1;
        SharedPreferences r109 = m.a().f524630a;
        if (r109 == null) goto L25;
        SharedPreferences.Editor r110 = r109.edit();
        r110.putInt("show_share_video_continue_share_dialog", r108);
        r110.apply();
    L25:
        r101.getVideoShareDialog();
        l r111 = r103.f473336j;
        if (r111 == null) goto L28;
        r111.d();
    L28:
        l r112 = com.bytedance.ug.sdk.share.impl.manager.b.c();
        if (r112 == null) goto L34;
        r112.d();
        return;
    }
}
