package com.bytedance.ee.bear.share.externalshare.external;

import android.content.Context;
import com.bytedance.ee.bear.bizwidget.shareview.ShareType;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.permission.share.info.ShareFolderInfo;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.IFolderPublicPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderPermission;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.bear.share.externalshare.external.handler.BaseOpenTencentHandler;
import com.bytedance.ee.bear.share.externalshare.external.handler.h;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class FolderShareExternalPresenter extends com.bytedance.ee.bear.share.externalshare.external.a {
    public final ShareParams i;
    public final Context j;
    public ShareFolderInfo k;
    public Disposable l;
    public Disposable m;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ShareType.values().length];
            r0[ShareType.CopyLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[ShareType.PasswordLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[ShareType.Wechat.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[ShareType.WechatMoments.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[ShareType.QQ.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void d() {
        Disposable r0 = this.l;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.l = null;
        Disposable r1 = this.m;
        if (r1 == null) goto L8;
        r1.dispose();
    L8:
        this.m = null;
    }

    public final h j() {
        Context r1 = this.j;
        ShareFolderInfo r2 = this.k;
        ShareParams r3 = this.i;
        BaseOpenTencentHandler r0 = this.g;
        if (r0 == null) goto L6;
        String r4 = r0.e();
        if (r4 == null) goto L6;
    L8:
        return new h(r1, r2, r3, r4, new FolderShareExternalPresenter$createPasswordLinkHandler$1(this), new FolderShareExternalPresenter$createPasswordLinkHandler$2(this));
    L6:
        r4 = "";
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final com.bytedance.ee.bear.share.export.f a() {
        return this.k;
    }

    public final boolean Yl(ShareType r7) {
        Intrinsics.checkNotNullParameter(r7, "shareType");
        switch(b.a[r7.ordinal()]) {
            case 2: goto L22;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L18;
        };
    L5:
        ShareFolderInfo r1 = this.k;
        if (r1 == null) goto L13;
        boolean r4 = r1.e();
        boolean r2 = r1.isLinkShareAnyoneRead();
        if (r4 == true) goto L13;
        if (r2 == true) goto L13;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.a.i() == false) goto L13;
        Toast.showFailureText(this.j, 2131888785);
        boolean r3 = true;
    L14:
        if (r3 == false) goto L16;
        return false;
    L16:
        Intrinsics.checkNotNullParameter(r7, "shareType");
        return true;
    L13:
        r3 = false;
        goto L14
    L18:
        Intrinsics.checkNotNullParameter(r7, "shareType");
        return true;
    L22:
        return j().a();
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void i(com.bytedance.ee.bear.share.export.f r13) {
        Intrinsics.checkNotNullParameter(r13, "shareInfo");
        if ((r13 instanceof ShareFolderInfo) == false) goto L5;
        ShareFolderInfo r0 = (ShareFolderInfo) r13;
    L6:
        if (r0 != null) goto L8;
        r0 = new ShareFolderInfo(0, null, null, null, null, null, null, null, null, 1023);
    L8:
        this.k = r0;
        super.i(r13);
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void s10(ShareType r3) {
        Intrinsics.checkNotNullParameter(r3, "shareType");
        Intrinsics.checkNotNullParameter(r3, "shareType");
        r3.getItemId();
        int r0 = b.a[r3.ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        b();
        ShareFolderInfo r4 = this.k;
        if (r4 == null) goto L16;
        ShareFolderPermission r5 = r4.i;
        if (r5 == null) goto L16;
        IFolderPublicPermission r6 = r5.b;
    L17:
        if (r6 != null) goto L19;
    L21:
        r1 = false;
    L22:
        if (r6 == null) goto L25;
        String r7 = r6.linkPassword();
        if (r7 == null) goto L25;
    L26:
        c(r1, r7);
        return;
    L25:
        r7 = "";
        goto L26
    L19:
        if (r6.hasLinkPassword() != true) goto L21;
    L16:
        r6 = null;
        goto L17
    L5:
        if (r0 == 2) goto L7;
        super.s10(r3);
        return;
    L7:
        tt5.a.h("BaseShareExternalPresenter", "onPasswordLink()...");
        this.d = ShareType.PasswordLink;
        h r8 = j();
        ShareFolderInfo r2 = r8.b;
        if (r2 == null) goto L30;
        r8.b(r2);
        return;
    }

    public FolderShareExternalPresenter(ShareParams r2, Context r3, com.bytedance.ee.bear.share.newshare.b r4, ShareFolderInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "shareHost");
        Intrinsics.checkNotNullParameter(r5, "shareFolderInfo");
        super(r2, r3, r4);
        this.i = r2;
        this.j = r3;
        this.k = r5;
    }
}
