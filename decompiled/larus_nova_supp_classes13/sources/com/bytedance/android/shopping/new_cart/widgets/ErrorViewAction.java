package com.bytedance.android.shopping.new_cart.widgets;

import com.bytedance.android.shopping.card_list.components.q;
import com.bytedance.android.shopping.card_list.widgets.nest.CardListTwoRevViewAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ErrorViewAction implements q {
    public final Function0<Unit> a;
    public final Function0<Unit> b;
    public final Function0<Unit> c;
    public final CardListTwoRevViewAction d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.widgets.ErrorViewAction$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1802invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1802invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.widgets.ErrorViewAction$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1803invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1803invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.new_cart.widgets.ErrorViewAction$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m1804invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m1804invoke();
            return Unit.INSTANCE;
        }
    }

    public ErrorViewAction(Function0<Unit> r2, Function0<Unit> r3, Function0<Unit> r4, CardListTwoRevViewAction r5) {
        Intrinsics.checkNotNullParameter(r2, "onRetry");
        Intrinsics.checkNotNullParameter(r3, "onBack");
        Intrinsics.checkNotNullParameter(r4, "onAdvice");
        Intrinsics.checkNotNullParameter(r5, "cardListTwoRevViewAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
