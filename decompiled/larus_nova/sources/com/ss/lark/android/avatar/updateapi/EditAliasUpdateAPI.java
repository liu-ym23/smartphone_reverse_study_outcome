package com.ss.lark.android.avatar.updateapi;

import android.content.Context;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.uploader.entity.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/ss/lark/android/avatar/updateapi/EditAliasUpdateAPI;", "Lcom/ss/lark/android/avatar/updateapi/IUpdateAvatarAPI;", "<init>", "()V", "doRequest", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "avatarPath", "", "callback", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Companion", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EditAliasUpdateAPI implements IUpdateAvatarAPI {
    public static final a Companion = null;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends dlb.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IGetDataCallback<String> f456784a;

        @Override // dlb.b
        public final void d() {
            this.f456784a.onError(new ErrorResult(-1));
        }

        public b(IGetDataCallback<String> r100) {
            this.f456784a = r100;
        }

        @Override // dlb.b
        public final void i(int r100, String r101) {
            this.f456784a.onError(new ErrorResult(r100, r101));
        }

        @Override // dlb.b
        public final void k(com.ss.android.lark.image.uploader.entity.b r100, c r101) {
            Intrinsics.checkNotNullParameter(r100, "image");
            if (r101 == null) goto L6;
            this.f456784a.onSuccess(r101.f426410a);
            return;
        }

        @Override // dlb.b
        public final void j(int r100, com.ss.android.lark.image.uploader.entity.b r101, long r102, int r103, int r104) {
            this.f456784a.onError(new ErrorResult(r100));
        }
    }

    static {
        Companion = new a();
    }

    public EditAliasUpdateAPI() {
    }

    @Override // com.ss.lark.android.avatar.updateapi.IUpdateAvatarAPI
    public void doRequest(Context r100, String r101, IGetDataCallback<String> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "avatarPath");
        Intrinsics.checkNotNullParameter(r102, "callback");
        com.ss.android.lark.image.uploader.entity.b.a r103 = new com.ss.android.lark.image.uploader.entity.b.a();
        Intrinsics.checkNotNullParameter(r101, "path");
        r103.f426401a = r101;
        r103.d(Scene.Profile);
        r103.a(Biz.Core);
        r103.f426404d = 12;
        Intrinsics.checkNotNullParameter("EditAliasUpdate", "page");
        r103.f426405e = "EditAliasUpdate";
        com.ss.android.lark.image.uploader.entity.b r104 = r103.b();
        int r105 = ykb.a.f568290b;
        ykb.a r106 = ykb.a.C8350a.a(r100);
        r106.b(r104);
        r106.a(new b(r102));
        r106.f568291a.f426381g = new com.ss.android.lark.image.uploader.upload.b();
        r106.c();
    }

    @Override // com.ss.lark.android.avatar.updateapi.IUpdateAvatarAPI
    public void doRequestByAvatarKey(Context r100, String r101, IGetDataCallback<String> r102) {
        IUpdateAvatarAPI.a.a(r100, r101, r102);
    }
}
