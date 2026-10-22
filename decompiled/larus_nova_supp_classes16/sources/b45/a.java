package b45;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.synced.block.references.entity.DocReferencesResult;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final NetService a;

    /* JADX INFO: renamed from: b45.a$a, reason: collision with other inner class name */
    public static final class C0006a {
    }

    public static final class b implements NetService.c<Result<DocReferencesResult>> {

        /* JADX INFO: renamed from: b45.a$b$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/synced/block/references/repository/SyncedSourceReferencesRepository$DocumentReferencesParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/synced/block/references/entity/DocReferencesResult;", "docs-doc-impl-native_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0007a extends TypeToken<Result<DocReferencesResult>> {
            public C0007a() {
            }
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<DocReferencesResult> parse(String r3) {
            Intrinsics.checkNotNullParameter(r3, "json");
            return (Result) GsonProtectorUtils.fromJson(new Gson(), r3, new C0007a().getType());
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            Result r3 = (Result) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            return (DocReferencesResult) r3.data;
        }
    }

    public static final class d<T> implements Consumer {
        public static final d<T> a = null;

        static {
            a = new d();
        }

        public d() {
        }

        public final void accept(Object r3) {
            tt5.a.f("SyncedSourceReferencesRepository", (Throwable) r3, false);
        }
    }

    static {
    }

    public a(NetService r2) {
        Intrinsics.checkNotNullParameter(r2, "netService");
        this.a = r2;
    }

    public final Flowable<DocReferencesResult> a(boolean r3, String r4, String r5, Integer r6, String r7, Integer r8, int r9) {
        NetService.f r0 = new NetService.f("/space/api/block/reference");
        r0.c = 2;
        r0.b("resource_token", r5);
        r0.b("resource_type", String.valueOf(r6));
        if (r3 == true) goto L5;
        r0.b("docx_synced_block_host_token", r7);
        r0.b("docx_synced_block_host_type", String.valueOf(r8));
    L5:
        r0.b("break_point", r4);
        r0.b("limit", String.valueOf(r9));
        return this.a.Vc(new b()).a(r0).map(c.a).doOnError(d.a);
    }
}
