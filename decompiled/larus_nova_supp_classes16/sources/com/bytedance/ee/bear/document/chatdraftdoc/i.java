package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i {
    public final CompositeDisposable a;

    public final class a implements NetService.c<Result<CreateResponse>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.chatdraftdoc.i$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/chatdraftdoc/CreateChatDraftDocNetExecutor$ChatDraftDocParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/CreateResponse;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C0067a extends TypeToken<Result<CreateResponse>> {
            public C0067a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CreateResponse> parse(String r3) {
            Object r4 = new Gson().fromJson(r3, new C0067a().getType());     // Catch: Exception -> L4
            Intrinsics.checkNotNull(r4);     // Catch: Exception -> L4
            return (Result) r4;
        L4:
            e = move-exception;
            tt5.a.d("CreateChatDraftDocNetExecutor", "ChatDraftDocParser parse()...error = " + e);
            Result<CreateResponse> r5 = new Result();
            r5.code = -1;
            return r5;
        }
    }

    public static final class b {
    }

    static {
    }

    public i() {
        this.a = new CompositeDisposable();
    }
}
