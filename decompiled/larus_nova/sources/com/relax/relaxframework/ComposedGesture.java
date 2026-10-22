package com.relax.relaxframework;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
public class ComposedGesture implements k1 {

    /* JADX INFO: renamed from: com.relax.relaxframework.ComposedGesture$serialize$2, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.relax.relaxframework.ComposedGesture$serialize$3, reason: invalid class name */
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

    /* JADX INFO: renamed from: com.relax.relaxframework.ComposedGesture$serialize$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00000\u0004j\b\u0012\u0004\u0012\u00020\u0000`\u0005H\n¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/relax/relaxframework/k1;", "gesture", "", "index", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/foundation/RTSArray;", "arr", "", "", "", "Lcom/bytedance/rts/foundation/RTSMap;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxframework/k1;ILjava/util/ArrayList;)Ljava/util/Map;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    public static final class AnonymousClass4 extends Lambda implements Function3<k1, Integer, ArrayList<k1>, Map<String, Object>> {
        public static final AnonymousClass4 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass4();
        }

        public AnonymousClass4() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Map<String, Object> invoke(k1 r100, Integer r101, ArrayList<k1> r102) {
            return invoke(r100, r101.intValue(), r102);
        }

        public final Map<String, Object> invoke(k1 r100, int r101, ArrayList<k1> r102) {
            Intrinsics.checkNotNullParameter(r100, "gesture");
            Intrinsics.checkNotNullParameter(r102, "arr");
            return r100.serialize();
        }
    }

    @Override // com.relax.relaxframework.k1
    public final ArrayList<BaseGesture> a() {
        ComposedGesture$toGestureArray$1 r100 = ComposedGesture$toGestureArray$1.INSTANCE;
        n0 r101 = RelaxFrameworkKt.f404871a;
        Intrinsics.checkNotNullParameter(null, "arr");
        Intrinsics.checkNotNullParameter(r100, "mapper");
        com.bytedance.rts.foundation.j.k(new Object[0]);
        throw null;
    }

    @Override // com.relax.relaxframework.k1
    public final Map<String, Object> serialize() {
        com.bytedance.rts.foundation.m.e(new LinkedHashMap(), "type", Integer.valueOf(getType().getValue()));
        com.bytedance.rts.foundation.j.h(null, AnonymousClass1.INSTANCE);
        throw null;
    }

    @Override // com.relax.relaxframework.k1
    public GestureTypeInner getType() {
        return GestureTypeInner.Composed;
    }
}
