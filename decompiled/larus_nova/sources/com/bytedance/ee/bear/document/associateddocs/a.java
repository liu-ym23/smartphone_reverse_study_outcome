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

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$a, reason: collision with other inner class name */
    public interface InterfaceC3111a {
        void a(AppUrlAssociatedDocResult r100);
    }

    public interface b {
        void a(AssociatedPluginsInfo r100);
    }

    public final class c implements NetService.c<Result<AssociatedUrlInfo>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$c$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AppUrlAssociatedDocEnableParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedUrlInfo;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3112a extends TypeToken<Result<AssociatedUrlInfo>> {
            public C3112a() {
            }
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AssociatedUrlInfo> parse(String r100) {
            Result<AssociatedUrlInfo> r101 = new Result();
            return (Result) new Gson().fromJson(r100, new C3112a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r101;
        }
    }

    public final class d implements NetService.c<Result<AppUrlAssociatedDocResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$d$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AppUrlAssociatedDocParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AppUrlAssociatedDocResult;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3113a extends TypeToken<Result<AppUrlAssociatedDocResult>> {
            public C3113a() {
            }
        }

        public d() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AppUrlAssociatedDocResult> parse(String r100) {
            Result<AppUrlAssociatedDocResult> r101 = new Result();
            return (Result) new Gson().fromJson(r100, new C3113a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r101;
        }
    }

    public interface e {
        void a(int r100, String r101);
    }

    public final class f implements NetService.c<Result<AssociatedExitingDocResult>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.a$f$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/associateddocs/AssociatedDocNetExecutor$AssociatedExitingDocsParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/associateddocs/bean/AssociatedExitingDocResult;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3114a extends TypeToken<Result<AssociatedExitingDocResult>> {
            public C3114a() {
            }
        }

        public f() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<AssociatedExitingDocResult> parse(String r100) {
            Result<AssociatedExitingDocResult> r101 = new Result();
            return (Result) new Gson().fromJson(r100, new C3114a().getType());
        L5:
            e = move-exception;
            tt5.a.d("AssociatedDocNetExecutor", "parse()...error = " + e);
            return r101;
        }
    }

    public static final class g {
    }

    public final class h implements NetService.c<Result<CreateAndAssociatedDocResult>> {
        public h() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CreateAndAssociatedDocResult> parse(String r100) {
            String r101 = "";
            CreateAndAssociatedDocResult r102 = new CreateAndAssociatedDocResult("");
            if (r100 == null) goto L20;
            JSONObject r103 = new JSONObject(r100).optJSONObject("data");
            if (r103 == null) goto L20;
            JSONObject r104 = r103.optJSONObject("entities");
            if (r104 == null) goto L20;
            JSONArray r105 = JSONObjectProtectorUtils.getJSONArray(r103, "node_list");
            if (r105.length() <= 0) goto L20;
            JSONObject r106 = r104.optJSONObject("nodes");
            String r107 = JSONArrayProtectorUtils.getString(r105, 0);
            if (r106 == null) goto L13;
            JSONObject r108 = r106.optJSONObject(r107);
        L14:
            if (r108 == null) goto L19;
            String r109 = r108.optString("url");
            if (r109 == null) goto L19;
            r101 = r109;
        L19:
            r102.setUrl(r101);
            goto L20
        L13:
            r108 = null;
        L20:
            Result<CreateAndAssociatedDocResult> r110 = new Result();
            r110.data = r102;
            return r110;
        }
    }

    static {
    }

    public a() {
    }

    public static NetService.f a(String r100, List r101, String r102) {
        NetService.f r103 = new NetService.f(r102);
        r103.f216906c = 1;
        JSONObject r104 = new JSONObject();
        JSONArray r105 = new JSONArray();
        Iterator r106 = r101.iterator();
    L4:
        if (r106.hasNext() == false) goto L6;
        Pair r107 = (Pair) r106.next();
        JSONObject r108 = new JSONObject();
        r108.put("obj_token", r107.getFirst());
        r108.put("obj_type", r107.getSecond());
        r105.put(r108);
        goto L4
    L6:
        r104.put("app_url", r100);
        r104.put("obj_list", r105);
        r103.f216913j = r104.toString();
        HashMap r109 = new HashMap();
        r109.put("Content-Type", "application/x-www-form-urlencoded");
        r103.c(r109);
        return r103;
    }
}
