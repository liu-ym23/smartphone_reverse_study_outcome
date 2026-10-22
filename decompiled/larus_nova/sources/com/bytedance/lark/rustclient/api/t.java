package com.bytedance.lark.rustclient.api;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.LarkError;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.chat.service.impl.RecallInterceptCallback;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f253927a = null;

    public static final class a<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<DATA, Unit> f253928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<p, Unit> f253929b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super DATA, Unit> r100, Function1<? super p, Unit> r101) {
            this.f253928a = r100;
            this.f253929b = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            s r101 = (s) r100;
            if ((r101 instanceof x) == false) goto L6;
            this.f253928a.invoke(((x) r101).f253935c);
            return;
        L6:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
            this.f253929b.invoke(((com.bytedance.lark.rustclient.api.c) r101).f253907c);
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class b<T, R> implements Function {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T, R> f253930a = null;

        static {
            f253930a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Function
        public final Object apply(Object r100) {
            s r101 = (s) r100;
            Intrinsics.checkNotNullParameter(r101, "it");
            if ((r101 instanceof x) == false) goto L7;
            return (x) r101;
        L7:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L11;
            throw ((com.bytedance.lark.rustclient.api.c) r101).f253907c.b();
        L11:
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f253931a;

        public c(Function1 r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f253931a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final /* synthetic */ void accept(Object r100) {
            this.f253931a.invoke(r100);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<DATA, Unit> f253932a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function1<Throwable, Unit> f253933b;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super DATA, Unit> r100, Function1<? super Throwable, Unit> r101) {
            this.f253932a = r100;
            this.f253933b = r101;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            s r101 = (s) r100;
            if ((r101 instanceof x) == false) goto L6;
            this.f253932a.invoke(((x) r101).f253935c);
            return;
        L6:
            if ((r101 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
            this.f253933b.invoke(((com.bytedance.lark.rustclient.api.c) r101).f253907c.b());
            return;
        L10:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
        f253927a = new p(null, null, Command.UNKNOWN_COMMAND, null);
    }

    public static final <RAW, DATA> Observable<x<RAW, DATA>> b(Observable<s<RAW, DATA>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return (Observable<x<RAW, DATA>>) r100.map(b.f253930a);
    }

    public static /* synthetic */ Object d(s r100) {
        return c(r100, null);
    }

    public static final <RAW, DATA> DATA c(s<RAW, DATA> r100, Function1<? super p, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if ((r100 instanceof x) == false) goto L6;
        return ((x) r100).f253935c;
    L6:
        if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L12;
        if (r101 == null) goto L9;
        r101.invoke(((com.bytedance.lark.rustclient.api.c) r100).f253907c);
    L9:
        return null;
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static final <RAW, DATA1, DATA2> s<RAW, DATA2> e(s<RAW, DATA1> r100, Function1<? super DATA1, ? extends DATA2> r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "transformer");
        if ((r100 instanceof x) == false) goto L6;
        x r102 = (x) r100;
        return new x(r101.invoke((Object) r102.f253935c), r102.f253925a, r102.f253926b);
    L6:
        if ((r100 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
        com.bytedance.lark.rustclient.api.c r103 = (com.bytedance.lark.rustclient.api.c) r100;
        return new com.bytedance.lark.rustclient.api.c(r103.f253907c, r103.f253925a, r103.f253926b);
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static final <RAW, DATA> Disposable g(Observable<s<RAW, DATA>> r100, Function1<? super DATA, Unit> r101, Function1<? super Throwable, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        Intrinsics.checkNotNullParameter(r102, LynxVideoManagerLite.EVENT_ON_ERROR);
        return r100.subscribe(new d(r101, r102), new c(r102));
    }

    public static final void h(Observable r100, Function1 r101, final RecallInterceptCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "responseTransformer");
        a(r100.map(new u(r101)), new RustOutputKt$subscribeWithCallback$1(r102), new RustOutputKt$subscribeWithCallback$2(r102), new RustOutputKt$subscribeWithCallback$3(r102));
    }

    public static final <RAW, DATA> Disposable a(Observable<s<RAW, DATA>> r100, Function1<? super DATA, Unit> r101, Function1<? super p, Unit> r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "onNext");
        Intrinsics.checkNotNullParameter(r102, "onRustError");
        Intrinsics.checkNotNullParameter(r103, "onOtherError");
        return r100.subscribe(new a(r101, r102), new c(r103));
    }

    public static final p f(Command r100, com.ss.android.lark.pb.improto.Command r101, byte[] r102, Exception r103) {
        Intrinsics.checkNotNullParameter(r100, "command");
        LarkError r104 = null;
        if (r102 == null) goto L10;
        r104 = LarkError.ADAPTER.decode(r102);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        if (r103 != null) goto L10;
        r103 = e;
    L10:
        return new p(r103, r104, r100, r101);
    }

    public static final <T> Pair<T, p> i(ProtoAdapter<T> r100, byte[] r101, Command r102, com.ss.android.lark.pb.improto.Command r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "command");
        return TuplesKt.to(r100.decode(r101), f253927a);
    L5:
        e = move-exception;
        return TuplesKt.to(null, f(r102, r103, r101, e));
    }
}
