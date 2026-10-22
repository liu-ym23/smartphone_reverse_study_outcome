package com.bytedance.ee.bear.document.sharewords;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.document.sharewords.bean.ShareWordsThumbnailResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.reactivex.disposables.CompositeDisposable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f221794a;

    public static final class a {
    }

    public final class b implements NetService.c<Result<ShareWordsThumbnailResponse>> {

        @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/ee/bear/document/sharewords/ShareWordsNetExecutor$ShareWordsThumbnailParser$parse$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/bytedance/ee/bear/contract/Result;", "Lcom/bytedance/ee/bear/document/sharewords/bean/ShareWordsThumbnailResponse;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class a extends TypeToken<Result<ShareWordsThumbnailResponse>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<ShareWordsThumbnailResponse> parse(String r100) {
            Object r101 = new Gson().fromJson(r100, new a().getType());     // Catch: Exception -> L4
            Intrinsics.checkNotNull(r101);     // Catch: Exception -> L4
            return (Result) r101;
        L4:
            e = move-exception;
            tt5.a.d("ShareWordsNetExecutor", "ShareWordsThumbnailParser parse()...error = " + e);
            Result<ShareWordsThumbnailResponse> r102 = new Result();
            r102.code = -1;
            return r102;
        }
    }

    public interface c {
        void a(ShareWordsThumbnailResponse r100);
    }

    static {
    }

    public d() {
        this.f221794a = new CompositeDisposable();
    }
}
