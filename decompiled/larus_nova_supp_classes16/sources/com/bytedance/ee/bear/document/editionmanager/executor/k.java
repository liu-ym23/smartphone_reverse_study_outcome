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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k {
    public final NetService a;

    public static class a implements NetService.c<Result<TokenResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.editionmanager.executor.k$a$a, reason: collision with other inner class name */
        public class C0070a extends TypeToken<Result<TokenResult>> {
            public C0070a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<TokenResult> parse(String r3) throws NetService.ParseException {
            Result<TokenResult> r0 = (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new C0070a().getType());
            if (r0 == null) goto L5;
            return r0;
        L5:
            tt5.a.d("EditionNetExecutor", "parse CheckTokenParser error, " + r3);
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
        public final Result<EditionListResult> parse(String r3) throws NetService.ParseException {
            Result<EditionListResult> r0 = (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new a().getType());
            if (r0 == null) goto L5;
            return r0;
        L5:
            tt5.a.d("EditionNetExecutor", "parse EditionListParser error, " + r3);
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
        public final Result<EditionTokenResult> parse(String r3) throws NetService.ParseException {
            Result<EditionTokenResult> r0 = (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new a().getType());
            if (r0 == null) goto L5;
            return r0;
        L5:
            tt5.a.d("EditionNetExecutor", "parse VersionTokenParser error, " + r3);
            throw new NetService.ParseException();
        }
    }

    public k(NetService r1) {
        this.a = r1;
    }

    public final void a(String r4, int r5, String r6, final c15.b r7) {
        NetService.d r0 = this.a.Vc(new b());
        String r8 = String.valueOf(r5);
        NetService.e r1 = new NetService.f("/space/api/platform/version/list/");
        r1.c = 2;
        r1.b(DocViewModel.EXTRA_PARENT_TOKEN, r4);
        r1.b("obj_type", r8);
        r1.b("page_size", String.valueOf(10));
        if (TextUtils.isEmpty(r6) == true) goto L5;
        r1.b("page_token", r6);
    L5:
        HashMap r9 = new HashMap();
        r9.put("Content-Type", "application/x-www-form-urlencoded");
        r1.c(r9);
        r0.a(r1).subscribe(new d(r7), new e(r7));
    }
}
