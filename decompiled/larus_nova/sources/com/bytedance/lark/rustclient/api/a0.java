package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.larksuite.wire.CommandScope;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class a0 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f253898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<String> f253899b;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f253900a = null;

        static {
            int[] r100 = new int[CommandScope.values().length];
            r100[CommandScope.GlobalScope.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CommandScope.UserScope.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f253900a = r100;
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a0 f253901a;

        public b(a0 r100) {
            this.f253901a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "<destruct>");
            w r102 = (w) r101.component2();
            if ((r102 instanceof y) == true) goto L5;
        L8:
            return true;
        L5:
            if (Intrinsics.areEqual(((y) r102).f253936a, this.f253901a.f253899b.invoke()) == true) goto L8;
            return false;
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T, R> f253902a = null;

        static {
            f253902a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            return (com.bytedance.lark.sdk.refactor.q) r101.getFirst();
        }
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final void k(long r100) {
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final Observable<com.bytedance.lark.sdk.refactor.q> a(Command r100) {
        return this.f253898a.a(r100).filter(new b(this)).map(c.f253902a);
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final <Resp> k<Resp> h(d<Resp> r110) {
        Intrinsics.checkNotNullParameter(r110, "request");
        CommandScope r100 = com.bytedance.lark.rustclient.internal.e.a(r110.a());
        int r101 = a.f253900a[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = f.f253911i;
        Intrinsics.checkNotNullParameter(r110, "general");
        Object r103 = r110.f253908g;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IGlobalScopeBuilder<Req of com.bytedance.lark.rustclient.api.GlobalRustRequest.Companion.from>");
        we6.b r104 = (we6.b) r103;
        ProtoAdapter<Resp> r105 = r110.f253909h;
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IGlobalScopeAdapter<Resp of com.bytedance.lark.rustclient.api.GlobalRustRequest.Companion.from>");
        f r106 = new f(r104, (we6.a) r105, r110.a(), r110.f253893b, r110.f253894c, r110.f253895d, r110.f253896e, r110.f253897f);
        k<Resp> r111 = this.f253898a.d(r106);
        Intrinsics.checkNotNull(r111, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.IRustCall<Resp of com.bytedance.lark.rustclient.api.UserScopeWrapper.newCall>");
        return r111;
    L5:
        if (r101 != 2) goto L8;
        int r107 = z.f253938i;
        Intrinsics.checkNotNullParameter(r110, "general");
        Object r108 = r110.f253908g;
        Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeBuilder<Req of com.bytedance.lark.rustclient.api.UserRustRequest.Companion.from>");
        we6.d r109 = (we6.d) r108;
        ProtoAdapter<Resp> r112 = r110.f253909h;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.bytedance.larksuite.wire.IUserScopeAdapter<Resp of com.bytedance.lark.rustclient.api.UserRustRequest.Companion.from>");
        z r113 = new z(r109, (we6.c) r112, r110.a(), r110.f253893b, r110.f253894c, r110.f253895d, r110.f253896e, r110.f253897f);
        com.bytedance.lark.rustclient.internal.r r114 = this.f253898a.f(this.f253899b.invoke(), r113);
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type com.bytedance.lark.rustclient.api.IRustCall<Resp of com.bytedance.lark.rustclient.api.UserScopeWrapper.newCall>");
        return r114;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public a0(h r100, Function0<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "global");
        Intrinsics.checkNotNullParameter(r101, "uidProvider");
        this.f253898a = r100;
        this.f253899b = r101;
    }

    @Override // com.bytedance.lark.rustclient.api.l
    public final <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> c(com.ss.android.lark.pb.improto.Command r100, ProtoAdapter<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        return this.f253898a.j(this.f253899b.invoke(), r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.lark.rustclient.api.l
    public final <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> i(Command r100, ProtoAdapter<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        if ((r101 instanceof we6.a) == false) goto L6;
        return this.f253898a.e(r100, (we6.a) r101);
    L6:
        if ((r101 instanceof we6.c) == false) goto L10;
        return this.f253898a.g(this.f253899b.invoke(), r100, (we6.c) r101);
    L10:
        throw new IllegalArgumentException("ResponseProtoAdapter should be either IGlobalScopeAdapter or IUserScopeAdapter, found: " + r101.getClass() + '.');
    }
}
