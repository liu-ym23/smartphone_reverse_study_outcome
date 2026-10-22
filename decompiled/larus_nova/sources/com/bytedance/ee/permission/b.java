package com.bytedance.ee.permission;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.list.dto.FolderVersion;
import com.bytedance.ee.bear.middleground.permission.apply.ApplyDocPermPuller;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.DocPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.middleground_permission_export.model.folder.ShareFolderUserPermission;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.permission.doc.GetPublicPermissionApi$Result;
import com.bytedance.ee.permission.doc.UpdatePublicPermissionApi$Result;
import com.larus.office.base.permission.r;
import com.ss.android.download.api.config.HttpMethod;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.permission.b$b, reason: collision with other inner class name */
    public static final class C3485b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ sbb.e f243013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f243014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ut5.a<Boolean> f243015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f243016d;

        /* JADX INFO: renamed from: com.bytedance.ee.permission.b$b$a */
        public static final class a implements ph5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ut5.a<Boolean> f243017a;

            public a(ut5.a<Boolean> r100) {
                this.f243017a = r100;
            }

            @Override // ph5.d
            public final void a(PermissionResponse r100) {
                Intrinsics.checkNotNullParameter(r100, "permissionResponse");
                ut5.a<Boolean> r101 = this.f243017a;
                if (r101 == null) goto L6;
                r101.onResult(Boolean.valueOf(r100.getAllow()));
                return;
            }
        }

        public C3485b(sbb.e r100, String r101, ut5.a<Boolean> r102, String r103) {
            this.f243013a = r100;
            this.f243014b = r101;
            this.f243015c = r102;
            this.f243016d = r103;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            UserPermissionEntity r101 = new UserPermissionEntity(r100, null);
            if (Intrinsics.areEqual(this.f243013a, sbb.e.f541295f) == false) goto L12;
            if ((r100 instanceof ShareFolderUserPermission) == false) goto L12;
            if (Intrinsics.areEqual(this.f243014b, "DELETE_ENTITY") == true) goto L9;
        L46:
            boolean r102 = false;
        L47:
            tt5.a.h("PermissionAllApis", "asyncValidate: operation = " + this.f243014b + " isDeniedByUserPermission:" + r102);
            if (r102 == false) goto L53;
            ut5.a<Boolean> r103 = this.f243015c;
            if (r103 == null) goto L55;
            r103.onResult(Boolean.FALSE);
            return;
        L55:
            return;
        L53:
            ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).b(new PermissionRequest(new BaseEntity(this.f243016d, this.f243013a, BizDomain.FileBizDomainCCM, null), this.f243014b), r101, new a(this.f243015c));
            return;
        L9:
            if (((ShareFolderUserPermission) r100).getActions().canOperateEntity() == true) goto L46;
        L45:
            r102 = true;
        L12:
            if ((r100 instanceof IDocUserPermission) == false) goto L46;
            String r104 = this.f243014b;
            switch(r104.hashCode()) {
                case -2084521848: goto L41;
                case -1116803173: goto L35;
                case -363473906: goto L29;
                case 992359671: goto L23;
                case 2059143092: goto L17;
                default: goto L46;
            };
        L17:
            if (r104.equals("EXPORT") == false) goto L46;
            if (((IDocUserPermission) r100).canExport() == true) goto L46;
        L23:
            if (r104.equals("DELETE_ENTITY") == false) goto L46;
            if (((IDocUserPermission) r100).canOperateEntity() == true) goto L46;
        L29:
            if (r104.equals("VIEW_PREVIEW") == false) goto L46;
            if (((IDocUserPermission) r100).canPreview() == true) goto L46;
        L35:
            if (r104.equals("CONTENT_COPY") == false) goto L46;
            if (((IDocUserPermission) r100).canCopy() == true) goto L46;
        L41:
            if (r104.equals(HttpMethod.DOWNLOAD) == false) goto L46;
            if (((IDocUserPermission) r100).canDownload() == true) goto L46;
            goto L45
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ut5.a<Boolean> f243018a;

        public c(ut5.a<Boolean> r100) {
            this.f243018a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            ut5.a<Boolean> r102 = this.f243018a;
            if (r102 == null) goto L6;
            r102.onError(-1, r101);
            return;
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ut5.a<DocPermission> f243019a;

        public d(ut5.a<DocPermission> r100) {
            this.f243019a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            DocPermission r101 = (DocPermission) r100;
            ut5.a<DocPermission> r102 = this.f243019a;
            if (r102 == null) goto L6;
            r102.onResult(r101);
            return;
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ut5.a<DocPermission> f243020a;

        public e(ut5.a<DocPermission> r100) {
            this.f243020a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("PermissionAllApis", "fetchDocPermission failed", r101, false);
            ut5.a<DocPermission> r102 = this.f243020a;
            if (r102 == null) goto L6;
            r102.onError(-1, r101);
            return;
        }
    }

    public static final class f<T extends Result> implements NetService.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f<T> f243021a = null;

        public static final class a extends TypeReference<Result<String>> {
            public a() {
            }
        }

        static {
            f243021a = new f();
        }

        public f() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<String> parse(String r100) {
            return (Result) JSON.parseObject(r100, new a(), new Feature[0]);
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ut5.a<Boolean> f243022a;

        public g(ut5.a<Boolean> r100) {
            this.f243022a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Result r101 = (Result) r100;
            if (r101.code != 0) goto L7;
            ut5.a<Boolean> r102 = this.f243022a;
            if (r102 == null) goto L11;
            r102.onResult(Boolean.TRUE);
            return;
        L11:
            return;
        L7:
            tt5.a.d("PermissionAllApis", "requestPasswordCheck error, code=" + r101.code);
            ut5.a<Boolean> r103 = this.f243022a;
            if (r103 == null) goto L13;
            r103.onError(r101.code, new NetService.ServerErrorException(r101.code, "requestPasswordCheck failed", "", ""));
            return;
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ut5.a<Boolean> f243023a;

        public h(ut5.a<Boolean> r100) {
            this.f243023a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            tt5.a.e("PermissionAllApis", "requestPasswordCheck failed", r101, false);
            ut5.a<Boolean> r102 = this.f243023a;
            if (r102 == null) goto L6;
            r102.onError(-1, r101);
            return;
        }
    }

    static {
    }

    public b() {
    }

    public final void d(vt5.a r100, ut5.a<GetPublicPermissionApi$Result> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        new vt5.b(r100, r101).b();
    }

    public final void f(vt5.c r100, ut5.a<UpdatePublicPermissionApi$Result> r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        new vt5.d(r100, r101).b();
    }

    public final Disposable c(String r100, int r101, ut5.a<DocPermission> r102) {
        Intrinsics.checkNotNullParameter(r100, "token");
        return new wh5.d().b(r100, r101).subscribe(new d(r102), new e(r102));
    }

    public final void b(String r100, int r110, String r111, ut5.a<Boolean> r112) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r111, WikiFolderPushPlugin.OPT);
        sbb.e r101 = sbb.e.d(r110);
        Intrinsics.checkNotNull(r101);
        if (Intrinsics.areEqual(r101, sbb.e.f541295f) == false) goto L5;
        Flowable r113 = xh5.a.f563873a.c(r100, new FolderVersion(0, 0, false, 7, null), false).map(com.bytedance.ee.permission.e.f243043a);
        Intrinsics.checkNotNull(r113);
    L6:
        r113.subscribe(new C3485b(r101, r111, r112, r100), new c(r112));
        return;
    L5:
        int r102 = wh5.b.f559668a;
        Intrinsics.checkNotNullParameter(r100, "token");
        r113 = wh5.b.b(r100, r110, "", -1).map(com.bytedance.ee.permission.f.f243044a);
        Intrinsics.checkNotNull(r113);
        goto L6
    }

    public final void a(String r100, String r101, int r102, String r103, r r104) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "objType");
        new ApplyDocPermPuller((NetService) org.koin.java.a.c(NetService.class, null, null, 6)).a(new ApplyDocPermPuller.Params(r100, r101, r103, String.valueOf(r102))).subscribe(new com.bytedance.ee.permission.c(r104), new com.bytedance.ee.permission.d(r104));
    }

    public final Disposable e(String r100, int r101, String r102, boolean r103, ut5.a<Boolean> r110) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r102, "password");
        NetService r104 = (NetService) org.koin.java.a.c(NetService.class, null, null, 6);
        int r105 = ii5.c.f489992a;
        if (r103 == false) goto L5;
        String r106 = "/space/api/suite/permission/space/password/input/";
    L6:
        NetService.f r107 = new NetService.f(r106);
        r107.f216906c = 1;
        JSONObject r108 = new JSONObject();
        r108.put("token", r100);
        r108.put("type", Integer.valueOf(r101));
        r108.put("password", r102);
        r107.f216913j = r108.toJSONString();
        return r104.Vc(f.f243021a).a(r107).subscribe(new g(r110), new h(r110));
    L5:
        r106 = "/api/suite/permission/password/input/";
        goto L6
    }
}
