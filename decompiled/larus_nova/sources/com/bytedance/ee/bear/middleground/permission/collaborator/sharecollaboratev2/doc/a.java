package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.larksuite.framework.callback.IRequestCallback;
import com.lynx.tasm.LynxError;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f233697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f233698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CompositeDisposable f233699c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.doc.a$a, reason: collision with other inner class name */
    public static final class C3352a {
    }

    public static final class b implements ax4.e<ShareUserInfoResult> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f233700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> f233701b;

        @Override // ax4.e
        public final void onFailed(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            this.f233701b.onError(r100);
        }

        @Override // ax4.e
        public final void onSuccess(ShareUserInfoResult r100) {
            ShareUserInfoResult r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            a.a(this.f233700a, r101.getUserInfoList());
            this.f233701b.onSuccess(r101);
        }

        public b(a r100, IRequestCallback<ShareUserInfoResult, Throwable> r101) {
            this.f233700a = r100;
            this.f233701b = r101;
        }
    }

    static {
    }

    public final void b(IRequestCallback<ShareUserInfoResult, Throwable> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        int r101 = this.f233697a;
        String r102 = this.f233698b;
        b r103 = new b(this, r100);
        int r104 = li5.c.f509359a;
        Intrinsics.checkNotNullParameter(r103, "callback");
        NetService.f r105 = new NetService.f("/space/api/suite/permission/synced_block/members/");
        if (r102 != null) goto L5;
        String r106 = "";
    L6:
        r105.b("token", r106);
        r105.b("type", String.valueOf(r101));
        NetService r107 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        if (r102 != null) goto L9;
        r102 = "";
    L9:
        Disposable r108 = r107.Vc(new zg5.a(r102)).a(r105).subscribe(new li5.d(r103), new li5.e(r103));
        this.f233699c.add(r108);
        return;
    L5:
        r106 = r102;
        goto L6
    }

    public a(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f233697a = r100;
        this.f233698b = r101;
        this.f233699c = new CompositeDisposable();
    }

    public static final void a(a r100, ArrayList r101) {
        r100.getClass();
        if (r101.size() == 0) goto L13;
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L21;
        UserInfo r103 = (UserInfo) r102.next();
        if (TextUtils.isEmpty(r103.getAvatarUrl()) == false) goto L7;
        if (r103.isUnknownType() == false) goto L7;
        tt5.a.k("ShareDocMemberModel", "Unknown user:" + r103.getOwnerType());
        r102.remove();
        goto L7
    L21:
        return;
    }
}
