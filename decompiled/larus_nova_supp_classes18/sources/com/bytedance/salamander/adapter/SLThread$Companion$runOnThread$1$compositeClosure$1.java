package com.bytedance.salamander.adapter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
final class SLThread$Companion$runOnThread$1$compositeClosure$1 extends Lambda implements Function1<Boolean, Object> {
    final /* synthetic */ Function1<Object, Unit> $callback;
    final /* synthetic */ q $task;

    /* JADX INFO: renamed from: com.bytedance.salamander.adapter.SLThread$Companion$runOnThread$1$compositeClosure$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<no name provided>", "", "isCancelled", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Object> {
        final /* synthetic */ Function1<Object, Unit> $callback;
        final /* synthetic */ Object $ret;

        public AnonymousClass1(Function1<Object, Unit> r1, Object r2) {
            this.$callback = r1;
            this.$ret = r2;
            super(1);
        }

        public final Object invoke(boolean r2) {
            Function1<Object, Unit> r3 = this.$callback;
            Intrinsics.checkNotNull(r3);
            r3.invoke(this.$ret);
            return null;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return invoke(((Boolean) r1).booleanValue());
        }
    }

    public SLThread$Companion$runOnThread$1$compositeClosure$1(q r1, Function1<Object, Unit> r2) {
        this.$callback = r2;
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke(((Boolean) r1).booleanValue());
    }

    public final Object invoke(boolean r1) {
        throw null;
    }
}
