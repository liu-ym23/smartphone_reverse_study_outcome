package com.bytedance.android.shopping.card_list.widgets.nest;

import com.bytedance.android.shopping.buynow.data.model.ErrorPageButtonAction;
import com.bytedance.android.shopping.card_list.components.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BodyViewAction implements q {
    public final Function0<Unit> a;
    public final Function1<Integer, Boolean> b;
    public final boolean c;
    public final CardListTwoRevViewAction d;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.BodyViewAction$1, reason: invalid class name */
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
        public final void m593invoke() {
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            m593invoke();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.widgets.nest.BodyViewAction$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass2 extends Lambda implements Function1<Integer, Boolean> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(1);
        }

        public final boolean invoke(int r1) {
            return false;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            return Boolean.valueOf(invoke(((Number) r1).intValue()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BodyViewAction(Function0<Unit> r2, Function1<? super Integer, Boolean> r3, boolean r4, CardListTwoRevViewAction r5) {
        Intrinsics.checkNotNullParameter(r2, ErrorPageButtonAction.REFRESH);
        Intrinsics.checkNotNullParameter(r3, "canScrollVerticallyAsMultiList");
        Intrinsics.checkNotNullParameter(r5, "cardListTwoRevViewAction");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
