package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.larksuite.wire.CommandScope;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class x extends BaseRustClient implements com.bytedance.lark.rustclient.api.l {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final y f254031e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f254032f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f254033g;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f254034a = null;

        static {
            int[] r100 = new int[CommandScope.values().length];
            r100[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f254034a = r100;
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f254035a = null;

        static {
            f254035a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (com.bytedance.lark.sdk.refactor.q) r101.getFirst();
        }
    }

    public static final class c<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Command f254036a;

        public c(Command r100) {
            this.f254036a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            com.bytedance.lark.sdk.refactor.q r101 = (com.bytedance.lark.sdk.refactor.q) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (this.f254036a != null) goto L5;
        L8:
            return true;
        L5:
            if (r101.f254277a.getValue() == this.f254036a.getValue()) goto L8;
            return false;
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.pb.improto.Command f254037a;

        public d(com.ss.android.lark.pb.improto.Command r100) {
            this.f254037a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            com.bytedance.lark.sdk.refactor.q.a r102 = ((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254279c;
            if (r102 != null) goto L5;
        L7:
            return false;
        L5:
            if (r102.f254280a.getValue() != this.f254037a.getValue()) goto L7;
            return true;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProtoAdapter<T> f254038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.pb.improto.Command f254039b;

        public e(ProtoAdapter<T> r100, com.ss.android.lark.pb.improto.Command r101) {
            this.f254038a = r100;
            this.f254039b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            final com.bytedance.lark.sdk.refactor.q.a r102 = ((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254279c;
            if (r102 == null) goto L7;
            return com.bytedance.lark.rustclient.api.v.a((com.bytedance.lark.sdk.refactor.q) r101.getFirst(), this.f254038a, (com.bytedance.lark.rustclient.api.w) r101.getSecond(), Command.POST_GATEWAY, this.f254039b, new UserRustClient$observeServerPush$2$1(r102));
        L7:
            throw new IllegalArgumentException("Server push data should not be empty here.".toString());
        }
    }

    public static final class f<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Command f254040a;

        public f(Command r100) {
            this.f254040a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254277a.getValue() != this.f254040a.getValue()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProtoAdapter<T> f254041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Command f254042b;

        public g(ProtoAdapter<T> r100, Command r101) {
            this.f254041a = r100;
            this.f254042b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return com.bytedance.lark.rustclient.api.v.b((com.bytedance.lark.sdk.refactor.q) r101.getFirst(), this.f254041a, (com.bytedance.lark.rustclient.api.w) r101.getSecond(), this.f254042b);
        }
    }

    public x() {
        throw null;
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final l m() {
        return this.f254031e;
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final Long n() {
        return this.f254033g;
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final String o() {
        return this.f254032f;
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final Observable<com.bytedance.lark.sdk.refactor.q> a(Command r100) {
        return this.f254031e.f().map(b.f254035a).filter(new c(r100));
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final <Resp> com.bytedance.lark.rustclient.api.k<Resp> h(com.bytedance.lark.rustclient.api.d<Resp> r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        CommandScope r101 = com.bytedance.lark.rustclient.internal.e.a(r100.a());
        int r102 = a.f254034a[r101.ordinal()];
        if (r102 != 1) goto L5;
        com.bytedance.lark.rustclient.api.w r103 = com.bytedance.lark.rustclient.api.e.f253910a;
    L11:
        return l(r100, r103);
    L5:
        if (r102 != 2) goto L8;
        r103 = new com.bytedance.lark.rustclient.api.y(this.f254032f, this.f254033g);
        goto L11
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final void k(long r100) {
        this.f254033g = Long.valueOf(r100);
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final <T> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>> c(com.ss.android.lark.pb.improto.Command r100, ProtoAdapter<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>>) this.f254031e.f().filter(new d(r100)).map(new e(r101, r100));
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final <T> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>> i(Command r100, ProtoAdapter<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>>) this.f254031e.f().filter(new f(r100)).map(new g(r101, r100));
    }

    public x(k r100, com.bytedance.lark.sdk.refactor.l r101, com.bytedance.lark.sdk.refactor.state.c r102, List r103, m r104, com.ss.android.lark.passportc.api.m r105) {
        List r106 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "rustSDK");
        Intrinsics.checkNotNullParameter(r102, "rustContext");
        Intrinsics.checkNotNullParameter(r103, "invokeInterceptors");
        Intrinsics.checkNotNullParameter(r106, "pushInterceptors");
        Intrinsics.checkNotNullParameter(r104, "receiverRegistry");
        Intrinsics.checkNotNullParameter(r105, "passport");
        super(r101, r102, CollectionsKt.plus(CollectionsKt.listOf(new com.bytedance.lark.rustclient.internal.a()), r103));
        y r107 = new y(r100, CollectionsKt.plus(CollectionsKt.listOf(new com.bytedance.lark.rustclient.internal.c(r105.getSession().f438138b)), r106), r105);
        this.f254031e = r107;
        String r108 = r105.getSession().f438138b;
        this.f254032f = r108;
        com.ss.android.lark.passportc.api.s.a(r107);
        r104.c(r108, null, r107);
    }
}
