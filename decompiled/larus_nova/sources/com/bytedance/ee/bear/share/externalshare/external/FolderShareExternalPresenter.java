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
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class FolderShareExternalPresenter extends com.bytedance.ee.bear.share.externalshare.external.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ShareParams f237037i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Context f237038j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public ShareFolderInfo f237039k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f237040l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Disposable f237041m;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f237042a = null;

        static {
            int[] r100 = new int[ShareType.values().length];
            r100[ShareType.CopyLink.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[ShareType.PasswordLink.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[ShareType.More.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ShareType.Weibo.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[ShareType.Wechat.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[ShareType.WechatMoments.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ShareType.QQ.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f237042a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void d() {
        Disposable r100 = this.f237040l;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        this.f237040l = null;
        Disposable r101 = this.f237041m;
        if (r101 == null) goto L8;
        r101.dispose();
    L8:
        this.f237041m = null;
    }

    public final h j() {
        Context r100 = this.f237038j;
        ShareFolderInfo r101 = this.f237039k;
        ShareParams r102 = this.f237037i;
        BaseOpenTencentHandler r103 = this.f237049g;
        if (r103 == null) goto L6;
        String r104 = r103.e();
        if (r104 == null) goto L6;
    L8:
        return new h(r100, r101, r102, r104, new FolderShareExternalPresenter$createPasswordLinkHandler$1(this), new FolderShareExternalPresenter$createPasswordLinkHandler$2(this));
    L6:
        r104 = "";
        goto L8
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final com.bytedance.ee.bear.share.export.f a() {
        return this.f237039k;
    }

    @Override // com.bytedance.ee.bear.bizwidget.shareview.b
    public final boolean Yl(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        switch(b.f237042a[r100.ordinal()]) {
            case 2: goto L22;
            case 3: goto L5;
            case 4: goto L5;
            case 5: goto L5;
            case 6: goto L5;
            case 7: goto L5;
            default: goto L18;
        };
    L5:
        ShareFolderInfo r101 = this.f237039k;
        if (r101 == null) goto L13;
        boolean r102 = r101.e();
        boolean r103 = r101.isLinkShareAnyoneRead();
        if (r102 == true) goto L13;
        if (r103 == true) goto L13;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (jg5.e.a.f499003a.i() == false) goto L13;
        Toast.showFailureText(this.f237038j, R.string.LarkCCM_CM_Mobile_ExSharing_TurnOnSwitchToViewOrEdit_Toast);
        boolean r104 = true;
    L14:
        if (r104 == false) goto L16;
        return false;
    L16:
        Intrinsics.checkNotNullParameter(r100, "shareType");
        return true;
    L13:
        r104 = false;
        goto L14
    L18:
        Intrinsics.checkNotNullParameter(r100, "shareType");
        return true;
    L22:
        return j().a();
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a
    public final void i(com.bytedance.ee.bear.share.export.f r110) {
        Intrinsics.checkNotNullParameter(r110, "shareInfo");
        if ((r110 instanceof ShareFolderInfo) == false) goto L5;
        ShareFolderInfo r100 = (ShareFolderInfo) r110;
    L6:
        if (r100 != null) goto L8;
        r100 = new ShareFolderInfo(0, null, null, null, null, null, null, null, null, 1023);
    L8:
        this.f237039k = r100;
        super.i(r110);
        return;
    L5:
        r100 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.share.externalshare.external.a, com.bytedance.ee.bear.bizwidget.shareview.b
    public final void s10(ShareType r100) {
        Intrinsics.checkNotNullParameter(r100, "shareType");
        Intrinsics.checkNotNullParameter(r100, "shareType");
        r100.getItemId();
        int r101 = b.f237042a[r100.ordinal()];
        boolean r102 = true;
        if (r101 != 1) goto L5;
        b();
        ShareFolderInfo r103 = this.f237039k;
        if (r103 == null) goto L16;
        ShareFolderPermission r104 = r103.f234260i;
        if (r104 == null) goto L16;
        IFolderPublicPermission r105 = r104.f234426b;
    L17:
        if (r105 != null) goto L19;
    L21:
        r102 = false;
    L22:
        if (r105 == null) goto L25;
        String r106 = r105.linkPassword();
        if (r106 == null) goto L25;
    L26:
        c(r102, r106);
        return;
    L25:
        r106 = "";
        goto L26
    L19:
        if (r105.hasLinkPassword() != true) goto L21;
    L16:
        r105 = null;
        goto L17
    L5:
        if (r101 == 2) goto L7;
        super.s10(r100);
        return;
    L7:
        tt5.a.h("BaseShareExternalPresenter", "onPasswordLink()...");
        this.f237046d = ShareType.PasswordLink;
        h r107 = j();
        ShareFolderInfo r108 = r107.f237094b;
        if (r108 == null) goto L30;
        r107.b(r108);
        return;
    }

    public FolderShareExternalPresenter(ShareParams r100, Context r101, com.bytedance.ee.bear.share.newshare.b r102, ShareFolderInfo r103) {
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "shareHost");
        Intrinsics.checkNotNullParameter(r103, "shareFolderInfo");
        super(r100, r101, r102);
        this.f237037i = r100;
        this.f237038j = r101;
        this.f237039k = r103;
    }
}
