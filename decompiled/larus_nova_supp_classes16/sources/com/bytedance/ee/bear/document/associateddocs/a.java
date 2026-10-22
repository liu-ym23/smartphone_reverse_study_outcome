package com.bytedance.ee.bear.document.associateddocs;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.associateddocs.bean.AppUrlAssociatedDocResult;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedExitingDocResult;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedPluginsInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.AssociatedUrlInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.CreateAndAssociatedDocResult;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$a, reason: collision with other inner class name */
    public interface InterfaceC0055a {
        void a(AppUrlAssociatedDocResult r1);
    }

    public interface b {
        void a(AssociatedPluginsInfo r1);
    }

    public final class c implements NetService.c<Result<AssociatedUrlInfo>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$c$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AppUrlAssociatedDocEnableParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedUrlInfo;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0056a extends TypeToken<Result<AssociatedUrlInfo>> {
            public C0056a() {
            }
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AssociatedUrlInfo> parse(String r4) {
            Result<AssociatedUrlInfo> r0 = new Result();
            return (Result) new Gson().fromJson(r4, new C0056a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r0;
        }
    }

    public final class d implements NetService.c<Result<AppUrlAssociatedDocResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$d$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AppUrlAssociatedDocParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AppUrlAssociatedDocResult;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0057a extends TypeToken<Result<AppUrlAssociatedDocResult>> {
            public C0057a() {
            }
        }

        public d() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AppUrlAssociatedDocResult> parse(String r4) {
            Result<AppUrlAssociatedDocResult> r0 = new Result();
            return (Result) new Gson().fromJson(r4, new C0057a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r0;
        }
    }

    public interface e {
        void a(int r1, String r2);
    }

    public final class f implements NetService.c<Result<AssociatedExitingDocResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$f$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AssociatedExitingDocsParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedExitingDocResult;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0058a extends TypeToken<Result<AssociatedExitingDocResult>> {
            public C0058a() {
            }
        }

        public f() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AssociatedExitingDocResult> parse(String r4) {
            Result<AssociatedExitingDocResult> r0 = new Result();
            return (Result) new Gson().fromJson(r4, new C0058a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r0;
        }
    }

    public static final class g {
    }

    public final class h implements NetService.c<Result<CreateAndAssociatedDocResult>> {
        public h() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CreateAndAssociatedDocResult> parse(String r5) {
            String r1 = "";
            CreateAndAssociatedDocResult r0 = new CreateAndAssociatedDocResult("");
            if (r5 == null) goto L20;
            JSONObject r6 = new JSONObject(r5).optJSONObject("data");
            if (r6 == null) goto L20;
            JSONObject r2 = r6.optJSONObject("entities");
            if (r2 == null) goto L20;
            JSONArray r7 = JSONObjectProtectorUtils.getJSONArray(r6, "node_list");
            if (r7.length() <= 0) goto L20;
            JSONObject r3 = r2.optJSONObject("nodes");
            String r8 = JSONArrayProtectorUtils.getString(r7, 0);
            if (r3 == null) goto L13;
            JSONObject r9 = r3.optJSONObject(r8);
        L14:
            if (r9 == null) goto L19;
            String r10 = r9.optString("url");
            if (r10 == null) goto L19;
            r1 = r10;
        L19:
            r0.setUrl(r1);
            goto L20
        L13:
            r9 = null;
        L20:
            Result<CreateAndAssociatedDocResult> r11 = new Result();
            r11.data = r0;
            return r11;
        }
    }

    static {
    }

    public a() {
    }

    public static NetService.f a(String r6, List r7, String r8) {
        NetService.f r0 = new NetService.f(r8);
        r0.c = 1;
        JSONObject r9 = new JSONObject();
        JSONArray r1 = new JSONArray();
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Pair r2 = (Pair) r10.next();
        JSONObject r3 = new JSONObject();
        r3.put("obj_token", r2.getFirst());
        r3.put("obj_type", r2.getSecond());
        r1.put(r3);
        goto L4
    L6:
        r9.put("app_url", r6);
        r9.put("obj_list", r1);
        r0.j = r9.toString();
        HashMap r11 = new HashMap();
        r11.put("Content-Type", "application/x-www-form-urlencoded");
        r0.c(r11);
        return r0;
    }
}
