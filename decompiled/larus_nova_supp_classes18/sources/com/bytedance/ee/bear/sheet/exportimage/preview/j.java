package com.bytedance.ee.bear.sheet.exportimage.preview;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareItemModel;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends com.bytedance.ee.bear.bizwidget.shareview.i {
    public final /* synthetic */ SheetImagePreviewFragment a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.Wechat.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[ShareType.WechatMoments.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[ShareType.QQ.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[ShareType.More.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[ShareType.Download.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[ShareType.CopyText.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[ShareType.Lark.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    public j(SheetImagePreviewFragment r1) {
        this.a = r1;
    }

    public final boolean U10(ShareItemModel r5) {
        Intrinsics.checkNotNullParameter(r5, "shareItem");
        SheetImagePreviewFragment r0 = this.a;
        ImagePreviewViewModel r1 = r0.f;
        if (r1 != null) goto L5;
        return false;
    L5:
        if (r1.doShareToCustom(r5, r0.o, r0.p) != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean Yl(ShareType r5) {
        Intrinsics.checkNotNullParameter(r5, "shareType");
        SheetImagePreviewFragment r0 = this.a;
        if (r0.n == false) goto L6;
        return false;
    L6:
        if (r5 != ShareType.Wechat) goto L8;
    L15:
        boolean r1 = true;
    L16:
        if (r1 == false) goto L20;
        Context r2 = r0.getContext();
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        if (km5.c.e(r2, r5) == true) goto L20;
        return false;
    L20:
        SheetImagePreviewFragment r3 = this.a;
        if (r3.o == true) goto L29;
        ImagePreviewViewModel r4 = r3.f;
        if (r4 != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == true) goto L29;
        return false;
    L25:
        if (r4.canShareImageToExternalApp(r5) != true) goto L27;
        r6 = true;
    L29:
        return true;
    L8:
        if (r5 == ShareType.WechatMoments) goto L15;
        if (r5 == ShareType.QQ) goto L15;
        if (r5 == ShareType.Weibo) goto L15;
        r1 = false;
        goto L16
    }

    public final boolean rF(ShareItemModel r5) {
        Intrinsics.checkNotNullParameter(r5, "shareItem");
        SheetImagePreviewFragment r0 = this.a;
        if (r0.n == false) goto L6;
        return false;
    L6:
        if (r0.o == true) goto L14;
        ImagePreviewViewModel r1 = r0.f;
        if (r1 != null) goto L10;
    L12:
        boolean r6 = false;
    L13:
        if (r6 == true) goto L14;
        return false;
    L10:
        if (r1.canCustomShareImage(r5) != true) goto L12;
        r6 = true;
    L14:
        return true;
    }

    public final void s10(ShareType r3) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        switch(a.a[r3.ordinal()]) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        super.s10(r3);
        return;
    L5:
        SheetImagePreviewFragment r0 = this.a;
        if (r0.o == false) goto L10;
        ImagePreviewViewModel r1 = r0.f;
        if (r1 == null) goto L25;
        r1.onShareTextToExternalApp(r3, r0.p);
        return;
    L25:
        return;
    L10:
        ImagePreviewViewModel r2 = r0.f;
        if (r2 == null) goto L27;
        r2.onShareImageToExternalApp(r3);
        return;
    L27:
        return;
    L13:
        Context r4 = this.a.getContext();
        ((com.bytedance.ee.bear.share.export.a) org.koin.java.a.a(com.bytedance.ee.bear.share.export.a.class)).Y9().getClass();
        if (km5.c.e(r4, r3) == false) goto L29;
        SheetImagePreviewFragment r5 = this.a;
        if (r5.o == false) goto L20;
        ImagePreviewViewModel r6 = r5.f;
        if (r6 == null) goto L30;
        r6.onShareTextToExternalApp(r3, r5.p);
        return;
    L30:
        return;
    L20:
        ImagePreviewViewModel r7 = r5.f;
        if (r7 == null) goto L32;
        r7.onShareImageToExternalApp(r3);
        return;
    L32:
        return;
    }

    public final void xq(ShareType r3, String r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        tt5.a.h("SheetImagePreviewFragment", "onCacControlled, shareType: " + r3 + ", token: " + r4 + ", type: " + r5);
        if (r5 == 12) goto L6;
        ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).c("CCM_EXPORT", FileBizDomain.FileBizDomainCCM, r5, "");
        return;
    }
}
