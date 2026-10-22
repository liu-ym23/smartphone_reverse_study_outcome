package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public final class BaseGesture implements k1 {

    /* JADX INFO: renamed from: com.relax.relaxframework.BaseGesture$serialize$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "gesture", "Lcom/relax/relaxframework/BaseGesture;", "index", "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/BaseGesture;ILjava/util/ArrayList;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass2 extends Lambda implements Function3<BaseGesture, Integer, ArrayList<BaseGesture>, Integer> {
        public static final AnonymousClass2 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass2();
        }

        public AnonymousClass2() {
            super(3);
        }

        public final Integer invoke(BaseGesture r100, int r101, ArrayList<BaseGesture> r102) {
            Intrinsics.checkNotNullParameter(r100, "gesture");
            Intrinsics.checkNotNullParameter(r102, "arr");
            r100.getClass();
            return 0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Integer invoke(BaseGesture r100, Integer r101, ArrayList<BaseGesture> r102) {
            return invoke(r100, r101.intValue(), r102);
        }
    }

    /* JADX INFO: renamed from: com.relax.relaxframework.BaseGesture$serialize$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "gesture", "Lcom/relax/relaxframework/BaseGesture;", "index", "arr", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/BaseGesture;ILjava/util/ArrayList;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class AnonymousClass3 extends Lambda implements Function3<BaseGesture, Integer, ArrayList<BaseGesture>, Integer> {
        public static final AnonymousClass3 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass3();
        }

        public AnonymousClass3() {
            super(3);
        }

        public final Integer invoke(BaseGesture r100, int r101, ArrayList<BaseGesture> r102) {
            Intrinsics.checkNotNullParameter(r100, "gesture");
            Intrinsics.checkNotNullParameter(r102, "arr");
            r100.getClass();
            return 0;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Integer invoke(BaseGesture r100, Integer r101, ArrayList<BaseGesture> r102) {
            return invoke(r100, r101.intValue(), r102);
        }
    }

    /* JADX INFO: renamed from: com.relax.relaxframework.BaseGesture$serialize$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0010\u000e\u001a\u00020\u00072:\u0010\t\u001a6\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0000j\u0002`\b2\u0006\u0010\u000b\u001a\u00020\nH\n¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/Function2;", "Lcom/relax/relaxframework/j1;", "Lkotlin/ParameterName;", "name", "event", "Lcom/relax/relaxframework/l1;", "stateManager", "", "Lcom/relax/relaxframework/GestureControlCallback;", "value", "", "key", AbsMethodDelegate.TAG_INVOKE, "(Lkotlin/jvm/functions/Function2;Ljava/lang/String;)V", "<no name provided>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass4 extends Lambda implements Function2<Function2<? super j1, ? super l1, ? extends Unit>, String, Unit> {
        final /* synthetic */ ArrayList<String> $callbacks;

        public AnonymousClass4(ArrayList<String> r100) {
            this.$callbacks = r100;
            super(2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Function2<? super j1, ? super l1, Unit> r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "value");
            Intrinsics.checkNotNullParameter(r101, "key");
            com.bytedance.rts.foundation.j.j(this.$callbacks, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Function2<? super j1, ? super l1, ? extends Unit> r100, String r101) {
            invoke2(r100, r101);
            return Unit.INSTANCE;
        }
    }

    @Override // com.relax.relaxframework.k1
    public final ArrayList<BaseGesture> a() {
        return com.bytedance.rts.foundation.j.k(new BaseGesture[]{this});
    }

    @Override // com.relax.relaxframework.k1
    public GestureTypeInner getType() {
        Intrinsics.throwUninitializedPropertyAccessException("__type");
        return null;
    }

    @Override // com.relax.relaxframework.k1
    public final Map<String, Object> serialize() {
        LinkedHashMap r100 = new LinkedHashMap();
        com.bytedance.rts.foundation.m.e(r100, "config", null);
        com.bytedance.rts.foundation.m.e(r100, "id", 0);
        com.bytedance.rts.foundation.m.e(r100, "type", Integer.valueOf(getType().getValue()));
        com.bytedance.rts.foundation.j.h(null, AnonymousClass1.INSTANCE);
        throw null;
    }
}
