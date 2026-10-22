package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground_permission_export.model.ShareFolderUtils;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IRequestCallback;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final FolderVersion a;
    public final String b;
    public final String c;
    public final CompositeDisposable d;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder.b$b, reason: collision with other inner class name */
    public static final class C0107b<T> implements Consumer {
        public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> a;

        public C0107b(IRequestCallback<ShareUserInfoResult, Throwable> r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            IRequestCallback<ShareUserInfoResult, Throwable> r0 = this.a;
            r0.onSuccess((ShareUserInfoResult) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> a;

        public c(IRequestCallback<ShareUserInfoResult, Throwable> r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            tt5.a.f("ShareFolderMemberModel", (Throwable) r3, false);
            this.a.onError(new ErrorResult("fetchShareFolderCollaborate()...Error"));
        }
    }

    static {
    }

    public final void a(IRequestCallback<ShareUserInfoResult, Throwable> r9) {
        Intrinsics.checkNotNullParameter(r9, "callback");
        if (this.a.isFolderV1() == true) goto L5;
        b(this.c, this.b, r9, this.a);
        return;
    L5:
        if (TextUtils.isEmpty(this.c) == false) goto L14;
        AccountService.Account r0 = ((h0) org.koin.java.a.a(h0.class)).G2();
        if (r0 != null) goto L9;
        tt5.a.d("CollaboratorUtils", "getDefaultFolderOwner account is null!");
        UserInfo r1 = null;
    L10:
        ArrayList<UserInfo> r3 = new ArrayList();
        if (r1 == null) goto L13;
        r3.add(r1);
    L13:
        ShareUserInfoResult r2 = new ShareUserInfoResult();
        r2.setTotalNum(1);
        r2.setUserInfoList(r3);
        r2.setHasMore(false);
        r9.onSuccess(r2);
        return;
    L9:
        String r4 = ((i0) org.koin.java.a.a(i0.class)).a();
        UserInfo r5 = new UserInfo();
        r5.setId(r0.uid);
        r5.setAvatarUrl(r0.avatarUrl);
        r5.setTenantId(r0.tenantId);
        r5.setTenantName(r0.tenantName);
        String r6 = Locale.CHINESE.getLanguage();
        String r7 = r0.displayName;
        String r8 = r0.cnName;
        r5.setCnName(ou5.a.d(r6, r7, r8, r8));
        String r10 = Locale.ENGLISH.getLanguage();
        String r11 = r0.displayName;
        String r12 = r0.enName;
        r5.setEnName(ou5.a.d(r10, r11, r12, r12));
        String r13 = r0.displayName;
        String r14 = r0.userName;
        r5.setName(ou5.a.d(r4, r13, r14, r14));
        r5.setOwner(true);
        r5.setOwnerType(0);
        r5.setLabel(r0.organization);
        r5.setPermission(ShareFolderUtils.a());
        r1 = r5;
        goto L10
    L14:
        b(this.c, this.b, r9, this.a);
    }

    public b(FolderVersion r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "version");
        Intrinsics.checkNotNullParameter(r3, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r4, "spaceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new CompositeDisposable();
    }

    public final void b(String r2, String r3, IRequestCallback<ShareUserInfoResult, Throwable> r4, FolderVersion r5) {
        if (r5.isShareFolderV2() == false) goto L5;
        r2 = r3;
    L5:
        boolean r6 = r5.isShareFolderV2();
        int r7 = xh5.c.a;
        if (r6 == false) goto L8;
        si5.b r8 = xh5.a.a;
    L9:
        Disposable r9 = r8.a(r2).subscribe(new C0107b(r4), new c(r4));
        tt5.a.h("ShareFolderMemberModel", "fetchShareFolderCollaborate");
        this.d.add(r9);
        return;
    L8:
        r8 = xh5.d.a;
        goto L9
    }
}
