package com.bytedance.lark.rustclient.internal;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i extends BaseRustClient implements com.bytedance.lark.rustclient.api.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<String> f253990e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final j f253991f;

    public static final class a<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Command f253992a;

        public a(Command r100) {
            this.f253992a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if (this.f253992a != null) goto L5;
        L8:
            return true;
        L5:
            if (((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254277a.getValue() == this.f253992a.getValue()) goto L8;
            return false;
        }
    }

    public static final class b<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.pb.improto.Command f253993a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f253994b;

        public b(com.ss.android.lark.pb.improto.Command r100, String r101) {
            this.f253993a = r100;
            this.f253994b = r101;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.lark.sdk.refactor.q.a r102 = ((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254279c;
            com.bytedance.lark.rustclient.api.w r103 = (com.bytedance.lark.rustclient.api.w) r101.getSecond();
            if (r102 != null) goto L5;
        L13:
            return false;
        L5:
            if (r102.f254280a.getValue() != this.f253993a.getValue()) goto L13;
            if ((r103 instanceof com.bytedance.lark.rustclient.api.y) == true) goto L10;
        L12:
            return true;
        L10:
            if (Intrinsics.areEqual(((com.bytedance.lark.rustclient.api.y) r103).f253936a, this.f253994b) == true) goto L12;
            goto L12
        }
    }

    public static final class c<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProtoAdapter<T> f253995a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.ss.android.lark.pb.improto.Command f253996b;

        public c(ProtoAdapter<T> r100, com.ss.android.lark.pb.improto.Command r101) {
            this.f253995a = r100;
            this.f253996b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            final com.bytedance.lark.sdk.refactor.q.a r102 = ((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254279c;
            if (r102 == null) goto L7;
            return com.bytedance.lark.rustclient.api.v.a((com.bytedance.lark.sdk.refactor.q) r101.getFirst(), this.f253995a, (com.bytedance.lark.rustclient.api.w) r101.getSecond(), Command.POST_GATEWAY, this.f253996b, new GlobalRustClient$observeServerPush$2$1(r102));
        L7:
            throw new IllegalArgumentException("Server push data should not be empty here.".toString());
        }
    }

    public static final class d<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Command f253997a;

        public d(Command r100) {
            this.f253997a = r100;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            if (((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254277a.getValue() != this.f253997a.getValue()) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class e<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ we6.a<T> f253998a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Command f253999b;

        public e(we6.a<T> r100, Command r101) {
            this.f253998a = r100;
            this.f253999b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.lark.sdk.refactor.q r102 = (com.bytedance.lark.sdk.refactor.q) r101.getFirst();
            we6.a<T> r103 = this.f253998a;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.bytedance.lark.rustclient.internal.GlobalRustClient.observeSingleGlobalPush>");
            return com.bytedance.lark.rustclient.api.v.b(r102, (ProtoAdapter) r103, (com.bytedance.lark.rustclient.api.w) r101.getSecond(), this.f253999b);
        }
    }

    public static final class f<T> implements Predicate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Command f254000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f254001b;

        public f(Command r100, String r101) {
            this.f254000a = r100;
            this.f254001b = r101;
        }

        @Override // io.reactivex.functions.Predicate
        public final boolean test(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.lark.rustclient.api.w r102 = (com.bytedance.lark.rustclient.api.w) r101.getSecond();
            if (((com.bytedance.lark.sdk.refactor.q) r101.getFirst()).f254277a.getValue() == this.f254000a.getValue()) goto L6;
        L9:
            return false;
        L6:
            if ((r102 instanceof com.bytedance.lark.rustclient.api.y) == true) goto L8;
        L10:
            return true;
        L8:
            if (Intrinsics.areEqual(((com.bytedance.lark.rustclient.api.y) r102).f253936a, this.f254001b) == true) goto L10;
            goto L9
        }
    }

    public static final class g<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ we6.c<T> f254002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Command f254003b;

        public g(we6.c<T> r100, Command r101) {
            this.f254002a = r100;
            this.f254003b = r101;
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            Pair r101 = (Pair) r100;
            Intrinsics.checkNotNullParameter(r101, "pair");
            com.bytedance.lark.sdk.refactor.q r102 = (com.bytedance.lark.sdk.refactor.q) r101.getFirst();
            we6.c<T> r103 = this.f254002a;
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<T of com.bytedance.lark.rustclient.internal.GlobalRustClient.observeSingleUserPush>");
            return com.bytedance.lark.rustclient.api.v.b(r102, (ProtoAdapter) r103, (com.bytedance.lark.rustclient.api.w) r101.getSecond(), this.f254003b);
        }
    }

    public i() {
        throw null;
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final Long n() {
        return null;
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final String o() {
        return this.f253990e.invoke();
    }

    @Override // com.bytedance.lark.rustclient.internal.BaseRustClient
    public final l m() {
        return this.f253991f;
    }

    @Override // com.bytedance.lark.rustclient.api.h
    public final Observable<Pair<com.bytedance.lark.sdk.refactor.q, com.bytedance.lark.rustclient.api.w>> a(Command r100) {
        return this.f253991f.f().filter(new a(r100));
    }

    @Override // com.bytedance.lark.rustclient.api.i
    public final <Resp, Req> com.bytedance.lark.rustclient.api.k<Resp> d(com.bytedance.lark.rustclient.api.f<Resp, Req> r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        return l(r100.b(), com.bytedance.lark.rustclient.api.e.f253910a);
    }

    @Override // com.bytedance.lark.rustclient.api.i
    public final <T> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>> e(Command r100, we6.a<T> r101) {
        Intrinsics.checkNotNullParameter(r100, "command");
        Intrinsics.checkNotNullParameter(r101, "responseProtoAdapter");
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>>) this.f253991f.f().filter(new d(r100)).map(new e(r101, r100));
    }

    @Override // com.bytedance.lark.rustclient.api.h
    public final r f(String r110, com.bytedance.lark.rustclient.api.z r111) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "request");
        Long r100 = this.f253944b.a(r110);
        Object r101 = r111.f253939g;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.squareup.wire.Message.Builder<*, *>");
        Message.Builder r102 = (Message.Builder) r101;
        Object r103 = r111.f253940h;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<Resp of com.bytedance.lark.rustclient.api.UserRustRequest>");
        return l(new com.bytedance.lark.rustclient.api.d(r102, (ProtoAdapter) r103, r111.a(), r111.f253893b, r111.f253894c, r111.f253895d, r111.f253896e, r111.f253897f), new com.bytedance.lark.rustclient.api.y(r110, r100));
    }

    @Override // com.bytedance.lark.rustclient.api.h
    public final r b(String r110, com.ss.android.lark.pb.improto.Command r111, com.bytedance.lark.rustclient.api.d r112) {
        Intrinsics.checkNotNullParameter(r110, "userId");
        Intrinsics.checkNotNullParameter(r111, "command");
        Intrinsics.checkNotNullParameter(r112, "request");
        Long r100 = this.f253944b.a(r110);
        return l(new com.bytedance.lark.rustclient.api.d(r112.f253908g, r112.f253909h, r112.a(), r112.f253893b, r112.f253894c, r112.f253895d, r111, r112.f253897f), new com.bytedance.lark.rustclient.api.y(r110, r100));
    }

    @Override // com.bytedance.lark.rustclient.api.h
    public final <T> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>> g(String r100, Command r101, we6.c<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "command");
        Intrinsics.checkNotNullParameter(r102, "responseProtoAdapter");
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>>) this.f253991f.f().filter(new f(r101, r100)).map(new g(r102, r101));
    }

    @Override // com.bytedance.lark.rustclient.api.h
    public final <T> Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>> j(String r100, com.ss.android.lark.pb.improto.Command r101, ProtoAdapter<T> r102) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "command");
        Intrinsics.checkNotNullParameter(r102, "responseProtoAdapter");
        return (Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.q, T>>) this.f253991f.f().filter(new b(r101, r100)).map(new c(r102, r101));
    }

    public i(k r100, com.bytedance.lark.sdk.refactor.l r101, com.bytedance.lark.sdk.refactor.state.c r102, List r103, Function0 r104) {
        List r105 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, "definition");
        Intrinsics.checkNotNullParameter(r101, "rustSDK");
        Intrinsics.checkNotNullParameter(r102, "rustContext");
        Intrinsics.checkNotNullParameter(r103, "invokeInterceptors");
        Intrinsics.checkNotNullParameter(r105, "pushInterceptors");
        Intrinsics.checkNotNullParameter(r104, "uidGetter");
        Intrinsics.checkNotNullParameter(r100, "clientDef");
        super(r101, r102, CollectionsKt.plus(r103, CollectionsKt.listOf(new a0(r100))));
        this.f253990e = r104;
        this.f253991f = new j(r105, r100);
    }
}
