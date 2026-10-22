package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.callback.IRequestCallback;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final int a;
    public final String b;
    public final CompositeDisposable c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a$a, reason: collision with other inner class name */
    public static final class C0105a {
    }

    public static final class b implements ax4.e<ShareUserInfoResult> {
        public final /* synthetic */ a a;
        public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> b;

        public final void onFailed(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            this.b.onError(r2);
        }

        public final void onSuccess(Object r3) {
            ShareUserInfoResult r4 = (ShareUserInfoResult) r3;
            Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
            a.a(this.a, r4.getUserInfoList());
            this.b.onSuccess(r4);
        }

        public b(a r1, IRequestCallback<ShareUserInfoResult, Throwable> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void b(IRequestCallback<ShareUserInfoResult, Throwable> r7) {
        Intrinsics.checkNotNullParameter(r7, "callback");
        int r1 = this.a;
        String r2 = this.b;
        b r3 = new b(this, r7);
        int r8 = li5.c.a;
        Intrinsics.checkNotNullParameter(r3, "callback");
        NetService.f r9 = new NetService.f("/space/api/suite/permission/synced_block/members/");
        if (r2 != null) goto L5;
        String r4 = "";
    L6:
        r9.b(ResourceData.KEY_TOKEN, r4);
        r9.b(ResourceData.KEY_TYPE, String.valueOf(r1));
        NetService r5 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        if (r2 != null) goto L9;
        r2 = "";
    L9:
        Disposable r10 = r5.Vc(new zg5.a(r2)).a(r9).subscribe(new li5.d(r3), new li5.e(r3));
        this.c.add(r10);
        return;
    L5:
        r4 = r2;
        goto L6
    }

    public a(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        this.a = r2;
        this.b = r3;
        this.c = new CompositeDisposable();
    }

    public static final void a(a r2, ArrayList r3) {
        r2.getClass();
        if (r3.size() == 0) goto L13;
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L21;
        UserInfo r5 = (UserInfo) r4.next();
        if (TextUtils.isEmpty(r5.getAvatarUrl()) == false) goto L7;
        if (r5.isUnknownType() == false) goto L7;
        tt5.a.k("ShareDocMemberModel", "Unknown user:" + r5.getOwnerType());
        r4.remove();
        goto L7
    L21:
        return;
    }
}
