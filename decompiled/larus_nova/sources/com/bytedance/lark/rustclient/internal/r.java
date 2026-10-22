package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.sdk.InvokeResponse;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class r<Resp> implements com.bytedance.lark.rustclient.api.k<Resp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.lark.rustclient.api.m> f254012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.b<Resp> f254013b;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.lark.rustclient.api.n<Resp> f254014a;

        public a(com.bytedance.lark.rustclient.api.n<Resp> r100) {
            this.f254014a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
            com.bytedance.lark.rustclient.api.d<Resp> r102 = this.f254014a.f253917c.f253903a;
            StringBuilder r103 = new StringBuilder("async invoke return response: ");
            Intrinsics.checkNotNull(r101);
            com.bytedance.lark.rustclient.api.p r104 = com.bytedance.lark.rustclient.api.t.f253927a;
            Intrinsics.checkNotNullParameter(r101, "response");
            if ((r101 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L6;
            String r105 = "succeed";
        L8:
            r103.append(r105);
            r103.append('.');
            z.a(r102, r103.toString());
            return;
        L6:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L11;
            r105 = "error";
            goto L8
        L11:
            throw new NoWhenBranchMatchedException();
        }
    }

    @Override // com.bytedance.lark.rustclient.api.k
    public final Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Resp>> a() {
        com.bytedance.lark.rustclient.api.n r100 = new com.bytedance.lark.rustclient.api.n(this.f254012a, 0, this.f254013b);
        z.a(r100.f253917c.f253903a, "start to async invoke.");
        return r100.b(this.f254013b).doOnNext(new a(r100));
    }

    @Override // com.bytedance.lark.rustclient.api.k
    public final com.bytedance.lark.rustclient.api.s<InvokeResponse, Resp> execute() {
        List<com.bytedance.lark.rustclient.api.m> r100 = this.f254012a;
        com.bytedance.lark.rustclient.api.b<Resp> r101 = this.f254013b;
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "input");
        z.a(r101.f253903a, "start to sync invoke.");
        com.bytedance.lark.rustclient.api.b<Resp> r102 = this.f254013b;
        Intrinsics.checkNotNullParameter(r102, "input");
        com.bytedance.lark.rustclient.api.n<Resp> r103 = new com.bytedance.lark.rustclient.api.n(r100, 0 + 1, r102);
        com.bytedance.lark.rustclient.api.s<InvokeResponse, Resp> r104 = ((com.bytedance.lark.rustclient.api.m) ListProtector.get(r100, 0)).b(r103);
        com.bytedance.lark.rustclient.api.d<Resp> r105 = r101.f253903a;
        StringBuilder r106 = new StringBuilder("sync invoke return response: ");
        com.bytedance.lark.rustclient.api.p r107 = com.bytedance.lark.rustclient.api.t.f253927a;
        Intrinsics.checkNotNullParameter(r104, "response");
        if ((r104 instanceof com.bytedance.lark.rustclient.api.x) == false) goto L6;
        String r108 = "succeed";
    L8:
        r106.append(r108);
        r106.append('.');
        z.a(r105, r106.toString());
        return r104;
    L6:
        if ((r104 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L11;
        r108 = "error";
        goto L8
    L11:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public r(List<? extends com.bytedance.lark.rustclient.api.m> r100, com.bytedance.lark.rustclient.api.b<Resp> r101) {
        Intrinsics.checkNotNullParameter(r100, "interceptors");
        Intrinsics.checkNotNullParameter(r101, "input");
        this.f254012a = r100;
        this.f254013b = r101;
    }
}
