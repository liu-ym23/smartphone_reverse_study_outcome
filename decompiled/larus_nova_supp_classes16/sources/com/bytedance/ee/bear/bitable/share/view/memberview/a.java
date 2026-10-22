package com.bytedance.ee.bear.bitable.share.view.memberview;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground_permission_export.model.share.ShareUserInfoResult;
import com.larksuite.framework.callback.IRequestCallback;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import pu4.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final String a;
    public String b;
    public final CompositeDisposable c;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.share.view.memberview.a$a, reason: collision with other inner class name */
    public static final class C0021a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ IRequestCallback<ShareUserInfoResult, Throwable> a;

        public b(IRequestCallback<ShareUserInfoResult, Throwable> r1) {
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

        public final void accept(Object r2) {
            IRequestCallback<ShareUserInfoResult, Throwable> r0 = this.a;
            r0.onError((Throwable) r2);
        }
    }

    static {
    }

    public final void a(IRequestCallback<ShareUserInfoResult, Throwable> r10) {
        Intrinsics.checkNotNullParameter(r10, "callback");
        if (this.b.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        r10.onSuccess(new ShareUserInfoResult());
        return;
    L9:
        String r1 = this.a;
        String r3 = this.b;
        int r4 = pu4.a.a;
        Intrinsics.checkNotNullParameter(r1, "baseToken");
        Intrinsics.checkNotNullParameter(r3, "shareToken");
        Intrinsics.checkNotNullParameter("", "lastLabel");
        tt5.a.h("BitableSharePermissionManager", "fetchCollaborators()...lastLabel = ");
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        NetService.f r2 = new NetService.f(String.format("/space/api/bitable/%s/share/permission/members", Arrays.copyOf(new Object[]{r1}, 1)));
        r2.b("shareToken", r3);
        r2.b("lastLabel", "");
        r2.c = 2;
        this.c.add(((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).Vc(new g()).a(r2).subscribe(new b(r10), new c(r10)));
        return;
    L5:
        r0 = false;
        goto L6
    }

    public a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "shareToken");
        this.a = r2;
        this.b = r3;
        this.c = new CompositeDisposable();
    }
}
