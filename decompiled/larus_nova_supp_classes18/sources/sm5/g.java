package sm5;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.bizwidget.shareview.i;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertFragment;
import com.bytedance.ee.bear.sheet.exportimage.alert.ScreenshotImageAlertViewModel;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g extends i {
    public final /* synthetic */ ScreenshotImageAlertFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Lark.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L19:
            r0[ShareType.Wechat.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L27:
            r0[ShareType.WechatMoments.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L21:
            r0[ShareType.QQ.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ShareType.Weibo.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L17:
            r0[ShareType.More.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L9:
            a = r0;
        }
    }

    public g(ScreenshotImageAlertFragment r1) {
        this.a = r1;
    }

    public final boolean U10(ShareItemModel r7) {
        Intrinsics.checkNotNullParameter(r7, "shareItem");
        ScreenshotImageAlertFragment r0 = this.a;
        int r1 = ScreenshotImageAlertFragment.w;
        r0.getClass();
        ShareType r2 = r7.getType();
        if (r2 != null) goto L5;
        r2 = ShareType.More;
    L5:
        boolean r3 = com.bytedance.ee.bear.appsetting.c.a.a.h("admin.watermark.filewatermark.remaining");
        CharSequence r4 = null;
        if (r3 == true) goto L8;
    L14:
        Context r5 = r0.getContext();
        Context r6 = r0.getContext();
        if (r6 == null) goto L17;
        r4 = r6.getText(2131888211);
    L17:
        Toast.showLoading(r5, r4);
    L18:
        r0.ba0(r2, r3).subscribeOn(fo5.d.b()).observeOn(fo5.d.d()).doFinally(b.a).subscribe(new com.bytedance.ee.bear.sheet.exportimage.alert.a(r0, r7), com.bytedance.ee.bear.sheet.exportimage.alert.b.a);
        return true;
    L8:
        if (r2 == ShareType.Lark) goto L18;
        ScreenshotImageAlertViewModel r8 = r0.i;
        if (r8 == null) goto L12;
        File r9 = r8.getWatermarkedImageBitmap();
    L13:
        if (r9 != null) goto L18;
    L12:
        r9 = null;
        goto L13
    }

    public final boolean Yl(ShareType r2) {
        Intrinsics.checkNotNullParameter(r2, "shareType");
        ScreenshotImageAlertFragment r3 = this.a;
        int r0 = ScreenshotImageAlertFragment.w;
        return r3.aa0(2131887299);
    }

    public final boolean rF(ShareItemModel r2) {
        Intrinsics.checkNotNullParameter(r2, "shareItem");
        ScreenshotImageAlertFragment r3 = this.a;
        int r0 = ScreenshotImageAlertFragment.w;
        return r3.aa0(2131887299);
    }

    public final void s10(ShareType r3) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        switch(a.a[r3.ordinal()]) {
            case 1: goto L5;
            case 2: goto L5;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r3);
        return;
    L5:
        ScreenshotImageAlertViewModel r0 = this.a.i;
        if (r0 == null) goto L8;
        r0.onShareToExternalApp(r3);
    L8:
        this.a.da0(r3);
    }
}
