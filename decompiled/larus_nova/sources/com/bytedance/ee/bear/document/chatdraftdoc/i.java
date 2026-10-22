package com.bytedance.ee.bear.document.chatdraftdoc;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.chatdraftdoc.bean.CreateResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f219212a;

    public final class a implements NetService.c<Result<CreateResponse>> {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.document.chatdraftdoc.i$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/chatdraftdoc/CreateChatDraftDocNetExecutor$ChatDraftDocParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/chatdraftdoc/bean/CreateResponse;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class C3123a extends TypeToken<Result<CreateResponse>> {
            public C3123a() {
            }
        }

        public a() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<CreateResponse> parse(String r100) {
            Object r101 = new Gson().fromJson(r100, new C3123a().getType());     // Catch: Exception -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Exception -> L4
            return (Result) r101;
        L4:
            e = move-exception;
            tt5.a.d("CreateChatDraftDocNetExecutor", "ChatDraftDocParser parse()...error = " + e);
            Result<CreateResponse> r102 = new Result();
            r102.code = -1;
            return r102;
        }
    }

    public static final class b {
    }

    static {
    }

    public i() {
        this.f219212a = new CompositeDisposable();
    }
}
