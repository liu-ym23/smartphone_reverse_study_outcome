package com.relax.relaxreact;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0006j\b\u0012\u0004\u0012\u00020\u0003`\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "gesture", "Lcom/relax/relaxreact/BaseGesture;", "_index", "_array", "Ljava/util/ArrayList;", "Lcom/bytedance/rts/kmp/foundation/RTSArray;", AbsMethodDelegate.TAG_INVOKE, "(Lcom/relax/relaxreact/BaseGesture;ILjava/util/ArrayList;)Ljava/lang/Integer;"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class BaseGesture$__getRelationMap$2 extends Lambda implements Function3<BaseGesture, Integer, ArrayList<BaseGesture>, Integer> {
    public static final BaseGesture$__getRelationMap$2 INSTANCE = null;

    static {
        INSTANCE = new BaseGesture$__getRelationMap$2();
    }

    public BaseGesture$__getRelationMap$2() {
        super(3);
    }

    public final Integer invoke(BaseGesture r100, int r101, ArrayList<BaseGesture> r102) {
        Intrinsics.checkNotNullParameter(r100, "gesture");
        Intrinsics.checkNotNullParameter(r102, "_array");
        return Integer.valueOf(r100.f405383a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Integer invoke(BaseGesture r100, Integer r101, ArrayList<BaseGesture> r102) {
        return invoke(r100, r101.intValue(), r102);
    }
}
