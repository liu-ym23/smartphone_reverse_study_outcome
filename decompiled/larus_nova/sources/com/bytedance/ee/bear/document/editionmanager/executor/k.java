package com.bytedance.ee.bear.document.editionmanager.executor;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.editionmanager.data.EditionListResult;
import com.bytedance.ee.bear.document.editionmanager.data.EditionTokenResult;
import com.bytedance.ee.bear.document.editionmanager.data.TokenResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;

/* JADX INFO: loaded from: classes16.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetService f219626a;

    public static class a implements NetService.c<Result<TokenResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.executor.k$a$a, reason: collision with other inner class name */
        public class C3126a extends TypeToken<Result<TokenResult>> {
            public C3126a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<TokenResult> parse(String r100) throws NetService.ParseException {
            Result<TokenResult> r101 = (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new C3126a().getType());
            if (r101 == null) goto L5;
            return r101;
        L5:
            tt5.a.d("EditionNetExecutor", "parse CheckTokenParser error, " + r100);
            throw new NetService.ParseException();
        }
    }

    public static class b implements NetService.c<Result<EditionListResult>> {

        public class a extends TypeToken<Result<EditionListResult>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<EditionListResult> parse(String r100) throws NetService.ParseException {
            Result<EditionListResult> r101 = (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
            if (r101 == null) goto L5;
            return r101;
        L5:
            tt5.a.d("EditionNetExecutor", "parse EditionListParser error, " + r100);
            throw new NetService.ParseException();
        }
    }

    public static class c implements NetService.c<Result<EditionTokenResult>> {

        public class a extends TypeToken<Result<EditionTokenResult>> {
            public a() {
            }
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<EditionTokenResult> parse(String r100) throws NetService.ParseException {
            Result<EditionTokenResult> r101 = (Result) GsonProtectorUtils.fromJson(new Gson(), r100, new a().getType());
            if (r101 == null) goto L5;
            return r101;
        L5:
            tt5.a.d("EditionNetExecutor", "parse VersionTokenParser error, " + r100);
            throw new NetService.ParseException();
        }
    }

    public k(NetService r100) {
        this.f219626a = r100;
    }

    public final void a(String r100, int r101, String r102, final c15.b r103) {
        NetService.d r104 = this.f219626a.Vc(new b());
        String r105 = String.valueOf(r101);
        NetService.e r106 = new NetService.f("/space/api/platform/version/list/");
        r106.f216906c = 2;
        r106.b(DocViewModel.EXTRA_PARENT_TOKEN, r100);
        r106.b("obj_type", r105);
        r106.b("page_size", String.valueOf(10));
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r106.b("page_token", r102);
    L5:
        HashMap r107 = new HashMap();
        r107.put("Content-Type", "application/x-www-form-urlencoded");
        r106.c(r107);
        r104.a(r106).subscribe(new d(r103), new e(r103));
    }
}
